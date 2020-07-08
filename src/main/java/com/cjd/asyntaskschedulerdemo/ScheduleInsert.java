package com.cjd.asyntaskschedulerdemo;

import java.util.Timer;
import java.util.TimerTask;

public class ScheduleInsert {
    public static void main(String[] args) {
        //int index = 0;
        final Task task = new InsertTask();
        new Timer("testTimer").schedule(new TimerTask() {
            @Override
            public void run() {
                task.insert();
            }
        },1000,2000);
    }
}
