package com.zw.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;


public class ReplyTextMessage extends BaseReplyMessage implements Serializable {



    private String Content;

    public ReplyTextMessage() {
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
