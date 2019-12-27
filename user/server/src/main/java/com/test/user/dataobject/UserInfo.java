package com.test.user.dataobject;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Auther: zjc
 * @Date: 2019/12/27 15:54
 * @Description:
 */

@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;

}
