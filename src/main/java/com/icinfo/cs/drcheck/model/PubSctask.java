/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.drcheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:  cs_pub_sctask 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月25日
 */
@Table(name = "cs_pub_sctask")
public class PubSctask implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id") 
    private Integer id;

    /**
     * 序号：UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 任务名称
     */
    @Column(name = "TaskName")
    private String taskName;

    /**
     * 任务编码
     */
    @Column(name = "TaskCode")
    private String taskCode;
    
    /**
     * 随机抽取企业总数
     */
    @Column(name = "TotalEnt")
    private Integer totalEnt;
    
    /**
     * 任务组织部门编码
     */
    @Column(name = "LeaderDeptCode")
    private String leaderDeptCode;

    /**
     * 任务组织部门描述
     */
    @Column(name = "LeaderDeptDesc")
    private String leaderDeptDesc;

    /**
     * 检查主体类型(企业大类多个以逗号分开)
     */
    @Column(name = "TaskEntCatgCode")
    private String taskEntCatgCode;

    /**
     * 检查主体类型中文(企业大类多个以逗号分开)
     */
    @Column(name = "TaskEntCatgDesc")
    private String taskEntCatgDesc;

    /**
     * 任务开始日期
     */
    @Column(name = "StartDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startDate;

    /**
     * 任务结束日期
     */
    @Column(name = "EndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endDate;

    /**
     * 抽查检查依据
     */
    @Column(name = "CheckReason")
    private String checkReason;

    /**
     * 检查区域
     */
    @Column(name = "CheckArea")
    private String checkArea;

    /**
     * 抽查检查对象
     */
    @Column(name = "CheckObject")
    private String checkObject;

    /**
     * 抽查检查内容
     */
    @Column(name = "CheckContent")
    private String checkContent;

    /**
     * 任务计划期限开始
     */
    @Column(name = "PlanStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planStartDate;

    /**
     * 任务计划期限结束
     */
    @Column(name = "PlanEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planEndDate;

    /**
     * 每户检查对象配置检查人员数量
     */
    @Column(name = "CheckNumber")
    private Integer checkNumber;

    /**
     * 检查方式及要求
     */
    @Column(name = "CheckWay")
    private String checkWay;

    /**
     * 设置人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 设置日期
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date setTime;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 设置部门描述
     */
    @Column(name = "SetDeptDesc")
    private String setDeptDesc;

    /**
     * 适用地区
     */
    @Column(name = "SuitArea")
    private String suitArea;

    /**
     * 状态
     */
    @Column(name = "TaskState")
    private String taskState;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 实施部门id多个以逗号分隔
     */
    @Column(name ="ImplDeptCode")
    private String implDeptCode;
    /**
     * 实施部门描述多个以逗号分隔
     */
    @Column(name ="ImplDeptDesc")
    private String implDeptDesc;
    /**
     * 抽查方式(0定向,1不定向)
     */
    @Column(name="SpeckWay")
    private String speckWay;
    
    
    private static final long serialVersionUID = 1L;

    /**
     * 获取自增序号
     *
     * @return id - 自增序号
     */
    public Integer getId() {
        return id;
    }

    public String getImplDeptCode() {
		return implDeptCode;
	}

	public void setImplDeptCode(String implDeptCode) {
		this.implDeptCode = implDeptCode;
	}

	public String getImplDeptDesc() {
		return implDeptDesc;
	}

	public void setImplDeptDesc(String implDeptDesc) {
		this.implDeptDesc = implDeptDesc;
	}

	public String getSpeckWay() {
		return speckWay;
	}

	public void setSpeckWay(String speckWay) {
		this.speckWay = speckWay;
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
     * 获取序号：UUID
     *
     * @return UID - 序号：UUID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号：UUID
     *
     * @param UID 序号：UUID
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * 获取任务编码
     *
     * @return TaskCode - 任务编码
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * 设置任务编码
     *
     * @param taskCode 任务编码
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    /**
     * 获取任务组织部门编码
     *
     * @return LeaderDeptCode - 任务组织部门编码
     */
    public String getLeaderDeptCode() {
        return leaderDeptCode;
    }

    /**
     * 设置任务组织部门编码
     *
     * @param leaderDeptCode 任务组织部门编码
     */
    public void setLeaderDeptCode(String leaderDeptCode) {
        this.leaderDeptCode = leaderDeptCode;
    }

    /**
     * 获取任务组织部门描述
     *
     * @return LeaderDeptDesc - 任务组织部门描述
     */
    public String getLeaderDeptDesc() {
        return leaderDeptDesc;
    }

    /**
     * 设置任务组织部门描述
     *
     * @param leaderDeptDesc 任务组织部门描述
     */
    public void setLeaderDeptDesc(String leaderDeptDesc) {
        this.leaderDeptDesc = leaderDeptDesc;
    }

    /**
     * 获取检查主体类型(企业大类多个以逗号分开)
     *
     * @return TaskEntCatgCode - 检查主体类型(企业大类多个以逗号分开)
     */
    public String getTaskEntCatgCode() {
        return taskEntCatgCode;
    }

    /**
     * 设置检查主体类型(企业大类多个以逗号分开)
     *
     * @param taskEntCatgCode 检查主体类型(企业大类多个以逗号分开)
     */
    public void setTaskEntCatgCode(String taskEntCatgCode) {
        this.taskEntCatgCode = taskEntCatgCode;
    }

    /**
     * 获取检查主体类型中文(企业大类多个以逗号分开)
     *
     * @return TaskEntCatgDesc - 检查主体类型中文(企业大类多个以逗号分开)
     */
    public String getTaskEntCatgDesc() {
        return taskEntCatgDesc;
    }

    /**
     * 设置检查主体类型中文(企业大类多个以逗号分开)
     *
     * @param taskEntCatgDesc 检查主体类型中文(企业大类多个以逗号分开)
     */
    public void setTaskEntCatgDesc(String taskEntCatgDesc) {
        this.taskEntCatgDesc = taskEntCatgDesc;
    }

    /**
     * 获取任务开始日期
     *
     * @return StartDate - 任务开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置任务开始日期
     *
     * @param startDate 任务开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取任务结束日期
     *
     * @return EndDate - 任务结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置任务结束日期
     *
     * @param endDate 任务结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取抽查检查依据
     *
     * @return CheckReason - 抽查检查依据
     */
    public String getCheckReason() {
        return checkReason;
    }

    /**
     * 设置抽查检查依据
     *
     * @param checkReason 抽查检查依据
     */
    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    /**
     * 获取检查区域
     *
     * @return CheckArea - 检查区域
     */
    public String getCheckArea() {
        return checkArea;
    }

    /**
     * 设置检查区域
     *
     * @param checkArea 检查区域
     */
    public void setCheckArea(String checkArea) {
        this.checkArea = checkArea;
    }

    /**
     * 获取抽查检查对象
     *
     * @return CheckObject - 抽查检查对象
     */
    public String getCheckObject() {
        return checkObject;
    }

    /**
     * 设置抽查检查对象
     *
     * @param checkObject 抽查检查对象
     */
    public void setCheckObject(String checkObject) {
        this.checkObject = checkObject;
    }

    /**
     * 获取抽查检查内容
     *
     * @return CheckContent - 抽查检查内容
     */
    public String getCheckContent() {
        return checkContent;
    }

    /**
     * 设置抽查检查内容
     *
     * @param checkContent 抽查检查内容
     */
    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    /**
     * 获取任务计划期限开始
     *
     * @return PlanStartDate - 任务计划期限开始
     */
    public Date getPlanStartDate() {
        return planStartDate;
    }

    /**
     * 设置任务计划期限开始
     *
     * @param planStartDate 任务计划期限开始
     */
    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    /**
     * 获取任务计划期限结束
     *
     * @return PlanEndDate - 任务计划期限结束
     */
    public Date getPlanEndDate() {
        return planEndDate;
    }

    /**
     * 设置任务计划期限结束
     *
     * @param planEndDate 任务计划期限结束
     */
    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    /**
     * 获取每户检查对象配置检查人员数量
     *
     * @return CheckNumber - 每户检查对象配置检查人员数量
     */
    public Integer getCheckNumber() {
        return checkNumber;
    }

    /**
     * 设置每户检查对象配置检查人员数量
     *
     * @param checkNumber 每户检查对象配置检查人员数量
     */
    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    /**
     * 获取检查方式及要求
     *
     * @return CheckWay - 检查方式及要求
     */
    public String getCheckWay() {
        return checkWay;
    }

    /**
     * 设置检查方式及要求
     *
     * @param checkWay 检查方式及要求
     */
    public void setCheckWay(String checkWay) {
        this.checkWay = checkWay;
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
     * 获取设置部门编码
     *
     * @return SetDeptCode - 设置部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置设置部门编码
     *
     * @param setDeptCode 设置部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取设置部门描述
     *
     * @return SetDeptDesc - 设置部门描述
     */
    public String getSetDeptDesc() {
        return setDeptDesc;
    }

    /**
     * 设置设置部门描述
     *
     * @param setDeptDesc 设置部门描述
     */
    public void setSetDeptDesc(String setDeptDesc) {
        this.setDeptDesc = setDeptDesc;
    }

    /**
     * 获取适用地区
     *
     * @return SuitArea - 适用地区
     */
    public String getSuitArea() {
        return suitArea;
    }

    /**
     * 设置适用地区
     *
     * @param suitArea 适用地区
     */
    public void setSuitArea(String suitArea) {
        this.suitArea = suitArea;
    }

    /**
     * 获取状态
     *
     * @return TaskState - 状态
     */
    public String getTaskState() {
        return taskState;
    }

    /**
     * 设置状态
     *
     * @param taskState 状态
     */
    public void setTaskState(String taskState) {
        this.taskState = taskState;
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

	public Integer getTotalEnt() {
		return totalEnt;
	}

	public void setTotalEnt(Integer totalEnt) {
		this.totalEnt = totalEnt;
	}
}