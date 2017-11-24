/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述: cs_pb_updateinfo 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年10月09日
 */
@Table(name = "cs_pb_updateinfo")
public class PbUpdateinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336945225694791783L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "AltDate")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
	private Date altDate;// 修改日期

	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
	private Date createTime;

	@Column(name = "AnCheID")
	private String anCheID;// 年报id

	@Column(name = "AltTable")
	private String altTable;// 修改记录对应表

	//年报修改uuId
	@Column(name = "AncheUID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
	private String ancheUID;

	@Column(name = "AltItem")
	private String altItem;// 修改事项

	@Column(name = "AltBe")
	private String altBe;// 修改前

	@Column(name = "AltAf")
	private String altAf;// 修改后
	
	/**
     * 年报提交编号
     */
    @Column(name = "ReportNo")
    private String reportNo;
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
	 * @return AltDate
	 */
	public Date getAltDate() {
		return altDate;
	}

	/**
	 * @param altDate
	 */
	public void setAltDate(Date altDate) {
		this.altDate = altDate;
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

	/**
	 * @return AnCheID
	 */
	public String getAnCheID() {
		return anCheID;
	}

	/**
	 * @param anCheID
	 */
	public void setAnCheID(String anCheID) {
		this.anCheID = anCheID;
	}

	/**
	 * @return AltTable
	 */
	public String getAltTable() {
		return altTable;
	}

	/**
	 * @param altTable
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
	 * @return AltItem
	 */
	public String getAltItem() {
		return altItem;
	}

	/**
	 * @param altItem
	 */
	public void setAltItem(String altItem) {
		this.altItem = altItem;
	}

	/**
	 * @return AltBe
	 */
	public String getAltBe() {
		return altBe;
	}

	/**
	 * @param altBe
	 */
	public void setAltBe(String altBe) {
		this.altBe = altBe;
	}

	/**
	 * @return AltAf
	 */
	public String getAltAf() {
		return altAf;
	}

	/**
	 * @param altAf
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
	
	/**
	 * 修改表的主键
	 */
	@Column(name = "AltID")
	private String altID;

	/**
	 * 获取修改表的主键
	 *
	 * @return altID - 修改表的主键
	 */
	public String getAltID() {
		return altID;
	}

	/**
	 * 设置修改表的主键
	 *
	 * @param altID 修改表的主键
	 */
	public void setAltID(String altID) {
		this.altID = altID;
	}
}