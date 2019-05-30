package com.test.product.service;

import com.test.product.DTO.CartDTO;
import com.test.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Auther: zjc
 * @Date: 2019/4/23 10:13
 * @Description:
 */
public interface ProductService {


    /**
     * 查询所有在架商品
     */
    public List<ProductInfo> findUpAll();


    /**
     * 查询商品列表
     */
    public List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);


}
