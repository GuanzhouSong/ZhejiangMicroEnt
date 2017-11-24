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
 * 描述:    cs_email_task 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月14日
 */
@Table(name = "cs_email_task")
public class EmailTask implements Serializable {
    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 邮件任务名称
     */
    @Column(name = "TaskName")
    private String taskName;

    /**
     * 任务开始日期
     */
    @Column(name = "StartTime")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startTime;

    /**
     * 设置人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date setTime;

    /**
     * 设置部门id
     */
    @Column(name = "DeptId")
    private String deptId;

    /**
     * 设置部门名称
     */
    @Column(name = "DeptName")
    private String deptName;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 邮件发送说明
     */
    @Column(name = "EmailInstruction")
    private String emailInstruction;

    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 邮件内容
     */
    @Column(name = "TaskContent")
    private String taskContent;
    
    /**
     * 邮件发送状态
     */
    @Column(name = "TaskType")
    private String taskType;
    
    private static final long serialVersionUID = 1L;

    public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取邮件任务名称
     *
     * @return TaskName - 邮件任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置邮件任务名称
     *
     * @param taskName 邮件任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取任务开始日期
     *
     * @return StartTime - 任务开始日期
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置任务开始日期
     *
     * @param startTime 任务开始日期
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取设置人
     *
     * @return SetName - 设置人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置设置人
     *
     * @param setName 设置人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取设置日期
     *
     * @return SetTime - 设置日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置日期
     *
     * @param setTime 设置日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取设置部门id
     *
     * @return DeptId - 设置部门id
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置设置部门id
     *
     * @param deptId 设置部门id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取设置部门名称
     *
     * @return DeptName - 设置部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置设置部门名称
     *
     * @param deptName 设置部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取邮件发送说明
     *
     * @return EmailInstruction - 邮件发送说明
     */
    public String getEmailInstruction() {
        return emailInstruction;
    }

    /**
     * 设置邮件发送说明
     *
     * @param emailInstruction 邮件发送说明
     */
    public void setEmailInstruction(String emailInstruction) {
        this.emailInstruction = emailInstruction;
    }

    /**
     * @return Uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取邮件内容
     *
     * @return TaskContent - 邮件内容
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * 设置邮件内容
     *
     * @param taskContent 邮件内容
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}