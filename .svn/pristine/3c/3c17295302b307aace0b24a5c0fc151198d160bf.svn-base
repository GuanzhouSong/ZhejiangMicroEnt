/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 双随机任务状态 <br/>
 * @author chenxin
 * @date 2016-10-26
 * @version 1.0
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;



/** 
 * 描述: 双随机任务状态 <br>
 * @author chenxin
 * @date 2016-10-26  
 */
public enum ScTaskStates {
	/**
     * 任务创建中
     */
    Filling("00","任务创建中"),
    /**
     * 待抽取对象
     */
    WaitSetEnt("01","待抽取对象"),
    /**
     * 待设置任务计划
     */
    WaitSetPlan("02","待设置任务计划"),
    /**
     * 待实施部门确认执法人员
     */
    WaitConfirmAgent("03","待确认执法人员"),
    /**
     * 待抽取执法人员
     */
    ChooseAgent("04","待抽取执法人员"),    
    
    /**
     * 实施中
     */
    Inspecting("05","实施中"),
    /**
     * 已完成
     */
    Finished("06","已完成");
	private String code;//编码
	private String desc;//描述

	private ScTaskStates(String code, String desc){
		this.code= code;
		this.desc=desc;		
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}

	public static ScTaskStates getValue(String code) {
		for (ScTaskStates scTaskStates : ScTaskStates.values()) {
			if (scTaskStates.code.equalsIgnoreCase(code)) {
				return scTaskStates;
			}
		}
		return null;
	}
    
    public static Map<String,ScTaskStates> getScTaskStatesMap(){
		Map<String,ScTaskStates> scTaskStatesMap = new TreeMap<String,ScTaskStates>();
		for(ScTaskStates scTaskStates :ScTaskStates.values()){
			scTaskStatesMap.put(scTaskStates.getCode(),scTaskStates);
		}
		return scTaskStatesMap;
	}
}
