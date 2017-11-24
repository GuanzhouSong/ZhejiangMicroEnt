/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import java.util.List;

import com.icinfo.cs.sccheck.model.PubScentBack;

/**
 * 描述:    cs_pub_scent_back 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public class PubScentBackDto extends PubScentBack {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4842051923768940212L;
	//前台传入参数
	private List<String> priPIDs;
	//批量删除
	private List<String> delUidList;
	
	private Integer specialNum;

	public Integer getSpecialNum() {
		return specialNum;
	}

	public void setSpecialNum(Integer specialNum) {
		this.specialNum = specialNum;
	}

	public List<String> getPriPIDs() {
		return priPIDs;
	}

	public void setPriPIDs(List<String> priPIDs) {
		this.priPIDs = priPIDs;
	}

	public List<String> getDelUidList() {
		return delUidList;
	}

	public void setDelUidList(List<String> delUidList) {
		this.delUidList = delUidList;
	}
	
	
}