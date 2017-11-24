/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.other.dto.PubOtherpunishGovDto;
import com.icinfo.cs.other.service.IPubOtherpunishGovService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_otherpunish_gov 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Controller
@RequestMapping({ "/reg/server/other/pubotherpunishgov/"})
public class PubOtherpunishGovController extends CSBaseController {
	@Autowired
	private IPubOtherpunishGovService pubOtherpunishGovService;
	
	/** 
	 * 描述: 行政处罚归集查询
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/pubotherpunishgov/pubotherpunishgov_list");
		return view;
	}
	
	/** 
	 * 描述: 行政处罚归集查询
	 * @auther ZhouYan
	 * @date 2017年11月1日  
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOtherpunishGovDto> listJSON(PageRequest request) throws Exception {
		List<PubOtherpunishGovDto> data = pubOtherpunishGovService.selectPubOtherpunishGovList(request);
		return new PageResponse<PubOtherpunishGovDto>(data);
	}
	
	/** 
	 * 描述: 在册企业行政处罚数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/total.json",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult totalJSON(@RequestBody Map<String, Object> paramsMap) throws Exception {
		PubOtherpunishGovDto govDto = pubOtherpunishGovService.selectPunishGovCount(paramsMap);
		return AjaxResult.success("统计数成功", govDto);
	}
}