/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzZtQsDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzZtcountDto;
import com.icinfo.cs.rpt.rptmapper.RptQcdzZtQsMapper;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtQs;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtcount;
import com.icinfo.cs.rpt.rptservice.IRptQcdzZtQsService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_qcdz_ztqs 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class RptQcdzZtQsServiceImpl extends MyBatisServiceSupport implements IRptQcdzZtQsService {
	
	@Autowired
	private RptQcdzZtQsMapper rptQcdzZtQsMapper;
	
	/**
	 * 
	 * 描述: 大屏可视化--图一（当年新设消亡月趋势）
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzZtQsDto> selectRptQcdzZtQsList(Map<String, Object> map)throws Exception{
		return rptQcdzZtQsMapper.selectRptQcdzZtQsList(map);
	};
	

	/**
	 * 
	 * 描述: 查询某月份数据是否存在
	 * @auther gaojinling
	 * @date 2017年10月10日 
	 * @param monthcode
	 * @return
	 * @throws Exception
	 */
	public int selectOne(String monthcode) throws Exception{
		Example example = new Example(RptQcdzZtQs.class);
		example.createCriteria().andEqualTo("monthcode", monthcode);
		return rptQcdzZtQsMapper.selectCountByExample(example);
	}
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年10月10日 
	 * @param rptQcdzZtQs
	 * @return
	 * @throws Exception
	 */
	public int save(RptQcdzZtQs rptQcdzZtQs) throws Exception{
		rptQcdzZtQs.setUpdatetime(new Date());
		return rptQcdzZtQsMapper.insert(rptQcdzZtQs);
	}
	
	public int delete(String monthcode) throws Exception{
		Example example = new Example(RptQcdzZtQs.class);
		example.createCriteria().andEqualTo("monthcode", monthcode);
		return rptQcdzZtQsMapper.deleteByExample(example);
	}
	
	public int update(RptQcdzZtQs rptQcdzZtQs) throws Exception{
		Example example = new Example(RptQcdzZtQs.class);
		example.createCriteria().andEqualTo("monthcode", rptQcdzZtQs.getMonthcode());
		rptQcdzZtQs.setUpdatetime(new Date());
		return rptQcdzZtQsMapper.updateByExampleSelective(rptQcdzZtQs, example);
	}
	
}