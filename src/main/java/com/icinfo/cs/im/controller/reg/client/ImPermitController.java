/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.controller.reg.client;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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
import com.icinfo.cs.im.model.ImPermit;
import com.icinfo.cs.im.model.ImPrmtalt;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.im.service.IImPrmtaltService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: 即时信息——行政许可 对应的Controller类.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/im/ent/permit/")
public class ImPermitController extends BaseController {
	@Autowired
	private IImPermitService imPermitService;
	@Autowired
	private IImPrmtaltService imPrmtaltService;

	/**
	 * 
	 * 描述: 即时信息——行政许可列表页
	 * 
	 * @auther ljx
	 * @date 2016年8月28日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/client/im/permit/permit_list");
		// view.addObject("map",session.getAttribute("sessionMap"));
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");

		view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;
	}

	/**
	 * 描述: 即时信息——行政许可列表json数据 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月28日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public AjaxResult listJSON(PageRequest request, HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID = null;
		List<ImPermit> data = null;
		if (midBaseInfoDto != null) {
			priPID = midBaseInfoDto.getPriPID();
			data = imPermitService.queryPage(request, priPID);
			for (ImPermit imPer : data) {
				imPer.setLicID(AESEUtil.encodeCorpid(imPer.getLicID()));
			}
		}

		return AjaxResult.success("查询成功", data);
	} 
	 
	/**
	 * 描述: 即时信息——行政许可信息修改或添加页面 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月31日
	 * @param session
	 * @param id
	 * @param pubFlag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(HttpSession session, String id, String pubFlag) throws Exception {
		ModelAndView view = new ModelAndView();
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (StringUtils.isNotEmpty(id)) {
			id = AESEUtil.decodeCorpid(id);// 解密
			ImPermit mPermit = imPermitService.selectByLicId(id,midBaseInfoDto.getPriPID());
			view.addObject("mPermit", mPermit);
			if (StringUtils.isNotEmpty(pubFlag)) {
				if (pubFlag.equals("2")) {
					view.setViewName("/reg/client/im/permit/permit_edit");
				} else if (pubFlag.equals("1")) {
					view.setViewName("/reg/client/im/permit/permit_change");
				}
			}

		} else {
			view.setViewName("/reg/client/im/permit/permit_edit");
		} 

		view.addObject("midBaseInfoDto", midBaseInfoDto);

		return view;

	}

	/**
	 * 公示后变更方法 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param mPermit
	 * @param names
	 * @param changevalues
	 * @param originalValues
	 * @param altDate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult change(HttpSession session, HttpServletRequest request, @Valid ImPermit mPermit,  BindingResult resu) throws Exception {
		if (resu.hasErrors()) {
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
		mPermit.setPubType("1");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (midBaseInfoDto != null) {
			mPermit.setPriPID(midBaseInfoDto.getPriPID());
			if (imPermitService.update(mPermit) > 0) {
			 for (int i = 0; i < nameArray.length; i++) {
					ImPrmtalt imPrmtalt = new ImPrmtalt();
					imPrmtalt.setAltItemContent(nameArray[i]);
					imPrmtalt.setAltBeContent(original[i]);
					imPrmtalt.setAltAfContent(changeArray[i]);
					imPrmtalt.setLicID(mPermit.getLicID());
					imPrmtalt.setCreateTime(new Date());
					imPrmtalt.setAltDate(DateUtil.stringToDate(altDate, "yyyy-MM-dd"));

					result = imPrmtaltService.insert(imPrmtalt);
				} 
			}
			if (result > 0) {
				return AjaxResult.success("变更成功");
			} else {
				return AjaxResult.error("变更失败");
			}
		} else {
			return AjaxResult.error("未登录");
		}
	}

	/**
	 * 注销， 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param mPermit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/beCancle")
	@ResponseBody
	public AjaxResult Cancle(HttpSession session,@RequestBody @Valid ImPermit mPermit,BindingResult result) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
			return error;
		} 
		
		mPermit.setPubType("2");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (midBaseInfoDto != null) {
			mPermit.setPriPID(midBaseInfoDto.getPriPID());
			if (imPermitService.update(mPermit) > 0) {
				return AjaxResult.success("注销成功");
			} else {
				return AjaxResult.error("操作失败");
			}
		} else {
			return AjaxResult.error("未登录");
		}

	}

	/**
	 * 
	 * 描述: 被注销
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param mPermit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/beRevoked")
	@ResponseBody
	public AjaxResult beRevoked(HttpSession session, @RequestBody @Valid ImPermit mPermit,BindingResult result)
			throws Exception {  
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
		mPermit.setPubType("3");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		if (midBaseInfoDto != null) {
			mPermit.setPriPID(midBaseInfoDto.getPriPID());
			if (imPermitService.update(mPermit) > 0) {
				return AjaxResult.success("被吊销成功");
			} else {
				return AjaxResult.error("操作失败");
			}
		}else{
			return AjaxResult.error("未登录");
		}
	}

	/**
	 * 
	 * 描述: 其他无效原因
	 * 
	 * @auther ljx
	 * @date 2016年8月30日
	 * @param mPermit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/invalidReason")
	@ResponseBody
	public AjaxResult invalidReason(HttpSession session, @RequestBody @Valid ImPermit mPermit,BindingResult result) throws Exception {
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
		mPermit.setPubType("4");
		 MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
	     if(midBaseInfoDto!=null){
	    	 mPermit.setPriPID(midBaseInfoDto.getPriPID());
		 if (imPermitService.update(mPermit) > 0) {
			return AjaxResult.success("操作成功");
		} else {
			return AjaxResult.error("操作失败");
		}
	   }else{
		   return AjaxResult.error("未登录");
	   }
	}

	/**
	 * 
	 * 描述: 保存，或更新许可信息
	 * 
	 * @auther ljx
	 * @date 2016年8月28日
	 * @param mPermit
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid ImPermit mPermit,BindingResult result) throws Exception {

		if (result.hasErrors()) {
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<result.getFieldErrors().size();i++){
				buffer.append(result.getFieldErrors().get(i).getRejectedValue()).append(",");
			}
			 AjaxResult error = AjaxResult.error("输入的内容【"+buffer.substring(0,buffer.length()-1).toString()+"】为敏感词!");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		if (StringUtils.isNotEmpty(mPermit.getLicID())) {
			if (imPermitService.update(mPermit) > 0) {
				return AjaxResult.success("更新成功");
			} else {
				return AjaxResult.error("更新失败");
			}
		} else {
			if (imPermitService.insert(mPermit) > 0) {
				return AjaxResult.success("新增成功");
			} else {
				return AjaxResult.error("新增失败");
			}
		}

	}

	/**
	 * 删除行政许可信息 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年8月28日
	 * @param licid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public AjaxResult delete(String licId, HttpSession session) throws Exception {
		String priPID = null;
		if (StringUtils.isNotEmpty(licId)) {
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			if (midBaseInfoDto != null) {
				priPID = midBaseInfoDto.getPriPID();
				int result = imPermitService.deleteByLicId(AESEUtil.decodeCorpid(licId), priPID);
				if (result > 0) {
					return AjaxResult.success("删除许可信息成功");
				} else {
					if (result == -1) {
						return AjaxResult.error("-1", "已经公示不能删除");
					}
				}
			}

		}
		return AjaxResult.error("未选择许可信息");

	}

	/**
	 * 
	 * 描述: 公示
	 * 
	 * @auther ljx
	 * @date 2016年9月10日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/pubAll")
	@ResponseBody
	public AjaxResult pubAll(HttpSession session) throws Exception {
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID = null;
		if (midBaseInfoDto != null) {
			priPID = midBaseInfoDto.getPriPID();
		}
		int result = imPermitService.pubAll(priPID);
		if (result == 0) {
			return AjaxResult.success("已全部公示");
		} else if (result > 0) {
			return AjaxResult.success("公示成功");
		} else {
			return AjaxResult.error("公示失败");
		}

	}
	/**
	 * 
	 * 描述: TODO
	 * @auther ljx
	 * @date 2016年11月15日 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/print",method=RequestMethod.GET)
	public ModelAndView print(HttpSession session,PageRequest request)throws Exception{
		ModelAndView view=new ModelAndView("reg/client/im/permit/permit_print");
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String priPID=null;
		List<ImPermit> data = null;
		if (midBaseInfoDto != null) {
			priPID =  midBaseInfoDto.getPriPID();
		    data=imPermitService.queryPage(request, priPID);
		}
		view.addObject("perMitList", data);
		return view;
		
	}
	
	
	
	
	
	
	

}