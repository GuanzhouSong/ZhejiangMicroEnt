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
 * 描述:    cs_yr_forguaranteeinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_yr_forguaranteeinfo")
public class YrForGuaranteeInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 主体身份代码（原corpid）
     */
    @Column(name = "PriPID")
    private String priPID;

    /**
     * 年报年度
     */
    @Column(name = "Year")
    private Integer year;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
    private Date createTime;

    /**
     * 年报ID
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 保证担保额范围：1：主债权  2：利息 3：违约金 4：损害赔偿金 5：实现债权的费用 6：其他约定
     */
    @Column(name = "GaRange")
    private String gaRange;

    /**
     * 对外担保标识ID
     */
    @Column(name = "MoreID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String moreID;

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

    

    public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
     * 获取保证担保额范围：1：主债权  2：利息 3：违约金 4：损害赔偿金 5：实现债权的费用 6：其他约定
     *
     * @return GaRange - 保证担保额范围：1：主债权  2：利息 3：违约金 4：损害赔偿金 5：实现债权的费用 6：其他约定
     */
    public String getGaRange() {
        return gaRange;
    }

    /**
     * 设置保证担保额范围：1：主债权  2：利息 3：违约金 4：损害赔偿金 5：实现债权的费用 6：其他约定
     *
     * @param gaRange 保证担保额范围：1：主债权  2：利息 3：违约金 4：损害赔偿金 5：实现债权的费用 6：其他约定
     */
    public void setGaRange(String gaRange) {
        this.gaRange = gaRange;
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
    
}