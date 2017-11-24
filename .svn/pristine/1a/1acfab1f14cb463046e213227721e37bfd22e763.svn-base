/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.mapper.CsMortEstateInfoMapper;
import com.icinfo.cs.es.model.CsMortEstateInfo;
import com.icinfo.cs.es.service.ICsMortEstateInfoService;
import com.icinfo.cs.other.model.MortRegInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mort_estate_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
@Service
public class CsMortEstateInfoServiceImpl extends MyBatisServiceSupport implements ICsMortEstateInfoService {
	@Autowired
	private CsMortEstateInfoMapper csMortEstateInfoMapper;
	/**
	 * 根据priPID获取企业不动产抵押信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CsMortEstateInfo> selectCsMortEstateInfoListByPriPID(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> searchMap=  request.getParams();
		String regno = searchMap.get("regNO").toString();
		String unicode = searchMap.get("uniCode").toString();
		if(StringUtils.isBlank(regno) && StringUtils.isBlank(unicode)){
			return new ArrayList<CsMortEstateInfo>();
		}else{
		Example example = new Example(CsMortEstateInfo.class);
		Example.Criteria criteria1 = example.createCriteria();
		Example.Criteria criteria2 = example.createCriteria();
		if(StringUtils.isNotBlank(regno)){
			criteria1.andEqualTo("mortGagorCertNO", regno);
		}
		if(StringUtils.isNotBlank(unicode)){
			criteria2.andEqualTo("mortGagorCertNO", unicode );
		}
		example.or(criteria2);
		example.setOrderByClause("CheckDate desc");
		return csMortEstateInfoMapper.selectByExample(example);
		}
	}
	
	/**
	 * 根据cerNO获取个人不动产抵押信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CsMortEstateInfo> selectCsMortEstateInfoListByCerNO(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsMortEstateInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("mortGagorCertNO", "%" + request.getParams().get("cerNO").toString() + "%");
		//criteria.andLike("mortGagorCertNO", "%" + "111" + "%");
		return csMortEstateInfoMapper.selectByExample(example);
	}
}