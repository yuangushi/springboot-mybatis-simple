package com.ylp.test.autocon;

import com.ylp.test.autocon.entity.YuanLP;
import com.ylp.test.autocon.properties.YlpProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(YlpProperties.class)
@ConditionalOnClass(YuanLP.class)
public class YuanAutoConfigure {
    private YlpProperties ylpProperties;

    public YuanAutoConfigure(YlpProperties ylpProperties){
        this.ylpProperties=ylpProperties;
        System.out.println("YuanAutoConfigure构造方法调用");
    }

    @Bean
    @ConditionalOnMissingBean(YuanLP.class)
    public YuanLP yuanLP(){
        YuanLP yuanLP=new YuanLP();
        yuanLP.printSomeThing();
        return yuanLP;
    }
}
