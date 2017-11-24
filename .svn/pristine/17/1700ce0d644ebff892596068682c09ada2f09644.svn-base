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

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:   个体年报App midbaseinfo(核准基本信息表).<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/midbaseinfo")
public class AppQueryMidBaseinfoController extends CSBaseController {
	
	//mid基本信息表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	//mid法定代表人表
	@Autowired
	private IMidLeRepService midLeRepService;

	/**
	 * 
	 * 描述: 个体年报App midbaseinfo(核准基本信息表)
	 * @auther gaojinling
	 * @date 2017年2月17日 
	 * @param regNo 注册号或者统一代码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/querymidbaseinfo.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryMidBaseInfo(String regNo)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(regNo)){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "120");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			
			//查询条件下的联络员信息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regNO", regNo);
			map.put("entTypeCatg", "3");
			map.put("regState", 1);  //状态有效（直接去除掉不合法的状态   保留登记状态 为 'K', 'B', 'A', 'DA' 的企业）
			//查询状态有效的个体户
			List<MidBaseInfoDto> data = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
			if(data != null && data.size() > 0){
			   MidBaseInfoDto midBaseInfoDto = data.get(0);
			   List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", midBaseInfoDto.getPriPID());
		   	   //从法定代表人表取证照号码（）
			   if(leRepList != null && leRepList.size()>0 && StringUtils.isNotEmpty(leRepList.get(0).getCerNO())){
				   midBaseInfoDto.setCerNO(leRepList.get(0).getCerNO());
			   }
				Map<String, Object> objMap = new HashMap<String, Object>();
				/*
				 * 统一代码  注册号  名称  经营者姓名 登记机关名称  经营者身份证号 经营者手机 成立日期 组成形式  经营场所（住所） 经营范围 
				 */
				objMap.put("priPID", AESEUtil.encodeCorpid(midBaseInfoDto.getPriPID()));
				objMap.put("entName", midBaseInfoDto.getEntName());
				objMap.put("regNO", midBaseInfoDto.getRegNO());
				objMap.put("uniCode", StringUtil.isBlank(midBaseInfoDto.getUniCode()) ? "" : midBaseInfoDto.getUniCode());
				objMap.put("dom", StringUtil.isBlank(midBaseInfoDto.getDom()) ? "" : midBaseInfoDto.getDom());
				objMap.put("leRep", StringUtil.isBlank(midBaseInfoDto.getLeRep()) ? "" : midBaseInfoDto.getLeRep());
				objMap.put("cerNO", StringUtil.isBlank(midBaseInfoDto.getCerNO()) ? "" : midBaseInfoDto.getCerNO());
				objMap.put("regOrg", midBaseInfoDto.getRegOrg());
				objMap.put("regOrgName", StringUtil.isBlank(midBaseInfoDto.getRegOrgName()) ? "" :midBaseInfoDto.getRegOrgName());
				objMap.put("estDate", DateUtil.dateToString(midBaseInfoDto.getEstDate(),"yyyy-MM-dd"));
				objMap.put("opForm",  StringUtil.isBlank(midBaseInfoDto.getOpForm()) ? "" : midBaseInfoDto.getOpForm());
				objMap.put("opScope", StringUtil.isBlank(midBaseInfoDto.getOpScope()) ? "" : midBaseInfoDto.getOpScope());
				objMap.put("entType", StringUtil.isBlank(midBaseInfoDto.getEntType()) ? "" : midBaseInfoDto.getEntType());
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