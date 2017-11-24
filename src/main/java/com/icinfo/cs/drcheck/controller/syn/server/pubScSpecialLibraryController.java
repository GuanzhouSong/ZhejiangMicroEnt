/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.model.pubScSpecialLibrary;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scspecial_library 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月19日
 */
@Controller
@RequestMapping({"/syn/server/drcheck/specialcheck","/reg/server/drcheck/specialcheck"})
public class pubScSpecialLibraryController extends CSBaseController {
	
	@Autowired
	private IpubScSpecialLibraryService pubScSpecialLibraryService;
	
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private IRegistMarkService registMarkService;
	
	
	/**
	 * 描述: 进入专项检查对象主体库
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_list");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	/**
	 * 描述: 进入专项检查对象主体库添加页面
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("addview")
	public ModelAndView doEnAddView(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	/**
	 * 描述   进入信息添加页面
	 * @author yujingwei
	 * @date 2017年4月19日 
	 * @return view
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView doAddOrEditView(String priPID , String uid , String viewFlag) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_edit");
		if(StringUtil.isNotEmpty(uid)){
			pubScSpecialLibrary pubScSpecialLibrary = pubScSpecialLibraryService.doGetScSpecialInfoByUid(uid); 
			view.addObject("pubScSpecialLibrary", pubScSpecialLibrary);
		}
		MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(priPID);
		view.addObject("baseInfo", baseInfo);
		view.addObject("viewFlag", viewFlag);
		return view;
	}
	
	/**
	 * 描述: 专项检查对象主体库查询
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<pubScSpecialLibrary> listJSON(PageRequest request,HttpSession session) throws Exception {
		creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		creatDefaultDBAuthEnv(parmMap,"t.regOrg","t.localAdm");
		List<pubScSpecialLibrary> data = pubScSpecialLibraryService.doGetScSpecialLibraryList(request);
		return new PageResponse<pubScSpecialLibrary>(data);
	}
	
	/**
	 * 描述: 专项检查对象主体库统计（录入）
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/optcount.json")
	@ResponseBody
	public List<pubScSpecialLibraryDto> initOptCountJSON(@RequestBody Map<String, Object> parmMap,HttpSession session) throws Exception {
		creatDefaultDBAuthEnv(parmMap,"t.regOrg","t.localAdm");
//		creatOptDBAuthEnv(parmMap,"m.CheckDep","t.LocalAdm");
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		List<pubScSpecialLibraryDto> infos = pubScSpecialLibraryService.doGetScSpecialOptInitTotal(parmMap);
		return infos;
	}
	
	/**
	 * 描述: 专项检查对象主体库查询
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/count.json")
	@ResponseBody
	public List<pubScSpecialLibraryDto> initCountJSON(@RequestBody Map<String, Object> parmMap,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		parmMap.put("setUserUid", sysUser.getId());
		List<pubScSpecialLibraryDto> infos = pubScSpecialLibraryService.doGetScSpecialInitTotal(parmMap);
		return infos;
	}
	
	/**
	 * 获取查询企业列表
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
		StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}
	
	/**
	 * 描述：保存或修改企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=2000)
	public AjaxResult doSaveOrEditFavorableInfo(pubScSpecialLibrary pubScSpecialLibrary,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScSpecialLibrary == null)
			return AjaxResult.success("保存失败！");
		pubScSpecialLibrary.setSetUserName(sysUser.getRealName());
		pubScSpecialLibrary.setSetUserUid(sysUser.getId());
		pubScSpecialLibrary.setSetTime(new Date());
		if(sysUser.getDepartMent() != null && StringUtils.isNotEmpty(sysUser.getDepartMent().getDeptName())){
			pubScSpecialLibrary.setSetDeptName(sysUser.getDepartMent().getDeptName());
		}
		if(sysUser.getDepartMent() != null && StringUtils.isNotEmpty(sysUser.getDepartMent().getDeptCode())){
			pubScSpecialLibrary.setSetDeptcode(sysUser.getDepartMent().getDeptCode());
		}
		if(StringUtil.isNotEmpty(pubScSpecialLibrary.getUid())){
			if(pubScSpecialLibraryService.doUpdateScSpecialInfo(pubScSpecialLibrary,pubScSpecialLibrary.getUid(),sysUser) > 0){
				return AjaxResult.success("保存成功！");
			}
		}else{
			if(pubScSpecialLibraryService.doSaveScSpecialInfo(pubScSpecialLibrary,sysUser) > 0){
				return AjaxResult.success("保存成功！");
			}
		}
		return AjaxResult.error("保存失败！");
	}
	
	/**
	 * 描述: 进入专项库树选择页面
	 * @auther yujingwei
	 * @date 2017年4月20日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("scSpecialSelect")
	public ModelAndView toOrgTreeView(String isPermissionCheck) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_tree");
		view.addObject("isPermissionCheck", isPermissionCheck);
		return view;

	}
	
	/**
	 * 描述   进入许可证选择页面（复选）
	 * @author yujingwei
	 * @date 2016年10月19日 上午9:51:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/licenseListCheckboxTreePage")
	public ModelAndView licenseListCheckboxTreePage(HttpSession session,String isRadio) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdtinfo/licenseListcheckboxtree"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); //登录人员
		view.addObject("userType", sysUser.getUserType());
		view.addObject("isLisence", true);
		view.addObject("isRadio", isRadio);
		return view;
	}
	

	/**
	 * 描述: 进入监管标签复选页面
	 * @auther yujingwei
	 * @date 2017年4月26日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("markTreeView")
	public ModelAndView toMarkTreeView(String isMarkFlag) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_tree");
		view.addObject("isMarkFlag", isMarkFlag);
		return view;

	}
	
	/**
	 * 描述: 获取专项库树 数据
	 * @auther yujingwei
	 * @date 2017年4月20日
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/markTreeJSON")
	@ResponseBody
	public AjaxResult markTreeJSON() throws Exception {
		List<Map<String, Object>> data = pubScSpecialLibraryService.selectToMarkTreeMap();
		return AjaxResult.success("查询成功", data);
	}
	
	/**
	 * 描述: 获取专项库树 数据
	 * @auther yujingwei
	 * @date 2017年4月20日
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/treeListJSON")
	@ResponseBody
	public AjaxResult treeListJSON(String isPermissionCheck) throws Exception {
		List<Map<String, Object>> data = pubScSpecialLibraryService.selectToTreeMap(isPermissionCheck);
		return AjaxResult.success("查询成功", data);
	}
	
	/**
	 * 描述: 通过专项库编码获取标签编码
	 * @auther yujingwei
	 * @date 2017年4月20日
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping("/getMarkInfo")
	@ResponseBody
	public AjaxResult getMarkInfo(String Code) throws Exception {
		List<RegistMark> registMarkList = registMarkService.doGetRegistMarkInfoForDrcheck(Code);
		return AjaxResult.success("查询成功", registMarkList);
	}
	
	/**
	 * 检查主体名单导入模板下载
	 * @author yujingwei
	 * @date 2017年3月13日 
	 * @throws Exception
	 */
	@RequestMapping("/scSpecialDown")
	public ResponseEntity<byte[]> commitment(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF/views/page/syn/system/drcheck/scspecial")+File.separator+"spLibrary.xlsx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("检查主体名单导入模板.xlsx".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	/**
	 * 描述：抽查名单导出
	 * @author yujingwei
	 * @date 2017年3月13日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/downExcel")
	public ResponseEntity<byte[]> exportExcel(HttpServletRequest request, String taskUid)throws Exception{
		String realPath = "";
		String fileName = "";
		String url = request.getSession().getServletContext().getRealPath("WEB-INF/views/page/syn/system/drcheck/scspecial")+File.separator;
		if("D1F4D797EFDC480E9B77A4A9B5B01CD5".equals(taskUid)){
			realPath = url+"check01.xlsx";
			fileName = new String("浙江省广告经营企业广告业务专项检查活动.xlsx".getBytes("GBK"),"iso-8859-1");
		}
		if("4C41AB5D21DC41238A51F4CD3C03D0AA".equals(taskUid)){
			realPath = url+"check02.xlsx";
			fileName = new String("浙江省失信被执行人关联企业专项抽查.xlsx".getBytes("GBK"),"iso-8859-1");
		}
		if("BF98C3ED240A4F1D823EE20A1A374A51".equals(taskUid)){
			realPath = url+"check03.xlsx";
			fileName = new String("浙江省2016年度企业年报公示信息及登记事项抽查.xlsx".getBytes("GBK"),"iso-8859-1");
		}
		if("EE49977C87A248F496E86076D48B231A".equals(taskUid)){
			realPath = url+"check04.xlsx";
			fileName = new String("浙江省直销经营企业专项抽查活动.xlsx".getBytes("GBK"),"iso-8859-1");
		}
		File file=new File(realPath);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	 /**
     * 描述：excel批量导入检查主体名单
     * @author yujingwei
     * @date 2016-10-26
     * @throws Exception
     */
	@RequestMapping(value="/addbatch",method= RequestMethod.POST)
    @ResponseBody
    public void addbatch(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        Map<String, Object> resultMap = pubScSpecialLibraryService.doSaveSpLibraryInfoExcelBatch(in , sysUser);
        JSONObject json = new JSONObject();
        if(resultMap != null){
        	json.put("status", "success");
            json.put("errorInfo", resultMap.get("errorInfo"));
        }else{
        	json.put("status", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	
	/**
	 * 描述   进入信息添加页面
	 * @author yujingwei
	 * @date 2017年4月19日 
	 * @return view
	 */
	@RequestMapping("/countview")
	public ModelAndView doCountView(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_count");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(("1".equals(sysUser.getUserType()) && sysUser.getDepartMent()!=null) || ("2".equals(sysUser.getUserType()) && sysUser.getSysDepart() !=null)){
			if("1".equals(sysUser.getUserType())){
				deptCode=sysUser.getDepartMent().getDeptCode();
			}else{
				deptCode=sysUser.getSysDepart().getAdcode();
			}
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("startCheckPushDate", DateUtil.getYear()+"-01-01");  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 描述: 专项库统计
	 * @auther chenxin
	 * @date 2017年4月24日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping({"/countlist.json","list.xml"})
	@ResponseBody
	public PageResponse<pubScSpecialLibraryDto> countJSON(PageRequest request) throws Exception {
		List<pubScSpecialLibraryDto> data = pubScSpecialLibraryService.selectScSpecialLibraryCount(request);
		return new PageResponse<pubScSpecialLibraryDto>(data);
	}
	
	
	/**
	 * 描述: 进入专项检查对象主体库
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/search")
	public ModelAndView search() throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scspecial/scspecial_sear_list");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
	 * 描述: 专项检查对象主体库查询
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/searchlist.json")
	@ResponseBody
	public PageResponse<pubScSpecialLibrary> searchlistJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"regOrg","localAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<pubScSpecialLibrary> data = pubScSpecialLibraryService.doGetScSpecialLibraryInfo(request);
		return new PageResponse<pubScSpecialLibrary>(data);
	}
	
	/**
	 * 描述: 专项检查对象主体库查询
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/searchcount.json")
	@ResponseBody
	public List<pubScSpecialLibraryDto> initSearchCountJSON(@RequestBody Map<String, Object> parmMap) throws Exception {
		creatDefaultDBAuthEnv(parmMap,"t.regOrg","t.localAdm");
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		List<pubScSpecialLibraryDto> infos = pubScSpecialLibraryService.doGetScSpecialInitTotal(parmMap);
		return infos;
	}
	
}