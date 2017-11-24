/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.cs.base.service.ICodeDzLicenseService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.dzdtinfo.dto.LicDzDeptDto;
import com.icinfo.cs.dzdtinfo.model.LicDzDept;
import com.icinfo.cs.dzdtinfo.service.ILicDzDeptService;
import com.icinfo.cs.dzdtinfo.service.IPubDzDtInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_lic_dz_dept 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller
@RequestMapping({ "/syn/licdzdept", "/reg/server/licdzdept" })
public class LicDzDeptController extends BaseController {
	/**
	 * 2017年6月15日16:45:57
	 */
	@Autowired
	private ILicDzDeptService licDeptService;
	@Autowired
	/**
	 * 2017年6月15日16:46:00
	 */
	private ICodeDzLicenseService codeLicenseService;

	@Autowired
	private ISysDepartService sysDepartService;
	/**
	 * 2017年6月15日16:46:04
	 */
	@Autowired
	private IPubDzDtInfoService pubDtInfoService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	@Autowired
	private ISysLogService sysLogService;
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;

	private final String SJCODE = "330000";
	private final String SJNAME = "省本级";

	/**
	 * 
	 * 描述 进入备案部门对照维护列表页面 @author 赵祥江 @date 2016年10月19日 下午1:35:50 @param @return
	 * ModelAndView @throws
	 */
	@RequestMapping("/licdeptListPage")
	public ModelAndView licdeptListPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		// 警示协同的地址 默认警示
		String sysUrl = "/reg/server";
		// 协同
		if ("2".equals(sysUser.getUserType())) {
			sysUrl = "/syn";
		}
		ModelAndView view = new ModelAndView("/syn/system/licdzdept/licdzdept_list");
		view.addObject("sysUrl", sysUrl);
		return view;
	}

	/**
	 * 
	 * 描述 数据和配置下放 @author 赵祥江 @date 2017年4月17日 下午2:03:30 @param @return
	 * ModelAndView @throws
	 */
	@RequestMapping("/transferExaCodePage")
	public ModelAndView transferExaCodePage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		// 警示协同的地址 默认警示
		String sysUrl = "/reg/server";
		// 协同
		if ("2".equals(sysUser.getUserType())) {
			sysUrl = "/syn";
		}
		ModelAndView view = new ModelAndView("/syn/system/licdzdept/pubdzdtinfotransfer_edit");
		view.addObject("sysUrl", sysUrl);
		return view;
	}

	/**
	 * 
	 * 描述 数据下放 @author 赵祥江 @date 2016年12月29日 下午3:57:52 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping(value = "/transferExaCode", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult transferExaCode(String exaCodeStr, String checkDep, String yFlag, String istransferFlag)
			throws Exception {
		try {
			licDeptService.transferExaCode(exaCodeStr, checkDep, yFlag, istransferFlag);
			return AjaxResult.success("操作成功", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AjaxResult.error("操作失败");
	}

	/**
	 * 
	 * 描述 分页查询备案对照维护 @author 赵祥江 @date 2016年10月19日 下午1:37:36 @param @return
	 * PageResponse<LicDeptDto> @throws
	 */
	@RequestMapping({ "/licDeptListJSON.json", "list.xml" })
	@ResponseBody
	public PageResponse<LicDzDeptDto> licDeptListJSON(PageRequest request) throws Exception {
		Map<String, Object> queryMap = request.getParams();
		// 去掉查询参数的左右空格
		pubDtInfoService.paramTrim(queryMap);
		request.setParams(queryMap);
		if (queryMap != null && queryMap.containsKey("yiedistrict")) {
			queryMap.put("yiedistrict", com.icinfo.cs.common.utils.StringUtil
					.doSplitStringToSqlFormat(queryMap.get("yiedistrict").toString(), ","));
		}
		if (queryMap != null && queryMap.containsKey("adCode")) {
			queryMap.put("adCode", com.icinfo.cs.common.utils.StringUtil
					.doSplitStringToSqlFormat(queryMap.get("adCode").toString(), ","));
		}
		if (queryMap != null && queryMap.containsKey("deptCode")) {
			queryMap.put("deptCode", com.icinfo.cs.common.utils.StringUtil
					.doSplitStringToSqlFormat(queryMap.get("deptCode").toString(), ","));
		}
		List<LicDzDeptDto> licDeptDtoList = licDeptService.queryLicDeptListJSON(request);
		return new PageResponse<LicDzDeptDto>(licDeptDtoList);
	}

	/**
	 * 
	 * 描述 自动生成备案对照表数据 @author 赵祥江 @date 2016年11月3日 下午3:39:30 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping(value = "/executeLicDeptDataByLicZone", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult executeLicDeptDataByLicZone() throws Exception {
		licDeptService.executeLicDeptDataByLicZone();
		return null;
	}

	/**
	 * 
	 * 描述 根据不同类型进入相对应的页面 @author 赵祥江 @date 2016年10月19日 下午1:50:22 @param @return
	 * ModelAndView @throws
	 */
	@RequestMapping("/licdeptEditPage")
	public ModelAndView licdeptEditPage(HttpSession session, String uid, String flag) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = null;
		CodeDzLicense codeLicense = null;
		List<LicDzDept> licDeptList = new ArrayList<LicDzDept>();
		if ("1".equals(flag)) {// 新增
			view = new ModelAndView("/syn/system/licdzdept/licdzdept_edit");
		} else if ("2".equals(flag) || "3".equals(flag)) {// 修改
			if ("2".equals(flag)) {
				view = new ModelAndView("/syn/system/licdzdept/licdzdept_edit");
			} else {
				view = new ModelAndView("/syn/system/licdzdept/licdzdept_view");
			}
			
			licDeptList = licDeptService.selectLicDeptByUid(uid);
			
			
			String exaCode = licDeptList.get(0).getExaCode();
			if (licDeptList != null && licDeptList.size() > 0 && StringUtil.isEmpty(licDeptList.get(0).getAreaName())) {
				String yiedistrict = licDeptList.get(0).getYiedistrict();
				if (SJCODE.equals(yiedistrict)) {// 省级
					licDeptList.get(0).setAreaName(SJNAME);
				} else {
					List<SysDepart> sysDepartList = sysDepartService
							.doGetSysDepartByAdcode(yiedistrict == null || "".equals(yiedistrict) ? "" : yiedistrict);
					licDeptList.get(0).setAreaName(sysDepartList == null || sysDepartList.size() == 0 ? ""
							: sysDepartList.get(0).getOrgName());
				}
			}
			codeLicense = codeLicenseService.selectCodeLicenseByExaCodeAndLicType(exaCode, "2");
		}
		// 警示协同的地址 默认警示
		String sysUrl = "/reg/server";
		// 协同
		if ("2".equals(sysUser.getUserType())) {
			sysUrl = "/syn";
		}
		view.addObject("flag", flag);
		view.addObject("licDeptList", licDeptList);
		view.addObject("codeLicense", codeLicense);
		view.addObject("sysUser", sysUser);
		view.addObject("sysUrl", sysUrl);
		return view;
	}

	/**
	 * 
	 * 描述 新增提交 @author 赵祥江 @date 2016年10月19日 下午1:52:12 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping(value = "/commitLicDeptAdd", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitLicDeptAdd(@RequestBody LicDzDept licDept, HttpSession session, String flag)
			throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userType = sysUser.getUserType();
		try {
			if (licDept != null && StringUtil.isNotEmpty(licDept.getDeptCode())
					&& StringUtil.isNotEmpty(licDept.getExaCode())) {
				String exaCode = licDept.getExaCode();
				String msg = "";

				// 设置人姓名
				licDept.setSetName(sysUser.getRealName());
				licDept.setSetTime(DateUtil.getSysDate());
				String deptCdoe = licDept.getDeptCode();
				List<DeptDutycodeRef> deptDutycodeRefList = deptDutycodeRefService
						.selectDeptDutycodeRefByAdCode(deptCdoe);
				if ("2".equals(userType)) {
					msg = sysUser.getSysDepart().getOrgName() + "的" + sysUser.getRealName() + "执行了新增操作,备案事项编码:"
							+ exaCode + ",对应备案部门编码:" + licDept.getDeptCode() + ",对应备案部门名称:" + licDept.getDeptName()
							+ ";实际部门编码:" + licDept.getAdCode() + ",实际备案部门名称:" + licDept.getOrgName() + ";职能部门编码:"
							+ licDept.getDutyDeptCode() + ",职能部门名称:" + licDept.getDutyDeptName() + ";共新增了"
							+ deptDutycodeRefList.size() + "条记录";
				} else {
					msg = sysUser.getDepartMent().getDeptName() + "的" + sysUser.getRealName() + "执行了新增操作,备案事项编码:"
							+ exaCode + ",对应备案部门编码:" + licDept.getDeptCode() + ",对应备案部门名称:" + licDept.getDeptName()
							+ ";实际部门编码:" + licDept.getAdCode() + ",实际备案部门名称:" + licDept.getOrgName() + ";职能部门编码:"
							+ licDept.getDutyDeptCode() + ",职能部门名称:" + licDept.getDutyDeptName() + ";共新增了"
							+ deptDutycodeRefList.size() + "条记录";
				}
				if (deptDutycodeRefList != null && deptDutycodeRefList.size() > 1) {
					return AjaxResult.success("您选择的对应备案部门为" + deptDutycodeRefList.size() + "合一的合并部门,点击确定将生成"
							+ deptDutycodeRefList.size() + "条备案记录;确定继续吗?", "1");
				} else {
					List<LicDzDept> licDeptList = licDeptService.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(
							exaCode, licDept.getDutyDeptCode(), licDept.getYiedistrict(), "1");
					if (licDeptList != null && licDeptList.size() > 0) {
						return AjaxResult.success("同一备案事项、同一行政区下划该职能部门的备案记录已经存在!若继续操作将覆盖当前记录,确定继续吗?", "1");
					} else {
						licDeptService.insertLicDept(licDept);
						// 修改是否推送属地的值 库中已有是数据保持一致
						licDeptService.updateLicDeptByExaCode(exaCode, licDept.getLicDeptType(), "0");
						// 修改是否推送同级的值 库中已有是数据保持一致
						licDeptService.updateLicDeptByExaCode(exaCode, licDept.getIsSameGov(), "1");
						// 保存日志
						licDept.setDeptName(msg);
						this.saveLog(licDept, userType);
					}
				}
			}
			return AjaxResult.success("新增成功!", "0");
		} catch (Exception e) {
			licDept.setDeptName(e.getMessage());
			// 保存日志
			this.saveLog(licDept, userType);
			e.printStackTrace();
		}
		return AjaxResult.error("新增失败!");
	}

	/**
	 * 
	 * 描述 修改提交 @author 赵祥江 @date 2016年10月19日 下午1:54:28 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping(value = "/commitLicDeptEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitLicDeptEdit(@RequestBody LicDzDept licDept, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userType = sysUser.getUserType();
		try {
			if (licDept != null && StringUtil.isNotEmpty(licDept.getDeptCode())
					&& StringUtil.isNotEmpty(licDept.getExaCode())) {
				String exaCode = licDept.getExaCode();
				String msg = "";
				// 设置人姓名
				licDept.setSetName(sysUser.getRealName());
				licDept.setSetTime(DateUtil.getSysDate());
				List<LicDzDept> licDeptList = licDeptService.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(
						exaCode, licDept.getDutyDeptCode(), licDept.getYiedistrict(), "1");
				if (licDeptList != null && licDeptList.size() > 0) {
					if (licDeptList.size() > 1) {
						return AjaxResult.success("同一备案事项、同一行政区下划该职能部门的备案记录已经存在!若继续操作将覆盖当前记录,确定继续吗?", "1");
					} else {
						if (!licDeptList.get(0).getUid().equals(licDept.getUid())) {
							return AjaxResult.success("同一备案事项、同一行政区下划该职能部门的备案记录已经存在!若继续操作将覆盖当前记录,确定继续吗?", "1");
						}
					}
				}
				// 删除
				this.licDeptService.deleteLicDeptByUid(licDept.getUid());
				String deptCdoe = licDept.getDeptCode();
				List<DeptDutycodeRef> deptDutycodeRefList = deptDutycodeRefService
						.selectDeptDutycodeRefByAdCode(deptCdoe);
				for (DeptDutycodeRef deptDutycodeRef : deptDutycodeRefList) {
					this.licDeptService.deleteByExaCodeAnDutyDeptCodeAndYiedistrict(exaCode,
							deptDutycodeRef.getDutyDeptCode(), licDept.getYiedistrict());
					licDept.setUid(null);
					licDept.setDutyDeptCode(deptDutycodeRef.getDutyDeptCode());
					licDept.setDutyDeptName(deptDutycodeRef.getDutyDeptName());
					licDeptService.insertLicDept(licDept);
				}
				// 修改是否推送属地的值 库中已有是数据保持一致
				licDeptService.updateLicDeptByExaCode(exaCode, licDept.getLicDeptType(), "0");
				//// 修改是否推送同级的值 库中已有是数据保持一致
				licDeptService.updateLicDeptByExaCode(exaCode, licDept.getIsSameGov(), "1");
				if ("2".equals(userType)) {
					msg = sysUser.getSysDepart().getOrgName() + "的" + sysUser.getRealName() + "执行了修改操作,备案事项编码:"
							+ exaCode + ",对应备案部门编码:" + licDept.getDeptCode() + ",对应备案部门名称:" + licDept.getDeptName()
							+ ";实际部门编码:" + licDept.getAdCode() + ",实际备案部门名称:" + licDept.getOrgName() + ";职能部门编码:"
							+ licDept.getDutyDeptCode() + ",职能部门名称:" + licDept.getDutyDeptName() + ";共修改了"
							+ deptDutycodeRefList.size() + "条记录";
				} else {
					msg = sysUser.getDepartMent().getDeptName() + "的" + sysUser.getRealName() + "执行了修改操作,备案事项编码:"
							+ exaCode + ",对应备案部门编码:" + licDept.getDeptCode() + ",对应备案部门名称:" + licDept.getDeptName()
							+ ";实际部门编码:" + licDept.getAdCode() + ",实际备案部门名称:" + licDept.getOrgName() + ";职能部门编码:"
							+ licDept.getDutyDeptCode() + ",职能部门名称:" + licDept.getDutyDeptName() + ";共修改了"
							+ deptDutycodeRefList.size() + "条记录";
				}
				// 保存日志
				licDept.setDeptName(msg);
				this.saveLog(licDept, userType);
			}
			return AjaxResult.success("修改成功!", "0");
		} catch (Exception e) {
			licDept.setDeptName(e.getMessage());
			// 保存日志
			this.saveLog(licDept, userType);
			e.printStackTrace();
		}
		return AjaxResult.error("修改失败!");
	}

	/**
	 * 
	 * 描述 先删除再修改 @author 赵祥江 @date 2017年1月11日 下午7:46:30 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping(value = "/commitLicDeptUpdate", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitLicDeptUpdate(@RequestBody LicDzDept licDept, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userType = sysUser.getUserType();
		try {
			if (licDept != null && StringUtil.isNotEmpty(licDept.getDeptCode())
					&& StringUtil.isNotEmpty(licDept.getExaCode())) {
				String exaCode = licDept.getExaCode();
				// 设置人姓名
				licDept.setSetName(sysUser.getRealName());
				licDept.setSetTime(DateUtil.getSysDate());
				String msg = "";
				String deptCdoe = licDept.getDeptCode();
				List<DeptDutycodeRef> deptDutycodeRefList = deptDutycodeRefService
						.selectDeptDutycodeRefByAdCode(deptCdoe);
				String s = "新增";
				if (StringUtil.isNotEmpty(licDept.getUid())) {
					s = "修改";
					// 删除原来的
					licDeptService.deleteLicDeptByUid(licDept.getUid());
				}
				for (DeptDutycodeRef deptDutycodeRef : deptDutycodeRefList) {
					// 删除
					this.licDeptService.deleteByExaCodeAnDutyDeptCodeAndYiedistrict(exaCode,
							deptDutycodeRef.getDutyDeptCode(), licDept.getYiedistrict());
					licDept.setUid(null);
					licDept.setDutyDeptCode(deptDutycodeRef.getDutyDeptCode());
					licDept.setDutyDeptName(deptDutycodeRef.getDutyDeptName());
					licDeptService.insertLicDept(licDept);
				}
				if ("2".equals(userType)) {
					msg = sysUser.getSysDepart().getOrgName() + "的" + sysUser.getRealName() + "执行了" + s + "操作,备案事项编码:"
							+ exaCode + ",对应备案部门编码:" + licDept.getDeptCode() + ",对应备案部门名称:" + licDept.getDeptName()
							+ ";实际部门编码:" + licDept.getAdCode() + ",实际备案部门名称:" + licDept.getOrgName() + ";职能部门编码:"
							+ licDept.getDutyDeptCode() + ",职能部门名称:" + licDept.getDutyDeptName() + ";共" + s + "了"
							+ deptDutycodeRefList.size() + "条记录";
					;
				} else {
					msg = sysUser.getDepartMent().getDeptName() + "的" + sysUser.getRealName() + "执行了" + s + "操作,备案事项编码:"
							+ exaCode + ",对应备案部门编码:" + licDept.getDeptCode() + ",对应备案部门名称:" + licDept.getDeptName()
							+ ";实际部门编码:" + licDept.getAdCode() + ",实际备案部门名称:" + licDept.getOrgName() + ";职能部门编码:"
							+ licDept.getDutyDeptCode() + ",职能部门名称:" + licDept.getDutyDeptName() + ";共" + s + "了"
							+ deptDutycodeRefList.size() + "条记录";
					;
				}

				// 修改是否推送属地的值 库中已有是数据保持一致
				licDeptService.updateLicDeptByExaCode(exaCode, licDept.getLicDeptType(), "0");
				//// 修改是否推送同级的值 库中已有是数据保持一致
				licDeptService.updateLicDeptByExaCode(exaCode, licDept.getIsSameGov(), "1");
				// 保存日志
				licDept.setDeptName(msg);
				this.saveLog(licDept, userType);
				/*
				 * List<LicDept> licDeptList= licDeptService.
				 * selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(exaCode,
				 * licDept.getDutyDeptCode(), licDept.getYiedistrict());
				 * if(licDeptList!=null&&licDeptList.size()>0){ for(int
				 * i=0;i<licDeptList.size();i++){ if(licDeptList.size()==1){
				 * break; } if("系统自动".equals(licDeptList.get(i).getSetName())){
				 * licDeptService.deleteLicDeptByUid(licDeptList.get(i).getUid()
				 * ); } licDeptList.remove(i); i--; }
				 * licDept.setUid(licDeptList.get(0).getUid());
				 * licDeptService.updateLicDeptByUid(licDept);
				 * 
				 * }
				 */
			}
			return AjaxResult.success("修改成功!");
		} catch (Exception e) {
			licDept.setDeptName(e.getMessage());
			// 保存日志
			this.saveLog(licDept, userType);
			e.printStackTrace();
		}
		return AjaxResult.error("修改失败!");
	}

	/**
	 * 
	 * 描述 根据备案事项编码随机取一个备案部门 @author 赵祥江 @date 2016年10月28日
	 * 下午2:28:17 @param @return AjaxResult @throws
	 */
	@RequestMapping(value = "/randomDeptByExaCode", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult randomDeptByExaCode(LicDzDept licDept) throws Exception {
		try {
			PageRequest request = new PageRequest();
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("exaCode", licDept.getExaCode());
			request.setParams(queryMap);
			request.setLength(1);
			List<LicDzDeptDto> licDeptDtoList = licDeptService.queryLicDeptListJSON(request);
			return AjaxResult.success("查询成功", licDeptDtoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AjaxResult.error("查询失败!");
	}

	private void saveLog(LicDzDept licDept, String userType) {
		try {
			Map<String, String> logMap = new HashMap<String, String>();
			if ("2".equals(userType)) {
				logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE, ISysLogService.LOG_TYPE_SYN);// 协同系统
			} else {
				logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE, ISysLogService.LOG_TYPE_SERVER);// 警示系统
			}
			logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());// 年份
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, licDept.getDeptName());
			logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.licDzDeptLog.getCode());// 操作类型
			sysLogService.doAddSysLog(logMap, getRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 描述 根据uid删除 @author 赵祥江 @date 2017年1月10日 下午8:52:00 @param @return
	 * AjaxResult @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult delete(String uid) throws Exception {
		if (StringUtil.isNotEmpty(uid)) {
			if (licDeptService.deleteLicDeptByUid(uid) > 0) {
				return AjaxResult.success("删除成功");
			}
		}
		return AjaxResult.error("删除失败");
	}

}