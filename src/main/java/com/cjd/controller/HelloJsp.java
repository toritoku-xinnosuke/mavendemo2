package com.cjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("HelloJsp")
public class HelloJsp {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
