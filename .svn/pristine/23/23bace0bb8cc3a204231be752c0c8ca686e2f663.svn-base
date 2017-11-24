/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.ext.dto.MidLiquidationDto;
import com.icinfo.cs.ext.service.IMidLiquidationService;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述: cs_mid_liquidation 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
@Controller
@RequestMapping("/midliquidation/")
public class MidLiquidationController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MidLiquidationController.class);

	@Autowired
	IMidLiquidationService midLiquidationService;

	/**
	 * 描述：根据priPID查询清算信息
	 *
	 * @author baifangfang
	 * @date 2016年10月21日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "get.json", "get.xml" })
	@ResponseBody
	public MidLiquidationDto get(@RequestParam String priPID) throws Exception {
		MidLiquidationDto midLiquidationDto = midLiquidationService.queryResult(priPID);
		logger.info("midLiquidationDto {}", midLiquidationDto);
		if (midLiquidationDto != null) {
			return midLiquidationDto;
		}
		return new MidLiquidationDto();
	}
}