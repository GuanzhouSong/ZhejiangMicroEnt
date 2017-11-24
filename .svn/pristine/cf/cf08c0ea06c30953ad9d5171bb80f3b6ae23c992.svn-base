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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:   个体年报App查询接口.（6月30号后申请修改时查询使用），6月30号之前，直接修改主表状态
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/modapplication")
public class AppQueryModApplicationController extends CSBaseController {
	
	//修改申请表
	@Autowired
	private IModApplicationService modApplicationService;
	
	
	/**
	 * 
	 * 描述: 查询当前有效的修改申请列表
	 * @auther gaojinling
	 * @date 2017年2月21日 
	 * @param licConent
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"/querymodapplication.json","list.xml"}, method = RequestMethod.GET)
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryLicence(String pripid,String year)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(pripid) || StringUtil.isBlank(year)){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "120");
				jsonObj.put("errcode", "120");
			    return AjaxResult.success("查询参数不完整", jsonObj); 
			}
			//解密传过来的pripid;
			pripid = AESEUtil.decodeCorpid(pripid); 
			//查询当前有效的修改申请列表
			List<ModApplication> data = modApplicationService.selectModApplicationPriPIDAndYear(Integer.parseInt(year), pripid);
			if(data != null && data.size() > 0){
				for(ModApplication modApplication :data ){
					Map<String, Object> objMap = new HashMap<String, Object>();
					objMap.put("UID", modApplication.getUID()); //唯一标识
					objMap.put("priPID", AESEUtil.encodeCorpid(modApplication.getPriPID()));
					objMap.put("year", modApplication.getYear());
					objMap.put("modReason", modApplication.getModReason());//提交申请修改原因
					objMap.put("modSubmitDate", DateUtil.dateToString(modApplication.getModSubmitDate(),"yyyy-MM-dd")); //审核提交日期
					objMap.put("modResult", modApplication.getModResult()); //审核结果  0  待审核  1同意  2  不同意
					objMap.put("modDescription", modApplication.getModDescription() == null ? "" :modApplication.getModDescription());  //审核理由
					objMap.put("audName", modApplication.getAudName() == null ? "" : modApplication.getAudName()); //审核人员
					objMap.put("audDate", modApplication.getAudDate() == null ? "" : DateUtil.dateToString(modApplication.getAudDate(),"yyyy-MM-dd")); //审核日期
					objMap.put("modResubmit", modApplication.getModResubmit()); //资料已重新提交，记录失效为1，未失效为0
					jsonObjList.add(objMap);
				}
			}
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			jsonObj.put("errcode", "0");
			jsonObj.put("msg", "查询成功");
		    return AjaxResult.success("查询成功", jsonObj);
		} catch (Exception e) {
			jsonObj.put("errcode", "500");
			jsonObj.put("errcode", "查询失败");
			e.printStackTrace();
		    return AjaxResult.success("查询失败", jsonObj);
		}
	}	
	
}