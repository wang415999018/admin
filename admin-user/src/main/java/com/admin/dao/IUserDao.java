package com.admin.dao;

import com.admin.common.user.UserEntity;
import com.admin.common.user.UserEntityDetail;

public interface IUserDao {

    void saveUser(UserEntity userEntity);

    UserEntity getUserByUserName(String userName);

    UserEntityDetail getUserDetailByUserName(String userName);
}
