/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.CodeUtils;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.dto.CsWarnMarkDto;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.ICsWarnDeptService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_warn_mark 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/syn/risk/cswarnmark")
public class CsWarnMarkController extends CSBaseController {
	@Autowired
	ICsWarnMarkService csWarnMarkService;
	
	@Autowired
	ICsWarnDeptService csWarnDeptService;
	
	@Autowired
	ICsEntWarnService csEntWarnService;
	
	@Autowired
	ICsSuperviseObjService csSuperviseObjService;
	
	@Autowired
	IPanoramaSearchService panoramaSearchService;
	
	@Autowired
	ICsConcernObjService csConcernObjService;
	
	/**
	 * 进入预警标识设置页面
	 * @author zjj
	 * 20161018
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/risk/mark/warnmark_list");
		CsWarnMarkDto csWarnMark = new CsWarnMarkDto();
		csWarnMark.setUserType(sysUser.getUserType());
		csWarnMark.setMarkAppointDeptCode(getCodeByUserType(sysUser));
		csWarnMark.setMarkSetDeptCode(getCodeByUserType(sysUser));
		List<CsWarnMark> yearList = csWarnMarkService.selectCsWarnMarkSetYear();
		view.addObject("yearList",yearList);
		view.addObject("csWarnMark",csWarnMark);
		return view;
	}
	/**
	 * 获取预警标识
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/warnlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<CsWarnMark> markListJson(PageRequest request) throws Exception{
		List<CsWarnMark> csWarnMarkList = csWarnMarkService.queryPage(request);
		return new PageResponse<CsWarnMark>(csWarnMarkList);
	}
	
	/**
	 * 进入新增修改预警标识页面
	 * @author zjj
	 * 20161019
	 */
	@RequestMapping(value="/enaddAndedit",method= RequestMethod.GET)
	public ModelAndView enaddAndedit(String uid,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/risk/mark/warnmark_edit");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> qryMap = new HashMap<String,Object>();
		CsWarnMark csWarnMark = new CsWarnMark();
		csWarnMark.setMarkNo(CodeUtils.createCode("yj"));
		csWarnMark.setMarkSetDept(sysUser.getDept());
		csWarnMark.setMarkSetDeptCode(getCodeByUserType(sysUser));
		csWarnMark.setSetId(sysUser.getId());
		csWarnMark.setMarkSetDate(new Date());
		//修改
		if(!StringUtils.isBlank(uid)){
			qryMap.put("uid", uid);
		    List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
		    csWarnMark = csWarnMarkList.get(0);
		}
		view.addObject("csWarnMark", csWarnMark);
		
		return view;
	}
	/**
	 * 新增修改预警标识
	 *@author zjj
	 *20161018
	 * @throws Exception
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@RequestBody CsWarnMarkDto csWarnMark,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markFunc","yj");
		map.put("markName",csWarnMark.getMarkName());
		map.put("markSetDeptCode", getCodeByUserType(sysUser));
		List<CsWarnMark> dataList = csWarnMarkService.selectCsWarnMarkList(map);
		
		//插入关联部门表
		csWarnDeptService.insertDept(csWarnMark, "yj");
		
		if(!StringUtils.isBlank(csWarnMark.getUid())){
			if(dataList != null && dataList.size()>0 && !dataList.get(0).getUid().equals(csWarnMark.getUid()))
				return AjaxResult.error("预警标识名称已存在，请修改！");
			if(csWarnMarkService.update(csWarnMark)>0){
				
					//更改企业审核状态
					if("1".equals(csWarnMark.getEntapplyflag())){
						CsEntWarnDto csEntWarn = new CsEntWarnDto();
						csEntWarn.setBatchNo(csWarnMark.getBatchNo());
						csEntWarn.setCheckState("2");
						csEntWarnService.update(csEntWarn);
					}
					
					//更新预警标识索引 
					updateEntWarnIdx(csWarnMark.getMarkNo());
					return AjaxResult.success("修改成功!");
			}
			return AjaxResult.error("修改失败!");
		}
		//新增
		if(dataList != null && dataList.size()>0)
			return AjaxResult.error("预警标识名称已存在，请修改！");
		
		csWarnMark.setMarkSetYear(DateUtil.getCurrentYear());
		csWarnMark.setCreateTime(new Date());
		
		if(csWarnMarkService.insert(csWarnMark)>0){
			return AjaxResult.success("添加成功!");
		}
		
		return AjaxResult.error("添加失败!");
	}
	
	/**
	 * 失效处理
	 * @author zjj
	 * 20161020
	 */
	@RequestMapping(value="/disable",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult disable(String uid,String markNo,String type) throws Exception{
		if(!StringUtils.isBlank(uid)){
			CsWarnMark csWarnMark = new CsWarnMark();
			csWarnMark.setUid(uid);
			csWarnMark.setMarkState("0");	
			
			if(!(csWarnMarkService.disableUpdate(csWarnMark)>0))
				return AjaxResult.error("操作失败!");

			if("jg".equals(type)){
				updateSuperviseIdx(markNo);
			}else if("yj".equals(type)){
				updateEntWarnIdx(markNo);
			}else if("gz".equals(type)){
				updateConcernIdx(markNo);
			}
		}
		return AjaxResult.error("操作成功!");
	}
	
	
	
	/**
	 * 进去重点监管对象 标识列表页面
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnSupMark")
	@ResponseBody
	public ModelAndView doEnSupMark(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/syn/system/supervise/mark/mark_list");
		CsWarnMarkDto csWarnMark = new CsWarnMarkDto();
		csWarnMark.setUserType(sysUser.getUserType());
		csWarnMark.setMarkAppointDeptCode(getCodeByUserType(sysUser));
		csWarnMark.setMarkSetDeptCode(getCodeByUserType(sysUser));
		mav.addObject("yearList",csWarnMarkService.selectCsWarnMarkSetYear());
		mav.addObject("csWarnMark",csWarnMark);
		return mav;
	}
	
	/**
	 * 获取预警标识
	 * 
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doGetSupMarklist")
	@ResponseBody
	public PageResponse<CsWarnMark> doGetSupMarklist(PageRequest request) throws Exception{
		List<CsWarnMark> csWarnMarkList = csWarnMarkService.queryPage(request);
		return new PageResponse<CsWarnMark>(csWarnMarkList);
	}
	
	
	/**
	 * 进入新增修改预警标识页面
	 * 
	 * @author zhuyong
	 */
	@RequestMapping(value="/doEnMarkAddAndEdit",method= RequestMethod.GET)
	public ModelAndView doEnMarkAddAndEdit(String uid,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/supervise/mark/mark_addandedit");
		//修改
		if(!StringUtils.isBlank(uid)){
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("uid", uid);
			List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
			view.addObject("csWarnMark", csWarnMarkList.get(0));
			return view;
		}
		
		CsWarnMark csWarnMark = new CsWarnMark();
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		csWarnMark.setMarkNo(CodeUtils.createCode("jg"));//标识编号
		csWarnMark.setMarkSetDept(sysUser.getDept());
		csWarnMark.setMarkSetDeptCode(getCodeByUserType(sysUser));
		csWarnMark.setMarkSetYear(DateUtil.getCurrentYear());
		csWarnMark.setMarkSetDate(new Date());
		view.addObject("csWarnMark", csWarnMark);
		return view;
	}
	
	/**
	 * 进入新增修改预警标识页面
	 * 
	 * @author zhuyong
	 */
	@RequestMapping(value="/doEnMarkView",method= RequestMethod.GET)
	public ModelAndView doEnMarkView(String uid,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/supervise/mark/mark_view");
		//修改
		if(!StringUtils.isBlank(uid)){
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("uid", uid);
			List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
			view.addObject("csWarnMark", csWarnMarkList.get(0));
			return view;
		}
		
		return view;
	}
	
	
	
	/**
	 * 新增修改监控标识
	 * 
	 *@author zhuyong
	 *20161018
	 * @throws Exception
	 */
	@RequestMapping(value="/doSaveSupMark",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSaveSupMark(@RequestBody CsWarnMarkDto csWarnMark,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markFunc","jg");
		map.put("markName",csWarnMark.getMarkName());
		map.put("markSetDeptCode", getCodeByUserType(sysUser));
		List<CsWarnMark> dataList = csWarnMarkService.selectCsWarnMarkList(map);
		
		//修改
		if(!StringUtils.isBlank(csWarnMark.getUid())){
			if(dataList != null && dataList.size()>0 && !dataList.get(0).getUid().equals(csWarnMark.getUid()))
				return AjaxResult.error("监管标识名称已存在，请修改！");
			//插入关联部门表
			csWarnDeptService.insertDept(csWarnMark, "jg");
			csWarnMarkService.update(csWarnMark);
			
			//更新监管标识索引 
			updateSuperviseIdx(csWarnMark.getMarkNo());
			
			return AjaxResult.success("修改成功!");
		}
		
		//新增
		if(dataList != null && dataList.size()>0)
			return AjaxResult.error("监管标识名称已存在，请修改！");
		
		csWarnMark.setCreateTime(new Date());//设置时间
		csWarnMark.setSetId(sysUser.getId());
		csWarnMarkService.insert(csWarnMark);
		csWarnDeptService.insertDept(csWarnMark, "jg");
		
		return AjaxResult.success("添加成功!");
	}
	
	/**
	 * 预警标识查看详情
	 * @author zjj
	 * 20161031
	 * 
	 */
	@RequestMapping(value="/lookdetail",method= RequestMethod.GET)
	public ModelAndView lookdetail(String uid) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/risk/mark/warnmark_detail");
		if(!StringUtils.isBlank(uid)){
		   Map<String,Object> qryMap = new HashMap<String,Object>();
		   qryMap.put("uid", uid);
		   List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
		   if(csWarnMarkList.get(0).getMarkStartDate().getTime()<=(new Date()).getTime()&&csWarnMarkList.get(0).getMarkEndDate().getTime()>=(new Date()).getTime()&&csWarnMarkList.get(0).getMarkState().equals("1")){
			   csWarnMarkList.get(0).setMarkState("1");  
		   }else{
			   csWarnMarkList.get(0).setMarkState("0");
		   }
		   mv.addObject("csWarnMark",csWarnMarkList.get(0));
		}
		return mv;
	}
	
	/**
	 * 进去关注服务对象 标识列表页面
	 * 
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doEnConMark")
	@ResponseBody
	public ModelAndView doEnConMark(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/syn/system/concern/mark/mark_list");
		CsWarnMarkDto csWarnMark = new CsWarnMarkDto();
		csWarnMark.setUserType(sysUser.getUserType());
		csWarnMark.setMarkAppointDeptCode(getCodeByUserType(sysUser));
		csWarnMark.setMarkSetDeptCode(getCodeByUserType(sysUser));

		mav.addObject("yearList",csWarnMarkService.selectCsWarnMarkSetYear());
		mav.addObject("csWarnMark",csWarnMark);
		return mav;
	}
	
	/**
	 * 获取关注服务标识
	 * 
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doGetConMarklist")
	@ResponseBody
	public PageResponse<CsWarnMark> doGetConMarklist(PageRequest request) throws Exception{
		List<CsWarnMark> csWarnMarkList = csWarnMarkService.queryPage(request);
		return new PageResponse<CsWarnMark>(csWarnMarkList);
	}
	/**
	 * 进入新增修改关注服务标识页面
	 * 
	 * @author zjj
	 */
	@RequestMapping(value="/doEnConMarkAddAndEdit",method= RequestMethod.GET)
	public ModelAndView doEnConMarkAddAndEdit(String uid,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/concern/mark/mark_edit");
		//修改
		if(!StringUtils.isBlank(uid)){
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("uid", uid);
			List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
			view.addObject("csWarnMark", csWarnMarkList.get(0));
			return view;
		}
		
		CsWarnMark csWarnMark = new CsWarnMark();
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		csWarnMark.setMarkNo(CodeUtils.createCode("gz"));//标识编号
		csWarnMark.setMarkSetDept(sysUser.getDept());
		csWarnMark.setMarkSetDeptCode(getCodeByUserType(sysUser));
		csWarnMark.setMarkSetYear(DateUtil.getCurrentYear());
		csWarnMark.setMarkSetDate(new Date());
		view.addObject("csWarnMark", csWarnMark);
		return view;
	}
	/**
	 * 新增修改关注服务标识
	 * 
	 *@author zjj
	 *20161018
	 * @throws Exception
	 */
	@RequestMapping(value="/doSaveConMark",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSaveConMark(@RequestBody CsWarnMarkDto csWarnMark,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markFunc","gz");
		map.put("markName",csWarnMark.getMarkName());
		map.put("markSetDeptCode", getCodeByUserType(sysUser));
		List<CsWarnMark> dataList = csWarnMarkService.selectCsWarnMarkList(map);
		
		//插入关联部门表
		csWarnDeptService.insertDept(csWarnMark, "gz");
		
		//修改
		if(!StringUtils.isBlank(csWarnMark.getUid())){
			if(dataList != null && dataList.size()>0 && !dataList.get(0).getUid().equals(csWarnMark.getUid()))
				return AjaxResult.error("关注标识名称已存在，请修改！");
			csWarnMarkService.update(csWarnMark);
			
			//更新关注标识索引 
			updateConcernIdx(csWarnMark.getMarkNo());
			return AjaxResult.success("修改成功!");
		}
		//新增
		if(dataList != null && dataList.size()>0)
			return AjaxResult.error("关注标识名称已存在，请修改！");
		
		csWarnMark.setCreateTime(new Date());//设置时间
		csWarnMark.setSetId(sysUser.getId());
		csWarnMarkService.insert(csWarnMark);
		return AjaxResult.success("添加成功!");
	}
	
	/**
	 * 关注标识查看详情
	 * @author zjj
	 * 
	 */
	@RequestMapping(value="/lookdetailforgz",method= RequestMethod.GET)
	public ModelAndView lookdetailForGZ(String uid) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/concern/mark/mark_detail");
		if(!StringUtils.isBlank(uid)){
		   Map<String,Object> qryMap = new HashMap<String,Object>();
		   qryMap.put("uid", uid);
		   List<CsWarnMark> csWarnMarkList = csWarnMarkService.selectCsWarnMarkList(qryMap);
		   if(csWarnMarkList.get(0).getMarkStartDate().getTime()<=(new Date()).getTime()&&csWarnMarkList.get(0).getMarkEndDate().getTime()>=(new Date()).getTime()&&"1".equals(csWarnMarkList.get(0).getMarkState())){
			   csWarnMarkList.get(0).setMarkState("1");  
		   }else{
			   csWarnMarkList.get(0).setMarkState("0");
		   }
		   mv.addObject("csWarnMark",csWarnMarkList.get(0));
		}
		return mv;
	}
	
	/**
	 * 查询是否有我的标识
	 * @author zjj
	 */
	@RequestMapping(value="/doselectmymark",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSelectMyMark(String markFunc,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("markSetDeptCode",getCodeByUserType(sysUser));
		qryMap.put("markState", "1");
		qryMap.put("markFunc", markFunc);
		
		if(csWarnMarkService.selectCsWarnMarkList(qryMap).size()>0)
			return AjaxResult.success("true");
		else
			return AjaxResult.success("false");
	}
	
	
	/**
	 * 更新重点企业监管索引
	 * 
	 * @author zhuyong
	 * @param markNo
	 * @throws Exception
	 */
	private void updateSuperviseIdx(String markNo) throws Exception{
		if(StringUtils.isBlank(markNo)) return;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markCode", markNo);
		List<CsSuperviseObjDto> dtoList = csSuperviseObjService.queryListNoPage(map);
		for (CsSuperviseObjDto dto : dtoList) {
			panoramaSearchService.updatePanoramaIdx(
					csSuperviseObjService.doGetSuperviewInfoForIndex(dto.getPriPID()));
		}
			
	}
	/**
	 * 更新企业预警索引
	 * 
	 * @author zjj
	 * @param markNo
	 * @throws Exception
	 */
	private void updateEntWarnIdx(String markNo) throws Exception{
		if(StringUtils.isBlank(markNo)) return;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markNo", markNo);
		List<CsEntWarnDto> dataList = csEntWarnService.selectCsEntWarnApplyInfo(map);
		for (CsEntWarnDto dto : dataList) {
			panoramaSearchService.updatePanoramaIdx(
					csEntWarnService.doGetEntWarnInfoForIndex(dto.getPriPID()));
		}
			
	}
	/**
	 * 更新企业关注服务索引
	 * 
	 * @author zjj
	 * @param markNo
	 * @throws Exception
	 */
	private void updateConcernIdx(String markNo) throws Exception{
		if(StringUtils.isBlank(markNo)) return;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("markNo", markNo);
		List<CsConcernObjDto> dataList = csConcernObjService.selectCsConObjInfo(map);
		for (CsConcernObjDto dto : dataList) {
			panoramaSearchService.updatePanoramaIdx(
					csConcernObjService.doGetConcernInfoForIndex(dto.getPriPID()));
		}
			
	}
	
	/**
	 * 打印预警页面
	 * @author zjj
	 * 
	 */
	@RequestMapping(value="/doenprint")
	public ModelAndView doEnPrint() throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/risk/mark/warnmark_print");
		return mv;
	}
	
	/**
	 * 打印关注服务页面
	 * @author zjj
	 * 
	 */
	@RequestMapping(value="/doenconprint")
	public ModelAndView doEnConPrint() throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/concern/mark/mark_print");
		return mv;
	}
	
}