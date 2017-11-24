/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
*/
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.cs.base.model.CodeEntType;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.cs.base.service.ICodeEntTypeService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.AlterStockInfo;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.BaseInfoHis;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IAlterStockInfoService;
import com.icinfo.cs.yr.service.IBaseInfoHisService;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IForinvestMentService;
import com.icinfo.cs.yr.service.ISubcapitalService;
import com.icinfo.cs.yr.service.IWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrPrintService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.core.exception.BusinessException;

/**
 * 
 * 描述:    年报打印  Service接口实现类
 * @author: 赵祥江
 * @date: 2016年9月19日 上午9:51:23
 */
@Service
public class YrPrintServiceImpl implements IYrPrintService {
	private static final Logger logger = LoggerFactory.getLogger(YrPrintServiceImpl.class);
  
	@Autowired
	private ICodeEntTypeService codeEntTypeService; 
	@Autowired
	private IYrRegCheckService yrRegCheckService; 
	@Autowired
	private IBaseInfoHisService baseInfoHisService;
	@Autowired
	private IBaseInfoService baseInfoService;
	@Autowired
	private IWebsiteInfoService websiteInfoService;
	@Autowired
	private ISubcapitalService subcapitalService;
	@Autowired
	private IForinvestMentService forinvestMentService;
	@Autowired
	private IForGuaranteeInfoService forGuaranteeInfoService;
	@Autowired
	private IAlterStockInfoService alterStockInfoService;
	@Autowired
	private ICodeCurrencyService codeCurrencyService;

	
	
	
	
	
	/**
	 * 
	 * 描述             : 打印年度报告证明
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 上午11:19:11 
	 * @param : 
	 * @throws
	 */
	@Override
	public ModelAndView printerEnAnnualReportProve(String priPID, int year,
			MidBaseInfoDto midBaseInfoDto) throws Exception {
		ModelAndView view=new ModelAndView();
		CodeCurrency  codeCurrency =null;
		try { 
			/*--------------------基本信息-------------------- */ 
			if(midBaseInfoDto!=null){
				midBaseInfoDto.setRegCap(midBaseInfoDto.getRegCap()==null?new BigDecimal(0):midBaseInfoDto.getRegCap().setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			view.addObject("midBaseInfoDto", midBaseInfoDto);
			//中外合资
			if("21".equals(midBaseInfoDto.getEntTypeCatg())){
				codeCurrency=codeCurrencyService.selectCodeCurrencyByCode(midBaseInfoDto.getCurrency());
			}
			view.addObject("codeEntType", codeCurrency);
			//企业小类 
			CodeEntType  codeEntType =codeEntTypeService.selectCodeEntTypeByCode(midBaseInfoDto.getEntType());
			view.addObject("codeEntType", codeEntType); 
			/*--------------------年报情况-------------------- */ 
			//年报年度
			view.addObject("year", year);
			// 年报主表信息 其中：IsReported:年报状态 0、未年报  1、已年报   2、已年报（逾期） 首次报送日期:FirstReportTime
			YrRegCheck  yrRegCheck =yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, year);
			view.addObject("yrRegCheck", yrRegCheck);
			//年报修改记录信息
 			List<BaseInfoHis> baseInfoHisListH=baseInfoHisService.selectBaseInfoHisListYear(year, priPID); 
 			if(baseInfoHisListH!=null&&baseInfoHisListH.size()!=0){
				BaseInfoHis baseInfoHis=new BaseInfoHis();
				BaseInfo baseInfo= baseInfoService.selectInfoByPripidAndYear(priPID, year);
				baseInfoHis.setLastReportTime(baseInfo==null?null:baseInfo.getLastReportTime());
 				baseInfoHisListH.add(0, baseInfoHis);
			}else{
				baseInfoHisListH=baseInfoHisService.slectBaseInfoHisByYearAndpriPID(year, priPID);
				if(baseInfoHisListH!=null&&baseInfoHisListH.size()==1){
					BaseInfo baseInfo= baseInfoService.selectInfoByPripidAndYear(priPID, year);
					baseInfoHisListH.get(0).setLastReportTime(baseInfo==null?null:baseInfo.getLastReportTime());
				}
			}  
			view=view.addObject("baseInfoHisList", baseInfoHisListH); 
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取打印年报证明信息失败!");
            throw new BusinessException("获取打印年报证明信息失败!");
		}
	}
	
	/**
	 * 
	 * 描述             : 打印当年年度报告
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午1:49:58 
	 * @param :
	 * @return: ModelAndView
	 * @throws
	 */
	public ModelAndView printReportCurrentReport(String priPID,int year) throws Exception{
		ModelAndView view=new ModelAndView();
		try { 
			//年报基本信息(包括资产状况)  公示 
			BaseInfo baseInfo=baseInfoService.selectInfoByPripidAndYear(priPID, year);
			view.addObject("baseInfo", baseInfo); 
 			//企业小类 
			CodeEntType  codeEntType =codeEntTypeService.selectCodeEntTypeByCode(baseInfo.getEntType());
			view.addObject("codeEntType", codeEntType); 
			//年报ID
			String anCheID=baseInfo.getAnCheID(); 
			//网站网店 
			List<WebsiteInfo> websiteInfoList= websiteInfoService.selectWebsiteInfoByAnCheID(anCheID);
			view.addObject("websiteInfoList", websiteInfoList);
			//出资 
			List<Subcapital> subcapitalList= subcapitalService.selectSubcapitalByAnCheID(anCheID);
			view.addObject("subcapitalList", subcapitalList);
			//对外投资
			List<ForinvestMent> forinvestMentList= forinvestMentService.selectForinvestMentByAnCheID(anCheID);
			view.addObject("forinvestMentList", forinvestMentList);
			//对外担保
			List<ForGuaranteeInfo> forGuaranteeInfoList= forGuaranteeInfoService.selectForGuaranteeInfoByAnCheID(anCheID);
			view.addObject("forGuaranteeInfoList", forGuaranteeInfoList);
            //股权转让
			List<AlterStockInfo> alterStockInfoList= alterStockInfoService.selectAlterStockInfoByAnCheID(anCheID);
			view.addObject("alterStockInfoList", alterStockInfoList); 
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取打印年度报告信息失败!");
            throw new BusinessException("获取打印年度报告息失败!");
		}
	}
    
}
