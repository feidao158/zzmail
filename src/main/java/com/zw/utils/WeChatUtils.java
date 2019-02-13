package com.zw.utils;

import com.thoughtworks.xstream.XStream;
import com.zw.pojo.ServerInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class WeChatUtils {
    @Autowired
    XStream xStream;
//    微信Token
    public final static String token = "zhangwei111";

    /**
     * 验证是否通过微信发送的请求
     * @param serverInfo
     * @return
     */
    public static  boolean authentication(ServerInfo serverInfo)
    {
        String[] strings = {token, serverInfo.getTimestamp(), serverInfo.getNonce()};
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


}
