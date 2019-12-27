package com.test.user.repository;

import com.test.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: zjc
 * @Date: 2019/12/27 15:58
 * @Description:
 */
public interface UserInfoRepostory extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);

}
