/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inspect.controller.reg.server;

import com.icinfo.cs.inspect.service.IReportCheckItemService;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 描述:  cs_report_check_item 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年01月17日
 */
@Controller
public class ReportCheckItemController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ReportCheckItemController.class);

    @Autowired
    private IReportCheckItemService reportCheckItemService;
}