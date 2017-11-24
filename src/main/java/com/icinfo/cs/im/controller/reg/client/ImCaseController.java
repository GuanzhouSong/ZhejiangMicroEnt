/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeSetService;
import com.icinfo.cs.common.constant.CodeType;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.cs.im.service.IImCaseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: 行政处罚信息 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/im/ent/case/")
public class ImCaseController extends BaseController {
	@Autowired
	private IImCaseService imCaseService;
    @Autowired
    private ICodeSetService codeService;
   
	/**
	 * 
	 * 描述: 行政处罚信息列表
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/case/case_list");
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;
	}

	/**
	 * 
	 * 描述: 行政处罚信息json数据
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json" })
	@ResponseBody
	public AjaxResult  listJSON(PageRequest request, HttpSession session) throws Exception {
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 List<ImCase> data = null ;
		 String priPID=null;
		 if(midBaseInfoDto!=null){
		   priPID=midBaseInfoDto.getPriPID();
		   data = imCaseService.quryPage(request, priPID);
		   for(ImCase imCase:data){
				imCase.setCaseNO(AESEUtil.encodeCorpid(imCase.getCaseNO()));//加密
			}
		 } 
		
		return   AjaxResult.success("查询成功",data);
	}
    /**
     * 行政处罚信息修改或添加
     * 描述: TODO
     * @auther ljx
     * @date 2016年9月8日 
     * @param session
     * @param caseNO
     * @param pubFlag
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(HttpSession session, String caseNO, String pubFlag) throws Exception {
		ModelAndView view = new ModelAndView();
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		   view.addObject("midBaseInfoDto", midBaseInfoDto);
		if (StringUtils.isNotEmpty(caseNO)) {
			caseNO=AESEUtil.decodeCorpid(caseNO);
			ImCase imCase = imCaseService.findByCaseNO(caseNO,midBaseInfoDto.getPriPID());
			view.addObject("imCase", imCase); 
            Map<String,Object> map=new HashMap<String,Object>();
            for(String str:imCase.getPenType().split(",")){
            	map.put(str, str);
            }
			view.addObject("penType",map);
			if (StringUtils.isNotEmpty(pubFlag)) {
				if (pubFlag.equals(Constants.PUB_FLG_Y)) {
					view.addObject("caseNO", caseNO);
					view.setViewName("/reg/client/im/case/case_change");
				} else {
					view.setViewName("/reg/client/im/case/case_edit");
				}
			}
		} else {
			view.setViewName("/reg/client/im/case/case_edit");
		}
		
       view.addObject("codeList",codeService.findCodeByType(CodeType.CODE_TYPE_PENTYPE));
      
		return view;

	}
	/**
	 * 
	 * 描述: 保存或更新许可信息
	 * @auther ljx
	 * @date 2016年9月8日 
	 * @param imCase
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid ImCase imCase,BindingResult result)throws Exception{
		 
		if(result.hasErrors()){ //参数错误
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			
			
			AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1)+"】为敏感词!");
	    	
	    	 error.addErrorInfo(result.getAllErrors()); 
	    	 return error;
	     }
		 if(StringUtils.isNotEmpty(imCase.getCaseNO())){
			 if(imCaseService.update(imCase)>0){
				 return AjaxResult.success("更新成功");
			 }else{
				 return AjaxResult.error("更新失败");
			 }
		 }else{
			 imCase.setPubFlag(Constants.PUB_FLG_N);
			 if(imCaseService.insert(imCase)>0){
				 return AjaxResult.success("新增成功");
			 }else{
				 return AjaxResult.error("新增失败");
			 }
		 }
		
		
	}
	/**
	 * 
	 * 描述: 删除行政处罚信息
	 * @auther ljx
	 * @date 2016年9月8日 
	 * @param caseNO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
    @ResponseBody
	public AjaxResult delete(String caseNO,HttpSession session)throws Exception{
		String priPID=null;
		if(StringUtils.isNotEmpty(caseNO)){
			 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			 
			 if(midBaseInfoDto!=null){
				   priPID=midBaseInfoDto.getPriPID();
					int result=imCaseService.deleteByCaseNO(AESEUtil.decodeCorpid(caseNO),priPID);
					if(result>0){
						return AjaxResult.success("删除成功");
					}else{
						return AjaxResult.error("删除失败");
			   }
			 }else{
				 return AjaxResult.error("请登录再操作");
			 }
			 
		
		}else{
			return AjaxResult.error("未选择删除信息");
		}
		
	}
	@RequestMapping("/pubAll")
	@ResponseBody
	public AjaxResult pubAll(HttpSession session)throws Exception{
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID = null;
		if (midBaseInfoDto != null) {
			priPID =  midBaseInfoDto.getPriPID();
		}
		imCaseService.pubAllImCase(priPID);
		return AjaxResult.success("公示成功");

	}

	/**
	 * 描述：行政处罚信息打印
	 * @author ZhuDefeng
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/print",method=RequestMethod.GET)
	public ModelAndView print(HttpSession session) throws Exception{
		ModelAndView view=new ModelAndView("reg/client/im/case/case_print");
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		List<ImCase> imCaseList =new ArrayList<ImCase>();
		String priPID = null;
		if (midBaseInfoDto != null) {
			priPID =  midBaseInfoDto.getPriPID();
			 imCaseList = imCaseService.quryPage(null, priPID);
		}
	
		view.addObject("imCaseList",imCaseList);
		return view;
	}



}