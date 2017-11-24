/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.drcheck.service.IPubScitemResultService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:  cs_pub_scitem_result 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public class PubScitemResultController extends BaseController {

    @Autowired
    private IPubScitemResultService pubScitemResultService;
    /**
     * 
     * 描述: to选择页面
     * @auther ljx
     * @date 2016年10月26日 
     * @param dptId
     * @return
     * @throws Exception
     */
    public ModelAndView toTreePage(String dptId)throws Exception{
    	   ModelAndView view=new ModelAndView("/");
           view.addObject("dptId",dptId);
    	   return view;
    }
    public AjaxResult toTreeJSON() throws Exception{
    	   
    	return AjaxResult.success("查询成功");
    	
    	
    }
    
    
    
    

}