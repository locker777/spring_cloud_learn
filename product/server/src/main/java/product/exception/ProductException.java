package com.test.product.exception;

import com.test.product.enums.ResultEnum;

/**
 * @Auther: zjc
 * @Date: 2019/5/30 15:04
 * @Description:
 */
public class ProductException extends RuntimeException {
    private int code;

    public ProductException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}

