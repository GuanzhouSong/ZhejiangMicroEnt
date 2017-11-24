/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.dto;

import com.icinfo.cs.system.model.SysUserAreaManage;

/**
 * 描述:   111111 SYS_USER_AREA_ADMIN 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@SuppressWarnings("serial")
public class SysUserAreaManageDto extends SysUserAreaManage {
	//用户名
	private String username;
	//用户姓名
	private String realName;
	//手机号码
	private String telPhone;
	//座机
	private String phone;
	//职务
	private String post;
	//部门编码
	private String deptCode;
	//部门名称
	private String orgName;
	
	private String jurUnit;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getJurUnit() {
		return jurUnit;
	}
	public void setJurUnit(String jurUnit) {
		this.jurUnit = jurUnit;
	}
}