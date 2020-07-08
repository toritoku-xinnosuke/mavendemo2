package com.cjd.localtest;

import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
    public static void main(String[] args) {
        //BatchProperties.Job
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 10 ; ++i){
            final int index = 1;
            try {
                Thread.sleep(index * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println();
                }
            });
        }
    }
}
