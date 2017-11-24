/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.BeanUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.service.ICsMessageService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.AlterStockInfo;
import com.icinfo.cs.yr.model.AlterStockInfoHis;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.BaseInfoHis;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;
import com.icinfo.cs.yr.model.ForGuaranteeInfoHis;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.cs.yr.model.ForinvestMentHis;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.cs.yr.model.PbLicenceinfo;
import com.icinfo.cs.yr.model.PbLicenceinfoHis;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.cs.yr.model.PbWebsiteinfoHis;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.cs.yr.model.SfcBaseInfoHis;
import com.icinfo.cs.yr.model.SfcBranchInfo;
import com.icinfo.cs.yr.model.SfcBranchInfoHis;
import com.icinfo.cs.yr.model.SfcLicenceInfo;
import com.icinfo.cs.yr.model.SfcLicenceInfoHis;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;
import com.icinfo.cs.yr.model.SfcWebsiteInfoHis;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.SubcapitalHis;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.cs.yr.model.WebsiteInfoHis;
import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForGuaranteeInfo;
import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrPbLicenceInfo;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.model.YrSfcBranchInfo;
import com.icinfo.cs.yr.model.YrSfcLicenceInfo;
import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.cs.yr.model.YrSfcWebsiteInfo;
import com.icinfo.cs.yr.model.YrSocialSecurity;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.cs.yr.service.IAlterStockInfoHisService;
import com.icinfo.cs.yr.service.IAlterStockInfoService;
import com.icinfo.cs.yr.service.IBaseInfoHisService;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.cs.yr.service.IForGuaranteeInfoHisService;
import com.icinfo.cs.yr.service.IForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IForinvestMentHisService;
import com.icinfo.cs.yr.service.IForinvestMentService;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.cs.yr.service.IPbBaseinfoHisService;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IPbLicenceinfoHisService;
import com.icinfo.cs.yr.service.IPbLicenceinfoService;
import com.icinfo.cs.yr.service.IPbUpdateinfoService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoHisService;
import com.icinfo.cs.yr.service.IPbWebsiteinfoService;
import com.icinfo.cs.yr.service.IPubForbidResultService;
import com.icinfo.cs.yr.service.ISfcBaseInfoHisService;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.cs.yr.service.ISfcBranchInfoHisService;
import com.icinfo.cs.yr.service.ISfcBranchInfoService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoHisService;
import com.icinfo.cs.yr.service.ISfcLicenceInfoService;
import com.icinfo.cs.yr.service.ISfcUpdateinfoService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoHisService;
import com.icinfo.cs.yr.service.ISfcWebsiteInfoService;
import com.icinfo.cs.yr.service.ISubcapitalHisService;
import com.icinfo.cs.yr.service.ISubcapitalService;
import com.icinfo.cs.yr.service.ISysForbidwordService;
import com.icinfo.cs.yr.service.IUpdateInfoService;
import com.icinfo.cs.yr.service.IWebsiteInfoHisService;
import com.icinfo.cs.yr.service.IWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrAlterStockInfoService;
import com.icinfo.cs.yr.service.IYrAssetService;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrCommitService;
import com.icinfo.cs.yr.service.IYrForGuaranteeInfoService;
import com.icinfo.cs.yr.service.IYrForinvestMentService;
import com.icinfo.cs.yr.service.IYrOtherInfoService;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbLicenceInfoService;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.cs.yr.service.IYrSfcBaseinfoService;
import com.icinfo.cs.yr.service.IYrSfcBranchInfoService;
import com.icinfo.cs.yr.service.IYrSfcLicenceInfoService;
import com.icinfo.cs.yr.service.IYrSfcSocialSecurityService;
import com.icinfo.cs.yr.service.IYrSfcWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrSocialSecurityService;
import com.icinfo.cs.yr.service.IYrSubcapitalService;
import com.icinfo.cs.yr.service.IYrWebsiteInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.tools.utils.StringUtils;

/** 
 * 描述: 年报提交Service接口实现类
 * @author ZhouYan
 * @date 2016年9月14日  
 */
/** 
 * 描述: TODO<br>
 * @author 张文男
 * @date 2017年6月12日  
 */
@Service
public class YrCommitServiceImpl extends MyBatisServiceSupport implements IYrCommitService {
	@Autowired
    IYrRegCheckService yrRegCheckService;
	@Autowired
    IModApplicationService modApplicationService;
	@Autowired
	ISysForbidwordService sysForbidwordService;
	@Autowired
	IPubForbidResultService pubForbidResultService;
	@Autowired
	IUpdateInfoService updateInfoService;
	@Autowired
	IYrBaseInfoService yrBaseInfoService;
	@Autowired
	IYrAssetService yrAssetService;
	@Autowired
	IYrOtherInfoService yrOtherInfoService;
	@Autowired
    IYrSocialSecurityService yrSocialSecurityService;
	@Autowired
	IYrSubcapitalService yrSubcapitalService;
	@Autowired
	IYrWebsiteInfoService yrWebsiteInfoService;
	@Autowired
	IYrForGuaranteeInfoService yrForGuaranteeInfoService;
	@Autowired
	IYrForinvestMentService yrForinvestMentService;
	@Autowired
	IYrAlterStockInfoService yrAlterStockInfoService;
	@Autowired
	IBaseInfoService baseInfoService;
	@Autowired
	IBaseInfoHisService baseInfoHisService;
	@Autowired
	ISubcapitalService subcapitalService;
	@Autowired
	ISubcapitalHisService subcapitalHisService;
	@Autowired
	IWebsiteInfoService websiteInfoService;
	@Autowired
	IWebsiteInfoHisService websiteInfoHisService;
	@Autowired
	IForGuaranteeInfoService forGuaranteeInfoService;
	@Autowired
	IForGuaranteeInfoHisService forGuaranteeInfoHisService;
	@Autowired
	IForinvestMentService forinvestMentService;
	@Autowired
	IForinvestMentHisService forinvestMentHisService;
	@Autowired
	IAlterStockInfoService alterStockInfoService;
	@Autowired
	IAlterStockInfoHisService alterStockInfoHisService;
	
	@Autowired
	IYrPbBaseInfoService yrPbBaseInfoService;
	@Autowired
	IPbBaseinfoService pbBaseinfoService;
	@Autowired
	IPbBaseinfoHisService pbBaseinfoHisService;
	@Autowired
	IYrPbWebsiteInfoService yrPbWebsiteInfoService;
	@Autowired
	IPbWebsiteinfoService pbWebsiteinfoService;
	@Autowired
	IPbWebsiteinfoHisService pbWebsiteinfoHisService;
	@Autowired
	IYrPbLicenceInfoService yrPbLicenceInfoService;
	@Autowired
	IPbLicenceinfoService pbLicenceinfoService;
	@Autowired
	IPbLicenceinfoHisService pbLicenceinfoHisService;
	//个体修改记录
	@Autowired
	IPbUpdateinfoService pbUpdateinfoService; 
	
	//农专基本信息
	@Autowired
	IYrSfcBaseinfoService YrSfcBaseinfo;
	//农专公示信息表
	@Autowired
	ISfcBaseInfoService sfcBaseInfoService;
	@Autowired
	ISfcBaseInfoHisService sfcBaseInfoHisService;
	@Autowired
	IYrSfcWebsiteInfoService yrSfcWebsiteInfoService;
	//农专公示网站信息
	@Autowired
	ISfcWebsiteInfoService sfcWebsiteInfoService;
	@Autowired
	ISfcWebsiteInfoHisService sfcWebsiteInfoHisService;
	@Autowired
	IYrSfcLicenceInfoService yrSfcLicenceInfoService;
	//农专公示许可信息
	@Autowired
	ISfcLicenceInfoService sfcLicenceInfoService;
	@Autowired
	ISfcLicenceInfoHisService sfcLicenceInfoHisService;
	@Autowired
	IYrSfcBranchInfoService yrSfcBranchInfoService;
	//农专公示分支机构信息
	@Autowired
	ISfcBranchInfoService  sfcBranchInfoService;
	@Autowired
	ISfcBranchInfoHisService sfcBranchInfoHisService;
	//农专修改记录
	@Autowired
	ISfcUpdateinfoService  sfcUpdateinfoService;
	//农专社社保信息
	@Autowired
	IYrSfcSocialSecurityService yrSfcSocialSecurityService;
	//日志
	@Autowired
	private ISysLogService sysLogService;

