package com.cjd.threadpooldemo;

import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ScheduledExecutorDemo {
    private static final ExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

    Class<Observable> observable = Observable.class;
    public static void main(String[] args) {
        scheduledExecutor.submit(()->{
            System.out.println("11111");
        });
    }
}
