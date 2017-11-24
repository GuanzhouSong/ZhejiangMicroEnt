/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.dto.YrWebsiteInfoDto;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.cs.yr.service.IYrWebsiteInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;

import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 描述:    cs_yr_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/yrwebsiteinfo")
public class YrWebsiteInfoController extends BaseController {

    @Autowired
	private IYrWebsiteInfoService yrWebsiteInfoService;

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
		ModelAndView view = new ModelAndView("/reg/client/yr/other/websiteInfo_view");
		if (StringUtils.isNotBlank(webid)) {
			YrWebsiteInfo yrWebsiteInfo = yrWebsiteInfoService.selectYrWebsiteInfoByWebId(webid);
			view.addObject("yrWebsiteInfo", yrWebsiteInfo);
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
	public ModelAndView show(YrWebsiteInfoDto yrWebsiteInfoDto) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/other/websiteInfo_add");
		view.addObject("anCheID",yrWebsiteInfoDto.getAnCheID());
		view.addObject("priPID",yrWebsiteInfoDto.getPriPID());
		view.addObject("year",yrWebsiteInfoDto.getYear());
		view.addObject("selectedValue",yrWebsiteInfoDto.getSelectedValue());
		return view;
	}

	/**
	 * 年报网站网店 保存和修改
	 * @author:wangjin
	 * @param yrWebsiteInfo
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save( YrWebsiteInfo yrWebsiteInfo) throws Exception {
		if (StringUtil.checkYearAndPripid(yrWebsiteInfo.getYear(), yrWebsiteInfo.getPriPID())&&
				StringUtils.isNotBlank(yrWebsiteInfo.getAnCheID())) {
			if (yrWebsiteInfoService.insert(yrWebsiteInfo) > 0) {
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
	 * @param yrWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doReadList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doReadList(YrWebsiteInfo yrWebsiteInfo) throws Exception {
		if (StringUtil.checkYearAndPripid(yrWebsiteInfo.getYear(), yrWebsiteInfo.getPriPID()) &&
				StringUtils.isNotBlank(yrWebsiteInfo.getAnCheID())) {
			List<YrWebsiteInfo> data = yrWebsiteInfoService.selectByYearAndPriPID(yrWebsiteInfo.getYear(), yrWebsiteInfo.getPriPID());
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
		if (StringUtils.isNotBlank(priPID) && StringUtils.isNotBlank(webid)) {
			if (yrWebsiteInfoService.deleteByWebidwebid(webid, priPID) > 0) {
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
	public AjaxResult deleteAll(YrWebsiteInfo yrWebsiteInfo) throws Exception{
		if(StringUtil.checkYearAndPripid(yrWebsiteInfo.getYear(),yrWebsiteInfo.getPriPID())&&
				StringUtils.isNotBlank(yrWebsiteInfo.getAnCheID())){
			if(yrWebsiteInfoService.deleteAll(yrWebsiteInfo)>0){
				return AjaxResult.success("执行成功!");
			}
		}
		return  AjaxResult.error("执行失败");
	}

}