/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import com.icinfo.cs.registinfo.model.RegistUnlicensed;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_regist_unlicensed 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IRegistUnlicensedService extends BaseService {
    RegistUnlicensed getSupersiveByPriPID(String priPid);
}