	/** 
	 * 描述: 提交年报
	 * @auther ZhouYan
	 * @date 2016年9月23日 
	 * @param pripid 主体身份代码
	 * @param year 年份
	 * @param loginType  登录类型
 	 * @param subIp  ip地址
	 * @param repType 报表的类型有哪些
	 * @throws Exception 
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void doCommitYearReport(String pripid, Integer year, String loginType, String subIp, String repType, String entTypeCatg) throws Exception {
		Date curDate = new Date();
		// a.保存公示信息、敏感词过滤、修改记录   
		boolean forbidFlag = false;
		if(entTypeCatg.equals(Constants.entTypeCatgPB)) { //个体户
			forbidFlag = doCommitPbPubInfo(pripid, year, repType, curDate);
		}else if(Constants.entTypeCatgSFC.indexOf(entTypeCatg) != -1){ //农专
			forbidFlag = doCommitSfcPubInfo(pripid, year, repType, curDate);
		}else{
			forbidFlag = doCommitPubInfo(pripid, year, repType, curDate);
		}
		// b.更新主表信息
		yrRegCheckService.updateYrRegCheck(pripid, year, loginType, subIp, forbidFlag, curDate);
	    // c.设置修改申请失效
		modApplicationService.updateModApplicationInvalid(pripid, year);
		//加日志
		StringBuilder logMsg = new StringBuilder();
		logMsg.append(forbidFlag == false ? "无敏感词；" : "有敏感词；");
		if(loginType.equals(Constants.LOGIN_TYPE_APPPWD)){//app
			logMsg.append("提交方式：个体户App");
		}else{
			logMsg.append("提交方式：" + (loginType.equals(Constants.LOGIN_TYPE_OAUTH) ? "数字证书；" : "联络员；"));
		}
		logMsg.append("提交时间：" + DateUtil.dateToString(curDate, "yyyy-MM-dd HH:mm:ss"));
        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID,pripid);//企业内部序号
        logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,year.toString());//年份
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGEENTYPE,entTypeCatg);//企业类型
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_CLIENT);//企业端
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, logMsg.toString());//提交年报
		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.commitYearReportLog.getCode());//操作类型
		sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
	}


	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param pripid
	 * @param year
	 * @param repType 报表类型有哪些
	 * @param curDate 系统时间
	 * @throws Exception 
	 */
	public boolean doCommitPubInfo(String pripid, Integer year, String repType, Date curDate) throws Exception {
		boolean forbidFlag = false;
		//查询年报业务表基本信息、获取年报ID
		List<YrBaseInfo> yrBaseInfoList = yrBaseInfoService.selectYrBaseInfoByYearAndPriPID(year, pripid);
		if(!yrBaseInfoList.isEmpty()) {
			YrBaseInfo yrBaseInfo = yrBaseInfoList.get(0);//年报业务表基本信息
			String anCheID = yrBaseInfo.getAnCheID();//获取年报ID
			//定义原公示信息list用以保存历史记录、修改比对
			List<WebsiteInfo> websiteInfoOldList = new ArrayList<WebsiteInfo>();
			List<ForGuaranteeInfo> forGuaranteeInfoOldList =  new ArrayList<ForGuaranteeInfo>();
			List<Subcapital> subcapitalOldList =  new ArrayList<Subcapital>();
			List<ForinvestMent>	forinvestMentOldList = new ArrayList<ForinvestMent>();
			List<AlterStockInfo> alterStockInfoOldList = new ArrayList<AlterStockInfo>();
			
			//查询当前公示主表基本信息
			BaseInfo baseInfo = baseInfoService.selectInfoByPripidAndYear(pripid, year);
			
			//如果当前有公示数据，则先保存历史记录，再删除当前数据
			if(baseInfo != null){
				websiteInfoOldList = websiteInfoService.selectWebsiteInfoByAnCheID(anCheID);
				forGuaranteeInfoOldList = forGuaranteeInfoService.selectForGuaranteeInfoByAnCheID(anCheID);
				if(repType.indexOf(RepTypeUtil.formSubcapital) != -1) {
					subcapitalOldList = subcapitalService.selectSubcapitalByAnCheID(anCheID);
				}
				if(repType.indexOf(RepTypeUtil.formForinvestment) != -1) {
					forinvestMentOldList = forinvestMentService.selectForinvestMentByAnCheID(anCheID);
				}
				if(repType.indexOf(RepTypeUtil.formAlterstockinfo) != -1) {
					alterStockInfoOldList = alterStockInfoService.selectAlterStockInfoByAnCheID(anCheID);
				}
				doSaveHisPubInfo(pripid, year, repType, baseInfo, anCheID, websiteInfoOldList, forGuaranteeInfoOldList, subcapitalOldList, forinvestMentOldList, alterStockInfoOldList);
			}
			
			//保存公示信息
			doSaveNewPubInfo(pripid, year, repType, curDate, yrBaseInfo, baseInfo, anCheID);
			
			// 查询当前公示信息用以敏感词过滤、修改比对:
			BaseInfo baseInfoNow = baseInfoService.selectInfoByPripidAndYear(pripid, year);
			List<WebsiteInfo> websiteInfoNowList = websiteInfoService.selectWebsiteInfoByAnCheID(anCheID);
			List<ForGuaranteeInfo> forGuaranteeInfoNowList = forGuaranteeInfoService.selectForGuaranteeInfoByAnCheID(anCheID);
			List<Subcapital> subcapitalNowList = new ArrayList<Subcapital>();
			if(repType.indexOf(RepTypeUtil.formSubcapital) != -1) {
				subcapitalNowList = subcapitalService.selectSubcapitalByAnCheID(anCheID);
			}
			List<ForinvestMent> forinvestMentNowList = new ArrayList<ForinvestMent>();
			if(repType.indexOf(RepTypeUtil.formForinvestment) != -1) {
				forinvestMentNowList = forinvestMentService.selectForinvestMentByAnCheID(anCheID);
			}
			List<AlterStockInfo> alterStockInfoNowList = new ArrayList<AlterStockInfo>();
			if(repType.indexOf(RepTypeUtil.formAlterstockinfo) != -1) {
				alterStockInfoNowList = alterStockInfoService.selectAlterStockInfoByAnCheID(anCheID);
			}
			
			//敏感词过滤
			forbidFlag = doCommitForbidFilter(pripid, year, repType,
					baseInfoNow, subcapitalNowList, forinvestMentNowList,
					alterStockInfoNowList, websiteInfoNowList,
					forGuaranteeInfoNowList);

			//保存修改记录
			if(baseInfo != null){
				doCommitUpdateInfo(anCheID, repType, baseInfoNow, baseInfo,
						subcapitalNowList, subcapitalOldList,
						forinvestMentNowList, forinvestMentOldList,
						alterStockInfoNowList, alterStockInfoOldList,
						websiteInfoNowList, websiteInfoOldList,
						forGuaranteeInfoNowList, forGuaranteeInfoOldList);
			}
		}else{
			throw new BusinessException("年报基本信息为空！");
		}
		return forbidFlag;
	}
	
