/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.sment.model.SmLog;
import com.icinfo.cs.sment.service.ISmLogService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    sm_log 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
@Controller
@RequestMapping("/sment/log")
public class SmLogController extends BaseController {
	
	@Autowired
	private ISmLogService smLogService;
	
	/**
	 * 进入日志管理
	 */
	@RequestMapping("/view")
	public String view() throws Exception{
		return "sment/sment_log_list";
	}
	
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<SmLog> listJSON(PageRequest request) throws Exception {
		List<SmLog> data = smLogService.queryPage(request);
		return new PageResponse<SmLog>(data);
	}
}