/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.controller.reg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.registmanage.dto.InvManagerCount;
import com.icinfo.cs.registmanage.dto.InvManagerDto;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.IInvManagerService;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_inv_manager 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
@Controller
@RequestMapping({ "/reg/server/invmanager/", "/syn/server/invmanager/" })
public class InvManagerController extends CSBaseController {
	@Autowired
	IInvManagerService invManagerService;
	@Autowired
	IEntSearchService entSearchService;
	@Autowired
	IMidBaseInfoService midBaseInfoService;
	@Autowired
	IQualificationLimitService qualificationLimitService;
	@Autowired
	IPubEppasswordService pubEppasswordService;
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	@Autowired
	IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	IPubScentResultService pubScentResultService;
	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;

	/**
	 * 
	 * 描述：进入公示出资到期管理页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月22日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("invexpire")
	public ModelAndView invExpire() throws Exception {
		ModelAndView modelAndView = new ModelAndView("/reg/server/registmanage/inv/invexpire_list");
		return modelAndView;
	}

	/**
	 * 
	 * 描述：公示出资到期管理json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月22日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("invexpirejson")
	@ResponseBody
	public PageResponse<InvManagerDto> invExpireJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<InvManagerDto> data = invManagerService.selectLicenceInvalidMgrJSON(request);
		return new PageResponse<InvManagerDto>(data);
	}

	/**
	 * 
	 * 描述: 公示出资到期管理数据统计
	 * 
	 * @auther baifangfang
	 * @date 2017年11月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "invexpirecount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult invExpireCount(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "B.localAdm", "B.localAdm");
		List<Integer> countList = new ArrayList<Integer>();
		InvManagerCount invManagerCount = invManagerService.queryInvManagerCount(request);
		if (invManagerCount != null) {
			countList.add(invManagerCount.getEntNum());
			countList.add(invManagerCount.getZeroInvNum());
			countList.add(invManagerCount.getPartInvNum());
			countList.add(invManagerCount.getAllInvNum());
			countList.add(invManagerCount.getPartInvExpireNum());
			countList.add(invManagerCount.getAlreadyExpireNum());
		} else {
			countList.add(0);
			countList.add(0);
			countList.add(0);
			countList.add(0);
			countList.add(0);
			countList.add(0);
		}
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 描述：公示出资到期管理详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月20日
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("invexpiredetail")
	public ModelAndView invExpireDetail(@RequestParam String priPID) throws Exception {
		ModelAndView mav = new ModelAndView("/reg/server/registmanage/inv/invexpire_detail");
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
	 * 描述: 在册企业行政处罚数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="yrinfo")
	@ResponseBody
	public AjaxResult totalJSON(@RequestParam String priPID) throws Exception {
		InvManagerCount invManagerCount = invManagerService.selectYrinfo(priPID);
		return AjaxResult.success("统计数成功", invManagerCount);
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