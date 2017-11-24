/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.drcheck.service.IPubCodeSctypeService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:  cs_pub_code_sctype 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
@Controller
@RequestMapping("/syn/drcheck/syn/server/sctype")
public class PubCodeSctypeController extends BaseController {

    @Autowired
    private IPubCodeSctypeService pubCodeSctypeService;
    
    
    /**
     * 
     * 描述: to选择页面
     * @auther ljx
     * @date 2016年10月26日 
     * @param dptId
     * @return
     * @throws Exception
     */
    @RequestMapping("/toTreePage")
    public ModelAndView toTreePage(String dptId,String deptCode)throws Exception{
    	   ModelAndView view=new ModelAndView("/syn/system/drcheck/sctype/sctypetreeview");
           view.addObject("dptId",dptId);
           view.addObject("deptCode",deptCode);
    	   return view;
    }
    @RequestMapping("/listJSON")
	@ResponseBody
    public AjaxResult toTreeJSON(String deptCode,String items) throws Exception{
    	   Map<String,Object> map=new HashMap<String,Object>();
    	   if(StringUtils.isNotEmpty(items)){
    		   map.put("items",items.split(","));
    	   }
//    	   if(StringUtils.isNotEmpty(deptCode)){
//    		   map.put("deptCode",deptCode);
//    	   }
    	   List<Map<String,Object>> data=pubCodeSctypeService.selectToTreeMap(map);
    	return AjaxResult.success("查询成功",data);
    	
    	
    }
    
    
}