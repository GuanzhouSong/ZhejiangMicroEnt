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

import com.icinfo.cs.yr.dto.PbWebsiteinfoDto;
import com.icinfo.cs.yr.dto.SfcWebsiteInfoDto;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_sfc_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Controller
@RequestMapping("pub/sfcwebsiteinfo")
public class SfcWebsiteInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SfcWebsiteInfoController.class);
	
	@Autowired
	ISfcWebsiteInfoService sfcWebsiteInfoService;
	
	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;
	/**
	 * 描述：查询农专年报网站或网店列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public List<SfcWebsiteInfoDto> listJSON(@RequestParam String anCheID) throws Exception {
		List<SfcWebsiteInfoDto> sfcWebsiteInfoDtos = sfcWebsiteInfoService.queryListResult(anCheID);
		logger.info("sfcWebsiteInfoDtos {}", sfcWebsiteInfoDtos);
		String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(anCheID);
		if ("0".equals(ifFilter)) {
			for (SfcWebsiteInfoDto sfcWebsiteInfo : sfcWebsiteInfoDtos) {
				if (sfcWebsiteInfo != null) {
					sfcWebsiteInfo.doFilterForbidword();
				}
			}
		}
		
		return sfcWebsiteInfoDtos;
	}
	
	/**
	 * 描述：获取农专年报网站或网店信息列表
	 * @author yujingwei
	 * @return PageResponse<PbWebsiteinfo>
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<SfcWebsiteInfo> listJSON(PageRequest request) throws Exception {
		List<SfcWebsiteInfo> data = sfcWebsiteInfoService.querySfcWebsitePage(request);
		return new PageResponse<SfcWebsiteInfo>(data);
	}
}