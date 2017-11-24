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
import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.cs.yr.service.ISysLicenseService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:   个体年报App联络员信息查询.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/licence")
public class AppQueryLicenceController extends CSBaseController {
	
	//系统许可证列表
	@Autowired
	private ISysLicenseService sysLicenseService;
	
	/**
	 * 
	 * 描述: 个体户许可证列表
	 * @auther gaojinling
	 * @date 2017年2月17日 
	 * @param licConent
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/querylicence.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryLicence(String licConent)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			//查询有效的许可证列表
			List<SysLicense> data = sysLicenseService.selectVaildLicListOrderBy(licConent);
			for(SysLicense sysLicense :data ){
				Map<String, Object> objMap = new HashMap<String, Object>();
				objMap.put("licNO", sysLicense.getLicNO() == null ? "" : sysLicense.getLicNO() );  // 许可编号
				objMap.put("licType", sysLicense.getLicType() == null ? "" : sysLicense.getLicType());  //1 前置  2 后置
				objMap.put("licName", sysLicense.getLicName() == null ? "" : sysLicense.getLicName()); //许可名称
				jsonObjList.add(objMap);
			}
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			jsonObj.put("errcode", "0");
		    return AjaxResult.success("查询成功", jsonObj);
		} catch (Exception e) {
			jsonObj.put("errcode", "1");
			e.printStackTrace();
		    return AjaxResult.success("查询失败", jsonObj);
		}
	}	
	
}