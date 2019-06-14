package com.test.product.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * @Auther: zjc
 * @Date: 2019/4/23 10:20
 * @Description:
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架"),;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
