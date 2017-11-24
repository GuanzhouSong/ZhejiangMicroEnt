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
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:   个体年报App联络员信息查询.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/eppassword")
public class AppQueryEppasswordController extends CSBaseController {
	
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	//mid基本信息表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	//mid法定代表人表
	@Autowired
	private IMidLeRepService midLeRepService;
	
	/**
	 * 
	 * 描述: 个体年报App联络员信息查询
	 * @auther gaojinling
	 * @date 2017年2月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryeppassword.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryEppassword(String regNo,String tel, String password)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(regNo) && (StringUtil.isBlank(tel))){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "120");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			
			//查询条件下的有效个体户联络员信息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pasentkey", regNo);  
			map.put("tel", tel);
			map.put("password", password);
			map.put("passtatus", 1); //有效状态
			List<PubEppasswordDto> data = pubEppasswordService.selectPubEppasswordList(map);
			if(data != null && data.size() >0){
			for(PubEppasswordDto pubEppasswordDto :data ){
				Map<String, Object> objMap = new HashMap<String, Object>();
				objMap.put("pripid", AESEUtil.encodeCorpid(pubEppasswordDto.getPripid()));
				objMap.put("password", pubEppasswordDto.getPassword()== null ? "" :pubEppasswordDto.getPassword());
				objMap.put("tel", pubEppasswordDto.getTel()== null ? "" :pubEppasswordDto.getTel());
				objMap.put("pasid", pubEppasswordDto.getPasid()== null ? "" :pubEppasswordDto.getPasid());
				objMap.put("passtatus", pubEppasswordDto.getPasstatus());
				objMap.put("applytime", DateUtil.dateToString(pubEppasswordDto.getApplytime(), "yyyy-MM-dd"));
				objMap.put("liaidnum", pubEppasswordDto.getLiaidnum());
				objMap.put("liaidtype", pubEppasswordDto.getLiaidtype());
				objMap.put("lianame", pubEppasswordDto.getLianame());
				objMap.put("entname", pubEppasswordDto.getEntname());
				objMap.put("regno", pubEppasswordDto.getRegno());
				objMap.put("lerep", pubEppasswordDto.getLerep());
				objMap.put("enttype", pubEppasswordDto.getEnttype());
				objMap.put("unicode", pubEppasswordDto.getUnicode() == null ? "" :pubEppasswordDto.getUnicode());
				objMap.put("createtime", DateUtil.dateToString(pubEppasswordDto.getCreatetime(), "yyyy-MM-dd"));
				objMap.put("lerepphone", pubEppasswordDto.getLerepphone() == null ? "" :pubEppasswordDto.getLerepphone());
				jsonObjList.add(objMap);
			}
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
	
	
	/**
	 * 
	 * 描述: 个体户联络员注册或变更（校验未加短信，暂时不用）
	 * @auther gaojinling
	 * @date 2017年2月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryeppasswordzc.json","list.xml"})
	@ResponseBody
	public AjaxResult doGetQueryEppasswordZc(String regNo,String type)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(regNo) && (StringUtil.isBlank(type))){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "120");
				jsonObj.put("msg", "查询参数不完整");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			//查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regNO", regNo);
			map.put("entTypeCatg", "3");
			map.put("regState", 1);  //状态有效（直接去除掉不合法的状态   保留登记状态 为 'K', 'B', 'A', 'DA' 的企业）
			//查询状态有效的个体户
			List<MidBaseInfoDto> midBaseinfodata = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
			if(midBaseinfodata == null ||  midBaseinfodata.isEmpty() ){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "1");
				jsonObj.put("msg", "未找到匹配的个体工商户信息");
			    return AjaxResult.success("未找到匹配的个体工商户信息", jsonObj);  
			}
			
			MidBaseInfoDto midBaseInfoDto = midBaseinfodata.get(0);
			if (StringUtil.isNotBlank(midBaseInfoDto.getUniCode()) && !midBaseInfoDto.getUniCode().equals(regNo)) {
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "2");
				jsonObj.put("msg", "有统一代码的个体工商户必须采用统一代码注册或变更");
			    return AjaxResult.success("有统一代码的个体工商户必须采用统一代码注册或变更", jsonObj);
			}
			
			//查询条件下的有效个体户联络员信息
			Map<String, Object> passmap = new HashMap<String, Object>();
			passmap.put("pasentkey", regNo);  
			passmap.put("passtatus", 1); //有效状态
			List<PubEppasswordDto> data = pubEppasswordService.selectPubEppasswordList(passmap);
		   
		   List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", midBaseInfoDto.getPriPID());
	   	   //从法定代表人表取证照号码（）
		   if(leRepList != null && leRepList.size()>0 && StringUtils.isNotEmpty(leRepList.get(0).getCerNO())){
			   midBaseInfoDto.setCerNO(leRepList.get(0).getCerNO());
		   }
		   if(StringUtils.isBlank(midBaseInfoDto.getCerNO())){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "3");
				jsonObj.put("msg", "证件号码异常，请联系工商部门处理");
			    return AjaxResult.success("证件号码异常，请联系工商部门处理", jsonObj);  
		   }
			
			if("1".equals(type)){  //注册
				if(!data.isEmpty()){   
					jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
					jsonObj.put("errcode", "4");
					jsonObj.put("msg", "该个体工商户已注册");   
				    return AjaxResult.success("该个体工商户已注册", jsonObj); 
				}else{
					Map<String, Object> objMap = new HashMap<String, Object>();
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
			}else{  //变更
				if(data.isEmpty()){   
					jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
					jsonObj.put("errcode", "5");   
					jsonObj.put("msg", "未注册企业，请先注册");   
				    return AjaxResult.success("未注册企业，请先注册", jsonObj); 
				}else{
					 PubEppasswordDto pubEppasswordDto = data.get(0);
					 Map<String, Object> objMap = new HashMap<String, Object>();
					 objMap.put("pripid", AESEUtil.encodeCorpid(midBaseInfoDto.getPriPID()));
					 objMap.put("password", pubEppasswordDto.getPassword()== null ? "" :pubEppasswordDto.getPassword());
					 objMap.put("tel", pubEppasswordDto.getTel()== null ? "" :pubEppasswordDto.getTel());
					 objMap.put("pasid", pubEppasswordDto.getPasid()== null ? "" :pubEppasswordDto.getPasid());
					 objMap.put("passtatus", pubEppasswordDto.getPasstatus());
					 objMap.put("applytime", DateUtil.dateToString(pubEppasswordDto.getApplytime(), "yyyy-MM-dd"));
					 objMap.put("liaidnum", pubEppasswordDto.getLiaidnum());
					 objMap.put("liaidtype", pubEppasswordDto.getLiaidtype());
					 objMap.put("lianame", pubEppasswordDto.getLianame());
					 objMap.put("entname", midBaseInfoDto.getEntName());
					 objMap.put("regno", midBaseInfoDto.getRegNO());
					 objMap.put("lerep", midBaseInfoDto.getLeRep());
					 objMap.put("enttype", midBaseInfoDto.getEntType());
					 objMap.put("unicode", midBaseInfoDto.getUniCode() == null ? "" :midBaseInfoDto.getUniCode());
					 objMap.put("createtime", DateUtil.dateToString(pubEppasswordDto.getCreatetime(), "yyyy-MM-dd"));
					 objMap.put("lerepphone", midBaseInfoDto.getTel());
					 jsonObjList.add(objMap);
				}
			}
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			jsonObj.put("errcode", "0"); 
			jsonObj.put("msg", "查询成功"); 
		    return AjaxResult.success("查询成功", jsonObj);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObj.put("result",  "");
			jsonObj.put("errcode", "6");
			jsonObj.put("msg", e.getMessage()); 
		    return AjaxResult.success("查询失败", jsonObj);
		}
	}
	
}