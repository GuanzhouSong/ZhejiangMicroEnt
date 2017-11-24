/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述: 股权转让   cs_yr_alterstockinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月29日
 */
@Table(name = "cs_yr_alterstockinfo")
public class YrAlterStockInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 股东名称
     */
    @Column(name = "Inv")
    private String inv; 

    /**
     * 年报年度
     */
    
    @Column(name = "Year")
    private Integer year;

    /**
     * 股权变更日期
     */
    @Column(name = "AltDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date altDate;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 股东变更标识
     */
    @Column(name = "InvAltID") 
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String invAltID;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

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
     * 获取股权变更日期
     *
     * @return AltDate - 股权变更日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置股权变更日期
     *
     * @param altDate 股权变更日期
     */
    public void setAltDate(Date altDate) {
        this.altDate = altDate;
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
     * 获取股东变更标识
     *
     * @return InvAltID - 股东变更标识
     */
    public String getInvAltID() {
        return invAltID;
    }

    /**
     * 设置股东变更标识
     *
     * @param invAltID 股东变更标识
     */
    public void setInvAltID(String invAltID) {
        this.invAltID = invAltID;
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