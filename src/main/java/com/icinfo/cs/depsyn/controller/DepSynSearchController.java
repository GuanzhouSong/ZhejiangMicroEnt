package com.icinfo.cs.depsyn.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.depsyn.dto.DepSynSearchHisDto;
import com.icinfo.cs.depsyn.model.DepSynSearchHis;
import com.icinfo.cs.depsyn.model.DepSynSearchKey;
import com.icinfo.cs.depsyn.service.IDepSynSearchHisService;
import com.icinfo.cs.depsyn.service.IDepSynSearchService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.es.model.CsPubIlldisdetail;
import com.icinfo.cs.es.service.ICsPubIlldisdetailService;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBranchDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidBranchService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.BaseInfoDto;
import com.icinfo.cs.yr.dto.PbBaseinfoDto;
import com.icinfo.cs.yr.dto.SfcBaseInfoDto;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 查询控制器
 * 
 * @author caoxu
 *
 */
@Controller
@RequestMapping("/depsyn/search")
public class DepSynSearchController extends BaseController {

	@Autowired
	private IDepSynSearchService depSearchService;

	@Autowired
	private IDepSynSearchHisService depSearchHisService;
	
	@Autowired
	private IDepSynSearchHisService depSearchKeyService;

	@Autowired
	private IMidBaseInfoService midBaseInfoService;

	@Autowired
	IEntSearchService entSearchService;
	@Autowired
	IMidBranchService midBranchService;

	@Autowired
	IBaseInfoService baseInfoService;

	@Autowired
	IPbBaseinfoService pbBaseinfoService;

	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;
	
	@Autowired
	private ICsPubIlldisdetailService csPubIlldisdetailService;

