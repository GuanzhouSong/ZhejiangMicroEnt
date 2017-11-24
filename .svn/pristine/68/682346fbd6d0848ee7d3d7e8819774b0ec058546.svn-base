/*
\ * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.dto;

import java.util.Date;

import com.icinfo.cs.copysend.model.CopySend;

/**
 * 描述:    cs_copy_send 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
public class CopySendDto extends CopySend {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//抄告抄送接收部门名称
	private String acceptDepartName;
	//抄告抄送接收部门编码
	private String acceptDepartCode;
	//当事人名字
	private String clientName;
	//当事人证件号
	private String certNo;
	//接收部门抄告状态
	private int fkState;
	
	//抄告抄送部门名称串
	private String departNames;
	//抄告抄送部门编码串
	private String departCodes;
	
	//涉嫌违法当事人信息json
	private String illegalStr;
	
	public String getAcceptDepartName() {
		return acceptDepartName;
	}
	public void setAcceptDepartName(String acceptDepartName) {
		this.acceptDepartName = acceptDepartName;
	}
	public String getAcceptDepartCode() {
		return acceptDepartCode;
	}
	public void setAcceptDepartCode(String acceptDepartCode) {
		this.acceptDepartCode = acceptDepartCode;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public int getFkState() {
		return fkState;
	}
	public void setFkState(int fkState) {
		this.fkState = fkState;
	}
	public String getDepartNames() {
		return departNames;
	}
	public void setDepartNames(String departNames) {
		this.departNames = departNames;
	}
	public String getDepartCodes() {
		return departCodes;
	}
	public void setDepartCodes(String departCodes) {
		this.departCodes = departCodes;
	}
	
	public String getCopyInfoFromName(){
		if("jcfx".equals(getCopyInfoFrom()))
			return "检查发现";
		if("qzjb".equals(getCopyInfoFrom()))
			return "群众举报";
		if("sjjb".equals(getCopyInfoFrom()))
			return "上级交办";
		if("qt".equals(getCopyInfoFrom()))
			return "其他";
		return null;
	}
	
	public String getCopyTypeName(){
		if("wzwz".equals(getCopyType()))
			return "无证无照";
		if("qywfaj".equals(getCopyType()))
			return "企业违法案件线索";
		if("qt".equals(getCopyType()))
			return "其他情况抄告";
		return null;
	}
	public String getCopyStateName(){
		if("dsh".equals(getCopyState()))
			return "抄告申请待审核";
		if("yshth".equals(getCopyState()))
			return "抄告申请被退回";
		if("ycgfkz".equals(getCopyState()))
			return "已抄告待反馈";
		if("ycgfkwc".equals(getCopyState()))
			return "已抄告已反馈";
		if("qxcg".equals(getCopyState()))
			return "取消抄告";
		if("ycgwc".equals(getCopyState()))
			return "已抄告完成";
		return null;
	}
	public String getIllegalStr() {
		return illegalStr;
	}
	public void setIllegalStr(String illegalStr) {
		this.illegalStr = illegalStr;
	}

	
	
}