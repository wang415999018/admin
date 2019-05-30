package com.admin.common.vo;

import com.alibaba.fastjson.JSON;

public class BaseController {

    public ReturnVo getSuccess(Object object){
        ReturnVo vo = new ReturnVo();
        vo.setCode(1);
        if(object != null){
            vo.setData(JSON.toJSONString(object));
        }
        vo.setMsg("sucess");
        return vo;
    }

    public ReturnVo getErr(String msg){
        ReturnVo vo = new ReturnVo();
        vo.setMsg("error:"+msg);
        vo.setCode(2);
        return vo;
    }
}
