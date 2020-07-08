package com.cjd.annotationdemo;

public class UseAnnotationDemo {
    @FruitName("Apple")
    public String apple;
    public static void main(String[] args) {
        //System.out.println(new UseAnnotationDemo().apple);
        FruitInfoUtil.getFruitInfo(UseAnnotationDemo.class);
    }
}
