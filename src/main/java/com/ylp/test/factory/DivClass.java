package com.ylp.test.factory;

public class DivClass implements Operator {
    @Override
    public double getResult(double a, double b) throws Exception {
        if(b==0){
            throw new Exception("除数不能为0");
        }
        return a/b;
    }
}
