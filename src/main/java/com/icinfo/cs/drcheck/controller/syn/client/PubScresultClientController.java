/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_scresult 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Controller
@RequestMapping("/pubscresult")
public class PubScresultClientController extends BaseController {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(PubScresultClientController.class);

	@Autowired
	IPubScentResultService pubScentResultService;

	/**
	 * 描述：根据priPID查询抽查检查JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年9月30日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubScentResultDto> listJSON(PageRequest request) throws Exception {
		List<PubScentResultDto> pubScentResultDtos = pubScentResultService.queryPageResultPub(request);
		logger.info("pubScentResultDtos {}", pubScentResultDtos);
		return new PageResponse<PubScentResultDto>(pubScentResultDtos);
	}
}