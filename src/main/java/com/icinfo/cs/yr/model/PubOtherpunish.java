/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.DateUtil;

/**
 * 描述:    cs_pub_otherpunish 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月17日
 */
@Table(name = "cs_pub_otherpunish")
public class PubOtherpunish implements Serializable {
	
	@Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "CaseNO")
    private String caseNO;

    @Column(name = "PriPID")
    private String priPID;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "RegNO")
    private String regNO;
    
    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 处罚决定书文号
     */
    @Column(name = "PenDecNo")
    private String penDecNo;

    /**
     * 处罚类型，对应字段表
     */
    @Column(name = "PenType")
    private String penType;

    /**
     * 罚款金额
     */
    @Column(name = "PenAm")
    private BigDecimal penAm;

    /**
     * 没收金额
     */
    @Column(name = "ForfAm")
    private BigDecimal forfAm;

    /**
     * 处罚决定日期
     */
    @Column(name = "PenDecIssDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date penDecIssDate;

    /**
     * 处罚决定机关
     */
    @Column(name = "JudAuth")
    private String judAuth;

    /**
     * 是否已公示1:已公示 0：未公示
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 录入人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 录入日期
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setDate;

    /**
     * 审核人
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;

    /**
     * 审核结果：0：待审核，1：已审核，2：审核不通过
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 录入部门
     */
    @Column(name = "SetDeptname")
    private String setDeptname;

    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 违法行为类型
     */
    @Column(name = "IllegActType")
    private String illegActType;

    /**
     * 行政处罚内容
     */
    @Column(name = "PenContent")
    private String penContent;

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
     * @return CaseNO
     */
    public String getCaseNO() {
        return caseNO;
    }

    /**
     * @param caseNO
     */
    public void setCaseNO(String caseNO) {
        this.caseNO = caseNO;
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
     * 获取处罚决定书文号
     *
     * @return PenDecNo - 处罚决定书文号
     */
    public String getPenDecNo() {
        return penDecNo;
    }

    /**
     * 设置处罚决定书文号
     *
     * @param penDecNo 处罚决定书文号
     */
    public void setPenDecNo(String penDecNo) {
        this.penDecNo = penDecNo;
    }

    /**
     * 获取处罚类型，对应字段表
     *
     * @return PenType - 处罚类型，对应字段表
     */
    public String getPenType() {
        return penType;
    }

    /**
     * 设置处罚类型，对应字段表
     *
     * @param penType 处罚类型，对应字段表
     */
    public void setPenType(String penType) {
        this.penType = penType;
    }

    /**
     * 获取罚款金额
     *
     * @return PenAm - 罚款金额
     */
    public BigDecimal getPenAm() {
        return penAm;
    }

    /**
     * 设置罚款金额
     *
     * @param penAm 罚款金额
     */
    public void setPenAm(BigDecimal penAm) {
        this.penAm = penAm;
    }

    /**
     * 获取没收金额
     *
     * @return ForfAm - 没收金额
     */
    public BigDecimal getForfAm() {
        return forfAm;
    }

    /**
     * 设置没收金额
     *
     * @param forfAm 没收金额
     */
    public void setForfAm(BigDecimal forfAm) {
        this.forfAm = forfAm;
    }

    /**
     * 获取处罚决定日期
     *
     * @return PenDecIssDate - 处罚决定日期
     */
    public Date getPenDecIssDate() {
        return penDecIssDate;
    }

    /**
     * 设置处罚决定日期
     *
     * @param penDecIssDate 处罚决定日期
     */
    public void setPenDecIssDate(Date penDecIssDate) {
        this.penDecIssDate = penDecIssDate;
    }

    /**
     * 获取处罚决定机关
     *
     * @return JudAuth - 处罚决定机关
     */
    public String getJudAuth() {
        return judAuth;
    }

    /**
     * 设置处罚决定机关
     *
     * @param judAuth 处罚决定机关
     */
    public void setJudAuth(String judAuth) {
        this.judAuth = judAuth;
    }

    /**
     * 获取是否已公示1:已公示 0：未公示
     *
     * @return PubFlag - 是否已公示1:已公示 0：未公示
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置是否已公示1:已公示 0：未公示
     *
     * @param pubFlag 是否已公示1:已公示 0：未公示
     */
    public void setPubFlag(String pubFlag) {
        this.pubFlag = pubFlag;
    }

    /**
     * 获取录入人
     *
     * @return SetName - 录入人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置录入人
     *
     * @param setName 录入人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取录入日期
     *
     * @return SetDate - 录入日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置录入日期
     *
     * @param setDate 录入日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取审核人
     *
     * @return AuditName - 审核人
     */
    public String getAuditName() {
        return auditName;
    }

    /**
     * 设置审核人
     *
     * @param auditName 审核人
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
     * 获取审核结果：0：待审核，1：已审核，2：审核不通过
     *
     * @return AuditState - 审核结果：0：待审核，1：已审核，2：审核不通过
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核结果：0：待审核，1：已审核，2：审核不通过
     *
     * @param auditState 审核结果：0：待审核，1：已审核，2：审核不通过
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
     * 获取录入部门
     *
     * @return SetDeptname - 录入部门
     */
    public String getSetDeptname() {
        return setDeptname;
    }

    /**
     * 设置录入部门
     *
     * @param setDeptname 录入部门
     */
    public void setSetDeptname(String setDeptname) {
        this.setDeptname = setDeptname;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取违法行为类型
     *
     * @return IllegActType - 违法行为类型
     */
    public String getIllegActType() {
        return illegActType;
    }

    /**
     * 设置违法行为类型
     *
     * @param illegActType 违法行为类型
     */
    public void setIllegActType(String illegActType) {
        this.illegActType = illegActType;
    }

    /**
     * 获取行政处罚内容
     *
     * @return PenContent - 行政处罚内容
     */
    public String getPenContent() {
        return penContent;
    }

    /**
     * 设置行政处罚内容
     *
     * @param penContent 行政处罚内容
     */
    public void setPenContent(String penContent) {
        this.penContent = penContent;
    }

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}
    
	public String getPenDecIssDateFom(){
    	try {
			return DateUtil.dateToString(this.penDecIssDate, "yyyy年MM月dd日");
		} catch (Exception e) {
			return "";
		}
    }
}