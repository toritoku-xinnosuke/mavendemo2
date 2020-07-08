package com.cjd.taskschedulerdemo;

public class Main {
    public static void main(String[] args) {
            ITaskScheduler taskScheduler = new TaskSchedulerImpl();
            ((TaskSchedulerImpl) taskScheduler).submit();
            //taskScheduler.start();

    }
}
