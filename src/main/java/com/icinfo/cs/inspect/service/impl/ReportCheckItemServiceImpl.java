/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inspect.service.impl;

import com.icinfo.cs.inspect.mapper.ReportCheckItemMapper;
import com.icinfo.cs.inspect.service.IReportCheckItemService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_report_check_item 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年01月17日
 */
@Service
public class ReportCheckItemServiceImpl extends MyBatisServiceSupport implements IReportCheckItemService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ReportCheckItemServiceImpl.class);

    @Autowired
    private ReportCheckItemMapper reportCheckItemMapper;
}