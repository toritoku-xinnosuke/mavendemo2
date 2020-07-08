package com.cjd.annotationdemo;

public class ReflectDemo {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.cjd.annotationdemo.Apple");
            Apple apple = (Apple) clazz.newInstance();
            System.out.println(apple.getName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
