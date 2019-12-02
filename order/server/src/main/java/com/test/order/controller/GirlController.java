package com.test.order.controller;

import com.test.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zjc
 * @Date: 2019/11/28 15:32
 * @Description:
 */
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("girl/config")
    public  String print(){

        return "name:"+girlConfig.getName()+",age:"+girlConfig.getAge();
    }
}
