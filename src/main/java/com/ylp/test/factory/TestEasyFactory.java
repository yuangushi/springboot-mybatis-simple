package com.ylp.test.factory;

public class TestEasyFactory {
    public static void main(String[] args) throws Exception {
        Operator add = EasyFactory.operator("add");
        Operator minus = EasyFactory.operator("minus");
        Operator mul = EasyFactory.operator("mul");
        Operator div = EasyFactory.operator("div");

        System.out.println(add.getResult(1,2));
        System.out.println(minus.getResult(1,2));
        System.out.println(mul.getResult(1,2));
        System.out.println(div.getResult(1,2));
    }
}
