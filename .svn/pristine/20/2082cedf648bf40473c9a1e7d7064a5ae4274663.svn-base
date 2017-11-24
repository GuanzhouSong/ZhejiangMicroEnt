/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.controller.pub;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
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
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.dto.ErEscObjinfoDto;
import com.icinfo.cs.simpleesc.dto.ErEscScrinfoDto;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.cs.simpleesc.service.IErEscObjinfoService;
import com.icinfo.cs.simpleesc.service.IErEscScrinfoService;
import com.icinfo.cs.simpleesc.util.DataExChange;
import com.icinfo.framework.cache.CacheTemplate;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: er_esc_objinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller
@RequestMapping("pub/simpleesc/erescobjinfo")
public class ErEscObjinfoController extends BaseController {
	public static final String EXTYPEBYPERSON = "1";
	public static final String EXTYPEBYENT = "2";
	public static final String EXTYPEBYOTHERUNIT = "3";
	public static final String INSERTMETHOD = "insertObjinfo";
	@Autowired
	IErEscAppinfoService erEscAppinfoService;

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

	@Resource
	CacheTemplate<String, Object> gsCloudCacheTemplate;
	
	@Autowired
	IErEscScrinfoService erEscScrinfoService;

	/**
	 * 描述：我要异议详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param encryPriPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("objectionDetail")
	public ModelAndView objectionDetail(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/simpleesc/objection_detail");
		String priPID = AESEUtil.decodeCorpid(encryPriPID);
		ErEscAppinfoDto erEscAppinfo = erEscAppinfoService.getErEscAppinfoByPriPID(priPID);
		erEscAppinfo.setEncryPriPID(encryPriPID);
		if (erEscAppinfo.getNoticeTo() != null && erEscAppinfo.getNoticeTo().getTime() > new Date().getTime()) {
			mav.addObject("objectionFlag", 1);// 我要异议标记
		}
		mav.addObject("erEscAppinfo", erEscAppinfo);
		
		//查询简易注销结果信息
		ErEscScrinfoDto erEscScrinfo = erEscScrinfoService.getErEscScByPriPID(priPID);
		mav.addObject("erEscScrinfo", erEscScrinfo);
		return mav;
	}

	/**
	 * 描述：查看全体投资人承诺书页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月16日
	 * @param encryPriPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findLetter")
	public ModelAndView findLetter(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/simpleesc/undertakingletter");
		mav.addObject("encryPriPID", encryPriPID);
		return mav;
	}

	/**
	 * 描述：获取全体投资人承诺书图片流
	 * 
	 * @author baifangfang
	 * @date 2017年2月16日
	 * @param encryPriPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "getLetter.json" })
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
	 * 描述：根据priPID查询异议信息JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<ErEscObjinfoDto> listJSON(PageRequest request) throws Exception {
		List<ErEscObjinfoDto> erEscObjinfoDtos = erEscObjinfoService.queryPageResult(request);
		return new PageResponse<ErEscObjinfoDto>(erEscObjinfoDtos);
	}

	/**
	 * 描述：我要异议申请页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月14日
	 * @param encryPriPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("objectionApply")
	public ModelAndView objectionApply(@RequestParam String encryPriPID) throws Exception {
		ModelAndView mav = new ModelAndView("pub/simpleesc/objection_apply");
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
	 * 描述：提交异议信息(自然人)
	 * 
	 * @author baifangfang
	 * @date 2017年2月14日
	 * @param erEscObjinfo
	 * @param result
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveByPerson", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveByPerson(@Valid @RequestBody ErEscObjinfoDto erEscObjinfo, BindingResult result)
			throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}

		Object acSimpleEscCode = gsCloudCacheTemplate.get("simpleEscCode" + erEscObjinfo.getMobTel());
		if (acSimpleEscCode == null || !String.valueOf(acSimpleEscCode).equals(erEscObjinfo.getValidateCode())) {
			return AjaxResult.success("错误的验证码.");
		}
		erEscObjinfo.setObjapptime(new Date());
		erEscObjinfo.setType("1");

		// 简易注销异议信息数据交换
		String returnResult = null;
		if ("Y".equals(cloudModel)) {
			returnResult = dataExChange.objectionExChange(erEscObjinfo, EXTYPEBYPERSON, INSERTMETHOD);
		}
		if (!StringUtil.isEmpty(returnResult) && returnResult.contains("sucess")) {
			int i = erEscObjinfoService.saveErEscObjinfo(erEscObjinfo);
			if (i >= 0) {
				return AjaxResult.success("自然人异议信息提交成功.");
			} else {
				return AjaxResult.error("-1", "自然人异议信息提交失败.");
			}
		} else {
			return AjaxResult.error("-1", "自然人异议信息提交失败.");
		}
	}

	/**
	 * 描述：提交异议信息(企业)
	 * 
	 * @author baifangfang
	 * @date 2017年2月14日
	 * @param erEscObjinfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveByEnt", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveByEnt(@Valid @RequestBody ErEscObjinfoDto erEscObjinfo, BindingResult result)
			throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}

		Object acSimpleEscCode = gsCloudCacheTemplate.get("simpleEscCode" + erEscObjinfo.getMobTel());
		if (acSimpleEscCode == null || !String.valueOf(acSimpleEscCode).equals(erEscObjinfo.getValidateCode())) {
			return AjaxResult.error("错误的验证码.");
		}
		erEscObjinfo.setObjapptime(new Date());
		erEscObjinfo.setType("2");

		// 简易注销异议信息数据交换
		String returnRsult = null;
		if ("Y".equals(cloudModel)) {
			returnRsult = dataExChange.objectionExChange(erEscObjinfo, EXTYPEBYENT, INSERTMETHOD);
		}
		if (!StringUtil.isEmpty(returnRsult) && returnRsult.contains("sucess")) {
			int i = erEscObjinfoService.saveErEscObjinfo(erEscObjinfo);
			if (i >= 0) {
				return AjaxResult.success("企业异议信息提交成功.");
			} else {
				return AjaxResult.error("-1", "企业异议信息提交失败.");
			}
		} else {
			return AjaxResult.error("-1", "企业异议信息提交失败.");
		}
	}

	/**
	 * 描述：提交异议信息(其他相关单位)
	 * 
	 * @author baifangfang
	 * @date 2017年2月14日
	 * @param erEscObjinfo
	 * @param result
	 * @return
	 * @throws Exception
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "saveByOtherUnit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveByOtherUnit(@Valid @RequestBody ErEscObjinfoDto erEscObjinfo, BindingResult result)
			throws Exception {
		if (result.hasErrors()) {
			// 参数验证错误
			AjaxResult error = AjaxResult.error("参数验证错误");
			error.addErrorInfo(result.getAllErrors());
			return error;
		}

		Object acSimpleEscCode = gsCloudCacheTemplate.get("simpleEscCode" + erEscObjinfo.getMobTel());
		if (acSimpleEscCode == null || !String.valueOf(acSimpleEscCode).equals(erEscObjinfo.getValidateCode())) {
			return AjaxResult.error("错误的验证码.");
		}
		erEscObjinfo.setObjapptime(new Date());
		erEscObjinfo.setType("3");
		String objection;
		if (!StringUtil.isEmpty(erEscObjinfo.getObjection())) {
			objection = erEscObjinfo.getObjection() + ";" + erEscObjinfo.getOtherContent();
		} else {
			objection = erEscObjinfo.getOtherContent();
		}
		erEscObjinfo.setObjection(objection);
		// 简易注销异议信息数据交换
		String returnRsult = null;
		if ("Y".equals(cloudModel)) {
			returnRsult = dataExChange.objectionExChange(erEscObjinfo, EXTYPEBYOTHERUNIT, INSERTMETHOD);
		}
		if (!StringUtil.isEmpty(returnRsult) && returnRsult.contains("sucess")) {
			int i = erEscObjinfoService.saveErEscObjinfo(erEscObjinfo);
			if (i >= 0) {
				return AjaxResult.success("其他相关单位异议信息提交成功.");
			} else {
				return AjaxResult.error("-1", "其他相关单位异议信息提交失败.");
			}
		} else {
			return AjaxResult.error("-1", "其他相关单位异议信息提交失败.");
		}
	}

	/**
	 * 描述：上传接口（兼容IE8）
	 * 
	 * @author baifangfang
	 * @date 2017年2月14日
	 * @param file
	 * @param prefix
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "btnFile") MultipartFile file, String prefix, String suffix) {
		String fileName = prefix + "." + suffix;
		String result = null;
		if ("Y".equals(cloudModel)) {
			result = uploadToOSS(file, fileName);
		} else {
			// result = uploadToLoc(files, fileName);
		}
		return result;
	}

	/**
	 * 上传到OSS服务器
	 * 
	 * @param files
	 * @param fileName
	 * @return
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
	 * 描述：获取验证码，发送短信
	 * 
	 * @author baifangfang
	 * @date 2017年2月14日
	 * @param tel
	 * @param district
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getMsgCode", method = RequestMethod.GET)
	@ResponseBody
	public String getMsgCode(String tel, String district, String entName) throws Exception {
		String code = String.valueOf(StringUtil.NextInt(100000, 999999));
		gsCloudCacheTemplate.set("simpleEscCode" + tel, code, 24 * 60 * 60);

		String message = "您正在对" + entName + "公司的简易注销信息提出异议，验证码" + code + "，24小时内有效。";
		System.out.println(message);
		smsService.doSendMsg(tel, message, district);
		return code;
	}

}