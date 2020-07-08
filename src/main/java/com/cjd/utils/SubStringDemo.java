package com.cjd.utils;

import java.util.ArrayList;
import java.util.List;
import java.net.InetAddress;

public class SubStringDemo {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("11111");
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        if(s.length()>4000) {
            String s1 =s.toString().substring(0,3999);
        }

        //System.out.println(()->(s));
        System.out.println(s);
        String s2 = String.valueOf(s);
        list.add(s2);
        list.forEach((x) -> {if(x.length() > 4000)
            list2.add(x.substring(0,3999));
        else
            list2.add(x);});


        System.out.println();
        //System.out.println(s.substring(0,100));
    }
}
