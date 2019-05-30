package com.test.product.DTO;

import lombok.Data;

/**
 * @Auther: zjc
 * @Date: 2019/5/30 14:58
 * @Description:
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private int productQuantity;


}
