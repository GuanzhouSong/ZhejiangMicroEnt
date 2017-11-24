/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_sys_log 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月18日
 */
@Table(name = "cs_sys_log")
public class SysLog implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "EntName")
    private String entName;

    @Column(name = "RegNO")
    private String regNO;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "LogEntType")
    private String logEntType;

    @Column(name = "LogType")
    private String logType;

    @Column(name = "LogOperation")
    private String logOperation;

    @Column(name = "CallIp")
    private String callIp;

    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date setTime;

    @Column(name = "SetName")
    private String setName;

    @Column(name = "SetId")
    private String setId;

    @Column(name = "LogMsg")
    private String logMsg;

    /**
     * 其他详细信息
     */
    @Column(name = "Remark")
    private String remark;

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
     * @return UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * @param UID
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * @return EntName
     */
    public String getEntName() {
        return entName;
    }

    /**
     * @param entName
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * @return RegNO
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * @param regNO
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * @return Year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return LogEntType
     */
    public String getLogEntType() {
        return logEntType;
    }

    /**
     * @param logEntType
     */
    public void setLogEntType(String logEntType) {
        this.logEntType = logEntType;
    }

    /**
     * @return LogType
     */
    public String getLogType() {
        return logType;
    }

    /**
     * @param logType
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * @return LogOperation
     */
    public String getLogOperation() {
        return logOperation;
    }

    /**
     * @param logOperation
     */
    public void setLogOperation(String logOperation) {
        this.logOperation = logOperation;
    }

    /**
     * @return CallIp
     */
    public String getCallIp() {
        return callIp;
    }

    /**
     * @param callIp
     */
    public void setCallIp(String callIp) {
        this.callIp = callIp;
    }

    /**
     * @return SetTime
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * @param setTime
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * @return SetName
     */
    public String getSetName() {
        return setName;
    }

    /**
     * @param setName
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * @return SetId
     */
    public String getSetId() {
        return setId;
    }

    /**
     * @param setId
     */
    public void setSetId(String setId) {
        this.setId = setId;
    }

    /**
     * @return LogMsg
     */
    public String getLogMsg() {
        return logMsg;
    }

    /**
     * @param logMsg
     */
    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    /**
     * 获取其他详细信息
     *
     * @return Remark - 其他详细信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置其他详细信息
     *
     * @param remark 其他详细信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}