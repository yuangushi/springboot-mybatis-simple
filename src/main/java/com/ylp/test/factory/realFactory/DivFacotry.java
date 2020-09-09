package com.ylp.test.factory.realFactory;

import com.ylp.test.factory.DivClass;
import com.ylp.test.factory.Operator;

public class DivFacotry implements Factory {
    @Override
    public Operator createOperator() {
        System.out.println("除法工厂");
        return new DivClass();
    }
}
