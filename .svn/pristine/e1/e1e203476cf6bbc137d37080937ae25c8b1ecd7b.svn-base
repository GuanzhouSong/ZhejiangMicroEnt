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
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.cs.yr.model.PbLicenceinfo;
import com.icinfo.cs.yr.model.PbLicenceinfoHis;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.cs.yr.model.PbWebsiteinfoHis;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IPbBaseinfoHisService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbLicenceinfoHisService;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoHisService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;
 
/**
 * 
 * 描述: 个体户年度报告查看打印控制类
 * @author: 赵祥江
 * @date: 2016年9月19日 上午9:52:54
 */
@Controller
@RequestMapping("/reg/client/yr/pb/yrprint")
public class PbYrPrintController { 
	@Autowired
	private IPbBaseinfoService pbBaseinfoService;
	@Autowired
	private IPbLicenceinfoService pbLicenceinfoService;
	@Autowired
	private IPbWebsiteinfoService pbWebsiteinfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICodeEntTypeService codeEntTypeService;
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	
	@Autowired
	private IPbBaseinfoHisService pbBaseinfoHisService;
	@Autowired
	private IPbLicenceinfoHisService pbLicenceinfoHisService;
	@Autowired
	private IPbWebsiteinfoHisService pbWebsiteinfoHisService; 
	
