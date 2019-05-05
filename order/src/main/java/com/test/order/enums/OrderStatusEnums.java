package com.test.order.enums;

import lombok.Getter;

/**
 * @Auther: zjc
 * @Date: 2019/4/29 10:30
 * @Description:
 */
@Getter
public enum  OrderStatusEnums {

    NEW(0,"新订单"),
    FINISHED(1,"新订单"),
    CANCEL(2,"新订单"),;

    private Integer code;
    private String message;

    OrderStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
