package com.zw.controller;
import com.thoughtworks.xstream.XStream;
import com.zw.pojo.ReplyTextMessage;
import com.zw.pojo.ServerInfo;
import com.zw.pojo.TextMessage;
import com.zw.pojo.WeChatMessage;
import com.zw.utils.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class MessageController {
    @Autowired
    XStream xStream;
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
    @PostMapping(value = "/send",produces = "application/json;charset=UTF-8",consumes = "text/xml")
    @ResponseBody
    public String send(@RequestBody TextMessage textMessage)
    {
        System.out.println(textMessage.getMsgType());
        System.out.println(textMessage);

        ReplyTextMessage replyTextMessage = new ReplyTextMessage();
        replyTextMessage.setFromUserName(textMessage.getToUserName());
        replyTextMessage.setToUserName(textMessage.getFromUserName());
        replyTextMessage.setCreateTime(new Date().getTime());

        replyTextMessage.setMsgType(WeChatMessage.MSG_TYPE_TEXT);


        if (textMessage.getContent().equals("懒羊羊"))
        {
            replyTextMessage.setContent("什么沙雕玩意");


        }else {
            replyTextMessage.setContent(textMessage.getContent());
        }
            return converToXml(replyTextMessage);

    }

    public String converToXml(ReplyTextMessage replyTextMessage)
    {

        xStream.alias("xml",ReplyTextMessage.class);

        return xStream.toXML(replyTextMessage);


    }


}
