package com.admin.service.imp;

import com.admin.vo.UserVo;
import com.admin.common.user.UserEntity;
import com.admin.dao.IUserDao;
import com.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao ;
    @Override
    public void saveUser(UserVo vo) {
        userDao.saveUser(vo.toEntity());
    }

    @Override
    public UserVo getUserByUserName(String userName) {
        UserEntity userEntity = userDao.getUserByUserName(userName);
        return UserVo.toVo(userEntity);
    }
}
