package com.ylp.test.threadPool;

import java.util.concurrent.*;

public class FixedPoolTest {

    public static Runnable getRunnable(){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    System.out.println("一个线程经过6秒睡眠后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /**
     * 能执行的线程是15个,为最大线程数+队列长度
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService1=new ThreadPoolExecutor(4,10,10, TimeUnit.SECONDS,new LinkedBlockingQueue<>(5));
//        ExecutorService executorService= Executors.newFixedThreadPool(4);
        for (int i = 0; i < 50; i++) {
            executorService1.execute(getRunnable());
        }
//        executorService1.shutdown();
        executorService1.shutdownNow();
    }
}
