/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月04日
 * @version 2.0
 */
package com.icinfo.cs.registmanage.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registmanage.dto.QualificationLimitDto;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_qualification_limit 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
public interface QualificationLimitMapper extends Mapper<QualificationLimit> {

	/**
	 * 描述:获取任职资格限制管理列表
	 *
	 * @throws Exception
	 * @auther ylr
	 * @date 2016年11月6日
	 */
	List<QualificationLimitDto> selectQualificationLimitList(Map<String, Object> qryMap);

	/**
	 * 描述:获取任职资格黑名单查询列表
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param qryMap
	 * @return
	 */
	public List<QualificationLimitDto> selectRightLimitList(Map<String, Object> qryMap);

	/**
	 * 描述:获取任职资格黑名单查询pripid List
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param qryMap
	 * @return
	 */
	public List<String> selectRightPriPIDList(Map<String, Object> qryMap);

	/**
	 * 描述:获取限制信息
	 * 
	 * @auther ylr
	 * @date 2017年03月22日
	 * @param qryMap
	 * @return
	 */
	public List<QualificationLimit> selectLimitPersonInfo(Map<String, Object> qrymap);

	/**
	 * 描述：获取限制对象人数
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param map
	 * @return
	 */
	public int selectPersonTotal(Map<String, Object> map);

	/**
	 * 描述：获取限制原因企业数量
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param map
	 * @return
	 */
	public int selectEntTotal(Map<String, Object> map);

	/**
	 * 描述:获取任职限制对象列表(按任职限制对象查询)
	 * 
	 * @auther baifangfang
	 * @date 2017年04月06日
	 * @param params
	 * @return
	 */
	List<QualificationLimitDto> selectLimitObjList(Map<String, Object> params);

	/**
	 * 描述：获取任职限制对象列表(按限制对象关联企业查询)
	 * 
	 * @author baifangfang
	 * @date 2017-04-06
	 * @param params
	 * @return
	 */
	List<QualificationLimitDto> selectlimitRelEntList(Map<String, Object> params);

	/**
	 * 
	 * 描述: 获取提前限制资格申请列表
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param qryMap
	 * @return
	 */
	public List<QualificationLimitDto> selectRemoveLimitList(Map<String, Object> qryMap);

	/**
	 * 
	 * 描述: 查询限制对象总量(按限制对象查询)
	 * 
	 * @param map
	 * @auther baifangfang
	 * @date 2017年4月17日
	 * @param qryMap
	 * @return
	 */
	int selectLimitObjCount(Map<String, Object> map);

	/**
	 * 
	 * 描述: 查询限制对象关联企业总量(按限制对象查询)
	 * 
	 * @param map
	 * @auther baifangfang
	 * @date 2017年4月17日
	 * @param qryMap
	 * @return
	 */
	int selectRelEntCount(Map<String, Object> params);

	/**
	 * 
	 * 描述: 查询限制对象总量(按关联企业查询)
	 * 
	 * @param map
	 * @auther baifangfang
	 * @date 2017年4月17日
	 * @param qryMap
	 * @return
	 */
	int selectLimitObjCountByEnt(Map<String, Object> params);

	/**
	 * 
	 * 描述: 查询限制对象关联企业总量(按关联企业查询)
	 * 
	 * @param map
	 * @auther baifangfang
	 * @date 2017年4月17日
	 * @param qryMap
	 * @return
	 */
	int selectRelEntCountByEnt(Map<String, Object> params);

	/**
	 * 
	 * 描述: 获取提前解除限制查询 限制对象人数
	 * 
	 * @auther gaojinling
	 * @date 2017年4月13日
	 * @param map
	 * @return
	 */
	public int selectRemoveClientNameTotal(Map<String, Object> map);

	/**
	 * 
	 * 描述: 获取提前解除限制对象查询 限制企业数量
	 * 
	 * @auther gaojinling
	 * @date 2017年4月13日
	 * @param map
	 * @return
	 */
	public int selectRemovePripidTotal(Map<String, Object> map);

	/**
	 * 描述：任职资格黑名单详情
	 * 
	 * @author baifangfang
	 * @date 2017年6月15日
	 * @param params
	 * @return
	 */
	List<QualificationLimitDto> selectLimitObjDetailList(Map<String, Object> params);

	/**
	 * 描述：获取任职限制对象列表(按失信被执行人关联企业查询)
	 * 
	 * @author baifangfang
	 * @date 2017年8月16日
	 * @param params
	 * @return
	 */
	List<QualificationLimitDto> selectlimiterRelEntList(Map<String, Object> params);

	/**
	 * 
	 * 描述：任职资格受限
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param qryMap
	 * @return
	 */
	int limitObjNum(Map<String, Object> qryMap);
	
	void deleteRevocationInfo();
	
	void insertRevocationInfo();
	
	void deleteDishonestexe();
    
	void insertDishonestexe();
	
	public List<QualificationLimit> selectNewRevocationInfo();
	
	public List<QualificationLimit> selectNewDishonestexe();
}