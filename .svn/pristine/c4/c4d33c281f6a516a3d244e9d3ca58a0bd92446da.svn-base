package com.icinfo.cs.nocreditPunish.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.GenerSeqUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishBack;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishDetail;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishInfo;
import com.icinfo.cs.nocreditPunish.model.NoCreditPunishRule;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishBackService;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishDetailService;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishInfoService;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishRuleService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 失信联合惩戒管理控制器
 * @author caoxu
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({ "/syn/noCreditPunish/info", "/reg/server/noCreditPunish/info" })
public class NoCreditPunishInfoController extends BaseController {
	
	@Autowired
	private NoCreditPunishInfoService noCreditPunishInfoService;
	
	@Autowired
	private NoCreditPunishDetailService noCreditPunishDetailService;
	
	@Autowired
	private NoCreditPunishBackService noCreditPunishBackService;
	
	@Autowired
	private NoCreditPunishRuleService noCreditPunishRuleService;
	@Autowired
	private OssClient ossClient;
	
	@Autowired
	private  HttpServletRequest request;
	
	@Value("${cloudModel}")
	private String cloudModel;
	
	/**
	 * 跳转到惩戒反馈页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/list"})
	public String list(ModelMap map, String tab) throws Exception {
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		map.addAttribute("tab", tab);
		return "/syn/system/nocreditPunish/info/punishinfolist";
	}
	
	/**
	 * 跳转到惩戒申请页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/reqlist"})
	public String reqlist(ModelMap map) throws Exception {
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		return "/syn/system/nocreditPunish/info/punishinfo_req_list";
	}
	
	/**
	 * 跳转到惩戒审核页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/auditlist"})
	public String auditlist(ModelMap map) throws Exception {
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		return "/syn/system/nocreditPunish/info/punishinfo_audit_list";
	}
	
	/**
	 * 跳转到惩戒企业查询页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/entlist"})
	public String entlist(ModelMap map) throws Exception {
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		map.addAttribute("sysDate", DateUtil.getCurrentDate());
		return "/syn/system/nocreditPunish/info/punishinfo_ent_list";
	}
	
	/**
	 * 跳转到惩戒自然人查询页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/manlist"})
	public String manlist(ModelMap map) throws Exception {
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		map.addAttribute("sysDate", DateUtil.getCurrentDate());
		return "/syn/system/nocreditPunish/info/punishinfo_man_list";
	}
	
	/**
	 * 入口选择
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/entrance"})
	public String entrance() throws Exception {
		return "/syn/system/nocreditPunish/info/entrance";
	}
	
	/**
	 * 跳转到企业惩戒添加界面
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/addmyent"})
	public String addEnt(ModelMap map) throws Exception {
		map.addAttribute("date", DateUtil.dateToString(new Date(), "yyyy年MM月dd日"));
		map.addAttribute("punType", "ent");
		map.addAttribute("nowdate", DateUtil.getSysDate());
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		map.addAttribute("batchNo", "CJQ" + GenerSeqUtil.generateID());
		return "/syn/system/nocreditPunish/info/punishinfoadd";
	}
	
	/**
	 * 跳转到自然人惩戒添加界面
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/addmyman"})
	public String addMan(ModelMap map) throws Exception {
		map.addAttribute("date", DateUtil.dateToString(new Date(), "yyyy年MM月dd日"));
		map.addAttribute("punType", "man");
		map.addAttribute("nowdate", DateUtil.getSysDate());
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		map.addAttribute("batchNo", "CJR" + GenerSeqUtil.generateID());
		return "/syn/system/nocreditPunish/info/punishinfoadd";
	}
	
	/**
	 * 获取需要反馈的戒单列表（企业、自然人）
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishInfoDto> listJSON(PageRequest request, String type) throws Exception {
		Map<String, Object> parms = request.getParams();
		if (parms == null) {
			parms = new HashMap<String, Object>();
		}
		if (type != null) {
			parms.put("type", type);
		}
		parms.put("exeEnd", DateUtil.getCurrentDate());
		SysUserDto sysUserDto = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (sysUserDto.getUserType().equals("1")) {
			parms.put("userType", "1");  //判断警示，还是协同
			parms.put("userDeptCode", sysUserDto.getDeptCode());
		} else
			parms.put("userDeptCode", sysUserDto.getSysDepart().getAdcode());
		List<NoCreditPunishInfoDto> list = this.noCreditPunishInfoService.selectAuditedInfoPage(request, parms);
		return new PageResponse<NoCreditPunishInfoDto>(list);
	}
	
	/**
	 * 获取某企业的惩戒记录
	 * @param request
	 * @param priPid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/recordlist.json", "recordlist.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishInfoDto> recordlistJSON(PageRequest request) throws Exception {
		Map<String, Object> parms = request.getParams();
		parms.put("type", parms.get("type"));
		if ("ent".equals(parms.get("type").toString())) {
			parms.put("priPID", parms.get("key").toString());
		} else{
			parms.put("cardNo", parms.get("key").toString());
		} 	
		List<NoCreditPunishInfoDto> list = this.noCreditPunishInfoService.selectAuditedInfoPage(request, parms);
		return new PageResponse<NoCreditPunishInfoDto>(list);
	}
	
	/**
	 * 获取我的的戒单列表（企业、自然人）
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/mylist.json", "mylist.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishInfoDto> mylistJSON(PageRequest request) throws Exception {
		Map<String, Object> parms = request.getParams();
		if (parms == null) {
			parms = new HashMap<String, Object>();
		} 
		StringUtil.paramTrim(parms);
		if(parms.containsKey("proveType")){
			parms.put("proveType", StringUtil.doSplitStringToSqlFormat(parms.get("proveType").toString(),","));
		}
		
		SysUserDto sysUserDto = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (sysUserDto.getUserType().equals("1")) {
			parms.put("operDeptCode", sysUserDto.getDeptCode());
		} else{
			parms.put("operDeptCode", sysUserDto.getSysDepart().getAdcode());
		}	
		parms.put("exeEnd", new Date());
		List<NoCreditPunishInfoDto> list = this.noCreditPunishInfoService.selectAllInfoJsonList(request, parms);
		return new PageResponse<NoCreditPunishInfoDto>(list);
	}
	
	/**
	 * 查询惩戒全信息列表
	 * @param request
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/searchlist.json", "searchlist.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishInfoDto> searchlistJSON(PageRequest request, String type, HttpSession session) throws Exception {
		Map<String, Object> parms = request.getParams();
		if (parms == null) {
			parms = new HashMap<String, Object>();
		}
		if (type != null) {
			parms.put("type", type);
		}
		parms.put("exeEnd", DateUtil.getCurrentDate());
		// --------------------加个adcode add by liuhq
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (sysUserDto.getSysDepart() != null) {
			parms.put("adCode", sysUserDto.getSysDepart().getAdcode());
		}
		// --------------------加个adcode 完 add by liuhq
		List<NoCreditPunishInfoDto> dtos = this.noCreditPunishInfoService.selectAllFullInfoList(request, parms);
		return new PageResponse<NoCreditPunishInfoDto>(dtos);
	}

	/**
	 *
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/searchlistJSON_downednum"})
	@ResponseBody
	public AjaxResult searchlistJSON_downednum(String uniCode,String entName,HttpSession session)throws Exception{
		Map<String, Object> parms  = new HashMap<String, Object>();

		parms.put("exeEnd", new Date());
		parms.put("uniCode",uniCode);
		parms.put("entName",entName);
		//--------------------加个adcode add by liuhq
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		parms.put("adCode",sysUserDto.getSysDepart().getAdcode());
		//--------------------加个adcode 完 add by liuhq
		String downed = noCreditPunishInfoService.searchlistJSON_downednum(parms);
		return AjaxResult.success("downed",downed );

	}
	/**
	 * 弹出添加框
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/selectDig"})
	public String selectDig(ModelMap map, String type) throws Exception {
		map.addAttribute("type", type);
		if (type.equals("ent")) {
			return "/syn/system/nocreditPunish/info/selectentdig";
		}
		return "/syn/system/nocreditPunish/info/selectmandig";
	}
	
	/**
	 * 弹出惩戒记录框
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/recordlist"})
	public String recordlist(ModelMap map, String type, String key) throws Exception {
		map.addAttribute("type", type);
		map.addAttribute("key", key);
		return "/syn/system/nocreditPunish/info/recorddig";
	}
	
	/**
	 * 跳转到惩戒记录详情页dialog
	 * @param map
	 * @param batchNo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/goToRecordInfo"})
	public String goToRecordInfo(ModelMap map, String batchNo, String type, String key) throws Exception {
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("batchNo", batchNo);
		NoCreditPunishInfo info = this.noCreditPunishInfoService.getInfo(batchNo);
		map.addAttribute("info", info);
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		map.addAttribute("user", user);
		map.addAttribute("date", new Date());
		// 明细
		List<NoCreditPunishDetail> details = this.noCreditPunishDetailService.queryList(parms);
		map.addAttribute("details", details);
		// 反馈列表
		List<NoCreditPunishBack> backlist = this.noCreditPunishBackService.queryList(parms);
		map.addAttribute("backlist", backlist);
		// 附件
		String files = info.getFiles();
		if (files != null && !files.isEmpty()) {
			map.addAttribute("files", files.split("\\|"));
		}
		map.addAttribute("key", key);
		return "/syn/system/nocreditPunish/info/punishinfoview_dig";
	}
	
	/**
	 * 保存失信联合惩戒单
	 * @param noCreditPunishInfoDto
	 * @param detailJson
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@RepeatSubmit(timeout=2000)
    @ResponseBody
	public synchronized  AjaxResult save(@Valid NoCreditPunishInfoDto noCreditPunishInfoDto, BindingResult result, String detailJson, String files) throws Exception {
		/*if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查 红色* 的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}*/
		detailJson = StringEscapeUtils.unescapeHtml(detailJson);

