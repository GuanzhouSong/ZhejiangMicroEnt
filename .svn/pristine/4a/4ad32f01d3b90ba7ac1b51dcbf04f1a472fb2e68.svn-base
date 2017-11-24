package com.icinfo.cs.composite.controller.syn;

import java.util.Date;
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
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.YrRegCheckDto;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 农专报表审核流程
 * @author: 赵祥江 
 * @date: 2016年11月29日 上午10:47:10
 * @version: V1.0  
 */
@Controller
@RequestMapping({ "/syn/cominfocheck", "/reg/server/cominfocheck" })
public class ComInfoCheckController extends CSBaseController{
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	/**
	 * 
	 * 描述   进入农专报表审核列表页面
	 * @author 赵祥江
	 * @date 2016年11月29日 上午11:15:11 
	 * @param deptType部门类型:0 农业 1 工商 2 农信
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/comInfoCheckListPage")
	public ModelAndView comInfoCheckListPage(String deptType,HttpSession session) throws Exception{ 
		ModelAndView view  = new ModelAndView("/syn/system/composite/cominfocheck_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认协同
		String sysUrl="/syn";
		//警示
		if("1".equals(sysUser.getUserType())){
			sysUrl="/reg/server";
		}
		view.addObject("sysUrl",sysUrl); 
		view.addObject("deptType", deptType);
		view.addObject("yearList", getYearReport());
		return view;
	}
	
	/**
	 * 
	 * 描述   去除当年年度
	 * @author 赵祥江
	 * @date 2017年1月9日 下午2:44:36 
	 * @param 
	 * @return List<String>
	 * @throws
	 */
	private List<String> getYearReport(){
		List<String> yearList= DateUtil.getYearToNow();
		String year=DateUtil.getYear();
		if(yearList!=null&&yearList.size()>0){
			for(int i=0;i<yearList.size();i++){
				if(year.equals(yearList.get(i))||"2013".equals(yearList.get(i))){
					yearList.remove(i); 
				}
			}
		} 
		return yearList;
	}
	
	/**
	 * 
	 * 描述   进入tab页
	 * @author 赵祥江
	 * @date 2016年11月30日 下午7:06:32 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/sfcassetliaTabEdit")
	public ModelAndView sfcassetliaTabEdit(HttpSession session,String priPID,String year,String deptType,String regNo,String entName) throws Exception{ 
		ModelAndView view  = new ModelAndView("/syn/system/composite/sfcassetlia_tab_edit");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认协同
		String sysUrl="/syn";
		//警示
		if("1".equals(sysUser.getUserType())){
			sysUrl="/reg/server";
		}
		YrRegCheck yrRegCheck=yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.parseInt(year));
		view.addObject("sysUrl", sysUrl);
		view.addObject("deptType", deptType);
		view.addObject("year", year); 
		view.addObject("priPID", priPID); 
		view.addObject("regNo", yrRegCheck==null?"":yrRegCheck.getRegNO()); 
		view.addObject("entName", yrRegCheck==null?"":yrRegCheck.getEntName()); 
		view.addObject("sysUser", sysUser);
		view.addObject("yrRegCheck", yrRegCheck);
		view.addObject("aduitDate", DateUtils.getDate()); 
		return view;
	} 
	
	
	/**
	 * 
	 * 描述   分页查询待审核和待录入意见列表
	 * @author 赵祥江
	 * @date 2016年11月29日 下午2:05:59 
	 * @param 
	 * @return PageResponse<YrRegCheckDto>
	 * @throws
	 */
	@RequestMapping({"/comInfoCheckDtoListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<YrRegCheckDto> comInfoCheckDtoListJSON(PageRequest request)throws Exception{
		 creatDefaultDBAuthEnv(request,"E.checkDep","E.localAdm");
		 Map<String,Object> queryMap= request.getParams(); 
		 //去掉查询参数的左右空格
		 com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		 //queryMap.put("fieldLikeValue","3304%");
  		 request.setParams(queryMap); 
		 List<YrRegCheckDto> yrRegCheckDtoList= yrRegCheckService.comInfoCheckDtoListJSON(request);
	 	 return new PageResponse<YrRegCheckDto>(yrRegCheckDtoList);
	}
	
	
	
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2016年11月30日 下午4:05:59 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/saveCominfocheck", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveCominfocheck(@RequestBody YrRegCheck yrRegCheck,HttpSession session) throws Exception {
 		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
 		YrRegCheck yrRegCheckTem=null;
		if(yrRegCheck!=null){
			 //登录人姓名
			 String realName=sysUser.getRealName();
			 //登录人账号
			 String username=sysUser.getUsername();
			 yrRegCheckTem=new YrRegCheck();
			 //年报年度
			 Integer year=yrRegCheck.getYear();
			 //主体身份代码
			 String priPID=yrRegCheck.getPriPID();
			 //部门类型0 农业 1 工商 2 农信
			 String deptType= yrRegCheck.getReportType();
			 //操作日期
			 Date stateDate=DateUtils.getSysDate(); 
			 if("0".equals(deptType)){
				 //审核意见
				 yrRegCheckTem.setCheckOpinSfc(yrRegCheck.getCheckOpinSfc());
				 //审核状态
				 yrRegCheckTem.setDeclStatus(yrRegCheck.getDeclStatus());
				 //审核人姓名
				 yrRegCheckTem.setSignSfc(realName);
				 //审核人账号
				 yrRegCheckTem.setCheckNameSfc(username);
				 //审核日期
				 yrRegCheckTem.setSignDateSfc(stateDate);
			 }else if("1".equals(deptType)){
				 yrRegCheckTem.setCheckOpinBur(yrRegCheck.getCheckOpinBur());
				 yrRegCheckTem.setSignBur(realName);
				 yrRegCheckTem.setCheckNameBur(username);
				 yrRegCheckTem.setSignDateBur(stateDate);
			 }else if("2".equals(deptType)){
				 yrRegCheckTem.setCheckOpinBank(yrRegCheck.getCheckOpinBank());
				 yrRegCheckTem.setSignBank(realName);
				 yrRegCheckTem.setCheckNameBank(username);
				 yrRegCheckTem.setSignBankDate(stateDate);
			 } 
			 yrRegCheckTem.setYear(year);
			 yrRegCheckTem.setPriPID(priPID);
			 yrRegCheckTem.setCreateTime(stateDate);
		 } 
		if(StringUtil.isNotEmpty(yrRegCheckTem.getYear()+"")&&StringUtil.isNotEmpty(yrRegCheckTem.getPriPID())){//修改
			if (yrRegCheckService.updateYrRegCheckByPriPIdAndYear(yrRegCheckTem)> 0) { 
				return AjaxResult.success("保存成功!");
			}
		}
		return AjaxResult.error("保存失败!");
	}
}
