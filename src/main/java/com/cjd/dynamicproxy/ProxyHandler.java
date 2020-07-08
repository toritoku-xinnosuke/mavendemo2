package com.cjd.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object o){
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke" + method.getName());

        method.invoke(object,args);

        System.out.println("after invoke" + method.getName());

        return null;
    }
}
