/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptdto;

import com.icinfo.cs.rpt.rptmodel.DeptPubInfoRpt;

/**
 * 描述: cs_rpt_public_info 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
@SuppressWarnings("serial")
public class DeptPubInfoRptDto extends DeptPubInfoRpt {
	// 部门名称
	private String deptName;
	
	//来源其他部门异常名录户数
	private Integer otherpanomlyH;
	//来源其他部门异常名录条数
	private Integer otherpanomlyT;
	//来源其他部门严重违法户数
	private Integer otherillDisHoneH;
	//来源其他部门严重违法条数
	private Integer otherillDisHoneT;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getOtherpanomlyH() {
		return otherpanomlyH;
	}
	public void setOtherpanomlyH(Integer otherpanomlyH) {
		this.otherpanomlyH = otherpanomlyH;
	}
	public Integer getOtherpanomlyT() {
		return otherpanomlyT;
	}
	public void setOtherpanomlyT(Integer otherpanomlyT) {
		this.otherpanomlyT = otherpanomlyT;
	}
	public Integer getOtherillDisHoneH() {
		return otherillDisHoneH;
	}
	public void setOtherillDisHoneH(Integer otherillDisHoneH) {
		this.otherillDisHoneH = otherillDisHoneH;
	}
	public Integer getOtherillDisHoneT() {
		return otherillDisHoneT;
	}
	public void setOtherillDisHoneT(Integer otherillDisHoneT) {
		this.otherillDisHoneT = otherillDisHoneT;
	}
	
	

}