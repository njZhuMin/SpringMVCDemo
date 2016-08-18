package com.sunnywr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InterceptorController {

    @RequestMapping("/viewAll")
    public ModelAndView viewAll(String name, String password) {
        ModelAndView mv = new ModelAndView();
        System.out.println("In controller viewAll()...");
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        mv.setViewName("hello1");
        mv.addObject("msg", "value form viewAll()...");
        return mv;
    }

    @RequestMapping("/query")
    public ModelAndView query(String name, String password) {
        ModelAndView mv = new ModelAndView();
        System.out.println("In controller query()...");
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        mv.setViewName("hello1");
        return mv;
    }
}
