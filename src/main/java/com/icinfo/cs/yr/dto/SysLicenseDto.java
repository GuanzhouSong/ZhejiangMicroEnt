/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.yr.model.SysLicense;

/**
 * 描述:    cs_sys_license 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public class SysLicenseDto extends SysLicense {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}