package com.cjd.senddemo;

public class Main {
    public static void main(String[] args) {
        AsyncSend asyncSend = new AsyncSend();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                asyncSend.insertReq();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                asyncSend.updateReq();
            }
        });

        t1.start();
        t2.start();


    }
}
