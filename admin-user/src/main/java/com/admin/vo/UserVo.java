package com.admin.vo;

import com.admin.common.user.UserEntity;

public class UserVo {
    private String userName;
    private String password;

    public UserVo(){}

    public UserVo(UserEntity entity){
        this.userName = entity.getUserName();
        this.password = entity.getPassword();
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setPassword(this.password);
        entity.setUserName(this.userName);
        return entity;
    }

    public static UserVo toVo(UserEntity userEntity){
        UserVo vo = new UserVo();
        vo.setUserName(userEntity.getUserName());
        vo.setPassword(userEntity.getPassword());
        return vo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
