package com.test.order.controller;

import com.test.order.client.ProductClient;
import com.test.order.dataobject.ProductInfo;
import com.test.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/5/6 16:05
 * @Description:
 */
@RestController
@Slf4j
public class CliectController {


    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

        String response = productClient.msg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {

        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("157875227953464068"));
        log.info("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/proudctDecreaseStock")
    public String proudctDecreaseStock(){
        CartDTO cartDTO = new CartDTO("164103465734242707", 82);
        productClient.decreaseStock(Arrays.asList(cartDTO));
        return "ok";
    }


}
