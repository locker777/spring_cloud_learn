package com.test.user.enums;

import lombok.Getter;

/**
 * @Auther: zjc
 * @Date: 2019/5/30 15:06
 * @Description:
 */
@Getter
public enum ResultEnum {

    LOGIN_FAIL(1, "登陆失败"),
    ROLE_ERROR(2, "角色权限有误"),
    ;

    private int code;

    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