		JSONArray array = JSONArray.fromObject(detailJson);
		if (array.size() == 0) {
			return AjaxResult.error("请填写惩戒对象明细表");
		}
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		noCreditPunishInfoDto.setOperDept(user.getDept());
		if (user.getUserType().equals("1")) {
			noCreditPunishInfoDto.setOperDeptCode(user.getDeptCode());
		} else{
			noCreditPunishInfoDto.setOperDeptCode(user.getSysDepart().getAdcode());
		}	
		if (noCreditPunishInfoDto.getIsLife() == null) {
			noCreditPunishInfoDto.setIsLife("0");
		}
		noCreditPunishInfoDto.setAuditRes("-1");
		noCreditPunishInfoDto.setPunReqDeptCode(user.getId());
		noCreditPunishInfoDto.setPunReqUser(user.getRealName());
		noCreditPunishInfoDto.setPunReqDept(user.getDept());
		noCreditPunishInfoDto.setPunReqDeptCode(noCreditPunishInfoDto.getOperDeptCode());
		// 存储主表
		if (this.noCreditPunishInfoService.insert(noCreditPunishInfoDto) > 0) {
		} else {
			return AjaxResult.error("保存失败");
		}
		// 存储明细
		this.noCreditPunishInfoService.insertDetail(array, noCreditPunishInfoDto);
		//创建反馈空记录
		this.noCreditPunishBackService.insertBackDetail(noCreditPunishInfoDto.getPunExeDept(),
				noCreditPunishInfoDto.getPunExeDeptCode(), noCreditPunishInfoDto.getBatchNo(),
				noCreditPunishInfoDto.getFeedBack());
		return AjaxResult.success("保存成功");
	}
	
	/**
	 * 获取企业信息
	 * @param entName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getEnt", method = RequestMethod.POST)
	@ResponseBody
	public NoCreditPunishDetail getEnt(String entName) throws Exception {
		return this.noCreditPunishInfoService.selectEnt(entName);
	}
	
	/**
	 * 获取自然人信息
	 * @param entName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getMan", method = RequestMethod.POST)
	@ResponseBody
	public NoCreditPunishDetail getMan(String keyword) throws Exception {
		return this.noCreditPunishInfoService.selectMan(keyword);
	}

	/**
	 * 判断是否有惩戒记录
	 * 
	 * @param key
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/detailExist", method = RequestMethod.POST)
	@ResponseBody
	public String detailExist(String key, String type) throws Exception {
		Boolean isExist = false;
		if (type.equals("ent")) {
			isExist = this.noCreditPunishDetailService.detailEntExist(key);
		} else
			isExist = this.noCreditPunishDetailService.detailManExist(key);
		if (isExist) {
			return "exist";
		} else
			return "none";
	}
	
	/**
	 * 进入单据编辑页
	 * @param batchNo
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editpage", method = RequestMethod.GET)
	public String editpage(String batchNo, ModelMap map) throws Exception {
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("batchNo", batchNo);
		NoCreditPunishInfo info = this.noCreditPunishInfoService.getInfo(batchNo);
		map.addAttribute("info", info);
		if (info != null) {
			// 获取附件路径
			String files = info.getFiles();
			if (files != null && !files.isEmpty()) {
				map.addAttribute("files", files.split("\\|"));
			}
			// 获取当前用户
			SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
			map.addAttribute("user", user);
			map.addAttribute("date", new Date());
			// 明细
			List<NoCreditPunishDetail> details = this.noCreditPunishDetailService.queryList(parms);
			map.addAttribute("details", details);
			Map<String, Object> rulemap = new HashMap<String, Object>();
			rulemap.put("punField", info.getPunField());
			List<NoCreditPunishRule> causes = this.noCreditPunishRuleService.queryList(rulemap);
			map.addAttribute("causes", causes);
			return "/syn/system/nocreditPunish/info/punishinfoedit";
		} else{
			return "/syn/system/nocreditPunish/info/punishinfo_req_list";
		}	
	}
	
	/**
	 * 进入单据查看页
	 * @param batchNo
	 * @param deal （判断处理页面。查看，审核，编辑，反馈）
	 * @param map
	 * @param from（来源菜单标记）
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String batchNo, Integer deal,String printFlag, ModelMap map) throws Exception {
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("batchNo", batchNo);
		map.put("printFlag", printFlag);
		NoCreditPunishInfo info = this.noCreditPunishInfoService.getInfo(batchNo);
		if (info != null) {
			map.addAttribute("info", info);
			// 获取附件路径
			String files = info.getFiles();
			if (files != null && !files.isEmpty()) {
				map.addAttribute("files", files.split("\\|"));
			}
			// 获取当前用户
			SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
			map.addAttribute("user", user);
			map.addAttribute("deal", deal);
			map.addAttribute("date", new Date());
			// 明细
			List<NoCreditPunishDetail> details = this.noCreditPunishDetailService.queryList(parms);
			map.addAttribute("details", details);
			if (deal == 1 || deal==5) {
				return "/syn/system/nocreditPunish/info/punishinfoaudit";
				// 返回反馈页
			} else if (deal == 2) {
				map.addAttribute("backlist", null);
				map.addAttribute("flag", "Y");
				return "/syn/system/nocreditPunish/info/punishinfoview";
				// 返回查看页
			} else if (deal == 3) {
				// 反馈列表
				parms.put("state", 1);
				List<NoCreditPunishBack> backlist = this.noCreditPunishBackService.queryList(parms);
				backlist = backlist.size() == 0 ? null : backlist;
				map.addAttribute("backlist", backlist);
				map.addAttribute("flag", "N");
				return "/syn/system/nocreditPunish/info/punishinfoview";
			} else if (deal == 4) {
				//打印页
				parms.put("state", 1);
				List<NoCreditPunishBack> backlist = this.noCreditPunishBackService.queryList(parms);
				backlist = backlist.size() == 0 ? null : backlist;
				map.addAttribute("backlist", backlist);
				map.addAttribute("flag", "N");
				return "/syn/system/nocreditPunish/info/punishinfo_print";
			}else if (deal == 6) { 
				//隐藏身份证号码
				if(details!=null&&details.size()>0){
					for(NoCreditPunishDetail noCreditPunishDetail:details){ 
						if(StringUtil.isNotBlank(noCreditPunishDetail.getCardNo())){
							String sCard=noCreditPunishDetail.getCardNo();
							if(sCard.indexOf("*")>0){
								noCreditPunishDetail.setRecord(sCard);
							}else{
								String carBeforeSix=noCreditPunishDetail.getCardNo().substring(0, 6);
								String carAfterFour=noCreditPunishDetail.getCardNo().substring(noCreditPunishDetail.getCardNo().length()-4, noCreditPunishDetail.getCardNo().length());
								String carX=CardUtil.getHide(sCard); 
								noCreditPunishDetail.setRecord(carBeforeSix+carX+carAfterFour);
							}
						}else{
							noCreditPunishDetail.setRecord("");
						}
					}
				}
				return "/syn/system/search/nocreditpunishsearch/nocreditpunishsearch_edit";
			}
		}else if(deal == 6){
			return "";
		}
		return "/syn/system/nocreditPunish/info/punishinfolist";
	}
	
	/**
	 * 修改更新惩戒单
	 * @param noCreditPunishInfoDto
	 * @param detailJson
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@RepeatSubmit(timeout=2000)
    @ResponseBody
	public synchronized  AjaxResult update(@Valid NoCreditPunishInfoDto noCreditPunishInfoDto, BindingResult result, String detailJson) throws Exception {
		/*if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查 红色* 的内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}*/
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		// 终身处理
		if (noCreditPunishInfoDto.getIsLife() == null) {
			noCreditPunishInfoDto.setIsLife("0");
		}
		// 撤销之前审核结果
		noCreditPunishInfoDto.setAuditRes("-1");
		noCreditPunishInfoDto.setPunReqDeptCode(user.getId());
		noCreditPunishInfoDto.setPunReqUser(user.getRealName());
		noCreditPunishInfoDto.setPunReqDept(user.getDept());
		noCreditPunishInfoDto.setPunReqDeptCode(noCreditPunishInfoDto.getOperDeptCode());
		noCreditPunishInfoDto.setCreateTime(DateUtil.getSysDate());
		// 更新主单据信息
		if (this.noCreditPunishInfoService.update(noCreditPunishInfoDto) > 0) {
			Map<String, Object> parms = new HashMap<String, Object>();
			parms.put("batchNo", noCreditPunishInfoDto.getBatchNo());
			// 先删除原先明细
			this.noCreditPunishDetailService.delete(parms);
			detailJson = StringEscapeUtils.unescapeHtml(detailJson);
			JSONArray array = JSONArray.fromObject(detailJson);
			if (array.size() == 0) {
				return AjaxResult.error("请选择惩戒对象");
			}
			// 存储新明细
			this.noCreditPunishInfoService.insertDetail(array, noCreditPunishInfoDto);
			//先删除原先反馈
			this.noCreditPunishBackService.delete(parms);
			//创建新反馈空白记录
			this.noCreditPunishBackService.insertBackDetail(noCreditPunishInfoDto.getPunExeDept(),
					noCreditPunishInfoDto.getPunExeDeptCode(), noCreditPunishInfoDto.getBatchNo(),
					noCreditPunishInfoDto.getFeedBack());
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败！");
	}
	
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult audit(String auditView, String auditRes, String feedBack, String batchNo,String isLife) throws Exception {
		if(com.icinfo.cs.common.utils.StringUtil.isBlank(batchNo)){
			return AjaxResult.error("审核失败！");
		} 
		// 获取当前用户
		SysUserDto user = this.noCreditPunishInfoService.getCurrUser();
		//
		NoCreditPunishInfo noCreditPunishInfo = new NoCreditPunishInfo();
		noCreditPunishInfo.setBatchNo(batchNo);
		noCreditPunishInfo.setAuditor(user.getRealName());
		noCreditPunishInfo.setAuditTime(new Date());
		noCreditPunishInfo.setAuditRes(auditRes);
		noCreditPunishInfo.setAuditView(auditView);
		// 审核通过终身有效
		if ("0".equals(auditRes)&&"1".equals(isLife)) {
			noCreditPunishInfo.setState(2);
		}else if("0".equals(auditRes)){//审核通过非终身有效
			noCreditPunishInfo.setState(1);
		}
		if (this.noCreditPunishInfoService.update(noCreditPunishInfo) > 0) {
			return AjaxResult.success("审核成功");
		}
		return AjaxResult.error("审核失败！");
	}
	
	/**
	 * 上传接口（兼容IE8）
	 * @param files
	 * @param batchNo
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
	public String uploadFile(@RequestParam(value = "btnFile") MultipartFile files, String batchNo, String fileName) {
		fileName = fileName.replaceAll("\\\\", "/");
		fileName = batchNo + "-" + fileName;
		files.getName();
		String result = null;
		if (cloudModel == null || cloudModel.equals("N")) {
			result = uploadToLoc(files, fileName);
		} else{
			result = uploadToOSS(files, fileName);
		} 
		return result;
	}
	
	/** 
	 * 描述: 根据身份证号获取列表
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping({ "/selectListByCerNO" })
	@ResponseBody
	public PageResponse<NoCreditPunishDetail> selectListByCerNO(PageRequest request) throws Exception {
		List<NoCreditPunishDetail> list = noCreditPunishInfoService.selectNoCreditPunishDetailListByCerNO(request);
		return new PageResponse<NoCreditPunishDetail>(list);
	}
	
	/**
	 * 从OSS上下载文件
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = { "/download" }, method = { RequestMethod.GET })
	public ResponseEntity<byte[]> download(String fileName) {
		if (cloudModel == null || cloudModel.equals("N")) {
			return downFromLoc(fileName);
		} else
			return downFormOSS(fileName);
	}
	
	/**
	 * 上传到OSS服务器
	 * @param files
	 * @param fileName
	 * @return
	 */
	private String uploadToOSS(MultipartFile files, String fileName) {
		boolean flag = false;
		try {
			flag = ossClient.putStream(files, "test/" + fileName);
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message: " + oe.getErrorMessage());
			System.out.println("Error Code: " + oe.getErrorCode());
			System.out.println("Request ID: " + oe.getRequestId());
			System.out.println("Host ID: " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Code: " + ce.getErrorCode());
			System.out.println("Error Message: " + ce.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			return "test/" + fileName;
		} else
			return "error";
	}
	
	/**
	 * 上传本地接口
	 * @param files
	 * @param fileName
	 * @return
	 */
	private String uploadToLoc(MultipartFile files, String fileName) {
		System.out.println("上传到本地开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			files.transferTo(targetFile);
			System.out.println("上传到本地结束");
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 从本地下载接口
	 * @param fileName
	 * @return
	 */
	private ResponseEntity<byte[]> downFromLoc(String fileName) {
		byte[] buffer = null;
		HttpHeaders headers = new HttpHeaders();
		try {
			System.out.println(fileName);
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			File file = new File(realPath + File.separator + fileName);
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
			// 处理响应
			int index = fileName.indexOf("-");
			fileName = fileName.substring(index + 1);
			if (request.getHeader("User-Agent").contains("MSIE") || request.getHeader("User-Agent").contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				// 非IE浏览器的处理
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 从OSS下载文件接口
	 * @param fileName
	 * @return
	 */
	private ResponseEntity<byte[]> downFormOSS(String fileName) {
		if (fileName == null || StringUtils.isBlank(fileName)) {
			return null;
		}
		try {
			HttpHeaders headers = new HttpHeaders();
			// 从OSS获取文件流
			byte[] by = null;
			by = ossClient.getStream(fileName);
			// 处理请求头
			int index = fileName.indexOf("-");
			fileName = fileName.substring(index + 1);
			if (request.getHeader("User-Agent").contains("MSIE") || request.getHeader("User-Agent").contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				// 非IE浏览器的处理
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(by, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 描述   删除
	 * @author 赵祥江
	 * @date 2017年8月27日 下午2:13:01 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult delete(String batchNo) throws Exception{
		try {
			if (com.icinfo.cs.common.utils.StringUtil.isNotBlank(batchNo)) {
				Map<String,Object> parms=new HashMap<String,Object>();
				parms.put("batchNo", batchNo);
				this.noCreditPunishInfoService.deleteNoCreditPunishInfoByBatchNo(batchNo);
				this.noCreditPunishDetailService.delete(parms);
				this.noCreditPunishBackService.delete(parms); 
				return AjaxResult.success("删除成功"); 
			}
		} catch (Exception e) {
			 e.printStackTrace();
		} 
		return  AjaxResult.error("删除失败");
	}
	
	
	/**
	 * 
	 * 描述   进入全景查询 页面
	 * @author 赵祥江
	 * @date 2017年10月30日 上午9:27:17 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/nocreditPunishSearchListPage")
	public ModelAndView nocreditPunishSearchListPage(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/search/nocreditpunishsearch/nocreditpunishsearch_list"); 
		view.addObject("sysDate",  DateUtil.getCurrentDate());
		return view;
	}
	
	/**
	 * 
	 * 描述   全景查询列表
	 * @author 赵祥江
	 * @date 2017年10月30日 上午9:29:23 
	 * @param 
	 * @return PageResponse<NoCreditPunishInfoDto>
	 * @throws
	 */
	@RequestMapping({ "/nocreditPunishSearch.json", "list.xml" })
	@ResponseBody
	public PageResponse<NoCreditPunishInfoDto> nocreditPunishSearch(PageRequest request, String type, HttpSession session) throws Exception {
		Map<String, Object> parms = request.getParams();
		if (parms == null) {
			parms = new HashMap<String, Object>();
		}
		if (type != null) {
			parms.put("type", type);
		}
		parms.put("exeEnd", DateUtil.getCurrentDate()); 
		List<NoCreditPunishInfoDto> dtos = this.noCreditPunishInfoService.selectAllFullInfoList(request, parms);
		return new PageResponse<NoCreditPunishInfoDto>(dtos);
	}
}