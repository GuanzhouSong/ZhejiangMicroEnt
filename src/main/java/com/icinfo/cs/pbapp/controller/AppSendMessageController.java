package com.icinfo.cs.pbapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubPbpassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPbpasswordService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.tools.utils.StringUtils;


/**
 * 
 * 描述:个体户app发送短信接口（验证手机号的有效性）
 * @author gaojinling
 * @date 2017年2月21日
 */
@Controller
@RequestMapping("/app/sendmessage")
public class AppSendMessageController extends CSBaseController {

	//发送短信方法类
	@Autowired
	private ISmsService smsService;
	//系统日志
	@Autowired
	private ISysLogService sysLogService;
	//工商联络员号码发送验证码表
	@Autowired
	private IPubPbpasswordService pubPbpasswordService;
	//联络员基本信息表
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
	 * 描述: 联络员注册发送短信接口
	 * @auther gaojinling
	 * @date 2017年2月28日 
	 * @param tel
	 * @param regorg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/message",method = RequestMethod.POST)    //post方式
	@ResponseBody 
	public AjaxResult sendMessage(String tel,String regorg)throws Exception{
		JSONObject jsonObj = new JSONObject();			
        try {
			if(StringUtil.isBlank(tel)){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数为空");
				jsonObj.put("pwd", "");
				return AjaxResult.success("参数为空", jsonObj);
			} 
			
			// 2.生成验证码
	    	String password = String.valueOf(StringUtil.NextInt(100000,999999));
	    	PubPbpassword pubPbpassword = new PubPbpassword();
	        pubPbpassword.setTel(tel);
	    	pubPbpassword.setPassword(password);
	    	pubPbpassword.setOperation("1");
	    	//先删除当前联络员电话获取的验证码，再保存验证码
	    	pubPbpasswordService.deletePwd(pubPbpassword);
	    	//发送短信
	    	if(pubPbpasswordService.save(pubPbpassword)>0){
		    	String msgContent = "[浙江年报]校验手机号码获取验证码：" + password +"，请勿将此码告诉他人。";
	        	smsService.doSendMsg(tel, msgContent, regorg);//发短信
				jsonObj.put("status", "0");
				jsonObj.put("msg", "发送短信成功");
				jsonObj.put("pwd", password);
				return AjaxResult.success("发送短信成功", jsonObj);
	    	}else{
				jsonObj.put("status", "0");
				jsonObj.put("msg", "发送短信失败");
				jsonObj.put("pwd", password);
				return AjaxResult.success("发送短信失败", jsonObj);
	    	}
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	/**
	 * 
	 * 描述: 联络员注册或变更校验（包括校验码）
	 * @auther gaojinling
	 * @date 2017年2月28日 
	 * @param tel
	 * @param regorg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/zcMessage.json","list.xml"})    //get方式
	@ResponseBody 
	public AjaxResult ZcMessage(String tel,String password,String regNo,String type)throws Exception{
		JSONObject jsonObj = new JSONObject();	
		 //json结果List
		 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			
			if(StringUtil.isBlank(regNo) ||  StringUtil.isBlank(type)){
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
				jsonObj.put("errcode", "3");
				jsonObj.put("msg", "未找到匹配的个体工商户信息");
			    return AjaxResult.success("未找到匹配的个体工商户信息", jsonObj);  
			}
			MidBaseInfoDto midBaseInfoDto = midBaseinfodata.get(0);
			if (StringUtil.isNotBlank(midBaseInfoDto.getUniCode()) && !midBaseInfoDto.getUniCode().equals(regNo)) {
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("errcode", "4");
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
				jsonObj.put("errcode", "5");
				jsonObj.put("msg", "证件号码异常，请联系工商部门处理");
			    return AjaxResult.success("证件号码异常，请联系工商部门处理", jsonObj);  
		   }
			if("1".equals(type)){
				if(StringUtil.isBlank(tel) ){
					jsonObj.put("msg", "参数为空");
					jsonObj.put("errcode", "120");
					return AjaxResult.success("参数为空", jsonObj);
				} 
				//校验短信
//				PubPbpassword pubPbpassword = new PubPbpassword();
//				pubPbpassword.setTel(tel);
//				pubPbpassword.setPassword(password);
//				pubPbpassword.setOperation("1");
//				ResultRtn<T> pwdRtn = pubPbpasswordService.doCheckPubPbpassword(pubPbpassword);
//		        if(!pwdRtn.isSucess()){
//					jsonObj.put("errcode", pwdRtn.getErrorCode());
//					jsonObj.put("msg", pwdRtn.getError());
//					return AjaxResult.success(pwdRtn.getError(),jsonObj);
//		    	}
				if(!data.isEmpty()){   
					jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
					jsonObj.put("errcode", "6");
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
					objMap.put("tel", tel);
					objMap.put("lerepphone", StringUtil.isBlank(midBaseInfoDto.getTel()) ? "" : midBaseInfoDto.getTel());
					jsonObjList.add(objMap);
				}
		    }else{
				if(data.isEmpty()){   
					jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
					jsonObj.put("errcode", "7");   
					jsonObj.put("msg", "未注册企业，请先注册");   
				    return AjaxResult.success("未注册企业，请先注册", jsonObj); 
				}else{
					 PubEppasswordDto pubEppasswordDto = data.get(0);
					 Map<String, Object> objMap = new HashMap<String, Object>();
					 objMap.put("pripid", AESEUtil.encodeCorpid(midBaseInfoDto.getPriPID()));
					 objMap.put("password", pubEppasswordDto.getPassword()== null ? "" :pubEppasswordDto.getPassword());
					 objMap.put("oldtel", pubEppasswordDto.getTel()== null ? "" :pubEppasswordDto.getTel());
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
					 objMap.put("lerepphone", pubEppasswordDto.getTel() == null ? "" : pubEppasswordDto.getTel() == null);
					 objMap.put("cerNO", StringUtil.isBlank(midBaseInfoDto.getCerNO()) ? "" : midBaseInfoDto.getCerNO());
//					 objMap.put("tel",tel);
					 jsonObjList.add(objMap);
				}
		    }
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			jsonObj.put("errcode", "0"); 
			jsonObj.put("msg", "操作成功"); 
		    return AjaxResult.success("操作成功", jsonObj);
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("errcode", "500");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("系统异常，请稍候再试",jsonObj);  
		}
	}

}
