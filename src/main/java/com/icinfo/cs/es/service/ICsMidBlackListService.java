/*
 * Copyright? 2003-2016 �㽭���ſƼ����޹�˾, All Rights Reserved. 
 */
package com.icinfo.cs.es.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.CsMidBlackListDto;
import com.icinfo.cs.es.model.CsMidBlackList;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * ����:    cs_mid_blacklist ��Ӧ��Service�ӿ�.<br>
 *
 * @author framework generator
 * @date 2016��11��03��
 */
public interface ICsMidBlackListService extends BaseService {
	/**
	 * 根据CerNO获取吊销黑名单信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	List<CsMidBlackListDto> selectCsMidBlackListByCerNO(PageRequest request) throws Exception;
	/**
	 * 查询黑名单信息
	 * @author zjj
	 */
	List<CsMidBlackList> selectCsMidBlackList(Map<String,Object> qryMap) throws Exception;
}