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
import com.icinfo.cs.webservice.model.WsPubOpadetail;
import com.icinfo.cs.webservice.service.IWsPubOpadetailService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:    cs_pub_opadetail 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
@Controller
@RequestMapping({"/webservice/pubopadetail"})
public class WsPubOpadetailController extends CSBaseController{
	
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsPubOpadetailController.class);

    @Autowired
    private IWsPubOpadetailService wsPubOpadetailService;
    /**
     * 列入经营异常名录接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wspubopadetailList.json", "wspubopadetailList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWssupList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsPubOpadetail> detailList = wsPubOpadetailService.doGetWsPubOpadetailListByContion(paramMap);
        return  AjaxResult.success("detailList",detailList);
    }
    
    /**
     * 列入经营异常名录数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubopadetailcount.json", "wspubopadetailcount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer detailCount = wsPubOpadetailService.doGetWsPubOpadetailCountByContion(paramMap);
        return AjaxResult.success("统计数量",detailCount);
    }
    
    /**
     * 列入经营异常名录--获取时间段内最大id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubopadetailMaxId.json", "wspubopadetailMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsPubOpadetailService.doGetWsPubOpadetailMaxId(paramMap);
        return AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 列入经营异常名录--获取时间段内最小id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubopadetailMinId.json", "wspubopadetailMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsPubOpadetailService.doGetWsPubOpadetailMinId(paramMap);
        return AjaxResult.success("minId",minId);
    }
}