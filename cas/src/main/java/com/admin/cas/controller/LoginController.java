package com.admin.cas.controller;

import com.admin.cas.service.IUserServer;
import com.admin.common.login.LoginInfo;
import com.admin.common.login.LoginUtil;
import com.admin.common.user.UserEntity;
import com.admin.common.vo.BaseController;
import com.admin.common.vo.ReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cas")
public class LoginController extends BaseController {

    @Autowired
    private IUserServer userServer;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ReturnVo login(String userName,String password){
        UserEntity user = userServer.getUserByUserName(userName);
        if (user == null){
            return getErr("用户不存在");
        }
        if(user.getPassword().equals(password)){
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setUserName(user.getUserName());
            LoginUtil.addLoginCookie(loginInfo);
        }
        return getSuccess(null);
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    public ReturnVo loginOut(){
        LoginUtil.loginOut();
        return getSuccess(null);
    }

    @RequestMapping(value = "/checkLogin",method = RequestMethod.GET)
    public ReturnVo checkLogin(){
        return LoginUtil.checkLogin()?getSuccess(null):getErr("未登录");
    }

}
