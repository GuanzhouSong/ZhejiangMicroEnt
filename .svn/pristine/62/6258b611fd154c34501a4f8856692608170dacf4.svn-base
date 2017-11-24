/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sendaffairs.controller.syn;
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
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.icinfo.cs.batch.service.IBatchService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.copysend.dto.CopySendDto;
import com.icinfo.cs.copysend.dto.CopySendFeedbackDto;
import com.icinfo.cs.copysend.model.CopySendFeedback;
import com.icinfo.cs.copysend.model.CopySendIllegal;
import com.icinfo.cs.copysend.service.ICopySendFeedbackService;
import com.icinfo.cs.copysend.service.ICopySendIllegalService;
import com.icinfo.cs.copysend.service.ICopySendService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_copy_send 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller
@RequestMapping({"/syn/sendaffairs/","/reg/server/sendaffairs/"})
public class SendAffairsController extends BaseController {
	@Autowired
	private ICopySendService copySendService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICopySendIllegalService copySendIllegalService;
	@Autowired
	private IBatchService batchService;
	@Autowired
	private ICopySendFeedbackService copySendFeedbackService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private OssClient ossClient;
	
	@Value("${cloudModel}")
	private String cloudModel;
	  /**
     * 进入抄告抄送页面
     * @author ylr
     * @date 2016-10-20
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnCopySend")
	public ModelAndView doEnCopySend(String realtab,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_main");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtils.isBlank(realtab))
			realtab = "send";
		
		mv.addObject("realtab", realtab);
		mv.addObject("sysUser", sysUser);
		return mv;
	}
	
	  /**
     * 进入抄告抄送审核页面
     * @author ylr
     * @date 2016-11-7
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnSend")
	public ModelAndView doEnSend(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_send");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		return mv;
	}
	
	  /**
     * 进入抄告抄送打印页面
     * @author ylr
     * @date 2016-11-7
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnPrint")
	public ModelAndView doEnPrint(CopySendDto copySendDto) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_print");
		return mv;
	}
	
	  /**
     * 进入抄告抄送接收反馈页面
     * @author ylr
     * @date 2016-11-7
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnAccept")
	public ModelAndView doEnAccept(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_accept");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		return mv;
	}
	
	/**
	 * 描述：进入无证无照涉嫌违法事项选择页面
	 * 
	 * @author ylr
	 * @date 2016年11月4日
	 * @throws Exception
	 */
	@RequestMapping("doEnNocardItem")
	public ModelAndView doEnNocardItem(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("syn/system/syncsupervise/sendaffairs/cgcs_nocarditem");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		return mv;
	}
	
	/**
	 * 描述：进入抄告抄送查看页面
	 * 
	 * @author ylr
	 * @date 2016年11月15日
	 * @throws Exception
	 */
	@RequestMapping("doEnSendView")
	public ModelAndView doEnSendView(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("syn/system/syncsupervise/sendaffairs/cgcs_view");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		return mv;
	}
	
	  /**
     * 获取抄告页面统计
     * @author chenyu
     * @date 2016-10-23
     *
     */
	@RequestMapping("doGetSendCount")
	@ResponseBody
	public AjaxResult doGetSendCount(HttpSession session) throws Exception{
		Map<String, Object> qryMap = new HashMap<>();
		SysUserDto sysUser = (SysUserDto)session.getAttribute(Constants.SESSION_SYS_USER);
		qryMap.put("userType", sysUser.getUserType());
		if("1".equals(sysUser.getUserType())){//警示
			qryMap.put("departCode", sysUser.getDeptCode());
		}else{//协同
			qryMap.put("departCode", sysUser.getSysDepart().getAdcode());
			qryMap.put("dutyDeptCodes", sysUser.getDutyDeptCodes());
		}
		Map<String, Object> maps = copySendService.getParams(qryMap);
		return AjaxResult.success("成功！", maps);
	}
	  /**
     * 获取接收页面统计
     * @author chenyu
     * @date 2016-10-23
     */
	@RequestMapping("doGetAcceptCount")
	@ResponseBody
	public AjaxResult doGetAcceptCount(HttpSession session) throws Exception{
		Map<String, Object> qryMap = new HashMap<>();
		SysUserDto sysUser = (SysUserDto)session.getAttribute(Constants.SESSION_SYS_USER);
		qryMap.put("userType", sysUser.getUserType());
		if("1".equals(sysUser.getUserType())){//警示
			qryMap.put("departCode", sysUser.getDeptCode());
		}else{//协同
			qryMap.put("departCode", sysUser.getSysDepart().getAdcode());
			qryMap.put("dutyDeptCodes", sysUser.getDutyDeptCodes());
		}
		Map<String, Object> maps = copySendService.getParams(qryMap);
		return AjaxResult.success("成功！", maps);
	}
	  /**
     * 进入抄告页面
     * @author ylr
     * @date 2016-10-20
     * @return ModelAndView
     *
     */
	@RequestMapping("doAddCopySend")
	public ModelAndView doAddCopySend(HttpSession  session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		mv.addObject("date", DateUtil.dateToString(new Date(), "yyyy年MM月dd日"));
		return mv;
	}
	