	/**
	 * 描述：企业基本信息
	 * 
	 * @author baifangfang
	 * @date 2016年9月26日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/baseinfo")
	public ModelAndView yrbaseinfo(@RequestParam String encryPriPID, @RequestParam String classFlag) throws Exception {
		// logger.info("encryPriPID {}", encryPriPID);
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ModelAndView mav = new ModelAndView("depsyn/search/cx_xxxq");

		PubEntSearchDto entBasicInfo = entSearchService.selectByDocId(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);
		// logger.info("entBasicInfo {}", entBasicInfo);
		mav.addObject("entBasicInfo", entBasicInfo);
		mav.addObject("classflag", 1);// 1.基础信息2.行政许可信息3.行政处罚信息4.纳入经营异常5.纳入严重违法
		mav.addObject("classFlag", classFlag);// 1.企业信用信息2.经营异常名录3.严重违法失信
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());
		// 历史记录处理
		dealHistory(priPID);
		return mav;
	}
	
	private void dealHistory(String priPID) throws Exception {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userId", sysUser.getId());
		queryMap.put("priPID", priPID);
		boolean flag = this.depSearchHisService.historyExist(queryMap);
		DepSynSearchHis searchHis = new DepSynSearchHis();
		searchHis.setHisUserId(sysUser.getId());
		if (!flag) {
			MidBaseInfo baseInfo = midBaseInfoService.selectByPripid(priPID);
			// 保存查询记录
			this.depSearchHisService.insert(searchHis, baseInfo);
		} else {
			searchHis.setHisPriPID(priPID);
			// 更新查询记录
			this.depSearchHisService.update(searchHis);
		}
	}

	/**
	 * 企业即时信息
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/jsinfo")
	public ModelAndView jsinfo(@RequestParam String encryPriPID, @RequestParam String classFlag) throws Exception {
		// logger.info("encryPriPID {}", encryPriPID);
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ModelAndView mav = new ModelAndView("depsyn/search/iminfosyn");

		PubEntSearchDto entBasicInfo = entSearchService.selectByDocId(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);
		// logger.info("entBasicInfo {}", entBasicInfo);
		mav.addObject("entBasicInfo", entBasicInfo);
		mav.addObject("classflag", 1);// 1.基础信息2.行政许可信息3.行政处罚信息4.纳入经营异常5.纳入严重违法
		mav.addObject("classFlag", classFlag);// 1.企业信用信息2.经营异常名录3.严重违法失信
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());
		return mav;
	}

	/**
	 * 描述：企业其他信息
	 * 
	 * @author baifangfang
	 * @date 2016年9月26日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/qtinfo")
	public ModelAndView qtinfo(@RequestParam String encryPriPID, @RequestParam String classFlag) throws Exception {
		// logger.info("encryPriPID {}", encryPriPID);
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ModelAndView mav = new ModelAndView("depsyn/search/otherinfosyn");

		PubEntSearchDto entBasicInfo = entSearchService.selectByDocId(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);
		// logger.info("entBasicInfo {}", entBasicInfo);
		mav.addObject("entBasicInfo", entBasicInfo);
		mav.addObject("classflag", 1);// 1.基础信息2.行政许可信息3.行政处罚信息4.纳入经营异常5.纳入严重违法
		mav.addObject("classFlag", classFlag);// 1.企业信用信息2.经营异常名录3.严重违法失信
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());
		return mav;
	}

	/**
	 * 描述：处罚信息
	 * 
	 * @author baifangfang
	 * @date 2016年9月26日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cfinfo")
	public ModelAndView cfinfo(@RequestParam String encryPriPID, @RequestParam String classFlag) throws Exception {
//		logger.info("encryPriPID {}", encryPriPID);
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ModelAndView mav = new ModelAndView("depsyn/search/cfinfosyn");

		PubEntSearchDto entBasicInfo = entSearchService.selectByDocId(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);
//		logger.info("entBasicInfo {}", entBasicInfo);
		mav.addObject("entBasicInfo", entBasicInfo);
		mav.addObject("classflag", 1);// 1.基础信息2.行政许可信息3.行政处罚信息4.纳入经营异常5.纳入严重违法
		mav.addObject("classFlag", classFlag);// 1.企业信用信息2.经营异常名录3.严重违法失信
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());
		return mav;
	}
	
	/**
	 * 高级查询页面
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/searchlist" })
	public String searchlist(ModelMap model) throws Exception {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		model.addAttribute("sysUser", sysUser);
		return "/depsyn/search/search_list";
	}

	
	/**
	 * 查询接口
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/appsearchlist.json")
	@ResponseBody
	public Map<String, Object> listJSON(PageRequest request) throws Exception {
		long begin = System.currentTimeMillis();
		Page<PanoramaResultDto> data = depSearchService.doGetSearchList(request);
		long end = System.currentTimeMillis();
		long between = end - begin;
		Map<String, Object> result = new HashMap<String, Object>();
		float num = (float) between / 1000;
		DecimalFormat df = new DecimalFormat("0.00");
		result.put("costtime", df.format(num));
		result.put("data", new PageResponse<PanoramaResultDto>(data));
		return result;
	}

	/**
	 * 查询历史记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/historyList")
	@ResponseBody
	public List<DepSynSearchHisDto> historyList() {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userId", sysUser.getId());
		List<DepSynSearchHisDto> list = this.depSearchHisService.selectHistory(queryMap);
		return list;
	}

	@RequestMapping(value = "/midbranch/list.json")
	@ResponseBody
	public PageResponse<MidBranchDto> MidBranchListJSON(PageRequest request) throws Exception {
		List<MidBranchDto> list = midBranchService.queryPageResult(request);
		return new PageResponse<MidBranchDto>(list);
	}

	/**
	 * 描述：企业基本信息
	 * 
	 * @author baifangfang
	 * @date 2016年12月12日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("baseinfosyn")
	public ModelAndView selectByDocId(@RequestParam String encryPriPID) throws Exception {
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ModelAndView mav = new ModelAndView("depsyn/search/baseinfosyn");
		PubEntSearchDto entBasicInfo = entSearchService.selectByDocId(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);
		mav.addObject("entBasicInfo", entBasicInfo);
		// 即时信息报表配置
		mav.addObject("imReportType",
				RepTypeUtil.getImReportTypeList(entBasicInfo.getEntTypeCatg(), entBasicInfo.getEntType()).toString());
		// 历史记录处理
		dealHistory(priPID);
		return mav;
	}

	/**
	 * 描述：企业年报信息
	 * 
	 * @author baifangfang
	 * @date 2016年12月12日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("yrinfosyn")
	public ModelAndView yrcheckinfo(@RequestParam String encryPriPID, @RequestParam String year) throws Exception {
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		PubEntSearchDto entBasicInfo = entSearchService.selectByDocId(priPID);
		entBasicInfo.setEncryPriPID(encryPriPID);

		ModelAndView mav = new ModelAndView("depsyn/search/yrinfosyn");
		mav.addObject("entBasicInfo", entBasicInfo);
		String entTypeCatgStr = entBasicInfo.getEntTypeCatg();// 企业大类
		// 50 个体户，16,17 农专，其他 企业
		if ("50".equals(entTypeCatgStr)) {
			PbBaseinfoDto pbBaseinfoDto = pbBaseinfoService.queryPbYrInfoByPriPIDAndYear(priPID, year);
			String ifFilter = pbBaseinfoService.queryAnduitStateInfoByAncheID(priPID, Integer.parseInt(year));
			if ("0".equals(ifFilter)) {
				pbBaseinfoDto.doFilterForbidword();
			}
			mav.addObject("baseInfo", pbBaseinfoDto);
		} else if ("16".equals(entTypeCatgStr) || "17".equals(entTypeCatgStr)) {
			SfcBaseInfoDto sfcBaseInfoDto = sfcBaseInfoService.querySfcYrInfoByPriPIDAndYear(priPID, year);
			String ifFilter = sfcBaseInfoService.queryAnduitStateInfoByAncheID(priPID, Integer.parseInt(year));
			if ("0".equals(ifFilter)) {
				sfcBaseInfoDto.doFilterForbidword();
			}
			mav.addObject("baseInfo", sfcBaseInfoDto);
		} else {
			BaseInfoDto baseInfoDto = baseInfoService.queryYrInfoByPriPIDAndYear(priPID, year);
			String ifFilter = baseInfoService.queryAnduitStateInfoByAncheID(priPID, Integer.parseInt(year));
			if ("0".equals(ifFilter)) {
				baseInfoDto.doFilterForbidword();
			}
			mav.addObject("baseInfo", baseInfoDto);
		}
		// 获取企业报表类型
		String repType = RepTypeUtil.getReportTypeList(entTypeCatgStr, entBasicInfo.getEntType(), year).toString();
		mav.addObject("repType", repType);
		return mav;
	}
	
	/**
	 * 查询接口页面
	 * @return
	 */
	@RequestMapping("searchPort")
	public String searchPort() {
		return "/depsyn/search/search_port";
	}
	
