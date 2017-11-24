/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.pub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.simpleesc.dto.ErEscScrinfoDto;
import com.icinfo.cs.simpleesc.service.IErEscScrinfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: er_esc_scrinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller
@RequestMapping("pub/simpleesc/erescscrinfo")
public class ErEscScrinfoController extends BaseController {

	@Autowired
	IErEscScrinfoService erEscScrinfoService;

	/**
	 * 描述：根据priPID查询简易注销结果信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<ErEscScrinfoDto> listJSON(PageRequest request) throws Exception {
		List<ErEscScrinfoDto> erEscScrinfoDtos = erEscScrinfoService.queryPageResult(request);
		return new PageResponse<ErEscScrinfoDto>(erEscScrinfoDtos);
	}
}