/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.rpt.rptmodel;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 描述:    cs_rpt_ent_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年08月02日
 */
@Table(name = "cs_rpt_ent_info")
public class RptEntInfo implements Serializable {
    /**
     * 地区
     */
    @Column(name = "areaCode")
    private String areaCode;

    /**
     * 登记机关(CA11)
     */
    @Column(name = "regOrgCode")
    private String regOrgCode; 

    /**
     * 市场主体类型大类
     */
    @Column(name = "entCatgCode")
    private String entCatgCode;
    
    /**
     * 年月
     */
    @Column(name = "monthCode")
    private  String monthCode; 

    /**
     * 年报年度
     */
    @Column(name = "YEAR")
    private Integer YEAR;

    /**
     * 在册数
     */
    @Column(name = "normal")
    private BigDecimal normal;

    /**
     * 注销数
     */
    @Column(name = "cancel")
    private BigDecimal cancel;

    

    private static final long serialVersionUID = 1L;

    /**
     * 获取地区
     *
     * @return areaCode - 地区
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置地区
     *
     * @param areaCode 地区
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取登记机关(CA11)
     *
     * @return regOrgCode - 登记机关(CA11)
     */
    public String getRegOrgCode() {
        return regOrgCode;
    }

    /**
     * 设置登记机关(CA11)
     *
     * @param regOrgCode 登记机关(CA11)
     */
    public void setRegOrgCode(String regOrgCode) {
        this.regOrgCode = regOrgCode;
    } 
    

    /**
     * 获取市场主体类型大类
     *
     * @return entCatgCode - 市场主体类型大类
     */
    public String getEntCatgCode() {
        return entCatgCode;
    }

    /**
     * 设置市场主体类型大类
     *
     * @param entCatgCode 市场主体类型大类
     */
    public void setEntCatgCode(String entCatgCode) {
        this.entCatgCode = entCatgCode;
    }

    /**
     * 获取年报年度
     *
     * @return YEAR - 年报年度
     */
    public Integer getYEAR() {
        return YEAR;
    }

    /**
     * 设置年报年度
     *
     * @param YEAR 年报年度
     */
    public void setYEAR(Integer YEAR) {
        this.YEAR = YEAR;
    }

	public BigDecimal getNormal() {
		return normal;
	}

	public void setNormal(BigDecimal normal) {
		this.normal = normal;
	}

	public BigDecimal getCancel() {
		return cancel;
	}

	public void setCancel(BigDecimal cancel) {
		this.cancel = cancel;
	}

	public String getMonthCode() {
		return monthCode;
	}

	public void setMonthCode(String monthCode) {
		this.monthCode = monthCode;
	}
}