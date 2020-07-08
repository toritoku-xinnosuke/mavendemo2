package com.cjd.threadpooldemo;

public class ThreadTest extends Thread {
    static ThreadLocal<Integer> i = new ThreadLocal<>();
    @Override
    public void run() {
        System.out.println("Thread is " + Thread.currentThread().getId());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
