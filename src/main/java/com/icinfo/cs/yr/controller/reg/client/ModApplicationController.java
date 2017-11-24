/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.common.utils.AESEUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_mod_application 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
@Controller("ClientModApplicationController")
@RequestMapping("/reg/client/yr/modapplication")
public class ModApplicationController extends BaseController {
	@Autowired
	private IModApplicationService modApplicationService;
	
	private final String SESSION_MIDBASEINFODTO="midBaseInfoDto"; 
 
	
	/**
	 * 
	 * 描述 : 进入年报修改页面（企业）
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 下午3:14:12 
	 * @param :
	 * @return: ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/ent/show", method = RequestMethod.GET)
	public ModelAndView show(HttpSession session, String year,String pripid, String reapply) throws Exception {
		year = AESEUtil.decodeYear(year);  //年份解密
		ModelAndView view = new ModelAndView();
		//企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(SESSION_MIDBASEINFODTO);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		pripid = midBaseInfoDto.getPriPID();
		//重新申请reapply时，不查当前申请信息
		if(StringUtils.isNotEmpty(pripid)&&StringUtils.isNotEmpty(year) && StringUtils.isEmpty(reapply)){
			//申请记录
			List<ModApplication> modApplicationList=  modApplicationService.selectModApplicationPriPIDAndYear(Integer.parseInt(year), pripid);
			view.addObject("modApplicationList", modApplicationList);
		} 
		view.addObject("year", year);
		view.addObject("encodeYear",AESEUtil.encodeYear(year)); //年份加密
		view.setViewName("/reg/client/yr/modapply/modapply_edit");
		return view;
	}
	
	/** 
	 * 描述: 进入年报修改页面（农专）
	 * @auther ZhouYan
	 * @date 2016年11月15日 
	 * @param session
	 * @param year
	 * @param pripid
	 * @param reapply
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sfc/show", method = RequestMethod.GET)
	public ModelAndView sfc_show(HttpSession session, String year,String pripid, String reapply) throws Exception { 
		year = AESEUtil.decodeYear(year);
		ModelAndView view = new ModelAndView(); 
		//企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(SESSION_MIDBASEINFODTO);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		pripid = midBaseInfoDto.getPriPID();
		//重新申请reapply时，不查当前申请信息
		if(StringUtils.isNotEmpty(pripid)&&StringUtils.isNotEmpty(year) && StringUtils.isEmpty(reapply)){
			//申请记录
			List<ModApplication> modApplicationList=  modApplicationService.selectModApplicationPriPIDAndYear(Integer.parseInt(year), pripid);
			view.addObject("modApplicationList", modApplicationList);
		} 
		view.addObject("year", year);
		view.addObject("encodeYear",AESEUtil.encodeYear(year));		
		view.setViewName("/reg/client/yr/modapply/modapply_edit");
		return view;
	}
	
	/** 
	 * 描述: 进入年报修改页面（个体）
	 * @auther ZhouYan
	 * @date 2016年11月15日 
	 * @param session
	 * @param year
	 * @param pripid
	 * @param reapply
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/pb/show", method = RequestMethod.GET)
	public ModelAndView pb_show(HttpSession session, String year,String pripid, String reapply) throws Exception { 
		year = AESEUtil.decodeYear(year);
		ModelAndView view = new ModelAndView(); 
		//企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(SESSION_MIDBASEINFODTO);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		pripid = midBaseInfoDto.getPriPID();
		//重新申请reapply时，不查当前申请信息
		if(StringUtils.isNotEmpty(pripid)&&StringUtils.isNotEmpty(year) && StringUtils.isEmpty(reapply)){
			//申请记录
			List<ModApplication> modApplicationList=  modApplicationService.selectModApplicationPriPIDAndYear(Integer.parseInt(year), pripid);
			view.addObject("modApplicationList", modApplicationList);
		} 
		view.addObject("year", year);
		view.addObject("encodeYear",AESEUtil.encodeYear(year));		
		view.setViewName("/reg/client/yr/modapply/modapply_edit");
		return view;
	}
	
	/**
	 * 
	 * 描述 : 保存（企业）
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 下午3:37:50 
	 * @param :
	 * @return: AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/ent/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@RequestBody  ModApplication modApplication) throws Exception{
	    int i= modApplicationService.insertModApplication(modApplication);
		if(i>0){ 
			return AjaxResult.success("新增成功");
		}else{
			return AjaxResult.error("新增失败");
		} 
	}  
	
	/** 
	 * 描述:  保存（农专）
	 * @auther ZhouYan
	 * @date 2016年11月15日 
	 * @param modApplication
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sfc/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult sfc_save(@RequestBody  ModApplication modApplication) throws Exception{
	    int i= modApplicationService.insertModApplication(modApplication);
		if(i>0){ 
			return AjaxResult.success("新增成功");
		}else{
			return AjaxResult.error("新增失败");
		} 
	} 
	
	/** 
	 * 描述:  保存（个体）
	 * @auther ZhouYan
	 * @date 2016年11月15日 
	 * @param modApplication
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/pb/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pb_save(@RequestBody  ModApplication modApplication) throws Exception{
	    int i= modApplicationService.insertModApplication(modApplication);
		if(i>0){ 
			return AjaxResult.success("新增成功");
		}else{
			return AjaxResult.error("新增失败");
		} 
	} 
	
	/** 
	 * 描述: 企业端：查询历史修改记录（企业）
	 * @auther ZhouYan
	 * @date 2016年9月22日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({"/ent/list_json"})
	@ResponseBody
	public PageResponse<ModApplication> list_json(PageRequest request) throws Exception {
		List<ModApplication> data = modApplicationService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<ModApplication>(data);
	}
	
	/** 
	 * 描述: 企业端：查询历史修改记录（农专）
	 * @auther ZhouYan
	 * @date 2016年9月22日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({"/sfc/list_json"})
	@ResponseBody
	public PageResponse<ModApplication> sfclist_json(PageRequest request) throws Exception {
		List<ModApplication> data = modApplicationService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<ModApplication>(data);
	}
	
	/** 
	 * 描述: 企业端：查询历史修改记录（个体）
	 * @auther ZhouYan
	 * @date 2016年9月22日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({"/pb/list_json"})
	@ResponseBody
	public PageResponse<ModApplication> pblist_json(PageRequest request) throws Exception {
		List<ModApplication> data = modApplicationService.select_queryPage(request);//执行参数条件查询
		return new PageResponse<ModApplication>(data);
	}
}