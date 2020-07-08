package com.cjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {
    @RequestMapping("/")
    String home(){
        return "Hello World";
    }
}
