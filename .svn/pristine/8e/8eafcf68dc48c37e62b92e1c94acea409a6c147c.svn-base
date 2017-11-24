/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.controller;

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
import com.icinfo.cs.webservice.model.WsMidSup;
import com.icinfo.cs.webservice.service.IWsMidSupService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:    cs_mid_sup 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
@Controller
@RequestMapping({"/webservice/midsup"})
public class WsMidSupController extends CSBaseController {
	
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidSupController.class);

    @Autowired
    private IWsMidSupService wsMidSupService;
    /**
     * 董事经理人员接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidsupList.json", "wsmidsupList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWssupList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsMidSup> supList = wsMidSupService.doGetWsMidSupListByContion(paramMap);
        return  AjaxResult.success("supList",supList);
    }
    
    /**
     * 统计董事经理人员表数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidsupcount.json", "wsmidsupcount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer supCount = wsMidSupService.doGetWsMidSupCountByContion(paramMap);
        return AjaxResult.success("统计数量",supCount);
    }
    
    /**
     * 董事经理人员接口--获取时间段内最大id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidsupMaxId.json", "wsmidsupMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWssupMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsMidSupService.doGetWsMidSupMaxId(paramMap);
        return  AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 董事经理人员接口--获取时间段内最小id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidsupMinId.json", "wsmidsupMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWssupMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsMidSupService.doGetWsMidSupMinId(paramMap);
        return  AjaxResult.success("minId",minId);
    }
}