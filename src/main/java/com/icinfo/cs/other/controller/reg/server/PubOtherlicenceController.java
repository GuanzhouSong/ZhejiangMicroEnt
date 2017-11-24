/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.im.service.IImPrmtaltService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.other.dto.LicenceInvalidCount;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.cs.other.model.PubOtherlicenceHis;
import com.icinfo.cs.other.service.IPubOtherlicenceHisService;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_otherlicence 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({ "/reg/server/other/pubohterlicence/", "/syn/server/other/pubohterlicence/" })
public class PubOtherlicenceController extends CSBaseController {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(PubOtherlicenceController.class);

	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IPubOtherlicenceHisService pubOtherlicenceHisService;
	@Autowired
	private ICodeRegunitService codeRegunitService;
	@Autowired
	private ICodeEntcatgService codeEntcatgService;
	@Autowired
	private ICodeSlicenoService codeSlicenoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IImPermitService permitService;
	@Autowired
	private IImPrmtaltService prmtaltService;
	@Autowired
	IEntSearchService entSearchService;
	@Autowired
	IPubEppasswordService pubEppasswordService;
	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	@Autowired
	IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;
	@Autowired
	IPubScentResultService pubScentResultService;
	@Autowired
	IQualificationLimitService qualificationLimitService;

	/**
	 * 
	 * 描述:to审核页面
	 * 
	 * @auther ljx
	 * @date 2016年10月20日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/pubotherlicence_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("1")) {
			view.addObject("urlType", "/reg");
		} else {
			view.addObject("deptCode", sysUser.getDeptCode());// 部门id

			view.addObject("urlType", "/syn");
		}

		return view;
	}

	@RequestMapping("/toSearch")
	public ModelAndView toSearch(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/pubotherlicence_search");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listJSON")
	@ResponseBody
	public PageResponse<PubOtherlicenceDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		Map<String, Object> parmMap = request.getParams();
		if (parmMap == null) {
			parmMap = new HashMap<String, Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<PubOtherlicenceDto> data = pubOtherlicenceService.selectPubOtherlicenceByCation(request);
		return new PageResponse<PubOtherlicenceDto>(data);
	}

	@RequestMapping("/searchListJSON")
	@ResponseBody
	public PageResponse<PubOtherlicenceDto> searchListJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "t.CheckDep", "t.LocalAdm");
		Map<String, Object> parmMap = request.getParams();
		if (parmMap == null) {
			parmMap = new HashMap<String, Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<PubOtherlicenceDto> data = pubOtherlicenceService.selectImPrimitByCation(request);
		return new PageResponse<PubOtherlicenceDto>(data);
	}

	/**
	 * 
	 * 描述: 登记机关树状结构json数据
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeListJSON")
	@ResponseBody
	public AjaxResult treeListJSON(String isPermissionCheck) throws Exception {
		Map param = new HashedMap();
		if ("true".equals(isPermissionCheck)) {
			param.put("regUnit_permission_limit", getLimitReg());// 权限限制字段
			List<Map<String, Object>> data = codeRegorgService.selectToTreeMap(param);
			return AjaxResult.success("查询成功", data);
		}
		List<Map<String, Object>> data = codeRegorgService.selectToTreeMap(param);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: to登记机关树页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toTreeView")
	public ModelAndView toTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/treeview");
		return view;
	}

	/**
	 * 
	 * 描述: 管辖单位json
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeRegUnitListJSON")
	@ResponseBody
	public AjaxResult treeRegUnitListJSON() throws Exception {
		List<Map<String, Object>> data = codeRegunitService.selectToTreeMap(new HashedMap());
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 企业类型json 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeEntcatgListJSON")
	@ResponseBody
	public AjaxResult treeEntcatgListJSON(String content) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		List<Map<String, Object>> data = codeEntcatgService.selectToTreeMap(map);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: 片区选择json
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeSlicenoListJSON")
	@ResponseBody
	public AjaxResult treeSlicenoListJSON(String isPermissionCheck) throws Exception {
		Map param = new HashedMap();
		if ("true".equals(isPermissionCheck)) {
			param.put("regUnit_permission_limit", getLimitReg());// 权限限制字段
			List<Map<String, Object>> data = codeSlicenoService.selectToTreeMap(param);
			return AjaxResult.success("查询成功", data);
		}
		List<Map<String, Object>> data = codeSlicenoService.selectToTreeMap(param);
		return AjaxResult.success("查询成功", data);

	}

	/**
	 * 
	 * 描述: 去管辖单位树页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toRegUnitTreeView")
	public ModelAndView toRegUnitTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/regUnitTreeView");
		return view;
	}

	/**
	 * 
	 * 描述: to企业类型选择页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEntcatgTreeView")
	public ModelAndView toEntcatgTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/entcatgTreeView");
		return view;

	}

	/**
	 * 
	 * 描述: to片区选择页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSlicenoTreeView")
	public ModelAndView toSlicenoTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/slicenoTreeView");
		return view;
	}

	/**
	 * 
	 * 描述: to审核详情页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String licID, String entType, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView();
		if (StringUtils.isNotEmpty(licID)) {
			PubOtherlicence pubOtherlicence = pubOtherlicenceService.selectByOne(licID);
			view.addObject("pubOtherlicence", pubOtherlicence);
			PubOtherlicenceHis pubOtherlicenceHis = new PubOtherlicenceHis();
			pubOtherlicenceHis.setPriPID(pubOtherlicence.getPriPID());
			pubOtherlicenceHis.setLicNO(pubOtherlicenceHis.getLicNO());
			List<PubOtherlicenceHis> hisList = pubOtherlicenceHisService.selectOtherLincesHisList(pubOtherlicenceHis);
			view.addObject("hisList", hisList);
		}
		if (StringUtils.isNotEmpty(entType) && entType.equals("audit")) {
			view.setViewName("/reg/server/other/otherlicence/otheerlicence_audit");
		} else {
			view.setViewName("/reg/server/other/otherlicence/otheerlicence_detail");
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。

		return view;
	}

	/**
	 * 
	 * 描述: 审核操作
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param pubOtherlicence
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/auditOtherLinence")
	@ResponseBody
	public AjaxResult auditOtherLinence(PubOtherlicence pubOtherlicence) throws Exception {
		if (pubOtherlicenceService.auditOtherlicence(pubOtherlicence) > 0) {
			return AjaxResult.success("操作成功");
		} else {
			return AjaxResult.error("操作失败");
		}
	}

	/**
	 * 
	 * 描述: 查看详情
	 * 
	 * @auther ljx
	 * @date 2016年10月21日
	 * @param licID
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetails")
	public ModelAndView showDetails(String licID, String priPID, String type, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView();
		if (StringUtils.isNotEmpty(priPID)) {
			view.addObject("midBaseInfo", midBaseInfoService.selectByPripid(priPID));
		}
		if (StringUtils.isNotEmpty(type) && type.equals("enterprise")) {
			if (StringUtils.isNotEmpty(licID)) {
				view.addObject("perMit", permitService.selectByLicId(licID, priPID));
				view.addObject("perMaltlist", prmtaltService.selectBylicID(licID));
				view.setViewName("/reg/server/other/otherlicence/perMitDetails");
			}
		} else if (StringUtils.isNotEmpty(type) && type.equals("other")) {
			view.addObject("otherLicence", pubOtherlicenceService.selectByOne(licID));
			view.addObject("perMaltlist", prmtaltService.selectBylicID(licID));// 变更信息
			view.setViewName("/reg/server/other/otherlicence/otherLicenceDetails");
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。

		return view;

	}

	/**
	 * 
	 * 描述: 查询统计
	 * 
	 * @auther ljx
	 * @date 2016年10月23日
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/count")
	@ResponseBody
	public AjaxResult count(PubOtherlicenceDto dto) throws Exception {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		return AjaxResult.success("查询成功", pubOtherlicenceService.selectCountOtherLicence(dto, qryMap));
	}

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther 查询企业基本信息
	 * @date 2016年11月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listMidJSON")
	@ResponseBody
	public PageResponse<MidBaseInfo> listMidJSON(PageRequest request) throws Exception {
		List<MidBaseInfo> data = pubOtherlicenceService.queryMidBasePageForOtherAdd(request);
		return new PageResponse<MidBaseInfo>(data);
	}

	/**
	 * 获取权限限制
	 * 
	 * @return
	 */
	public String getLimitReg() {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		String level = sysUser.getUserVest(sysUser);
		String isAdmin = sysUser.getIsAdmin();
		// 1：本所2：本局3：本市4：本省
		if (StringUtils.isNotBlank(isAdmin) && "1".equals(isAdmin)) { // 管理员权限放开
			return "";
		}
		if (StringUtils.equalsIgnoreCase(level, "1") || StringUtils.isBlank(level)) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6);
		}
		if (StringUtils.equalsIgnoreCase(level, "2")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6);
		}
		if (StringUtils.equalsIgnoreCase(level, "3")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 4);
		}
		return "";
	}

	/**
	 * 描述：食品许可到期数量
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param session
	 */
	@RequestMapping("foodExpireNum")
	@ResponseBody
	public void foodExpireNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = pubOtherlicenceService.foodExpireNum(qryMap);
		System.out.println(count + "====================");
	}

	/**
	 * 描述：药品许可到期数量
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param session
	 */
	@RequestMapping("drugsExpireNum")
	@ResponseBody
	public void drugsExpireNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = pubOtherlicenceService.drugsExpireNum(qryMap);
		System.out.println(count + "============");
	}

	/**
	 * 
	 * 描述：进入许可证失效到期管理页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月15日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("licenceinvalid")
	public ModelAndView licenceInvalid() throws Exception {
		ModelAndView modelAndView = new ModelAndView("/reg/server/other/otherlicence/licenceinvalid_list");
		modelAndView.addObject("regState", RegStateEnum.CUNXU.getCode());
		return modelAndView;
	}

	/**
	 * 
	 * 描述：许可证失效到期管理json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月15日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("licenceinvalidjson")
	@ResponseBody
	public PageResponse<PubOtherlicenceDto> licenceInvalidJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<PubOtherlicenceDto> data = pubOtherlicenceService.selectLicenceInvalidMgrJSON(request);
		return new PageResponse<PubOtherlicenceDto>(data);
	}

	/**
	 * 
	 * 描述: 许可证到期管理数据统计
	 * 
	 * @auther baifangfang
	 * @date 2017年11月17日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "licenceinvalidcount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult licenceInvalidCount(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<Integer> countList = new ArrayList<Integer>();
		LicenceInvalidCount licenceInvalidCount = pubOtherlicenceService.queryLicenceInvalidCount(request);
		if (licenceInvalidCount != null) {
			countList.add(licenceInvalidCount.getEntNum());
			countList.add(licenceInvalidCount.getLicenceNum());
		} else {
			countList.add(0);
			countList.add(0);
		}
		return AjaxResult.success("统计数成功", countList);
	}

	@RequestMapping("licenceinvaliddetail")
	public ModelAndView licenceInvalidDetail(@RequestParam String priPID) throws Exception {
		ModelAndView mav = new ModelAndView("/reg/server/other/otherlicence/licenceinvalid_detail");
		MidBaseInfoDto midBaseInfoDto = entSearchService.selectByPripid(priPID);
		List<MidBaseInfoDto> midDtos = midBaseInfoService.selectPunishDate(priPID);
		if (midDtos != null && midDtos.size() > 0) {
			midBaseInfoDto.setPunishDate(midDtos.get(0).getPunishDate());
		}
		if (midBaseInfoDto != null) {
			List<QualificationLimit> limits = qualificationLimitService
					.selectLimitPersonInfo(midBaseInfoDto.getPriPID());
			mav.addObject("isLimit", limits);
		}
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		mav.addObject("midBaseInfoDto", midBaseInfoDto);
		mav.addObject("liaName", pubEppassword == null ? "" : pubEppassword.getLianame());
		mav.addObject("liaTel", pubEppassword == null ? "" : pubEppassword.getTel());
		mav.addObject("dto", midBaseInfoDto);
		mav.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
		mav.addObject("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID(priPID));
		// 检查是否查无下落
		String notFoundFlag = getNotFoundFlag(priPID, midBaseInfoDto.getEntTypeCatg());
		mav.addObject("notFoundFlag", notFoundFlag);
		mav.addObject("regState", RegStateEnum.CUNXU.getCode());
		return mav;
	}

	/**
	 * 
	 * 描述 @author 赵祥江 @date 2017年11月6日 下午3:53:25 @param @return String @throws
	 */
	public String getNotFoundFlag(String priPID, String entTypeCatg) throws Exception {
		// 查询企业查无下落列入异常的最大列入日期
		PubOpanoMalyDto pubOpanoMalyDto = pubOpanoMalyService.selectMaxAbnTimePubOpanoMalyByPriPID(priPID, entTypeCatg,
				"4");
		// 获取企业检查结果包括查无下落的最大检查日期
		PubScentResultDto pubScentResultDto = pubScentResultService.selectMaxCheckDateScentResultByPriPID(priPID);
		if ((pubOpanoMalyDto == null || pubOpanoMalyDto.getAbnTime() == null)
				&& (pubScentResultDto == null || pubScentResultDto.getCheckDate() == null)) {
			return "0";
		}
		return "1";
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
			PubOpanoMalyDto pubOpanoMalyDto = pubOpanoMalyService.selectMaxAbnTimePubOpanoMalyByPriPID(priPID,
					entTypeCatg, null);
			if (pubOpanoMalyDto != null && pubOpanoMalyDto.getAbnTime() != null) {
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