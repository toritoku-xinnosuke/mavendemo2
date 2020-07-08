package com.cjd.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadXML {
    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream in = null;
        StringBuffer stringBuffer = new StringBuffer();

        if (file.isFile() && file.exists()){
            System.out.println("reading ");
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            try{
                in = new FileInputStream(file);

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
