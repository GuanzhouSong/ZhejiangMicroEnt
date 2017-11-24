/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.controller.reg.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.model.CodeSliceno;
import com.icinfo.cs.base.model.CodeStreet;
import com.icinfo.cs.base.model.SuperItem;
import com.icinfo.cs.base.service.impl.CodeEntcatgServiceImpl;
import com.icinfo.cs.base.service.impl.CodeRegorgServiceImpl;
import com.icinfo.cs.base.service.impl.CodeRegunitServiceImpl;
import com.icinfo.cs.base.service.impl.CodeSlicenoServiceImpl;
import com.icinfo.cs.base.service.impl.CodeStreetServiceImpl;
import com.icinfo.cs.base.service.impl.SuperItemServiceImpl;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidAltitemDto;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.impl.MidAltitemServiceImpl;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.cs.other.service.impl.PubOtherlicenceServiceImpl;
import com.icinfo.cs.registinfo.dto.PubApprMarkRelDto;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.model.PubApprMarkRel;
import com.icinfo.cs.registinfo.model.RegistInfo;
import com.icinfo.cs.registinfo.model.RegistSurver;
import com.icinfo.cs.registinfo.model.UlManage;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.cs.registinfo.service.IRegistSurverService;
import com.icinfo.cs.registinfo.service.impl.RegistInfoServiceImpl;
import com.icinfo.cs.registinfo.service.impl.UlManageServiceImpl;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.impl.CsWarnMarkServiceImpl;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.system.service.impl.SysUserServiceImpl;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述: cs_regist_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("/reg/server/registinfo/registinfo/")
public class RegistInfoController extends CSBaseController {

	@Autowired
	CodeEntcatgServiceImpl codeEntcatgService;
	@Autowired
	CodeSlicenoServiceImpl codeSlicenoService;
	@Autowired
	CodeRegunitServiceImpl codeRegunitService;
	@Autowired
	CodeRegorgServiceImpl codeRegorgService;
	@Autowired
	RegistInfoServiceImpl registInfoService;
	@Autowired
	UlManageServiceImpl ulManageService;
	@Autowired
	PubOtherlicenceServiceImpl pubOtherlicenceService;
	@Autowired
	SysUserServiceImpl sysUserService;
	@Autowired
	CodeStreetServiceImpl codeStreetService;
	@Autowired
	SuperItemServiceImpl superItemService;
	@Autowired
	MidAltitemServiceImpl midAltitemService;
	@Autowired
	CsWarnMarkServiceImpl csWarnMarkService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private IQualificationLimitService qualificationLimitService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private ICsSuperviseObjService csSuperviseObjService;
	@Autowired
	private IErEscAppinfoService erEscAppinfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICsConcernObjService csConcernObjService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	private IPubApprMarkRelService pubApprMarkRelService;
	@Autowired
	ICsEntWarnService csEntWarnService;
	@Autowired
	IRegistSurverService registSurverService;
	@Autowired
	IRegIndexService regIndexService;

	// -------------------------------------------------跳转页面方法--------------------------------------

	@RequestMapping("/regerror")
	public ModelAndView regerror() throws Exception {
		ModelAndView view = new ModelAndView("reg/server/registinfo/error");
		return view;
	}

