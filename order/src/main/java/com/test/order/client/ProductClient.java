package com.test.order.client;

import com.test.order.dataobject.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/5/6 18:21
 * @Description:
 */
@FeignClient(name = "product")//调用哪个应用
public interface ProductClient {
    //哪个应用的方法s
    @GetMapping("/msg")
    String msg();

    @GetMapping("/product/listForOrder")
    public List<ProductInfo> listForOrder(List<String> productIdList);
}
