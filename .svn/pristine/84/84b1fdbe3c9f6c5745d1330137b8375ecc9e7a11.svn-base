/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.PdfUtils;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.SendEmailUtil;
import com.icinfo.cs.drcheck.dto.PubScresultDto;
import com.icinfo.cs.drcheck.service.IPubScresultService;
import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidAltitemDto;
import com.icinfo.cs.ext.dto.MidBranchDto;
import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.ext.dto.MidLiquidationDto;
import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.service.IMidAltitemService;
import com.icinfo.cs.ext.service.IMidBranchService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.cs.ext.service.IMidLiquidationService;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.cs.ext.service.ITmDetailInfoService;
import com.icinfo.cs.im.dto.ImCaseDto;
import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvsralt;
import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.cs.im.model.ImPermit;
import com.icinfo.cs.im.service.IImCasaltService;
import com.icinfo.cs.im.service.IImCaseService;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.cs.im.service.IImInvsraltService;
import com.icinfo.cs.im.service.IImIppldgService;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.model.PubPbopanomaly;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.MortRegInfo;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.model.PubServerModrecord;
import com.icinfo.cs.other.model.SpPledge;
import com.icinfo.cs.other.service.IMortRegInfoService;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.other.service.IPubServerModrecordService;
import com.icinfo.cs.other.service.ISpPledgeService;
import com.icinfo.cs.yr.dto.AlterStockInfoDto;
import com.icinfo.cs.yr.dto.BaseInfoDto;
import com.icinfo.cs.yr.dto.ForGuaranteeInfoDto;
import com.icinfo.cs.yr.dto.ForinvestMentDto;
import com.icinfo.cs.yr.dto.PbBaseinfoDto;
import com.icinfo.cs.yr.dto.PbLicenceinfoDto;
import com.icinfo.cs.yr.dto.PbWebsiteinfoDto;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.dto.SfcBaseInfoDto;
import com.icinfo.cs.yr.dto.SfcBranchInfoDto;
import com.icinfo.cs.yr.dto.SfcLicenceInfoDto;
import com.icinfo.cs.yr.dto.SfcWebsiteInfoDto;
import com.icinfo.cs.yr.dto.SubcapitalDto;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IAlterStockInfoService;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IForinvestMentService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.cs.yr.service.IPubOtherPunishAlterService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcBranchInfoService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoService;
import com.icinfo.cs.yr.service.ISubcapitalService;
import com.icinfo.cs.yr.service.IWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述: cs_mid_branch 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Controller
@RequestMapping("/midbranch/")
public class MidBranchController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MidBranchController.class);

	@Autowired
	IMidBranchService midBranchService;
	@Autowired
	IEntSearchService entSearchService;
	@Autowired
	IBaseInfoService baseInfoService;

	@Autowired
	IPbBaseinfoService pbBaseinfoService;

	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;
	@Autowired
	IMidInvService midInvService;
	@Autowired
	IMidMemberService midMemberService;
	@Autowired
	ITmDetailInfoService tmDetailInfoService;

	@Autowired
	IMidAltitemService midAltitemService;

	@Autowired
	IMidLiquidationService midLiquidationService;

	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;

	@Autowired
	private IPubServerModrecordService pubServerModrecordService;
	@Autowired
	private IPubOtherpunishService pubOtherpunishService;
	@Autowired
	private IPubOtherPunishAlterService pubOtherPunishAlterService;
	@Autowired
	private IPubScresultService pubScresultService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubJusticeInfoService pubJusticeInfoService;
	@Autowired
	private IMortRegInfoService mortRegInfoService;
	@Autowired
	private ISpPledgeService spPledgeService;
	@Autowired
	private IImInvestmentService imInvestmentService;
	@Autowired
	private IImInvsraltService imInvsraltService;
	@Autowired
	private IImPermitService imPermitService;
	@Autowired
	private IImCaseService imCaseService;
	@Autowired
	private IImCasaltService casaltService;
	@Autowired
	private IImIppldgService imIppldgService;
	@Autowired
	private IWebsiteInfoService websiteInfoService;
	@Autowired
	private ISubcapitalService subcapitalService;
	@Autowired
	private IForinvestMentService forinvestMentService;
	@Autowired
	private IForGuaranteeInfoService forGuaranteeInfoService;
	@Autowired
	private IAlterStockInfoService alterStockInfoService;
	@Autowired
	IPbWebsiteinfoService pbWebsiteinfoService;
	@Autowired
	IPbLicenceinfoService pbLicenceinfoService;
	@Autowired
	ISfcWebsiteInfoService sfcWebsiteInfoService;
	@Autowired
	ISfcBranchInfoService sfcBranchInfoService;
	@Autowired
	ISfcLicenceInfoService sfcLicenceInfoService;
	@Autowired
	IYrRegCheckService yrRegCheckService;
	@Autowired
	ICodeCurrencyService codeCurrencyService;

	/**
	 * 跳转到信息打印页面
	 *
	 * @param encryPriPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toinfoprint")
	public ModelAndView toinfoprint(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infodetail/infoprint");
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		PubEntSearchDto entBasicInfo = entSearchService.selectByPriPID(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);

		mav.addObject("now", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		mav.addObject("entBasicInfo", entBasicInfo);
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());

		// 企业、个体户、农专年报信息
		PageRequest request = new PageRequest();
		List year_list = new ArrayList();
		// 个体户 纸质报告集合
		List year_pb_list = new ArrayList();
		String t = entBasicInfo.getEntTypeCatg();
		HashMap par = new HashMap();
		par.put("priPID", entBasicInfo.getPriPID());
		request.setParams(par);
		String yearstr = "";
		if (t.equals("50")) {
			// 个体户年报信息查看详情列表页
			List<PbBaseinfoDto> year_list_tmp = pbBaseinfoService.queryPbYrInfoByPriPID(entBasicInfo.getPriPID());
			for (PbBaseinfoDto pbBaseinfoDto : year_list_tmp) {
				// 该个体户已接收纸质年报 显示年报列表.
				if (pbBaseinfoDto == null || "6".equals(pbBaseinfoDto.getReportType())) {
					year_pb_list.add(pbBaseinfoDto);
					continue;
				}
				String ifFilter = pbBaseinfoService.queryAnduitStateInfoByAncheID(priPID, pbBaseinfoDto.getYear());
				if ("0".equals(ifFilter)) {
					pbBaseinfoDto.doFilterForbidword();
				}
				yearstr += "," + pbBaseinfoDto.getYear();
				// 获取企业报表类型
				String repType = RepTypeUtil
						.getReportTypeList(t, entBasicInfo.getEntType(), pbBaseinfoDto.getYear().toString()).toString();
				pbBaseinfoDto.setRepYearType(repType);
				year_list.add(pbBaseinfoDto);
			}
		} else if (t.equals("16") || t.equals("17")) {
			// 农专年报信息查看详情列表页
			year_list = sfcBaseInfoService.queryPageResult(request);
			for (Object o : year_list) {
				SfcBaseInfoDto sfcBaseInfoDto = (SfcBaseInfoDto) o;
				if (sfcBaseInfoDto == null)
					continue;
				String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(priPID, sfcBaseInfoDto.getYear());
				if ("0".equals(ifFilter)) {
					sfcBaseInfoDto.doFilterForbidword();
				}
				yearstr += "," + sfcBaseInfoDto.getYear();
				// 获取企业报表类型
				String repType = RepTypeUtil
						.getReportTypeList(t, entBasicInfo.getEntType(), sfcBaseInfoDto.getYear().toString())
						.toString();
				sfcBaseInfoDto.setRepYearType(repType);
			}
		} else {
			// 企业年报信息查看详情列表页
			year_list = baseInfoService.queryPageResult(request);
			for (Object o : year_list) {
				BaseInfoDto baseInfoDto = (BaseInfoDto) o;
				if (baseInfoDto == null)
					continue;
				YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, baseInfoDto.getYear());
				CodeCurrency codeCurrency = codeCurrencyService.selectCodeCurrencyByCode(yrRegCheck.getCurrency());
				if (codeCurrency != null) {
					baseInfoDto.setCurrencyCN(codeCurrency.getContent());
				} else {
					baseInfoDto.setCurrencyCN("人民币元");
				}
				String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(priPID, baseInfoDto.getYear());
				if ("0".equals(ifFilter)) {
					baseInfoDto.doFilterForbidword();
				}
				yearstr += "," + baseInfoDto.getYear();
				// 获取企业报表类型
				String repType = RepTypeUtil
						.getReportTypeList(t, entBasicInfo.getEntType(), baseInfoDto.getYear().toString()).toString();
				baseInfoDto.setRepYearType(repType);
			}
		}
		mav.addObject("year_list", year_list);
		mav.addObject("year_pb_list", year_pb_list);// 个体户纸质列表
		mav.addObject("yearstr", yearstr.length() > 1 ? yearstr.substring(1) : "");
		
		mav.addObject("entBasicInfo", entBasicInfo);
		return mav;
	}

	/**
	 * 描述：分支机构列表页面
	 *
	 * @return
	 * @throws Exception
	 * @author baifangfang
	 * @date 2016年11月24日
	 */
	@RequestMapping("list")
	public ModelAndView list(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/infopublic/infodetail/branchdetail");
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		mav.addObject("priPID", priPID);
		return mav;
	}

	/**
	 * 描述：根据priPID查询分支机构信息JSON数据列表
	 *
	 * @param priPID
	 * @return
	 * @throws Exception
	 * @author baifangfang
	 * @date 2016年10月20日
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public List<MidBranchDto> listJSON(@RequestParam String priPID) throws Exception {
		List<MidBranchDto> midBranchDtos = midBranchService.queryListResult(priPID);
		logger.info("midBranchDtos {}", midBranchDtos);
		return midBranchDtos;
	}

	/**
	 * 描述：根据priPID查询变更信息JSON数据列表分页
	 *
	 * @author baifangfang
	 * @date 2016年12月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "synlist.json", "synlist.xml" })
	@ResponseBody
	public PageResponse<MidBranchDto> listJSON(PageRequest request) throws Exception {
		List<MidBranchDto> midBranchDtos = midBranchService.queryPageResult(request);
		logger.info("midBranchDtos {}", midBranchDtos);
		return new PageResponse<MidBranchDto>(midBranchDtos);
	}

	@RequestMapping("createPdf")
	@ResponseBody
	public AjaxResult createPdf(HttpServletRequest request, String priPID, String receiver, PageRequest page)
			throws Exception {
		// priPID = "3300000000012888";
		Map<Object, Object> o = new HashMap<Object, Object>();
		PubEntSearchDto entBasicInfo = entSearchService.selectByPriPID(priPID);
		String uniCode = entBasicInfo.getUNICODE();
		if (StringUtils.isEmpty(uniCode)) {
			uniCode = entBasicInfo.getRegNO();
		}
		System.out
				.println(entBasicInfo.getEntTypeCatg() + "类型---------------------------------------------------------");
		o.put("uniCode", uniCode);
		o.put("entBasicInfo", entBasicInfo);
		o.put("createTime", DateUtils.getDate("yyyy-MM-dd HH:mm:ss"));

		page.getParams().put("priPID", priPID);
		page.getParams().put("regNO", entBasicInfo.getRegNO());
		if (entBasicInfo.getUNICODE() == null) {
			page.getParams().put("uniCode", "");
		} else {
			page.getParams().put("uniCode", entBasicInfo.getUNICODE());
		}
		List<MidInvDto> midInvDtos = midInvService.queryPageResult(page);
		o.put("listMId", midInvDtos);// 股东及出资信息
		List<MidMemberDto> midMemberDtos = midMemberService.queryListResult(priPID);// 主要人员信息
		o.put("listMem", midMemberDtos);
		List<MidInvDto> memberinv = midInvService.queryListResult(priPID);// 农民专业合作社成员名册信息
		o.put("memberinv", memberinv);
		List<MidBranchDto> midBranchDtos = midBranchService.queryListResult(priPID);// 分制机构信息

		o.put("midBranchDtos", midBranchDtos);
		List<MidAltitemDto> midAltitemDtos = midAltitemService.queryPageResult(page);
		o.put("midAltitemDtos", midAltitemDtos);// 变更信息
		MidLiquidationDto midLiquidationDto = midLiquidationService.queryResult(priPID);// 清算信息
		o.put("midLiquidationDto", midLiquidationDto);
		List<String> listLiu = new ArrayList<String>();

		if (midLiquidationDto != null && !midLiquidationDto.getLiqMem().equals("")) {
			listLiu = Arrays.asList(midLiquidationDto.getLiqMem().split("、"));
		}

		List<PubOtherlicenceDto> data = pubOtherlicenceService.select_queryPage(page);// 执行参数条件查询
		List<PubServerModrecord> pubOtherlicenceModList = new ArrayList<PubServerModrecord>();
		for (PubOtherlicenceDto pubOtherlicenceDto : data) {
			// 变更信息
			pubOtherlicenceModList = pubServerModrecordService.doGetAlterInfoList(pubOtherlicenceDto.getLicID());
			pubOtherlicenceDto.setPubOtherlicenceModList(pubOtherlicenceModList);
		}
		o.put("otherList", pubOtherlicenceModList);// 行政许可信息

		o.put("listLiu", listLiu);
		o.put("size", listLiu.size());
		List<PubOtherpunishDto> pushdata = pubOtherpunishService.queryPageForPub(page);
		for (PubOtherpunishDto pubOtherpunishDto : pushdata) {
			// 变更信息
			List<PubOtherPunishAlter> pubOtherPunishAlterList = pubOtherPunishAlterService
					.doGetAlterInfoList(pubOtherpunishDto.getPriPID(), pubOtherpunishDto.getCaseNO());
			pubOtherpunishDto.setPubOtherPunishAlterList(pubOtherPunishAlterList);
		}
		o.put("pushList", pushdata);// 行政处罚信息
		// 经营异常信息
		if (entBasicInfo.getEntTypeCatg() == "50") {
			List<PubPbopanomaly> nomalydata = pubPbopanomalyService.queryPubPbopanomalyListForPub(page);
			o.put("nomalList", nomalydata);
		} else {
			List<PubOpanoMalyDto> Malydata = pubOpanoMalyService.queryPubOpanoMalyListForPub(page);
			o.put("nomalList", Malydata);
		}
		// 抽查检查
		List<PubScresultDto> pubScresultDtos = pubScresultService.queryPageResult(page);
		for (PubScresultDto dat : pubScresultDtos) {
			String result[] = dat.getScResult().split(",");
			StringBuffer buffer = new StringBuffer();
			for (String re : result) {// 判断类型|状态
				if (re.equals("1")) {
					buffer.append("正常（符合信息公示相关规定）;");
				} else if (re.equals("2")) {
					buffer.append("未按规定公示即时信息;");
				} else if (re.equals("3")) {
					buffer.append("未按规定公示年报信息;");
				} else if (re.equals("4")) {
					buffer.append("通过登记的住所（经营场所）无法联系;");
				} else if (re.equals("5")) {
					buffer.append("公示信息隐瞒真实情况、弄虚作假;");
				} else if (re.equals("6")) {
					buffer.append("不予配合情节严重;");
				} else if (re.equals("7")) {
					buffer.append("已办理营业执照注销;");
				} else if (re.equals("8")) {
					buffer.append("被吊销营业执照;");
				} else if (re.equals("9")) {
					buffer.append("被撤销登记;");
				} else {
					buffer.append("正常（符合信息公示相关规定）;");
				}
			}
			dat.setRemark(buffer.toString());
		}

		o.put("checkList", pubScresultDtos);
		// 司法协助
		List<PubJusticeInfo> jsutdata = pubJusticeInfoService.queryPageForPub(page);
		o.put("justList", jsutdata);
		// 动产抵押
		List<MortRegInfo> mortdata = mortRegInfoService.queryPage(page);
		o.put("mortList", mortdata);
		// 股权出质登记信息
		List<SpPledge> pledgdata = spPledgeService.queryPage(page);
		o.put("pledgList", pledgdata);
		// 即时信息
		List<ImInvestment> invesList = new ArrayList<ImInvestment>();
		page.getParams().put("pubFlag", "1");
		page.getParams().put("pageNum", 0);
		invesList = imInvestmentService.findInvestmentWithDetatilForPub(page);
		o.put("invesList", invesList);// 股东出资信息
		// 股权变更
		List<ImInvsralt> Ivsralist = new ArrayList<ImInvsralt>();
		Ivsralist = imInvsraltService.queryPageForPub(page, priPID);
		o.put("Ivsralist", Ivsralist);
		// 行政许可
		List<ImPermit> permitlist = new ArrayList<ImPermit>();
		permitlist = imPermitService.queryPageForPub(page, priPID);
		o.put("permitlist", permitlist);
		// 知识产权出质
		List<ImIppldg> ippldglist = new ArrayList<ImIppldg>();
		ippldglist = imIppldgService.queryPageForPUb(page, priPID);
		o.put("ippldglist", ippldglist);
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/pub/infopublic/infodetail/resource");
		// 行政处罚
		List<ImCaseDto> caseList = imCaseService.queryToPub(page, priPID);
		for (ImCaseDto dto : caseList) {
			List<ImCasalt> lis = casaltService.queryForPub(dto.getCaseNO());
			dto.setCaslatList(lis);
		}
		o.put("caseList", caseList);

		// 年度信息
		List year_list = new ArrayList();
		String t = entBasicInfo.getEntTypeCatg();
		String yearstr = "";
		if (t.equals("50")) {
			year_list = pbBaseinfoService.queryPbYrInfoByPriPID(priPID);
			for (Object b : year_list) {
				PbBaseinfoDto pbBaseinfoDto = (PbBaseinfoDto) b;
				if (pbBaseinfoDto == null)
					continue;
				// if("6".equals(pbBaseinfoDto.getReportType())){
				// year_list.remove(b);
				// }
				String ifFilter = pbBaseinfoService.queryAnduitStateInfoByAncheID(priPID, pbBaseinfoDto.getYear());
				if ("0".equals(ifFilter)) {
					pbBaseinfoDto.doFilterForbidword();
				}
				yearstr += "," + pbBaseinfoDto.getYear();
				// 获取企业报表类型
				String repType = RepTypeUtil
						.getReportTypeList(t, entBasicInfo.getEntType(), pbBaseinfoDto.getYear().toString()).toString();
				pbBaseinfoDto.setRepYearType(repType);
				page.getParams().put(Constants.CS_ANCHEID, pbBaseinfoDto.getAnCheID());
				List<PbWebsiteinfoDto> pbWebsiteinfoDtos = pbWebsiteinfoService
						.queryListResult(pbBaseinfoDto.getAnCheID());

				if ("0".equals(ifFilter)) {
					for (PbWebsiteinfoDto pbWebsiteinfo : pbWebsiteinfoDtos) {
						if (pbWebsiteinfo != null) {
							pbWebsiteinfo.doFilterForbidword();
						}
					}
				}
				pbBaseinfoDto.setPbWebsiteList(pbWebsiteinfoDtos);// 个体户网站信息
				// 行政许可
				List<PbLicenceinfoDto> licendata = pbLicenceinfoService.queryPage(page);
				if ("0".equals(ifFilter)) {
					for (PbLicenceinfoDto pbLicenceinfo : licendata) {
						if (pbLicenceinfo != null) {
							pbLicenceinfo.doFilterForbidword();
						}
					}
				}
				pbBaseinfoDto.setPbLicenceList(licendata);// 行政许可信息
			}
		} else if (t.equals("16") || t.equals("17")) {
			// 农专年报信息查看详情列表页
			year_list = sfcBaseInfoService.queryPageResult(page);
			for (Object b : year_list) {
				SfcBaseInfoDto sfcBaseInfoDto = (SfcBaseInfoDto) b;
				if (sfcBaseInfoDto == null)
					continue;
				String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(priPID, sfcBaseInfoDto.getYear());
				if ("0".equals(ifFilter)) {
					sfcBaseInfoDto.doFilterForbidword();
				}
				yearstr += "," + sfcBaseInfoDto.getYear();
				String repType = RepTypeUtil
						.getReportTypeList(t, entBasicInfo.getEntType(), sfcBaseInfoDto.getYear().toString())
						.toString();
				sfcBaseInfoDto.setRepYearType(repType);
				// 农专网站信息
				List<SfcWebsiteInfoDto> sfcWebsiteInfoDtos = sfcWebsiteInfoService
						.queryListResult(sfcBaseInfoDto.getAnCheID());
				if ("0".equals(ifFilter)) {
					for (SfcWebsiteInfoDto sfcWebsiteInfo : sfcWebsiteInfoDtos) {
						if (sfcWebsiteInfo != null) {
							sfcWebsiteInfo.doFilterForbidword();
						}
					}
				}
				page.getParams().put(Constants.CS_ANCHEID, sfcBaseInfoDto.getAnCheID());
				sfcBaseInfoDto.setSfcWebList(sfcWebsiteInfoDtos);// 农专网站信息
				List<SfcBranchInfoDto> branchdata = sfcBranchInfoService.queryPage(page);

				if ("0".equals(ifFilter)) {
					for (SfcBranchInfoDto sfcBranceInfo : branchdata) {
						if (sfcBranceInfo != null) {
							sfcBranceInfo.doFilterForbidword();
						}
					}
				}
				sfcBaseInfoDto.setBranchList(branchdata);// 分支机构
				// 行政许可信息
				List<SfcLicenceInfoDto> licencedata = sfcLicenceInfoService.queryPage(page);
				if ("0".equals(ifFilter)) {
					for (SfcLicenceInfoDto sfcLicenceInfo : licencedata) {
						if (sfcLicenceInfo != null) {
							sfcLicenceInfo.doFilterForbidword();
						}
					}
				}
				sfcBaseInfoDto.setLicenceList(licencedata);// 行政许可信息
			}

		} else {
			year_list = baseInfoService.queryPageResult(page);
			for (Object b : year_list) {
				BaseInfoDto baseInfoDto = (BaseInfoDto) b;
				if (baseInfoDto == null)
					continue;
				String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(priPID, baseInfoDto.getYear());
				if ("0".equals(ifFilter)) {
					baseInfoDto.doFilterForbidword();
				}
				yearstr += "," + baseInfoDto.getYear();
				String repType = RepTypeUtil
						.getReportTypeList(t, entBasicInfo.getEntType(), baseInfoDto.getYear().toString()).toString();
				baseInfoDto.setRepYearType(repType);
				baseInfoDto.getAnCheID();
				page.getParams().put("priPID", priPID);
				page.getParams().put(Constants.CS_ANCHEID, baseInfoDto.getAnCheID());
				baseInfoDto.setWebList(websiteInfoService.queryPage(page));// 网址网店信息

				// 股东及其出资信息
				List<SubcapitalDto> subCapdata = subcapitalService.queryPageForPub(page);
				String ifFilterd = baseInfoService.queryAnduitStateInfoByAncheID(baseInfoDto.getAnCheID());
				if ("0".equals(ifFilterd)) {
					for (SubcapitalDto subcapital : subCapdata) {
						if (subcapital != null) {
							subcapital.doFilterForbidword();
						}
					}
				}
				baseInfoDto.setSubcapiList(subCapdata);// 股东及其出资信息
				// 对外投资信息
				List<ForinvestMentDto> forinvestMentDtos = forinvestMentService
						.queryListResult(baseInfoDto.getAnCheID());
				if ("0".equals(ifFilterd)) {
					for (ForinvestMentDto forinvestMent : forinvestMentDtos) {
						if (forinvestMent != null) {
							forinvestMent.doFilterForbidword();
						}
					}
				}
				baseInfoDto.setForInvesList(forinvestMentDtos);
				// 对外提供担保信息
				List<ForGuaranteeInfoDto> forgGuarantdata = forGuaranteeInfoService.queryPageForPub(page);

				if ("0".equals(ifFilterd)) {
					for (ForGuaranteeInfoDto forGuaranteeInfo : forgGuarantdata) {
						if (forGuaranteeInfo != null) {
							forGuaranteeInfo.doFilterForbidword();
						}
					}
				}
				baseInfoDto.setForGuarantList(forgGuarantdata);
				// 股权变更信息
				List<AlterStockInfoDto> stockdata = alterStockInfoService.queryPageForPub(page);
				if ("0".equals(ifFilter)) {
					for (AlterStockInfoDto alterStockInfo : stockdata) {
						if (alterStockInfo != null) {
							alterStockInfo.doFilterForbidword();
						}
					}
				}
				baseInfoDto.setStockInfoList(stockdata);
			}
		}
		o.put("year_list", year_list);
		o.put("yearstr", yearstr.length() > 1 ? yearstr.substring(1) : "");
		String uuid = UUID.randomUUID().toString().replace("-", "");
		PdfUtils.generateToFile(request, path, "tpl.ftl", path + "/", o, path + "/" + uuid + ".pdf");
		FileSystemResource file = new FileSystemResource(new File(path + "/" + uuid + ".pdf"));
		SendEmailUtil.send(receiver, file, entBasicInfo.getEntName());
		File filetoDel = new File(path + "/" + uuid + ".pdf");
		if (filetoDel.isFile()) {
			filetoDel.delete();
		}

		return AjaxResult.success("发送成功,请您注意查收。");
	}

}