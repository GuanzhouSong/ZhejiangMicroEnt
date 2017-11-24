/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 描述:  cs_code_address 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年01月20日
 */
@Table(name = "cs_code_address")
public class CodeAddress implements Serializable {
    /**
     * 地址编码W
     */
    @Id
    @Column(name = "code")
    private String code;

    /**
     * 地址名称
     */
    @Column(name = "addressName")
    private String addressName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取地址编码
     *
     * @return code - 地址编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置地址编码
     *
     * @param code 地址编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取地址名称
     *
     * @return addressName - 地址名称
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 设置地址名称
     *
     * @param addressName 地址名称
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}