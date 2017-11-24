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
 * 描述: 登记状态 <br>
 *
 * @author liuhq
 * @date 2016-10-26
 */
public enum RegStates {
    X("X", "注销中"),
    XX("XX", "注销"),
    DX("DX", "吊销已注销"),
    Q("Q", "迁出"),
    C("C", "撤销"),
    D("D", "吊销"),
    K("K", "开业"),
    B("B", "变更"),
    A("A", "档案"),
    DA("DA", "电子档案");


    private String code;//编码
    private String name;//描述

    private RegStates(String code, String name) {
        this.code = code;
        this.name = name;
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

    public static RegStates getValue(String code) {
        for (RegStates scTaskStates : RegStates.values()) {
            if (scTaskStates.code.equalsIgnoreCase(code)) {
                return scTaskStates;
            }
        }
        return null;
    }

    /**
     * 根据code获取登记状态名称
     * @param code
     * @return
     */
    public static String getName(String code) {
        for (RegStates scTaskStates : RegStates.values()) {
            if (scTaskStates.code.equalsIgnoreCase(code)) {
                return scTaskStates.getName();
            }
        }
        return null;
    }
    public static Map<String, RegStates> getScTaskStatesMap() {
        Map<String, RegStates> scTaskStatesMap = new TreeMap<String, RegStates>();
        for (RegStates scTaskStates : RegStates.values()) {
            scTaskStatesMap.put(scTaskStates.getCode(), scTaskStates);
        }
        return scTaskStatesMap;
    }
}
