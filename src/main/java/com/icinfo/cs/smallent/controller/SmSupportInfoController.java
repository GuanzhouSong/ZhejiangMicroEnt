/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.smallent.controller;

import java.util.ArrayList;
import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.smallent.model.SmSupportInfo;
import com.icinfo.cs.smallent.service.ISmSupportInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:  企业享受扶持信息公示  cs_sm_support 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
@Controller
@RequestMapping("/pub/smallentsupport")
public class SmSupportInfoController extends BaseController {
	
	@Autowired
	private ISmSupportInfoService smSupportInfoService;
	
	/**
	 * 描述: 进入小微企业名录信息扶持列表页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public ModelAndView list() throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallentsup");
		return view;
	}
	
	/**
	 * 描述: 进入小微企业名录信息扶持嵌入页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/insert")
	public ModelAndView insert() throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallentinsert");
		return view;
	}
	
	/**
     * 获取小微企业扶持列表数据
     * @author yujingwei
     * @date 2016-10-17
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.POST)
    @ResponseBody
    public PageResponse<SmSupportInfo> doGetSupInfo(PageRequest request) throws Exception {
		List<SmSupportInfo> data = new ArrayList<SmSupportInfo>();
		data = smSupportInfoService.doGetSupportInfoList(request);
        return new PageResponse<SmSupportInfo>(data);
    }
	
	/**
	 * 描述: 进入小微企业名录信息扶持详情页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value="/details",method= RequestMethod.GET)
	public ModelAndView view(String pripid) throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallentsupInfo");
		if(StringUtil.isNotBlank(pripid)){
			List<SmSupportInfo> smSupportInfoList = smSupportInfoService.selectByPripid(pripid);
			view.addObject("smSupportInfoList", smSupportInfoList);
		}
		return view;
	}
	
	
	
}