/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.concern.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.batch.service.IBatchService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.model.CsConcernObj;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_concern_obj 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
@Controller
@RequestMapping("/syn/con/csconcernobj")
public class CsConcernObjController extends CSBaseController {
	
	@Autowired
	ICsConcernObjService csConcernObjService;
	@Autowired
	IPanoramaSearchService panoramaSearchService;
	@Autowired
	IBatchService batchService;
	@Autowired
	ICsWarnMarkService csWarnMarkService; 
    /**
     * 进入企业关注服务申请页面
     * @author zjj
     * 20161020
     */
	@RequestMapping(value="/applylist",method= RequestMethod.GET)
	public ModelAndView applyList(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/concern/conc/con_apply_list");
		CsConcernObjDto csConcernObj = new CsConcernObjDto();
		csConcernObj.setDeptCode(getCodeByUserType(sysUser));
		view.addObject("csConcernObj",csConcernObj);
		return view;
	} 
	
	
	/**
	 * 获取企业申请数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/applylist.json", "list.xml" })
	@ResponseBody
	public PageResponse<CsConcernObjDto> ListJson(PageRequest request, HttpSession session) throws Exception {
		List<CsConcernObjDto> data = csConcernObjService.queryPage(request);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> qryMap = new HashMap<String, Object>();
		if(!"1".equals(request.getParams().get("needHis"))){
		 for (CsConcernObjDto csConcernObj : data) {
			 qryMap.put("priPID", csConcernObj.getPriPID());
			 qryMap.put("conState", "1");
			 qryMap.put("checkState", "1");
			 qryMap.put("deptCode", getCodeByUserType(sysUser));
			 List<CsConcernObjDto> csEntWarnList = csConcernObjService.selectCsConObjInfo(qryMap);
			 if (csEntWarnList.size() > 0)
				csConcernObj.setIsConHis("1");
		 }
		} 
		return new PageResponse<CsConcernObjDto>(data);
	}
	
	/**
	 * 获取查询企业列表
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/panosearchlist.json", "list.xml"})
    @ResponseBody
	public PageResponse<PanoramaResultDto> panoSearchList(PageRequest request) throws Exception {
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}
	
	/**
	 * 进入企业关注服务新增页面
	 * @author zjj
	 */
	@RequestMapping(value="/enadd",method= RequestMethod.GET)
	public ModelAndView enAdd() throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/concern/conc/con_apply_add");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
	 * 进入标识列表页面
	 * 
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doenconapplyaddmark")
	public ModelAndView doEnConApplyAddMark(String priPIDStr, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/concern/conc/con_apply_addmark");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("markSetDeptCode", getCodeByUserType(sysUser));
		map.put("markFunc", "gz");// 关注标识
		map.put("markState", "1");// 有效标识

		mav.addObject("priPIDStr", priPIDStr);
		mav.addObject("batchNO", batchService.getBatchNo(Constants.BATCH_NO_GZFW));
		mav.addObject("markList", csWarnMarkService.selectCsWarnMarkList(map));
		return mav;
	}
	
