package com.ylp.test.threadPool;

import com.ylp.test.entity.TaskCron;
import com.ylp.test.mapper.TaskCronMapper;
import com.ylp.test.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Configuration
@EnableScheduling
public class ThreadPoolConfiguration implements SchedulingConfigurer {

    @Autowired
    private TaskCronMapper taskCronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        List<TaskCron> taskCrons = taskCronMapper.queryAllTasks();
        System.out.println("查询了定时任务表,查到数据"+taskCrons.size()+"条数据");
        ThreadPoolTaskScheduler taskScheduler=new ThreadPoolTaskScheduler();
        //配置线程池里线程数为2
        taskScheduler.setPoolSize(2);
        taskScheduler.initialize();
        //修改默认的线程池为的新的含有2个线程的线程池
        taskRegistrar.setTaskScheduler(taskScheduler);
        if(!CollectionUtils.isEmpty(taskCrons)){
            for(TaskCron taskCron:taskCrons){
                taskRegistrar.addTriggerTask(getRunnable(taskCron),getTrigger(taskCron));
            }
        }

    }

    private Runnable getRunnable(TaskCron taskCron){
        return new Runnable() {
            @Override
            public void run() {
                Object task= SpringUtil.getBean(taskCron.getTaskName());
                try {
                    Method method = task.getClass().getMethod(taskCron.getMethodName());
                    method.invoke(task);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private Trigger getTrigger(TaskCron taskCron){
        return  new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                String cron=taskCronMapper.queryCron(taskCron.getTaskName());
                CronTrigger trigger=new CronTrigger(cron);
                Date date = trigger.nextExecutionTime(triggerContext);
                return date;
            }
        };
    }
}
