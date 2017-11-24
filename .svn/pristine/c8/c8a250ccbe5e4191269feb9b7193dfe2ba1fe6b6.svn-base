/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.dto.FoodstorageBackDto;
import com.icinfo.cs.yr.dto.FoodstorageBaseDto;
import com.icinfo.cs.yr.service.IFoodstorageBackService;
import com.icinfo.cs.yr.service.IFoodstorageBaseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_foodstorage_back 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller
@RequestMapping("/reg/server/yr/foodstorageback")
public class FoodstorageBackController extends BaseController {
	@Autowired
	private ICodeRegorgService codeRegorgService;
	
	@Autowired
	private ICodeRegunitService codeRegunitService;
	
	@Autowired
	private IFoodstorageBackService foodstorageBackService;
	
	@Autowired
	private IFoodstorageBaseService foodstorageBaseService;
	
	@Autowired
	private ISysLogService sysLogService;
	
	/**
	 * 
	 * 描述: 进入食品仓储退回记录列表页面
	 * @auther chenxin
	 * @date 2016-09-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView enterBackPage() throws Exception{
		List<CodeRegunit> codeRegUnitList = codeRegunitService.selectCodeRegunitAll();
		List<CodeRegorg> codeRegorgList = codeRegorgService.selectCodeRegorgList();
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstorageback/foodstorageback_list");
		view.addObject("codeRegUnitList",codeRegUnitList);
		view.addObject("codeRegorgList",codeRegorgList);
		return view;
	}
	
	/**
	 * 描述：查询食品仓储退回记录列表
	 * @author chenxin
	 * @date 2016-09-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<FoodstorageBackDto> listJSON(PageRequest request) throws Exception {
		List<FoodstorageBackDto> data = foodstorageBackService.queryPage(request);
        return new PageResponse<FoodstorageBackDto>(data);
    }
	
	/**
	 * 
	 * 描述: 进入食品仓储退回列表页面
	 * @auther chenxin
	 * @date 2016-09-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/basebacklist",method= RequestMethod.GET)
	public ModelAndView enterBaseBackPage() throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstorageback/foodstoragebaseback_list");
		return view;
	}
	
	/**
	 * 描述：查询食品仓储退回列表
	 * @author chenxin
	 * @date 2016-09-27
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/basebacklist.json",method= RequestMethod.GET)
	@ResponseBody
	public PageResponse<FoodstorageBaseDto> basebacklistJSON(PageRequest request) throws Exception {
		List<FoodstorageBaseDto> data = foodstorageBaseService.queryBaseBackPage(request);
		return new PageResponse<FoodstorageBaseDto>(data);
	}
	
	/**
	 * 
	 * 描述: 进入食品仓储退回保存页面
	 * @auther chenxin
	 * @date 2016-09-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show",method = RequestMethod.GET)
	public ModelAndView enterBaseBackSavePage(@RequestParam(required = false) Integer foodStorageBaseId) throws Exception{
		if(foodStorageBaseId <= 0){
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", foodStorageBaseId);
		FoodstorageBaseDto foodstorageBaseDto =  foodstorageBaseService.selecFoodstorageBaseDtoById(map);
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstorageback/foodstoragebaseback_edit");
		view.addObject("foodstorageBaseDto",foodstorageBaseDto);
		return view;
	}
	
	/**
	 * 描述：添加食品仓储退回
	 * 
	 * @author chenxin
	 * @date 2016-09-14
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommitBaseback(FoodstorageBackDto foodStorageBackDto,HttpSession session) throws Exception {
		if(foodStorageBackDto != null){
			 Map<String, String> logMap = new HashMap<String, String>();
			 List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
			 SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
			 foodStorageBackDto.setBackName(sysUser.getRealName());
			 if (foodstorageBackService.applyFoodStorageBackAddLog(foodStorageBackDto, logCollector)) {
				 logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID, foodStorageBackDto.getPriPID());
				 logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME, foodStorageBackDto.getEntName());
				 logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,foodStorageBackDto.getYear().toString());
				 logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SERVER);
				 logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.FoodstorageBackLog.getCode());
				 logMap.put(ISysLogService.LOG_MAP_KEY_LOGEENTYPE,foodStorageBackDto.getEntTypeCatg());
				 logMap.put(ISysLogService.LOG_MAP_KEY_REGNO,foodStorageBackDto.getRegNO());
				 SysLogJson logJson = new SysLogJson(logCollector);
				 JSONObject jsonObject = JSONObject.fromObject(logJson);
				 logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
				 sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
				 return AjaxResult.success("保存成功");
			 }
		}
		return AjaxResult.error("保存失败");
	}
}