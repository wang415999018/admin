package com.admin.service;

import com.admin.vo.UserVo;

public interface IUserService {

    void saveUser(UserVo vo);

    UserVo getUserByUserName(String userName);
}
