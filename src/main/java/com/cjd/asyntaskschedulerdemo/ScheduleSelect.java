package com.cjd.asyntaskschedulerdemo;

import java.util.Timer;
import java.util.TimerTask;

public class ScheduleSelect {
    public static void main(String[] args) {
        final Task task = new SelectTask();
        new Timer("testTimer").schedule(new TimerTask() {
            @Override
            public void run() {
                task.select();
            }
        },1000,2000);
    }
}
