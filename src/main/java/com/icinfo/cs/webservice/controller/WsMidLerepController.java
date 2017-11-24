/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.webservice.model.WsMidBaseInfo;
import com.icinfo.cs.webservice.model.WsMidLerep;
import com.icinfo.cs.webservice.service.IWsMidLerepService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_lerep 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月16日
 */
@Controller
@RequestMapping({"/webservice/midlerep"})
public class WsMidLerepController extends CSBaseController {
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidLerepController.class);

    @Autowired
    private IWsMidLerepService wsMidLerepService;

    /**
     * 法定代表人接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidlerepList.json", "wsmidlerepList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsLerepList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsMidLerep> lerepList = wsMidLerepService.doGetWsMidLerepListByContion(paramMap);
        return  AjaxResult.success("lerepList",lerepList);
    }
    
    /**
     * 统计法定代表人表数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidlerepcount.json", "wsmidlerepcount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsLerepCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer lerepCount = wsMidLerepService.doGetWsMidLerepCountByContion(paramMap);
        return AjaxResult.success("统计数量",lerepCount);
    }
    
    /**
     * 法定代表人接口--获取时间段内最大id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidlerepMaxId.json", "wsmidlerepMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsLerepMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsMidLerepService.doGetWsMidLerepMaxId(paramMap);
        return  AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 法定代表人接口--获取时间段内最小id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidlerepMinId.json", "wsmidlerepMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsLerepMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsMidLerepService.doGetWsMidLerepMinId(paramMap);
        return  AjaxResult.success("minId",minId);
    }
}