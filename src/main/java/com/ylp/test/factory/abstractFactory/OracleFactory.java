package com.ylp.test.factory.abstractFactory;

public class OracleFactory implements SqlFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }
}
