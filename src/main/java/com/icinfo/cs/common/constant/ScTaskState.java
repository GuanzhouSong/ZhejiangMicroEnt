/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 名称状态 <br/>
 * @author 刘明
 * @date 2013-8-29
 * @version 1.0
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;



/** 
 * 描述: 双随机主任务状态<br>
 * @author chenxin
 * @date 2017-05-23  
 */
public enum ScTaskState {
	/**
     * 设置任务计划
     */
    TaskSet("01","待抽取","待执行"),
    /**
     * 待抽取企业
     */
    WaitRandomEnt("02","已抽取","执行中"),
    /**
     * 已录入结果并公示
     */
    TaskEnd("03","已完成","已完成");
    

    private String code;//状态编码
    private String desc;//抽取企业状态
    private String mainDesc;//状态客户端描述

    private ScTaskState(String code, String desc, String mainDesc) {
        this.code = code;
        this.desc = desc;
        this.mainDesc = mainDesc;
    }
    
    public static ScTaskState getValue(String code) {
		for (ScTaskState nameState : ScTaskState.values()) {
			if (nameState.code.equalsIgnoreCase(code)) {
				return nameState;
			}
		}
		return null;
	}
    
    public static Map<String,ScTaskState> getNameStateMap(){
		Map<String,ScTaskState> nameStateMap = new TreeMap<String,ScTaskState>();
		for(ScTaskState nameState :ScTaskState.values()){
			nameStateMap.put(nameState.getCode(),nameState);
		}
		return nameStateMap;
	}
    

    public String getCode() {
        return this.code;
    }
    public String getDesc() {
        return this.desc;
    }
    public String getMainDesc() {
        return this.mainDesc;
    }
}
