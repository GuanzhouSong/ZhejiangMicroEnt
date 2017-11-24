/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.casesource.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_case_source_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年11月23日
 */
@Table(name = "cs_case_source_info")
public class CaseSourceInfo implements Serializable {
	
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 唯一标识
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 案源名称
     */
    @Column(name = "CaseName")
    private String caseName;

    /**
     * 举报人姓名
     */
    @Column(name = "ReporterName")
    private String reporterName;

    /**
     * 举报人电话号码
     */
    @Column(name = "ReporterTel")
    private String reporterTel;

    /**
     * 举报人证件号码
     */
    @Column(name = "ReporterCard")
    private String reporterCard;

    /**
     * 举报时间
     */
    @Column(name = "ReportTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportTime;
    
    /**
     * 状态
     */
    @Column(name = "CaseState")
    private String caseState;

    /**
     * 受理人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 受理时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date setTime;

    /**
     * 受理部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 受理部门名称
     */
    @Column(name = "SetDeptName")
    private String setDeptName;

    /**
     * 举报内容
     */
    @Column(name = "ReportContent")
    private String reportContent;

    /**
     * 受理意见
     */
    @Column(name = "SetOpinion")
    private String setOpinion;

    /**
     * 备注
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
     * 获取主体代码
     *
     * @return PriPID - 主体代码
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体代码
     *
     * @param priPID 主体代码
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
     * 获取注册号
     *
     * @return RegNO - 注册号
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号
     *
     * @param regNO 注册号
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UniCode - 统一社会信用代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniCode 统一社会信用代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取案源名称
     *
     * @return CaseName - 案源名称
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * 设置案源名称
     *
     * @param caseName 案源名称
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * 获取举报人姓名
     *
     * @return ReporterName - 举报人姓名
     */
    public String getReporterName() {
        return reporterName;
    }

    /**
     * 设置举报人姓名
     *
     * @param reporterName 举报人姓名
     */
    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    /**
     * 获取举报人电话号码
     *
     * @return ReporterTel - 举报人电话号码
     */
    public String getReporterTel() {
        return reporterTel;
    }

    /**
     * 设置举报人电话号码
     *
     * @param reporterTel 举报人电话号码
     */
    public void setReporterTel(String reporterTel) {
        this.reporterTel = reporterTel;
    }

    /**
     * 获取举报人证件号码
     *
     * @return ReporterCard - 举报人证件号码
     */
    public String getReporterCard() {
        return reporterCard;
    }

    /**
     * 设置举报人证件号码
     *
     * @param reporterCard 举报人证件号码
     */
    public void setReporterCard(String reporterCard) {
        this.reporterCard = reporterCard;
    }

    /**
     * 获取举报时间
     *
     * @return ReportTime - 举报时间
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * 设置举报时间
     *
     * @param reportTime 举报时间
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取受理人
     *
     * @return SetName - 受理人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置受理人
     *
     * @param setName 受理人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取受理时间
     *
     * @return SetTime - 受理时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置受理时间
     *
     * @param setTime 受理时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取受理部门编码
     *
     * @return SetDeptCode - 受理部门编码
     */
    public String getSetDeptCode() {
        return setDeptCode;
    }

    /**
     * 设置受理部门编码
     *
     * @param setDeptCode 受理部门编码
     */
    public void setSetDeptCode(String setDeptCode) {
        this.setDeptCode = setDeptCode;
    }

    /**
     * 获取受理部门名称
     *
     * @return SetDeptName - 受理部门名称
     */
    public String getSetDeptName() {
        return setDeptName;
    }

    /**
     * 设置受理部门名称
     *
     * @param setDeptName 受理部门名称
     */
    public void setSetDeptName(String setDeptName) {
        this.setDeptName = setDeptName;
    }

    /**
     * 获取举报内容
     *
     * @return ReportContent - 举报内容
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * 设置举报内容
     *
     * @param reportContent 举报内容
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    /**
     * 获取受理意见
     *
     * @return SetOpinion - 受理意见
     */
    public String getSetOpinion() {
        return setOpinion;
    }

    /**
     * 设置受理意见
     *
     * @param setOpinion 受理意见
     */
    public void setSetOpinion(String setOpinion) {
        this.setOpinion = setOpinion;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getCaseState() {
		return caseState;
	}

	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}
     
    
}