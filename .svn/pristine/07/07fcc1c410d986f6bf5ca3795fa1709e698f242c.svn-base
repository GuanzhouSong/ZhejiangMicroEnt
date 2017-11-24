/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.rpt.rptdto.YrRptDto;
import com.icinfo.cs.rpt.rptservice.IYrRptService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 
 * 描述:  警示首页可视化控制层
 * @author: 赵祥江
 * @date: 2017年7月24日 上午9:46:11
 */
@Controller
@RequestMapping("/reg/server/echartsindexrpt" )
public class EchartsIndexRptController extends CSBaseController  {
	 private static final Logger logger =LoggerFactory.getLogger(EchartsIndexRptController.class);
	 @Autowired
	 private IYrRptService yrRptService;
	/**
	 * 
	 * 描述   根据年报年度和企业类型获取企业年度报告json格式数据
	 * @author 赵祥江
	 * @date 2017年7月24日 上午9:58:38 
	 * @param  
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntReportJsonData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntReportJsonData(PageRequest request,HttpSession session) throws Exception {
		try {
    		Map<String,Object> queryMap=request.getParams(); 
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")&&queryMap.get("entTypeCatg")!=null &&queryMap.containsKey("year")&&queryMap.get("year")!=null ){
				Map<String,Object> qMap=new HashMap<String,Object>();
				//年报年度
				String year=queryMap.get("year").toString();
				//开始年月
				qMap.put("monthCodeStart",getMonthCode(year).get("monthCodeStart"));
				//结束年月
				qMap.put("monthCodeEnd",getMonthCode(year).get("monthCodeEnd"));
				qMap.put("year", year);
				qMap.put("entCatgCode", queryMap.get("entTypeCatg").toString());
				qMap.put("statLevel", "areatj"); 
				qMap.put("areaCode", queryMap.get("areaCode").toString());
				List<YrRptDto> yrRptDtoList=yrRptService.selectEntReportDataCount(qMap);
				return AjaxResult.success("获取企业年报报告数据成功", yrRptDtoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取企业年报报告数据失败!", e);
		} 
		return AjaxResult.error("获取企业年报报告数据失败!");
	}
	
	
	
	
	/**
	 * 
	 * 描述   获取近三年的年报率
	 * @author 赵祥江
	 * @date 2017年7月24日 下午3:11:26 
	 * @param  
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getThreeYearJsonData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getThreeYearJsonData(PageRequest request,HttpSession session) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams(); 
			//当前年份
			Integer nowYear=Integer.parseInt(DateUtil.getYear());
			List<YrRptDto>  yrRptDtoList=new ArrayList<YrRptDto>();
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")&&queryMap.get("entTypeCatg")!=null&&queryMap.containsKey("monthCode")&&queryMap.get("monthCode")!=null){
			    String monthCode=queryMap.get("monthCode").toString();
				Map<String,Object> qMap=new HashMap<String,Object>(); 
				qMap.put("entCatgCode", queryMap.get("entTypeCatg").toString());
				qMap.put("areaCode", queryMap.get("areaCode").toString());
				qMap.put("statLevel", "areatj");  
				for(int i=1;i<=3;i++){
					nowYear=nowYear-1;
					//monthCodeStart 格式为 20170712
					if(!"00".equals(monthCode)){
						String monthCodeStart=nowYear+monthCode+"01";
						String monthCodeEnd=nowYear+monthCode+"31";
						qMap.put("monthCodeStart",monthCodeStart);  
						qMap.put("monthCodeEnd", monthCodeEnd); 
					}else{
						//开始年月
						qMap.put("monthCodeStart",getMonthCode(nowYear.toString()).get("monthCodeStart"));
						//结束年月
						qMap.put("monthCodeEnd",getMonthCode(nowYear.toString()).get("monthCodeEnd"));
					}
					qMap.put("year", nowYear); 
					List<YrRptDto> yrRptDtoTemList=yrRptService.selectEntReportDataCount(qMap);	
				    if(yrRptDtoTemList!=null&&yrRptDtoTemList.size()>0){
				    	yrRptDtoTemList.get(0).setYEAR(nowYear);
				    	yrRptDtoList.addAll(yrRptDtoTemList);
				    }
				}
				return AjaxResult.success("获取近三年企业年报报告数据成功", yrRptDtoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取近三年企业年报报告数据失败!", e);
		} 
		return AjaxResult.error("获取近三年企业年报报告数据失败!");
	}
	
	/**
	 * 
	 * 描述   根据地市获取年报情况
	 * @author 赵祥江
	 * @date 2017年7月25日 上午9:53:10 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getYearReportJsonDataByArea", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getYearReportJsonDataByArea(PageRequest request,HttpSession session) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams();
			List<YrRptDto>  yrRptDtoList=new ArrayList<YrRptDto>();
			if(queryMap!=null&&queryMap.containsKey("qytype")&&queryMap.get("qytype")!=null&&queryMap.containsKey("year")&&queryMap.get("year")!=null){
				String year=queryMap.get("year").toString();
				String areaCode=queryMap.get("areaCode").toString();
				queryMap.put("entCatgCode", queryMap.get("qytype").toString());
				queryMap.put("year", year); 
				queryMap.put("statLevel", "regOrg");
				//如果是省局根据地市查询统计
				if("3300".equals(areaCode)||"33".equals(areaCode)){
					queryMap.put("statLevel", "area");
				}
				if(queryMap.containsKey("entTypeCatg")){
					queryMap.remove("entTypeCatg");
				}
				//开始年月
				queryMap.put("monthCodeStart",getMonthCode(year).get("monthCodeStart"));
				//结束年月
				queryMap.put("monthCodeEnd",getMonthCode(year).get("monthCodeEnd"));
				List<YrRptDto> yrRptDtoTemList=yrRptService.selectEntReportDataCount(queryMap);	
			    if(yrRptDtoTemList!=null&&yrRptDtoTemList.size()>0){
			    	yrRptDtoList.addAll(yrRptDtoTemList);
			    } 
				return AjaxResult.success("根据地市获取年报情况成功", yrRptDtoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("根据地市获取年报情况失败!", e);
		} 
		return AjaxResult.error("根据地市获取年报情况失败!");
	}
	
	
	/**
	 * 
	 * 描述   报送趋势
	 * @author 赵祥江
	 * @date 2017年7月26日 上午11:32:27 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getYearReportTrendJsonData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getYearReportTrendJsonData(PageRequest request,HttpSession session) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams();
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")&&queryMap.get("entTypeCatg")!=null&&queryMap.containsKey("year")&&queryMap.get("year")!=null){
				String year=queryMap.get("year").toString();
				queryMap.put("entCatgCode", queryMap.get("entTypeCatg").toString());
				queryMap.put("year", year); 
				queryMap.put("statLevel", "areatj"); 
				//报送趋势标记
				queryMap.put("qstj", "0"); 
				queryMap.put("areaCode", queryMap.get("areaCode").toString()); 
				//开始年月
				queryMap.put("monthCodeStart",getMonthCode(year).get("monthCodeStart"));
				//结束年月
				queryMap.put("monthCodeEnd",getMonthCode(year).get("monthCodeEnd"));
				List<YrRptDto> yrRptDtoTemList=yrRptService.selectEntReportDataCount(queryMap);	
				return AjaxResult.success("获取报送趋势成功", yrRptDtoTemList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取报送趋势失败!", e);
		} 
		return AjaxResult.error("获取报送趋势失败!");
	}
	
	
	/**
	 * 
	 * 描述   根据报送方式统计
	 * @author 赵祥江
	 * @date 2017年7月26日 下午3:50:16 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getYearReportBsfsJsonData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getYearReportBsfsJsonData(PageRequest request,HttpSession session) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams(); 
			List<YrRptDto>  yrRptDtoList=new ArrayList<YrRptDto>();
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")&&queryMap.get("entTypeCatg")!=null&&queryMap.containsKey("year")&&queryMap.get("year")!=null){
				String year=queryMap.get("year").toString();
				queryMap.put("entCatgCode", queryMap.get("entTypeCatg"));
				queryMap.put("year", year); 
				queryMap.put("statLevel", "bsfs"); 
				queryMap.put("areaCode", queryMap.get("areaCode"));
				//开始年月
				queryMap.put("monthCodeStart",getMonthCode(year).get("monthCodeStart"));
				//结束年月
				queryMap.put("monthCodeEnd",getMonthCode(year).get("monthCodeEnd"));
				List<YrRptDto> yrRptDtoTemList=yrRptService.selectEntReportDataCount(queryMap);	
			    if(yrRptDtoTemList!=null&&yrRptDtoTemList.size()>0&&yrRptDtoTemList.get(0)!=null){ 
			    	yrRptDtoList.add(yrRptDtoTemList.get(0));
			    }else{
			    	YrRptDto yrRptDto=new YrRptDto(); 
			    	yrRptDto.setPaper(BigDecimal.ZERO);
			    	yrRptDto.setKeyLogin(BigDecimal.ZERO);
			    	yrRptDto.setApp(BigDecimal.ZERO);
			    	yrRptDto.setPasswordLogin(BigDecimal.ZERO);
			    	yrRptDtoList.add(yrRptDto);
			    } 
				 
				return AjaxResult.success("根据报送方式统计成功", yrRptDtoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("根据报送方式统计失败!", e);
		} 
		return AjaxResult.error("根据报送方式统计失败!");
	}
	
	/**
	 * 
	 * 描述   根据行业统计
	 * @author 赵祥江
	 * @date 2017年7月26日 下午4:52:57 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getYearReportIndustryphyJsonData", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getYearReportIndustryphyJsonData(PageRequest request,HttpSession session) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams(); 
			List<YrRptDto>  yrRptDtoList=new ArrayList<YrRptDto>();
			if(queryMap!=null&&queryMap.containsKey("areaCode")&&queryMap.get("areaCode")!=null&&queryMap.containsKey("year")&&queryMap.get("year")!=null){
				String year=queryMap.get("year").toString();
				queryMap.put("areaCode", queryMap.get("areaCode").toString()); 
				queryMap.put("statLevel", "industryphy");  
				queryMap.put("year",year); 
				//开始年月
				queryMap.put("monthCodeStart",getMonthCode(year).get("monthCodeStart"));
				//结束年月
				queryMap.put("monthCodeEnd",getMonthCode(year).get("monthCodeEnd"));
				List<YrRptDto> yrRptDtoTemList=yrRptService.selectEntReportDataCount(queryMap);	
			    if(yrRptDtoTemList!=null&&yrRptDtoTemList.size()>0){ 
			    	yrRptDtoList.addAll(yrRptDtoTemList);
			    }  
				return AjaxResult.success("根据行业统计成功", yrRptDtoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("根据行业统计失败!", e);
		} 
		return AjaxResult.error("根据行业统计失败!");
	}
 
	
	/**
	 * 
	 * 描述   根据年报年度转换年报开始月份和结束年月
	 * @author 赵祥江
	 * @date 2017年7月28日 下午2:22:58 
	 * @param 
	 * @return Map<String,Object>
	 * @throws
	 */
	private Map<String,Object> getMonthCode(String ryear){
		Map<String,Object> qMap=new HashMap<String,Object>();
		//年报年度
		int year=Integer.parseInt(ryear) ;
		//报送年度
		int reportYear=year+1 ;
		Calendar cal=Calendar.getInstance();
		//当前年度
		Integer nowYear = cal.get(Calendar.YEAR);
		//当前月
		Integer nowMonth = cal.get(Calendar.MONTH)+1;
		String monthCodeEnd=""; 
		if(nowMonth.toString().length()>1){
			monthCodeEnd=nowYear+nowMonth.toString();
		}else{
			monthCodeEnd=nowYear+"0"+nowMonth.toString();
		} 
		//开始年月
		qMap.put("monthCodeStart", reportYear+"01");
		//结束年月
		qMap.put("monthCodeEnd",monthCodeEnd);
		return qMap;
	}
}