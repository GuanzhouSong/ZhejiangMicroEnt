/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.drcheck.dto.PubDeptScitemDto;
import com.icinfo.cs.drcheck.service.IPubDeptScitemService;
import com.icinfo.cs.drcheck.service.IPubScitemService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:  cs_pub_scitem 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Controller
@RequestMapping("/syn/drcheck/syn/server/scitem")
public class PubScitemController extends BaseController {

    @Autowired
    private IPubScitemService pubScitemService;
    @Autowired
    private IPubDeptScitemService deptScitemService;

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
    public ModelAndView toTreePage(String dptId)throws Exception{
    	   ModelAndView view=new ModelAndView("/syn/system/drcheck/scitem/scitemTreeView");
           view.addObject("dptId",dptId);
    	   return view;
    }
    
    /**
     * 
     * 描述: to选择页面
     * @auther ljx
     * @date 2016年10月26日 
     * @param dptId
     * @return
     * @throws Exception
     */
    @RequestMapping("/listJSON")
	@ResponseBody
    public AjaxResult toTreeJSON(String deptCode) throws Exception{
    	   List<Map<String,Object>> data=deptScitemService.selectToTreeMap(deptCode);
    	return AjaxResult.success("查询成功",data);
    	
    	
    }
    
    /**
     * 描述：修改实施部门检查科目
     * @author chenxin
     * @date 2016-11-15
     * @param pubDeptScitemDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveDeptScitem")
	@ResponseBody
    public AjaxResult saveDeptScitem(PubDeptScitemDto pubDeptScitemDto)throws Exception{
    	deptScitemService.saveDeptScitem(pubDeptScitemDto);
    	return AjaxResult.success("修改成功");
    }

}