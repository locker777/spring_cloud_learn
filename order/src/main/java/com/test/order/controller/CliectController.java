package com.test.order.controller;

import com.test.order.config.RestTempleteConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zjc
 * @Date: 2019/5/6 16:05
 * @Description:
 */
@RestController
@Slf4j
public class CliectController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

        //1、第一种方式,直接使用restTemplate，url写死
//        RestTemplate restTemplate =new RestTemplate();
//        String response=restTemplate.getForObject("http://127.0.0.1:8080/msg",String.class);

        //2、第二种方式利用loadBalancerClient通过应用名获取url，然后再使用restTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
        RestTemplate restTemplate =new RestTemplate();
        String response=restTemplate.getForObject(url,String.class);


        //3、第三种方式（利用@LoadBalanced，可在restTemplate里使用名字）
//        String response=restTemplate.getForObject("http://PRODUCT/msg",String.class);

        log.info("response={}", response);
        return response;
    }
}
