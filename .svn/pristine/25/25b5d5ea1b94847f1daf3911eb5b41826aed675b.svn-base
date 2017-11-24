/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.pbapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述: 个体年报App 年报主表列表（yr_reg_check）
 * @author gaojinling
 * @date 2017年2月21日
 */
@Controller
@RequestMapping("/app/yrregcheck")
public class AppQueryYrRegCheckController extends CSBaseController {

	//年报主表
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	//年报主表
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	

	/**
	 * 
	 * 描述: 查询年报主表信息
	 * @auther gaojinling
	 * @date 2017年2月22日 
	 * @param pripid
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/queryregcheck.json","list.xml"})
	@AppTokenCheck
	@ResponseBody
	public AjaxResult doGetQueryRegCheck(String pripid,String year)throws Exception{
	 JSONObject jsonObj = new JSONObject();
	 //json结果List
	 List<Object> jsonObjList = new ArrayList<Object>();
		try {
			if(StringUtil.isBlank(pripid)){
				jsonObj.put("result",  "");
				jsonObj.put("errcode", "120");
			    return AjaxResult.success("查询参数不完整", jsonObj);  
			}
			
			//查询核准基本信息（个体户）
			pripid = AESEUtil.decodeCorpid(pripid); //内部序号解密
			MidBaseInfoDto midBaseInfoDto  = midBaseInfoService.selectMidBaseInfoByPripid(pripid, "2");
			
			if(midBaseInfoDto == null || midBaseInfoDto.getEstDate() == null ){
				jsonObj.put("result",  "");
				jsonObj.put("errcode", "1");
			    return AjaxResult.success("该个体户不在系统范围内或信息不完整", jsonObj); 
			}
			
        	Date endDate = DateUtil.stringToDate(DateUtil.getPreYear() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss"); //获取上一年的时间
        	if(midBaseInfoDto.getEstDate().after(endDate)){ //判断当前企业成立日期是否大于上一年的时间   如果:是 表示是今年新成立的企业 ---> 只能填写即时信息，不能年报
				jsonObj.put("result",  "");
				jsonObj.put("errcode", "2");
			    return AjaxResult.success("该个体户为新成立个体户，当前不需报年报", jsonObj); 
        	}
			
			//查询当前个体户现有主表列表,初始化主表列表
			List<YrRegCheck> data = yrRegCheckService.doGetYrRegCheckInit(pripid);
			
    		ArrayList<Integer> yearList= new ArrayList<Integer>();
    		for(YrRegCheck yrRegCheck : data) {
    			yearList.add(yrRegCheck.getYear());
    		}
    		String initYear = yearList.toString();
    		Date estDate = midBaseInfoDto.getEstDate();
    		//如果是个转企，按个转企时间初始化年报主表
    		if("1".equals(midBaseInfoDto.getIsIndivid()) && null != midBaseInfoDto.getIndividDate()) {
    			estDate = midBaseInfoDto.getIndividDate();
    		}
    		int estYear = Integer.valueOf(DateUtil.dateToString(estDate, "yyyy")); // 成立日期年度
    		int yrYear = 2015; //企业年报起始年度
    		int startYear = estYear > yrYear ? estYear : yrYear; // 初始化起始年度
    		for(int i = startYear; i < Integer.valueOf(DateUtil.getCurrentYear()) ;i++) {
    			if(initYear.indexOf(String.valueOf(i)) == -1) {
    				yrRegCheckService.doInitYrRegCheck(midBaseInfoDto.getPriPID(), i);
    			}
    		}
			
    		//初始化后查询当前企业有的主表列表，返回其主表列表
			data = yrRegCheckService.doGetYrRegCheckInit(pripid);
    		
			if(data != null && data.size() > 0){
				if(StringUtil.isNotBlank(year)){  //有年份  查询单个主表信息
					YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid, Integer.parseInt(year));
					Map<String, Object> objMap = doGetobjMap(yrRegCheck);
					jsonObjList.add(objMap);
				}else{
					for(YrRegCheck yrRegCheck : data){//列表查询去除纸质提交的列表
//						if(StringUtil.isNotBlank(yrRegCheck.getReportType()) && "6".endsWith(yrRegCheck.getReportType())){ //纸质提交，不显示
//						}else{
							Map<String, Object> objMap = doGetobjMap(yrRegCheck);
							jsonObjList.add(objMap);
//						}
					}
				}
			}
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			jsonObj.put("errcode", "0");
		    return AjaxResult.success("查询成功", jsonObj);
		} catch (Exception e) {
			jsonObj.put("errcode", "500");
			e.printStackTrace();
		    return AjaxResult.success("查询失败", jsonObj);
		}
	}	
	
	/**
	 * 
	 * 描述: 封装主表信息进map,便于存于json数据
	 * @auther gaojinling
	 * @date 2017年2月22日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetobjMap(YrRegCheck yrRegCheck) throws Exception {
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("id", yrRegCheck.getId());
		objMap.put("year", yrRegCheck.getYear());
		objMap.put("priPID", AESEUtil.encodeCorpid(yrRegCheck.getPriPID()));
		objMap.put("entName", yrRegCheck.getEntName());
		objMap.put("regNO", yrRegCheck.getRegNO());
		objMap.put("dom", StringUtil.isBlank(yrRegCheck.getDom()) ? "" : yrRegCheck.getDom());
		objMap.put("leRep", yrRegCheck.getLeRep());
		objMap.put("uniCode", StringUtil.isBlank(yrRegCheck.getUniCode()) ? "" : yrRegCheck.getUniCode());
		objMap.put("estDate", DateUtil.dateToString(yrRegCheck.getEstDate(),"yyyy-MM-dd"));
		objMap.put("regCap", yrRegCheck.getRegCap() == null ? "" : yrRegCheck.getRegCap()); //注册资本
		objMap.put("currency", StringUtil.isBlank(yrRegCheck.getCurrency()) ? "" : yrRegCheck.getCurrency()); //币种
		objMap.put("entType", StringUtil.isBlank(yrRegCheck.getEntType()) ? "" : yrRegCheck.getEntType());
		objMap.put("industryCo", StringUtil.isBlank(yrRegCheck.getIndustryCo()) ? "" : yrRegCheck.getIndustryCo());
		objMap.put("regOrg", StringUtil.isBlank(yrRegCheck.getRegOrg()) ? "" : yrRegCheck.getRegOrg());
		objMap.put("localAdm", StringUtil.isBlank(yrRegCheck.getLocalAdm()) ? "" : yrRegCheck.getLocalAdm());
		objMap.put("regState", StringUtil.isBlank(yrRegCheck.getRegState()) ? "" : yrRegCheck.getRegState());
		objMap.put("postalCode", StringUtil.isBlank(yrRegCheck.getPostalCode()) ? "" : yrRegCheck.getPostalCode());
		objMap.put("entTypeCatg", StringUtil.isBlank(yrRegCheck.getEntTypeCatg()) ? "" : yrRegCheck.getEntTypeCatg());
		objMap.put("firstReportTime", DateUtil.dateToString(yrRegCheck.getFirstReportTime(),"yyyy-MM-dd"));
		objMap.put("tel", StringUtil.isBlank(yrRegCheck.getTel()) ? "" : yrRegCheck.getTel());
		objMap.put("checkDep", StringUtil.isBlank(yrRegCheck.getCheckDep()) ? "" : yrRegCheck.getCheckDep());
		objMap.put("acceptDept", StringUtil.isBlank(yrRegCheck.getAcceptDept()) ? "" : yrRegCheck.getAcceptDept());
		objMap.put("acceptDate", yrRegCheck.getAcceptDate() == null ? "" : DateUtil.dateToString(yrRegCheck.getAcceptDate(), "yyyy-MM-dd"));
		objMap.put("acceptUser", StringUtil.isBlank(yrRegCheck.getAcceptUser()) ? "" : yrRegCheck.getAcceptUser());
		objMap.put("reportState", StringUtil.isBlank(yrRegCheck.getReportState()) ? "" : yrRegCheck.getReportState());
		objMap.put("subIp", StringUtil.isBlank(yrRegCheck.getSubIp()) ? "" : yrRegCheck.getSubIp());
		objMap.put("repType", StringUtil.isBlank(yrRegCheck.getRepType()) ? "" : yrRegCheck.getRepType());
		objMap.put("isReported", StringUtil.isBlank(yrRegCheck.getIsReported()) ? "" : yrRegCheck.getIsReported());
		objMap.put("lastReportTime", yrRegCheck.getLastReportTime() == null ? "" :  DateUtil.dateToString(yrRegCheck.getLastReportTime(),"yyyy-MM-dd"));
		objMap.put("reportType", StringUtil.isBlank(yrRegCheck.getReportType()) ? "" : yrRegCheck.getReportType());
		objMap.put("sliceNo", StringUtil.isBlank(yrRegCheck.getSliceNo()) ? "" : yrRegCheck.getSliceNo());
		objMap.put("isForbidWord", StringUtil.isBlank(yrRegCheck.getIsForbidWord()) ? "" : yrRegCheck.getIsForbidWord());
		objMap.put("modifyCount", yrRegCheck.getModifyCount() == null ? "" : yrRegCheck.getModifyCount());
		return objMap;
	}
	
}