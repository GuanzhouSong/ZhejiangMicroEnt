/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    cs_im_ippldg 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_im_ippldg")
public class ImIppldg implements Serializable {
    /**
     * 主键自增id
     */
    @Id
    @Column(name = "id")
     private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业(机构)名称
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
     * 知识产权出质人名称
     */
    @Column(name = "Pledgor")
    @Forbidword
    private String pledgor;

    /**
     * 商品注册号
     */
    @Column(name = "TMRegNo")
    @Forbidword
    private String TMRegNo;

    /**
     * 注销日期
     */
    @Column(name = "CanDate")
    private Date canDate;

    /**
     * 名称
     */
    @Column(name = "TMName")
    @Forbidword
    private String TMName;

    /**
     * 知识产权质权人名称
     */
    @Column(name = "ImpOrg")
    @Forbidword
    private String impOrg;

    /**
     * 记期限自
     */
    @Column(name = "PleRegPerFrom")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pleRegPerFrom;

    /**
     * 注销原因
     */
    @Column(name = "EquPleCanRea")
    @Forbidword
    private String equPleCanRea;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 出质ID
     */
    @Column(name = "PleID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String pleID;

    /**
     * 种类代码
     */
    @Column(name = "Kinds")
    @Forbidword
    private String kinds;

    /**
     * 其它无效原因
     */
    @Column(name = "InvAliDRea")
    @Forbidword
    private String invAliDRea;

    /**
     * 其它无效日期
     */
    @Column(name = "InvAlidDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date invAlidDate;

    /**
     * 类别选择：1变更，2注销，3撤销
     */
    @Column(name = "PubType")
    private String pubType;

    /**
     * 公示类型1：公示，2：暂存，0：历史
     */
    @Column(name = "PubFlag")
    private String pubFlag;

    /**
     * 公示日期
     */
    @Column(name = "PublicDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;

    /**
     * 知识产权质权登记期限至
     */
    @Column(name = "PleRegPerTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pleRegPerTo;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键自增id
     *
     * @return id - 主键自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增id
     *
     * @param id 主键自增id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取知识产权出质人名称
     *
     * @return Pledgor - 知识产权出质人名称
     */
    public String getPledgor() {
        return pledgor;
    }

    /**
     * 设置知识产权出质人名称
     *
     * @param pledgor 知识产权出质人名称
     */
    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    /**
     * 获取商品注册号
     *
     * @return TMRegNo - 商品注册号
     */
    public String getTMRegNo() {
        return TMRegNo;
    }

    /**
     * 设置商品注册号
     *
     * @param TMRegNo 商品注册号
     */
    public void setTMRegNo(String TMRegNo) {
        this.TMRegNo = TMRegNo;
    }

    /**
     * 获取注销日期
     *
     * @return CanDate - 注销日期
     */
    public Date getCanDate() {
        return canDate;
    }

    /**
     * 设置注销日期
     *
     * @param canDate 注销日期
     */
    public void setCanDate(Date canDate) {
        this.canDate = canDate;
    }

    /**
     * 获取名称
     *
     * @return TMName - 名称
     */
    public String getTMName() {
        return TMName;
    }

    /**
     * 设置名称
     *
     * @param TMName 名称
     */
    public void setTMName(String TMName) {
        this.TMName = TMName;
    }

    /**
     * 获取知识产权质权人名称
     *
     * @return ImpOrg - 知识产权质权人名称
     */
    public String getImpOrg() {
        return impOrg;
    }

    /**
     * 设置知识产权质权人名称
     *
     * @param impOrg 知识产权质权人名称
     */
    public void setImpOrg(String impOrg) {
        this.impOrg = impOrg;
    }

    /**
     * 获取记期限自
     *
     * @return PleRegPerFrom - 记期限自
     */
    public Date getPleRegPerFrom() {
        return pleRegPerFrom;
    }

    /**
     * 设置记期限自
     *
     * @param pleRegPerFrom 记期限自
     */
    public void setPleRegPerFrom(Date pleRegPerFrom) {
        this.pleRegPerFrom = pleRegPerFrom;
    }

    /**
     * 获取注销原因
     *
     * @return EquPleCanRea - 注销原因
     */
    public String getEquPleCanRea() {
        return equPleCanRea;
    }

    /**
     * 设置注销原因
     *
     * @param equPleCanRea 注销原因
     */
    public void setEquPleCanRea(String equPleCanRea) {
        this.equPleCanRea = equPleCanRea;
    }

    /**
     * 获取创建时间戳
     *
     * @return CreateTime - 创建时间戳
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间戳
     *
     * @param createTime 创建时间戳
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取出质ID
     *
     * @return PleID - 出质ID
     */
    public String getPleID() {
        return pleID;
    }

    /**
     * 设置出质ID
     *
     * @param pleID 出质ID
     */
    public void setPleID(String pleID) {
        this.pleID = pleID;
    }

    /**
     * 获取种类代码
     *
     * @return Kinds - 种类代码
     */
    public String getKinds() {
        return kinds;
    }

    /**
     * 设置种类代码
     *
     * @param kinds 种类代码
     */
    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    /**
     * 获取其它无效原因
     *
     * @return InvAliDRea - 其它无效原因
     */
    public String getInvAliDRea() {
        return invAliDRea;
    }

    /**
     * 设置其它无效原因
     *
     * @param invAliDRea 其它无效原因
     */
    public void setInvAliDRea(String invAliDRea) {
        this.invAliDRea = invAliDRea;
    }

    /**
     * 获取其它无效日期
     *
     * @return InvAlidDate - 其它无效日期
     */
    public Date getInvAlidDate() {
        return invAlidDate;
    }

    /**
     * 设置其它无效日期
     *
     * @param invAlidDate 其它无效日期
     */
    public void setInvAlidDate(Date invAlidDate) {
        this.invAlidDate = invAlidDate;
    }

    /**
     * 获取类别选择：1变更，2注销，3撤销
     *
     * @return PubType - 类别选择：1变更，2注销，3撤销
     */
    public String getPubType() {
        return pubType;
    }

    /**
     * 设置类别选择：1变更，2注销，3撤销
     *
     * @param pubType 类别选择：1变更，2注销，3撤销
     */
    public void setPubType(String pubType) {
        this.pubType = pubType;
    }

    /**
     * 获取公示类型1：公示，2：暂存，0：历史
     *
     * @return PubFlag - 公示类型1：公示，2：暂存，0：历史
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置公示类型1：公示，2：暂存，0：历史
     *
     * @param pubFlag 公示类型1：公示，2：暂存，0：历史
     */
    public void setPubFlag(String pubFlag) {
        this.pubFlag = pubFlag;
    }

    /**
     * 获取公示日期
     *
     * @return PublicDate - 公示日期
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * 设置公示日期
     *
     * @param publicDate 公示日期
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * 获取知识产权质权登记期限至
     *
     * @return PleRegPerTo - 知识产权质权登记期限至
     */
    public Date getPleRegPerTo() {
        return pleRegPerTo;
    }

    /**
     * 设置知识产权质权登记期限至
     *
     * @param pleRegPerTo 知识产权质权登记期限至
     */
    public void setPleRegPerTo(Date pleRegPerTo) {
        this.pleRegPerTo = pleRegPerTo;
    }
}