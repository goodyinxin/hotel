package com.example.hotel.config;

import com.example.hotel.utils.Result;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LonginInterceptor implements HandlerInterceptor {


    private static final Logger log = LoggerFactory.getLogger(LonginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String method = request.getMethod();
        if (method != null && "OPTIONS".equals(method.toUpperCase())) {
            response = new Response();
            return true;
        }*/

        String token = request.getHeader("AUTH_TOKEN");
        log.info("token--{}",token);
        Object  userToken = request.getSession().getAttribute("token");
        log.info("seesion",request.getSession());
        if(userToken ==null || !String.valueOf(userToken).equals(token)){
            Result result = new Result();
            result.setCode("error");
            result.setMsg("没有权限请登录");
            return false;
        }else {
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
