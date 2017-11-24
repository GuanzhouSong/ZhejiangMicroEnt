/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.yr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: cs_sys_forbidword 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年08月30日
 */
@Table(name = "cs_sys_forbidword")
public class SysForbidword implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8587597818889510686L;

	@Id
	@Column(name = "id")
	private Integer id;

	// 禁用文字
	@Column(name = "BanLetter")
	private String banLetter;

	// 禁用类型
	@Column(name = "BanType")
	private String banType;

	// 禁用起始日期
	@Column(name = "BanFrom")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
	private Date banFrom;

	// 禁用结束日期
	@Column(name = "BanTo")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  
	private Date banTo;

	// 禁用说明
	@Column(name = "BanExp")
	private String banExp;

	// 禁用文字拼音
	@Column(name = "BanLettPinY")
	private String banLettPinY;

	// 设置时间
	@Column(name = "SetTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  
	private Date setTime;

	// 设置人姓名
	@Column(name = "SetName")
	private String setName;

	// 设置人id
	@Column(name = "SetId")
	private String setId;

	// 是否有效
	@Column(name = "IsValid")
	private String isValid;

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
	 * @return BanLetter
	 */
	public String getBanLetter() {
		return banLetter;
	}

	/**
	 * @param banLetter
	 */
	public void setBanLetter(String banLetter) {
		this.banLetter = banLetter;
	}

	/**
	 * @return BanType
	 */
	public String getBanType() {
		return banType;
	}

	/**
	 * @param banType
	 */
	public void setBanType(String banType) {
		this.banType = banType;
	}

	/**
	 * @return BanFrom
	 */
	public Date getBanFrom() {
		return banFrom;
	}

	/**
	 * @param banFrom
	 */
	public void setBanFrom(Date banFrom) {
		this.banFrom = banFrom;
	}

	/**
	 * @return BanTo
	 */
	public Date getBanTo() {
		return banTo;
	}

	/**
	 * @param banTo
	 */
	public void setBanTo(Date banTo) {
		this.banTo = banTo;
	}

	/**
	 * @return BanExp
	 */
	public String getBanExp() {
		return banExp;
	}

	/**
	 * @param banExp
	 */
	public void setBanExp(String banExp) {
		this.banExp = banExp;
	}

	/**
	 * @return BanLettPinY
	 */
	public String getBanLettPinY() {
		return banLettPinY;
	}

	/**
	 * @param banLettPinY
	 */
	public void setBanLettPinY(String banLettPinY) {
		this.banLettPinY = banLettPinY;
	}

	/**
	 * @return SetTime
	 */
	public Date getSetTime() {
		return setTime;
	}

	/**
	 * @param setTime
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	/**
	 * @return SetName
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * @param setName
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * @return SetId
	 */
	public String getSetId() {
		return setId;
	}

	/**
	 * @param setId
	 */
	public void setSetId(String setId) {
		this.setId = setId;
	}

	/**
	 * @return IsValid
	 */
	public String getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid
	 */
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SysForbidword [id=");
		builder.append(id);
		builder.append(", banLetter=");
		builder.append(banLetter);
		builder.append(", banType=");
		builder.append(banType);
		builder.append(", banFrom=");
		builder.append(banFrom);
		builder.append(", banTo=");
		builder.append(banTo);
		builder.append(", banExp=");
		builder.append(banExp);
		builder.append(", banLettPinY=");
		builder.append(banLettPinY);
		builder.append(", setTime=");
		builder.append(setTime);
		builder.append(", setName=");
		builder.append(setName);
		builder.append(", setId=");
		builder.append(setId);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append("]");
		return builder.toString();
	}
	
}