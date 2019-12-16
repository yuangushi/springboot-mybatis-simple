package com.ylp.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
        String[] arr={"1"};
        List<String> retList= Arrays.asList(arr==null?new String[0]:arr);
        System.out.println(retList);
    }

    @Test
    public void test2(){
        List<String> list1=null;
    }

}
