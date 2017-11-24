/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.creditprove.dto.CreditProveListDto;
import com.icinfo.cs.creditprove.mapper.CreditProveListMapper;
import com.icinfo.cs.creditprove.model.CreditProveList;
import com.icinfo.cs.creditprove.service.ICreditProveListService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_credit_prove_list 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@Service
public class CreditProveListServiceImpl extends MyBatisServiceSupport implements ICreditProveListService {

	@Autowired
	private CreditProveListMapper creditProveListMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	/**
	 * 
	 * 描述   根据uid删除
	 * @author  赵祥江
	 * @date 2017年4月5日 下午2:01:46 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteCreditProveListByUid(String uid) throws Exception {
		if(StringUtil.isNotBlank(uid)){
			CreditProveList creditProveList=new CreditProveList();
			creditProveList.setUid(uid);
			return creditProveListMapper.delete(creditProveList);
		}
		return 0;
	}

	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年4月5日 下午2:02:01 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertCreditProveList(CreditProveList creditProveList) throws Exception {
		if(creditProveList!=null){
			creditProveList.setCreateTime(DateUtil.getSysDate());
			return creditProveListMapper.insert(creditProveList);
		}
		return 0;
	}

	/**
	 * 
	 * 描述   分页查询企业名单
	 * @author  赵祥江
	 * @date 2017年4月6日 上午11:44:27 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CreditProveListDto> selectCreditProveEntListJSON(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectCreditProveEntListJSON(request.getParams());
	} 
	 
	/**
	 * 
	 * 描述   导入
	 * @author  赵祥江
	 * @date 2017年4月6日 下午5:05:36 
	 * @param  
	 * @throws
	 */
	@Override
	public Map<String, String> doSaveCreditProveListExcelBatch(InputStream in,SysUserDto sysUser,String proveType) throws Exception{ 
		   Map<String, String> resultMap = new HashMap<String, String>();
		   // 数据校验
		   if(in == null || sysUser == null){
			   return null;
		   }
		   List<CreditProveList> creditProveListTem=null;
		   Map<String, Object> resMap= excelTranslateToCreditProveList(in,sysUser,proveType);
		   if(resMap.containsKey("data")){
			   creditProveListTem=(List<CreditProveList>) resMap.get("data");
		   }
		   if(creditProveListTem.size()>0){
			   for(CreditProveList creditProveList : creditProveListTem){
				   creditProveList.setProveType(proveType); 
				   if("1".equals(proveType)){
					   // 2.判断基本信息库是否存在该企业
					   List<MidBaseInfo> midBaseInfos = doJudgeEntInfoIsExist(creditProveList.getRegNO(),creditProveList.getEntName());
					   if(CollectionUtils.isEmpty(midBaseInfos)){
						   continue;
					   }
					   MidBaseInfo midBaseInfo = midBaseInfos.get(0);
					   // 企业信息
					   creditProveList.setSetName(sysUser.getRealName());
					   creditProveList.setSetTime(DateUtil.getSysDate());
					   creditProveList.setPriPID(midBaseInfo.getPriPID());
					   creditProveList.setRegNO(midBaseInfo.getRegNO());
					   creditProveList.setUniSCID(midBaseInfo.getUniCode());
					   creditProveList.setEntName(midBaseInfo.getEntName());
					  /* CreditProveList creditProve=this.selectCreditProveListByRegNOAndPriPID(midBaseInfo.getRegNO(), midBaseInfo.getPriPID());
					   if(creditProve!=null){
						   creditProveList.setUid(creditProve.getUid());
						   this.updateCreditProveListByUid(creditProveList);
					   }else{*/
						   this.insertCreditProveList(creditProveList);
					   //}
				   }else{
					  /* CreditProveList  creditProveTem =  this.selectCreditProveListByCerNO(creditProveList.getCerNO());
					   if(creditProveTem!=null){
						   creditProveList.setUid(creditProveTem.getUid());*/
						   creditProveList.setSetName(sysUser.getRealName());
						   creditProveList.setSetTime(DateUtil.getSysDate());
						 //  this.updateCreditProveListByUid(creditProveList);
					  //}else{
						   this.insertCreditProveList(creditProveList);
					   //}
				   }
			   }
		   }
		   //导入条数
		   resultMap.put("allImportTatol",creditProveListTem==null?"0":creditProveListTem.size()+"");
		   //状态
		   resultMap.put("status", resMap.get("status").toString());
		   //提示信息
		   resultMap.put("msg", resMap.get("msg").toString());
		   return resultMap;	
		}
	
