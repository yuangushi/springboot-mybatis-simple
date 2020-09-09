package com.ylp.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        int i=5;
        int k=(i++) *3;
        int j=++i *3;
        System.out.println(k);
        System.out.println(j);
        System.out.println(i);
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
