//
//package com.example.hotel.config;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * Created by Silence on 2018/3/23.
// */
//
//@Component
//public class CrossDomainFilter implements Filter {
//
//    private static final Logger logger = LoggerFactory.getLogger(CrossDomainFilter.class);
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//
//
//        String requestOrigin = request.getHeader("Origin");
//
//        logger.info("==========requestOrigin:" + requestOrigin);
//
//
////        if(StringUtil.isNotEmpty(requestOrigin)){
////            response.addHeader("Access-Control-Allow-Origin", requestOrigin);
////        }
//
//        //全部包括 cloud.enndata.cn 的子域名。
////        if (requestOrigin != null && (requestOrigin.contains("*")
////                ||requestOrigin.contains("op.com")||requestOrigin.contains("laikang.com"))) {
////
//////            response.addHeader("Access-Control-Allow-Origin", "*");
////        }
//        response.addHeader("Access-Control-Allow-Origin", requestOrigin);
//        response.addHeader("Access-Control-Allow-Credentials", "true");
////        response.addHeader("Access-Control-Allow-Headers", "X-Requested-With");
////        response.addHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
//        response.addHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
//        response.addHeader("Access-Control-Allow-Headers", "content-type,Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, UserToken, appkey,AppId");
//        filterChain.doFilter(servletRequest, servletResponse);
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
//
