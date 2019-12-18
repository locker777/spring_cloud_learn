//package com.test.apigateway;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
//import org.springframework.stereotype.Component;
//
///**
// * @Auther: zjc
// * @Date: 2019/12/18 17:27
// * @Description:
// */
//@Component
//public class ZuulConfig {
//
//    @ConfigurationProperties("zuul")
//    @RefreshScope
//    public ZuulProperties zuulProperties(){
//        return  new ZuulProperties();
//    }
//}
