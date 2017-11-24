/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述: cs_regist_surver 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年08月18日
 */
@Table(name = "cs_regist_surver")
public class RegistSurver implements Serializable {
	/**
	 * 自增id
	 */
	@Id
	@Column(name = "id")

	private Integer id;

	/**
	 * uid
	 */
	@Column(name = "uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

	/**
	 * 勘察时间
	 */
	@Column(name = "SurverDate")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date surverDate;

	/**
	 * 勘察人员
	 */
	@Column(name = "SurverName")
	private String surverName;

	/**
	 * 勘察情况
	 */
	@Column(name = "SurverInfo")
	private String surverInfo;

	@Column(name = "PriPID")
	private String priPID;

	private static final long serialVersionUID = 1L;

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * 获取自增id
	 *
	 * @return id - 自增id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置自增id
	 *
	 * @param id
	 *            自增id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取uid
	 *
	 * @return uid - uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置uid
	 *
	 * @param uid
	 *            uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取勘察时间
	 *
	 * @return SurverDate - 勘察时间
	 */
	public Date getSurverDate() {
		return surverDate;
	}

	/**
	 * 设置勘察时间
	 *
	 * @param surverDate
	 *            勘察时间
	 */
	public void setSurverDate(Date surverDate) {
		this.surverDate = surverDate;
	}

	/**
	 * 获取勘察人员
	 *
	 * @return SurverName - 勘察人员
	 */
	public String getSurverName() {
		return surverName;
	}

	/**
	 * 设置勘察人员
	 *
	 * @param surverName
	 *            勘察人员
	 */
	public void setSurverName(String surverName) {
		this.surverName = surverName;
	}

	/**
	 * 获取勘察情况
	 *
	 * @return SurverInfo - 勘察情况
	 */
	public String getSurverInfo() {
		return surverInfo;
	}

	/**
	 * 设置勘察情况
	 *
	 * @param surverInfo
	 *            勘察情况
	 */
	public void setSurverInfo(String surverInfo) {
		this.surverInfo = surverInfo;
	}
}