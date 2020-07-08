package com.cjd.mylockdemo;

public class MyLock {
    volatile static int lockFlag = 1;
    volatile Object o;
    public void lock(Object o){
        lockFlag = 0;
        this.o = o;
        while (lockFlag!=1){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {

            }
        }

    }

    public void unlock(Object o) throws Exception {
        if(this.o.equals(o)){
            lockFlag = 1;
        }else{
            throw new InterruptedException();
        }
        //
    }

}
