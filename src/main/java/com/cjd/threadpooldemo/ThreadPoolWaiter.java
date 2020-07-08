package com.cjd.threadpooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolWaiter {

    private static final AtomicInteger num = new AtomicInteger();


    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                //ThreadLocal
            }
        });

    }

    private static final class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {

            e.printStackTrace();
            if(num.get() < 3){
            new Thread(new ThreadTask()).start();
        }
    }

    private static final class ThreadTask implements Runnable{
        @Override
        public void run() {
            num.incrementAndGet();
            Thread.currentThread().setUncaughtExceptionHandler(new ThreadExceptionHandler());
             /*try{

                System.out.println(12/0);
            }catch (InterruptedException e){
                e.printStackTrace();
            }*/
        }
    }
    }

}
