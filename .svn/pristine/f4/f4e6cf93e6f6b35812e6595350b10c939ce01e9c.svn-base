/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegState;
import com.icinfo.cs.base.service.ICodeRegStateService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.sccheck.dto.DrandomSpecialEntDto;
import com.icinfo.cs.sccheck.model.CodeMarkType;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.cs.sccheck.model.DrandomSpecialEnt;
import com.icinfo.cs.sccheck.service.ICodeMarkTypeService;
import com.icinfo.cs.sccheck.service.ICodeSpecialTypeService;
import com.icinfo.cs.sccheck.service.IDrandomSpecialEntService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;


/**
 * 描述:    cs_drandom_special_ent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月13日
 */
@Controller
@RequestMapping("/syn/server/sccheck/specialent")
public class DrandomSpecialEntController extends CSBaseController {
	
	@Autowired
	private IDrandomSpecialEntService drandomSpecialEntService;
	
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private ICodeSpecialTypeService codeSpecialTypeService;
	
	@Autowired
	private ICodeMarkTypeService codeMarkTypeService;
	
	@Autowired
	private ICodeRegStateService codeRegStateService;
	
	/**
	 * 描述: 进入跨部门专项库列表(只用作协同除工商部门以外)
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("specialentlistpage")
	public ModelAndView enterSpecialEntListpage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
				 || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
				 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
			ModelAndView view = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_list");
			view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
			view.addObject("sysUser", sysUser);
			return view;
		}else{
			ModelAndView view = new ModelAndView("syn/system/sccheck/specialent/specialent_list");
			List<CodeSpecialType> codeSpecialTypeList = null;
			List<CodeMarkType> codeMarkTypeList = null;
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				Map<String,Object> params = new HashMap<String,Object>();
				String dutyDeptCodes = sysUser.getDutyDeptCodes();
				params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
				params.put("isVlid", "1");
				codeSpecialTypeList = codeSpecialTypeService.selectListByParams(params);
				codeMarkTypeList = codeMarkTypeService.selectListByParams(params);//查询专项库对应的标签
			}
			view.addObject("codeSpecialTypeList", codeSpecialTypeList);
			view.addObject("codeMarkTypeList", codeMarkTypeList);
			view.addObject("sysUser", sysUser);
			view.addObject("dutyDeptCode", sysUser.getDutyDeptCodes());
			view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
			return view;
		}
	}
	
	/**
	 * 描述: 进入跨部门专项库列表(只用作协同除工商部门以外)
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("export")
	public ModelAndView enterExportpage(HttpSession session,String taskUid) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("syn/system/sccheck/specialent/specialent_export");
		List<CodeSpecialType> codeSpecialTypeList = null;
		List<CodeMarkType> codeMarkTypeList = null;
		if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
			Map<String,Object> params = new HashMap<String,Object>();
			String dutyDeptCodes = sysUser.getDutyDeptCodes();
			params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
			params.put("isVlid", "1");
			codeSpecialTypeList = codeSpecialTypeService.selectListByParams(params);
			codeMarkTypeList = codeMarkTypeService.selectListByParams(params);//查询专项库对应的标签
		}
		view.addObject("codeSpecialTypeList", codeSpecialTypeList);
		view.addObject("codeMarkTypeList", codeMarkTypeList);
		view.addObject("sysUser", sysUser);
		view.addObject("dutyDeptCode", sysUser.getDutyDeptCodes());
		view.addObject("taskUid", taskUid);
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
	 * 描述：跨部门专项库列表查询(只用作协同除工商部门以外)
	 *
	 * @author chenxin
	 * @date 2017年7月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("specialentlist.json")
	@ResponseBody
	public PageResponse<DrandomSpecialEntDto> specialEntlistJSON(PageRequest request, HttpSession session) throws Exception {
		creatDefaultDBAuthEnv(request, "t.SetDeptCode", "t.SetDeptCode");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<DrandomSpecialEntDto> dsedList = drandomSpecialEntService.queryPage(request, sysUserDto);
		return new PageResponse<DrandomSpecialEntDto>(dsedList);
	}
	
	/**
	 * 描述: 专项检查对象统计查询
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/searchcount.json")
	@ResponseBody
	public List<DrandomSpecialEntDto> initSearchCountJSON(HttpSession session,@RequestBody Map<String, Object> parmMap) throws Exception {
		creatDefaultDBAuthEnv(parmMap,"t.SetDeptCode", "t.SetDeptCode");
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<DrandomSpecialEntDto> infos = drandomSpecialEntService.selectSpecialCount(parmMap, sysUserDto);
		return infos;
	}
	
	
	/**
	 * 描述: 导入待抽检库
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addSpecialAll")
	@ResponseBody
	public AjaxResult addSpecialAll(HttpSession session,@RequestBody Map<String, Object> parmMap) throws Exception {
		creatDefaultDBAuthEnv(parmMap,"t.SetDeptCode", "t.SetDeptCode");
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		return drandomSpecialEntService.addSpecialAll(parmMap, sysUserDto);
	}
	
	/**
	 * 描述: 进入详情页(只用作协同除工商部门以外)
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("edit")
	public ModelAndView doShowDetail(HttpSession session,String uid,String viewFlag) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/specialent/specialent_edit");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		DrandomSpecialEnt drandomSpecialEnt = null;
		MidBaseInfoDto midBaseInfoDto = null;
		List<CodeMarkType> codeMarkTypeList = null;
		String regStateName = "";
		if(StringUtils.isNotEmpty(uid)){
			drandomSpecialEnt = drandomSpecialEntService.selectByUid(uid);//查询专项库基本信息
			String pripid = drandomSpecialEnt.getPriPID();
			Map<String,Object> parmMap = new HashMap<String,Object>();
			parmMap.put("priPID", pripid);
			midBaseInfoDto = midBaseInfoService.selectForDrandomByKeyword(parmMap);//查询企业详情信息
			CodeRegState codeRegState = codeRegStateService.selectCsStateDesc(midBaseInfoDto.getRegState());
			regStateName = codeRegState.getCsStateDesc();
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				String dutyDeptCodes = sysUser.getDutyDeptCodes();
				parmMap.put("dutyDeptCodes", dutyDeptCodes);
				parmMap.put("isVlid", "1");
				parmMap.put("specialCode", drandomSpecialEnt.getSpecialCode());
				codeMarkTypeList = codeMarkTypeService.selectListByParams(parmMap);//查询专项库对应的标签
			}
		}else{
			midBaseInfoDto = new MidBaseInfoDto();
			codeMarkTypeList = new ArrayList<CodeMarkType>();
			drandomSpecialEnt = new DrandomSpecialEnt();
			drandomSpecialEnt.setCreatTime(new Date());
			drandomSpecialEnt.setSetUserName(sysUser.getRealName());;
		}
		List<CodeSpecialType> codeSpecialTypeList = null;
		if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
			Map<String,Object> params = new HashMap<String,Object>();
			String dutyDeptCodes = sysUser.getDutyDeptCodes();
			params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
			params.put("isVlid", "1");
			codeSpecialTypeList = codeSpecialTypeService.selectListByParams(params);
		}
	    view.addObject("codeSpecialTypeList", codeSpecialTypeList);
	    view.addObject("sysUser", sysUser);
	    view.addObject("drandomSpecialEnt", drandomSpecialEnt);
	    view.addObject("viewFlag", viewFlag);
	    view.addObject("midBaseInfoDto", midBaseInfoDto);
	    view.addObject("codeMarkTypeList", codeMarkTypeList);
	    view.addObject("regStateName", regStateName);
	    view.addObject("dutyDeptCode", sysUser.getDutyDeptCodes());
		return view;
	}
	
	/**
	 * 描述：添加或修改(只用作协同除工商部门以外)
	 * 
	 * @author chenxin
	 * @date 2017-09-13
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveorupdate", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAppointEnt(DrandomSpecialEnt drandomSpecialEnt,HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		return drandomSpecialEntService.saveOrUpdateDrandomSpecialEnt(drandomSpecialEnt, sysUserDto);
	}
	
	/**
	 * 描述：excel批量导入跨部门专项库(只用作协同除工商部门以外)
	 * @author yujingwei
	 * @date 2017年3月13日 
	 * @throws Exception
	 */
	@RequestMapping("/exceldownload")
	public ResponseEntity<byte[]> excelDownload(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/syn/system/sccheck/specialent")+File.separator+"special.xlsx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("检查主体名单导入模板.xlsx".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	/**
	 * 描述：excel批量导入跨部门专项库(只用作协同除工商部门以外)
	 * @author chenxin
	 * @date 2017-9-13
	 * @param file 导入excel文件
	 * @param dutyDeptCode  职能部门编码
	 * @param dutyDeptName 职能部门名称
	 * @param subjectType 主体类型
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value="/addexcel",method= RequestMethod.POST)
    @ResponseBody
    public void addbatch(@RequestParam("file") MultipartFile file,String subjectType,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        JSONObject json = drandomSpecialEntService.saveExcelBatch(in, sysUser,subjectType);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }

	/**
	 * 描述：添加或修改(只用作协同除工商部门以外)
	 * 
	 * @author chenxin
	 * @date 2017-09-13
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public MidBaseInfoDto doSearchEnt(@RequestBody Map<String, Object> parmMap) throws Exception {
		if(parmMap==null || parmMap.get("keyword") == null){
			return new MidBaseInfoDto();
		}
		StringUtil.paramTrim(parmMap);
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectForDrandomByKeyword(parmMap);
		
		if(midBaseInfoDto == null){
			return new MidBaseInfoDto();
		}
		CodeRegState codeRegState = codeRegStateService.selectCsStateDesc(midBaseInfoDto.getRegState());
		if(codeRegState != null){
			String regStateName = codeRegState.getCsStateDesc();
			midBaseInfoDto.setRegStateDesc(regStateName);
		}
		return midBaseInfoDto;
	}
}