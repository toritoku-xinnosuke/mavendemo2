package com.cjd.controller;

import com.cjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyBatisModelController {
    @Autowired
    private UserService userService;
    @RequestMapping("/map")
    //@ResponseBody
    public String getMap(Model model){
        model.addAttribute("list",userService.findAll());

        return "user";
    }
}
