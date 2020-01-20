package com.test.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Auther: zjc
 * @Date: 2020/1/19 14:28
 * @Description:
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {


    @HystrixCommand(commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//设置超时时间
    } )//(fallbackMethod = "fallback")使用上面默认的
    @GetMapping("/getProductInfoList")
    public String getProductInfoList() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://127.0.0.1:8086/product/listForOrder",
                Arrays.asList("157875227953464068"), String.class);
    }

    public String fallback(){
        return "太拥挤了，请稍后再试~~";
    }

    public String defaultFallback(){
        return "默认提示：太拥挤了，请稍后再试~~";
    }
}
