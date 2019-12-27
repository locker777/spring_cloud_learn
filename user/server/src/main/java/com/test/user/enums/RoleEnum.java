package com.test.user.enums;

import lombok.Getter;

/**
 * @Auther: zjc
 * @Date: 2019/5/30 15:06
 * @Description:
 */
@Getter
public enum RoleEnum {

    BUYER(1, "买家"),
    SELLER(2, "卖家"),;

    private int code;

    private String message;

    RoleEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
