package com.zw.config;

import com.thoughtworks.xstream.XStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.zw.service","com.zw.thread"})
public class RootConfig {
    @Bean
    public XStream xStream()
    {
        return new XStream();
    }
}
