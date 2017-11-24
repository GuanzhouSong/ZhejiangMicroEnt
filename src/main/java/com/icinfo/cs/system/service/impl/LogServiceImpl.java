/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.system.mapper.LogMapper;
import com.icinfo.cs.system.model.Log;
import com.icinfo.cs.system.service.ILogService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_log_2016 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月29日
 */
@Service
public class LogServiceImpl extends MyBatisServiceSupport implements ILogService {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogMapper logMapper;

    /**
     * 插入系统日志
     *
     * @param log
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-12-29
     */
    @Override
    public int insertLog(Log log) {
        int rlt=0;
        try{
            logMapper.insert(log);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("插入日志出现异常:"+e.getMessage());
        }
        return rlt;
    }
}