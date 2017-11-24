package com.icinfo.cs.nocreditPunish.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * cs_nocredit_punishdetail 对应实体类
 * @author caoxu
 * @date 2016年10月18日
 */
@Table(name = "cs_nocredit_punishdetail")
public class NoCreditPunishDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4831883914693054863L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	/**
     * 批次号
     */
	@Column(name = "BatchNo")
	private String batchNo;
	
	/**
     * 主体代码
     */
	@Column(name = "PriPID")
	private String priPID;
	
	/**
     * 注册号
     */
	@Column(name = "RegNo")
	private String regNo;
	
	/**
     * 企业名称
     */
	@Column(name = "EntName")
	private String entName;
	
	/**
     * 统一社会信用代码
     */
	@Column(name = "UniCode")
	private String uniCode;
	
	/**
     * 证件类型
     */
	@Column(name = "CerType")
	private String cerType;
	
	/**
     * 法定代表人
     */
	@Column(name = "LeRep")
	private String leRep;
	
	/**
     * 身份证号
     */
	@Column(name = "CardNo")
	private String cardNo;
	
	/**
     * 当事人姓名
     */
	@Column(name = "LitiName")
	private String litiName;
	
	/**
     * 当事人电话
     */
	@Column(name = "Phone")
	private String phone;
	
	/**
     * 惩戒记录
     */
	@Column(name = "Record")
	private String record;
	
	
	/**
     * 惩戒记录条数
     */
	@Column(name = "RecordCount")
	private String recordCount;
	
	
	
	@Transient
	private String cerTypeDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getLitiName() {
		return litiName;
	}

	public void setLitiName(String litiName) {
		this.litiName = litiName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public void setCerTypeDesc(String cerTypeDesc) {
		this.cerTypeDesc = cerTypeDesc;
	}

	public String getCerTypeDesc() {
		if (cerType != null && cerType.equals("10")) {
			cerTypeDesc = "居民身份证";
		} else if (cerType != null && cerType.equals("20")) {
			cerTypeDesc = "军官证";
		} else if (cerType != null && cerType.equals("30")) {
			cerTypeDesc = "警官证";
		} else if (cerType != null && cerType.equals("40")) {
			cerTypeDesc = "外国(地区)护照";
		} else if (cerType != null && cerType.equals("52")) {
			cerTypeDesc = "香港身份证";
		} else if (cerType != null && cerType.equals("54")) {
			cerTypeDesc = "澳门身份证";
		} else if (cerType != null && cerType.equals("56")) {
			cerTypeDesc = "台湾身份证";
		} else if (cerType != null && cerType.equals("90")) {
			cerTypeDesc = "其他有效身份证件";
		}
		return cerTypeDesc;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
}
