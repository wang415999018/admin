package com.admin.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtil {
	
	/**
	 * 记录系统运行日志，监控系统运行情况
	 */
    public static final Log APP = LogFactory.getLog("app");
    
    /**
     * 记录业务日志，监控业务执行情况
     */
    public static final Log MSG = LogFactory.getLog("msg");
    
    /**
     * 记录系统错误，监控程序是否出错
     */
    public static final Log ERROR = LogFactory.getLog("error");
	
}
