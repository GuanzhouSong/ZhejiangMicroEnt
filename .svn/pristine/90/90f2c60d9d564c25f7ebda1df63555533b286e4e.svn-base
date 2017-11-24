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
 * 描述: 双随机支线任务状态<br>
 * @author chenxin
 * @date 2017-05-23  
 */
public enum ScDeptTaskState {
	/**
     * 待抽取执法人员
     */
    WaitRandomAgent("1","待抽取","待抽取"),
    /**
     * 已抽取执法人员
     */
    RandomAgentEnd("2","已抽取","待录入");
    

    private String code;//状态编码
    private String desc;//抽取执法人员状态
    private String mainDesc;//状态客户端描述

    private ScDeptTaskState(String code, String desc, String mainDesc) {
        this.code = code;
        this.desc = desc;
        this.mainDesc = mainDesc;
    }
    
    public static ScDeptTaskState getValue(String code) {
		for (ScDeptTaskState nameState : ScDeptTaskState.values()) {
			if (nameState.code.equalsIgnoreCase(code)) {
				return nameState;
			}
		}
		return null;
	}
    
    public static Map<String,ScDeptTaskState> getNameStateMap(){
		Map<String,ScDeptTaskState> nameStateMap = new TreeMap<String,ScDeptTaskState>();
		for(ScDeptTaskState nameState :ScDeptTaskState.values()){
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
