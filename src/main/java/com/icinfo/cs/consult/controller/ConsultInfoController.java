/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.consult.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.consult.dto.ConsultInfoDto;
import com.icinfo.cs.consult.model.ConsultInfo;
import com.icinfo.cs.consult.service.IConsultInfoService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_consult_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年10月12日
 */
@Controller
@RequestMapping({ "/reg/client/yr/ent/consult", "/reg/server/consult" })
public class ConsultInfoController extends CSBaseController {
	@Autowired
	private IConsultInfoService consultInfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	
	/**
	 * 
	 * 描述   跳转到咨询列表页面
	 * @author 赵祥江
	 * @date 2017年10月12日 上午10:52:12 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toClientConsultListPage")
	public ModelAndView toClientConsultListPage(HttpSession session) throws Exception{
		MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		ModelAndView view  = new ModelAndView("/reg/client/yr/consult/consult_list"); 
		//协同 
		view.addObject("pripid", midBaseInfoDto.getPriPID());
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		return view;
	}
	
	/**
	 * 
	 * 描述   工商端反馈页面
	 * @author 赵祥江
	 * @date 2017年10月12日 上午11:03:22 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toServerConsultListPage")
	public ModelAndView toServerConsultListPage(HttpSession session) throws Exception{ 
		ModelAndView view  = new ModelAndView("/reg/server/consult/consult_list"); 
		return view;
	}
	
	
	
	/**
	 * 
	 * 描述   客户端保存和修改
	 * @author 赵祥江
	 * @date 2017年10月12日 上午10:10:15 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitClientConsultInfo", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitClientConsultInfo(@RequestBody ConsultInfo consultInfo,HttpSession session) throws Exception {
		 try {
			 //咨询日期
			consultInfo.setConsultTime(DateUtil.getSysDate());  
			 //修改
			if(consultInfo!=null&&StringUtil.isNotBlank(consultInfo.getUid())){  
				consultInfoService.updateConsultInfo(consultInfo); 
				return	AjaxResult.success("修改成功!");
			}else{//新增
				MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
				consultInfo.setPriPID(midBaseInfoDto.getPriPID());
				consultInfo.setEntName(midBaseInfoDto.getEntName());
				consultInfo.setRegNO(midBaseInfoDto.getRegNO());
				consultInfo.setUniSCID(midBaseInfoDto.getUniCode());
				consultInfo.setRegOrg(midBaseInfoDto.getRegOrg());
				consultInfo.setLocalAdm(midBaseInfoDto.getLocalAdm()); 
				consultInfo.setState("0");
				consultInfoService.insertConsultInfo(consultInfo);
				return	AjaxResult.success("新增成功!");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("操作失败!");
	}
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年10月12日 下午2:31:36 
	 * @param 
	 * @return PageResponse<ConsultInfoDto>
	 * @throws
	 */
	@RequestMapping({"/selectConsultInfoDtoSearchListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<ConsultInfoDto> selectConsultInfoDtoSearchListJSON(PageRequest request,HttpSession session)throws Exception{
		Map<String,Object> queryMap=getRequestParam(request);
		//searchFlag 1 企业端 2 工商端
		if(queryMap.containsKey("searchFlag")&&"2".equals(queryMap.get("searchFlag").toString())){
			//权限
			creatOptDBAuthEnv(request,"A.regOrg","A.localAdm");
		} 
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap); 
		List<ConsultInfoDto>  consultInfoDtoList=consultInfoService.queryConsultInfoListJSON(request);
		return new PageResponse<ConsultInfoDto>(consultInfoDtoList);
	}
	
	
	/**
	 * 
	 * 描述   工商端咨询反馈
	 * @author 赵祥江
	 * @date 2017年10月12日 上午11:11:41 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitServerConsultInfo", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitServerConsultInfo(@RequestBody ConsultInfo consultInfo,HttpSession session) throws Exception {
		 try { 
			ConsultInfo backConsultInfo=new ConsultInfo();
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			//反馈日期
			backConsultInfo.setBackTime(DateUtil.getSysDate());
			//反馈部门编码
			backConsultInfo.setBackDeptCode(sysUser.getDepartMent().getDeptDID());
			backConsultInfo.setBackDept(sysUser.getDepartMent().getDeptName());
			//反馈日期
			backConsultInfo.setBackTime(DateUtil.getSysDate());
			//主键ID
			backConsultInfo.setUid(consultInfo.getUid());
			//反馈内容
			backConsultInfo.setBackContent(consultInfo.getBackContent());
			//反馈人姓名
			backConsultInfo.setBackName(sysUser.getRealName());
			//反馈状态
			backConsultInfo.setState("1");
			 //修改
			if(backConsultInfo!=null&&StringUtil.isNotBlank(backConsultInfo.getUid())){  
				consultInfoService.updateConsultInfo(backConsultInfo); 
				return	AjaxResult.success("操作成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("操作失败!");
	}
	
	/**
	 * 
	 * 描述   进入咨询页面
	 * @author 赵祥江
	 * @date 2017年10月12日 上午11:24:49 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toClientConsultEditPage")
	public ModelAndView Client(HttpSession session,String uid,String flag) throws Exception{ 
		ModelAndView view  = new ModelAndView("/reg/client/yr/consult/consult_edit"); 
		if(StringUtil.isBlank(uid)){//
			MidBaseInfoDto midBaseInfoDto= (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			view.addObject("midBaseInfoDto", midBaseInfoDto); 
			
		}else{
			ConsultInfo consultInfo =consultInfoService.selectConsultInfoByUid(uid);
			view.addObject("consultInfo", consultInfo);
		} 
		//但当前时间
		view.addObject("nowDate", DateUtil.formatDate(DateUtil.getSysDate(),null));
		view.addObject("flag",flag); 
		return view;
	}
	
	
	/**
	 * 
	 * 描述   进入反馈页面
	 * @author 赵祥江
	 * @date 2017年10月12日 上午11:24:49 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toServerConsultEditPage")
	public ModelAndView toServerConsultEditPage(HttpSession session,String uid,String flag) throws Exception{ 
		ModelAndView view  = new ModelAndView("/reg/server/consult/consult_edit"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ConsultInfo consultInfo =consultInfoService.selectConsultInfoByUid(uid);
		List<MidBaseInfoDto> midBaseInfoDtoList= midBaseInfoService.doGetListByPriPID(consultInfo.getPriPID());
		MidBaseInfoDto midBaseInfoDto=null;
		if(midBaseInfoDtoList!=null&&midBaseInfoDtoList.size()>0){
			midBaseInfoDto=midBaseInfoDtoList.get(0);
		}
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("consultInfo", consultInfo);
		view.addObject("sysUser", sysUser);
		view.addObject("deptName", sysUser.getDepartMent().getDeptName());
		view.addObject("flag", flag);
		//但当前时间
		view.addObject("nowDate", DateUtil.formatDate(DateUtil.getSysDate(), "yyyy-MM-dd"));
		return view;
	}
	
	
	/**
	 * 
	 * 描述   删除
	 * @author 赵祥江
	 * @date 2017年10月12日 上午10:05:36 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult delete(String uid) throws Exception{
		if (StringUtil.isNotBlank(uid)) {
			if(consultInfoService.deleteConsultInfoByUid(uid)>0){
				return AjaxResult.success("删除成功");
			}  
		}
		return  AjaxResult.error("删除失败");
	}
}