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
import com.icinfo.cs.yr.dto.SubcapitalDto;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.ISubcapitalService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_subcapital 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("pub/subcapitalInfo")
public class SubcapitalController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SubcapitalController.class);

	@Autowired
	private ISubcapitalService subcapitalService;
	
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
	public PageResponse<Subcapital> listJSON(PageRequest request) throws Exception {
		List<Subcapital> data = subcapitalService.queryPage(request);
		logger.info("data {}", data);
		return new PageResponse<Subcapital>(data);
	}
	
	/**
	 * 
	 * 描述: 公示侧获取股东及出资信息
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publist.json")
	@ResponseBody
	public PageResponse<SubcapitalDto> listJSONForPub(PageRequest request) throws Exception {
		List<SubcapitalDto> data = subcapitalService.queryPageForPub(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap = request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (SubcapitalDto subcapital : data) {
					if (subcapital != null) {
						subcapital.doFilterForbidword();
					}
				}
			}	
		}
		return new PageResponse<SubcapitalDto>(data);
	}
}