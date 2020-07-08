package com.cjd.threadpooldemo;

import org.apache.camel.spi.ExceptionHandler;

public class MyTask implements Runnable{



    @Override
    public void run() {
        this.hashCode();
        //Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
    }
}
