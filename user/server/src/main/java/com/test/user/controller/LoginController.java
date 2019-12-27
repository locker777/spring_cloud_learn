package com.test.user.controller;

import com.test.user.VO.ResultVO;
import com.test.user.constant.CookieConstant;
import com.test.user.dataobject.UserInfo;
import com.test.user.enums.ResultEnum;
import com.test.user.enums.RoleEnum;
import com.test.user.service.UserService;
import com.test.user.utils.CookieUtil;
import com.test.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: zjc
 * @Date: 2019/12/27 16:07
 * @Description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private UserService userService;


    @GetMapping("/buyer")
    public ResultVO buyer(String openid, HttpServletResponse response) {

        //1. openid 和数据库里的数据进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);

        if (null == userInfo) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2、 判断角色
        if(RoleEnum.BUYER.getCode()!=userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //3、 cookie里设置openid=abc

        CookieUtil.set(response,CookieConstant.OPENID,openid,CookieConstant.expire);

        return ResultVOUtil.success();
    }


    @GetMapping("/seller")
    public ResultVO seller(String openid, HttpServletResponse response) {

        //1. openid 和数据库里的数据进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);

        if (null == userInfo) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2、 判断角色
        if(RoleEnum.BUYER.getCode()!=userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //3、 cookie里设置openid=abc

        CookieUtil.set(response,CookieConstant.OPENID,openid,CookieConstant.expire);

        return ResultVOUtil.success();

    }
}
