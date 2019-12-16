package com.ylp.test.conf;

import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HttpProperties.class)
public class MyConf {

    HttpProperties.Encoding properties;

    public MyConf(HttpProperties httpProperties){
        this.properties=httpProperties.getEncoding();
    }

}
