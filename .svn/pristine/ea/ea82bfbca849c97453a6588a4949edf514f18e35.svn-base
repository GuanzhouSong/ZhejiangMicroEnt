/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.govguide.service;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.govguide.model.Govguide;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_govguide_set 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface IGovguideService extends BaseService {

    Govguide getGovGuideByUid(String uid);

    List<Govguide> govguide_querypage(PageRequest request);

    List<MidBaseInfo> midbaseinfoForAdd_querypage(PageRequest request);

    List<Govguide> govguidecheck_querypage(PageRequest request);

    int modiGovSet(Govguide govguide);

    int delGovSet(String uid);

    int getCountByPripid(String priPID);
    /**
     * 
     * 描述: 行政指导待审核条数
     * @auther gaojinling
     * @date 2017年10月18日 
     * @param map
     * @return
     * @throws Exception
     */
    int selectAduitGovCount(Map<String, Object> map) throws Exception;
    
    /**
     * 
     * 描述: 责令整改类待审核条数
     * @auther gaojinling
     * @date 2017年10月18日 
     * @param map
     * @return
     * @throws Exception
     */
    int selectAduitOrdCount(Map<String, Object> map) throws Exception;
}