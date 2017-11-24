/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.specialrec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_special_rec_task 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月01日
 */
@Table(name = "cs_special_rec_task")
public class SpecialRecTask implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "Uid")
    private String uid;

    /**
     * 任务名称
     */
    @Column(name = "TaskName")
    private String taskName;

    /**
     * 任务编号
     */
    @Column(name = "TaskCode")
    private String taskCode;
    
    /**
     * 任务年度
     */
    @Column(name = "SeqYear")
    private Integer seqYear;

    /**
     * 任务类型
     */
    @Column(name = "TaskType")
    private String taskType;

    /**
     * 任务开始日期
     */
    @Column(name = "TaskStartTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date taskStartTime;

    /**
     * 任务截止日期
     */
    @Column(name = "TaskEndTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date taskEndTime;

    /**
     * 任务状态
     */
    @Column(name = "TaskState")
    private String taskState;

    /**
     * 任务设置部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;

    /**
     * 任务设置部门名称
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;

    /**
     * 任务组织部门编码
     */
    @Column(name = "OrgDeptCode")
    private String orgDeptCode;

    /**
     * 任务组织部门名称
     */
    @Column(name = "OrgDeptName")
    private String orgDeptName;

    /**
     * 任务参于部门编码
     */
    @Column(name = "PartiDeptCode")
    private String partiDeptCode;

    /**
     * 任务参与部门名称
     */
    @Column(name = "PartiDeptName")
    private String partiDeptName;

    /**
     * 设置人名称
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    /**
     * 任务说明
     */
    @Column(name = "TaskContent")
    private String taskContent;
    
    /**
     * 检查对像总数
     */
    @Column(name = "CheckEntTotal")
    private String checkEntTotal;
    
    /**
     * 已完成检查数
     */
    @Column(name = "CompletedTotal")
    private String completedTotal;

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
     * 获取唯一标识
     *
     * @return Uid - 唯一标识
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置唯一标识
     *
     * @param uid 唯一标识
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取任务名称
     *
     * @return TaskName - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取任务编号
     *
     * @return TaskCode - 任务编号
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * 设置任务编号
     *
     * @param taskCode 任务编号
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    /**
     * 获取任务类型
     *
     * @return TaskType - 任务类型
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 设置任务类型
     *
     * @param taskType 任务类型
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * 获取任务开始日期
     *
     * @return TaskStartTime - 任务开始日期
     */
    public Date getTaskStartTime() {
        return taskStartTime;
    }

    /**
     * 设置任务开始日期
     *
     * @param taskStartTime 任务开始日期
     */
    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    /**
     * 获取任务截止日期
     *
     * @return TaskEndTime - 任务截止日期
     */
    public Date getTaskEndTime() {
        return taskEndTime;
    }

    /**
     * 设置任务截止日期
     *
     * @param taskEndTime 任务截止日期
     */
    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    /**
     * 获取任务状态
     *
     * @return TaskState - 任务状态
     */
    public String getTaskState() {
        return taskState;
    }

    /**
     * 设置任务状态
     *
     * @param taskState 任务状态
     */
    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    /**
     * 获取任务设置部门编码
     *
     * @return DutyDeptCode - 任务设置部门编码
     */
    public String getDutyDeptCode() {
        return dutyDeptCode;
    }

    /**
     * 设置任务设置部门编码
     *
     * @param dutyDeptCode 任务设置部门编码
     */
    public void setDutyDeptCode(String dutyDeptCode) {
        this.dutyDeptCode = dutyDeptCode;
    }

    /**
     * 获取任务设置部门名称
     *
     * @return DutyDeptName - 任务设置部门名称
     */
    public String getDutyDeptName() {
        return dutyDeptName;
    }

    /**
     * 设置任务设置部门名称
     *
     * @param dutyDeptName 任务设置部门名称
     */
    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }

    /**
     * 获取任务组织部门编码
     *
     * @return OrgDeptCode - 任务组织部门编码
     */
    public String getOrgDeptCode() {
        return orgDeptCode;
    }

    /**
     * 设置任务组织部门编码
     *
     * @param orgDeptCode 任务组织部门编码
     */
    public void setOrgDeptCode(String orgDeptCode) {
        this.orgDeptCode = orgDeptCode;
    }

    /**
     * 获取任务组织部门名称
     *
     * @return OrgDeptName - 任务组织部门名称
     */
    public String getOrgDeptName() {
        return orgDeptName;
    }

    /**
     * 设置任务组织部门名称
     *
     * @param orgDeptName 任务组织部门名称
     */
    public void setOrgDeptName(String orgDeptName) {
        this.orgDeptName = orgDeptName;
    }

    /**
     * 获取任务参于部门编码
     *
     * @return PartiDeptCode - 任务参于部门编码
     */
    public String getPartiDeptCode() {
        return partiDeptCode;
    }

    /**
     * 设置任务参于部门编码
     *
     * @param partiDeptCode 任务参于部门编码
     */
    public void setPartiDeptCode(String partiDeptCode) {
        this.partiDeptCode = partiDeptCode;
    }

    /**
     * 获取任务参与部门名称
     *
     * @return PartiDeptName - 任务参与部门名称
     */
    public String getPartiDeptName() {
        return partiDeptName;
    }

    /**
     * 设置任务参与部门名称
     *
     * @param partiDeptName 任务参与部门名称
     */
    public void setPartiDeptName(String partiDeptName) {
        this.partiDeptName = partiDeptName;
    }

    /**
     * 获取设置人名称
     *
     * @return SetUserName - 设置人名称
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人名称
     *
     * @param setUserName 设置人名称
     */
    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    /**
     * 获取设置时间
     *
     * @return SetTime - 设置时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置设置时间
     *
     * @param setTime 设置时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取任务说明
     *
     * @return TaskContent - 任务说明
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * 设置任务说明
     *
     * @param taskContent 任务说明
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

	public String getCheckEntTotal() {
		return checkEntTotal;
	}

	public void setCheckEntTotal(String checkEntTotal) {
		this.checkEntTotal = checkEntTotal;
	}

	public String getCompletedTotal() {
		return completedTotal;
	}

	public void setCompletedTotal(String completedTotal) {
		this.completedTotal = completedTotal;
	}

	public Integer getSeqYear() {
		return seqYear;
	}

	public void setSeqYear(Integer seqYear) {
		this.seqYear = seqYear;
	}
    
    
}