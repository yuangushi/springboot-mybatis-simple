package com.ylp.test.genericType;

public class UserS implements MyInterface<String> {
    @Override
    public void show(String s) {
        System.out.println("show string");
    }
}
