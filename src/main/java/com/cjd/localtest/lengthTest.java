package com.cjd.localtest;

public class lengthTest {
    public static void main(String[] args) {
        String str = "这里是10个字符的测试";
        try{
            byte[] b = str.getBytes("UTF-8");
            System.out.println(b.length);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
