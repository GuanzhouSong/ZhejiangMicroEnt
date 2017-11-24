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
 * 描述:    cs_pub_forbidresult 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年09月11日
 */
@Table(name = "cs_pub_forbidresult")
public class PubForbidResult implements Serializable {
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
     * 时间戳
     */
    @Column(name = "CreateTime")
    private Date createTime;

    /**
     * UID
     */
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 年报年份
     */
    @Column(name = "Year")
    private Integer year;

    /**
     * 提交序号
     */
    @Column(name = "ReportNo")
    private String reportNo;

    /**
     * 提交日期
     */
    @Column(name = "ForbidDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date forbidDate;


    /**
     * 敏感词所在报表
     */
    @Column(name = "ForbidTable")
    private String forbidTable;


    /**
     * 敏感信息
     */
    @Column(name = "ForbidContent")
    private String forbidContent;

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

    

    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取年报年份
     *
     * @return Year - 年报年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置年报年份
     *
     * @param year 年报年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }


    /**
     * 获取提交日期
     *
     * @return ForbidDate - 提交日期
     */
    public Date getForbidDate() {
        return forbidDate;
    }

    /**
     * 设置提交日期
     *
     * @param forbidDate 提交日期
     */
    public void setForbidDate(Date forbidDate) {
        this.forbidDate = forbidDate;
    }


    /**
     * 获取敏感词所在报表
     *
     * @return ForbidTable - 敏感词所在报表
     */
    public String getForbidTable() {
        return forbidTable;
    }

    /**
     * 设置敏感词所在报表
     *
     * @param forbidTable 敏感词所在报表
     */
    public void setForbidTable(String forbidTable) {
        this.forbidTable = forbidTable;
    }

    /**
     * 获取敏感信息
     *
     * @return ForbidContent - 敏感信息
     */
    public String getForbidContent() {
        return forbidContent;
    }

    /**
     * 设置敏感信息
     *
     * @param forbidContent 敏感信息
     */
    public void setForbidContent(String forbidContent) {
        this.forbidContent = forbidContent;
    }

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
    
    
}