package com.ylp.test.factory.abstractFactory;

import com.ylp.test.entity.User;

public class OracleUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("oracle操作插入user");
    }

    @Override
    public User getUser(int id) {
        System.out.println("Oracle操作查询user");
        return null;
    }
}
