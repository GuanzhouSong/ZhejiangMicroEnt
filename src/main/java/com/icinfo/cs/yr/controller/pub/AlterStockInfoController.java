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
import com.icinfo.cs.yr.dto.AlterStockInfoDto;
import com.icinfo.cs.yr.model.AlterStockInfo;
import com.icinfo.cs.yr.service.IAlterStockInfoService;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_alterstockinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("pub/alterStockInfo")
public class AlterStockInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AlterStockInfoController.class);

	@Autowired
	private IAlterStockInfoService alterStockInfoService;
	
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
	public PageResponse<AlterStockInfo> listJSON(PageRequest request) throws Exception {
		List<AlterStockInfo> data = alterStockInfoService.queryPage(request);
		logger.info("data {}", data);
		return new PageResponse<AlterStockInfo>(data);
	}
	
	
	/**
	 * 
	 * 描述: 公示侧股权变更信息
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publist.json")
	@ResponseBody
	public PageResponse<AlterStockInfoDto> listJSONForPub(PageRequest request) throws Exception {
		List<AlterStockInfoDto> data = alterStockInfoService.queryPageForPub(request);
		logger.info("data {}", data);
		Map<String, Object> searchMap=  request.getParams();
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			String anCheID = (String) searchMap.get(Constants.CS_ANCHEID);
			String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(anCheID);

			if ("0".equals(ifFilter)) {
				for (AlterStockInfoDto alterStockInfo : data) {
					if (alterStockInfo != null) {
						alterStockInfo.doFilterForbidword();
					}
				}
			}
		}

		return new PageResponse<AlterStockInfoDto>(data);
	}
}