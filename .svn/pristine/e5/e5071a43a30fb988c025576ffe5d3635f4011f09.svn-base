/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PubEntSearchDto;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.sccheck.dto.DailyInspectResultCount;
import com.icinfo.cs.sccheck.dto.DailyInspectResultDto;
import com.icinfo.cs.sccheck.model.DailyInspectItemResult;
import com.icinfo.cs.sccheck.model.DailyInspectResult;
import com.icinfo.cs.sccheck.service.IDailyInspectItemResultService;
import com.icinfo.cs.sccheck.service.IDailyInspectResultService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_daily_inspect_result 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Controller
@RequestMapping({ "/syn/dailycheck/dailyinspectresult", "/reg/dailycheck/dailyinspectresult" })
public class DailyInspectResultController extends CSBaseController {

	@Autowired
	IDailyInspectResultService dailyInspectResultService;

	@Autowired
	IDailyInspectItemResultService dailyInspectItemResultService;

	@Autowired
	IEntSearchService entSearchService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Autowired
	IPubEppasswordService pubEppasswordService;

	/**
	 * 描述：日常检查录入列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月1日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView addDailyResultList() throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresultinsert_list");
		return mav;
	}

	/**
	 * 描述：日常检查记录查询列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月6日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("querylist")
	public ModelAndView queryDailyResultList() throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresultquery_list");
		return mav;
	}

	/**
	 * 描述：日常检查记录修改列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月6日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editlist")
	public ModelAndView editDailyResultList() throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresultedit_list");
		return mav;
	}

	/**
	 * 描述：日常检查录入列表json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listjson")
	@ResponseBody
	public PageResponse<DailyInspectResultDto> addDailyInspectResultListJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<DailyInspectResultDto> dailyInspectResultDtos = dailyInspectResultService.queryDailyInspectResult(request);
		return new PageResponse<DailyInspectResultDto>(dailyInspectResultDtos);
	}

	/**
	 * 描述：日常检查记录查询列表json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("querylistjson")
	@ResponseBody
	public PageResponse<DailyInspectResultDto> queryDailyInspectResultListJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<DailyInspectResultDto> dailyInspectResultDtos = dailyInspectResultService
				.queryDailyInspectResultList(request);
		return new PageResponse<DailyInspectResultDto>(dailyInspectResultDtos);
	}

	/**
	 * 
	 * 描述: 日常检查结果统计
	 * 
	 * @auther baifangfang
	 * @date 2017年11月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "dailyInspectResultCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult dailyInspectResultCount(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<Integer> countList = new ArrayList<Integer>();
		DailyInspectResultCount dailyInspectResultCount = dailyInspectResultService
				.queryDailyInspectResultCount(request);
		if (dailyInspectResultCount != null) {
			countList.add(dailyInspectResultCount.getNotInputNum());
			countList.add(dailyInspectResultCount.getAlreadyInputNum());
			countList.add(dailyInspectResultCount.getNotOverNum());
			countList.add(dailyInspectResultCount.getAlreadyOverNum());
		} else {
			countList.add(0);
			countList.add(0);
			countList.add(0);
			countList.add(0);
		}
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 
	 * 描述: 日常检查记录查询统计
	 * 
	 * @auther baifangfang
	 * @date 2017年11月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "dailyInspectResultQueryCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult dailyInspectResultQueryCount(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<Integer> countList = new ArrayList<Integer>();
		DailyInspectResultCount dailyInspectResultCount = dailyInspectResultService
				.queryDailyInspectResultQueryCount(request);
		if (dailyInspectResultCount != null) {
			countList.add(dailyInspectResultCount.getNotInputNum());
			countList.add(dailyInspectResultCount.getAlreadyInputNum());
			countList.add(dailyInspectResultCount.getNotOverNum());
			countList.add(dailyInspectResultCount.getAlreadyOverNum());
		} else {
			countList.add(0);
			countList.add(0);
			countList.add(0);
			countList.add(0);
		}
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 描述：添加检查对象
	 * 
	 * @author baifangfang
	 * @date 2017年11月1日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addcheckobj")
	public ModelAndView addCheckObj() throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresultinsert_edit");

		return mav;
	}

	/**
	 * 描述：检查对象列表添加页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月1日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("insertcheckobj")
	public ModelAndView insertCheckObj(@RequestParam(required = false) String priPID,
			@RequestParam(required = false) String entName, @RequestParam(required = false) String checkObjType,
			@RequestParam String flag, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresult_insert");
		if ("1".equals(flag)) {
			mav.addObject("entName", entName);
			mav.addObject("checkObjType", checkObjType);
			mav.addObject("flag", 1);
		} else {
			// 选入的企业
			MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
			mav.addObject("midBaseInfoDto", midBaseInfoDto);
			mav.addObject("checkObjType", checkObjType);
			mav.addObject("entName", midBaseInfoDto.getEntName());
			mav.addObject("flag", 2);
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
			mav.addObject("pubEppassword", pubEppassword);
		}
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysUserDto", sysUserDto);
		return mav;
	}

	/**
	 * 描述：检查对象列表录入页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("entercheckobj")
	public ModelAndView enterCheckObj(@RequestParam String uid) throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresult_enter");
		// 根据uid查询检查对象
		DailyInspectResult dailyInspectResult = dailyInspectResultService.queryDailyInspectResultByUid(uid);
		// 查询处理事项
		List<DailyInspectItemResult> dailyInspectItemResultList = dailyInspectItemResultService
				.queryDailyInspectItemResultListByResultUid(uid);
		mav.addObject("dailyInspectResult", dailyInspectResult);
		mav.addObject("dailyInspectItemResultList", dailyInspectItemResultList);
		mav.addObject("maxNum", dailyInspectItemResultList.size());
		return mav;
	}

	/**
	 * 描述：日常检查记录修改列表修改页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("altercheckobj")
	public ModelAndView alterCheckObj(@RequestParam String uid, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresult_alter");
		// 根据uid查询检查对象
		DailyInspectResult dailyInspectResult = dailyInspectResultService.queryDailyInspectResultByUid(uid);
		// 查询处理事项
		List<DailyInspectItemResult> dailyInspectItemResultList = dailyInspectItemResultService
				.queryDailyInspectItemResultListByResultUid(uid);
		mav.addObject("dailyInspectResult", dailyInspectResult);
		mav.addObject("dailyInspectItemResultList", dailyInspectItemResultList);
		mav.addObject("maxNum", dailyInspectItemResultList.size());
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysUserDto", sysUserDto);
		return mav;
	}

	/**
	 * 描述：检查对象列表续录页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("supplycheckobj")
	public ModelAndView supplyCheckObj(@RequestParam String uid) throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresult_supply");
		// 根据uid查询检查对象
		DailyInspectResult dailyInspectResult = dailyInspectResultService.queryDailyInspectResultByUid(uid);
		// 查询处理事项
		List<DailyInspectItemResult> dailyInspectItemResultList = dailyInspectItemResultService
				.queryDailyInspectItemResultListByResultUid(uid);
		mav.addObject("dailyInspectResult", dailyInspectResult);
		mav.addObject("dailyInspectItemResultList", dailyInspectItemResultList);
		return mav;
	}

	/**
	 * 描述：检查对象列表详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("detailcheckobj")
	public ModelAndView detailCheckObj(@RequestParam String uid) throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyresult_detail");
		// 根据uid查询检查对象
		DailyInspectResult dailyInspectResult = dailyInspectResultService.queryDailyInspectResultByUid(uid);
		// 查询处理事项
		List<DailyInspectItemResult> dailyInspectItemResultList = dailyInspectItemResultService
				.queryDailyInspectItemResultListByResultUid(uid);
		mav.addObject("dailyInspectResult", dailyInspectResult);
		mav.addObject("dailyInspectItemResultList", dailyInspectItemResultList);
		return mav;
	}

	/**
	 * 描述：日常检查续录
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "dosupplycheckobj", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSupplyCheckobj(@RequestBody Map<String, Object> map) throws Exception {
		int i = dailyInspectResultService.supplyDailyInspectResult(map);
		if (i > 0) {
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
	}

	/**
	 * 描述：暂存或录入日常检查结果
	 * 
	 * @author baifangfang
	 * @date 2017年11月7日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "doinsertcheckobj", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doInsertCheckObj(@RequestBody Map<String, Object> map) throws Exception {
		int i = dailyInspectResultService.saveDailyInspectResult(map);
		if (i > 0) {
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败");
	}

	/**
	 * 描述：检查对象选入
	 * 
	 * @author baifangfang
	 * @date 2017年11月1日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectcheckobj")
	public ModelAndView selectCheckObj() throws Exception {
		ModelAndView mav = new ModelAndView("syn/system/sccheck/dailyresult/dailyselectcheckobj");
		return mav;
	}

	/**
	 * 描述：检查对象选入企业列表
	 * 
	 * @author baifangfang
	 * @date 2017年11月1日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectcheckobjjson")
	@ResponseBody
	public AjaxResult selectCheckObjJSON(@RequestParam(required = false) String searchKeyWord) throws Exception {
		if (!StringUtil.isEmpty(searchKeyWord)) {
			searchKeyWord = java.net.URLDecoder.decode(searchKeyWord, "UTF-8");
		}

		List<PubEntSearchDto> data = entSearchService.queryEntList(searchKeyWord);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 描述：公示综合查询
	 * 
	 * @author baifangfang
	 * @date 2017年11月1日
	 * @return
	 */
	@RequestMapping(value = "entlist", method = RequestMethod.GET)
	public ModelAndView doGetAppSearchResult(@RequestParam(required = false) String searchKeyWord) {
		if (StringUtils.isEmpty(searchKeyWord)) {
			return null;
		}
		ModelAndView mav = new ModelAndView("pub/infopublic/infosearch/entsearch_list");
		return mav;
	}

	/**
	 * 描述：录入抽查检查结果
	 * 
	 * @author baifangfang
	 * @date 2017年5月18日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "addscresult", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommit(@RequestBody Map<String, Object> map, HttpSession session) throws Exception {
		// SysUserDto sysUserDto = (SysUserDto)
		// session.getAttribute(Constants.SESSION_SYS_USER);
		return AjaxResult.error("保存失败");
	}

	/**
	 * 描述：暂存的未提交的检查对象删除
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "deletedailyinspectresult")
	@ResponseBody
	public AjaxResult deleteDailyInspectResult(@RequestParam String uid) throws Exception {
		if (dailyInspectResultService.deleteByUid(uid) > 0) {
			return AjaxResult.success("删除成功.");
		}
		return AjaxResult.error("删除失败!");
	}
}