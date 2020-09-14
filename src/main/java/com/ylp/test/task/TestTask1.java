package com.ylp.test.task;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask1 {

    public void run(){
        System.out.println("TestTask1 run============================"+new Date().toString());
        System.out.println("TestTask1 run====================end========"+new Date().toString());
    }
}
