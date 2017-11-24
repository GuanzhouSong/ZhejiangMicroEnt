/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.model.MidCaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidCaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeBasedDto;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeBased;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeBasedService;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousPunishListService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    处罚类严违控制器
 *
 * @author caoxu
 * @date 2016年11月25日
 */
@Controller
@RequestMapping("/reg/server/seriouspunish/")
public class ExpSeriousPunishListController extends CSBaseController {
	
	@Autowired
	private IExpSeriousPunishListService expSeriousPunishListService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;
	
	@Autowired
	private IExpSeriousCrimeBasedService expSeriousCrimeBasedService;
	@Autowired
	private IRegIndexService regIndexService;
	
	@Autowired
	IMidCaseInfoService midCaseInfoService;
	
	 /**
	  * 进入处罚类严违名单列入申请
	  * @return
	  * @throws Exception
	  */
	@RequestMapping("doEnExpSecInApply")
	public ModelAndView doEnExpSecInApply(ModelMap model) throws Exception {
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/exppunmanage/apply_list");
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		mv.addObject("regStateCunxuEnumMap", RegStateEnum.getRegStateCunxuEnumMap());
		return mv;
	}
	
	/**
	  * 进入处罚类严违名单初审
	  * @return
	  * @throws Exception
	  */
	@RequestMapping("doEnExpSecApplyFirst")
	public ModelAndView doEnExpSecApplyFirst(ModelMap model) throws Exception {
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/exppunmanage/apply_first_list");
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	
	/**
	  * 进入处罚类严违名单审核
	  * @return
	  * @throws Exception
	  */
	@RequestMapping("doEnExpSecApplyAudit")
	public ModelAndView doEnExpSecApplyAudit(ModelMap model) throws Exception {
		ModelAndView mv = new ModelAndView("/reg/server/secnocreditmanage/exppunmanage/apply_audit_list");
		mv.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return mv;
	}
	
	/**
	 * 处罚类严违名单列入申请列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doGetExpSecInApplyList")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeListDto> doGetExpSecInApplyList(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		List<ExpSeriousCrimeListDto> expSeriousPunishList = null;
		if (map.get("businessStatus") == null || StringUtils.isEmpty(map.get("businessStatus").toString())) {
			expSeriousPunishList = this.expSeriousPunishListService.doGetExpSecInApplySrcList(request);
		} else {
			expSeriousPunishList = this.expSeriousPunishListService.doGetExpSecInApplyList(request);
			return new PageResponse<ExpSeriousCrimeListDto>(expSeriousPunishList);
		}
		// 在这里设置总记录数以便分页计算显示
		Integer count1 = this.expSeriousPunishListService.applySrcTotalParm(map);
		//Integer count2 = this.expSeriousPunishListService.applyTotalParm(map);
		// 手动set构造函数里的三个参数
		PageResponse<ExpSeriousCrimeListDto> pages = new PageResponse<ExpSeriousCrimeListDto>(expSeriousPunishList);
		pages.setRecordsTotal(count1);
		pages.setRecordsFiltered( count1);
		pages.setData(expSeriousPunishList);
		return pages;
	}
	
	/**
	 * 处罚类严违名单初审列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doGetExpSecApplyFirstList")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeListDto> doGetExpSecApplyFirstList(PageRequest request) throws Exception {
		List<ExpSeriousCrimeListDto> expSeriousPunishList = this.expSeriousPunishListService.doGetExpSecInApplyList(request);
		return new PageResponse<ExpSeriousCrimeListDto>(expSeriousPunishList);
	}
	
	/**
	 * 处罚类严违名单审核列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doGetExpSecApplyAuditList")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeListDto> doGetExpSecApplyAuditList(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		map.put("audit", "1");
		List<ExpSeriousCrimeListDto> expSeriousPunishList = this.expSeriousPunishListService.doGetExpSecInApplyList(request);
		return new PageResponse<ExpSeriousCrimeListDto>(expSeriousPunishList);
	}
	
	/**
	 * 跳转到列入申请页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doApply")
	public String doApply(String caseID, String pid, ModelMap model) throws Exception {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		// 根据案件号获取源
		Map<String, Object> srcQuery = new HashMap<String, Object>();
		srcQuery.put("caseID", caseID);
		ExpSeriousCrimeListDto srcDto = this.expSeriousPunishListService.getSrcCase(srcQuery).get(0);
		// 严违期限
		Date date = srcDto.getAddSecTerm();
		if (date != null) {
			date = DateUtil.getNdaylaterDate(date, 10);
		}
		// 企业信息
		MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(pid);
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(pid);
		model.addAttribute("baseInfo", baseInfo);
		model.addAttribute("pubEppassword", pubEppassword);
		model.addAttribute("sysUser", sysUser);
		model.addAttribute("now", new Date());
		model.addAttribute("caseID", caseID);
		model.addAttribute("priPID", pid);
		model.addAttribute("addSecTerm", date);
		return "/reg/server/secnocreditmanage/exppunmanage/apply";
	}
	
	/**
	 * 保存申请
	 * @param expSeriousCrimeListDto
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveApply", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult saveApply(@Valid ExpSeriousCrimeListDto expSeriousCrimeListDto, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查 红色* 的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		// 根据案件ID获取源
		Map<String, Object> srcQuery = new HashMap<String, Object>();
		srcQuery.put("caseID", expSeriousCrimeListDto.getCaseID());
		List<ExpSeriousCrimeListDto> srcDtos = this.expSeriousPunishListService.getSrcCase(srcQuery);
		ExpSeriousCrimeListDto srcDto = null;
		if (srcDtos != null && srcDtos.size() > 0) {
			srcDto = srcDtos.get(0);
		}
		
		// 获取企业信息
		MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(expSeriousCrimeListDto.getPriPID());
		if (baseInfo != null && srcDto != null) {
			expSeriousCrimeListDto.setEntName(baseInfo.getEntName());
			expSeriousCrimeListDto.setRegNO(baseInfo.getRegNO());
			expSeriousCrimeListDto.setUniSCID(baseInfo.getUniCode());
			expSeriousCrimeListDto.setLeRep(baseInfo.getLeRep());
			expSeriousCrimeListDto.setRegState(baseInfo.getRegState());

			expSeriousCrimeListDto.setCerNO(baseInfo.getCerNO());
			expSeriousCrimeListDto.setRegOrg(baseInfo.getRegOrg());
			expSeriousCrimeListDto.setLocalAdm(baseInfo.getLocalAdm());
			// 业务类型、状态
			expSeriousCrimeListDto.setBusinessType("2");
			expSeriousCrimeListDto.setBusinessStatus("1");
			// 案件号作srcid-案件号重复-用id
			expSeriousCrimeListDto.setSourceId(expSeriousCrimeListDto.getCaseID());
			// 列入决定机关
			expSeriousCrimeListDto.setDecorgCN(srcDto.getDecorgCN());
			// 处罚文号
			expSeriousCrimeListDto.setPenDecNo(srcDto.getPenDecNo());
			// 申请日期
			expSeriousCrimeListDto.setApplyDate(new Date());
			// 严违期限
			Date date = srcDto.getAddSecTerm();
			//列违类型
			String secDishonestyType  = this.expSeriousPunishListService.getSecDishonestyTypeByAddSecCause(expSeriousCrimeListDto.getAddSecCause());
			expSeriousCrimeListDto.setSecDishonestyType(secDishonestyType);
			
			
			if (date != null) {
				expSeriousCrimeListDto.setAddSecTerm(DateUtil.getNdaylaterDate(date, 10));
			}
			// 严违类型
			expSeriousCrimeListDto.setAddSecType("1");
		}
		if (this.expSeriousPunishListService.insert(expSeriousCrimeListDto) > 0) {
			String[] str = expSeriousCrimeListDto.getSecBasedStr().split(";");
			for (String st : str) {
				ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto = doGetExpSeriousCrimeBasedDto(expSeriousCrimeListDto.getSourceId(), st);
				if (expSeriousCrimeBasedService.insertExpSeriousCrimeBased(expSeriousCrimeBasedDto) < 0) {
					return AjaxResult.error("新增严违名单依据失败！");
				}
			}
		} else
			return AjaxResult.error("申请列入失败");
		//新增成功，缓存待列入-1，待初审+1
		try {
			//操作成功后  缓存重新设置（行政指导新增申请删除成功，待审核-1）
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 14, 1,"2",sysUser);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 15, 1,"1",sysUser);
		} catch (Exception e) {
			return AjaxResult.success("申请列入成功");
		}
		return AjaxResult.success("申请列入成功");
	}
	
	/**
	 * 获取严违失信记录
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getSrcList", method = RequestMethod.POST)
    @ResponseBody
	public List<ExpSeriousCrimeListDto> getSrcList(String pid) throws Exception {
		Map<String, Object> srcQuery = new HashMap<String, Object>();
		srcQuery.put("priPID", pid);
		srcQuery.put("datelimit", DateUtil.stringToDate("2016-4-1","yyyy-MM-dd"));
		List<ExpSeriousCrimeListDto> srcDtos = this.expSeriousPunishListService.getSrcCase(srcQuery);
		return srcDtos;
	}

	/**
	 * 跳转到列入申请编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doApplyEdit")
	public String doApplyEdit(String uid, ModelMap model) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("uid", uid);
		List<ExpSeriousCrimeList> dtolist = this.expSeriousPunishListService.queryList(query);
		if (dtolist != null && dtolist.size() > 0) {
			// 企业信息
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(dtolist.get(0).getPriPID());
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(dtolist.get(0).getPriPID());
			// 依据
			List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(dtolist.get(0).getSourceId());
			model.addAttribute("baseInfo", baseInfo);
			model.addAttribute("pubEppassword", pubEppassword);
			model.addAttribute("basedList", basedList);
			model.addAttribute("apply", dtolist.get(0));
			return "/reg/server/secnocreditmanage/exppunmanage/apply_edit";
		} else
			return "/reg/server/secnocreditmanage/exppunmanage/apply_list";
	}
	
	/**
	 * 更新申请
	 * @param expSeriousCrimeListDto
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateApply", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult updateApply(@Valid ExpSeriousCrimeListDto expSeriousCrimeListDto, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查 红色* 的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("uid", expSeriousCrimeListDto.getUid());
		List<ExpSeriousCrimeList> dtolist = this.expSeriousPunishListService.queryList(query);
		// 修改的时候还原状态（可能之前是初审不通过）
		expSeriousCrimeListDto.setBusinessStatus("1");
		if (this.expSeriousPunishListService.update(expSeriousCrimeListDto) > 0) {
			//处理依据
			if (expSeriousCrimeBasedService.deleteExpSeriousCrimeBasedBySourceId(expSeriousCrimeListDto.getSourceId()) < 0) {
				return AjaxResult.error("严违依据删除失败！");
			}
			if(expSeriousPunishListService.UpdateSomeMsg(expSeriousCrimeListDto.getSourceId())<0){
				return AjaxResult.error("删除历史数据失败");
			}
			String[] str = expSeriousCrimeListDto.getSecBasedStr().split(";");
			for (String st : str) {
				ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto = doGetExpSeriousCrimeBasedDto(expSeriousCrimeListDto.getSourceId(), st);
				if (expSeriousCrimeBasedService.insertExpSeriousCrimeBased(expSeriousCrimeBasedDto) < 0) {
					return AjaxResult.error("新增严违名单依据失败！");
				}
			}
		} else
			return AjaxResult.error("修改申请列入失败");
		//初审不通过2，审核不通过5，变为待初审1，待初审缓存+1
		try {
			String oldBusinessStatus = dtolist == null ? "" : dtolist.get(0).getBusinessStatus() ;
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
			return AjaxResult.success("修改申请列入成功");
		}
		return AjaxResult.success("修改申请列入成功");
	}
	
	/**
	 * 跳转到列入申请初审页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doApplyFirst")
	public String doApplyFirst(String uid, ModelMap model) throws Exception {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("uid", uid);
		List<ExpSeriousCrimeList> dtolist = this.expSeriousPunishListService.queryList(query);
		if (dtolist != null && dtolist.size() > 0) {
			// 企业信息
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(dtolist.get(0).getPriPID());
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(dtolist.get(0).getPriPID());
			// 依据
			List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(dtolist.get(0).getSourceId());
			model.addAttribute("baseInfo", baseInfo);
			model.addAttribute("pubEppassword", pubEppassword);
			model.addAttribute("basedList", basedList);
			model.addAttribute("sysUser", sysUser);
			model.addAttribute("now", new Date());
			model.addAttribute("apply", dtolist.get(0));
			return "/reg/server/secnocreditmanage/exppunmanage/apply_first";
		} else
			return "/reg/server/secnocreditmanage/exppunmanage/apply_first_list";
	}
	
	/**
	 * 初审保存
	 * @param expSeriousCrimeListDto
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applySaveFirst", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult applySaveFirst(ExpSeriousCrimeListDto expSeriousCrimeListDto, BindingResult result) throws Exception {
		if (expSeriousCrimeListDto.getFirstCheck() == null) {
			AjaxResult error = AjaxResult.error("请选择初审意见");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		expSeriousCrimeListDto.setFirstdate(new Date());
		if (expSeriousCrimeListDto.getFirstCheck().equals("0")) {
			expSeriousCrimeListDto.setBusinessStatus("2");
		} else
			expSeriousCrimeListDto.setBusinessStatus("3");
		if (this.expSeriousPunishListService.update(expSeriousCrimeListDto) > 0) {
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
			return AjaxResult.success("列入申请初审成功");
		} else
			return AjaxResult.error("列入申请初审失败");
	}
	
	/**
	 * 跳转到严违名单审核页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doApplyAudit")
	public String doApplyAudit(String uid, ModelMap model) throws Exception {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("uid", uid);
		List<ExpSeriousCrimeList> dtolist = this.expSeriousPunishListService.queryList(query);
		if (dtolist != null && dtolist.size() > 0) {
			// 企业信息
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(dtolist.get(0).getPriPID());
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(dtolist.get(0).getPriPID());
			// 依据
			List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(dtolist.get(0).getSourceId());
			model.addAttribute("baseInfo", baseInfo);
			model.addAttribute("pubEppassword", pubEppassword);
			model.addAttribute("basedList", basedList);
			model.addAttribute("sysUser", sysUser);
			model.addAttribute("now", new Date());
			model.addAttribute("apply", dtolist.get(0));
			return "/reg/server/secnocreditmanage/exppunmanage/apply_audit";
		} else
			return "/reg/server/secnocreditmanage/exppunmanage/apply_audit_list";
	}
	
	/**
	 * 审核保存
	 * @param expSeriousCrimeListDto
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applySaveAudit", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult applySaveAudit(@Valid ExpSeriousCrimeListDto expSeriousCrimeListDto, BindingResult result) throws Exception {
		if (expSeriousCrimeListDto.getAuditCheck().equals("1")) {
			// 查询年份
			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("year", DateUtil.getYear());
			qryMap.put("auditDept", expSeriousCrimeListDto.getAuditDept());
			Integer no = expSeriousCrimeListService.selectMaxAddSecCountNo(qryMap);
			no = no + 1;

			expSeriousCrimeListDto.setAddSecCountNo(no);
			expSeriousCrimeListDto.setAddSecNo(expSeriousCrimeListDto.getAddSecOrg() + "严违入（" + DateUtil.getYear() + "）第" + no + "号");
			expSeriousCrimeListDto.setYear(Integer.parseInt(DateUtil.getYear()));

			expSeriousCrimeListDto.setAddSecDate(new Date());
			expSeriousCrimeListDto.setPublicState("0");
			expSeriousCrimeListDto.setSecExpiredDate(DateUtil.getyearlaterDateObject(new Date(), 5));

			expSeriousCrimeListDto.setBusinessStatus("4");
		} else
			expSeriousCrimeListDto.setBusinessStatus("5");
		expSeriousCrimeListDto.setAuditDate(new Date());
		if (this.expSeriousPunishListService.update(expSeriousCrimeListDto) > 0) {
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
			return AjaxResult.success("审核成功");
		} else
			return AjaxResult.error("审核失败");
	}
	
	/**
	 * 跳转到列入申请查看页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doApplyView")
	public String doApplyView(String uid, ModelMap model) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("uid", uid);
		List<ExpSeriousCrimeList> dtolist = this.expSeriousPunishListService.queryList(query);
		if (dtolist != null && dtolist.size() > 0) {
			// 企业信息
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(dtolist.get(0).getPriPID());
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(dtolist.get(0).getPriPID());
			// 依据
			List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(dtolist.get(0).getSourceId());
			model.addAttribute("baseInfo", baseInfo);
			model.addAttribute("pubEppassword", pubEppassword);
			model.addAttribute("basedList", basedList);
			model.addAttribute("apply", dtolist.get(0));
			return "/reg/server/secnocreditmanage/exppunmanage/apply_view";
		} else
			return "/reg/server/secnocreditmanage/exppunmanage/apply_list";
	}
	
	/**
	 * 跳转到列入申请审核查看页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doApplyAuditView")
	public String doApplyAuditView(String uid, ModelMap model) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("uid", uid);
		List<ExpSeriousCrimeList> dtolist = this.expSeriousPunishListService.queryList(query);
		if (dtolist != null && dtolist.size() > 0) {
			// 企业信息
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(dtolist.get(0).getPriPID());
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(dtolist.get(0).getPriPID());
			// 依据
			List<ExpSeriousCrimeBased> basedList = expSeriousCrimeBasedService.selectExpSeriousCrimeBasedList(dtolist.get(0).getSourceId());
			model.addAttribute("baseInfo", baseInfo);
			model.addAttribute("pubEppassword", pubEppassword);
			model.addAttribute("basedList", basedList);
			model.addAttribute("apply", dtolist.get(0));
			return "/reg/server/secnocreditmanage/exppunmanage/apply_audit_view";
		} else
			return "/reg/server/secnocreditmanage/exppunmanage/apply_audit_list";
	}
	
	/**
	 * 列入页面统计
	 * @return
	 */
	@RequestMapping("applyTotal")
	@ResponseBody
	public Map<String, Integer> applyTotal() {
		Map<String, Integer> totals = new HashMap<String, Integer>();
//		Integer applySrcTotal = this.expSeriousPunishListService.applySrcTotal();
		Integer applyFirstTotal = this.expSeriousPunishListService.applyFirstTotal();
		Integer applyAuditTotal = this.expSeriousPunishListService.applyAuditTotal();
		Integer applyExpirTotal = this.expSeriousPunishListService.applyExpirTotal();
//		totals.put("applySrcTotal", applySrcTotal);
		totals.put("applyFirstTotal", applyFirstTotal);
		totals.put("applyAuditTotal", applyAuditTotal);
		totals.put("applyExpirTotal", applyExpirTotal);
		return totals;
	}
	
	/**
	 * 初审页面统计
	 * @return
	 */
	@RequestMapping("firstTotal")
	@ResponseBody
	public Map<String, Integer> firstTotal() {
		Map<String, Integer> totals = new HashMap<String, Integer>();
		Integer firstTotal = this.expSeriousPunishListService.firstTotal();
		Integer firstNotTotal = this.expSeriousPunishListService.firstNotTotal();
		Integer auditTotal = this.expSeriousPunishListService.auditTotal();
		totals.put("firstTotal", firstTotal);
		totals.put("firstNotTotal", firstNotTotal);
		totals.put("auditTotal", auditTotal);
		return totals;
	}
	
	/**
	 * 审核页面统计
	 * @return
	 */
	@RequestMapping("auditTotal")
	@ResponseBody
	public Map<String, Integer> auditTotal() {
		Map<String, Integer> totals = new HashMap<String, Integer>();
		Integer auditTotal = this.expSeriousPunishListService.auditTotal();
		Integer auditNotTotal = this.expSeriousPunishListService.auditNotTotal();
		Integer passTotal = this.expSeriousPunishListService.passTotal();
		totals.put("auditTotal", auditTotal);
		totals.put("auditNotTotal", auditNotTotal);
		totals.put("passTotal", passTotal);
		return totals;
	}
	
	/**
	 * 删除严违名单
	 * @param sourceId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doExpInApplyDelete")
	@ResponseBody
	public AjaxResult doExpInApplyDelete(String uid) throws Exception {
		if (expSeriousPunishListService.deleteExpSeriousList(uid) < 0) {
			return AjaxResult.error("严违名单删除失败！");
		}
		if (expSeriousCrimeBasedService.deleteExpSeriousCrimeBasedBySourceId(uid) < 0) {
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
	 * 严违依据构建
	 * @param sourceId
	 * @param based
	 * @return
	 * @throws Exception
	 */
	private ExpSeriousCrimeBasedDto doGetExpSeriousCrimeBasedDto(String sourceId, String based) throws Exception {
		ExpSeriousCrimeBasedDto base = new ExpSeriousCrimeBasedDto();
		base.setSourceId(sourceId);
		base.setBased(based);
		base.setCreateTime(new Date());
		return base;
	}
	
	@RequestMapping("judgstate")
	@ResponseBody
	public AjaxResult judgstate(String priPID) throws Exception{
		List<ExpSeriousCrimeList> modelList = expSeriousCrimeListService.selectSeriousCrimeInfoByPriPID(priPID);
		if(modelList.size()>0)
			return AjaxResult.error("已审核成功，不允许修改");
		return AjaxResult.success("允许修改");
	}
	
	/**
	 * 描述：严违失信信息详情
	 * 
	 * @author baifangfang
	 * @date 2017年10月23日
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("caseDetail")
	public ModelAndView caseDetail(@RequestParam String id) throws Exception {
		ModelAndView mav = new ModelAndView("/reg/server/secnocreditmanage/exppunmanage/apply_audit_case_detail");
		MidCaseInfo midCaseInfo = midCaseInfoService.selectMidCaseInfoById(id);
		mav.addObject("midCaseInfo", midCaseInfo);
		return mav;
	}
	
}