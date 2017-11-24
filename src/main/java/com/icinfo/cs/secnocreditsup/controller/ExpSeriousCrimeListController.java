/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.bulletin.model.PubAnnounceMent;
import com.icinfo.cs.bulletin.service.IPubAnnounceMentService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeBasedDto;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeBased;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeBasedService;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_exp_serious_crime_list 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月25日
 */
@Controller
@RequestMapping("/reg/server/seriouscrime/")
public class ExpSeriousCrimeListController extends CSBaseController {
	
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IExpSeriousCrimeBasedService expSeriousCrimeBasedService;
	@Autowired
	private IDepartMentService departMentService;
	@Autowired
	private IPubAnnounceMentService pubAnnounceMentService;
	@Autowired
	private IRegIndexService regIndexService;
	
	
	/**
     * 进入列入异常类严违名单决定书
     * @author ylr
     * @date 2016-12-9
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpManageDecision")
	public ModelAndView doEnExpManageDecision(String uid) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/expmanagedecision");
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeByUID(uid);
		mv.addObject("expSeriousCrimeList",expSeriousCrimeList);
		return mv;
	}
	/**
     * 进入列入异常类严违名单审批表
     * @author ylr
     * @date 2016-12-9
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpManageApproval")
	public ModelAndView doEnExpManageApproval(String uid) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/expmanageapproval");
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeByUID(uid);
		
		mv.addObject("expSeriousCrimeList",expSeriousCrimeList);
		return mv;
	}
	 /**
     * 进入异常类严违名单检索
     * @author ylr
     * @date 2016-12-2
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpSecSearch")
	public ModelAndView doEnExpSecSearch(PageRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/expsecsearch");
//		creatOptDBAuthEnv(request,"DecOrg","LocalAdm");
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	
	 /**
     * 进入异常类严违名单列入申请
     * @author ylr
     * @date 2016-11-27
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpSecInApply")
	public ModelAndView doEnExpSecInApply(PageRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/expsecinapply");
//		creatOptDBAuthEnv(request,"DecOrg","LocalAdm");
		Map<String, Object> qryMap = request.getParams();
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	/**
	 * 统计异常严违名单业务状态数量
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("doCountByBussinessType")
	@ResponseBody
	public Map<String,Object> doCountByBussinessType() throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		//待列入
		map.put("dlrNum",expSeriousCrimeListService.getDLRNum(qryMap));
		//逾期列入
		map.put("yqlrNum",expSeriousCrimeListService.getYQLRNum(qryMap));
		//待初审
		qryMap.put("businessStatus", "1");
		map.put("dcsNum",expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//初审不通过
		qryMap.put("businessStatus", "2");
		map.put("csbtgNum",  expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//待审核
		qryMap.put("businessStatus", "3");
		map.put("dshNum",expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//初审通过
		qryMap.put("businessStatus", "4");
		map.put("cstgNum",  expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//审核不通过
		qryMap.put("businessStatus", "5");
		map.put("shbtgNum",  expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//待移出
		qryMap.put("businessStatus", "6");
		map.put("dycNum",  expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//待延期
		qryMap.put("businessStatus", "7");
		map.put("dyqNum",  expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		//异常将届满
		qryMap.put("businessStatus", "8");
		map.put("ycjjmNum",  expSeriousCrimeListService.getNumByBusinessStatus(qryMap));
		return map;
	}
	 /**
     * 进入异常类严违名单初审列表页面
     * @author ylr
     * @date 2016-12-1
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpSecFirstReview")
	public ModelAndView doEnExpSecFirstReview(PageRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/expsecfirstreview");
//		creatOptDBAuthEnv(request,"a.DecOrg","a.LocalAdm");
		Map<String, Object> qryMap = request.getParams();
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	
	 /**
     * 进入异常类严违名单审核列表页面
     * @author ylr
     * @date 2016-12-1
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpSecEndReview")
	public ModelAndView doEnExpSecEndReview(PageRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/expsecendreview");
//		creatOptDBAuthEnv(request,"a.DecOrg","a.LocalAdm");
		Map<String, Object> qryMap = request.getParams();
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	
	/**
     * 进入异常类严违列入申请页面
     * @author ylr
     * @date 2016-11-29
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpApplyAdd")
	public ModelAndView doEnExpApplyAdd(String priPID,String uID,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/applyadd");
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(uID);
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("midBaseInfo", midBaseInfo);
		mv.addObject("pubOpanoMaly", pubOpanoMaly);
		mv.addObject("pubEppassword", pubEppassword);
		mv.addObject("sysUser", sysUser);
		mv.addObject("now", new Date());
		mv.addObject("baseone", DateUtil.formatDate(pubOpanoMaly.getAbnTime())+"《列入经营异常名录决定书》（警示系统）");
		return mv;
	}
	
	/**
     * 进入异常类严违列入申请修改页面
     * @author ylr	
     * @date 2016-11-30
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpInApplyEdit")
	public ModelAndView doEnExpInApplyEdit(String priPID,String uID,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/inedit");
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeBySourceId(uID);
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(uID);
		
		
		mv.addObject("midBaseInfo", midBaseInfo);
		mv.addObject("expSeriousCrimeList", expSeriousCrimeList);
		mv.addObject("pubEppassword", pubEppassword);
		mv.addObject("basedList", basedList);
		return mv;
	}
	
	/**
     * 进入异常类严违列入申请初审
     * @author ylr	
     * @date 2016-12-2
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpFirstReview")
	public ModelAndView doEnExpFirstReview(String priPID,String uID,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/firstreview");
		
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeBySourceId(uID);
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(uID);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("midBaseInfo", midBaseInfo);
		mv.addObject("expSeriousCrimeList", expSeriousCrimeList);
		mv.addObject("pubEppassword", pubEppassword);
		mv.addObject("basedList", basedList);
		mv.addObject("sysUser", sysUser);
		mv.addObject("date", new Date());
		return mv;
	}
	
	/**
     * 进入异常类严违列入申请初审
     * @author ylr	
     * @date 2016-12-2
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpEndReview")
	public ModelAndView doEnExpEndReview(String priPID,String uID,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/endreview");
		
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeBySourceId(uID);
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(uID);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("midBaseInfo", midBaseInfo);
		mv.addObject("expSeriousCrimeList", expSeriousCrimeList);
		mv.addObject("pubEppassword", pubEppassword);
		mv.addObject("basedList", basedList);
		mv.addObject("sysUser", sysUser);
		mv.addObject("date", new Date());
		return mv;
	}
	
	
	
	/**
     * 进入异常类严违列入申请详情页面
     * @author ylr	
     * @date 2016-12-1
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnExpInApplyDetail")
	public ModelAndView doEnExpInApplyDetail(String priPID,String uID,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/expsecmanage/indetail");
		List<MidBaseInfoDto> midBaseInfoList = midBaseInfoService.doGetListByPriPID(priPID);
		MidBaseInfo midBaseInfo = null;
		if(midBaseInfoList.size()>0)
			midBaseInfo = midBaseInfoList.get(0);
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeBySourceId(uID);
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		if(expSeriousCrimeList!=null){
			PubAnnounceMent pubAnnounceMent = pubAnnounceMentService.findBySomeMsg(priPID, expSeriousCrimeList.getAbnTime(), "3");
			mv.addObject("pubAnnounceMent", pubAnnounceMent);
		}
		List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(uID);
		mv.addObject("midBaseInfo", midBaseInfo);
		mv.addObject("expSeriousCrimeList", expSeriousCrimeList);
		mv.addObject("pubEppassword", pubEppassword);
		mv.addObject("basedList", basedList);
		return mv;
	}
	
	
	
	/**
     * 获取异常类严违名单列入申请列表
     * @author ylr
     * @date 2016-11-28
     * @return ModelAndView
     *
     */
	@RequestMapping("doGetExpSecInApplyList")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeListDto> doGetExpSecInApplyList(PageRequest request) throws Exception{
//		creatOptDBAuthEnv(request,"a.DecOrg","a.LocalAdm");
		List<ExpSeriousCrimeListDto> expSeriousCrimeListDtoList = expSeriousCrimeListService.doGetExpSecInApplyList(request);
		return new PageResponse<ExpSeriousCrimeListDto>(expSeriousCrimeListDtoList);
	}
	
