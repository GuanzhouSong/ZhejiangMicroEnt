/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述:    cs_yr_asset 对应的Controller类.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/server/yr/yrasset_server")
public class YrAssetServerController extends BaseController {

    @Autowired
    IYrAssetService yrAssetService;
    @Autowired
    IYrFormService yrFormService;
    @Autowired
    IYrBaseInfoService yrBaseInfoService;
    @Autowired
    IYrRegCheckService yrRegCheckService;
    


    /**
     * 显示资产详情
     * @autor: wangjin
     * @param year
     * @return
     * @throws Exception
     */
    @RequestMapping("/view") //   /reg/server/yr/yrasset_server/view
    public ModelAndView show(String year,String priPID,String entType) throws Exception {
        ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport/asset_view");
        if(StringUtil.checkYearAndPripid(year,priPID)){
            view.addObject("yrAsset", yrAssetService.selectByYearAndPripid(Integer.parseInt(year),priPID));
            view.addObject("year",Integer.parseInt(year));
            view.addObject("entType",entType);  //企业小类
            view.addObject("priPID",priPID);
        }
        return view;
    }

}