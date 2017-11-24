/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.controller;

import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.webservice.model.WsPubEppassword;
import com.icinfo.cs.webservice.service.IWsPubEppasswordService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 描述: 联络员信息表 cs_pub_eppassword 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
@Controller
@RequestMapping({"/webservice/pubeppassword"})
public class WsPubEppasswordController extends CSBaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsPubEppasswordController.class);

    @Autowired
    private IWsPubEppasswordService wsPubEppasswordService;

    /**
     * 用户信息接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wspubeppasswordList.json", "/wspubeppasswordList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWssupList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsPubEppassword> detailList = wsPubEppasswordService.doGetWsPubEppasswordListByContion(paramMap);
        return  AjaxResult.success("detailList",detailList);
    }

    /**
     * 用户信息数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubeppasswordcount.json", "/wspubeppasswordcount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer detailCount = wsPubEppasswordService.doGetWsPubEppasswordCountByContion(paramMap);
        return AjaxResult.success("统计数量",detailCount);
    }

    /**
     * 用户信息--获取时间段内最大id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubeppasswordMaxId.json", "/wspubeppasswordMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsPubEppasswordService.doGetWsPubEppasswordMaxId(paramMap);
        return AjaxResult.success("maxId",maxId);
    }

    /**
     * 用户信息--获取时间段内最小id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubeppasswordMinId.json", "/wspubeppasswordMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsPubEppasswordService.doGetWsPubEppasswordMinId(paramMap);
        return AjaxResult.success("minId",minId);
    }
}