	/**
	 * 
	 * 描述   个体户  查看与打印当年最新的年度报告  个体户
	 * @author 赵祥江
	 * @date 2016年9月28日 下午4:50:09 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/showPbReportProve", method = RequestMethod.GET)
	public ModelAndView showPbReportProve(HttpSession  session,String year,String printFalg) throws Exception {
		year = AESEUtil.decodeYear(year); //初始解密年份
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String pripid="";
		if(midBaseInfoDto!=null){
        	pripid=midBaseInfoDto.getPriPID();
        }
		ModelAndView view=new ModelAndView();
		PbBaseinfo pbBaseinfo=pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year);  
		//年报基本信息 公示
		view.addObject("pbBaseInfo", pbBaseinfo);
		//年报ID
		String anCheID=pbBaseinfo==null?"":pbBaseinfo.getAnCheID();
		//许可信息 公示
		List<PbLicenceinfo> pbLicenceinfoList= pbLicenceinfoService.selectPbLicenceListByPriPidAndYear(anCheID);
		view.addObject("pbLicenceinfoList", pbLicenceinfoList); 
		List<PbWebsiteinfo>  pbWebsiteinfoList=pbWebsiteinfoService.selectPbWebsiteListByPriPidAndYear(anCheID);
		year = AESEUtil.encodeYear(year); //后置加密年份，作为页面传值
		view.addObject("pbWebsiteinfoList", pbWebsiteinfoList);
		view.addObject("printFalg", printFalg);
		view.addObject("encodeYear", year);
		view.addObject("pripid", pripid);
		view.setViewName("/reg/client/yr/pbyr/pubpbprintreport"); 
		return view;
	}
	
	/**
	 * 
	 * 描述   根据年报ID分页获取历史信息 个体户
	 * @author 赵祥江
	 * @date 2016年9月29日 下午12:08:59 
	 * @param 
	 * @return PageResponse<PbBaseinfoHis>
	 * @throws
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PbBaseinfoHis> listJSON(HttpSession  session,PageRequest request) throws Exception { 
		Map<String, Object> searchMap=  request.getParams();
		String pripid="";
		String year="";
		if(searchMap.containsKey(Constants.CS_YEAR)){
 			year=searchMap.get(Constants.CS_YEAR).toString();
		} 
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        if(midBaseInfoDto!=null){
        	pripid=midBaseInfoDto.getPriPID();
        }  
		//获取公示 基本信息 得到年报ID
 		PbBaseinfo  pbBaseinfo =pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year); 
		//年报ID
		request.getParams().put(Constants.CS_ANCHEID, pbBaseinfo==null?"":pbBaseinfo.getAnCheID());
		List<PbBaseinfoHis>   pbBaseinfoHisList=pbBaseinfoHisService.queryPage(request);  
 		return new PageResponse<PbBaseinfoHis>(pbBaseinfoHisList);
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
	@RequestMapping(value = "/printPubPbPrintProve", method = RequestMethod.GET)
	public ModelAndView printPubPbPrintProve(HttpSession  session,String year) throws Exception {
		year = AESEUtil.decodeYear(year);
		ModelAndView view=new  ModelAndView(); 
		//MidBaseInfoDto  midBaseInfoDto =midBaseInfoService.selectByPripid("3301060001044535");
		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        CodeEntType codeEntType=null;
		String  pripid="";
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
		//List<PbBaseinfoHis> pbBaseinfoHisList= pbBaseinfoHisService.selectPbBaseinfoHisByAnCheID(pbBaseinfo==null?"":pbBaseinfo.getAnCheID());
		List<PbBaseinfoHis> baseInfoHisListH=pbBaseinfoHisService.selectPbBaseinfoHisListYear(Integer.parseInt(year),pripid);
			if(baseInfoHisListH!=null&&baseInfoHisListH.size()!=0){
				PbBaseinfoHis baseInfoHis=new PbBaseinfoHis();
				PbBaseinfo baseInfo= pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year);
				baseInfoHis.setLastReportTime(baseInfo==null?null:baseInfo.getLastReportTime());
 				baseInfoHisListH.add(0, baseInfoHis);
		}else{
			PbBaseinfo  pbBaseinfo =pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year);		
            baseInfoHisListH=pbBaseinfoHisService.selectPbBaseinfoHisByAnCheID(pbBaseinfo==null?"":pbBaseinfo.getAnCheID());
			if(baseInfoHisListH!=null&&baseInfoHisListH.size()==1){
 				baseInfoHisListH.get(0).setLastReportTime(pbBaseinfo==null?null:pbBaseinfo.getLastReportTime());
			}
		}
		view.addObject("pbBaseinfoHisList", baseInfoHisListH); 
		view.addObject("codeEntType", codeEntType); 
		view.addObject("midBaseInfoDto", midBaseInfoDto);
		view.addObject("year", year);
		view.addObject("pripid", pripid);
		view.addObject("reportProveDate", DateUtils.getDateTime()); 
 		view.setViewName("/reg/client/yr/pbyr/pubpbprintprove");
		return view;
	}
	
	
	
	/**
	 * 
	 * 描述   进入历史年度报告列表页面  个体户
	 * @author 赵祥江
	 * @date 2016年9月26日 下午2:48:03 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/readPbReportPage", method = RequestMethod.GET)
	public ModelAndView readPbReportPage(String  pripid,String year) throws Exception {
		year = AESEUtil.decodeYear(year);
		ModelAndView view=new  ModelAndView(); 
		view.addObject("year", year);
		view.addObject("pripid", pripid);
 		view.setViewName("/reg/client/yr/pbyr/pubpbhis_list");
		return view;
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
	@RequestMapping(value = "/readPbHisReportPage", method = RequestMethod.GET)
	public ModelAndView readPbHisReportPage(String  reportNo,String anCheID,String printFalg) throws Exception {
		ModelAndView view=new  ModelAndView();
 		PbBaseinfoHis pbBaseinfoHis=pbBaseinfoHisService.selectPbBaseinfoHisAnCheIdAndReportNo(anCheID, reportNo);
		//年报基本信息
		view.addObject("pbBaseinfoHis", pbBaseinfoHis);
		//许可信息
		List<PbLicenceinfoHis> pbLicenceinfoHisList= pbLicenceinfoHisService.selectPbLicenceinfoHisByAnCheIdAndReportNo(anCheID, reportNo);
		view.addObject("pbLicenceinfoHisList", pbLicenceinfoHisList); 
		//网站网店
		List<PbWebsiteinfoHis>  pbWebsiteinfoHisList=pbWebsiteinfoHisService.selectPbWebsiteinfoHisByAnCheIdAndReportNo(anCheID, reportNo);
		view.addObject("pbWebsiteinfoHisList", pbWebsiteinfoHisList);
		view.addObject("printFalg", printFalg);
		view.addObject("year",pbBaseinfoHis==null?"": pbBaseinfoHis.getYear());
		view.addObject("pripid",pbBaseinfoHis==null?"":pbBaseinfoHis.getPriPID());
		view.setViewName("/reg/client/yr/pbyr/pubpbhisprintreport");
 		return view;
	} 
	
	
	/**
	 * 
	 * 描述   组装企业核准内容表内容 测试用
	 * @author 赵祥江
	 * @date 2016年9月30日 上午9:47:16 
	 * @param 
	 * @return MidBaseInfoDto
	 * @throws
	 */
	private MidBaseInfoDto getMidBaseInfoDto(){
		MidBaseInfoDto midBaseInfoDto=new MidBaseInfoDto();
		midBaseInfoDto.setEntName("杭州市西湖区于得水窗帘店");
		midBaseInfoDto.setDom("杭州市西湖区");
		midBaseInfoDto.setLeRep("赵祥江");
		midBaseInfoDto.setOpScope("窗帘销售");
		midBaseInfoDto.setRegOrgName("杭州市市场监管局");
		midBaseInfoDto.setEntType("4900");
		midBaseInfoDto.setEntTypeCatg("50");
		midBaseInfoDto.setApprDate(DateUtils.getSysDate());
		midBaseInfoDto.setRegState("D");
		midBaseInfoDto.setUniCode("333333");
		return midBaseInfoDto;
	}
}
