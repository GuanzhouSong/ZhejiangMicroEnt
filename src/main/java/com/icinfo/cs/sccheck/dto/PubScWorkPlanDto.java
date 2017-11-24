/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import com.icinfo.cs.sccheck.model.PubScWorkPlan;

/**
 * 描述:    cs_pub_scwork_plan 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public class PubScWorkPlanDto extends PubScWorkPlan {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1624733720436646609L;
	
	//总任务量
	private Integer totalWork;
	
	//本部门任务数量
	private Integer ownNum;
	
	//跨部门任务数量
	private Integer crossNum;

	//已抽取企业数量
	private Integer entNum;

	public Integer getTotalWork() {
		return totalWork;
	}

	public void setTotalWork(Integer totalWork) {
		this.totalWork = totalWork;
	}

	public Integer getOwnNum() {
		return ownNum;
	}

	public void setOwnNum(Integer ownNum) {
		this.ownNum = ownNum;
	}

	public Integer getCrossNum() {
		return crossNum;
	}

	public void setCrossNum(Integer crossNum) {
		this.crossNum = crossNum;
	}

	public Integer getEntNum() {
		return entNum;
	}

	public void setEntNum(Integer entNum) {
		this.entNum = entNum;
	}
	
	
}