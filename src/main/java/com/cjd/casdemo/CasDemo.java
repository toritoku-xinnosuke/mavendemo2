package com.cjd.casdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Semaphore semaphore = new Semaphore(2);

        try {
            semaphore.acquire();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int j = 0 ; j < 3 ; ++j){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(i.incrementAndGet());

                }
            });
        }
    }
}
