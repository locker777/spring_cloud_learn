package com.test.order.enums;

import lombok.Getter;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 10:37
 * @Description:
 */
@Getter
public enum PayStatusEnums {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),;

    private Integer code;
    private String message;


    PayStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
