package com.zw.pojo;

import java.util.Date;

public class AccessToken {

    private int id;

    private String accessToken;

    private int expiresIn;

    private Date gmtCreate;

    private Date gmtModified;

    @Override
    public String toString() {
        return "AccessToken{" +
                "id=" + id +
                ", accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public AccessToken(int id, String accessToken, int expiresIn, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public AccessToken() {
    }
}
