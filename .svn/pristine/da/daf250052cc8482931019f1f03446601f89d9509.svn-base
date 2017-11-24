package com.icinfo.cs.nocreditPunish.dto;

import javax.persistence.Column;
import javax.persistence.Transient;

import com.icinfo.cs.nocreditPunish.model.NoCreditPunishInfo;

/**
 * cs_nocredit_punishinfo 对应的DTO类.
 * @author caoxu
 * @date 2016年10月18日
 */
public class NoCreditPunishInfoDto extends NoCreditPunishInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6986855496443719745L;
	
	/**
	 * 当前用户部门是否已反馈
	 */
	private Integer hasBack;
	
	private String priPID;
	
	private String regNo;
	
	private String entName;
	
	private String uniCode;
	
	private String leRep;
	
	private String cardNo;
	
	private String litiName;

	private String downState;
	
	private String exeDateStr;
	
	
	/**
     * 证件类型
     */
	private String cerType;
	
	
	/**
     * 当事人电话
     */
	private String manphone;
	
	/**
     * 惩戒记录
     */
	private String record;
	
	
	/**
     * 惩戒记录条数
     */
	private String recordCount;
	
	
    private String cerTypeDesc;

	public Integer getHasBack() {
		return hasBack;
	}

	public void setHasBack(Integer hasBack) {
		this.hasBack = hasBack;
	}

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	public String getDownState() {
		return downState;
	}

	public void setDownState(String downState) {
		this.downState = downState;
	}

	public String getExeDateStr() {
		return exeDateStr;
	}

	public void setExeDateStr(String exeDateStr) {
		this.exeDateStr = exeDateStr;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getManphone() {
		return manphone;
	}

	public void setManphone(String manphone) {
		this.manphone = manphone;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
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
	
	
	
}
