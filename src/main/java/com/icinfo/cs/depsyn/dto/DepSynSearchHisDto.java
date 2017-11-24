package com.icinfo.cs.depsyn.dto;

import com.icinfo.cs.depsyn.model.DepSynSearchHis;

/**
 * 描述:    cs_depsyn_search_his 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年12月10日
 */
public class DepSynSearchHisDto extends DepSynSearchHis {
	
	//距离目前时间
	private String fromNow;

	public String getFromNow() {
		return fromNow;
	}

	public void setFromNow(String fromNow) {
		this.fromNow = fromNow;
	}

}
