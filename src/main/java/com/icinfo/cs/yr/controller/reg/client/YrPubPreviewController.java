/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForGuaranteeInfo;
import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.model.YrSocialSecurity;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.cs.yr.service.IYrAlterStockInfoService;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IYrForinvestMentService;
import com.icinfo.cs.yr.service.IYrOtherInfoService;
import com.icinfo.cs.yr.service.IYrSocialSecurityService;
import com.icinfo.cs.yr.service.IYrSubcapitalService;
import com.icinfo.cs.yr.service.IYrWebsiteInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/** 
 * 描述: 年报预览控制类
 * @author ZhouYan
 * @date 2016年9月23日  
 */
@Controller
@RequestMapping("/reg/client/yr/ent/pubpreview")
public class YrPubPreviewController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(YrPubPreviewController.class);
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	IYrAssetService yrAssetService;
	@Autowired
	IYrOtherInfoService yrOtherInfoService;
	@Autowired
	IYrWebsiteInfoService yrWebsiteInfoService;
	@Autowired
	IYrSubcapitalService yrSubcapitalService; 
	@Autowired
	IYrForinvestMentService yrForinvestMentService; 
	@Autowired
	IYrForGuaranteeInfoService yrForGuaranteeInfoService;
	@Autowired
	private IYrAlterStockInfoService yrAlterStockInfoService; 
	@Autowired
    private IYrSocialSecurityService yrSocialSecurityService;
	
	private final String SESSION_MIDBASEINFODTO="midBaseInfoDto"; 

    /** 
     * 描述: 年报预览
     * @auther ZhouYan
     * @date 2016年9月23日 
     * @param year
     * @return
     * @throws Exception 
     */
	@RequestMapping(value = "/show")
	public ModelAndView show( String year, HttpSession session) throws Exception {
		Integer _year = Integer.valueOf(AESEUtil.decodeYear(year)); //年份进行解密
		ModelAndView view = new ModelAndView();
		//企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(SESSION_MIDBASEINFODTO);
		String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
		String repType = RepTypeUtil.getReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType(), _year.toString()).toString();
		//年报基本信息
		List<YrBaseInfo> yrBaseInfoList = yrBaseInfoService.selectYrBaseInfoByYearAndPriPID(_year, priPID);
		//年报资产状况信息
		YrAsset yrAsset = yrAssetService.selectByYearAndPripid(_year, priPID);
		//年报其他情况信息
		YrOtherInfo yrOtherInfo = yrOtherInfoService.selectOtherInfoListByYearPriID(priPID, _year);
		//年报社保信息
		YrSocialSecurity yrSocialSecurity = yrSocialSecurityService.selectByYearAndPripid(_year, priPID);
		view.addObject("year",AESEUtil.decodeYear(year)); //不加密参数
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("yrBaseInfoList", yrBaseInfoList);
		view.addObject("yrAsset", yrAsset);
		view.addObject("yrOtherInfo", yrOtherInfo);
		view.addObject("yrSocialSecurity", yrSocialSecurity);
		view.addObject("repType", repType);
		view.setViewName("reg/client/yr/pubpreview/yrpubpreview");
		return view;
	}

  /*  @RequestMapping(value = "/show")
    public ModelAndView show(String pripid, Integer year, HttpSession session) throws Exception {
    	pripid = AESEUtil.decodeCorpid(pripid);
    	ModelAndView view = new ModelAndView(); 
		//企业基本信息
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute(SESSION_MIDBASEINFODTO);

		String repType = RepTypeUtil.getReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType()).toString();
		//年报基本信息
		List<YrBaseInfo> yrBaseInfoList = yrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, pripid);
		//年报资产状况信息
		YrAsset yrAsset = yrAssetService.selectByYearAndPripid(year, pripid);
		//年报其他情况信息
		YrOtherInfo yrOtherInfo = yrOtherInfoService.selectOtherInfoListByYearPriID(pripid, year);
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("yrBaseInfoList", yrBaseInfoList);
		view.addObject("yrAsset", yrAsset);
		view.addObject("yrOtherInfo", yrOtherInfo);
		view.addObject("repType", repType);
		view.setViewName("reg/client/yr/pubpreview/yrpubpreview");
		return view;
	}*/
    
	/** 
	 * 描述: 年报预览：网站或网店信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/website/list.json")
	@ResponseBody
	public PageResponse<YrWebsiteInfo> listJSONYrWebsiteInfo(PageRequest request) throws Exception {
		List<YrWebsiteInfo> yrWebsiteInfoList = yrWebsiteInfoService.queryPagePreview(request);
		return new PageResponse<YrWebsiteInfo>(yrWebsiteInfoList);
	}
	
	/** 
	 * 描述: 年报预览：股东及出资信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/subcapital/list.json")
	@ResponseBody
	public PageResponse<YrSubcapital> listJSONYrSubcapital(PageRequest request) throws Exception {
		List<YrSubcapital> yrSubcapitalList = yrSubcapitalService.queryPagePreview(request);
		return new PageResponse<YrSubcapital>(yrSubcapitalList);
	}
	
	/** 
	 * 描述: 年报预览：对外投资信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/forinvest/list.json")
	@ResponseBody
	public PageResponse<YrForinvestMent> listJSONYrForinvestMent(PageRequest request) throws Exception {
		List<YrForinvestMent> yrForinvestMentList = yrForinvestMentService.queryPagePreview(request);
		return new PageResponse<YrForinvestMent>(yrForinvestMentList);
	}
	
	/** 
	 * 描述: 年报预览：对外提供保证担保信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/forguarantee/list.json")
	@ResponseBody
	public PageResponse<YrForGuaranteeInfo> listJSONYrForGuaranteeInfo(PageRequest request) throws Exception {
		List<YrForGuaranteeInfo> yrForGuaranteeInfoList = yrForGuaranteeInfoService.queryPagePreview(request);
		return new PageResponse<YrForGuaranteeInfo>(yrForGuaranteeInfoList);
	}
	
	/** 
	 * 描述: 年报预览：股权变更信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/stock/list.json")
	@ResponseBody
	public PageResponse<YrAlterStockInfo> listJSONYrAlterStockInfo(PageRequest request) throws Exception {
		List<YrAlterStockInfo> yrAlterStockInfoList = yrAlterStockInfoService.queryPagePreview(request);
		return new PageResponse<YrAlterStockInfo>(yrAlterStockInfoList);
	}
}