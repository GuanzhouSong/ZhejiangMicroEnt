package com.icinfo.cs.yr.controller.reg.server;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.cs.yr.service.IYrAlterStockInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
 

/**
 * 
 * 描述: 股权转让 控制层~server端<br>
 * @author wangjin
 * @date 2016年10月16日
 */
@Controller
@RequestMapping("/reg/server/yr/alterstock_server")
public class YrAlterStockInfoServerController extends BaseController{
	@Autowired
	private IYrAlterStockInfoService yrAlterStockInfoService; 

	/**
	 * 股权转让 显示
	 * @autor: wangjin
	 * @param year pripid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") // /reg/server/yr/alterstock_server/view
	public ModelAndView show(String year,String priPID,String entType) throws Exception {
		ModelAndView view=new ModelAndView("reg/server/search/entreportsearch/yrreport/stock_view");
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			view.addObject("year", year);
			view.addObject("priPID", priPID);
		}
		return view;
	}


	/**
	 * 股权转让 信息表 数据列表  当前年份
	 * @autor: wangjin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list_json_tody"})
	@ResponseBody
	public PageResponse<YrAlterStockInfo> list_json_tody(PageRequest request) throws Exception {
		List<YrAlterStockInfo> data = yrAlterStockInfoService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<YrAlterStockInfo>(data);
	}




}
