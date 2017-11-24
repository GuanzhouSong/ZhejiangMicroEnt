/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    sm_log 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月02日
 */
@Table(name = "sm_log")
public class SmLog implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 日志操作者
     */
    @Column(name = "LogUser")
    private String logUser;

    /**
     * 操作类型
     */
    @Column(name = "LogType")
    private String logType;

    /**
     * 操作状态
     */
    @Column(name = "LogStatue")
    private String logStatue;

    /**
     * 备注
     */
    @Column(name = "LogRemark")
    private String logRemark;

    /**
     * 客户端地址
     */
    @Column(name = "LogIp")
    private String logIp;

    /**
     * 操作时间
     */
    @Column(name = "LogTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date logTime;

    private static final long serialVersionUID = 1L;
    
    public SmLog() {
		super();
	}
	public SmLog(String logUser, String logType, String logRemark,String ip) {
		super();
		this.logUser = logUser;
		this.logType = logType;
		this.logStatue = "SUCCESS";
		this.logRemark = logRemark;
		this.logIp = ip;
		this.logTime = new Date();
	}

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
     * 获取日志操作者
     *
     * @return LogUser - 日志操作者
     */
    public String getLogUser() {
        return logUser;
    }

    /**
     * 设置日志操作者
     *
     * @param logUser 日志操作者
     */
    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    /**
     * 获取操作类型
     *
     * @return LogType - 操作类型
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 设置操作类型
     *
     * @param logType 操作类型
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * 获取操作状态
     *
     * @return LogStatue - 操作状态
     */
    public String getLogStatue() {
        return logStatue;
    }

    /**
     * 设置操作状态
     *
     * @param logStatue 操作状态
     */
    public void setLogStatue(String logStatue) {
        this.logStatue = logStatue;
    }

    /**
     * 获取备注
     *
     * @return LogRemark - 备注
     */
    public String getLogRemark() {
        return logRemark;
    }

    /**
     * 设置备注
     *
     * @param logRemark 备注
     */
    public void setLogRemark(String logRemark) {
        this.logRemark = logRemark;
    }

    /**
     * 获取客户端地址
     *
     * @return LogIp - 客户端地址
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     * 设置客户端地址
     *
     * @param logIp 客户端地址
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * 获取操作时间
     *
     * @return LogTime - 操作时间
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * 设置操作时间
     *
     * @param logTime 操作时间
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}