/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.ImportExcelUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.other.dto.PubJusticeInfoDto;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.model.PubJusticeInfoHis;
import com.icinfo.cs.other.service.IPubJusticeInfoHisService;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.cs.yr.service.IPubServerHisModService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_justiceinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Controller("ServerPubJusticeInfo")
@RequestMapping({ "/reg/other/pubjusticeinfo", "/syn/other/pubjusticeinfo" })
public class PubJusticeInfoController extends CSBaseController {

	@Autowired
	private IPubJusticeInfoService pubJusticeInfoService;

	@Autowired
	private IPubServerHisModService pubServerHisModService;

	@Autowired
	private IMidBaseInfoService midBaseInfoService;

	@Autowired
	private IPubJusticeInfoHisService pubJusticeInfoHisService;

	@Autowired
	private ICodeCertypeService codeCertypeService;
	
	@Autowired
	private IPanoramaSearchService panoramaSearchService;

	/**
	 * 
	 * 描述: 进入司法协助信息录入列表页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfo_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("1")) {
			view.addObject("urlType", "/reg");
		} else {
			view.addObject("urlType", "/syn");
			view.addObject("deptCode", sysUser.getDeptCode());
		}
		return view;
	}

	/**
	 * 
	 * 描述: 进入司法协助信息录入新增列表页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addList")
	public ModelAndView addlist(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfo_add_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}
	
	/**
	 * 获取查询企业列表
	 * 
	 * @author yujingwei
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/panoQueryPage"})
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"checkDep","localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

	/**
	 * 描述：获取司法协助信息录入列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubOtherpunish>(data)
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<PubJusticeInfo> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		List<PubJusticeInfo> data = pubJusticeInfoService.queryPage(request);
		return new PageResponse<PubJusticeInfo>(data);
	}

	/**
	 * 描述: 进入司法协助信息录入新增或修改页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView doEnAddOrEditView(String pripid, String UID, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfo_edit");
		if (StringUtil.isNotBlank(UID)) {
			PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfo(pripid, UID);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
		} else {
			PubJusticeInfo pubJusticeInfo = new PubJusticeInfo();
			MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(pripid);
			if (midBaseInfo != null) {
				pubJusticeInfo.setUniSCID(StringUtil.isNotEmpty(midBaseInfo.getUniCode()) ? midBaseInfo.getUniCode()
						: midBaseInfo.getRegNO());
				pubJusticeInfo.setEntName(midBaseInfo.getEntName());
			}
			pubJusticeInfo.setPriPID(pripid);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
		view.addObject("codeCertypeList", codeCertypeList);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 新增或修改司法协助信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubJusticeInfoDto
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "addOrEdit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddAndEditInfo(PubJusticeInfoDto pubJusticeInfoDto, HttpSession session) throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		try {
			if (pubJusticeInfoDto != null) {
				boolean commitFlag = pubJusticeInfoService.doAddAndEditJusticeInfo(pubJusticeInfoDto, sysUser);
				if (commitFlag) {
					return AjaxResult.success("保存成功！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("保存失败！");
		}
		return AjaxResult.error("保存失败！");
	}

	/**
	 * 描述: 进入司法协助信息录入详情页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param pripid，UID
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/detailsView")
	public ModelAndView doEnDetailsView(String pripid, String UID, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfo_details");
		if (StringUtil.isNotBlank(pripid) && StringUtil.isNotBlank(UID)) {
			PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfo(pripid, UID);
			List<PubServerHisMod> pubServerHisModList = pubServerHisModService.doGetPubServerHisModList(pripid, UID);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
			view.addObject("pubServerHisModList", pubServerHisModList);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
		view.addObject("codeCertypeList", codeCertypeList);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 描述: 进入司法协助信息录入历史详情页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param pripid，modUID，hisNO
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/hisView")
	public ModelAndView doEnHisView(String pripid, String modUID, String hisNO, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfo_hisDetails");
		if (StringUtil.isNotBlank(pripid) && StringUtil.isNotBlank(modUID) && StringUtil.isNotBlank(hisNO)) {
			PubJusticeInfoHis pubJusticeInfo = pubJusticeInfoHisService.doGetPubJusticeInfoHis(pripid, modUID, hisNO);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
		view.addObject("codeCertypeList", codeCertypeList);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 删除司法协助信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param priPID,UID
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult delete(String priPID, String UID) throws Exception {
		if (StringUtil.isNotEmpty(priPID) && StringUtil.isNotEmpty(UID)) {
			if (pubJusticeInfoService.deletePubJusticeInfo(priPID, UID)) {
				return AjaxResult.success("删除成功");
			}
		}
		return AjaxResult.success("删除失败！");
	}

	/**
	 * 描述: 进入被执行人列表页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param pripid，executeItem
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/includeView")
	public ModelAndView includeView(String pripid, String executeItem, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfo_include");
		if (StringUtil.isNotBlank(pripid) && StringUtil.isNotBlank(executeItem)) {
			view.addObject("priPID", pripid);
			view.addObject("executeItem", executeItem);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 描述：获取被执行人选择页面列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubOtherpunish>(data)
	 * @throws Exception
	 */
	@RequestMapping("/include.json")
	@ResponseBody
	public PageResponse<PubJusticeInfo> includeList(PageRequest request) throws Exception {
		List<PubJusticeInfo> data = pubJusticeInfoService.queryPageForInclude(request);
		return new PageResponse<PubJusticeInfo>(data);
	}

