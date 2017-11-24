/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pub_scwork_plan 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_scwork_plan")
public class PubScWorkPlan implements Serializable {
    /**
     * 自增序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 序号：UUID
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
   private String uid;

    /**
     * 工作计划年度
     */
    @Column(name = "PlanYear")
    private Integer planYear;
    
    

    /**
     * 附件地址
     */
    @Column(name = "fileUrl")
    private String fileUrl;
    
    /**
     * 附件名称
     */
    @Column(name = "fileName")
    private String fileName;
    
    

    /**
     * 抽查活动名称
     */
    @Column(name = "PlanName")
    private String planName;

    /**
     * 活动任务编号
     */
    @Column(name = "PlanCode")
    private String planCode;

    /**
     * 任务状态：待执行01,执行中02,已完成03
     */
    @Column(name = "PlanState")
    private String planState;

    /**
     * 抽查方式：定向-1，不定向-2
     */
    @Column(name = "PlanType")
    private String planType;

    /**
     * 计划活动期限起始
     */
    @Column(name = "PlanStartTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date planStartTime;

    /**
     * 计划活动期限结束
     */
    @Column(name = "PlanEndTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date planEndTime;

    /**
     * 责任单位（牵头处室）编码
     */
    @Column(name = "PlanLeadDeptcode")
    private String planLeadDeptcode;

    /**
     * 责任单位（牵头处室）描述
     */
    @Column(name = "PlanLeadDeptName")
    private String planLeadDeptName;

    /**
     * 抽查范围及数量比例（地区）
     */
    @Column(name = "PlanRange")
    private String planRange;

    @Column(name = "PlanRemark")
    private String planRemark;

    /**
     * 计划制定部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 计划制定部门描述
     */
    @Column(name = "SetDeptName")
    private String setDeptName;

    /**
     * 设置用户Uid
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date setTime;
    
    /**
     * 国家局公示编号-抽查检查
     */
    @Column(name = "InnerCode")
    private String innerCode;
    
    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;
    
    /**
     * 职能部门描述
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;
    
    /**
     * 是否跨部门，1-本部门，2-跨部门
     */
    @Column(name = "CrossDepartFlag")
    private String crossDepartFlag;

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
     * 获取序号：UUID
     *
     * @return Uid - 序号：UUID
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置序号：UUID
     *
     * @param uid 序号：UUID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取工作计划年度
     *
     * @return PlanYear - 工作计划年度
     */
    public Integer getPlanYear() {
        return planYear;
    }

    /**
     * 设置工作计划年度
     *
     * @param planYear 工作计划年度
     */
    public void setPlanYear(Integer planYear) {
        this.planYear = planYear;
    }

    /**
     * 获取抽查活动名称
     *
     * @return PlanName - 抽查活动名称
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * 设置抽查活动名称
     *
     * @param planName 抽查活动名称
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * 获取活动任务编号
     *
     * @return PlanCode - 活动任务编号
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * 设置活动任务编号
     *
     * @param planCode 活动任务编号
     */
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    /**
     * 获取任务状态：待执行01,执行中02,已完成03
     *
     * @return PlanState - 任务状态：待执行01,执行中02,已完成03
     */
    public String getPlanState() {
        return planState;
    }

    /**
     * 设置任务状态：待执行01,执行中02,已完成03
     *
     * @param planState 任务状态：待执行01,执行中02,已完成03
     */
    public void setPlanState(String planState) {
        this.planState = planState;
    }

    /**
     * 获取抽查方式：定向-1，不定向-2
     *
     * @return PlanType - 抽查方式：定向-1，不定向-2
     */
    public String getPlanType() {
        return planType;
    }

    /**
     * 设置抽查方式：定向-1，不定向-2
     *
     * @param planType 抽查方式：定向-1，不定向-2
     */
    public void setPlanType(String planType) {
        this.planType = planType;
    }

    /**
     * 获取计划活动期限起始
     *
     * @return PlanStartTime - 计划活动期限起始
     */
    public Date getPlanStartTime() {
        return planStartTime;
    }

    /**
     * 设置计划活动期限起始
     *
     * @param planStartTime 计划活动期限起始
     */
    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * 获取计划活动期限结束
     *
     * @return PlanEndTime - 计划活动期限结束
     */
    public Date getPlanEndTime() {
        return planEndTime;
    }

    /**
     * 设置计划活动期限结束
     *
     * @param planEndTime 计划活动期限结束
     */
    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * 获取责任单位（牵头处室）编码
     *
     * @return PlanLeadDeptcode - 责任单位（牵头处室）编码
     */
    public String getPlanLeadDeptcode() {
        return planLeadDeptcode;
    }

    /**
     * 设置责任单位（牵头处室）编码
     *
     * @param planLeadDeptcode 责任单位（牵头处室）编码
     */
    public void setPlanLeadDeptcode(String planLeadDeptcode) {
        this.planLeadDeptcode = planLeadDeptcode;
    }

    /**
     * 获取责任单位（牵头处室）描述
     *
     * @return PlanLeadDeptName - 责任单位（牵头处室）描述
     */
    public String getPlanLeadDeptName() {
        return planLeadDeptName;
    }

    /**
     * 设置责任单位（牵头处室）描述
     *
     * @param planLeadDeptName 责任单位（牵头处室）描述
     */
    public void setPlanLeadDeptName(String planLeadDeptName) {
        this.planLeadDeptName = planLeadDeptName;
    }

    /**
     * 获取抽查范围及数量比例（地区）
     *
     * @return PlanRange - 抽查范围及数量比例（地区）
     */
    public String getPlanRange() {
        return planRange;
    }

    /**
     * 设置抽查范围及数量比例（地区）
     *
     * @param planRange 抽查范围及数量比例（地区）
     */
    public void setPlanRange(String planRange) {
        this.planRange = planRange;
    }

    /**
     * @return PlanRemark
     */
    public String getPlanRemark() {
        return planRemark;
    }

    /**
     * @param planRemark
     */
    public void setPlanRemark(String planRemark) {
        this.planRemark = planRemark;
    }

    /**
     * 获取计划制定部门编码
     *
     * @return SetDeptCode - 计划制定部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置计划制定部门编码
     *
     * @param setDeptCode 计划制定部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取计划制定部门描述
     *
     * @return SetDeptName - 计划制定部门描述
     */
    public String getSetDeptName() {
        return setDeptName;
    }

    /**
     * 设置计划制定部门描述
     *
     * @param setDeptName 计划制定部门描述
     */
    public void setSetDeptName(String setDeptName) {
        this.setDeptName = setDeptName;
    }

    /**
     * 获取设置用户Uid
     *
     * @return SetUserUid - 设置用户Uid
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置用户Uid
     *
     * @param setUserUid 设置用户Uid
     */
    public void setSetUserUid(String setUserUid) {
        this.setUserUid = setUserUid;
    }

    /**
     * 获取设置人姓名
     *
     * @return SetUserName - 设置人姓名
     */
    public String getSetUserName() {
        return setUserName;
    }

    /**
     * 设置设置人姓名
     *
     * @param setUserName 设置人姓名
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getInnerCode() {
		return innerCode;
	}

	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}

	public String getDutyDeptCode() {
		return dutyDeptCode;
	}

	public void setDutyDeptCode(String dutyDeptCode) {
		this.dutyDeptCode = dutyDeptCode;
	}

	public String getDutyDeptName() {
		return dutyDeptName;
	}

	public void setDutyDeptName(String dutyDeptName) {
		this.dutyDeptName = dutyDeptName;
	}

	public String getCrossDepartFlag() {
		return crossDepartFlag;
	}

	public void setCrossDepartFlag(String crossDepartFlag) {
		this.crossDepartFlag = crossDepartFlag;
	}
}