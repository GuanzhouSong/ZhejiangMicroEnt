/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.batch.service.IBatchService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.CodeUtils;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_ent_warn 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Controller
@RequestMapping("/syn/risk/csentwarn")
public class CsEntWarnController extends CSBaseController {
	
	@Autowired
	ICsEntWarnService csEntWarnService;
	@Autowired
	IPanoramaSearchService panoramaSearchService;
	@Autowired
	IBatchService batchService;
	@Autowired
	ICsWarnMarkService csWarnMarkService;
	
    /**
     * 进入企业预警申请页面
     * @author zjj
     * 20161020
     */
	@RequestMapping(value="/applylist",method= RequestMethod.GET)
	public ModelAndView applyList(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarnapply_list");
		CsEntWarnDto csEntWarn = new CsEntWarnDto();
		csEntWarn.setDeptCode(getCodeByUserType(sysUser));
		view.addObject("csEntWarn",csEntWarn);
		return view;
	} 
	
	/**
	 * 获取企业申请数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<CsEntWarnDto> ListJson(PageRequest request,HttpSession session) throws Exception{
		List<CsEntWarnDto> data = csEntWarnService.queryPage(request);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> qryMap = new HashMap<String,Object>();
		if(!"1".equals(request.getParams().get("needHis"))){
		  for(CsEntWarnDto csEntWarn:data){
			 qryMap.put("priPID", csEntWarn.getPriPID());
	         qryMap.put("entWarnState", "1");
	         qryMap.put("checkState", "1");
	         qryMap.put("deptCode",getCodeByUserType(sysUser));
			 List<CsEntWarnDto> csEntWarnList = csEntWarnService.selectCsEntWarnInfo(qryMap);
			 if(csEntWarnList.size()>0) csEntWarn.setIsWarnHis("1");
		 }
		}
		return new PageResponse<CsEntWarnDto>(data);
	}
	
	/**
	 * 进入企业预警新增
	 * @author zjj
	 * 20161020
	 */
	@RequestMapping(value="/enadd",method= RequestMethod.GET)
	public ModelAndView enAdd() throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarnapply_add");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
    /**
     * 进入新增企业标识页面
     * @author zjj
     * 20161023
     */
	@RequestMapping("/enaddmark")
	public ModelAndView enaddmark(String arr,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarnapply_addmark");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		CsEntWarnDto csEntWarn = new CsEntWarnDto();
		
		csEntWarn.setMarkNo(CodeUtils.createCode("yj"));
		csEntWarn.setBatchNo(batchService.getBatchNo(Constants.BATCH_NO_FXYJ));
		csEntWarn.setEntStr(arr);
		csEntWarn.setImportSetId(sysUser.getId());
		csEntWarn.setImportPeople(sysUser.getRealName());
		csEntWarn.setMarkSetDept(sysUser.getDept());
		csEntWarn.setMarkSetDeptCode(getCodeByUserType(sysUser));
		csEntWarn.setDeptCode(getCodeByUserType(sysUser));
		csEntWarn.setMarkSetDate(new Date());
		view.addObject("csEntWarn",csEntWarn);
		
		return view;
	}
	/**
	 * 添加企业标识
	 * @author zjj
	 * 20161024
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@RequestBody CsEntWarnDto csEntWarn) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markFunc","yj");
		map.put("markName",csEntWarn.getMarkName());
		List<CsWarnMark> dataList = csWarnMarkService.selectCsWarnMarkList(map);
		
		if(dataList != null && dataList.size()>0)
			return AjaxResult.error("预警标识名称已存在，请修改！");
		
		if(csEntWarnService.insert(csEntWarn)>0)
			return AjaxResult.success("添加成功!");
		return AjaxResult.error("添加失败!");
	
	}
	
	/**
	 * 进入企业申请修改
	 * @author zjj
	 * 20161025
	 */
	@RequestMapping("/enedit")
	public ModelAndView enedit(String batchNo) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarnapply_edit");
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("batchNo", batchNo);
		List<CsEntWarnDto> csEntWarnList = csEntWarnService.selectCsEntWarnApplyInfo(qryMap);
		qryMap.put("markNo", csEntWarnList.get(0).getMarkNo());
		qryMap.put("markFunc", "yj");
		List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
		view.addObject("csEntWarn",csEntWarnList.get(0));
		view.addObject("csWarnMark",csWarnMarkList.get(0));
		return view;
	}
	/**
	 * 删除预警申请企业
	 * @author zjj
	 * 20161026
	 */
	@RequestMapping(value="/delapplyent")
	@ResponseBody
	public AjaxResult delApplyEnt(String arr) throws Exception{
		    if(StringUtils.isNotBlank(arr)){
		    	String[] priArr =  arr.split(",");
		    	for(int i=0;i<priArr.length;i++){
		    		csEntWarnService.delete(priArr[i]);
		    	}
		    	return AjaxResult.success("删除成功!");
		    }
		    return AjaxResult.error("删除失败!");
	
	}
	/**
	 * 进入添加预警申请企业
	 * @author zjj
	 */
	@RequestMapping(value="/enaddent",method=RequestMethod.GET)
	public ModelAndView enAddEnt(String batchNo,String markNo,String checkState) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarnapply_addent");
		view.addObject("batchNo",batchNo);
		view.addObject("markNo",markNo);
		view.addObject("checkState",checkState);
		return view;
	
	}
	/**
	 * 添加预警申请企业
	 * @author zjj
	 * 20161026
	 */
	@RequestMapping(value="/addent",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addEnt(String batchNo,String priPIDStr,HttpSession session,String markNo,String checkState) throws Exception{
		    
		if(StringUtils.isNotBlank(batchNo)&&StringUtils.isNotBlank(priPIDStr)&&StringUtils.isNotBlank(markNo)&&StringUtils.isNotBlank(checkState)){
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		    	String[] priArr =  priPIDStr.split(",");
		    	Map<String,Object> qryMap = new HashMap<String,Object>();
		    	CsEntWarnDto csEntWarn = new CsEntWarnDto();
		    	List<CsEntWarnDto> csEntWarnList = null;
		    	qryMap.put("batchNo", batchNo);
		    	
		    	csEntWarn.setBatchNo(batchNo);
		    	csEntWarn.setMarkNo(markNo);
		    	csEntWarn.setImportDate(new Date());
		    	csEntWarn.setCreateTime(new Date());
		    	csEntWarn.setImportPeople(sysUser.getRealName());
		    	csEntWarn.setImportSetId(sysUser.getId());
		    	csEntWarn.setDeptCode(getCodeByUserType(sysUser));
		    	csEntWarn.setEntWarnState("1");
		    	csEntWarn.setCheckState(checkState);
		    	for(int i=0;i<priArr.length;i++){
		    		qryMap.put("priPID", priArr[i]);
		    		csEntWarnList = csEntWarnService.selectCsEntWarnApplyInfo(qryMap);
		    		if(csEntWarnList.size()>0) continue;
		    		csEntWarn.setPriPID(priArr[i]);
		    		csEntWarnService.insertEnt(csEntWarn);
		    	}
		    	return AjaxResult.success("添加成功!");
		    }
		    return AjaxResult.error("添加失败!");
	
	}
	/**
	 * 获取企业预警历史记录
     * @author zjj
     * 20161027
     */
	@RequestMapping("/getentwarnhis")
	public ModelAndView getEntWarnhis(String priPID,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarnapply_warnhis");
        Map<String,Object> qryMap = new HashMap<String,Object>();
        qryMap.put("priPID", priPID);
        qryMap.put("entWarnState", "1");
        qryMap.put("checkState", "1");
        qryMap.put("deptCode", getCodeByUserType(sysUser));
        List<CsEntWarnDto> csEntWarnList= csEntWarnService.selectCsEntWarnInfo(qryMap);
        view.addObject("csEntWarnList",csEntWarnList);
		
        return view;
	}
	/**
	 * 获取查询企业列表
	 * 
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/panosearchlist.json", "list.xml"})
    @ResponseBody
	public PageResponse<PanoramaResultDto> panoSearchList(PageRequest request) throws Exception{
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
        return new PageResponse<PanoramaResultDto>(data);
	}
	
	
	/**
	 * 进入企业预警审核页面
	 * @author zjj
	 */
	@RequestMapping(value="/enchecklist",method= RequestMethod.GET)
	public ModelAndView enCheckList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarncheck_list");
		CsEntWarnDto csEntWarn = new CsEntWarnDto();
		csEntWarn.setDeptCode(getCodeByUserType(sysUser));
		List<CsEntWarnDto> csEntWarnList = null;
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("deptCode", getCodeByUserType(sysUser));
		qryMap.put("checkState", "1");
		csEntWarnList = csEntWarnService.selectCsEntWarnInfo(qryMap);
		view.addObject("tgNum",csEntWarnList.size());
		qryMap.put("checkState", "0");
		csEntWarnList = csEntWarnService.selectCsEntWarnInfo(qryMap);
		view.addObject("wtgNum",csEntWarnList.size());
		qryMap.put("checkState", "2");
		csEntWarnList = csEntWarnService.selectCsEntWarnInfo(qryMap);
		view.addObject("wshNum",csEntWarnList.size());
    	view.addObject("csEntWarn",csEntWarn);
		return view;
	}
	/**
	 * 获取企业预警审核数据
	 * @author zjj
	 * 20161025
	 * 
	 */
	@RequestMapping({ "/checklist.json", "checklist.xml" })
	@ResponseBody
	public PageResponse<CsEntWarnDto> checkListJson(PageRequest request) throws Exception{
		List<CsEntWarnDto> csEntWarnList = csEntWarnService.queryPageForCheck(request);
		return new PageResponse<CsEntWarnDto>(csEntWarnList);
	}
	
	/**
	 * 进入审核操作页面
	 * @author zjj
	 * 20161025
	 */
	@RequestMapping(value="/encheck",method= RequestMethod.GET)
	public ModelAndView enCheck(String urlFlag,String batchNo,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarncheck_edit");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("batchNo", batchNo);
		List<CsEntWarnDto> csEntWarnList = csEntWarnService.selectCsEntWarnApplyInfo(qryMap);
		CsEntWarnDto  csEntWarn = csEntWarnList.get(0);
		csEntWarn.setUrlFlag(urlFlag);
		
		if(csEntWarn.getMarkStartDate().getTime() <= new Date().getTime()&&csEntWarn.getMarkEndDate().getTime() >= new Date().getTime() && "1".equals(csEntWarn.getMarkState()))
			csEntWarn.setMarkState("1");
		else 
			csEntWarn.setMarkState("0");
		if(StringUtils.isBlank(csEntWarn.getCheckPeople())){
			csEntWarn.setCheckPeople(sysUser.getRealName());
			csEntWarn.setCheckDate(new Date());
		}
		
		view.addObject("csEntWarn",csEntWarn);
		return view;
	}
	/**
	 * 保存审核意见
	 * @author zjj
	 * 20161025
	 * 
	 */
	@RequestMapping(value="/savecheck",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveCheck(@RequestBody CsEntWarnDto csEntWarn) throws Exception{
		if(csEntWarn == null || StringUtils.isBlank(csEntWarn.getBatchNo())) 
			return AjaxResult.error("保存失败!");
		
		csEntWarn.setCheckDate(new Date());
		if("0".equals(csEntWarn.getCheckState()))
			csEntWarn.setEntWarnState("0");
		csEntWarnService.update(csEntWarn);
		if("1".equals(csEntWarn.getCheckState())){//更新索引
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("batchNO", csEntWarn.getBatchNo());
			List<CsEntWarnDto> dataList = csEntWarnService.selectCsEntWarnApplyInfo(qryMap);
			for (CsEntWarnDto dto : dataList) {
				panoramaSearchService.updatePanoramaIdx(
						csEntWarnService.doGetEntWarnInfoForIndex(dto.getPriPID()));
			}
		}
		return AjaxResult.success("保存成功!");
		
				     
	}
	/**
	 * 企业预警状态失效
	 * @author zjj
	 * 20161027
	 */
	@RequestMapping(value="/disable",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult disable(String uid,String priPID)throws Exception{
		if(StringUtils.isNotBlank(uid)){
			CsEntWarnDto csEntWarn = new CsEntWarnDto();
			csEntWarn.setEntWarnState("0");
			csEntWarn.setUID(uid);
			csEntWarnService.updateByUID(csEntWarn);
			//更新索引接口
			panoramaSearchService.updatePanoramaIdx(
					csEntWarnService.doGetEntWarnInfoForIndex(priPID));
		}
		return AjaxResult.success("操作成功!");
	}
	/**
	 * 进入企业预警查看页面
	 * 
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doenviewlist")
	public ModelAndView doEnViewList(HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/risk/entwarninfo/entwarnview_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("MarkSetDeptCode", getCodeByUserType(sysUser));
		return mav;
	}
	/**
	 * 获取企业预警查看页面数据
	 * @author zjj
	 */
	@RequestMapping({ "/viewlist.json", "viewlist.xml" })
	@ResponseBody
	public PageResponse<CsEntWarnDto> viewList(PageRequest request) throws Exception{
		List<CsEntWarnDto> csEntWarnList = csEntWarnService.queryPageForView(request);
		return new PageResponse<CsEntWarnDto>(csEntWarnList);
	}
	
	/**
	 * 查看企业预警申请/审核信息
	 * @author zjj
	 */
	@RequestMapping(value="/lookinfo",method= RequestMethod.GET)
	public ModelAndView lookInfo(String urlFlag,String batchNo) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/entwarninfo/entwarninfo_list");
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("batchNo", batchNo);
		List<CsEntWarnDto> csEntWarnList = csEntWarnService.selectCsEntWarnApplyInfo(qryMap);
		CsEntWarnDto  csEntWarn = csEntWarnList.get(0);
		csEntWarn.setUrlFlag(urlFlag);
		
		if(csEntWarn.getMarkStartDate().getTime() <= new Date().getTime()&&csEntWarn.getMarkEndDate().getTime() >= new Date().getTime() && "1".equals(csEntWarn.getMarkState()))
			csEntWarn.setMarkState("1");
		else
			csEntWarn.setMarkState("0");
		view.addObject("csEntWarn",csEntWarn);
		return view;
	}
	
}