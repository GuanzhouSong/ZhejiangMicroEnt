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

import com.icinfo.cs.yr.dto.WebsiteInfoDto;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IWebsiteInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("pub/WebsiteInfo")
public class WebsiteInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WebsiteInfoController.class);

	@Autowired
	private IWebsiteInfoService websiteInfoService;
	
	@Autowired
	private IBaseInfoService baseInfoService;

	/**
	 * 描述：获取列表Json数据
	 * 
	 * @author yujingwei
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<WebsiteInfo> listJSON(PageRequest request) throws Exception {
		List<WebsiteInfo> data = websiteInfoService.queryPage(request);
		logger.info("data {}", data);
		return new PageResponse<WebsiteInfo>(data);
	}

	/**
	 * 描述：根据anCheID获取网站或网店信息
	 * 
	 * @author baifangfang
	 * @date 2016年10月26日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "publist.json", "publist.xml" })
	@ResponseBody
	public List<WebsiteInfoDto> listJSONForPub(@RequestParam String anCheID) throws Exception {
		List<WebsiteInfoDto> websiteInfoDtos = websiteInfoService.queryListResult(anCheID);
		logger.info("websiteInfoDtos {}", websiteInfoDtos);
		String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(anCheID);

		if ("0".equals(ifFilter)) {
			for (WebsiteInfoDto websiteinfodto : websiteInfoDtos) {
				if (websiteinfodto != null) {
					websiteinfodto.doFilterForbidword();
				}
			}
		}
		return websiteInfoDtos;
	}

}