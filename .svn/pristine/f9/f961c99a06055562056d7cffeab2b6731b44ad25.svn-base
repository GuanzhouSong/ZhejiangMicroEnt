/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 各地区编码值 <br/>
 * @author chenxin
 * @date 2016-10-26
 * @version 1.0
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;

/** 
 * 描述: 各地区编码值 <br>
 * @author chenxin
 * @date 2016-10-26  
 */
public enum AreaCodes {
    SS("3300","省局直属"),
    HZ("3301","杭州地区"),
    NB("3302","宁波地区"),
    WZ("3303","温州地区"),
    JX("3304","嘉兴地区"),
    HUZ("3305","湖州地区"),
    SX("3306","绍兴地区"),
    JH("3307","金华地区"),
    QZ("3308","衢州地区"),
    TZ("3309","台州地区"),
    ZS("3310","舟山地区"),
    LS("3325","丽水地区"),
    QT("9999","其他地区");
	private String code;//编码
	private String desc;//描述

	private AreaCodes(String code, String desc){
		this.code= code;
		this.desc=desc;		
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}

	public static AreaCodes getValue(String code) {
		for (AreaCodes areaCodes : AreaCodes.values()) {
			if (areaCodes.code.equalsIgnoreCase(code)) {
				return areaCodes;
			}
		}
		return null;
	}
    
    public static Map<String,AreaCodes> getScTaskStatesMap(){
		Map<String,AreaCodes> areaCodesMap = new TreeMap<String,AreaCodes>();
		for(AreaCodes areaCodes :AreaCodes.values()){
			areaCodesMap.put(areaCodes.getCode(),areaCodes);
		}
		return areaCodesMap;
	}
}
