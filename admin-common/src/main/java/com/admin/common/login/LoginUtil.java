package com.admin.common.login;

import com.admin.common.ecrypt.md5.MD5Util;
import com.admin.common.filter.CurrentRequest;
import com.admin.common.log.LogUtil;
import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoginUtil {

    public static final String COOKEI_KEY="ADMIN_COOKEI_USER";
    final static BASE64Encoder encoder = new BASE64Encoder();
    final static BASE64Decoder decoder = new BASE64Decoder();

    public static void addLoginCookie(LoginInfo loginInfo){
        HttpServletResponse response = CurrentRequest.getResponse();
        try{
            String loginInfoStr = JSON.toJSONString(loginInfo);
            String baseLoginfoBase64 = decoder.decodeBuffer(loginInfoStr).toString();
            String sign = MD5Util.MD5(baseLoginfoBase64+COOKEI_KEY);
            Cookie loginInfoCookie = new Cookie("LOGIN_INFO", baseLoginfoBase64);
            loginInfoCookie.setPath("/");
            loginInfoCookie.setMaxAge(24*60*60*1000);
            response.addCookie(loginInfoCookie);

            Cookie signCookie = new Cookie("sign",sign);
            signCookie.setPath("/");
            signCookie.setMaxAge(24*60*60*1000);
            response.addCookie(signCookie);

        }catch (IOException e){
            LogUtil.ERROR.error(e.getMessage(), e);
        }
    }

    public static  LoginInfo getLoginInfo(){
        HttpServletRequest request = CurrentRequest.getRequest();
        Cookie [] cookies = request.getCookies();
        String loginInfoStr =null;
        String sign = null;
        for(Cookie ce : cookies ){
            if("LOGIN_INFO".equals(ce.getName())){
                loginInfoStr = ce.getValue();
            }else if("sign".equals(ce.getName())){
                sign = ce.getValue();
            }
        }
        if(loginInfoStr == null || sign == null){
            return null;
        }
        try {
            if(MD5Util.MD5(loginInfoStr+COOKEI_KEY).equals(sign)){
                return JSON.parseObject(encoder.encode(loginInfoStr.getBytes("utf-8")).toString(),LoginInfo.class);
            }
        }catch (UnsupportedEncodingException e){
            LogUtil.ERROR.error(e.getMessage(), e);
        }
        return null;
    }

    public boolean checkLogin(){
        return getLoginInfo()==null?false:true;
    }

}
