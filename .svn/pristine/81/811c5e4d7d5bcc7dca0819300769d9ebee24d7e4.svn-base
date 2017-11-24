/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.controller.reg.server;

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
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.cs.opanomaly.service.IPubPbOpadetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_pbopadetail 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Controller
@RequestMapping({ "/reg/server/opanomaly/pbopadetail", "/syn/server/opanomaly/pbopadetail" })
public class PubPbOpadetailController extends CSBaseController {
	@Autowired
	ICodeRegorgService codeRegorgService;

	@Autowired
	IPubPbOpadetailService pubPbOpadetailService;

	@Autowired
	IPubPbopanomalyService pubPbopanomalyService;

	@Autowired
	IMidBaseInfoService midBaseInfoService;

	@Autowired
	IPanoramaSearchService panoramaSearchService;

	@Autowired
	IEntSearchService entSearchService;
	
	@Autowired
	IEsManageService esManageService;
	
	@Autowired
	IRegIndexService regIndexService;

	/**
	 * 描述：个体户恢复正常记载申请列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月27日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyRecoveryApp")
	public ModelAndView pbopanomalyRecovery(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyrecoveryapp_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述：个体户恢复异常申请JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年7月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyRecoveryApp.json")
	@ResponseBody
	public PageResponse<PubPbOpadetailDto> pbopanomalyAppListJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request,"B.checkDep","B.localAdm");
		List<PubPbOpadetailDto> pubPbOpadetailDtoList = pubPbOpadetailService.queryPubPbOpadetailDtoList(request);
		return new PageResponse<PubPbOpadetailDto>(pubPbOpadetailDtoList);
	}

	/**
	 * 描述：新增恢复异常记载列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年7月5日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addPbopanomalyRecoveryList")
	public ModelAndView addPbopanomalyRecoveryList(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyrecoveryadd_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述：新增恢复异常记载JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年7月5日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addPbopanomalyRecoveryList.json")
	@ResponseBody
	public PageResponse<PubPbopanomalyDto> addPbopanomalyRecoveryListJSON(PageRequest request) throws Exception {
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.queryPbopanomalyRecoveryList(request);
		return new PageResponse<PubPbopanomalyDto>(pubPbopanomalyDtoList);
	}

	/**
	 * 描述：新增恢复异常记载页面
	 * 
	 * @author baifangfang
	 * @date 2017年7月5日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("recoveryPbOpadetail")
	public ModelAndView recoveryPbOpadetail(@RequestParam String busExcList, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyrecovery_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("sysuser", sysUser);
		String regOrg = selectRegorgByDeptCode(sysUser);
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		// 基本信息
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubPbopanomalyDto.getPriPID());
		mav.addObject("midBaseInfo", midBaseInfo);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述: 保存恢复异常记载
	 * 
	 * @author baifangfang
	 * @date 2017年7月5日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "savePbOpadetail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult savePbOpadetail(PubPbOpadetail pubPbOpadetail, HttpSession session) throws Exception {
		pubPbOpadetail.setCreateTime(new Date());
		pubPbOpadetail.setIsRecovery("0");
		pubPbOpadetail.setAuditState("0");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		pubPbOpadetail.setResetName(sysUser.getRealName());
		if (pubPbOpadetailService.savePbOpadetail(pubPbOpadetail) > 0) {
			try {
				//操作成功后  缓存重新设置（异常移出新增成功，+1）
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
	 * 描述：修改恢复正常记载记录页面
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("editPbOpadetail")
	public ModelAndView editPbOpadetail(@RequestParam String busExcList, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopadetail_edit");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService.selectPubPbOpadetailDtoByBusExcList(busExcList);
		mav.addObject("pubPbOpadetailDto", pubPbOpadetailDto);
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
	 * 描述: 保存修改恢复正常记载记录
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveEditPbOpadetail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveEditPbOpadetail(PubPbOpadetail pubPbOpadetail) throws Exception {
		if (pubPbOpadetailService.saveEditPbOpadetail(pubPbOpadetail) > 0) {
			return AjaxResult.success("修改成功");
		} else {
			return AjaxResult.error("修改失败");
		}
	}

	/**
	 * 描述：删除恢复正常记载记录
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deletePbOpadetail")
	@ResponseBody
	public AjaxResult deletePbOpadetail(@RequestParam String busExcList) throws Exception {
		if (!StringUtil.isEmpty(busExcList)) {
			if (pubPbOpadetailService.deletePbOpadetailByBusExcList(busExcList) > 0) {
				try {
					//操作成功后  缓存重新设置（删除记录，-1）
					SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					String regOrg = selectRegorgByDeptCode(sysUser);
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					forBidmap.put("regOrg", regOrg);
					regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 4,1, "2",sysUser);
				} catch (Exception e) {
					return AjaxResult.success("新增成功");
				}
				return AjaxResult.success("删除成功!");
			}
		}
		return AjaxResult.error("删除失败");
	}

	/**
	 * 描述：打印恢复审批表
	 * 
	 * @author baifangfang
	 * @date 2017年7月12日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyRecoveryTablePrint")
	public ModelAndView pbopanomalyRecoveryTablePrint(HttpSession session, @RequestParam String busExcList)
			throws Exception {
		ModelAndView mav = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyrecoverytable_print");
		PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService.selectPubPbOpadetailDtoByBusExcList(busExcList);
		mav.addObject("pubPbOpadetailDto", pubPbOpadetailDto);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("deptName", sysUser.getDepartMent().getDeptName());
		return mav;
	}

	/**
	 * 描述：个体户恢复正常记载审核列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年6月27日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pbopanomalyRecoveryCheck")
	public ModelAndView pbopanomalyRecoveryCheck(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView(
				"reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopanomalyrecoverycheck_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		mav.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return mav;
	}

	/**
	 * 描述：个体户恢复正常记载审核页面
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("checkOpadetail")
	public ModelAndView checkOpadetail(HttpSession session, String busExcList) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopadetail_check");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService.selectPubPbOpadetailDtoByBusExcList(busExcList);
		mav.addObject("pubPbOpadetailDto", pubPbOpadetailDto);
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
	 * 描述：个体户恢复正常记载审核
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param pubPbopanomalyDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "doCheckOpadetail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCheckOpadetail(PubPbOpadetailDto pubPbOpadetailDto) throws Exception {
		//当前库中移出信息
		PubPbOpadetailDto ppod = pubPbOpadetailService
				.selectPubPbOpadetailDtoByBusExcList(pubPbOpadetailDto.getBusExcList());
		String auditState = ppod.getAuditState();
		ppod.setAuditDate(pubPbOpadetailDto.getAuditDate());
		ppod.setAuditDept(pubPbOpadetailDto.getAuditDept());
		ppod.setAuditName(pubPbOpadetailDto.getAuditName());
		ppod.setAuditOpin(pubPbOpadetailDto.getAuditOpin());
		ppod.setAuditState(pubPbOpadetailDto.getAuditState());
		ppod.setCreateTime(new Date());

		// 查询该企业是否还有其他的异常信息
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(ppod.getPriPID());
		Map<String, Object> searchmaps = new HashMap<>();
		searchmaps.put("regNO", midBaseInfo.getRegNO());
		List<PubPbopanomalyDto> pubPbopanomalyDtoList = pubPbopanomalyService.selectPubPbopanomalys(searchmaps);
		for (int i = 0; i < pubPbopanomalyDtoList.size(); i++) {
			if (pubPbopanomalyDtoList.get(i).getBusExcList().equals(ppod.getBusExcList())) {
				pubPbopanomalyDtoList.remove(i);
			}
		}

		if (pubPbOpadetailService.savePubPbOpadetailCheck(ppod) > 0) {
			//更新全景索引
			esManageService.updateOnePanoramaIdx(ppod.getPriPID());
			
			if (pubPbopanomalyDtoList == null || pubPbopanomalyDtoList.size() == 0) {
				if ("1".equals(pubPbOpadetailDto.getAuditState()) || "3".equals(pubPbOpadetailDto.getAuditState())) {// 审核成功，更新索引
					Map<String, Object> indexserverMap = new HashMap<String, Object>();
					indexserverMap.put("priPID", ppod.getPriPID());
					try {
						indexserverMap.put("isOpanomaly", "0");
						entSearchService.updatePubIndex(indexserverMap);
					} catch (Exception e) {
						return AjaxResult.success("恢复成功");
					}
				}
			}
			
			if("0".equals(auditState)){// 待审核状态下 说明是首次审核
				try {
					//操作成功后  缓存重新设置（首次审核成功，-1）
					SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					String regOrg = selectRegorgByDeptCode(sysUser);
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					forBidmap.put("regOrg", regOrg);
					regIndexService.doRedisRegcountAll(sysUser.getId(), forBidmap, 4, 1,"2",sysUser);
				} catch (Exception e) {
					return AjaxResult.success("审核成功");
				}
			}
			return AjaxResult.success("审核成功");
		} else {
			return AjaxResult.error("审核失败");
		}
	}

	/**
	 * 描述：个体户恢复正常记载详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("opadetail")
	public ModelAndView opadetail(HttpSession session, String busExcList) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/opanomaly/pbopanomaly/pbopanomalysearch/pbopadetail_detail");
		PubPbopanomalyDto pubPbopanomalyDto = pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(busExcList);
		mav.addObject("pubPbopanomalyDto", pubPbopanomalyDto);
		PubPbOpadetailDto pubPbOpadetailDto = pubPbOpadetailService.selectPubPbOpadetailDtoByBusExcList(busExcList);
		mav.addObject("pubPbOpadetailDto", pubPbOpadetailDto);
		// 基本信息
		MidBaseInfo midBaseInfo = midBaseInfoService.selectInfoByPriPID(pubPbopanomalyDto.getPriPID());
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
	 * 
	 * 描述:查询警示系统登录用户对应的登记机关编码
	 * 
	 * @auther gaojinling
	 * @date 2017年7月3日
	 * @param sysUser
	 * @return
	 */
	public String selectRegorgByDeptCode(SysUserDto sysUser) {
		String regOrg = sysUser.getDepartMent().getDeptCode().length() > 5
				? sysUser.getDepartMent().getDeptCode().substring(0, 6) : "0000";
		if ("330010".equals(regOrg)) {
			regOrg = "330000";
		}
		return regOrg;
	}

}