/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述: cs_pub_scent_result_material 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月13日
 */
@Table(name = "cs_pub_scent_result_material")
public class PubScentResultMaterial implements Serializable {
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 检查日期起
	 */
	@Column(name = "CheckDateFrom")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkDateFrom;

	/**
	 * 检查日期止
	 */
	@Column(name = "CheckDateTo")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkDateTo;

	/**
	 * 检查事项结果uid
	 */
	@Column(name = "ResultUid")
	private String resultUid;

	/**
	 * 序号uuid
	 */
	@Column(name = "uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

	/**
	 * 需要准备的资料
	 */
	@Column(name = "Material")
	private String material;

	@Column(name = "FillDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fillDate;// 通知书填写日期

	@Column(name = "ContactName")
	private String contactName;// 联系人

	@Column(name = "ContactTel")
	private String contactTel;// 联系电话

	@Column(name = "DepartMent")
	private String departMent;// 部门

	@Column(name = "TaskUid")
	private String taskUid;// 任务表uid

	@Column(name = "MainTaskUid")
	private String mainTaskUid;// 主任务表taskUid

	private static final long serialVersionUID = 1L;

	public String getTaskUid() {
		return taskUid;
	}

	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}

	public String getMainTaskUid() {
		return mainTaskUid;
	}

	public void setMainTaskUid(String mainTaskUid) {
		this.mainTaskUid = mainTaskUid;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getDepartMent() {
		return departMent;
	}

	public void setDepartMent(String departMent) {
		this.departMent = departMent;
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
	 * 获取检查日期起
	 *
	 * @return CheckDateFrom - 检查日期起
	 */
	public Date getCheckDateFrom() {
		return checkDateFrom;
	}

	/**
	 * 设置检查日期起
	 *
	 * @param checkDateFrom
	 *            检查日期起
	 */
	public void setCheckDateFrom(Date checkDateFrom) {
		this.checkDateFrom = checkDateFrom;
	}

	/**
	 * 获取检查日期止
	 *
	 * @return CheckDateTo - 检查日期止
	 */
	public Date getCheckDateTo() {
		return checkDateTo;
	}

	/**
	 * 设置检查日期止
	 *
	 * @param checkDateTo
	 *            检查日期止
	 */
	public void setCheckDateTo(Date checkDateTo) {
		this.checkDateTo = checkDateTo;
	}

	/**
	 * 获取检查事项结果uid
	 *
	 * @return ResultUid - 检查事项结果uid
	 */
	public String getResultUid() {
		return resultUid;
	}

	/**
	 * 设置检查事项结果uid
	 *
	 * @param resultUid
	 *            检查事项结果uid
	 */
	public void setResultUid(String resultUid) {
		this.resultUid = resultUid;
	}

	/**
	 * 获取序号uuid
	 *
	 * @return uid - 序号uuid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置序号uuid
	 *
	 * @param uid
	 *            序号uuid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取需要准备的资料
	 *
	 * @return Material - 需要准备的资料
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * 设置需要准备的资料
	 *
	 * @param material
	 *            需要准备的资料
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	public Date getFillDate() {
		return fillDate;
	}

	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}
}