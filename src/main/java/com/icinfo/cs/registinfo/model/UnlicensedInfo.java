/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    cs_unlicensed_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_unlicensed_info")
public class UnlicensedInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业拿名次
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 管辖单位
     */
    @Column(name = "LocalAdm")
    private String localAdm;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 当事人姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 身份证号码
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 手机号码
     */
    @Column(name = "MobTel")
    private String mobTel;

    /**
     * 固定电话
     */
    @Column(name = "FixTel")
    private String fixTel;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * uuid
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 片区/商圈
     */
    @Column(name = "SliceNo")
    private String sliceNo;

    /**
     * 经办时间
     */
    @Column(name = "SetTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date setTime;

    /**
     * 经办人
     */
    @Column(name = "SetName")
    private String setName;

    /**
     * 状态（1未销户、2已销户）
     */
    @Column(name = "UnlicState")
    private String unlicState;

    /**
     * 是否涉及前置、后置（0无、1涉及前置许可、2涉及后置许可）
     */
    @Column(name = "IsInvolve")
    private String isInvolve;

    /**
     * 类型（1无照、2无照无证、3有照无证、4执照过期、5吊销未注销）
     */
    @Column(name = "UnlicType")
    private String unlicType;

    /**
     * 经营地点—具体地址
     */
    @Column(name = "ProLocAddress")
    private String proLocAddress;

    /**
     * 经营地点—街道
     */
    @Column(name = "ProLocStreet")
    private String proLocStreet;

    /**
     * 经营地点—县区
     */
    @Column(name = "ProLocCounty")
    private String proLocCounty;

    /**
     * 经营地点—市
     */
    @Column(name = "ProLocCity")
    private String proLocCity;

    /**
     * 经营时所使用名称
     */
    @Column(name = "MgrName")
    private String mgrName;

    /**
     * 经营内容
     */
    @Column(name = "MgrScope")
    private String mgrScope;

    /**
     * 经营地点
     */
    @Column(name = "ProLoc")
    private String proLoc;

    private static final long serialVersionUID = 1L;

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
     * 获取企业拿名次
     *
     * @return EntName - 企业拿名次
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业拿名次
     *
     * @param entName 企业拿名次
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
     * 获取当事人姓名
     *
     * @return Name - 当事人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置当事人姓名
     *
     * @param name 当事人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证号码
     *
     * @return CerNO - 身份证号码
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置身份证号码
     *
     * @param cerNO 身份证号码
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取手机号码
     *
     * @return MobTel - 手机号码
     */
    public String getMobTel() {
        return mobTel;
    }

    /**
     * 设置手机号码
     *
     * @param mobTel 手机号码
     */
    public void setMobTel(String mobTel) {
        this.mobTel = mobTel;
    }

    /**
     * 获取固定电话
     *
     * @return FixTel - 固定电话
     */
    public String getFixTel() {
        return fixTel;
    }

    /**
     * 设置固定电话
     *
     * @param fixTel 固定电话
     */
    public void setFixTel(String fixTel) {
        this.fixTel = fixTel;
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

    /**
     * 获取uuid
     *
     * @return UID - uuid
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置uuid
     *
     * @param UID uuid
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取片区/商圈
     *
     * @return SliceNo - 片区/商圈
     */
    public String getSliceNo() {
        return sliceNo;
    }

    /**
     * 设置片区/商圈
     *
     * @param sliceNo 片区/商圈
     */
    public void setSliceNo(String sliceNo) {
        this.sliceNo = sliceNo;
    }

    /**
     * 获取经办时间
     *
     * @return SetTime - 经办时间
     */
    public Date getSetTime() {
        return setTime;
    }

    /**
     * 设置经办时间
     *
     * @param setTime 经办时间
     */
    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    /**
     * 获取经办人
     *
     * @return SetName - 经办人
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置经办人
     *
     * @param setName 经办人
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * 获取状态（1未销户、2已销户）
     *
     * @return UnlicState - 状态（1未销户、2已销户）
     */
    public String getUnlicState() {
        return unlicState;
    }

    /**
     * 设置状态（1未销户、2已销户）
     *
     * @param unlicState 状态（1未销户、2已销户）
     */
    public void setUnlicState(String unlicState) {
        this.unlicState = unlicState;
    }

    /**
     * 获取是否涉及前置、后置（0无、1涉及前置许可、2涉及后置许可）
     *
     * @return IsInvolve - 是否涉及前置、后置（0无、1涉及前置许可、2涉及后置许可）
     */
    public String getIsInvolve() {
        return isInvolve;
    }

    /**
     * 设置是否涉及前置、后置（0无、1涉及前置许可、2涉及后置许可）
     *
     * @param isInvolve 是否涉及前置、后置（0无、1涉及前置许可、2涉及后置许可）
     */
    public void setIsInvolve(String isInvolve) {
        this.isInvolve = isInvolve;
    }

    /**
     * 获取类型（1无照、2无照无证、3有照无证、4执照过期、5吊销未注销）
     *
     * @return UnlicType - 类型（1无照、2无照无证、3有照无证、4执照过期、5吊销未注销）
     */
    public String getUnlicType() {
        return unlicType;
    }

    /**
     * 设置类型（1无照、2无照无证、3有照无证、4执照过期、5吊销未注销）
     *
     * @param unlicType 类型（1无照、2无照无证、3有照无证、4执照过期、5吊销未注销）
     */
    public void setUnlicType(String unlicType) {
        this.unlicType = unlicType;
    }

    /**
     * 获取经营地点—具体地址
     *
     * @return ProLocAddress - 经营地点—具体地址
     */
    public String getProLocAddress() {
        return proLocAddress;
    }

    /**
     * 设置经营地点—具体地址
     *
     * @param proLocAddress 经营地点—具体地址
     */
    public void setProLocAddress(String proLocAddress) {
        this.proLocAddress = proLocAddress;
    }

    /**
     * 获取经营地点—街道
     *
     * @return ProLocStreet - 经营地点—街道
     */
    public String getProLocStreet() {
        return proLocStreet;
    }

    /**
     * 设置经营地点—街道
     *
     * @param proLocStreet 经营地点—街道
     */
    public void setProLocStreet(String proLocStreet) {
        this.proLocStreet = proLocStreet;
    }

    /**
     * 获取经营地点—县区
     *
     * @return ProLocCounty - 经营地点—县区
     */
    public String getProLocCounty() {
        return proLocCounty;
    }

    /**
     * 设置经营地点—县区
     *
     * @param proLocCounty 经营地点—县区
     */
    public void setProLocCounty(String proLocCounty) {
        this.proLocCounty = proLocCounty;
    }

    /**
     * 获取经营地点—市
     *
     * @return ProLocCity - 经营地点—市
     */
    public String getProLocCity() {
        return proLocCity;
    }

    /**
     * 设置经营地点—市
     *
     * @param proLocCity 经营地点—市
     */
    public void setProLocCity(String proLocCity) {
        this.proLocCity = proLocCity;
    }

    /**
     * 获取经营时所使用名称
     *
     * @return MgrName - 经营时所使用名称
     */
    public String getMgrName() {
        return mgrName;
    }

    /**
     * 设置经营时所使用名称
     *
     * @param mgrName 经营时所使用名称
     */
    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    /**
     * 获取经营内容
     *
     * @return MgrScope - 经营内容
     */
    public String getMgrScope() {
        return mgrScope;
    }

    /**
     * 设置经营内容
     *
     * @param mgrScope 经营内容
     */
    public void setMgrScope(String mgrScope) {
        this.mgrScope = mgrScope;
    }

    /**
     * 获取经营地点
     *
     * @return ProLoc - 经营地点
     */
    public String getProLoc() {
        return proLoc;
    }

    /**
     * 设置经营地点
     *
     * @param proLoc 经营地点
     */
    public void setProLoc(String proLoc) {
        this.proLoc = proLoc;
    }
}