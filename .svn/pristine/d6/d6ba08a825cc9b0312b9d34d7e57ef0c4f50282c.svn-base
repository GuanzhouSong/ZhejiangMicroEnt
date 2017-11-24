/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sccheck.mapper.SccheckKeyMapper;
import com.icinfo.cs.sccheck.model.SccheckKey;
import com.icinfo.cs.sccheck.service.ISccheckKeyService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_sccheck_key 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月08日
 */
@Service
public class SccheckKeyServiceImpl extends MyBatisServiceSupport implements ISccheckKeyService {
	
	@Autowired
	private SccheckKeyMapper sccheckKeyMapper;
	
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
	@Override
	public boolean saveList(List<SccheckKey> sccheckKeyList,String uid) throws Exception {
		if(sccheckKeyList != null){
			Example example = new Example(SccheckKey.class);
			example.createCriteria().andEqualTo("resultUid", uid);
			sccheckKeyMapper.deleteByExample(example);
			for(SccheckKey sccheckKey : sccheckKeyList){
				sccheckKeyMapper.insertSelective(sccheckKey);
			}
			return true;
		}
		return false;
	}
	
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
	@Override
	public List<SccheckKey> selectListByResultUid(String resultUid)throws Exception {
		SccheckKey sccheckKey = new SccheckKey();
		sccheckKey.setResultUid(resultUid);
		return sccheckKeyMapper.select(sccheckKey);
	}
}