/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.controller.reg.server;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.model.PubPbopanomaly;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: 个体户异常.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Controller
@RequestMapping({ "/reg/server/opanomaly/pbopanomaly", "/syn/server/opanomaly/pbopanomaly" })
public class PubPbopanomalyController extends CSBaseController {
	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private IRegIndexService regIndexService;

	private Map<String, Object> queryMap;
	
	@Autowired
	IEsManageService esManageService;

	/**
	 * 描述: 进入异常标记的列表主页面
	 * 
	 * @author ZhouJun
	 * @date 2016年10月10日
	 * @param session
	 * @return
	 */
	@RequestMapping("/pbopanomalySign")
	public ModelAndView pbopanomalySign(HttpSession session) {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysign/pbopanomaly_main");
		return mav;
	}

	/**
	 * 描述: 表格加载
	 * 
	 * @author ZhouJun
	 * @date 2016年9月27日
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping({ "/midBaseInfoList.json", "list.xml" })
	@ResponseBody
	public PageResponse<MidBaseInfo> midBaseInfoList(PageRequest request) throws Exception {
		List<MidBaseInfo> midBaseInfolist = pubPbopanomalyService.selectmidBaseInfolist(request);
		return new PageResponse<MidBaseInfo>(midBaseInfolist);
	}

	/**
	 * 
	 * 描述: 可标记企业列表（索引）
	 * 
	 * @auther gaojinling
	 * @date 2016年12月12日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/panoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "checkDep", "localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

	/**
	 * 描述: 新增异常页面
	 * 
	 * @author ZhouJun
	 * @date 2016年10月10日
	 * @param regNO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/tosign")
	public ModelAndView tosign(String priPid, String regNO, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysign/pbopanomaly_addsign");
		// 基本信息
		MidBaseInfo mbi = midBaseInfoService.selectByPripid(priPid);
		mav.addObject("midBaseInfo", mbi);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(mbi == null ? "00" : mbi.getRegOrg());
		mav.addObject("codeRegorg", codeRegorg);
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		String lastyear = year.format(DateUtil.getNyearlaterDateObject(new Date(), -1));
		mav.addObject("lastyear", lastyear);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		mav.addObject("currentTime", formatter.format(new Date()));
		// 当前登录用户信息
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysuser", sysUser);
		// 当前登录用户异常信息
		Map<String, Object> searchmaps = new HashMap<>();
		searchmaps.put("regNO", regNO);
		// searchmaps.put("priPID", priPid);
		mav.addObject("pbopanomalyList", pubPbopanomalyService.PubPbopanomalySearchList(searchmaps));
		// 主表年报信息
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPid,
				Integer.parseInt(DateUtil.getPreYear()));
		mav.addObject("yrRegCheck", yrRegCheck);
		return mav;
	}

	/**
	 * 描述: 添加异常标记
	 * 
	 * @author ZhouJun
	 * @date 2016年10月10日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addSign", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addSign(PubPbopanomaly pbopanomaly) throws Exception {
		if (pubPbopanomalyService.addSign(pbopanomaly) > 0) {
			// 插入成功 ，更新索引
			Map<String, Object> indexMap = new HashMap<String, Object>();
			indexMap.put("priPID", pbopanomaly.getPriPID());
			try {
				indexMap.put("isOpan", "Y");
				// 更新索引，异常捕捉，索引更新失败与否，不影响业务
				panoramaSearchService.updatePanoramaIdx(indexMap);
				Map<String, Object> indexserverMap = new HashMap<String, Object>();
				indexserverMap.put("priPID", pbopanomaly.getPriPID());
				indexserverMap.put("isOpanomaly", "1");
				entSearchService.updatePubIndex(indexserverMap);
			} catch (Exception e) {
				return AjaxResult.success("恢复成功");
			}
			return AjaxResult.success("新增成功");
		} else {
			return AjaxResult.error("新增失败");
		}
	}

	/**
	 * 描述: 异常标记进入详情页
	 * 
	 * @author ZhouJun
	 * @date 2016年10月11日
	 * @param regNO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toDetail")
	public ModelAndView toDetail(@RequestParam String busExcList) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysign/pbopanomaly_detail");
		PubPbopanomaly pubPbopanomaly = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomaly", pubPbopanomaly);
		return mav;
	}
	/*--------个体户经营异常状态查询----------- */

