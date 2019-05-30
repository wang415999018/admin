package com.admin.common.login;

import java.util.ArrayList;
import java.util.List;

public class LoginInfo {

    private String userName;
    private List<String>  menuCodeList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getMenuCodeList() {
        return menuCodeList;
    }

    public void setMenuCodeList(List<String> menuCodeList) {
        this.menuCodeList = menuCodeList;
    }

    @Override
    public String toString() {
        return this.getUserName();
    }
}
