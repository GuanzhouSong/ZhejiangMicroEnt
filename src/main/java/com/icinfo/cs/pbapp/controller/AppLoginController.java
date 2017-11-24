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

import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ResultRtn;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubPbpassword;
import com.icinfo.cs.login.service.ILoginService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPbpasswordService;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:   个体年报App联络员登录.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Controller
@RequestMapping("/app/login")
public class AppLoginController extends CSBaseController {
	
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	//mid基本信息表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	//mid法定代表人表
	@Autowired
	private IMidLeRepService midLeRepService;
	@Autowired
	private ILoginService loginService;
	@Autowired
	private IPubPbpasswordService pubPbpasswordService;
	@Autowired
	private TokenManager tokenManager;
    public static final String APP_TOKEN ="token";

	
	/**
	 * 
	 * 描述: 登录
	 * @auther gaojinling
	 * @date 2017年2月28日 
	 * @param tel
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/login.json","list.xml"})
	@ResponseBody
	public AjaxResult doGetQueryLogin(String tel, String password,String entname,String regNo)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(tel) || StringUtil.isBlank(password)){
				jsonObj.put("status", "1");
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "120");
				jsonObj.put("msg", "查询参数不完整");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			//查询条件下的有效个体户联络员信息
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tel", tel);
//			map.put("password", password);
			map.put("entname", entname);
			map.put("regCode", regNo);
			map.put("passtatus", 1); //有效状态
			//工商联络员电话下的联络员信息表
			List<PubEppasswordDto> data = pubEppasswordService.selectPubEppasswordList(map);
			//1.若电话下无联络员信息或者无该联络员获取验证码信息，则认为电话号码有误
			if(data != null && data.size() >0){
				//2.校验输入的校验码
				PubPbpassword pubPbpassword = new PubPbpassword();
				pubPbpassword.setTel(tel);
				pubPbpassword.setPassword(password);
				pubPbpassword.setOperation("2");
				ResultRtn<T> pwdRtn = pubPbpasswordService.doCheckPubPbpassword2(pubPbpassword);
		        if(!pwdRtn.isSucess()){
					jsonObj.put("status", "1");
					jsonObj.put("errcode", pwdRtn.getErrorCode());
					jsonObj.put("msg", pwdRtn.getError());
					return AjaxResult.success(pwdRtn.getError(),jsonObj);
		        }else{
		        	//3. 验证码校验成功后，排除不能允许登录的个体户
				    int xh = 1;
		        	for(PubEppasswordDto pubEppasswordDto :data ){
				        ResultRtn<T> rtn = loginService.doPbPwdAppLogin(pubEppasswordDto);
				        if(!rtn.isSucess()){
				    	}else{
				    		//允许登录的个体户放入列表
							Map<String, Object> objMap = new HashMap<String, Object>();
							objMap.put("xh", xh);
							objMap.put("pripid", AESEUtil.encodeCorpid(pubEppasswordDto.getPripid()));
							objMap.put("password", pubEppasswordDto.getPassword()== null ? "" :pubEppasswordDto.getPassword());
							objMap.put("tel", pubEppasswordDto.getTel()== null ? "" :pubEppasswordDto.getTel());
							objMap.put("pasid", pubEppasswordDto.getPasid()== null ? "" :pubEppasswordDto.getPasid());
							objMap.put("passtatus", pubEppasswordDto.getPasstatus());
							objMap.put("applytime", DateUtil.dateToString(pubEppasswordDto.getApplytime(), "yyyy-MM-dd"));
							objMap.put("liaidnum", pubEppasswordDto.getLiaidnum());
							objMap.put("liaidtype", pubEppasswordDto.getLiaidtype() == null ? "" : pubEppasswordDto.getLiaidtype());
							objMap.put("lianame", pubEppasswordDto.getLianame());
							objMap.put("entname", pubEppasswordDto.getEntname());
							objMap.put("regno", pubEppasswordDto.getRegno());
							objMap.put("lerep", pubEppasswordDto.getLerep());
							objMap.put("enttype", pubEppasswordDto.getEnttype());
							objMap.put("unicode", pubEppasswordDto.getUnicode() == null ? "" :pubEppasswordDto.getUnicode());
							objMap.put("createtime", DateUtil.dateToString(pubEppasswordDto.getCreatetime(), "yyyy-MM-dd"));
							objMap.put("lerepphone", pubEppasswordDto.getLerepphone() == null ? "" :pubEppasswordDto.getLerepphone());
							jsonObjList.add(objMap);
							xh = xh +1;
				    	}
					}
		        	  if(jsonObjList != null && jsonObjList.size()>0){
						    jsonObj.put(APP_TOKEN,  tokenManager.generateClientToken(tel));
						    jsonObj.put("length",  jsonObjList.size());
						    jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
						    jsonObj.put("errcode", "0"); 
						    jsonObj.put("msg", "操作成功"); 
					        return AjaxResult.success("操作成功", jsonObj);
		        	  }else{		        		    
		        		    jsonObj.put("result",  "");
						    jsonObj.put("errcode", "2"); 
						    jsonObj.put("msg", "联络员手机号有误，该联络员手机号下无有效可登录的个体户"); 
					        return AjaxResult.success("联络员手机号有误，该联络员手机号下无有效可登录的个体户", jsonObj);
		        	  }
		        }
			}else{
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "1"); 
			    jsonObj.put("msg", "联络员手机号有误，该联络员手机号下无个体户"); 
			    return AjaxResult.success("联络员手机号有误，该联络员手机号下无个体户", jsonObj);	
			}
		} catch (Exception e) {
			jsonObj.put("errcode", "500");
			jsonObj.put("msg", "操作失败");
		    return AjaxResult.success("操作失败", jsonObj);
		}
	}
	
	
	
	
	
	
	

	
}