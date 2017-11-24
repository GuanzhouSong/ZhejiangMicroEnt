/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.yr.model.SfcBalanctsheet;

import java.util.List;

/**
 * 描述:  cs_sfc_balanctsheet 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月23日
 */
public class SfcBalanctsheetDto extends SfcBalanctsheet {

    private List<SfcBalanctsheet> sfcBalanctsheetList;

    public List<SfcBalanctsheet> getSfcBalanctsheetList() {
        return sfcBalanctsheetList;
    }

    public void setSfcBalanctsheetList(List<SfcBalanctsheet> sfcBalanctsheetList) {
        this.sfcBalanctsheetList = sfcBalanctsheetList;
    }
}