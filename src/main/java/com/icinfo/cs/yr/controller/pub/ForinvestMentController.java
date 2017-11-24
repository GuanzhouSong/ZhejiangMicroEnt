/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.pub;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.yr.dto.ForinvestMentDto;
import com.icinfo.cs.yr.dto.WebsiteInfoDto;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IForinvestMentService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_forinvestment 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("pub/forinvestMentInfo")
public class ForinvestMentController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ForinvestMentController.class);

	@Autowired
	private IForinvestMentService forinvestMentService;

	@Autowired
	private IBaseInfoService baseInfoService;
	/**
	 * 描述：获取列表Json数据
	 * 
	 * @author yujingwei
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<ForinvestMent> listJSON(PageRequest request) throws Exception {
		List<ForinvestMent> data = forinvestMentService.queryPage(request);
		logger.info("data {}", data);
		return new PageResponse<ForinvestMent>(data);
	}

	/**
	 * 
	 * 描述: 公示侧获取对外投资（过滤敏感词）
	 * 
	 * @auther chenyl
	 * @date 2016年10月8日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publist.json")
	@ResponseBody
	public List<ForinvestMentDto> listJSONForPub(@RequestParam String anCheID) throws Exception {
		List<ForinvestMentDto> forinvestMentDtos = forinvestMentService.queryListResult(anCheID);
		logger.info("forinvestMentDtos {}", forinvestMentDtos);

		String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(anCheID);

		if ("0".equals(ifFilter)) {
			for (ForinvestMentDto forinvestMent : forinvestMentDtos) {
				if (forinvestMent != null) {
					forinvestMent.doFilterForbidword();
				}
			}
		}

		return forinvestMentDtos;
	}
}