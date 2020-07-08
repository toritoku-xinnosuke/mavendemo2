package com.cjd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"com.cjd.dao"})
@ComponentScan(basePackages = {"com.cjd.*"})
public class HelloSpring {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpring.class,args);
    }
}
