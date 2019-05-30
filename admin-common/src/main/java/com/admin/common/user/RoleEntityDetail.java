package com.admin.common.user;


import java.util.ArrayList;
import java.util.List;

public class RoleEntityDetail extends RoleEntity {

    private List<String> menuCodeList  = new ArrayList<>();

    public List<String> getMenuCodeList() {
        return menuCodeList;
    }

    public void setMenuCodeList(List<String> menuCodeList) {
        this.menuCodeList = menuCodeList;
    }
}
