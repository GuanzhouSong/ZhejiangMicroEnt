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
 * 描述:    cs_yr_subcapital 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_yr_subcapital")
public class YrSubcapital implements Serializable {
    /**
     * 自增ID
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
     * 股东/发起人名称
     */
    @Column(name = "Inv")
    private String inv;

    /**
     * 投资人ID
     */
    @Column(name = "InvID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String invID;

    /**
     * 实缴出资日期
     */
    @Column(name = "AcConDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date acConDate;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 认缴出资方式（中文名称）
     */
    @Column(name = "ConFormCN")
    private String conFormCN;

    /**
     * 实缴出资方式（中文名称）
     */
    @Column(name = "AcConFormCn")
    private String acConFormCn;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 累计实缴额
     */
    @Column(name = "LIACCONAM")
    private BigDecimal liacconam;

    /**
     * 累计认缴额
     */
    @Column(name = "LISUBCONAM")
    private BigDecimal lisubconam;

    /**
     * 统一代码、注册号/身份证件号码
     */
    @Column(name = "InvRegNO")
    private String invRegNO;
    

    /**
     * 实缴出资方式
     */
    @Column(name = "AcConForm")
    private String acConForm;

    /**
     * 认缴出资方式
     */
    @Column(name = "SubConForm")
    private String subConForm;

    /**
     * 认缴出资日期
     */
    @Column(name = "SubConDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
    private Date subConDate;

    

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
     * 获取股东/发起人名称
     *
     * @return Inv - 股东/发起人名称
     */
    public String getInv() {
        return inv;
    }

    /**
     * 设置股东/发起人名称
     *
     * @param inv 股东/发起人名称
     */
    public void setInv(String inv) {
        this.inv = inv;
    }

    /**
     * 获取投资人ID
     *
     * @return InvID - 投资人ID
     */
    public String getInvID() {
        return invID;
    }

    /**
     * 设置投资人ID
     *
     * @param invID 投资人ID
     */
    public void setInvID(String invID) {
        this.invID = invID;
    }

    /**
     * 获取实缴出资日期
     *
     * @return AcConDate - 实缴出资日期
     */
    public Date getAcConDate() {
        return acConDate;
    }

    /**
     * 设置实缴出资日期
     *
     * @param acConDate 实缴出资日期
     */
    public void setAcConDate(Date acConDate) {
        this.acConDate = acConDate;
    } 

    public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
     * 获取认缴出资方式（中文名称）
     *
     * @return ConFormCN - 认缴出资方式（中文名称）
     */
    public String getConFormCN() {
        return conFormCN;
    }

    /**
     * 设置认缴出资方式（中文名称）
     *
     * @param conFormCN 认缴出资方式（中文名称）
     */
    public void setConFormCN(String conFormCN) {
        this.conFormCN = conFormCN;
    }

    /**
     * 获取实缴出资方式（中文名称）
     *
     * @return AcConFormCn - 实缴出资方式（中文名称）
     */
    public String getAcConFormCn() {
        return acConFormCn;
    }

    /**
     * 设置实缴出资方式（中文名称）
     *
     * @param acConFormCn 实缴出资方式（中文名称）
     */
    public void setAcConFormCn(String acConFormCn) {
        this.acConFormCn = acConFormCn;
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
     * 获取累计实缴额
     *
     * @return liacconam - 累计实缴额
     */
    public BigDecimal getLiacconam() {
        return liacconam;
    }

    /**
     * 设置累计实缴额
     *
     * @param liacconam 累计实缴额
     */
    public void setLiacconam(BigDecimal liacconam) {
        this.liacconam = liacconam;
    }

    /**
     * 获取累计认缴额
     *
     * @return lisubconam - 累计认缴额
     */
    public BigDecimal getLisubconam() {
        return lisubconam;
    }


    /**
     * 设置累计认缴额
     *
     * @param lisubconam 累计认缴额
     */
    public void setLisubconam(BigDecimal lisubconam) {
        this.lisubconam = lisubconam;
    }

    /**
     * 获取统一代码、注册号/身份证件号码
     *
     * @return InvRegNO - 统一代码、注册号/身份证件号码
     */
    public String getInvRegNO() {
        return invRegNO;
    }

    /**
     * 设置统一代码、注册号/身份证件号码
     *
     * @param invRegNO 统一代码、注册号/身份证件号码
     */
    public void setInvRegNO(String invRegNO) {
        this.invRegNO = invRegNO;
    }
    /**
     * 获取实缴出资方式
     *
     * @return AcConForm - 实缴出资方式
     */
    public String getAcConForm() {
        return acConForm;
    }

    /**
     * 设置实缴出资方式
     *
     * @param acConForm 实缴出资方式
     */
    public void setAcConForm(String acConForm) {
        this.acConForm = acConForm;
    }

    /**
     * 获取认缴出资方式
     *
     * @return SubConForm - 认缴出资方式
     */
    public String getSubConForm() {
        return subConForm;
    }

    /**
     * 设置认缴出资方式
     *
     * @param subConForm 认缴出资方式
     */
    public void setSubConForm(String subConForm) {
        this.subConForm = subConForm;
    }

    /**
     * 获取认缴出资日期
     *
     * @return SubConDate - 认缴出资日期
     */
    public Date getSubConDate() {
        return subConDate;
    }

    /**
     * 设置认缴出资日期
     *
     * @param subConDate 认缴出资日期
     */
    public void setSubConDate(Date subConDate) {
        this.subConDate = subConDate;
    } 
    
}