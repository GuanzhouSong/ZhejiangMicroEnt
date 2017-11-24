/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrPbLicenceInfo;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbLicenceInfoService;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    工商端个体户报表查看<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Controller
@RequestMapping("/reg/server/yr/pb/pbbaseinfoserver")
public class YrPbBaseInfoServerController extends BaseController {
	
	//个体基本信息
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	//主表
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	//个体许可证
	@Autowired
	private IYrPbLicenceInfoService yrPbLicenceInfoService;
	//个体网站
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;	
	/**
	 * 
	 * 描述: 进入个体年报查看页（工商端）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/reportlist")
	public ModelAndView serverList(String priPID,String year) throws Exception{	
		//登陆成功后进入个体年报填报页
		ModelAndView view = new ModelAndView("/reg/server/search/entreportsearch/yrreport/pbreport_view");        
        //查询年报主表信息
        YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));       
        //查询个体户基本表信息
        YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, priPID,"1");
        view.addObject("yrPbBaseInfo",yrPbBaseInfo);
    	view.addObject("yrRegCheck", yrRegCheck);
		return view;
	}
	
	/**
	 * 
	 * 描述:返回单个年份个体公示信息分页（工商端查看）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/licencelist.json", "licencelist.xml" })
	@ResponseBody
	public PageResponse<YrPbLicenceInfo> licencelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrPbLicenceInfo> data = new ArrayList<YrPbLicenceInfo>();
		if(map.containsKey("anCheID")){
			 data=yrPbLicenceInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrPbLicenceInfo>(data);
	}
	
	/**
	 * 
	 * 描述:返回单个年份个体网站信息分页（工商端查看）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/websitelist.json", "websitelist.xml" })
	@ResponseBody
	public PageResponse<YrPbWebsiteInfo> websitelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrPbWebsiteInfo> data = new ArrayList<YrPbWebsiteInfo>();
		if(map.containsKey("anCheID")){
			 data=yrPbWebsiteInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrPbWebsiteInfo>(data);
	}
}