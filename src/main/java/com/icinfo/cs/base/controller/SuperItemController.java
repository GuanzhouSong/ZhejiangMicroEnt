/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import com.icinfo.cs.base.service.ISuperItemService;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 描述:  cs_super_item 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
@Controller
public class SuperItemController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SuperItemController.class);

    @Autowired
    private ISuperItemService superItemService;
}