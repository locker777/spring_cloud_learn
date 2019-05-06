package com.test.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zjc
 * @Date: 2019/5/6 16:28
 * @Description:
 */
@Component
public class RestTempleteConfig {

    @Bean
    @LoadBalanced//LoadBalanced可以让restTemplate使用服务名
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
