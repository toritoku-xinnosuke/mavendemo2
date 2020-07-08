package com.cjd.taskschedulerdemo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskSchedulerImpl implements ITaskScheduler {

    /**
     * 分发器
     */
    private final IDispatcher dispatcher;

    /**
     * 控制器
     */



    public TaskSchedulerImpl() {
       this.dispatcher = new DispacherImpl(this);
    }

    public void submit(){
        dispatcher.submit();
    }


    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() {

    }
}
