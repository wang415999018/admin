package com.admin.cas.service;

import com.admin.cas.service.imp.UserServerImp;
import com.admin.common.user.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "admin-user",fallback = UserServerImp.class )
public interface IUserServer {

    @RequestMapping(value = "/user/findUser/{userName}",method = RequestMethod.GET)
    UserEntity getUserByUserName(String userName);
}
