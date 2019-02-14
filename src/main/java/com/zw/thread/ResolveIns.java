package com.zw.thread;

import com.zw.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResolveIns  extends Thread
{
    String url;
    String fromUser;

    WeChatService weChatService;

    @Override
    public void run() {
        System.out.println("线程类的run方法");
       weChatService.resoloverIns(this.fromUser,this.url);
    }

    public ResolveIns(String fromUser,String url)
    {
        this.url = url;
        this.fromUser = fromUser;

    }
    public ResolveIns()
    {
        super();
    }
}