	/** 
	 * 描述: 保存历史公示信息
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param repType
	 * @param baseInfo
	 * @param anCheID
	 * @param websiteInfoOldList
	 * @param forGuaranteeInfoOldList
	 * @param subcapitalOldList
	 * @param forinvestMentOldList
	 * @param alterStockInfoOldList
	 * @throws Exception 
	 */
	public void doSaveHisPubInfo(String pripid, Integer year, String repType, BaseInfo baseInfo,
			String anCheID, List<WebsiteInfo> websiteInfoOldList,
			List<ForGuaranteeInfo> forGuaranteeInfoOldList,
			List<Subcapital> subcapitalOldList,
			List<ForinvestMent> forinvestMentOldList,
			List<AlterStockInfo> alterStockInfoOldList) throws Exception {
		//历史记录版本号
		String reportNo = StringUtils.uuid();
		//保存公示主表历史记录(包括基本信息、资产状况、其他情况)，删除当前数据
		BaseInfoHis baseInfoHis =  new BaseInfoHis();
		BeanUtil.getBeanUtilsBean().copyProperties(baseInfoHis, baseInfo);
		baseInfoHis.setId(null);
		baseInfoHis.setReportNo(reportNo);

		//处理特殊字符的转义 支持云平台
		if(StringUtil.isNotBlank(baseInfo.getAddr())){
			baseInfoHis.setAddr(baseInfo.getAddr().replace("'","\\\'")); //通讯地址
		}
		if(StringUtil.isNotBlank(baseInfo.getSupEntname())){
			baseInfoHis.setSupEntname(baseInfo.getSupEntname().replace("'","\\\'"));//隶属企业名称
		}
		if(StringUtil.isNotBlank(baseInfo.getEntMainBusActivity())){
			baseInfoHis.setEntMainBusActivity(baseInfo.getEntMainBusActivity().replace("'","\\\'"));//企业主营业务活动
		}

		baseInfoHisService.insert(baseInfoHis);
		baseInfoService.deleteByAnCheID(anCheID);
		//保存网站历史记录，删除当前数据
		for(WebsiteInfo websiteInfo : websiteInfoOldList){
			WebsiteInfoHis websiteInfoHis = new WebsiteInfoHis();
			BeanUtil.getBeanUtilsBean().copyProperties(websiteInfoHis, websiteInfo);
			websiteInfoHis.setId(null);
			websiteInfoHis.setReportNo(reportNo);
			websiteInfoHis.setWebSitName(websiteInfo.getWebSitName().replace("'","\\\'"));//网站网店名称
			websiteInfoHisService.insert(websiteInfoHis);
			websiteInfoService.deleteByAnCheID(anCheID);
		}
		//保存对外担保历史记录，删除当前数据
		for(ForGuaranteeInfo forGuaranteeInfo : forGuaranteeInfoOldList){
			ForGuaranteeInfoHis forGuaranteeInfoHis = new ForGuaranteeInfoHis();
			BeanUtil.getBeanUtilsBean().copyProperties(forGuaranteeInfoHis, forGuaranteeInfo);
			forGuaranteeInfoHis.setId(null);
			forGuaranteeInfoHis.setReportNo(reportNo);
			//处理特殊字符的转义 支持云平台
			if(StringUtil.isNotBlank(forGuaranteeInfo.getMore())){
				forGuaranteeInfoHis.setMore(forGuaranteeInfo.getMore().replace("'","\\\'"));
			}
			if(StringUtil.isNotBlank(forGuaranteeInfo.getMortgagor())){
				forGuaranteeInfoHis.setMortgagor(forGuaranteeInfo.getMortgagor().replace("'","\\\'"));
			}
			forGuaranteeInfoHisService.insert(forGuaranteeInfoHis);
			forGuaranteeInfoService.deleteByAnCheID(anCheID);
		}
		//保存出资情况历史记录，删除当前数据
		if(repType.indexOf(RepTypeUtil.formSubcapital) != -1) {
			for(Subcapital subcapital : subcapitalOldList){
				SubcapitalHis subcapitalHis = new SubcapitalHis();
				BeanUtil.getBeanUtilsBean().copyProperties(subcapitalHis, subcapital);
				subcapitalHis.setId(null);
				subcapitalHis.setReportNo(reportNo);
				//处理特殊字符的转义 支持云平台
				subcapitalHis.setInv(subcapital.getInv().replace("'","\\\'"));//股东（发起人）
				subcapitalHisService.insert(subcapitalHis);
				subcapitalService.deleteByAnCheID(anCheID);
			}
		}
		//保存对外投资历史记录，删除当前数据
		if(repType.indexOf(RepTypeUtil.formForinvestment) != -1) {
			for(ForinvestMent forinvestMent : forinvestMentOldList){
				ForinvestMentHis forinvestMentHis = new ForinvestMentHis();
				BeanUtil.getBeanUtilsBean().copyProperties(forinvestMentHis, forinvestMent);
				forinvestMentHis.setId(null);
				forinvestMentHis.setReportNo(reportNo);
				//处理特殊字符的转义 支持云平台
				forinvestMentHis.setEntName(forinvestMent.getEntName().replace("'","\\\'"));//投资设立
				forinvestMentHisService.insert(forinvestMentHis);
				forinvestMentService.deleteByAnCheID(anCheID);
			}
		}
		//保存股权转让历史记录，删除当前数据
		if(repType.indexOf(RepTypeUtil.formAlterstockinfo) != -1) {
			for(AlterStockInfo alterStockInfo : alterStockInfoOldList){
				AlterStockInfoHis alterStockInfoHis = new AlterStockInfoHis();
				BeanUtil.getBeanUtilsBean().copyProperties(alterStockInfoHis, alterStockInfo);
				alterStockInfoHis.setId(null);
				alterStockInfoHis.setReportNo(reportNo);
				//处理特殊字符的转义 支持云平台
				alterStockInfoHis.setInv(alterStockInfo.getInv().replace("'","\\\'"));
				alterStockInfoHisService.insert(alterStockInfoHis);
				alterStockInfoService.deleteByAnCheID(anCheID);
			}
		}
		
		//更新历史敏感词记录信息年报编号
		pubForbidResultService.updateHis(pripid, year, reportNo);
		
		//更新历史修改记录信息年报编号
		updateInfoService.updateHis(anCheID, reportNo);
	}
	
