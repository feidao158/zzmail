package com.zw.controller;
import com.thoughtworks.xstream.XStream;
import com.zw.pojo.*;
import com.zw.service.WeChatService;
import com.zw.thread.ResolveIns;
import com.zw.utils.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
public class MessageController {
    @Autowired
    XStream xStream;
    @Autowired
    WeChatService weChatService;
    /**
     * 验证是否为微信传来的消息
     * @param serverInfo
     * @return
     */
    @GetMapping("/send")
    @ResponseBody

    public String send(ServerInfo serverInfo)
    {
//        boolean authentication = WeChatUtils.authentication(serverInfo);
//        return "";
        if(WeChatUtils.authentication(serverInfo))
        {
            return serverInfo.getEchostr();
        }
            return "error";
    }

    /**
     * 处理用户发送给微信公众号的消息
     * @param textMessage
     * @return
     */
    @PostMapping(value = "/send",produces = "application/json;charset=UTF-8",consumes = "text/xml")
    @ResponseBody
    public String send(@RequestBody TextMessage textMessage)
    {
        System.out.println(textMessage.getMsgType());
//        System.out.println(textMessage);
        ReplyTextMessage replyTextMessage = new ReplyTextMessage();
        replyTextMessage.setFromUserName(textMessage.getToUserName());
        replyTextMessage.setToUserName(textMessage.getFromUserName());
        replyTextMessage.setCreateTime(new Date().getTime());

        replyTextMessage.setMsgType(WeChatMessage.MSG_TYPE_TEXT);


        if (textMessage.getContent().equals("懒羊羊"))
        {
            replyTextMessage.setContent("什么沙雕玩意");

        }else if (textMessage.getContent().equals("图文消息")) {
//            replyTextMessage.setMsgType(WeChatMessage.MSG_TYPE_NEWS);
            ReplyPicTextMessage replyPicTextMessage = new ReplyPicTextMessage();
            replyPicTextMessage.setMsgType(WeChatMessage.MSG_TYPE_NEWS);
            replyPicTextMessage.setToUserName(textMessage.getFromUserName());
            replyPicTextMessage.setFromUserName(textMessage.getToUserName());
            replyPicTextMessage.setCreateTime(new Date().getTime());
            replyPicTextMessage.setArticleCount(1);
            List<News> list = new ArrayList<>();
            News news1 = new News();
            news1.setTitle("游戏竟然可以这么玩");
            news1.setDescription("《地下城与勇士》是一款韩国网络游戏公司NEOPLE开发的免费角色扮演2D游戏，由三星电子发行，并于2005年8月在韩国正式发布。中国则由腾讯游戏代理发行。\n" +
                    "该游戏是一款2D卷轴式横版格斗过关网络游戏，大量继承了众多家用机、街机2D格斗游戏的特色。以任务引导角色成长为中心，结合副本、PVP、PVE为辅，与其他网络游戏同样具有装备与等级的改变，并拥有共500多种装备道具。每个人物有8个道具装备位置，在游戏中可以允许最多4个玩家进行组队挑战关卡，同样也可以进行4对4的PK。\n");
            news1.setPicUrl("http://i0.hdslb.com/bfs/article/9e991e8f10346809295a3b7507f7db22522162fe.jpg");
            news1.setUrl("http://dnf.qq.com");
            list.add(news1);

            replyPicTextMessage.setArticles(list);
            return converToXml(replyPicTextMessage);
        }else if(textMessage.getContent().equals("ins"))
        {
            String insPicUrl = weChatService.getInsPicUrl(textMessage.getFromUserName());
            replyTextMessage.setContent(insPicUrl);
        }



        else if(textMessage.getContent().contains("https://www.instagram.com"))
        {
//
            System.out.println("我执行了");
            System.out.println(textMessage.getFromUserName());
            new ResolveIns(textMessage.getFromUserName(),textMessage.getContent(),weChatService).start();
            replyTextMessage.setContent("正在解析url，请等待5秒后回复ins查看！");

        } else {
            replyTextMessage.setContent(textMessage.getContent());
        }
            return converToXml(replyTextMessage);
    }
    /**
     * 微信公众号被动回复消息需要XML格式 这里使用一个工具转换为xml格式
     * @param replyTextMessage
     * @return
     */
    public String converToXml(BaseReplyMessage replyTextMessage)
    {
        xStream.alias("xml",ReplyTextMessage.class);
        xStream.alias("xml",ReplyPicTextMessage.class);
        xStream.alias("item",News.class);
        System.out.println(xStream.toXML(replyTextMessage));
        return xStream.toXML(replyTextMessage);
    }

}
