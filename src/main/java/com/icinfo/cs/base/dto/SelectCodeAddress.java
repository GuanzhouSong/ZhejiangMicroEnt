/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.dto;

import com.icinfo.cs.base.model.CodeAddress;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * 描述:  cs_code_address 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年01月20日
 */
public class SelectCodeAddress  {
    /**
     * 地址编码
     */

    private String code;

    /**
     * 地址名称
     */
    private String addressName;


    List<SelectCodeAddress> codeAddress;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public List<SelectCodeAddress> getCodeAddress() {
        return codeAddress;
    }

    public void setCodeAddress(List<SelectCodeAddress> codeAddress) {
        this.codeAddress = codeAddress;
    }
}