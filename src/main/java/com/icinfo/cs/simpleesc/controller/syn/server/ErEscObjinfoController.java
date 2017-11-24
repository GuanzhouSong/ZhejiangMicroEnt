/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.syn.server;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeObjection;
import com.icinfo.cs.base.service.ICodeObjectionService;
import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.dto.ErEscObjinfoDto;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.simpleesc.service.IErEscObjinfoService;
import com.icinfo.cs.simpleesc.util.DataExChange;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.cache.CacheTemplate;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: er_esc_objinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller("ServerErEscObjinfoController")
@RequestMapping("/syn/erescobjinfo")
public class ErEscObjinfoController extends CSBaseController {
	public static final String EXTYPEBYPERSON = "1";
	public static final String EXTYPEBYENT = "2";
	public static final String EXTYPEBYOTHERUNIT = "3";
	public static final String INSERTMETHOD = "insertObjinfo";
	@Autowired
	IErEscAppinfoService erEscAppinfoService;
	@Autowired
	CacheTemplate cacheTemplate;

	@Autowired
	IErEscObjinfoService erEscObjinfoService;

	@Value("${cloudModel}")
	private String cloudModel;

	@Autowired
	OssClient ossClient;

	@Autowired
	ICodeObjectionService codeObjectionService;

	@Autowired
	ISmsService smsService;

	@Autowired
	DataExChange dataExChange;
	
	@Autowired
	private ISysLogService sysLogService;
	//电话号码
	private String telPhone="";

