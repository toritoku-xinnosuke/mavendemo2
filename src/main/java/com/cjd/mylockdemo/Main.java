package com.cjd.mylockdemo;

public class Main {
    public static void main(String[] args) {
        MyLock lock = new MyLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    lock.lock(this);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                    lock.unlock(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }
}
