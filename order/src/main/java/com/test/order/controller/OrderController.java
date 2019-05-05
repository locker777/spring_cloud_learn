package com.test.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 11:30
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    /**
     * 1、参数检验
     * 2、查询商品信息
     * 3、计算总价
     * 4、扣库存（调用商品服务）
     * 5、订单入库
     */
    public void create(){

    }
}
