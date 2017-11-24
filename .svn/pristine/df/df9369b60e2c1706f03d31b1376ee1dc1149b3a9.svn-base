/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
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
import com.icinfo.cs.rpt.rptdto.YrRptDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.dto.IndividQueMainDto;
import com.icinfo.cs.yr.dto.IndividQuestionnaireDto;
import com.icinfo.cs.yr.model.IndividQueMain;
import com.icinfo.cs.yr.model.IndividQuestionnaire;
import com.icinfo.cs.yr.service.IIndividQueMainService;
import com.icinfo.cs.yr.service.IIndividQuestionnaireService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_individ_questionnaire 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
@Controller("ServerQuestionnaire")
@RequestMapping("/reg/server/yr/individquestionnaire")
public class IndividQuestionnaireController extends BaseController {

	@Autowired
	private IIndividQuestionnaireService individQuestionnaireService;

	@Autowired
	private IIndividQueMainService individQueMainService;

	@Autowired
	ICodeRegorgService codeRegorgService;

	/**
	 * 
	 * 描述: 进入个转企调查表统计页面
	 * 
	 * @auther baifangfang
	 * @date 2017年4月25日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("individCount")
	public ModelAndView individCount(@RequestParam Map<String, Object> params) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/yr/questionnaire/questionnaire_count");
		mav.addObject("yearList", DateUtil.getYearToNow());
		if (params == null) {
			params = new HashMap<String, Object>();
			params.put("queFlag", "1");
		} else {
			params.put("queFlag", "1");
		}
		// 转企前
		IndividQuestionnaireDto individQuestionnaireDtoBefore = individQuestionnaireService
				.qryQuestionnaireCount(params);

		params.put("queFlag", "2");
		mav.addObject("individQuestionnaireDtoBefore", individQuestionnaireDtoBefore);
		// 转企后
		IndividQuestionnaireDto individQuestionnaireDtoAfter = individQuestionnaireService
				.qryQuestionnaireCount(params);
		mav.addObject("individQuestionnaireDtoAfter", individQuestionnaireDtoAfter);

		// 做大做强信心，优惠政策兑现情况
		IndividQueMainDto individQueMainDto = individQueMainService.qryQueMainCount(params);
		mav.addObject("individQueMainDto", individQueMainDto);
		mav.addObject("yearOption", params.get("year"));
		mav.addObject("setDateStart", params.get("setDateStart"));
		mav.addObject("setDateEnd", params.get("setDateEnd"));
		if (params.get("regOrg") != null && !"".equals(params.get("regOrg"))) {
			String regOrgs = params.get("regOrg").toString();
			List<CodeRegorg> codeRegorgList = codeRegorgService.selectRegOrgByCodes(regOrgs);
			String regOrgNames = "";
			for (CodeRegorg codeRegOrg : codeRegorgList) {
				regOrgNames = regOrgNames + "," + codeRegOrg.getContent();
			}
			mav.addObject("regOrgNames", regOrgNames.substring(1, regOrgNames.length()));
			mav.addObject("regOrgs", regOrgs);
		}
		return mav;
	}

	/**
	 * 
	 * 描述: 按调查量进行统计
	 * 
	 * @auther baifangfang
	 * @date 2017年4月26日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("surQuantity.json")
	@ResponseBody
	public PageResponse<IndividQueMainDto> surQuantity(PageRequest request) throws Exception {
		List<IndividQueMainDto> data = individQueMainService.selectSurQuantity(request);
		return new PageResponse<IndividQueMainDto>(data);
	}

	/**
	 * 
	 * 描述: 进入个转企调查表修正页面
	 * 
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("reg/server/yr/questionnaire/questionnaire_list");
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}

	/**
	 * 描述：获取个转企调查表列表数据
	 * 
	 * @author yujingwei
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<IndividQueMain> listJSON(PageRequest request) throws Exception {
		List<IndividQueMain> data = individQueMainService.queryPage(request);
		return new PageResponse<IndividQueMain>(data);
	}

	/**
	 * 
	 * 描述: 进入个转企调查表修正详细页面
	 * 
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView view(String pripid, Integer year) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/yr/questionnaire/questionnaire_edit");
		List<IndividQueMain> individQueMainList = individQueMainService.selectIndividQueMainList(pripid, year);
		List<IndividQuestionnaire> questionnaireList = individQuestionnaireService.selectQuestionnaireList(pripid, year,
				null);
		// 须根据当前用户判断查询机关
		view.addObject("individQueMainList", individQueMainList);
		view.addObject("questionnaireList", individQuestionnaireService.wrapQuestionnaireList(questionnaireList));
		return view;
	}

	/**
	 * 个转企调查表修正
	 * 
	 * @author yujingwei
	 * @param IndividQuestionnaireDto
	 * @param individQueMainDto
	 * @date 2016-9-26
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult commit(IndividQuestionnaireDto IndividQuestionnaireDto, IndividQueMainDto individQueMainDto,
			HttpSession session) throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		List<IndividQuestionnaire> questionnaireList = IndividQuestionnaireDto.getQuestionnaireList();
		List<IndividQueMain> individQueMainList = individQueMainDto.getIndividQueMainList();
		IndividQueMain individQueMain = individQueMainList.get(0);
		if (CollectionUtils.isNotEmpty(individQueMainList) && CollectionUtils.isNotEmpty(questionnaireList)) {
			try {
				// 修正
				boolean commitFlag = individQueMainService.doEditQuestionnaireForServer(questionnaireList,
						individQueMain, sysUser);
				if (commitFlag) {
					return AjaxResult.success("修正成功！");
				}
			} catch (Exception e) {
				AjaxResult.error("修正失败！请重试");
			}
		}
		return AjaxResult.error("修正失败！请重试");
	}

}