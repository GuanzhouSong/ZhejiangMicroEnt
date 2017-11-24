/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.controller.reg.server;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubEppasswordHis;
import com.icinfo.cs.login.model.PubPhoneapply;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPhoneapplyService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_phoneapply 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller("ServerPubPhoneApplyController")
@RequestMapping("/reg/server/login/phoneapply")
public class PubPhoneApplyController extends CSBaseController {
	
	@Autowired
	private IPubPhoneapplyService  pubPhoneapplyService;
	
	@Autowired
	private IPubEppasswordService PubEppasswordService;
	
	@Autowired
	private ICodeCertypeService codeCertypeService;
	
	@Autowired
	private ISmsService smsService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 
	 * 描述: 进入联络员确认通知书列表页面
	 * @auther yujingwei
	 * @date 2016年8月28日 
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list() throws Exception{
		return "reg/server/login/pubeppassword_list";
	}
	
	/**
     * 描述：获取列表Json数据
     * @author yujingwei
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	@RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<PubPhoneapply> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"b.CheckDep","LocalAdm");
		List<PubPhoneapply> pubPhoneapplyList = pubPhoneapplyService.queryPage(request);
		if(CollectionUtils.isNotEmpty(pubPhoneapplyList)){
			for(PubPhoneapply pubPhoneapply : pubPhoneapplyList){
				//如果统一代码为空则显示注册号
				String regnoForView =(pubPhoneapply.getUnicode() ==null 
						|| pubPhoneapply.getUnicode().equals(""))?pubPhoneapply.getRegno():pubPhoneapply.getUnicode();
				pubPhoneapply.setRegno(regnoForView);
			}
		}
        return new PageResponse<PubPhoneapply>(pubPhoneapplyList);
    }
	
	/**
	 * 描述：获取确认书历史列表Json数据
	 * @param  request
	 * @author yujingwei
	 * @return PageResponse
	 * @throws Exception
	 */
	@RequestMapping("/list_his.json")
	@ResponseBody
	public PageResponse<PubEppasswordHis> listForHisJSON(PageRequest request) throws Exception {
		List<PubEppasswordHis> data = PubEppasswordService.queryPageForHis(request);
		return new PageResponse<PubEppasswordHis>(data);
	}
	
	/**
	 * 描述：进入联络员确认接收详细页面
	 * @author yujingwei
	 * @return view
	 * @param pasid,pripid
	 * @throws Exception
	 */
	@RequestMapping(value = "/option")
	public ModelAndView accept(String pasid,String pripid) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/login/pubphoneapply_edit");
		if(StringUtil.isNotEmpty(pasid) && StringUtil.isNotEmpty(pripid)){
			PubPhoneapply pubPhoneapply =  pubPhoneapplyService.selectPubPhoneApplyInfo(pasid,pripid);
			List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
			view.addObject("codeCertypeList", codeCertypeList);
			view.addObject("pubPhoneapply",pubPhoneapply);
		}
		return view;
	}
	
	/**
	 * 描述：联络员回执单打印
	 * @author yujingwei
	 * @param pasid,regno
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value = "/print")
	public ModelAndView doPrint(String pasid,String regno) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/login/pubphone_print");
		if(StringUtil.isNotEmpty(pasid) && StringUtil.isNotEmpty(regno)){
			HashMap<String, Object> map  = new HashMap<String, Object>();
			map.put("pasid", pasid);
			map.put("regno", regno);
			PubEppassword pubEppassword =  PubEppasswordService.selectPubEppasswordForPrint(map);
			List<CodeCertype> codeCertypeList = codeCertypeService.selectAll();
			view.addObject("codeCertypeList",codeCertypeList);
		    view.addObject("pubEppassword",pubEppassword);
		}
		return view;
	}
	
	/**
	 * 描述：短信发送
	 * @date 2016-9-10
	 * @param entname,lianame,tel
	 * @author yujingwei
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/doSendMsg")
	@ResponseBody
	public AjaxResult doSend(String entname,String lianame,String tel,String priPID) throws Exception {
		try {
			MidBaseInfo midBaseInfo = midBaseInfoService.selectByPripid(priPID);
			String msgContent = entname+DateUtil.dateToString(new Date(),"yyyy-MM-dd")+"确认"+lianame+"为联络员，授权其登录企业信用信息公示系统报送年度报告等法定信息。";
			smsService.doSendMsg(tel, msgContent,midBaseInfo != null?midBaseInfo.getRegOrg():null);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("短信发送失败,请稍后重试！");
		}
		return AjaxResult.success("短信发送成功！");
	}
	
	/**
	 * 描述：确认书接收
	 * @author yujingwei
	 * @return AjaxResult
	 * @param pasid,session
	 * @throws Exception
	 */
	@RequestMapping(value = "/doAccept")
	@ResponseBody
	public AjaxResult doAccept(String pasid,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		try {
		    boolean acceptFlag = pubPhoneapplyService.acceptPubPhoneApply(pasid,sysUser);
			if(acceptFlag == true){
				return AjaxResult.success("接收成功！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			AjaxResult.error("接收失败！"+ex.getMessage());
		}
		return AjaxResult.error("接收失败！");
	}
	
	
}