	/**
	 * 保存标识列表页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/dosaveconapplymark")
	@ResponseBody
	public AjaxResult doSaveConApplyMark(@RequestBody CsConcernObjDto csConcernObj,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtils.isBlank(csConcernObj.getPriPIDStr()))
			return AjaxResult.error("保存失败!");
		
		String[] priPidArr = csConcernObj.getPriPIDStr().split(",");
		for (String priPID : priPidArr) {
			csConcernObj.setPriPID(priPID);
			csConcernObj.setConState("1");//有效
			csConcernObj.setCheckState("2");//未审核
			csConcernObj.setImportPeople(sysUser.getRealName());
			csConcernObj.setImportSetId(sysUser.getId());
			csConcernObj.setImportDate(new Date());
			csConcernObj.setDeptCode(getCodeByUserType(sysUser));
			csConcernObj.setCreateTime(new Date());
			csConcernObjService.insert(csConcernObj);
		}
		return AjaxResult.success("添加成功");
	}
	
	/**
	 * 进入批次修改页面
	 * 
	 * @author zjj
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnConBatchMod")
	public ModelAndView doEnConBatchMod(String batchNO,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("/syn/system/concern/conc/con_apply_edit");
		mav.addObject("batchNO", batchNO);
		if(StringUtils.isBlank(batchNO)) return mav;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("batchNO", batchNO);
		mav.addObject("dto",csConcernObjService.selectCsConObjInfo(map).get(0)); 
		
		//获取mark列表
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		map.clear();
		map.put("markSetDeptCode", getCodeByUserType(sysUser));
		map.put("markFunc", "gz");//关注标识
		map.put("markState", "1");//有效标识
		mav.addObject("markList", csWarnMarkService.selectCsWarnMarkList(map));
		
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
		String[] priPIDArr = priPIDStr.split(",");
		for (String priPID : priPIDArr) {
			csConcernObjService.doDelByAndPriPID(batchNO, priPID);
		}
		return AjaxResult.success("删除成功");
	}
	
	/**
	 * 进入添加关注申请企业
	 * @author zjj
	 */
	@RequestMapping(value="/enaddent",method=RequestMethod.GET)
	public ModelAndView enAddEnt(String batchNO,String markNo,String checkState) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/concern/conc/con_apply_addent");
		view.addObject("batchNO",batchNO);
		view.addObject("markNo",markNo);
		view.addObject("checkState",checkState);
		return view;
	}
	/**
	 * 添加关注申请企业
	 * @author zjj
	 */
	@RequestMapping(value="/addent",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addEnt(String batchNO,String priPIDStr,HttpSession session,String markNo,String checkState) throws Exception{
		if(StringUtils.isNotBlank(batchNO)&&StringUtils.isNotBlank(priPIDStr)&&StringUtils.isNotBlank(markNo)&&StringUtils.isNotBlank(checkState)){
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		    	String[] priArr =  priPIDStr.split(",");
		    	Map<String,Object> qryMap = new HashMap<String,Object>();
		    	CsConcernObjDto csConcernObj = new CsConcernObjDto();
		    	qryMap.put("batchNO", batchNO);
		    	List<CsConcernObjDto> csConcernObjList =null;
		    	
		    	csConcernObj.setBatchNO(batchNO);
		    	csConcernObj.setMarkNo(markNo);
		    	csConcernObj.setImportDate(new Date());
		    	csConcernObj.setCreateTime(new Date());
		    	csConcernObj.setImportPeople(sysUser.getRealName());
		    	csConcernObj.setImportSetId(sysUser.getId());
		    	csConcernObj.setDeptCode(getCodeByUserType(sysUser));
		    	csConcernObj.setConState("1");
		    	csConcernObj.setCheckState(checkState);
		    	for(int i=0;i<priArr.length;i++){
		    		qryMap.put("priPID", priArr[i]);
		    		csConcernObjList = csConcernObjService.selectCsConObjInfo(qryMap);
		    		if(csConcernObjList.size()>0) continue;
		    		csConcernObj.setPriPID(priArr[i]);
		    		csConcernObjService.insert(csConcernObj);
		    	}
		    	return AjaxResult.success("添加成功!");
		    }
		    return AjaxResult.error("添加失败!");
	
	}	
	
	/**
	 * 批量删除
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSaveAppBatchMod")
	@ResponseBody
	public AjaxResult doSaveAppBatchMod(@RequestBody CsConcernObj obj) throws Exception{
		csConcernObjService.updateByField(obj,"batchNO");
		return AjaxResult.success("修改成功");
	}
	
	/**
	 * 失效
	 * 
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doDisable/{uid}/{priPID}")
	@ResponseBody
	public AjaxResult doDisable(@PathVariable("uid")String uid,@PathVariable("priPID")String priPID) throws Exception{
		CsConcernObj obj = new CsConcernObj();
		obj.setUID(uid);
		obj.setConState("0");//失效
		csConcernObjService.updateByField(obj,"uid");
		//更新索引接口
		panoramaSearchService.updatePanoramaIdx(
				csConcernObjService.doGetConcernInfoForIndex(priPID));
		return AjaxResult.success("操作成功");
	}
	
	/**
	 * 获取企业预警历史记录
     * @author zjj
     * 20161027
     */
	@RequestMapping("/getentwarnhis")
	public ModelAndView getEntWarnhis(String priPID,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/concern/conc/con_apply_his");
        Map<String,Object> qryMap = new HashMap<String,Object>();
        qryMap.put("priPID", priPID);
        qryMap.put("conState", "1");
        qryMap.put("checkState", "1");
        qryMap.put("deptCode", getCodeByUserType(sysUser));
        List<CsConcernObjDto> csConcernObjList= csConcernObjService.selectCsConObjInfo(qryMap);
        view.addObject("csConcernObjList",csConcernObjList);
        return view;
	}
	/**
	 * 进入企业关注服务审核列表页面
	 * @author caoxu
	 */
	@RequestMapping(value="/applyauditlist",method= RequestMethod.GET)
	public ModelAndView applyAuditList(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/concern/conc/con_apply_auditlist");
		CsConcernObjDto csConcernObj = new CsConcernObjDto();
		view.addObject("userCode", getCodeByUserType(sysUser));
		view.addObject("csConcernObj", csConcernObj);
		return view;
	}
	
	@RequestMapping({ "/applyauditlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<CsConcernObjDto> auditListJson(PageRequest request) throws Exception {
		List<CsConcernObjDto> data = csConcernObjService.queryAllUnauditPage(request);
		return new PageResponse<CsConcernObjDto>(data);
	}
	
	@RequestMapping(value = "/applyaudit")
	public ModelAndView applyaudit(String batchNO, HttpSession session, String urlFlag) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/concern/conc/con_apply_audit");
		if (StringUtils.isBlank(batchNO))
			return mav;

		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchNO", batchNO);
		List<CsConcernObjDto> dataList = csConcernObjService.selectCsConObjInfo(map);
		if (dataList == null || dataList.size() == 0)
			return mav;
		CsConcernObjDto dto = dataList.get(0);
		dto.setCheckPeople(sysUser.getRealName());
		dto.setCheckDate(new Date());
		dto.setUrlFlag(urlFlag);
		mav.addObject("dto", dto);
		mav.addObject("batchNO", batchNO);
		return mav;
	}
	
	@RequestMapping(value="/applyview")
	public ModelAndView applyview(String batchNO, String urlFlag) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/concern/conc/con_apply_audit");
		if (StringUtils.isBlank(batchNO))
			return mav;

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchNO", batchNO);
		List<CsConcernObjDto> dataList = csConcernObjService.selectCsConObjInfo(map);
		if (dataList == null || dataList.size() == 0)
			return mav;
		CsConcernObjDto dto = dataList.get(0);
		dto.setUrlFlag(urlFlag);
		mav.addObject("dto", dto);
		mav.addObject("batchNO", batchNO);
		return mav;
	}
	
	/**
	 * 保存审核结果
	 */
	@RequestMapping(value = "/doApplyAudit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doApplyAudit(@RequestBody CsConcernObjDto obj) throws Exception {
		if (obj == null || StringUtils.isBlank(obj.getBatchNO()))
			return AjaxResult.error("审核失败");
		obj.setCheckDate(new Date());
		if("0".equals(obj.getCheckState()))
			obj.setConState("0");
		csConcernObjService.updateByField(obj, "batchNo");
		
		if("1".equals(obj.getCheckState())){//更新索引
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("batchNO", obj.getBatchNO());
			List<CsConcernObjDto> dataList = csConcernObjService.selectCsConObjInfo(qryMap);
			for (CsConcernObjDto dto : dataList) {
				panoramaSearchService.updatePanoramaIdx(
						csConcernObjService.doGetConcernInfoForIndex(dto.getPriPID()));
			}
		}
		return AjaxResult.success("审核成功");
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
		ModelAndView mav = new ModelAndView("/syn/system/concern/conc/con_view_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("MarkSetDeptCode", getCodeByUserType(sysUser));
		return mav;
	}
	/**
	 * 获取关注服务对象查看页面数据
	 * @author zjj
	 */
	@RequestMapping({ "/viewlist.json", "viewlist.xml" })
	@ResponseBody
	public PageResponse<CsConcernObjDto> viewList(PageRequest request) throws Exception{
		List<CsConcernObjDto> csConcernObjList = csConcernObjService.queryPageForView(request);
		return new PageResponse<CsConcernObjDto>(csConcernObjList);
	}
	
}