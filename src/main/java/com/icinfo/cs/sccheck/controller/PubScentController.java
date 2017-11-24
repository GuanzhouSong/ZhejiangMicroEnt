/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Controller
@RequestMapping({"/reg/server/sccheck/pubscent","/syn/server/sccheck/pubscent"})
public class PubScentController extends CSBaseController {
	
	@Autowired
	private IPubScentService pubScentService;
	
	
	/**
	 * 
	 * 描述: 通过部门任务id分页查询已抽取的企业
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list.json",method= RequestMethod.GET)
    @ResponseBody
    public PageResponse<PubScentDto> listJSON(PageRequest request,HttpSession session) throws Exception {
		List<PubScentDto> data = null;
		data = pubScentService.selectPubScentDtoList(request);
        return new PageResponse<PubScentDto>(data);
    }
	
	/**
	 * 描述: 进入任务指派列表页面
	 * @auther chenxin
	 * @date 2017年7月4日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("appointlistpage")
	public ModelAndView enterAppointListpage(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/scent/scentappoint_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
	    view.addObject("sysUser", sysUser);
	    view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
	 * 描述：任务指派列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("appointlist.json")
	@ResponseBody
	public PageResponse<PubScentDto> appointEntResultlistJSON(PageRequest request, HttpSession session) throws Exception {
//		creatDefaultDBAuthEnv(request, "k.UnitDeptCode", "k.UnitDeptCode");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if("2".equals(sysUserDto.getUserType()) && StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return  new PageResponse<PubScentDto>(null); 
		}
		Map<String,Object> queryMap = request.getParams();
		if(queryMap == null){
			queryMap = new HashMap<String,Object>();
		}
		if(queryMap != null){
			StringUtil.paramTrim(queryMap);
		}
		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		if(deptCode.length() > 8){
			deptCode = deptCode.substring(0, 8);
		}else if (deptCode.length() == 6){
			deptCode = deptCode+"00";
		}
		String unitDeptCodes = "";
		if(queryMap != null && queryMap.get("unitDeptCodes") != null){
			unitDeptCodes = (String)queryMap.get("unitDeptCodes");
		}
		if("2".equals(sysUserDto.getUserType()) && "A058".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A027".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A012".indexOf(sysUserDto.getDutyDeptCodes()) == -1){
			deptCode = sysUserDto.getSysDepart().getAdcode();
			queryMap.put("crossType", "Y");
		}else{
			queryMap.put("crossType", "N");
		}
		if(StringUtils.isNotEmpty(unitDeptCodes)){
			queryMap.put("unitDeptCodeArr", unitDeptCodes.split(","));
		}else{
			queryMap.put("unitDeptCode", deptCode);
		}
		setDefaultParams(sysUserDto, queryMap);
		List<PubScentDto> pubScentResultDtos = pubScentService.queryPageResult(request, sysUserDto);
		return new PageResponse<PubScentDto>(pubScentResultDtos);
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
	 * 描述: 进入任务指派页面
	 * @auther chenxin
	 * @date 2017年7月4日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("appointpage")
	public ModelAndView appointpage(HttpSession session,String uids) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/scent/scent_appoint");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if("1".equals(sysUser.getUserType()) || "A058".indexOf(sysUser.getDutyDeptCodes()) != -1
				|| "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
						|| "A027".indexOf(sysUser.getDutyDeptCodes()) != -1){
			view.addObject("deptFlag", "Y");
		}else{
			view.addObject("deptFlag", "N");
		}
		view.addObject("dutyDeptCode", sysUser.getDutyDeptCodes());
		view.addObject("sysUser", sysUser);
		view.addObject("uids", uids);
		return view;
	}
	
	/**
	 * 描述：清除待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appoint", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAppointEnt(@RequestParam String uids,String appointLocalAdm,HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentService.doAppointEnts(uids,appointLocalAdm,sysUserDto)){
			return AjaxResult.success("指派成功");
		}
		return AjaxResult.error("指派失败");
	}

	/**
	 * 描述: 进入已抽取企业列表
	 * @auther chenxin
	 * @date 2017年7月4日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("entlistpage")
	public ModelAndView enterEntListpage(HttpSession session,String taskUid) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/scent/scentshow_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
	    view.addObject("sysUser", sysUser);
	    view.addObject("taskUid", taskUid);
		return view;
	}

	/**
	 * 描述：查询已抽取企业列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("entlist.json")
	@ResponseBody
	public PageResponse<PubScentDto> entListJSON(PageRequest request, HttpSession session) throws Exception {
		List<PubScentDto> pubScentResultDtos = pubScentService.queryEntPage(request);
		return new PageResponse<PubScentDto>(pubScentResultDtos);
	}
	
	/**
	 * 
	 * 描述: 抽查查询结果统计
	 * 
	 * @auther chenxin
	 * @date 2017年5月17日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "scEntCountTask", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult scEntCountTask(PageRequest request) throws Exception {
		Map<String,Object> params = request.getParams();
		if(params != null && params.get("taskUid") != null){
			String taskUid = (String)params.get("taskUid");
			PubScentDto pubScentDto = pubScentService.selectEntCountByTaskUid(taskUid);
			return AjaxResult.success("", pubScentDto);
		}else{
			return AjaxResult.error("");
		}
	}
	
	/**
	 * 描述：抽查名单导出
	 * @author yujingwei
	 * @date 2017年3月13日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/downExcel")
	public ResponseEntity<byte[]> commitment(HttpServletRequest request, String taskUid)throws Exception{
		String realPath = "";
		String fileName = "";
		String url = request.getSession().getServletContext().getRealPath("WEB-INF/views/page/syn/system/sccheck")+File.separator;
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
}