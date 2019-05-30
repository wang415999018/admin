package com.admin.common.user;


import java.util.ArrayList;
import java.util.List;

public class UserEntityDetail extends UserEntity {

    private List<RoleEntityDetail> roleEntityDetailList = new ArrayList<>();

    public List<RoleEntityDetail> getRoleEntityDetailList() {
        return roleEntityDetailList;
    }

    public void setRoleEntityDetailList(List<RoleEntityDetail> roleEntityDetailList) {
        this.roleEntityDetailList = roleEntityDetailList;
    }
}
