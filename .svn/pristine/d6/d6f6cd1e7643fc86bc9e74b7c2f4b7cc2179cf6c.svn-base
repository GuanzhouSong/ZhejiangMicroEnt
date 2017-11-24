package com.icinfo.cs.pbapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述: 个体户app 修改年报
 * @author gaojinling
 * @date 2017年2月27日
 */
@Controller
@RequestMapping("/app/updatemodapplication")
public class AppUpdateModApplicationController extends CSBaseController {

	//修改申请
	@Autowired
	private IModApplicationService modApplicationService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	
	/**
	 * 
	 * 描述: 修改申请提交（6月30号后，需审核后才能修改）
	 * @auther gaojinling
	 * @date 2017年2月21日 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modapplication", method = RequestMethod.POST)
	@AppTokenCheck
	@ResponseBody 
	public AjaxResult modPbapplication(@RequestBody ModApplication modApplication ) throws Exception{
		JSONObject jsonObj = new JSONObject();		
        try {        
			if(modApplication == null || StringUtil.isBlank(modApplication.getPriPID())){
				jsonObj.put("status", "1");
				jsonObj.put("errcode", "120");
				jsonObj.put("msg", "参数为空");
				return AjaxResult.success("参数为空", jsonObj);
			}
			//对象中主体身份代码解密
			modApplication.setPriPID(AESEUtil.decodeCorpid(modApplication.getPriPID()));
			int i= modApplicationService.insertModApplication(modApplication);
			if(i>0){ 
				jsonObj.put("status", "0");
				jsonObj.put("errcode", "0");
				jsonObj.put("msg", "新增成功");
				return AjaxResult.success("新增成功",jsonObj);
			}else{
				jsonObj.put("status", "1");
				jsonObj.put("errcode", "1");
				jsonObj.put("msg", "新增失败");
				return AjaxResult.success("新增失败",jsonObj);
			}
		} catch (Exception e) {
			jsonObj.put("status", "1");
			jsonObj.put("errcode", "1");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success(e.getMessage(),jsonObj);
		} 
	}
	
	/**
	 * 
	 * 描述: 修改年度报告（6月30号前）
	 * @auther gaojinling
	 * @date 2017年2月21日 
	 * @param pripid
	 * @param year
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/modreport",method=RequestMethod.POST)
	@AppTokenCheck
    @ResponseBody
    public AjaxResult modPbYearReport(String pripid, String year) throws Exception {
		 JSONObject jsonObj = new JSONObject();
    	try {
			if(StringUtil.isBlank(pripid) || StringUtil.isBlank(year)){
				jsonObj.put("status",  "1");
			    return AjaxResult.success("参数不完整", jsonObj);
			}
			pripid = AESEUtil.decodeCorpid(pripid); //内部序号解密
			//修改年报 
			int i = yrRegCheckService.modYearReport(pripid, Integer.parseInt(year));
			if(i>0){
				jsonObj.put("status",  "0");
			    return AjaxResult.success("修改操作成功", jsonObj);
			}else{
				jsonObj.put("status",  "1");
			    return AjaxResult.success("修改操作失败", jsonObj);
		    }
			} catch (Exception ex) {
			    jsonObj.put("status",  "1");
			return AjaxResult.success(ex.getMessage(),jsonObj);
		}
	}

}
