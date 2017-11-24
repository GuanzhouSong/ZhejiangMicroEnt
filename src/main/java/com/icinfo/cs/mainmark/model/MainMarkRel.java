/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.mainmark.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述: cs_main_mark_rel 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年03月29日
 */
@Table(name = "cs_main_mark_rel")
public class MainMarkRel implements Serializable {
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 设置部门编号
	 */
	@Column(name = "MarkCode")
	private String markCode;

	@Column(name = "MarkUuid")
	private String markUuid;

	@Column(name = "MarkName")
	private String markName;

	@Column(name = "Type")
	private String type;

	@Column(name = "Ishis")
	private String ishis;

	public String getIshis() {
		return ishis;
	}

	public void setIshis(String ishis) {
		this.ishis = ishis;
	}

	public String getMarkUuid() {
		return markUuid;
	}

	public void setMarkUuid(String markUuid) {
		this.markUuid = markUuid;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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
	 * @param priPID
	 *            主体身份代码
	 */
	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * 获取设置部门编号
	 *
	 * @return MarkCode - 设置部门编号
	 */
	public String getMarkCode() {
		return markCode;
	}

	/**
	 * 设置设置部门编号
	 *
	 * @param markCode
	 *            设置部门编号
	 */
	public void setMarkCode(String markCode) {
		this.markCode = markCode;
	}
}