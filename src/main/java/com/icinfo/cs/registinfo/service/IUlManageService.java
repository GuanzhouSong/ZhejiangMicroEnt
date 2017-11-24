/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import com.icinfo.cs.registinfo.model.UlManage;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_ul_manage 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IUlManageService extends BaseService {
    /**
     * 增加一条无证无照处理记录
     * @param ulManage
     * @return
     */
    int addUlManage(UlManage ulManage);
}