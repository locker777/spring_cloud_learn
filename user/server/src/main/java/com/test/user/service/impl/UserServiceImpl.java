package com.test.user.service.impl;

import com.test.user.dataobject.UserInfo;
import com.test.user.repository.UserInfoRepostory;
import com.test.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zjc
 * @Date: 2019/12/27 16:03
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserInfoRepostory userInfoRepostory;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepostory.findByOpenid(openid);
    }
}
