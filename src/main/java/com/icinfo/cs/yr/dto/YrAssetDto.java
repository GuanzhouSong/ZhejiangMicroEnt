/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.yr.model.YrAsset;

/**
 * 描述:    cs_yr_asset 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public class YrAssetDto extends YrAsset {

    private String sign;  //标记  用于判断是 暂存还是保存的条件


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}