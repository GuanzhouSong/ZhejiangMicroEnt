/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述: cs_email_task_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年11月14日
 */
@Table(name = "cs_email_task_info")
public class EmailTaskInfo implements Serializable {
	/**
	 * 自增id
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 任务序号
	 */
	@Column(name = "TaskUid")
	private String taskUid;

	/**
	 * 序号
	 */
	@Column(name = "Uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

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
	 * 统一代码
	 */
	@Column(name = "UniSCID")
	private String uniSCID;

	/**
	 * 企业类型大类
	 */
	@Column(name = "EntTypeCatg")
	private String entTypeCatg;

	/**
	 * 成立日期
	 */
	@Column(name = "EstDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date estDate;

	/**
	 * 邮箱
	 */
	@Column(name = "Email")
	private String email;

	/**
	 * 登记机关名称
	 */
	@Column(name = "RegOrgName")
	private String regOrgName;

	/**
	 * 管辖单位名称
	 */
	@Column(name = "LocalAdmName")
	private String localAdmName;

	/**
	 * 片区名称
	 */
	@Column(name = "SliceNoName")
	private String sliceNoName;

	/**
	 * 创建时间
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 * 获取任务序号
	 *
	 * @return TaskUid - 任务序号
	 */
	public String getTaskUid() {
		return taskUid;
	}

	/**
	 * 设置任务序号
	 *
	 * @param taskUid
	 *            任务序号
	 */
	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}

	/**
	 * 获取序号
	 *
	 * @return Uid - 序号
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置序号
	 *
	 * @param uid
	 *            序号
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * @param entName
	 *            企业名称
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
	 * @param regNO
	 *            注册号
	 */
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	/**
	 * 获取统一代码
	 *
	 * @return UniSCID - 统一代码
	 */
	public String getUniSCID() {
		return uniSCID;
	}

	/**
	 * 设置统一代码
	 *
	 * @param uniSCID
	 *            统一代码
	 */
	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
	}

	/**
	 * 获取企业类型大类
	 *
	 * @return EntTypeCatg - 企业类型大类
	 */
	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	/**
	 * 设置企业类型大类
	 *
	 * @param entTypeCatg
	 *            企业类型大类
	 */
	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	/**
	 * 获取成立日期
	 *
	 * @return EstDate - 成立日期
	 */
	public Date getEstDate() {
		return estDate;
	}

	/**
	 * 设置成立日期
	 *
	 * @param estDate
	 *            成立日期
	 */
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	/**
	 * 获取邮箱
	 *
	 * @return Email - 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱
	 *
	 * @param email
	 *            邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取登记机关名称
	 *
	 * @return RegOrgName - 登记机关名称
	 */
	public String getRegOrgName() {
		return regOrgName;
	}

	/**
	 * 设置登记机关名称
	 *
	 * @param regOrgName
	 *            登记机关名称
	 */
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	/**
	 * 获取管辖单位名称
	 *
	 * @return LocalAdmName - 管辖单位名称
	 */
	public String getLocalAdmName() {
		return localAdmName;
	}

	/**
	 * 设置管辖单位名称
	 *
	 * @param localAdmName
	 *            管辖单位名称
	 */
	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	/**
	 * 获取片区名称
	 *
	 * @return SliceNoName - 片区名称
	 */
	public String getSliceNoName() {
		return sliceNoName;
	}

	/**
	 * 设置片区名称
	 *
	 * @param sliceNoName
	 *            片区名称
	 */
	public void setSliceNoName(String sliceNoName) {
		this.sliceNoName = sliceNoName;
	}
}