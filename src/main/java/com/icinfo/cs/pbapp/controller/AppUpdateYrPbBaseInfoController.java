package com.icinfo.cs.pbapp.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPhoneapplyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述:个体户app联络员维护
 * @author gaojinling
 * @date 2017年2月21日
 */
@Controller
@RequestMapping("/app/updatebaseinfo")
public class AppUpdateYrPbBaseInfoController extends CSBaseController {

	//联络员备案信息
	@Autowired
	private IPubPhoneapplyService  pubPhoneApplyService;
	//联络员确认信息
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	//发送短信方法类
	@Autowired
	private ISmsService smsService;
	//系统日志
	@Autowired
	private ISysLogService sysLogService;
	//个体基本信息表
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	
	

	/**
	 * 
	 * 描述:保存或者修改个体户基本信息报表（包含基本信息、经营信息、共产党员党建信息）
	 * @auther gaojinling
	 * @date 2017年2月27日 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/baseinfo", method = RequestMethod.POST)
	@AppTokenCheck
	@ResponseBody 
	public AjaxResult saveBaseInfo(@RequestBody YrPbBaseInfo yrPbBaseInfo)throws Exception{
		JSONObject jsonObj = new JSONObject();		
        try {
			if(yrPbBaseInfo == null || StringUtil.isBlank(yrPbBaseInfo.getAnCheID()) || StringUtil.isBlank(yrPbBaseInfo.getPriPID()) || yrPbBaseInfo.getYear() == null ){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数不完整");
				return AjaxResult.success("参数不完整", jsonObj);
			} 
			//主体身份代码解密
			yrPbBaseInfo.setPriPID(AESEUtil.decodeCorpid(yrPbBaseInfo.getPriPID()));
			int i= yrPbBaseInfoService.updateYrPbBaseInfoByPriPidAndYear(yrPbBaseInfo);
			if(i>0){
				jsonObj.put("status", "0");
				jsonObj.put("msg", "个体户基本信息保存成功");
				return AjaxResult.success("操作成功",jsonObj);  
			}else{
				jsonObj.put("status", "1");
				jsonObj.put("msg", "个体户基本信息保存失败");
				return AjaxResult.success("操作失败",jsonObj);  
			}
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	

}
