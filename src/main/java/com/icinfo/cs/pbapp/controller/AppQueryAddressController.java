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

import com.icinfo.cs.base.dto.SelectCodeAddress;
import com.icinfo.cs.base.service.ICodeAddressService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:   个体年报App联络员信息查询.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/address")
public class AppQueryAddressController extends CSBaseController {
	
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	//mid基本信息表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	//mid法定代表人表
	@Autowired
	private IMidLeRepService midLeRepService;
	@Autowired
	private ICodeAddressService codeAddressService;
	
	/**
	 * 
	 * 描述: 个体年报App联络员信息查询
	 * @auther gaojinling
	 * @date 2017年2月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryaddress.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryEppassword(String code)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(code)){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "120");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			
			SelectCodeAddress selectCodeAddress = codeAddressService.selectByPriKey(code);
			if(selectCodeAddress == null || StringUtil.isBlank(selectCodeAddress.getCode())){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "1");
			    return AjaxResult.success("查询参数下无对应的市县区", jsonObj);  
			}
			SelectCodeAddress data = codeAddressService.setSubCode(selectCodeAddress, null);

			if(data != null && data.getCodeAddress() != null && data.getCodeAddress().size() >0 ){
				Map<String, Object> objMap = new HashMap<String, Object>();				
				objMap.put("code", data.getCode());
				objMap.put("addressName", data.getAddressName());
				objMap.put("codeAddress", data.getCodeAddress());
				jsonObjList.add(objMap);
			}
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			jsonObj.put("errcode", "0"); 
		    return AjaxResult.success("查询成功", jsonObj);
		} catch (Exception e) {
			jsonObj.put("errcode", "500");
			e.printStackTrace();
		    return AjaxResult.success("查询失败", jsonObj);
		}
	}	
	
}