	/**
     * 获取异常类严违名单列入申请列表
     * @author ylr
     * @date 2016-11-28
     * @return ModelAndView
     *
     */
	@RequestMapping("doGetExpSecSearchList")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeListDto> doGetExpSecSearchList(PageRequest request) throws Exception{
		creatDefaultDBAuthEnv(request,"a.DecOrg","a.LocalAdm");
		List<ExpSeriousCrimeListDto> expSeriousCrimeListDtoList = expSeriousCrimeListService.doGetExpSecSearchList(request);
		return new PageResponse<ExpSeriousCrimeListDto>(expSeriousCrimeListDtoList);
	}
	
	/**
     * 获取异常类严违名单审核列表
     * @author ylr
     * @date 2016-11-28
     * @return ModelAndView
     *
     */
	@RequestMapping("doGetExpSecFirstReviewList")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeListDto> doGetExpSecFirstReviewList(PageRequest request) throws Exception{
//		creatOptDBAuthEnv(request,"a.DecOrg","a.LocalAdm");
		List<ExpSeriousCrimeListDto> expSeriousCrimeListDtoList = expSeriousCrimeListService.doGetExpFirstReviewList(request);
		return new PageResponse<ExpSeriousCrimeListDto>(expSeriousCrimeListDtoList);
	}
	
