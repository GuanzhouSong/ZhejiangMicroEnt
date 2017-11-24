/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 描述:    cs_yr_otherinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
@Controller
@RequestMapping("/reg/server/yr/yrotherinfo_server")
public class YrOtherInfoServerController extends BaseController {
	@Autowired
	private IYrOtherInfoService yrOtherInfoService;
	@Autowired
	IYrAssetService yrAssetService;
	@Autowired
	private IYrWebsiteInfoService yrWebsiteInfoService;
	@Autowired
	private IYrFormService yrFormService;
	@Autowired
	private IYrBaseInfoService yrBaseInfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	@Autowired
	ICodeCertypeService codeCertypeService; //证件类型


	/**
	 * 显示查看
	 * @autor：wangjin
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view") ///reg/server/yr/yrotherinfo_server/view
	public ModelAndView show(String year,String priPID,String entTypeCatg,String uniscid) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport/other_view");

		if(StringUtil.checkYearAndPripid(year,priPID)) {

			view.addObject("yrOtherInfo", yrOtherInfoService.selectByYearAndPripid(Integer.parseInt(year), priPID));

			// 获取当前企业网站信息列表
			List<YrWebsiteInfo> yrWebsiteInfoList = yrWebsiteInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
			if (yrWebsiteInfoList.size() > 0) {
				view.addObject("yrWebsiteInfoList", yrWebsiteInfoList);
			}

			//证件类型：
		/*	List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
			view.addObject("codeCertypeList", codeCertypeList); //证件类型*/

			view.addObject("entTypeCatg", entTypeCatg);         //企业大类
			view.addObject("year", year);                       //年份
			view.addObject("priPID", priPID);                   //身份主体代码
			view.addObject("uniscid", uniscid);                   //统一社会信用代码
		}

		return view;
	}


	/**
	 * 描述：查看详情
	 * @author wangjin
	 * @param webid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	@ResponseBody
	public ModelAndView show(String webid) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/other/otherwebsite_detial");
		if (StringUtil.isNotEmpty(webid)) {
			YrWebsiteInfo yrWebsiteInfo = yrWebsiteInfoService.selectYrWebsiteInfoByWebId(webid);
			view.addObject("yrWebsiteInfo", yrWebsiteInfo);
		}
		return view;
	}

}