/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.BeanUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RestFulClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.other.dto.PubJusticeInfoDto;
import com.icinfo.cs.other.mapper.PubJusticeInfoHisMapper;
import com.icinfo.cs.other.mapper.PubJusticeInfoMapper;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.other.model.PubJusticeInfoHis;
import com.icinfo.cs.other.service.IPubJusticeInfoService;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.mapper.PubServerHisModMapper;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_justiceinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Service
public class PubJusticeInfoServiceImpl extends MyBatisServiceSupport implements IPubJusticeInfoService {

	@Autowired
	PubJusticeInfoMapper pubJusticeInfoMapper;

	@Autowired
	PubServerHisModMapper pubServerHisModMapper;

	@Autowired
	PubJusticeInfoHisMapper pubJusticeInfoHisMapper;
	
	@Autowired
	private ICodeCurrencyService codeCurrencyService;
	
	@Autowired
	private MidBaseInfoMapper midBaseInfoMapper;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService; 
	
	@Value("${cloudModel}")
	private String cloudModel;
	
	@Autowired
	RestFulClient sclient;
	
	// 股权冻结，续冻，轮候接口类型
	private final static String  FROZEN_METHOD = "editEquityFreeze";
	// 股权解冻接口
	private final static String  REMOVE_FROZEN_METHOD = "editEquityUnFreeze";  
	// 股权冻结失效接口
	private final static String  NoEffect_METHOD = "editEquityOuttime";  
	// 强制股权变更接口
	private final static String CHANGE_FROZEN_METHOD = "EditEquityChange";
	