	/** 
	 * 描述: 保存本次年报提交的公示信息
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param curDate
	 * @param yrBaseInfo
	 * @param baseInfo
	 * @param anCheID
	 * @throws Exception 
	 */
	public void doSaveNewPubInfo(String pripid, Integer year, String repType,
			Date curDate, YrBaseInfo yrBaseInfo, BaseInfo baseInfo,
			String anCheID) throws Exception {
		BaseInfo baseInfoNew = new BaseInfo();
		//保存公示主表信息(包括基本信息、资产状况、其他情况)
		YrAsset yrAsset = yrAssetService.selectYrAssetByYearAndPripid(year, pripid);
		YrOtherInfo yrOtherInfo = yrOtherInfoService.selectOtherInfoListByYearPriID(pripid, year);
		YrSocialSecurity yrSocialSecurity = yrSocialSecurityService.selectByYearAndPripid(year, pripid);
		BeanUtil.getBeanUtilsBean().copyProperties(baseInfoNew, yrBaseInfo);
		BeanUtil.getBeanUtilsBean().copyProperties(baseInfoNew, yrAsset);
		BeanUtil.getBeanUtilsBean().copyProperties(baseInfoNew, yrOtherInfo);
		//2016年度开始填写社保信息
		if(year > 2015) {
			BeanUtil.getBeanUtilsBean().copyProperties(baseInfoNew, yrSocialSecurity);
		}

		//chenyl 2016-10-14 BaseInfo表主键ID修改为null
		baseInfoNew.setId(null);
		//残疾人雇工数字段名不一样，手动赋值
		baseInfoNew.setDisableMgr(yrAsset.getDisOpers());
		//设置最近年报时间
		baseInfoNew.setLastReportTime(curDate);
		//处理特殊字符的转义 支持云平台
		if(StringUtil.isNotBlank(yrAsset.getEntMainBusActivity())){
			baseInfoNew.setEntMainBusActivity(yrAsset.getEntMainBusActivity().replace("'","\\\'"));
		}
		if(StringUtil.isNotBlank(yrOtherInfo.getAddr())){
			baseInfoNew.setAddr(yrOtherInfo.getAddr().replace("'","\\\'"));
		}
		if(StringUtil.isNotBlank(yrOtherInfo.getSupEntname())){
			baseInfoNew.setSupEntname(yrOtherInfo.getSupEntname().replace("'","\\\'"));
		}

		//首次提交，设置年报时间，否则取上次时间
		if(baseInfo != null){
			baseInfoNew.setAncheDate(baseInfo.getAncheDate());
		}else{
			baseInfoNew.setAncheDate(curDate);
		}
		baseInfoService.insert(baseInfoNew);
		
		// 云平台不支持select into, so change the method~ 2016-11-11 13:52:45 by Zhou Yan
		// 保存网站信息
		List<YrWebsiteInfo> yrWebsiteInfoList = yrWebsiteInfoService.selectYrWebsiteInfoByPriPIDAndYear(pripid, year);
		for(YrWebsiteInfo yrWebsiteInfo : yrWebsiteInfoList){
			WebsiteInfo websiteInfo = new WebsiteInfoHis();
			BeanUtil.getBeanUtilsBean().copyProperties(websiteInfo, yrWebsiteInfo);
			websiteInfo.setId(null);
			//处理特殊字符的转义 支持云平台
			websiteInfo.setWebSitName(yrWebsiteInfo.getWebSitName().replace("'","\\\'"));
			websiteInfoService.insert(websiteInfo);
		}
		// 保存对外担保信息
		List<YrForGuaranteeInfo> yrForGuaranteeInfoList = yrForGuaranteeInfoService.selectYrForGuaranteeInfoByYearAndPriPID(year, pripid);
		for(YrForGuaranteeInfo yrForGuaranteeInfo : yrForGuaranteeInfoList){
			ForGuaranteeInfo forGuaranteeInfo = new ForGuaranteeInfo();
			BeanUtil.getBeanUtilsBean().copyProperties(forGuaranteeInfo, yrForGuaranteeInfo);
			forGuaranteeInfo.setId(null);
			//处理特殊字符的转义 支持云平台
			forGuaranteeInfo.setMore(yrForGuaranteeInfo.getMore().replace("'","\\\'"));
			forGuaranteeInfo.setMortgagor(yrForGuaranteeInfo.getMortgagor().replace("'","\\\'"));
			forGuaranteeInfoService.insert(forGuaranteeInfo);
		}
		
		//保存出资情况
		if(repType.indexOf(RepTypeUtil.formSubcapital) != -1) {
			List<YrSubcapital> yrSubcapitalList = yrSubcapitalService.selectByYearAndPripidList(year, pripid);
			for(YrSubcapital yrSubcapital : yrSubcapitalList){
				Subcapital subcapital = new Subcapital();
				BeanUtil.getBeanUtilsBean().copyProperties(subcapital, yrSubcapital);
				subcapital.setId(null);
				//处理特殊字符的转义 支持云平台
				subcapital.setInv(yrSubcapital.getInv().replace("'","\\\'"));
				subcapitalService.insert(subcapital);
			}
		}
		//保存对外投资信息
		if(repType.indexOf(RepTypeUtil.formForinvestment) != -1) {
			List<YrForinvestMent> yrForinvestMentList = yrForinvestMentService.selectByYearAndPripidList(year, pripid);
			for(YrForinvestMent yrForinvestMent : yrForinvestMentList){
				ForinvestMent forinvestMent = new ForinvestMent();
				BeanUtil.getBeanUtilsBean().copyProperties(forinvestMent, yrForinvestMent);
				forinvestMent.setId(null);
				//处理特殊字符的转义 支持云平台
				forinvestMent.setEntName(yrForinvestMent.getEntName().replace("'","\\\'"));
				forinvestMentService.insert(forinvestMent);
			}
		}
		//保存股权转让（或叫变更）
		if(repType.indexOf(RepTypeUtil.formAlterstockinfo) != -1) {
			List<YrAlterStockInfo> yrAlterStockInfoList = yrAlterStockInfoService.selectYrAlterStockInfoByPriPID(year, pripid);
			for(YrAlterStockInfo yrAlterStockInfo : yrAlterStockInfoList){
				AlterStockInfo alterStockInfo = new AlterStockInfo();
				BeanUtil.getBeanUtilsBean().copyProperties(alterStockInfo, yrAlterStockInfo);
				alterStockInfo.setId(null);
				//处理特殊字符的转义 支持云平台
				alterStockInfo.setInv(yrAlterStockInfo.getInv().replace("'","\\\'"));
				alterStockInfoService.insert(alterStockInfo);
			}
		}
	}
	
	
	/** 
	 * 描述: 敏感词过滤
	 * @auther ZhouYan
	 * @date 2016年9月18日 
	 * @param pripid
	 * @param year
	 * @param
	 * @return
	 * @throws Exception 
	 */
	public boolean doCommitForbidFilter(String pripid, Integer year,
			String repType, BaseInfo baseInfo,
			List<Subcapital> subcapitalList,
			List<ForinvestMent> forinvestMentList,
			List<AlterStockInfo> alterStockInfoList,
			List<WebsiteInfo> websiteInfoList,
			List<ForGuaranteeInfo> forGuaranteeInfoList) throws Exception {
		boolean forbidFlag = false;
		// 敏感词校验：基本情况
		String baseInfoRlt = null;
		if(repType.indexOf(RepTypeUtil.formAsset) != -1) {
			baseInfoRlt = doCheckForbidWord(baseInfo.getPubForbidInfo());//非分支机构
		}else{
			baseInfoRlt = doCheckForbidWord(baseInfo.getPubForbidInfoBranch());//分支机构
		}
		if (!baseInfoRlt.equals("")) {
			forbidFlag = true;
			pubForbidResultService.insert(pripid, year, "cs_baseinfo", baseInfoRlt);
		}
		//敏感词校验：出资情况
		if(repType.indexOf(RepTypeUtil.formSubcapital) != -1) {
			for (Subcapital subcapital : subcapitalList) {
				String subcapitalRlt = doCheckForbidWord(subcapital.getPubForbidInfo());
				if (!subcapitalRlt.equals("")) {
					forbidFlag = true;
					pubForbidResultService.insert(pripid, year, "cs_subcapital", subcapitalRlt);
				}
			}
		}
		// 敏感词校验：对外投资
		if(repType.indexOf(RepTypeUtil.formForinvestment) != -1) {
			for (ForinvestMent forinvestMent : forinvestMentList) {
				String forinvestMentRlt = doCheckForbidWord(forinvestMent.getPubForbidInfo());
				if (!forinvestMentRlt.equals("")) {
					forbidFlag = true;
					pubForbidResultService.insert(pripid, year, "cs_forinvestment", forinvestMentRlt);
				}
			}
		}
		// 敏感词校验：股权转让
		if(repType.indexOf(RepTypeUtil.formAlterstockinfo) != -1) {
			for (AlterStockInfo alterStockInfo : alterStockInfoList) {
				String alterStockInfoRlt = doCheckForbidWord(alterStockInfo.getPubForbidInfo());
				if (!alterStockInfoRlt.equals("")) {
					forbidFlag = true;
					pubForbidResultService.insert(pripid, year, "cs_alterstockinfo", alterStockInfoRlt);
				}
			}
		}
		// 敏感词校验：网站
		for (WebsiteInfo websiteInfo : websiteInfoList) {
			String websiteInfoRlt = doCheckForbidWord(websiteInfo.getPubForbidInfo());
			if (!websiteInfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_websiteinfo", websiteInfoRlt);
			}
		}
		// 敏感词校验：对外担保
		for (ForGuaranteeInfo forGuaranteeInfo : forGuaranteeInfoList) {
			String forGuaranteeInfoRlt = doCheckForbidWord(forGuaranteeInfo.getPubForbidInfo());
			if (!forGuaranteeInfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_forguaranteeinfo", forGuaranteeInfoRlt);
			}
		}
		return forbidFlag;
	}
	
