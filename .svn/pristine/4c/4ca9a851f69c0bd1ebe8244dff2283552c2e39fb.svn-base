/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.cs.im.service.IImCasaltService;
import com.icinfo.cs.im.service.IImCaseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 
 * 描述: 行政处罚变更信息<br>
 * @author ljx
 * @date 2016年9月9日
 */
@Controller
@RequestMapping("/reg/client/im/ent/casalt/")
public class ImCasaltController extends BaseController { 
    @Autowired
    private IImCasaltService imCasaltService;
    @Autowired
    private IImCaseService imCaseService;
    /**
     * 
     * 描述: 查询行政处罚变更信息
     * @auther ljx
     * @date 2016年9月9日 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/list.json" })
	@ResponseBody
	public AjaxResult listJSON(PageRequest request,String caseNO)throws Exception{
		 
		List<ImCasalt> data=imCasaltService.queryPageByCaseNO(request, caseNO);
		 
        return AjaxResult.success("查询成功",data);   				
	}
    /**
     * 
     * 描述: 保存变更信息
     * @auther ljx
     * @date 2016年9月9日 
     * @param imCasalt
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
   	@ResponseBody
    public AjaxResult save(@Valid ImCasalt imCasalt,BindingResult result)throws Exception{
    	 if(result.hasErrors()){
    		 StringBuffer buffer=new StringBuffer();
 			for(int i=0;i<result.getFieldErrors().size();i++){
 				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
 			}
 			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
	    	 error.addErrorInfo(result.getAllErrors());
	    	  return error;
    	 }
    	ImCase imCase=new ImCase();
    	imCase.setCaseNO(imCasalt.getCaseNO());
    	imCase.setJudAuth(imCasalt.getPenAuthName());
    	imCase.setPubType("1");
    	 if(imCaseService.update(imCase)>0){
    	 
    	if(imCasaltService.insert(imCasalt)>0){
    		return AjaxResult.success("保存成功");
    	}else{
    		return AjaxResult.error("保存失败");
    	}
    	 }else{
    		 return AjaxResult.error("保存失败");
    	 }
    }
    
    
    
    
	
}