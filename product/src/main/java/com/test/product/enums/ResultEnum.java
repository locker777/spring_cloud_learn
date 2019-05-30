package com.test.product.enums;

import lombok.Getter;

/**
 * @Auther: zjc
 * @Date: 2019/5/30 15:06
 * @Description:
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在");

    private int code;

    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
