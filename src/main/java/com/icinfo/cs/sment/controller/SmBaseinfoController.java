/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sm_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
@Controller
@RequestMapping("/sment/smBaseinfo")
public class SmBaseinfoController extends CSBaseController {

	@Autowired
	private ISmBaseinfoService smBaseinfoService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;

	@Autowired
	IErEscAppinfoService erEscAppinfoService;

	@Autowired
	IPubOpaDetailService pubOpaDetailService;

	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;
	
	@Autowired
	IYrRegCheckService yrRegCheckService;
	
	@Autowired
	IBaseInfoService baseInfoService;
	

	/**
	 * 描述：小微企业查询详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年5月4日
	 * @param priPID
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doSmEntSearchDetail/{priPID}")
	public ModelAndView doEnAppSearchDetails(@PathVariable(value = "priPID") String priPID, HttpSession session)
			throws Exception {
		priPID = AESEUtil.decodeCorpid(priPID);
		ModelAndView mav = new ModelAndView("sment/smentsearch/smentsearch_detail");
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("priPID", priPID);
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		mav.addObject("dto", midBaseInfoDto);
		mav.addObject("encryPriPID", AESEUtil.encodeCorpid(priPID));
		mav.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfoDto.getEntTypeCatg(), priPID));
		mav.addObject("isEscApp", erEscAppinfoService.getErEscAppinfoByPriPID(priPID));
		return mav;
	}

	/**
	 * 描述：检查企业是否是异常名录和严重违法
	 * 
	 * @author Administrator
	 * @date 2017年5月4日
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

	/**
	 * 描述：年报信息详情页
	 * 
	 * @author baifangfang
	 * @date 2017年5月11日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("smyr")
	public ModelAndView smyr(@RequestParam String encryPriPID, @RequestParam String year, @RequestParam String currency)
			throws Exception {
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		// 查询年报主表
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.parseInt(year));
		if (yrRegCheck == null) {
			yrRegCheck = new YrRegCheck();
		}
		ModelAndView mav = new ModelAndView("sment/smentsearch/smentsearchyr_detail");
		mav.addObject("yrRegCheck", yrRegCheck);

		BaseInfo baseInfo = baseInfoService.selectInfoByPripidAndYear(priPID, Integer.parseInt(year));
		mav.addObject("baseInfo", baseInfo);
		// 年份及priPID加密用于打印
		mav.addObject("encodeYear", AESEUtil.encodeYear(year));
		mav.addObject("encodePriPID", AESEUtil.encodeCorpid(priPID));
		mav.addObject("currency", currency);// 币种类型

		return mav;
	}
	
	
	

}