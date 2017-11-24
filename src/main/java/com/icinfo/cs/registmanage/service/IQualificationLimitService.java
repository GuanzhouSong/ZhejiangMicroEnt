/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registmanage.dto.QualificationLimitDto;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_qualification_limit 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
public interface IQualificationLimitService extends BaseService {

	/**
	 * 描述:获取任职资格限制管理列表
	 *
	 * @throws Exception
	 * @auther ylr
	 * @date 2016年11月6日
	 */
	List<QualificationLimitDto> selectQualificationLimitList(PageRequest request) throws Exception;

	/**
	 * 描述:提前解除限制
	 *
	 * @throws Exception
	 * @auther ylr
	 * @date 2016年11月6日
	 */
	Integer updateByUid(QualificationLimitDto qualificationLimitDto) throws Exception;

	/**
	 * 描述:判断当事人是否受限
	 * 
	 * @throws Exception
	 * @auther yujingwei
	 * @date 2017年3月22日
	 */
	List<QualificationLimit> selectLimitPersonInfo(String priPID) throws Exception;

	/**
	 * 描述:通过uid查询受限黑名单信息
	 * 
	 * @throws Exception
	 * @auther yujingwei
	 * @param uid
	 * @date 2017年3月22日
	 */
	QualificationLimit selectQualificationLimitInfoByUid(String uid) throws Exception;

	/**
	 * 描述:获取任职资格黑名单查询列表
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param request
	 * @return
	 */
	public List<QualificationLimitDto> selectRightLimitList(PageRequest request);

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
	 * 描述:获取任职资格黑名单查询pripid List
	 * 
	 * @auther chenxin
	 * @date 2017年03月22日
	 * @param qryMap
	 * @return
	 */
	public List<String> selectRightPriPIDList(Map<String, Object> qryMap);

	/**
	 * 描述：获取任职限制对象列表(按任职限制对象查询)
	 * 
	 * @auther baifangfang
	 * @date 2017年04月06日
	 * @param request
	 * @return
	 */
	List<QualificationLimitDto> selectLimitObjList(PageRequest request);

	/**
	 * 描述：获取任职限制对象列表(按限制对象关联企业查询)
	 * 
	 * @author baifangfang
	 * @date 2017-04-06
	 * @return
	 */
	List<QualificationLimitDto> selectlimitRelEntList(PageRequest request);

	/**
	 * 
	 * 描述: 获取提前限制资格申请列表
	 * 
	 * @auther gaojinling
	 * @date 2017年4月6日
	 * @param qryMap
	 * @return
	 */
	public List<QualificationLimitDto> selectRemoveLimitList(PageRequest request);

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
	int qryLimitObjCount(Map<String, Object> map);

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
	int qryRelEntCount(Map<String, Object> params);

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
	int qryLimitObjCountByEnt(Map<String, Object> params);

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
	int qryRelEntCountByEnt(Map<String, Object> params);

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
	 * 描述: 获取提前解除限制查询 限制对象人数
	 * 
	 * @auther gaojinling
	 * @date 2017年4月13日
	 * @param map
	 * @return
	 */
	public int selectRemovePripidTotal(Map<String, Object> map);

	/**
	 * 
	 * 描述: 获取单个限制资格对象（未分页）
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param map
	 * @return
	 */
	public QualificationLimitDto selectQualificationLimitDtoByUid(Map<String, Object> map);

	/**
	 * 
	 * 描述: 修改
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param qualificationLimit
	 * @return
	 * @throws Exception
	 */
	public int update(QualificationLimit qualificationLimit) throws Exception;

	/**
	 * 
	 * 描述: 删除（通过uid）
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public int delete(String uid) throws Exception;

	/**
	 * 
	 * 描述: 修改(更新包括属性值为NUll的数据)
	 * 
	 * @auther gaojinling
	 * @date 2017年4月10日
	 * @param qualificationLimit
	 * @return
	 * @throws Exception
	 */
	public int updateByNull(QualificationLimit qualificationLimit) throws Exception;

	/**
	 * 描述：按任职限制对象查询详情
	 * 
	 * @author baifangfang
	 * @date 2017年6月15日
	 * @param request
	 * @return
	 */
	List<QualificationLimitDto> selectLimitObjDetailList(PageRequest request);

	/**
	 * 描述：获取任职限制对象列表(按失信被执行人关联企业查询)
	 * 
	 * @author baifangfang
	 * @date 2017年8月16日
	 * @param request
	 * @return
	 */
	List<QualificationLimit> selectlimiterRelEntList(PageRequest request);

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
	
	/** 
	 * 描述: 任职资格限制信息同步
	 * @auther ZhouYan
	 * @date 2017年10月23日 
	 * @throws Exception 
	 */
	public void doQualificationLimitQuartz() throws Exception;

}