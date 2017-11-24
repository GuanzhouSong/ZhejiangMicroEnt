/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.icinfo.cs.drcheck.service.IPubScdisposeService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:  cs_pub_scdispose 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Controller
public class PubScdisposeController extends BaseController {
    @Autowired
    private IPubScdisposeService pubScdisposeService;
}