/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.FoodstorageLicense;
import com.icinfo.cs.yr.service.IFoodstorageLicenseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_foodstorage_license 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller("FoodstorageLicenseClientController")
@RequestMapping("/reg/client/yr/ent/foodstoragelicense")
public class FoodstorageLicenseController extends BaseController {
	@Autowired
	private IFoodstorageLicenseService foodstorageLicenseService;
	@Autowired
	private ISysLogService sysLogService;
	
	/**
	 * 
	 * 描述: 进入许可证列表页面
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(String priPID,String licType) throws Exception{
		ModelAndView view = new ModelAndView("/reg/client/yr/auxtab/foodstorage_list");
		return view;
	}
	
	/**
	 * 描述：查询许可证列表
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<FoodstorageLicense> listJSON(PageRequest request,HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if(StringUtils.isNotEmpty(midBaseInfoDto.getPriPID())){
			Map<String,Object> params = request.getParams();
			if(params != null){
				params.put("priPID", midBaseInfoDto.getPriPID());
				params.put("year", DateUtil.getYear());	
			}
			List<FoodstorageLicense> data = foodstorageLicenseService.queryPage(request);
			return new PageResponse<FoodstorageLicense>(data);
		}
		return new PageResponse<FoodstorageLicense>(new ArrayList<FoodstorageLicense>());	
    }
	
	/**
	 * 描述：查询许可证信息
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doSearchFoodstorageLicense(Integer id,HttpSession session) throws Exception {
		if(id != null && id > 0){
			MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			FoodstorageLicense foodstorageLicense = foodstorageLicenseService.searchFoodstorageLicenseByFsInfoIdAndPriPID(id, midBaseInfoDto.getPriPID());
			return AjaxResult.success("foodstorageLicense", foodstorageLicense);
		}
		return AjaxResult.success("foodstorageLicense", new FoodstorageLicense());
	}
	
	/**
	 * 描述：添加许可证
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSave(FoodstorageLicense foodstorageLicense,HttpSession session) throws Exception {
		Map<String, String> logMap = new HashMap<String, String>();
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
		if(foodstorageLicense == null){
			return AjaxResult.error("保存失败");
		}
		if(foodstorageLicense.getId() != null && foodstorageLicense.getId() > 0){
			if(!foodstorageLicenseService.modFoodstorageLicenseAddLog(foodstorageLicense, logCollector)){
				return AjaxResult.error("保存失败");
			}
		}else{
			foodstorageLicense.setYear(Integer.parseInt(DateUtil.getYear()));
			foodstorageLicense.setPriPID(midBaseInfoDto.getPriPID());
			foodstorageLicense.setCreateTime(new Date());
			if(!foodstorageLicenseService.saveFoodstorageLicenseAddLog(foodstorageLicense, logCollector)){
				return AjaxResult.error("保存失败");
			}
		}
		logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.SaveFoodstorageLicenLog.getCode());
		SysLogJson logJson = new SysLogJson(logCollector);
		JSONObject jsonObject = JSONObject.fromObject(logJson);
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
		sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
		return AjaxResult.success("保存成功");
	}
	
	/**
	 * 描述：删除许可证
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDelete(Integer foodstorageLicenseId,String year) throws Exception {
		Map<String, String> logMap = new HashMap<String, String>();
		List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
		if(foodstorageLicenseId == null || foodstorageLicenseId <=0){
			return AjaxResult.error("请选中删除需要删除的记录");
		}
		if(StringUtils.isEmpty(year)){
			return AjaxResult.error("删除失败");
		}
		if(foodstorageLicenseService.rmFoodstorageLicenseAddLog(foodstorageLicenseId, logCollector)){
			logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,year);
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.DelFoodstorageLicenLog.getCode());
			SysLogJson logJson = new SysLogJson(logCollector);
			JSONObject jsonObject = JSONObject.fromObject(logJson);
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
			sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.error("删除失败");
	}
	
	/**
	 * 描述：删除许可证
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDeleteBatch(@RequestBody List<Integer> foodstorageLicenseIdList) throws Exception {
		Map<String, String> logMap = new HashMap<String, String>();
		List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
		if(foodstorageLicenseIdList == null || foodstorageLicenseIdList.size() <= 0){
			return AjaxResult.error("请选中删除需要删除的记录");
		}
		if(foodstorageLicenseService.rmBatchFoodstorageLicenseAddLog(foodstorageLicenseIdList, logCollector)){
			logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.DelBatchFoodstorageLicenLog.getCode());
			SysLogJson logJson = new SysLogJson(logCollector);
			JSONObject jsonObject = JSONObject.fromObject(logJson);
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
			sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.error("删除失败");
	}
	
}