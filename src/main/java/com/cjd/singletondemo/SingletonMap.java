package com.cjd.singletondemo;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Future;

public class SingletonMap {
    private final HashMap<Future<String>,Date> hashMap = new HashMap<>();
    private static SingletonMap instance = new SingletonMap();

    private SingletonMap(){}
    public static SingletonMap getInstance(){
        return instance;
    }

    public void put(Future<String> future,Date date){
        hashMap.put(future,date);

    }

    public void forEach(){

        //hashMap.forEach((x,y)->(if(y)));
    }
}
