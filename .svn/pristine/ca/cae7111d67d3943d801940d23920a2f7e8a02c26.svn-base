/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.service.impl;

import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeBasedDto;
import com.icinfo.cs.secnocreditsup.mapper.ExpSeriousCrimeBasedMapper;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeBased;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeBasedService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_exp_serious_crime_based 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月30日
 */
@Service
public class ExpSeriousCrimeBasedServiceImpl extends MyBatisServiceSupport implements IExpSeriousCrimeBasedService {
	
	@Autowired
	private ExpSeriousCrimeBasedMapper expSeriousCrimeBasedMapper;
	/**
     * 描述:异常类严违名单依据列入
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月30日
     */
	public Integer insertExpSeriousCrimeBased(ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto) throws Exception{
		return expSeriousCrimeBasedMapper.insert(expSeriousCrimeBasedDto);
	}
	
	/**
     * 描述:根据sourceId查询异常类严违名单依据列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	public List<ExpSeriousCrimeBased> selectExpSeriousCrimeBasedList(String sourceId) throws Exception{
		Example example = new Example(ExpSeriousCrimeBased.class);
		example.createCriteria().andEqualTo("sourceId", sourceId);
		return expSeriousCrimeBasedMapper.selectByExample(example);
	}
	
	/**
     * 描述:异常类严违名单依据删除
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	public Integer deleteExpSeriousCrimeBasedBySourceId(String sourceId) throws Exception{
		ExpSeriousCrimeBased base = new ExpSeriousCrimeBased();
		base.setSourceId(sourceId);
		return expSeriousCrimeBasedMapper.delete(base);
	}

	@Override
	public Integer UpdateSomeMsg(String sourceId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}