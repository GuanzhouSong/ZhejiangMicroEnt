/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.syn.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    er_esc_appinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller("ServerErEscAppinfoController")
@RequestMapping("/syn/erescappinfo")
public class ErEscAppinfoController extends CSBaseController { 
	@Autowired
	private IErEscAppinfoService erEscAppinfoService; 
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;
	//外资企业类型编码
	private final String entTypeCatg="21,22,23,24,25,26,27,28";
	
 	 
	
	/**
	 * 
	 * 描述   进入公告查询页面
	 * @author 赵祥江
	 * @date 2017年2月21日 下午5:00:00 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/erescappinfoListPage")
	public ModelAndView erescappinfoListPage(HttpSession session) throws Exception{
		ModelAndView view =new ModelAndView("/syn/system/simpleesc/erescappinfo_list");
		view.addObject("sysUrl", "/syn"); 
		return view;
	}
	
	
	/**
	 * 
	 * 描述   分页查询简易注销结果列表  如果是 商务部只能查询外资
	 * @author 赵祥江
	 * @date 2017年2月21日 下午2:17:50 
	 * @param 
	 * @return PageResponse<ErEscScrinfoDto>
	 * @throws
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<ErEscAppinfoDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		//商务部门的职能编码  商务部职能查询外资
		String deptDutycode="A025";
		Map<String,Object> queryMap=request.getParams()==null?new HashMap<String,Object>():request.getParams();
		//去除空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(sysUser!=null){
			String adCode=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(sysUser.getSysDepart().getAdcode())?"0000":sysUser.getSysDepart().getAdcode()  ;
			List<DeptDutycodeRef>  deptDutycodeRefList= deptDutycodeRefService.selectDeptDutycodeRefByAdCode(adCode);
		    if(deptDutycodeRefList.size()>0){
		    	for(DeptDutycodeRef deptDutycodeRef:deptDutycodeRefList){
		    		if(deptDutycode.equals(deptDutycodeRef.getDutyDeptCode())){ 
		    			queryMap.put("entTypeCatg", entTypeCatg);
		    			break;
		    		}
		    	}
		    }
		}
		request.setParams(queryMap); 
		//权限
		//buildDBEnv_baseLocalAdminWhenSyn(false).creatDefaultDBAuthEnv(request,"B.CheckDep","B.LocalAdm"); 
		List<ErEscAppinfoDto> erEscScrinfoList=erEscAppinfoService.queryErEscAppinfoPageResult(request);
		return new PageResponse<ErEscAppinfoDto>(erEscScrinfoList);
	} 
}