package com.ylp.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class FanXingTest {
    Number a;

    @Test
    public void test(){
        BigDecimal a=new BigDecimal(1);
        BigDecimal b=new BigDecimal(2);
        if(a.compareTo(b)==-1){
            System.out.println("小于");
        }

    }
}
