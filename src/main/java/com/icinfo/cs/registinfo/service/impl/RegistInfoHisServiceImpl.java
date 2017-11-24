/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import com.icinfo.cs.registinfo.mapper.RegistInfoHisMapper;
import com.icinfo.cs.registinfo.service.IRegistInfoHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_regist_info_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月10日
 */
@Service
public class RegistInfoHisServiceImpl extends MyBatisServiceSupport implements IRegistInfoHisService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(RegistInfoHisServiceImpl.class);

    @Autowired
    private RegistInfoHisMapper registInfoHisMapper;
}