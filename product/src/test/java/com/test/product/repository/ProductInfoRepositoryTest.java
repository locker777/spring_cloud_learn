package com.test.product.repository;

import com.test.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/4/22 16:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);

        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findByProductId() throws Exception {

        List<String> productIdList=new ArrayList<>();
        productIdList.add("157875196366160022");
        productIdList.add("157875227953464068");
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));

        Assert.assertTrue(productInfoList.size() > 0);
    }

}