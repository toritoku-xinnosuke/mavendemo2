package com.cjd.quartzdemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerDemo {
    public static Scheduler getScheduler() throws SchedulerException{
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }

    public static void schedulerJob() throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(JobDemo.class).withIdentity("jobDemo","group1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerDemo","group3").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
        Scheduler scheduler = getScheduler();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }

    public static void main(String[] args) throws SchedulerException{
        SchedulerDemo schedulerDemo = new SchedulerDemo();

        schedulerJob();
    }
}
