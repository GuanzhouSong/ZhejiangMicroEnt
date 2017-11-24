/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.supervise.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.batch.service.IBatchService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.model.CsSuperviseObj;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_supervise_obj 对应的Controller类.<br>
 *
 * @author zhuyong
 * @date 2016年10月26日
 */
@Controller
@RequestMapping("/syn/supervise")
public class CsSuperviseObjController extends CSBaseController {
	
	@Autowired
	ICsSuperviseObjService iCsSuperviseObjService;
	@Autowired
	IBatchService iBatchService;
	@Autowired
	ICsWarnMarkService iCsWarnMarkService;
	@Autowired
	IPanoramaSearchService panoramaSearchService;
	
	/**
	 * 进入监管申请页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupApplyList")
	public ModelAndView doEnSupApplyList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_apply_list");
		mav.addObject("userCode",getCodeByUserType(sysUser));
		return mav;
	}
	
	/**
	 * 进入监管审核页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupCheckList")
	public ModelAndView doEnSupCheckList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_check_list");
		mav.addObject("userCode",getCodeByUserType(sysUser));
		return mav;
	}
	
	/**
	 * 进入新增监管申请页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupApplyAdd")
	public ModelAndView doEnSupApplyAdd() throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_apply_add");
		mav.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mav;
	}
	
	/**
	 * 进入审核页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnCheckConfirm")
	public ModelAndView doEnCheckConfirm(String batchNO,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_check_confirm");
		if(StringUtils.isBlank(batchNO)) return mav;
		
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("batchNO", batchNO);
		List<CsSuperviseObjDto> dataList = iCsSuperviseObjService.queryListNoPage(map);
		if(dataList==null || dataList.size() == 0) return mav;
		CsSuperviseObjDto dto = dataList.get(0);
		dto.setCheckPer(sysUser.getRealName());
		dto.setCheckPerID(sysUser.getId());
		dto.setCheckDate(new Date());
		mav.addObject("dto",dto);
		mav.addObject("batchNO",batchNO);
		//本次增设家数
		mav.addObject("bcNum",dataList.size());
		//该标识使用的家数
		map.clear();
		map.put("markCode", dto.getMarkCode());
		dataList = iCsSuperviseObjService.queryListNoPage(map);
		mav.addObject("syNum",dataList == null ? "0" :dataList.size());
		//本部门累计设置家数
		map.clear();
		map.put("inputDepCode", sysUser.getDeptCode());
		dataList = iCsSuperviseObjService.queryListNoPage(map);
		mav.addObject("ljNum",dataList == null ? "0" :dataList.size());
		
		return mav;
	}
	
	
	/**
	 * 进入审核查看页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnCheckView")
	public ModelAndView doEnCheckView(String batchNO,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_check_view");
		if(StringUtils.isBlank(batchNO)) return mav;
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("batchNO", batchNO);
		List<CsSuperviseObjDto> dataList = iCsSuperviseObjService.queryListNoPage(map);
		if(dataList==null || dataList.size() == 0) return mav;
		mav.addObject("dto",dataList.get(0));
		mav.addObject("batchNO",batchNO);
		return mav;
	}
	
	
	
	/**
	 * 进入标识列表页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupApplyMarkList")
	public ModelAndView doEnSupApplyMarkList(String priPIDStr,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_apply_mark_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markSetDeptCode", getCodeByUserType(sysUser));//可用标识
		map.put("markState", "1");//有效标识
		map.put("markFunc", "jg");//监管标识
		
		mav.addObject("priPIDStr", priPIDStr);
		mav.addObject("batchNO", iBatchService.getBatchNo(Constants.BATCH_NO_ZDJG));
		mav.addObject("markList", iCsWarnMarkService.selectCsWarnMarkList(map));
		return mav;
	}
	
	/**
	 * 保存标识列表页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSaveSupApplyMark")
	@ResponseBody
	public AjaxResult doSaveSupApplyMark(@RequestBody CsSuperviseObjDto dto,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtils.isBlank(dto.getPriPIDStr()))
			return AjaxResult.error("保存失败!");
		String[] priPidArr = dto.getPriPIDStr().split(";");
		for (String priPID : priPidArr) {
			dto.setPriPID(priPID);
			dto.setSupState("1");//有效
			dto.setSupCheckState("2");//未审核
			dto.setInputPer(sysUser.getRealName());
			dto.setInputPerID(sysUser.getId());
			dto.setInputDate(new Date());
			dto.setInputDepCode(getCodeByUserType(sysUser));
			iCsSuperviseObjService.insert(dto);
		}
		return AjaxResult.success("添加成功");
	}
	
	
	
	/**
	 * 标识列表
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doQueryListPage")
	@ResponseBody
	public PageResponse<CsSuperviseObjDto> doQueryListPage(PageRequest request) throws Exception{
		List<CsSuperviseObjDto> dataList = iCsSuperviseObjService.queryListPage(request);
		return new PageResponse<CsSuperviseObjDto> (dataList);
	}
	
	/**
	 * 批次列表
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doQueryByBatchNOListPage")
	@ResponseBody
	public PageResponse<CsSuperviseObjDto> doQueryByBatchNOListPage(PageRequest request) throws Exception{
		List<CsSuperviseObjDto> dataList = iCsSuperviseObjService.queryByBatchNOList(request);
		return new PageResponse<CsSuperviseObjDto> (dataList);
	}
	
	/**
	 * 保存审核结果
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSaveSupCheck")
	@ResponseBody
	public AjaxResult doSaveSupCheck(@RequestBody CsSuperviseObj obj) throws Exception{
		if(obj == null || StringUtils.isBlank(obj.getBatchNO()))  
			return AjaxResult.error("保存失败");
		obj.setCheckDate(new Date());
		if("0".equals(obj.getSupCheckState())) obj.setSupState("0");//审核不通过监管状态失效
		iCsSuperviseObjService.updateByField(obj, "batchNo");
		
		if("1".equals(obj.getSupCheckState())){//更新索引
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("batchNO", obj.getBatchNO());
			List<CsSuperviseObjDto> dataList = iCsSuperviseObjService.queryListNoPage(qryMap);
			for (CsSuperviseObjDto dto : dataList) {
				panoramaSearchService.updatePanoramaIdx(
						iCsSuperviseObjService.doGetSuperviewInfoForIndex(dto.getPriPID()));
			}
		}
		return AjaxResult.success("保存成功");
	}
	
	
	/**
	 * 进入批次修改页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupBatchMod")
	public ModelAndView doEnSupBatchMod(String batchNO,String supState,String markCode,
			String supCheckState,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_apply_batch_mod");
		mav.addObject("batchNO", batchNO);
		mav.addObject("supState", supState);
		mav.addObject("markCode", markCode);
		mav.addObject("supCheckState", supCheckState);
		if(StringUtils.isBlank(batchNO)) return mav;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("batchNO", batchNO);
		mav.addObject("dto",iCsSuperviseObjService.queryListNoPage(map).get(0)); 
		
		//获取mark列表
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		map.clear();
		map.put("markSetDeptCode", sysUser.getDeptCode());
		map.put("markFunc", "jg");//监管标识
		map.put("markState", "1");//有效标识
		mav.addObject("markList", iCsWarnMarkService.selectCsWarnMarkList(map));
		
		return mav;
	}
	
	
	/**
	 * 进入批次修改页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupBatchView")
	public ModelAndView doEnSupBatchView(String batchNO,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_apply_batch_view");
		mav.addObject("batchNO", batchNO);
		if(StringUtils.isBlank(batchNO)) return mav;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("batchNO", batchNO);
		mav.addObject("dto",iCsSuperviseObjService.queryListNoPage(map).get(0)); 
		
		//获取mark列表
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		map.clear();
		map.put("markSetDeptCode", getCodeByUserType(sysUser));
		map.put("markFunc", "jg");//监管标识
		mav.addObject("markList", iCsWarnMarkService.selectCsWarnMarkList(map));
		
		return mav;
	}
	
	
	/**
	 * 进入批次修改页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupAppBatchModAdd")
	public ModelAndView doEnSupAppBatchModAdd(String batchNO,String supState,String markCode,
			String supCheckState) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_apply_batch_mod_add");
		mav.addObject("batchNO", batchNO);
		mav.addObject("supState", supState);
		mav.addObject("markCode", markCode);
		mav.addObject("supCheckState", supCheckState);
		return mav;
	}
	
	
	/**
	 * 批量删除
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doBatchDel")
	@ResponseBody
	public AjaxResult doBatchDel(String batchNO,String priPIDStr) throws Exception{
		if(StringUtils.isBlank(batchNO) ||StringUtils.isBlank(priPIDStr)){
			return AjaxResult.success("删除成功");
		}
		String[] priPIDArr = priPIDStr.split(";");
		for (String priPID : priPIDArr) {
			iCsSuperviseObjService.doDelByAndPriPID(batchNO, priPID);
		}
		return AjaxResult.success("删除成功");
	}
	
	/**
	 * 
	 * 批次修改时候新增企业
	 * 
	 * @author zhuyong
	 * @param batchNO
	 * @param priPIDStr
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doBatchModAdd")
	@ResponseBody
	public AjaxResult doBatchModAdd(String batchNO,String supState,
			String markCode,String supCheckState,String priPIDStr,
			HttpSession session) throws Exception{
		
		if(StringUtils.isBlank(batchNO) || StringUtils.isBlank(supState) || StringUtils.isBlank(markCode) 
				|| StringUtils.isBlank(supCheckState) || StringUtils.isBlank(priPIDStr))
			return AjaxResult.success("添加成功");
		
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String[] pirPIDs = priPIDStr.split(";");
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("batchNO", batchNO);
		List<CsSuperviseObjDto> dtoList = null;
		CsSuperviseObjDto obj = null;
		
		for (String priPID : pirPIDs) {
			qryMap.put("priPID",priPID);
			dtoList = iCsSuperviseObjService.queryListNoPage(qryMap);
			if(dtoList!=null && dtoList.size() > 0) continue;
			
			obj = new CsSuperviseObjDto();
			obj.setPriPID(priPID);
			obj.setBatchNO(batchNO);
			obj.setMarkCode(markCode);
			obj.setSupState(supState);
			obj.setSupCheckState(supCheckState);
			obj.setInputPer(sysUser.getRealName());
			obj.setInputPerID(sysUser.getId());
			obj.setInputDepCode(getCodeByUserType(sysUser));
			obj.setInputDate(new Date());
			
			iCsSuperviseObjService.insert(obj);
		}
		
		return AjaxResult.success("添加成功");
	}
	
	/**
	 * 失效
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSaveAppBatchMod")
	@ResponseBody
	public AjaxResult doSaveAppBatchMod(@RequestBody CsSuperviseObj obj) throws Exception{
		iCsSuperviseObjService.updateByField(obj,"batchNO");
		return AjaxResult.success("修改成功");
	}
	
	/**
	 * 批量删除
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doDisable/{uid}/{priPID}")
	@ResponseBody
	public AjaxResult doDisable(@PathVariable("uid")String uid,@PathVariable("priPID")String priPID) throws Exception{
		CsSuperviseObj obj = new CsSuperviseObj();
		obj.setUID(uid);
		obj.setSupState("0");//失效
		iCsSuperviseObjService.updateByField(obj,"uid");
		//更新索引接口
		panoramaSearchService.updatePanoramaIdx(
				iCsSuperviseObjService.doGetSuperviewInfoForIndex(priPID));
		return AjaxResult.success("修改成功");
	}
	
	
	/**
	 * 进入企业重点监管查看页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupViewList")
	public ModelAndView doEnSupViewList(HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/supervise/sup/sup_view_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("markSetDeptCode", sysUser.getDeptCode());
		return mav;
	}
	
	

	/**
	 * 标识列表
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doQueryForViewList")
	@ResponseBody
	public PageResponse<CsSuperviseObjDto> doQueryForViewList(PageRequest request) throws Exception{
		List<CsSuperviseObjDto> dataList = iCsSuperviseObjService.queryForViewList(request);
		return new PageResponse<CsSuperviseObjDto> (dataList);
	}
	

	/**
	 * 进入标识打印页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnMarkPrint")
	public String doEnMarkPrint() throws Exception{
		return "syn/system/supervise/mark/mark_print";
	}
	
	
	
}


