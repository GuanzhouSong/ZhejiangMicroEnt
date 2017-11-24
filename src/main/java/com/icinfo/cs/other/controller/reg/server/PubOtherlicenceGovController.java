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

import com.icinfo.cs.other.dto.PubOtherlicenceGovDto;
import com.icinfo.cs.other.service.IPubOtherlicenceGovService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_otherlicence_gov 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
@Controller
@RequestMapping({ "/reg/server/other/pubotherlicencegov/"})
public class PubOtherlicenceGovController extends CSBaseController {
	@Autowired
	private IPubOtherlicenceGovService pubOtherlicenceGovService;
	
	/** 
	 * 描述: 行政许可归集查询
	 * @auther ZhouYan
	 * @date 2017年10月31日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/pubotherlicencegov/pubotherlicencegov_list");
		return view;
	}
	
	/** 
	 * 描述: 行政许可归集查询
	 * @auther ZhouYan
	 * @date 2017年10月31日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOtherlicenceGovDto> listJSON(PageRequest request) throws Exception {
		List<PubOtherlicenceGovDto> data = pubOtherlicenceGovService.selectPubOtherlicenceGovList(request);
		return new PageResponse<PubOtherlicenceGovDto>(data);
	}
	
	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/total.json",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult totalJSON(@RequestBody Map<String, Object> paramsMap) throws Exception {
		PubOtherlicenceGovDto govDto = pubOtherlicenceGovService.selectOtherLicenceGovCount(paramsMap);
		return AjaxResult.success("", govDto);
	}
}