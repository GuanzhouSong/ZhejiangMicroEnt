/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.datacount.controller.reg.server;

import com.icinfo.cs.base.model.*;
import com.icinfo.cs.base.service.impl.*;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.datacount.dto.RptTrade;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidAltitemDto;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.impl.MidAltitemServiceImpl;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.cs.other.service.impl.PubOtherlicenceServiceImpl;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.model.RegistInfo;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistUnlicensed;
import com.icinfo.cs.registinfo.model.UlManage;
import com.icinfo.cs.registinfo.service.impl.RegistInfoServiceImpl;
import com.icinfo.cs.registinfo.service.impl.UlManageServiceImpl;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.impl.CsWarnMarkServiceImpl;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.impl.SysUserServiceImpl;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;
import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 描述:    数据统计
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("/reg/server/datacount/")
public class DataCountController extends CSBaseController {

    @Autowired
    RegistInfoServiceImpl registInfoService;
    @Autowired
    IMidBaseInfoService midBaseInfoService;
    @Autowired
    IPanoramaSearchService panoramaSearchService;
    //-------------------------------------------------跳转页面方法--------------------------------------

    @RequestMapping("/toDataCount")
    public ModelAndView regerror() throws Exception {
        ModelAndView view = new ModelAndView("reg/server/datacount/datacount_list");
        return view;
    }
    @RequestMapping("/toMidQuery")
    public ModelAndView toMidQuery() throws Exception {
        ModelAndView view = new ModelAndView("reg/server/datacount/midquery_list");
        return view;
    }


    //-------------------------------------------------逻辑操作方法--------------------------------------
    /**
     * 请求数据统计
     *
     * @param request
     * @return PageResponse
     */
    @RequestMapping("/midlist.json")
    @ResponseBody
    public PageResponse<MidBaseInfo> midlistJSON(PageRequest request) throws Exception {
        List<MidBaseInfo> midBaseInfos =  midBaseInfoService.queryPage(request);
        return new PageResponse<MidBaseInfo>(midBaseInfos);
    }
    /**
     *
     * 描述   查询企业列表
     * @author liuhq
     * @date 2016年12月12日 下午4:21:41
     * @param
     * @return PageResponse<PanoramaResultDto>
     * @throws
     */
    @RequestMapping({ "/panoQueryPage" })
    @ResponseBody
    public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
        Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
        return new PageResponse<PanoramaResultDto>(data);
    }



    /**
     * 请求数据统计
     *
     * @param request
     * @return PageResponse
     */
    @RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<RptTrade> listJSON(PageRequest request) throws Exception {
        creatOptDBAuthEnv(request, "CheckDep", "LocalAdm");
        List<RptTrade> data = registInfoService.getDataCountQueryPage(request);
        Integer idx=1;
        for (RptTrade rptTrade:
                data) {
            rptTrade.setIndex( idx.toString());
            idx++;
        }
        RptTrade sum = new RptTrade();

        sum.setArea("<font color=\"red\">合计：</font>");
        sum.setCountTrade(data.stream().collect(Collectors.summingDouble(item -> item.getCountTrade())));
        sum.setCountTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getCountTrade_())));
        sum.setEnvironmentTrade(data.stream().collect(Collectors.summingDouble(item -> item.getEnvironmentTrade())));
        sum.setEnvironmentTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getEnvironmentTrade_())));
        sum.setFinanceTrade(data.stream().collect(Collectors.summingDouble(item -> item.getFinanceTrade())));
        sum.setFinanceTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getFinanceTrade_())));
        sum.setHealthTrade(data.stream().collect(Collectors.summingDouble(item -> item.getHealthTrade())));
        sum.setHealthTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getHealthTrade_())));
        sum.setHighInd(data.stream().collect(Collectors.summingDouble(item -> item.getHighInd())));
        sum.setHighInd_(data.stream().collect(Collectors.summingDouble(item -> item.getHighInd_())));
        sum.setInfoTrade(data.stream().collect(Collectors.summingDouble(item -> item.getInfoTrade())));
        sum.setInfoTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getInfoTrade_())));
        sum.setTravelTrade(data.stream().collect(Collectors.summingDouble(item -> item.getTravelTrade())));
        sum.setTravelTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getTravelTrade_())));
        sum.setPopTrade(data.stream().collect(Collectors.summingDouble(item -> item.getPopTrade())));
        sum.setPopTrade_(data.stream().collect(Collectors.summingDouble(item -> item.getPopTrade_())));
        data.add(sum);
        return new PageResponse<RptTrade>(data);
    }


}