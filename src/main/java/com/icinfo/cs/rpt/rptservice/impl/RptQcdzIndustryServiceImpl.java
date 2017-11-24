/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzIndustryDto;
import com.icinfo.cs.rpt.rptmapper.RptQcdzIndustryMapper;
import com.icinfo.cs.rpt.rptmodel.RptQcdzIndustry;
import com.icinfo.cs.rpt.rptservice.IRptQcdzIndustryService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_qcdz_industry 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月27日
 */
@Service
public class RptQcdzIndustryServiceImpl extends MyBatisServiceSupport implements IRptQcdzIndustryService {
	
	@Autowired
	private RptQcdzIndustryMapper rptQcdzIndustryMapper;
	/**
	 * 
	 * 描述: 大屏可视化 -- 图5投资分布   法人自然人股东行业占比
	 * @auther gaojinling
	 * @date 2017年9月27日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzIndustryDto> selectRptQcdzIndustryList(Map<String, Object> map) throws Exception{
		return rptQcdzIndustryMapper.selectRptQcdzIndustryList(map);
	}
	
	
	public int save(RptQcdzIndustry rptQcdzIndustry) throws Exception{
		return rptQcdzIndustryMapper.insertSelective(rptQcdzIndustry);
	}
	
	/**
	 * 
	 * 描述: 删除(根据type和name删除)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public int delete(String invtype) throws Exception{
		Example example = new Example(RptQcdzIndustry.class);
		example.createCriteria().andEqualTo("invtype", invtype);
		return rptQcdzIndustryMapper.deleteByExample(example);
	}
	
}