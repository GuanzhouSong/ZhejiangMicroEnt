/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.system.service.IWorkDayService;
import com.icinfo.cs.yr.dto.YrRegCheckDto;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.PubForbidResult;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPubForbidResultService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_forbidresult 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
@Controller
@RequestMapping("/reg/server/yr/forbidresult")
public class PubForbidResultController extends CSBaseController {

	@Autowired
	private IPubForbidResultService pubForbidResultService;

	@Autowired
	private IYrRegCheckService yrRegCheckService;

	@Autowired
	private IBaseInfoService baseInfoService;

	@Autowired
	private IPbBaseinfoService pbBaseinfoService;

	@Autowired
	private ISfcBaseInfoService sfcBaseInfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	// 简易注销
	@Autowired
	private IErEscAppinfoService erEscAppinfoService;
	@Autowired
	private IPubEppasswordService PubEppasswordService;
	// token管理
	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private IRegIndexService regIndexService;
	// 短信管理
	@Autowired
	private ISmsService smsService;

	@Autowired
	private IWorkDayService workDayService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	private IExpSeriousCrimeListService expSeriousCrimeListService;

	/**
	 * 
	 * 描述: 进入敏感词过滤审核列表页面
	 * 
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("reg/server/yr/pubforbidresult/forbidresult_list");
		view.addObject("yearList", DateUtil.getYearToNowForReport());
		view.addObject("currentYC", Integer.parseInt(DateUtil.getCurrentYear()));
		view.addObject("current", DateUtil.formatDate(new Date(), "yyyy-MM-dd"));
		return view;
	}

	/**
	 * 描述：获取列表Json数据
	 * 
	 * @author yujingwei
	 * @param request
	 * @return PageResponse<YrRegCheck>(data)
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<YrRegCheckDto> listJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "CheckDep", "LocalAdm");
		List<YrRegCheckDto> data = yrRegCheckService.queryPageForForbidResult(request);
		for (YrRegCheckDto yrRegCheckDto : data) {
			if (yrRegCheckDto.getLastReportTime() != null) {
				yrRegCheckDto.setRedDate(DateUtil.dateToString(
						workDayService.getNWorkDaylaterWorkDay(
								DateUtil.dateToString(yrRegCheckDto.getLastReportTime(), "yyyy-MM-dd"), 5),
						"yyyy-MM-dd"));
				yrRegCheckDto.setYellowDate(DateUtil.dateToString(
						workDayService.getNWorkDaylaterWorkDay(
								DateUtil.dateToString(yrRegCheckDto.getLastReportTime(), "yyyy-MM-dd"), 4),
						"yyyy-MM-dd"));
			} else {
				yrRegCheckDto.setRedDate("2000-01-01");
				yrRegCheckDto.setYellowDate("2000-01-01");
			}
		}
		return new PageResponse<YrRegCheckDto>(data);
	}

	/**
	 * 描述：查询敏感词信息
	 * 
	 * @author yujingwei
	 * @param request
	 * @return new PageResponse<PubForbidResult>(data)
	 * @throws Exception
	 */
	@RequestMapping("/forbidlist.json")
	@ResponseBody
	public PageResponse<PubForbidResult> forbidlistJSON(PageRequest request) throws Exception {
		List<PubForbidResult> data = pubForbidResultService.queryPage(request);
		return new PageResponse<PubForbidResult>(data);
	}

