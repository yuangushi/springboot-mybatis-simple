package com.ylp.test.autocon.entity;

public class YuanLP {
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void printSomeThing(){
        System.out.println("这是自动配置实体类里的方法");
    }
}
