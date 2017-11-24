/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.secnocreditsup.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 描述:    cs_exp_serious_crime_list 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年11月25日
 */
@Table(name = "cs_exp_serious_crime_list")
public class ExpSeriousCrimeList implements Serializable {
    /**
     * 自增主键ID
     */
    @Column(name = "id")
    private Integer id;

    /**
     * uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * SourceId
     */
    @Column(name = "SourceId")
    private String sourceId;
    
    /**
     * SourceId
     */
    @Column(name = "AddSecType")
    private String addSecType;
    
    
    /**
     * 主体身份代码
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
    @Column(name = "UniSCID")
    private String uniSCID;
    
    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date estDate;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 证件类型
     */
    @Column(name = "CerType")
    private String cerType;

    /**
     * 证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;
    
    /**
     * 登记机关部门名称
     */
    @Column(name = "DeptName")
    private String deptName;
    
    /**
     * 登记机关-上级机关名称
     */
    @Column(name = "DeptUpName")
    private String deptUpName;
    
    /**
     * 登记机关-同级人民法院
     */
    @Column(name = "DeptSameCourt")
    private String deptSameCourt;
    
    /**
     * 登记机关-同级人民政府
     */
    @Column(name = "DeptSameGov")
    private String deptSameGov;

    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 业务类型
     */
    @Column(name = "BusinessType")
    private String businessType;

    /**
     * 业务状态
     */
    @Column(name = "BusinessStatus")
    private String businessStatus;

    /**
     * 列入经营异常名录原因类型（中文名称）
     */
    @Column(name = "SpeCauseCN")
    private String speCauseCN;

    /**
     * 列入经营异常名录原因类型
     */
    @Column(name = "SpeCause")
    private String speCause;

