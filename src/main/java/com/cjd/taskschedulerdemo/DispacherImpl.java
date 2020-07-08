package com.cjd.taskschedulerdemo;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public final class DispacherImpl implements IDispatcher {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue();
    private final BlockingQueue<String> submitQueue = new LinkedBlockingQueue();
    private final List<DispacherImpl.AbstractHandler> handlers = new CopyOnWriteArrayList();
    private final ITaskScheduler taskScheduler;

    public DispacherImpl(ITaskScheduler taskScheduler) {
        handlers.add(new AbstractHandler("dispatcher")
        {
            @Override
            protected void handle() throws Exception
            {
                System.out.println("now in dispatcher add");
                handleDispatch();
            }
        });

        handlers.add(new AbstractHandler("sender")
        {
            @Override
            protected void handle() throws Exception
            {
                System.out.println("now in sender add");
                processSubmit();
            }
        });

        this.taskScheduler = taskScheduler;
    }


    @Override
    public void submit()
    {

        this.submitQueue.add("now in submit");
        System.out.println("now in submit");
    }


    public void processSubmit() throws Exception
    {
        System.out.println("in processSubmit");
    }

    private void handleDispatch() throws Exception
    {
        System.out.println("in handleDispatch");
    }

    /**
     *
     * 这里没看懂很奇怪
     *
     * */
    abstract class AbstractHandler
    {

        /**
         * 名称
         */
        private String name;
        /**
         * stop状态
         */
        private transient boolean stop = true;
        /**
         * 处理线程
         */
        private transient Thread thread;

        /**
         * 构造函数
         *
         * @param name
         *            处理器名称
         */
        AbstractHandler(String name)
        {
            this.name = name;
            System.out.println("init AbstractHandler");
        }

        /**
         * 启动
         */
        public void start()
        {
            System.out.println("AbstractHandler start");
            if (!stop) {
                return;
            }

            stop = false;
            thread = new Thread(() -> {

                while (!stop) {
                    try {
                        System.out.println("in loop");
                        this.handle();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });

            thread.setName(name);
            // thread.setDaemon(true);
            thread.start();

        }

        /**
         * 停止
         */
        void stop()
        {
            this.stop = true;
            if (thread != null) {
                thread.interrupt();
            }
        }

        /**
         * 处理逻辑抽象方法
         *
         * @throws Exception
         */
        protected abstract void handle() throws Exception;

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
