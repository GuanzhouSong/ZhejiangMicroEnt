/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述:    cs_alterstockinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_alterstockinfo")
public class AlterStockInfo implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 股东名称
     */
    @Column(name = "Inv")
    private String inv;

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
    
    /** 
 	 * 描述: 公示敏感词校验字符串
 	 * @auther ZhouYan
 	 * @date 2016年9月14日 
 	 * @return 
 	 */
 	public String getPubForbidInfo() {
 		return "股东股权转让信息 [股东名称=" + inv + "]";
 	}
}