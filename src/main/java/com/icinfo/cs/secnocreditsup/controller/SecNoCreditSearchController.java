/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.cs.secnocreditsup.service.ISecNoCreditSearchService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 *
 * @date 2016年11月25日
 */
@Controller
@RequestMapping("/reg/server/secnocreditsearch")
public class SecNoCreditSearchController extends CSBaseController {
	
	@Autowired
	ISecNoCreditSearchService secNoCreditSearchService;
	/** 
	 * 进入严违失信名单查询页面
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/search",method= RequestMethod.GET)
	public ModelAndView search() throws Exception {
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/secnocreditsearch/secnocreditsearch_list");
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	/**
	 * 获取查询数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/searchlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<SecNoCreditSearchDto> searchList(PageRequest request) throws Exception{
		creatDefaultDBAuthEnv(request,"a.AddSecOrg","a.LocalAdm");
		List<SecNoCreditSearchDto> list = secNoCreditSearchService.queryPage(request);
		return new PageResponse<SecNoCreditSearchDto>(list);
	}
}