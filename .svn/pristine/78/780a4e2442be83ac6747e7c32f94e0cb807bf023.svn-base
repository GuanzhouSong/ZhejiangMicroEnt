/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;

/**
 * 描述:    cs_yr_sfc_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/sfcbaseinfo")
public class YrSfcBaseinfoController extends BaseController {
	
	@Autowired
	private IYrSfcBaseinfoService  yrSfcBaseinfoService;
	
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	
	//主表
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	
	//证件类型
	@Autowired
	private ICodeCertypeService codeCertypeService;

	//农专报表状态
	@Autowired
	private ISfcFormService sfcFormService;
	//社保信息表
	@Autowired
	private IYrSfcSocialSecurityService  yrSfcSocialSecurityService;
	//社保信息表
	@Autowired
	private IYrSfcWebsiteInfoService  yrSfcWebsiteInfoService;
	//电子公章
	@Autowired
	private ISignatureService signatureService;


	/**
	 * 
	 * 描述: 进入农专基本信息报表填报页 需要参数主体代码和年份（由登录成功后存入的session中取）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(String year,RedirectAttributes attr) throws Exception{
		String url = "redirect:/reg/client/yr/sfc/sfcbaseinfo/show";
		year = AESEUtil.encodeYear(year); //年份进行加密处理
		attr.addAttribute("year",year);
		return url;
	}
	
	/**
	 * 
	 * 描述: 进入农专基本信息报表填报页 需要参数主体代码和年份（由登录成功后存入的session中取）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(String year,HttpSession session) throws Exception{	
		//登陆成功后进入农专年报填报页
		ModelAndView view = new ModelAndView("/reg/client/yr/sfcyr/sfcreport_edit");
		if(StringUtil.isNotEmpty(year)){
			year = AESEUtil.decodeYear(year); //年份进行解密处理
			//获取session的企业基本信息
	        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
	        String pripid = midBaseInfoDto.getPriPID();

	        //查询年报主表信息
	        YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid,Integer.valueOf(year));
			
			//查询基本信息（）
			YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, pripid,"1");


			 if(yrSfcBaseinfo != null){
	        	view.addObject("yrSfcBaseinfo",yrSfcBaseinfo);
	        }else{
	        	YrSfcBaseinfo yrSfcBaseinfotem = new YrSfcBaseinfo();
	        	yrSfcBaseinfotem.setPriPID(midBaseInfoDto.getPriPID());
	        	yrSfcBaseinfotem.setRegNO(midBaseInfoDto.getRegNO());
	        	yrSfcBaseinfotem.setUniCode(midBaseInfoDto.getUniCode());
	        	yrSfcBaseinfotem.setDom(midBaseInfoDto.getDom());
	        	yrSfcBaseinfotem.setLeRep(midBaseInfoDto.getLeRep());
	        	yrSfcBaseinfotem.setFarSpeArtName(midBaseInfoDto.getEntName());
	        	yrSfcBaseinfotem.setOpScope(midBaseInfoDto.getOpScope());
//		        	yrSfcBaseinfotem.setOpScope(midBaseInfoDto.getOpScope());
	        	yrSfcBaseinfotem.setTel(midBaseInfoDto.getTel());
	        	yrSfcBaseinfotem.setYear(Integer.valueOf(year));
	        	yrSfcBaseinfoService.saveYrSfcBaseInfo(yrSfcBaseinfotem);
				yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, pripid,"1");
	        	view.addObject("yrSfcBaseinfo",yrSfcBaseinfo);
	        }
			
		    view.addObject("yrRegCheck", yrRegCheck);
			view.addObject("year", year);
			
			String anCheID = yrSfcBaseinfo.getAnCheID();
			if(Integer.valueOf(year) > 2015){ //社保信息从16年年报开始
				//通过基本信息中的年报id查询社保信息
				YrSfcSocialSecurity yrSfcSocialSecurity = yrSfcSocialSecurityService.selectYrSfcSocialSecurityByAnCheID(StringUtil.isNotEmpty(anCheID) ? anCheID : "0000", "1");
				if(yrSfcSocialSecurity != null){
					view.addObject("yrSfcSocialSecurity", yrSfcSocialSecurity);
				}else{
					yrSfcSocialSecurity = yrSfcBaseinfoService.baseinfotransformSocialSecurity(yrSfcBaseinfo, yrSfcSocialSecurity);
					yrSfcSocialSecurityService.saveYrSfcSocialSecurity(yrSfcSocialSecurity);
					view.addObject("yrSfcSocialSecurity", yrSfcSocialSecurity);
				}
			}
			
			//获取年报anCheID
			if(StringUtils.isNotEmpty(anCheID)){
				// 获取当前企业网站信息列表
				List<YrSfcWebsiteInfo> yrSfcWebsiteInfoList = yrSfcWebsiteInfoService.selectSfcWebsiteListByanCheID(anCheID);
				if (yrSfcWebsiteInfoList.size() > 0) {
					view.addObject("yrSfcWebsiteInfoList", yrSfcWebsiteInfoList);
				}
			}

			//查询备案信息
			PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(pripid);
		    if(pubEppassword != null){
		    	view.addObject("pubEppassword",pubEppassword);
		    }

			//获取电子公章图片字符串路径
			Signature signature = signatureService.selectByYearAndPripid(year,pripid);
			if(signature!=null&& StringUtils.isNotBlank(signature.getTextCode())){
				view.addObject("qzImgBase64", signature.getTextCode());
			}

		    //证件类型
			List<CodeCertype> Certypes = codeCertypeService.selectAll();
		    view.addObject("Certypes", Certypes);
			year = AESEUtil.encodeYear(year); //年份进行加密处理传到后台
			view.addObject("encodeYear", year);


		}
		return view;
	}
	
	/**
	 * 
	 * 描述: 保存填报的表单信息（或更新）（暂存）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=3000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
	public AjaxResult save(@Valid YrSfcBaseinfo yrSfcBaseinfo,@Valid YrSfcSocialSecurity yrSfcSocialSecurity) throws Exception{
		try {//1.保存基本表信息
			if(yrSfcBaseinfo == null ){
				return AjaxResult.error("表单保存失败");
			}else{
				if(yrSfcBaseinfo.getYear() > 2015 && yrSfcSocialSecurity == null){
					return AjaxResult.error("社保表单保存失败");
				}
				if(yrSfcBaseinfo.getYear() > 2015 && yrSfcSocialSecurity != null){
					//将基本信息表中与社保信息相同字段赋值到社保信息中
					yrSfcSocialSecurity = yrSfcBaseinfoService.baseinfotransformSocialSecurity(yrSfcBaseinfo, yrSfcSocialSecurity);
					if(StringUtil.isNotBlank(yrSfcSocialSecurity.getSocialID())){
						yrSfcSocialSecurityService.updateYrSfcSocialSecurityByID(yrSfcSocialSecurity);	
					}
				}
				if(StringUtil.isNotBlank(yrSfcBaseinfo.getAnCheID())){
					  yrSfcBaseinfoService.updateYrSfcBaseinfoByPriPidAndYear(yrSfcBaseinfo);	
				}
				return AjaxResult.success("表单保存成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("表单保存失败");
		}
		
	}
	
	/**
	 * 
	 * 描述: 年报信息预览
	 * @auther gaojinling
	 * @date 2016年9月26日 
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView view(HttpSession session,String year) throws Exception{	
		year = AESEUtil.decodeYear(year); //年份进行解密处理		
		//登陆成功后进入个体年报预览页
		ModelAndView view = new ModelAndView("/reg/client/yr/sfcyr/sfcyrpubpreview");
		//获取session的企业基本信息
	    MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
	    String priPID = midBaseInfoDto.getPriPID();
		if(StringUtil.isNotEmpty(priPID)&&StringUtil.isNotEmpty(year)){
			YrSfcBaseinfo yrSfcBaseinfo = yrSfcBaseinfoService.selectYrSfcBaseInfoByYearAndPripid(year, priPID,"1");
			view.addObject("yrSfcBaseinfo",yrSfcBaseinfo);
			String anCheID = yrSfcBaseinfo.getAnCheID();
			if(Integer.valueOf(year) > 2015 && StringUtil.isNotEmpty(anCheID)){
				//通过基本信息中的年报id查询社保信息
				YrSfcSocialSecurity yrSfcSocialSecurity = yrSfcSocialSecurityService.selectYrSfcSocialSecurityByAnCheID(StringUtil.isNotEmpty(anCheID) ? anCheID : "0000", "1");
				view.addObject("yrSfcSocialSecurity", yrSfcSocialSecurity);
			}
			//获取年报anCheID
			if(StringUtils.isNotEmpty(anCheID)){
				// 获取当前企业网站信息列表
				List<YrSfcWebsiteInfo> yrSfcWebsiteInfoList = yrSfcWebsiteInfoService.selectSfcWebsiteListByanCheID(anCheID);
				if (yrSfcWebsiteInfoList.size() > 0) {
					view.addObject("yrSfcWebsiteInfoList", yrSfcWebsiteInfoList);
				}
			}
		}
		view.addObject("year",year);
		return view;
	}
	
}