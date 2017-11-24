/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

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
 * 描述: cs_sendsms_task 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年02月21日
 */
@Table(name = "cs_sendsms_task")
public class SendSmsTask implements Serializable {

	/**
	 * 自增主键ID
	 */
	@Id
	@Column(name = "id")
	private Long id;

	/**
	 * 任务序号
	 */
	@Column(name = "taskid")
	private String taskid;

	/**
	 * 任务名称
	 */
	@Column(name = "taskName")
	private String taskName;

	/**
	 * 任务状态
	 */
	@Column(name = "taskType")
	private String taskType;

	@Column(name = "UID")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String UID;

	/**
	 * 短信内容模板类型
	 */
	@Column(name = "smsType")
	private String smsType;

	/**
	 * 发送对象（负责人）
	 */
	@Column(name = "smsLerep")
	private String smsLerep;

	/**
	 * 发送对象（联络员）
	 */
	@Column(name = "smsLia")
	private String smsLia;

	/**
	 * 任务开始日期
	 */
	@Column(name = "smsDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date smsDate;

	/**
	 * 任务原始名单
	 */
	@Column(name = "smsIntroduction")
	private String smsIntroduction;

	/**
	 * 去重后任务原始名单
	 */
	@Column(name = "rsmsIntroduction")
	private String rsmsIntroduction;

	/**
	 * 手机号码去重（负责人）
	 */
	@Column(name = "repeatLerep")
	private String repeatLerep;

	/**
	 * 手机号码去重（联络员）
	 */
	@Column(name = "repeatLia")
	private String repeatLia;

	/**
	 * 设置人
	 */
	@Column(name = "SetName")
	private String setName;

	/**
	 * 设置日期
	 */
	@Column(name = "SetTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date setTime;

	/**
	 * 部门编码
	 */
	@Column(name = "DeptId")
	private String deptId;

	/**
	 * 部门名称
	 */
	@Column(name = "DeptName")
	private String deptName;

	/**
	 * 创建时间
	 */
	@Column(name = "CreateTime")
	private Date createTime;

	/**
	 * 任务描述
	 */
	@Column(name = "taskInstruction")
	private String taskInstruction;

	/**
	 * 短信内容
	 */
	@Column(name = "smsMsg")
	private String smsMsg;

	private static final long serialVersionUID = 1L;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取任务序号
	 *
	 * @return taskid - 任务序号
	 */
	public String getTaskid() {
		return taskid;
	}

	/**
	 * 设置任务序号
	 *
	 * @param taskid
	 *            任务序号
	 */
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	/**
	 * 获取任务名称
	 *
	 * @return taskName - 任务名称
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 设置任务名称
	 *
	 * @param taskName
	 *            任务名称
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 获取任务状态
	 *
	 * @return taskType - 任务状态
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * 设置任务状态
	 *
	 * @param taskType
	 *            任务状态
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 * 获取短信内容模板类型
	 *
	 * @return smsType - 短信内容模板类型
	 */
	public String getSmsType() {
		return smsType;
	}

	/**
	 * 设置短信内容模板类型
	 *
	 * @param smsType
	 *            短信内容模板类型
	 */
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	/**
	 * 获取发送对象（负责人）
	 *
	 * @return smsLerep - 发送对象（负责人）
	 */
	public String getSmsLerep() {
		return smsLerep;
	}

	/**
	 * 设置发送对象（负责人）
	 *
	 * @param smsLerep
	 *            发送对象（负责人）
	 */
	public void setSmsLerep(String smsLerep) {
		this.smsLerep = smsLerep;
	}

	/**
	 * 获取发送对象（联络员）
	 *
	 * @return smsLia - 发送对象（联络员）
	 */
	public String getSmsLia() {
		return smsLia;
	}

	/**
	 * 设置发送对象（联络员）
	 *
	 * @param smsLia
	 *            发送对象（联络员）
	 */
	public void setSmsLia(String smsLia) {
		this.smsLia = smsLia;
	}

	/**
	 * 获取任务开始日期
	 *
	 * @return smsDate - 任务开始日期
	 */
	public Date getSmsDate() {
		return smsDate;
	}

	/**
	 * 设置任务开始日期
	 *
	 * @param smsDate
	 *            任务开始日期
	 */
	public void setSmsDate(Date smsDate) {
		this.smsDate = smsDate;
	}

	/**
	 * 获取任务原始名单
	 *
	 * @return smsIntroduction - 任务原始名单
	 */
	public String getSmsIntroduction() {
		return smsIntroduction;
	}

	/**
	 * 设置任务原始名单
	 *
	 * @param smsIntroduction
	 *            任务原始名单
	 */
	public void setSmsIntroduction(String smsIntroduction) {
		this.smsIntroduction = smsIntroduction;
	}

	/**
	 * 获取去重后任务原始名单
	 *
	 * @return rsmsIntroduction - 去重后任务原始名单
	 */
	public String getRsmsIntroduction() {
		return rsmsIntroduction;
	}

	/**
	 * 设置去重后任务原始名单
	 *
	 * @param rsmsIntroduction
	 *            去重后任务原始名单
	 */
	public void setRsmsIntroduction(String rsmsIntroduction) {
		this.rsmsIntroduction = rsmsIntroduction;
	}

	/**
	 * 获取手机号码去重（负责人）
	 *
	 * @return repeatLerep - 手机号码去重（负责人）
	 */
	public String getRepeatLerep() {
		return repeatLerep;
	}

	/**
	 * 设置手机号码去重（负责人）
	 *
	 * @param repeatLerep
	 *            手机号码去重（负责人）
	 */
	public void setRepeatLerep(String repeatLerep) {
		this.repeatLerep = repeatLerep;
	}

	/**
	 * 获取手机号码去重（联络员）
	 *
	 * @return repeatLia - 手机号码去重（联络员）
	 */
	public String getRepeatLia() {
		return repeatLia;
	}

	/**
	 * 设置手机号码去重（联络员）
	 *
	 * @param repeatLia
	 *            手机号码去重（联络员）
	 */
	public void setRepeatLia(String repeatLia) {
		this.repeatLia = repeatLia;
	}

	/**
	 * 获取设置人
	 *
	 * @return SetName - 设置人
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * 设置设置人
	 *
	 * @param setName
	 *            设置人
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * 获取设置日期
	 *
	 * @return SetTime - 设置日期
	 */
	public Date getSetTime() {
		return setTime;
	}

	/**
	 * 设置设置日期
	 *
	 * @param setTime
	 *            设置日期
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	/**
	 * 获取部门编码
	 *
	 * @return DeptId - 部门编码
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * 设置部门编码
	 *
	 * @param deptId
	 *            部门编码
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * 获取部门名称
	 *
	 * @return DeptName - 部门名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 设置部门名称
	 *
	 * @param deptName
	 *            部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取创建时间
	 *
	 * @return CreateTime - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取任务描述
	 *
	 * @return taskInstruction - 任务描述
	 */
	public String getTaskInstruction() {
		return taskInstruction;
	}

	/**
	 * 设置任务描述
	 *
	 * @param taskInstruction
	 *            任务描述
	 */
	public void setTaskInstruction(String taskInstruction) {
		this.taskInstruction = taskInstruction;
	}

	/**
	 * 获取短信内容
	 *
	 * @return smsMsg - 短信内容
	 */
	public String getSmsMsg() {
		return smsMsg;
	}

	/**
	 * 设置短信内容
	 *
	 * @param smsMsg
	 *            短信内容
	 */
	public void setSmsMsg(String smsMsg) {
		this.smsMsg = smsMsg;
	}
}