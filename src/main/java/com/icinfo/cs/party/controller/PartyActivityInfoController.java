/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.party.dto.PartyActivityInfoDto;
import com.icinfo.cs.party.model.PartyActivityInfo;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.party.service.IPartyActivityInfoService;
import com.icinfo.cs.party.service.IPartyOrganizeInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_party_activity_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月04日
 */
@Controller
@RequestMapping("/reg/server/party/partyactivityinfo/")
public class PartyActivityInfoController extends BaseController {
	
	@Autowired
	private IPartyActivityInfoService partyActivityInfoService ;
	@Autowired
	private IPartyOrganizeInfoService partyOrganizeInfoService ;
	@Autowired
	private OssClient ossClient;
	@Autowired
	private  HttpServletRequest request;
	
	@Value("${cloudModel}")
	private String cloudModel;
	
	/**
	 * 
	 * 描述: 进入党建活动信息录入（查询页）
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("inputlist")
	public ModelAndView inputlist() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partactivity/activityinput_list");
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入党建活动信息录入（查询列表）
	 * @auther gaojinling
	 * @date 2017年9月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "inputlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<PartyActivityInfoDto> pubOpadetailMoveListJSON(PageRequest request) throws Exception {
		List<PartyActivityInfoDto> data = partyActivityInfoService.selectPartyActivityInfoList(request);
		return new PageResponse<PartyActivityInfoDto>(data);
	}
	
	/**
	 * 
	 * 描述: 党建活动信息查询处统计
	 * @auther gaojinling
	 * @date 2017年9月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchCount",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchListCount(PageRequest request) throws Exception {
		Map<String, Object> map = request.getParams();
		if(map !=null){
			//查询时条件处理
			if(map.get("claimLocalAdm") !=null){  //管辖单位
				map.put("claimLocalAdm", StringUtil.doSplitStringToSqlFormat(map.get("claimLocalAdm").toString(),","));
			}
			if(map.get("joinerIds") !=null){  //管辖单位
				map.put("joinerIds", StringUtil.doSplitStringToSqlFormat(map.get("joinerIds").toString(),","));
			}
		}else{
			map = new HashMap<String, Object>();
		}
		int count = 0;
		try {
			count = partyActivityInfoService.selectActivityJoinerSum(map);
		} catch (Exception e) {
			return AjaxResult.error("查询失败");
		}
		return AjaxResult.success("查询成功", count);
	}
	
	
	
	/**
	 * 
	 * 描述: 党建活动信息录入（新增页）
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addPartyActivityInfo")
	public ModelAndView addPartyActivityInfo(String inputState) throws Exception {
		SysUserDto sysUser = (SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partactivity/activityinput_add");
		view.addObject("sysUser",sysUser);
		view.addObject("inputState", inputState);
		return view;
	}
	


	/**
	 * 
	 * 描述: 新增党建活动
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param bulletins
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(PartyActivityInfo partyActivityInfo) throws Exception{
		partyActivityInfo.setCreateTime(new Date());
		try {
			if(StringUtils.isEmpty(partyActivityInfo.getUID())){//新增
				partyActivityInfo.setInputDate(new Date());
				//处理接收部门对应的管辖单位
				PartyOrganizeInfo partyOrganizeInfo = partyOrganizeInfoService.doGetOrganizeInfoByUid(StringUtils.isEmpty(partyActivityInfo.getClaimDeptUID()) ? "00000" : partyActivityInfo.getClaimDeptUID());
				if(partyOrganizeInfo != null){ 
					partyActivityInfo.setClaimLocalAdm(partyOrganizeInfo.getLocalAdm());
					partyActivityInfo.setClaimLocalAdmName(partyOrganizeInfo.getLocalAdmName());
				}
				if(partyActivityInfoService.insert(partyActivityInfo)>0){
					return AjaxResult.success("增加成功!");
				}else{
					return AjaxResult.error("增加失败!");
				}
			}else {
				partyActivityInfo.setResultInputDate(new Date());
				if(partyActivityInfoService.update(partyActivityInfo)>0){
					return AjaxResult.success("操作成功!");
				}else{
					return AjaxResult.error("操作失败!");
				}
			}
		} catch (Exception e) {
			return AjaxResult.error("操作失败!");
		}
	}
	
	/**
	 * 
	 * 描述: 进入党建活动信息结果录入（查询页）
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("resultinputlist")
	public ModelAndView resultinputlist() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partactivity/activityresultinput_list");
		return view;
	}
	
	/**
	 * 
	 * 描述: 党建活动信息结果录入（修改）
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partyActivityResult")
	public ModelAndView partyActivityResult(String inputState,String uid,String viewFlag) throws Exception {
		SysUserDto sysUser = (SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view;
		if(StringUtil.isNotEmpty(viewFlag)){//查看
			view = new ModelAndView("/reg/server/partycreate/partactivity/activityresultinput_view");
		}else{
		    view = new ModelAndView("/reg/server/partycreate/partactivity/activityresultinput_edit");
		}
		//
		PartyActivityInfo partyActivityInfo = partyActivityInfoService.selectOneByUID(uid);
		//根据所在党组织uid获取对应的最新名称以及管辖单位及id
		PartyOrganizeInfo partyOrganizeInfo = partyOrganizeInfoService.doGetOrganizeInfoByUid(StringUtils.isEmpty(partyActivityInfo.getClaimDeptUID()) ? "00000" : partyActivityInfo.getClaimDeptUID());		
		//获取活动附件路径
		String upfiles = partyActivityInfo.getUpfilePath();
		if (upfiles != null && !upfiles.isEmpty()) {
			if("|".equalsIgnoreCase(upfiles.substring(0, 1))){
				upfiles = upfiles.substring(1);
			}
			view.addObject("upfiles", upfiles.split("\\|"));
		}
		//获取结果附件
		String resultfiles = partyActivityInfo.getResultFilePath();
		if(StringUtil.isNotBlank(resultfiles)){
			if("|".equalsIgnoreCase(resultfiles.substring(0, 1))){
				resultfiles = resultfiles.substring(1);
			}
			view.addObject("files", resultfiles.split("\\|"));
		}
		view.addObject("partyActivityInfoDto", partyActivityInfo);
		view.addObject("partyOrganizeInfo", partyOrganizeInfo);
		view.addObject("sysUser",sysUser);
		view.addObject("inputState", inputState);
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入选择组织人员页面
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param partyOrgID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("chooseMembers")
	public ModelAndView chooseMembers(String partyOrgID,String operateType) throws Exception{
		SysUserDto sysUser = (SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partactivity/choosemember_list");
		view.addObject("sysUser",sysUser);
		view.addObject("partyOrgID",partyOrgID);
		view.addObject("operateType",operateType);
		return view;
	}
	
	/**
	 * 
	 * 描述: 进入党建活动信息查询（查询页）
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("seachlist")
	public ModelAndView seachlist() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partactivity/activitysearch_list");
		return view;
	}
	
	
	
	/**
	 * 上传接口（兼容IE8）
	 * @param files
	 * @param batchNo
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
	public String uploadFile(@RequestParam(value = "btnFile") MultipartFile files, String fileName) {
		fileName = fileName.replaceAll("\\\\", "/");
		files.getName();
		String result = null;
		if (cloudModel == null || cloudModel.equals("N")) {
			result = uploadToLoc(files, fileName);
		} else{
			result = uploadToOSS(files, "party/activity/"+fileName);
		} 
		return result;
	}
	
	/**
	 * 从OSS上下载文件
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = { "download" }, method = { RequestMethod.GET })
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
			flag = ossClient.putStream(files, fileName);
		} catch (OSSException oe) {
			System.out.println("Error Message: " + oe.getErrorMessage());
			System.out.println("Error Code: " + oe.getErrorCode());
			System.out.println("Request ID: " + oe.getRequestId());
			System.out.println("Host ID: " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Error Code: " + ce.getErrorCode());
			System.out.println("Error Message: " + ce.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			return fileName;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}