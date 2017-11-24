/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;

import com.icinfo.cs.sccheck.model.SccheckKey;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_sccheck_key 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月08日
 */
public interface ISccheckKeyService extends BaseService {

	/**
	 * 描述：保存专项检查表
	 * 
	 * @author chenxin
	 * @date 2017-11-08
	 * @param sccheckKeyList
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public boolean saveList(List<SccheckKey> sccheckKeyList,String uid)throws Exception;
	
	/**
	 * 描述：查询列表根据结果表uid
	 * 
	 * @author chenxin
	 * @date 2017-11-08
	 * @param sccheckKeyList
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public List<SccheckKey> selectListByResultUid(String resultUid)throws Exception;
}