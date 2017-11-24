/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.cs.yr.service.IFoodstorageAuxService;
import com.icinfo.cs.yr.service.IFoodstorageBaseService;
import com.icinfo.cs.yr.service.IFoodstorageInfoService;
import com.icinfo.cs.yr.service.IFoodstorageLicenseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;

/**
 * 描述:    cs_foodstorage_base 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller("FoodstorageBaseClientController")
@RequestMapping("/reg/client/yr/ent/foodstoragebase")
public class FoodstorageBaseController extends BaseController {
	@Autowired
	private IFoodstorageBaseService foodstorageBaseService;
	
	@Autowired
	private ISysLogService sysLogService;
	
	@Autowired
	private IFoodstorageLicenseService foodstorageLicenseService; 
	
	@Autowired
	private IFoodstorageInfoService foodstorageInfoService; 
	
	@Autowired
	private IFoodstorageAuxService foodstorageAuxService;
	/**
	 * 
	 * 描述: 进入食品仓储列表页面
	 * @auther chenxin
	 * @date 2016-09-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView enterListpage(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/auxtab/foodstorage_list");
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if(StringUtils.isNotEmpty(midBaseInfoDto.getPriPID())){
			String priPID = midBaseInfoDto.getPriPID();
			int year = Integer.parseInt(DateUtil.getYear());
			FoodstorageBase foodstorageBase = foodstorageBaseService.selecFoodstorageBaseByPriPIDandYear(priPID,year);
			view.addObject("foodstorageBase",foodstorageBase);
		}
		return view;
	}
	
	/**
     * 获取仓储主表信息
     * @author yujingwei
     * @date 2016-9-26
     * @param session
     * @return AjaxResult
     * @throws Exception
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult doGetInfo(HttpSession session) throws Exception {
    	MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
    	if(StringUtil.isNotEmpty(midBaseInfoDto.getPriPID())){
    		 Integer year = Calendar.getInstance().get(Calendar.YEAR);
    		 FoodstorageBase foodstorageBase = foodstorageBaseService.selecFoodstorageBaseByPriPIDandYear(midBaseInfoDto.getPriPID(),year);
    		 return AjaxResult.success("foodstorageBase", foodstorageBase);
    	}
    	return AjaxResult.success("foodstorageBase",new FoodstorageBase());
    }
	
	
	/**
	 * 描述：保存仓储基本信息（仅保存基本信息，不改变状态）
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=3000)
	public AjaxResult doSave(FoodstorageBase foodstorageBase) throws Exception {
		Map<String, String> logMap = new HashMap<String, String>();
		List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
		foodstorageBase.setYear(Integer.parseInt(DateUtil.getYear()));
		foodstorageBase.setCreateTime(new Date());
		if(foodstorageBase.getId() != null && foodstorageBase.getId() > 0){
			if(foodstorageBase.getSubmitState().equals("2")){
				foodstorageBase.setSetTime(new Date());
			}
			if(!foodstorageBaseService.modFoodstorageBaseAddLog(foodstorageBase, logCollector)){
				return AjaxResult.error("保存失败");
			}
		}else{
			if(foodstorageBase.getSubmitState().equals("2")){
				foodstorageBase.setSetTime(new Date());
			}
			if(!foodstorageBaseService.saveFoodstorageBaseAddLog(foodstorageBase, logCollector)){
				return AjaxResult.error("保存失败");
			}
		}
		logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.SaveFoodstorageBaseLog.getCode());
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_CLIENT);
		SysLogJson logJson = new SysLogJson(logCollector);
		JSONObject jsonObject = JSONObject.fromObject(logJson);
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
		sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
		if(foodstorageBase.getSubmitState().equals("2")){
			return AjaxResult.success("提交成功");
		}
		return AjaxResult.success("暂存成功");
	}
	
	/**
	 * 描述：删除食品生产，食品经营，仓储信息（通过选择类型删除）
	 * 
	 * @author yujingwei
	 * @date 2016-09-29
	 * @param deleteType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doDelete(String deleteType,HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		int year = Integer.parseInt(DateUtil.getYear());
		if(StringUtil.isNotEmpty(deleteType) && StringUtil.isNotEmpty(midBaseInfoDto.getPriPID())){
			if(!deleteType.equals("3")){
				if(foodstorageLicenseService.deleteLicenseInfo(deleteType,midBaseInfoDto.getPriPID(),year)){
					return AjaxResult.success("删除成功！");
				}
			}else{
				if(foodstorageInfoService.deleteStorageInfo(midBaseInfoDto.getPriPID(),year)
						&& foodstorageAuxService.deleteStorageAuxInfo(midBaseInfoDto.getPriPID(),year)){
					return AjaxResult.success("删除成功！");
				}
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
	/**
	 * 描述：删除食品生产，食品经营，仓储信息（直接删除）
	 * 
	 * @author yujingwei
	 * @date 2016-09-29
	 * @param deleteType
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doDeleteAll(HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		int year = Integer.parseInt(DateUtil.getYear());
		if(StringUtil.isNotEmpty(midBaseInfoDto.getPriPID())){
			if(foodstorageBaseService.deleteAllByPripidAndYear(midBaseInfoDto.getPriPID(),year)){
				return AjaxResult.success("删除成功！");
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
}