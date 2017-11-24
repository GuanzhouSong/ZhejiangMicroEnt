/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icinfo.cs.simpleesc.service.IErEscScrinfoService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述: 简易注销索引管理
 *
 * @author framework generator
 * @date 2017年02月20日
 */
@Controller
@RequestMapping("pub/simpleesc/simpleescesmanage")
public class SimpleEscESManageController extends BaseController {
	
	@Autowired
	IErEscScrinfoService erEscScrinfoService;

	/**
	 * 描述：简易注销索引全量更新方法
	 * 
	 * @author baifangfang
	 * @date 2017年2月20日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("simpleEscUpdate")
	public void simpleEscUpdate() throws Exception {
		erEscScrinfoService.simpleEscUpdate();
	}

}