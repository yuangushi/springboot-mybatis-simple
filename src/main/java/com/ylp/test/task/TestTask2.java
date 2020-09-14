package com.ylp.test.task;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask2 {
    public void run(){
        System.out.println("TestTask2 run============================"+new Date().toString());
        try {
            Thread.sleep(20000);
            throw new RuntimeException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestTask2 run====================end========"+new Date().toString());
    }
}
