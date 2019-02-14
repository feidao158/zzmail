package com.zw.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeChatUtilsTest {

    public static void main(String[] args) {
//        long begintime = new Date().getTime();
//        String url = "https://www.instagram.com/p/BtxoafjBFFi/?utm_source=ig_share_sheet&igshid=dxxnm3e71mlv";
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
//
//        String value = forEntity.getBody().toString();
//        long over = new Date().getTime();
//        System.out.println(over-begintime);
//        String pattern = "<meta property=\"og:image\".*?/>";
//        Pattern compile = Pattern.compile(pattern);
//        Matcher matcher = compile.matcher(value);
//        if (matcher.find())
//        {
//            String group = matcher.group();
//            System.out.println(group);
//            int begin = group.indexOf("http");
//            int end = group.lastIndexOf("com");
//            System.out.println(group.substring(begin,end+3));
//
//        }
//        String insPicUrl = WeChatUtils.getInsPicUrl("https://www.instagram.com/p/BtxoafjBFFi/?utm_source=ig_share_sheet&igshid=dxxnm3e71mlv");
       new ThreadTest().start();

    }
}
