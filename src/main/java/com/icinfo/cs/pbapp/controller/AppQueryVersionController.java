/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.pbapp.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 
 * 描述: app版本号查询
 * @author gaojinling
 * @date 2017年3月23日
 */
@Controller
@RequestMapping("/app/version")
public class AppQueryVersionController extends CSBaseController {
	
	
	@Value("${pbApp.version}")
	private  String version;// 版本号

	@Value("${pbApp.url}")
	private  String url;// app下载服务器地址
	

	/**
	 * 
	 * 描述: app版本更新标志查询
	 * @auther gaojinling
	 * @date 2017年3月23日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryversion.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetVersionInfo()throws Exception{
	 JSONObject jsonObj = new JSONObject();
		try {
			if(StringUtil.isNotBlank(version)&&StringUtil.isNotBlank(url)){
				jsonObj.put("needUpdate",  version);
				jsonObj.put("url",  url);
				jsonObj.put("errcode", "0");
				jsonObj.put("msg", "查询成功");
			}else{
				jsonObj.put("errcode", "1");
				jsonObj.put("msg", "当前配置中更新标志或下载链接为空");
			}

		} catch (Exception e) {
			jsonObj.put("errcode", "500");
			jsonObj.put("msg", "查询失败");
			e.printStackTrace();
		}
	     return AjaxResult.success("", jsonObj);
	}	
	
}