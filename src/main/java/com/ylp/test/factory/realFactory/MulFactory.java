package com.ylp.test.factory.realFactory;

import com.ylp.test.factory.MulClass;
import com.ylp.test.factory.Operator;

public class MulFactory implements Factory {
    @Override
    public Operator createOperator() {
        System.out.println("乘法工厂");
        return new MulClass();
    }
}
