/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.controller.reg.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.WritTypeEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.service.IMessageOpanoMalyService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.writ.model.Writ;
import com.icinfo.cs.writ.service.IWritService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述: 列入异常明细表（也即异常移出撤销表）.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@Controller
@RequestMapping({ "/reg/server/opadetail/pubopadetail", "/syn/server/opadetail/pubopadetail" })
public class PubOpaDetailController extends CSBaseController {
	private static final Logger logger = LoggerFactory.getLogger(PubOpaDetailController.class);
	// 异常列入信息表
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	// 异常移出/撤销信息表
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	// 管辖单位
	@Autowired
	private ICodeRegunitService codeRegunitService;
	// 登记机关表
	@Autowired
	private ICodeRegorgService codeRegorgService;
	// 准入基本信息表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	// 联络员信息表
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	// 部门信息表
	@Autowired
	private IDepartMentService departMentService;
	@Autowired
	private ICodeSlicenoService codeSlicenoService;
	// 全景查询服务方法
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private IEntSearchService entSearchService;
	@Autowired
	private IRegIndexService regIndexService;
	@Autowired
	private TokenManager tokenManager;

	@Autowired
	private IMessageOpanoMalyService mssessageOpanoMalyService;

	// 引入文书接口
	@Autowired
	private IWritService writService;
	@Autowired
	IEsManageService esManageService;

