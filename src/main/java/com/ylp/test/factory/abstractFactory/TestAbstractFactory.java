package com.ylp.test.factory.abstractFactory;

import com.ylp.test.entity.User;

public class TestAbstractFactory {
    public static void main(String[] args) {
        SqlFactory factory=new MysqlFactory();
        IUser user = factory.createUser();
        user.getUser(1);
        user.insert(new User());
    }

    public <T> void test123(T t){
        
    }
}