	/**
	 * 描述：进入敏感词过滤审核详细页面
	 * 
	 * @author yujingwei
	 * @param priPID,year,entTypeCatg
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value = "/view")
	public ModelAndView doViewDetails(String priPID, Integer year, String entTypeCatg) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/yr/pubforbidresult/forbidresult_edit");
		if (year != null && StringUtils.isNotEmpty(entTypeCatg) && StringUtils.isNotEmpty(priPID)) {
			// 查询核准信息
			MidBaseInfoDto midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
			view.addObject("midBaseInfo", midBaseInfo);

			// 查询主表信息
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, year);
			view.addObject("yrRegCheck", yrRegCheck);

			// 查询该企业简易注销信息
			ErEscAppinfo erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID);
			if (erEscAppinfo != null) {
				view.addObject("erEscAppinfo", erEscAppinfo);
			}

			// 查询联络员信息
			PubEppassword pubEppassword = PubEppasswordService.selectPubEppasswordByPriPid(priPID);
			view.addObject("pubEppassword", pubEppassword);
			String auditOpinion;

			// 是否列入异常
			view.addObject("isOpanomaly", checkIsOpanomaly(entTypeCatg, priPID));

			// 1.个体户基本信息
			if (entTypeCatg.equals(Constants.entTypeCatgPB)) {
				PbBaseinfo pbBaseInfo = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(priPID, year.toString());
				view.addObject("pbBaseInfo", pbBaseInfo);
				auditOpinion = pbBaseInfo.getAuditOpinion();
				// 2.农专基本信息
			} else if (Constants.entTypeCatgSFC.indexOf(entTypeCatg) != -1) {
				SfcBaseInfo sfcBaseInfo = sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(priPID, year);
				view.addObject("sfcBaseInfo", sfcBaseInfo);
				auditOpinion = sfcBaseInfo.getAuditOpinion();
			} else {
				// 3.企业基本信息
				BaseInfo BaseInfo = baseInfoService.selectInfoByPripidAndYear(priPID, year);
				view.addObject("BaseInfo", BaseInfo);
				auditOpinion = BaseInfo.getAuditOpinion();
			}

			// 加密年份和主体代码
			String enYear = AESEUtil.encodeYear(year.toString());
			String enPriPid = AESEUtil.encodeCorpid(priPID);
			// 获取当前日期
			view.addObject("curDate", DateUtil.getCurrentDate());
			view.addObject("enYear", enYear);
			view.addObject("enPriPid", enPriPid);
			view.addObject("auditOpinion", auditOpinion);
		}
		return view;
	}

	/**
	 * 描述：敏感词审核
	 * 
	 * @author yujingwei
	 * @param yrRegCheck
	 * @param auditState
	 * @param auditOpinion
	 * @param session
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommitForbidCheck(YrRegCheck yrRegCheck, String auditState, String auditOpinion,
			HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		try {
			boolean commitFlag = pubForbidResultService.doCommitForbidCheck(yrRegCheck, sysUser, auditState,
					auditOpinion);
			if (commitFlag) {
				// 敏感词审核成功，对当前用户对应的统计缓存数据重新设置
				// 统计map
				Map<String, Object> forBidmap = new HashMap<String, Object>();
				// 操作权限添加
				creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
				// 1.得到当前统计条数 （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
				List<Integer> temList = tokenManager.getRegCountList(sysUser.getId());
				List<Integer> countTepList = new ArrayList<Integer>();
				if (temList != null && temList.size() > 0) { // 缓存存在
					countTepList.add(temList.get(0) - 1); // 敏感词审核
					countTepList.add(temList.get(1)); // 修改申请审核
					countTepList.add(temList.get(2)); // 企业异常待审核（包括列入待审核+移出待审核+撤销待审核）
					countTepList.add(temList.get(3)); // 农专异常待审核（包括列入待审核+移出待审核+撤销待审核）
				} else { // 缓存不存在,数据库取值，重新设置缓存
					countTepList = regIndexService.getCount(forBidmap,sysUser);
				}
				// 2 重新设置缓存
				tokenManager.setRegCountToken(sysUser.getId(), countTepList);
				return AjaxResult.success("保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("保存失败！");
		}
		return AjaxResult.error("保存失败！");
	}

	/**
	 * 
	 * 描述: 发送短信
	 * 
	 * @auther gaojinling
	 * @date 2016年9月19日
	 * @param msg
	 * @param tel
	 * @param district
	 *            地区（传企业登记机关，为空时直接调用省局）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendMsg")
	@ResponseBody
	public AjaxResult doSend(String msg, String tel, String district) throws Exception {
		try {
			smsService.doSendMsg(tel, msg,district);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("短信发送失败请重试！");
		}
		return AjaxResult.success("短信发送成功！");
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

}