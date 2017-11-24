/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.supervise.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.supervise.model.CsSuperviseObj;

/**
 * 描述:    cs_supervise_obj 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public class CsSuperviseObjDto extends CsSuperviseObj {
	
	/*统一社会代码*/
	private String uniscid;
	/*注册号*/
	private String regNO;
	/*企业名称*/
	private String entName;
	/*管辖单位*/
	private String localAdm;
	/*登记机关*/
	private String regOrg;
	
	//标识名称
	private String markName;
	//标识开始日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date markStartDate;
	//标识结束日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date markEndDate;
	//标识等级
	private String markClass;
	//标识使用地区
	private String markUseArea;
	//监管标识状态
	private String markState;
	//表示创建日期
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date markCreateTime;
	
	//登记机关名称
	private String regOrgName;
	
	//管辖单位
	private String localAdmName;
	//法定代表人
	private String leRep;
	//企业类型
	private String entType;
	//行业
	private String industryCo;
	//住所
	private String dom;
	
	/**
	 * 统一批次内部序号串
	 * 
	 * xxx;xxx;xxx;...
	 * 
	 */
	private String priPIDStr;

	public String getPriPIDStr() {
		return priPIDStr;
	}

	public void setPriPIDStr(String priPIDStr) {
		this.priPIDStr = priPIDStr;
	}

	public String getUniscid() {
		return uniscid;
	}

	public void setUniscid(String uniscid) {
		this.uniscid = uniscid;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public Date getMarkStartDate() {
		return markStartDate;
	}

	public void setMarkStartDate(Date markStartDate) {
		this.markStartDate = markStartDate;
	}

	public Date getMarkEndDate() {
		return markEndDate;
	}

	public void setMarkEndDate(Date markEndDate) {
		this.markEndDate = markEndDate;
	}

	public String getMarkClass() {
		return markClass;
	}

	public void setMarkClass(String markClass) {
		this.markClass = markClass;
	}

	public String getMarkUseArea() {
		return markUseArea;
	}

	public void setMarkUseArea(String markUseArea) {
		this.markUseArea = markUseArea;
	}

	public String getMarkStartDateDesc(){
		try {
			return DateUtil.dateToString(this.markStartDate, "yyyy-MM-dd");
		} catch (Exception e) {
			return "-";
		}
	}
	
	public String getMarkEndDateDesc(){
		try {
			return DateUtil.dateToString(this.markEndDate, "yyyy-MM-dd");
		} catch (Exception e) {
			return "-";
		}
	}
	
	public String getCheckDateDesc(){
		try {
			return DateUtil.dateToString(super.getCheckDate(), "yyyy-MM-dd");
		} catch (Exception e) {
			return "-";
		}
	}
	
	public String getInputDateDesc(){
		try {
			return DateUtil.dateToString(super.getInputDate(), "yyyy-MM-dd");
		} catch (Exception e) {
			return "-";
		}
	}
	
	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getIndustryCo() {
		return industryCo;
	}

	public void setIndustryCo(String industryCo) {
		this.industryCo = industryCo;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getMarkState() {
		return markState;
	}

	public void setMarkState(String markState) {
		this.markState = markState;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public Date getMarkCreateTime() {
		return markCreateTime;
	}

	public void setMarkCreateTime(Date markCreateTime) {
		this.markCreateTime = markCreateTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
}