package com.ylp.test.factory;

public class EasyFactory {

    public static Operator operator(String name){
        Operator operator=null;
        switch (name){
            case "add":
                operator=new AddClass();
                break;
            case "minus":
                operator=new MinusClass();
                break;
            case "mul":
                operator=new MulClass();
                break;
            case "div":
                operator=new DivClass();
                break;

        }
        return operator;
    }
}
