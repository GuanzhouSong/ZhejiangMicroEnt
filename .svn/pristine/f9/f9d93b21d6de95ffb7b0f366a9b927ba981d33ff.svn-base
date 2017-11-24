package com.icinfo.cs.pbapp.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubPbpassword;
import com.icinfo.cs.login.model.PubPhoneapply;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPbpasswordService;
import com.icinfo.cs.login.service.IPubPhoneapplyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述:个体户app联络员维护
 * @author gaojinling
 * @date 2017年2月21日
 */
@Controller
@RequestMapping("/app/updateeppassword")
public class AppUpdateEppassWordController extends CSBaseController {

	//联络员备案信息
	@Autowired
	private IPubPhoneapplyService  pubPhoneApplyService;
	//联络员备案信息
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	//发送短信方法类
	@Autowired
	private ISmsService smsService;
	//系统日志
	@Autowired
	private ISysLogService sysLogService;
	//工商联络员号码发送验证码表
	@Autowired
	private IPubPbpasswordService pubPbpasswordService;
	
	

	/**
	 * 
	 * 描述: 联络员注册或变更（result 中为phoneApply）
	 * @auther gaojinling
	 * @date 2017年2月20日 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/phoneapply", method = RequestMethod.POST)
	@ResponseBody 
	public AjaxResult pubsavePhoneApply(@Valid PubPhoneapply phoneApply )throws Exception{
		JSONObject jsonObj = new JSONObject();		
        try {        
			if(phoneApply == null || StringUtil.isBlank(phoneApply.getPripid())){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数为空");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数为空", jsonObj);
			} 
			phoneApply.setPripid(AESEUtil.decodeCorpid(phoneApply.getPripid()));
			
			String pasID; //流水号
			pasID = StringUtil.getSeqNumber(); //流水号  
			phoneApply.setCreatetime(new Date());//时间戳
			phoneApply.setPasstatus("02");//申请状态        		
			phoneApply.setPasid(pasID);//流水号
			//处理外国法定代表人数据，保存入库
			phoneApply.setLerep(StringUtil.doHtm(phoneApply.getLerep()));
			int count = pubPhoneApplyService.savePubPhoneapply(phoneApply);
			boolean acceptFlag = true;
			//个体户同时做接收操作
			acceptFlag = pubPhoneApplyService.acceptPubPhoneApply(pasID,null);
			if(count>0 && acceptFlag){
				jsonObj.put("msg", "操作成功");
				jsonObj.put("status", "0");
				jsonObj.put("errorcode", "0");
				return AjaxResult.success("操作成功", jsonObj);
			}else{
				jsonObj.put("msg", "操作失败");
				jsonObj.put("status", "1");
				jsonObj.put("errorcode", "1");
			    return AjaxResult.success("操作失败",jsonObj);  
			}
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("errorcode", "500");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	/**
	 * 
	 * 描述: 联络员登录  发送短信获取验证码，同时更新密码
	 * @auther gaojinling
	 * @date 2017年2月22日 
	 * @param tel 联络员联系电话
	 * @param regorg  登记机关编码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/eppassword",method = RequestMethod.POST)    //post方式
	@ResponseBody 
	public AjaxResult pubsaveEppassword(String tel,String regorg)throws Exception{
		PubEppassword pubEppassword = new PubEppassword();
		JSONObject jsonObj = new JSONObject();			
        try {
			if(StringUtil.isBlank(tel)){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数为空");
				jsonObj.put("pwd", "");
				return AjaxResult.success("参数为空", jsonObj);
			} 
			
			pubEppassword.setTel(tel);
			// 2.生成验证码
	    	String password = String.valueOf(StringUtil.NextInt(100000,999999));
	    	// 3.保存验证码,发送短信
		    pubEppassword.setPassword(password);
//		    if(pubEppasswordService.updatePwdByTel(pubEppassword) >0 ){
		    	PubPbpassword pubPbpassword = new PubPbpassword();
		        pubPbpassword.setTel(tel);
		    	pubPbpassword.setPassword(password);
		    	pubPbpassword.setOperation("2");
		    	//先删除当前联络员电话获取的验证码，再保存验证码
		    	pubPbpasswordService.deletePwd(pubPbpassword);
		    	pubPbpasswordService.save(pubPbpassword);
		    	//发短信
		    	String msgContent = "[浙江工商年报]登录验证码：" + password +"（6月30号之前有效），请勿将此码告诉他人。";
	        	smsService.doSendMsg(pubEppassword.getTel(), msgContent, regorg);
				jsonObj.put("status", "0");
				jsonObj.put("msg", "修改密码,发送短信成功");
				jsonObj.put("pwd", password);
				return AjaxResult.success("发送短信成功", jsonObj);
//		    }else{
//				jsonObj.put("status", "1");
//				jsonObj.put("msg", "修改密码发送短信失败");
//				jsonObj.put("pwd", "");
//				return AjaxResult.success("发送短信失败", jsonObj);
//		    }
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	

}
