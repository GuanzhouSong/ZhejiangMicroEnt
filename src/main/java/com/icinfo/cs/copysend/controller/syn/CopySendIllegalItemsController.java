/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.controller.syn;

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
import com.icinfo.cs.copysend.dto.CopySendIllegalItemsDto;
import com.icinfo.cs.copysend.model.CopySendIllegalItems;
import com.icinfo.cs.copysend.service.ICopySendIllegalItemsService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_copy_send_illegal_items 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
@Controller
@RequestMapping({"/syn/illegalitem/","/reg/server/illegalitem/"})
public class CopySendIllegalItemsController extends BaseController {
	
	@Autowired
	private ICopySendIllegalItemsService copySendIllegalItemsService;
	
	  /**
     * 进入抄告抄送页面
     * @author ylr
     * @date 2016-10-20
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnIllegalItem")
	public ModelAndView doEnIllegalItem(String deptcode) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/copysend/cgcs_illegalitem");
		
		mv.addObject("deptcode", deptcode);
		return mv;
	}
	
	  /**
     * 进入涉嫌违法事项维护页面
     * @author chenyu
     * @date 2016-10-20
     * @return ModelAndView
     *
     */
	@RequestMapping("doCopySendIllegalItems")
	public ModelAndView doCopySendIllegalItems() throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/copysend/cgcs_illegalitems_weihu");
		return mv;
	}
	
	  /**
     * 获取涉嫌违法事项列表
     * @author ylr
     * @date 2016-11-1
     * @return ajax
     *
     */
	@RequestMapping("doGetIllegalItemList")
	@ResponseBody
	public AjaxResult doGetIllegalItemList(String deptCode,String illegalItems,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("deptCode", deptCode);
		qryMap.put("illegalItems", illegalItems);
		if("1".equals(sysUser.getUserType()))//jinshi
			qryMap.put("userType", 1);
		if("2".equals(sysUser.getUserType()))//xt
			qryMap.put("userType", 2);
		
		List<CopySendIllegalItems> copySendIllegalItemsList = copySendIllegalItemsService.selectCopySendIllegalItemsList(qryMap);
		
		return AjaxResult.success("列表加载成功！",copySendIllegalItemsList);
	}
	
	 /**
     * 获取涉嫌违法事项维护列表
     * @author chenyu
     * @date 2016-11-1
     * @return ajax
     *
     */
	@RequestMapping("doGetIllegalItemWeiHuList")
	@ResponseBody
	public PageResponse<CopySendIllegalItemsDto> doGetIllegalItemWeiHuList(PageRequest request,HttpSession session) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<CopySendIllegalItemsDto> copySendIllegalItemsList = copySendIllegalItemsService.selectCopySendIllegalItemsWeiHuList(request.getParams());
		return new PageResponse<CopySendIllegalItemsDto>(copySendIllegalItemsList);
	}
	
	 /**
     * 进去添加或修改页面
     * @author chenyu
     * @date 2016-11-1
     * @return ModelAndView
     *
     */
	@RequestMapping("doAddAndEditCopySendIllegalItems")
	public ModelAndView doAddCopySendIllegalItems(String id) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/syn/system/syncsupervise/copysend/cgcs_illegalitems_addandedit");
		if(StringUtils.isNotBlank(id)){
			mv.addObject("copySendIllegalItems",copySendIllegalItemsService.selectCopySendIllegalItemsWeiHuById(id));
			mv.addObject("pageFlag", "edit");
		}
		else{
			mv.addObject("pageFlag", "add");
		}
		return mv;
	}
	
	 /**
     * 保存操作
     * @author chenyu
     * @date 2016-11-1
     * @return ModelAndView
	 * @throws Exception 
     *
     */
	@RequestMapping(value="save",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSaveCopySendIllegalItems(@RequestBody CopySendIllegalItems copySendIllegalItems) throws Exception{
		copySendIllegalItemsService.insert(copySendIllegalItems);
		return AjaxResult.success("添加成功!");
	}
	
	/**
     * 修改操作
     * @author chenyu
     * @date 2016-11-1
     * @return ModelAndView
	 * @throws Exception 
     *
     */
	@RequestMapping(value="edit",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doEditCopySendIllegalItems(@RequestBody CopySendIllegalItems copySendIllegalItems) throws Exception{
		copySendIllegalItemsService.update(copySendIllegalItems);
		return AjaxResult.success("修改成功!");
	}
	
	/**
     * 删除操作
     * @author chenyu
     * @date 2016-11-1
     * @return ModelAndView
	 * @throws Exception 
     *
     */
	@RequestMapping(value="delete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDeleteCopySendIllegalItems(Integer id) throws Exception{
		copySendIllegalItemsService.delete(id);
		return AjaxResult.success("删除成功!");
	}
}