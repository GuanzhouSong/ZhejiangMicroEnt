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
 * 描述:    cs_foodstorage_back 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月26日
 */
@Table(name = "cs_foodstorage_back")
public class FoodstorageBack implements Serializable {
    /**
     * 主键ID
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
     * 序号
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String UID;

    /**
     * 年度
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 退回人员
     */
    @Column(name = "BackName")
    private String backName;

    /**
     * 退回原因
     */
    @Column(name = "BackReason")
    private String backReason;

    /**
     * 退回日期
     */
    @Column(name = "BackTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date backTime;

    @Column(name = "CreateTime")
    private Date createTime;

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
     * 获取序号
     *
     * @return UID - 序号
     */
    public String getUID() {
        return UID;
    }

    /**
     * 设置序号
     *
     * @param UID 序号
     */
    public void setUID(String UID) {
        this.UID = UID;
    }

    /**
     * 获取年度
     *
     * @return Year - 年度
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年度
     *
     * @param year 年度
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取退回人员
     *
     * @return BackName - 退回人员
     */
    public String getBackName() {
        return backName;
    }

    /**
     * 设置退回人员
     *
     * @param backName 退回人员
     */
    public void setBackName(String backName) {
        this.backName = backName;
    }

    /**
     * 获取退回原因
     *
     * @return BackReason - 退回原因
     */
    public String getBackReason() {
        return backReason;
    }

    /**
     * 设置退回原因
     *
     * @param backReason 退回原因
     */
    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    /**
     * 获取退回日期
     *
     * @return BackTime - 退回日期
     */
    public Date getBackTime() {
        return backTime;
    }

    /**
     * 设置退回日期
     *
     * @param backTime 退回日期
     */
    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    /**
     * @return CreateTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
	public String toString() {
		return "FoodstorageBack [id=" + id + ", priPID=" + priPID + ", UID="
				+ UID + ", year=" + year + ", backName="
				+ backName + ", backReason=" + backReason + ", backTime="
				+ backTime + ", createTime=" + createTime + "]";
	}
}