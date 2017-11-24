/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.rpt.rptdto.PubSearchLogRptDto;
import com.icinfo.cs.rpt.rptservice.IPubSearchLogRptService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_search_log 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月09日
 */
@Controller
@RequestMapping("/reg/server/pubsearchlogrpt" )
public class PubSearchLogRptController extends BaseController {
	@Autowired
	private IPubSearchLogRptService pubSearchLogRptService;
	
	/** 
	 * 描述: 进入公示系统访问情况统计页面
	 * @auther ZhouYan
	 * @date 2017年10月09日 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/rpt/pubsearchlogrpt_list"); 
		view.addObject("endCheckPushDate",DateUtil.getNdaylater2(DateUtil.getSysDate(), 0));    //结束日期
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/** 
	 * 描述: 公示系统访问情况统计
	 * @auther ZhouYan
	 * @date 2017年10月9日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({"/list.json","list.xml"})
	@ResponseBody
	public PageResponse<PubSearchLogRptDto> rptYrCountJSON(PageRequest request)throws Exception{
	 List<PubSearchLogRptDto> data= pubSearchLogRptService.selectPubSearchLogRpt(request);
	 return new PageResponse<PubSearchLogRptDto>(data);
	}
}