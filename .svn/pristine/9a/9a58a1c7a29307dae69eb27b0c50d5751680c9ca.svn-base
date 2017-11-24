/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;

/**
 * 描述:联络员备案申请状态<br>
 *
 * @author chenxin
 * @date 2016年05月20日
 */
public enum PasStatus {
	PasStatus01("01","已接受"),
	PasStatus02("02","申请"),
	PasStatus03("03","不接受");

    private String code;//状态编码
    private String desc;//状态描述

    private PasStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    public static PasStatus getValue(String code) {
		for (PasStatus pasStatus : PasStatus.values()) {
			if (pasStatus.code.equalsIgnoreCase(code)) {
				return pasStatus;
			}
		}
		return null;
	}
    
    public static Map<String,PasStatus> getNameTypesMap(){
		Map<String,PasStatus> pasStatusMap = new TreeMap<String,PasStatus>();
		for(PasStatus pasStatus :PasStatus.values()){
			pasStatusMap.put(pasStatus.getCode(),pasStatus);
		}
		return pasStatusMap;
	}
    

    public String getCode() {
        return this.code;
    }
    public String getDesc() {
        return this.desc;
    }
}
