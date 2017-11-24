/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;


import java.util.ArrayList;
import java.util.Date;
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

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.system.dto.PermisionTreeNode;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_yr_pb_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Controller
@RequestMapping({"/reg/client/yr/pb/pbbaseinfo","/reg/server/yr/pb/pbbaseinfo"})
public class YrPbBaseInfoController extends BaseController {
	
	//个体基本信息
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	
	//个体公示基本信息（公示主表）
	@Autowired
	private IPbBaseinfoService pbBaseinfoService;
	
	//系统许可证列表
	@Autowired
	private ISysLicenseService sysLicenseService;
	
	//主表
	@Autowired
	private IYrRegCheckService yrRegCheckService;

	//电子公章
	@Autowired
	private ISignatureService signatureService;

	//网站信息
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;
	
	/**
	 * 
	 * 描述: 进入个体年报填报页 需要参数主体代码和年份（由登录成功后存入的session中取）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(String year,RedirectAttributes attr) throws Exception{
		String url = "redirect:/reg/client/yr/pb/pbbaseinfo/show";
		year = AESEUtil.encodeYear(year); //年份进行加密处理
		attr.addAttribute("year",year);
		return url;
	}

	/**
	 * 
	 * 描述: 进入个体年报填报页 需要参数主体代码和年份（由登录成功后存入的session中取）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")	
	public ModelAndView show(String year,HttpSession session) throws Exception {
		//登陆成功后进入个体年报填报页
		ModelAndView view = new ModelAndView("/reg/client/yr/pbyr/pbreport_edit");
		//获取session的企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
		String pripid = midBaseInfoDto.getPriPID();
		year = AESEUtil.decodeYear(year); //年份进行加密处理
		//查询年报主表信息
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid,Integer.valueOf(year));

		//查询个体户基本表信息
		YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, pripid,"1");
		
		if(yrPbBaseInfo != null){
			view.addObject("yrPbBaseInfo",yrPbBaseInfo);
		}else{
			YrPbBaseInfo yrPbBaseInfoTem = new YrPbBaseInfo();
			yrPbBaseInfoTem.setName(midBaseInfoDto.getLeRep());
			yrPbBaseInfoTem.setPriPID(midBaseInfoDto.getPriPID());
			yrPbBaseInfoTem.setRegNO(midBaseInfoDto.getRegNO());
			yrPbBaseInfoTem.setOpLoc(midBaseInfoDto.getDom());
			yrPbBaseInfoTem.setTraName(midBaseInfoDto.getEntName());
			yrPbBaseInfoTem.setUniCode(midBaseInfoDto.getUniCode());
			yrPbBaseInfoTem.setComPhone(midBaseInfoDto.getTel());
			yrPbBaseInfoTem.setYear(Integer.valueOf(year));
			yrPbBaseInfoService.saveYrPbBaseInfo(yrPbBaseInfoTem);
			yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, pripid,"1");
			view.addObject("yrPbBaseInfo",yrPbBaseInfo);
		}
		//获取年报anCheID
		String anCheID = yrPbBaseInfo.getAnCheID();
		if(StringUtils.isNotEmpty(anCheID)){
			// 获取当前企业网站信息列表
			List<YrPbWebsiteInfo> yrPbWebsiteInfoList = yrPbWebsiteInfoService.selectPbWebsiteListByanCheID(anCheID);
			if (yrPbWebsiteInfoList.size() > 0) {
				view.addObject("yrPbWebsiteInfoList", yrPbWebsiteInfoList);
			}
		}

		//获取电子公章图片字符串路径
		Signature signature = signatureService.selectByYearAndPripid(year,pripid);
		if(signature!=null&& StringUtils.isNotBlank(signature.getTextCode())){
			view.addObject("qzImgBase64", signature.getTextCode());
		}

		year = AESEUtil.encodeYear(year); //年份进行加密处理传到后台
		view.addObject("encodeYear", year);
		view.addObject("yrRegCheck", yrRegCheck);
		return view;
	}
	
	/**
	 * 
	 * 描述: 保存填报的表单信息（或更新）（暂存）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid YrPbBaseInfo yrPbBaseInfo) throws Exception{
		try {//1.保存基本表信息
			if(yrPbBaseInfo != null && StringUtil.isNotBlank(yrPbBaseInfo.getAnCheID())){
				yrPbBaseInfoService.updateYrPbBaseInfoByPriPidAndYear(yrPbBaseInfo);
			}
			return AjaxResult.success("表单保存成功");
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
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exceptionl
	 */
	@RequestMapping("/view")
	public ModelAndView view(HttpSession session,String year) throws Exception{	
		year = AESEUtil.decodeYear(year); //年份进行解密处理
		//登陆成功后进入个体年报预览页
		ModelAndView view = new ModelAndView("/reg/client/yr/pbyr/pbyrpubpreview");
		//获取session的企业基本信息
	    MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
	    String priPID = midBaseInfoDto.getPriPID();
		if(StringUtil.isNotEmpty(priPID)&&StringUtil.isNotEmpty(year)){
			YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, priPID,"0");
			view.addObject("yrPbBaseInfo",yrPbBaseInfo);
		}
		view.addObject("year",year);
		return view;
	}
	
	
	
	
	/**
	 * 
	 * 描述: 进入许可证列表树
	 * @auther gaojinling
	 * @date 2016年9月26日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeview")
	public ModelAndView licenceTreeview() throws Exception{	
		//许可证树
		ModelAndView view = new ModelAndView("/reg/client/yr/pbyr/licenseTree");
		return view;
	}
	
	/**
	 * 
	 * 描述: 许可证列表
	 * @auther gaojinling
	 * @date 2016年9月26日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"treelist.json","list.xml"})
	@ResponseBody
	public AjaxResult listJSON(String licConent)throws Exception{
	 List<SysLicense> data=	sysLicenseService.selectVaildLicList(licConent);
	 List<PermisionTreeNode> list=new ArrayList<PermisionTreeNode>();
	//因为审批事项没有上下级关系 这里默认给它设置一个父节点
	 PermisionTreeNode praenttreeNode = new PermisionTreeNode(); 
	 praenttreeNode.setName("许可证列表");
     praenttreeNode.setId("0");
	 praenttreeNode.setpId("0");
	 list.add(praenttreeNode);
	 for(SysLicense sysLicense:data){
		 PermisionTreeNode prT=new PermisionTreeNode();
		 prT.setId(sysLicense.getLicNO());
		 prT.setpId("0");
		 prT.setName(sysLicense.getLicName().toString());
		 prT.setOpen(true);
		 list.add(prT);
	 }
	 
	 return AjaxResult.success("查询成功",list);
	}
	
	
	/**
	 * 
	 * 描述: 根据licNo查询
	 * @auther gaojinling
	 * @date 2016年9月26日 
	 * @param licNO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"selectDetail.json","list.xml"})
	@ResponseBody
	public AjaxResult selectDetail(String licNO) throws Exception{
	  if(!licNO.isEmpty()){
		  SysLicense sysLicense=sysLicenseService.selectOneByLicNO(licNO);
	      return AjaxResult.success("查询成功",sysLicense);
	  }else{
		  return AjaxResult.error("查询失败");
	  }
	}
	
     
	
	
	
	
}