/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeAddress;
import com.icinfo.cs.base.service.ICodeAddressService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.party.dto.PartyMemberInfoDto;
import com.icinfo.cs.party.model.PartyEntInfo;
import com.icinfo.cs.party.model.PartyMemberInfo;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.party.service.IPartyEntInfoService;
import com.icinfo.cs.party.service.IPartyMemberInfoService;
import com.icinfo.cs.party.service.IPartyOrganizeInfoService;
import com.icinfo.cs.registinfo.dto.PubApprMarkRelDto;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.rpt.rptdto.RptPartyCliamInfoDto;
import com.icinfo.cs.rpt.rptservice.IRptPartyCliamInfoService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.service.IYrOtherInfoService;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_party_member_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
@Controller("ServerPartyMemberInfo")
@RequestMapping({"/syn/server/party/member","/reg/server/party/member","/commom/server/party/member"})
public class PartyMemberInfoController extends CSBaseController {
	
	private Map<String, Object> dataParmMap;
	@Autowired
	private IPartyMemberInfoService partyMemberInfoService;
	@Autowired
	private IRptPartyCliamInfoService rptPartyCliamInfoService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private IQualificationLimitService qualificationLimitService;
	@Autowired
	private IErEscAppinfoService erEscAppinfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	private IPubApprMarkRelService pubApprMarkRelService;
	@Autowired
	private ICsSuperviseObjService csSuperviseObjService;
	@Autowired
	private ICsConcernObjService csConcernObjService;
	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	@Autowired
	ICsWarnMarkService csWarnMarkService;
	@Autowired
	ICsEntWarnService csEntWarnService;
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	@Autowired
	private IYrOtherInfoService yrOtherInfoService;
	@Autowired
    private IPartyEntInfoService partyEntInfoService;
	@Autowired
	private IMidLeRepService midLeRepService;
	@Autowired
	private ICodeAddressService codeAddressService;
	@Autowired
	private IPartyOrganizeInfoService partyOrganizeInfoService;
	
	/**
	 * 描述: 进入党员户口认领列表页面
	 * @auther yujingwei
	 * @date 2017年8月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("cliamlist")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_member_cliam_list");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	 /**
     * 描述: 进入党员户口新增列表页面
     * @auther yujingwei
     * @date 2017年8月18日
     * @return view
     * @throws Exception
     */
    @RequestMapping("addlist")
    public ModelAndView addlist() throws Exception {
    	ModelAndView view = new ModelAndView("/reg/server/partycreate/party_member_add_list");
    	view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
    	return view;
    }
    
    /**
   	 * 描述: 进入党员户口维护列表页面
   	 * @auther yujingwei
   	 * @date 2017年9月6日
   	 * @return view
   	 * @throws Exception
   	 */
   	@RequestMapping("maintainlist")
   	public ModelAndView maintainList() throws Exception {
   		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_member_maintain_list");
   		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
   		return view;
   	}
   	
   	/**
   	 * 描述: 进入党员户口查询列表页面
   	 * @auther yujingwei
   	 * @date 2017年9月6日
   	 * @return view
   	 * @throws Exception
   	 */
   	@RequestMapping("searchlist")
   	public ModelAndView searchlist() throws Exception {
   		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_member_search_list");
   		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
   		return view;
   	}
   	
    
    /**
	 * 描述: 进入党员户口新增企业选择页面
	 * @auther yujingwei
	 * @date 2017年8月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("addChoose")
	public ModelAndView addChoose() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_member_add_choose");
		return view;
	}
	
    /**
     * 描述: 查询党员户口认领列表
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
    @RequestMapping({"/partycliam.json", "list.xml"})
    @ResponseBody
	public PageResponse<RptPartyCliamInfoDto> queryPartyOrgInfo(PageRequest request) throws Exception{
    	creatDefaultDBAuthEnv(request, "a.checkDep", "a.localAdm");
    	List<RptPartyCliamInfoDto> data = rptPartyCliamInfoService.queryRptPartyCliamInfo(request);
    	Integer total = rptPartyCliamInfoService.queryCountRptPartyCliamInfo(request);
    	return new PageResponse<RptPartyCliamInfoDto>(data, total, request);
    }
    
    /**
     * 描述: 查询党员户口新增列表
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
    @RequestMapping({"/partyadd.json", "list.xml"})
    @ResponseBody
    public PageResponse<PartyMemberInfoDto> partyadd(PageRequest request) throws Exception{
    	creatDefaultDBAuthEnv(request, "a.checkDep", "a.localAdm");
    	List<PartyMemberInfoDto> data = partyMemberInfoService.queryPartyMemberAddInfo(request);
    	return (new PageResponse<PartyMemberInfoDto>(data));
    }
    
	 /**
     * 描述: 查询党员户口维护列表
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
    @RequestMapping({"/partymaintain.json", "list.xml"})
    @ResponseBody
    public PageResponse<PartyMemberInfoDto> partymaintain(PageRequest request) throws Exception{
    	creatDefaultDBAuthEnv(request, "a.checkDep", "a.localAdm");
    	if (dataParmMap != null) {
			dataParmMap.clear();
		}
    	dataParmMap = getRequestParam(request);
    	List<PartyMemberInfoDto> data = partyMemberInfoService.queryPartyMemberMaintainInfo(request);
    	return (new PageResponse<PartyMemberInfoDto>(data));
    }
    
    /**
     * 描述: 查询党员户口新增列表
     * @auther yujingwei
     * @date 2016年9月20日 
     * @param request
     * @return PageResponse
     * @throws Exception
     */
    @RequestMapping({"/partyYearInfo.json", "list.xml"})
    @ResponseBody
    public PageResponse<PartyMemberInfoDto> partyYearInfo(PageRequest request) throws Exception{
    	List<PartyMemberInfoDto> data = partyMemberInfoService.doGetParty3YearInfo(request);
    	return new PageResponse<PartyMemberInfoDto>(data, 3, request);
    }
    
