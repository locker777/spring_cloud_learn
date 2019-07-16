package com.test.order.dto;

import lombok.Data;

import java.io.Serializable;

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

    public CartDTO() {
    }

    public CartDTO(String productId, int productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
