/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.creditprove.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_credit_prove_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年04月05日
 */
@Table(name = "cs_credit_prove_info")
public class CreditProveInfo implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id") 
    private Integer id;

    /**
     * 主键UID
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
    
    @Column(name = "ProveScope")
    private String proveScope;

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
     * 身份证件号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 设置日期
     */
    @Column(name = "SetDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date setDate;

    /**
     * 出证证明开始日期
     */
    @Column(name = "ProveStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date proveStartDate;

    /**
     * 出证证明结束日期
     */
    @Column(name = "ProveEntDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date proveEntDate;

    /**
     * 出证主体类型:1、企业，2、自然人
     */
    @Column(name = "ProveType")
    private String proveType;

    /**
     * 出证单编号
     */
    @Column(name = "ProveNo")
    private String proveNo;

    /**
     * 出证人姓名
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 出证人部门名称
     */
    @Column(name = "SetDept")
    private String setDept;

    /**
     * 查证部门编码
     */
    @Column(name = "AdCode")
    private String adCode;

    /**
     * 姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

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
     * 获取主键UID
     *
     * @return UID - 主键UID
     */
    public String getUID() {
        return uid;
    }

    /**
     * 设置主键UID
     *
     * @param UID 主键UID
     */
    public void setUID(String uid) {
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
     * 获取身份证件号码
     *
     * @return CerNO - 身份证件号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置身份证件号码
     *
     * @param cerNO 身份证件号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取设置日期
     *
     * @return SetDate - 设置日期
     */
    public Date getSetDate() {
        return setDate;
    }

    /**
     * 设置设置日期
     *
     * @param setDate 设置日期
     */
    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    /**
     * 获取出证证明开始日期
     *
     * @return ProveStartDate - 出证证明开始日期
     */
    public Date getProveStartDate() {
        return proveStartDate;
    }

    /**
     * 设置出证证明开始日期
     *
     * @param proveStartDate 出证证明开始日期
     */
    public void setProveStartDate(Date proveStartDate) {
        this.proveStartDate = proveStartDate;
    }

    /**
     * 获取出证证明结束日期
     *
     * @return ProveEntDate - 出证证明结束日期
     */
    public Date getProveEntDate() {
        return proveEntDate;
    }

    /**
     * 设置出证证明结束日期
     *
     * @param proveEntDate 出证证明结束日期
     */
    public void setProveEntDate(Date proveEntDate) {
        this.proveEntDate = proveEntDate;
    }

    /**
     * 获取出证主体类型:1、企业，2、自然人
     *
     * @return ProveType - 出证主体类型:1、企业，2、自然人
     */
    public String getProveType() {
        return proveType;
    }

    /**
     * 设置出证主体类型:1、企业，2、自然人
     *
     * @param proveType 出证主体类型:1、企业，2、自然人
     */
    public void setProveType(String proveType) {
        this.proveType = proveType;
    }

    /**
     * 获取出证单编号
     *
     * @return ProveNo - 出证单编号
     */
    public String getProveNo() {
        return proveNo;
    }

    /**
     * 设置出证单编号
     *
     * @param proveNo 出证单编号
     */
    public void setProveNo(String proveNo) {
        this.proveNo = proveNo;
    }

    /**
     * 获取出证人姓名
     *
     * @return SetName - 出证人姓名
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置出证人姓名
     *
     * @param setName 出证人姓名
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取出证人部门名称
     *
     * @return SetDept - 出证人部门名称
     */
    public String getSetDept() {
        return setDept;
    }

    /**
     * 设置出证人部门名称
     *
     * @param setDept 出证人部门名称
     */
    public void setSetDept(String setDept) {
        this.setDept = setDept;
    }

    public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	/**
     * 获取姓名
     *
     * @return Name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
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

	public String getProveScope() {
		return proveScope;
	}

	public void setProveScope(String proveScope) {
		this.proveScope = proveScope;
	}
}