/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;
 
/**
 * 
 * 描述:    年报打印 控制类
 * @author: 赵祥江
 * @date: 2016年9月19日 上午9:52:54
 */
@Controller
@RequestMapping("/reg/client/yr/ent/pubprint")
public class YrPrintController { 
	@Autowired
	private IYrPrintService yrPrintService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IBaseInfoHisService baseInfoHisService;
	@Autowired
	private IAlterStockInfoHisService alterStockInfoHisService;
	@Autowired
	private IForGuaranteeInfoHisService forGuaranteeInfoHisService;
	@Autowired
	private IForinvestMentHisService forinvestMentHisService;
	@Autowired
	private ISubcapitalHisService subcapitalHisService;
	@Autowired
	private IWebsiteInfoHisService websiteInfoHisService;
	
	
	@Autowired
	private IBaseInfoService baseInfoService;
	@Autowired
	private IAlterStockInfoService alterStockInfoService;
	@Autowired
	private IForGuaranteeInfoService forGuaranteeInfoService;
	@Autowired
	private IForinvestMentService forinvestMentService;
	@Autowired
	private ISubcapitalService subcapitalService;
	@Autowired
	private IWebsiteInfoService websiteInfoService;

	@Autowired
	IYrAssetService assetService;
	
	/**
	 * 
	 * 描述     查看年度报告证明
	 * @author 赵祥江
	 * @date  2016年9月19日 上午10:06:03 
	 * @param 
	 * @return ModelAndView{企业基本信息  midBaseInfoDto 企业小类 codeEntType 年报年度 year 年报主表 yrRegCheck 年报修改记录 baseInfoHisList}    
	 * @throws
	 */
	@RequestMapping(value = "/showEnAnnualReportProve", method = RequestMethod.GET)
	public ModelAndView showEnAnnualReportProve(String year,HttpSession session) throws Exception {
		year = AESEUtil.decodeYear(year);  //年份解密
		//pripid="3301080000028162";
		//MidBaseInfoDto midBaseInfo =  midBaseInfoService.selectByPripid(AESEUtil.decodeCorpid(pripid));
 		MidBaseInfoDto midBaseInfo = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto"); 
 		String pripid="";
 		if(midBaseInfo!=null){
 			pripid=midBaseInfo.getPriPID();
 		}		
		ModelAndView view=yrPrintService.printerEnAnnualReportProve(pripid, Integer.parseInt(year), midBaseInfo); 
		//打印页面
		view.addObject("year", year);
		view.addObject("pripid", pripid);
		view.addObject("reportProveDate", DateUtils.getDateTime());
		view.setViewName("/reg/client/yr/pubprint/pubprint");
		return view;
	}
	
