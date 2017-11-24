/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.dto;

import com.icinfo.cs.system.model.Log;

import java.util.Date;

/**
 * 描述:    cs_log_2016 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年12月29日
 */
public class LogDto extends Log {


    public static LogDto newInstance(){
        return new LogDto();
    }

    public LogDto putPriPID(String priPID) {
        super.setPriPID (priPID);
        return this;

    }

    public  LogDto putEntName(String entName) {
        super.setEntName(entName);
        return this;
    }


    public  LogDto putRegNo(String regNo) {
        super.setRegNo(regNo);
        return this;
    }


    public  LogDto putLogYear(Integer logYear) {
        super.setLogYear(logYear) ;
        return this;
    }


    public  LogDto putLogType(String logType) {
        super.setLogType(logType);
        return this;
    }


    public  LogDto putLogMsg(String logMsg) {
        super.setLogMsg(logMsg) ;
        return this;
    }


    public  LogDto putLogSystem(String logSystem) {
        super.setLogSystem (logSystem) ;
        return this;
    }


    public  LogDto putLogOperator(String logOperator) {
        super.setLogOperator(logOperator);
        return this;
    }

    public  LogDto putLogOperDepart(String logOperDepart) {
        super.setLogOperDepart(logOperDepart);
        return this;
    }

    public  LogDto putLogIp(String logIp) {
        super.setLogIp(logIp);
        return this;
    }

    public  LogDto putLogTime(Date logTime) {
        super.setLogTime(logTime);
        return this;
    }
}