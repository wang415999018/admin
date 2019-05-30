package com.admin.controller;

import com.admin.vo.UserVo;
import com.admin.common.vo.BaseController;
import com.admin.common.vo.ReturnVo;
import com.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ReturnVo addUser(HttpServletRequest request, HttpServletResponse response, UserVo vo){
        userService.saveUser(vo);
        return getSuccess(null);
    }


    @RequestMapping(value = "/findUser/{userName}" , method = RequestMethod.GET)
    public ReturnVo findUser(HttpServletResponse request,HttpServletResponse response,String userName){
        UserVo vo = userService.getUserByUserName(userName);
        return getSuccess(vo);
    }
}
