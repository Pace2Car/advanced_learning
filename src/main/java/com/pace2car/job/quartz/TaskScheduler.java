package com.pace2car.job.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author Pace2Car
 * @date 2019/6/21 17:58
 */
public class TaskScheduler {
    public static void main(String[] args) throws SchedulerException {
        // 1.创建Scheduler工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        // 2.获取调度器
        Scheduler scheduler = sf.getScheduler();
        // 3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(MyJob.class)
                .withDescription("demo Job")
                .withIdentity("testJob", "testGroup")
                .build();
        // 任务启动的时间
        long timeMills = System.currentTimeMillis() + (3000L);
        Date startTime = new Date(timeMills);

        // 4.创建Trigger
        // 使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("trigger")
                .withIdentity("ramTrigger", "ranTrigger")
                .startAt(startTime)
                // 两秒一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? "))
                .build();
        // 5.注册Job和Trigger
        scheduler.scheduleJob(jb, trigger);

        // 6.启动
        scheduler.start();
    }
}
