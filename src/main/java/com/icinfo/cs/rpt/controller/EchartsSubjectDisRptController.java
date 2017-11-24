/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.RptEntInfoDto;
import com.icinfo.cs.rpt.rptservice.IRptEntInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 
 * 描述:  
 * @author: 赵祥江
 * @date: 2017年8月2日 下午2:22:55
 */
@Controller
@RequestMapping("/reg/server/echartssubjectdisrpt" )
public class EchartsSubjectDisRptController extends CSBaseController  {
	 private static final Logger logger =LoggerFactory.getLogger(EchartsSubjectDisRptController.class);
	 @Autowired
	 private IRptEntInfoService rptEntInfoService;


	 /**
	  * 
	  * 描述   获取在册企业总数
	  * @author 赵祥江
	  * @date 2017年8月2日 下午2:24:43 
	  * @param 
	  * @return AjaxResult
	  * @throws
	  */
	@RequestMapping(value = "/getEntRegStateKTotal", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntRegStateKTotal(PageRequest request) throws Exception {
		try { 
			Map<String,Object> qMap=new HashMap<String,Object>();
			qMap.put("statLevel", "regstatektotal");
			String[] normalStrArr={"0","0","0","0","0","0","0","0"};
			List<RptEntInfoDto> rptEntInfoDtoList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
			if(rptEntInfoDtoList.size()>0){
				String normalStr=rptEntInfoDtoList.get(0).getNormal().toString();
				if(normalStr.length()<8){
					String zero="";
					int a= 8-normalStr.length();
					while(normalStr.length()<8){
						zero+="0";
						if(a==zero.length()){
							break;
						}
					}
					normalStr=zero+normalStr;
				} 
				for(int i=0;i<normalStr.length();i++){ 
					String tStr=normalStr.substring(i, i+1); 
					normalStrArr[i]=tStr; 
				}
			}
			return AjaxResult.success("获取在册企业总数成功", normalStrArr); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取在册企业总数失败!", e);
		} 
		return AjaxResult.error("获取在册企业总数失败!");
	} 
	
	
	/**
	 * 
	 * 描述   根据企业类型统计在册企业数
	 * @author 赵祥江
	 * @date 2017年8月3日 下午2:01:51 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntCatgCodeTotal", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntCatgCodeTotal(PageRequest request) throws Exception {
		try {  
			RptEntInfoDto rptEntInfoDto=new RptEntInfoDto();
			Map<String,Object> qMap=new HashMap<String,Object>();
			qMap.put("statLevel", "entcatgtotal");  
			//企业
			qMap.put("entCatgCode", "1"); 
			List<RptEntInfoDto> rptEntList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
			if(rptEntList.size()>0){
				rptEntInfoDto.setEntNormal(rptEntList.get(0).getNormal());
				rptEntInfoDto.setEntNormalRate(rptEntList.get(0).getEntNormalRate());
			}else{
				rptEntInfoDto.setEntNormal(BigDecimal.ZERO);
				rptEntInfoDto.setEntNormalRate(BigDecimal.ZERO);
			} 
			 
			//农专
			qMap.put("entCatgCode", "2"); 
			List<RptEntInfoDto> rptFcList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
			if(rptFcList.size()>0){
				rptEntInfoDto.setFcNormal(rptFcList.get(0).getNormal());
				//农专占比
				rptEntInfoDto.setFcNormalRate(rptFcList.get(0).getEntNormalRate()); 
			}else{
				rptEntInfoDto.setFcNormal(BigDecimal.ZERO);
				//农专占比
				rptEntInfoDto.setFcNormalRate(BigDecimal.ZERO); 
			}
			
			//个体户
			qMap.put("entCatgCode", "3"); 
			List<RptEntInfoDto> pbFcList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
			if(pbFcList.size()>0){
				rptEntInfoDto.setPbNormal(pbFcList.get(0).getNormal());
				//个体户占比
				rptEntInfoDto.setPbNormalRate(pbFcList.get(0).getEntNormalRate()) ;
			}else{
				rptEntInfoDto.setPbNormal(BigDecimal.ZERO);
				//个体户占比
				rptEntInfoDto.setPbNormalRate(BigDecimal.ZERO) ;
			}
			return AjaxResult.success("根据企业类型统计在册企业数成功", rptEntInfoDto); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("根据企业类型统计在册企业数失败!", e);
		} 
		return AjaxResult.error("根据企业类型统计在册企业数失败!");
	} 
	
	/**
	 * 
	 * 描述   查询在册主体分布
	 * @author 赵祥江
	 * @date 2017年8月3日 下午4:29:07 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntAreaDistribution", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntAreaDistribution(PageRequest request) throws Exception {
		try {  
			Map<String,Object> queryMap=request.getParams(); 
			Map<String,Object> qMap=new HashMap<String,Object>();
			List<RptEntInfoDto> entAreaDisList=null;
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")){
				String entTypeCatg= queryMap.get("entTypeCatg").toString(); 
				//企业
				qMap.put("entCatgCode", entTypeCatg);  
				qMap.put("statLevel", "areacdis"); 
				entAreaDisList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
				if("2".equals(entTypeCatg)&&(!"3300".equals(entAreaDisList.get(0).getAreaCode()))){
					RptEntInfoDto  entInfoDto=new RptEntInfoDto();
					entInfoDto.setAreaCode("3300");
					entInfoDto.setNormal(BigDecimal.ZERO);
					entAreaDisList.add(0, entInfoDto);
				}
			} 
			return AjaxResult.success("查询在册主体分布成功", entAreaDisList); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询在册主体分布失败!", e);
		} 
		return AjaxResult.error("查询在册主体分布失败!");
	} 
	
	/**
	 * 
	 * 描述   查询注销和存续的趋势
	 * @author 赵祥江
	 * @date 2017年8月3日 下午5:08:54 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntCXCancel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntCXCancel(PageRequest request) throws Exception {
		try { 
			Map<String,Object> queryMap=request.getParams(); 
			Map<String,Object> qMap=new HashMap<String,Object>();
			List<RptEntInfoDto> entAreaDisList=null;
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")){
				String entTypeCatg=queryMap.get("entTypeCatg").toString();
				if(!"0".equals(entTypeCatg)){
					//企业类型
					qMap.put("entCatgCode",entTypeCatg); 
				}
				qMap.put("statLevel", "ztzxqs"); 
				qMap.put("yearCode", DateUtil.getDate("yyyyMM"));
				entAreaDisList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
			}
			return AjaxResult.success("查询在册主体分布成功", entAreaDisList); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询在册主体分布失败!", e);
		} 
		return AjaxResult.error("查询在册主体分布失败!");
	}
	
	/**
	 * 
	 * 描述   企业主体增长情况
	 * @author 赵祥江
	 * @date 2017年8月3日 下午5:34:28 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getZTEntIncrease", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getZTEntIncrease(PageRequest request) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams(); 
			Map<String,Object> qMap=new HashMap<String,Object>();
			List<RptEntInfoDto> entAreaDisList=new ArrayList<RptEntInfoDto>();
			if(queryMap!=null&&queryMap.containsKey("entTypeCatg")){
				qMap.put("statLevel", "yeartotal"); 
				qMap.put("yearCode", DateUtil.getDate("yyyyMM"));  
				//企业类型
				String entTypeCatg=queryMap.get("entTypeCatg").toString();
				if(!"0".equals(entTypeCatg)){
					//企业类型
					qMap.put("entCatgCode",entTypeCatg); 
				}
				Integer nowyear=Integer.parseInt(DateUtil.getYear());
				Integer bYear=2005; 
				for(int i=2005;i<=nowyear;i++){
					RptEntInfoDto rptEntInfoDto=new RptEntInfoDto();
					String tyear="";
					if(i==2005){
						tyear=bYear.toString();
					}else{
						int total=(i-bYear)+1;
						int c=0;
						while(true){
							tyear+= (i-c)+",";
							c++;
							if(c==total){
								break;
							}
						}
					}
					String years=StringUtil.doSplitStringToSqlFormat(tyear,",");
					qMap.put("years", years);
					List<RptEntInfoDto> entAreaDisListTem=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
					if(entAreaDisListTem.size()>0){
						rptEntInfoDto.setNormal(entAreaDisListTem.get(0).getNormal());
					}else{
						rptEntInfoDto.setNormal(BigDecimal.ZERO);
					}
					rptEntInfoDto.setYEAR(i);
					entAreaDisList.add(rptEntInfoDto);
				} 
			}
			return AjaxResult.success("查询在册主体分布成功", entAreaDisList); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询在册主体分布失败!", e);
		} 
		return AjaxResult.error("查询在册主体分布失败!");
	}
	
	
	
	/**
	 * 
	 * 描述企业年增长情况
	 * @author 赵祥江
	 * @date 2017年8月3日 下午5:34:28 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntIncrease", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntIncrease(PageRequest request) throws Exception {
		try {
			Map<String,Object> queryMap=request.getParams(); 
			Map<String,Object> qMap=new HashMap<String,Object>();
			List<RptEntInfoDto> entAreaDisList=new ArrayList<RptEntInfoDto>();
			if(queryMap!=null&&queryMap.containsKey("qytype")){
				qMap.put("statLevel", "yeartotal"); 
				qMap.put("yearCode", DateUtil.getDate("yyyyMM"));
				String qytype=queryMap.get("qytype").toString();
				if(!"0".equals(qytype)){
					//企业类型
					qMap.put("entCatgCode",qytype); 
				}
				Integer nowyear=Integer.parseInt(DateUtil.getYear());
				Integer bYear=2005; 
				for(int i=2005;i<=nowyear;i++){
					RptEntInfoDto rptEntInfoDto=new RptEntInfoDto();
					String tyear="";
					if(i==2005){
						tyear=bYear.toString();
					}else{
						int total=(i-bYear)+1;
						int c=0;
						while(true){
							tyear+= (i-c)+",";
							c++;
							if(c==total){
								break;
							}
						}
					}
					String years=StringUtil.doSplitStringToSqlFormat(tyear,",");
					qMap.put("years", years);
					List<RptEntInfoDto> entAreaDisListTem=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
					if(entAreaDisListTem.size()>0){
						rptEntInfoDto.setNormal(entAreaDisListTem.get(0).getNormal());
					}else{
						rptEntInfoDto.setNormal(BigDecimal.ZERO);
					}
					rptEntInfoDto.setYEAR(i);
					entAreaDisList.add(rptEntInfoDto);
				} 
			}
			return AjaxResult.success("查询在册主体分布成功", entAreaDisList); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询在册主体分布失败!", e);
		} 
		return AjaxResult.error("查询在册主体分布失败!");
	}
	
	
	/**
	 * 
	 * 描述   根据行业统计
	 * @author 赵祥江
	 * @date 2017年8月4日 下午1:57:54 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntIndustryphy", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult getEntIndustryphy(PageRequest request) throws Exception {
		try {  
			Map<String,Object> qMap=new HashMap<String,Object>();
			Map<String,Object> queryMap=request.getParams();
			List<RptEntInfoDto> entAreaDisList=null;
			if(queryMap!=null&&queryMap.containsKey("monthCode")&&queryMap.containsKey("areaCode")){
				qMap.put("statLevel", "industryphy"); 
				qMap.put("yearCode", queryMap.get("monthCode").toString()); 
				qMap.put("areaCode", queryMap.get("areaCode").toString());  
				entAreaDisList=rptEntInfoService.selectRptEntInfoDtoCount(qMap);
			} 
			return AjaxResult.success("根据行业统计成功", entAreaDisList); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("根据行业统计失败!", e);
		} 
		return AjaxResult.error("根据行业统计失败!");
	}
	 
}