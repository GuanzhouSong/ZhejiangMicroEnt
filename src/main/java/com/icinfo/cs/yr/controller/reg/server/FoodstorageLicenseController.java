/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.yr.model.FoodstorageLicense;
import com.icinfo.cs.yr.service.IFoodstorageLicenseService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_foodstorage_license 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller("FoodstorageBaseServerController")
@RequestMapping("/reg/server/yr/foodstoragelicense")
public class FoodstorageLicenseController extends BaseController {
	@Autowired
	private IFoodstorageLicenseService foodstorageLicenseService;
	
	/**
	 * 
	 * 描述: 进入许可证列表页面
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(String priPID,String licType,String year) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstoragelicense/foodstoragelicense_list");
		view.addObject("priPID", priPID);
		view.addObject("licType", licType);
		view.addObject("year", year);
		return view;
	}
	
	/**
	 * 描述：查询许可证列表
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<FoodstorageLicense> listJSON(PageRequest request) throws Exception {
		List<FoodstorageLicense> data = foodstorageLicenseService.queryPage(request);
        return new PageResponse<FoodstorageLicense>(data);
    }
}