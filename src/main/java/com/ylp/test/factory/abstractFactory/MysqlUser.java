package com.ylp.test.factory.abstractFactory;

import com.ylp.test.entity.User;

public class MysqlUser implements  IUser {
    @Override
    public void insert(User user) {
        System.out.println("mysql操作user表插入");
    }

    @Override
    public User getUser(int id) {
        System.out.println("mysql查询ID为:"+id+",的用户");
        return null;
    }
}
