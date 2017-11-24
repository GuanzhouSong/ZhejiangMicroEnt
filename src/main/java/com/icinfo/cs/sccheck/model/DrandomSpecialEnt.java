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
 * 描述:    cs_drandom_special_ent 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年09月13日
 */
@Table(name = "cs_drandom_special_ent")
public class DrandomSpecialEnt implements Serializable {
    /**
     * 序号
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Column(name = "Uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 职能部门编码
     */
    @Column(name = "DutyDeptCode")
    private String dutyDeptCode;

    /**
     * 职能部门名称
     */
    @Column(name = "DutyDeptName")
    private String dutyDeptName;

    /**
     * 专项库编码
     */
    @Column(name = "SpecialCode")
    private String specialCode;

    /**
     * 专项库名称
     */
    @Column(name = "SpecialName")
    private String specialName;

    /**
     * 标签编码
     */
    @Column(name = "MarkCode")
    private String markCode;

    /**
     * 标签名称
     */
    @Column(name = "MarkName")
    private String markName;

    /**
     * 注册号(CA15)
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 统一社会信用代码(CA91)
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 主体身份代码(CA14)
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 市场主体类型大类
     */
    @Column(name = "EntTypeCatg")
    private String entTypeCatg;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 属地监管工商所
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 登记机关名称
     */
    @Column(name = "RegOrgName")
    private String regOrgName;

    /**
     * 属地监管工商所名称
     */
    @Column(name = "LocalAdmName")
    private String localAdmName;

    /**
     * 成立日期
     */
    @Column(name = "EstDate")
    private Date estDate;

    /**
     * 登记状态(CA19)
     */
    @Column(name = "RegState")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String regState;

    /**
     * 法定代表人
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 检查机关编码
     */
    @Column(name = "CheckDeptCode")
    private String checkDeptCode;

    /**
     * 检查部门描述
     */
    @Column(name = "CheckDeptName")
    private String checkDeptName;
    
    /**
     * 地址
     */
    @Column(name = "Dom")
    private String dom;
    
    /**
     * 经营范围
     */
    @Column(name = "OpScope")
    private String opScope;

    /**
     * 组织机构代码
     */
    @Column(name = "OrganizationNO")
    private String organizationNO;

    /**
     * 主体类别
     */
    @Column(name = "SubjectType")
    private String subjectType;

    /**
     * 创建日期
     */
    @Column(name = "CreatTime")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date creatTime;

    /**
     * 设置人UId
     */
    @Column(name = "SetUserUid")
    private String setUserUid;

    /**
     * 设置人姓名
     */
    @Column(name = "SetUserName")
    private String setUserName;

    /**
     * 设置部门编码
     */
    @Column(name = "SetDeptCode")
    private String setDeptCode;

    /**
     * 许可证名称
     */
    @Column(name = "LicName")
    private String licName;

