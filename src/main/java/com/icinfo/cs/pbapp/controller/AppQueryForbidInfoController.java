/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.pbapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.service.ISysForbidwordService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:   个体年报App有效敏感词查询.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/forbidinfo")
public class AppQueryForbidInfoController extends CSBaseController {
	
	@Autowired
	private ISysForbidwordService sysForbidwordService;
	
	/**
	 * 
	 * 描述: 个体年报App有效敏感词查询
	 * @auther gaojinling
	 * @date 2017年2月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryforbidinfo.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryForbidInfo()throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> queryForbidList = new ArrayList<Object>();
		try {
			//有效敏感词信息列表
			List<SysForbidword> data = sysForbidwordService.doGetListForCache();
			for(SysForbidword sysforbidWord:data ){
				Map<String, Object> objMap = new HashMap<String, Object>();
				objMap.put("banLetter", sysforbidWord.getBanLetter());
				queryForbidList.add(objMap);
			}
			jsonObj.put("result",  JSONArray.fromObject(queryForbidList));
			jsonObj.put("errcode", "0");
		} catch (Exception e) {
			jsonObj.put("errcode", "1");
			e.printStackTrace();
		}
     return AjaxResult.success("", jsonObj);
	}	
	
}