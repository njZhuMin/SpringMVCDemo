package com.sunnywr.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置编码
        request.setCharacterEncoding("utf-8");

        //权限验证
        if(request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return false;
        }
//        System.out.println("Intercepting: " + handler.getClass().getName());
        System.out.println("preHandle 1...");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("msg", "modified in postHandle()...");
//        modelAndView.setViewName("hello2");
        System.out.println("postHandle 1...");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 1...");
    }
}
