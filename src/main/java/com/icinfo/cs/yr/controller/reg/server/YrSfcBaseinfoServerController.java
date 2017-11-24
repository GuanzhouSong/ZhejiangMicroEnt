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

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.model.YrSfcBranchInfo;
import com.icinfo.cs.yr.model.YrSfcLicenceInfo;
import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.cs.yr.model.YrSfcWebsiteInfo;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrSfcBaseinfoService;
import com.icinfo.cs.yr.service.IYrSfcBranchInfoService;
import com.icinfo.cs.yr.service.IYrSfcLicenceInfoService;
import com.icinfo.cs.yr.service.IYrSfcSocialSecurityService;
import com.icinfo.cs.yr.service.IYrSfcWebsiteInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    工商端农专报表查看.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Controller
@RequestMapping("/reg/server/yr/sfc/sfcbaseinfoserver")
public class YrSfcBaseinfoServerController extends BaseController {
	//农专基本信息
	@Autowired
	private IYrSfcBaseinfoService  yrSfcBaseinfoService;	
	//主表
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	//农专许可信息
	@Autowired
	private IYrSfcLicenceInfoService yrSfcLicenceInfoService;
	//农专网站信息
	@Autowired
	private IYrSfcWebsiteInfoService yrSfcWebsiteInfoService;
	//农专分支机构
	@Autowired
	private IYrSfcBranchInfoService yrSfcBranchInfoService;
	//证件类型
	@Autowired
	private ICodeCertypeService codeCertypeService;
	//社保信息表
	@Autowired
	private IYrSfcSocialSecurityService  yrSfcSocialSecurityService;
	
	
	/**
	 * 
	 * 描述: 进入农专报表查看页（工商端查看）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/reportlist")
	public ModelAndView serverList(String priPID,String year) throws Exception{	
		//登陆成功后进入农专年报填报页
		ModelAndView view = new ModelAndView("/reg/server/search/entreportsearch/yrreport/sfcreport_view");
		if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(priPID)){			
			//查询年报主表信息
	        YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));			
			//查询基本信息（）
			YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID,"0");
		    view.addObject("yrSfcBaseinfo",yrSfcBaseinfo);
		    view.addObject("yrRegCheck", yrRegCheck);
			if(Integer.valueOf(year) > 2015){ //社保信息从16年年报开始
				//通过基本信息中的年报id查询社保信息
				YrSfcSocialSecurity yrSfcSocialSecurity = yrSfcSocialSecurityService.selectYrSfcSocialSecurityByAnCheID(yrSfcBaseinfo != null ? yrSfcBaseinfo.getAnCheID() : "0000", "1");
				view.addObject("yrSfcSocialSecurity", yrSfcSocialSecurity);
			}
		    //证件类型
			List<CodeCertype> Certypes = codeCertypeService.selectAll();
		    view.addObject("Certypes", Certypes);
		    view.addObject("year",Integer.parseInt(year));
		}
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
	public PageResponse<YrSfcLicenceInfo> licencelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcLicenceInfo> data = new ArrayList<YrSfcLicenceInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcLicenceInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcLicenceInfo>(data);
	}
	
	/**
	 * 
	 * 描述:返回单个年份农专网站信息分页（工商端查看）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/websitelist.json", "websitelist.xml" })
	@ResponseBody
	public PageResponse<YrSfcWebsiteInfo> websitelistJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcWebsiteInfo> data = new ArrayList<YrSfcWebsiteInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcWebsiteInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcWebsiteInfo>(data);
	}
	
	
	/**
	 * 
	 * 描述:返回单个年份个体公示信息分页（预览页用到）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/branchlist.json", "branchlist.xml" })
	@ResponseBody
	public PageResponse<YrSfcBranchInfo> listJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcBranchInfo> data = new ArrayList<YrSfcBranchInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcBranchInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcBranchInfo>(data);
	}
	
	
	
	
}