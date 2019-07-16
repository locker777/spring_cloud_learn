package com.test.product.utils;

import com.test.product.VO.ResultVO;

/**
 * @Auther: zjc
 * @Date: 2019/4/23 14:12
 * @Description:
 */
public class ResultVOUtil {


    public static ResultVO success(Object Data) {

        ResultVO resultVO = new ResultVO();
        resultVO.setData(Data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }
}