    /**
     * 列入经营异常日期
     */
    @Column(name = "AbnTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date abnTime;

    /**
     * 列入决定机关
     */
    @Column(name = "DecOrg")
    private String decOrg;

    /**
     * 列入决定机关（中文名称）
     */
    @Column(name = "DecorgCN")
    private String decorgCN;

    /**
     * 处罚文号 如：浙杭上工商异入【2014】第0001号
     */
    @Column(name = "PenDecNo")
    private String penDecNo;

    /**
     * 异常届满日期
     */
    @Column(name = "ExpExpiredDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date expExpiredDate;

    /**
     * 异常届满前60日
     */
    @Column(name = "ExpExpiredBeforeDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date expExpiredBeforeDate;

    /**
     * 列入严违期限
     */
    @Column(name = "AddSecTerm")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date addSecTerm;

    /**
     * 列入严违日期
     */
    @Column(name = "AddSecDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date addSecDate;

    /**
     * 列入严违文号
     */
    @Column(name = "AddSecNo")
    private String addSecNo;
    
    /**
     * 列入严违年度
     */
    @Column(name = "Year")
    private Integer year;
    
    /**
     * 列入严违文号序号
     */
    @Column(name = "AddSecCountNo")
    private Integer addSecCountNo;
    
    /**
     * 列入严违依据数量
     */
    @Column(name = "AddSecBasedNum")
    private Integer addSecBasedNum;


    /**
     * 严违失信类型
     */
    @Column(name = "SecDishonestyType")
    private String secDishonestyType;

    /**
     * 严违届满延期0:无1:有
     */
    @Column(name = "SecExpiredDelay")
    private Integer secExpiredDelay;

    /**
     * 初审人部门
     */
    @Column(name = "FirstDept")
    private String firstDept;
    
    /**
     * 初审人部门
     */
    @Column(name = "FirstDeptName")
    private String firstDeptName;
    

    /**
     * 初审人员
     */
    @Column(name = "FirstName")
    private String firstName;

    /**
     * 初审日期
     */
    @Column(name = "Firstdate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date firstdate;

    /**
     * 初审意见
     */
    @Column(name = "FirstCheck")
    private String firstCheck;

    /**
     * 初审意见说明
     */
    @Column(name = "FirstOpin")
    private String firstOpin;

    /**
     * 审核人部门
     */
    @Column(name = "AuditDept")
    private String auditDept;
    
    /**
     * 审核人部门
     */
    @Column(name = "AuditDeptName")
    private String auditDeptName;

    /**
     * 审核人员
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date auditDate;

    /**
     * 审核意见
     */
    @Column(name = "AuditCheck")
    private String auditCheck;

    /**
     * 审核意见说明
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 申请人
     */
    @Column(name = "ApplyMan")
    private String applyMan;
    
    /**
     * 申请人意见
     */
    @Column(name = "ApplyCheck")
    private String applyCheck;

    /**
     * 申请人
     */
    @Column(name = "ApplyDept")
    private String applyDept;
    
    /**
     * 申请人
     */
    @Column(name = "ApplyDeptName")
    private String applyDeptName;
    
    /**
     * 列入严违机关编码
     */
    @Column(name = "AddSecOrgCode")
    private String addSecOrgCode;

    /**
     * 列入严违机关
     */
    @Column(name = "AddSecOrg")
    private String addSecOrg;
    
    /**
     * 列入严违原因
     */
    @NotBlank
    @Column(name = "AddSecCause")
    private String addSecCause;
    
    /**
     * 列入严违说明
     */
    @NotBlank
    @Column(name = "AddSecExplain")
    private String addSecExplain;

    /**
     * 申请日期
     */
    @Column(name = "ApplyDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date applyDate;

    /**
     * 公示状态 0:未认领1：已认领
     */
    @Column(name = "PublicState")
    private String publicState;

    /**
     * 提醒公告发布状态
     */
    @Column(name = "NoticeIssueState")
    private String noticeIssueState;

    /**
     * 提醒公告发布日期
     */
    @Column(name = "NoticeIssueDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date noticeIssueDate;

    /**
     * 严违公示日期
     */
    @Column(name = "SecPublicDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date secPublicDate;

    /**
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    private String regState;

    /**
     * 严违届满日期
     */
    @Column(name = "SecExpiredDate")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date secExpiredDate;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    
    /**
     * 异常届满公告日期
     */
    @Transient
    private Date secNoticeDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增主键ID
     *
     * @return id - 自增主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键ID
     *
     * @param id 自增主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取uuid
     *
     * @return UID - uuid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uuid
     *
     * @param UID uuid
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
     * @return UniSCID - 统一社会信用代码
     */
    public String getUniSCID() {
        return uniSCID;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniSCID 统一社会信用代码
     */
    public void setUniSCID(String uniSCID) {
        this.uniSCID = uniSCID;
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
     * 获取证件类型
     *
     * @return CerType - 证件类型
     */
    public String getCerType() {
        return cerType;
    }

    /**
     * 设置证件类型
     *
     * @param cerType 证件类型
     */
    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    /**
     * 获取证件号码
     *
     * @return CerNO - 证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置证件号码
     *
     * @param cerNO 证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
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
     * 获取属地监管工商所
     *
     * @return LocalAdm - 属地监管工商所
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置属地监管工商所
     *
     * @param localAdm 属地监管工商所
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取业务类型
     *
     * @return BusinessType - 业务类型
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务类型
     *
     * @param businessType 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取业务状态
     *
     * @return BusinessStatus - 业务状态
     */
    public String getBusinessStatus() {
        return businessStatus;
    }

    /**
     * 设置业务状态
     *
     * @param businessStatus 业务状态
     */
    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    /**
     * 获取列入经营异常名录原因类型（中文名称）
     *
     * @return SpeCauseCN - 列入经营异常名录原因类型（中文名称）
     */
    public String getSpeCauseCN() {
        return speCauseCN;
    }

    /**
     * 设置列入经营异常名录原因类型（中文名称）
     *
     * @param speCauseCN 列入经营异常名录原因类型（中文名称）
     */
    public void setSpeCauseCN(String speCauseCN) {
        this.speCauseCN = speCauseCN;
    }

    /**
     * 获取列入经营异常名录原因类型
     *
     * @return SpeCause - 列入经营异常名录原因类型
     */
    public String getSpeCause() {
        return speCause;
    }

    /**
     * 设置列入经营异常名录原因类型
     *
     * @param speCause 列入经营异常名录原因类型
     */
    public void setSpeCause(String speCause) {
        this.speCause = speCause;
    }

    /**
     * 获取列入经营异常日期
     *
     * @return AbnTime - 列入经营异常日期
     */
    public Date getAbnTime() {
        return abnTime;
    }

    /**
     * 设置列入经营异常日期
     *
     * @param abnTime 列入经营异常日期
     */
    public void setAbnTime(Date abnTime) {
        this.abnTime = abnTime;
    }

    /**
     * 获取列入决定机关
     *
     * @return DecOrg - 列入决定机关
     */
    public String getDecOrg() {
        return decOrg;
    }

    /**
     * 设置列入决定机关
     *
     * @param decOrg 列入决定机关
     */
    public void setDecOrg(String decOrg) {
        this.decOrg = decOrg;
    }

    /**
     * 获取列入决定机关（中文名称）
     *
     * @return DecorgCN - 列入决定机关（中文名称）
     */
    public String getDecorgCN() {
        return decorgCN;
    }

    /**
     * 设置列入决定机关（中文名称）
     *
     * @param decorgCN 列入决定机关（中文名称）
     */
    public void setDecorgCN(String decorgCN) {
        this.decorgCN = decorgCN;
    }

    /**
     * 获取处罚文号 如：浙杭上工商异入【2014】第0001号
     *
     * @return PenDecNo - 处罚文号 如：浙杭上工商异入【2014】第0001号
     */
    public String getPenDecNo() {
        return penDecNo;
    }

    /**
     * 设置处罚文号 如：浙杭上工商异入【2014】第0001号
     *
     * @param penDecNo 处罚文号 如：浙杭上工商异入【2014】第0001号
     */
    public void setPenDecNo(String penDecNo) {
        this.penDecNo = penDecNo;
    }

    /**
     * 获取异常届满日期
     *
     * @return ExpExpiredDate - 异常届满日期
     */
    public Date getExpExpiredDate() {
        return expExpiredDate;
    }

    /**
     * 设置异常届满日期
     *
     * @param expExpiredDate 异常届满日期
     */
    public void setExpExpiredDate(Date expExpiredDate) {
        this.expExpiredDate = expExpiredDate;
    }

    /**
     * 获取异常届满前60日
     *
     * @return ExpExpiredBeforeDate - 异常届满前60日
     */
    public Date getExpExpiredBeforeDate() {
        return expExpiredBeforeDate;
    }

    /**
     * 设置异常届满前60日
     *
     * @param expExpiredBeforeDate 异常届满前60日
     */
    public void setExpExpiredBeforeDate(Date expExpiredBeforeDate) {
        this.expExpiredBeforeDate = expExpiredBeforeDate;
    }

    /**
     * 获取列入严违期限
     *
     * @return AddSecTerm - 列入严违期限
     */
    public Date getAddSecTerm() {
        return addSecTerm;
    }

    /**
     * 设置列入严违期限
     *
     * @param addSecTerm 列入严违期限
     */
    public void setAddSecTerm(Date addSecTerm) {
        this.addSecTerm = addSecTerm;
    }

    /**
     * 获取列入严违日期
     *
     * @return AddSecDate - 列入严违日期
     */
    public Date getAddSecDate() {
        return addSecDate;
    }

    /**
     * 设置列入严违日期
     *
     * @param addSecDate 列入严违日期
     */
    public void setAddSecDate(Date addSecDate) {
        this.addSecDate = addSecDate;
    }

    /**
     * 获取列入严违文号
     *
     * @return AddSecNo - 列入严违文号
     */
    public String getAddSecNo() {
        return addSecNo;
    }

    /**
     * 设置列入严违文号
     *
     * @param addSecNo 列入严违文号
     */
    public void setAddSecNo(String addSecNo) {
        this.addSecNo = addSecNo;
    }

    /**
     * 获取严违失信类型
     *
     * @return SecDishonestyType - 严违失信类型
     */
    public String getSecDishonestyType() {
        return secDishonestyType;
    }

    /**
     * 设置严违失信类型
     *
     * @param secDishonestyType 严违失信类型
     */
    public void setSecDishonestyType(String secDishonestyType) {
        this.secDishonestyType = secDishonestyType;
    }

    /**
     * 获取严违届满延期0:无1:有
     *
     * @return SecExpiredDelay - 严违届满延期0:无1:有
     */
    public Integer getSecExpiredDelay() {
        return secExpiredDelay;
    }

    /**
     * 设置严违届满延期0:无1:有
     *
     * @param secExpiredDelay 严违届满延期0:无1:有
     */
    public void setSecExpiredDelay(Integer secExpiredDelay) {
        this.secExpiredDelay = secExpiredDelay;
    }

    /**
     * 获取初审人部门
     *
     * @return FirstDept - 初审人部门
     */
    public String getFirstDept() {
        return firstDept;
    }

    /**
     * 设置初审人部门
     *
     * @param firstDept 初审人部门
     */
    public void setFirstDept(String firstDept) {
        this.firstDept = firstDept;
    }

    /**
     * 获取初审人员
     *
     * @return FirstName - 初审人员
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置初审人员
     *
     * @param firstName 初审人员
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 获取初审日期
     *
     * @return Firstdate - 初审日期
     */
    public Date getFirstdate() {
        return firstdate;
    }

    /**
     * 设置初审日期
     *
     * @param firstdate 初审日期
     */
    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    /**
     * 获取初审意见
     *
     * @return FirstCheck - 初审意见
     */
    public String getFirstCheck() {
        return firstCheck;
    }

    /**
     * 设置初审意见
     *
     * @param firstCheck 初审意见
     */
    public void setFirstCheck(String firstCheck) {
        this.firstCheck = firstCheck;
    }

    /**
     * 获取初审意见说明
     *
     * @return FirstOpin - 初审意见说明
     */
    public String getFirstOpin() {
        return firstOpin;
    }

    /**
     * 设置初审意见说明
     *
     * @param firstOpin 初审意见说明
     */
    public void setFirstOpin(String firstOpin) {
        this.firstOpin = firstOpin;
    }

    /**
     * 获取审核人部门
     *
     * @return AuditDept - 审核人部门
     */
    public String getAuditDept() {
        return auditDept;
    }

    /**
     * 设置审核人部门
     *
     * @param auditDept 审核人部门
     */
    public void setAuditDept(String auditDept) {
        this.auditDept = auditDept;
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
     * 获取审核意见
     *
     * @return AuditCheck - 审核意见
     */
    public String getAuditCheck() {
        return auditCheck;
    }

    /**
     * 设置审核意见
     *
     * @param auditCheck 审核意见
     */
    public void setAuditCheck(String auditCheck) {
        this.auditCheck = auditCheck;
    }

    /**
     * 获取审核意见说明
     *
     * @return AuditOpin - 审核意见说明
     */
    public String getAuditOpin() {
        return auditOpin;
    }

    /**
     * 设置审核意见说明
     *
     * @param auditOpin 审核意见说明
     */
    public void setAuditOpin(String auditOpin) {
        this.auditOpin = auditOpin;
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
     * 获取列入严违机关编码
     *
     * @return AddSecOrgCode - 列入严违机关编码
     */
    public String getAddSecOrgCode() {
        return addSecOrgCode;
    }

    /**
     * 设置列入严违机关编码
     *
     * @param addSecOrgCode 列入严违机关编码
     */
    public void setAddSecOrgCode(String addSecOrgCode) {
        this.addSecOrgCode = addSecOrgCode;
    }

    /**
     * 获取列入严违机关
     *
     * @return AddSecOrg - 列入严违机关
     */
    public String getAddSecOrg() {
        return addSecOrg;
    }

    /**
     * 设置列入严违机关
     *
     * @param addSecOrg 列入严违机关
     */
    public void setAddSecOrg(String addSecOrg) {
        this.addSecOrg = addSecOrg;
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
     * 获取公示状态
     *
     * @return PublicState - 公示状态
     */
    public String getPublicState() {
        return publicState;
    }

    /**
     * 设置公示状态
     *
     * @param publicState 公示状态
     */
    public void setPublicState(String publicState) {
        this.publicState = publicState;
    }

    /**
     * 获取提醒公告发布状态
     *
     * @return NoticeIssueState - 提醒公告发布状态
     */
    public String getNoticeIssueState() {
        return noticeIssueState;
    }

    /**
     * 设置提醒公告发布状态
     *
     * @param noticeIssueState 提醒公告发布状态
     */
    public void setNoticeIssueState(String noticeIssueState) {
        this.noticeIssueState = noticeIssueState;
    }

    /**
     * 获取提醒公告发布日期
     *
     * @return NoticeIssueDate - 提醒公告发布日期
     */
    public Date getNoticeIssueDate() {
        return noticeIssueDate;
    }

    /**
     * 设置提醒公告发布日期
     *
     * @param noticeIssueDate 提醒公告发布日期
     */
    public void setNoticeIssueDate(Date noticeIssueDate) {
        this.noticeIssueDate = noticeIssueDate;
    }

    /**
     * 获取严违公示日期
     *
     * @return SecPublicDate - 严违公示日期
     */
    public Date getSecPublicDate() {
        return secPublicDate;
    }

    /**
     * 设置严违公示日期
     *
     * @param secPublicDate 严违公示日期
     */
    public void setSecPublicDate(Date secPublicDate) {
        this.secPublicDate = secPublicDate;
    }

    /**
     * 获取登记状态(CA19)
     *
     * @return RegState - 登记状态(CA19)
     */
    public String getRegState() {
        return regState;
    }

    /**
     * 设置登记状态(CA19)
     *
     * @param regState 登记状态(CA19)
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * 获取严违届满日期
     *
     * @return SecExpiredDate - 严违届满日期
     */
    public Date getSecExpiredDate() {
        return secExpiredDate;
    }

    /**
     * 设置严违届满日期
     *
     * @param secExpiredDate 严违届满日期
     */
    public void setSecExpiredDate(Date secExpiredDate) {
        this.secExpiredDate = secExpiredDate;
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

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getAddSecCause() {
		return addSecCause;
	}

	public void setAddSecCause(String addSecCause) {
		this.addSecCause = addSecCause;
	}

	public String getAddSecExplain() {
		return addSecExplain;
	}

	public void setAddSecExplain(String addSecExplain) {
		this.addSecExplain = addSecExplain;
	}

	public String getAddSecType() {
		return addSecType;
	}

	public void setAddSecType(String addSecType) {
		this.addSecType = addSecType;
	}

	public Integer getAddSecBasedNum() {
		return addSecBasedNum;
	}

	public void setAddSecBasedNum(Integer addSecBasedNum) {
		this.addSecBasedNum = addSecBasedNum;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getAddSecCountNo() {
		return addSecCountNo;
	}

	public void setAddSecCountNo(Integer addSecCountNo) {
		this.addSecCountNo = addSecCountNo;
	}

	public String getFirstDeptName() {
		return firstDeptName;
	}

	public void setFirstDeptName(String firstDeptName) {
		this.firstDeptName = firstDeptName;
	}

	public String getAuditDeptName() {
		return auditDeptName;
	}

	public void setAuditDeptName(String auditDeptName) {
		this.auditDeptName = auditDeptName;
	}

	public String getApplyDept() {
		return applyDept;
	}

	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}

	public String getApplyDeptName() {
		return applyDeptName;
	}

	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptUpName() {
		return deptUpName;
	}

	public void setDeptUpName(String deptUpName) {
		this.deptUpName = deptUpName;
	}

	public String getDeptSameCourt() {
		return deptSameCourt;
	}

	public void setDeptSameCourt(String deptSameCourt) {
		this.deptSameCourt = deptSameCourt;
	}

	public String getDeptSameGov() {
		return deptSameGov;
	}

	public void setDeptSameGov(String deptSameGov) {
		this.deptSameGov = deptSameGov;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	
	public String getApplyCheck() {
		return applyCheck;
	}

	public void setApplyCheck(String applyCheck) {
		this.applyCheck = applyCheck;
	}

	public String getBusinessTypeDesc() {
		if (businessType != null && businessType.equals("1")) {
			return "提醒公告";
		} else if (businessType != null && businessType.equals("2")) {
			return "列入";
		} else if (businessType != null && businessType.equals("3")) {
			return "届满移出";
		} else if (businessType != null && businessType.equals("4")) {
			return "届满延期";
		} else if (businessType != null && businessType.equals("5")) {
			return "更正移出";
		}
		return businessType;
	}

	public Date getSecNoticeDate() {
		if(abnTime==null)return abnTime;
		return DateUtil.getNdaylaterDate(DateUtil.getyearlaterDateObject(abnTime, 3),-60);
	}

	public void setSecNoticeDate(Date secNoticeDate) {
		this.secNoticeDate = secNoticeDate;
	}

}