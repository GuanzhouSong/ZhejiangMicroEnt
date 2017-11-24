package com.icinfo.cs.im.controller.reg.server;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.base.service.ICodeSetService;
import com.icinfo.cs.common.constant.CodeType;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.PdfUtils;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.im.dto.ImCaseDto;
import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.cs.im.model.ImInvactdetail;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.cs.im.model.ImInvprodetail;
import com.icinfo.cs.im.model.ImInvsralt;
import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.cs.im.model.ImPermit;
import com.icinfo.cs.im.service.IImCasaltService;
import com.icinfo.cs.im.service.IImCaseService;
import com.icinfo.cs.im.service.IImInvactdetailService;
import com.icinfo.cs.im.service.IImInvestmentService;
import com.icinfo.cs.im.service.IImInvprodetailService;
import com.icinfo.cs.im.service.IImInvsraltService;
import com.icinfo.cs.im.service.IImIppldgService;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 即时信息综合查询
 * 
 * @author ljx
 *
 */
@Controller
@RequestMapping("/reg/server/iminfo")
public class ImInfoSearchController extends CSBaseController {

	@Autowired
	IEntSearchService entSearchService;
	@Autowired
	IMidBaseInfoService midBaseInfoService;
	@Autowired
	IPubOpaDetailService pubOpaDetailService;
	@Autowired
	ICodeEntcatgService codeEntcatgService;
	@Autowired
	private IImInvactdetailService imInvactdetailService;
	@Autowired
	private IImInvprodetailService imInvprodetailService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IImInvsraltService imInvsraltService;
	@Autowired
	private IImPermitService imPermitService;
	@Autowired
	private IImIppldgService imIppldgService;
	@Autowired
	private IImCaseService imCaseService;
	@Autowired
	private ICodeSetService codeService;
	@Autowired
	private IImInvestmentService imInvestmentService;
	@Autowired
	private IImCasaltService casaltService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;

	@Autowired
	IErEscAppinfoService erEscAppinfoService;

	/**
	 * to 列表页
	 * 
	 * @author ljx
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("reg/server/iminfo/iminfolist");
		String level = sysUser.getUserVest(sysUser);

		Map<String, String> map = new HashMap<String, String>();
		if (level.equals("0") || level.equals("4")) {
			map.put("1", "本所");
			map.put("2", "本局");
			map.put("3", "本市");
			map.put("4", "本省");
			level = "4";
			view.addObject("map", map);
		}
		if (level.equals("3")) {
			map.put("1", "本所");
			map.put("2", "本局");
			map.put("3", "本市");
			view.addObject("map", map);
		}
		if (level.equals("2")) {
			map.put("1", "本所");
			map.put("2", "本局");
			view.addObject("map", map);
		}
		if (level.equals("1")) {
			map.put("1", "本所");
			view.addObject("map", map);
		}

		view.addObject("level", level);

		List<String> yearList = DateUtil.getYearToNow();
		yearList.remove(yearList.size() - 1);
		view.addObject("yearList", yearList);
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}

	/**
	 * 获取查询企业综合查询列表
	 * 
	 * @author ljx
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/comPanoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> comPanoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "localAdm", "localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetComSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

	/**
	 * to即时信息选项页
	 * 
	 * @author ljx
	 * @return
	 */
	@RequestMapping("/tochoseitem")
	public ModelAndView tochoseitem() {
		ModelAndView view = new ModelAndView("reg/server/iminfo/itemselect");
		return view;
	}

