package com.ylp.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
