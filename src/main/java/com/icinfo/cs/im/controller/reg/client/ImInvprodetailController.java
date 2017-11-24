/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeSet;
import com.icinfo.cs.base.service.ICodeSetService;
import com.icinfo.cs.common.constant.CodeType;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvprodetail;
import com.icinfo.cs.im.model.ImInvupdate;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.cs.im.service.IImInvprodetailService;
import com.icinfo.cs.im.service.IImInvupdateService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_im_invprodetail 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/im/ent/inprodetail/")
public class ImInvprodetailController extends BaseController {
	@Autowired
	private IImInvprodetailService imInvprodetailService;
	@Autowired
	private IImInvestmentService imInvestmentService;
    @Autowired
    private IImInvupdateService imInvupdateService;
    @Autowired
    private ICodeSetService codeSetService;
    
	/**
	 * 认缴json列表 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param request
	 * @param invId
	 * @return
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public AjaxResult   listJSON(PageRequest request, String invId) throws Exception {
		   if(StringUtils.isNotEmpty(invId)){
		    	 invId=AESEUtil.decodeCorpid(invId);
		     } 
		List<ImInvprodetail> data = imInvprodetailService.findByInvIdNoPage(invId);
		for(ImInvprodetail ivp:data){
			if(StringUtils.isNotEmpty(ivp.getSubID())){
			ivp.setSubID(AESEUtil.encodeCorpid(ivp.getSubID()));
			}
		}
		
		return AjaxResult.success("查询成功",data);
	}

	/**
	 * 描述: 认缴修改或添加，变更页面 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月31日
	 * @param subID
	 * @param invID
	 * @param pubFlag
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(String subID, String invID, String pubFlag) throws Exception {
		ModelAndView view = new ModelAndView();
		if (StringUtils.isNotEmpty(subID)) {
			subID=AESEUtil.decodeCorpid(subID);
			ImInvprodetail imInvprodetail = imInvprodetailService.findBySubID(subID);
			view.addObject("imInvprodetail", imInvprodetail);
			if (StringUtils.isNotEmpty(pubFlag)) {
				if (pubFlag.equals("2")) {
					view.setViewName("/reg/client/im/invprodetail/invprodetail_edit");
				} else if (pubFlag.equals("1")) {
					view.setViewName("/reg/client/im/invprodetail/invprodetail_change");
				}

			}
		} else {
			view.setViewName("/reg/client/im/invprodetail/invprodetail_edit");
		}
		 view.addObject("codeList",codeSetService.findCodeByType(CodeType.CODE_TYPE_CONTRIFORM));
		view.addObject("invID", invID);
		return view;

	}

	/**
	 * 
	 * 描述: 变更认缴方法
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param imInvprodetail
	 * @param names
	 * @param changevalues
	 * @param originalValues
	 * @param altDate
	 * @param invID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult change(HttpSession session,@Valid ImInvprodetail imInvprodetail, 
			HttpServletRequest request,BindingResult resu) throws Exception {
		if(resu.hasErrors()){
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<resu.getFieldErrors().size();i++){
				buffer.append(resu.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
	 	    	 error.addErrorInfo(resu.getAllErrors());
	     
	    	 return error;
	     }
		String names=request.getParameter("names"); 
		String changevalues=request.getParameter("changevalues"); 
		String originalValues=request.getParameter("originalValues"); 
	    String nameArray[] = names.split(",");
		String changeArray[] = changevalues.split(",");
		String original[] = originalValues.split(","); 
		String altDate=request.getParameter("altDate"); 
		String invID=request.getParameter("invID"); 
		
		//类别
		List<CodeSet> codeList=codeSetService.findCodeByType(CodeType.CODE_TYPE_CONTRIFORM);
		Map<String,String> codeMap=new HashMap<String,String>();
		for(CodeSet code:codeList){
			codeMap.put(code.getCode(),code.getContent());
		}
		
		if(StringUtils.isNotEmpty(invID)){
			invID=AESEUtil.decodeCorpid(invID);
		}
		 
		int result = 0;
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 if(midBaseInfoDto!=null){
			 imInvprodetail.setInvID(AESEUtil.decodeCorpid(imInvprodetail.getInvID()));
			 if(imInvprodetailService.update(imInvprodetail)>0){
			for(int i=0;i<nameArray.length;i++){
				
				ImInvupdate imInvupdate=new ImInvupdate();
				imInvupdate.setInvID(invID);
				imInvupdate.setPriPID(midBaseInfoDto.getPriPID());
				imInvupdate.setEntName(midBaseInfoDto.getEntName());
				imInvupdate.setRegNO(midBaseInfoDto.getRegNO());
				imInvupdate.setUniCode(midBaseInfoDto.getUniCode()); 
				imInvupdate.setAltDate(DateUtil.stringToDate(altDate, "yyyy-MM-dd"));
				imInvupdate.setCreateTime(new Date());
				imInvupdate.setAltItemContent(nameArray[i]); 
				imInvupdate.setAltBeContent(original[i]);
                if(nameArray[i].equals("出资方式")){
                 imInvupdate.setAltAfContent(codeMap.get(changeArray[i]));
				}else{
				imInvupdate.setAltAfContent(changeArray[i]);
				}
			    result=	imInvupdateService.insert(imInvupdate);
			} 
		}
		 }
		if(result>0){
		return AjaxResult.success("变更成功");
		}else{
			return AjaxResult.error("变更失败");
		}
	}

	/**
	 * 
	 * 描述: 保存，或更新认缴信息
	 * 
	 * @auther ljx
	 * @date 2016年8月28日
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid ImInvprodetail imInvprodetail, BindingResult result,HttpSession session) throws Exception {
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (result.hasErrors()) {
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
	    	 error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (StringUtils.isNotEmpty(imInvprodetail.getSubID())) {
			if(StringUtils.isNotEmpty(imInvprodetail.getInvID())){
				imInvprodetail.setInvID(AESEUtil.decodeCorpid(imInvprodetail.getInvID()));
			}
			imInvprodetailService.update(imInvprodetail);
			return AjaxResult.success("更新成功");

		} else {
			ImInvestment imInvestment = imInvestmentService.findByInvId(AESEUtil.decodeCorpid(imInvprodetail.getInvID()),midBaseInfoDto.getPriPID());
			if (imInvestment != null) {
				imInvprodetail.setInv(imInvestment.getInv());
				imInvprodetail.setInvID(imInvestment.getInvID());
			}
			imInvprodetail.setPubFlag("2");
			imInvprodetailService.insert(imInvprodetail);
			return AjaxResult.success("新增成功");
		}

	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String subID)throws Exception{
		if(StringUtils.isNotEmpty(subID)){
			
			if(imInvprodetailService.delBySubId(AESEUtil.decodeCorpid(subID))>0){
				return  AjaxResult.success("删除成功");
			}else{
				return AjaxResult.error("删除失败");
			}
		}else{
			return AjaxResult.error("未选择");
		}
		
		
	}
	

}