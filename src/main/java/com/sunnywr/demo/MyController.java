package com.sunnywr.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class MyController {

    @RequestMapping("/mvc")
    public String helloMvc() {
        return "home";
    }
}
