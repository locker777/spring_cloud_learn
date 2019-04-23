package com.test.product.service.impl;

import com.test.product.ProductApplicationTests;
import com.test.product.dataobject.ProductInfo;
import com.test.product.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

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
}