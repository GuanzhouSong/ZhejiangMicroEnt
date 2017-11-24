/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.dto.MidLeRepDto;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.cs.registmanage.dto.QualificationLimitDto;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: 任职资格黑名单  对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年03月21日
 */
@Controller
@RequestMapping({ "/reg/server/other/blacklist/", "/syn/server/other/blacklist/" })
public class PubRightBlackListController  extends CSBaseController{
	
	@Autowired
	private IMidLeRepService midLeRepService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private IQualificationLimitService qualificationLimitService;
	
	@Autowired
	private IMidMemberService midMemberService;
	
	@Autowired
	private IMidInvService midInvService;
	
	/**
	 * 
	 * 描述: 进入任职资格黑名单查询页面
	 * 
	 * @auther chenxin
	 * @date 2016年11月28日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listpage")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/blacklist/pubrightblacklist");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}
	
	/**
     * 描述：获取任职资格黑名单列表
     * @author chenxin
     * @date 2017-03-21
     * @return 
     */
    @RequestMapping("/rightbackList")
    @ResponseBody
    public PageResponse<QualificationLimitDto> doGetRightBackList(PageRequest request) throws Exception{
        List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService.selectRightLimitList(request);
        return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
    }
    
	/**
     * 描述：获取受限对象受限原因列表
     * @author chenxin
     * @date 2017-03-21
     * @return 
     */
    @RequestMapping("/reasonbackList")
    @ResponseBody
    public PageResponse<MidLeRepDto> doGetRightBackReasonList(PageRequest request) throws Exception{
        List<MidLeRepDto> midLeRepDtoList = midLeRepService.selectMidLeRepBackReasonList(request);
        return new PageResponse<MidLeRepDto>(midLeRepDtoList);
    }
    
    /**
     * 描述：获取受限对象关联企业列表
     * @author chenxin
     * @date 2017-03-21
     * @return 
     */
    @RequestMapping("/midbackList")
    @ResponseBody
    public PageResponse<MidBaseInfoDto> doGetMidbackList(PageRequest request) throws Exception{
    	List<MidBaseInfoDto> midLeRepDtoList = midBaseInfoService.selectMidBaseinfoBackList(request);
    	return new PageResponse<MidBaseInfoDto>(midLeRepDtoList);
    }
    
    /**
	 * 
	 * 描述: 进入任职资格黑名单查询页面
	 * 
	 * @auther chenxin
	 * @date 2016年11月28日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(String uid,HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/blacklist/pubrightblackdetail");
		QualificationLimit limitInfo = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		if(limitInfo !=null){
			List<MidMember> midMembers = midMemberService.
					selectMidMemberInfoByCerNOAndName(limitInfo.getCertNO(),limitInfo.getClientName());
			if(midMembers != null){
				view.addObject("midMeCount", midMembers.size());
			}
			List<MidLeRep> leReps = midLeRepService.selectMidLeRepListByCerNO(limitInfo.getCertNO());
			if(leReps != null){
				view.addObject("leRepCount", leReps.size());
			}
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("certNO", limitInfo.getCertNO());
			List<String> priPIDList = qualificationLimitService.selectRightPriPIDList(qryMap);
			String notInPidList = "";
			for(String pid : priPIDList){
				if(StringUtils.isEmpty(notInPidList)){
					notInPidList += pid;
				}else{
					notInPidList += ","+pid;
				}
			}
			view.addObject("notInPidList", notInPidList);
			if(StringUtils.isNotEmpty(limitInfo.getCertType()) && StringUtils.isNotEmpty(limitInfo.getCertNO()) 
					&& "10".equals(limitInfo.getCertType())){
				String certNO = limitInfo.getCertNO();
				Map<String,Object> map = CardUtil.getCertNOInfo(certNO);
				String age = "";
				String birthDay = "";
				String sex = "";
				if(map != null){
					if(map.get("age") != null){
						age = (String)map.get("age");
					}
					if(map.get("birthDay") != null){
						birthDay = (String)map.get("birthDay");
					}
					if(map.get("sex") != null){
						sex = (String)map.get("sex");
					}
				}
				view.addObject("sex", sex);
				view.addObject("age", age);
				view.addObject("birthDay", birthDay);
				if(certNO.length() > 4){
					view.addObject("certNOS", certNO.substring(0, certNO.length()-4)+"****");
				}
			}
			Date sysdate = DateUtil.getSysCurrentDate();
			if(limitInfo.getLimitDateEnd() == null || limitInfo.getLimitDateEnd().compareTo(sysdate) == 1){
				view.addObject("limitstate", "Y");
			}else{
				view.addObject("limitstate", "N");
			}
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		view.addObject("sysdate", DateUtil.getCurrentDate());
		view.addObject("limitInfo", limitInfo);
		return view;
	}
	
	/**
	 * 描述：统计数量
	 * 
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @param priPID
	 * @param inspectDept
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/countback", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doCountBack(@RequestParam Map<String,Object> params) throws Exception {
    	if(params!=null){
    		if(params.get("limitType") != null && StringUtils.isNotEmpty(params.get("limitType").toString()) ){
    			String limitType = params.get("limitType").toString();
    			if(limitType.split(",").length >= 1){
    				params.put("limitTypeArr",limitType.split(","));
    				params.remove("limitType");
    			}
    		}
    		if(params.get("limitDateEnd") != null && StringUtils.isNotEmpty(params.get("limitDateEnd").toString()) ){
    			String limitDateEnd = params.get("limitDateEnd").toString();
    			params.put("limitDateEnd",limitDateEnd+" "+"23:59:59");
    		}
    	}
		int entTotal = qualificationLimitService.selectEntTotal(params);
		int personTotal = qualificationLimitService.selectPersonTotal(params);
		return AjaxResult.success("查询成功",entTotal+"="+personTotal);
	}
}
