/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 描述:    cs_yr_baseinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年08月28日
 */
@Table(name = "cs_yr_baseinfo")
public class YrBaseInfo implements Serializable {
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
     * 注册号
     */
    @Column(name = "RegNO")
    private String regNO;

    /**
     * 企业类型
     */
    @Column(name = "EntType")
    private String entType;

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
     * 企业年报类别
     */
    @Column(name = "AnType")
    private String anType;

    /**
     * 年报id(uuid)
     */
    @Column(name = "AnCheID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String anCheID;

     

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
     * 获取企业类型
     *
     * @return EntType - 企业类型
     */
    public String getEntType() {
        return entType;
    }

    /**
     * 设置企业类型
     *
     * @param entType 企业类型
     */
    public void setEntType(String entType) {
        this.entType = entType;
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
     * 获取企业年报类别
     *
     * @return AnType - 企业年报类别
     */
    public String getAnType() {
        return anType;
    }

    /**
     * 设置企业年报类别
     *
     * @param anType 企业年报类别
     */
    public void setAnType(String anType) {
        this.anType = anType;
    }

    /**
     * 获取年报id(uuid)
     *
     * @return AnCheID - 年报id(uuid)
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报id(uuid)
     *
     * @param anCheID 年报id(uuid)
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    } 
}