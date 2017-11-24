/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.SfcCominfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_sfc_cominfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface ISfcCominfoService extends BaseService {

    /**
     * 更新数据
     * @author: wangjin
     * @param sfcCominfo
     * @return
     */
    int update(SfcCominfo sfcCominfo);

    /**
     * 新增数据
     *  @author: wangjin
     * @param sfcCominfo
     * @return
     */
    int insert(SfcCominfo sfcCominfo);


    /**
     * 根据 年份和身份主体代码查询当前对象
     *  @author: wangjin
     * @param year
     * @param priPID
     * @return
     */
    SfcCominfo selectByYearAndPripid(Integer year, String priPID);
}