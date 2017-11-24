/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.favorable.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_favorable_info_his 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年03月09日
 */
@Table(name = "cs_favorable_info_his")
public class FavorAbleInfoHis implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 修改记录序号
     */
    @Column(name = "HisNO")
    private String hisNO;
    
    /**
     * 良好信息名称
     */
    @Column(name = "FavName")
    private String favName;

    /**
     * 主键UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniSCID")
    private String uniSCID;

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
     * 登记机关
     */
    @Column(name = "RegOrg")
    private String regOrg;

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 录入员
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 录入日期
     */
    @Column(name = "SetTime")
    private Date setTime;

    /**
     * 录入人部门
     */
    @Column(name = "SetDept")
    private String setDept;

    /**
     * 审核人员
     */
    @Column(name = "AuditName")
    private String auditName;

    /**
     * 审核日期
     */
    @Column(name = "AuditDate")
    private Date auditDate;

    /**
     * 审核部门
     */
    @Column(name = "AuditDept")
    private String auditDept;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpin")
    private String auditOpin;

    /**
     * 发布日期
     */
    @Column(name = "RegDate")
    private Date regDate;

    /**
     * 发布部门(中文名称)
     */
    @Column(name = "RegDeptCn")
    private String regDeptCn;

    /**
     * 发布部门编码
     */
    @Column(name = "RegDept")
    private String regDept;

    /**
     * 文号
     */
    @Column(name = "RegDocNo")
    private String regDocNo;

    /**
     * 有效期自
     */
    @Column(name = "RegFrom")
    private Date regFrom;

    /**
     * 有效期至
     */
    @Column(name = "RegTo")
    private Date regTo;

    /**
     * 信息认定类型
     */
    @Column(name = "RegType")
    private String regType;

    /**
     * 信息认定年度
     */
    @Column(name = "RegYear")
    private Integer regYear;

    /**
     * 信息级别，0,国家级；1，省级；2，市级；3，县级
     */
    @Column(name = "LicZone")
    private String licZone;

    /**
     * 良好信息类别，0,百强民营企业；1、驰名商标；2，知名商号；3，著名商标4，守合同重信用企业；5，信用示范管理企业6，小微企业成长之星
     */
    @Column(name = "FavType")
    private String favType;

    /**
     * 审核状态，0，待审核；1，同意；2，不同意
     */
    @Column(name = "AuditState")
    private String auditState;

    /**
     * 良好信息状态，0，无效；1，有效
     */
    @Column(name = "EfftStatus")
    private String efftStatus;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取修改记录序号
     *
     * @return HisNO - 修改记录序号
     */
    public String getHisNO() {
        return hisNO;
    }

    /**
     * 设置修改记录序号
     *
     * @param hisNO 修改记录序号
     */
    public void setHisNO(String hisNO) {
        this.hisNO = hisNO;
    }

    /**
     * 获取主键UID
     *
     * @return UID - 主键UID
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置主键UID
     *
     * @param UID 主键UID
     */
    public void setUID(String UID) {
        this.UID = UID;
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
     * 获取管辖单位
     *
     * @return LocalAdm - 管辖单位
     */
    public String getLocalAdm() {
        return localAdm;
    }

    /**
     * 设置管辖单位
     *
     * @param localAdm 管辖单位
     */
    public void setLocalAdm(String localAdm) {
        this.localAdm = localAdm;
    }

    /**
     * 获取录入员
     *
     * @return SetName - 录入员
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置录入员
     *
     * @param setName 录入员
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取录入日期
     *
     * @return SetTime - 录入日期
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置录入日期
     *
     * @param setTime 录入日期
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取录入人部门
     *
     * @return SetDept - 录入人部门
     */
    public String getSetDept() {
        return setDept;
    }

    /**
     * 设置录入人部门
     *
     * @param setDept 录入人部门
     */
    public void setSetDept(String setDept) {
        this.setDept = setDept;
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
     * 获取审核部门
     *
     * @return AuditDept - 审核部门
     */
    public String getAuditDept() {
        return auditDept;
    }

    /**
     * 设置审核部门
     *
     * @param auditDept 审核部门
     */
    public void setAuditDept(String auditDept) {
        this.auditDept = auditDept;
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
     * 获取发布日期
     *
     * @return RegDate - 发布日期
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * 设置发布日期
     *
     * @param regDate 发布日期
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * 获取发布部门(中文名称)
     *
     * @return RegDeptCn - 发布部门(中文名称)
     */
    public String getRegDeptCn() {
        return regDeptCn;
    }

    /**
     * 设置发布部门(中文名称)
     *
     * @param regDeptCn 发布部门(中文名称)
     */
    public void setRegDeptCn(String regDeptCn) {
        this.regDeptCn = regDeptCn;
    }

    /**
     * 获取发布部门编码
     *
     * @return RegDept - 发布部门编码
     */
    public String getRegDept() {
        return regDept;
    }

    /**
     * 设置发布部门编码
     *
     * @param regDept 发布部门编码
     */
    public void setRegDept(String regDept) {
        this.regDept = regDept;
    }

    /**
     * 获取文号
     *
     * @return RegDocNo - 文号
     */
    public String getRegDocNo() {
        return regDocNo;
    }

    /**
     * 设置文号
     *
     * @param regDocNo 文号
     */
    public void setRegDocNo(String regDocNo) {
        this.regDocNo = regDocNo;
    }

    /**
     * 获取有效期自
     *
     * @return RegFrom - 有效期自
     */
    public Date getRegFrom() {
        return regFrom;
    }

    /**
     * 设置有效期自
     *
     * @param regFrom 有效期自
     */
    public void setRegFrom(Date regFrom) {
        this.regFrom = regFrom;
    }

    /**
     * 获取有效期至
     *
     * @return RegTo - 有效期至
     */
    public Date getRegTo() {
        return regTo;
    }

    /**
     * 设置有效期至
     *
     * @param regTo 有效期至
     */
    public void setRegTo(Date regTo) {
        this.regTo = regTo;
    }

    /**
     * 获取信息认定类型
     *
     * @return RegType - 信息认定类型
     */
    public String getRegType() {
        return regType;
    }

    /**
     * 设置信息认定类型
     *
     * @param regType 信息认定类型
     */
    public void setRegType(String regType) {
        this.regType = regType;
    }

    /**
     * 获取信息认定年度
     *
     * @return RegYear - 信息认定年度
     */
    public Integer getRegYear() {
        return regYear;
    }

    /**
     * 设置信息认定年度
     *
     * @param regYear 信息认定年度
     */
    public void setRegYear(Integer regYear) {
        this.regYear = regYear;
    }

    /**
     * 获取信息级别，0,国家级；1，省级；2，市级；3，县级
     *
     * @return LicZone - 信息级别，0,国家级；1，省级；2，市级；3，县级
     */
    public String getLicZone() {
        return licZone;
    }

    /**
     * 设置信息级别，0,国家级；1，省级；2，市级；3，县级
     *
     * @param licZone 信息级别，0,国家级；1，省级；2，市级；3，县级
     */
    public void setLicZone(String licZone) {
        this.licZone = licZone;
    }

    /**
     * 获取良好信息类别，0,百强民营企业；1、驰名商标；2，知名商号；3，著名商标4，守合同重信用企业；5，信用示范管理企业6，小微企业成长之星
     *
     * @return FavType - 良好信息类别，0,百强民营企业；1、驰名商标；2，知名商号；3，著名商标4，守合同重信用企业；5，信用示范管理企业6，小微企业成长之星
     */
    public String getFavType() {
        return favType;
    }

    /**
     * 设置良好信息类别，0,百强民营企业；1、驰名商标；2，知名商号；3，著名商标4，守合同重信用企业；5，信用示范管理企业6，小微企业成长之星
     *
     * @param favType 良好信息类别，0,百强民营企业；1、驰名商标；2，知名商号；3，著名商标4，守合同重信用企业；5，信用示范管理企业6，小微企业成长之星
     */
    public void setFavType(String favType) {
        this.favType = favType;
    }

    /**
     * 获取审核状态，0，待审核；1，同意；2，不同意
     *
     * @return AuditState - 审核状态，0，待审核；1，同意；2，不同意
     */
    public String getAuditState() {
        return auditState;
    }

    /**
     * 设置审核状态，0，待审核；1，同意；2，不同意
     *
     * @param auditState 审核状态，0，待审核；1，同意；2，不同意
     */
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取良好信息状态，0，无效；1，有效
     *
     * @return EfftStatus - 良好信息状态，0，无效；1，有效
     */
    public String getEfftStatus() {
        return efftStatus;
    }

    /**
     * 设置良好信息状态，0，无效；1，有效
     *
     * @param efftStatus 良好信息状态，0，无效；1，有效
     */
    public void setEfftStatus(String efftStatus) {
        this.efftStatus = efftStatus;
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

	public String getFavName() {
		return favName;
	}

	public void setFavName(String favName) {
		this.favName = favName;
	}
}