package com.ylp.test.conf;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(YuanProperties.class)
public class MyConfig {

    public MyConfig(YuanProperties properties){
        String name=properties.getName();
        Integer age=properties.getAge();
    }
}
