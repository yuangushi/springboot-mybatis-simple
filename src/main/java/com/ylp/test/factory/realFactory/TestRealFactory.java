package com.ylp.test.factory.realFactory;

import com.ylp.test.factory.Operator;

public class TestRealFactory {
    public static void main(String[] args) throws Exception {
        Factory addFactory= (Factory) Class.forName("com.ylp.test.factory.realFactory.AddFactory").newInstance();
        Factory minusFactory= (Factory) Class.forName("com.ylp.test.factory.realFactory.MinusFactory").newInstance();

        Operator add=addFactory.createOperator();
        Operator minus=minusFactory.createOperator();
        System.out.println(add.getResult(1,2));
        System.out.println(minus.getResult(1,2));
    }
}
