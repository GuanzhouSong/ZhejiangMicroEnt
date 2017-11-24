/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.service;

import java.util.List;

import com.icinfo.cs.registmanage.dto.LimitManageRecordDto;
import com.icinfo.cs.registmanage.model.LimitManageRecord;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_limit_managerecord 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月10日
 */
public interface ILimitManageRecordService extends BaseService {

	/**
	 * 描述：获取受限对象管理记录列表
	 * @param request
	 * @return
	 */
	List<LimitManageRecordDto> qryLimitObjManageRecordList(PageRequest request);
	
	/**
	 * 
	 * 描述:提前解除限制资格解除证明保存
	 * @auther gaojinling
	 * @date 2017年4月17日 
	 * @param limitManageRecord
	 * @return
	 */
	public int save(LimitManageRecord limitManageRecord) throws Exception;
	
	
	/**
	 * 
	 * 描述: 查询单个
	 * @auther gaojinling
	 * @date 2017年4月17日 
	 * @return
	 * @throws Exception
	 */
	public LimitManageRecord selectByUid(String uid ,String removeUid) throws Exception;
	
	
	/**
	 * 
	 * 描述: 获取当前限制对象下的解除证明文号的最大值
	 * @auther gaojinling
	 * @date 2017年4月17日 
	 * @param queryMap
	 * @return
	 */
	public Integer selectLimitNo(String uid) throws Exception ;

	/**
	 * 
	 * 描述: 获取最大文号
	 * @auther baifangfang
	 * @date 2017年4月17日 
	 * @param uid
	 * @param item
	 * @return
	 */
	Integer selectLimitNo(String uid, String item) throws Exception;
}