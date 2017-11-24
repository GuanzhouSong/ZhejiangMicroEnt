/*
 * Copyright? 2003-2016 �㽭���ſƼ����޹�˾, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.dto.CsMidBlackListDto;
import com.icinfo.cs.es.mapper.CsMidBlackListMapper;
import com.icinfo.cs.es.model.CsMidBlackList;
import com.icinfo.cs.es.service.ICsMidBlackListService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ����:    cs_mid_blacklist ��Ӧ��Service�ӿ�ʵ����.<br>
 *
 * @author framework generator
 * @date 2016��11��03��
 */
@Service
public class CsMidBlackListServiceImpl extends MyBatisServiceSupport implements ICsMidBlackListService {
	@Autowired
	private CsMidBlackListMapper csMidBlackListMapper;
	/**
	 * 根据CerNO获取吊销黑名单信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CsMidBlackListDto> selectCsMidBlackListByCerNO(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csMidBlackListMapper.selectCsMidBlackListByCerNO(request.getParams());
	}
	
	@Override
	public List<CsMidBlackList> selectCsMidBlackList(Map<String, Object> qryMap) throws Exception {
		Example example = new Example(CsMidBlackList.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (qryMap != null) {
			for (Map.Entry<String, Object> entry : qryMap.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return csMidBlackListMapper.selectByExample(example);
	}
}