	/**
     * 异常类严违名单申请
     * @author ylr
     * @date 2016-11-29
     * @return AjaxResult
     *
     */
	@RequestMapping("doSaveExpSecInApply")
	@ResponseBody
	@RepeatSubmit(timeout=1000)
	public AjaxResult doSaveExpSecInApply(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{
		expSeriousCrimeListDto = doGetExpSeriousCrimeListDto(expSeriousCrimeListDto);
		if(expSeriousCrimeListService.insertExpSeriousCrimeList(expSeriousCrimeListDto) < 0){
			return AjaxResult.error("新增严违名单失败！"); 
		}
		
		String[] str = expSeriousCrimeListDto.getSecBasedStr().split(";");
		for(String st:str){
			ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto = doGetExpSeriousCrimeBasedDto(expSeriousCrimeListDto.getSourceId(),st);
			if(expSeriousCrimeBasedService.insertExpSeriousCrimeBased(expSeriousCrimeBasedDto) < 0){
				return AjaxResult.error("新增严违名单依据失败！"); 
			}
		}
		//新增成功，缓存待列入-1，待初审+1
		try {
	        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			//操作成功后  缓存重新设置（行政指导新增申请删除成功，待审核-1）
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 14, 1,"2",sysUser);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 15, 1,"1",sysUser);
		} catch (Exception e) {
			return AjaxResult.success("申请成功");
		}
		return AjaxResult.success("申请成功！");
	}
	
	/**
     * 异常类严违名单列入修改
     * @author ylr
     * @date 2016-12-1
     * @return AjaxResult
     *
     */
	@RequestMapping("doSaveExpSecInEdit")
	@ResponseBody
	public AjaxResult doSaveExpSecInEdit(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{
		//获取当前状态
		ExpSeriousCrimeList expSeriousCrimeList = expSeriousCrimeListService.selectSeriousCrimeBySourceId(expSeriousCrimeListDto.getSourceId());
		expSeriousCrimeListDto.setBusinessStatus("1");
		if(expSeriousCrimeListService.updateExpSeriousCrimeList(expSeriousCrimeListDto) < 0){
			return AjaxResult.error("严违名单修改失败！"); 
		}
		if(expSeriousCrimeBasedService.deleteExpSeriousCrimeBasedBySourceId(expSeriousCrimeListDto.getSourceId()) < 0){
			return AjaxResult.error("严违依据删除失败！"); 
		}
		if(expSeriousCrimeListService.UpdateSomeMsg(expSeriousCrimeListDto.getSourceId()) < 0){
			return AjaxResult.error("历史审核数据删除失败");
		}
		String[] str = expSeriousCrimeListDto.getSecBasedStr().split(";");
		for(String st:str){
			ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto = doGetExpSeriousCrimeBasedDto(expSeriousCrimeListDto.getSourceId(),st);
			if(expSeriousCrimeBasedService.insertExpSeriousCrimeBased(expSeriousCrimeBasedDto) < 0){
				return AjaxResult.error("修改严违名单依据失败！"); 
			}
		}
		//初审不通过2，审核不通过5，变为待初审1，待初审缓存+1
		try {
			String oldBusinessStatus = expSeriousCrimeList.getBusinessStatus();
			if(!"1".equals(oldBusinessStatus) && "1".equals(expSeriousCrimeListDto.getBusinessStatus())){
		        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				//操作成功后  缓存重新设置（行政指导新增申请删除成功，待审核-1）
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				String regOrg = selectRegorgByDeptCode(sysUser);
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				forBidmap.put("regOrg", regOrg);
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 15, 1,"1",sysUser);
			}
		} catch (Exception e) {
			return AjaxResult.success("修改成功");
		}
		return AjaxResult.success("修改成功！");
	}
	
	/**
     * 异常类严违名单列入初审
     * @author ylr
     * @date 2016-12-2
     * @return AjaxResult
     *
     */
	@RequestMapping("doSaveInFirstReview")
	@ResponseBody
	public AjaxResult doSaveInFirstReview(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{

		if("1".equals(expSeriousCrimeListDto.getFirstCheck())){
			expSeriousCrimeListDto.setBusinessStatus("3");
		}else{
			expSeriousCrimeListDto.setBusinessStatus("2");
		}
		
		if(expSeriousCrimeListService.updateExpSeriousCrimeListForAll(expSeriousCrimeListDto) < 0){
			return AjaxResult.error("严违名单初审失败！"); 
		}
		//初审成功  待初审缓存-1 ；初审审核通过 待审核+1；
		try {
	        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 15, 1,"2",sysUser);
			if("3".equals(expSeriousCrimeListDto.getBusinessStatus())){
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 16, 1,"1",sysUser);
			}
		} catch (Exception e) {
			return AjaxResult.success("初审成功");
		}
		return AjaxResult.success("初审成功！");
	}
	
	/**
     * 异常类严违名单列入审核
     * @author ylr
     * @date 2016-12-2
     * @return AjaxResult
     *
     */
	@RequestMapping("doSaveInEndReview")
	@ResponseBody
	public AjaxResult doSaveInEndReview(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{
		if("1".equals(expSeriousCrimeListDto.getAuditCheck())){
			DepartMent departMent =  departMentService.selectDepartMentByDeptCode(expSeriousCrimeListDto.getRegOrg());
			if(StringUtils.isBlank(departMent.getDocShortName()))
				return AjaxResult.error("该企业登记机关部门字号为空，无法生成严违文号！"); 
			
			Map<String, Object> qryMap = new HashMap<>();
			qryMap.put("year", DateUtil.getYear());
			qryMap.put("auditDept", expSeriousCrimeListDto.getAuditDept());
			Integer no = expSeriousCrimeListService.selectMaxAddSecCountNo(qryMap);
			no = no + 1;
			
			expSeriousCrimeListDto.setBusinessStatus("4");
			expSeriousCrimeListDto.setAddSecCountNo(no);
			expSeriousCrimeListDto.setAddSecNo(departMent.getDocShortName()+"严违入〔"+DateUtil.getYear()+"〕第"+no+"号");
			expSeriousCrimeListDto.setYear(Integer.parseInt(DateUtil.getYear()));
			expSeriousCrimeListDto.setAddSecOrgCode(expSeriousCrimeListDto.getAuditDept());
			
			expSeriousCrimeListDto.setAddSecOrg(expSeriousCrimeListDto.getAuditDeptName());
			expSeriousCrimeListDto.setAddSecDate(new Date());
			expSeriousCrimeListDto.setPublicState("0");//设置公示状态未认领
			expSeriousCrimeListDto.setSecExpiredDate(DateUtil.getyearlaterDateObject(new Date(), 5));
			
		}else{
			expSeriousCrimeListDto.setBusinessStatus("5");
		}
		
		if(expSeriousCrimeListService.updateExpSeriousCrimeList(expSeriousCrimeListDto) < 0){
			return AjaxResult.error("严违名单审核失败！"); 
		}
		//审核成功  待审核-1；
		try {
	        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 16, 1,"2",sysUser);
		} catch (Exception e) {
			return AjaxResult.success("审核成功");
		}
		return AjaxResult.success("审核成功！");
	}
	
	/**
     * 异常类严违名单列入删除
     * @author ylr
     * @date 2016-12-1
     * @return AjaxResult
     *
     */
	@RequestMapping("doExpInApplyDelete")
	@ResponseBody
	public AjaxResult doExpInApplyDelete(String sourceId) throws Exception{
		if(expSeriousCrimeListService.deleteExpSeriousCrimeList(sourceId) < 0){
			return AjaxResult.error("严违名单删除失败！"); 
		}

		if(expSeriousCrimeBasedService.deleteExpSeriousCrimeBasedBySourceId(sourceId) < 0){
			return AjaxResult.error("严违依据删除失败！"); 
		}
		//列入删除  待初审-1；
		try {
	        SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 15, 1,"2",sysUser);
		} catch (Exception e) {
			return AjaxResult.success("审核成功");
		}
		return AjaxResult.success("成功删除！"); 
	}
	
	
	
	
	
	/**
     * 异常类严违名单申请--构建严违实体
     * @author ylr
     * @date 2016-11-29
     * @return AjaxResult
     *
     */
	private ExpSeriousCrimeListDto doGetExpSeriousCrimeListDto(ExpSeriousCrimeListDto exp) throws Exception{
		PubOpanoMaly pub = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(exp.getSourceId());
		
		exp.setPriPID(pub.getPriPID());
		exp.setEntName(pub.getEntName());
		exp.setRegNO(pub.getRegNO());
		exp.setUniSCID(pub.getUniSCID());
		exp.setLeRep(pub.getLeRep());
		
		exp.setCerType(pub.getCerType());
		exp.setCerNO(pub.getCerNO());
		exp.setRegOrg(pub.getRegOrg());
		exp.setLocalAdm(pub.getLocalAdm());
		exp.setBusinessType("2");//业务类型不确定啊啊啊啊
		
		exp.setBusinessStatus("1");//1待初审2初审不通过3待审核4审核通过5审核不通过
		exp.setSpeCause(pub.getSpeCause());
		exp.setSpeCauseCN(pub.getSpeCauseCN());
		exp.setAbnTime(pub.getAbnTime());
		exp.setDecOrg(pub.getDecOrg());
		
		exp.setDecorgCN(pub.getDecorgCN());
		exp.setPenDecNo(pub.getPenDecNo());
		exp.setExpExpiredBeforeDate(DateUtil.getNdaylaterDate(DateUtil.getyearlaterDateObject(pub.getAbnTime(), 3), -60));
		exp.setSecDishonestyType("异常届满");
		exp.setApplyDate(new Date());
		
		exp.setSecExpiredDelay(0);
		exp.setAddSecType("2");
		exp.setCreateTime(new Date());
		
		return exp;
	}
	
	/**
     * 异常类严违名单申请--构建严违实体
     * @author ylr
     * @date 2016-11-29
     * @return AjaxResult
     *
     */
	private ExpSeriousCrimeBasedDto doGetExpSeriousCrimeBasedDto(String sourceId,String based) throws Exception{
		ExpSeriousCrimeBasedDto base = new ExpSeriousCrimeBasedDto();
		
		base.setSourceId(sourceId);
		base.setBased(based);
		base.setCreateTime(new Date());
		
		return base;
	}
	@RequestMapping("judgState")
	@ResponseBody
	public AjaxResult judgState(String priPID) throws Exception{
		List<ExpSeriousCrimeList> modelList = expSeriousCrimeListService.selectSeriousCrimeInfoByPriPID(priPID);
		if(modelList.size()>0)
			return AjaxResult.error("不允许修改");
		return AjaxResult.success("允许修改");
	}
	
	
	
}