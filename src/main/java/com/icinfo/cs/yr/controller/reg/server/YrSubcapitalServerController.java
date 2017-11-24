/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeContriFormService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrSubcapitalService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_yr_subcapital 对应的Controller类.<br>
 *  年报 出资情况报表 
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/server/yr/subcapital_server")
public class YrSubcapitalServerController extends BaseController {
	@Autowired
	private IYrSubcapitalService yrSubcapitalService; 
	@Autowired
	private ICodeContriFormService codeContriFormService;
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	IYrRegCheckService yrRegCheckService;


	/**
	 * 出资情况详情
	 * @autor: wangjin
	 * @param year pripid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") // /reg/server/yr/subcapital_server/view
	public ModelAndView show(String year,String priPID,String entType,String currencyCn) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport/subcapital_view");
		view.addObject("currencyCn",currencyCn);
		view.addObject("year",year);
		view.addObject("priPID",priPID);
		view.addObject("entType",entType);
		return view;
	}


	/**
	 * 出资信息表 数据列表 当前年份的上一年数据
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
     */
	@RequestMapping({"/list_json_last"})
	@ResponseBody
	public PageResponse<YrSubcapital> list_json_last(PageRequest request) throws Exception {
		List<YrSubcapital> data = yrSubcapitalService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrSubcapital>(data);
	}

	/**
	 * 出资信息表 数据列表  当前年份
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrSubcapital> list_json_tody(PageRequest request) throws Exception {
		List<YrSubcapital> data = yrSubcapitalService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrSubcapital>(data);
	}


	/**
	 *认缴 出资 和 实缴 出资额 (合计)
	 * @author: wangjin
	 * @param year
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/countMoney", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult countMoney(String year, String priPID) throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		queryMap.put(Constants.CS_YEAR,year );

		//认缴 出资合计
		BigDecimal rj_Money = yrSubcapitalService.rj_sumMoney(queryMap);
		rj_Money = rj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

		//实缴 出资合计
		BigDecimal sj_Money = yrSubcapitalService.sj_sumMoney(queryMap);
		sj_Money = sj_Money.setScale(4, BigDecimal.ROUND_HALF_UP);

		Object data = rj_Money+","+sj_Money;
		return AjaxResult.success("",data);
	}
	
	/**
	 * 描述：根据priPID查询企业年报股东及出资信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年11月23日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<Subcapital> listJSON(PageRequest request) throws Exception {
		List<Subcapital> subcapitals = yrSubcapitalService.queryPageResult(request);
		return new PageResponse<Subcapital>(subcapitals);
	}


}