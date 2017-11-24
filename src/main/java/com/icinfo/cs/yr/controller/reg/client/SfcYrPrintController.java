/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeEntType;
import com.icinfo.cs.base.service.ICodeEntTypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.cs.yr.model.SfcBaseInfoHis;
import com.icinfo.cs.yr.model.SfcBranchInfo;
import com.icinfo.cs.yr.model.SfcBranchInfoHis;
import com.icinfo.cs.yr.model.SfcLicenceInfo;
import com.icinfo.cs.yr.model.SfcLicenceInfoHis;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;
import com.icinfo.cs.yr.model.SfcWebsiteInfoHis;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.ISfcBaseInfoHisService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcBranchInfoHisService;
import com.icinfo.cs.yr.service.ISfcBranchInfoService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoHisService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoHisService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;
 

/**
 * 
 * 描述: 农专打印控制类 
 * @author: 赵祥江
 * @date: 2016年10月8日 上午10:53:13
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/yrprint")
public class SfcYrPrintController { 
	@Autowired
	private ISfcBaseInfoService sfcBaseInfoService;
	@Autowired
	private ISfcLicenceInfoService sfcLicenceInfoService;
	@Autowired
	private ISfcWebsiteInfoService sfcWebsiteInfoService;
	@Autowired
	private ISfcBranchInfoService sfcBranchInfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICodeEntTypeService codeEntTypeService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	
	@Autowired
	private ISfcBaseInfoHisService sfcBaseInfoHisService;
	@Autowired
	private ISfcLicenceInfoHisService sfcLicenceInfoHisService;
	@Autowired
	private ISfcWebsiteInfoHisService sfcWebsiteInfoHisService; 
	@Autowired
	private ISfcBranchInfoHisService sfcBranchInfoHisService;
	 
	
	/**
	 * 
	 * 描述    查看与打印当年最新的年度报告 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 下午4:25:53 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/showSfcReportProve", method = RequestMethod.GET)
	public ModelAndView showSfcReportProve(HttpSession  session, String year,String printFalg) throws Exception {
		ModelAndView view=new ModelAndView();
		year = AESEUtil.decodeYear(year); //初始解密年份
		String pripid="";
		//MidBaseInfoDto  midBaseInfoDto =midBaseInfoService.selectByPripid(sfc_propid);
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        if(midBaseInfoDto!=null){
        	pripid=midBaseInfoDto.getPriPID();
        }
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		SfcBaseInfo  sfcBaseInfo =sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(pripid, Integer.parseInt(year));
		//年报基本信息 公示
		view.addObject("sfcBaseInfo", sfcBaseInfo);
		//年报ID
		String anCheID=sfcBaseInfo==null?"":sfcBaseInfo.getAnCheID();
		//许可信息 公示
		List<SfcLicenceInfo> sfcLicenceInfoList= sfcLicenceInfoService.selectSfcLicenceInfoByAnCheID(anCheID);
		view.addObject("sfcLicenceInfoList", sfcLicenceInfoList);
		//网站网店信息
		List<SfcWebsiteInfo> sfcWebsiteInfoList= sfcWebsiteInfoService.selectSfcWebsiteInfoByAnCheID(anCheID);
		view.addObject("sfcWebsiteInfoList", sfcWebsiteInfoList);
 		//分支机构
 		List<SfcBranchInfo> sfcBranchInfoList= sfcBranchInfoService.selectSfcBranchInfoByAnCheID(anCheID);
		year = AESEUtil.encodeYear(year); //后置加密年份，作为页面传值
 		view.addObject("sfcBranchInfoList", sfcBranchInfoList);
		view.addObject("printFalg", printFalg);
		view.addObject("encodeYear", year);
		view.addObject("pripid", pripid);
		view.setViewName("/reg/client/yr/sfcyr/sfcyrpubprint"); 
		return view;
	} 
	
	/**
	 * 
	 * 描述   根据年报ID分页获取历史信息  农专
	 * @author 赵祥江
	 * @date 2016年10月8日 下午4:26:23 
	 * @param 
	 * @return PageResponse<SfcBaseInfoHis>
	 * @throws
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<SfcBaseInfoHis> listJSON(HttpSession  session,PageRequest request) throws Exception { 
		Map<String, Object> searchMap=  request.getParams();
		String pripid="";
		String year="";
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
		if(midBaseInfoDto!=null){
			pripid=midBaseInfoDto.getPriPID();
		}
		if(searchMap.containsKey(Constants.CS_YEAR)){
 			year=searchMap.get(Constants.CS_YEAR).toString();
		} 
		//获取公示 基本信息 得到年报ID
		SfcBaseInfo  sfcBaseInfo=sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(pripid, Integer.parseInt(year));
 		//年报ID
		request.getParams().put(Constants.CS_ANCHEID, sfcBaseInfo==null?"":sfcBaseInfo.getAnCheID());
		List<SfcBaseInfoHis> sfcBaseInfoHisList= sfcBaseInfoHisService.queryPage(request);
  		return new PageResponse<SfcBaseInfoHis>(sfcBaseInfoHisList);
 	}
	
	/**
	 * 
	 * 描述   打印年度报告证明 农专
	 * @author 赵祥江
	 * @date 2016年9月24日 下午5:13:58 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/printPubSfcPrintProve", method = RequestMethod.GET)
	public ModelAndView printPubSfcPrintProve(HttpSession  session,String year) throws Exception {
		ModelAndView view=new  ModelAndView();
		year = AESEUtil.decodeYear(year); //初始解密年份
		String pripid=""; 
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        //MidBaseInfoDto  midBaseInfoDto =midBaseInfoService.selectByPripid(pripid);
		CodeEntType codeEntType=null;
		if(midBaseInfoDto!=null){
			pripid=midBaseInfoDto.getPriPID();
			//企业小类 
			codeEntType =codeEntTypeService.selectCodeEntTypeByCode(midBaseInfoDto.getEntType()==null?"":midBaseInfoDto.getEntType());
		}
		//getMidBaseInfoDto();
		// 年报主表信息 其中：IsReported:年报状态 0、未年报  1、已年报   2、已年报（逾期） 首次报送日期:FirstReportTime
		YrRegCheck  yrRegCheck =yrRegCheckService.selectCheckInfoByPripidAndYear(pripid, Integer.parseInt(year));
		//yrRegCheck.setFirstReportTime(DateUtils.getSysDate());
		view.addObject("yrRegCheck", yrRegCheck);
 		//获取年报日期和最新年报日期不相等的历史记录
		List<SfcBaseInfoHis> baseInfoHisListH=sfcBaseInfoHisService.selectSfcBaseinfoHisListYear(Integer.parseInt(year), pripid);
			if(baseInfoHisListH!=null&&baseInfoHisListH.size()!=0){
			SfcBaseInfoHis baseInfoHis=new SfcBaseInfoHis();
			SfcBaseInfo baseInfo= sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(pripid, Integer.parseInt(year));
			baseInfoHis.setLastReportTime(baseInfo==null?null:baseInfo.getLastReportTime());
 			baseInfoHisListH.add(0, baseInfoHis);
		}else{
	 		SfcBaseInfo  sfcBaseInfo =sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(pripid, Integer.parseInt(year)); 
			baseInfoHisListH=sfcBaseInfoHisService.selectSfcBaseInfoHisByAnCheID(sfcBaseInfo==null?"0000":sfcBaseInfo.getAnCheID());
			if(baseInfoHisListH!=null&&baseInfoHisListH.size()==1){  
				baseInfoHisListH.get(0).setLastReportTime(sfcBaseInfo==null?null:sfcBaseInfo.getLastReportTime());
			}
		}
		view.addObject("sfcBaseInfoHisList", baseInfoHisListH); 
		view.addObject("codeEntType", codeEntType); 
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("year", year);
		view.addObject("pripid", pripid);
		view.addObject("reportProveDate", DateUtils.getDateTime()); 
 		view.setViewName("/reg/client/yr/sfcyr/pubsfchisprintprove");
		return view;
	} 
	 
	
	/**
	 * 
	 * 描述   进入历史年度报告列表页面  农专
	 * @author 赵祥江
	 * @date 2016年10月8日 下午4:26:57 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/readSfcReportPage", method = RequestMethod.GET)
	public ModelAndView readSfcReportPage(String  pripid,String year) throws Exception {
		ModelAndView view=new  ModelAndView(); 
		year = AESEUtil.decodeYear(year); //初始解密年份
		view.addObject("year", year);
		view.addObject("pripid", pripid);
 		view.setViewName("/reg/client/yr/sfcyr/pubsfchis_list");
		return view;
	} 
	 
	
	/**
	 * 
	 * 描述   查看与打印历史年度报告  农专
	 * @author 赵祥江
	 * @date 2016年10月8日 下午4:27:21 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/readSfcHisReportPage", method = RequestMethod.GET)
	public ModelAndView readSfcHisReportPage(HttpSession  session,String  reportNo,String anCheID,String printFalg) throws Exception {
		ModelAndView view=new  ModelAndView();
		//MidBaseInfoDto  midBaseInfoDto =midBaseInfoService.selectByPripid("3301850000123981");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据 
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		SfcBaseInfoHis  sfcBaseInfoHis=sfcBaseInfoHisService.selectSfcBaseInfoHisAnCheIdAndReportNo(anCheID, reportNo);
        //年报基本信息
		view.addObject("sfcBaseInfoHis", sfcBaseInfoHis);
		//许可信息
		List<SfcLicenceInfoHis> sfcLicenceInfoHisList=sfcLicenceInfoHisService.selectSfcLicenceInfoHisByAnCheIdAndReportNo(anCheID, reportNo);
		view.addObject("sfcLicenceInfoHisList", sfcLicenceInfoHisList); 
		//网站网店
		List<SfcWebsiteInfoHis> sfcWebsiteInfoHisList= sfcWebsiteInfoHisService.selectSfcWebsiteInfoHisByAnCheIdAndReportNo(anCheID, reportNo);
 		view.addObject("sfcWebsiteInfoHisList", sfcWebsiteInfoHisList);
 		List<SfcBranchInfoHis> sfcBranchInfoHisList=sfcBranchInfoHisService.selectSfcBranchInfoHisByAnCheIdAndReportNo(anCheID, reportNo);
		view.addObject("sfcBranchInfoHisList", sfcBranchInfoHisList);
		view.addObject("printFalg", printFalg);
		view.addObject("year",sfcBaseInfoHis==null?"": sfcBaseInfoHis.getYear());
		view.addObject("pripid",sfcBaseInfoHis==null?"":sfcBaseInfoHis.getPriPID());
		view.setViewName("/reg/client/yr/sfcyr/sfchisyrpubprint");
 		return view; 
	} 
}
