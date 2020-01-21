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


    //超时配置
//    @HystrixCommand(commandProperties ={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//设置超时时间
//    } )//(fallbackMethod = "fallback")使用上面默认的
//    @HystrixCommand(commandProperties = {
//            //circuitBreaker:断路器
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口 休眠时间（这个时间内进入降级逻辑） 休眠十秒 指定多久超时，单位毫秒。超时进fallback
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//断路器打开的百分比条件 判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(Integer number) {

        if (null != number && number % 2 == 0) {
            return "success";
        }

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject("http://127.0.0.1:8086/product/listForOrder",
                Arrays.asList("157875227953464068"), String.class);
    }

    public String fallback() {
        return "太拥挤了，请稍后再试~~";
    }

    public String defaultFallback() {
        return "默认提示：太拥挤了，请稍后再试~~";
    }
}
