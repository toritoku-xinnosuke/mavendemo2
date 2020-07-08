package com.cjd.finalqueuedemo;

import java.util.concurrent.LinkedBlockingQueue;

public class DispatcherDemo {

    private final LinkedBlockingQueue<LinkedBlockingQueue<String>> bqueue = new LinkedBlockingQueue<>();
    private static final  SchedulerDemo schedulerDemo = new SchedulerDemo();
    public static void main(String[] args) {
        DispatcherDemo dispatcherDemo = new DispatcherDemo();

        //SchedulerDemo schedulerDemo = new SchedulerDemo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 100 ; ++i)
                schedulerDemo.putQueue(new StringBuffer(i).toString());
                schedulerDemo.sendQueue();
            }
        });
        t1.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //dispatcherDemo.putQueue();
        while (dispatcherDemo.bqueue.size() > 0){
            dispatcherDemo.getQueue();
        }
    }

    public  void getQueue(){
        try {
            System.out.println(this.bqueue.take().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putQueue(LinkedBlockingQueue<String> sringLinkedBlockingQueue){
        try {
            this.bqueue.put(sringLinkedBlockingQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
