package com.icinfo.cs.other.controller.reg.server;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.service.IPubJusticeInfoHisService;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.service.IPubServerHisModService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;



@Controller("ServerPubJusticeInfoAudit")
@RequestMapping({"/reg/other/pubjusticeinfoaudit","/syn/other/pubjusticeinfoaudit"})
public class PubJusticeInfoAuditController extends BaseController{
    
	
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
	
	/**
	 * 
	 * 描述: 进入司法协助录入审核页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfoaudit_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if(sysUser.getUserType().equals("1")){
		      view.addObject("urlType", "/reg");
		}else{
		      view.addObject("urlType","/syn");
		      view.addObject("deptCode", sysUser.getDeptCode());
		}
		return view;
	}
	
	/**
	 * 描述: 进入司法协助录入审核页面
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/auditView")
	public ModelAndView doAuditView(String pripid, String UID,HttpSession session) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/other/pubjusticeinfo/pubjusticeinfoaudit_audit");
		if(StringUtil.isNotBlank(pripid) && StringUtil.isNotBlank(UID)){
			PubJusticeInfo pubJusticeInfo = pubJusticeInfoService.doGetPubJusticeInfo(pripid,UID);
			view.addObject("pubJusticeInfo", pubJusticeInfo);
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
		view.addObject("codeCertypeList", codeCertypeList);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}
	
	/**
     * 司法协助提交审核
     * @author yujingwei
     * @date 2016-10-17
     * @param priPID,caseNO
     * @return AjaxResult
     * @throws Exception
     */
    @RequestMapping(value = "commit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(PubJusticeInfo pubJusticeInfo,HttpSession seesion) throws Exception{
    	SysUser sysUser = (SysUser) seesion.getAttribute(Constants.SESSION_SYS_USER);
    	try {
    		if(pubJusticeInfo !=null){
        		boolean commitFlag = pubJusticeInfoService.doCommitJusticeInfo(pubJusticeInfo,sysUser);
        		if(commitFlag){
        			return AjaxResult.success("提交成功！");
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("提交失败！"+e.getMessage());
		}
    	return AjaxResult.error("提交失败！");
    }
}
