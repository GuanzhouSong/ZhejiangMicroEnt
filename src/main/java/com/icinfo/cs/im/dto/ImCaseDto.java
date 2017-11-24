/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.dto;


import java.util.List;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_im_case 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public class ImCaseDto extends ImCase {
	public List<ImCasalt> caslatList;

	public List<ImCasalt> getCaslatList() {
		return caslatList;
	}

	public void setCaslatList(List<ImCasalt> caslatList) {
		this.caslatList = caslatList;
	}

	 
	public String getPublicDateDesc(){
		try {
			return DateUtil.dateToString(super.getPublicDate(), "yyyy-MM-dd");
		} catch (Exception e) {
			return "-";
		}
	}
	
}