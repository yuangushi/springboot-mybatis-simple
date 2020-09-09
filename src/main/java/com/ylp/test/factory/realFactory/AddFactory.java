package com.ylp.test.factory.realFactory;

import com.ylp.test.factory.AddClass;
import com.ylp.test.factory.Operator;

public class AddFactory implements Factory {
    @Override
    public Operator createOperator() {
        System.out.println("加法运行工厂");
        return new AddClass();
    }
}
