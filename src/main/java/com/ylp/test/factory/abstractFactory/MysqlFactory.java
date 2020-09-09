package com.ylp.test.factory.abstractFactory;

public class MysqlFactory implements SqlFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }
}
