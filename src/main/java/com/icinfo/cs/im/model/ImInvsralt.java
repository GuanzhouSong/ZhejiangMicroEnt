/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.im.model;


import java.io.Serializable;
import java.math.BigDecimal;
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
 * 描述:    股权变更信息 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author 朱德峰
 * @date 2016年08月28日
 */
@Table(name = "cs_im_invsralt")
public class ImInvsralt implements Serializable {
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
     * 股东名称
     */
    @Column(name = "Inv")
    @Forbidword
    private String inv;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

    /**
     * 创建时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 股权变更信息代码
     */
    @Column(name = "InvAltID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String invAltID;

    /**
     * 公示状态1：已公示，0：未公示
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
     * 股权变更日期
     */
    @Column(name = "EquAltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date equAltDate;

    /**
     * 转让前股权比例
     */
    @Column(name = "BeTransAmPr")
    private BigDecimal beTransAmPr;

    /**
     * 转让后股权比例
     */
    @Column(name = "AfTransAmPr")
    private BigDecimal afTransAmPr;


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
     * 获取股东名称
     *
     * @return Inv - 股东名称
     */
    public String getInv() {
        return inv;
    }

    /**
     * 设置股东名称
     *
     * @param inv 股东名称
     */
    public void setInv(String inv) {
        this.inv = inv;
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
     * 获取股权变更信息代码
     *
     * @return InvAltID - 股权变更信息代码
     */
    public String getInvAltID() {
        return invAltID;
    }

    /**
     * 设置股权变更信息代码
     *
     * @param invAltID 股权变更信息代码
     */
    public void setInvAltID(String invAltID) {
        this.invAltID = invAltID;
    }

    /**
     * 获取公示状态1：已公示，0：未公示
     *
     * @return PubFlag - 公示状态1：已公示，0：未公示
     */
    public String getPubFlag() {
        return pubFlag;
    }

    /**
     * 设置公示状态1：已公示，0：未公示
     *
     * @param pubFlag 公示状态1：已公示，0：未公示
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
     * 获取股权变更日期
     *
     * @return EquAltDate - 股权变更日期
     */
    public Date getEquAltDate() {
        return equAltDate;
    }

    /**
     * 设置股权变更日期
     *
     * @param equAltDate 股权变更日期
     */
    public void setEquAltDate(Date equAltDate) {
        this.equAltDate = equAltDate;
    }

    /**
     * 获取转让前股权比例
     *
     * @return BeTransAmPr - 转让前股权比例
     */
    public BigDecimal getBeTransAmPr() {
        return beTransAmPr;
    }

    /**
     * 设置转让前股权比例
     *
     * @param beTransAmPr 转让前股权比例
     */
    public void setBeTransAmPr(BigDecimal beTransAmPr) {
        this.beTransAmPr = beTransAmPr;
    }

    /**
     * 获取转让后股权比例
     *
     * @return AfTransAmPr - 转让后股权比例
     */
    public BigDecimal getAfTransAmPr() {
        return afTransAmPr;
    }

    /**
     * 设置转让后股权比例
     *
     * @param afTransAmPr 转让后股权比例
     */
    public void setAfTransAmPr(BigDecimal afTransAmPr) {
        this.afTransAmPr = afTransAmPr;
    }

}