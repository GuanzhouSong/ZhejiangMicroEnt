/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.dto;

import java.util.Date;

import com.icinfo.cs.login.model.PubEppassword;

/**
 * 描述:    cs_pub_eppassword 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public class PubEppasswordDto extends PubEppassword {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//法定代表人证件号码
	private String cerNO;
	
	//加密联络员号码
	private String entel;
	
	//加密联络员证件号码
	private String enliaidnum;
	
	//加密联络员姓名
	private String enlianame;
	//加密法定代表人
	private String enlerep;
	//加密证件号码
	private String encerNO;
	
	//登记机关
	private String regOrgName;
	//管辖单位
	private String localAdmName;
	//责任片区
	private String sliceNOName;
	//成立日期
	private Date estDate;
	//企业大类
	private String entTypeCatg;
	
	private Long entCount;
	
	
	public void setCerNO(String cerNO) {
		this.cerNO = cerNO;
	}
	
	public String getCerNO() {
		return cerNO;
	}

	public String getEntel() {
		return entel;
	}

	public void setEntel(String entel) {
		this.entel = entel;
	}

	public String getEnliaidnum() {
		return enliaidnum;
	}

	public void setEnliaidnum(String enliaidnum) {
		this.enliaidnum = enliaidnum;
	}

	public String getEnlianame() {
		return enlianame;
	}

	public void setEnlianame(String enlianame) {
		this.enlianame = enlianame;
	}

	public String getEnlerep() {
		return enlerep;
	}

	public void setEnlerep(String enlerep) {
		this.enlerep = enlerep;
	}

	public String getEncerNO() {
		return encerNO;
	}

	public void setEncerNO(String encerNO) {
		this.encerNO = encerNO;
	}
	
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}
	
	public String getRegOrgName() {
		return regOrgName;
	}
	
	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}
	
	public String getLocalAdmName() {
		return localAdmName;
	}

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	
	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}
	
	public String getEntTypeCatg() {
		return entTypeCatg;
	}

    
    public Long getEntCount(){
        return entCount;
    }

    
    public void setEntCount(Long entCount){
        this.entCount = entCount;
    }
	
}