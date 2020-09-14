package com.ylp.test;

import com.ylp.test.entity.TaskCron;
import com.ylp.test.mapper.TaskCronMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//
//@Configuration
//@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer {

    @Autowired
    private TaskCronMapper taskCronMapper;

    public static String cron;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5,10,60, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(3);
        taskScheduler.initialize();
//        taskRegistrar.setTaskScheduler(taskScheduler);
        Runnable task=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("taskCronChange task is running..."+new Date());
            }
        };

        Trigger trigger=new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                TaskCron taskCron =taskCronMapper.getCronById("1");
                cron=taskCron.getCron();
                CronTrigger trigger1=new CronTrigger(cron);
                Date next=trigger1.nextExecutionTime(triggerContext);
                return next;
            }
        };

        for (int i = 0; i <20 ; i++) {
            taskRegistrar.addTriggerTask(getTask(),trigger);
        }
    }

    public Runnable getTask(){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread.开始启动"+Thread.currentThread().getId());
            }
        };
    }
}
