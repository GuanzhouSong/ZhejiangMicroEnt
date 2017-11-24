/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.controller.reg;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.model.PanoramaSearch;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.dto.MidLeRepDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.ext.service.IMidMemberService;
import com.icinfo.cs.registmanage.dto.LimitManageRecordDto;
import com.icinfo.cs.registmanage.dto.QualificationLimitDto;
import com.icinfo.cs.registmanage.model.LimitManageRecord;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.registmanage.service.ILimitManageRecordService;
import com.icinfo.cs.registmanage.service.IQualificationLimitService;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_qualification_limit 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
@Controller
@RequestMapping("/reg/server/registmanage/")
public class QualificationLimitController extends CSBaseController {

	@Autowired
	private IQualificationLimitService qualificationLimitService;
	@Autowired
	private IMidLeRepService midLeRepService;

	@Autowired
	private IPanoramaSearchService panoramaSearchService;

	@Autowired
	private IMidMemberService midMemberService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Autowired
	IMidInvService midInvService;

	@Autowired
	ILimitManageRecordService limitManageRecordService;

	@Autowired
	IErEscAppinfoService erEscAppinfoService;

	/**
	 * 进入任职限制对象管理页面
	 * 
	 * @author baifangfang
	 * @date 2017-4-15
	 * @return ModelAndView
	 */
	@RequestMapping("limitobj")
	public ModelAndView limitObj() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/registmanage/qualifiedmanage/limitobj");
		modelAndView.addObject("sysdate", DateUtil.getCurrentDate());
		return modelAndView;
	}

	/**
	 * 打印清算通知书页面
	 * 
	 * @author baifangfang
	 * @date 2017-4-15
	 * @return ModelAndView
	 */
	@RequestMapping("printLiq")
	public ModelAndView printLiq(@RequestParam String uid, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/registmanage/qualifiedmanage/printliq");
		QualificationLimit qualificationLimit = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		mav.addObject("qualificationLimit", qualificationLimit);
		List<MidBaseInfoDto> midBaseInfoDtos = midBaseInfoService.doGetListByPriPID(qualificationLimit.getPriPID());
		String regOrg = null;
		if (midBaseInfoDtos != null && midBaseInfoDtos.size() > 0) {
			mav.addObject("midBaseInfoDto", midBaseInfoDtos.get(0));
			regOrg = midBaseInfoDtos.get(0).getRegOrg();
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

		// 查询当前打印下的最大文号
		String limitNo = getLimitNo(uid, regOrg, "打印清算通知书", "1-");
		mav.addObject("limitNo", limitNo);
		mav.addObject("sysUser", sysUser);
		return mav;
	}

	/**
	 * 描述: 打印清算通知书
	 * 
	 * @auther baifangfang
	 * @date 2017年4月18日
	 * @param operate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doPrintLiq")
	@ResponseBody
	public AjaxResult doPrintLiq(LimitManageRecord limitManageRecord) throws Exception {
		limitManageRecord.setItem("打印清算通知书");
		int i = limitManageRecordService.save(limitManageRecord);
		if (i > 0) {
			String removeUid = limitManageRecord.getRemoveUid();
			return AjaxResult.success("打印清算通知书保存成功", removeUid);
		}
		return AjaxResult.error("打印清算通知书保存失败");
	}

	/**
	 * 
	 * 描述: 打印清算通知书预览页面
	 * 
	 * @auther baifangfang
	 * @date 2017年4月18日
	 * @param session
	 * @param uid
	 * @param removeUid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("printLiqView")
	public ModelAndView printLiqView(HttpSession session, String uid, String removeUid) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/printliq_view");
		QualificationLimit qualificationLimit = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		LimitManageRecord limitManageRecord = limitManageRecordService.selectByUid(uid, removeUid);
		view.addObject("qualificationLimit", qualificationLimit);
		view.addObject("limitManageRecord", limitManageRecord);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

		view.addObject("sysUser", sysUser);
		view.addObject("sysdate", DateUtil.getCurrentDate());
		List<MidBaseInfoDto> midBaseInfoDtos = midBaseInfoService.doGetListByPriPID(qualificationLimit.getPriPID());
		if (midBaseInfoDtos != null && midBaseInfoDtos.size() > 0) {
			view.addObject("midBaseInfoDto", midBaseInfoDtos.get(0));
		}
		return view;
	}

	/**
	 * 打印解除证明页面
	 * 
	 * @author baifangfang
	 * @date 2017-4-15
	 * @return ModelAndView
	 */
	@RequestMapping("printCan")
	public ModelAndView printCan(@RequestParam String uid, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/registmanage/qualifiedmanage/printcan");
		QualificationLimit qualificationLimit = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		mav.addObject("qualificationLimit", qualificationLimit);
		List<MidBaseInfoDto> midBaseInfoDtos = midBaseInfoService.doGetListByPriPID(qualificationLimit.getPriPID());
		String regOrg = null;
		if (midBaseInfoDtos != null && midBaseInfoDtos.size() > 0) {
			mav.addObject("midBaseInfoDto", midBaseInfoDtos.get(0));
			regOrg = midBaseInfoDtos.get(0).getRegOrg();
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

		// 查询当前打印下的最大文号
		String limitNo = getLimitNo(uid, regOrg, "打印解除证明", "2-");
		mav.addObject("limitNo", limitNo);
		mav.addObject("sysUser", sysUser);
		return mav;
	}

	/**
	 * 描述: 打印解除证明
	 * 
	 * @auther baifangfang
	 * @date 2017年4月18日
	 * @param operate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doPrintCan")
	@ResponseBody
	public AjaxResult doPrintCan(LimitManageRecord limitManageRecord) throws Exception {
		limitManageRecord.setItem("打印解除证明");
		int i = limitManageRecordService.save(limitManageRecord);
		if (i > 0) {
			String removeUid = limitManageRecord.getRemoveUid();
			return AjaxResult.success("打印解除证明保存成功", removeUid);
		}
		return AjaxResult.error("打印解除证明保存失败");
	}

	/**
	 * 
	 * 描述: 打印解除证明预览页面
	 * 
	 * @auther baifangfang
	 * @date 2017年4月18日
	 * @param session
	 * @param uid
	 * @param removeUid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("printCanView")
	public ModelAndView printCanView(HttpSession session, String uid, String removeUid) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/printcan_view");
		QualificationLimit qualificationLimit = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		LimitManageRecord limitManageRecord = limitManageRecordService.selectByUid(uid, removeUid);
		view.addObject("qualificationLimit", qualificationLimit);
		view.addObject("limitManageRecord", limitManageRecord);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

		view.addObject("sysUser", sysUser);
		return view;
	}

	/**
	 * 描述：获取文号
	 * 
	 * @param uid
	 * @param regOrg
	 * @return
	 * @throws Exception
	 */
	private String getLimitNo(String uid, String regOrg, String item, String prefix) throws Exception {
		Integer maxNo = limitManageRecordService.selectLimitNo(uid, item);

		if (maxNo == null) {
			maxNo = new Integer(1);
		}
		String no = String.format("%0" + 3 + "d", maxNo);

		String limitNo = prefix;
		if (!StringUtil.isEmpty(regOrg)) {
			limitNo = limitNo + regOrg + "-" + no;
		} else {
			limitNo = limitNo + 000000 + "-" + no;
		}
		return limitNo;
	}

	/**
	 * 描述：获取任职限制对象列表(按任职限制对象查询)
	 * 
	 * @author baifangfang
	 * @date 2017-04-06
	 * @return
	 */
	@RequestMapping("limitObjList")
	@ResponseBody
	public PageResponse<QualificationLimitDto> limitObjList(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "n.RegOrg", "n.LocalAdm");
		List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService.selectLimitObjList(request);
		return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
	}

	/**
	 * 描述：获取任职限制对象列表(按任职限制对象查询详情)
	 * 
	 * @author baifangfang
	 * @date 2017-04-06
	 * @return
	 */
	@RequestMapping("limitObjDetailList")
	@ResponseBody
	public PageResponse<QualificationLimitDto> limitObjDetailList(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "n.RegOrg", "n.LocalAdm");
		List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService
				.selectLimitObjDetailList(request);
		return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
	}

	/**
	 * 
	 * 描述: 获取任职限制对象列表(按任职限制对象查询)统计
	 * 
	 * @auther baifangfang
	 * @date 2017年4月17日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "limitObjCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult limitObjCount(PageRequest request) throws Exception {
		List<Integer> countList = new ArrayList<Integer>();
		int limitObjCount = qualificationLimitService.qryLimitObjCount(request.getParams());
		int relEntCount = qualificationLimitService.qryRelEntCount(request.getParams());
		countList.add(limitObjCount);
		countList.add(relEntCount);
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 
	 * 描述: 获取任职限制对象列表(按关联企业)统计
	 * 
	 * @auther baifangfang
	 * @date 2017年4月17日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "limitObjCountByEnt", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult limitObjCountByEnt(PageRequest request) throws Exception {
		List<Integer> countList = new ArrayList<Integer>();
		int limitObjCount = qualificationLimitService.qryLimitObjCountByEnt(request.getParams());
		int relEntCount = qualificationLimitService.qryRelEntCountByEnt(request.getParams());
		countList.add(limitObjCount);
		countList.add(relEntCount);
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 描述：获取受限对象关联企业列表(按受限对象查询详情)
	 * 
	 * @author baifangfang
	 * @date 2017-04-10
	 * @param request
	 * @return
	 */
	@RequestMapping("limitObjRelEnt")
	@ResponseBody
	public PageResponse<MidBaseInfoDto> limitObjRelEnt(PageRequest request) throws Exception {
		List<MidBaseInfoDto> midLeRepDtoList = midBaseInfoService.qryLimitObjRelEntList(request);
		return new PageResponse<MidBaseInfoDto>(midLeRepDtoList);
	}

	/**
	 * 描述：获取本企业受限对象(按限制对象关联企业查询详情)
	 * 
	 * @author baifangfang
	 * @date 2017-04-10
	 * @param request
	 * @return
	 */
	@RequestMapping("limitRelEntObj")
	@ResponseBody
	public PageResponse<MidBaseInfoDto> limitRelEntObj(PageRequest request) throws Exception {
		List<MidBaseInfoDto> midLeRepDtoList = midBaseInfoService.qryLimitRelEntObjList(request);
		return new PageResponse<MidBaseInfoDto>(midLeRepDtoList);
	}

	/**
	 * 描述：获取受限对象管理记录列表
	 * 
	 * @author baifangfang
	 * @date 2017-04-10
	 * @param request
	 * @return
	 */
	@RequestMapping("limitObjManageRecordList")
	@ResponseBody
	public PageResponse<LimitManageRecordDto> limitObjManageRecordList(PageRequest request) throws Exception {
		List<LimitManageRecordDto> limitManageRecordDtoList = limitManageRecordService
				.qryLimitObjManageRecordList(request);
		return new PageResponse<LimitManageRecordDto>(limitManageRecordDtoList);
	}

	/**
	 * 描述：获取任职限制对象列表(按限制对象关联企业查询)
	 * 
	 * @author baifangfang
	 * @date 2017-04-06
	 * @return
	 */
	@RequestMapping("limitRelEntList")
	@ResponseBody
	public PageResponse<QualificationLimitDto> limitRelEntList(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "n.RegOrg", "n.LocalAdm");
		List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService
				.selectlimitRelEntList(request);
		return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
	}

	/**
	 * 描述：获取任职限制对象列表(按失信被执行人关联企业查询)
	 * 
	 * @author baifangfang
	 * @date 2017-08-06
	 * @return
	 */
	@RequestMapping("limiterRelEntList")
	@ResponseBody
	public PageResponse<QualificationLimit> limiterRelEntList(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "A.RegOrg", "A.LocalAdm");
		List<QualificationLimit> qualificationLimitList = qualificationLimitService.selectlimiterRelEntList(request);
		Page<QualificationLimit> qualificationLimitPage = new Page<QualificationLimit>(0,1000);
		qualificationLimitPage.addAll(qualificationLimitList);
		qualificationLimitPage.setTotal(qualificationLimitList.size());
		return new PageResponse<QualificationLimit>(qualificationLimitPage);
	}

	/**
	 * 
	 * 描述: 进入任职限制对象详情页面(按任职限制对象查询)
	 * 
	 * @auther baifangfang
	 * @date 2017年04月06日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("limitObjDetail")
	public ModelAndView limitObjDetail(@RequestParam String uid) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/registmanage/qualifiedmanage/limitobj_detail");
		QualificationLimit limitInfo = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		if (limitInfo != null) {
			// 查询高管人员数量
			int midMemCount = midMemberService.qryMidMemCountByCerNOAndName(limitInfo.getCertNO(),
					limitInfo.getClientName());
			view.addObject("midMeCount", midMemCount);
			// 查询法人数量
			int midLerepCount = midLeRepService.qryMidLeRepByCerNOAndName(limitInfo.getCertNO(),
					limitInfo.getClientName());
			int midInvCount = midInvService.qryMidInvByCerNOAndName(limitInfo.getCertNO(), limitInfo.getClientName());// 合伙企业的时候，法人取值
			view.addObject("leRepCount", midLerepCount + midInvCount);

			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("certNO", limitInfo.getCertNO());
			List<String> priPIDList = qualificationLimitService.selectRightPriPIDList(qryMap);
			String notInPidList = "";
			for (String pid : priPIDList) {
				if (StringUtils.isEmpty(notInPidList)) {
					notInPidList += pid;
				} else {
					notInPidList += "," + pid;
				}
			}
			view.addObject("notInPidList", notInPidList);

			if (StringUtils.isNotEmpty(limitInfo.getCertType()) && StringUtils.isNotEmpty(limitInfo.getCertNO())
					&& "10".equals(limitInfo.getCertType())) {
				String certNO = limitInfo.getCertNO();
				Map<String, Object> map = CardUtil.getCertNOInfo(certNO);
				String age = "";
				String birthDay = "";
				String sex = "";
				if (map != null) {
					if (map.get("age") != null) {
						age = (String) map.get("age");
					}
					if (map.get("birthDay") != null) {
						birthDay = (String) map.get("birthDay");
					}
					if (map.get("sex") != null) {
						sex = (String) map.get("sex");
					}
				}
				view.addObject("sex", sex);
				view.addObject("age", age);
				view.addObject("birthDay", birthDay);
				view.addObject("certNOS", certNO);
			}

			Date sysdate = DateUtil.getSysCurrentDate();
			if ((limitInfo.getLimitDateEnd() != null && limitInfo.getLimitDateEnd().compareTo(sysdate) == 1)
					|| limitInfo.getLimitDateEnd() == null) {
				view.addObject("limitstate", "Y");
			} else {
				view.addObject("limitstate", "N");
			}
		}
		view.addObject("sysdate", DateUtil.getCurrentDate());
		view.addObject("limitInfo", limitInfo);
		return view;
	}

	/**
	 * 
	 * 描述: 进入任职限制对象详情页面(按关联企业查询)
	 * 
	 * @auther baifangfang
	 * @date 2017年04月06日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("limitRelEntDetail")
	public ModelAndView limitRelEntDetail(@RequestParam String priPID, @RequestParam String uid) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/registmanage/qualifiedmanage/limitrelent_detail");
		QualificationLimit limitInfo = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		List<MidBaseInfoDto> midBaseInfoDtos = midBaseInfoService.doGetListByPriPID(priPID);
		ErEscAppinfo erEscAppinfo = erEscAppinfoService.doGetErEscAppinfoByPriPID(priPID);
		if (erEscAppinfo != null) {
			if ("4".equals(erEscAppinfo.getSimplecanRea())) {
				view.addObject("isSimplecan", 1);
				view.addObject("noticeFrom", erEscAppinfo.getNoticeFrom());
				view.addObject("noticeTo", erEscAppinfo.getNoticeTo());
			}
		}
		PanoramaSearch panoramaSearch = panoramaSearchService.selectOnePanorama(priPID);
		if (panoramaSearch != null) {
			view.addObject("liaName", panoramaSearch.getLiaName());
			view.addObject("liaTel", panoramaSearch.getLiaTel());
		}

		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("certNO", limitInfo.getCertNO());
		List<String> priPIDList = qualificationLimitService.selectRightPriPIDList(qryMap);
		String notInPidList = "";
		for (String pid : priPIDList) {
			if (StringUtils.isEmpty(notInPidList)) {
				notInPidList += pid;
			} else {
				notInPidList += "," + pid;
			}
		}

		Date sysdate = DateUtil.getSysCurrentDate();
		if ((limitInfo.getLimitDateEnd() != null && limitInfo.getLimitDateEnd().compareTo(sysdate) == 1)
				|| limitInfo.getLimitDateEnd() == null) {
			view.addObject("limitstate", "Y");
		} else {
			view.addObject("limitstate", "N");
		}

		view.addObject("notInPidList", notInPidList);
		view.addObject("midBaseInfoDto", midBaseInfoDtos.get(0));
		view.addObject("sysdate", DateUtil.getCurrentDate());
		view.addObject("limitInfo", limitInfo);
		return view;
	}

	/**
	 * 进入经营期限到期管理页面
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doEnInvestManage")
	public ModelAndView doEnInvestManage() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/registmanage/investmanage/investmanage");
		modelAndView.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return modelAndView;
	}

	/**
	 * 获取查询企业列表
	 *
	 * @author zhuyong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/panoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "checkDep", "localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

	/**
	 * 进入任职资格限制管理页面
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doEnQualifiedLimit")
	public ModelAndView doEnQualifiedLimit() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/registmanage/qualifiedmanage/qualifiedlimit");

		return modelAndView;
	}

	/**
	 * 进入任职资格限制解除页面
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doEnQualifiedLimitRemove")
	public ModelAndView doEnQualifiedLimitRemove() throws Exception {
		ModelAndView modelAndView = new ModelAndView("reg/server/registmanage/qualifiedmanage/qualifiedlimitremove");

		return modelAndView;
	}

	/**
	 * 进入限制管理页面
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doEnLimitManage")
	public ModelAndView doEnLimitManage(String ids, String priPIDs) throws Exception {
		ModelAndView mv = new ModelAndView("reg/server/registmanage/qualifiedmanage/limitmanage");
		mv.addObject("ids", ids);
		mv.addObject("priPIDs", priPIDs);
		return mv;
	}

	/**
	 * 获取任职资格限制管理列表
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doGetQualifiedLimitList")
	@ResponseBody
	public PageResponse<QualificationLimitDto> doGetQualifiedLimitList(PageRequest request) throws Exception {
		List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService
				.selectQualificationLimitList(request);

		return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
	}

	/**
	 * 获取限制管理列表
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doGetLimitManageList")
	@ResponseBody
	public PageResponse<MidLeRepDto> doGetLimitManageList(PageRequest request) throws Exception {
		// 默认暂时只展开法人关联查询
		List<MidLeRepDto> midLeRepDtoList = midLeRepService.selectMidLeRepList(request);

		return new PageResponse<MidLeRepDto>(midLeRepDtoList);
	}

	/**
	 * 提前解除限制
	 * 
	 * @author ylr
	 * @return ModelAndView
	 */
	@RequestMapping("doUpdateQualificationLimit")
	@ResponseBody
	public AjaxResult doUpdateQualificationLimit(QualificationLimitDto qualificationLimitDto, HttpSession session)
			throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		qualificationLimitDto.setChangeTime(new Date());
		qualificationLimitDto.setChangePerson(sysUser.getRealName());
		if (qualificationLimitService.updateByUid(qualificationLimitDto) > 0) {
			return AjaxResult.success("解除限制成功！");
		}

		return AjaxResult.error("解除限制失败！");

	}

	/**
	 * 
	 * 描述: 限制对象提前解除申请列表页
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveApplyList")
	public ModelAndView limitRemoveApplyList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremoveapply_list");
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}

	/**
	 * 
	 * 描述: 限制对象提前解除申请列表查询
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/limitRemoveApplyListJSON.json", "list.xml" })
	@ResponseBody
	public PageResponse<QualificationLimitDto> limitRemoveApplyListJSON(PageRequest request) throws Exception {
		List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService
				.selectRemoveLimitList(request);
		return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
	}

	/**
	 * 
	 * 描述: 限制对象提前解除新增申请列表页
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveAddApplyList")
	public ModelAndView limitRemoveAddApplyList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremoveaddapply_list");
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}

	/**
	 * 
	 * 描述: 限制对象提前解除列表查询
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/limitRemoveAddApplyListJSON.json", "list.xml" })
	@ResponseBody
	public PageResponse<QualificationLimitDto> limitRemoveAddApplyListJSON(PageRequest request) throws Exception {
		List<QualificationLimitDto> qualificationLimitDtoList = qualificationLimitService
				.selectRemoveLimitList(request);
		return new PageResponse<QualificationLimitDto>(qualificationLimitDtoList);
	}

	/**
	 * 
	 * 描述: 限制对象提前解除查询统计
	 * 
	 * @auther gaojinling
	 * @date 2017年4月13日
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/DataCountList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult DataCountList(PageRequest request) throws Exception {
		Map<String, Object> params = request.getParams();
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		if (params != null) {
			if (params.get("limitType") != null && StringUtils.isNotEmpty(params.get("limitType").toString())) {
				String limitType = params.get("limitType").toString();
				if (limitType.indexOf(",") > -1) {// 查询的为全部
					params.remove("limitType");
				} else {// 查询的为单个
					params.remove("removelimitflag");
				}
			}
		}
		List<Integer> countList = new ArrayList<Integer>();
		// 限制对象数量
		int clientNameCount = qualificationLimitService.selectRemoveClientNameTotal(params);
		// 限制原因企业数量
		int pripidCount = qualificationLimitService.selectRemovePripidTotal(params);
		countList.add(clientNameCount);
		countList.add(pripidCount);
		return AjaxResult.success("countList", countList);
	}

	/**
	 * 
	 * 描述: 进入提前解除限制资格申请页
	 * 
	 * @auther gaojinling
	 * @date 2017年4月7日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveAddApply")
	public ModelAndView limitRemoveAddApply(HttpSession session, String uid, String operate) throws Exception {
		ModelAndView view;
		if ("1".equals(operate)) {// 申请
			view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremoveaddapply_edit");
		} else if ("2".equals(operate)) {// 审核
			view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremoveaddaudit_edit");
		} else {
			view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremoveaddaudit_edit");
		}
		QualificationLimitDto qualificationLimit = new QualificationLimitDto();
		if (StringUtil.isNotBlank(uid)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uid", uid);
			qualificationLimit = qualificationLimitService.selectQualificationLimitDtoByUid(map);
		}
		view.addObject("qualificationLimit", qualificationLimit);
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		// 查询在册企业
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(qualificationLimit.getPriPID());
		// 若在册灭有 查询 所有状态企业
		if (midBaseInfo == null) {
			midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(qualificationLimit.getPriPID());
		}
		// 根据名称查询部门
		// DepartMent departMent =
		// departMentService.selectDepartMentByDeptCode(deptCode);
		view.addObject("midBaseInfo", midBaseInfo);
		view.addObject("sysUser", sysUser);
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}

	/**
	 * 
	 * 描述:提前解除限制资格申请提交
	 * 
	 * @auther gaojinling
	 * @date 2017年4月7日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/limitRemoveAddApplyCommit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult limitRemoveAddApplyCommit(QualificationLimit qualificationLimit, HttpSession session)
			throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		qualificationLimit.setAuditState("0");// 待审核
		qualificationLimit.setRemoveAppLyDate(new Date());
		qualificationLimit.setRemoveAppLyName(sysUser.getRealName());
		if (qualificationLimitService.update(qualificationLimit) > 0) {
			return AjaxResult.success("操作成功");
		}
		return AjaxResult.error("提前解除限制资格申请失败");
	}

	/**
	 * 
	 * 描述: 删除提前解除限制资格申请（实际为回复当前数据为未申请状态）
	 * 
	 * @auther gaojinling
	 * @date 2017年4月11日
	 * @param uid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteRemoveApply", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteRemoveApply(String uid, String priPID) throws Exception {
		// 查询当前申请数据
		QualificationLimit qualificationLimit = qualificationLimitService.selectQualificationLimitInfoByUid(uid);
		qualificationLimit.setAuditState(null);
		qualificationLimit.setRemoveAppLyDate(null);
		qualificationLimit.setRemoveAppLyName(null);
		qualificationLimit.setRemoveReason(null);
		qualificationLimit.setRemoveReasonCN(null);
		qualificationLimit.setRemoveOtherReason(null);
		qualificationLimit.setRemoveDept(null);
		qualificationLimit.setRemoveDeptName(null);
		if (qualificationLimitService.updateByNull(qualificationLimit) > 0) {
			return AjaxResult.success("操作成功");
		}
		return AjaxResult.error("操作失败");
	}

	/**
	 * 
	 * 描述: 限制对象提前解除申请审核页
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveAduitList")
	public ModelAndView limitRemoveAduitList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremoveaudit_list");
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}

	/**
	 * 
	 * 描述:提前解除限制资格审核提交
	 * 
	 * @auther gaojinling
	 * @date 2017年4月7日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/limitRemoveAuditCommit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult limitRemoveAuditCommit(QualificationLimit qualificationLimit, HttpSession session)
			throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		qualificationLimit.setRemoveAuditDate(new Date());
		qualificationLimit.setRemoveAuditName(sysUser.getRealName());
		qualificationLimit.setRemoveAuditDept(sysUser.getDepartMent().getDeptName());
		if ("1".equals(qualificationLimit.getAuditState())) { // 审核通过，提前限制解除成功
			qualificationLimit.setRemoveDate(new Date());
		}
		if (qualificationLimitService.update(qualificationLimit) > 0) {
			return AjaxResult.success("操作成功");
		}
		return AjaxResult.error("提前解除限制资格申请失败");
	}

	/**
	 * 
	 * 描述: 解除证明打印编辑页面
	 * 
	 * @auther gaojinling
	 * @date 2017年4月14日
	 * @param session
	 * @param uid
	 * @param operate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveBookEdit")
	public ModelAndView limitRemoveBookEdit(HttpSession session, String uid) throws Exception {
		ModelAndView view;
		view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremovebook_edit");
		QualificationLimitDto qualificationLimit = new QualificationLimitDto();
		if (StringUtil.isNotBlank(uid)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uid", uid);
			qualificationLimit = qualificationLimitService.selectQualificationLimitDtoByUid(map);
		}

		// 查询在册企业
		// MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
		// 若在册灭有 查询 所有状态企业
		// if(midBaseInfo == null ){
		MidBaseInfo midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(qualificationLimit.getPriPID());
		// }
		// 查询文号
		Integer maxNo = limitManageRecordService.selectLimitNo(uid);
		if (maxNo == null) {
			maxNo = new Integer(1);
		}
		// String limitType = "0".equals(qualificationLimit.getLimitType()) ?
		// "1-" : "2-";
		String maxNostring = maxNo < 100 ? "-00" : "-";
		String limitNo = "2-" + midBaseInfo.getRegOrg() + maxNostring + maxNo;
		view.addObject("qualificationLimit", qualificationLimit);
		view.addObject("limitNo", limitNo);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

		view.addObject("sysUser", sysUser);
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}

	/**
	 * 
	 * 描述: 解除证明打印编辑页面保存(管理台账打印)
	 * 
	 * @auther gaojinling
	 * @date 2017年4月14日
	 * @param session
	 * @param uid
	 * @param operate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveBookPrintCommit")
	@ResponseBody
	public AjaxResult limitRemoveBookPrintCommit(LimitManageRecord limitManageRecord) throws Exception {
		String removeUid = StringUtil.uuid();
		limitManageRecord.setRemoveUid(removeUid);// 生成当前表记录uuid
		if (limitManageRecordService.save(limitManageRecord) > 0) {
			return AjaxResult.success("解除证明保存成功", removeUid);
		}
		return AjaxResult.error("解除证明保存成功");
	}

	/**
	 * 
	 * 描述: 解除证明打印页面
	 * 
	 * @auther gaojinling
	 * @date 2017年4月14日
	 * @param session
	 * @param uid
	 * @param operate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/limitRemoveBookPrint")
	public ModelAndView limitRemoveBookPrint(HttpSession session, String uid, String removeUid) throws Exception {
		ModelAndView view;
		view = new ModelAndView("/reg/server/registmanage/qualifiedmanage/limitremovebook_print");
		QualificationLimitDto qualificationLimit = new QualificationLimitDto();
		LimitManageRecord limitManageRecord = new LimitManageRecord();
		if (StringUtil.isNotBlank(uid)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uid", uid);
			qualificationLimit = qualificationLimitService.selectQualificationLimitDtoByUid(map);
			limitManageRecord = limitManageRecordService.selectByUid(uid, removeUid);
		}
		view.addObject("qualificationLimit", qualificationLimit);
		view.addObject("limitManageRecord", limitManageRecord);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

		view.addObject("sysUser", sysUser);
		view.addObject("sysdate", DateUtil.getCurrentDate());
		return view;
	}
	
	/**
	 * 描述：任职资格受限
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param session
	 */
	@RequestMapping("limitObjNum")
	@ResponseBody
	public void limitObjNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "n.RegOrg", "n.LocalAdm");
		int count = qualificationLimitService.limitObjNum(qryMap);
		System.out.println(count+"====================");
	}

}