/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.ImportExcelUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.other.dto.PubSamllSupportDto;
import com.icinfo.cs.other.model.PubSamllSupport;
import com.icinfo.cs.other.service.IPubSamllSupportService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import net.sf.json.JSONObject;

/**
 * 描述: cs_pub_small_suporrt 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
@Controller
@RequestMapping({ "/reg/server/other/pubSmallSupport/", "/syn/server/other/pubSmallSupport/" })
public class PubSamllSupportController extends CSBaseController {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(PubSamllSupportController.class);

	@Autowired
	private IPubSamllSupportService pubSamllSupportService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;

	/**
	 * 
	 * 描述: to列表页面
	 * 
	 * @auther ljx
	 * @date 2016年11月28日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/pubsmallsupport_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("1")) {
			view.addObject("urlType", "/reg");

		} else {
			view.addObject("urlType", "/syn");

			view.addObject("deptCode", sysUser.getDeptCode());// 部门id

		}
		return view;
	}

	/**
	 * 
	 * 描述: for查询页面
	 * 
	 * @auther ljx
	 * @date 2016年11月28日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchlist")
	public ModelAndView searchList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/pubsmallsupportsearch_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("1")) {
			view.addObject("urlType", "/reg");

		} else {
			view.addObject("urlType", "/syn");

			view.addObject("deptCode", sysUser.getDeptCode());// 部门id

		}

		return view;
	}

	/**
	 * to 增加页面 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年11月29日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addView")
	public ModelAndView doAdd(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/pubsmallsupportinput_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;

	}

	/**
	 * 
	 * 描述: listJSON
	 * 
	 * @auther ljx
	 * @date 2016年11月28日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listJSON")
	@ResponseBody
	public PageResponse<PubSamllSupportDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "b.checkDep", "b.localAdm");
		List<PubSamllSupportDto> data = pubSamllSupportService.selectByCation(request);
		return new PageResponse<PubSamllSupportDto>(data);
	}

	@RequestMapping("/searchList")
	@ResponseBody
	public PageResponse<PubSamllSupportDto> searchListJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "b.checkDep", "b.localAdm");
		List<PubSamllSupportDto> data = pubSamllSupportService.selectByCation(request);
		return new PageResponse<PubSamllSupportDto>(data);

	}

	/**
	 * 
	 * 描述: 保存或者新增操作
	 * 
	 * @auther ljx
	 * @date 2016年11月28日
	 * @param pubSamllSupport
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(PubSamllSupport pubSamllSupport, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (StringUtils.isEmpty(pubSamllSupport.getUID())) { 
			pubSamllSupport.setSetName(sysUser.getRealName());
			pubSamllSupport.setSetDate(new Date());
			pubSamllSupport.setAuditState("0");// 待审核 状态
			pubSamllSupport.setDeptID(sysUser.getDeptCode()); 
			pubSamllSupport.setDeptName(sysUser.getDept());
			if (pubSamllSupportService.saveSmalSupport(pubSamllSupport) > 0) {
				return AjaxResult.success("新增成功",sysUser.getDeptCode());
			} else {
				return AjaxResult.error("新增失败");
			}
		} else {
			pubSamllSupport.setDeptID(sysUser.getDeptCode());
			if (pubSamllSupportService.updateSmallSupport(pubSamllSupport) > 0) {
				return AjaxResult.success("更新成功");
			} else {
				return AjaxResult.error("更新失败");
			}
		}
	}

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public AjaxResult deleteBatch(String uid) throws Exception {
		if (StringUtils.isNotEmpty(uid)) {
			if (pubSamllSupportService.deleteByUids(uid) > 0) {
				return AjaxResult.success("删除成功");
			} else {
				return AjaxResult.error("删除失败");
			}

		} else {
			return AjaxResult.error("未选择内容");
		}

	}

	/**
	 * 
	 * 描述: 显示for增加
	 * 
	 * @auther ljx
	 * @date 2016年11月28日
	 * @param session
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showToAdd")
	public ModelAndView showToAdd(HttpSession session, String priPID) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/pubsmallsupport_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		view.addObject("dutyDeptCodes", sysUser.getDutyDeptCodes());
		if (StringUtils.isNotEmpty(priPID)) {
			view.addObject("midBase", midBaseInfoService.selectByPripid(priPID));
		}
		return view;
	}

	/**
	 * 
	 * 描述: 详情展示页
	 * 
	 * @auther ljx
	 * @date 2016年11月28日
	 * @param session
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(HttpSession session, String uid) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/pubsmallsupport_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (StringUtils.isNotEmpty(uid)) {
			PubSamllSupport pubSamllSupport = pubSamllSupportService.selectByOne(uid);
			view.addObject("midBase", midBaseInfoService.selectByPripid(pubSamllSupport.getPriPID()));
			view.addObject("pubSamllSupport", pubSamllSupport);

		}

		return view;

	}

	/**
	 * 
	 * 描述:to 审核页面
	 * 
	 * @auther ljx
	 * @date 2016年11月29日
	 * @param session
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showToAudit")
	public ModelAndView showToAudit(HttpSession session, String uid) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/smalsupport_audit");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (StringUtils.isNotEmpty(uid)) {
			PubSamllSupport pubSamllSupport = pubSamllSupportService.selectByOne(uid);
			pubSamllSupport.setAuditDate(new Date());
			pubSamllSupport.setAuditName(sysUser.getRealName());
			view.addObject("midBase", midBaseInfoService.selectByPripid(pubSamllSupport.getPriPID()));
			view.addObject("pubSamllSupport", pubSamllSupport);

		}
		return view;
	}

	/**
	 * 
	 * 描述: 展示详情
	 * 
	 * @auther ljx
	 * @date 2016年11月29日
	 * @param session
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetails")
	public ModelAndView showDetails(HttpSession session, String uid) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/smallsupport/smalsupport_detail");
		if (StringUtils.isNotEmpty(uid)) {
			PubSamllSupport pubSamllSupport = pubSamllSupportService.selectByOne(uid);
			view.addObject("midBase", midBaseInfoService.selectByPripid(pubSamllSupport.getPriPID()));
			view.addObject("pubSamllSupport", pubSamllSupport);
		}
		return view;
	}

	/**
	 * 
	 * 描述:审核操作
	 * 
	 * @auther ljx
	 * @date 2016年11月29日
	 * @param pubSamllSupport
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/auditSmallSupport")
	@ResponseBody
	public AjaxResult auditSmallSupport(PubSamllSupport pubSamllSupport,HttpSession session) throws Exception {
		int result = 0; 
		if (StringUtils.isNotEmpty(pubSamllSupport.getUID())) {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
			pubSamllSupport.setDeptID(sysUser.getDeptCode());
			result = pubSamllSupportService.auditSmallSupport(pubSamllSupport);
		}
		if (result > 0) {
			return AjaxResult.success("审核成功");
		} else {
			return AjaxResult.error("审核失败");
		}
	}

	@RequestMapping("/importExcel")
	public void importExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpSession session)
			throws Exception {
		int result = 0;
		String titles[] = { "注册号", "企业名称", "扶持日期", "反馈日期", "扶持内容", "扶持金额" };
		JSONObject json = new JSONObject();
		InputStream in = null;
		List<List<Object>> listob = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (file.isEmpty()) {
			throw new Exception("文件不存在");
		}
		in = file.getInputStream();
		map = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(), 2, titles);// 从第二行开始导入，标题不导入
		if (map.get("errorType").toString().equals("ok")) {
			listob = (List<List<Object>>) map.get("listob");
			result = pubSamllSupportService.importByExcel(listob, session); // excel导入
			if (result > 0) {
				json.put("status", "success");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(json);
				response.getWriter().flush();
				response.getWriter().close();// 关闭流
			} else {
				json.put("status", "faill");
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
				.getRealPath("WEB-INF/views/page/reg/server/other/smallsupport") + File.separator + "test.xlsx";

		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		// 更改下载名称
		String fileName = new String("帮扶信息导入模板.xlsx".getBytes("GBK"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	/**
	 * 
	 * 描述 查询企业列表 @author 赵祥江 @date 2016年12月12日 下午4:21:41 @param @return
	 * PageResponse<PanoramaResultDto> @throws
	 */
	@RequestMapping({ "/panoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "checkDep", "localAdm");
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}

}