	/**
	 * 
	 * 描述   打印年度报告证明
	 * @author 赵祥江
	 * @date 2016年9月24日 下午5:13:58 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/printerEnAnnualReportProve", method = RequestMethod.GET)
	public ModelAndView printerEnAnnualReportProve(String year,HttpSession session) throws Exception {
		//pripid="3301080000028162";
		//MidBaseInfoDto midBaseInfo =  midBaseInfoService.selectByPripid(AESEUtil.decodeCorpid(pripid));
 		MidBaseInfoDto midBaseInfo = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto"); 
 		String  pripid="";
 		if(midBaseInfo!=null){
 			pripid=midBaseInfo.getPriPID();
 		}
		ModelAndView view=yrPrintService.printerEnAnnualReportProve(pripid, Integer.parseInt(year), midBaseInfo); 
		//打印页面 
		view.addObject("reportProveDate", DateUtils.getDateTime());
		view.setViewName("/reg/client/yr/pubprint/pubprintReport");
		return view;
	}
	
	
	
	/**
	 * 
	 * 描述   进入历史年度报告列表页面
	 * @author 赵祥江
	 * @date 2016年9月26日 下午2:48:03 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/readReportPage", method = RequestMethod.GET)
	public ModelAndView readReportPage(String  pripid,String year) throws Exception {
		year = AESEUtil.decodeYear(year);  //年份解密
		ModelAndView view=new  ModelAndView();
		view.addObject("year", year);
		view.addObject("pripid", pripid);
 		view.setViewName("/reg/client/yr/pubhis/pubhis_list");
		return view;
	}
	
	
	/**
	 * 
	 * 描述   获取历史年报信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午5:34:02 
	 * @param 
	 * @return PageResponse<BaseInfoHis>
	 * @throws
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<BaseInfoHis> listJSON(HttpSession  session,PageRequest request) throws Exception { 
		 //根据企业年度和主体代码获取对外投资
		Map<String, Object> searchMap=  request.getParams();
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		String pripid="";
		if(midBaseInfoDto!=null){
			pripid=midBaseInfoDto.getPriPID();
        }
		int year=Integer.parseInt(searchMap.get(Constants.CS_YEAR).toString()) ;
		BaseInfo baseInfo =baseInfoService.selectInfoByPripidAndYear(pripid, year); 
		//年报ID
		request.getParams().put(Constants.CS_ANCHEID, baseInfo==null?"":baseInfo.getAnCheID());
		List<BaseInfoHis>  baseInfoHisList=baseInfoHisService.queryPage(request);  
 		return new PageResponse<BaseInfoHis>(baseInfoHisList);
	}
	
	
	/**
	 * 
	 * 描述  查看与打印历史年度报告
	 * @author 赵祥江
	 * @date 2016年9月26日 下午2:48:03 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/readHisReportPage", method = RequestMethod.GET)
	public ModelAndView readHisReportPage(String  reportNo,String anCheID,String printFalg, HttpSession session) throws Exception {
   		MidBaseInfoDto midBaseInfo = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");  
 		ModelAndView view=new  ModelAndView();
		view.addObject("midBaseInfo", midBaseInfo);
		//年报基本信息
		BaseInfoHis baseInfoHis= baseInfoHisService.slectBaseInfoHisByanCheIDAndReportNo(anCheID, reportNo); 
		view.addObject("baseInfoHis", baseInfoHis);
		String repType = RepTypeUtil.getReportTypeList(midBaseInfo.getEntTypeCatg(), midBaseInfo.getEntType(), baseInfoHis.getYear().toString()).toString();
		view.addObject("repType", repType);
		//股权转让
		List<AlterStockInfoHis> alterStockInfoHisList=  alterStockInfoHisService.selectAlterStockInfoHisByAnCheIDAndreportNo(anCheID, reportNo);
		view.addObject("alterStockInfoHisList", alterStockInfoHisList);
        //对外担保
		List<ForGuaranteeInfoHis> forGuaranteeInfoHisList=forGuaranteeInfoHisService.selectForGuaranteeInfoHisByAnCheIDAnd(anCheID, reportNo);
		view.addObject("forGuaranteeInfoHisList", forGuaranteeInfoHisList);
        //对外投资
		List<ForinvestMentHis> forinvestMentHisList= forinvestMentHisService.selectForinvestMentHisByAnCheIDAndReportNo(anCheID, reportNo);
		view.addObject("forinvestMentHisList", forinvestMentHisList);
        //出资
		List<SubcapitalHis>  subcapitalHisList= subcapitalHisService.selectSubcapitalHisByAnCheIDAndReportNo(anCheID, reportNo);
		view.addObject("subcapitalHisList", subcapitalHisList);
        //网站网店
		List<WebsiteInfoHis> websiteInfoHisList=  websiteInfoHisService.selectWebsiteInfoHisByAnCheIDAndReportNo(anCheID, reportNo);
		view.addObject("websiteInfoHisList", websiteInfoHisList); 
		//打印标识
		view.addObject("printFalg", printFalg);
		view.addObject("year", baseInfoHis.getYear());
		//进入页面
 		view.setViewName("/reg/client/yr/pubhis/pubhispreview");
		return view;
	}
	
	/**
	 * 
	 * 描述   查看与打印当年最新的年度报告
	 * @author 赵祥江
	 * @date 2016年9月28日 上午10:21:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/showReportProvePage", method = RequestMethod.GET)
	public ModelAndView showReportProvePage(String year,String printFalg, HttpSession session) throws Exception {
		String  pripid="";
   		MidBaseInfoDto midBaseInfo = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");  
   		if(midBaseInfo!=null){
   			pripid=midBaseInfo.getPriPID();
   		}
 		ModelAndView view=new  ModelAndView();
 		view.addObject("encodeYear", year);
 		year = AESEUtil.decodeYear(year);  //年份解密
		view.addObject("midBaseInfo", midBaseInfo);
		BaseInfo baseInfo= baseInfoService.selectInfoByPripidAndYear(pripid, Integer.parseInt(year));
		view.addObject("baseInfo", baseInfo);
		String repType = RepTypeUtil.getReportTypeList(midBaseInfo.getEntTypeCatg(), midBaseInfo.getEntType(), year).toString();
		view.addObject("repType", repType);
		//年报ID
		String anCheID=baseInfo==null?"":baseInfo.getAnCheID();
		//股权转让
		List<AlterStockInfo> alterStockInfoList=  alterStockInfoService.selectAlterStockInfoByAnCheID(anCheID);
		view.addObject("alterStockInfoList", alterStockInfoList);
        //对外担保
		List<ForGuaranteeInfo> forGuaranteeInfoList=forGuaranteeInfoService.selectForGuaranteeInfoByAnCheID(anCheID);
		view.addObject("forGuaranteeInfoList", forGuaranteeInfoList);
        //对外投资
		List<ForinvestMent> forinvestMentList= forinvestMentService.selectForinvestMentByAnCheID(anCheID);
		view.addObject("forinvestMentList", forinvestMentList);
        //出资
		List<Subcapital>  subcapitalList= subcapitalService.selectSubcapitalByAnCheID(anCheID);
		view.addObject("subcapitalList", subcapitalList);
        //网站网店
		List<WebsiteInfo> websiteInfoList=  websiteInfoService.selectWebsiteInfoByAnCheID(anCheID);
		view.addObject("websiteInfoList", websiteInfoList);

		//打印标识
		view.addObject("printFalg", printFalg);
		view.addObject("year", year);

		view.addObject("pripid", pripid);
		//进入页面
 		view.setViewName("/reg/client/yr/pubhis/pubpreview");
		return view;
	} 
	
	
	/**
	 * 
	 * 描述  查看打印年度报告
	 * @author 赵祥江
	 * @date  2016年9月19日 上午11:01:20 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/printerCurrentReport", method = RequestMethod.GET)
    public ModelAndView printReportCurrentReport(String priPID,String year) throws Exception{
 		ModelAndView view= yrPrintService.printReportCurrentReport(priPID, Integer.parseInt(year));
		 //打印页面
		view.setViewName("/reg/client/im/permit/permit_edit");
		return view;
	} 
}
