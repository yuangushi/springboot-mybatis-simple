package com.ylp.test.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@ConfigurationProperties(prefix = "yuan.configuration")
public class MyProperties implements Serializable {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyConfiguration{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
