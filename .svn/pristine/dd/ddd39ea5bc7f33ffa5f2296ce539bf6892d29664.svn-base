package com.icinfo.cs.pbapp.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPhoneapplyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述:个体户app联络员维护
 * @author gaojinling
 * @date 2017年2月21日
 */
@Controller
@RequestMapping("/app/updatewebinfo")
public class AppUpdateYrPbWebInfoController extends CSBaseController {

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
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;
	
	
	/**
	 * 
	 * 描述:保存或者修改个体户网站信息报表（传入web值列表）
	 * @auther gaojinling
	 * @date 2017年2月27日 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/webinfo", method = RequestMethod.POST)
	@ResponseBody 
	public AjaxResult saveWebInfo(@RequestBody List<YrPbWebsiteInfo> yrPbWebsiteInfolist)throws Exception{
		JSONObject jsonObj = new JSONObject();		
        try {
        	if(yrPbWebsiteInfolist.isEmpty()){
    			jsonObj.put("status", "0");
    			jsonObj.put("msg", "操作成功");
    			jsonObj.put("errorcode", "0");
    			return AjaxResult.success("操作成功", jsonObj);
        	}else{
        		int i=0;
        		for(YrPbWebsiteInfo yrPbWebsiteInfo :yrPbWebsiteInfolist){
        			if(yrPbWebsiteInfo == null || StringUtil.isBlank(yrPbWebsiteInfo.getAnCheID()) || StringUtil.isBlank(yrPbWebsiteInfo.getStatus())){
    			}
    			if("1".endsWith(yrPbWebsiteInfo.getStatus())){ //添加
    				 i= i+yrPbWebsiteInfoService.saveYrPbWebsiteInfo(yrPbWebsiteInfo);
    			}
    			if("2".endsWith(yrPbWebsiteInfo.getStatus())){ //删除
    				if(StringUtil.isBlank(yrPbWebsiteInfo.getWebID())){
    				}else{
    					i=i+yrPbWebsiteInfoService.deleteByWebID(yrPbWebsiteInfo.getWebID());
    				}
    			}
    			if("3".endsWith(yrPbWebsiteInfo.getStatus())){ //修改
    				if(StringUtil.isBlank(yrPbWebsiteInfo.getWebID())){
    				}else{
    					i=i+yrPbWebsiteInfoService.updateYrPbWebsiteInfo(yrPbWebsiteInfo);
    				}
    			}
        		}
    			jsonObj.put("status", "0");
    			jsonObj.put("msg", "操作成功"+i+"条,总共"+yrPbWebsiteInfolist.size()+"条");
    			jsonObj.put("errorcode", "0");
    			return AjaxResult.success("操作成功"+i+"条", jsonObj);
        }
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("msg", e.getMessage());
			jsonObj.put("errorcode", "500");
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	
	
	/**
	 * 
	 * 描述: 保存
	 * @auther gaojinling
	 * @date 2017年3月15日 
	 * @param yrPbLicenceInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@AppTokenCheck
	@ResponseBody 
	public AjaxResult addlicInfo(@RequestBody YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(yrPbWebsiteInfo == null || StringUtil.isBlank(yrPbWebsiteInfo.getAnCheID())){
				jsonObj.put("status", "120");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
			    if(yrPbWebsiteInfoService.saveYrPbWebsiteInfo(yrPbWebsiteInfo) >0 ){
					jsonObj.put("status", "0");
					jsonObj.put("msg", "操作成功");
					jsonObj.put("errorcode", "0");
			    }else{
					jsonObj.put("status", "1");
					jsonObj.put("msg", "操作方法执行失败");
					jsonObj.put("errorcode", "1");
			    }
				return AjaxResult.success("操作成功", jsonObj);
			}
		} catch (Exception e) {
			jsonObj.put("status", "500");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	
	/**
	 * 
	 * 描述: 修改
	 * @auther gaojinling
	 * @date 2017年3月15日 
	 * @param yrPbLicenceInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@AppTokenCheck
	@ResponseBody 
	public AjaxResult updatelicInfo(@RequestBody YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(yrPbWebsiteInfo == null || StringUtil.isBlank(yrPbWebsiteInfo.getAnCheID()) || StringUtil.isBlank(yrPbWebsiteInfo.getWebID())){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
			    if(yrPbWebsiteInfoService.updateYrPbWebsiteInfo(yrPbWebsiteInfo) >0 ){
					jsonObj.put("status", "0");
					jsonObj.put("msg", "操作成功");
					jsonObj.put("errorcode", "0");
			    }else{
					jsonObj.put("status", "1");
					jsonObj.put("msg", "操作方法执行失败");
					jsonObj.put("errorcode", "1");
			    }
				return AjaxResult.success("操作成功", jsonObj);
			}
		} catch (Exception e) {
			jsonObj.put("status", "500");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2017年3月15日 
	 * @param yrPbLicenceInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@AppTokenCheck
	@ResponseBody 
	public AjaxResult deletelicInfo(@RequestBody YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(yrPbWebsiteInfo == null || StringUtil.isBlank(yrPbWebsiteInfo.getAnCheID()) || StringUtil.isBlank(yrPbWebsiteInfo.getWebID())){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
			    if(yrPbWebsiteInfoService.deleteYrPbWebsiteInfoRtn(yrPbWebsiteInfo.getWebID()) >0 ){
					jsonObj.put("status", "0");
					jsonObj.put("msg", "操作成功");
					jsonObj.put("errorcode", "0");
			    }else{
					jsonObj.put("status", "1");
					jsonObj.put("msg", "操作方法执行失败");
					jsonObj.put("errorcode", "1");
			    }
				return AjaxResult.success("操作成功", jsonObj);
			}
		} catch (Exception e) {
			jsonObj.put("status", "500");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("操作失败",jsonObj);  
		}
	}
	
	

}
