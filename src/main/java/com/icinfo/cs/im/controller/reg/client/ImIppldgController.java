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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.cs.im.model.ImIppldgalt;
import com.icinfo.cs.im.service.IImIppldgService;
import com.icinfo.cs.im.service.IImIppldgaltService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: 知识产权登记信息 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/im/ent/ippldg/")
public class ImIppldgController extends BaseController {
	@Autowired
	private IImIppldgService imIppldgService;
	@Autowired
	private IImIppldgaltService imIppldgaltService;

	/**
	 * 
	 * 描述: 知识产权登记信息列表页
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/ippldg/ippldg_list");
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;

	}

	/**
	 * 
	 * 描述: 知识产权登记信息列表json数据
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public AjaxResult  listJSON(PageRequest request, HttpSession session) throws Exception {
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 String priPID=null;
		 List<ImIppldg> data=null;
		 if(midBaseInfoDto!=null){
		   priPID=midBaseInfoDto.getPriPID();
		   data = imIppldgService.quryPage(request, priPID);
			for(ImIppldg ipp:data){
				ipp.setPleID(AESEUtil.encodeCorpid(ipp.getPleID()));
			}
		 }
		  
		return AjaxResult.success("查询成功",data);

	}

	/**
	 * 
	 * 描述: 知识产权登记信息修改或新增页面
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param session
	 * @param pleID
	 * @param pubFlag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(HttpSession session, String pleID, String pubFlag) throws Exception {
		ModelAndView view = new ModelAndView();
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto"); 
		if (StringUtils.isNotEmpty(pleID)) {
			pleID=AESEUtil.decodeCorpid(pleID);//解密
			ImIppldg imIppldg = imIppldgService.findByPleId(pleID,midBaseInfoDto.getPriPID());
			view.addObject("imIppldg", imIppldg);
			if (StringUtils.isNotEmpty(pubFlag)) {
				if (pubFlag.equals("1")) {
					Map<String,String> map=new HashMap<String,String>();
					 map.put("1", "商标");
					 map.put("2","版权");
					 map.put("3","专利"); 
				     view.addObject("map",map);
				     map.remove(imIppldg.getKinds());
					view.setViewName("/reg/client/im/ippldg/ippldg_change");
				} else {
					Map<String,String> map=new HashMap<String,String>();
					 map.put("1", "商标");
					 map.put("2","版权");
					 map.put("3","专利"); 
				     view.addObject("map",map);
				     map.remove(imIppldg.getKinds());
				     
					view.setViewName("/reg/client/im/ippldg/ippldg_edit");
				}
			}
		} else {
			Map<String,String> map=new HashMap<String,String>();
			 map.put("1", "商标");
			 map.put("2","版权");
			 map.put("3","专利"); 
		     view.addObject("map",map);
			view.setViewName("/reg/client/im/ippldg/ippldg_edit");
		}
		
			view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;
	}

	/**
	 * 
	 * 描述: 保存,或更新 知识产权登记信息
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param imIppldg
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid ImIppldg imIppldg, BindingResult result,HttpSession session) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (StringUtils.isNotEmpty(imIppldg.getPleID())) {
			
			if (imIppldgService.update(imIppldg) > 0) {
				return AjaxResult.success("更新成功");
			} else {
				return AjaxResult.error("更新失败");
			}
		} else {
			imIppldg.setPubFlag("2");
			if (imIppldgService.insert(imIppldg) > 0) {
				return AjaxResult.success("新增成功");
			} else {
				return AjaxResult.error("新增失败");
			}
		}

	}

	/**
	 * 
	 * 描述: 知识产权登记信息变更
	 * 
	 * @auther ljx
	 * @date 2016年9月8日
	 * @param imIppldg
	 * @param names
	 * @param changevalues
	 * @param originalValues
	 * @param altDate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult change(HttpSession session,HttpServletRequest request, @Valid ImIppldg imIppldg, BindingResult resu)
			throws Exception { 
		if (resu.hasErrors()) {
			// 参数验证错误
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
		int result = 0;
		imIppldg.setPubType("1");
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 Map<String,String> map=new HashMap<String,String>();
		 map.put("1", "商标");
		 map.put("2","版权");
		 map.put("3","专利"); 
	   
		 if(midBaseInfoDto!=null){
			 imIppldg.setPriPID(midBaseInfoDto.getPriPID());
		if (imIppldgService.update(imIppldg) > 0) {
			for (int i = 0; i < nameArray.length; i++) {
				
				ImIppldgalt imIppldgalt = new ImIppldgalt();
				imIppldgalt.setPleID(imIppldg.getPleID());
				imIppldgalt.setCreateTime(new Date());
				imIppldgalt.setAltDate(DateUtil.stringToDate(altDate, "yyyy-MM-dd"));
				if(nameArray[i].equals("种类")){
					imIppldgalt.setAltAfContent(map.get(changeArray[i]));
				}else{
				imIppldgalt.setAltAfContent(changeArray[i]);
				}
				imIppldgalt.setAltBeContent(original[i]);
				imIppldgalt.setAltItemContent(nameArray[i]);
				result = imIppldgaltService.insert(imIppldgalt);
			}
		}
		if (result > 0) {
			return AjaxResult.success("变更成功");
		} else {
			return AjaxResult.error("变更失败");
		}
		 }else{
			 return AjaxResult.error("未登录");
		 }
	}
	/**
	 * 
	 * 描述: 注销
	 * @auther ljx
	 * @date 2016年9月11日 
	 * @param imIppldg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/beCancle")
    @ResponseBody
     public AjaxResult cancle(HttpSession session, @RequestBody @Valid  ImIppldg imIppldg ,BindingResult result) throws Exception{
		if (result.hasErrors()) {
			// 参数验证错误
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}  
		
		imIppldg.setPubType("2"); 
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 if(midBaseInfoDto!=null){
			 imIppldg.setPriPID(midBaseInfoDto.getPriPID());
		if(imIppldgService.update(imIppldg) > 0){
			 return AjaxResult.success("注销成功");
		 }else{
			 return AjaxResult.error("注销失败");
		 }  
		 }else{
			 return AjaxResult.error("未登录");
		 }
	}
	/**
	 * 
	 * 描述: 其他无效原因
	 * @auther ljx
	 * @date 2016年9月11日 
	 * @param imIppldg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/invalidReason")
    @ResponseBody
	public AjaxResult invalidReason(HttpSession session,  @RequestBody @Valid  ImIppldg imIppldg ,BindingResult result)throws Exception{
		if (result.hasErrors()) {
			// 参数验证错误
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}  
		
	    MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 if(midBaseInfoDto!=null){
			 imIppldg.setPubType("3");
			 imIppldg.setPriPID(midBaseInfoDto.getPriPID());
	    if(imIppldgService.update(imIppldg)>0){
			return AjaxResult.success("操作成功");
		}else{
			return AjaxResult.error("操作失败");
		}
		 }else{
			 return AjaxResult.error("未登录");
		 }
	}
	
	/**
	 * 
	 * 描述: 公示方法
	 * @auther ljx
	 * @date 2016年9月11日 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pubAll")
    @ResponseBody
    public AjaxResult pubAll(HttpSession session)throws Exception{
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		 String priPID=null;
		 if(midBaseInfoDto!=null){
		   priPID=midBaseInfoDto.getPriPID();
		   if(imIppldgService.pubAll(priPID)>0){
				return AjaxResult.success("公示成功");
			}else{
				return AjaxResult.error("已全部公示");
			}
		 }else{
			 return AjaxResult.error("未登录");
		 }
		
		
	}
	
	
	
    /**
     * 
     * 描述: 删除方法
     * @auther ljx
     * @date 2016年9月8日 
     * @param pleID
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/delete")
    @ResponseBody
	public AjaxResult delete(String pleID,HttpSession session) throws Exception {
		String priPID=null;
		if (StringUtils.isNotEmpty(pleID)) {
	      MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			 if(midBaseInfoDto!=null){
				  priPID=midBaseInfoDto.getPriPID();
			 
			int result = imIppldgService.deleteByPleID(AESEUtil.decodeCorpid(pleID),priPID);
			if (result > 0) {
				return AjaxResult.success("删除成功");
			} else {
				return AjaxResult.error("删除失败");
			}
			 }else{
				 return AjaxResult.error("未登录");
			 }
		}else{
			return AjaxResult.error("未选择信息");
		}

	}
   /**
    * 
    * 描述: 打印
    * @auther ljx
    * @date 2016年11月15日 
    * @param session
    * @param request
    * @return
    * @throws Exception
    */
	@RequestMapping(value="/print",method=RequestMethod.GET)
	public ModelAndView print(HttpSession session,PageRequest request)throws Exception{
		ModelAndView view=new ModelAndView("reg/client/im/ippldg/ippldg_print");
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID=null;
		List<ImIppldg> data=null;
        if(midBaseInfoDto!=null){
        	priPID=midBaseInfoDto.getPriPID();
        	data=imIppldgService.quryPage(request, priPID);
        }
        view.addObject("ippldgList",data);
		return view;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}