	/**
	 * 
	 * 描述 进入个体户经营状态查询列表页面 @author 赵祥江 @date 2016年10月8日 下午9:05:38 @param
	 * 
	 * @return ModelAndView @throws
	 */
	@RequestMapping("/pbopanomalySearchPage")
	public ModelAndView pbopanomalySearchPage(String priPID, String year) throws Exception {
		ModelAndView view = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalysearch_list");
		view.addObject("year", Integer.parseInt(DateUtil.getCurrentYear()) - 1);
		return view;
	}

	/**
	 * 
	 * 描述 经营状态查询 进入查看页面 @author 赵祥江 @date 2016年10月9日 下午5:39:59 @param @return
	 * ModelAndView @throws
	 */
	@RequestMapping(value = "/pbopanomalySearchViewPage", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView pbopanomalySearchViewPage(String busExcList) throws Exception {
		ModelAndView view = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalysearch_edit");
		if (StringUtil.isNotEmpty(busExcList)) {
			PageRequest re = new PageRequest();
			Map<String, Object> parmMap = new HashMap<String, Object>();
			parmMap.put("busExcList", busExcList);
			re.setParams(parmMap);
			List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.queryPubPbopanomalySearchList(re);
			view.addObject("pubPbopanomalyDtoList", pubPbopanomalyDtoList);
		}
		return view;
	}

	/**
	 * 
	 * 描述 统计标记企业和标记未恢复 标记已恢复的企业 @author 赵祥江 @date 2016年10月9日
	 * 下午4:11:14 @param @return AjaxResult @throws
	 */
	@RequestMapping(value = "/getEntCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntCount() throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("EntCount", pubPbopanomalyService.selectEntCount(queryMap));
		dataMap.put("MarkEntCount", pubPbopanomalyService.selectMarkEntCount(queryMap));
		dataMap.put("RenewEntCount", pubPbopanomalyService.selectRenewEntCount(queryMap));
		return AjaxResult.success("", dataMap);
	}

	/**
	 * 
	 * 描述 个体户经营异常状态查询 @author 赵祥江 @date 2016年10月9日 上午10:45:58 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping({ "/pbopanomalySearchList.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubPbopanomalyDto> pbopanomalySearchListJSON(PageRequest request) throws Exception {
		List<PubPbopanomalyDto> pubPbopanomalyDtoList;
		if (!request.getParams().containsKey("removePermit")) {
			creatDefaultDBAuthEnv(request, "A.CheckDep", "A.LocalAdm");
		}
		// 将查询参数赋给全局查询MAP方便统计
		queryMap = request.getParams();
		pubPbopanomalyDtoList = pubPbopanomalyService.queryPubPbopanomalySearchList(request);
		return new PageResponse<PubPbopanomalyDto>(pubPbopanomalyDtoList);
	}

	/* -----------------------------异常标记恢复------------------------------- */
	/**
	 * 描述: 进入异常标记恢复的主页
	 * 
	 * @author ZhouJun
	 * @date 2016年10月10日
	 * @return
	 */
	@RequestMapping("/pbopanomalyRecoList")
	public ModelAndView pbopanomalyRecolist() {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalyrecover/pbopanomaly_main");
		return mav;
	}

	/**
	 * 描述: 获取可以恢复的异常名录
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/pbopanomalySearchRecoverList.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubPbopanomalyDto> pbopanomalySearchRecoverList(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "A.CheckDep", "A.LocalAdm");
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService
				.queryPubPbopanomalySearchRecoverList(request);
		return new PageResponse<PubPbopanomalyDto>(pubPbopanomalyDtoList);
	}

	/**
	 * 描述: 进入恢复页面
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param busExcList
	 * @param priPid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pbopanomalyRecoPage")
	public ModelAndView pbopanomalyRecoPage(String busExcList, String priPid, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalyrecover/pbopanomaly_reco");
		Map<String, Object> searchmaps = new HashMap<>();
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPid,
				Integer.parseInt(DateUtil.getPreYear()));
		mav.addObject("yrRegCheck", yrRegCheck);
		PubPbopanomalyDto ppd = new PubPbopanomalyDto();
		searchmaps.put("busExcList", busExcList);
		if (pubPbopanomalyService.PubPbopanomalySearchList(searchmaps).size() != 0) {
			ppd = pubPbopanomalyService.PubPbopanomalySearchList(searchmaps).get(0);
		}
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(ppd.getRegOrg());
		mav.addObject("codeRegorg", codeRegorg);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		mav.addObject("currentTime", formatter.format(new Date()));
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysuser", sysUser);
		mav.addObject("pbopanomaly", ppd);
		return mav;
	}

	/**
	 * 描述: 恢复异常标记
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recoSign", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pbopanomalyReco(PubPbopanomaly pbopanomaly) throws Exception {
		if (pubPbopanomalyService.pubPbopanomalyRecover(pbopanomaly) > 0) {
			// 插入成功 ，更新索引
			Map<String, Object> indexMap = new HashMap<String, Object>();
			indexMap.put("priPID", pbopanomaly.getPriPID());
			List<PubPbopanomalyDto> indexList = pubPbopanomalyService.pubPbopanomalySearchRecoverList(indexMap);
			if (indexList == null || indexList.size() == 0) {
				try {
					indexMap.put("isOpan", "N");
					// 更新索引，异常捕捉，索引更新失败与否，不影响业务
					panoramaSearchService.updatePanoramaIdx(indexMap);
					Map<String, Object> indexserverMap = new HashMap<String, Object>();
					indexserverMap.put("priPID", pbopanomaly.getPriPID());
					indexserverMap.put("isOpanomaly", "0");
					entSearchService.updatePubIndex(indexserverMap);
				} catch (Exception e) {
					return AjaxResult.success("恢复成功");
				}
			}
			return AjaxResult.success("恢复成功");
		} else {
			return AjaxResult.success("恢复失败");
		}
	}

	/* ----协同个体户经营异常状态查询------------------------------------------------ */

	/**
	 * 
	 * 描述: 协同个体户经营异常状态查询
	 * 
	 * @auther gaojinling
	 * @date 2017年2月8日
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/synpbopanomalySearchPage")
	public ModelAndView synpbopanomalySearchPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/synpbopanomalysearch_list");
		view.addObject("year", Integer.parseInt(DateUtil.getCurrentYear()) - 1);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}

	/**
	 * 描述：个体户标记异常申请列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyApp")
	public ModelAndView pbopanomalyApp(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyapp_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述：个体户标记异常申请JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年6月19日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyApp.json")
	@ResponseBody
	public PageResponse<PubPbopanomalyDto> pbopanomalyAppListJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "B.checkDep", "B.localAdm");
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.queryPubPbopanomalyAppList(request);
		return new PageResponse<PubPbopanomalyDto>(pubPbopanomalyDtoList);
	}

	/**
	 * 描述：新增标记异常记录列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月20日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addPbopanomalyList")
	public ModelAndView addPbopanomalyList(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyadd_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述： 查询可标记的个体户列表
	 * 
	 * @author baifangfang
	 * @date 2017年6月27日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addPbopanomalyList.json")
	@ResponseBody
	public PageResponse<PanoramaResultDto> addPbopanomalyListJSON(PageRequest request) throws Exception {
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

	/**
	 * 描述：新增标记异常记录页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月20日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addPbopanomaly")
	public ModelAndView addPbopanomaly(@RequestParam String priPID, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomaly_add");
		// 基本信息
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		mav.addObject("midBaseInfo", midBaseInfo);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService
				.selectRegOrgByCode(midBaseInfo == null ? "00" : midBaseInfo.getRegOrg());
		mav.addObject("codeRegorg", codeRegorg);
		// 当前登录用户信息
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysuser", sysUser);
		// 当前登录用户异常信息
		Map<String, Object> searchmaps = new HashMap<>();
		if (midBaseInfo != null) {
			searchmaps.put("regNO", midBaseInfo.getRegNO());
			// 查询当前个体户的异常记录
			List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.selectPubPbopanomalys(searchmaps);
			mav.addObject("pbopanomalyList", pubPbopanomalyDtoList);
		}

		return mav;
	}

	/**
	 * 描述: 保存异常标记记录
	 * 
	 * @author baifangfang
	 * @date 2017年6月26日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "savePbopanomaly", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult savePbopanomaly(PubPbopanomaly pbopanomaly, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		pbopanomaly.setSetName(sysUser.getRealName());
		if (pubPbopanomalyService.savePbopanomaly(pbopanomaly) > 0) {
			//操作成功后  缓存重新设置（异常列入新增，+1）
			try {
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				String regOrg = selectRegorgByDeptCode(sysUser);
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				forBidmap.put("regOrg", regOrg);
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 4, 1,"1",sysUser);
			} catch (Exception e) {
				return AjaxResult.success("新增成功");
			}
			return AjaxResult.success("新增成功");
		} else {
			return AjaxResult.error("新增失败");
		}
	}

	/**
	 * 描述：修改标记异常记录页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月20日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editPbopanomaly")
	public ModelAndView eidtPbopanomaly(@RequestParam String busExcList, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomaly_edit");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		// 基本信息
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubPbopanomalyDto.getPriPID());
		mav.addObject("midBaseInfo", midBaseInfo);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService
				.selectRegOrgByCode(midBaseInfo == null ? "00" : midBaseInfo.getRegOrg());
		mav.addObject("codeRegorg", codeRegorg);
		// 当前登录用户信息
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysuser", sysUser);
		// 当前登录用户异常信息
		Map<String, Object> searchmaps = new HashMap<>();
		searchmaps.put("regNO", midBaseInfo.getRegNO());
		// 查询当前个体户的异常记录
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.selectPubPbopanomalys(searchmaps);
		mav.addObject("pbopanomalyList", pubPbopanomalyDtoList);

		return mav;
	}

	/**
	 * 描述: 保存修改异常标记记录
	 * 
	 * @author baifangfang
	 * @date 2017年6月26日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveEditPbopanomaly", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveEditPbopanomaly(PubPbopanomaly pbopanomaly) throws Exception {
		if (pubPbopanomalyService.saveEditPbopanomaly(pbopanomaly) > 0) {
			return AjaxResult.success("修改成功");
		} else {
			return AjaxResult.error("修改失败");
		}
	}

	/**
	 * 描述：删除异常标记记录
	 * 
	 * @author baifangfang
	 * @date 2017年6月28日
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deletePbopanomaly")
	@ResponseBody
	public AjaxResult deletePbopanomaly(@RequestParam String busExcList) throws Exception {
		if (!StringUtil.isEmpty(busExcList)) {
			if (pubPbopanomalyService.deletePbopanomalyByBusExcList(busExcList) > 0) {
				//操作成功后  缓存重新设置（异常列入删除，-1）
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				try {
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					String regOrg = selectRegorgByDeptCode(sysUser);
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					forBidmap.put("regOrg", regOrg);
					regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 4,1, "2",sysUser);
				} catch (Exception e) {
					return AjaxResult.success("删除成功!");
				}
				return AjaxResult.success("删除成功!");
			}
		}
		return AjaxResult.error("删除失败");
	}

	/**
	 * 描述：异常标记详情页
	 * 
	 * @author baifangfang
	 * @date 2017年6月28日
	 * @param regNO
	 * @param priPID
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyDetail")
	public ModelAndView pbopanomalyDetail(@RequestParam String busExcList) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomaly_detail");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		// 基本信息
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubPbopanomalyDto.getPriPID());
		mav.addObject("midBaseInfo", midBaseInfo);

		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService
				.selectRegOrgByCode(midBaseInfo == null ? "00" : midBaseInfo.getRegOrg());
		mav.addObject("codeRegorg", codeRegorg);

		// 查询当前个体户的异常记录
		Map<String, Object> searchmaps = new HashMap<>();
		searchmaps.put("regNO", midBaseInfo.getRegNO());
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.selectPubPbopanomalys(searchmaps);
		mav.addObject("pbopanomalyList", pubPbopanomalyDtoList);
		return mav;
	}

	/**
	 * 描述：打印审批表
	 * 
	 * @author baifangfang
	 * @date 2017年6月30日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyTablePrint")
	public ModelAndView pbopanomalyTablePrint(HttpSession session, @RequestParam String busExcList) throws Exception {
		ModelAndView mav = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalytable_print");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("deptName", sysUser.getDepartMent().getDeptName());
		return mav;
	}

	/**
	 * 描述：个体户标记异常审核列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月26日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyCheck")
	public ModelAndView pbopanomalyCheck(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalycheck_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述：个体户异常标记审核页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月26日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("checkpbopanomaly")
	public ModelAndView checkPbopanomaly(HttpSession session, String busExcList) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomaly_check");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		mav.addObject("currentTime", new Date());
		mav.addObject("sysUser", sysUser);
		return mav;
	}

	/**
	 * 描述：个体户异常标记审核
	 * 
	 * @author baifangfang
	 * @date 2017年6月27日
	 * @param pubPbopanomalyDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "docheckpbopanomaly", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCheckPbopanomaly(PubPbopanomalyDto pubPbopanomalyDto) throws Exception {
		PubPbopanomalyDto ppd = pubPbopanomalyService
				.selectPubPbopanomalyDtoByBusExcList(pubPbopanomalyDto.getBusExcList());
		ppd.setAuditDate(pubPbopanomalyDto.getAuditDate());
		ppd.setAuditDept(pubPbopanomalyDto.getAuditDept());
		ppd.setAuditName(pubPbopanomalyDto.getAuditName());
		ppd.setAuditOpin(pubPbopanomalyDto.getAuditOpin());
		ppd.setCogDate(pubPbopanomalyDto.getCogDate());
		ppd.setAuditState(pubPbopanomalyDto.getAuditState());

		if (pubPbopanomalyService.savePbopanomalyCheck(ppd) > 0) {
			if ("1".equals(pubPbopanomalyDto.getAuditState())) {// 审核成功，更新索引
				Map<String, Object> indexserverMap = new HashMap<String, Object>();
				indexserverMap.put("priPID", ppd.getPriPID());
				try {
					//更新全景索引
					esManageService.updateOnePanoramaIdx(ppd.getPriPID());
					indexserverMap.put("isOpanomaly", "1");
					entSearchService.updatePubIndex(indexserverMap);
				} catch (Exception e) {
					return AjaxResult.success("审核成功");
				}
			}
			try {
				//操作成功后  缓存重新设置（异常列入审核成功，-1）
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				String regOrg = selectRegorgByDeptCode(sysUser);
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				forBidmap.put("regOrg", regOrg);
				regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 4,1, "2",sysUser);
			} catch (Exception e) {
				return AjaxResult.success("审核成功");
			}
			return AjaxResult.success("审核成功");
		} else {
			return AjaxResult.error("审核失败");
		}
	}
	
	
	
	/**
	 * 描述：个体户异常处理，从7月1号开始
	 */
	@RequestMapping("test")
	public void test(){
		pubPbopanomalyService.test();
	}

}