/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.icinfo.framework.core.web.BaseController;


/**
 * 描述: cs_code_regorg 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Controller
@RequestMapping("/commom/server/intercept/")
public class interceptController extends BaseController {

	/**
	 * 
	 * 描述:  to公共弹窗页面（树）
	 * @auther gaojinling
	 * @date 2016年11月25日 
	 * @param selecttype (传入的list值)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("interceptselect")
	public ModelAndView toOrgTreeView(String selecttype) throws Exception {
		ModelAndView view = new ModelAndView("/common/select/selectintercept");
		view.addObject("selecttype", selecttype);
		return view;

	}
	
	/**
	 * 
	 * 描述:  to公共弹窗页面（多选树）
	 * @auther gaojinling
	 * @date 2016年11月25日 
	 * @param selecttype (传入的list值)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("interceptselectmuti")
	public ModelAndView toOrgTreeViewMuti(String selecttype) throws Exception {
		ModelAndView view = new ModelAndView("/common/select/selectinterceptmuti");
		view.addObject("selecttype", selecttype);
		return view;

	}
	
	
}