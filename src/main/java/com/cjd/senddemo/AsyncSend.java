package com.cjd.senddemo;

import com.cjd.service.ReqService;
import com.cjd.service.impl.ReqServiceImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class AsyncSend {
    ReqService reqService = new ReqServiceImpl();
    ReqGen reqGen = new ReqGen();

    volatile int insertI = 0;
    volatile int updateI = 0;

    public void insertReq() {
        //ThreadPoolExecutor = new
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        System.out.println("now in insertReq");
        int loop = 1000;
        //int i = 0;
        while (insertI < 1000) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    LockSupport.parkNanos(10);
                    reqService.insert(reqGen.getNewReq(1));
                    System.out.println("insert" + insertI);
                    insertI++;
                }
            });
        }
    }

    public void updateReq() {
        //ThreadPoolExecutor = new
        System.out.println("now in updateReq");
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        int loop = 1000;
        //int i = 0;
        while (updateI < 1000) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    LockSupport.parkNanos(100);
                    reqService.update(reqGen.getNewReq(0));
                    System.out.println("update" + updateI);
                    updateI++;
                }
            });
        }
    }
}
