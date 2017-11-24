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
 * 描述:    cs_forguaranteeinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_forguaranteeinfo")
public class ForGuaranteeInfo implements Serializable {
    /**
     * 自增ID
     */
	@Id
    @Column(name = "id")
    private Integer id;
    
    /**
     * 对外担保标识ID
     */
    @Column(name = "MoreID")
    private String moreID;

    /**
     * 债权人
     */
    @Column(name = "More")
    private String more;

    /**
     * 债务人
     */
    @Column(name = "Mortgagor")
    private String mortgagor;

    /**
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 主债权种类
     */
    @Column(name = "PriClaSecKind")
    private String priClaSecKind;

    /**
     * 主债权数额
     */
    @Column(name = "PriClaSecAm")
    private BigDecimal priClaSecAm;

    /**
     * 履行债务的期限自
     */
    @Column(name = "PefPerForm")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pefPerForm;

    /**
     * 履行债务的期限至
     */
    @Column(name = "PefPerTo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pefPerTo;

    /**
     * 对外担保是否公示
     */
    @Column(name = "IsPubFlag")
    private String isPubFlag;

    /**
     * 保证的方式
     */
    @Column(name = "GaType")
    private String gaType;

    /**
     * 保证的期间
     */
    @Column(name = "GuaPeriod")
    private String guaPeriod;

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
     * 获取债权人
     *
     * @return More - 债权人
     */
    public String getMore() {
        return more;
    }

    /**
     * 设置债权人
     *
     * @param more 债权人
     */
    public void setMore(String more) {
        this.more = more;
    }

    /**
     * 获取债务人
     *
     * @return Mortgagor - 债务人
     */
    public String getMortgagor() {
        return mortgagor;
    }

    /**
     * 设置债务人
     *
     * @param mortgagor 债务人
     */
    public void setMortgagor(String mortgagor) {
        this.mortgagor = mortgagor;
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
     * 获取对外担保标识ID
     *
     * @return MoreID - 对外担保标识ID
     */
    public String getMoreID() {
        return moreID;
    }

    /**
     * 设置对外担保标识ID
     *
     * @param moreID 对外担保标识ID
     */
    public void setMoreID(String moreID) {
        this.moreID = moreID;
    }

    /**
     * 获取主债权种类
     *
     * @return PriClaSecKind - 主债权种类
     */
    public String getPriClaSecKind() {
        return priClaSecKind;
    }

    /**
     * 设置主债权种类
     *
     * @param priClaSecKind 主债权种类
     */
    public void setPriClaSecKind(String priClaSecKind) {
        this.priClaSecKind = priClaSecKind;
    }

    /**
     * 获取主债权数额
     *
     * @return PriClaSecAm - 主债权数额
     */
    public BigDecimal getPriClaSecAm() {
        return priClaSecAm;
    }

    /**
     * 设置主债权数额
     *
     * @param priClaSecAm 主债权数额
     */
    public void setPriClaSecAm(BigDecimal priClaSecAm) {
        this.priClaSecAm = priClaSecAm;
    }

    /**
     * 获取履行债务的期限自
     *
     * @return PefPerForm - 履行债务的期限自
     */
    public Date getPefPerForm() {
        return pefPerForm;
    }

    /**
     * 设置履行债务的期限自
     *
     * @param pefPerForm 履行债务的期限自
     */
    public void setPefPerForm(Date pefPerForm) {
        this.pefPerForm = pefPerForm;
    }

    /**
     * 获取履行债务的期限至
     *
     * @return PefPerTo - 履行债务的期限至
     */
    public Date getPefPerTo() {
        return pefPerTo;
    }

    /**
     * 设置履行债务的期限至
     *
     * @param pefPerTo 履行债务的期限至
     */
    public void setPefPerTo(Date pefPerTo) {
        this.pefPerTo = pefPerTo;
    }

    /**
     * 获取对外担保是否公示
     *
     * @return IsPubFlag - 对外担保是否公示
     */
    public String getIsPubFlag() {
        return isPubFlag;
    }

    /**
     * 设置对外担保是否公示
     *
     * @param isPubFlag 对外担保是否公示
     */
    public void setIsPubFlag(String isPubFlag) {
        this.isPubFlag = isPubFlag;
    }

    /**
     * 获取保证的方式
     *
     * @return GaType - 保证的方式
     */
    public String getGaType() {
        return gaType;
    }

    /**
     * 设置保证的方式
     *
     * @param gaType 保证的方式
     */
    public void setGaType(String gaType) {
        this.gaType = gaType;
    }

    /**
     * 获取保证的期间
     *
     * @return GuaPeriod - 保证的期间
     */
    public String getGuaPeriod() {
        return guaPeriod;
    }

    /**
     * 设置保证的期间
     *
     * @param guaPeriod 保证的期间
     */
    public void setGuaPeriod(String guaPeriod) {
        this.guaPeriod = guaPeriod;
    }
    
    /** 
	 * 描述: 公示敏感词校验字符串
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	public String getPubForbidInfo() {
		return "对外提供保证担保信息 [债务人=" + mortgagor + ", 债权人=" + more + "]";
	}
}