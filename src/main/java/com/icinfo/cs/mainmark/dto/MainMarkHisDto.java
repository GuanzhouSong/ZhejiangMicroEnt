/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.mainmark.dto;

import com.icinfo.cs.mainmark.model.MainMarkHis;

/**
 * 描述: cs_main_mark_his 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public class MainMarkHisDto extends MainMarkHis {
	//TODO
	private static final long serialVersionUID = 1L;
	private String MarkName2;
	private String MarkName3;
	private String MarkName4;

	public String getMarkName2() {
		return MarkName2;
	}

	public void setMarkName2(String markName2) {
		MarkName2 = markName2;
	}

	public String getMarkName3() {
		return MarkName3;
	}

	public void setMarkName3(String markName3) {
		MarkName3 = markName3;
	}

	public String getMarkName4() {
		return MarkName4;
	}

	public void setMarkName4(String markName4) {
		MarkName4 = markName4;
	}
}