	/**
	 * 
	 * 描述   进入详情页面
	 * @author 赵祥江
	 * @date 2017年2月22日 下午5:14:37 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/objectionDetail")
	public ModelAndView objectionDetail( String priPID) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/simpleesc/objection_detail");
 		ErEscAppinfoDto erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID); 
 		erEscAppinfo.setEncryPriPID(AESEUtil.encodeCorpid(priPID));
 		mav.addObject("sysUrl", "/syn");
 		mav.addObject("erEscAppinfo", erEscAppinfo);
		return mav;
	} 
	
	/**
	 * 
	 * 描述   查看全体投资人承诺书页面
	 * @author 赵祥江
	 * @date 2017年2月23日 上午10:58:42 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/findLetter")
	public ModelAndView findLetter(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/simpleesc/undertakingletter");
		mav.addObject("encryPriPID", encryPriPID);
		return mav;
	}
 
	
	/**
	 * 
	 * 描述   获取全体投资人承诺书图片流
	 * @author 赵祥江
	 * @date 2017年2月23日 上午10:59:09 
	 * @param 
	 * @return byte[]
	 * @throws
	 */
	@RequestMapping({ "/getLetter.json" })
	@ResponseBody
	public byte[] getLetter(@RequestParam String encryPriPID) throws Exception {
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ErEscAppinfoDto erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID);
		String commitment = erEscAppinfo.getCommitment();
		byte[] letter = null;
		if (!StringUtil.isEmpty(commitment)) {
			try {// 从OSS获取文件流
				letter = ossClient.getStream(commitment);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return letter;
	}

 
	
	/**
	 * 
	 * 描述   根据priPID查询异议信息JSON数据列表
	 * @author 赵祥江
	 * @date 2017年2月27日 上午11:13:33 
	 * @param 
	 * @return PageResponse<ErEscObjinfoDto>
	 * @throws
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<ErEscObjinfoDto> listJSON(PageRequest request) throws Exception {
		List<ErEscObjinfoDto> erEscObjinfoDtos = erEscObjinfoService.queryPageResult(request);
		return new PageResponse<ErEscObjinfoDto>(erEscObjinfoDtos);
	}
 
	
	/**
	 * 
	 * 描述   我要异议申请页面
	 * @author 赵祥江
	 * @date 2017年2月23日 上午11:14:38 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/objectionApply")
	public ModelAndView objectionApply(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("/syn/system/simpleesc/objection_apply");
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ErEscAppinfoDto erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID);
		erEscAppinfo.setEncryPriPID(encryPriPID);
		mav.addObject("erEscAppinfo", erEscAppinfo);

		// 查询异议内容编码表
		List<CodeObjection> codeObjections = codeObjectionService.findListResultAll();
		mav.addObject("codeObjections", codeObjections);
		return mav;
	}

	 
	
	/**
	 * @throws Exception 
	 * 
	 * 描述   提交异议信息(其他相关单位)
	 * @author 赵祥江
	 * @date 2017年2月23日 上午11:38:15 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/saveByOtherUnit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveByOtherUnit(@Valid @RequestBody ErEscObjinfoDto erEscObjinfo, BindingResult result,
			HttpSession session) throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}

		//Object acSimpleEscCode = session.getAttribute("synSimpleEscCode");
		Object acSimpleEscCode =cacheTemplate.get("synSimpleEscCode"+telPhone);
		if (acSimpleEscCode == null || !String.valueOf(acSimpleEscCode).equals(erEscObjinfo.getValidateCode())) {
			return AjaxResult.error("错误的验证码");
		}
		String objectionStr="";
		String objection= erEscObjinfo.getObjection();
		if(objection!=null&&!"".equals(objection)){
			String[] objectionArr= objection.split(",");
			if(objectionArr.length>0){
				for(int i=0;i<objectionArr.length;i++){
					CodeObjection codeObjections = codeObjectionService.findCodeObjectionByCode(objectionArr[i]);
				    if(codeObjections!=null){
				    	objectionStr+= codeObjections.getContent()+";";
				    }
				}
				objectionStr=objectionStr.substring(0, objectionStr.length()-1);
			}
		}
		if(com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty(erEscObjinfo.getOtherContent())){
			if(com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty(objectionStr)){
				objectionStr+=";"+erEscObjinfo.getOtherContent();
			}else{
				objectionStr=erEscObjinfo.getOtherContent();
			}
		}
		erEscObjinfo.setObjection(objectionStr);
		erEscObjinfo.setObjapptime(new Date());
		erEscObjinfo.setType("3");
		erEscObjinfo.setCreateTime(DateUtil.getSysDate());
		if(erEscObjinfo.getRegNO().length()==18){
			erEscObjinfo.setUniSCID(erEscObjinfo.getRegNO());
			erEscObjinfo.setRegNO(null);
		} 
		// 简易注销异议信息数据交换
		String returnRsult = null;
		if ("Y".equals(cloudModel)) {
			returnRsult = dataExChange.objectionExChange(erEscObjinfo, EXTYPEBYOTHERUNIT, INSERTMETHOD);
		}
		if (!StringUtil.isEmpty(returnRsult) && returnRsult.contains("sucess")) {
			int i = erEscObjinfoService.saveErEscObjinfo(erEscObjinfo);
			if (i >= 0) {
				return AjaxResult.success("1", "其他相关单位异议信息提交成功.");
			} else {
				return AjaxResult.error("-1", "其他相关单位异议信息提交失败.");
			}
		} else {
			return AjaxResult.error("-1", "其他相关单位异议信息提交失败.");
		}
	}

	 
	/**
	 * 
	 * 描述   上传接口（兼容IE8）
	 * @author 赵祥江
	 * @date 2017年2月23日 上午11:28:01 
	 * @param 
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "btnFile") MultipartFile file, String prefix) {
		String fileName = prefix + file.getOriginalFilename();
		String result = null;
		if ("Y".equals(cloudModel)) {
			result = uploadToOSS(file, fileName);
		} else {
			// result = uploadToLoc(files, fileName);
		}
		return result;
	} 
	 
	
	/**
	 * 
	 * 描述   上传到OSS服务器
	 * @author 赵祥江
	 * @date 2017年2月23日 上午11:37:53 
	 * @param 
	 * @return String
	 * @throws
	 */
	private String uploadToOSS(MultipartFile file, String fileName) {
		boolean flag = false;
		try {
			flag = ossClient.putStream(file, "simpleesc/objection/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return "update error";
		}
		if (flag) {
			return "simpleesc/objection/" + fileName;
		} else {
			return "update error";
		}
	}

	
	/**
	 * 
	 * 描述   获取验证码，发送短信
	 * @author 赵祥江
	 * @date 2017年2月27日 上午11:13:13 
	 * @param 
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/getMessageCode", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getMessageCode(HttpSession session, String tel, String district,String entName) throws Exception {
		try {
			telPhone=tel;
			String code = String.valueOf(StringUtil.NextInt(100000, 999999));
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
			cacheTemplate.set("synSimpleEscCode"+telPhone, code, 24*60*60);
			// 短信验证码存session中
			//session.setAttribute("synSimpleEscCode", code);
			//String message = "简易注销验证码为：" + code;
			String message = "您正在对" + entName + "公司的简易注销信息提出异议，验证码" + code + "，24小时内有效。";
			System.out.println(message);
			//System.out.println(cacheTemplate.get("synSimpleEscCode"));
			//保存日志
			saveLog(sysUser,code);
			smsService.doSendMsg(tel, message, district); 
			return AjaxResult.success("获取验证码成功", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AjaxResult.error("获取验证码失败", null);
	}
	
	 /**
	  * 
	  * 描述   保存日志
	  * @author 赵祥江
	  * @date 2017年2月27日 上午11:14:08 
	  * @param 
	  * @return void
	  * @throws
	  */
	 private void saveLog(SysUserDto sysUser, String code){
	        try{
	        	Map<String,String> logMap=new HashMap<String,String>();
	            logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SYN);//协同系统
	            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());//年份
	            logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID, null);
	            logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME, null);
	            logMap.put(ISysLogService.LOG_MAP_KEY_REGNO, null);
	            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG,"用户名:"+sysUser.getUsername()+"在协同系统其他部门简易注销异议获取的验证码为:"+code);
	            logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.synSimpleescLog.getCode());//操作类型
	            sysLogService.doAddSysLog(logMap,getRequest());
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	    }

}