/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.smallent.controller;

import java.util.ArrayList;
import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.smallent.model.SmSupportInfo;
import com.icinfo.cs.smallent.service.ISmSupportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.smallent.dto.SmBaseInfoDto;
import com.icinfo.cs.smallent.model.SmBaseInfo;
import com.icinfo.cs.smallent.service.ISmBaseInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: 小微企业库   cs_sm_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
@Controller
@RequestMapping("/pub/smallentdir")
public class SmBaseInfoController extends BaseController {
	
	@Autowired
	private ISmBaseInfoService smBaseInfoService;
	@Autowired
	private ISmSupportInfoService smSupportInfoService;
	
	/**
	 * 描述: 进入小微企业库列表页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @return view
	 * @throws Exception
	 */
/*	@RequestMapping("/index2")
	public ModelAndView list2() throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallentdir");
		return view;
	}*/

	/**
	 * 描述: 进入小微企业库列表页面
	 * @auther wangjin
	 * @date 2017-02-23
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public ModelAndView list() throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallmicro");
		return view;
	}

	
	/**
     * 获取小微企业库列表数据
     * @author yujingwei
     * @date 2016-10-17
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	@RequestMapping(value="/list.json",method= RequestMethod.POST)
    @ResponseBody
    public PageResponse<SmBaseInfo> doGetSupInfo(PageRequest request) throws Exception {
		List<SmBaseInfo> data = new ArrayList<SmBaseInfo>();
		data = smBaseInfoService.doGetSmallDirInfoList(request);
        return new PageResponse<SmBaseInfo>(data);
    }
	
	/**
	 * 描述: 进入小微企业库详细信息页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @return view
	 * @throws Exception
	 */
	/*@RequestMapping(value="/details",method= RequestMethod.GET)
	public ModelAndView view(String UID) throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallentdirInfo");
		SmBaseInfoDto smBaseInfo = smBaseInfoService.doGetSmBaseInfo(UID);
		view.addObject("smBaseInfo", smBaseInfo);
		return view;
	}*/

	/**
	 * 描述: 进入小微企业库详细信息页面
	 * @auther wangjin
	 * @date 2017-02-23
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value="/detailsinfo",method= RequestMethod.GET)
	public ModelAndView view1(String UID) throws Exception{
		ModelAndView view = new ModelAndView("pub/smallent/smallmicroDetail");
		SmBaseInfoDto smBaseInfo = smBaseInfoService.doGetSmBaseInfo(UID);
		view.addObject("smBaseInfo", smBaseInfo);
		/*企业享受扶持信息公示*/
		if(smBaseInfo!=null&& StringUtil.isNotBlank(smBaseInfo.getPriPID())){
			List<SmSupportInfo> smSupportInfoList = smSupportInfoService.selectByPripid(smBaseInfo.getPriPID());
			view.addObject("smSupportInfoList", smSupportInfoList);
		}
		return view;
	}

}