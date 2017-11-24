/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.syn.server;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.simpleesc.dto.ErEscScrinfoDto;
import com.icinfo.cs.simpleesc.service.IErEscScrinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: er_esc_scrinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller("ServerErEscScrinfoController")
@RequestMapping("/syn/erescscrinfo")
public class ErEscScrinfoController extends CSBaseController{

	@Autowired
	IErEscScrinfoService erEscScrinfoService;

	/**
	 * 
	 * 描述   分页查询简易注销结果列表
	 * @author 赵祥江
	 * @date 2017年2月21日 下午2:17:50 
	 * @param 
	 * @return PageResponse<ErEscScrinfoDto>
	 * @throws
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<ErEscScrinfoDto> listJSON(PageRequest request) throws Exception {
		Map<String,Object> queryMap=request.getParams();
		//去除空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		//权限
		//buildDBEnv_baseLocalAdminWhenSyn(false).creatDefaultDBAuthEnv(request,"C.CheckDep","C.LocalAdm"); 
		List<ErEscScrinfoDto> erEscScrinfoDtos = erEscScrinfoService.queryErEscScrinfoPageResult(request);
		return new PageResponse<ErEscScrinfoDto>(erEscScrinfoDtos);
	}
	
	
	/**
	 * 
	 * 描述   进入简易注销结果查询页面
	 * @author 赵祥江
	 * @date 2017年2月21日 下午2:21:35 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/erescscrinfoListPage")
	public ModelAndView erescscrinfoListPage(HttpSession session) throws Exception{ 
		ModelAndView view =new ModelAndView("/syn/system/simpleesc/erescscrinfo_list");
		view.addObject("sysUrl", "/syn"); 
		return view;
	}
	
	/**
	 * 
	 * 描述   根据主体代码查询
	 * @author 赵祥江
	 * @date 2017年2月23日 上午10:14:16 
	 * @param 
	 * @return PageResponse<ErEscScrinfoDto>
	 * @throws
	 */
	@RequestMapping({ "erescList.json", "list.xml" })
	@ResponseBody
	public PageResponse<ErEscScrinfoDto> erescListJSON(PageRequest request) throws Exception {
		List<ErEscScrinfoDto> erEscScrinfoDtos = erEscScrinfoService.queryPageResult(request);
		return new PageResponse<ErEscScrinfoDto>(erEscScrinfoDtos);
	}
	
	
}