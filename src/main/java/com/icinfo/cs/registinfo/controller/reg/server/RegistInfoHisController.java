/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.controller.reg.server;

import com.icinfo.cs.registinfo.service.IRegistInfoHisService;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 描述:  cs_regist_info_his 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月10日
 */
@Controller
public class RegistInfoHisController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(RegistInfoHisController.class);

    @Autowired
    private IRegistInfoHisService registInfoHisService;
}