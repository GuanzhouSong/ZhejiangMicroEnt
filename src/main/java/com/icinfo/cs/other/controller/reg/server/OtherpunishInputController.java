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

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.ImportExcelUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_otherpunish_his 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Controller("ServerPubOtherInput")
@RequestMapping({ "/pub/server/pubotherpunishinput", "/syn/server/pubotherpunishinput" })
public class OtherpunishInputController extends CSBaseController {

	@Autowired
	private IPubOtherpunishService pubOtherpunishService;

	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private IPanoramaSearchService panoramaSearchService;

	/**
	 * 
	 * 描述: 进入行政处罚信息录入列表页
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunishinput_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		if(sysUser.getUserType().equals("1")){
		      view.addObject("urlType", "/pub");
	     }else{
	    	 view.addObject("urlType","/syn");
	    	 view.addObject("deptCode",sysUser.getDeptCode());
	     }
		return view;
	}

	/**
	 * 删除行政处罚信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param priPID,caseNO
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult delete(String priPID, String caseNO) throws Exception {
		if (StringUtil.isNotEmpty(priPID) && StringUtil.isNotEmpty(caseNO)) {
			if (pubOtherpunishService.deleteOtherPunishInfo(priPID, caseNO)) {
				return AjaxResult.success("删除成功");
			}
		}
		return AjaxResult.success("删除失败！");
	}

	/**
	 * 描述: 进入行政处罚变更页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/alter")
	public ModelAndView doEnAlter(String pripid, String caseNO, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunishinput_alter");
		PubOtherpunish pubOtherpunish = pubOtherpunishService.doGetPubOtherPunishInfo(pripid, caseNO);
		view.addObject("pubOtherpunish", pubOtherpunish);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}

	/**
	 * 保存行政处罚变更信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubOtherPunishAlter
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAlter(PubOtherPunishAlter pubOtherPunishAlter, HttpSession session) throws Exception {
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		try {
			if (pubOtherPunishAlter != null) {
				boolean commitFlag = pubOtherpunishService.doSavePunishAlter(pubOtherPunishAlter, sysUser);
				if (commitFlag) {
					return AjaxResult.success("保存成功");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("保存失败！");
		}
		return AjaxResult.error("保存失败！");
	}

	/**
	 * 描述: 进入行政处罚新增列表页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addView")
	public ModelAndView doEnAdd(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunishinput_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}

	/**
	 * 描述: 进入行政处罚新增或修改页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView doEnAddOrEditView(String pripid, 
			   String caseNO,String entName,String regNO,String leRep, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunishinput_edit");
		if (StringUtil.isNotEmpty(caseNO)) {
			PubOtherpunish pubOtherpunish = pubOtherpunishService.doGetPubOtherPunishInfo(pripid, caseNO);
			view.addObject("pubOtherpunish", pubOtherpunish);
		} else {
			PubOtherpunish pubOtherpunish = new PubOtherpunish();
			pubOtherpunish.setRegNO(regNO);
			pubOtherpunish.setEntName(entName);
			pubOtherpunish.setLeRep(leRep);
			pubOtherpunish.setPriPID(pripid);
			view.addObject("pubOtherpunish", pubOtherpunish);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());
		return view;
	}

	/**
	 * 新增或修改行政处罚信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubOtherpunish
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "addOrEdit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doddOrEdit(PubOtherpunish pubOtherpunish, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		boolean commitFlag = pubOtherpunishService.doSaveOrEditOtherPunishInfo(pubOtherpunish, sysUser);
		if (commitFlag) {
			return AjaxResult.success("保存成功");
		}
		return AjaxResult.error("保存失败！");
	}

	/**
	 * 描述：获取行政处罚新增企业数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubOtherpunish>(data)
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<MidBaseInfo> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"CheckDep","LocalAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<MidBaseInfo> data = midBaseInfoService.queryPage(request);
		return new PageResponse<MidBaseInfo>(data);
	}

	/**
	 * 描述: 进入获取处罚类型页面
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/viewPenType")
	public ModelAndView viewPenType(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/viewPenType");
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
	 * 
	 * 描述: Excel 导入
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
	 
		JSONObject json = new JSONObject();
		InputStream in = null;
		String titles[]={"注册号","企业名称","处罚决定书文号","违法类型","处罚类型","行政处罚内容","处罚决定日期","处罚决定机关","罚款金额","没收金额"};
		List<List<Object>> listob = null;
	    Map<String,Object> map=new HashMap<String,Object>();
		if (file.isEmpty()) {
			throw new Exception("文件不存在");
		}
		in = file.getInputStream();// 获得文件输入流
		map=new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename(),2,titles);//从第二行开始导入，标题不导入
       	if(map.get("errorType").toString().equals("ok")){
			listob=(List<List<Object>>) map.get("listob");
		Map<String,String> resultMap=pubOtherpunishService.importByExcel(listob,session); //excel导入
		if(Integer.parseInt(resultMap.get("result"))>0) {
			json.put("status", "success");
			json.put("regNO", resultMap.get("regNO"));
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();//关闭流
		}else{
			json.put("status","faill");
			json.put("regNO",resultMap.get("regNO"));
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();//关闭流
		} 
		}else{
			json.put("status", "faill");
		    json.put("msg",map.get("errorType"));
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();//关闭流
			return;
		}
	 

	}

	/**
	 *  文件下载
	 * @throws Exception
	 */
	@RequestMapping("/file_down")
	public ResponseEntity<byte[]> file_down(HttpServletRequest request, String file_name)throws Exception{

		/************************************GBK的写法 start *****************************************/

		//TODO 获取WEB-INF 下面文件夹的文件路径：
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/reg/server/other/pubotherpunish")+File.separator+"test.xls";

		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("行政处罚导入模板.xls".getBytes("GBK"),"iso-8859-1");//为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	
}