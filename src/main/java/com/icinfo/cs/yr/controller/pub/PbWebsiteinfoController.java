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
import com.icinfo.cs.yr.dto.PbWebsiteinfoDto;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pb_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月09日
 */
@Controller
@RequestMapping("pub/pbwebsiteinfo")
public class PbWebsiteinfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PbWebsiteinfoController.class);
	
	@Autowired
	IPbWebsiteinfoService pbWebsiteinfoService;
	
	@Autowired
	IPbBaseinfoService pbBaseinfoService;
	/**
	 * 描述：个体户年报网站或网店信息列表
	 * @author baifangfang
	 * @date 2016年10月9日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public List<PbWebsiteinfoDto> listJSON(@RequestParam String anCheID) throws Exception {
		List<PbWebsiteinfoDto> pbWebsiteinfoDtos = pbWebsiteinfoService.queryListResult(anCheID);
		logger.info("pbWebsiteinfoDtos {}", pbWebsiteinfoDtos);
		String ifFilter = pbBaseinfoService.queryAnduitStateInfoByAncheID(anCheID);
		if ("0".equals(ifFilter)) {
			for (PbWebsiteinfoDto pbWebsiteinfo : pbWebsiteinfoDtos) {
				if (pbWebsiteinfo != null) {
					pbWebsiteinfo.doFilterForbidword();
				}
			}
		}
		return pbWebsiteinfoDtos;
	}
	
	/**
	 * 描述：获个体户年报网站或网店信息列表
	 * @author yujingwei
	 * @return PageResponse<PbWebsiteinfo>
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<PbWebsiteinfo> listJSON(PageRequest request) throws Exception {
		List<PbWebsiteinfo> data = pbWebsiteinfoService.queryPbWebsitePage(request);
		return new PageResponse<PbWebsiteinfo>(data);
	}
}