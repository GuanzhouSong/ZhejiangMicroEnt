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
import com.icinfo.cs.yr.dto.PbUpdateinfoDto;
import com.icinfo.cs.yr.dto.SfcBranchInfoDto;
import com.icinfo.cs.yr.dto.SfcUpdateinfoDto;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcUpdateinfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_sfc_updateinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月10日
 */
@Controller
@RequestMapping("pub/sfcupdateinfo")
public class SfcUpdateinfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SfcUpdateinfoController.class);
	
	@Autowired
	ISfcUpdateinfoService sfcUpdateinfoService;
	
	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;
	/**
	 * 描述：查询农专修改信息列表
	 * 
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SfcUpdateinfoDto> listJSON(PageRequest request) throws Exception {
		List<SfcUpdateinfoDto> data = sfcUpdateinfoService.queryPage(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap = request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (SfcUpdateinfoDto sfcUpdateinfo : data) {
					if (sfcUpdateinfo != null) {
						sfcUpdateinfo.doFilterForbidword();
					}
				}
			}	
		}
		return new PageResponse<SfcUpdateinfoDto>(data);
	}
	
	/**
	 * 描述：获取农专修改记录（用于敏感词审核）
	 * @author yujingwei
	 * @return PageResponse<PbUpdateinfoDto>(data)
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/forbidword.json")
	@ResponseBody
	public PageResponse<SfcUpdateinfoDto> forbidwordJson(PageRequest request) throws Exception {
		List<SfcUpdateinfoDto> data = sfcUpdateinfoService.queryPageForbidWord(request);
		logger.info("data {}", data);
		return new PageResponse<SfcUpdateinfoDto>(data);
	}
}