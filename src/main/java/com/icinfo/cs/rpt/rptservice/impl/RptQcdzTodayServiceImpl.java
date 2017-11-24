/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzTodayDto;
import com.icinfo.cs.rpt.rptmapper.RptQcdzTodayMapper;
import com.icinfo.cs.rpt.rptmodel.RptQcdzToday;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtcount;
import com.icinfo.cs.rpt.rptservice.IRptQcdzTodayService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_qcdz_today 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class RptQcdzTodayServiceImpl extends MyBatisServiceSupport implements IRptQcdzTodayService {
	
	@Autowired
	private RptQcdzTodayMapper rptQcdzTodayMapper;
	
	/**
	 * 
	 * 描述:大屏--图三 今日注销新设数量查询
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzTodayDto> selectRptQcdzTodayList(Map<String, Object> map) throws Exception{
		return rptQcdzTodayMapper.selectRptQcdzTodayList(map);
	}
	
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int save(RptQcdzToday rptQcdzToday) throws Exception{
		return rptQcdzTodayMapper.insertSelective(rptQcdzToday);
	}
	
	/**
	 * 
	 * 描述: 删除(根据type和name删除)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public int delete(String name,String type) throws Exception{
		Example example = new Example(RptQcdzToday.class);
		example.createCriteria().andEqualTo("name", name).andEqualTo("type", type);
		return rptQcdzTodayMapper.deleteByExample(example);
	}
	
	/**
	 * 
	 * 描述: 更新
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int update(RptQcdzToday rptQcdzToday) throws Exception{
		Example example = new Example(RptQcdzToday.class);
		example.createCriteria().andEqualTo("name", rptQcdzToday.getName()).andEqualTo("type", rptQcdzToday.getType());
		return rptQcdzTodayMapper.updateByExampleSelective(rptQcdzToday, example);
	}
}