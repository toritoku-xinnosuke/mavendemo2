package com.cjd.finalqueuedemo;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SchedulerDemo {
    private final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final DispatcherDemo dispatcherDemo = new DispatcherDemo();

    SchedulerDemo(){
        try {
            queue.put("Start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putQueue(String s){
        try {
            queue.put(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendQueue(){
        this.dispatcherDemo.putQueue(this.queue);
    }

}
