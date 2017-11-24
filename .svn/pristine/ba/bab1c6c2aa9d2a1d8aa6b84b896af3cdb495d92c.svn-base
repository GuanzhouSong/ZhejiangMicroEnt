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
import com.icinfo.cs.yr.dto.SfcBranchInfoDto;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcBranchInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sfc_branchinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Controller
@RequestMapping("pub/sfcbranchinfo")
public class SfcBranchInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SfcBranchInfoController.class);

	@Autowired
	ISfcBranchInfoService sfcBranchInfoService;
	
	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;

	/**
	 * 描述：查询农专分支机构列表
	 * 
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SfcBranchInfoDto> listJSON(PageRequest request) throws Exception {
		List<SfcBranchInfoDto> data = sfcBranchInfoService.queryPage(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap = request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (SfcBranchInfoDto sfcBranceInfo : data) {
					if (sfcBranceInfo != null) {
						sfcBranceInfo.doFilterForbidword();
					}
				}
			}	
		}
		
		return new PageResponse<SfcBranchInfoDto>(data);
	}
	
	/**
	 * 描述：查询农专分支机构列表(用于敏感词审核)
	 * @author yujingwei
	 * @date 2016年10月10日
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/forbid.json")
	@ResponseBody
	public PageResponse<SfcBranchInfoDto> forbidJson(PageRequest request) throws Exception {
		List<SfcBranchInfoDto> data = sfcBranchInfoService.queryPage(request);
		return  new PageResponse<SfcBranchInfoDto>(data);
	}
}