	/** 
	 * 描述: 校验敏感词、返回结果
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	public String doCheckForbidWord(String content) throws Exception {
		// 敏感词对比标志
		boolean sentiveFlag = false;
		List<SysForbidword> sysForbidwordList = sysForbidwordService.doGetListForCache();
		//过滤掉所有特殊字符
		content = StringUtil.StringFilter(content);
		for (SysForbidword sysForbidword : sysForbidwordList) {
			if (content.indexOf(sysForbidword.getBanLetter()) != -1) {
				content = content.replaceAll(sysForbidword.getBanLetter(), "<font style=\"background:yellow\">"+sysForbidword.getBanLetter()+"</font>") + "敏感词：" + sysForbidword.getBanLetter() + ",";
				sentiveFlag = true;
			}
		}
		if (!sentiveFlag) {
			return content = "";
		}
		content = content.substring(0, content.lastIndexOf(","));
		return content;
	}
	
	/** 
	 * 描述: 保存修改记录
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param anCheID
	 * @param repType
	 * @param baseInfoNow
	 * @param baseInfo
	 * @param subcapitalNowList
	 * @param subcapitalOldList
	 * @param forinvestMentNowList
	 * @param forinvestMentOldList
	 * @param alterStockInfoNowList
	 * @param alterStockInfoOldList
	 * @param websiteInfoNowList
	 * @param websiteInfoOldList
	 * @param forGuaranteeInfoNowList
	 * @param forGuaranteeInfoOldList
	 * @throws Exception 
	 */
	public void doCommitUpdateInfo(String anCheID, String repType,
			BaseInfo baseInfoNow, BaseInfo baseInfo,
			List<Subcapital> subcapitalNowList,
			List<Subcapital> subcapitalOldList,
			List<ForinvestMent> forinvestMentNowList,
			List<ForinvestMent> forinvestMentOldList,
			List<AlterStockInfo> alterStockInfoNowList,
			List<AlterStockInfo> alterStockInfoOldList,
			List<WebsiteInfo> websiteInfoNowList,
			List<WebsiteInfo> websiteInfoOldList,
			List<ForGuaranteeInfo> forGuaranteeInfoNowList,
			List<ForGuaranteeInfo> forGuaranteeInfoOldList) throws Exception {
		//基本信息修改记录
		updateInfoService.doCompareEntity(baseInfoNow,baseInfo, new String[] {"tel", "addr", "postalCode", "email", "busStatusCN", "supRegNO", "supEntname", "assGroIsPub", "empNumDis", "vendIncIsPub", "liaGroIsPub", "maiBusIncIsPub", "ratGroIsPub", "netIncIsPub", "proGroIsPub", "totEquIsPub", "endowmentNum", "unemploymentNum", "medicalNum", "empInjuryNum", "maternityNum", "paymentBaseIsPub", "actualPaymentIsPub", "cumulArrearsIsPub", "entMainBusActivity", "entControlIsPub", "femaleEmployeIsPub"},anCheID);
		//网站修改记录
		updateInfoService.doCompareList(websiteInfoNowList, websiteInfoOldList, new String[]{"webSite"}, new String[] { "webSitName", "webSite" ,"webType"},anCheID);
		//对外担保修改记录
		updateInfoService.doCompareList(forGuaranteeInfoNowList, forGuaranteeInfoOldList, new String[]{"moreID"}, new String[] { "more", "mortgagor" ,"priClaSecKind","priClaSecAm","pefPerForm","pefPerTo","gaType","isPubFlag","guaPeriod"},anCheID);
		//出资情况修改记录
		if(repType.indexOf(RepTypeUtil.formSubcapital) != -1) {
			updateInfoService.doCompareList(subcapitalNowList, subcapitalOldList, new String[]{"invID"}, new String[] { "inv", "acConDate" ,"liacconam", "lisubconam", "invRegNO", "conFormCN", "acConFormCn", "subConDate"},anCheID);
		}
		//对外投资修改记录
		if(repType.indexOf(RepTypeUtil.formForinvestment) != -1) {
			updateInfoService.doCompareList(forinvestMentNowList, forinvestMentOldList, new String[]{"OUTINVID"}, new String[] { "entName", "uniCode"},anCheID);
		}
		//股权转让修改记录
		if(repType.indexOf(RepTypeUtil.formAlterstockinfo) != -1) {
			updateInfoService.doCompareList(alterStockInfoNowList, alterStockInfoOldList, new String[]{"invAltID"}, new String[] { "inv", "altDate" ,"beTransAmPr","afTransAmPr"},anCheID);
		}
	}
	
	/** 
	 * 描述: 保存个体户公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param curDate
	 * @return
	 * @throws Exception 
	 */
	public boolean doCommitPbPubInfo(String pripid, Integer year, String repType, Date curDate) throws Exception {
		boolean forbidFlag = false;
		//查询年报业务表基本信息、获取年报ID
		 YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year.toString(), pripid, "0");
		if(yrPbBaseInfo != null) {
			String anCheID = yrPbBaseInfo.getAnCheID();//获取年报ID
			//定义原公示信息list用以保存历史记录、修改比对
			List<PbWebsiteinfo> pbWebsiteInfoOldList = new ArrayList<PbWebsiteinfo>();
			List<PbLicenceinfo> pbLicenceInfoOldList = new ArrayList<PbLicenceinfo>();
			
			//查询当前公示主表基本信息
			PbBaseinfo pbBaseinfo = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year.toString());
			
			//如果当前有公示数据，则先保存历史记录，再删除当前数据
			if(pbBaseinfo != null){
				pbWebsiteInfoOldList = pbWebsiteinfoService.selectPbWebsiteInfoByAnCheID(anCheID);
				pbLicenceInfoOldList = pbLicenceinfoService.selectPbLicenceinfoByAnCheID(anCheID);
				doSaveHisPbPubInfo(pripid, year, repType, pbBaseinfo, anCheID, pbWebsiteInfoOldList, pbLicenceInfoOldList);
			}
			
			//保存公示信息
			doSaveNewPbPubInfo(pripid, year, repType, curDate, yrPbBaseInfo, pbBaseinfo, anCheID);
			
