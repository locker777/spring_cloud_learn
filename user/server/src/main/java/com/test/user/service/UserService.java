package com.test.user.service;

import com.test.user.dataobject.UserInfo;

/**
 * @Auther: zjc
 * @Date: 2019/12/27 16:01
 * @Description:
 */
public interface UserService {

    /**
     * 通过openid 来查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
