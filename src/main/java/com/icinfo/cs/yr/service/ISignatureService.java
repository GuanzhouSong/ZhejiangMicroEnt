/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.Signature;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_signature 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
public interface ISignatureService extends BaseService {

    /**
     * 描述：只根据年份和pripid查询  不查询签章状态
     * @param year
     * @param pripid
     * @return
     */
    Signature selectNotbySatuts(String year, String pripid);

    /**
     * 描述：根据年份和内部序号查询当前对象
     * @param year
     * @param pripid
     * @return
     */
    Signature selectByYearAndPripid(String year, String pripid);

    /**
     * 描述：新增一条签章纪录
     * @param year
     * @param pripid
     * @return
     */
    int save(String year, String pripid,String sealImgBase64);

    /**
     *  描述：根据参数条件修改签章状态
     * @param signature
     */
    int modify(Signature signature);

    /**
     * 描述：修改签章后的状态
     * @param signature
     * @return
     */
    int modifyStatus(Signature signature);


}