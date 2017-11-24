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

import org.apache.commons.collections.map.HashedMap;
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

import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ImportExcelUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.im.service.IImPermitService;
import com.icinfo.cs.im.service.IImPrmtaltService;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.cs.other.model.PubOtherlicenceHis;
import com.icinfo.cs.other.service.IPubOtherlicenceHisService;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.other.service.IPubServerModrecordService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import net.sf.json.JSONObject;

/**
 * 描述: cs_pub_otherlicence 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({ "/reg/server/other/pubohterlicenceinput/", "/syn/server/other/pubohterlicenceinput/" })
public class PubOtherlicenceInputController extends CSBaseController {
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(PubOtherlicenceInputController.class);

	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IPubOtherlicenceHisService pubOtherlicenceHisService;
	@Autowired
	private ICodeRegunitService codeRegunitService;
	@Autowired
	private ICodeEntcatgService codeEntcatgService;
	@Autowired
	private ICodeSlicenoService codeSlicenoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IImPermitService permitService;
	@Autowired
	private IImPrmtaltService prmtaltService;
	@Autowired
	private IPubServerModrecordService pubServerModrecordService;
	@Autowired
	private IPanoramaSearchService panoramaSearchService;

	/**
	 * 
	 * 描述:to录入页面
	 * 
	 * @auther ljx
	 * @date 2016年10月20日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/pubotherlicenceinput_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("1")) {
			view.addObject("urlType", "/reg");
		} else {

			view.addObject("deptCode", sysUser.getDeptCode());// 部门id

			view.addObject("urlType", "/syn");
		}
		return view;
	}

	@RequestMapping("/toSearch")
	public ModelAndView toSearch(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/pubotherlicence_search");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 
	 * 描述: 进入行政许可新增页面
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addView")
	public ModelAndView doPrimitAdd(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/pubotherlicenceinput_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("2")) {
			view.addObject("localAdm", sysUser.getDeptCode());

		}

		return view;

	}

	/**
	 * 
	 * 描述: 进入行政许可新增页面
	 * 
	 * @auther ljx
	 * @date 2016年12月6日
	 * @param priPID
	 * @param licID
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView doEntAddOrEditView(String priPID, String licID, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/otherlicenceinput_edit");
		if (StringUtils.isNotEmpty(priPID)) {
			PubOtherlicence pubOtherLicence = new PubOtherlicenceDto();
			MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
			if (midBaseInfo != null) {
				pubOtherLicence.setPriPID(priPID);
				pubOtherLicence.setRegNO(midBaseInfo.getRegNO());
				pubOtherLicence.setEntName(midBaseInfo.getEntName());
				view.addObject("pubOtherLicence", pubOtherLicence);
			}
		}
		if (StringUtils.isNotEmpty(licID)) {
			PubOtherlicence pubOtherLicence = pubOtherlicenceService.selectByOne(licID);
			view.addObject("pubOtherLicence", pubOtherLicence);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。

		return view;

	}

	@RequestMapping(value = "addOrEdit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAddOrEdit(PubOtherlicence pubOtherlicence, HttpSession session) throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		pubOtherlicence.setSetDate(new Date());// 录入时间
		pubOtherlicence.setSetName(sysUser.getRealName());// 录入人

		pubOtherlicence.setSetDeptname(sysUser.getDeptCode());// 录入部门id

		pubOtherlicence.setAuditState("0");// 设置待审核
		pubOtherlicence.setAuditOpin(null);// 审核意见
		pubOtherlicence.setAuditName(null);// 审核人姓名
		pubOtherlicence.setAuditDate(null);// 审核时间
		pubOtherlicence.setPubFlag("0");// 设置未公示
		pubOtherlicence.setLicState("1");// 默认有效

		if (StringUtils.isNotEmpty(pubOtherlicence.getLicID())) {
			if (pubOtherlicenceService.update(pubOtherlicence) > 0) {
				return AjaxResult.success("更新成功");
			} else {
				return AjaxResult.error("更新失败");
			}
		} else {

			if (pubOtherlicenceService.saveOhterLicence(pubOtherlicence) > 0) {
				return AjaxResult.success("保存成功");
			} else {
				return AjaxResult.error("保存失败");
			}
		}

	}

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listJSON")
	@ResponseBody
	public PageResponse<PubOtherlicenceDto> listJSON(PageRequest request) throws Exception {
		List<PubOtherlicenceDto> data = pubOtherlicenceService.selectPubOtherlicenceByCation(request);

		return new PageResponse<PubOtherlicenceDto>(data);
	}

	@RequestMapping("/searchListJSON")
	@ResponseBody
	public PageResponse<PubOtherlicenceDto> searchListJSON(PageRequest request) throws Exception {

		List<PubOtherlicenceDto> data = pubOtherlicenceService.selectImPrimitByCation(request);
		return new PageResponse<PubOtherlicenceDto>(data);
	}

	/**
	 * 
	 * 描述: 登记机关树状结构json数据
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeListJSON")
	@ResponseBody
	public AjaxResult treeListJSON(String isPermissionCheck) throws Exception {
		Map param = new HashedMap();
		if("true".equals(isPermissionCheck)){
			param.put("regUnit_permission_limit", getLimitReg());//权限限制字段
			List<Map<String,Object>> data=codeRegorgService.selectToTreeMap(param);
			return AjaxResult.success("查询成功",data);
		}
		List<Map<String,Object>> data=codeRegorgService.selectToTreeMap(param);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: to登记机关树页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toTreeView")
	public ModelAndView toTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/treeview");
		return view;
	}

	/**
	 * 
	 * 描述: 管辖单位json
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeRegUnitListJSON")
	@ResponseBody
	public AjaxResult treeRegUnitListJSON() throws Exception {
		List<Map<String, Object>> data = codeRegunitService.selectToTreeMap(new HashedMap());
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 企业类型json 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeEntcatgListJSON")
	@ResponseBody
	public AjaxResult treeEntcatgListJSON(String content) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		List<Map<String, Object>> data = codeEntcatgService.selectToTreeMap(map);
		return AjaxResult.success("查询成功", data);
	}

	/**
	 * 
	 * 描述: 片区选择json
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeSlicenoListJSON")
	@ResponseBody
	public AjaxResult treeSlicenoListJSON(String isPermissionCheck)throws Exception{
		Map param = new HashedMap();
		if("true".equals(isPermissionCheck)){
			param.put("regUnit_permission_limit", getLimitReg());//权限限制字段
			List<Map<String,Object>> data=codeSlicenoService.selectToTreeMap(param);
			return AjaxResult.success("查询成功",data);
		}
		List<Map<String,Object>> data=codeSlicenoService.selectToTreeMap(param);
		return AjaxResult.success("查询成功",data); 
	} 

	/**
	 * 
	 * 描述: 去管辖单位树页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toRegUnitTreeView")
	public ModelAndView toRegUnitTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/regUnitTreeView");
		return view;
	}

	/**
	 * 
	 * 描述: to企业类型选择页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEntcatgTreeView")
	public ModelAndView toEntcatgTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/entcatgTreeView");
		return view;

	}

	/**
	 * 
	 * 描述: to片区选择页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSlicenoTreeView")
	public ModelAndView toSlicenoTreeView() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/slicenoTreeView");
		return view;
	}

	/**
	 * 
	 * 描述: to审核详情页面
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String licID, String entType, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView();
		if (StringUtils.isNotEmpty(licID)) {
			PubOtherlicence pubOtherlicence = pubOtherlicenceService.selectByOne(licID);
			view.addObject("pubOtherlicence", pubOtherlicence);
			PubOtherlicenceHis pubOtherlicenceHis = new PubOtherlicenceHis();
			pubOtherlicenceHis.setPriPID(pubOtherlicence.getPriPID());
			pubOtherlicenceHis.setLicNO(pubOtherlicenceHis.getLicNO());
			List<PubOtherlicenceHis> hisList = pubOtherlicenceHisService.selectOtherLincesHisList(pubOtherlicenceHis);
			view.addObject("hisList", hisList);
		}
		if (StringUtils.isNotEmpty(entType) && entType.equals("audit")) {
			view.setViewName("/reg/server/other/otherlicence/otheerlicence_audit");
		} else {
			view.setViewName("/reg/server/other/otherlicence/otheerlicence_detail");
		}

		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 
	 * 描述: 审核操作
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param pubOtherlicence
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/auditOtherLinence")
	@ResponseBody
	public AjaxResult auditOtherLinence(PubOtherlicence pubOtherlicence) throws Exception {
		if (pubOtherlicenceService.auditOtherlicence(pubOtherlicence) > 0) {
			return AjaxResult.success("操作成功");
		} else {
			return AjaxResult.error("操作失败");
		}
	}

	/**
	 * 
	 * 描述: 删除操作
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @param licID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String licID) throws Exception {
		if (StringUtils.isNotEmpty(licID)) {
			if (pubOtherlicenceService.deleteByLicID(licID) > 0) {
				return AjaxResult.success("删除成功");
			} else {
				return AjaxResult.error("删除失败");
			}
		} else {
			return AjaxResult.error("没有选择选项");
		}
	}

	/**
	 * 变更页面
	 * 
	 * @param licID
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/change")
	public ModelAndView change(String licID, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/other/otherlicence/otheerlicence_change");
		if (StringUtils.isNotEmpty(licID)) {
			view.addObject("pubOtherlicence", pubOtherlicenceService.selectByOne(licID));

		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。

		return view;

	}

	/**
	 * 变更
	 * 
	 * @param pubOtherlicence
	 * @param names
	 * @param changevalues
	 * @param originalValues
	 * @param altDate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/alert")
	@ResponseBody
	public AjaxResult alert(PubOtherlicence pubOtherlicence, String names, String changevalues, String originalValues,
			Date altDate) throws Exception {
		int result = pubOtherlicenceService.alert(pubOtherlicence, names, changevalues, originalValues, altDate);

		if (result > 0) {
			return AjaxResult.success("变更成功");
		} else {
			return AjaxResult.error("变更失败");
		}
	}

	/**
	 * 取消
	 * 
	 * @param licID
	 * @param canRea
	 * @param canDate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/beCancle")
	@ResponseBody
	public AjaxResult cancle(String licID, String canRea, String canDate) throws Exception {
		PubOtherlicence pubOtherlicence = new PubOtherlicence();
		pubOtherlicence.setLicType("2");
		pubOtherlicence.setLicState("5");
		pubOtherlicence.setLicID(licID);
		pubOtherlicence.setCanRea(canRea);
		pubOtherlicence.setCanDate(DateUtil.stringToDate(canDate, "yyyy-MM-dd"));
		if (pubOtherlicenceService.update(pubOtherlicence) > 0) {
			return AjaxResult.success("注销成功");
		} else {
			return AjaxResult.error("注销失败");
		}

	}

	/**
	 * 被注销
	 * 
	 * @param licID
	 * @param revDate
	 * @param revRea
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/beRevoked")
	@ResponseBody
	public AjaxResult beRevoked(String licID, String revDate, String revRea) throws Exception {
		PubOtherlicence pubOtherlicence = new PubOtherlicence();
		pubOtherlicence.setLicType("3");
		pubOtherlicence.setLicState("4");
		pubOtherlicence.setLicID(licID);
		pubOtherlicence.setRevRea(revRea);
		pubOtherlicence.setRevDate(DateUtil.stringToDate(revDate, "yyyy-MM-dd"));
		if (pubOtherlicenceService.update(pubOtherlicence) > 0) {
			return AjaxResult.success("被吊销成功");
		} else {
			return AjaxResult.error("被吊销失败");
		}
	}

	/**
	 * 其他无形信息
	 * 
	 * @param licID
	 * @param invAlidDate
	 * @param invAliDRea
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/invalidReason")
	@ResponseBody
	public AjaxResult invalidReason(String licID, String invAlidDate, String invAliDRea) throws Exception {
		PubOtherlicence pubOtherlicence = new PubOtherlicence();
		pubOtherlicence.setInvAlidDate(DateUtil.stringToDate(invAlidDate, "yyyy-MM-dd"));
		pubOtherlicence.setInvAliDRea(invAliDRea);
		pubOtherlicence.setLicType("4");
		pubOtherlicence.setLicState("3");
		pubOtherlicence.setLicID(licID);
		if (pubOtherlicenceService.update(pubOtherlicence) > 0) {
			return AjaxResult.success("操作成功");
		} else {
			return AjaxResult.error("操作失败");
		}
	}

	/**
	 * 
	 * 描述: 查看详情
	 * 
	 * @auther ljx
	 * @date 2016年10月21日
	 * @param licID
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showDetails")
	public ModelAndView showDetails(String licID, String priPID, String type, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView();
		if (StringUtils.isNotEmpty(priPID)) {
			view.addObject("midBaseInfo", midBaseInfoService.selectByPripid(priPID));
		}
		if (StringUtils.isNotEmpty(type) && type.equals("enterprise")) {
			if (StringUtils.isNotEmpty(licID)) {
				view.addObject("perMit", permitService.selectByLicId(licID, priPID));
				view.addObject("perMaltlist", prmtaltService.selectBylicID(licID));
				view.setViewName("/reg/server/other/otherlicence/perMitDetails");
			}
		} else if (StringUtils.isNotEmpty(type) && type.equals("other")) {
			view.addObject("otherLicence", pubOtherlicenceService.selectByOne(licID));

			view.setViewName("/reg/server/other/otherlicence/otherLicenceDetails");
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。

		return view;

	}

	/**
	 * 
	 * 描述: Excel 导入
	 * 
	 * @auther ljx
	 * @date 2016年11月25日
	 * @param file
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping("/importExcel")
	public void importExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpSession session)
			throws Exception {
		int result = 0;
		String titles[] = { "注册号", "企业名称", "许可文件编号", "许可文件名称", "有效期始", "有效期至", "许可机关", "许可内容" };
		JSONObject json = new JSONObject();
		InputStream in = null;
		List<List<Object>> listob = null;
		Map<String, Object> map = new HashMap<String, Object>();

		if (file.isEmpty()) {
			throw new Exception("文件不存在!");
		}
		in = file.getInputStream();
		map = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(), 2, titles);// 从第二行开始导入，标题不导入
		if (map.get("errorType").toString().equals("ok")) {
			listob = (List<List<Object>>) map.get("listob");

			Map<String, String> resultMap = pubOtherlicenceService.importByExcel(listob, session); // excel导入
			if (Integer.parseInt(resultMap.get("result")) > 0) {
				json.put("status", "success");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(json);
				json.put("regNO", resultMap.get("regNO"));
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
				.getRealPath("WEB-INF/views/page/reg/server/other/otherlicence") + File.separator + "test.xlsx";

		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		// 更改下载名称
		String fileName = new String("行政许可导入模板.xlsx".getBytes("GBK"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	/**
	 * 
	 * 描述 查询企业列表 @author ljx @date 2016年12月12日 下午4:21:41 @param @return
	 * PageResponse<PanoramaResultDto> @throws
	 */
	@RequestMapping({ "/panoQueryPage" })
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "checkDep", "localAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}
	
	/**
	 * 获取权限限制
	 * @return
	 */
	public String getLimitReg() {
		SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		String level = sysUser.getUserVest(sysUser);
		String isAdmin = sysUser.getIsAdmin(); 
//        1：本所2：本局3：本市4：本省
		if(StringUtils.isNotBlank(isAdmin) &&"1".equals(isAdmin)){ //管理员权限放开
			return "";
		}
		if (StringUtils.equalsIgnoreCase(level, "1")||StringUtils.isBlank(level)) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6);
		}
		if (StringUtils.equalsIgnoreCase(level, "2")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 6);
		}
		if (StringUtils.equalsIgnoreCase(level, "3")) {
			return StringUtils.substring(sysUser.getDepartMent().getDeptCode(), 0, 4);
		}
		return "";
	}

}