	/**
	 * 保存筛选条件
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "saveParams", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveParams(String params) {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userId", sysUser.getId());
		queryMap.put("params", params);
		boolean flag = this.depSearchKeyService.paramsExist(queryMap);
		DepSynSearchKey depSynSearchKey = new DepSynSearchKey();
		depSynSearchKey.setParams(params);
		depSynSearchKey.setUserId(sysUser.getId());
		if (!flag) {
			if (this.depSearchKeyService.insert(depSynSearchKey) > 0) {
				return AjaxResult.success("保存筛选条件成功");
			} else
				return AjaxResult.success("保存筛选条件失败！");
		} else {
			if (this.depSearchKeyService.update(depSynSearchKey) > 0) {
				return AjaxResult.success("保存筛选条件成功");
			} else
				return AjaxResult.success("保存筛选条件失败！");
		}
	}
	
	/**
	 * 查询筛选条件
	 * 
	 * @return
	 */
	@RequestMapping(value = "/paramsList")
	@ResponseBody
	public List<DepSynSearchKey> paramsList() {
		SysUserDto sysUser = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userId", sysUser.getId());
		List<DepSynSearchKey> list = this.depSearchKeyService.selectParams(queryMap);
		return list;
	}
	
	/**
	 * 获取企业严重违法信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/doGetCsPubIlldisDetailList")
	@ResponseBody
	public PageResponse<CsPubIlldisdetail> doGetCsPubIlldisDetailList(PageRequest request) throws Exception{
		List<CsPubIlldisdetail> data = csPubIlldisdetailService.selectCsPubIlldisDetailListByPriPID(request);
		return new PageResponse<CsPubIlldisdetail>(data);
	}
}