package com.test.product.service.impl;

import com.test.product.dataobject.ProductInfo;
import com.test.product.enums.ProductStatusEnum;
import com.test.product.repository.ProductInfoRepository;
import com.test.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/4/23 10:18
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
   private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
