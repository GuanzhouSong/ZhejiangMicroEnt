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
 * 描述:    cs_subcapital 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_subcapital")
public class Subcapital implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 股东/发起人名称
     */
    @Column(name = "Inv")
    private String inv;

    /**
     * UUID
     */
    @Column(name = "InvID")
    private String invID;

    /**
     * 实缴出资日期
     */
    @Column(name = "AcConDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
    private Date acConDate;

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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取UUID
     *
     * @return InvID - UUID
     */
    public String getInvID() {
        return invID;
    }

    /**
     * 设置UUID
     *
     * @param invID UUID
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
    
    /** 
	 * 描述: 公示敏感词校验字符串
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	public String getPubForbidInfo() {
		return "投资人及出资信息 [股东（发起人）姓名或名称=" + inv + ",注册号或者身份证=" + invID + "]";
	}
}