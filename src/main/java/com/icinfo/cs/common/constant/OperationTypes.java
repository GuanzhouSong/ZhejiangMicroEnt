/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;

/**
 * 描述:数据库操作类型<br>
 *
 * @author chenxin
 * @date 2016年09月19日
 */
public enum OperationTypes {
	INSERT("1","INSERT")	
	,DELETE("2","DELETE")
	,UPDATE("3","UPDATE");
	private String code;//编码
	private String desc;//描述

	private OperationTypes(String code, String desc){
		this.code= code;
		this.desc=desc;		
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}

	public static OperationTypes getValue(String code) {
		for (OperationTypes operationTypes : OperationTypes.values()) {
			if (operationTypes.code.equalsIgnoreCase(code)) {
				return operationTypes;
			}
		}
		return null;
	}
    
    public static Map<String,OperationTypes> getOperationTypesMap(){
		Map<String,OperationTypes> operationTypesMap = new TreeMap<String,OperationTypes>();
		for(OperationTypes operationTypes :OperationTypes.values()){
			operationTypesMap.put(operationTypes.getCode(),operationTypes);
		}
		return operationTypesMap;
	}
}
