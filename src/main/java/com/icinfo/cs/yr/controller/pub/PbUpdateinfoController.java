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
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbUpdateinfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pb_updateinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月09日
 */
@Controller
@RequestMapping("pub/pbupdateinfo")
public class PbUpdateinfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PbUpdateinfoController.class);
	
	@Autowired
	IPbUpdateinfoService pbUpdateInfoService;
	
	@Autowired
	IPbBaseinfoService pbBaseinfoService;
	/**
	 * 描述：个体户年报修改信息
	 * @author baifangfang
	 * @date 2016年10月9日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<PbUpdateinfoDto> listJSON(PageRequest request) throws Exception {
		List<PbUpdateinfoDto> data = pbUpdateInfoService.queryPage(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap = request.getParams();
		if (searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)) {
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = pbBaseinfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (PbUpdateinfoDto pbUpdateinfo : data) {
					if (pbUpdateinfo != null) {
						pbUpdateinfo.doFilterForbidword();
					}
				}
			}
		}
		return new PageResponse<PbUpdateinfoDto>(data);
	}
	
	/**
	 * 描述：获取个体修改记录（用于敏感词审核）
	 * @author yujingwei
	 * @return PageResponse<PbUpdateinfoDto>(data)
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/forbidword.json")
	@ResponseBody
	public PageResponse<PbUpdateinfoDto> forbidwordJson(PageRequest request) throws Exception {
		List<PbUpdateinfoDto> data = pbUpdateInfoService.queryPageForbidWord(request);
		logger.info("data {}", data);
		return new PageResponse<PbUpdateinfoDto>(data);
	}
}