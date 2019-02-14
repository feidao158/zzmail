package com.zw.service;

import com.zw.mapper.AccessTokenMapper;
import com.zw.mapper.InsInfoMapper;
import com.zw.pojo.AccessToken;
import com.zw.utils.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeChatService {
    @Autowired
    AccessTokenMapper accessTokenMapper;
    @Autowired
    InsInfoMapper insInfoMapper;


    public String getAcckessToken()
    {
        AccessToken accessToken = accessTokenMapper.selectAccessToken();


        if(accessToken.getGmtModified().getTime()+(accessToken.getExpiresIn()*1000)>new Date().getTime())
        {

            return accessToken.getAccessToken();
        }
        System.out.println("新查询的");
        AccessToken newAccessToken = WeChatUtils.getAccessToken();
        int i = accessTokenMapper.updateAccessToken(newAccessToken);
        return newAccessToken.getAccessToken();

    }


    public int resoloverIns(String fromUser,String url)
    {
        String insPicUrl = WeChatUtils.getInsPicUrl(url);

        return   insInfoMapper.insertData(fromUser,insPicUrl);
    }
}
