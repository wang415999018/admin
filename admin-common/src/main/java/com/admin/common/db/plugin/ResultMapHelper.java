package com.admin.common.db.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

import java.util.Properties;

public class ResultMapHelper implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(invocation.getTarget() instanceof ResultSetHandler){
            ResultSetHandler resultSetHandlerr = (ResultSetHandler)invocation.getTarget();
            Object[] arg = invocation.getArgs();

        }
        return null;
    }

    @Override
    public Object plugin(Object o) {
        if(o instanceof ResultSetHandler){
            return Plugin.wrap(o,this);
        }
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
