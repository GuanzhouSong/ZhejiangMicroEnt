/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.YrForGuaranteeInfo;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_yr_forguaranteeinfo 对应的Controller类.<br>
 * 对外担保
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/server/yr/forguarantee_server")
public class YrForGuaranteeInfoServerController extends BaseController {
	@Autowired
	private IYrForGuaranteeInfoService yrForGuaranteeInfoService;  
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	IYrRegCheckService yrRegCheckService;


	/**
	 * 页面查看
	 * @param
	 * @author: wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView show(String year,String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport/forguarantee_view");
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			view.addObject("year", Integer.parseInt(year));
			view.addObject("priPID", priPID);
		}
		return view;
	}

	/**
	 *
	 * 外投资信息表 数据列表 当前年份的上一年
	 * @author: wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_last"})
	@ResponseBody
	public PageResponse<YrForGuaranteeInfo> list_json_last(PageRequest request) throws Exception {
		List<YrForGuaranteeInfo> data = yrForGuaranteeInfoService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForGuaranteeInfo>(data);
	}

	/**
	 *
	 * 外投资信息表 数据列表 当前年份
	 * @author: wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrForGuaranteeInfo> list_json_tody(PageRequest request) throws Exception {
		List<YrForGuaranteeInfo> data = yrForGuaranteeInfoService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrForGuaranteeInfo>(data);
	}

	/**
	 *	主债权数额 (合计)
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
		//主债权数额 (合计)
		BigDecimal sumMoney = yrForGuaranteeInfoService.sumMoney(queryMap);
		sumMoney = sumMoney.setScale(4, BigDecimal.ROUND_HALF_UP);
		return AjaxResult.success("",sumMoney);
	}




}
	
