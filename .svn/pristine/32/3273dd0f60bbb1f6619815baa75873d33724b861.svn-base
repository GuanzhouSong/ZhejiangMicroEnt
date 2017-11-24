/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.cs.base.service.ICodeDzLicenseService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_code_dz_license 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping("/common/system/codedzlicense")
public class CodeDzLicenseController extends BaseController {
	
	@Autowired
	private ICodeDzLicenseService codeLicenseService ;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	@Autowired
	private ISysLogService sysLogService;
	
	/**
	 * 
	 * 描述   进入后置备案事项列表页面
	 * @author 赵祥江
	 * @date 2016年11月18日 下午4:54:01 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/codeLicenseListPage")
	public ModelAndView codeLicenseListPage() throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/codedzLicense/codedzLicense_list");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入新增页面
	 * @author 赵祥江
	 * @date 2016年11月21日 上午9:28:44 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/codeLicenseAddPage")
	public ModelAndView codeLicenseAddPage(String exaCode) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/codedzLicense/codedzLicense_edit");
		return view;
	}
	
	/**
	 * 
	 * 描述   进入查看页面和修改页面
	 * @author 赵祥江
	 * @date 2016年11月21日 上午9:28:54 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/codeLicenseViewPage")
	public ModelAndView codeLicenseViewPage(String exaCode,String viewFlag,String licType) throws Exception{
		String licDeptTypeStr="";
		ModelAndView view  = new ModelAndView("/syn/system/codedzLicense/codedzLicense_view");
		if("4".equals(viewFlag)){
			view  = new ModelAndView("/syn/system/codedzLicense/codedzLicensesearcg_view");
		}
		CodeDzLicense codeLicense=codeLicenseService.selectCodeLicenseByExaCodeAndLicType(exaCode,licType);
		if(codeLicense!=null&&StringUtil.isNotEmpty(codeLicense.getLicDeptType().trim())){
			String[] licDeptTypeArr=codeLicense.getLicDeptType().split(",");
			for(int i=0;i<licDeptTypeArr.length;i++){
				CodeDutydept codeDutydept=	codeDutydeptService.doSelectCodeDutydeptBydeptCode(licDeptTypeArr[i]);
			    if(codeDutydept!=null){
			    	if(i==licDeptTypeArr.length-1){
			    		licDeptTypeStr+=codeDutydept.getDeptName();
			    	}else{
			    		licDeptTypeStr+=codeDutydept.getDeptName()+",";
			    	}
			    }
			} 
		} 
		view.addObject("licDeptTypeStr", licDeptTypeStr); 
		view.addObject("codeLicense", codeLicense);
		view.addObject("viewFlag", viewFlag);
		return view;
	}
	
	/**
	 * 
	 * 描述   分页查询后置备案事项列表
	 * @author 赵祥江
	 * @date 2016年11月21日 上午9:57:27 
	 * @param 
	 * @return PageResponse<CodedzLicense>
	 * @throws
	 */
	@RequestMapping({"/selectCodeLicenseSearchList.json","list.xml"})
	@ResponseBody
	public PageResponse<CodeDzLicense> selectCodeLicenseSearchList(PageRequest request)throws Exception{
		Map<String,Object> queryMap= request.getParams();
		if(queryMap==null){
			queryMap=new HashMap<String,Object>();
		} 
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap);
		List<CodeDzLicense> codeLicenseList= codeLicenseService.selectCodeLicenseSearchList(request);
		return new PageResponse<CodeDzLicense>(codeLicenseList);
	}
	
	/**
	 * 
	 * 描述   保存后置备案事项
	 * @author 赵祥江
	 * @date 2016年11月21日 上午9:21:19 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitCodeLicense", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitAuditPubOpanoMaly(@RequestBody CodeDzLicense codeLicense,HttpSession session) throws Exception {
		codeLicense.setCreateTime(DateUtils.getSysDate());
		CodeDzLicense codeLicenseTem=codeLicenseService.selectCodeLicenseByExaCodeAndLicType(codeLicense.getExaCode(), "2");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userType=sysUser.getUserType();
		String msg=""; 
		if(codeLicenseTem!=null){ 
			if(codeLicenseService.updateCodeLicenseByExaCode(codeLicense)>0){
				if("2".equals(userType)){
					msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了修改操作:后置备案事项编码:"+codeLicense.getExaCode()+",后置备案事项名称:"+codeLicense.getExaName();
				}else{
					msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了修改操作:后置备案事项编码:"+codeLicense.getExaCode()+",后置备案事项名称:"+codeLicense.getExaName();
				}
				codeLicenseTem.setExaName(msg);
				this.saveLog(codeLicenseTem, userType);
				return AjaxResult.success("保存成功!");
			}
		}else{
			if(codeLicenseService.insertCodeLicenseByExaCode(codeLicense)>0){
				if("2".equals(userType)){
					msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了新增操作:后置备案事项编码:"+codeLicense.getExaCode()+",后置备案事项名称:"+codeLicense.getExaName();
				}else{
					msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了新增操作:后置备案事项编码:"+codeLicense.getExaCode()+",后置备案事项名称:"+codeLicense.getExaName();
				}
				codeLicense.setExaName(msg);
				this.saveLog(codeLicense, userType);
				return AjaxResult.success("保存成功!");
			}
		} 
		return AjaxResult.error("保存失败!");
	}  
	
	
	
	/**
	 * 
	 * 描述   根据备案事项编码删除
	 * @author 赵祥江
	 * @date 2016年11月18日 下午4:56:17 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/deleteCodeLicense")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult delete(String exaCode,HttpSession session) throws Exception{
		if (StringUtil.isNotEmpty(exaCode)) {
			CodeDzLicense codeLicense=codeLicenseService.selectCodeLicenseByExaCode(exaCode);
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			String userType=sysUser.getUserType();
			String msg="";
			if("2".equals(userType)){
				msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了删除操作:后置备案事项编码:"+exaCode+",后置备案事项名称:"+codeLicense.getExaName();
			}else{
				msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了删除操作:后置备案事项编码:"+exaCode+",后置备案事项名称:"+codeLicense.getExaName();
			}
			codeLicense.setExaName(msg);
			//保存日志
			this.saveLog(codeLicense, userType);
			if(codeLicenseService.deleteCodeLicenseByExaCode(exaCode)>0){
				return AjaxResult.success("删除成功!");
			}
		}
		return  AjaxResult.error("删除失败");
	}
	
	
	/**
	 * 
	 * 描述   进入许可备案查询页面
	 * @author 赵祥江
	 * @date 2016年12月9日 下午5:12:50 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/codeLicenseSearchPage")
	public ModelAndView codeLicenseSearchPage() throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/codedzLicense/codedzLicensesearch_list");
		return view;
	}
	
	
	/**
	 * 
	 * 描述   保存日期
	 * @author 赵祥江
	 * @date 2017年1月6日 上午11:48:37 
	 * @param 
	 * @return void
	 * @throws
	 */
    private void saveLog(CodeDzLicense codeLicense,String userType){
        try{
        	Map<String,String> logMap=new HashMap<String,String>();
             if("2".equals(userType)){
            	logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SYN);//协同系统
            }else{
            	logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SERVER);//警示系统
            }  
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());//年份
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, codeLicense.getExaName());
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.codeDzLicenseLog.getCode());//操作类型
            sysLogService.doAddSysLog(logMap,getRequest());
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	
	
}