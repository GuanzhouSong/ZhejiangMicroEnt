/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.pub;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.PbLicenceinfoDto;
import com.icinfo.cs.yr.model.PbLicenceinfo;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pb_licenceinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月09日
 */
@Controller
@RequestMapping("pub/pblicenceinfo")
public class PbLicenceinfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PbLicenceinfoController.class);
	
	@Autowired
	IPbLicenceinfoService pbLicenceinfoService;
	
	@Autowired
	IPbBaseinfoService pbBaseinfoService;
	
	/**
	 * 描述：查询个体年报行政许可列表
	 * @author baifangfang
	 * @date 2016年10月9日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<PbLicenceinfoDto> listJSON(PageRequest request) throws Exception {
		List<PbLicenceinfoDto> data = pbLicenceinfoService.queryPage(request);
		Map<String, Object> searchMap = request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = pbBaseinfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (PbLicenceinfoDto pbLicenceinfo : data) {
					if (pbLicenceinfo != null) {
						pbLicenceinfo.doFilterForbidword();
					}
				}
			}	
		}
		
		logger.info("data {}", data);
		return new PageResponse<PbLicenceinfoDto>(data);
	}
	
	/**
	 * 描述：获取个体年报行政许可列表
	 * @author yujingwei
	 * @return PageResponse<PbWebsiteinfo>
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<PbLicenceinfo> querylist(PageRequest request) throws Exception {
		List<PbLicenceinfo> data = pbLicenceinfoService.queryPbLicencePage(request);
		return new PageResponse<PbLicenceinfo>(data);
	}
}