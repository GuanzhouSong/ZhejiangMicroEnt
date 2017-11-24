/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registmanage.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述: cs_inv_manager 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年11月22日
 */
@Table(name = "cs_inv_manager")
public class InvManager implements Serializable {
	/**
	 * 自增id
	 */
	@Column(name = "id")
	private Integer id;

	/**
	 * uuid
	 */
	@Column(name = "Uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

	/**
	 * 主体代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 是否分期出资：1是0否
	 */
	@Column(name = "IsInvStages")
	private String isInvStages;

	/**
	 * 出资到位情况：1零出资2部分出资3全额出资
	 */
	@Column(name = "InvPlace")
	private String invPlace;

	/**
	 * 出资到期情况：1未到期2将到期3已到期
	 */
	@Column(name = "InvExpire")
	private String invExpire;

	/**
	 * 最近应出资期限
	 */
	@Column(name = "LastTermInvDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastTermInvDate;

	/**
	 * 最末应出资期限
	 */
	@Column(name = "EndTermInvDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endTermInvDate;

	/**
	 * 正在进行简易注销：1是0否
	 */
	@Column(name = "IsSim")
	private String isSim;

	/**
	 * 实缴公示总额
	 */
	@Column(name = "PaidPubTotal")
	private BigDecimal paidPubTotal;

	/**
	 * 设置日期
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date setDate;

	/**
	 * 设置人
	 */
	private String setName;

	private static final long serialVersionUID = 1L;

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

	public Date getSetDate() {
		return setDate;
	}

	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * 获取uuid
	 *
	 * @return Uid - uuid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置uuid
	 *
	 * @param uid
	 *            uuid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取主体代码
	 *
	 * @return PriPID - 主体代码
	 */
	public String getPriPID() {
		return priPID;
	}

	/**
	 * 设置主体代码
	 *
	 * @param priPID
	 *            主体代码
	 */
	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * 获取是否分期出资：1是0否
	 *
	 * @return IsInvStages - 是否分期出资：1是0否
	 */
	public String getIsInvStages() {
		return isInvStages;
	}

	/**
	 * 设置是否分期出资：1是0否
	 *
	 * @param isInvStages
	 *            是否分期出资：1是0否
	 */
	public void setIsInvStages(String isInvStages) {
		this.isInvStages = isInvStages;
	}

	/**
	 * 获取出资到位情况：1零出资2部分出资3全额出资
	 *
	 * @return InvPlace - 出资到位情况：1零出资2部分出资3全额出资
	 */
	public String getInvPlace() {
		return invPlace;
	}

	/**
	 * 设置出资到位情况：1零出资2部分出资3全额出资
	 *
	 * @param invPlace
	 *            出资到位情况：1零出资2部分出资3全额出资
	 */
	public void setInvPlace(String invPlace) {
		this.invPlace = invPlace;
	}

	/**
	 * 获取出资到期情况：1未到期2将到期3已到期
	 *
	 * @return InvExpire - 出资到期情况：1未到期2将到期3已到期
	 */
	public String getInvExpire() {
		return invExpire;
	}

	/**
	 * 设置出资到期情况：1未到期2将到期3已到期
	 *
	 * @param invExpire
	 *            出资到期情况：1未到期2将到期3已到期
	 */
	public void setInvExpire(String invExpire) {
		this.invExpire = invExpire;
	}

	public Date getLastTermInvDate() {
		return lastTermInvDate;
	}

	public void setLastTermInvDate(Date lastTermInvDate) {
		this.lastTermInvDate = lastTermInvDate;
	}

	public Date getEndTermInvDate() {
		return endTermInvDate;
	}

	public void setEndTermInvDate(Date endTermInvDate) {
		this.endTermInvDate = endTermInvDate;
	}

	/**
	 * 获取正在进行简易注销：1是0否
	 *
	 * @return IsSim - 正在进行简易注销：1是0否
	 */
	public String getIsSim() {
		return isSim;
	}

	/**
	 * 设置正在进行简易注销：1是0否
	 *
	 * @param isSim
	 *            正在进行简易注销：1是0否
	 */
	public void setIsSim(String isSim) {
		this.isSim = isSim;
	}

	/**
	 * 获取实缴公示总额
	 *
	 * @return PaidPubTotal - 实缴公示总额
	 */
	public BigDecimal getPaidPubTotal() {
		return paidPubTotal;
	}

	/**
	 * 设置实缴公示总额
	 *
	 * @param paidPubTotal
	 *            实缴公示总额
	 */
	public void setPaidPubTotal(BigDecimal paidPubTotal) {
		this.paidPubTotal = paidPubTotal;
	}
}