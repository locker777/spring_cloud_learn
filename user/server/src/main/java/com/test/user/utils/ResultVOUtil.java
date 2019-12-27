package com.test.user.utils;

import com.test.user.VO.ResultVO;
import com.test.user.enums.ResultEnum;

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

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }
}
