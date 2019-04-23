package com.test.product.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @Auther: zjc
 * @Date: 2019/4/23 10:52
 * @Description:
 */
@Data
public class ResultVO<T> {


    /**
     * 错误码
     */
     private Integer code;

    /**
     * 提示信息
     */
     private String msg;

    /**
     * 具体内容
     */
     private T data;
}
