package com.cjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.thymeleaf.Thymeleaf;

@Controller
public class SayHelloController {
    @RequestMapping("/sayhello")
    //@ResponseBody
    public String index(Model model){

        model.addAttribute("message","Say Hello");
        return "get";
    }
}
