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
import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.inforece.sercive.IPubDtInfoForReceService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 *
 * @date 2016年11月25日
 */
@Controller
@RequestMapping("/syn/inforece/pubdtinfoforrece")
public class PubDtInfoForReceController extends BaseController {
	
	@Autowired
	IPubDtInfoForReceService pubDtInfoForReceService;
	/** 
	 * 进入信息接收双告知页面
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/pubdtinfo",method= RequestMethod.GET)
	public ModelAndView pubDtInfo(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("/syn/system/inforece/pubdtinfo/pubdtinfo_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mv.addObject("adcode",sysUser.getSysDepart().getAdcode());
		return mv;
	}
	/**
	 * 获取双告知数据
	 * @author zjj
	 */
	@RequestMapping({ "/pubdtinfolist.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubDtInfoDto> pubdtinfoList(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		List<PubDtInfoDto> data = pubDtInfoForReceService.queryPage(request,sysUser);
		return new PageResponse<PubDtInfoDto>(data);
	}
    /**
     * 查询已下载数据
     * 
     */
	@RequestMapping(value="/downlist",method=RequestMethod.POST)
	@ResponseBody
	public List<PubDtInfoDto> downList(@RequestBody PubDtInfoDto PubDtInfo,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		PubDtInfo.setAdcode(sysUser.getSysDepart().getAdcode());
		List<PubDtInfoDto> list = pubDtInfoForReceService.getDownList(PubDtInfo);
		return list;
	}
}