	/**
	 * 
	 * 描述   根据类型将表格转换成集合 如果有错误给出提示信息
	 * @author 赵祥江
	 * @date 2017年4月25日 下午2:31:57 
	 * @param 
	 * @return Map<String,Object>
	 * @throws
	 */
	private   Map<String,Object>  excelTranslateToCreditProveList(InputStream in,SysUserDto sysUser,String proveType) {
		Map<String,Object> qMap=new HashMap<String,Object>();
		//校验MAP
		Map<String,Object> checkMap=new HashMap<String,Object>();
		//校验成功状态 0 成功 1 失败
		qMap.put("status", "0");
		StringBuffer bf=new StringBuffer();
		CardUtil cc = new CardUtil();
		try {
			//解析excel
			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			if (rows < 3) {
				return null;
			} 
			List<CreditProveList> creditProveList = new ArrayList<CreditProveList>(); 
			// 遍历处理每行
			for (int i = 2; i < rows; i++) {
				int count=i;
				CreditProveList creditProveTem = new CreditProveList();
				Row row = sheet.getRow(i);
				if("1".equals(proveType)){//企业
					String regOrUnicode = com.icinfo.cs.common.utils.ExcelUtil.parseCellValueToString(row.getCell(0));// 注册号或统一代码
					if(StringUtil.isBlank(regOrUnicode)){
						++count;
						bf.append("第"+count+"行第1列统一信用代码/注册号不能为空;"); 
						qMap.put("status", "1");
						continue;
					}
					
					String entName = ExcelUtil.getCellContent(row.getCell(1));  //企业名称
					if(StringUtil.isBlank(entName)){
						++count;
						bf.append("第"+count+"行第2列企业名称不能为空;"); 
						qMap.put("status", "1");
						continue;
					}
					
					List<MidBaseInfo> midBaseInfoList=  this.doJudgeEntInfoIsExist(regOrUnicode,entName);
					if(midBaseInfoList.size()==0){
						++count;
						bf.append("第"+count+"行根据统一信用代码/注册号和企业名称没有找到企业基本信息;"); 
						qMap.put("status", "1");
						continue;
					}
					List<CreditProveList> proveList= this.selectCreditProveListByRegNOAndPriPID(midBaseInfoList.get(0).getRegNO(), midBaseInfoList.get(0).getPriPID());
					if(proveList!=null&&proveList.size()>0){
						++count;
						bf.append("第"+count+"行数据已经存在;"); 
						qMap.put("status", "1");
						continue;
					}
					creditProveTem.setRegNO(regOrUnicode);
					creditProveTem.setEntName(entName);
					
					if(!checkMap.containsKey(regOrUnicode)){
						checkMap.put(regOrUnicode, entName);
					}else{
						continue;
					}
				}else{//自然人
					String name = ExcelUtil.getCellContent(row.getCell(0));// 姓名
					if(StringUtil.isBlank(name)){
						++count;
						bf.append("第"+count+"行第1列姓名不能为空;"); 
						qMap.put("status", "1");
						continue;
					}
					name=name.trim();
					creditProveTem.setName(name);
					String cerNO = ExcelUtil.getCellContent(row.getCell(1));  //身份证件号码
					if(StringUtil.isBlank(cerNO)){
						++count;
						bf.append("第"+count+"行第2列身份证件号码不能为空;"); 
						qMap.put("status", "1");
						continue;
					}
					cerNO=cerNO.trim();
					//校验身份证号码
					if(!"".equals(cc.IDCardValidate(cerNO.toLowerCase()))){
						++count;
						bf.append("第"+count+"行第2列身份证件号码格式不正确;"); 
						qMap.put("status", "1");
						continue;
					}
					
					List<CreditProveList>   creditProveListT =this.selectCreditProveListByCerNO(cerNO);
					if(creditProveListT!=null&&creditProveListT.size()>0){
						++count;
						bf.append("第"+count+"行数据已经存在;"); 
						qMap.put("status", "1");
						continue;
					} 
					creditProveTem.setCerNO(cerNO);
					if(!checkMap.containsKey(creditProveTem.getCerNO())){
						checkMap.put(creditProveTem.getCerNO(), creditProveTem.getName());
					}else{
						continue;
					}
				} 
				creditProveList.add(creditProveTem); 
			}
			qMap.put("data", creditProveList);
			qMap.put("msg", bf.toString());
			return qMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @throws Exception 
	 * 
	 * 描述   根据企业名称 注册号或社会统一信用代码获取企业信息
	 * @author 赵祥江
	 * @date 2017年4月6日 下午4:51:20 
	 * @param 
	 * @return List<MidBaseInfo>
	 * @throws
	 */
	public List<MidBaseInfo> doJudgeEntInfoIsExist(String regNO,String entName) throws Exception { 
		PageRequest request=new PageRequest();
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("uniCode_regNO", regNO);
		queryMap.put("entname", entName);
		request.setParams(queryMap);
		List<MidBaseInfo> midBaseInfoList= midBaseInfoService.queryPage(request); 
		return midBaseInfoList;
	}

	/**
	 * 
	 * 描述   查询工商行政处罚 多个用逗号隔开
	 * @author  赵祥江
	 * @date 2017年4月10日 下午5:41:18 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubOtherpunishDto> selectMidCaseInfoByPripids(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectMidCaseInfoByPripids(request.getParams());
	}

	/**
	 * 
	 * 描述   根据主体身份代码查询其他部门行政处罚 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午9:33:24 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	@Override
	public List<PubOtherpunishDto> selectPubOtherpunishByPripids(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectPubOtherpunishByPripids(request.getParams());
	}

	/**
	 * 
	 * 描述    根据主体身份代码查询企业异常名录（列入未移出） 多个用逗号隔开
	 * @author  赵祥江
	 * @date 2017年4月11日 上午10:04:26 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubOpanoMaly> selectOpanomalyResultMapByPripids(
			PageRequest request) throws Exception { 
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectOpanomalyByPripids(request.getParams());
	}

	/**
	 * 
	 * 描述   根据主体身份代码查询严重违法失信  多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:23:36 
	 * @param 
	 * @return List<ExpSeriousCrimeList>
	 * @throws
	 */
	@Override
	public List<ExpSeriousCrimeList> selectExpSeriousCrimeByPripids(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectExpSeriousCrimeByPripids(request.getParams());
	}

	/**
	 * 
	 * 描述   根据主体身份代码查询任职资格限制 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午11:03:14 
	 * @param 
	 * @return List<QualificationLimit>
	 * @throws
	 */
	@Override
	public List<QualificationLimit> selectQualificationLimitByPripids(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectQualificationLimitByPripids(request.getParams());
	}
	
	/**
	 * 
	 * 描述   失信被执行人黑名单
	 * @author 赵祥江
	 * @date 2017年4月21日 上午9:22:52 
	 * @param 
	 * @return List<QualificationLimit>
	 * @throws
	 */
	@Override
	public List<QualificationLimit> selectQualificationLimitTypePripids(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectQualificationLimitTypePripids(request.getParams());
	}
	
	
	

	/**
	 * 
	 * 描述   根据证件号查询
	 * @author  赵祥江
	 * @date 2017年4月20日 下午3:24:32 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CreditProveListDto> selectProPidListBycertNO(String certNO)
			throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("certNO", certNO);
		return creditProveListMapper.selectProPidListBycertNO(queryMap);
	}

	/**
	 * 
	 * 描述   根据身份证号查询
	 * @author  赵祥江
	 * @date 2017年4月20日 下午6:08:57 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CreditProveListDto> selectMidInvDivTableBycerNOs(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveListMapper.selectMidInvDivTableBycerNOs(request.getParams());
	}

	/**
	 * 
	 * 描述   根据uid查询
	 * @author  赵祥江
	 * @date 2017年4月21日 上午11:35:00 
	 * @param  
	 * @throws
	 */
	@Override
	public CreditProveList selectCreditProveListByUid(String uid)
			throws Exception {
		CreditProveList creditProveList=new CreditProveList();
		creditProveList.setUid(uid);
		return creditProveListMapper.selectOne(creditProveList);
	}

	/**
	 * 
	 * 描述   根据主键uid更新
	 * @author 赵祥江
	 * @date 2017年4月25日 下午2:18:38 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int updateCreditProveListByUid(CreditProveList creditProveList)
			throws Exception {
		//时间戳
		creditProveList.setCreateTime(DateUtils.getSysDate());
		Example example = new Example(CreditProveList.class);
		example.createCriteria().andEqualTo("uid", creditProveList.getUid());
	    return creditProveListMapper.updateByExampleSelective(creditProveList, example); 
	}

	/**
	 * 
	 * 描述   根据证件号查询
	 * @author 赵祥江
	 * @date 2017年4月25日 下午2:16:02 
	 * @param 
	 * @return CreditProveList
	 * @throws
	 */
	@Override
	public List<CreditProveList> selectCreditProveListByCerNO(String cerNO)
			throws Exception {
		CreditProveList creditProveList=new CreditProveList();
		creditProveList.setCerNO(cerNO);
		return creditProveListMapper.select(creditProveList);
	}

	/**
	 * 
	 * 描述   根据主体身份代码和注册号查询
	 * @author 赵祥江
	 * @date 2017年4月25日 下午3:03:57 
	 * @param 
	 * @return CreditProveList
	 * @throws
	 */
	@Override
	public List<CreditProveList>  selectCreditProveListByRegNOAndPriPID(String regNO,
			String priPID) throws Exception {
		CreditProveList creditProveList=new CreditProveList();
		creditProveList.setRegNO(regNO);
		creditProveList.setPriPID(priPID);
		return creditProveListMapper.select(creditProveList);
	}



}