/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年04月05日
 * @version 2.0
 */
package com.icinfo.cs.creditprove.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.creditprove.dto.CreditProveListDto;
import com.icinfo.cs.creditprove.model.CreditProveList;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_credit_prove_list 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
public interface CreditProveListMapper extends Mapper<CreditProveList> {
	
	/**
	 * 
	 * 描述   企业名单查询 分页
	 * @author 赵祥江
	 * @date 2017年4月6日 上午11:41:07 
	 * @param 
	 * @return List<CreditProveListDto>
	 * @throws
	 */
	public List<CreditProveListDto> selectCreditProveEntListJSON(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   根据身份证号查询
	 * @author 赵祥江
	 * @date 2017年4月20日 下午6:13:49 
	 * @param 
	 * @return List<CreditProveListDto>
	 * @throws
	 */
	public List<CreditProveListDto> selectMidInvDivTableBycerNOs(Map<String,Object> queryMap)throws Exception;
	
	
	
	/**
	 * 
	 * 描述   根据证件号码查询
	 * @author 赵祥江
	 * @date 2017年4月20日 下午3:21:15 
	 * @param 
	 * @return List<CreditProveListDto>
	 * @throws
	 */
	public List<CreditProveListDto> selectProPidListBycertNO(Map<String,Object> queryMap)throws Exception;
	
	
	
	/**
	 * 
	 * 描述   根据主体身份代码查询工商行政处罚 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月10日 下午5:37:32 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	public List<PubOtherpunishDto> selectMidCaseInfoByPripids(Map<String,Object> queryMap)throws Exception;
	
 
	/**
	 * 
	 * 描述   根据主体身份代码查询其他部门行政处罚 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午9:33:24 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	public List<PubOtherpunishDto> selectPubOtherpunishByPripids(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询企业异常名录（列入未移出） 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:02:45 
	 * @param 
	 * @return List<PubOpanoMaly>
	 * @throws
	 */
	public List<PubOpanoMaly> selectOpanomalyByPripids(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询严重违法失信  多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:23:36 
	 * @param 
	 * @return List<ExpSeriousCrimeList>
	 * @throws
	 */
	public List<ExpSeriousCrimeList> selectExpSeriousCrimeByPripids(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询任职资格限制 多个用逗号隔开 
	 * @author 赵祥江
	 * @date 2017年4月11日 上午11:03:14 
	 * @param 
	 * @return List<QualificationLimit>
	 * @throws
	 */
	public List<QualificationLimit> selectQualificationLimitByPripids(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   失信被执行人黑名单
	 * @author 赵祥江
	 * @date 2017年4月21日 上午9:25:09 
	 * @param 
	 * @return List<QualificationLimit>
	 * @throws
	 */
	public List<QualificationLimit> selectQualificationLimitTypePripids(Map<String,Object> queryMap)throws Exception;
	
	
	
	
}