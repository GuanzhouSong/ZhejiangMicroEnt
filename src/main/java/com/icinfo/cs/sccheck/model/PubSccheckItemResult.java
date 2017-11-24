/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述: cs_pub_sccheck_item_result 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_sccheck_item_result")
public class PubSccheckItemResult implements Serializable {
	/**
	 * 自增序号
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 序号：UUID
	 */
	@Column(name = "Uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

	/**
	 * 企业主体代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 抽查建任务Uid
	 */
	@Column(name = "TaskUid")
	private String taskUid;

	/**
	 * 检查类别编码
	 */
	@Column(name = "CheckType")
	private String checkType;

	/**
	 * 检查类别描述
	 */
	@Column(name = "CheckTypeName")
	private String checkTypeName;

	/**
	 * 检查事项编码
	 */
	@Column(name = "CheckCode")
	private String checkCode;

	/**
	 * 检查事项名称
	 */
	@Column(name = "CheckName")
	private String checkName;

	/**
	 * 说明
	 */
	@Column(name = "Remark")
	private String remark;

	/**
	 * 是否检查：是-1，否-0
	 */
	@Column(name = "IsCheck")
	private String isCheck;

	/**
	 * 发现问题情况
	 */
	@Column(name = "Problem")
	private String problem;

	/**
	 * 处置情况
	 */
	@Column(name = "Dispose")
	private String dispose;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取自增序号
	 *
	 * @return id - 自增序号
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置自增序号
	 *
	 * @param id
	 *            自增序号
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取序号：UUID
	 *
	 * @return Uid - 序号：UUID
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置序号：UUID
	 *
	 * @param uid
	 *            序号：UUID
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取企业主体代码
	 *
	 * @return PriPID - 企业主体代码
	 */
	public String getPriPID() {
		return priPID;
	}

	/**
	 * 设置企业主体代码
	 *
	 * @param priPID
	 *            企业主体代码
	 */
	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * 获取抽查建任务Uid
	 *
	 * @return TaskUid - 抽查建任务Uid
	 */
	public String getTaskUid() {
		return taskUid;
	}

	/**
	 * 设置抽查建任务Uid
	 *
	 * @param taskUid
	 *            抽查建任务Uid
	 */
	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}

	/**
	 * 获取检查类别编码
	 *
	 * @return CheckType - 检查类别编码
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * 设置检查类别编码
	 *
	 * @param checkType
	 *            检查类别编码
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	/**
	 * 获取检查类别描述
	 *
	 * @return CheckTypeName - 检查类别描述
	 */
	public String getCheckTypeName() {
		return checkTypeName;
	}

	/**
	 * 设置检查类别描述
	 *
	 * @param checkTypeName
	 *            检查类别描述
	 */
	public void setCheckTypeName(String checkTypeName) {
		this.checkTypeName = checkTypeName;
	}

	/**
	 * 获取检查事项编码
	 *
	 * @return CheckCode - 检查事项编码
	 */
	public String getCheckCode() {
		return checkCode;
	}

	/**
	 * 设置检查事项编码
	 *
	 * @param checkCode
	 *            检查事项编码
	 */
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * 获取检查事项名称
	 *
	 * @return CheckName - 检查事项名称
	 */
	public String getCheckName() {
		return checkName;
	}

	/**
	 * 设置检查事项名称
	 *
	 * @param checkName
	 *            检查事项名称
	 */
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	/**
	 * 获取说明
	 *
	 * @return Remark - 说明
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置说明
	 *
	 * @param remark
	 *            说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取是否检查：是-1，否-0
	 *
	 * @return IsCheck - 是否检查：是-1，否-0
	 */
	public String getIsCheck() {
		return isCheck;
	}

	/**
	 * 设置是否检查：是-1，否-0
	 *
	 * @param isCheck
	 *            是否检查：是-1，否-0
	 */
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * 获取发现问题情况
	 *
	 * @return Problem - 发现问题情况
	 */
	public String getProblem() {
		return problem;
	}

	/**
	 * 设置发现问题情况
	 *
	 * @param problem
	 *            发现问题情况
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}

	/**
	 * 获取处置情况
	 *
	 * @return Dispose - 处置情况
	 */
	public String getDispose() {
		return dispose;
	}

	/**
	 * 设置处置情况
	 *
	 * @param dispose
	 *            处置情况
	 */
	public void setDispose(String dispose) {
		this.dispose = dispose;
	}
}