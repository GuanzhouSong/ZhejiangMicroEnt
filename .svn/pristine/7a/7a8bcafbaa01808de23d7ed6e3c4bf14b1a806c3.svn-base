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

import com.icinfo.cs.yr.model.FoodstorageAux;
import com.icinfo.cs.yr.model.FoodstorageInfo;
import com.icinfo.cs.yr.service.IFoodstorageAuxService;
import com.icinfo.cs.yr.service.IFoodstorageInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_foodstorage_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
@Controller
@RequestMapping("/reg/server/yr/foodstorageinfo")
public class FoodstorageInfoController extends BaseController {
	@Autowired
	private IFoodstorageInfoService foodstorageInfoService;
	
	@Autowired
	private IFoodstorageAuxService foodstorageAuxService;
	
	/**
	 * 
	 * 描述: 进入仓库列表页面
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public ModelAndView list(String priPID,String year) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstorageinfo/foodstorageinfo_list");
		view.addObject("priPID", priPID);
		view.addObject("year", year);
		return view;
	}
	
	/**
	 * 描述：查询仓库列表
	 * @author chenxin
	 * @date 2016-09-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<FoodstorageInfo> listJSON(PageRequest request) throws Exception {
		List<FoodstorageInfo> data = foodstorageInfoService.queryPage(request);
        return new PageResponse<FoodstorageInfo>(data);
    }
	
	/**
	 * 描述：查询仓库详细信息
	 * 
	 * @author chenxin
	 * @date 2016-09-29
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView doSearchFoodstorageInfo(String fsInfoId) throws Exception {
		FoodstorageInfo foodstorageInfo = foodstorageInfoService.searchFoodstorageInfoByFsInfoId(fsInfoId);
		List<FoodstorageAux> foodstorageAuxList = foodstorageAuxService.searchFoodstorageAuxByFsInfoIdAndPriPID(fsInfoId, null);
		ModelAndView view = new ModelAndView("/reg/server/yr/foodstorageinfo/foodstorageinfo_edit");
		view.addObject("foodstorageInfo", foodstorageInfo);
		view.addObject("foodstorageAuxList", foodstorageAuxList);
		return view;
	}
	
}