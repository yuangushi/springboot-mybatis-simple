package com.ylp.test.abstractClass;

public abstract class abMethod {
    public void test1(){
        System.out.println("抽象类里的test1方法");
        test2();
    }

    public abstract void test2();
}
