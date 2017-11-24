/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.dto;

import com.icinfo.cs.depsyn.model.CsDepsynLicense;

import java.util.List;

/**
 * 描述:    cs_depsyn_license 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public class CsDepsynLicenseDto extends CsDepsynLicense {

    /**
     * 行政许可实体类集合
     */
    private List<CsDepsynLicense> csDepsynLicenseList;

    /**
     * 无效数据条数
     */
    private int invalidNun;

    public List<CsDepsynLicense> getCsDepsynLicenseList() {
        return csDepsynLicenseList;
    }

    public void setCsDepsynLicenseList(List<CsDepsynLicense> csDepsynLicenseList) {
        this.csDepsynLicenseList = csDepsynLicenseList;
    }

    public int getInvalidNun() {
        return invalidNun;
    }

    public void setInvalidNun(int invalidNun) {
        this.invalidNun = invalidNun;
    }
}