	/**
	 * 描述：司法协助-股权冻结定时失效
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param
	 * @throws Exception
	 */
	public void doSetfrozState() throws Exception {
		pubJusticeInfoService.doSetfrozNoEffect();
	}

	/**
	 * 
	 * 描述:Excel 导入
	 * 
	 * @auther ljx
	 * @date 2016年11月24日
	 * @param file
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping("/importExcel")
	public void importExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpSession session)
			throws Exception {
		int result = 0;
		String titles[] = { "股权所在企业统一代码/注册号", "股权所在企业名称", "执行法院", "执行事项", "司法协助公示通知书文号", "执行裁定书文号", "执行通知书文号", "被执行人" };
		JSONObject json = new JSONObject();
		InputStream in = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<List<Object>> listob = null;
		if (file.isEmpty()) {
			throw new Exception("文件不存在");
		}
		in = file.getInputStream();// 获得文件输入流
		map = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(), 2, titles);// 从第二行开始导入，标题不导入
		if (map.get("errorType").toString().equals("ok")) {
			listob = (List<List<Object>>) map.get("listob");
			Map<String, String> resultMap = pubJusticeInfoService.importByExcel(listob, session); // excel导入
			if (Integer.parseInt(resultMap.get("result")) > 0) {
				json.put("status", "success");
				json.put("regNO", resultMap.get("regNO"));
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(json);
				response.getWriter().flush();
				response.getWriter().close();// 关闭流
			} else {
				json.put("status", "faill");
				json.put("regNO", resultMap.get("regNO"));
				json.put("msg", "导入失败");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(json);
				response.getWriter().flush();
				response.getWriter().close();// 关闭流
			}
		} else {
			json.put("status", "faill");
			json.put("msg", map.get("errorType"));
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();// 关闭流
			return;
		}

	}

	/**
	 * 文件下载
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/file_down")
	public ResponseEntity<byte[]> file_down(HttpServletRequest request, String file_name) throws Exception {

		/************************************
		 * GBK的写法 start
		 *****************************************/

		// TODO 获取WEB-INF 下面文件夹的文件路径：
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/reg/server/other/pubjusticeinfo") + File.separator + "test.xlsx";

		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		// 更改下载名称
		String fileName = new String("司法导入模板.xlsx".getBytes("GBK"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

}