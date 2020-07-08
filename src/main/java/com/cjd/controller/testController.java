package com.cjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class testController {
    @RequestMapping("/test1")
    @ResponseBody
    public Map<String,Object> showHelloWorld(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("msg","helloworld");
        return map;
    }
}
