/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 双随机实施部门任务状态<br/>
 * @author chenxin
 * @date 2016-10-26
 * @version 1.0
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;



/** 
 * 描述: 双随机实施部门任务状态 <br>
 * @author chenxin
 * @date 2016-10-26  
 */
public enum ScTaskDeptStates {
	/**
     * 待选执法人员
     */
    WaitChooseAgent("1","待选执法人员"),
	/**
     * 已择执法人员
     */
    FinishChooseAgent("2","已选执法人员"),
    /**
     * 等待录入结果
     */
    WaitEnterResult("3","等待录入结果"),
    /**
     * 已录入结果
     */
    FinishEnterResult("4","已录入结果");
	private String code;//编码
	private String desc;//描述

	private ScTaskDeptStates(String code, String desc){
		this.code= code;
		this.desc=desc;		
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}

	public static ScTaskDeptStates getValue(String code) {
		for (ScTaskDeptStates scTaskStates : ScTaskDeptStates.values()) {
			if (scTaskStates.code.equalsIgnoreCase(code)) {
				return scTaskStates;
			}
		}
		return null;
	}
    
    public static Map<String,ScTaskDeptStates> getScTaskStatesMap(){
		Map<String,ScTaskDeptStates> scTaskStatesMap = new TreeMap<String,ScTaskDeptStates>();
		for(ScTaskDeptStates scTaskStates :ScTaskDeptStates.values()){
			scTaskStatesMap.put(scTaskStates.getCode(),scTaskStates);
		}
		return scTaskStatesMap;
	}
}
