/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:   跟踪监测
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Controller
@RequestMapping("/sment/entarchives/monitor")
public class EntarchivesMonitor extends BaseController {
	
	@RequestMapping("list")
	public ModelAndView list() throws Exception{
		return new ModelAndView("sment/entarchives/entarchives_monitor");
	}
}