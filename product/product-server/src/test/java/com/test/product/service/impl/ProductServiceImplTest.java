package com.test.product.service.impl;

import com.test.product.dto.CartDTO;
import com.test.product.ProductApplicationTests;
import com.test.product.dataobject.ProductInfo;
import com.test.product.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/4/23 10:24
 * @Description:
 */
@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;
    @Test
    public void findUpAll() {

        List<ProductInfo> productInfos= productService.findUpAll();
        System.out.println(productInfos.size());
    }


    @Test
    public void findList() throws Exception{

        List<ProductInfo> productInfos= productService.findList(Arrays.asList("157875196366160022"));
        System.out.println(productInfos.size());
    }

    @Test
    public void decreaseStock() throws Exception{


        CartDTO cartDTO = new CartDTO("157875196366160022", 1);

        productService.decreaseStock(Arrays.asList(cartDTO));



    }


}