/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_mid_member 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Controller
@RequestMapping("/midmember/")
public class MidMemberController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MidMemberController.class);

	@Autowired
	IMidMemberService midMemberService;

	/**
	 * 描述：主要人员列表页面
	 * 
	 * @author baifangfang
	 * @date 2016年11月24日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infodetail/memberdetail");
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		mav.addObject("priPID", priPID);
		return mav;
	}

	/**
	 * 描述：根据priPID查询主要人员信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public List<MidMemberDto> listJSON(@RequestParam String priPID) throws Exception {
		List<MidMemberDto> midMemberDtos = midMemberService.queryListResult(priPID);
		logger.info("midMemberDtos {}", midMemberDtos);
		return midMemberDtos;
	}

	/**
	 * 描述：根据证件号查询主要人员信息JSON数据列表
	 *
	 * @author ylr
	 * @date 2016年11月6日
	 * @throws Exception
	 */
	@RequestMapping("doGetMidMemberList")
	@ResponseBody
	public PageResponse<MidMemberDto> doGetMidMemberList(PageRequest request) throws Exception {
		List<MidMemberDto> midMemberDtoList = midMemberService.selectMidMemberList(request);
		return new PageResponse<MidMemberDto>(midMemberDtoList);
	}
}