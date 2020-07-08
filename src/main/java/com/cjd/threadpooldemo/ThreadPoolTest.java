package com.cjd.threadpooldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0 ; i < 100 ; ++i){
            /*
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread is " + Thread.currentThread().getId());
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
            */
            /*
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread is " + Thread.currentThread().getId());
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });*/

            threadPool.submit(new ThreadTest());
        }
    }
}
