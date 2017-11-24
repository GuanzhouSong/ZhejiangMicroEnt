/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.system.model;

import java.util.List;

/**
 * 描述: 日志Json.<br>
 * 
 * @author chenxin
 * @date 2016年09月19日
 */
public class SysLogJson {	
	private List<SysLogTable> dataList;	
	public SysLogJson(){}
	public SysLogJson(List<SysLogTable> dataList){
		this.dataList = dataList;
	}
	public List<SysLogTable> getDataList() {
		return dataList;
	}
	public void setDataList(List<SysLogTable> dataList) {
		this.dataList = dataList;
	}
}
