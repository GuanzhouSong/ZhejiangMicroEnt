package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;

public enum SimplecanRea {
	
	SimplecanPass("1","准予简易注销"),
	
	SimplecanNotPass("2","不予简易注销"),
	
	SimplecanDismissed("3","不予受理"),
	
	SimplecanApplyIng("4","正在进行简易注销公告"),

	SimplecanCanceled("5","已撤销简易注销公告");
	
	private String code;//编码
	private String desc;//描述
	private SimplecanRea(String code, String desc){
		this.code= code;
		this.desc=desc;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	public static SimplecanRea getValue(String code) {
		for (SimplecanRea simplecanRea : SimplecanRea.values()) {
			if (simplecanRea.code.equalsIgnoreCase(code)) {
				return simplecanRea;
			}
		}
		return null;
	}
    
    public static Map<String,SimplecanRea> getSimplecanReaMap(){
		Map<String,SimplecanRea> simplecanReaMap = new TreeMap<String,SimplecanRea>();
		for(SimplecanRea simplecanRea :SimplecanRea.values()){
			simplecanReaMap.put(simplecanRea.getCode(),simplecanRea);
		}
		return simplecanReaMap;
	}
}
