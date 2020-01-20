package com.test.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.test.product.client")

@SpringCloudApplication//包含下面三个注解

//@EnableCircuitBreaker
//@SpringBootApplication
//@EnableDiscoveryClient

public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
