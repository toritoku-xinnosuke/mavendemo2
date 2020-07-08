package com.cjd.annotationdemo;

import java.lang.reflect.Field;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){
        String strFruitName = "水果名称";
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            }
        }
    }
}
