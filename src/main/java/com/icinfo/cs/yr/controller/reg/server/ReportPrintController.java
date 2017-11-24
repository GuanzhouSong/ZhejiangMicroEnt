package com.icinfo.cs.yr.controller.reg.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.cs.base.model.CodeEntType;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.cs.base.service.ICodeEntTypeService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.yr.model.AlterStockInfo;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.cs.yr.model.PbLicenceinfo;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.cs.yr.model.SfcBaseInfoHis;
import com.icinfo.cs.yr.model.SfcBranchInfo;
import com.icinfo.cs.yr.model.SfcLicenceInfo;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IAlterStockInfoService;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IForinvestMentService;
import com.icinfo.cs.yr.service.IPbBaseinfoHisService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.cs.yr.service.ISfcBaseInfoHisService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcBranchInfoService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoService;
import com.icinfo.cs.yr.service.ISubcapitalService;
import com.icinfo.cs.yr.service.IWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.cs.yr.service.IYrPrintService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.tools.utils.DateUtils;

@Controller
@RequestMapping("/reg/server/reportprint/")
public class ReportPrintController extends BaseController {

	@Autowired
	IBaseInfoService baseInfoService;

	@Autowired
	IPbBaseinfoService pbBaseinfoService;

	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;

	@Autowired
	IYrRegCheckService yrRegCheckService;

	@Autowired
	IYrPrintService yrPrintService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Autowired
	IAlterStockInfoService alterStockInfoService;
	@Autowired
	IForGuaranteeInfoService forGuaranteeInfoService;
	@Autowired
	IForinvestMentService forinvestMentService;
	@Autowired
	ISubcapitalService subcapitalService;
	@Autowired
	IWebsiteInfoService websiteInfoService;
	@Autowired
	ICodeEntTypeService codeEntTypeService;
	@Autowired
	IPbBaseinfoHisService pbBaseinfoHisService;
	@Autowired
	IPbLicenceinfoService pbLicenceinfoService;
	@Autowired
	IPbWebsiteinfoService pbWebsiteinfoService;
	@Autowired
	ISfcBaseInfoHisService sfcBaseInfoHisService;
	@Autowired
	ISfcLicenceInfoService sfcLicenceInfoService;
	@Autowired
	ISfcWebsiteInfoService sfcWebsiteInfoService;
	@Autowired
	ISfcBranchInfoService sfcBranchInfoService;
	@Autowired
	IYrAssetService assetService;
	@Autowired
	ICodeCurrencyService codeCurrencyService;

	/**
	 * 描述 (企业)打印年度报告证明页面
	 * 
	 * @author yujingwei
	 * @date 2017年1月17日
	 * @param year
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/showEnAnnualReportProve", method = RequestMethod.GET)
	public ModelAndView showEnAnnualReportProve(@RequestParam(required = true) String year,
			@RequestParam(required = true) String priPID) throws Exception {
		year = AESEUtil.decodeYear(year); // 年份解密
		priPID = AESEUtil.decodeCorpid(priPID);// 内部序号解密
		MidBaseInfoDto midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		ModelAndView view = yrPrintService.printerEnAnnualReportProve(priPID, Integer.parseInt(year), midBaseInfo);
		view.addObject("year", year);
		view.addObject("pripid", priPID);
		view.addObject("reportProveDate", DateUtils.getDateTime());
		view.setViewName("/reg/client/yr/pubprint/pubprint");
		return view;
	}

	/**
	 * 描述 (企业) 打印最新的年度报告 @author yujingwei @date 2017-1-18 @param year @param
	 * priPID @param printFalg @return ModelAndView @throws
	 */
	@RequestMapping(value = "/showReportProvePage", method = RequestMethod.GET)
	public ModelAndView showReportProvePage(@RequestParam(required = true) String year,
			@RequestParam(required = true) String priPID, String printFalg) throws Exception {
		ModelAndView view = new ModelAndView();
		view.addObject("encodeYear", year);
		year = AESEUtil.decodeYear(year); // 年份解密
		priPID = AESEUtil.decodeCorpid(priPID);// 内部序号解密
		// 基本信息
		MidBaseInfoDto midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		view.addObject("midBaseInfo", midBaseInfo);
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.parseInt(year));
		CodeCurrency codeCurrency = codeCurrencyService.selectCodeCurrencyByCode(yrRegCheck.getCurrency());
		if (codeCurrency != null) {
			view.addObject("currencyCN", codeCurrency.getContent());
		} else {
			view.addObject("currencyCN", "人民币元");
		}
		BaseInfo baseInfo = baseInfoService.selectInfoByPripidAndYear(priPID, Integer.parseInt(year));
		view.addObject("baseInfo", baseInfo);
		String repType = RepTypeUtil.getReportTypeList(midBaseInfo.getEntTypeCatg(), midBaseInfo.getEntType(), year)
				.toString();
		view.addObject("repType", repType);
		// 年报ID
		String anCheID = baseInfo == null ? "" : baseInfo.getAnCheID();
		// 股权转让
		List<AlterStockInfo> alterStockInfoList = alterStockInfoService.selectAlterStockInfoByAnCheID(anCheID);
		view.addObject("alterStockInfoList", alterStockInfoList);
		// 对外担保
		List<ForGuaranteeInfo> forGuaranteeInfoList = forGuaranteeInfoService.selectForGuaranteeInfoByAnCheID(anCheID);
		view.addObject("forGuaranteeInfoList", forGuaranteeInfoList);
		// 对外投资
		List<ForinvestMent> forinvestMentList = forinvestMentService.selectForinvestMentByAnCheID(anCheID);
		view.addObject("forinvestMentList", forinvestMentList);
		// 出资
		List<Subcapital> subcapitalList = subcapitalService.selectSubcapitalByAnCheID(anCheID);
		view.addObject("subcapitalList", subcapitalList);
		// 网站网店
		List<WebsiteInfo> websiteInfoList = websiteInfoService.selectWebsiteInfoByAnCheID(anCheID);
		view.addObject("websiteInfoList", websiteInfoList);

