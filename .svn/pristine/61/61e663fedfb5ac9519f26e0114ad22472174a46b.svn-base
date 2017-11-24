/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.SimplecanRea;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RestFulClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.simpleesc.dto.ErEscAppinfoDto;
import com.icinfo.cs.simpleesc.mapper.ErEscAppinfoMapper;
import com.icinfo.cs.simpleesc.model.ErEscAppinfo;
import com.icinfo.cs.simpleesc.service.IErEscAppinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    er_esc_appinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Service
public class ErEscAppinfoServiceImpl extends MyBatisServiceSupport implements IErEscAppinfoService {

	@Autowired
	ErEscAppinfoMapper erEscAppinfoMapper;
	
	@Autowired
	IEntSearchService entSearchService;
	
	@Value("${cloudModel}")
	private String cloudModel;
	
	@Autowired
	RestFulClient sclient;
	
    // 保存
	public final static String simpleApplyIsSave = "01";  
	// 保存并公示
	public final static String simpleApplyIsPub = "02";
	// 选择交换接口
	public final static String webServiceExChangeMethod01 = "editAppinfo";
	
	
	
	@Override
	public ErEscAppinfoDto getErEscAppinfoByPriPID(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		return erEscAppinfoMapper.queryResultByPriPID(queryMap);
	}
	
