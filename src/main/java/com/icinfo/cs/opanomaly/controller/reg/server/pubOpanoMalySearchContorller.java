package com.icinfo.cs.opanomaly.controller.reg.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@Controller
@RequestMapping({ "/reg/server/opanomaly/search", "/syn/server/opanomaly/search" })
public class pubOpanoMalySearchContorller extends CSBaseController {

	private Map<String, Object> dataParmMap;

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

	/**
	 * 描述 进入异常名录查询页面（全景查询）
	 * 
	 * @author yujingwei
	 * @date 2017年06月13日
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView pubOpanoMalyListPage(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/opanomaly/opanosearch/opanomalysearch_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}

	/**
	 * 描述 进入异常名录查询页面（经营异常管理）
	 * 
	 * @author yujingwei
	 * @date 2017年06月13日
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/historyList")
	public ModelAndView pubOpanoMalyHisListPage() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/opanomaly/opanosearch/opanomalyhissearch_list");
		view.addObject("yearList", DateUtil.getYearToNowForReport());
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}

	/**
	 * 描述 获取经营异常名录全景查询数据
	 * 
	 * @author yujingwei
	 * @date 2017年06月13日
	 * @param request
	 * @return PageResponse<PubOpanoMalyDto>
	 * @throws Exception
	 */
	@RequestMapping({ "/opasearch.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> selectPubOpanoMalySearchListJSON(PageRequest request) throws Exception {
		Map<String, Object> queryMap = getRequestParam(request);
		List<PubOpanoMalyDto> pubOpanoMalyDtoList = new ArrayList<PubOpanoMalyDto>();
		Integer total = 0;
		// 情空全局变量
		if (dataParmMap != null) {
			dataParmMap.clear();
		}

		if (!queryMap.containsKey("removePermit")) {
			creatDefaultDBAuthEnv(request, "E.checkDep", "E.localAdm");
		}

		// 去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
		// 将查询参数赋给全局变量 统计查询结果用
		dataParmMap = queryMap;
		pubOpanoMalyDtoList = pubOpanoMalyService.selectPubOpanoMalyNewSearchList(request);
		total = pubOpanoMalyService.selectPubOpanoMalyNewSearchCount(queryMap);

		return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList, total, request);
	}

	/**
	 * 描述 获取经营异常记录查询数据（经营异常管理）
	 * 
	 * @author yujingwei
	 * @date 2017年06月13日
	 * @param request
	 * @return PageResponse<PubOpanoMalyDto>
	 * @throws Exception
	 */
	@RequestMapping({ "/hisopasearch.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> selectPubOpanoMalyHisSearchListJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "E.checkDep", "E.localAdm");
		Map<String, Object> queryMap = getRequestParam(request);
		List<PubOpanoMalyDto> pubOpanoMalyDtoList = new ArrayList<PubOpanoMalyDto>();
		Integer total = 0;
		// 情空全局变量
		if (dataParmMap != null) {
			dataParmMap.clear();
		}

		// 去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
		// 将查询参数赋给全局变量 统计查询结果用
		dataParmMap = queryMap;
		pubOpanoMalyDtoList = pubOpanoMalyService.selectPubOpanoMalyNewSearchHisList(request);
		total = pubOpanoMalyService.selectPubOpanoMalyNewSearchHisCount(queryMap);

		return new PageResponse<PubOpanoMalyDto>(pubOpanoMalyDtoList, total, request);
	}

	/**
	 * 描述 进入异常查询详情页面
	 * 
	 * @author yujingwei
	 * @date 2017年6月14日
	 * @param busExcList，session
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/details")
	public ModelAndView pubOpanoMalySearchViewPage(String busExcList, String priPID, HttpSession session)
			throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/reg/server/opanomaly/opanosearch/opanomalysearch_details");
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
		view.addObject("busExcList", busExcList);
		view.addObject("entTypeFlag", entTypeFlag);
		view.addObject("liaName", pubEppassword == null ? "" : pubEppassword.getLianame());
		view.addObject("liaTel", pubEppassword == null ? "" : pubEppassword.getTel());
		view.addObject("dto", midBaseInfoDto);
		view.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
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
		return view;
	}

	/**
	 * 描述 :检查是否是异常名录和严重违法
	 * 
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
		if (qryMap.isEmpty()) {
			return null;
		}
		String isOpaManageSearchFlag = "";
		List<PubOpanoMalyDto> infos = new ArrayList<PubOpanoMalyDto>();
		String inState = (String) qryMap.get("inState");
		String shiftOutType = (String) qryMap.get("shiftOutType");
		if (qryMap.containsKey("isOpaManageSearchFlag")) {
			isOpaManageSearchFlag = (String) qryMap.get("isOpaManageSearchFlag");
		}
		// 列入总数
		PubOpanoMalyDto totalAllDto = pubOpanoMalyService.selectOpanoMalyTotalAll(qryMap);
		infos.add(totalAllDto);
		// 列入未移出个数
		if (!"3".equals(inState) && !"1".equals(inState)) {
			PubOpanoMalyDto noOutDto = pubOpanoMalyService.selectOpanoMalyNoOutTotal(qryMap);
			infos.add(noOutDto);
		} else {
			PubOpanoMalyDto noOutDto = new PubOpanoMalyDto();
			infos.add(noOutDto);
		}
		// 移出个数
		if (!"3".equals(inState) && !"2".equals(inState) && !"3".equals(shiftOutType)) {
			PubOpanoMalyDto outTotalDto = pubOpanoMalyService.selectOpanoMalyOutTotal(qryMap);
			infos.add(outTotalDto);
		} else {
			PubOpanoMalyDto outTotalDto = new PubOpanoMalyDto();
			infos.add(outTotalDto);
		}
		// 撤销个数
		if (!"1".equals(inState) && !"2".equals(inState) && !"1".equals(shiftOutType)
				&& "01".equals(isOpaManageSearchFlag)) {
			PubOpanoMalyDto revokeDto = pubOpanoMalyService.selectOpanoMalyRevokeTotal(qryMap);
			infos.add(revokeDto);
		} else {
			PubOpanoMalyDto revokeDto = new PubOpanoMalyDto();
			infos.add(revokeDto);
		}
		return AjaxResult.success("", infos);
	}
}
