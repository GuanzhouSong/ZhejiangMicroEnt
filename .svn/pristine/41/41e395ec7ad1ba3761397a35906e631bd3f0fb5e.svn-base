/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.ArrayList;
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

import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.dto.FoodstorageInfoDto;
import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.cs.yr.model.FoodstorageInfo;
import com.icinfo.cs.yr.service.IFoodstorageAuxService;
import com.icinfo.cs.yr.service.IFoodstorageInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_foodstorage_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller("FoodstorageInfoClientController")
@RequestMapping("/reg/client/yr/ent/foodstorageinfo")
public class FoodstorageInfoController extends BaseController {
	
	@Autowired
	private IFoodstorageInfoService foodstorageInfoService;

	@Autowired
	private IFoodstorageAuxService foodstorageAuxService;
	
	@Autowired
	private ISysLogService sysLogService;
	
	/**
	 * 描述：查询仓库列表
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<FoodstorageInfoDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if(request.getParams() ==null){
		  request.setParams(new HashMap<String, Object>());
		  request.getParams().put("year", Integer.parseInt(DateUtil.getYear()));
		  request.getParams().put("priPID",midBaseInfoDto.getPriPID());
		}
		List<FoodstorageInfoDto> data = foodstorageInfoService.queryPageForClient(request);
        return new PageResponse<FoodstorageInfoDto>(data);
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
	public AjaxResult doSearchFoodstorageLicense(String fsInfoId,HttpSession session) throws Exception {
		if(StringUtils.isNotEmpty(fsInfoId)){
			MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			FoodstorageInfoDto foodstorageInfoDto = foodstorageInfoService.searchFoodstorageInfoByFsInfoIdAndPriPID(fsInfoId, midBaseInfoDto.getPriPID());
			List<FoodstorageAux> foodstorageAuxList = foodstorageAuxService.searchFoodstorageAuxByFsInfoIdAndPriPID(fsInfoId, midBaseInfoDto.getPriPID());
			foodstorageInfoDto.setFoodstorageAuxList(foodstorageAuxList);
			return AjaxResult.success("foodstorageInfoDto", foodstorageInfoDto);
		}
		return AjaxResult.success("foodstorageInfoDto", new FoodstorageInfoDto());
	}
	
	/**
	 * 描述：添加仓库
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSave(@RequestBody FoodstorageInfoDto foodstorageInfoDto,HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		Map<String, String> logMap = new HashMap<String, String>();
		List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
		foodstorageInfoDto.setPriPID(midBaseInfoDto.getPriPID());
		if(foodstorageInfoDto.getId() != null && foodstorageInfoDto.getId() > 0){
			if(!foodstorageInfoService.modFoodstorageInfoAndAuxAddLog(copyFoodstorageInfoFrom(foodstorageInfoDto), foodstorageInfoDto.getFoodstorageAuxList(), logCollector)){
				return AjaxResult.error("保存失败");
			}
		}else{
			if(!foodstorageInfoService.saveFoodstorageInfoAndAuxAddLog(copyFoodstorageInfoFrom(foodstorageInfoDto), foodstorageInfoDto.getFoodstorageAuxList(), logCollector)){
				return AjaxResult.error("保存失败");
			}
		}
		logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtils.getYear());
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.SaveFoodstorageInfoAndAuxLog.getCode());
		SysLogJson logJson = new SysLogJson(logCollector);
		JSONObject jsonObject = JSONObject.fromObject(logJson);
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
		sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
		return AjaxResult.success("保存成功");
	}
	
	/**
	 * 描述：添加仓库
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @param foodstorageInfoDto
	 * @return
	 */
	private FoodstorageInfo copyFoodstorageInfoFrom(FoodstorageInfoDto foodstorageInfoDto){
		FoodstorageInfo foodstorageInfo = new FoodstorageInfo();
		if(foodstorageInfoDto != null){
			if(foodstorageInfoDto.getId() != null && foodstorageInfoDto.getId().intValue() > 0){
				foodstorageInfo.setId(foodstorageInfoDto.getId());
			}
			foodstorageInfo.setPriPID(foodstorageInfoDto.getPriPID());
			foodstorageInfo.setYear(Integer.parseInt(DateUtils.getYear()));
			foodstorageInfo.setFsinfoID(foodstorageInfoDto.getFsinfoID());
			foodstorageInfo.setEntName(foodstorageInfoDto.getEntName());
			foodstorageInfo.setRegNO(foodstorageInfoDto.getRegNO());
			foodstorageInfo.setLeRep(foodstorageInfoDto.getLeRep());
			foodstorageInfo.setLinkman(foodstorageInfoDto.getLinkman());
			foodstorageInfo.setLinktel(foodstorageInfoDto.getLinktel());
			foodstorageInfo.setTel(foodstorageInfoDto.getTel());
			foodstorageInfo.setWareAddr(foodstorageInfoDto.getWareAddr());
			foodstorageInfo.setAddr(foodstorageInfoDto.getAddr());
			foodstorageInfo.setEmpNum(foodstorageInfoDto.getEmpNum());
			foodstorageInfo.setOpSpace(foodstorageInfoDto.getOpSpace());
			foodstorageInfo.setSetTime(foodstorageInfoDto.getSetTime());
			foodstorageInfo.setCreateTime(foodstorageInfoDto.getCreateTime());
			foodstorageInfo.setSubmitState(foodstorageInfoDto.getSubmitState());
		}
		return foodstorageInfo;
	}
	
	/**
	 * 描述：删除仓库
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDeleteBatch(@RequestBody List<String> fsInfoIdList) throws Exception {
		Map<String, String> logMap = new HashMap<String, String>();
		List<SysLogTable> logCollector = new ArrayList<SysLogTable>();
		if(fsInfoIdList != null && fsInfoIdList.size() > 0){
			if(!foodstorageInfoService.rmBatchFoodstorageInfoAndAuxAddLog(fsInfoIdList, logCollector)){
				return AjaxResult.error("删除失败");
			}
			logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.RmoveFoodstorageInfoAndAuxLog.getCode());
			SysLogJson logJson = new SysLogJson(logCollector);
			JSONObject jsonObject = JSONObject.fromObject(logJson);
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, jsonObject.toString());
			sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.error("请选中删除信息");
	}
	
	
	
}