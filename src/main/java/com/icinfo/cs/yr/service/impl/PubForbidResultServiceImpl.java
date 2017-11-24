/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.ReportStatusEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.mapper.BaseInfoMapper;
import com.icinfo.cs.yr.mapper.PbBaseinfoMapper;
import com.icinfo.cs.yr.mapper.PubForbidResultMapper;
import com.icinfo.cs.yr.mapper.SfcBaseInfoMapper;
import com.icinfo.cs.yr.mapper.YrRegCheckMapper;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.PubForbidResult;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IPubForbidResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_forbidresult 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
@Service
public class PubForbidResultServiceImpl extends MyBatisServiceSupport implements IPubForbidResultService {
	
	@Autowired
	private YrRegCheckMapper yrRegCheckMapper;
	
	@Autowired
	private BaseInfoMapper baseInfoMapper;
	
	@Autowired
	private PbBaseinfoMapper pbBaseinfoMapper;
	
	@Autowired
	private SfcBaseInfoMapper sfcBaseInfoMapper;
	
	@Autowired
	private PubForbidResultMapper pubForbidResultMapper; 
	
	@Autowired
	private IPanoramaSearchService panoramaSearchService; 
	
	/**
	 * 描述：敏感词审核
	 * @date 2016年9月12日 
	 * @author yujingwei
	 * @param yrRegCheck,sysUser,checkFlag,auditOpinion
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean doCommitForbidCheck(YrRegCheck yrRegCheck,SysUser sysUser,String auditState,String auditOpinion) throws Exception{
			if(yrRegCheck == null || StringUtils.isEmpty(auditState) || StringUtils.isEmpty(auditOpinion)){
				  return false;
			}
			if(auditState.equals("1")){
				yrRegCheck.setReportState(ReportStatusEnum.ReportStateForbidYes.getStatusCode());
			}else{
				yrRegCheck.setReportState(ReportStatusEnum.ReportStateForbidFail.getStatusCode());
			}
			//1.更新年报主表信息
			Example example = new Example(YrRegCheck.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, yrRegCheck.getPriPID())
			.andEqualTo(Constants.CS_YEAR,yrRegCheck.getYear());
			yrRegCheck.setIsForbidWord("1");//是否涉及过敏感词
			yrRegCheckMapper.updateByExampleSelective(yrRegCheck, example);
			//2.更新公示基本信息
			/*a.个体户信息*/
			if(yrRegCheck.getEntTypeCatg().equals(Constants.entTypeCatgPB)){
				PbBaseinfo pbBaseinfo = new PbBaseinfo();
				pbBaseinfo.setAuditState(auditState);
				pbBaseinfo.setAuditOpinion(auditOpinion);
				pbBaseinfo.setAuditUser(sysUser.getRealName());
				pbBaseinfo.setAuditDate(new Date());
				Example examplePb = new Example(PbBaseinfo.class);
				examplePb.createCriteria().andEqualTo(Constants.CS_PRIPID, yrRegCheck.getPriPID())
				.andEqualTo(Constants.CS_YEAR,yrRegCheck.getYear());
				pbBaseinfoMapper.updateByExampleSelective(pbBaseinfo, examplePb);
			/*b.农专信息*/
			}else if(Constants.entTypeCatgSFC.indexOf(yrRegCheck.getEntTypeCatg()) != -1){
				SfcBaseInfo sfcBaseInfo = new SfcBaseInfo();
				sfcBaseInfo.setAuditState(auditState);
				sfcBaseInfo.setAuditOpinion(auditOpinion);
				sfcBaseInfo.setAuditUser(sysUser.getRealName());
				sfcBaseInfo.setAuditDate(new Date());
				Example exampleSfc = new Example(SfcBaseInfo.class);
				exampleSfc.createCriteria().andEqualTo(Constants.CS_PRIPID, yrRegCheck.getPriPID())
				.andEqualTo(Constants.CS_YEAR,yrRegCheck.getYear());
				sfcBaseInfoMapper.updateByExampleSelective(sfcBaseInfo, exampleSfc);
			/*c.企业基本信息*/
			}else{
				BaseInfo baseInfo = new BaseInfo();
				baseInfo.setAuditState(auditState);
				baseInfo.setAuditOpinion(auditOpinion);
				baseInfo.setAuditUser(sysUser.getRealName());
				baseInfo.setAuditDate(new Date());
				Example exampleBase = new Example(BaseInfo.class);
				exampleBase.createCriteria().andEqualTo(Constants.CS_PRIPID, yrRegCheck.getPriPID())
				.andEqualTo(Constants.CS_YEAR,yrRegCheck.getYear());
				baseInfoMapper.updateByExampleSelective(baseInfo, exampleBase);
			}
			//更新年报主表索引
			Map<String, Object> jsondateMap  = new HashMap<String, Object>(); 
			jsondateMap.put("priPID", yrRegCheck.getPriPID());
			jsondateMap.put("yrSenCheck"+yrRegCheck.getYear(),"Y");
			jsondateMap.put("yrRepState"+yrRegCheck.getYear(), yrRegCheck.getReportState());
			panoramaSearchService.updatePanoramaIdx(jsondateMap);
		    return true;
	}
	

	/**
	 * 描述：获取敏感词信息(通过year 和 pripid查询)
	 * @date 2016年9月12日 
	 * @author yujingwei
	 * @param request
	 * @throws Exception
	 */
	@Override
	public List<PubForbidResult> queryPage(PageRequest request) throws Exception{
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=new Example(PubForbidResult.class);
			//年报ID
			if(searchMap!=null && searchMap.containsKey(Constants.CS_PRIPID) && searchMap.containsKey(Constants.CS_YEAR)){
				String priPID = (String) searchMap.get(Constants.CS_PRIPID);
				String year = (String) searchMap.get(Constants.CS_YEAR);
				example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID)
				.andEqualTo(Constants.CS_YEAR, year).andIsNull("reportNo");
				List<PubForbidResult>  pubForbidResultList= pubForbidResultMapper.selectByExample(example);
				return pubForbidResultList;
			} 
			return new ArrayList<PubForbidResult>();
	}

	/** 
	 * 描述: 保存敏感词结果
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @param priPID
	 * @param year
	 * @param tableName
	 * @param forbidRlt
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(String priPID, Integer year, String tableName,
			String forbidRlt) throws Exception {
		PubForbidResult pubForbidResult = new PubForbidResult();
		pubForbidResult.setPriPID(priPID);
		pubForbidResult.setYear(year);
		pubForbidResult.setForbidTable(tableName);
		pubForbidResult.setForbidContent(forbidRlt);
		pubForbidResult.setCreateTime(new Date());
		pubForbidResult.setForbidDate(new Date());
		return pubForbidResultMapper.insert(pubForbidResult);
	}

	/** 
	 * 描述: 更新历史信息年报编号
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param anCheID
	 * @param reportNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int updateHis(String pripid, Integer year, String reportNo) throws Exception {
		PubForbidResult pubForbidResult = new PubForbidResult();
		pubForbidResult.setReportNo(reportNo);
		pubForbidResult.setCreateTime(DateUtil.getSysDate());//时间戳
		Example example = new Example(PubForbidResult.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, pripid).andEqualTo(Constants.CS_YEAR, year).andIsNull("reportNo");
		return pubForbidResultMapper.updateByExampleSelective(pubForbidResult,example);
	}
	
}
