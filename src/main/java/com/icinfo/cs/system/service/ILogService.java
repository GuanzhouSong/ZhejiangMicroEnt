/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.model.Log;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_log_2016 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月29日
 */
public interface ILogService extends BaseService {


    /**
     * 插入系统日志
     * @author ZhuDefeng
     * @date 2016-12-29
     * @param log
     * @return
     * @throws Exception
     */
    int insertLog(Log log);
}