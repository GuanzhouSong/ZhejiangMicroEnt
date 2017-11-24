package com.icinfo.cs.es.controller.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.es.model.ParamsContent;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.mainmark.service.IMainMarkRelService;
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
import com.icinfo.cs.risk.service.ICsWarnMarkService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;

/**
 * 描述: 对应的Controller类.<br>
 * 
 * @author framework generator
 * @date 2016年09月20日
 */
@Controller
@RequestMapping("server/yr_view")
public class YrTabContentController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(YrTabContentController.class);

	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	IMainMarkRelService mainMarkRelService;
	@Autowired
	ICsSuperviseObjService csSuperviseObjService;
	@Autowired
	ICsConcernObjService csConcernObjService;
	@Autowired
	IPubOtherlicenceService pubOtherlicenceService;
	@Autowired
	IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IPubApprMarkRelService pubApprMarkRelService;
	@Autowired
	ICsWarnMarkService csWarnMarkService;
	@Autowired
	ICsEntWarnService csEntWarnService;
	@Autowired
	ICodeCurrencyService codeCurrencyService;

	/**
	 * 获取企业报表配置 显示Tab 年报页面 author: wangjin
	 */
	@RequestMapping("/tab")
	@ResponseBody
	public ModelAndView tab(ParamsContent paramsContent) throws Exception {

		ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport_tab");

		// 获取系统年份集合
		List<String> yearList = DateUtil.getYearList();

		// 获取成立日期的数字的年份
		Integer yearDate = Integer.valueOf(paramsContent.getEstDate());

		// 作为年份判断的条件变量
		Integer yearNum;

		// 判断当前企业大类是否为企业 (16,17：农专 50:个体户)
		if (!StringUtils.equalsIgnoreCase(paramsContent.getEntTypeCatg(), "16")
				&& !StringUtils.equalsIgnoreCase(paramsContent.getEntTypeCatg(), "17")
				&& !StringUtils.equalsIgnoreCase(paramsContent.getEntTypeCatg(), "50")) {
			List<String> reportTypeList = RepTypeUtil.getReportTypeList(paramsContent.getEntTypeCatg(),
					paramsContent.getEntType(), paramsContent.getYear()); // 企业显示tab列表
			view.addObject("reportTypeList", reportTypeList);

			String isIndivid = paramsContent.getIsIndivid(); // 判断是否是个转企
																// 1：表示是个转企
			String individDate = "";

			if (!"-".equals(paramsContent.getAltDate())) { // es返回日期为空的现象是 -
				individDate = paramsContent.getAltDate().substring(0, 4); // 个转企日期
			}

			if (StringUtils.isNotBlank(isIndivid) && StringUtils.isNotBlank(individDate) && "1".equals(isIndivid)) {
				yearNum = Integer.valueOf(individDate);
			} else {
				// 如果成立日期大于2013 则 从成立日期开始 否则从2013年开始
				yearNum = yearDate > 2013 ? yearDate : 2013;
			}
			for (int i = 0; i < yearList.size(); i++) {
				if (yearNum > Integer.valueOf(yearList.get(i))) { // 农专从2014年开始展示
					yearList.remove(i);
					i--;
				}
			}
		}
		// 农专
		if (StringUtils.equalsIgnoreCase(paramsContent.getEntTypeCatg(), "16")
				|| StringUtils.equalsIgnoreCase(paramsContent.getEntTypeCatg(), "17")) {

			// 如果成立日期大于2014 则 从成立日期开始 否则从2014年开始
			yearNum = yearDate > 2014 ? yearDate : 2014;
			for (int i = 0; i < yearList.size(); i++) {
				if (yearNum > Integer.valueOf(yearList.get(i))) { // 农专从2014年开始展示
					yearList.remove(i);
					i--;
				}
			}
		}
		// 个体户
		if (StringUtils.equalsIgnoreCase(paramsContent.getEntTypeCatg(), "50")) {
			// 如果成立日期大于2015 则 从成立日期开始 否则从2015年开始
			yearNum = yearDate > 2015 ? yearDate : 2015;
			for (int i = 0; i < yearList.size(); i++) {
				if (yearNum > Integer.valueOf(yearList.get(i))) { // 个体户从2015年开始展示
					yearList.remove(i);
					i--;
				}
			}
		}

		MidBaseInfoDto midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(paramsContent.getPriPID());

		if (StringUtils.isNotBlank(paramsContent.getPriPID()) && StringUtils.isNotBlank(paramsContent.getYear())) {
			// 查询年报主表
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(paramsContent.getPriPID(),
					Integer.parseInt(paramsContent.getYear()));
			// 查询币种
			CodeCurrency codeCurrency = codeCurrencyService.selectCodeCurrencyByCode(yrRegCheck.getCurrency());
			if (codeCurrency != null) {
				view.addObject("currencyCN", codeCurrency.getContent());
			}else{
				view.addObject("currencyCN", "人民币元");
			}
			view.addObject("yrRegCheck", yrRegCheck);
		}

		// 查询该企业简易注销信息
		if (StringUtils.isNotBlank(paramsContent.getPriPID())) {
			ErEscAppinfo erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(paramsContent.getPriPID());
			if (erEscAppinfo != null) {
				view.addObject("erEscAppinfo", erEscAppinfo);
			}
		}
		if (StringUtils.isNotBlank(paramsContent.getPriPID())
				&& StringUtils.isNotBlank(paramsContent.getEntTypeCatg())) {
			view.addObject("isOpanomaly", checkIsOpanomaly(paramsContent.getEntTypeCatg(), paramsContent.getPriPID()));
		}
		view.addObject("midBaseInfo", midBaseInfo);
		view.addObject("paramsContent", paramsContent);
		view.addObject("yearList", yearList); // 存在的年份
		view.addObject("regNO", paramsContent.getRegNO()); // 注册号
		view.addObject("uniscid", paramsContent.getUniscid()); // 统一代码
		view.addObject("entName", paramsContent.getEntName()); // 企业名称
		view.addObject("year", paramsContent.getYear()); // 年份
		view.addObject("priPID", paramsContent.getPriPID()); // 身份主体代码
		view.addObject("entType", paramsContent.getEntType()); // 小类
		view.addObject("entTypeCatg", paramsContent.getEntTypeCatg()); // 大类
		view.addObject("estDate", paramsContent.getEstDate()); // 成立日期

		// 监管项目标签
		List<PubApprMarkRelDto> apprMarkRelDtos = pubApprMarkRelService
				.selectPubApprMarkRelDtoByPriPID(paramsContent.getPriPID());
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
		List<CsSuperviseObjDto> csSuperviseObjDtoList = csSuperviseObjService
				.qryCsSuperviseObjDtoByPriPID(paramsContent.getPriPID());
		view.addObject("csSuperviseObjDtoList", csSuperviseObjDtoList);
		view.addObject("csSuperviseObjDtoSize", csSuperviseObjDtoList.size());

		// 关注服务对象
		List<CsConcernObjDto> csConcernObjDtoList = csConcernObjService
				.qryCsConcernObjDtoByPriPID(paramsContent.getPriPID());
		view.addObject("csConcernObjDtoList", csConcernObjDtoList);
		view.addObject("csConcernObjDtoSize", csConcernObjDtoList.size());

		// 预警提醒提示
		List<MidBaseInfoDto> midBaseInfoDtoList = midBaseInfoService.doGetListByPriPID(paramsContent.getPriPID());
		Date opTo = null;// 经营期限至
		Date licValTo = null;// 许可证有效期至
		Date abnTime = null;// 经营异常名录列入日期
		if (midBaseInfoDtoList != null && midBaseInfoDtoList.size() > 0) {
			opTo = midBaseInfoDtoList.get(0).getOpTo();
		}
		List<PubOtherlicenceDto> pubOtherlicenceDtoList = pubOtherlicenceService
				.selectOtherlicenceListByPriPID(paramsContent.getPriPID());
		if (pubOtherlicenceDtoList != null && pubOtherlicenceDtoList.size() > 0) {
			licValTo = pubOtherlicenceDtoList.get(0).getLicValTo();
		}
		if ("50".endsWith(midBaseInfo.getEntTypeCatg())) {
			List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService
					.selectPubPbopanomalyPriPID(paramsContent.getPriPID());
			if (pubPbopanomalyDtoList != null && pubPbopanomalyDtoList.size() > 0) {
				abnTime = pubPbopanomalyDtoList.get(0).getCogDate();
			}
		} else {
			List<PubOpanoMalyDto> pubOpanoMalyDtoList = pubOpanoMalyService
					.selectPubOpanoMalyServicePriPID(paramsContent.getPriPID());
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
		params.put("priPID", paramsContent.getPriPID());
		List<CsEntWarnDto> csEntWarnDtos = csEntWarnService.selectCsEntWarnMarks(params);
		for (CsEntWarnDto csEntWarnDto : csEntWarnDtos) {
			tips.add(csEntWarnDto.getMarkName());
		}

		view.addObject("tips", tips);
		view.addObject("tipsSize", tips.size());
		return view;
	}

	/**
	 * 检查企业是否是异常名录
	 * 
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

}