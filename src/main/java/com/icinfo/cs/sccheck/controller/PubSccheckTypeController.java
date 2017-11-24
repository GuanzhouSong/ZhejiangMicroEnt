/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_pub_sccheck_type 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Controller
@RequestMapping("/commom/sccheck/pubscchecktype")
public class PubSccheckTypeController extends BaseController {
	
	@Autowired
	private IPubSccheckTypeService pubSccheckTypeService;
	
	/**
	 * 描述: 进入检查事项树选择页面
	 * @auther chenxin
	 * @date 2017年4月20日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("scChecktypeSelect")
	public ModelAndView toOrgChooseTreeView(String isPermissionCheck) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scagent/sccheck_tree");
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;
		
	}
	
	/**
	 * 描述: 获取检查事项树 数据
	 * @auther yujingwei
	 * @date 2017年4月20日
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/treeListJSON")
	@ResponseBody
	public AjaxResult treeListJSON(String isPermissionCheck, String sccheckCodeIn) throws Exception {
		List<Map<String, Object>> data = pubSccheckTypeService.selectScPtypeMap(sccheckCodeIn);
		return AjaxResult.success("查询成功", data);
	}
	
}