	/**
	 * 描述: 进入党员户口认领详情页
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("addOrModifyView")
	public ModelAndView addOrModifyView(String memberUid, String viewFlag, String priPID, String businessType, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView();
		if (StringUtils.equals(businessType, "2")){
			view = new ModelAndView("/reg/server/partycreate/party_member_add_edit");
		}else if(StringUtils.equals(businessType, "3")){
			view = new ModelAndView("/reg/server/partycreate/party_member_maintain_edit");
		}else if(StringUtils.equals(businessType, "4")){
			view = new ModelAndView("/reg/server/partycreate/party_member_search_edit");
		}else{
			view = new ModelAndView("/reg/server/partycreate/party_member_cliam_edit");
		}
		
		if (StringUtils.isNotBlank(memberUid) && !"null".equalsIgnoreCase(memberUid)) {
			PartyMemberInfo partyMemberInfo = partyMemberInfoService.selectPartyMemberInfoByUid(memberUid);
			List<CodeAddress> codeAddresses = codeAddressService.selectCountyListByCityCode(partyMemberInfo.getLocCity());
		    view.addObject("partyMemberInfo", partyMemberInfo);
		    view.addObject("codeAddresses", codeAddresses);
		}else{
			PartyMemberInfo partyMemberInfo = new PartyMemberInfo();
			PartyOrganizeInfo organizeInfo = partyOrganizeInfoService.doGetPartyOrgInfoByPriPID(priPID);
			if (organizeInfo != null){
				partyMemberInfo.setPartyOrgName(organizeInfo.getPartyOrgName());
				partyMemberInfo.setPartyOrgID(organizeInfo.getUID());
				view.addObject("partyMemberInfo", partyMemberInfo);
			}
		}
		
		List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", priPID);
		if (leRepList != null && leRepList.size() > 0) {
			Map<String,Object> map = CardUtil.getCertNOInfo(leRepList.get(0).getCerNO());
			String age = "";
			String birthDay = "";
			String sex = "";
			if (map != null) {
				if (map.get("age") != null) {
					age = (String)map.get("age");
				}
				if (map.get("birthDay") != null){
					birthDay = (String)map.get("birthDay");
				}
				if (map.get("sex") != null) {
					sex = (String)map.get("sex");
				}
			}
			view.addObject("sex", sex);
			view.addObject("age", age);
			view.addObject("birthDay", birthDay);
			view.addObject("midLeRep", leRepList.get(0));
		}
		PartyEntInfo partyEntInfo = partyEntInfoService.doGetPartyEntInfoByPriPID(priPID);
		view.addObject("partyEntInfo", partyEntInfo);
		view.addObject("viewFlag", viewFlag);
		return getModelAndView(view,sysUser,priPID);
	}
	
	/**
	 * 描述: 详情页公共ModelAndView
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @return view
	 * @throws Exception
	 */
	private ModelAndView getModelAndView(ModelAndView view, SysUserDto sysUser, String priPID) throws Exception{
		// 基本信息
		MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid(priPID);
		List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate(priPID);
		if (midDtos != null && midDtos.size() > 0) {
			midBaseInfoDto.setPunishDate(midDtos.get(0).getPunishDate());
		}
		if (midBaseInfoDto != null) {
			List<QualificationLimit> limits = qualificationLimitService
					.selectLimitPersonInfo(midBaseInfoDto.getPriPID());
        	view.addObject("isLimit", limits);
		}

		String entTypeFlag = "";
		String entTypeCatg = midBaseInfoDto.getEntTypeCatg();
		if (entTypeCatg.equals(Constants.entTypeCatgPB)) {
			entTypeFlag = "03";
		} else if (Constants.entTypeCatgSFC.indexOf(entTypeCatg) != -1) {
			entTypeFlag = "02";
		} else {
			entTypeFlag = "01";
		}
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("entTypeFlag", entTypeFlag);
		view.addObject("liaName", pubEppassword == null ? "" : pubEppassword.getLianame());
		view.addObject("liaTel", pubEppassword == null ? "" : pubEppassword.getTel());
		view.addObject("dto", midBaseInfoDto);
		view.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
		view.addObject("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID(priPID));
		view.addObject("sysUser", sysUser);
		
		// 最新一年党建年报情况
		List<PartyMemberInfoDto> infoDtos = partyMemberInfoService.doGetPartyLastYearInfo(priPID, midBaseInfoDto.getEntType());
		if(CollectionUtils.isNotEmpty(infoDtos)){
			view.addObject("lastYearInfo", infoDtos.get(0));
		}
		
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
		view.addObject("apprMarkRelDtos", apprMarkRelDtos);
		view.addObject("apprMarkRelDtoSize", apprMarkRelDtos.size());
		view.addObject("apprMarkRelSccount", apprMarkRelSccount);
		// 重点监管对象
		List<CsSuperviseObjDto> csSuperviseObjDtoList = csSuperviseObjService.qryCsSuperviseObjDtoByPriPID(priPID);
		view.addObject("csSuperviseObjDtoList", csSuperviseObjDtoList);
		view.addObject("csSuperviseObjDtoSize", csSuperviseObjDtoList.size());

		// 关注服务对象
		List<CsConcernObjDto> csConcernObjDtoList = csConcernObjService.qryCsConcernObjDtoByPriPID(priPID);
		view.addObject("csConcernObjDtoList", csConcernObjDtoList);
		view.addObject("csConcernObjDtoSize", csConcernObjDtoList.size());

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
		view.addObject("tips", tips);
		view.addObject("tipsSize", tips.size());
		return view;
	}
	
	/**
	 * 描述 :检查是否是异常名录和严重违法
	 * @author yujingwei
	 * @date 2017年6月14日
	 * @param entTypeCatg，priPID
	 * @return ModelAndView
	 * @throws Exception
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
	 * 描述：保存或修改党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param organizeInfo
	 * @param  session
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=1000)
	public AjaxResult doSaveOrEditFavorableInfo(PartyMemberInfo memberInfo,PartyEntInfo entInfo, HttpSession session) throws Exception{
		int insertSta;
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (StringUtils.isNotBlank(memberInfo.getUID())) {
			insertSta = partyMemberInfoService.doUpdatePartyMemberInfoInfo(memberInfo, sysUser, entInfo);
			if (insertSta > 0) {
				return AjaxResult.success("更新成功！");
			}
		}else{
			insertSta = partyMemberInfoService.doSavePartyMemberInfoInfo(memberInfo, sysUser, entInfo);
			if (insertSta > 0) {
				return AjaxResult.success("保存成功！");
			}
		}
		if (insertSta == 0) {
			return AjaxResult.error("已存在身份证号相同的党员信息！");
		}else if(insertSta == -1) {
			return AjaxResult.error("同一个企业只允许有一个业主党员！");
		}else if(insertSta == -2) {
			return AjaxResult.error("该党组织已经存在");
		}
		return AjaxResult.error("保存失败！");
	}
	
	/**
	 * 描述：提交党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param priPID
	 * @throws Exception
	 */
	@RequestMapping(value = "/commitAll", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=2000)
	public AjaxResult doCommitAllPartyMemberInfo(String priPID) throws Exception{
		if(StringUtils.isNotBlank(priPID)){
			if (partyMemberInfoService.doCommitPartyMemberInfo(priPID)) {
				return AjaxResult.success("提交成功！");
			}
		}
		return AjaxResult.error("保存失败！");
	}
	
	/**
	 * 描述：获取党员数据
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param memberUid
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMemberData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getMemberData(String memberUid) throws Exception{
		if(StringUtils.isNotBlank(memberUid)){
			PartyMemberInfo partyMemberInfo = partyMemberInfoService.selectPartyMemberInfoByUid(memberUid);
			return AjaxResult.success("", partyMemberInfo);
		}
		return AjaxResult.error("");
	}
	
	/**
	 * 描述：初始化党组织
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param memberUid
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDefaultPartyOrg", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getDefaultPartyOrg(String priPID) throws Exception{
		if(StringUtils.isNotBlank(priPID)){
			PartyOrganizeInfo organizeInfo = partyOrganizeInfoService.doGetPartyOrgInfoByPriPID(priPID);
			if(organizeInfo !=null){
				return AjaxResult.success("", organizeInfo);
			}
		}
		return AjaxResult.error("");
	}
	
	/**
	 * 描述：删除党组织信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param UID
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult delete(String UID) throws Exception {
		if (StringUtil.isNotEmpty(UID)) {
			if (partyMemberInfoService.deletePartyMemberInfo(UID) > 0) {
				return AjaxResult.success("删除成功");
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
	/**
	 * 描述：通过身份证号获取出生年月，年龄
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param identityInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/getIdentiInfo", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getIdentiInfo(String identityInfo) throws Exception {
		if (StringUtil.isNotEmpty(identityInfo)) {
			Map<String,Object> map = CardUtil.getCertNOInfo(identityInfo);
			if (map != null){
				return AjaxResult.success("",map);
			}else{
				return AjaxResult.error("");
			}
		}
		return AjaxResult.error("");
	}
	
	/**
	 * 描述：原籍所在地选择
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param identityInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/chooseOriginLoc", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult chooseOriginLoc(String cityCode) throws Exception {
		if (StringUtil.isNotEmpty(cityCode)) {
			List<CodeAddress> addresses = codeAddressService.selectCountyListByCityCode(cityCode);
			if (addresses != null && addresses.size() > 0){
				return AjaxResult.success("",addresses);
			}else{
				return AjaxResult.error("");
			}
		}
		return AjaxResult.error("");
	}
	
	/**
	 * 描述：街道选择
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param identityInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/chooseOriginLocStreet", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult chooseOriginLocStreet(String countyCode) throws Exception {
		if (StringUtil.isNotEmpty(countyCode)) {
			List<CodeAddress> addresses = codeAddressService.selectCountyListByCountyCode(countyCode);
			if (addresses != null && addresses.size() > 0){
				return AjaxResult.success("",addresses);
			}else{
				return AjaxResult.error("");
			}
		}
		return AjaxResult.error("");
	}
	
	/**
	 * 描述: 经营异常名录查询统计（全景及经营异常管理）
	 * 
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchCount", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult initSearchCountJSON() throws Exception {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.putAll(dataParmMap);
		PartyMemberInfoDto memberInfo = partyMemberInfoService.doGetPartyMemberSearchTotal(dataParmMap);
		return  AjaxResult.success("", memberInfo);
	}
	
	/**
	 * 描述: 党员信息统计报表页面
	 * 
	 * @auther baifangfang
	 * @date 2017年9月5日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("partymemberinfocountview")
	public ModelAndView partyMemberInfoCountView(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partymemberinfocount_view");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		String deptCode = "";
		if (sysUser.getDepartMent() != null) {
			deptCode = sysUser.getDepartMent().getDeptCode();
			if (deptCode.length() > 4) {
				deptCode = deptCode.substring(0, 4);
			}
		}
		view.addObject("deptCode", deptCode);
		String preDate = DateUtil.getNdaylater(new Date(), -1).substring(0, 10);
		view.addObject("preDate", preDate);
		return view;
	}

	/**
	 * 
	 * 描述: 党员信息统计报表
	 * 
	 * @auther baifangfang
	 * @date 2017年9月5日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partymemberinfocount.json")
	@ResponseBody
	public PageResponse<PartyMemberInfoDto> partyMemberInfoCount(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "A.regOrg", "A.localAdm");
		List<PartyMemberInfoDto> data = partyMemberInfoService.selectPartyMemberInfoCount(request);
		return new PageResponse<PartyMemberInfoDto>(data);
	}
	/**
	 * 
	 * 描述:根据党组织id查询组织人员
	 * @auther gaojinling
	 * @date 2017年9月13日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectMembersByPartyOrgID.json")
	@ResponseBody
	public PageResponse<PartyMemberInfoDto> selectMembersByPartyOrgID(PageRequest request) throws Exception {
		List<PartyMemberInfoDto> data = partyMemberInfoService.selectMembersByPartyOrgID(request);
		return new PageResponse<PartyMemberInfoDto>(data);
	}
	
	/**
	 * 
	 * 描述: 党员树
	 * @auther gaojinling
	 * @date 2017年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toMemberTreeMap")
	public ModelAndView toMemberTreeMap()throws Exception{
	    ModelAndView view=new ModelAndView("/common/select/memberTreecheckbox");
	    return view;
	}

	/**
	 * 
	 * 描述: 党员树
	 * @auther gaojinling
	 * @date 2017年9月13日 
	 * @param smFlag
	 * @param indType
	 * @param content
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/toMemberTreeJson")
    @ResponseBody
    public AjaxResult toMemberTreeJson(String content)throws Exception{
    	List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("content",content);
        data=partyMemberInfoService.selectMemberTreeMap(map);
        return AjaxResult.success("查询成功",data);
    }
}