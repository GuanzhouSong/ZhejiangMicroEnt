/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.service;

import com.icinfo.cs.writ.model.Dzhz;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_dzhz 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public interface IDzhzService extends BaseService {

    /**
     * 描述：添加一条回执数据
     * @param dzhz
     * @return
     */
    int save(Dzhz dzhz);

    /**
     * 描述：查询电子回执数据
     * @param uuid
     * @return
     */
    Dzhz selectbyWritUuid(String uuid);
}