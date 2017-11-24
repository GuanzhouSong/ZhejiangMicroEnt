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
import com.icinfo.cs.yr.dto.SfcLicenceInfoDto;
import com.icinfo.cs.yr.model.SfcLicenceInfo;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_sfc_licenceinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Controller
@RequestMapping("pub/sfclicenceinfo")
public class SfcLicenceInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SfcLicenceInfoController.class);
	
	@Autowired
	ISfcLicenceInfoService sfcLicenceInfoService;
	
	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;
	/**
	 * 描述：查询农专年报行政许可列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SfcLicenceInfoDto> listJSON(PageRequest request) throws Exception {
		List<SfcLicenceInfoDto> data = sfcLicenceInfoService.queryPage(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap = request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (SfcLicenceInfoDto sfcLicenceInfo : data) {
					if (sfcLicenceInfo != null) {
						sfcLicenceInfo.doFilterForbidword();
					}
				}
			}	
		}
		return new PageResponse<SfcLicenceInfoDto>(data);
	}
	
	/**
	 * 描述：获取农专行政许可信息
	 * @author yujingwei
	 * @return PageResponse<sfcWebsiteinfo>
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<SfcLicenceInfo> querylist(PageRequest request) throws Exception {
		List<SfcLicenceInfo> data = sfcLicenceInfoService.queryPageInfo(request);
		return new PageResponse<SfcLicenceInfo>(data);
	}
}