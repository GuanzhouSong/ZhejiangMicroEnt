/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_pb_baseinfo_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月28日
 */
@Table(name = "cs_pb_baseinfo_his")
public class PbBaseinfoHis implements Serializable {
    @Column(name = "id")
    private Integer id;

    /**
     * 主体代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 名称
     */
    @Column(name = "TraName")
    private String traName;

    /**
     * 从业人数
     */
    @Column(name = "EmpNum")
    private Integer empNum;

    /**
     * 资金数额
     */
    @Column(name = "FundAm")
    private BigDecimal fundAm;

    /**
     * 纳税总额
     */
    @Column(name = "RatGro")
    private BigDecimal ratGro;

    /**
     * 营业总收入是否公示
     */
    @Column(name = "VendIncIsPub")
    private String vendIncIsPub;

    /**
     * 统一代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 经营者姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 经营者联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 营业额或营业收入
     */
    @Column(name = "VendInc")
    private BigDecimal vendInc;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 纳税总额是否公示
     */
    @Column(name = "RatGroIsPub")
    private String ratGroIsPub;

    /**
     * 年报时间
     */
    @Column(name = "AncheDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ancheDate;

    /**
     * 最新年报时间
     */
    @Column(name = "LastReportTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 
    private Date lastReportTime;

    /**
     * 年报提交编号
     */
    @Column(name = "ReportNo")
    private String reportNo;
    
    /**
     * 敏感词审核结果 0-不通过 1-通过
     */
    @Column(name = "AuditState")
    private String auditState;
    
    /**
     * 审核意见
     */
    @Column(name = "AuditOpinion")
    private String auditOpinion;
    
    /**
     * 审核人姓名
     */
    @Column(name = "AuditUser")
    private String auditUser;
    
    /**
     * 审核时间
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditDate;


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
     * 获取名称
     *
     * @return TraName - 名称
     */
    public String getTraName() {
        return traName;
    }

    /**
     * 设置名称
     *
     * @param traName 名称
     */
    public void setTraName(String traName) {
        this.traName = traName;
    }

    /**
     * 获取从业人数
     *
     * @return EmpNum - 从业人数
     */
    public Integer getEmpNum() {
        return empNum;
    }

    /**
     * 设置从业人数
     *
     * @param empNum 从业人数
     */
    public void setEmpNum(Integer empNum) {
        this.empNum = empNum;
    }

    /**
     * 获取资金数额
     *
     * @return FundAm - 资金数额
     */
    public BigDecimal getFundAm() {
        return fundAm;
    }

    /**
     * 设置资金数额
     *
     * @param fundAm 资金数额
     */
    public void setFundAm(BigDecimal fundAm) {
        this.fundAm = fundAm;
    }

    /**
     * 获取纳税总额
     *
     * @return RatGro - 纳税总额
     */
    public BigDecimal getRatGro() {
        return ratGro;
    }

    /**
     * 设置纳税总额
     *
     * @param ratGro 纳税总额
     */
    public void setRatGro(BigDecimal ratGro) {
        this.ratGro = ratGro;
    }

    /**
     * 获取营业总收入是否公示
     *
     * @return VendIncIsPub - 营业总收入是否公示
     */
    public String getVendIncIsPub() {
        return vendIncIsPub;
    }

    /**
     * 设置营业总收入是否公示
     *
     * @param vendIncIsPub 营业总收入是否公示
     */
    public void setVendIncIsPub(String vendIncIsPub) {
        this.vendIncIsPub = vendIncIsPub;
    }

    /**
     * 获取统一代码
     *
     * @return UniCode - 统一代码
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一代码
     *
     * @param uniCode 统一代码
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取经营者姓名
     *
     * @return Name - 经营者姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置经营者姓名
     *
     * @param name 经营者姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取经营者联系电话
     *
     * @return Tel - 经营者联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置经营者联系电话
     *
     * @param tel 经营者联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取年份
     *
     * @return Year - 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取营业额或营业收入
     *
     * @return VendInc - 营业额或营业收入
     */
    public BigDecimal getVendInc() {
        return vendInc;
    }

    /**
     * 设置营业额或营业收入
     *
     * @param vendInc 营业额或营业收入
     */
    public void setVendInc(BigDecimal vendInc) {
        this.vendInc = vendInc;
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

    /**
     * 获取年报ID
     *
     * @return AnCheID - 年报ID
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报ID
     *
     * @param anCheID 年报ID
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }

    /**
     * 获取纳税总额是否公示
     *
     * @return RatGroIsPub - 纳税总额是否公示
     */
    public String getRatGroIsPub() {
        return ratGroIsPub;
    }

    /**
     * 设置纳税总额是否公示
     *
     * @param ratGroIsPub 纳税总额是否公示
     */
    public void setRatGroIsPub(String ratGroIsPub) {
        this.ratGroIsPub = ratGroIsPub;
    }

    /**
     * 获取年报时间
     *
     * @return AnCheDate - 年报时间
     */
    public Date getAncheDate() {
        return ancheDate;
    }

    /**
     * 设置年报时间
     *
     * @param anCheDate 年报时间
     */
    public void setAncheDate(Date ancheDate) {
        this.ancheDate = ancheDate;
    }

    /**
     * 获取最新年报时间
     *
     * @return LastReportTime - 最新年报时间
     */
    public Date getLastReportTime() {
        return lastReportTime;
    }

    /**
     * 设置最新年报时间
     *
     * @param lastReportTime 最新年报时间
     */
    public void setLastReportTime(Date lastReportTime) {
        this.lastReportTime = lastReportTime;
    }

    /**
     * 获取年报提交编号
     *
     * @return ReportNo - 年报提交编号
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * 设置年报提交编号
     *
     * @param reportNo 年报提交编号
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getAuditOpinion() {
		return auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

    
}