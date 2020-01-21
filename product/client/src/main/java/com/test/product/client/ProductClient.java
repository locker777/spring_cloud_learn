package com.test.product.client;

import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/5/6 18:21
 * @Description:
 */
@FeignClient(name = "product",fallback = ProductClient.ProductClientFallback.class)//调用哪个应用
public interface ProductClient {
    //哪个应用的方法s
    @GetMapping("/msg")
    String msg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(List<String> productIdList);


    //扣库存
    @PostMapping("/product/decreaseStock")
    public void decreaseStock(List<DecreaseStockInput> cartDTOList);

    @Component
    static class  ProductClientFallback implements ProductClient{

        @Override
        public String msg() {
            return null;
        }

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

        }
    }
}
