package com.icinfo.cs.quartz.controller.syn.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.quartz.service.IPubDtInfoQuartzJobService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: TODO
 * @author: 赵祥江 
 * @date: 2016年10月24日 上午10:08:55
 * @version: V1.0  
 */
@Controller
@RequestMapping("/quartz/pubDtInfoPush")
public class PubDtInfoQuartzJobController extends BaseController{
	@Autowired
	private IPubDtInfoQuartzJobService pubDtInfoQuartzJobService; 
	
	/**
	 * 
	 * 描述   重新分流 推送失败的数据
	 * @author 赵祥江
	 * @date 2016年12月29日 下午3:57:09 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/pubFailPush", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pubFailPush() throws Exception {
		try {
			String msg=pubDtInfoQuartzJobService.pubFailPush();
			return AjaxResult.success(msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("分流失败");
	}
	
	/**
	 * 
	 * 描述   触发定时分流任务
	 * @author 赵祥江
	 * @date 2016年12月29日 下午3:57:52 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/pubDtInfoHandPush", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pubDtInfoHandPush(String flag,String priPIDStr) throws Exception {
		try {
			String msg=pubDtInfoQuartzJobService.pubDtInfoPush(flag,priPIDStr);
			return AjaxResult.success(msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("分流失败");
	}
	
	
	/**
	 * 
	 * 描述  跳转到触发定时分流维护页面
	 * @author 赵祥江
	 * @date 2017年3月28日 下午4:03:53 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubdtinfoMaintainPush")
	public ModelAndView pubdtinfoMaintainPush() throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdtinfo/pubdtinfoMaintain_edit");
		return view;
	}
	
	
	/**
	 * 
	 * 描述   晚上触发定时分流
	 * @author 赵祥江
	 * @date 2017年3月28日 下午3:30:09 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	public AjaxResult pubDtInfoPush() throws Exception {
		try {
			String msg=pubDtInfoQuartzJobService.pubDtInfoPush("5","");
			return AjaxResult.success(msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("分流失败");
	}
	
}