			// 查询当前公示信息用以敏感词过滤、修改比对:
			PbBaseinfo pbBaseinfoNow = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year.toString());
			List<PbWebsiteinfo> pbWebsiteinfoNowList = pbWebsiteinfoService.selectPbWebsiteInfoByAnCheID(anCheID);
			List<PbLicenceinfo> pbLicenceinfoNowList = pbLicenceinfoService.selectPbLicenceinfoByAnCheID(anCheID);
			
			//敏感词过滤
			forbidFlag = doCommitForbidFilter(pripid, year, repType, pbBaseinfoNow, pbWebsiteinfoNowList, pbLicenceinfoNowList);

			//保存修改记录
			if(pbBaseinfo != null){
				doCommitPbUpdateInfo(anCheID, repType, pbBaseinfoNow, pbBaseinfo,
						pbWebsiteinfoNowList, pbWebsiteInfoOldList,
						pbLicenceinfoNowList, pbLicenceInfoOldList);
			}
		}else{
			throw new BusinessException("年报基本信息为空！");
		}
		return forbidFlag;
	}
	
	/** 
	 * 描述: 保存历史公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param pbBaseinfo
	 * @param anCheID
	 * @param pbWebsiteInfoOldList
	 * @param pbLicenceInfoOldList
	 * @throws Exception 
	 */
	public void doSaveHisPbPubInfo(String pripid, Integer year, String repType, PbBaseinfo pbBaseinfo,
			String anCheID, List<PbWebsiteinfo> pbWebsiteInfoOldList,
			List<PbLicenceinfo> pbLicenceInfoOldList) throws Exception {
		//历史记录版本号
		String reportNo = StringUtils.uuid();
		//保存公示主表历史记录(包括基本信息、资产状况、其他情况)，删除当前数据
		PbBaseinfoHis pbBaseinfoHis =  new PbBaseinfoHis();
		BeanUtil.getBeanUtilsBean().copyProperties(pbBaseinfoHis, pbBaseinfo);
		pbBaseinfoHis.setId(null);
		pbBaseinfoHis.setReportNo(reportNo);
		pbBaseinfoHisService.insert(pbBaseinfoHis);
		pbBaseinfoService.deleteByAnCheID(anCheID);
		//保存网站历史记录，删除当前数据
		for(PbWebsiteinfo pbWebsiteinfo : pbWebsiteInfoOldList){
			PbWebsiteinfoHis pbWebsiteinfoHis = new PbWebsiteinfoHis();
			BeanUtil.getBeanUtilsBean().copyProperties(pbWebsiteinfoHis, pbWebsiteinfo);
			pbWebsiteinfoHis.setId(null);
			pbWebsiteinfoHis.setReportNo(reportNo);
			//处理特殊字符的转义 支持云平台
			pbWebsiteinfoHis.setWebSitName(pbWebsiteinfo.getWebSitName().replace("'","\\\'"));
			pbWebsiteinfoHisService.insert(pbWebsiteinfoHis);
			pbWebsiteinfoService.deleteByAnCheID(anCheID);
		}
		//保存行政许可历史记录，删除当前数据
		for(PbLicenceinfo pbLicenceinfo : pbLicenceInfoOldList){
			PbLicenceinfoHis pbLicenceinfoHis = new PbLicenceinfoHis();
			BeanUtil.getBeanUtilsBean().copyProperties(pbLicenceinfoHis, pbLicenceinfo);
			pbLicenceinfoHis.setId(null);
			pbLicenceinfoHis.setReportNo(reportNo);
			pbLicenceinfoHisService.insert(pbLicenceinfoHis);
			pbLicenceinfoService.deleteByAnCheID(anCheID);
		}
		
		//更新历史敏感词记录信息年报编号
		pubForbidResultService.updateHis(pripid, year, reportNo);
		
		//更新历史修改记录信息年报编号
		pbUpdateinfoService.updateHis(anCheID, reportNo);
	}
	
	/** 
	 * 描述: 保存本次年报提交的公示信息
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param curDate
	 * @param
	 * @param
	 * @param anCheID
	 * @throws Exception 
	 */
	public void doSaveNewPbPubInfo(String pripid, Integer year, String repType,
			Date curDate, YrPbBaseInfo yrPbBaseInfo, PbBaseinfo pbBaseinfo,
			String anCheID) throws Exception {
		PbBaseinfo pbBaseinfoNew = new PbBaseinfo();
		//保存公示主表信息
		BeanUtil.getBeanUtilsBean().copyProperties(pbBaseinfoNew, yrPbBaseInfo);
		//设置最近年报时间
		pbBaseinfoNew.setId(null);
		pbBaseinfoNew.setLastReportTime(curDate);
		//首次提交，设置年报时间，否则取上次时间
		if(pbBaseinfo != null){
			pbBaseinfoNew.setAncheDate(pbBaseinfo.getAncheDate());
		}else{
			pbBaseinfoNew.setAncheDate(curDate);
		}
		pbBaseinfoService.insert(pbBaseinfoNew);
		//保存网站信息
		List<YrPbWebsiteInfo> YrPbWebsiteInfoList = yrPbWebsiteInfoService.selectPbWebsiteListByanCheID(anCheID);
		for(YrPbWebsiteInfo yrPbWebsiteInfo : YrPbWebsiteInfoList){
			PbWebsiteinfo pbWebsiteinfo = new PbWebsiteinfo();
			BeanUtil.getBeanUtilsBean().copyProperties(pbWebsiteinfo, yrPbWebsiteInfo);
			pbWebsiteinfo.setId(null);
			//处理特殊字符的转义 支持云平台
			pbWebsiteinfo.setWebSitName(yrPbWebsiteInfo.getWebSitName().replace("'","\\\'"));
			pbWebsiteinfoService.insert(pbWebsiteinfo);
		}
		//保存行政许可信息
		List<YrPbLicenceInfo> yrPbLicenceInfoList = yrPbLicenceInfoService.selectPbLicenceListByAnCheID(anCheID);
		for(YrPbLicenceInfo yrPbLicenceInfo : yrPbLicenceInfoList){
			PbLicenceinfo pbLicenceinfo = new PbLicenceinfo();
			BeanUtil.getBeanUtilsBean().copyProperties(pbLicenceinfo, yrPbLicenceInfo);
			pbLicenceinfo.setId(null);
			pbLicenceinfoService.insert(pbLicenceinfo);
		}
	}
	
	/** 
	 * 描述: 敏感词过滤
	 * @auther ZhouYan
	 * @date 2016年9月18日 
	 * @param pripid
	 * @param year
	 * @param
	 * @return
	 * @throws Exception 
	 */
	public boolean doCommitForbidFilter(String pripid, Integer year,
			String repType, PbBaseinfo pbBaseinfo,
			List<PbWebsiteinfo> pbWebsiteinfoList, List<PbLicenceinfo> pbLicenceinfoList) throws Exception {
		boolean forbidFlag = false;
		// 敏感词校验：基本情况
		String pbBaseinfoRlt = doCheckForbidWord(pbBaseinfo.getPubForbidInfo());//非分支机构
		if (!pbBaseinfoRlt.equals("")) {
			forbidFlag = true;
			pubForbidResultService.insert(pripid, year, "cs_pb_baseinfo", pbBaseinfoRlt);
		}
		// 敏感词校验：网站
		for (PbWebsiteinfo pbWebsiteinfo : pbWebsiteinfoList) {
			String pbWebsiteinfoRlt = doCheckForbidWord(pbWebsiteinfo.getPubForbidInfo());
			if (!pbWebsiteinfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_pb_websiteinfo", pbWebsiteinfoRlt);
			}
		}
		// 敏感词校验：行政许可
		for (PbLicenceinfo pbLicenceinfo : pbLicenceinfoList) {
			String pbLicenceinfoRlt = doCheckForbidWord(pbLicenceinfo.getPubForbidInfo());
			if (!pbLicenceinfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_pb_licenceinfo", pbLicenceinfoRlt);
			}
		}
		return forbidFlag;
	}
	
	/** 
	 * 描述: 保存修改记录
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param anCheID
	 * @param repType

	 * @throws Exception 
	 */
	public void doCommitPbUpdateInfo(String anCheID, String repType,
			PbBaseinfo pbBaseinfoNow, PbBaseinfo pbBaseinfo,
			List<PbWebsiteinfo> pbWebsiteinfoNowList,
			List<PbWebsiteinfo> pbWebsiteInfoOldList,
			List<PbLicenceinfo> pbLicenceinfoNowList,
			List<PbLicenceinfo> pbLicenceInfoOldList
			) throws Exception {
		//基本信息修改记录
		pbUpdateinfoService.doCompareEntity(pbBaseinfoNow,pbBaseinfo, new String[] {"tel", "empNum", "fundAm", "ratGroIsPub", "vendIncIsPub"},anCheID);
		//网站修改记录
		pbUpdateinfoService.doCompareList(pbWebsiteinfoNowList, pbWebsiteInfoOldList, new String[]{"webSite"}, new String[] { "webSitName", "webSite" ,"webType"},anCheID);
		//行政许可修改记录
		pbUpdateinfoService.doCompareList(pbLicenceinfoNowList, pbLicenceInfoOldList, new String[]{"licID"}, new String[] { "licID", "licNameCN" ,"licName","valTo"},anCheID);
	}
	
	/**
	 * 
	 * 描述: 保存农专公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param curDate
	 * @return
	 */
	private boolean doCommitSfcPubInfo(String pripid, Integer year,String repType, Date curDate) throws Exception {
		boolean forbidFlag = false;
		//查询年报业务表基本信息、获取年报ID
		 YrSfcBaseinfo yrSfcBaseinfo = YrSfcBaseinfo.selectYrSfcBaseInfoByYearAndPripid(year.toString(), pripid, "0");
		if(yrSfcBaseinfo != null) {
			String anCheID = yrSfcBaseinfo.getAnCheID();//获取年报ID
			//定义原公示信息list用以保存历史记录、修改比对
			List<SfcWebsiteInfo> sfcWebsiteInfoOldList = new ArrayList<SfcWebsiteInfo>();
			List<SfcLicenceInfo> sfcLicenceInfoOldList = new ArrayList<SfcLicenceInfo>();
			List<SfcBranchInfo> sfcBranchInfoOldList = new ArrayList<SfcBranchInfo>();
			//查询当前公示主表基本信息
			SfcBaseInfo sfcBaseInfo = sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(pripid, year);
			//如果当前有公示数据，则先保存历史记录，再删除当前数据
			if(sfcBaseInfo != null){
				sfcWebsiteInfoOldList = sfcWebsiteInfoService.selectSfcWebsiteInfoByAnCheID(anCheID);
				sfcLicenceInfoOldList = sfcLicenceInfoService.selectSfcLicenceInfoByAnCheID(anCheID);
				sfcBranchInfoOldList = sfcBranchInfoService.selectSfcBranchInfoByAnCheID(anCheID);
				doSaveHisSfcPubInfo(pripid, year, repType, sfcBaseInfo, anCheID, sfcWebsiteInfoOldList, sfcLicenceInfoOldList,sfcBranchInfoOldList);
			}
			//保存公示信息
			doSaveNewSfcPubInfo(pripid, year, repType, curDate, yrSfcBaseinfo, sfcBaseInfo, anCheID);
			// 查询当前公示信息用以敏感词过滤、修改比对:
			SfcBaseInfo sfcBaseInfoNow = sfcBaseInfoService.selectSfcBaseInfoByPriPIdAndYear(pripid, year);
			List<SfcWebsiteInfo> sfcWebsiteinfoNowList = sfcWebsiteInfoService.selectSfcWebsiteInfoByAnCheID(anCheID);
			List<SfcLicenceInfo> sfcLicenceinfoNowList = sfcLicenceInfoService.selectSfcLicenceInfoByAnCheID(anCheID);
			List<SfcBranchInfo> sfcBranchInfoNowList = sfcBranchInfoService.selectSfcBranchInfoByAnCheID(anCheID);
			
			//敏感词过滤
			forbidFlag = doCommitForbidFilter(pripid, year, repType, sfcBaseInfoNow, 
					sfcWebsiteinfoNowList, sfcLicenceinfoNowList,sfcBranchInfoNowList);

			//保存修改记录
			if(sfcBaseInfo != null){
				doCommitsfcUpdateInfo(anCheID, repType, sfcBaseInfoNow, sfcBaseInfo,
						sfcWebsiteinfoNowList, sfcWebsiteInfoOldList,sfcLicenceinfoNowList, sfcLicenceInfoOldList,
						sfcBranchInfoNowList,sfcBranchInfoOldList);
			}
		}else{
			throw new BusinessException("年报基本信息为空！");
		}
		return forbidFlag;
	}


	/**
	 * 
	 * 描述: 保存农专历史公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param sfcBaseInfo
	 * @param anCheID
	 * @param sfcWebsiteInfoOldList
	 * @param sfcLicenceInfoOldList
	 * @param sfcBranchInfoOldList
	 */
	private void doSaveHisSfcPubInfo(String pripid, Integer year,String repType, SfcBaseInfo sfcBaseInfo, String anCheID,
			List<SfcWebsiteInfo> sfcWebsiteInfoOldList,List<SfcLicenceInfo> sfcLicenceInfoOldList,List<SfcBranchInfo> sfcBranchInfoOldList) throws Exception {
		       //历史记录版本号
				String reportNo = StringUtils.uuid();
				//保存公示主表历史记录(包括基本信息、网站信息、资产状况信息、许可信息、分支机构信息)，删除当前数据
				SfcBaseInfoHis sfcBaseInfoHis = new SfcBaseInfoHis();
				BeanUtil.getBeanUtilsBean().copyProperties(sfcBaseInfoHis, sfcBaseInfo);
				sfcBaseInfoHis.setId(null);
				sfcBaseInfoHis.setReportNo(reportNo);
				//处理特殊字符的转义 支持云平台
				if(StringUtil.isNotBlank(sfcBaseInfo.getEntMainBusActivity())){
					sfcBaseInfoHis.setEntMainBusActivity(sfcBaseInfo.getEntMainBusActivity().replace("'","\\\'"));
				}
				//保存公示基本信息历史记录表，删除当前公示基本信息
				sfcBaseInfoHisService.insert(sfcBaseInfoHis);
				sfcBaseInfoService.deleteByAnCheID(anCheID);
				//保存网站历史记录，删除当前数据
				for(SfcWebsiteInfo sfcWebsiteinfo : sfcWebsiteInfoOldList){
					SfcWebsiteInfoHis sfcWebsiteInfoHis = new SfcWebsiteInfoHis();
					BeanUtil.getBeanUtilsBean().copyProperties(sfcWebsiteInfoHis, sfcWebsiteinfo);
					sfcWebsiteInfoHis.setId(null);
					sfcWebsiteInfoHis.setReportNo(reportNo);
					//处理特殊字符的转义 支持云平台
					sfcWebsiteInfoHis.setWebSitName(sfcWebsiteinfo.getWebSitName().replace("'","\\\'"));
					sfcWebsiteInfoHisService.insert(sfcWebsiteInfoHis);
					sfcWebsiteInfoService.deleteByAnCheID(anCheID);
				}
				//保存行政许可历史记录，删除当前数据
				for(SfcLicenceInfo sfcLicenceInfo  : sfcLicenceInfoOldList){
					SfcLicenceInfoHis sfcLicenceInfoHis = new SfcLicenceInfoHis();
					BeanUtil.getBeanUtilsBean().copyProperties(sfcLicenceInfoHis, sfcLicenceInfo);
					sfcLicenceInfoHis.setId(null);
					sfcLicenceInfoHis.setReportNo(reportNo);
					sfcLicenceInfoHisService.insert(sfcLicenceInfoHis);
					sfcLicenceInfoService.deleteByAnCheID(anCheID);
				}
				
				//保存分支机构历史记录，删除当前数据
				for(SfcBranchInfo sfcBranchInfo  : sfcBranchInfoOldList){
					SfcBranchInfoHis sfcBranchInfoHis = new SfcBranchInfoHis();
					BeanUtil.getBeanUtilsBean().copyProperties(sfcBranchInfoHis, sfcBranchInfo);
					sfcBranchInfoHis.setId(null);
					sfcBranchInfoHis.setReportNo(reportNo);
					//处理特殊字符的转义 支持云平台
					sfcBranchInfoHis.setBrName(sfcBranchInfo.getBrName().replace("'","\\\'"));
					sfcBranchInfoHisService.insert(sfcBranchInfoHis);
					sfcBranchInfoService.deleteByAnCheID(anCheID);
				}
				
				//更新历史敏感词记录信息年报编号
				pubForbidResultService.updateHis(pripid, year, reportNo);
				
				//更新历史修改记录信息年报编号(还需修改)
				sfcUpdateinfoService.updateHis(anCheID, reportNo);
		
	}
	
	/**
	 * 
	 * 描述: 保存农专公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param curDate
	 * @param yrSfcBaseinfo
	 * @param sfcBaseInfo
	 * @param anCheID
	 * @throws Exception
	 */
	private void doSaveNewSfcPubInfo(String pripid, Integer year,String repType, Date curDate,YrSfcBaseinfo yrSfcBaseinfo,
			SfcBaseInfo sfcBaseInfo, String anCheID) throws Exception{
		SfcBaseInfo sfcBaseInfoNew = new SfcBaseInfo();
		YrSfcSocialSecurity yrSfcSocialSecurity = yrSfcSocialSecurityService.selectYrSfcSocialSecurityByAnCheID(anCheID, "0");
		//保存公示主表信息
		BeanUtil.getBeanUtilsBean().copyProperties(sfcBaseInfoNew, yrSfcBaseinfo);
		//2016年度开始填写社保信息
		if(year > 2015) {
			BeanUtil.getBeanUtilsBean().copyProperties(sfcBaseInfoNew, yrSfcSocialSecurity);
		}
		sfcBaseInfoNew.setId(null);
		//设置最近年报时间
		sfcBaseInfoNew.setLastReportTime(curDate);
		//处理特殊字符的转义 支持云平台
		if(StringUtil.isNotBlank(yrSfcBaseinfo.getEntMainBusActivity())){
			sfcBaseInfoNew.setEntMainBusActivity(yrSfcBaseinfo.getEntMainBusActivity().replace("'","\\\'"));
		}
		//首次提交，设置年报时间，否则取上次时间
		if(sfcBaseInfo != null){
			sfcBaseInfoNew.setAncheDate(sfcBaseInfo.getAncheDate());
		}else{
			sfcBaseInfoNew.setAncheDate(curDate);
		}
		sfcBaseInfoService.insert(sfcBaseInfoNew);
		
		List<YrSfcWebsiteInfo> yrSfcWebsiteInfoList = yrSfcWebsiteInfoService.selectSfcWebsiteListByanCheID(anCheID);
		for(YrSfcWebsiteInfo yrSfcWebsiteInfo : yrSfcWebsiteInfoList){
			SfcWebsiteInfo sfcWebsiteInfo = new SfcWebsiteInfo();
			BeanUtil.getBeanUtilsBean().copyProperties(sfcWebsiteInfo, yrSfcWebsiteInfo);
			sfcWebsiteInfo.setId(null);
			//处理特殊字符的转义 支持云平台
			sfcWebsiteInfo.setWebSitName(yrSfcWebsiteInfo.getWebSitName().replace("'","\\\'"));
			sfcWebsiteInfoService.insert(sfcWebsiteInfo);
		}
		List<YrSfcLicenceInfo> yrSfcLicenceInfoList = yrSfcLicenceInfoService.selectSfcLicenceListByAnCheID(anCheID);
		for(YrSfcLicenceInfo yrSfcLicenceInfo  : yrSfcLicenceInfoList){
			SfcLicenceInfo sfcLicenceInfo = new SfcLicenceInfo();
			BeanUtil.getBeanUtilsBean().copyProperties(sfcLicenceInfo, yrSfcLicenceInfo);
			sfcLicenceInfo.setId(null);
			sfcLicenceInfoService.insert(sfcLicenceInfo);
		}
		
		List<YrSfcBranchInfo> yrSfcBranchInfoList = yrSfcBranchInfoService.selectSfcBranchListByAnCheID(anCheID);
		for(YrSfcBranchInfo yrSfcBranchInfo  : yrSfcBranchInfoList){
			SfcBranchInfo sfcBranchInfo = new SfcBranchInfo();
			BeanUtil.getBeanUtilsBean().copyProperties(sfcBranchInfo, yrSfcBranchInfo);
			sfcBranchInfo.setId(null);
			//处理特殊字符的转义 支持云平台
			sfcBranchInfo.setBrName(yrSfcBranchInfo.getBrName().replace("'","\\\'"));
			sfcBranchInfoService.insert(sfcBranchInfo);
		}
	}
	
	/**
	 * 
	 * 描述: 农专敏感词过滤
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param pripid
	 * @param year
	 * @param repType
	 * @param sfcBaseInfoNow
	 * @param sfcWebsiteinfoNowList
	 * @param sfcLicenceinfoNowList
	 * @param sfcBranchInfoNowList
	 * @return
	 * @throws Exception
	 */
	private boolean doCommitForbidFilter(String pripid, Integer year,String repType, SfcBaseInfo sfcBaseInfoNow,List<SfcWebsiteInfo> sfcWebsiteinfoNowList,
			List<SfcLicenceInfo> sfcLicenceinfoNowList,List<SfcBranchInfo> sfcBranchInfoNowList) throws Exception {
		boolean forbidFlag = false;
		// 敏感词校验：基本情况
		String sfcBaseinfoRlt = doCheckForbidWord(sfcBaseInfoNow.getPubForbidInfo());
		if (!sfcBaseinfoRlt.equals("")) {
			forbidFlag = true;
			pubForbidResultService.insert(pripid, year, "cs_sfc_baseinfo", sfcBaseinfoRlt);
		}
		// 敏感词校验：网站
		for (SfcWebsiteInfo sfcWebsiteInfo : sfcWebsiteinfoNowList) {
			String sfcWebsiteinfoRlt = doCheckForbidWord(sfcWebsiteInfo.getPubForbidInfo());
			if (!sfcWebsiteinfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_sfc_websiteinfo", sfcWebsiteinfoRlt);
			}
		}
		// 敏感词校验：行政许可
		for (SfcLicenceInfo sfcLicenceInfo : sfcLicenceinfoNowList) {
			String sfcLicenceinfoRlt = doCheckForbidWord(sfcLicenceInfo.getPubForbidInfo());
			if (!sfcLicenceinfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_sfc_licenceinfo", sfcLicenceinfoRlt);
			}
		}
		// 敏感词校验：分支机构
		for (SfcBranchInfo sfcBranchInfo : sfcBranchInfoNowList) {
			String sfcBranchInfoRlt = doCheckForbidWord(sfcBranchInfo.getPubForbidInfo());
			if (!sfcBranchInfoRlt.equals("")) {
				forbidFlag = true;
				pubForbidResultService.insert(pripid, year, "cs_sfc_branchinfo", sfcBranchInfoRlt);
			}
		}
		return forbidFlag;
	}
	
	/**
	 * 
	 * 描述: 保存修改记录
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @param repType
	 * @param sfcBaseInfoNow
	 * @param sfcBaseInfo
	 * @param sfcWebsiteinfoNowList
	 * @param sfcWebsiteInfoOldList
	 * @param sfcLicenceinfoNowList
	 * @param sfcLicenceInfoOldList
	 * @param sfcBranchInfoNowList
	 * @param sfcBranchInfoOldList
	 * @throws Exception
	 */
	private void doCommitsfcUpdateInfo(String anCheID, String repType,
			SfcBaseInfo sfcBaseInfoNow, SfcBaseInfo sfcBaseInfo,
			List<SfcWebsiteInfo> sfcWebsiteinfoNowList,
			List<SfcWebsiteInfo> sfcWebsiteInfoOldList,
			List<SfcLicenceInfo> sfcLicenceinfoNowList,
			List<SfcLicenceInfo> sfcLicenceInfoOldList,
			List<SfcBranchInfo> sfcBranchInfoNowList,
			List<SfcBranchInfo> sfcBranchInfoOldList) throws Exception{
		//基本信息修改记录
		sfcUpdateinfoService.doCompareEntity(sfcBaseInfoNow,sfcBaseInfo, new String[] {"memNum", "farnum", "annNewMemNum", "annRedMemNum", "tel", "email",
				"vendIncIsPub", "maiBusIncIsPub","ratGroIsPub", "priYeaLoanIsPub", "priYeaSubIsPub"},anCheID);
		//网站修改记录
		sfcUpdateinfoService.doCompareList(sfcWebsiteinfoNowList, sfcWebsiteInfoOldList, new String[]{"webSite"}, new String[] { "webSitName", "webSite" ,"webType"},anCheID);
		//行政许可修改记录
		sfcUpdateinfoService.doCompareList(sfcLicenceinfoNowList, sfcLicenceInfoOldList, new String[]{"licID"}, new String[] { "licID", "licNameCN" ,"licName","valTo"},anCheID);
		//分支机构修改记录
		sfcUpdateinfoService.doCompareList(sfcBranchInfoNowList, sfcBranchInfoOldList, new String[]{"brId"}, new String[] { "brId", "brName" ,"uniCode"},anCheID);
		
	}
	
	
	
	
	/**
	 * 
	 * 描述: 个体户纸质补录
	 * @auther gaojinling
	 * @date 2017年3月9日 
	 * @param pripid
	 * @param year
	 * @param curDate
	 * @param sysUser
	 * @throws Exception
	 */
	public void doCommitPbaddRecInfo(String pripid, String year, Date curDate,SysUserDto sysUser) throws Exception {
		// 更新主表状态
		YrRegCheck yrRegCheck = new YrRegCheck();
		yrRegCheck.setPriPID(pripid);
		yrRegCheck.setYear(Integer.parseInt(year));
		yrRegCheck.setAddRecState("2"); //已补录
		yrRegCheck.setAddRecDate(new Date());
		yrRegCheck.setAddRecDept(sysUser.getDept());
		yrRegCheck.setAddRecUser(sysUser.getRealName());
		yrRegCheckService.updateYrRegCheckByPriPIdAndYear(yrRegCheck);
		
		//查询年报业务表基本信息、获取年报ID
		 YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year.toString(), pripid, "0");
		if(yrPbBaseInfo != null) {
			String anCheID = yrPbBaseInfo.getAnCheID();//获取年报ID
			
			//查询当前公示主表基本信息
			PbBaseinfo pbBaseinfo = pbBaseinfoService.selectPbBaseInfoByPriPIdAndYear(pripid, year.toString());
			
			//如果当前有公示数据，则先删除当前数据
			pbBaseinfoService.deleteByAnCheID(anCheID);
			pbWebsiteinfoService.deleteByAnCheID(anCheID);
			pbLicenceinfoService.deleteByAnCheID(anCheID);
			
			//保存公示信息
			doSaveNewPbPubInfo(pripid, Integer.parseInt(year), "50", curDate, yrPbBaseInfo, pbBaseinfo, anCheID);
		}else{
			throw new BusinessException("年报基本信息为空！");
		}
	}
}