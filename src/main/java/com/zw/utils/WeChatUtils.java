package com.zw.utils;

import com.thoughtworks.xstream.XStream;
import com.zw.pojo.AccessToken;
import com.zw.pojo.ServerInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class WeChatUtils {
    static{
        xStream = new XStream();
        restTemplate = new RestTemplate();
    }

    static XStream xStream;
    static RestTemplate restTemplate;
//    微信Token
    public final static String TOKEN = "zhangwei111";
//    公众号appid
    public final static String APPID = "wxe9638a79cce2c88d";

    public final static String SECRET = "6df03c28531738aacaac14475fb188a6";

    public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    /**
     * 验证是否通过微信发送的请求
     * @param serverInfo
     * @return
     */
    public static  boolean authentication(ServerInfo serverInfo)
    {
        String[] strings = {TOKEN, serverInfo.getTimestamp(), serverInfo.getNonce()};
        Arrays.sort(strings);
        StringBuffer stringBuffer = new StringBuffer();
        
        for(int i =0;i<strings.length;i++)
        {
            stringBuffer.append(strings[i]);
        }
        String hashCode = DigestUtils.sha1Hex(stringBuffer.toString());
//        System.out.println("hashCode:" + hashCode);
//        System.out.println("signatrue:" + serverInfo.getSignature());
        if (hashCode.equals(serverInfo.getSignature()))
        {

            return true;
        }
        return false;

    }

    /**
     * 请求微信接口需要这个AccessToken参数，过期时间为7200秒！且每天只能获取2000次！
     */
    public static  void getAccessToken()
    {
        String url  = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", SECRET);
        Map forObject = restTemplate.getForObject(url, Map.class);
//        ResponseEntity<List> forEntity = restTemplate.getForEntity(url, List.class);
//        List body = forEntity.getBody();

        System.out.println(forObject);

    }



}
