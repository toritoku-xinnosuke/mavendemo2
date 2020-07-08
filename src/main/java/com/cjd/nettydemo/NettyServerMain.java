package com.cjd.nettydemo;

public class NettyServerMain {



        public static void main(String[] args) throws Exception {
            //启动server服务
            new NettyServer().bind(10001);
        }


}
