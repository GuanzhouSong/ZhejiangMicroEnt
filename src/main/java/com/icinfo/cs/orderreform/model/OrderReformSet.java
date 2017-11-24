/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.orderreform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_orderreform_set 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月07日
 */
@Table(name = "cs_orderreform_set")
public class OrderReformSet implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 随机UUID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 注册号
     */
    @Column(name = "RegNo")
    private String regNo;

    /**
     * 统一代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

    /**
     * 营运状况
     */
    @Column(name = "BusSt")
    private String busSt;

    /**
     * 营运状况中文
     */
    @Column(name = "BusStatusCN")
    private String busStatusCN;

    /**
     * 行业代码
     */
    @Column(name = "IndustryCo")
    private String industryCo;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;
    
    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;
    
    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;
    
    @Column(name = "PenDecNo")
    private String penDecNo;

    /**
     * 年报状态
     */
    @Column(name = "ReportState")
    private String reportState;

    /**
     * 申请人
     */
    @Column(name = "ApplyMan")
    private String applyMan;

    /**
     * 申请日期
     */
    @Column(name = "ApplyDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date applyDate;

    /**
     * 提示状态：0无效1有效2流程中
     */
    @Column(name = "EfftStatus")
    private String efftStatus;

    /**
     * 审核状态 0未审核1同意责令整改2退回修改3取消责令整改4中止
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 责令整改类型
     */
    @Column(name = "AdminGuideType")
    private String adminGuideType;

    /**
     * 责令整改通知书(类型)
     */
    @Column(name = "AdminGuideDocType")
    private String adminGuideDocType;

    /**
     * 开始日期
     */
    @Column(name = "StaDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date staDate;

    /**
     * 结束日期
     */
    @Column(name = "EndDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

    /**
     * 联系人
     */
    @Column(name = "LinkMan")
    private String linkMan;

    /**
     * 联系电话
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 下达日期
     */
    @Column(name = "AssignDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date assignDate;

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
     * 审核意见
     */
    @Column(name = "AuditRemark")
    private String auditRemark;

    /**
     * 是否中止
     */
    @Column(name = "IsAbort")
    private String isAbort;

    /**
     * 中止说明
     */
    @Column(name = "SusRemark")
    private String susRemark;

    /**
     * 中止日期
     */
    @Column(name = "SusDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date susDate;

    /**
     * 中止人
     */
    @Column(name = "ApplySusMan")
    private String applySusMan;

    /**
     * 申请中止日期
     */
    @Column(name = "ApplySusDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date applySusDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 责令整改内容
     */
    @Column(name = "AdminGuideCerContent")
    private String adminGuideCerContent;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取随机UUID
     *
     * @return UID - 随机UUID
     */
    public String getUid() {
		return uid;
	}

    /**
     * 设置随机UUID
     *
     * @param UID 随机UUID
     */
    public void setUid(String uid) {
		this.uid = uid;
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
     * 获取注册号
     *
     * @return RegNo - 注册号
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * 设置注册号
     *
     * @param regNo 注册号
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * 获取统一代码
     *
     * @return UniSCID - 统一代码
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * 设置统一代码
     *
     * @param uniSCID 统一代码
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
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
     * 获取企业类型
     *
     * @return EntType - 企业类型
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置企业类型
     *
     * @param entType 企业类型
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * 获取营运状况
     *
     * @return BusSt - 营运状况
     */
    public String getBusSt() {
        return busSt;
    }

    /**
     * 设置营运状况
     *
     * @param busSt 营运状况
     */
    public void setBusSt(String busSt) {
        this.busSt = busSt;
    }

    /**
     * 获取营运状况中文
     *
     * @return BusStatusCN - 营运状况中文
     */
    public String getBusStatusCN() {
        return busStatusCN;
    }

    /**
     * 设置营运状况中文
     *
     * @param busStatusCN 营运状况中文
     */
    public void setBusStatusCN(String busStatusCN) {
        this.busStatusCN = busStatusCN;
    }

    /**
     * 获取行业代码
     *
     * @return IndustryCo - 行业代码
     */
    public String getIndustryCo() {
        return industryCo;
    }

    /**
     * 设置行业代码
     *
     * @param industryCo 行业代码
     */
    public void setIndustryCo(String industryCo) {
        this.industryCo = industryCo;
    }

    /**
     * 获取登记机关
     *
     * @return RegOrg - 登记机关
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关
     *
     * @param regOrg 登记机关
     */
    public void setRegOrg(String regOrg) {
        this.regOrg = regOrg;
    }

    /**
     * 获取登记机关名称
     *
     * @return RegOrgName - 登记机关名称
     */
    public String getRegOrgName() {
        return regOrgName;
    }

    /**
     * 设置登记机关名称
     *
     * @param regOrgName 登记机关名称
     */
    public void setRegOrgName(String regOrgName) {
        this.regOrgName = regOrgName;
    }

    /**
     * 获取法定代表人
     *
     * @return LeRep - 法定代表人
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法定代表人
     *
     * @param leRep 法定代表人
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取年报年度
     *
     * @return Year - 年报年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年报年度
     *
     * @param year 年报年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取年报状态
     *
     * @return ReportState - 年报状态
     */
    public String getReportState() {
        return reportState;
    }

    /**
     * 设置年报状态
     *
     * @param reportState 年报状态
     */
    public void setReportState(String reportState) {
        this.reportState = reportState;
    }

    /**
     * 获取申请人
     *
     * @return ApplyMan - 申请人
     */
    public String getApplyMan() {
        return applyMan;
    }

    /**
     * 设置申请人
     *
     * @param applyMan 申请人
     */
    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    /**
     * 获取申请日期
     *
     * @return ApplyDate - 申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请日期
     *
     * @param applyDate 申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取提示状态：0无效1有效2流程中
     *
     * @return EfftStatus - 提示状态：0无效1有效2流程中
     */
    public String getEfftStatus() {
        return efftStatus;
    }

    /**
     * 设置提示状态：0无效1有效2流程中
     *
     * @param efftStatus 提示状态：0无效1有效2流程中
     */
    public void setEfftStatus(String efftStatus) {
        this.efftStatus = efftStatus;
    }

    /**
     * 获取审核状态 0未审核1同意责令整改2退回修改3取消责令整改4中止
     *
     * @return AuditState - 审核状态 0未审核1同意责令整改2退回修改3取消责令整改4中止
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核状态 0未审核1同意责令整改2退回修改3取消责令整改4中止
     *
     * @param auditState 审核状态 0未审核1同意责令整改2退回修改3取消责令整改4中止
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取责令整改类型
     *
     * @return AdminGuideType - 责令整改类型
     */
    public String getAdminGuideType() {
        return adminGuideType;
    }

    /**
     * 设置责令整改类型
     *
     * @param adminGuideType 责令整改类型
     */
    public void setAdminGuideType(String adminGuideType) {
        this.adminGuideType = adminGuideType;
    }

    /**
     * 获取责令整改通知书(类型)
     *
     * @return AdminGuideDocType - 责令整改通知书(类型)
     */
    public String getAdminGuideDocType() {
        return adminGuideDocType;
    }

    /**
     * 设置责令整改通知书(类型)
     *
     * @param adminGuideDocType 责令整改通知书(类型)
     */
    public void setAdminGuideDocType(String adminGuideDocType) {
        this.adminGuideDocType = adminGuideDocType;
    }

    /**
     * 获取开始日期
     *
     * @return StaDate - 开始日期
     */
    public Date getStaDate() {
        return staDate;
    }

    /**
     * 设置开始日期
     *
     * @param staDate 开始日期
     */
    public void setStaDate(Date staDate) {
        this.staDate = staDate;
    }

    /**
     * 获取结束日期
     *
     * @return EndDate - 结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束日期
     *
     * @param endDate 结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取联系人
     *
     * @return LinkMan - 联系人
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * 设置联系人
     *
     * @param linkMan 联系人
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    /**
     * 获取联系电话
     *
     * @return Tel - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取下达日期
     *
     * @return AssignDate - 下达日期
     */
    public Date getAssignDate() {
        return assignDate;
    }

    /**
     * 设置下达日期
     *
     * @param assignDate 下达日期
     */
    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
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
     * 获取审核意见
     *
     * @return AuditRemark - 审核意见
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * 设置审核意见
     *
     * @param auditRemark 审核意见
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    /**
     * 获取是否中止
     *
     * @return IsAbort - 是否中止
     */
    public String getIsAbort() {
        return isAbort;
    }

    /**
     * 设置是否中止
     *
     * @param isAbort 是否中止
     */
    public void setIsAbort(String isAbort) {
        this.isAbort = isAbort;
    }

    /**
     * 获取中止说明
     *
     * @return SusRemark - 中止说明
     */
    public String getSusRemark() {
        return susRemark;
    }

    /**
     * 设置中止说明
     *
     * @param susRemark 中止说明
     */
    public void setSusRemark(String susRemark) {
        this.susRemark = susRemark;
    }

    /**
     * 获取中止日期
     *
     * @return SusDate - 中止日期
     */
    public Date getSusDate() {
        return susDate;
    }

    /**
     * 设置中止日期
     *
     * @param susDate 中止日期
     */
    public void setSusDate(Date susDate) {
        this.susDate = susDate;
    }

    /**
     * 获取中止人
     *
     * @return ApplySusMan - 中止人
     */
    public String getApplySusMan() {
        return applySusMan;
    }

    /**
     * 设置中止人
     *
     * @param applySusMan 中止人
     */
    public void setApplySusMan(String applySusMan) {
        this.applySusMan = applySusMan;
    }

    /**
     * 获取申请中止日期
     *
     * @return ApplySusDate - 申请中止日期
     */
    public Date getApplySusDate() {
        return applySusDate;
    }

    /**
     * 设置申请中止日期
     *
     * @param applySusDate 申请中止日期
     */
    public void setApplySusDate(Date applySusDate) {
        this.applySusDate = applySusDate;
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
     * 获取责令整改内容
     *
     * @return AdminGuideCerContent - 责令整改内容
     */
    public String getAdminGuideCerContent() {
        return adminGuideCerContent;
    }

    /**
     * 设置责令整改内容
     *
     * @param adminGuideCerContent 责令整改内容
     */
    public void setAdminGuideCerContent(String adminGuideCerContent) {
        this.adminGuideCerContent = adminGuideCerContent;
    }

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getPenDecNo() {
		return penDecNo;
	}

	public void setPenDecNo(String penDecNo) {
		this.penDecNo = penDecNo;
	} 
}