		// 打印标识
		view.addObject("printFalg", printFalg);
		view.addObject("year", year);
		view.addObject("pripid", priPID);
		// 进入页面
		view.setViewName("/reg/client/yr/pubhis/pubpreview");
		return view;
	}

	/**
	 * 描述 (个体) 打印年度报告证明
	 * 
	 * @author yujingwei
	 * @date 2017-1-18
	 * @param year
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/printPubPbPrintProve", method = RequestMethod.GET)
	public ModelAndView printPubPbPrintProve(@RequestParam(required = true) String year,
			@RequestParam(required = true) String priPID) throws Exception {
		year = AESEUtil.decodeYear(year);// 年度解密
		priPID = AESEUtil.decodeCorpid(priPID);// 内部序号解密
		ModelAndView view = new ModelAndView();
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		CodeEntType codeEntType = null;
		if (midBaseInfoDto != null) {
			codeEntType = codeEntTypeService
					.selectCodeEntTypeByCode(midBaseInfoDto.getEntType() == null ? "" : midBaseInfoDto.getEntType());
		}
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.parseInt(year));
		view.addObject("yrRegCheck", yrRegCheck);
		List<PbBaseinfoHis> baseInfoHisListH = pbBaseinfoHisService.selectPbBaseinfoHisListYear(Integer.parseInt(year),
				priPID);
		if (baseInfoHisListH != null && baseInfoHisListH.size() != 0) {
			PbBaseinfoHis baseInfoHis = new PbBaseinfoHis();
			PbBaseinfo baseInfo = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(priPID, year);
			baseInfoHis.setLastReportTime(baseInfo == null ? null : baseInfo.getLastReportTime());
			baseInfoHisListH.add(0, baseInfoHis);
		} else {
			PbBaseinfo pbBaseinfo = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(priPID, year);
			baseInfoHisListH = pbBaseinfoHisService
					.selectPbBaseinfoHisByAnCheID(pbBaseinfo == null ? "" : pbBaseinfo.getAnCheID());
			if (baseInfoHisListH != null && baseInfoHisListH.size() == 1) {
				baseInfoHisListH.get(0).setLastReportTime(pbBaseinfo == null ? null : pbBaseinfo.getLastReportTime());
			}
		}
		view.addObject("pbBaseinfoHisList", baseInfoHisListH);
		view.addObject("codeEntType", codeEntType);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("year", year);
		view.addObject("pripid", priPID);
		view.addObject("reportProveDate", DateUtils.getDateTime());
		view.setViewName("/reg/client/yr/pbyr/pubpbprintprove");
		return view;
	}

	/**
	 * 描述 (个体) 打印年度报告
	 * 
	 * @author yujingwei
	 * @date 2017-1-18
	 * @param year
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/showPbReportProve", method = RequestMethod.GET)
	public ModelAndView showPbReportProve(@RequestParam(required = true) String year,
			@RequestParam(required = true) String priPID, String printFalg) throws Exception {
		year = AESEUtil.decodeYear(year);
		priPID = AESEUtil.decodeCorpid(priPID);
		ModelAndView view = new ModelAndView();
		PbBaseinfo pbBaseinfo = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(priPID, year);
		// 年报基本信息 公示
		view.addObject("pbBaseInfo", pbBaseinfo);
		// 年报ID
		String anCheID = pbBaseinfo == null ? "" : pbBaseinfo.getAnCheID();
		// 许可信息 公示
		List<PbLicenceinfo> pbLicenceinfoList = pbLicenceinfoService.selectPbLicenceListByPriPidAndYear(anCheID);
		view.addObject("pbLicenceinfoList", pbLicenceinfoList);
		List<PbWebsiteinfo> pbWebsiteinfoList = pbWebsiteinfoService.selectPbWebsiteListByPriPidAndYear(anCheID);
		year = AESEUtil.encodeYear(year);
		view.addObject("pbWebsiteinfoList", pbWebsiteinfoList);
		view.addObject("printFalg", printFalg);
		view.addObject("encodeYear", year);
		view.addObject("pripid", priPID);
		view.setViewName("/reg/client/yr/pbyr/pubpbprintreport");
		return view;
	}

	/**
	 * 描述 (农专) 打印年度报告证明
	 * 
	 * @author yujingwei
	 * @date 2017-1-18
	 * @param year
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/printPubSfcPrintProve", method = RequestMethod.GET)
	public ModelAndView printPubSfcPrintProve(@RequestParam(required = true) String year,
			@RequestParam(required = true) String priPID) throws Exception {
		ModelAndView view = new ModelAndView();
		year = AESEUtil.decodeYear(year);
		priPID = AESEUtil.decodeCorpid(priPID);
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		CodeEntType codeEntType = null;
		if (midBaseInfoDto != null) {
			codeEntType = codeEntTypeService
					.selectCodeEntTypeByCode(midBaseInfoDto.getEntType() == null ? "" : midBaseInfoDto.getEntType());
		}
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.parseInt(year));
		view.addObject("yrRegCheck", yrRegCheck);
		List<SfcBaseInfoHis> baseInfoHisListH = sfcBaseInfoHisService
				.selectSfcBaseinfoHisListYear(Integer.parseInt(year), priPID);
		if (baseInfoHisListH != null && baseInfoHisListH.size() != 0) {
			SfcBaseInfoHis baseInfoHis = new SfcBaseInfoHis();
			SfcBaseInfo baseInfo = sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(priPID, Integer.parseInt(year));
			baseInfoHis.setLastReportTime(baseInfo == null ? null : baseInfo.getLastReportTime());
			baseInfoHisListH.add(0, baseInfoHis);
		} else {
			SfcBaseInfo sfcBaseInfo = sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(priPID,
					Integer.parseInt(year));
			baseInfoHisListH = sfcBaseInfoHisService
					.selectSfcBaseInfoHisByAnCheID(sfcBaseInfo == null ? "0000" : sfcBaseInfo.getAnCheID());
			if (baseInfoHisListH != null && baseInfoHisListH.size() == 1) {
				baseInfoHisListH.get(0).setLastReportTime(sfcBaseInfo == null ? null : sfcBaseInfo.getLastReportTime());
			}
		}
		view.addObject("sfcBaseInfoHisList", baseInfoHisListH);
		view.addObject("codeEntType", codeEntType);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("year", year);
		view.addObject("pripid", priPID);
		view.addObject("reportProveDate", DateUtils.getDateTime());
		view.setViewName("/reg/client/yr/sfcyr/pubsfchisprintprove");
		return view;
	}

	/**
	 * 描述 （农专） 打印年度报告
	 * 
	 * @author yujingwei
	 * @date 2017-1-18
	 * @param year
	 * @param priPID
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/showSfcReportProve", method = RequestMethod.GET)
	public ModelAndView showSfcReportProve(@RequestParam(required = true) String year,
			@RequestParam(required = true) String priPID, String printFalg) throws Exception {
		ModelAndView view = new ModelAndView();
		year = AESEUtil.decodeYear(year);
		priPID = AESEUtil.decodeCorpid(priPID);
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		SfcBaseInfo sfcBaseInfo = sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(priPID, Integer.parseInt(year));
		// 年报基本信息 公示
		view.addObject("sfcBaseInfo", sfcBaseInfo);
		// 年报ID
		String anCheID = sfcBaseInfo == null ? "" : sfcBaseInfo.getAnCheID();
		// 许可信息 公示
		List<SfcLicenceInfo> sfcLicenceInfoList = sfcLicenceInfoService.selectSfcLicenceInfoByAnCheID(anCheID);
		view.addObject("sfcLicenceInfoList", sfcLicenceInfoList);
		// 网站网店信息
		List<SfcWebsiteInfo> sfcWebsiteInfoList = sfcWebsiteInfoService.selectSfcWebsiteInfoByAnCheID(anCheID);
		view.addObject("sfcWebsiteInfoList", sfcWebsiteInfoList);
		// 分支机构
		List<SfcBranchInfo> sfcBranchInfoList = sfcBranchInfoService.selectSfcBranchInfoByAnCheID(anCheID);
		year = AESEUtil.encodeYear(year);
		view.addObject("sfcBranchInfoList", sfcBranchInfoList);
		view.addObject("printFalg", printFalg);
		view.addObject("encodeYear", year);
		view.addObject("pripid", priPID);
		view.setViewName("/reg/client/yr/sfcyr/sfcyrpubprint");
		return view;
	}
}
