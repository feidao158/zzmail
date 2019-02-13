package com.zw.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;


public class ReplyTextMessage implements Serializable {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String Content;

    public ReplyTextMessage() {
    }

    @Override
    public String toString() {
        return "ReplyTextMessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public ReplyTextMessage(String toUserName, String fromUserName, long createTime, String msgType, String content) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Content = content;
    }
}
