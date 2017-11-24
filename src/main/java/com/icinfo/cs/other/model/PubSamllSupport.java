/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.other.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  cs_pub_small_suporrt 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月28日
 */
@Table(name = "cs_pub_small_suporrt")
public class PubSamllSupport implements Serializable {
	 /**
     * id,自增主键
     */
    @Id
    @Column(name = "ID")
   
    private Integer ID;

    /**
     * 32位uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体id
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 扶持部门id
     */
    @Column(name = "DeptID")
    private String deptID;
    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;
    /**
     * 扶持部门名称
     */
    @Column(name = "DeptName")
    private String deptName;

    /**
     * 扶持日期
     */
    @Column(name = "HelpDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date helpDate;

    /**
     * 提供方式
     */
    @Column(name = "ProvideType")
    private String provideType;

    /**
     * 提交日期
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date setDate;

    /**
     * 反馈日期
     */
    @Column(name = "FeedBackTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date feedBackTime;

    /**
     * 扶持金额
     */
    @Column(name = "SupportAm")
    private BigDecimal supportAm;

    /**
     * 错误代码
     */
    @Column(name = "ErrorCode")
    private String errorCode;

    /**
     * 录入人员
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 审核人员
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date auditDate;

    /**
     * 审核结果:0:待审核,1:已审核,2:审核通不过
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 扶持内容
     */
    @Column(name = "HelpContent")
    private String helpContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id,自增主键
     *
     * @return ID - id,自增主键
     */
    public Integer getID() {
        return ID;
    }

    /**
     * 设置id,自增主键
     *
     * @param ID id,自增主键
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * 获取32位uuid
     *
     * @return UID - 32位uuid
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置32位uuid
     *
     * @param UID 32位uuid
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取主体id
     *
     * @return PriPID - 主体id
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体id
     *
     * @param priPID 主体id
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取扶持部门id
     *
     * @return DeptID - 扶持部门id
     */
    public String getDeptID() {
        return deptID;
    }

    /**
     * 设置扶持部门id
     *
     * @param deptID 扶持部门id
     */
    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }
    

    public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
     * 获取扶持部门名称
     *
     * @return DeptName - 扶持部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置扶持部门名称
     *
     * @param deptName 扶持部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取扶持日期
     *
     * @return HelpDate - 扶持日期
     */
    public Date getHelpDate() {
        return helpDate;
    }

    /**
     * 设置扶持日期
     *
     * @param helpDate 扶持日期
     */
    public void setHelpDate(Date helpDate) {
        this.helpDate = helpDate;
    }

    /**
     * 获取提供方式
     *
     * @return ProvideType - 提供方式
     */
    public String getProvideType() {
        return provideType;
    }

    /**
     * 设置提供方式
     *
     * @param provideType 提供方式
     */
    public void setProvideType(String provideType) {
        this.provideType = provideType;
    }

    /**
     * 获取提交日期
     *
     * @return SetDate - 提交日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置提交日期
     *
     * @param setDate 提交日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取反馈日期
     *
     * @return FeedBackTime - 反馈日期
     */
    public Date getFeedBackTime() {
        return feedBackTime;
    }

    /**
     * 设置反馈日期
     *
     * @param feedBackTime 反馈日期
     */
    public void setFeedBackTime(Date feedBackTime) {
        this.feedBackTime = feedBackTime;
    }

    /**
     * 获取扶持金额
     *
     * @return SupportAm - 扶持金额
     */
    public BigDecimal getSupportAm() {
        return supportAm;
    }

    /**
     * 设置扶持金额
     *
     * @param supportAm 扶持金额
     */
    public void setSupportAm(BigDecimal supportAm) {
        this.supportAm = supportAm;
    }

    /**
     * 获取错误代码
     *
     * @return ErrorCode - 错误代码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误代码
     *
     * @param errorCode 错误代码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取录入人员
     *
     * @return SetName - 录入人员
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置录入人员
     *
     * @param setName 录入人员
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取审核人员
     *
     * @return AuditName - 审核人员
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 设置审核人员
     *
     * @param auditName 审核人员
     */
    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    /**
     * 获取审核日期
     *
     * @return AuditDate - 审核日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置审核日期
     *
     * @param auditDate 审核日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 获取审核结果:0:待审核,1:已审核,2:审核通不过
     *
     * @return AuditState - 审核结果:0:待审核,1:已审核,2:审核通不过
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核结果:0:待审核,1:已审核,2:审核通不过
     *
     * @param auditState 审核结果:0:待审核,1:已审核,2:审核通不过
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取审核意见
     *
     * @return AuditOpin - 审核意见
     */
    public String getAuditOpin() {
        return auditOpin;
    }

    /**
     * 设置审核意见
     *
     * @param auditOpin 审核意见
     */
    public void setAuditOpin(String auditOpin) {
        this.auditOpin = auditOpin;
    }

    /**
     * 获取扶持内容
     *
     * @return HelpContent - 扶持内容
     */
    public String getHelpContent() {
        return helpContent;
    }

    /**
     * 设置扶持内容
     *
     * @param helpContent 扶持内容
     */
    public void setHelpContent(String helpContent) {
        this.helpContent = helpContent;
    }
}