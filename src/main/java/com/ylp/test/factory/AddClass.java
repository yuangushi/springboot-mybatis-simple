package com.ylp.test.factory;

public class AddClass implements Operator {
    @Override
    public double getResult(double a, double b) throws Exception {
        return a+b;
    }
}
