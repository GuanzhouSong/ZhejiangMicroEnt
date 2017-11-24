/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.dto.YrSfcWebsiteInfoDto;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.yr.model.YrSfcWebsiteInfo;
import com.icinfo.cs.yr.service.IYrSfcWebsiteInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_yr_sfc_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/sfcwebsite")
public class YrSfcWebsiteInfoController extends BaseController {
	
	@Autowired
	private IYrSfcWebsiteInfoService yrSfcWebsiteInfoService;


	/**
	 * 描述：查看详情
	 * @author wangjin
	 * @param webid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	@ResponseBody
	public ModelAndView view(String webid) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/sfcyr/websiteInfo_view");
		if (StringUtils.isNotBlank(webid)) {
			YrSfcWebsiteInfo yrSfcWebsiteInfo = yrSfcWebsiteInfoService.selectOneByWebId(webid);
			view.addObject("yrSfcWebsiteInfo", yrSfcWebsiteInfo);
		}
		return view;
	}

	/**
	 * 描述：进入网站网店编辑页面
	 * @author:wangjin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	@ResponseBody
	public ModelAndView show(YrSfcWebsiteInfoDto yrSfcWebsiteInfoDto) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/sfcyr/websiteInfo_add");
		view.addObject("anCheID",yrSfcWebsiteInfoDto.getAnCheID());
		view.addObject("priPID",yrSfcWebsiteInfoDto.getPriPID());
		view.addObject("year",yrSfcWebsiteInfoDto.getYear());
		view.addObject("selectedValue",yrSfcWebsiteInfoDto.getSelectedValue());
		return view;
	}

	/**
	 * 年报网站网店 保存和修改
	 * @author:wangjin
	 * @param yrSfcWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save(YrSfcWebsiteInfo yrSfcWebsiteInfo) throws Exception {
		if (StringUtil.checkYearAndPripid(yrSfcWebsiteInfo.getYear(), yrSfcWebsiteInfo.getPriPID())&&
				com.icinfo.framework.tools.utils.StringUtils.isNotBlank(yrSfcWebsiteInfo.getAnCheID())) {
			if (yrSfcWebsiteInfoService.insert(yrSfcWebsiteInfo) > 0) {
				return AjaxResult.success("保存成功!");
			} else {
				return AjaxResult.error("保存失败!");
			}
		}
		return AjaxResult.error("参数为空,执行失败!");
	}

	/**
	 * 描述：获取网站 网店列表
	 * @author:wangjin
	 * @param yrSfcWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doReadList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doReadList(YrSfcWebsiteInfo yrSfcWebsiteInfo) throws Exception {
		if (StringUtil.checkYearAndPripid(yrSfcWebsiteInfo.getYear(), yrSfcWebsiteInfo.getPriPID()) &&
			StringUtils.isNotBlank(yrSfcWebsiteInfo.getAnCheID())) {
			List<YrSfcWebsiteInfo> data = yrSfcWebsiteInfoService.selectByYearAndPriPID(yrSfcWebsiteInfo.getYear(), yrSfcWebsiteInfo.getPriPID());
			return AjaxResult.success("",data);
		}
		return AjaxResult.error("参数为空,执行失败!");
	}

	/**
	 * 描述：单条删除操作
	 * @param webid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String webid, String priPID) throws Exception {
		if (StringUtils.isNotBlank(priPID) && com.icinfo.framework.tools.utils.StringUtils.isNotBlank(webid)) {
			if (yrSfcWebsiteInfoService.deleteByWebidwebid(webid, priPID) > 0) {
				return AjaxResult.success("删除成功!");
			}
		}
		return AjaxResult.error("删除失败");
	}

	/**
	 * 描述：清空操作
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteall")
	@ResponseBody
	public AjaxResult deleteAll(YrSfcWebsiteInfo yrSfcWebsiteInfo) throws Exception{
		if(StringUtil.checkYearAndPripid(yrSfcWebsiteInfo.getYear(),yrSfcWebsiteInfo.getPriPID())&&
				com.icinfo.framework.tools.utils.StringUtils.isNotBlank(yrSfcWebsiteInfo.getAnCheID())){
			if(yrSfcWebsiteInfoService.deleteAll(yrSfcWebsiteInfo)>0){
				return AjaxResult.success("执行成功!");
			}
		}
		return  AjaxResult.error("执行失败");
	}



//  ----- TODO   分割线----------------------------------------------------------------------------------------------------


	
	/**
	 * 
	 * 描述:返回单个年份农专网站信息分页（进入年报及预览页用到）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/websitelist.json", "websitelist.xml" })
	@ResponseBody
	public PageResponse<YrSfcWebsiteInfo> listJSON(PageRequest request) throws Exception {
		Map<String, Object>  map = request.getParams();	
		List<YrSfcWebsiteInfo> data = new ArrayList<YrSfcWebsiteInfo>();
		if(map.containsKey("anCheID")){
			 data=yrSfcWebsiteInfoService.queryPageByAnCheID(request);
		}
		return new PageResponse<YrSfcWebsiteInfo>(data);
	}
	

	
}