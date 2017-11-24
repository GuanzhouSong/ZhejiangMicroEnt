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
 * 描述:    cs_sfc_updateinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2016年10月10日
 */
@Table(name = "cs_sfc_updateinfo")
public class SfcUpdateinfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6894732510487339532L;

	@Id
    @Column(name = "id")
    private Integer id;

    /**
     * 修改日期
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
     * 年报id
     */
    @Column(name = "AnCheID")
    private String anCheID;

    /**
     * 修改记录对应表
     */
    @Column(name = "AltTable")
    private String altTable;

    /**
     * 修改记录uuId
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "AncheUID")
    private String ancheUID;

    /**
     * 修改事项
     */
    @Column(name = "AltItem")
    private String altItem;

    /**
     * 修改前
     */
    @Column(name = "AltBe")
    private String altBe;

    /**
     * 修改后
     */
    @Column(name = "AltAf")
    private String altAf;

    /**
     * 年报提交编号
     */
    @Column(name = "ReportNo")
    private String reportNo;
    
    /**
     * 修改表主键
     */
    @Column(name = "AltID")
    private String altID;
    
    public String getAltID() {
		return altID;
	}

	public void setAltID(String altID) {
		this.altID = altID;
	}

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
     * 获取修改日期
     *
     * @return AltDate - 修改日期
     */
    public Date getAltDate() {
        return altDate;
    }

    /**
     * 设置修改日期
     *
     * @param altDate 修改日期
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
     * 获取年报id
     *
     * @return AnCheID - 年报id
     */
    public String getAnCheID() {
        return anCheID;
    }

    /**
     * 设置年报id
     *
     * @param anCheID 年报id
     */
    public void setAnCheID(String anCheID) {
        this.anCheID = anCheID;
    }

    /**
     * 获取修改记录对应表
     *
     * @return AltTable - 修改记录对应表
     */
    public String getAltTable() {
        return altTable;
    }

    /**
     * 设置修改记录对应表
     *
     * @param altTable 修改记录对应表
     */
    public void setAltTable(String altTable) {
        this.altTable = altTable;
    }

    /**
     * @return AncheUID
     */
    public String getAncheUID() {
        return ancheUID;
    }

    /**
     * @param ancheUID
     */
    public void setAncheUID(String ancheUID) {
        this.ancheUID = ancheUID;
    }

    /**
     * 获取修改事项
     *
     * @return AltItem - 修改事项
     */
    public String getAltItem() {
        return altItem;
    }

    /**
     * 设置修改事项
     *
     * @param altItem 修改事项
     */
    public void setAltItem(String altItem) {
        this.altItem = altItem;
    }

    /**
     * 获取修改前
     *
     * @return AltBe - 修改前
     */
    public String getAltBe() {
        return altBe;
    }

    /**
     * 设置修改前
     *
     * @param altBe 修改前
     */
    public void setAltBe(String altBe) {
        this.altBe = altBe;
    }

    /**
     * 获取修改后
     *
     * @return AltAf - 修改后
     */
    public String getAltAf() {
        return altAf;
    }

    /**
     * 设置修改后
     *
     * @param altAf 修改后
     */
    public void setAltAf(String altAf) {
        this.altAf = altAf;
    }
    
    /**
     * 获取年报提交编号
     *
     * @return ReportNo - 年报提交编号
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * 设置年报提交编号
     *
     * @param reportNo 年报提交编号
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }
    
    
}