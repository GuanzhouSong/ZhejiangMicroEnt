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
import com.icinfo.cs.yr.model.YrPbLicenceInfo;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbLicenceInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述:个体户app许可列表维护
 * @author gaojinling
 * @date 2017年2月21日
 */
@Controller
@RequestMapping("/app/updatelicinfo")
public class AppUpdateYrPbLicInfoController extends CSBaseController {

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
	private IYrPbLicenceInfoService yrPbLicenceInfoService;
	
	/**
	 * 
	 * 描述: 保存或者修改个体户许可信息报表（传入lic值列表）
	 * @auther gaojinling
	 * @date 2017年3月15日 
	 * @param infos
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/licinfo", method = RequestMethod.POST)
	@ResponseBody 
	public AjaxResult saveWebInfo(@RequestBody List<YrPbLicenceInfo> infos) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(infos.isEmpty()){
				jsonObj.put("status", "120");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
				int i=0;
				for(YrPbLicenceInfo yrPbLicenceInfo :infos){
					if(yrPbLicenceInfo == null || StringUtil.isBlank(yrPbLicenceInfo.getAnCheID()) || StringUtil.isBlank(yrPbLicenceInfo.getStatus())){
				}
				if("1".equals(yrPbLicenceInfo.getStatus())){ //添加
					 i= i+yrPbLicenceInfoService.saveYrPbLicenceInfo(yrPbLicenceInfo);
				}
				if("2".equals(yrPbLicenceInfo.getStatus())){ //删除
					if(StringUtil.isBlank(yrPbLicenceInfo.getLicID())){
					}else{
						i=i+yrPbLicenceInfoService.deleteYrPbLicenceInfoRtn(yrPbLicenceInfo.getLicID());
					}
				}
				if("3".equals(yrPbLicenceInfo.getStatus())){ //修改
					if(StringUtil.isBlank(yrPbLicenceInfo.getLicID())){
					}else{
						i=i+yrPbLicenceInfoService.updateYrPbLicenceInfo(yrPbLicenceInfo);
					}
				}
				}
				jsonObj.put("status", "0");
				jsonObj.put("msg", "操作成功"+i+"条");
				jsonObj.put("errorcode", "0");
				return AjaxResult.success("操作成功"+i+"条", jsonObj);
			}
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("msg", e.getMessage());
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
	public AjaxResult addlicInfo(@RequestBody YrPbLicenceInfo yrPbLicenceInfo) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(yrPbLicenceInfo == null || StringUtil.isBlank(yrPbLicenceInfo.getAnCheID())){
				jsonObj.put("status", "120");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
			    if(yrPbLicenceInfoService.saveYrPbLicenceInfo(yrPbLicenceInfo) >0 ){
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
	public AjaxResult updatelicInfo(@RequestBody YrPbLicenceInfo yrPbLicenceInfo) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(yrPbLicenceInfo == null || StringUtil.isBlank(yrPbLicenceInfo.getAnCheID()) || StringUtil.isBlank(yrPbLicenceInfo.getLicID())){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
			    if(yrPbLicenceInfoService.updateYrPbLicenceInfo(yrPbLicenceInfo) >0 ){
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
	public AjaxResult deletelicInfo(@RequestBody YrPbLicenceInfo yrPbLicenceInfo) throws Exception{
		JSONObject jsonObj = new JSONObject();
		try {
			if(yrPbLicenceInfo == null || StringUtil.isBlank(yrPbLicenceInfo.getAnCheID()) || StringUtil.isBlank(yrPbLicenceInfo.getLicID())){
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数不完整");
				jsonObj.put("errorcode", "120");
				return AjaxResult.success("参数不完整", jsonObj);
			}else{
			    if(yrPbLicenceInfoService.deleteYrPbLicenceInfoRtn(yrPbLicenceInfo.getLicID()) >0 ){
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
