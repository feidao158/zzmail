package com.zw.pojo;

public class AccessToken {

    private String appid;

    private String secret;

    public AccessToken(String appid, String secret) {
        this.appid = appid;
        this.secret = secret;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public AccessToken() {
    }
}
