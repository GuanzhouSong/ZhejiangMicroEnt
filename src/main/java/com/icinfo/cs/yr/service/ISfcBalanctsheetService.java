/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.SfcBalanctsheet;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;

/**
 * 描述:  cs_sfc_balanctsheet 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月23日
 */
public interface ISfcBalanctsheetService extends BaseService {

    /**
     * 根据 年份和身份主体代码查询表数据集合
     * @author: wangjin
     * @param year
     * @param priPID
     * @return
     */
    List<SfcBalanctsheet> selectByYearAndPripid(Integer year, String priPID);


    /**
     * 更新数据
     * @author: wangjin
     * @param sfcBalanctsheetList
     * @return
     */
    int update(List<SfcBalanctsheet> sfcBalanctsheetList);

    /**
     * 新增数据
     * @author: wangjin
     * @param sfcBalanctsheetList
     * @return
     */
    int insert(List<SfcBalanctsheet> sfcBalanctsheetList);



}