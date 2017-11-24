/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icinfo.cs.sment.model.EntarchivesHelp;
import com.icinfo.cs.sment.service.IEntarchivesHelpService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:   小微企业培育档案库-帮扶信息 sm_bus_entarchives_help 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Controller
@RequestMapping("/sment/entarchives/help")
public class EntarchivesHelpController extends BaseController {
	
	
	@Autowired
	private IEntarchivesHelpService ientarchiveshelpservice;
	
	/**
	 * 描述:企业详情页返回培育信息
	 * @author Czj
	 * @dateTime 2017-5-10
	 * @return map<String,List<EntarchivesHelp>>
	 */
	
	@RequestMapping("/doGetEntarchivesHelpListJSON")
	@ResponseBody
	public AjaxResult doGetEntarchivesHelpJSON(String priPID){
		List<EntarchivesHelp> data= ientarchiveshelpservice.doGetListJSON(priPID);
		String entarchivesHelpCount = Integer.toString(data.size());
		List<String> str=new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
 		for(EntarchivesHelp bean : data){
 			String key = bean.getYear().toString();
			if(!str.contains(key)){
				str.add(key);
			}
		}
 		for(String key: str){
 			List<EntarchivesHelp> list=new ArrayList<EntarchivesHelp>();
 			for(EntarchivesHelp bean : data){
 				if(bean.getYear().toString().equals(key)){
 					list.add(bean);
 				}
 			}
 			map.put(key, list);
 		}
		return AjaxResult.success(entarchivesHelpCount,map);
	}
}