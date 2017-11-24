/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inforece.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.inforece.sercive.ISecNoCreditService;
import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 *
 * @date 2016年11月25日
 */
@Controller
@RequestMapping("/syn/inforece/secnocredit")
public class SecNoCreditController extends BaseController {
	
	@Autowired
	ISecNoCreditService secNoCreditService;
	/** 
	 * 进入严违失信名单
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/nocreditview",method= RequestMethod.GET)
	public ModelAndView noCreditView(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/syn/system/inforece/secnocredit/secnocredit_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mv.addObject("adcode",sysUser.getSysDepart().getAdcode());
		return mv;
	}
	
	/**
	 * 获取严违失信名单数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/nocreditlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<SecNoCreditSearchDto> noCreditList(PageRequest request) throws Exception{
		List<SecNoCreditSearchDto> List = secNoCreditService.queryPage(request);
		return new PageResponse<SecNoCreditSearchDto>(List);
	}
    /**
     * 查询已下载数据
     * 
     */
	@RequestMapping(value="/downlist",method=RequestMethod.POST)
	@ResponseBody
	public List<SecNoCreditSearchDto> downList(@RequestBody SecNoCreditSearchDto secNoCreditSearchDto,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		secNoCreditSearchDto.setAdcode(sysUser.getSysDepart().getAdcode());
		List<SecNoCreditSearchDto> list = secNoCreditService.getDownList(secNoCreditSearchDto);
		return list;
	}
}