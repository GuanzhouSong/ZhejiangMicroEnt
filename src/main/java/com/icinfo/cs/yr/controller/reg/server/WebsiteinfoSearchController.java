/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegState;
import com.icinfo.cs.base.service.ICodeRegStateService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
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
import com.icinfo.cs.registinfo.dto.PubApprMarkRelDto;
import com.icinfo.cs.registinfo.service.IPubApprMarkRelService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.WebsiteinfoSearchDto;
import com.icinfo.cs.yr.model.WebsiteinfoSearch;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IWebsiteinfoSearchService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrWebsiteInfoService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_yr_websiteinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月21日
 */
/** 
 * 描述: TODO<br>
 * @author ZhouYan
 * @date 2017年7月26日  
 */
@Controller
@RequestMapping("/reg/server/yr/websiteinfo")
public class WebsiteinfoSearchController extends CSBaseController  {
	@Autowired
	private IWebsiteinfoSearchService websiteinfoSearchService;
	@Autowired
	private IYrWebsiteInfoService yrWebsiteInfoService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IErEscAppinfoService erEscAppinfoService;
	@Autowired
	private IPubApprMarkRelService pubApprMarkRelService;
	@Autowired
	private ICsSuperviseObjService csSuperviseObjService;
	@Autowired
	private ICsConcernObjService csConcernObjService;
	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private ICsEntWarnService csEntWarnService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	
	/** 
	 * 描述: 进入网站信息列表页面
	 * @auther ZhouYan
	 * @date 2017年7月24日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/websiteinfosearch/websiteinfosearch_list");
		List<String> yearList = DateUtil.getYearToNow();
		yearList.remove(yearList.size() - 1);
		view.addObject("yearList", yearList);
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/** 
	 * 描述: 获取网站信息列表
	 * @auther ZhouYan
	 * @date 2017年7月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<WebsiteinfoSearchDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"t2.CheckDep","t2.LocalAdm");
		List<WebsiteinfoSearchDto> data = websiteinfoSearchService.selectWebsiteinfoSearchList(request);
		return new PageResponse<WebsiteinfoSearchDto>(data);
    }
	
	
	/** 
	 * 描述: 查询结果统计
	 * @auther ZhouYan
	 * @date 2017年7月26日 
	 * @param pramsMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/total.json",method= RequestMethod.POST)
	@ResponseBody
	public List<WebsiteinfoSearchDto> totalListJSON(@RequestBody Map<String, Object> paramsMap) throws Exception {
		creatDefaultDBAuthEnv(paramsMap,"t2.CheckDep","t2.LocalAdm");
		List<WebsiteinfoSearchDto> totalList = websiteinfoSearchService.selectWebsiteinfoTotal(paramsMap);
		return totalList;
	}
	
	/** 
	 * 描述: 查询详情
	 * @auther ZhouYan
	 * @date 2017年7月27日 
	 * @param year
	 * @param priPID
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/details")
	public ModelAndView searchDetails(Integer year, String priPID, HttpSession session)
			throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/reg/server/yr/websiteinfosearch/websiteinfosearch_details");
		// 基本信息
		MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid(priPID);
		List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate(priPID);
		if (midDtos != null && midDtos.size() > 0) {
			midBaseInfoDto.setPunishDate(midDtos.get(0).getPunishDate());
		}
		view.addObject("midBaseInfo", midBaseInfoDto);
		// 获取系统年份集合
		List<String> yearList = DateUtil.getYearList();
		Date estDate = midBaseInfoDto.getEstDate();
		//个转企
		if("1".equals(midBaseInfoDto.getIsIndivid()) && null != midBaseInfoDto.getIndividDate()) {
			estDate = midBaseInfoDto.getIndividDate();
		}
		int estYear = Integer.valueOf(DateUtil.dateToString(estDate, "yyyy")); // 成立日期年度
		int yrYear = 2013; //企业年报起始年度
		String systemType = Constants.SYSTEM_TYPE_ENT;
		if(Constants.entTypeCatgSFC.indexOf(midBaseInfoDto.getEntTypeCatg()) != -1) {
			yrYear = 2014; //农专从14年度开始
			systemType = Constants.SYSTEM_TYPE_SFC;
		}else if(midBaseInfoDto.getEntTypeCatg().equals(Constants.entTypeCatgPB)){
			yrYear = 2015; //个体户从15年度开始
			systemType = Constants.SYSTEM_TYPE_PB;
		}
		int startYear = estYear > yrYear ? estYear : yrYear; // 起始年度
		for (int i = 0; i < yearList.size(); i++) {
			if (startYear > Integer.valueOf(yearList.get(i))) {
				yearList.remove(i);
				i--;
			}
		}
		view.addObject("yearList", yearList); // 存在的年份
		view.addObject("systemType", systemType);
		
		// 查询年报主表
		if (StringUtil.checkYearAndPripid(year,priPID)) {
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,year);
			view.addObject("yrRegCheck", yrRegCheck);
		}
		//联络员信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("liaName", pubEppassword == null ? "" : pubEppassword.getLianame());
		view.addObject("liaTel", pubEppassword == null ? "" : pubEppassword.getTel());
		//列入经营异常
		view.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
		//简易注销
		view.addObject("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID(priPID));
		view.addObject("sysUser", sysUser);

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
		view.addObject("priPID", priPID);
		view.addObject("year", year);
		
		return view;
	}
	
	/** 
	 * 描述: 检查是否是异常名录和严重违法
	 * @auther ZhouYan
	 * @date 2017年7月27日 
	 * @param entTypeCatg
	 * @param priPID
	 * @return
	 * @throws Exception 
	 */
	private String checkIsOpanomaly(String entTypeCatg, String priPID) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		String opanomaly = "0";
		String seriousCrime = "0";
		if ("50".equals(entTypeCatg)) {
			List<PubPbopanomalyDto> dataList = pubPbopanomalyService.selectPubPbopanomalys(map);
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
	 * 描述: 网站或网店信息
	 * @auther ZhouYan
	 * @date 2017年7月27日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({ "details/list.json", "details/list.xml" })
	@ResponseBody
	public PageResponse<WebsiteinfoSearch> detailsListJSON(PageRequest request) throws Exception {
		List<WebsiteinfoSearch> data = websiteinfoSearchService.queryPage(request);
		return new PageResponse<WebsiteinfoSearch>(data);
	}
}