	/**
	 * to详情页
	 * 
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/todetail")
	public ModelAndView toDetail(String priPID, String leRep, String liaName, String imPubDate, String tel,
			String liaTel) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/iminfo/iminfodetail");
		view.addObject("leRep", leRep);
		view.addObject("liaName", liaName);
		view.addObject("imPubDate", imPubDate);
		view.addObject("tel", tel);
		view.addObject("liaTel", liaTel);

		if (StringUtils.isNotEmpty(priPID)) {
			MidBaseInfoDto entBasicInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);

			view.addObject("imReportType", RepTypeUtil
					.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());
			view.addObject("entBasicInfo", entBasicInfo);
			view.addObject("priPID", priPID);
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
			view.addObject("pubEppassword", pubEppassword);
			List<YrRegCheck> checkList = yrRegCheckService.doGetYrRegCheckInit(priPID);
			if (checkList != null && checkList.size() > 0) {
				view.addObject("reportTime", checkList.get(0).getFirstReportTime());
			}

			view.addObject("isOpanomaly", checkIsOpanomaly(entBasicInfo.getEntTypeCatg(), priPID));

			if (entBasicInfo != null && StringUtils.isNotEmpty(entBasicInfo.getEntTypeCatg())) {
				entBasicInfo.setEntTypeCatgName(
						codeEntcatgService.selectByCode(entBasicInfo.getEntTypeCatg()).getContent());
			}

		}

		// 查询该企业简易注销信息
		if (StringUtils.isNotBlank(priPID)) {
			ErEscAppinfo erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID);
			if (erEscAppinfo != null) {
				view.addObject("erEscAppinfo", erEscAppinfo);
			}
		}
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
		if ("50".equals(entTypeCatg)) {
			List<PubPbopanomalyDto> dataList = pubPbopanomalyService.pubPbopanomalySearchRecoverList(map);
			if (dataList != null && dataList.size() > 0)
				return "1";
			else
				return "0";
		}
		List<PubOpaDetailDto> dataList = pubOpaDetailService.selectAddMoveOutSearch(map);
		if (dataList != null && dataList.size() > 0)
			return "1";
		else
			return "0";
	}

	@RequestMapping("createPdf")
	public ResponseEntity<byte[]> createPdf(HttpServletRequest request, String priPID, String leRep, String tel,
			String liaName, String liaTel, String imPubDate) throws Exception {
		PageRequest page = new PageRequest();
		page.setLength(1000);
		Map<Object, Object> o = new HashMap<Object, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		o.put("leRep", leRep);
		o.put("tel", tel);
		o.put("liaName", liaName);
		o.put("liaTel", liaTel);
		o.put("imPubDate", imPubDate);

		map.put("priPID", priPID);

		// 查询该企业简易注销信息
		if (StringUtils.isNotBlank(priPID)) {
			ErEscAppinfo erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID);
			if (erEscAppinfo != null) {
				o.put("erEscAppinfo", erEscAppinfo);
			}
		}
		// if(StringUtils.isNotEmpty(priPID)){
		MidBaseInfoDto entBasicInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		o.put("isOpanomaly", checkIsOpanomaly(entBasicInfo.getEntTypeCatg(), priPID));
		o.put("entBasicInfo", entBasicInfo);
		String regNO = "";
		if (entBasicInfo.getUniCode() != null && !entBasicInfo.getUniCode().equals("")) {
			regNO = entBasicInfo.getUniCode();
		} else {
			regNO = entBasicInfo.getRegNO();
		}

		o.put("isOpanomaly", checkIsOpanomaly(entBasicInfo.getEntTypeCatg(), priPID));

		if (entBasicInfo != null && StringUtils.isNotEmpty(entBasicInfo.getEntTypeCatg())) {
			entBasicInfo
					.setEntTypeCatgName(codeEntcatgService.selectByCode(entBasicInfo.getEntTypeCatg()).getContent());
		}
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		o.put("pubEppassword", pubEppassword);
		List<YrRegCheck> checkList = yrRegCheckService.doGetYrRegCheckInit(priPID);
		if (checkList != null && checkList.size() > 0) {
			o.put("reportTime", checkList.get(0).getLastReportTime());
		}

		String path = request.getSession().getServletContext().getRealPath("WEB-INF/views/page/reg/server/iminfo");
		String uuid = UUID.randomUUID().toString().replace("-", "");
		// 即时信息
		List<ImInvestment> invesList = new ArrayList<ImInvestment>();
		map.put("pubFlag", "1");
		map.put("pageNum", 0);
		page.setParams(map);
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

		// 行政处罚
		List<ImCaseDto> caseList = imCaseService.queryToPub(page, priPID);
		for (ImCaseDto dto : caseList) {
			List<ImCasalt> lis = casaltService.queryForPub(dto.getCaseNO());
			dto.setCaslatList(lis);
		}
		o.put("caseList", caseList);

		PdfUtils.generateToFile(request, path, "tpl.ftl", path + "/", o, path + "/" + uuid + ".pdf");

		File file = new File(path + "/" + uuid + ".pdf");
		// 更改下载名称
		HttpHeaders headers = new HttpHeaders();
		String entName = entBasicInfo.getEntName() + ".pdf";
		String fileName = new String(entName.getBytes("GBK"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> bytes = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers,
				HttpStatus.OK);
		if (file.isFile() && file.exists()) {
			file.delete(); // 删除掉pdf文件
		}
		return bytes;
	}

	/**
	 * 查看即时信息股东出资详情
	 * 
	 * @param invID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showInvestment")
	public ModelAndView showInvestment(String invID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/iminfo/investment_detail");
		PageRequest request = new PageRequest();
		if (StringUtils.isNotEmpty(invID)) {
			List<ImInvactdetail> actList = imInvactdetailService.findByInvId(request, invID);
			List<ImInvprodetail> prvList = imInvprodetailService.findByInvIdNoPage(invID);
			view.addObject("actList", actList);
			view.addObject("prvList", prvList);
			ImInvestment investment = imInvestmentService.findByOnlyInvId(invID);
			view.addObject("inv", investment.getInv());
		}

		view.addObject("invID", invID);
		return view;
	}

	/**
	 * 股权变更详情
	 * 
	 * @param invAltID
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showinvsralt")
	public ModelAndView showInvsralt(String invAltID, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/iminfo/invsralt_detail");
		if (StringUtils.isNotEmpty(invAltID) && StringUtils.isNotEmpty(priPID)) {
			ImInvsralt imInvsralt = imInvsraltService.findByInvAltID(invAltID, priPID);
			view.addObject("imInvsralt", imInvsralt);
		}
		return view;
	}

	/**
	 * 行政许可详情
	 * 
	 * @param licId
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showpermit")
	public ModelAndView showPermit(String licID, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/iminfo/permit_detail");
		if (StringUtils.isNotEmpty(licID) && StringUtils.isNotEmpty(priPID)) {
			ImPermit mPermit = imPermitService.selectByLicId(licID, priPID);
			view.addObject("mPermit", mPermit);
		}
		return view;

	}

	/**
	 * 知识产权出质详情
	 * 
	 * @param pleID
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showippldg")
	public ModelAndView showIppldg(String pleID, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/iminfo/ippldg_detail");
		if (StringUtils.isNotEmpty(pleID) && StringUtils.isNotEmpty(priPID)) {
			ImIppldg imIppldg = imIppldgService.findByPleId(pleID, priPID);
			view.addObject("imIppldg", imIppldg);
		}
		return view;
	}

	/**
	 * 行政处罚详情
	 * 
	 * @param caseNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showcase")
	public ModelAndView showCase(String caseNO, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/iminfo/case_detail");
		if (StringUtils.isNotEmpty(caseNO) && StringUtils.isNotEmpty(priPID)) {
			ImCase imCase = imCaseService.findByCaseNO(caseNO, priPID);
			view.addObject("imCase", imCase);
			Map<String, Object> map = new HashMap<String, Object>();
			for (String str : imCase.getPenType().split(",")) {
				map.put(str, str);
			}
			view.addObject("penType", map);
			view.addObject("codeList", codeService.findCodeByType(CodeType.CODE_TYPE_PENTYPE));
		}
		return view;

	}

}
