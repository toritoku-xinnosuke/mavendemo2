package com.cjd.queuedemo;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer {
    public final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
    public final List<AbstractHandler> list = new CopyOnWriteArrayList<>();
    protected static int i = 0;
    //String temp = null;
    public Consumer(){
        /*
        list.add(new AbstractHandler("put") {
            @Override
            protected void handle() throws Exception {
                try{
                    blockingQueue.put(new Date().toString() + "put");
                    Thread.sleep(1000);
                    System.out.println(blockingQueue.size() + "put");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });*/
        list.add(new AbstractHandler("producter") {
            @Override
            protected void handle() throws Exception {

                try {
                    blockingQueue.add(new Date().toString() + "producter");
                    Thread.sleep(1000);
                    //System.out.println(blockingQueue.size() + "producter");

                }catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println("now in producter" + new Date().toString());
            }
        });

        list.add(new AbstractHandler("Consumer") {
            @Override
            protected void handle() throws Exception {
                try{String temp = blockingQueue.take();
                    ++i;
                    System.out.println("now in Consumer" + temp  + i);
                    Thread.sleep(10);
                }catch (Exception e){
                    System.out.println("Consumer Exception");
                    e.printStackTrace();
                }

            }
        });

        for(AbstractHandler abstractHandler:list){
            abstractHandler.start();
        }
    }





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
        }

        /**
         * 启动
         */
        public void start()
        {

            if (!stop) {
                return;
            }

            stop = false;
            thread = new Thread(() -> {

                while (!stop) {
                    try {
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
         *         Exception
         */
        protected abstract void handle() throws Exception;

    }

}
