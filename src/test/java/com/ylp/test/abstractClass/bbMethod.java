package com.ylp.test.abstractClass;

public class bbMethod extends abMethod {
    @Override
    public void test2() {
        System.out.println("子类1的test2方法");
    }

    public static void main(String[] args) {
        abMethod abMethod=new bbMethod();
        abMethod.test1();
    }
}