	/**
	 * 描述：获取司法协助信息录入列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return List<PubJusticeInfo>
	 * @throws Exception
	 */
	public List<PubJusticeInfo> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubJusticeInfoMapper.selectPubJusticeInfoForApply(request.getParams());
	}

	/**
	 * 描述：查询司法协助信息（被执行人选择页面）
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pubJusticeInfo
	 * @param request
	 * @return List<PubJusticeInfo>
	 * @throws Exception
	 */
	public List<PubJusticeInfo> queryPageForInclude(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubJusticeInfoMapper.selectPubJusticeInfoForInclude(request.getParams());
	}

	/**
	 * 描述：获取司法协助信息查询数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return boolean
	 * @throws Exception
	 */
	public List<PubJusticeInfoDto> queryPageForSearch(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<PubJusticeInfoDto> pubJusticeInfoDtoList = pubJusticeInfoMapper
				.selectPubJusticeInfoForSearch(request.getParams());
		int totalAll = pubJusticeInfoMapper.selectTotalAllForSearch(request.getParams());
		int AmountAll = pubJusticeInfoMapper.selectTotalAmountForSearch(request.getParams());
		int totalOne = pubJusticeInfoMapper.selectTotalOneForSearch(request.getParams());
		int totalTwo = pubJusticeInfoMapper.selectTotalTwoForSearch(request.getParams());
		if (CollectionUtils.isNotEmpty(pubJusticeInfoDtoList)) {
			for (PubJusticeInfoDto PubJusticeInfoDto : pubJusticeInfoDtoList) {
				PubJusticeInfoDto.setOneCount(totalOne);// 股权冻结信息条数
				PubJusticeInfoDto.setTwoCount(totalTwo);// 股东强制变更信息条数
				PubJusticeInfoDto.setTotal(totalAll);// 公示企业家数
				PubJusticeInfoDto.setAmount(AmountAll);// 公示企业条数
			}
		}
		return pubJusticeInfoDtoList;
	}

	/**
	 * 描述：通过priPID，UID查询司法协助信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pripid,uID
	 * @return PubJusticeInfo
	 * @throws Exception
	 */
	public PubJusticeInfo doGetPubJusticeInfo(String pripid, String UID) throws Exception {
		PubJusticeInfo pubJusticeInfo = new PubJusticeInfo();
		pubJusticeInfo.setPriPID(pripid);
		pubJusticeInfo.setUID(UID);
		return pubJusticeInfoMapper.selectOne(pubJusticeInfo);
	}

	/**
	 * 描述：通过pripid 和 justiceType 查询司法信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pripid
	 * @param justiceType
	 * @return List<PubJusticeInfo>
	 * @throws Exception
	 */
	public List<PubJusticeInfo> doGetPubJusticeInList(String pripid, String justiceType) throws Exception {
		Example example = new Example(PubJusticeInfo.class);
		example.createCriteria()
		.andEqualTo(Constants.CS_PRIPID, pripid)
		.andEqualTo("justiceType", justiceType)
		.andEqualTo("auditState", "1");
		return pubJusticeInfoMapper.selectByExample(example);
	}

	/**
	 * 描述：通过priPID，UID删除司法协助信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pripid,uID
	 * @return PubJusticeInfo
	 * @throws Exception
	 */
	public boolean deletePubJusticeInfo(String priPID, String UID) throws Exception {
		Example example = new Example(PubJusticeInfo.class);
		example.createCriteria().andEqualTo("priPID", priPID).andEqualTo("UID", UID);
		if (pubJusticeInfoMapper.deleteByExample(example) < 0) {
			return false;
		}
		return true;
	}

	/**
	 * 描述：司法协助提交审核
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pubJusticeInfo
	 * @param sysUser
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doCommitJusticeInfo(PubJusticeInfo pubJusticeInfo, SysUser sysUser) throws Exception {
		if(pubJusticeInfo == null || sysUser == null){
			return false;
		}
		pubJusticeInfo.setAuditDate(new Date());
		pubJusticeInfo.setAuditName(sysUser.getRealName());
		Example example = new Example(PubJusticeInfo.class);
		example.createCriteria()
		.andEqualTo(Constants.CS_PRIPID, pubJusticeInfo.getPriPID())
		.andEqualTo("UID",pubJusticeInfo.getUID());
		pubJusticeInfoMapper.updateByExampleSelective(pubJusticeInfo, example);
		PubJusticeInfo pubJusticeInfoTemp = this.doGetPubJusticeInfo(pubJusticeInfo.getPriPID(),
				pubJusticeInfo.getUID());
		if(pubJusticeInfoTemp == null){
			return false;
		}
		// 保存修改记录表
		PubServerHisMod pubServerHisMod = new PubServerHisMod();
		pubServerHisMod.setAltDate(pubJusticeInfoTemp.getSetDate());
		pubServerHisMod.setAltName(pubJusticeInfoTemp.getSetName());
		pubServerHisMod.setAltTable("cs_pub_justiceinfo");
		pubServerHisMod.setAuditDate(pubJusticeInfoTemp.getAuditDate());
		pubServerHisMod.setAuditName(pubJusticeInfoTemp.getAuditName());
		pubServerHisMod.setAuditState(pubJusticeInfoTemp.getAuditState());
		pubServerHisMod.setHisNO(StringUtil.getRandomNumber(pubJusticeInfoTemp.getPriPID()));
		pubServerHisMod.setModUID(pubJusticeInfoTemp.getUID());
		pubServerHisMod.setPriPID(pubJusticeInfoTemp.getPriPID());
		pubServerHisModMapper.insert(pubServerHisMod);
		// 保存历史记录
		PubJusticeInfoHis pubJusticeInfoHis = new PubJusticeInfoHis();
		pubJusticeInfoTemp.setId(null);
		BeanUtil.getBeanUtilsBean().copyProperties(pubJusticeInfoHis, pubJusticeInfoTemp);
		pubJusticeInfoHis.setHisNO(pubServerHisMod.getHisNO());
		pubJusticeInfoHisMapper.insert(pubJusticeInfoHis);
		// 调用数据交换接口(只有审核通过时才进行数据交换，若交换失败事务回滚)
		if ("Y".equals(cloudModel) && !"2".equals(pubJusticeInfoTemp.getAuditState())){
			// 冻结期限处理
			int frozDeadline = DateUtil.getBetweenDays(
					DateUtil.dateToString(pubJusticeInfoTemp.getFroFrom(), "yyyy-MM-dd"), 
					DateUtil.dateToString(pubJusticeInfoTemp.getFroTo(), "yyyy-MM-dd"));
			pubJusticeInfoTemp.setFrozDeadline(String.valueOf(frozDeadline));
			// 注册号，统一代码赋值
			MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(pubJusticeInfoTemp.getPriPID());
			if(baseInfo != null){
				pubJusticeInfoTemp.setUniSCID(baseInfo.getUniCode());
				pubJusticeInfoTemp.setRegNO(baseInfo.getRegNO());
			}
			// 解冻续冻情况赋值JDID
			if("2".equals(pubJusticeInfoTemp.getExecuteItem()) 
					|| "3".equals(pubJusticeInfoTemp.getExecuteItem())){
				PubJusticeInfo frozenInfo = doGetPubJusticeInfoForPub(pubJusticeInfoTemp.getJusticeConNO());
				if(frozenInfo != null){
					pubJusticeInfoTemp.setJdid(frozenInfo.getDjid());
					doUpdateFrozenID(frozenInfo.getDjid(),2,pubJusticeInfoTemp);
				}
			}
			// 调用接口
			String resultStr = frozenWebServiceClient(pubJusticeInfoTemp);
			if(resultStr== null || resultStr.indexOf("sucess") == -1){
				 throw new Exception("数据交换异常，请稍后重试!");
			}else if(resultStr != null){
				JSONObject jsonObj = JSONObject.fromObject(resultStr);
				// 冻结情况将返回的冻结ID赋值
				if(jsonObj.containsKey("djid") && jsonObj !=null 
						&& "1".equals(pubJusticeInfoTemp.getExecuteItem())){
					String frozenID = jsonObj.get("djid").toString();
					if(doUpdateFrozenID(Integer.valueOf(frozenID),1,pubJusticeInfoTemp) < 1){
						 throw new Exception("数据交换异常，请稍后重试!");
					}
				}
			}
		}
		return true;
	}
    
	
	/**
	 * 描述：司法协助调用接口
	 * @author yujingwei
	 * @date 2017-02-15
	 * @param pubJusticeInfoTemp
	 * @return String
	 */
	private String frozenWebServiceClient(PubJusticeInfo pubJusticeInfoTemp) {
		try {
			String parameterForSend = "";
			// 股权冻结，轮候接口
			if("1".equals(pubJusticeInfoTemp.getExecuteItem())){
				parameterForSend = doGetFrozenInfoForParameter(pubJusticeInfoTemp,FROZEN_METHOD,"01");
		    // 续冻
			}else if("2".equals(pubJusticeInfoTemp.getExecuteItem())){
				parameterForSend = doGetFrozenInfoForParameter(pubJusticeInfoTemp,FROZEN_METHOD,"02");
		    // 解冻
			}else if("3".equals(pubJusticeInfoTemp.getExecuteItem())){
				parameterForSend = doGetFrozenInfoForParameter(pubJusticeInfoTemp,REMOVE_FROZEN_METHOD,"03");
			// 股权强制变更
			}else if("4".equals(pubJusticeInfoTemp.getExecuteItem())){
				parameterForSend = doGetFrozenInfoForParameter(pubJusticeInfoTemp,CHANGE_FROZEN_METHOD,"04");
			}
			System.out.println(parameterForSend);
			// 调用远程服务
			String result =sclient.callRemoteForEquityFreezeService(parameterForSend);
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
	 * @param pubJusticeInfoTemp,frozenMethod,type
	 * @return String
	 * @throws UnsupportedEncodingException 
	 */
	private String doGetFrozenInfoForParameter(PubJusticeInfo pubJusticeInfoTemp, String frozenMethod,String type) throws UnsupportedEncodingException {
		String paramUniSCID = "";
		if(StringUtil.isNotEmpty(pubJusticeInfoTemp.getUniSCID())){
			paramUniSCID = "&UNISCID="+pubJusticeInfoTemp.getUniSCID();
		}
		if("01".equals(type)){
			return "method="+frozenMethod
					+"&PRIPID="+pubJusticeInfoTemp.getPriPID()
					+"&CORENTNAME="+exchangeToGBK(pubJusticeInfoTemp.getEntName())
		            +"&REGNO="+pubJusticeInfoTemp.getRegNO()
		            +"&INV="+exchangeToGBK(pubJusticeInfoTemp.getInv())
		            +"&CERTYPE="+pubJusticeInfoTemp.getCerType()
		            +"&CERNO="+pubJusticeInfoTemp.getCerNO()
		            +"&FROAM="+pubJusticeInfoTemp.getFroAm()
		            +"&REGCAPCUR="+pubJusticeInfoTemp.getRegCapCur()
		            +"&SHARFROPROP="+pubJusticeInfoTemp.getFrozenProp()
		            +"&FROZSIGN="+pubJusticeInfoTemp.getFrozSign()
		            +"&FROZDEADLINE="+pubJusticeInfoTemp.getFrozDeadline()
		            +"&FROZSTATE=1"
		            +"&FROFROM="+DateUtil.formatDateNew(pubJusticeInfoTemp.getFroFrom())
		            +"&FROTO="+DateUtil.formatDateNew(pubJusticeInfoTemp.getFroTo())
		            +"&EXECUTEITEM=1"
		            +"&EXECUTENO="+exchangeToGBK(pubJusticeInfoTemp.getExecuteNo())
				    +"&FROAUTH="+exchangeToGBK(pubJusticeInfoTemp.getExecutionCourt())
			        +"&FRODOCNO="+exchangeToGBK(pubJusticeInfoTemp.getExeRulNum())
			        +"&FYJBR="+exchangeToGBK(pubJusticeInfoTemp.getOperatorName())
			        +"&FYJBRDH="+pubJusticeInfoTemp.getOperatorTel()
			        +"&PUBLICDATE="+DateUtil.formatDateNew(pubJusticeInfoTemp.getPublicDate())
			        + paramUniSCID;
		}else if("02".equals(type)){
			return "method="+frozenMethod
					+"&PRIPID="+pubJusticeInfoTemp.getPriPID()
					+"&DJID="+pubJusticeInfoTemp.getJdid()
					+"&CORENTNAME="+exchangeToGBK(pubJusticeInfoTemp.getEntName())
		            +"&REGNO="+pubJusticeInfoTemp.getRegNO()
		            +"&INV="+exchangeToGBK(pubJusticeInfoTemp.getInv())
		            +"&CERTYPE="+pubJusticeInfoTemp.getCerType()
		            +"&CERNO="+pubJusticeInfoTemp.getCerNO()
		            +"&FROAM="+pubJusticeInfoTemp.getFroAm()
		            +"&REGCAPCUR="+pubJusticeInfoTemp.getRegCapCur()
		            +"&SHARFROPROP="+pubJusticeInfoTemp.getFrozenProp()
		            +"&FROZSIGN="+pubJusticeInfoTemp.getFrozSign()
		            +"&FROZDEADLINE="+pubJusticeInfoTemp.getFrozDeadline()
		            +"&FROZSTATE=1"
		            +"&FROFROM="+DateUtil.formatDateNew(pubJusticeInfoTemp.getFroFrom())
		            +"&FROTO="+DateUtil.formatDateNew(pubJusticeInfoTemp.getFroTo())
		            +"&EXECUTEITEM=2"
		            +"&EXECUTENO="+exchangeToGBK(pubJusticeInfoTemp.getExecuteNo())
				    +"&FROAUTH="+exchangeToGBK(pubJusticeInfoTemp.getExecutionCourt())
			        +"&FRODOCNO="+exchangeToGBK(pubJusticeInfoTemp.getExeRulNum())
			        +"&FYJBR="+exchangeToGBK(pubJusticeInfoTemp.getOperatorName())
			        +"&FYJBRDH="+pubJusticeInfoTemp.getOperatorTel()
			        +"&PUBLICDATE="+DateUtil.formatDateNew(pubJusticeInfoTemp.getPublicDate())
			        + paramUniSCID;
		}else if("03".equals(type)){
			return "method="+frozenMethod
					+"&PRIPID="+pubJusticeInfoTemp.getPriPID()
					+"&JDID="+pubJusticeInfoTemp.getJdid()
					+"&CORENTNAME="+exchangeToGBK(pubJusticeInfoTemp.getEntName())
		            +"&REGNO="+pubJusticeInfoTemp.getRegNO()
		            +"&INV="+exchangeToGBK(pubJusticeInfoTemp.getInv())
		            +"&CERTYPE="+pubJusticeInfoTemp.getCerType()
		            +"&CERNO="+pubJusticeInfoTemp.getCerNO()
		            +"&FROAM="+pubJusticeInfoTemp.getFroAm()
		            +"&REGCAPCUR="+pubJusticeInfoTemp.getRegCapCur()
		            +"&FROZSIGN="+pubJusticeInfoTemp.getFrozSign()
		            +"&FROZSTATE=2"
		            +"&EXECUTEITEM=3"
		            +"&EXECUTENO="+exchangeToGBK(pubJusticeInfoTemp.getExecuteNo())
				    +"&FROAUTH="+exchangeToGBK(pubJusticeInfoTemp.getExecutionCourt())
			        +"&FRODOCNO="+exchangeToGBK(pubJusticeInfoTemp.getExeRulNum())
			        +"&FYJBR="+exchangeToGBK(pubJusticeInfoTemp.getOperatorName())
			        +"&FYJBRDH="+pubJusticeInfoTemp.getOperatorTel()
			        +"&THAWDATE="+DateUtil.formatDateNew(pubJusticeInfoTemp.getThawDate())
			        +"&PUBLICDATE="+DateUtil.formatDateNew(pubJusticeInfoTemp.getPublicDate())
			        +"&THAWCOMMENT="+exchangeToGBK(pubJusticeInfoTemp.getThawComment())
			        + paramUniSCID;
		}else if("04".equals(type)){
			return "method="+frozenMethod
					+"&PRIPID="+pubJusticeInfoTemp.getPriPID()
					+"&CORENTNAME="+exchangeToGBK(pubJusticeInfoTemp.getEntName())
					+"&FROAUTH="+exchangeToGBK(pubJusticeInfoTemp.getExecutionCourt())
			        +"&FRODOCNO="+exchangeToGBK(pubJusticeInfoTemp.getExeRulNum())
			        +"&EXECUTENO="+exchangeToGBK(pubJusticeInfoTemp.getExecuteNo())
		            +"&INV="+exchangeToGBK(pubJusticeInfoTemp.getInv())
		            +"&CERTYPE="+pubJusticeInfoTemp.getCerType()
		            +"&CERNO="+pubJusticeInfoTemp.getCerNO()
		            +"&FROAM="+pubJusticeInfoTemp.getFroAm()
		            +"&REGCAPCUR="+pubJusticeInfoTemp.getRegCapCur()
		            +"&ALIEN_S="+exchangeToGBK(pubJusticeInfoTemp.getAssInv())
		            +"&CERTYPE_S="+pubJusticeInfoTemp.getAssCerType()
		            +"&CERNO_S="+pubJusticeInfoTemp.getAssCerNO()
		            + paramUniSCID;
		}
		return null;
	}
	
	/**
	 * 描述：更新冻结解冻ID
	 * @date 2017-07-14
	 * @param frozenID,updateType
	 * @return int 
	 */
	private int doUpdateFrozenID(Integer frozenID,int updateType,PubJusticeInfo pubJusticeInfo){
		if(frozenID == null){
			return 0;
		}
		PubJusticeInfo info = new PubJusticeInfo();
		if(updateType == 1){
			info.setDjid(frozenID);
		}else if(updateType == 2){
			info.setJdid(frozenID);
		}
		Example upExample = new Example(PubJusticeInfo.class);
		upExample.createCriteria()
		.andEqualTo(Constants.CS_PRIPID, pubJusticeInfo.getPriPID())
		.andEqualTo("UID",pubJusticeInfo.getUID());
		return pubJusticeInfoMapper.updateByExampleSelective(info, upExample);
	}
	
	/**
	 * 描述：编码转GBK
	 * @throws UnsupportedEncodingException 
	 * @date 2017-02-14
	 */
	private String exchangeToGBK(String objStr) throws UnsupportedEncodingException {
		if(objStr == null){
			return null;
		}
		return java.net.URLEncoder.encode(objStr, "GBK");
	}

	/**
	 * 描述：新增或修改司法协助信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pubJusticeInfo
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doAddAndEditJusticeInfo(PubJusticeInfoDto pubJusticeInfoDto, SysUser sysUser) throws Exception {
		PubJusticeInfo pubJusticeInfo = new PubJusticeInfo();
		BeanUtil.getBeanUtilsBean().copyProperties(pubJusticeInfo, pubJusticeInfoDto);
		doOptFrozenAuditInfo(pubJusticeInfo,sysUser);
		if(StringUtil.isBlank(pubJusticeInfo.getUID())){
			pubJusticeInfo.setAuditState("0");
			// 解冻或续冻时保存上条冻结记录的唯一标识
			if(pubJusticeInfo.getExecuteItem().equals("2") || pubJusticeInfo.getExecuteItem().equals("3")){
				pubJusticeInfo.setJusticeConNO(pubJusticeInfoDto.getUpJusticeNO());
			}
			if(pubJusticeInfoMapper.insert(pubJusticeInfo) < 0){
				return false;
			}
		}else{
			if(pubJusticeInfo.getExecuteItem().equals("2") || pubJusticeInfo.getExecuteItem().equals("3")){
				if (StringUtil.isNotBlank(pubJusticeInfoDto.getUpJusticeNO())) {
					pubJusticeInfo.setJusticeConNO(pubJusticeInfoDto.getUpJusticeNO());
				}
			}
			Example example = new Example(PubJusticeInfo.class);
			example.createCriteria()
			.andEqualTo(Constants.CS_PRIPID, pubJusticeInfo.getPriPID())
			.andEqualTo("UID",pubJusticeInfo.getUID());
			if(pubJusticeInfoMapper.updateByExample(pubJusticeInfo, example) < 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 描述：审核信息处理
	 * @data 2016-10-17
	 * @param pubJusticeInfo，sysUser
	 */
	private void doOptFrozenAuditInfo(PubJusticeInfo pubJusticeInfo,SysUser sysUser){
		// 设置录入时间，录入人，时间戳
		pubJusticeInfo.setSetDate(new Date());
		pubJusticeInfo.setCreateTime(new Date());
		pubJusticeInfo.setSetName(sysUser.getRealName());
		pubJusticeInfo.setDeptCode(sysUser.getDeptCode());
		// 币种设置
		if(StringUtil.isNotBlank(pubJusticeInfo.getRegCapCur())){
			CodeCurrency codeCurrency = codeCurrencyService.selectCodeCurrencyByCode(pubJusticeInfo.getRegCapCur());
			if(codeCurrency !=null){
				pubJusticeInfo.setFroAuth("万"+codeCurrency.getContent());
			}
		}
		// 数据来源
		pubJusticeInfo.setDataFrom("1");
		if(StringUtil.isNotBlank(pubJusticeInfo.getUID()) && pubJusticeInfo.getAuditState().equals("2")){
			pubJusticeInfo.setAuditState("0");
			pubJusticeInfo.setAuditDate(null);
			pubJusticeInfo.setAuditOpin(null);
			pubJusticeInfo.setAuditName(null);
		}
	}
	
	/**
	 * 描述: 获取司法协助信息录入列表数据（公示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月26日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubJusticeInfo> queryPageForPub(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		String priPID = request.getParams().get("priPID").toString();
		if (StringUtils.isNotBlank(priPID)) {
			Example example = new Example(PubJusticeInfo.class);
			example.createCriteria().andEqualTo("auditState", "1").andEqualTo(Constants.CS_PRIPID, priPID);
			return pubJusticeInfoMapper.selectByExample(example);
		} else {
			return new ArrayList<PubJusticeInfo>();
		}
	}
	
	/**
     * 描述：判断某一个企业股权是否是冻结状态
     * 
     * @author yujingwei
     * @data 2016-10-17
     * @param  priPID
     * @throws Exception
     */
	@Override
	public boolean doJudgeIsExsitIsForzenInfo(String priPID) throws Exception{
		Example example = new Example(PubJusticeInfo.class);
		example.createCriteria()
		.andEqualTo(Constants.CS_PRIPID, priPID)
		.andEqualTo("auditState", "1")
		.andEqualTo("frozState", "1");
		List<PubJusticeInfo> justiceInfos = pubJusticeInfoMapper.selectByExample(example);
		if(justiceInfos.size() > 0){
			//若未查到说明该条信息未处于续冻，解冻等其它情况，属于正在冻结。查到并且frozState为1，说明该信息正在续冻(冻结)。
			List<PubJusticeInfo> frozenStateInfos = pubJusticeInfoMapper.selectFrozenStateInfo(priPID);
			if (frozenStateInfos.size() > 0) {
				for (PubJusticeInfo pubJusticeInfo : frozenStateInfos) {
					if ("1".equals(pubJusticeInfo.getFrozState())) {
						return true;
					}
				}
			}else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 描述: 司法协助信息录入详情（公示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月26日
	 * @param UID
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubJusticeInfo doGetPubJusticeInfoForPub(String UID) throws Exception {
		PubJusticeInfo pubJusticeInfo = new PubJusticeInfo();
		pubJusticeInfo.setUID(UID);
		return pubJusticeInfoMapper.selectOne(pubJusticeInfo);
	}

	/**
	 * 描述：查询司法协助信息（用于公告公示）
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param pubJusticeInfo
	 * @param request
	 * @return List<PubJusticeInfo>
	 * @throws Exception
	 */
	public List<PubJusticeInfo> doGetJusticeInfoForBulletin(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubJusticeInfoMapper.selectJusticeInfoForBulletin(request.getParams());
	}

	/**
	 * 描述: 查询司法协助信息（用于公告公示）
	 * 
	 * @auther yujingwei
	 * @date 2016年10月26日
	 * @param justiceType
	 * @return List<PubJusticeInfo>
	 * @throws Exception
	 */
	public List<PubJusticeInfo> doGetInfoByJusticeType(String updateDate) throws Exception {
		return pubJusticeInfoMapper.selectJusticeinfoListForBulletin(updateDate);
	}

	/**
	 * 描述：通过priPID查询司法协助信息
	 * 
	 * @author chenyu
	 * @data 2016-10-31
	 * @param pripid
	 * @return PubJusticeInfo
	 * @throws Exception
	 */
	@Override
	public List<PubJusticeInfo> selectPubJusticeInfoListByPriPID(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(PubJusticeInfo.class);
		example.createCriteria()
	    .andEqualTo("auditState", "1")
		.andEqualTo("priPID", request.getParams().get("priPID").toString());
		return pubJusticeInfoMapper.selectByExample(example);
	}

	/**
	 * 描述：通过cerNO查询司法协助信息
	 * 
	 * @author chenyu
	 * @data 2016-10-31
	 * @param pripid
	 * @return PubJusticeInfo
	 * @throws Exception
	 */
	@Override
	public List<PubJusticeInfoDto> selectSpPledgeListByCerNO(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubJusticeInfoMapper.selectPubJusticeInfoListByCerNO(request.getParams());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String, String> importByExcel(List<List<Object>> list, HttpSession session) throws Exception {
		int result = 0;
		Map<String, String> resultMap = new HashMap<String, String>();
		Map<String, String> iteMap = new HashMap<String, String>();
		iteMap.put("公示冻结股权、其他投资权益", "1");
		iteMap.put("续行冻结股权、其他投资权益", "2");
		iteMap.put("解除冻结股权、其他投资权益", "3");
		iteMap.put("强制转让被执行人股权，办理有限责任公司股东变更登记", "4");
		Map<String, String> carType = new HashMap<String, String>();
		carType.put("居民身份证", "10");
		carType.put("军官证", "20");
		carType.put("警官证", "30");
		carType.put("外国(地区)护照", "40");
		carType.put("香港身份证", "52");
		carType.put("澳门身份证", "54");
		carType.put("台湾身份证", "56");
		carType.put("其他有效身份证件", "90");
		PubJusticeInfo pubJusticeInfo = new PubJusticeInfo();
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		pubJusticeInfo.setSetDate(new Date());
		pubJusticeInfo.setCreateTime(new Date());
		pubJusticeInfo.setDeptCode(sysUser.getDeptCode());
		pubJusticeInfo.setSetName(sysUser.getRealName());
		pubJusticeInfo.setAuditState("0");// 设置待审核
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			List<Object> lo = list.get(i);
			MidBaseInfo bas = new MidBaseInfo();
			if(StringUtils.isEmpty(String.valueOf(lo.get(0)).trim())){//如果注册号为空则不保存
				continue;
			}
			bas.setRegNO(String.valueOf(lo.get(0)));
			MidBaseInfo baseIfo = getBaseInfoByUniIDOrRegNO(lo.get(0).toString());// 查询其主体信息，活动主体id(pirPID)
			if (baseIfo == null || baseIfo.getPriPID().equals("")) {
				buffer.append(lo.get(0).toString());
				continue;
			} else {
				pubJusticeInfo.setPriPID(baseIfo.getPriPID());
			}
			pubJusticeInfo.setUniSCID(String.valueOf(lo.get(0)));
			pubJusticeInfo.setEntName(String.valueOf(lo.get(1)));
			pubJusticeInfo.setExecutionCourt(String.valueOf(lo.get(2)));
		
			if(lo.size()>3){
			pubJusticeInfo.setExecuteItem(iteMap.get(String.valueOf(lo.get(3))));
		    String jusType=iteMap.get(String.valueOf(lo.get(3)));
			if(jusType.equals("1")||jusType.equals("2")||jusType.equals("3")){
				pubJusticeInfo.setJusticeType("1");
			}else if(jusType.equals("4")){
				pubJusticeInfo.setJusticeType("2");
			}
			if(jusType.equals("1")||jusType.equals("2")){
				pubJusticeInfo.setFrozState("1");
			}else if(jusType.equals("3")){
				pubJusticeInfo.setFrozState("2");
			}else if(jusType.equals("4")){
				pubJusticeInfo.setFrozState("");
			}
			}
			pubJusticeInfo.setBotRefNum(String.valueOf(lo.get(4)));
			pubJusticeInfo.setExeRulNum(String.valueOf(lo.get(5)));
			pubJusticeInfo.setExecuteNo(String.valueOf(lo.get(6)));
			pubJusticeInfo.setInv(String.valueOf(lo.get(7)));
			pubJusticeInfo.setCerType(carType.get(String.valueOf(lo.get(8))));
			pubJusticeInfo.setCerNO(String.valueOf(lo.get(9)));
			if (lo.get(10) != null && StringUtils.isNotBlank(String.valueOf(lo.get(10)).trim())) {
				BigDecimal bd = new BigDecimal(String.valueOf(lo.get(10))).setScale(4);
				pubJusticeInfo.setFroAm(bd);
			}
			if (lo.size() > 11) {
				pubJusticeInfo.setFroAuth(String.valueOf(lo.get(11)));
			}
			if (lo.size() > 12) {
				pubJusticeInfo.setFroFrom(DateUtil.stringToDate(String.valueOf(lo.get(12)), "yyyy-MM-dd"));
			}
			if (lo.size() > 13) {
				pubJusticeInfo.setFroTo(DateUtil.stringToDate(String.valueOf(lo.get(13)), "yyyy-MM-dd"));
			}
			if (lo.size() > 14) {
				pubJusticeInfo.setFrozDeadline(String.valueOf(lo.get(14)));
			}
			if (lo.size() > 15) {
				pubJusticeInfo.setPublicDate(DateUtil.stringToDate(String.valueOf(lo.get(15)), "yyyy-MM-dd"));
			}
			if (lo.size() > 16) {
				pubJusticeInfo.setThawDate(DateUtil.stringToDate(String.valueOf(lo.get(16)), "yyyy-MM-dd"));
			}
			if (lo.size() > 17) {
				pubJusticeInfo.setAssInv(String.valueOf(lo.get(17)));
			}
			if (lo.size() > 18) {
				pubJusticeInfo.setAssCerType(carType.get(String.valueOf(lo.get(18))));
			}
			if (lo.size() > 19) {
				pubJusticeInfo.setAssCerNO(String.valueOf(lo.get(19)));
			}
			if (lo.size() > 20) {
				pubJusticeInfo.setExecuteDate(DateUtil.stringToDate(String.valueOf(lo.get(20)), "yyyy-MM-dd"));
			}
			result = pubJusticeInfoMapper.insertSelective(pubJusticeInfo);
		}
		resultMap.put("regNO", buffer.toString());
		resultMap.put("result", String.valueOf(result));
		return resultMap;
	}

	/**
	 * 
	 * @param code
	 * @return
	 * @author ljx
	 */
	@Override
	public MidBaseInfo getBaseInfoByUniIDOrRegNO(String code) {
		Example example = new Example(MidBaseInfo.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("regNO", code);
		Criteria criteria2 = example.createCriteria();
		criteria2.andEqualTo("uniCode", code);
		example.or(criteria2);
		List<MidBaseInfo> list = midBaseInfoMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 描述：司法协助-股权冻结定时失效
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param
	 * @throws Exception
	 */
	public void doSetfrozNoEffect() throws Exception {

	}


}