	/**
	 * 
	 * 描述: 进入移出（撤销）申请信息列表
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日 moveFlag 移出标志 1 为移出 systemType 操作 系统类型 1 企业 2 农专
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailMoveSearchList")
	public ModelAndView opadetailMoveSearchList(String moveFlag, String systemType, HttpSession session)
			throws Exception {
		ModelAndView view;
		if (moveFlag.equals("1")) {// 移出申请查询
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailmove_list");
		} else {// 撤销申请查询
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailcancel_list");
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		view.addObject("systemType", systemType);
		return view;
	}

	/**
	 * 
	 * 描述: 移出申请查询分页列表(撤销查询同方法，map中传值加标识)（操作权限）
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/pubOpadetailMoveListJSON.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOpaDetailDto> pubOpadetailMoveListJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "B.CheckDep", "B.LocalAdm");
		List<PubOpaDetailDto> data = pubOpaDetailService.selectMoveOutSearchList(request);
		return new PageResponse<PubOpaDetailDto>(data);
	}

	/**
	 * 
	 * 描述: 进入移出申请可添加信息列表
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailAddMoveList")
	public ModelAndView opadetailAddMoveList(String moveFlag, String systemType, HttpSession session) throws Exception {
		ModelAndView view;
		if (moveFlag.equals("1")) {// 移出申请查询
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailaddmove_list");
		} else {// 撤销申请查询
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailaddcancel_list");
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		view.addObject("systemType", systemType);
		return view;
	}

	/**
	 * 
	 * 描述: 移出申请可添加信息分页(撤销查询同方法，map中传值加标识)
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/OpadetailAddMoveListJSON.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOpaDetailDto> OpadetailAddMoveListJSON(PageRequest request) throws Exception {
		List<PubOpaDetailDto> data;
		// if(request.getParams().containsKey("searchFlag")){
		// data = new ArrayList<PubOpaDetailDto>();
		// }else{   
		creatOptDBAuthEnv(request, "B.CheckDep", "B.LocalAdm");
		data = pubOpaDetailService.selectAddMoveOutSearchList(request);
		// }
		return new PageResponse<PubOpaDetailDto>(data);
	}

	/**
	 * 
	 * 描述: 进入异常移出申请添加/修改页面
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @param session
	 * @param busExcList
	 * @param operate
	 *            操作 0 新增 1 修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailAddMove")
	public ModelAndView opadetailAddMove(HttpSession session, String busExcList, String operate) throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView(
				"/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailaddmove_edit");
		// 由列入文号得到列入异常信息
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		PubOpaDetail pubOpaDetail = new PubOpaDetail();
		String priPID = pubOpanoMaly.getPriPID();
		if (operate.equals("1")) { // 修改
			pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		}
		// 查询在册企业
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		// 若在册灭有 查询 所有状态企业
		if (midBaseInfo == null) {
			midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		}
		// 根据登记机关编码查询其部门名称、上级部门名称等信息
		DepartMent departMent = departMentService.selectDepartMentByDeptCode(midBaseInfo.getRegOrg());
		view.addObject("departMent", departMent);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(midBaseInfo.getRegOrg());
		view.addObject("codeRegorg", codeRegorg);
		// 联络员信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		view.addObject("pubEppassword", pubEppassword);
		view.addObject("sysUser", sysUser);
		view.addObject("pubOpanoMaly", pubOpanoMaly);
		view.addObject("pubOpaDetail", pubOpaDetail);
		view.addObject("operate", operate);
		return view;
	}

	/**
	 * 
	 * 描述: 移出(更正（撤销）)申请提交
	 * 
	 * @auther gaojinling
	 * @date 2016年10月26日
	 * @param pubOpanoMaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/opadetailcommit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult opadetailCommit(PubOpaDetailDto pubOpaDetailDto) throws Exception {
		// 当前年度
		pubOpaDetailDto.setSeqYear(Integer.parseInt(DateUtils.getYear()));
		pubOpaDetailDto.setFirstdate(new Date());
		// 撤销时处理移除原因编码和中文
		pubOpaDetailDto.setRemExcpres("2".equals(pubOpaDetailDto.getIsMove()) ? null : pubOpaDetailDto.getRemExcpres());
		pubOpaDetailDto
				.setRemExcpresCN("2".equals(pubOpaDetailDto.getIsMove()) ? null : pubOpaDetailDto.getRemExcpresCN());
		String operate = pubOpaDetailDto.getOperate();
		PubOpaDetail opaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(pubOpaDetailDto.getBusExcList(),
				pubOpaDetailDto.getPriPID());
		// 处理移出日期
		pubOpaDetailDto.setRemDate(DateUtil.getAllDate(pubOpaDetailDto.getRemDate()));
		if (operate.equals("1")) {// 修改
			if (pubOpaDetailService.updatePubOpaDetail(pubOpaDetailDto) > 0) {
				String auditstate = opaDetail.getAuditState();
				if ("2".equals(auditstate)) { // 审核不通过，修改
					// 移出或撤销审核成功，对当前用户对应的统计缓存数据重新设置
					try {
						// 企业基本信息
						MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubOpaDetailDto.getPriPID());
						// 若在册灭有 查询 所有状态企业
						if (midBaseInfo == null) {
							midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pubOpaDetailDto.getPriPID());
						}
						// 统计map
						Map<String, Object> forBidmap = new HashMap<String, Object>();
						// 操作权限添加
						creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
						// 1.得到当前统计条数 （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
						SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
						// 更新redis缓存
						regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "1",sysUser);
					} catch (Exception e) {
						logger.info(
								"busExcList" + pubOpaDetailDto.getBusExcList() + "移出(撤销)申请修改提交缓存设置失败" + e.getMessage());
					}
				}
				return AjaxResult.success("修改成功!");
			} else {
				return AjaxResult.error("修改失败!");
			}
		} else if (operate.equals("0")) {// 新增
			if (opaDetail != null) {// 如果已经存在，代表已经移出或撤销过了 ，不能新增
				return AjaxResult.error("该企业该项异常记录已经申请过移出或撤销，不能再次申请!");
			}
			if (pubOpaDetailService.insertPubOpaDetail(pubOpaDetailDto) > 0) {
				// 移出或撤销审核成功，对当前用户对应的统计缓存数据重新设置
				try {
					// 企业基本信息
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubOpaDetailDto.getPriPID());
					// 若在册灭有 查询 所有状态企业
					if (midBaseInfo == null) {
						midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pubOpaDetailDto.getPriPID());
					}
					// 统计map
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					// 操作权限添加
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					// 1.得到当前统计条数 （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
					SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					// 更新redis缓存
					regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "1",sysUser);
				} catch (Exception e) {
					logger.info("busExcList" + pubOpaDetailDto.getBusExcList() + "移出(撤销)申请提交缓存设置失败" + e.getMessage());
				}
				return AjaxResult.success("添加成功!");
			} else {
				return AjaxResult.error("添加失败!");
			}
		}
		return AjaxResult.error("操作失败!");
	}

	/**
	 * 
	 * 描述: 进入异常撤销申请添加/修改页面
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @param session
	 * @param busExcList
	 * @param operate
	 *            操作 0 新增 1 修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailAddCancel")
	public ModelAndView opadetailAddCancel(HttpSession session, String busExcList, String operate) throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView(
				"/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailaddcancel_edit");
		// 由列入文号得到列入异常信息
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		PubOpaDetail pubOpaDetail = new PubOpaDetail();
		String priPID = pubOpanoMaly.getPriPID();
		if (operate.equals("1")) { // 修改
			pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		}
		// 查询在册企业
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		// 若在册灭有 查询 所有状态企业
		if (midBaseInfo == null) {
			midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		}
		// 根据登记机关编码查询其部门名称、上级部门名称等信息
		DepartMent departMent = departMentService.selectDepartMentByDeptCode(midBaseInfo.getRegOrg());
		view.addObject("departMent", departMent);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(midBaseInfo.getRegOrg());
		view.addObject("codeRegorg", codeRegorg);
		// 联络员信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		view.addObject("pubEppassword", pubEppassword);
		view.addObject("sysUser", sysUser);
		view.addObject("pubOpanoMaly", pubOpanoMaly);
		view.addObject("pubOpaDetail", pubOpaDetail);
		view.addObject("operate", operate);
		return view;
	}

	/**
	 * 
	 * 描述: 删除(移出(更正（撤销）)申请)
	 * 
	 * @auther gaojinling
	 * @date 2016年10月26日
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deletePubOpadetail", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deletePubOpadetail(String busExcList, String priPID) throws Exception {
		if (StringUtil.isNotEmpty(busExcList)) {
			if (pubOpaDetailService.deletePubOpaDetailByBusExcList(busExcList) > 0) {
				try {
					// 移出异常审核删除，移出审核数据减少，对当前用户对应的统计缓存数据重新设置（-1）
					// 企业基本信息
					MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
					// 若在册灭有 查询 所有状态企业
					if (midBaseInfo == null) {
						midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
					}
					// 统计map
					Map<String, Object> forBidmap = new HashMap<String, Object>();
					// 操作权限添加
					creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
					// 1.得到当前统计条数 （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
					SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
					// 更新redis缓存
					regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "2",sysUser);
				} catch (Exception e) {
					logger.info("busExcList" + busExcList + "删除移出(撤销)申请缓存设置失败" + e.getMessage());
				}
				return AjaxResult.success("删除成功!");
			}
		}
		return AjaxResult.error("删除失败");
	}

	/**
	 * 
	 * 描述: 进入移出（撤销）审核查询信息列表
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailAuditSearchList")
	public ModelAndView opadetailAuditSearchList(String moveFlag, String systemType, HttpSession session)
			throws Exception {
		ModelAndView view;
		if (moveFlag.equals("1")) {// 移出审核查询
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailmoveaudit_list");
		} else {// 撤销审核查询
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailcancelaudit_list");
		}
		view.addObject("systemType", systemType);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		view.addObject("codeRegorg", codeRegorgService.selectRegOrgByCode(regOrg));
		return view;
	}

	/**
	 * 
	 * 描述: 进入异常移出（更正（撤销））审核(查看)页面
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @param session
	 * @param busExcList
	 * @param operate
	 *            操作 0 移出 1 更正（撤销）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailAudit")
	public ModelAndView opadetailAudit(HttpSession session, String busExcList, String operate) throws Exception {
		// 获取当前用户信息
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view;
		if (operate.equals("0")) {// 移出
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailmoveaudit_edit");
		} else {// 更正（撤销）
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailcancelaudit_edit");
		}
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		String priPID = pubOpanoMaly.getPriPID();
		PubOpaDetail pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		// 查询在册企业
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		// 若在册灭有 查询 所有状态企业
		if (midBaseInfo == null) {
			midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		}
		// 根据登记机关编码查询其部门名称、上级部门名称等信息
		DepartMent departMent = departMentService.selectDepartMentByDeptCode(midBaseInfo.getRegOrg());
		view.addObject("departMent", departMent);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(midBaseInfo.getRegOrg());
		view.addObject("codeRegorg", codeRegorg);
		// 联络员信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		view.addObject("pubEppassword", pubEppassword);
		view.addObject("sysUser", sysUser);
		view.addObject("pubOpanoMaly", pubOpanoMaly);
		view.addObject("pubOpaDetail", pubOpaDetail);
		view.addObject("operate", operate);
		return view;
	}

	/**
	 * 
	 * 描述: 进入异常移出（更正（撤销））审核(查看)页面
	 * 
	 * @auther gaojinling
	 * @date 2016年10月25日
	 * @param session
	 * @param busExcList
	 * @param operate
	 *            操作 0 移出 1 更正（撤销）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailView")
	public ModelAndView opadetailView(HttpSession session, String busExcList, String operate) throws Exception {
		// 获取当前用户信息
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view;
		if (operate.equals("0")) {// 移出
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailmove_view");
		} else {// 更正（撤销）
			view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailcancel_view");
		}
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		String priPID = pubOpanoMaly.getPriPID();
		PubOpaDetail pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		// 查询在册企业
		MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
		// 若在册灭有 查询 所有状态企业
		if (midBaseInfo == null) {
			midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		}
		// 根据登记机关编码查询其部门名称、上级部门名称等信息
		DepartMent departMent = departMentService.selectDepartMentByDeptCode(midBaseInfo.getRegOrg());
		view.addObject("departMent", departMent);
		// 决定机关
		CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(midBaseInfo.getRegOrg());
		view.addObject("codeRegorg", codeRegorg);
		// 联络员信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		view.addObject("midBaseInfoDto", midBaseInfo);
		view.addObject("pubEppassword", pubEppassword);
		view.addObject("sysUser", sysUser);
		view.addObject("pubOpanoMaly", pubOpanoMaly);
		view.addObject("pubOpaDetail", pubOpaDetail);
		view.addObject("operate", operate);
		return view;
	}

	/**
	 * 
	 * 描述: 移出(更正（撤销））审核提交
	 * 
	 * @auther gaojinling
	 * @date 2016年10月26日
	 * @param pubOpanoMaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/opadetailAuditCommit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult opadetailAuditCommit(PubOpaDetailDto pubOpaDetail) throws Exception {
		// 当前年度
		pubOpaDetail.setSeqYear(Integer.parseInt(DateUtils.getYear()));
		pubOpaDetail.setAuditDate(new Date());
		// 处理移出日期
		pubOpaDetail.setRemDate(DateUtil.getAllDate(pubOpaDetail.getRemDate()));
		if (StringUtil.isNotEmpty(pubOpaDetail.getBusExcList())) {
			// 先查询当前移出撤销情况 确定不为不予移出/撤销后再次申请移出的企业
			PubOpaDetail pubOpaDetailTemp = pubOpaDetailService
					.selectPubOpaDetailByBusExcList(pubOpaDetail.getBusExcList(), pubOpaDetail.getPriPID());
			String aduitstate = pubOpaDetailTemp.getAuditState();
			if (pubOpaDetail.getAuditState().equals("1")) { // 审核通过的时候
				DepartMent departMent = departMentService.selectDepartMentByDeptCode(pubOpaDetail.getRegOrg());
				Integer docNo = pubOpaDetailService.selectPenDecNoMove(departMent.getDocShortName(),
						pubOpaDetail.getIsMove());
				if (docNo == null) {
					docNo = new Integer(1);
				}
				String str = "1".equals(pubOpaDetail.getIsMove()) ? "异出〔" : "异更〔";
				String penDecNo = departMent.getDocShortName() + str + DateUtils.getYear() + "〕第" + docNo + "号";
				pubOpaDetail.setPenDecNo(penDecNo);
			}
			if (pubOpaDetail.getIsMove().equals("2") && pubOpaDetail.getAuditState().equals("1")) { // 撤销且为审核通过的时候(列入表添加撤销标志)
				PubOpanoMaly pubOpanoMaly = new PubOpanoMaly();
				pubOpanoMaly.setBusExcList(pubOpaDetail.getBusExcList());
				pubOpanoMaly.setPriPID(pubOpaDetail.getPriPID());
				pubOpanoMaly.setRevokeFlag("1");
				pubOpanoMalyService.updatePubOpanoMaly(pubOpanoMaly);
			}
			if (pubOpaDetailService.updatePubOpaDetail(pubOpaDetail) > 0) {
				if ("0".equals(aduitstate)) { // 待审核状态下 说明是首次审核
					try {
						// 企业基本信息
						MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pubOpaDetail.getPriPID());
						// 若在册灭有 查询 所有状态企业
						if (midBaseInfo == null) {
							midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(pubOpaDetail.getPriPID());
						}
						// 移出或撤销审核成功，对当前用户对应的统计缓存数据重新设置
						// 统计map
						Map<String, Object> forBidmap = new HashMap<String, Object>();
						// 操作权限添加
						creatOptDBAuthEnv(forBidmap, "t.CheckDep", "t.LocalAdm");
						// 1.得到当前统计条数 （一般此时缓存存在，存在时由缓存中取值，无直接查询数据库取值）
						SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
						// 更新redis缓存
						regIndexService.doRedisRegCount(sysUser.getId(), forBidmap, midBaseInfo.getEntTypeCatg(), "2",sysUser);
					} catch (Exception e) {
						logger.info("busExcList" + pubOpaDetail.getBusExcList() + "移出(撤销)审核提交缓存设置失败" + e.getMessage());
					}
				}

				try {
					if ("1".equals(pubOpaDetail.getAuditState())) {
						// 消息推送
						List<String> priPIDList = new ArrayList<String>();
						priPIDList.add(pubOpaDetail.getPriPID());
						SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
						mssessageOpanoMalyService.sendIsMoveOpanoMaly(priPIDList, pubOpaDetail.getIsMove(), sysUser);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

				// 插入成功 ，更新索引
				Map<String, Object> indexMap = new HashMap<String, Object>();
				indexMap.put("priPID", pubOpaDetail.getPriPID());
				List<PubOpaDetailDto> indexList = pubOpaDetailService.selectAddMoveOutSearch(indexMap);
				if (indexList == null || indexList.size() == 0) {
					try {
						// 更新索引
						esManageService.updateOnePanoramaIdx(pubOpaDetail.getPriPID());

						Map<String, Object> indexserverMap = new HashMap<String, Object>();
						indexserverMap.put("priPID", pubOpaDetail.getPriPID());
						indexserverMap.put("isOpanomaly", "0");
						entSearchService.updatePubIndex(indexserverMap);
					} catch (Exception e) {
						return AjaxResult.success("审核成功!");
					}
				}
				// 添加文书
				addWritData(pubOpaDetail);

				return AjaxResult.success("审核成功!");
			}
		}
		return AjaxResult.error("审核失败!");
	}

	/**
	 * @描述： 添加文书
	 * 
	 * @author: wangjin
	 * @date 2017-07-11 9:57
	 * @return
	 */
	public void addWritData(PubOpaDetailDto pubOpaDetail) {
		// 添加文书内容
		try {
			if (com.icinfo.cs.common.utils.StringUtil.isNotBlank(pubOpaDetail.getAuditState())
					&& "1".equals(pubOpaDetail.getAuditState())) {
				writService.addWrit(new Writ(pubOpaDetail.getPriPID(), pubOpaDetail.getPenDecNo(),
						"1".equals(pubOpaDetail.getIsMove()) ? WritTypeEnum.WRIT_TYPE_YiChuYiCha.getType()
								: WritTypeEnum.WRIT_TYPE_CheXiaoYiChang.getType(),
						pubOpaDetail.getBusExcList(), pubOpaDetail.getYear()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 描述: 进入移出决定书填报页面
	 * 
	 * @auther gaojinling
	 * @date 2016年10月28日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailBook")
	public ModelAndView opadetailBook(HttpSession session, String busExcList, String priPID) throws Exception {
		ModelAndView view = new ModelAndView(
				"/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetaildescbook_edit");
		PubOpaDetail pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		DepartMent departMent = departMentService.selectDepartMentByDeptCodespec(pubOpaDetail.getRegOrg());
		view.addObject("pubOpaDetail", pubOpaDetail);
		view.addObject("pubOpanoMaly", pubOpanoMaly);
		view.addObject("departMent", departMent);
		return view;
	}

	/**
	 * 
	 * 描述: 决定书保存
	 * 
	 * @auther gaojinling
	 * @date 2016年10月26日
	 * @param pubOpanoMaly
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/descbookCommit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult descbookCommit(PubOpaDetailDto pubOpaDetailDto) throws Exception {
		if (pubOpaDetailService.updatePubOpaDetail(pubOpaDetailDto) > 0) {
			return AjaxResult.success("决定书保存成功!");
		} else {
			return AjaxResult.error("决定书保存失败!");
		}
	}

	/**
	 * 
	 * 描述: 打印决定书
	 * 
	 * @auther gaojinling
	 * @date 2016年10月28日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/opadetailBookPrint")
	public ModelAndView opadetailBookPrint(HttpSession session, String busExcList, String priPID) throws Exception {
		ModelAndView view = new ModelAndView(
				"/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetaildescbook_print");
		PubOpaDetail pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		PubOpanoMaly pubOpanoMaly = pubOpanoMalyService.selectPubOpanoMalyByBusExcList(busExcList);
		view.addObject("pubOpanoMaly", pubOpanoMaly);
		view.addObject("pubOpaDetail", pubOpaDetail);
		return view;
	}

	/**
	 * 
	 * 描述: 检验是否移除生成决定书
	 * 
	 * @auther gaojinling
	 * @date 2016年10月28日
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/existopadetailBook")
	@ResponseBody
	public AjaxResult existopadetailBook(String busExcList, String priPID) throws Exception {
		PubOpaDetail pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, priPID);
		// 同级人民政府
		String deptSameGov = pubOpaDetail.getDeptSameGov();
		// 同级人民法院
		String deptSameCourt = pubOpaDetail.getDeptSameCourt();
		// 上级机关名称
		String deptUpName = pubOpaDetail.getDeptUpName();
		if (StringUtil.isNotEmpty(deptSameGov) && StringUtil.isNotEmpty(deptSameCourt)
				&& StringUtil.isNotEmpty(deptUpName)) {
			return AjaxResult.success("已经生成了决定书");
		}
		return AjaxResult.error("请先生成列入经营异常名录决定书");
	}

	/**
	 * 
	 * 描述: 打印审批表
	 * 
	 * @auther gaojinling
	 * @date 2016年10月30日
	 * @param session
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pubOpadetailPrintTable")
	public ModelAndView pubOpanoMalyPrintspTable(HttpSession session, String busExcList) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/opanomaly/pubopanomaly/pubopadetail/pubopadetailtable_print");
		PubOpaDetail pubOpaDetail = pubOpaDetailService.selectPubOpaDetailByBusExcList(busExcList, null);
		view.addObject("pubOpaDetail", pubOpaDetail);
		return view;
	}

}