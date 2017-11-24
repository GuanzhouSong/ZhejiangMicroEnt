/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:  cs_pub_scdispose 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月25日
 */
@Table(name = "cs_pub_scdispose")
public class PubScdispose implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    private Integer id;
    
    /**
     * 序号：任务表UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;
    
    /**
     * 任务表序号
     */
    @Column(name = "TaskNO")
     private String taskNO;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 检查结果
     */
    @Column(name = "ScResult")
    private String scResult;

    /**
     * 具体情况记录
     */
    @Column(name = "ScDetail")
    private String scDetail;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序号
     *
     * @return id - 自增序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增序号
     *
     * @param id 自增序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取实施部门任务表序号
     *
     * @return TaskNO - 实施部门任务表序号
     */
    public String getTaskNO() {
        return taskNO;
    }

    /**
     * 设置实施部门任务表序号
     *
     * @param taskNO 实施部门任务表序号
     */
    public void setTaskNO(String taskNO) {
        this.taskNO = taskNO;
    }

    /**
     * 获取主体身份代码
     *
     * @return PriPID - 主体身份代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码
     *
     * @param priPID 主体身份代码
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取检查结果
     *
     * @return ScResult - 检查结果
     */
    public String getScResult() {
        return scResult;
    }

    /**
     * 设置检查结果
     *
     * @param scResult 检查结果
     */
    public void setScResult(String scResult) {
        this.scResult = scResult;
    }

    /**
     * 获取具体情况记录
     *
     * @return ScDetail - 具体情况记录
     */
    public String getScDetail() {
        return scDetail;
    }

    /**
     * 设置具体情况记录
     *
     * @param scDetail 具体情况记录
     */
    public void setScDetail(String scDetail) {
        this.scDetail = scDetail;
    }

    /**
     * 获取时间戳
     *
     * @return CreateTime - 时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间戳
     *
     * @param createTime 时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

}