	/**
	 * 描述：保存简易注销申请信息
	 * @author yujingwei
	 * @date 2017-02-13
	 * @param erEscAppinfo
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doSaveErEscAppinfo(ErEscAppinfo erEscAppinfo,String saveType) throws Exception{
		if(erEscAppinfo == null || saveType == null) return false;
		if(saveType.equals(simpleApplyIsPub)){
			// 公告申请日期
			erEscAppinfo.setAppDate(new Date());
			// 公告期自
			erEscAppinfo.setNoticeFrom(new Date());
			// 公告期至
			erEscAppinfo.setNoticeTo(DateUtil.getNdaylaterDate(new Date(), 45));
			//内网申请截止日期
			erEscAppinfo.setEndDate(DateUtil.getNdaylaterDate(new Date(), 75));
			// 简易注销结果状态
			erEscAppinfo.setSimplecanRea(SimplecanRea.SimplecanApplyIng.getCode());
		}
		if(erEscAppinfo.getId() != null){
			if(erEscAppinfoMapper.updateByPrimaryKeySelective(erEscAppinfo) < 0){
				return false;
			}
		}else if(erEscAppinfoMapper.insert(erEscAppinfo) < 0){
			return false;
		}
		if(saveType.equals(simpleApplyIsPub)){
			// 数据交换
			if ("Y".equals(cloudModel)) {
				String resultStr = erEscAppWebServiceClient(erEscAppinfo,webServiceExChangeMethod01,"01");
				if(resultStr== null || resultStr.indexOf("sucess") == -1){
					 throw new Exception("数据交换异常，请稍后重试!");
				}
			}
			// 更新索引
			updateIndex(erEscAppinfo.getPriPID(), 1);
		}
		return true;
	}
	
	/**
	 * 描述：撤销简易注销信息
	 * @author yujingwei
	 * @date 2017-02-15
	 * @param priPID
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doCancelErEscAppinfo(String priPID) throws Exception{
		Example example = new Example(ErEscAppinfo.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID);
		ErEscAppinfo erEscAppinfo = new ErEscAppinfo();
		erEscAppinfo.setSimplecanRea(SimplecanRea.SimplecanCanceled.getCode());
		erEscAppinfo.setCancelDate(new Date());
		erEscAppinfo.setPriPID(priPID);
		if(erEscAppinfoMapper.updateByExampleSelective(erEscAppinfo, example) < 0){
			return false;
		}
		// 数据交换
		if ("Y".equals(cloudModel)) {
		   String resultStr = erEscAppWebServiceClient(erEscAppinfo,webServiceExChangeMethod01,"02");
		   if(resultStr== null || resultStr.indexOf("sucess") == -1){
			   throw new Exception("数据交换异常，请稍后重试!");
		   }
		}
		// 更新索引
	    updateIndex(erEscAppinfo.getPriPID(), 0);
		return true;
	}
	
	/**
	 * 描述：更新索引
	 * @date 2017-02-15
	 * @param priPID,updateMethod
	 */
	private void updateIndex(String priPID , int updateMethod) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("priPID", priPID);
		jsonMap.put("isSimpleCancle", updateMethod);
		entSearchService.updatePubIndex(jsonMap);
	}
	
	/**
	 * 描述：简易注销webService接口
	 * @author yujingwei
	 * @date 2017-02-15
	 * @param erEscAppinfo
	 * @return 
	 */
	private String erEscAppWebServiceClient(ErEscAppinfo erEscAppinfo,String method,String type) {
		try {
			// 生成参数
			String parameterForSend = doGetEscAppInfoForParameter(erEscAppinfo,method,type);
			
			System.out.println(parameterForSend);
			// 调用远程服务
			String result =sclient.callRemoteService(parameterForSend);
			// 输出结果
			System.out.println(result); 
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 描述：生成webservice接口参数
	 * @author yujingwei
	 * @date 2017-02-15
	 * @param erEscAppinfo,method
	 * @return String
	 * @throws UnsupportedEncodingException 
	 */
	private String doGetEscAppInfoForParameter(ErEscAppinfo erEscAppinfo,String method,String type) throws UnsupportedEncodingException{
		if(type.equalsIgnoreCase("01")){
			return  "method="+method
					+"&PRIPID="+erEscAppinfo.getPriPID()
					+"&ENTNAME="+exchangeToGBK(erEscAppinfo.getEntName())
		            +"&UNISCID="+erEscAppinfo.getUniSCID()
		            +"&REGNO="+erEscAppinfo.getRegNO()
		            +"&REGORG="+erEscAppinfo.getRegOrg()
		            +"&LOCALADM="+erEscAppinfo.getLocalAdm()
		            +"&APPDATE="+getFormatDate(erEscAppinfo.getAppDate())
		            +"&NOTICEFROM="+getFormatDate(erEscAppinfo.getNoticeFrom())
		            +"&NOTICETO="+getFormatDate(erEscAppinfo.getNoticeTo())
		            +"&ENDDATE="+getFormatDate(erEscAppinfo.getEndDate())
		            +"&COMMITMENT="+exchangeToGBK(erEscAppinfo.getCommitment())
		            +"&SIMPLECANREA="+erEscAppinfo.getSimplecanRea();
		}else{
			return "method="+method
				   +"&PRIPID="+erEscAppinfo.getPriPID()
				   +"&CANCELDATE="+getFormatDate(erEscAppinfo.getCancelDate())
				   +"&SIMPLECANREA="+erEscAppinfo.getSimplecanRea();
		}
	}

	/**
	 * 描述：根据内部序号查询简易注销公告(查询所有字段)
	 * @author yujingwei
	 * @date 2017-02-14
	 * @param priPID
	 * @return ErEscAppinfo
	 */
	public ErEscAppinfo doGetErEscAppinfoByPriPID(String priPID) throws Exception{
		ErEscAppinfo erEscAppinfo = new ErEscAppinfo();
		erEscAppinfo.setPriPID(priPID);
		return erEscAppinfoMapper.selectOne(erEscAppinfo);
	}

	/**
	 * 描述：时间处理
	 * @date 2017-02-14
	 */
	public String getFormatDate(Date date){
		if(date == null){
			return null;
		}
		return DateUtil.formatDateNew(date);
	}
	
	/**
	 * 描述：编码转GBK
	 * @throws UnsupportedEncodingException 
	 * @date 2017-02-14
	 */
	public String exchangeToGBK(String objStr) throws UnsupportedEncodingException{
		if(objStr == null){
			return null;
		}
		return java.net.URLEncoder.encode(objStr, "GBK");
	}

	/**
	 * 
	 * 描述   分页查询简易注销公告
	 * @author  赵祥江
	 * @date 2017年2月21日 下午5:05:15 
	 * @param  
	 * @throws
	 */
	@Override
	public List<ErEscAppinfoDto> queryErEscAppinfoPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return erEscAppinfoMapper.selectErEscAppinfoPageResult(request.getParams());
	}
	
	/**
	 * 描述：通过企业名称查找简易注销信息
	 * @author yujingwei
	 * @date 2017年4月18日 
	 * @param entName
	 * @return ErEscAppinfo
	 * @throws Exception
	 */
	public ErEscAppinfo doGetErEscAppinfoByEntName(String entName) throws Exception{
		if(StringUtil.isBlank(entName)){
			return null;
		}
		ErEscAppinfo erEscAppinfo = new ErEscAppinfo();
		erEscAppinfo.setEntName(entName);
		return erEscAppinfoMapper.selectOne(erEscAppinfo);
	}
	
	/**
	 * 描述: 单家企业交换至准入（维护用）
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@Override
	public boolean doSendErEscAppinfo(String priPID) throws Exception{
		ErEscAppinfo erEscAppinfo = doGetErEscAppinfoByPriPID(priPID);
		if ("Y".equals(cloudModel)) {
			   String resultStr = erEscAppWebServiceClient(erEscAppinfo,webServiceExChangeMethod01,"01");
			   if(resultStr== null || resultStr.indexOf("sucess") == -1){
				   throw new Exception("数据交换异常!");
			   }
			}
		return true;
	}
    
	/**
	 * 描述: 保存简易注销申请信息（维护用）
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @return ajax
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean doMaintainSimpleesc(ErEscAppinfo erEscAppinfo,String saveType) throws Exception{
		if(erEscAppinfo == null || saveType == null  || erEscAppinfo.getEntName() == null) 
			 return false;
		// 通过企业名称匹配
		ErEscAppinfo erEscAppinfoDB = doGetErEscAppinfoByEntName(erEscAppinfo.getEntName());
		if(erEscAppinfoDB == null){
			 throw new Exception("未找到该企业名称，请确认输入是否正确。如有疑问请联系管理员!");
		}
		if("5".equals(erEscAppinfoDB.getSimplecanRea())){
			throw new Exception("该企业已撤销简易注销公告，不能再次上传。如有疑问请联系管理员!");
		}
		// 更新承诺书上传地址
		Example example = new Example(ErEscAppinfo.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, erEscAppinfoDB.getPriPID());
		if(erEscAppinfoMapper.updateByExampleSelective(erEscAppinfo, example) < 0){
			return false;
		}
		// 数据交换
		if ("Y".equals(cloudModel)) {
			erEscAppinfoDB.setCommitment(erEscAppinfo.getCommitment());
			String resultStr = erEscAppWebServiceClient(erEscAppinfoDB,webServiceExChangeMethod01,"01");
			if(resultStr== null || resultStr.indexOf("sucess") == -1){
				 throw new Exception("数据交换异常，请稍后重试。如有疑问请联系管理员!");
			}
		}
		return true;
	}
	
}