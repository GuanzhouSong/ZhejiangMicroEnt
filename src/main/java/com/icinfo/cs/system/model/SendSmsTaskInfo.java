/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: cs_sendsms_task_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年02月21日
 */
@Table(name = "cs_sendsms_task_info")
public class SendSmsTaskInfo implements Serializable {

	/**
	 * 自增主键ID
	 */
	@Id
	@Column(name = "id")
	private Long id;

	/**
	 * 短信下发序号
	 */
	@Column(name = "smsid")
	private String smsid;

	/**
	 * 任务序号
	 */
	@Column(name = "taskid")
	private String taskid;

	/**
	 * 注册号
	 */
	@Column(name = "RegNO")
	private String regNO;

	/**
	 * 统一社会信用代码
	 */
	@Column(name = "UniSCID")
	private String uniSCID;

	/**
	 * 企业名称
	 */
	@Column(name = "EntName")
	private String entName;

	/**
	 * 企业大类
	 */
	@Column(name = "EntTypeCatg")
	private String entTypeCatg;

	@Column(name = "UID")
	private String UID;

	/**
	 * 成立日期
	 */
	@Column(name = "EstDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date estDate;

	/**
	 * 企业法人/负责人
	 */
	@Column(name = "LeRep")
	private String leRep;

	/**
	 * 联络员手机号码
	 */
	@Column(name = "liaLeRepPhone")
	private String liaLeRepPhone;

	/**
	 * 负责人手机号码
	 */
	@Column(name = "Tel")
	private String tel;

	/**
	 * 联络员名称
	 */
	@Column(name = "LiaName")
	private String liaName;

	/**
	 * 登记机关
	 */
	@Column(name = "RegOrg")
	private String regOrg;

	/**
	 * 管辖单位
	 */
	@Column(name = "LocalAdm")
	private String localAdm;

	/**
	 * 片区
	 */
	@Column(name = "SliceNo")
	private String sliceNo;

	/**
	 * 负责人短信下发时间
	 */
	@Column(name = "sendLerepTime")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date sendLerepTime;

	/**
	 * 负责人短信下发是否成功
	 */
	@Column(name = "isSendLerep")
	private String isSendLerep;

	/**
	 * 联络员短信下发时间
	 */
	@Column(name = "sendLiaTime")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
	private Date sendLiaTime;

	/**
	 * 联络员短信下发是否成功
	 */
	@Column(name = "isSendLia")
	private String isSendLia;

	@Column(name = "CreateTime")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取短信下发序号
	 *
	 * @return smsid - 短信下发序号
	 */
	public String getSmsid() {
		return smsid;
	}

	/**
	 * 设置短信下发序号
	 *
	 * @param smsid
	 *            短信下发序号
	 */
	public void setSmsid(String smsid) {
		this.smsid = smsid;
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
	 * 获取统一社会信用代码
	 *
	 * @return UniSCID - 统一社会信用代码
	 */
	public String getUniSCID() {
		return uniSCID;
	}

	/**
	 * 设置统一社会信用代码
	 *
	 * @param uniSCID
	 *            统一社会信用代码
	 */
	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
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
	 * 获取企业法人/负责人
	 *
	 * @return LeRep - 企业法人/负责人
	 */
	public String getLeRep() {
		return leRep;
	}

	/**
	 * 设置企业法人/负责人
	 *
	 * @param leRep
	 *            企业法人/负责人
	 */
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	/**
	 * 获取联络员手机号码
	 *
	 * @return liaLeRepPhone - 联络员手机号码
	 */
	public String getLiaLeRepPhone() {
		return liaLeRepPhone;
	}

	/**
	 * 设置联络员手机号码
	 *
	 * @param liaLeRepPhone
	 *            联络员手机号码
	 */
	public void setLiaLeRepPhone(String liaLeRepPhone) {
		this.liaLeRepPhone = liaLeRepPhone;
	}

	/**
	 * 获取负责人手机号码
	 *
	 * @return Tel - 负责人手机号码
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置负责人手机号码
	 *
	 * @param tel
	 *            负责人手机号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 获取联络员名称
	 *
	 * @return LiaName - 联络员名称
	 */
	public String getLiaName() {
		return liaName;
	}

	/**
	 * 设置联络员名称
	 *
	 * @param liaName
	 *            联络员名称
	 */
	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	/**
	 * 获取登记机关
	 *
	 * @return RegOrg - 登记机关
	 */
	public String getRegOrg() {
		return regOrg;
	}

	/**
	 * 设置登记机关
	 *
	 * @param regOrg
	 *            登记机关
	 */
	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	/**
	 * 获取管辖单位
	 *
	 * @return LocalAdm - 管辖单位
	 */
	public String getLocalAdm() {
		return localAdm;
	}

	/**
	 * 设置管辖单位
	 *
	 * @param localAdm
	 *            管辖单位
	 */
	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	/**
	 * 获取片区
	 *
	 * @return SliceNo - 片区
	 */
	public String getSliceNo() {
		return sliceNo;
	}

	/**
	 * 设置片区
	 *
	 * @param sliceNo
	 *            片区
	 */
	public void setSliceNo(String sliceNo) {
		this.sliceNo = sliceNo;
	}

	/**
	 * 获取负责人短信下发时间
	 *
	 * @return sendLerepTime - 负责人短信下发时间
	 */
	public Date getSendLerepTime() {
		return sendLerepTime;
	}

	/**
	 * 设置负责人短信下发时间
	 *
	 * @param sendLerepTime
	 *            负责人短信下发时间
	 */
	public void setSendLerepTime(Date sendLerepTime) {
		this.sendLerepTime = sendLerepTime;
	}

	/**
	 * 获取负责人短信下发是否成功
	 *
	 * @return isSendLerep - 负责人短信下发是否成功
	 */
	public String getIsSendLerep() {
		return isSendLerep;
	}

	/**
	 * 设置负责人短信下发是否成功
	 *
	 * @param isSendLerep
	 *            负责人短信下发是否成功
	 */
	public void setIsSendLerep(String isSendLerep) {
		this.isSendLerep = isSendLerep;
	}

	/**
	 * 获取联络员短信下发时间
	 *
	 * @return sendLiaTime - 联络员短信下发时间
	 */
	public Date getSendLiaTime() {
		return sendLiaTime;
	}

	/**
	 * 设置联络员短信下发时间
	 *
	 * @param sendLiaTime
	 *            联络员短信下发时间
	 */
	public void setSendLiaTime(Date sendLiaTime) {
		this.sendLiaTime = sendLiaTime;
	}

	/**
	 * 获取联络员短信下发是否成功
	 *
	 * @return isSendLia - 联络员短信下发是否成功
	 */
	public String getIsSendLia() {
		return isSendLia;
	}

	/**
	 * 设置联络员短信下发是否成功
	 *
	 * @param isSendLia
	 *            联络员短信下发是否成功
	 */
	public void setIsSendLia(String isSendLia) {
		this.isSendLia = isSendLia;
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

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}
}