/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.yr.service.ISfcFormService;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 描述:  cs_sfc_form 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年12月05日
 */
@Controller
public class SfcFormController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcFormController.class);

    @Autowired
    private ISfcFormService sfcFormService;
}