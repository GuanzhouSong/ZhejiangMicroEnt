/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.service;

import com.icinfo.cs.writ.model.Dzqz;
import com.icinfo.cs.yr.model.Signature;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_dzqz 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public interface IDzqzService extends BaseService {

    /**
     * 描述：查询是否有签章数据
     * @author: wangjin
     * @param writUuid
     * @return
     */
    Dzqz selectbyWritUuid(String writUuid);

    /**
     * 描述：修改签章
     * @param dzqz
     * @return
     */
    int modify(Dzqz dzqz);

    /**
     * 描述：添加签章数据
     * @param year
     * @param pripid
     * @param sealImgBase64
     * @param writUuid
     * @return
     */
    int save(String year, String pripid, String sealImgBase64, String writUuid);

    /**
     * 描述：签章失败 将状态改为0
     * @param dzqz
     */
    int modifyStatus(Dzqz dzqz);
}