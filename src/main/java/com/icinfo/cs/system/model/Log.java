/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_log_2016 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年12月29日
 */
@Table(name = "cs_log_2016")
public class Log implements Serializable {


    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    @Column(name = "RegNo")
    private String regNo;

    /**
     * 年份
     */
    @Column(name = "LogYear")
    private Integer logYear;

    /**
     * 日志类型
     */
    @Column(name = "LogType")
    private String logType;

    /**
     * 日志说明
     */
    @Column(name = "LogMsg")
    private String logMsg;

    /**
     * 企业端：1，警示：2,协同：3
     */
    @Column(name = "LogSystem")
    private String logSystem;

    /**
     * 操作人姓名
     */
    @Column(name = "LogOperator")
    private String logOperator;

    /**
     * 部门
     */
    @Column(name = "logOperDepart")
    private String logOperDepart;

    /**
     * 请求IP
     */
    @Column(name = "LogIp")
    private String logIp;

    /**
     * 请求时间
     */
    @Column(name = "LogTime")
    private Date logTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return PriPID
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * @param priPID
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * @return RegNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * @param regNo
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * 获取年份
     *
     * @return LogYear - 年份
     */
    public Integer getLogYear() {
        return logYear;
    }

    /**
     * 设置年份
     *
     * @param logYear 年份
     */
    public void setLogYear(Integer logYear) {
        this.logYear = logYear;
    }

    /**
     * 获取日志类型
     *
     * @return LogType - 日志类型
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 设置日志类型
     *
     * @param logType 日志类型
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * 获取日志说明
     *
     * @return LogMsg - 日志说明
     */
    public String getLogMsg() {
        return logMsg;
    }

    /**
     * 设置日志说明
     *
     * @param logMsg 日志说明
     */
    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    /**
     * 获取企业端：1，警示：2,协同：3
     *
     * @return LogSystem - 企业端：1，警示：2,协同：3
     */
    public String getLogSystem() {
        return logSystem;
    }

    /**
     * 设置企业端：1，警示：2,协同：3
     *
     * @param logSystem 企业端：1，警示：2,协同：3
     */
    public void setLogSystem(String logSystem) {
        this.logSystem = logSystem;
    }

    /**
     * 获取操作人姓名
     *
     * @return LogOperator - 操作人姓名
     */
    public String getLogOperator() {
        return logOperator;
    }

    /**
     * 设置操作人姓名
     *
     * @param logOperator 操作人姓名
     */
    public void setLogOperator(String logOperator) {
        this.logOperator = logOperator;
    }

    /**
     * 获取部门
     *
     * @return logOperDepart - 部门
     */
    public String getLogOperDepart() {
        return logOperDepart;
    }

    /**
     * 设置部门
     *
     * @param logOperDepart 部门
     */
    public void setLogOperDepart(String logOperDepart) {
        this.logOperDepart = logOperDepart;
    }

    /**
     * 获取请求IP
     *
     * @return LogIp - 请求IP
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     * 设置请求IP
     *
     * @param logIp 请求IP
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * 获取请求时间
     *
     * @return LogTime - 请求时间
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * 设置请求时间
     *
     * @param logTime 请求时间
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}