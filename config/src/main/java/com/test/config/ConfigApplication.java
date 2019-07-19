package com.test.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

    /**
     * /{name}-{profiles}.yml
     * /{label}/{name}-{profiles}.yml
     *
     *  name 服务名
     *  profiles 环境
     *  label 分支（branch）：默认不写 认为是master分支
     *
     *  http://127.0.0.1:8082/dev_20190718_config_test_new_branch/order-dev.yml
     *  http://127.0.0.1:8082/order-test.yml
     */
}