	/**
	 * 跳转到主体户口建档表格页面
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("toList")
	public ModelAndView toList() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/registinfo/registinfo_list");

		return modelAndView;
	}

	/**
	 * 请求认领建档页面的列表数据:建档表cs_regist_info的数据
	 *
	 * @param request
	 * @return PageResponse
	 */

	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<RegistInfoDto> listJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		PageResponse<RegistInfoDto> data = registInfoService.registInfoQueryPage_page(request);
		return data;
	}

	/**
	 * 跳转到主体户口变更重建档表格页面
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("toAgainList")
	public ModelAndView toAgainList() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/registinfo/registinfoagain_list");
		return modelAndView;
	}

	/**
	 * 跳转到主体户口建档维护表格页面
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("toModiList")
	public ModelAndView toModiList() throws Exception {
		Map<String, List> data = new HashMap<String, List>();
		return new ModelAndView("reg/server/registinfo/registinfomodi_list", data);
	}

	/**
	 * 跳转到主体户口分配表格页面
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("toDistributeList")
	public ModelAndView toDistributeList() throws Exception {
		Map<String, List> data = new HashMap<String, List>();

		return new ModelAndView("reg/server/registinfo/registdistribute_list", data);
	}

	/**
	 * 跳转到主体户口--委托管理表格页面
	 *
	 * @return ModelAndView
	 */
	@RequestMapping("toDelegateList")
	public ModelAndView toDelegateList() throws Exception {
		Map<String, List> data = new HashMap<String, List>();
		// //企业类型大类
		// List<CodeEntcatg> codeEntCatgList = codeEntcatgService.selectAll();
		// //管辖单位
		// List<CodeRegunit> codeRegUnitList = codeRegunitService.selectAll();
		// //登记机关
		// List<CodeRegorg> codeRegorgs =
		// codeRegorgService.selectCodeRegorgList();
		// data.put("codeEntCatgList",codeEntCatgList);
		// data.put("codeRegUnitList",codeRegUnitList);
		// data.put("codeRegorgList",codeRegorgs);

		return new ModelAndView("reg/server/registinfo/registdelegate_list", data);
	}

	/**
	 * 跳转到主体户口退回表格页面
	 *
	 * @return ModelAndView
	 */

	@RequestMapping("toBackList")
	public ModelAndView toBackList() throws Exception {
		Map<String, List> data = new HashMap<String, List>();

		return new ModelAndView("reg/server/registinfo/registback_list", data);
	}

	/**
	 * 跳转到变更详情页面
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toAgainDetail")
	public ModelAndView toAgainDetail(String priPID) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("priPID", priPID);
		return new ModelAndView("reg/server/registinfo/againdetail_list", data);
	}

	/**
	 * 跳转到主体户口建档编辑\修改编辑页面
	 *
	 * @param registInfoDtop
	 * @return ModelAndView
	 */
	@RequestMapping("toShow")
	public ModelAndView toShow(RegistInfoDto registInfoDtop, String fromtype, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> data = new HashMap<String, Object>();
		String priPID = registInfoDtop.getPriPID();
		if (StringUtil.isNotEmpty(fromtype) && (fromtype.equals("single") || fromtype.equals("print"))) {
			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("priPID", priPID);
			// 索引查询基本信息
			MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid(priPID);
			if (midBaseInfoDto == null) {// 索引查询数据为空，查询数据库
				midBaseInfoDto = registInfoService.selectMidBaseInfoByPripid(registInfoDtop.getPriPID());
			}
			// 获取标记状态
			data = getAllState(priPID, data, midBaseInfoDto);
			// 主体户口建档信息
			RegistInfoDto registInfoDto = registInfoService.getRegistInfoByID(midBaseInfoDto, registInfoDtop);
			// 获取主体当前有效的标签
			List<PubApprMarkRel> ownmarks = new ArrayList<PubApprMarkRel>();

			List<PubApprMarkRelDto> ownmarkGroups = new ArrayList<PubApprMarkRelDto>();
			// 未建档的变更重建档不需要查询。
			// if (registInfoDtop == null ||
			// ("1".equals(registInfoDtop.getIsChangeArch()) &&
			// registInfoDtop.getArchState().equals("0"))){
			// }else{
			ownmarks = pubApprMarkRelService.queryListByPripid(priPID);
			// 拼接参数用（group参数）
			ownmarkGroups = pubApprMarkRelService.selectMainMarkRelDtoByPriPIDGroup(priPID);
			// }
			// 许可证表
			List<PubOtherlicence> pubOtherlicences = pubOtherlicenceService
					.selectOtherlicencesByPriPid(registInfoDtop.getPriPID());
			data.put("registInfoDto", registInfoDto);
			data.put("sysUser", sysUser);
			data.put("ownmarks", ownmarks);
			data.put("ownmarkGroups", ownmarkGroups);
			data.put("pubOtherlicences", pubOtherlicences);
			data.put("midBaseInfoDto", midBaseInfoDto);
			data.put("size", ownmarks.size());

		}
		data.put("fromtype", fromtype);
		if (StringUtil.isNotEmpty(fromtype) && fromtype.equals("print")) {
			return new ModelAndView("reg/server/registinfo/registinfo_print", data);
		}
		return new ModelAndView("reg/server/registinfo/registinfo_edit", data);

	}

	/**
	 * 描述：添加勘察记录
	 * 
	 * @author baifangfang
	 * @date 2017年8月16日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addRecordPage")
	public ModelAndView addRecordPage(@RequestParam String priPID, String uid) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/registinfo/registinfo_addrecord");
		view.addObject("priPID", priPID);
		if (!StringUtil.isEmpty(uid)) {
			RegistSurver registSurver = registSurverService.selectRegistSurverByUidAndPriPID(uid, priPID);
			view.addObject("registSurver", registSurver);
		}
		return view;
	}

	/**
	 * 描述：添加或修改勘察记录
	 * 
	 * @author baifangfang
	 * @date 2017年8月18日
	 * @param registSurver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "editRecord", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addRecord(@RequestBody RegistSurver registSurver) throws Exception {
		int res = registSurverService.editRecord(registSurver);
		if (res < 1) {
			return AjaxResult.error("操作失败！");
		} else {
			return AjaxResult.success("操作成功!");
		}
	}

	/**
	 * 描述：获取勘察记录列表
	 * 
	 * @author baifangfang
	 * @date 2017年8月18日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("registSurverList.json")
	@ResponseBody
	public PageResponse<RegistSurver> registSurverListJSON(PageRequest request) throws Exception {
		List<RegistSurver> registSurverList = registSurverService.registSurverPage(request);
		return new PageResponse<RegistSurver>(registSurverList);
	}

	/**
	 * 建档或者修改建档企业.单个建档、修改
	 *
	 * @param registInfoDto
	 * @return AjaxResult
	 */
	@RequestMapping(value = "/modi", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult modi(@RequestBody RegistInfoDto registInfoDto, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (StringUtil.isEmpty(registInfoDto.getPriPID()))
			return AjaxResult.error("企业序列号不存在！");

		// 查询是否进行实地勘察
		List<RegistSurver> registSurverList = registSurverService.findByRegistSurversPriPID(registInfoDto.getPriPID());
		if (registSurverList != null && registSurverList.size() > 0) {
			registInfoDto.setIsInvestigate("1");
		}

		String archState = registInfoDto.getArchState();
		String isChangeArch = registInfoDto.getIsChangeArch();
		// 初始化建档日期和创建日期(未建档)
		if (!"1".equals(registInfoDto.getArchState())) {
			registInfoDto.setArchState("1");// 不是未建档改成已建档
			registInfoDto.setArchDate(new Date());// 建档日期
		}
		registInfoDto.setCreateTime(new Date());
		// 修改日期
		registInfoDto.setModDate(new Date());
		// 建档人
		registInfoDto.setArchName(sysUser.getRealName());
		int res = registInfoService.modi(registInfoDto, sysUser);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			if(!"1".equals(archState)){//未建档，更新待建档缓存数据
				//操作成功后  缓存重新设置（建档成功，新设待建档-n）
//					SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					try {
						Map<String, Object> forBidmap = new HashMap<String, Object>();
						String regOrg = selectRegorgByDeptCode(sysUser);
						creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
						forBidmap.put("regOrg", regOrg);
						regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 5, res,"2",sysUser);
					} catch (Exception e) {
						return AjaxResult.success("操作成功!");
					}
				
			}
		    //变更重建档，更新变更户待建档缓存数据
	        if(isChangeArch != null && isChangeArch.equals("1")){
				//操作成功后  缓存重新设置（建档成功，变更待建档-n）
//				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				try {
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					String regOrg = selectRegorgByDeptCode(sysUser);
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					forBidmap.put("regOrg", regOrg);
//					regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 6, res,"2",sysUser);
				} catch (Exception e) {
					return AjaxResult.success("操作成功!");
				}
	        }
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 跳转到认领页面
	 *
	 * @param registInfoDto
	 * @return ModelAndView
	 */
	@RequestMapping("toClaim")
	public ModelAndView toClaim(RegistInfoDto registInfoDto, String fromtype) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		// 企业基本信息
		MidBaseInfoDto midBaseInfoDto = registInfoService.selectMidBaseInfoByPripid(registInfoDto.getPriPID());
		data.put("midBaseInfoDto", midBaseInfoDto);
		if (fromtype.equals("back")) {
			UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
			registInfoDto.setBackName(userProfile.getUsername());
			registInfoDto.setBackTime(new Date());
		}
		// 认领退回里面的管辖单位取建档表里面的管辖单位
		RegistInfoDto registLoadm = registInfoService.selectRegistInfoByPriPID(midBaseInfoDto.getPriPID());
		if (registLoadm != null) {
			midBaseInfoDto.setLocalAdm(registLoadm.getLocalAdm());
			midBaseInfoDto.setLocalAdmName(registLoadm.getLocalAdmName());
		}

		data.put("registInfoDto", registInfoDto);
		data.put("fromtype", fromtype);
		return new ModelAndView("reg/server/registinfo/claim_edit", data);

	}

	/**
	 * 跳转到主体标签分类编辑页面
	 *
	 * @param
	 * @return ModelAndView
	 */
	// @RequestMapping("toMarkAdd")
	// public ModelAndView toMarkAdd(String iDCode, String iDName, String
	// iDType, String iDTypename) throws Exception {
	// Map<String, Object> data = new HashMap<String, Object>();
	//
	// Map param = new HashedMap();
	// param.put("markFunc", iDType);
	// param.put("markState", "1");
	// List<CsWarnMark> registMarks =
	// csWarnMarkService.selectCsWarnMarkList(param);
	//
	// data.put("registMarks", registMarks);
	// data.put("iDCode", iDCode);
	// data.put("iDName", iDName);
	// data.put("iDTypename", iDTypename);
	// data.put("iDType", iDType);
	// return new ModelAndView("reg/server/registinfo/addmark_edit", data);
	// }

	/**
	 * 
	 * 描述:标签目录编辑
	 * 
	 * @auther gaojinling
	 * @date 2017年4月20日
	 * @param session
	 * @param markUuid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toMarkAdd")
	public ModelAndView toMainmarkapplyEdit(HttpSession session, String markUuid, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/registinfo/mainmark_edit");
		view.addObject("priPID", priPID);
		// MainMarkDto mainMarkDto = mainMarkService.queryViewByMarkPriPID
		// (priPID);
		// view.addObject ("mainMarkDto", mainMarkDto);
		// view.addObject ("markUuid", mainMarkDto == null ? "" :
		// mainMarkDto.getMarkUuid());
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("nowDate", DateUtil.getCurrentDate());
		return view;
	}

	/**
	 * 跳转到片区商圈编辑页面
	 *
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping("tosliceNOAdd")
	public ModelAndView tosliceNOAdd(String sliceNOName, String sliceNO, String supCode) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("sliceNO", sliceNO);
		data.put("sliceNOName", sliceNOName);
		data.put("supCode", supCode);
		return new ModelAndView("reg/server/registinfo/addsliceno_edit", data);
	}

	/**
	 * 跳转到管辖人员编辑页面
	 *
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping("toSlicemanAdd")
	public ModelAndView toSlicemanAdd(String sliceTel, String sliceMan) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("sliceTel", sliceTel);
		data.put("sliceMan", sliceMan);
		return new ModelAndView("reg/server/registinfo/addsliceman_edit", data);
	}

	/**
	 * 跳转到街道编辑页面
	 *
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping("tostreetAdd")
	public ModelAndView tostreetAdd(String code, String content, String supCode) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("code", code);
		data.put("content", content);
		data.put("supCode", supCode);
		return new ModelAndView("reg/server/registinfo/addstreet_edit", data);
	}

	/**
	 * 跳转到监管项目编辑页面
	 *
	 * @param
	 * @return ModelAndView
	 */
	@RequestMapping("toSuperAdd")
	public ModelAndView toSuperAdd(String superNoNames, String superNos, String superType) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		// 监管项目表，查询全部
		List<SuperItem> superItems = superItemService.selectSuperItemsByType(superType);
		data.put("superNoNames", superNoNames);// 已选择的列表
		data.put("superType", superType);// 已选择的列表
		data.put("superNos", superNos);// 已选择的列表
		data.put("superItems", superItems);// 全部的
		return new ModelAndView("reg/server/registinfo/addsuper_edit", data);

	}

	/**
	 * 跳转到销户页面
	 *
	 * @return ModelAndView
	 */
	/*
	 * @RequestMapping("toLogoff") public ModelAndView toLogoff() throws
	 * Exception { Map<String, Object> data = new HashMap<String, Object>();
	 * return new ModelAndView("reg/server/registinfo/logoff_edit", data); }
	 */

	/**
	 * 跳转到批量分配编辑页面
	 *
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "toBatchDistribute")
	public ModelAndView toBatchDistribute(String sliceMan, String sliceTel, String priPID, String fromtype,
			String localAdm) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
		RegistInfoDto registInfoDto = new RegistInfoDto();
		registInfoDto.setSliceTel(sliceTel);
		registInfoDto.setSliceMan(sliceMan);
		registInfoDto.setPriPID(priPID);
		registInfoDto.setSetName(userProfile.getUsername());
		registInfoDto.setSetTime(new Date());
		registInfoDto.setLocalAdm(localAdm);
		data.put("registInfoDto", registInfoDto);
		data.put("fromtype", fromtype);
		return new ModelAndView("reg/server/registinfo/batchdistribute_edit", data);
	}

	/**
	 * 跳转到批量设置委托编辑页面
	 *
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "toBatchDele", method = RequestMethod.GET)
	public ModelAndView toBatchDele(String priPID) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		SysUser sysUser = (SysUser) getSession().getAttribute(Constants.SESSION_SYS_USER);
		RegistInfoDto registInfoDto = new RegistInfoDto();
		registInfoDto.setPriPID(priPID);
		registInfoDto.setDelegateName(sysUser.getRealName());
		registInfoDto.setComDate(new Date());
		data.put("registInfoDto", registInfoDto);
		return new ModelAndView("reg/server/registinfo/batchdelegate_edit", data);
	}

	/**
	 * 跳转到批量退回页面
	 *
	 * @param priPID
	 * @param show
	 * @return ModelAndView
	 */
	@RequestMapping("toBatchBack")
	public ModelAndView toBatchBack(String priPID, String show) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		UserProfile userProfile = (UserProfile) getSession().getAttribute(Constants.SESSION_SYS_USER_KEY);
		RegistInfoDto registInfoDto = new RegistInfoDto();
		registInfoDto.setPriPID(priPID);
		registInfoDto.setBackName(userProfile.getUsername());
		registInfoDto.setBackTime(new Date());

		data.put("registInfoDto", registInfoDto);
		// data.put("show",show);
		return new ModelAndView("reg/server/registinfo/batchback_edit", data);
	}

	// -------------------------------------------------逻辑操作方法--------------------------------------

	/**
	 * 请求建档页面的列表数据:企业基础表cs_mid_baseinfo和建档表cs_regist_info的数据联合
	 *
	 * @param request
	 * @return PageResponse
	 */
	@RequestMapping("/againList.json")
	@ResponseBody
	public PageResponse<RegistInfoDto> againList(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		List<RegistInfoDto> data = registInfoService.registInfoAgainQueryPage(request);
		return new PageResponse<RegistInfoDto>(data);
	}

	/**
	 * 请求建档维护页面的列表数据：cs_regist_info
	 *
	 * @param request
	 * @return PageResponse
	 */
	@RequestMapping("/modiList.json")
	@ResponseBody
	public PageResponse<RegistInfoDto> modiList(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		List<RegistInfoDto> data = registInfoService.registModiInfoQueryPage(request);
		return new PageResponse<RegistInfoDto>(data);
	}

	/**
	 * 请求建档分配页面的列表数据：cs_regist_info，只查询建档表的分配状态是1和3的
	 *
	 * @param request
	 * @return PageResponse
	 */
	@RequestMapping("/distributeList.json")
	@ResponseBody
	public PageResponse<RegistInfoDto> distributeList(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		List<RegistInfoDto> data = registInfoService.registDistributeInfoQueryPage(request);
		return new PageResponse(data);
	}

	/**
	 * 请求户口委托页面的列表数据：cs_regist_info， 查询建档表中市局和省局的企业（登记机关后2为0的），且分配状态是1（未分配）
	 *
	 * @param request
	 * @return PageResponse
	 */
	@RequestMapping("/delegateList.json")
	@ResponseBody
	public PageResponse<RegistInfoDto> delegateList(PageRequest request) throws Exception {
		List<RegistInfoDto> data = registInfoService.registDelegateInfoQueryPage(request);
		return new PageResponse(data);
	}

	/**
	 * 变更详情列表数据
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/againdetailList.json")
	@ResponseBody
	public PageResponse<MidAltitemDto> againdetailList(PageRequest request) throws Exception {
		if (request.getParams() != null) {
			request.getParams().put("altDateOrder", "desc");
		}
		List<MidAltitemDto> data = midAltitemService.queryPageResult(request);
		return new PageResponse(data);
	}

	/**
	 * 描述: 根据管辖单位选择街道
	 *
	 * @return
	 * @throws Exception
	 * @auther liuhq
	 * @date 2016年10月19日
	 */
	@RequestMapping("/getStreetBynode")
	@ResponseBody
	public AjaxResult getStreetBynode(String supCode) throws Exception {
		List<CodeStreet> data = codeStreetService.getStreetBySupNode(supCode);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 描述: 片区选择json 根据管辖单位选择片区商圈
	 *
	 * @return
	 * @throws Exception
	 * @auther liuhq
	 * @date 2016年10月19日
	 */
	@RequestMapping("/getSlicenoBynode")
	@ResponseBody
	public AjaxResult getSlicenoBynode(String supCode) throws Exception {
		CodeSliceno codeSliceno = new CodeSliceno();
		codeSliceno.setSupCode(supCode);
		List<CodeSliceno> data = codeSlicenoService.getSlicenoBynode(codeSliceno);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 描述: 根据上级机关选择登记机关
	 *
	 * @return
	 * @throws Exception
	 * @auther liuhq
	 * @date 2016年10月19日
	 */
	@RequestMapping("/getRegorgByPcode")
	@ResponseBody
	public AjaxResult getRegorgByPcode(String code) throws Exception {
		List<CodeRegorg> data = codeRegorgService.getRegorgByPcode(code);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 描述: 根据部门选择管辖人员
	 *
	 * @return
	 * @throws Exception
	 * @auther liuhq
	 * @date 2016年10月19日
	 */
	@RequestMapping("/getsliceManByDept")
	@ResponseBody
	public AjaxResult getsliceManByDept(String deptCode) throws Exception {
		List<SysUser> data = sysUserService.getsliceManByDept(deptCode);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 认领
	 *
	 * @param registInfo
	 * @return AjaxResult
	 */
	@RequestMapping(value = "/claim", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult claim(@RequestBody RegistInfo registInfo, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		registInfo.setClaimName(sysUser.getRealName());
		registInfo.setClaimCode(sysUser.getUsername());
		registInfo.setClaimState(String.valueOf(Integer.parseInt(registInfo.getClaimState()) + 1));// ：0未认领；1已认领；2超时未认领；3超时认领

		registInfo.setClaimDate(new Date());
		int res = registInfoService.claim(registInfo);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			//操作成功后  缓存重新设置（认领成功，新设待建档+n）
			try {
//				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				String regOrg = selectRegorgByDeptCode(sysUser);
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				forBidmap.put("regOrg", regOrg);
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 5, res,"1",sysUser);
			} catch (Exception e) {
				return AjaxResult.success("操作成功");
			}
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 批量认领
	 *
	 * @param registInfo
	 * @return AjaxResult
	 */
	@RequestMapping(value = "/batchClaim", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batchClaim(String priPIds, String claimStates, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<String> idsList = new ArrayList<String>();
		// 数组转换成LIST
		Collections.addAll(idsList, priPIds.split(","));
		String[] claims = claimStates.split(",");
		int count= 0;
		for (int i = 0; i < idsList.size(); i++) {
			RegistInfo registInfo = new RegistInfo();
			registInfo.setPriPID(idsList.get(i));
			registInfo.setClaimName(sysUser.getRealName());
			registInfo.setClaimCode(sysUser.getUsername());
			registInfo.setClaimState(String.valueOf(Integer.parseInt(claims[i]) + 1));// ：0未认领；1已认领；2超时未认领；3超时认领

			registInfo.setClaimDate(new Date());
			int res = registInfoService.claim(registInfo);
			if (res < 1)
				return AjaxResult.error("操作失败！");
			else{
				count = count+res;
			}
		}
		try {//操作成功后  缓存重新设置（认领成功，新设待建档+n）
//			SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
			creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
			forBidmap.put("regOrg", regOrg);
			regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 5, count,"1",sysUser);
		}catch (Exception e) {
			return AjaxResult.success("操作成功");
		}
		
		return AjaxResult.success("操作成功!");
	}

	public static int getIntervalDays(Date fDate, Date oDate) {
		if (null == fDate || null == oDate) {
			return -1;
		}
		long intervalMilli = oDate.getTime() - fDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}

	/**
	 * 批量建档,批量修改
	 *
	 * @param registInfoDto
	 * @return AjaxResult
	 */
	@RequestMapping(value = "/batchModi")
	@ResponseBody
	public AjaxResult batchModi(@RequestBody RegistInfoDto registInfoDto) throws Exception {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (StringUtil.isEmpty(registInfoDto.getPriPID()))
			return AjaxResult.error("操作失败！");

		String archState = registInfoDto.getArchState();
		String isChangeArch = registInfoDto.getIsChangeArch();
		// 初始化自动设置建档日期等日期
		if (!"1".equals(registInfoDto.getArchState())) {
			registInfoDto.setArchState("1");// 不是已建档改成已建档
			registInfoDto.setArchDate(new Date());// 建档日期
		}
		registInfoDto.setCreateTime(new Date());
		int res = registInfoService.batchModi(registInfoDto, sysUser);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			if(!"1".equals(archState)){//未建档，更新待建档缓存数据
				//操作成功后  缓存重新设置（建档成功，新设待建档-n）
//					SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					try {
						Map<String, Object> forBidmap = new HashMap<String, Object>();
						String regOrg = selectRegorgByDeptCode(sysUser);
						creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
						forBidmap.put("regOrg", regOrg);
						regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 5, res,"2",sysUser);
					} catch (Exception e) {
						return AjaxResult.success("操作成功!");
					}
				
			}
		    //变更重建档，更新变更户待建档缓存数据
	        if(isChangeArch != null && isChangeArch.equals("1")){
				//操作成功后  缓存重新设置（建档成功，变更待建档-n）
//				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				try {
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					String regOrg = selectRegorgByDeptCode(sysUser);
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					forBidmap.put("regOrg", regOrg);
//					regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 6, res,"2",sysUser);
				} catch (Exception e) {
					return AjaxResult.success("操作成功!");
				}
	        }
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 销户
	 *
	 * @param ulManage
	 * @return AjaxResult
	 */
	@RequestMapping("/logoff")
	@ResponseBody
	public AjaxResult logoff(UlManage ulManage) throws Exception {
		int res = ulManageService.addUlManage(ulManage);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 批量分配
	 *
	 * @param RegistInfoDto
	 * @return AjaxResult
	 */
	@RequestMapping(value = "batchDistribute", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batchDistribute(@RequestBody RegistInfoDto RegistInfoDto) throws Exception {
		int res = registInfoService.batchDistribute(RegistInfoDto);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			//操作成功后  缓存重新设置（批量分配成功，待分配项-1）
			try {
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				String regOrg = selectRegorgByDeptCode(sysUser);
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				forBidmap.put("regOrg", regOrg);
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 7, res,"2",sysUser);
			} catch (Exception e) {
				return AjaxResult.success("操作成功");
			}
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 批量设置委托
	 *
	 * @param registInfo
	 * @return AjaxResult
	 */
	@RequestMapping(value = "batchDelegate", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batchDelegate(@RequestBody RegistInfo registInfo) throws Exception {
		int res = registInfoService.batchDelegate(registInfo);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 批量取消委托
	 *
	 * @param priPID
	 * @return AjaxResult
	 */
	@RequestMapping(value = "batchcancelDelegate")
	@ResponseBody
	public AjaxResult batchcancelDelegate(String priPID) throws Exception {
		RegistInfo registInfo = new RegistInfo();
		registInfo.setPriPID(priPID);
		registInfo.setDelegateName("");
		registInfo.setDelegateOrg("");
		registInfo.setDelegateOrgName("");
		registInfo.setRegistSource("3");
		int res = registInfoService.batchDelegate(registInfo);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 批量退回
	 *
	 * @param registInfo
	 * @return AjaxResult
	 */
	@RequestMapping(value = "/batchBack", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult batchBack(@RequestBody RegistInfoDto registInfo) throws Exception {
		int res = registInfoService.batchBack(registInfo);
		if (res < 1)
			return AjaxResult.error("操作失败！");
		else
			//操作成功后  缓存重新设置（批量退回成功，待分配项+n）
			try {
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				String regOrg = selectRegorgByDeptCode(sysUser);
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				forBidmap.put("regOrg", regOrg);
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 7, res,"1",sysUser);
			} catch (Exception e) {
				return AjaxResult.success("操作成功");
			}
			return AjaxResult.success("操作成功!");
	}

	/**
	 * 
	 * 描述 检查企业是否是异常名录和严重违法 @author 赵祥江 @date 2017年3月21日 下午2:41:58 @param @return
	 * String @throws
	 */
	private String checkIsOpanomaly(String entTypeCatg, String priPID) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		String opanomaly = "0";
		String seriousCrime = "0";
		if ("50".equals(entTypeCatg)) {
			List<PubPbopanomalyDto> dataList = pubPbopanomalyService.pubPbopanomalySearchRecoverList(map);
			if (dataList != null && dataList.size() > 0) {
				opanomaly = "1";
			}
		} else {
			List<PubOpaDetailDto> dataList = pubOpaDetailService.selectAddMoveOutSearch(map);
			if (dataList != null && dataList.size() > 0) {
				opanomaly = "1";
			}
		}
		List<ExpSeriousCrimeList> expSeriousCrimeList = expSeriousCrimeListService
				.selectSeriousCrimeInfoByPriPID(priPID);
		if (expSeriousCrimeList != null && expSeriousCrimeList.size() > 0) {
			seriousCrime = "1";
		}
		// 同时被列入异常和严重违法
		if ("1".equals(opanomaly) && "1".equals(seriousCrime)) {
			return "1";
		} else if ("1".equals(opanomaly) && !"1".equals(seriousCrime)) {// 只列入异常
			return "2";
		} else if (!"1".equals(opanomaly) && "1".equals(seriousCrime)) {// 只列入严重违法
			return "3";
		} else {
			return "0";
		}
	}

	/**
	 * 
	 * 描述: 获取各种标记状态
	 * 
	 * @auther gaojinling
	 * @date 2017年4月22日
	 * @param priPID
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAllState(String priPID, Map<String, Object> data, MidBaseInfoDto midBaseInfoDto)
			throws Exception {
		List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate(priPID);
		if (midDtos != null && midDtos.size() > 0) {
			midBaseInfoDto.setPunishDate(midDtos.get(0).getPunishDate());
		}
		if (midBaseInfoDto != null) {
			List<QualificationLimit> limits = qualificationLimitService
					.selectLimitPersonInfo(midBaseInfoDto.getPriPID());
			data.put("isLimit", limits);
		}
		// 联络员信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		data.put("liaName", pubEppassword == null ? "" : pubEppassword.getLianame());
		data.put("liaTel", pubEppassword == null ? "" : pubEppassword.getTel());
		data.put("liaidnum", pubEppassword == null ? "" : pubEppassword.getLiaidnum());
		data.put("dto", midBaseInfoDto);
		data.put("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
		data.put("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID(priPID));

		// 监管项目标签
		List<PubApprMarkRelDto> apprMarkRelDtos = pubApprMarkRelService.selectPubApprMarkRelDtoByPriPID(priPID);
		int apprMarkRelSccount = 0;
		if (apprMarkRelDtos != null && apprMarkRelDtos.size() > 0) {
			for (PubApprMarkRelDto apprMarkRelDto : apprMarkRelDtos) { // 查询出
				if (StringUtil.isNotEmpty(apprMarkRelDto.getDoublyStoState())
						&& "1".equals(apprMarkRelDto.getDoublyStoState())) {
					apprMarkRelDto.setMarkName(apprMarkRelDto.getMarkName() + "(专项库)");
					apprMarkRelSccount = apprMarkRelSccount + 1;
				}
			}
		}
		data.put("apprMarkRelDtos", apprMarkRelDtos);
		data.put("apprMarkRelDtoSize", apprMarkRelDtos.size());
		data.put("apprMarkRelSccount", apprMarkRelSccount);

		// List<MainMarkRelDto> mainMarkRelDtoList =
		// mainMarkRelService.qryMainMarkRelDtoByPriPID(priPID);
		// data.put("mainMarkRelDtoList", mainMarkRelDtoList);
		// data.put("mainMarkRelDtoSize", mainMarkRelDtoList.size());
		// //抽查专项库
		// List<pubScSpecialLibrary> pubScSpecialLibraries =
		// pubScSpecialLibraryService.getSpLibraryInfoByPriPID(priPID);
		// data.put("pubScSpecialLibraries", pubScSpecialLibraries);
		// data.put("pubScSpecialLibrariesSize", pubScSpecialLibraries.size());
		// 重点监管对象
		List<CsSuperviseObjDto> csSuperviseObjDtoList = csSuperviseObjService.qryCsSuperviseObjDtoByPriPID(priPID);
		data.put("csSuperviseObjDtoList", csSuperviseObjDtoList);
		data.put("csSuperviseObjDtoSize", csSuperviseObjDtoList.size());

		// 关注服务对象
		List<CsConcernObjDto> csConcernObjDtoList = csConcernObjService.qryCsConcernObjDtoByPriPID(priPID);
		data.put("csConcernObjDtoList", csConcernObjDtoList);
		data.put("csConcernObjDtoSize", csConcernObjDtoList.size());

		// 预警提醒提示
		List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoService.doGetListByPriPID(priPID);
		Date opTo = null;// 经营期限至
		Date licValTo = null;// 许可证有效期至
		Date abnTime = null;// 经营异常名录列入日期
		if (midBaseInfoDtoList != null && midBaseInfoDtoList.size() > 0) {
			opTo = midBaseInfoDtoList.get(0).getOpTo();
		}
		List<PubOtherlicenceDto> pubOtherlicenceDtoList = pubOtherlicenceService.selectOtherlicenceListByPriPID(priPID);
		if (pubOtherlicenceDtoList != null && pubOtherlicenceDtoList.size() > 0) {
			licValTo = pubOtherlicenceDtoList.get(0).getLicValTo();
		}
		if ("50".endsWith(midBaseInfoDto.getEntTypeCatg())) {
			List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.selectPubPbopanomalyPriPID(priPID);
			if (pubPbopanomalyDtoList != null && pubPbopanomalyDtoList.size() > 0) {
				abnTime = pubPbopanomalyDtoList.get(0).getCogDate();
			}
		} else {
			List<PubOpanoMalyDto> pubOpanoMalyDtoList = pubOpanoMalyService.selectPubOpanoMalyServicePriPID(priPID);
			if (pubOpanoMalyDtoList != null && pubOpanoMalyDtoList.size() > 0) {
				abnTime = pubOpanoMalyDtoList.get(0).getAbnTime();
			}
		}
		List<String> tips = new ArrayList<String>();
		Date after30 = DateUtil.addDays(new Date(), 30);// 当前时间后30天
		Date after60 = DateUtil.addDays(new Date(), 60);// 当前时间后60天

		if (opTo != null && (opTo.getTime() > new Date().getTime() && opTo.getTime() <= after30.getTime())) {
			tips.add("经营期限即将到期");
		} else if (opTo != null && opTo.getTime() <= new Date().getTime()) {
			tips.add("经营期限已经到期");
		}
		if (licValTo != null
				&& (licValTo.getTime() > new Date().getTime() && licValTo.getTime() <= after30.getTime())) {
			tips.add("许可证即将到期");
		} else if (licValTo != null && licValTo.getTime() <= new Date().getTime()) {
			tips.add("许可证已经到期");
		}

		if (abnTime != null) {
			Date abnTimeAfter3year = DateUtil.addYears(abnTime, 3);// 列异时间3年后
			if (abnTimeAfter3year.getTime() < after60.getTime() && abnTimeAfter3year.getTime() > new Date().getTime()) {
				tips.add("列入经营异常即将届满3年");
			}
		}
		// 查询风险预警提示标签
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("priPID", priPID);

		List<CsEntWarnDto> csEntWarnDtos = csEntWarnService.selectCsEntWarnMarks(params);
		for (CsEntWarnDto csEntWarnDto : csEntWarnDtos) {
			tips.add(csEntWarnDto.getMarkName());
		}

		data.put("tips", tips);
		data.put("tipsSize", tips.size() + csEntWarnDtos.size());

		return data;
	}

}