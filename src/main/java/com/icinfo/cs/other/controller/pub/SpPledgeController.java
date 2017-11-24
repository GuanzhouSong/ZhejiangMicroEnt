/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.pub;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.other.model.SpPledge;
import com.icinfo.cs.other.service.ISpPledgeService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_sp_pledge 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月27日
 */
@Controller("SpPledge")
@RequestMapping("/pub/sppledge")
public class SpPledgeController extends BaseController {
	
	@Autowired
	private ISpPledgeService spPledgeService;
	
	/** 
	 * 描述: 获取股权出质登记信息列表数据
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<SpPledge> listJSON(PageRequest request) throws Exception {
		List<SpPledge> data = spPledgeService.queryPage(request);
        return new PageResponse<SpPledge>(data);
    }
	
	/** 
	 * 描述: 获取股权出质登记信息详情数据
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/detail")
	public ModelAndView doEnDetail(String id) throws Exception{
		ModelAndView view = new ModelAndView("pub/infopublic/infodetail/stockdetail");
		if(StringUtils.isNotBlank(id)){
			//根据id查详情
			SpPledge spPledge = spPledgeService.doGetSpPledgeById(id);
			view.addObject("spPledge", spPledge);
		}
		return view;
	}
}