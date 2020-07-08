package com.cjd.cameldemo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopierWithCamel {

    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:E:\\data\\data?noop=true")
                        .to("file:E:\\data");   // (1) 将文件从inbox路由到outbox
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