    /**
     * 许可证编号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 许可证核准日期
     */
    @Column(name = "LicApprDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date licApprDate;

    /**
     * 许可证有效截止日期
     */
    @Column(name = "LicSaveEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date licSaveEndDate;

    /**
     * 许可证发证机关
     */
    @Column(name = "LicSendDeptCode")
    private String licSendDeptCode;

    /**
     * 许可证发证机关描述
     */
    @Column(name = "LicSendDeptName")
    private String licSendDeptName;
    
    /**
     * 是否有效
     */
    @Column(name = "IsVlid")
    private String isVlid;

    private static final long serialVersionUID = 1L;

    /**
     * 获取序号
     *
     * @return id - 序号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置序号
     *
     * @param id 序号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取uid
     *
     * @return Uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取职能部门编码
     *
     * @return DutyDeptCode - 职能部门编码
     */
    public String getDutyDeptCode() {
        return dutyDeptCode;
    }

    /**
     * 设置职能部门编码
     *
     * @param dutyDeptCode 职能部门编码
     */
    public void setDutyDeptCode(String dutyDeptCode) {
        this.dutyDeptCode = dutyDeptCode;
    }

    /**
     * 获取职能部门名称
     *
     * @return DutyDeptName - 职能部门名称
     */
    public String getDutyDeptName() {
        return dutyDeptName;
    }

    /**
     * 设置职能部门名称
     *
     * @param dutyDeptName 职能部门名称
     */
    public void setDutyDeptName(String dutyDeptName) {
        this.dutyDeptName = dutyDeptName;
    }

    /**
     * 获取专项库编码
     *
     * @return SpecialCode - 专项库编码
     */
    public String getSpecialCode() {
        return specialCode;
    }

    /**
     * 设置专项库编码
     *
     * @param specialCode 专项库编码
     */
    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    /**
     * 获取专项库名称
     *
     * @return SpecialName - 专项库名称
     */
    public String getSpecialName() {
        return specialName;
    }

    /**
     * 设置专项库名称
     *
     * @param specialName 专项库名称
     */
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    /**
     * 获取标签编码
     *
     * @return MarkCode - 标签编码
     */
    public String getMarkCode() {
        return markCode;
    }

    /**
     * 设置标签编码
     *
     * @param markCode 标签编码
     */
    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    /**
     * 获取标签名称
     *
     * @return MarkName - 标签名称
     */
    public String getMarkName() {
        return markName;
    }

    /**
     * 设置标签名称
     *
     * @param markName 标签名称
     */
    public void setMarkName(String markName) {
        this.markName = markName;
    }

    /**
     * 获取注册号(CA15)
     *
     * @return RegNO - 注册号(CA15)
     */
    public String getRegNO() {
        return regNO;
    }

    /**
     * 设置注册号(CA15)
     *
     * @param regNO 注册号(CA15)
     */
    public void setRegNO(String regNO) {
        this.regNO = regNO;
    }

    /**
     * 获取统一社会信用代码(CA91)
     *
     * @return UniCode - 统一社会信用代码(CA91)
     */
    public String getUniCode() {
        return uniCode;
    }

    /**
     * 设置统一社会信用代码(CA91)
     *
     * @param uniCode 统一社会信用代码(CA91)
     */
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    /**
     * 获取主体身份代码(CA14)
     *
     * @return PriPID - 主体身份代码(CA14)
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码(CA14)
     *
     * @param priPID 主体身份代码(CA14)
     */
    public void setPriPID(String priPID) {
        this.priPID = priPID;
    }

    /**
     * 获取企业(机构)名称
     *
     * @return EntName - 企业(机构)名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业(机构)名称
     *
     * @param entName 企业(机构)名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取市场主体类型大类
     *
     * @return EntTypeCatg - 市场主体类型大类
     */
    public String getEntTypeCatg() {
        return entTypeCatg;
    }

    /**
     * 设置市场主体类型大类
     *
     * @param entTypeCatg 市场主体类型大类
     */
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }

    /**
     * 获取登记机关(CA11)
     *
     * @return RegOrg - 登记机关(CA11)
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * 设置登记机关(CA11)
     *
     * @param regOrg 登记机关(CA11)
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
     * 获取属地监管工商所名称
     *
     * @return LocalAdmName - 属地监管工商所名称
     */
    public String getLocalAdmName() {
        return localAdmName;
    }

    /**
     * 设置属地监管工商所名称
     *
     * @param localAdmName 属地监管工商所名称
     */
    public void setLocalAdmName(String localAdmName) {
        this.localAdmName = localAdmName;
    }

    /**
     * 获取成立日期
     *
     * @return EstDate - 成立日期
     */
    public Date getEstDate() {
        return estDate;
    }

    /**
     * 设置成立日期
     *
     * @param estDate 成立日期
     */
    public void setEstDate(Date estDate) {
        this.estDate = estDate;
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
     * 获取检查机关编码
     *
     * @return CheckDeptCode - 检查机关编码
     */
    public String getCheckDeptCode() {
        return checkDeptCode;
    }

    /**
     * 设置检查机关编码
     *
     * @param checkDeptCode 检查机关编码
     */
    public void setCheckDeptCode(String checkDeptCode) {
        this.checkDeptCode = checkDeptCode;
    }

    /**
     * 获取检查部门描述
     *
     * @return CheckDeptName - 检查部门描述
     */
    public String getCheckDeptName() {
        return checkDeptName;
    }

    /**
     * 设置检查部门描述
     *
     * @param checkDeptName 检查部门描述
     */
    public void setCheckDeptName(String checkDeptName) {
        this.checkDeptName = checkDeptName;
    }

    /**
     * 获取组织机构代码
     *
     * @return OrganizationNO - 组织机构代码
     */
    public String getOrganizationNO() {
        return organizationNO;
    }

    /**
     * 设置组织机构代码
     *
     * @param organizationNO 组织机构代码
     */
    public void setOrganizationNO(String organizationNO) {
        this.organizationNO = organizationNO;
    }

    /**
     * 获取主体类别
     *
     * @return SubjectType - 主体类别
     */
    public String getSubjectType() {
        return subjectType;
    }

    /**
     * 设置主体类别
     *
     * @param subjectType 主体类别
     */
    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    /**
     * 获取创建日期
     *
     * @return CreatTime - 创建日期
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置创建日期
     *
     * @param creatTime 创建日期
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 获取设置人UId
     *
     * @return SetUserUid - 设置人UId
     */
    public String getSetUserUid() {
        return setUserUid;
    }

    /**
     * 设置设置人UId
     *
     * @param setUserUid 设置人UId
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
     * 获取许可证名称
     *
     * @return LicName - 许可证名称
     */
    public String getLicName() {
        return licName;
    }

    /**
     * 设置许可证名称
     *
     * @param licName 许可证名称
     */
    public void setLicName(String licName) {
        this.licName = licName;
    }

    /**
     * 获取许可证编号
     *
     * @return LicNO - 许可证编号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置许可证编号
     *
     * @param licNO 许可证编号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * 获取许可证核准日期
     *
     * @return LicApprDate - 许可证核准日期
     */
    public Date getLicApprDate() {
        return licApprDate;
    }

    /**
     * 设置许可证核准日期
     *
     * @param licApprDate 许可证核准日期
     */
    public void setLicApprDate(Date licApprDate) {
        this.licApprDate = licApprDate;
    }

    /**
     * 获取许可证有效截止日期
     *
     * @return LicSaveEndDate - 许可证有效截止日期
     */
    public Date getLicSaveEndDate() {
        return licSaveEndDate;
    }

    /**
     * 设置许可证有效截止日期
     *
     * @param licSaveEndDate 许可证有效截止日期
     */
    public void setLicSaveEndDate(Date licSaveEndDate) {
        this.licSaveEndDate = licSaveEndDate;
    }

    /**
     * 获取许可证发证机关
     *
     * @return LicSendDeptCode - 许可证发证机关
     */
    public String getLicSendDeptCode() {
        return licSendDeptCode;
    }

    /**
     * 设置许可证发证机关
     *
     * @param licSendDeptCode 许可证发证机关
     */
    public void setLicSendDeptCode(String licSendDeptCode) {
        this.licSendDeptCode = licSendDeptCode;
    }

    /**
     * 获取许可证发证机关描述
     *
     * @return LicSendDeptName - 许可证发证机关描述
     */
    public String getLicSendDeptName() {
        return licSendDeptName;
    }

    /**
     * 设置许可证发证机关描述
     *
     * @param licSendDeptName 许可证发证机关描述
     */
    public void setLicSendDeptName(String licSendDeptName) {
        this.licSendDeptName = licSendDeptName;
    }

	public String getIsVlid() {
		return isVlid;
	}

	public void setIsVlid(String isVlid) {
		this.isVlid = isVlid;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getOpScope() {
		return opScope;
	}

	public void setOpScope(String opScope) {
		this.opScope = opScope;
	}
}