	 /**
     * 加载列表信息
     * @author chenyu
     * @date 2016-10-23
     * @return ModelAndView
     *
     */
	@RequestMapping({"send/list.json","list.xml"})
	@ResponseBody
	public PageResponse<CopySendDto> sendListJSON(HttpSession session,PageRequest request) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CopySendDto> data = copySendService.queryPage(request,sysUser);
		return new PageResponse<CopySendDto>(data);
	}
	
	/**
     * 加载列表信息
     * @author chenyu
     * @date 2016-10-23
     * @return ModelAndView
     *
     */
	@RequestMapping({"accept/list.json","list.xml"})
	@ResponseBody
	public PageResponse<CopySendDto> acceptListJSON(HttpSession session,PageRequest request) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CopySendDto> data = copySendService.doGetAcceptListJSON(request,sysUser);
		return new PageResponse<CopySendDto>(data);
	}
	 /**
     * 进入抄告页面
     * @author ylr
     * @date 2016-10-20
     * @return ModelAndView
     *
     */
	@RequestMapping("addIllegal")
	public ModelAndView addIllegal(String state,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_check_out");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		mv.addObject("state", state);
		return mv;
	}
	 /**
     * 进入部门树页面
     * @author ylr
     * @date 2016-10-25
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnDepartTree")
	public ModelAndView doEnDepartTree(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/departtree");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		
		mv.addObject("sysUser", sysUser);
		return mv;
	}
	
	 /**
     * 进入抄告抄送反馈页面
     * @author ylr
     * @date 2016-10-25
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnFeedback")
	public ModelAndView doEnFeedback(HttpSession session,String copyFormNo) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_fk");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("copyFormNo", copyFormNo);
		CopySendDto copySendDto = copySendService.selectCopySend(qryMap);
		List<CopySendIllegal> copySendIllegalList = copySendIllegalService.selectIllegalListByCopyFormNo(copyFormNo);

		// 获取附件路径
		String files = copySendDto.getEvidenceData();
		if (files != null && !files.isEmpty()) {
			mv.addObject("files", files.split("\\|"));
		}
		mv.addObject("sysUser", sysUser);
		mv.addObject("copySendDto", copySendDto);
		mv.addObject("copySendIllegalList", copySendIllegalList);
		return mv;
	}
	
	 /**
     * 进入抄告抄送查看页面
     * @author ylr
     * @date 2016-10-30
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnRefer")
	public ModelAndView doEnRefer(HttpSession session,String copyFormNo) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_cy");
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("copyFormNo", copyFormNo);
		CopySendDto copySendDto = copySendService.selectCopySend(qryMap);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CopySendIllegal> copySendIllegalList = copySendIllegalService.selectIllegalListByCopyFormNo(copyFormNo);
		
		//查看反馈信息
		List<CopySendFeedbackDto> copySendFeedbackList = copySendFeedbackService.selectCopySendFeedbackList(copyFormNo);
		
		// 获取附件路径
		String files = copySendDto.getEvidenceData();
		if (files != null && !files.isEmpty()) {
			mv.addObject("files", files.split("\\|"));
		}
		mv.addObject("copySendDto", copySendDto);
		mv.addObject("sysUser", sysUser);
		mv.addObject("copySendIllegalList", copySendIllegalList);
		mv.addObject("copySendFeedbackList", copySendFeedbackList);
		return mv;
	}
	
	 /**
     * 进入抄告抄送修改页面
     * @author ylr
     * @date 2016-10-31
     * @return ModelAndView
     *
     */
	@RequestMapping("doEnEdit")
	public ModelAndView doEnEdit(HttpSession session,String copyFormNo) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_edit");
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("copyFormNo", copyFormNo);
		CopySendDto copySendDto = copySendService.selectCopySend(qryMap);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CopySendIllegal> copySendIllegalList = copySendIllegalService.selectIllegalListByCopyFormNo(copyFormNo);

		// 获取附件路径
		String files = copySendDto.getEvidenceData();
		if (files != null && !files.isEmpty()) {
			mv.addObject("files", files.split("\\|"));
		}
		mv.addObject("copySendDto", copySendDto);
		mv.addObject("sysUser", sysUser);
		mv.addObject("copySendIllegalList", copySendIllegalList);
		return mv;
	}
	
	 /**
     * 抄告抄送修改
     * @author ylr
     * @date 2016-10-31
     * @return ModelAndView
     *
     */
	@RequestMapping("doEdit" )
	@ResponseBody
	@RepeatSubmit(timeout=1000)
	public AjaxResult doEdit(@RequestBody CopySendDto copySendDto) throws Exception{
		String detailJson = StringEscapeUtils.unescapeHtml(copySendDto.getIllegalStr());//涉嫌违法当事人信息
		JSONArray array = JSONArray.fromObject(detailJson);
		if (array.size() == 0) {
			return AjaxResult.error("请添加涉嫌违法当事人信息！");
		}
		//先根据批次号删除涉嫌违法当事人
		copySendIllegalService.deleteByCopyFormNo(copySendDto.getCopyFormNo());
		//重新插入涉嫌违法当事人信息
		if(insertCopySendIllegalList(array,copySendDto.getCopyFormNo())){
			return AjaxResult.error("保存涉嫌违法当事人失败");
		}
		copySendDto.setCopyOptDate(new Date());
		copySendDto.setCopyState(Constants.CGCS_STATE_DSH);
		//更新抄告抄送主表信息
		if(copySendService.update(copySendDto)<0){
			return AjaxResult.error("修改失败！");
		}
		return AjaxResult.success("修改成功！");
	}
	
	
	
	/**
     * 保存反馈信息
     * @author ylr
     * @date 2016-10-30
     * @return ModelAndView
     *
     */
	@RequestMapping(value = "saveFeedback", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveFeedback(@RequestBody CopySendFeedback copySendFeedback,HttpSession session) throws Exception{
		copySendFeedback.setFeedbackTime(new Date());
		copySendFeedback.setState(1);//设置已反馈状态
		if(copySendFeedbackService.updateByCopyFormNoAndDeptCode(copySendFeedback,session)<0){
			AjaxResult.error("反馈失败！");
		}
		//根据反馈状态更新抄告状态
		Boolean flag = true;
		List<CopySendFeedbackDto> copySendFeedbackList = copySendFeedbackService.selectCopySendFeedbackList(copySendFeedback.getCopyFormNo());
		for(CopySendFeedbackDto copySendFeedbackDto:copySendFeedbackList){
			if(copySendFeedbackDto.getState() == 0){//拥有未反馈
				flag = false;
				break;
			}
		}
		//所有抄告都已经反馈完成
		if(flag){
			CopySendDto copySendDto = new CopySendDto();
			copySendDto.setCopyFormNo(copySendFeedback.getCopyFormNo());
			copySendDto.setCopyState(Constants.CGCS_STATE_YCGFKWC);//已抄告反馈完成
			copySendService.update(copySendDto);
		}
		return AjaxResult.success("成功反馈！");
	}
	
	
	
	 /**
     * 进入抄告抄送审核页面
     * @author ylr
     * @date 2016-10-27
     * @return ModelAndView
     *
     */
	@RequestMapping("doReview")
	public ModelAndView doReview(String copyFormNo,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/syn/system/syncsupervise/sendaffairs/cgcs_sh");
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("copyFormNo", copyFormNo);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		CopySendDto copySendDto = copySendService.selectCopySend(qryMap);
		List<CopySendIllegal> copySendIllegalList = copySendIllegalService.selectIllegalListByCopyFormNo(copyFormNo);
		
		mv.addObject("copySendDto", copySendDto);
		// 获取附件路径
		String files = copySendDto.getEvidenceData();
		if (files != null && !files.isEmpty()) {
			mv.addObject("files", files.split("\\|"));
		}
		mv.addObject("sysUser", sysUser);
		mv.addObject("date",  DateUtil.dateToString(new Date(), "yyyy年MM月dd日"));
		mv.addObject("copySendIllegalList", copySendIllegalList);
		return mv;
	}
	
	
	 /**
     * 根据企业名称获取数据
     * @author ylr
     * @date 2016-10-21
     * @return ModelAndView
     *
     */
	@RequestMapping(value = "getEnt", method = RequestMethod.POST)
	@ResponseBody
	public MidBaseInfo getEnt(String entName) throws Exception{
		return midBaseInfoService.selectEntByEntName(entName);
	}
	 /**
     * 获取当前用户部门编码
     * @author chenyu
     * @date 2016-10-23
     * @return ModelAndView
     *
     */
	private String getUserDepartCode(HttpSession session){
		SysUserDto sysUser = (SysUserDto)session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = null;
		if("1".equals(sysUser.getUserType())){//警示
			deptCode = sysUser.getDeptCode();
		}else{//协同
			deptCode = sysUser.getSysDepart().getAdcode();
		}
		return deptCode;
	}
	
	
	 /**
     * 保存抄告抄送信息
     * @author ylr
     * @date 2016-10-23
     * @return ModelAndView
     *
     */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=1000)
	public AjaxResult save(@Valid CopySendDto copySendDto, BindingResult result,HttpSession session) throws Exception{
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("请检查填写内容有无遗漏");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}
		String detailJson = StringEscapeUtils.unescapeHtml(copySendDto.getIllegalStr());//涉嫌违法当事人信息
		SysUserDto sysUser = (SysUserDto)session.getAttribute("session_sys_user");
		
		JSONArray array = JSONArray.fromObject(detailJson);
		if (array.size() == 0) {
			return AjaxResult.error("请添加涉嫌违法当事人信息！");
		}
		
		copySendDto = doGetCopyFormNo(copySendDto,sysUser);//获取抄告抄送编号
		
		if(copySendService.insert(getCopySendDto(copySendDto,Constants.CGCS_STATE_DSH))<0){
			return AjaxResult.error("新增抄告抄送失败！");
		}
		
		if(insertCopySendIllegalList(array,copySendDto.getCopyFormNo())){
			return AjaxResult.error("保存涉嫌违法当事人失败");
		}
		
		
		return AjaxResult.success("新增抄告抄送成功！");
	}
	
	
	
	 /**
     * 抄告抄送审核保存
     * @author ylr
     * @date 2016-10-23
     * @return ModelAndView
     *
     */
	@RequestMapping(value = "saveReview", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=1000)
	public AjaxResult saveReview(@RequestBody CopySendDto copySendDto) throws Exception{
		String detailJson = StringEscapeUtils.unescapeHtml(copySendDto.getIllegalStr());//涉嫌违法当事人信息
		JSONArray array = JSONArray.fromObject(detailJson);
		if (array.size() == 0) {
			return AjaxResult.error("请添加涉嫌违法当事人信息！");
		}
		//先根据批次号删除涉嫌违法当事人
		copySendIllegalService.deleteByCopyFormNo(copySendDto.getCopyFormNo());
		
		//重新插入涉嫌违法当事人信息
		if(insertCopySendIllegalList(array,copySendDto.getCopyFormNo())){
			return AjaxResult.error("保存涉嫌违法当事人失败");
		}
		//重新插入抄送部门反馈表数据
		if("0".equals(copySendDto.getCheckResult()) && //审核通过才向反馈表插入数据
				insertCopySendFeedbackList(copySendDto.getAcceptDeptCodes(),copySendDto.getCopyFormNo())){
			return AjaxResult.error("审核失败");
		}
		
		copySendDto.setCheckDate(new Date());
		copySendDto.setCopyOptDate(new Date());
		copySendDto.setCopyState(getReviewState(copySendDto.getCheckResult(),copySendDto.getFeedbackNeed()));
		//更新抄告抄送主表信息
		if(copySendService.update(copySendDto)<0){
			return AjaxResult.success("审核失败！");
		}
		
		
		return AjaxResult.success("审核成功！");
	}
	
	 /**
     * 涉嫌违法当事人插入数据
     * @author ylr
     * @date 2016-10-26
     */
	public Boolean insertCopySendIllegalList(JSONArray array,String batchNo) throws Exception{
		Boolean flag = false;
		for(int i=0;i<array.size();i++){
			JSONObject object = array.getJSONObject(i);
			CopySendIllegal copySendIllegal = new CopySendIllegal();
			copySendIllegal.setClientName(object.getString("entName"));
			copySendIllegal.setCertType(object.getString("certType"));
			copySendIllegal.setCertNo(object.getString("certNo"));
			copySendIllegal.setAddress(object.getString("address"));
			copySendIllegal.setClientTel(object.getString("clientTel"));
			copySendIllegal.setCopyFormNo(batchNo);
			copySendIllegal.setCreateTime(new Date());
			if(copySendIllegalService.insert(copySendIllegal)<0){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	 /**
     * 抄告抄送接收部门插入数据
     * @author ylr
     * @date 2016-10-26
     */
	public Boolean insertCopySendFeedbackList(String deptCodes,String batchNo) throws Exception{
		Boolean flag = false;
		String deptCode[] = deptCodes.split(",");
		for(int i=0;i<deptCode.length;i++){
			CopySendFeedback copySendFeedback = new CopySendFeedback();
			copySendFeedback.setCopyFormNo(batchNo);
			copySendFeedback.setState(0);//设置未反馈
			copySendFeedback.setAcceptDepartCode(deptCode[i]);
			if(copySendFeedbackService.insert(copySendFeedback)<0){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	
	 /**
     * 构建抄告抄送实体bean
     * @author ylr
     * @date 2016-10-23
     */
	public CopySendDto getCopySendDto(CopySendDto copySendDto,String copyState) throws Exception{
		copySendDto.setCopyState(copyState);
		copySendDto.setCopyDate(new Date());
		copySendDto.setCreateTime(new Date());
		return copySendDto;
	}
	
	 /**
     * 获取审核状态
     * @author ylr
     * @date 2016-10-28
     */
	public String getReviewState(String state,Integer feedBackNeed) throws Exception{
		if("0".equals(state)&&feedBackNeed==0)//同意抄送-需要反馈
			return Constants.CGCS_STATE_YCGFKZ;
		if("0".equals(state)&&feedBackNeed==1)//同意抄送-不需要反馈
			return Constants.CGCS_STATE_YCGWC;
		if("1".equals(state))//不抄送
			return Constants.CGCS_STATE_QXCG;
		if("2".equals(state))//退回修改
			return Constants.CGCS_STATE_YSHTH;
		return "";
	}
	
	/**
     * 获取抄告抄送编号
     * @author ylr
     * @date 2016-11-22
     */
	public CopySendDto doGetCopyFormNo(CopySendDto copySendDto,SysUserDto sysUser) throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("year", DateUtil.getCurrentYear());
		qryMap.put("copyDepartCode", copySendDto.getCopyDepartCode());
		if("1".equals(sysUser.getUserType())){//警示
			qryMap.put("userType",1);	
		}else{
			qryMap.put("userType",2);
			qryMap.put("dutyDeptCodes", sysUser.getDutyDeptCodes());
		}
		CopySendDto dto = copySendService.getMaxCopyFormNo(qryMap);
		copySendDto.setYear(Integer.parseInt(DateUtil.getCurrentYear()));
		if(dto == null){
			copySendDto.setCopyNo(1);
		}else{
			copySendDto.setCopyNo(dto.getCopyNo()+1);
		}
		copySendDto.setCopyFormNo(copySendDto.getCopyDepartName()+"("+copySendDto.getYear()+")"+copySendDto.getCopyNo()+"号");
		return copySendDto;
	}
	
	/**
	 * 上传接口（兼容IE8）
	 * @param files
	 * @param batchNo
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
	public String upload(@RequestParam(value = "btnFile") MultipartFile files, String batchNo, String fileName) {
		fileName = fileName.replaceAll("\\\\", "/");
		fileName = batchNo + "-" + fileName;
		String result = null;
		if (cloudModel == null || cloudModel.equals("N")) {
			result = uploadToLoc(files, fileName);
		} else
			result = uploadToOSS(files, fileName);
		return result;
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
	
	
}