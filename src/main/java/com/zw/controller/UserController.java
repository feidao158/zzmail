package com.zw.controller;

import com.thoughtworks.xstream.XStream;
import com.zw.pojo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class UserController {
//    @Autowired
//    XStream xStream;
//
//    @GetMapping("/send")
//    @ResponseBody
//    public String AppletDemo(ServerInfo serverInfo)
//    {
//        System.out.println("啊 我被访问了！");
//        System.out.println(serverInfo);
//        return serverInfo.getEchostr();
//    }
//
//    @PostMapping(value = "/send",produces = "application/json;charset=UTF-8",consumes = "text/xml")
//    @ResponseBody
//    public String TextMessage(@RequestBody TextMessage textMessage)
//    {
//        System.out.println(textMessage);
//        String msgType = textMessage.getMsgType();
//        System.out.println(msgType);
////        return textMessage.toString();
//        ReplyTextMessage replyTextMessage = new ReplyTextMessage();
//        replyTextMessage.setToUserName(textMessage.getFromUserName());
//        replyTextMessage.setFromUserName(textMessage.getToUserName());
//        replyTextMessage.setCreateTime(new Date().getTime());
//        replyTextMessage.setMsgType("text");
////        if (textMessage.getContent().equals("看片"))
////        {
////
////            textMessage.setContent("http://www.baidu.com ");
////        }
////        replyTextMessage.setContent("这是回复的消息:" + textMessage.getContent());
//        String result = ReplyTextMessageConverToXml(replyTextMessage);
//        System.out.println(result);
//        return result;
//
//    }
//
//    @RequestMapping("/reply")
//    @ResponseBody
//    public String ReplyTextMessage2()
//    {
//        ReplyTextMessage replyTextMessage = new ReplyTextMessage();
//        replyTextMessage.setFromUserName("aaa");
//        replyTextMessage.setToUserName("bbb");
//        replyTextMessage.setContent("this is content");
//        replyTextMessage.setCreateTime(9999);
//        replyTextMessage.setMsgType("text");
//        XStream xStream = new XStream();
//        xStream.alias("xml",ReplyTextMessage.class);
//        String s = xStream.toXML(replyTextMessage);
//        System.out.println(s);
//        return s;
//    }
//
//
//    public String ReplyTextMessageConverToXml(ReplyTextMessage replyTextMessage)
//    {
//        xStream.alias("xml",ReplyTextMessage.class);
//        return xStream.toXML(replyTextMessage);
//    }

}
