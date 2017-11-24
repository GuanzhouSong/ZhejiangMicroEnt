package com.icinfo.cs.yr.controller.reg.server;


import com.icinfo.cs.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.yr.service.IYrAssetService;

/**
 * 分支机构经营情况对应控制~Server端 <br>
 * 描述: TODO<br>
 * 
 * @author ljx
 * @date 2016年10月16日
 */
@Controller
@RequestMapping("/reg/server/yr/yrassetbranch_server")
public class YrAssetBranchServerController {

	@Autowired
	private IYrAssetService yrAssetService;
    /**
     * 
     * 描述: 显示分支机构经营情况
     * @auther wangjin
     * @param year
     * @param priPID
     * @return
     * @throws Exception
     */
	@RequestMapping("/view")
	public ModelAndView show(String year, String priPID,String entType) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport/assetbranch_view");
		if(StringUtil.checkYearAndPripid(year,priPID)) {
			view.addObject("yrAsset", yrAssetService.selectByYearPridIdForBranch(Integer.parseInt(year), priPID));
			view.addObject("year", Integer.parseInt(year));
			view.addObject("entType", entType);  //企业小类
			view.addObject("priPID", priPID);
		}

		return view;

	}

}
