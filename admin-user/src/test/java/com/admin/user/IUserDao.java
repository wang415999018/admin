package com.admin.user;

import com.admin.common.user.UserEntity;

public interface IUserDao {

    public int saveUser(UserEntity user);

    public UserEntity getUserByUserCode(String UserCode);
}
