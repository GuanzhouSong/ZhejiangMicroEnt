/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.risk.model.CsEntWarn;

/**
 * 描述:    cs_ent_warn 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public class CsEntWarnDto extends CsEntWarn {
	/**
	 * 统一信用代码
	 */
	private String uniscid;
	 /**
     *注册号
     */
    private String regNO;

    /**
     * 法定代表人
     */
    private String leRep;
    /**
     * 企业名称
     */
    private String entName;

    /**
     * 企业类型
     */
    private String entType;
    
    /**
     * 管辖单位
     */
    private String localAdm;
    
    /**
     * 登记机关
     */
    private String regOrg;
    /**
     * 住所
     */
    private String dom;
    /**
     * 行业编码
     */
    private String industryCo;
	 /**
     * 预警标识名称
     */
    private String markName;

    /**
     * 预警标识内容
     */
    private String markContent;

    /**
     * 预警标识级别
     */
    private String markClass;

    /**
     * 预警标识指定提示方式
     */
    private String markAppointWay;

    /**
     * 预警标识指定提示部门编码
     */
    private String markAppointDeptCode;

    /**
     * 预警标识指定提示部门
     */
    private String markAppointDept;

    /**
     * 预警标识开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date markStartDate;

    /**
     * 预警标识结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date markEndDate;

    /**
     * 预警标识设置年度
     */
    private String markSetYear;

    /**
     * 预警标识类型
     */
    private String markType;
    
    /**
     * 指定提示部门
     */
    private String markSetDept;
    
    /**
     * 设置时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date markSetDate;
    
    /**
     * 设置部门联系人
     */
    private String setDeptContact;
    
    /**
     * 联系电话
     */
    private String tel;
    
    /**
     * 传真
     */
    private String fax;
    
    /**
     * 邮箱
     */
    private String email;
    /**
     * 预警标识设置部门编码
     */
    private String markSetDeptCode;
    /**
     * 企业基本信息数组
     */
    private String entStr;
    /**
     * 标识有效性
     */
    private String markState;
    
    /**
     * 请求来源，0：申请，1：审核
     */
    private String urlFlag;
    /**
     * 是否有预警历史信息
     */
    private String isWarnHis;
    
    /**
     *是否需要查询历史记录 
     */
    private String needHis;
	public String getRegNO() {
		return regNO;
	}
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}
	public String getLeRep() {
		return leRep;
	}
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntType() {
		return entType;
	}
	public void setEntType(String entType) {
		this.entType = entType;
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
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}
	public String getIndustryCo() {
		return industryCo;
	}
	public void setIndustryCo(String industryCo) {
		this.industryCo = industryCo;
	}
	public String getMarkName() {
		return markName;
	}
	public void setMarkName(String markName) {
		this.markName = markName;
	}
	public String getMarkContent() {
		return markContent;
	}
	public void setMarkContent(String markContent) {
		this.markContent = markContent;
	}
	public String getMarkClass() {
		return markClass;
	}
	public void setMarkClass(String markClass) {
		this.markClass = markClass;
	}
	public String getMarkAppointWay() {
		return markAppointWay;
	}
	public void setMarkAppointWay(String markAppointWay) {
		this.markAppointWay = markAppointWay;
	}
	public String getMarkAppointDeptCode() {
		return markAppointDeptCode;
	}
	public void setMarkAppointDeptCode(String markAppointDeptCode) {
		this.markAppointDeptCode = markAppointDeptCode;
	}
	public String getMarkAppointDept() {
		return markAppointDept;
	}
	public void setMarkAppointDept(String markAppointDept) {
		this.markAppointDept = markAppointDept;
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
	public String getMarkSetYear() {
		return markSetYear;
	}
	public void setMarkSetYear(String markSetYear) {
		this.markSetYear = markSetYear;
	}
	public String getMarkType() {
		return markType;
	}
	public void setMarkType(String markType) {
		this.markType = markType;
	}
	public String getMarkSetDept() {
		return markSetDept;
	}
	public void setMarkSetDept(String markSetDept) {
		this.markSetDept = markSetDept;
	}
	public Date getMarkSetDate() {
		return markSetDate;
	}
	public void setMarkSetDate(Date markSetDate) {
		this.markSetDate = markSetDate;
	}
	public String getSetDeptContact() {
		return setDeptContact;
	}
	public void setSetDeptContact(String setDeptContact) {
		this.setDeptContact = setDeptContact;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEntStr() {
		return entStr;
	}
	public void setEntStr(String entStr) {
		this.entStr = entStr;
	}
	public String getUrlFlag() {
		return urlFlag;
	}
	public void setUrlFlag(String urlFlag) {
		this.urlFlag = urlFlag;
	}
	public String getIsWarnHis() {
		return isWarnHis;
	}
	public void setIsWarnHis(String isWarnHis) {
		this.isWarnHis = isWarnHis;
	}
	public String getMarkSetDeptCode() {
		return markSetDeptCode;
	}
	public void setMarkSetDeptCode(String markSetDeptCode) {
		this.markSetDeptCode = markSetDeptCode;
	}
	public String getMarkState() {
		return markState;
	}
	public void setMarkState(String markState) {
		this.markState = markState;
	}
	public String getUniscid() {
		return uniscid;
	}
	public void setUniscid(String uniscid) {
		this.uniscid = uniscid;
	}
	public String getNeedHis() {
		return needHis;
	}
	public void setNeedHis(String needHis) {
		this.needHis = needHis;
	}
	
}