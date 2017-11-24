/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.yr.dto.BaseInfoDto;
import com.icinfo.cs.yr.dto.PbBaseinfoDto;
import com.icinfo.cs.yr.dto.SfcBaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

@Controller
@RequestMapping("/reg/server/yr/yrassetinfo/")
public class YrAssetInfoController extends BaseController {

	@Autowired
	IBaseInfoService baseInfoService;

	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;

	@Autowired
	IPbBaseinfoService pbBaseinfoService;

	/**
	 * 年报资产类信息查询页面
	 * 
	 * @author baifangfang
	 * @date 2017-6-5
	 * @return ModelAndView
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/yr/yrassetinfo/yrassetinfo");
		List<String> yearList = DateUtil.getYearToNow();
		yearList.remove(yearList.size() - 1);
		modelAndView.addObject("yearList", yearList);
		modelAndView.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return modelAndView;
	}

	/**
	 * 描述：年报资产类信息查询（企业）
	 * 
	 * @author baifangfang
	 * @date 2017-06-05
	 * @return
	 */
	@RequestMapping("entlist.json")
	@ResponseBody
	public PageResponse<BaseInfoDto> entListJSON(PageRequest request) throws Exception {
		List<BaseInfoDto> baseInfoDtoList = baseInfoService.selectEntBaseinfoAssetList(request);
		return new PageResponse<BaseInfoDto>(baseInfoDtoList);
	}

	/**
	 * 描述：年报资产类信息统计（企业）
	 * 
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "entlistCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult entlistCount(PageRequest request) throws Exception {
		YrAssetCount yrAssetCount = baseInfoService.queryEntYrAssetCount(request);
		List<Object> countList = new ArrayList<Object>();
		countList.add(yrAssetCount.getAssGroCount());
		countList.add(yrAssetCount.getLiaGroCount());
		countList.add(yrAssetCount.getTotEquCount());
		countList.add(yrAssetCount.getVendIncCount());
		countList.add(yrAssetCount.getMaiBusIncCount());
		countList.add(yrAssetCount.getProGroCount());
		countList.add(yrAssetCount.getNetIncCount());
		countList.add(yrAssetCount.getRatGroCount());
		countList.add(yrAssetCount.getEmpNumCount());
		countList.add(yrAssetCount.getFemaleEmployeCount());
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 描述：年报资产类信息查询（农专社）
	 * 
	 * @author baifangfang
	 * @date 2017-06-05
	 * @return
	 */
	@RequestMapping("sfclist.json")
	@ResponseBody
	public PageResponse<SfcBaseInfoDto> sfcListJSON(PageRequest request) throws Exception {
		List<SfcBaseInfoDto> sfcBaseInfoDtoList = sfcBaseInfoService.selectSfcBaseinfoAssetList(request);
		return new PageResponse<SfcBaseInfoDto>(sfcBaseInfoDtoList);
	}

	/**
	 * 描述：年报资产类信息统计（农专社）
	 * 
	 * @author baifangfang
	 * @date 2017年6月8日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "sfclistCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult sfclistCount(PageRequest request) throws Exception {
		YrAssetCount yrAssetCount = sfcBaseInfoService.querySfcYrAssetCount(request);
		List<Object> countList = new ArrayList<Object>();
		countList.add(yrAssetCount.getSfcVendIncCount());
		countList.add(yrAssetCount.getSfcPriYeaProfitCount());
		countList.add(yrAssetCount.getSfcRatGroCount());
		countList.add(yrAssetCount.getSfcPriYeaSubCount());
		countList.add(yrAssetCount.getSfcPriYeaLoanCount());
		countList.add(yrAssetCount.getSfcEmpNumCount());
		countList.add(yrAssetCount.getSfcFemaleEmployeCount());
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 描述：年报资产类信息查询（个体户）
	 * 
	 * @author baifangfang
	 * @date 2017-06-05
	 * @return
	 */
	@RequestMapping("pblist.json")
	@ResponseBody
	public PageResponse<PbBaseinfoDto> pbListJSON(PageRequest request) throws Exception {
		List<PbBaseinfoDto> pbBaseInfoDtoList = pbBaseinfoService.selectPbBaseinfoAssetList(request);
		return new PageResponse<PbBaseinfoDto>(pbBaseInfoDtoList);
	}

	/**
	 * 描述：年报资产类信息统计（个体户）
	 * 
	 * @author baifangfang
	 * @date 2017年6月8日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "pblistCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pblistCount(PageRequest request) throws Exception {
		YrAssetCount yrAssetCount = pbBaseinfoService.queryPbYrAssetCount(request);
		List<Object> countList = new ArrayList<Object>();
		countList.add(yrAssetCount.getPbVendIncCount());
		countList.add(yrAssetCount.getPbRatGroCount());
		countList.add(yrAssetCount.getPbEmpNumCount());
		return AjaxResult.success("统计数成功", countList);
	}

}