/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.OssClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScWorkPlanDto;
import com.icinfo.cs.sccheck.model.PubScWorkPlan;
import com.icinfo.cs.sccheck.service.IPubScWorkPlanService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.DeptTree;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scwork_plan 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Controller
@RequestMapping({ "/syn/sccheck/pubscworkplan", "/reg/server/sccheck/pubscworkplan" })
public class PubScWorkPlanController extends CSBaseController{ 
	@Autowired
	private IPubScWorkPlanService pubScWorkPlanService;
	
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	
	@Value("${cloudModel}")
	private String cloudModel;
	
	@Autowired
	private OssClient ossClient;
	
	/**
	 * 
	 * 描述   进入抽查工作计划列表页面
	 * @author 赵祥江
	 * @date 2017年5月17日 上午9:25:44 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubScWorkPlanListPage")
	public ModelAndView pubScWorkPlanListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/sccheck/scworkplan/scworkplan_list");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl); 
		List<String> yearList= DateUtil.getYearToNow();
		view.addObject("yearList", yearList);
		view.addObject("thisYear", DateUtil.getYear());
		return view;
	}
	
	/**
	 * 
	 * 描述   进入新增或修改 详情 页面
	 * @author 赵祥江
	 * @date 2017年5月17日 上午10:42:58 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView addOrEditView(HttpSession session,String uid,String flag) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/sccheck/scworkplan/scworkplan_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		String deptName="";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
			deptName=sysUser.getSysDepart().getOrgName();
		}else{
			deptName=sysUser.getDepartMent().getDeptName();
		}
		//详情
		if("3".equals(flag)){
			view  = new ModelAndView("/syn/system/sccheck/scworkplan/scworkplan_detail");
		}
		if(StringUtil.isNotBlank(uid)){
			PubScWorkPlan pubScWorkPlan = pubScWorkPlanService.selectPubScWorkPlanByUid(uid);
			view.addObject("pubScWorkPlan", pubScWorkPlan);
		}
		List<CodeDutydept> codeDutydepts = new ArrayList<CodeDutydept>();
		if("1".equals(sysUser.getUserType())){
			CodeDutydept codeDutydept = new CodeDutydept();
			codeDutydept.setDeptCode("A058");
			codeDutydept.setDeptName("工商部门");
			codeDutydepts.add(codeDutydept);
		}else{
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				Map<String,Object> params = new HashMap<String,Object>();
				codeDutydepts = codeDutydeptService.selectByParams(params);
			}else{
				CodeDutydept codeDutydept = new CodeDutydept();
				codeDutydept.setDeptCode("");
				codeDutydept.setDeptName("您的账号未设置职能部门");
				codeDutydepts.add(codeDutydept);
			}
		}
		view.addObject("codeDutydepts", codeDutydepts);
		view.addObject("deptName", deptName);
		view.addObject("sysUrl", sysUrl);
		view.addObject("flag", flag);
		view.addObject("sysUser", sysUser);
		List<String> yearList= DateUtil.getYearToNow();
		view.addObject("yearList", yearList);
		return view;
	}
	
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年5月17日 上午10:35:48 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String uid) throws Exception{
		if (StringUtil.isNotBlank(uid)) { 
			try {
				if(pubScWorkPlanService.deletePubScWorkPlanByUid(uid)>0){
					return AjaxResult.success("删除成功");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}   
		}
		return  AjaxResult.error("删除失败");
	}
	
	/**
	 * 
	 * 描述   提交
	 * @author 赵祥江
	 * @date 2017年5月17日 上午10:41:18 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitPubScWorkPlan", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitPubScWorkPlan(@RequestBody PubScWorkPlan pubScWorkPlan,HttpSession session) throws Exception { 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		pubScWorkPlan.setSetUserUid(sysUser.getId());
		pubScWorkPlan.setSetUserName(sysUser.getRealName());
		pubScWorkPlan.setSetTime(DateUtil.getSysDate());
		pubScWorkPlan.setPlanState("01");
		if("2".equals(sysUser.getUserType())){
			pubScWorkPlan.setSetDeptName(sysUser.getSysDepart().getOrgName());
			pubScWorkPlan.setSetDeptCode(sysUser.getSysDepart().getAdcode());
		}else{
			pubScWorkPlan.setSetDeptName(sysUser.getDepartMent().getDeptName());
			pubScWorkPlan.setSetDeptCode(sysUser.getDepartMent().getDeptCode());
		}
		//修改
		if(pubScWorkPlan!=null&&StringUtil.isNotBlank(pubScWorkPlan.getUid())){
			boolean flag=false;
			List<PubScWorkPlan> pubScWorkPlanList= pubScWorkPlanService.selectPubScWorkPlanByPlanName(pubScWorkPlan.getPlanName().trim());
			if(pubScWorkPlanList.size()>0){
				for(PubScWorkPlan pubScWorkPlanTem:pubScWorkPlanList){
					 if(!pubScWorkPlan.getUid().equals(pubScWorkPlanTem.getUid())){
						 flag=true;
						 break;
					 }
				}
			}
			if(flag){
				return AjaxResult.error("抽查活动名称已存在");
			}
			if(pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan)> 0) { 
				return AjaxResult.success("修改成功!");
			} else {
				return AjaxResult.error("修改失败!");
			}
		}else{//新增
			List<PubScWorkPlan> pubScWorkPlanList= pubScWorkPlanService.selectPubScWorkPlanByPlanName(pubScWorkPlan.getPlanName().trim());
			if(pubScWorkPlanList.size()>0){
				return AjaxResult.error("抽查活动名称已存在");
			}
			if (pubScWorkPlanService.insertPubScWorkPlan(pubScWorkPlan)> 0) { 
				return AjaxResult.success("新增成功!");
			} else {
				return AjaxResult.error("新增失败!");
			}
		}
	}
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年5月17日 上午11:20:50 
	 * @param 
	 * @return PageResponse<PubScWorkPlanDto>
	 * @throws
	 */
	@RequestMapping("/selectPubScWorkPlanJSON.json")
	@ResponseBody
	public PageResponse<PubScWorkPlanDto> selectPubScWorkPlanJSON(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		creatDefaultDBAuthEnv(request,"A.SetDeptCode","A.SetDeptCode");
		Map<String,Object>	queryMap=	request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap); 
		if("2".equals(sysUser.getUserType())){
			queryMap.put("deptCode", sysUser.getSysDepart().getAdcode());
		}else{
			queryMap.put("deptCode", sysUser.getDepartMent().getDeptCode());
		}
		if("2".equals(sysUser.getUserType()) && StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
			return  new PageResponse<PubScWorkPlanDto>(null); 
		}
		String pubPlanState = (String) queryMap.get("pubPlanState");
		if (StringUtil.isNotEmpty(pubPlanState)) {
			queryMap.put("pubPlanStates", pubPlanState.split(","));
		}
		setDefaultParams(sysUser, queryMap);
		request.setParams(queryMap);
		List<PubScWorkPlanDto> pubScWorkPlanDtoList=pubScWorkPlanService.queryPubScWorkPlanListJSON(request);
		return  new PageResponse<PubScWorkPlanDto>(pubScWorkPlanDtoList); 
	}
	
	/**
	 * 
	 * 描述: 抽查查询结果统计
	 * 
	 * @auther baifangfang
	 * @date 2017年5月17日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "planCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchSccheckCount(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		creatDefaultDBAuthEnv(request,"A.SetDeptCode","A.SetDeptCode");
		Map<String,Object>	queryMap=	request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap); 
		if("2".equals(sysUser.getUserType())){
			queryMap.put("deptCode", sysUser.getSysDepart().getAdcode());
		}else{
			queryMap.put("deptCode", sysUser.getDepartMent().getDeptCode());
		}
		PubScWorkPlanDto pubScWorkPlanDto = new PubScWorkPlanDto();
		if("2".equals(sysUser.getUserType()) && StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
			return  AjaxResult.success("统计数成功", pubScWorkPlanDto); 
		}
		String pubPlanState = (String) queryMap.get("pubPlanState");
		if (StringUtil.isNotEmpty(pubPlanState)) {
			queryMap.put("pubPlanStates", pubPlanState.split(","));
		}
		setDefaultParams(sysUser, queryMap);
		request.setParams(queryMap);
		pubScWorkPlanDto = pubScWorkPlanService.selectCountAll(queryMap);
		return AjaxResult.success("统计数成功", pubScWorkPlanDto);
	}
	
	/**
	 * 描述：设置默认职能部门参数
	 * @author chenxin
	 * @date 2017-10-12
	 * @param sysUser
	 * @param queryMap
	 */
	private void setDefaultParams(SysUserDto sysUser,Map<String,Object>	queryMap){
		//职能部门编码
		if("1".equals(sysUser.getUserType())){
			queryMap.put("dutyDeptCodes","A058,A012,A027");
		}else if("2".equals(sysUser.getUserType())){
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
				queryMap.put("dutyDeptCodes","A058,A012,A027");
			}else{
				queryMap.put("dutyDeptCodes",sysUser.getDutyDeptCodes());
			}
		}
		if(queryMap.get("dutyDeptCodes")!=null&&StringUtils.isNotBlank(queryMap.get("dutyDeptCodes").toString())){
			queryMap.put("dutyDeptCodeArr",queryMap.get("dutyDeptCodes").toString().split(","));
		}
	}
	
	/**
	 * 
	 * 描述   组装年度工作计划树
	 * @author 赵祥江
	 * @date 2017年5月18日 下午7:15:53 
	 * @param 
	 * @return List<DeptTree>
	 * @throws
	 */
    @RequestMapping("/pubScWorkPlanTree")
    @ResponseBody
    public List<DeptTree> pubScWorkPlanTree(HttpSession session,String planYear)throws Exception{
    	 List<DeptTree> sysDepartList=new ArrayList<DeptTree>();
    	 PageRequest request=new PageRequest();
    	 request.setLength(999999);
    	 Map<String,Object> queryMap=new HashMap<String,Object>();
    	 queryMap.put("planState", "01");
    	 queryMap.put("planYear", planYear);
    	 SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
    	 List<PubScWorkPlanDto> pubScWorkPlanDtoList = null;
    	 if("2".equals(sysUser.getUserType()) && StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
    		 pubScWorkPlanDtoList = new ArrayList<PubScWorkPlanDto>();
 		 }else{
 			 setDefaultParams(sysUser, queryMap);
 			 request.setParams(queryMap);
 			 pubScWorkPlanDtoList=  this.pubScWorkPlanService.queryPubScWorkPlanListJSON(request);
 		 }
    	 if(pubScWorkPlanDtoList.size()>0){
    		 for(PubScWorkPlanDto pubScWorkPlanDto:pubScWorkPlanDtoList){
    			 	DeptTree deptTree=new DeptTree();
		            deptTree.setIsParent("false");
		            deptTree.setOrgCoding(pubScWorkPlanDto.getUid());
		            deptTree.setOrgName(pubScWorkPlanDto.getPlanName());
		            deptTree.setPorgCoding("123456");
		            deptTree.setAdcode(pubScWorkPlanDto.getSetDeptCode());
		            deptTree.setNocheck("false");
		            deptTree.setDutyDeptCode(pubScWorkPlanDto.getPlanName()+";"+DateUtil.formatDate(pubScWorkPlanDto.getPlanStartTime(), "yyyy-MM-dd"));
		            deptTree.setDutyDeptName(pubScWorkPlanDto.getPlanType()+";"+DateUtil.formatDate(pubScWorkPlanDto.getPlanEndTime(), "yyyy-MM-dd"));
		            sysDepartList.add(deptTree);
		            
    		 } 
    	 }
	    //虚拟一个省级节点
        DeptTree deptTree=new DeptTree();
        deptTree.setIsParent("true");
        deptTree.setOrgCoding("123456");
        deptTree.setOrgName("年度抽查工作计划");
        deptTree.setPorgCoding("0");
        deptTree.setAdcode("0");
        deptTree.setNocheck("false");
        sysDepartList.add(deptTree);
        return sysDepartList;
    }
    
    /**
     * 
     * 描述   进入年度抽查计划树页面
     * @author 赵祥江
     * @date 2017年5月18日 下午7:20:59 
     * @param 
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/pubScWorkPlanTreePage")
    public ModelAndView deptSelectCtity(String planYear,String treeType,HttpSession session) throws Exception{
        ModelAndView view  = new ModelAndView("/syn/system/sccheck/scworkplan/scworkplan_tree_list");
        view.addObject("treeType",treeType==null||"".equals(treeType)?"radio":treeType);
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl",sysUrl);
		view.addObject("planYear",planYear);
        return view;
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
	public String upload(@RequestParam(value = "btnFile") MultipartFile file,String prefix) {
		String fileName =prefix +file.getOriginalFilename();
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
	 * @date 2017年5月20日 下午4:46:30 
	 * @param 
	 * @return String
	 * @throws
	 */
	private String uploadToOSS(MultipartFile file, String fileName) {
		boolean flag = false;
		try {
			flag = ossClient.putStream(file, "sccheck/pubscworkplan/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return "update error";
		}
		if (flag) {
			return "sccheck/pubscworkplan/" + fileName;
		} else {
			return "upload error";
		}
	}
	
	/**
	 * 
	 * 描述   获取文件流 下载
	 * @author 赵祥江
	 * @date 2017年5月20日 下午4:46:49 
	 * @param 
	 * @return void
	 * @throws
	 */
	@RequestMapping("/getLetter.json")
	@ResponseBody
	public void getLetter(@RequestParam String fileUrl,String fName,HttpServletResponse response,HttpServletRequest request) throws Exception { 
		byte[] letter = null;
		if (!StringUtil.isEmpty(fileUrl)) {
			try {// 从OSS获取文件流
				letter = ossClient.getStream(fileUrl);
				response.reset();
		        response.setContentType("application/octet-stream");
		        if (request.getHeader("User-Agent").contains("MSIE") || request.getHeader("User-Agent").contains("Trident")) {
		        	fName = java.net.URLEncoder.encode(fName, "UTF-8").replaceAll("\\+", "%20");
				} else {
					// 非IE浏览器的处理
					fName = new String(fName.getBytes("UTF-8"), "ISO-8859-1");
				}
		        // fName = new String(fName.getBytes(), "ISO-8859-1");
		        //response.setHeader("Content-Disposition", "attachment; filename="+fName);
		        response.addHeader("Content-Disposition", "attachment; filename=\"" + fName + "\"");
 				response.getOutputStream().write(letter);
				/*HttpHeaders headers = new HttpHeaders();
				String fileName=new String(fName.getBytes("GBK"),"iso-8859-1");
				headers.setContentDispositionFormData("attachment", fileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", fileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				return new ResponseEntity<byte[]>(letter, headers, HttpStatus.OK);*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}