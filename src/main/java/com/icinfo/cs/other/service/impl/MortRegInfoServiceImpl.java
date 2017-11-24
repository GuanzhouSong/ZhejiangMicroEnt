/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.mapper.MortRegInfoMapper;
import com.icinfo.cs.other.model.MortRegInfo;
import com.icinfo.cs.other.service.IMortRegInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_mort_reg_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class MortRegInfoServiceImpl extends MyBatisServiceSupport implements IMortRegInfoService {
	
	@Autowired
	MortRegInfoMapper mortRegInfoMapper;

	/** 
	 * 描述: 获取动产抵押信息列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<MortRegInfo> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> searchMap=  request.getParams();
		String regno = searchMap.get("regNO")==null?null:searchMap.get("regNO").toString();
		String unicode = searchMap.get("uniCode")==null?null:searchMap.get("uniCode").toString();
		if(StringUtils.isBlank(regno) && StringUtils.isBlank(unicode)){
			return new ArrayList<MortRegInfo>();
		}else{
			Example example = new Example(MortRegInfo.class);
			Example.Criteria criteria1 = example.createCriteria();
			Example.Criteria criteria2 = example.createCriteria();
			if(StringUtils.isNotBlank(regno)){
				criteria1.andEqualTo("mortGagorCertNO", regno).andEqualTo("cancelStatus",'0').andEqualTo("checkStatus",'1');
			}
			if(StringUtils.isNotBlank(unicode)){
				criteria2.andEqualTo("mortGagorCertNO", unicode).andEqualTo("cancelStatus",'0').andEqualTo("checkStatus",'1');
			}
			example.or(criteria2);
			example.setOrderByClause("CheckDate desc");
			
			return mortRegInfoMapper.selectByExample(example);
		}
	}

	/** 
	 * 描述: 获取动产抵押信息详情（公示）
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Override
	public MortRegInfo doGetMortRegInfoById(String id) throws Exception {
		if(StringUtils.isNotBlank(id)) {
			return mortRegInfoMapper.selectByPrimaryKey(Integer.valueOf(id));
		}else{
			return new MortRegInfo();
		}
	}

	/** 
	 * 描述: 根据priPID获取动产抵押信息详情
	 * @auther chenyu
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<MortRegInfo> selectMortRegInfoListByPriPID(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> searchMap=  request.getParams();
		String regno = searchMap.get("regNO").toString();
		String unicode = searchMap.get("uniCode").toString();
		if(StringUtils.isBlank(regno) && StringUtils.isBlank(unicode)){
			return new ArrayList<MortRegInfo>();
		}else{
			Example example = new Example(MortRegInfo.class);
			Example.Criteria criteria1 = example.createCriteria();
			Example.Criteria criteria2 = example.createCriteria();
			if(StringUtils.isNotBlank(regno)){
				criteria1.andEqualTo("mortGagorCertNO",regno);
			}
			if(StringUtils.isNotBlank(unicode)){
				criteria2.andEqualTo("mortGagorCertNO", unicode);
			}
			example.or(criteria2);
			example.setOrderByClause("CheckDate desc");
			return mortRegInfoMapper.selectByExample(example);
		}
	}

	/** 
	 * 描述: 根据cerNO获取动产抵押信息详情
	 * @auther chenyu
	 * @date 2016年10月27日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<MortRegInfo> selectMortRegInfoListByCerNO(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		/*PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(MortRegInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("mortGagorCertNO", "%" + request.getParams().get("cerNO").toString() + "%");
		return mortRegInfoMapper.selectByExample(example);*/
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object>  paramMap = request.getParams();
		return mortRegInfoMapper.selectMortRegInfoListByCerNO(paramMap);
	}
	
}