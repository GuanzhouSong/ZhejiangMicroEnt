/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.creditprove.dto.CreditProveListDto;
import com.icinfo.cs.creditprove.model.CreditProveList;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_credit_prove_list 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
public interface ICreditProveListService extends BaseService {
	
	/**
	 * 
	 * 描述   根据主键Uid删除
	 * @author 赵祥江
	 * @date 2017年4月5日 下午2:00:14 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deleteCreditProveListByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据主键ID修改
	 * @author 赵祥江
	 * @date 2017年4月25日 下午2:14:52 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateCreditProveListByUid(CreditProveList creditProveList)throws Exception;
	
	/**
	 * 
	 * 描述   根据uid查询
	 * @author 赵祥江
	 * @date 2017年4月21日 上午11:33:55 
	 * @param 
	 * @return CreditProveList
	 * @throws
	 */
	public CreditProveList selectCreditProveListByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码和注册号查询
	 * @author 赵祥江
	 * @date 2017年4月25日 下午3:02:27 
	 * @param 
	 * @return CreditProveList
	 * @throws
	 */
	public List<CreditProveList> selectCreditProveListByRegNOAndPriPID(String regNO,String priPID)throws Exception;
	
	/**
	 * 
	 * 描述   根据证件号查询
	 * @author 赵祥江
	 * @date 2017年4月25日 下午2:13:54 
	 * @param 
	 * @return CreditProveList
	 * @throws
	 */
	public List<CreditProveList>  selectCreditProveListByCerNO(String cerNO)throws Exception;
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年4月5日 下午2:01:16 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertCreditProveList(CreditProveList creditProveList)throws Exception;
	
	
	/**
	 * 
	 * 描述   分页查询企业名单
	 * @author 赵祥江
	 * @date 2017年4月6日 上午11:43:59 
	 * @param 
	 * @return List<CreditProveListDto>
	 * @throws
	 */
	public List<CreditProveListDto> selectCreditProveEntListJSON(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   根据身份证号码分页查询
	 * @author 赵祥江
	 * @date 2017年4月20日 下午5:47:04 
	 * @param 
	 * @return List<CreditProveListDto>
	 * @throws
	 */
	public List<CreditProveListDto> selectMidInvDivTableBycerNOs(PageRequest request)throws Exception;
	
	
	/**
	 * 
	 * 描述   根据证件号查询
	 * @author 赵祥江
	 * @date 2017年4月20日 下午3:22:53 
	 * @param 
	 * @return List<CreditProveListDto>
	 * @throws
	 */
	public List<CreditProveListDto> selectProPidListBycertNO(String  certNO)throws Exception;
	
	
	 
	/**
	 * 
	 * 描述   导入企业和个人名单
	 * @author 赵祥江
	 * @date 2017年4月6日 下午4:46:06 
	 * @param 
	 * @return Map<String,String>
	 * @throws
	 */
	public Map<String, String> doSaveCreditProveListExcelBatch(InputStream in,SysUserDto sysUser,String proveType) throws Exception;
	
	
	/**
	 * 
	 * 描述   根据主体身份代码查询工商行政处罚 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月10日 下午5:37:32 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	public List<PubOtherpunishDto> selectMidCaseInfoByPripids(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询其他部门行政处罚 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午9:33:24 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	public List<PubOtherpunishDto> selectPubOtherpunishByPripids(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述    根据主体身份代码查询企业异常名录（列入未移出） 多个用逗号隔开
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:03:59 
	 * @param 
	 * @return List<PubOpanoMaly>
	 * @throws
	 */
	public List<PubOpanoMaly> selectOpanomalyResultMapByPripids(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询严重违法失信  多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:23:36 
	 * @param 
	 * @return List<ExpSeriousCrimeList>
	 * @throws
	 */
	public List<ExpSeriousCrimeList> selectExpSeriousCrimeByPripids(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询任职资格限制 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午11:03:14 
	 * @param 
	 * @return List<QualificationLimit>
	 * @throws
	 */
	public List<QualificationLimit> selectQualificationLimitByPripids(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   失信被执行人黑名单
	 * @author 赵祥江
	 * @date 2017年4月21日 上午9:24:20 
	 * @param 
	 * @return List<QualificationLimit>
	 * @throws
	 */
	public List<QualificationLimit> selectQualificationLimitTypePripids(PageRequest request)throws Exception;
	
}