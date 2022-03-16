package com.example.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@RequestMapping("/demo")
@Controller
public class DemoController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name","yipeng");
        return "hello2";
    }

}
