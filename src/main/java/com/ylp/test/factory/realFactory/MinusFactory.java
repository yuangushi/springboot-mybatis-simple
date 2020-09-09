package com.ylp.test.factory.realFactory;

import com.ylp.test.factory.MinusClass;
import com.ylp.test.factory.Operator;

public class MinusFactory implements Factory {
    @Override
    public Operator createOperator() {
        System.out.println("减法运行工厂");
        return new MinusClass();
    }
}
