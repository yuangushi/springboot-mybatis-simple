package com.ylp.test.genericType;

public class UserT<T> implements MyInterface<T> {
    @Override
    public void show(T t) {
        System.out.println("show T");
    }
}
