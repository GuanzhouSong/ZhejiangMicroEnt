/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述: cs_pub_sccheck_type 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubSccheckTypeService extends BaseService {
	/**
	 * 描述：获取检查事项列表
	 * 
	 * @author baifangfang
	 * @date 2017年5月18日
	 * @return
	 */
	List<PubSccheckType> queryPubSccheckTypeList();

	/**
	 * 描述：根据编码查询检查类型
	 * 
	 * @author baifangfang
	 * @date 2017年5月18日
	 * @param code
	 * @return
	 */
	PubSccheckType queryPubSccheckTypeByCode(String code);

	/**
	 * 
	 * 描述 获取所有检查事项 @author 赵祥江 @date 2017年5月18日 下午4:29:30 @param @return
	 * List<PubSccheckType> @throws
	 */
	public List<PubSccheckType> selectAllPubSccheckType();

	/**
	 * @throws Exception
	 * 
	 * 描述 根据编码查询 @author 赵祥江 @date 2017年5月18日 下午5:31:08 @param @return
	 * List<PubSccheckType> @throws
	 */
	public List<PubSccheckType> selectPubSccheckTypeList(Map<String, Object> queryMap) throws Exception;

	/**
	 * 
	 * 描述: 执法事项树
	 * 
	 * @auther gaojinling
	 * @date 2017年5月25日
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectScPtypeMap(String sccheckCodeIn) throws Exception;

}