/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 企业状态 <br/>
 *
 * @author liuhq
 * @date 2016-10-26
 * @version 1.0
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;


/** 
 * 描述: 登记状态枚举<br>
 * @author ZhouYan
 * @date 2017年8月21日  
 */
public enum RegStateEnum {
    CUNXU("A,B,K,Q,X", "存续", "'A','B','K','Q','X'"),
    CHEXIAO("C", "撤销","'C'"),
    DIAOXIAO("D,DA", "吊销", "'D','DA'"),
    ZHUXIAO("XX,DX", "注销", "'XX','DX'"),
    QIANCHU("QX", "迁出","'QX'");


    private String code;//编码
    private String name;//描述
    private String param;//描述

    private RegStateEnum(String code, String name, String param) {
        this.code = code;
        this.name = name;
        this.param = param;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public static RegStateEnum getValue(String code) {
        for (RegStateEnum regStateEnum : RegStateEnum.values()) {
            if (regStateEnum.code.equalsIgnoreCase(code)) {
                return regStateEnum;
            }
        }
        return null;
    }

    public static String getName(String code) {
        for (RegStateEnum regStateEnum : RegStateEnum.values()) {
            if (regStateEnum.code.equalsIgnoreCase(code)) {
                return regStateEnum.getName();
            }
        }
        return null;
    }
    public static Map<String, RegStateEnum> getRegStateEnumMap() {
        Map<String, RegStateEnum> regStateEnumMap = new TreeMap<String, RegStateEnum>();
        for (RegStateEnum regStateEnum : RegStateEnum.values()) {
        	regStateEnumMap.put(regStateEnum.getCode(), regStateEnum);
        }
        return regStateEnumMap;
    }
    
    public static Map<String, RegStateEnum> getRegStateCunxuEnumMap() {
        Map<String, RegStateEnum> regStateEnumMap = new TreeMap<String, RegStateEnum>();
        regStateEnumMap.put(RegStateEnum.CUNXU.code, RegStateEnum.CUNXU);
        return regStateEnumMap;
    }
}
