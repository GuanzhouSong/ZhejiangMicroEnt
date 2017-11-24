/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_mid_inv 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/midinv/")
public class MidInvController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MidInvController.class);

	@Autowired
	IMidInvService midInvService;

	/**
	 * 描述：根据priPID查询股东及出资信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年9月22日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<MidInvDto> listJSON(PageRequest request) throws Exception {
		List<MidInvDto> midInvDtos = midInvService.queryPageResult(request);
		logger.info("midInvDtos {}", midInvDtos);
		return new PageResponse<MidInvDto>(midInvDtos);
	}

	/**
	 * 描述：根据priPID农专JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "sfclist.json", "sfclist.xml" })
	@ResponseBody
	public List<MidInvDto> listJSON(@RequestParam String priPID) throws Exception {
		List<MidInvDto> midInvDtos = midInvService.queryListResult(priPID);
		logger.info("midInvDtos {}", midInvDtos);
		return midInvDtos;
	}

	/**
	 * 描述：根据id查询股东及出资信息
	 * 
	 * @author baifangfang
	 * @date 2016年9月30日
	 * @param midInvId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findMidInvById")
	public ModelAndView findMidInvById(@RequestParam int midInvId, String currencyCn) throws Exception {
		logger.info("midInvId {}", midInvId);
		ModelAndView mav = new ModelAndView("pub/infopublic/infodetail/investmentdetail");
		MidInv midInv = midInvService.findMidInvById(midInvId);
		mav.addObject("currencyCn", currencyCn);
		mav.addObject("midInv", midInv);
		logger.info("midInv {}", midInv);
		return mav;
	}

}