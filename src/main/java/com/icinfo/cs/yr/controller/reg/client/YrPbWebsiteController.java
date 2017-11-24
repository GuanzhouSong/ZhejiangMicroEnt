/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.yr.dto.YrPbWebsiteInfoDto;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * 描述:cs_yr_pb_websiteinfo 对应的Controller类.<br>
 * @author framework generator
 * @data: 2017-05-06
 */
@Controller
@RequestMapping("/reg/client/yr/pb/website")
public class YrPbWebsiteController extends BaseController {
	
	//个体户 网站网店
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;

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
		ModelAndView view = new ModelAndView("/reg/client/yr/pbyr/websiteInfo_view");
		if (StringUtils.isNotBlank(webid)) {
			YrPbWebsiteInfo yrPbWebsiteInfo = yrPbWebsiteInfoService.selectOneByWebId(webid);
			view.addObject("yrPbWebsiteInfo", yrPbWebsiteInfo);
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
	public ModelAndView show(YrPbWebsiteInfoDto yrPbWebsiteInfoDto) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/pbyr/websiteInfo_add");
		view.addObject("anCheID",yrPbWebsiteInfoDto.getAnCheID());
		view.addObject("selectedValue",yrPbWebsiteInfoDto.getSelectedValue());
		return view;
	}

	/**
	 * 年报网站网店 保存和修改
	 * @author:wangjin
	 * @param yrPbWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=3000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save( YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception {
		if (StringUtils.isNotBlank(yrPbWebsiteInfo.getAnCheID())) {
			if (yrPbWebsiteInfoService.insert(yrPbWebsiteInfo) > 0) {
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
	 * @param yrPbWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doReadList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doReadList(YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception {
		if (StringUtils.isNotBlank(yrPbWebsiteInfo.getAnCheID())) {
			List<YrPbWebsiteInfo> data = yrPbWebsiteInfoService.selectByAnCheID(yrPbWebsiteInfo.getAnCheID());
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
	public AjaxResult delete(String webid, String anCheID) throws Exception {
		if (StringUtils.isNotBlank(anCheID) && StringUtils.isNotBlank(webid)) {
			if (yrPbWebsiteInfoService.deleteByWebID(webid) > 0) {
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
	@RequestMapping("/delete_all")
	@ResponseBody
	public AjaxResult deleteAll(YrPbWebsiteInfo yrWebsiteInfo) throws Exception{
		if(StringUtils.isNotBlank(yrWebsiteInfo.getAnCheID())){
			if(yrPbWebsiteInfoService.deleteAll(yrWebsiteInfo)>0){
				return AjaxResult.success("执行成功!");
			}
		}
		return  AjaxResult.error("执行失败");
	}

}