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
 * 描述:    cs_yr_forinvestment 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_yr_forinvestment")
public class YrForinvestMent implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码（原corpid）
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 认缴投资比
     */
    @Column(name = "SubConProp")
    private BigDecimal subConProp;

    /**
     * 认缴投资总额
     */
    @Column(name = "SubConAm")
    private BigDecimal subConAm;

    /**
     * 实缴投资比
     */
    @Column(name = "AcConAmProp")
    private BigDecimal acConAmProp;


    /**
     * 实缴投资总额

     */
    @Column(name = "AcConAm")
    private BigDecimal acConAm;

    /**
     * 统一社会信用代码
     */
    @Column(name = "UniCode")
    private String uniCode;

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
     * 认缴投资方式中文
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
     * 企业对外投资标识
     */
    @Column(name = "outinvid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String outinvid;

    /**
     * 实缴投资方式
     */
    @Column(name = "AcConForm")
    private String acConForm;

    /**
     * 认缴投资方式
     */
    @Column(name = "SubConForm")
    private String subConForm;

   

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
     * 获取主体身份代码（原corpid）
     *
     * @return PriPID - 主体身份代码（原corpid）
     */
    public String getPriPID() {
        return priPID;
    }

    /**
     * 设置主体身份代码（原corpid）
     *
     * @param priPID 主体身份代码（原corpid）
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
     * 获取认缴投资比
     *
     * @return SubConProp - 认缴投资比
     */
    public BigDecimal getSubConProp() {
        return subConProp;
    }

    /**
     * 设置认缴投资比
     *
     * @param subConProp 认缴投资比
     */
    public void setSubConProp(BigDecimal subConProp) {
        this.subConProp = subConProp;
    }

    /**
     * 获取认缴投资总额
     *
     * @return SubConAm - 认缴投资总额
     */
    public BigDecimal getSubConAm() {
        return subConAm;
    }

    /**
     * 设置认缴投资总额
     *
     * @param subConAm 认缴投资总额
     */
    public void setSubConAm(BigDecimal subConAm) {
        this.subConAm = subConAm;
    }

    /**
     * 获取实缴投资比
     *
     * @return AcConAmProp - 实缴投资比
     */
    public BigDecimal getAcConAmProp() {
        return acConAmProp;
    }

    /**
     * 设置实缴投资比
     *
     * @param acConAmProp 实缴投资比
     */
    public void setAcConAmProp(BigDecimal acConAmProp) {
        this.acConAmProp = acConAmProp;
    }

    /**
     * 获取实缴投资总额
     *
     * @return AcConAm - 实缴投资总额
     */
    public BigDecimal getAcConAm() {
        return acConAm;
    }

    /**
     * 设置实缴投资总额
     *
     * @param acConAm 实缴投资总额
     */
    public void setAcConAm(BigDecimal acConAm) {
        this.acConAm = acConAm;
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
     * 获取认缴投资方式中文
     *
     * @return ConFormCN - 认缴投资方式中文
     */
    public String getConFormCN() {
        return conFormCN;
    }

    /**
     * 设置认缴投资方式中文
     *
     * @param conFormCN 认缴投资方式中文
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
     * 获取企业对外投资标识
     *
     * @return OUTINVID - 企业对外投资标识
     */
    public String getOutinvid() {
        return outinvid;
    }

    /**
     * 设置企业对外投资标识
     *
     * @param outinvid 企业对外投资标识
     */
    public void setOutinvid(String outinvid) {
        this.outinvid = outinvid;
    }
    /**
     * 获取实缴投资方式
     *
     * @return AcConForm - 实缴投资方式
     */
    public String getAcConForm() {
        return acConForm;
    }

    /**
     * 设置实缴投资方式
     *
     * @param acConForm 实缴投资方式
     */
    public void setAcConForm(String acConForm) {
        this.acConForm = acConForm;
    }

    /**
     * 获取认缴投资方式
     *
     * @return SubConForm - 认缴投资方式
     */
    public String getSubConForm() {
        return subConForm;
    }

    /**
     * 设置认缴投资方式
     *
     * @param subConForm 认缴投资方式
     */
    public void setSubConForm(String subConForm) {
        this.subConForm = subConForm;
    }


}