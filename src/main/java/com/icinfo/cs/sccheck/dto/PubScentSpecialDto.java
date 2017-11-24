/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import com.icinfo.cs.sccheck.model.PubScentSpecial;

/**
 * 描述:    cs_pub_scent_special 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月01日
 */
public class PubScentSpecialDto extends PubScentSpecial {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 289545683491357250L;
	/**
	 * 专项库数量
	 */
	private Integer specialNum;

	public Integer getSpecialNum() {
		return specialNum;
	}

	public void setSpecialNum(Integer specialNum) {
		this.specialNum = specialNum;
	}
	
	
}