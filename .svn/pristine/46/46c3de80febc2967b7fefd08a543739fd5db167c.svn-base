/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzMapDto;
import com.icinfo.cs.rpt.rptmapper.RptQcdzMapMapper;
import com.icinfo.cs.rpt.rptmodel.RptQcdzInvcount;
import com.icinfo.cs.rpt.rptmodel.RptQcdzMap;
import com.icinfo.cs.rpt.rptservice.IRptQcdzMapService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_qcdz_map 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
@Service
public class RptQcdzMapServiceImpl extends MyBatisServiceSupport implements IRptQcdzMapService {
	
	@Autowired
	private RptQcdzMapMapper rptQcdzMapMapper;
	
	/**
	 * 
	 * 描述: 全程电子化地图数据
	 * @auther gaojinling
	 * @date 2017年10月31日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzMapDto> selectRptQcdzMapList(Map<String, Object> map) throws Exception{
		return rptQcdzMapMapper.selectRptQcdzMapList(map);
	}
	
	/**
	 * 
	 * 描述: 更新所有
	 * @auther gaojinling
	 * @date 2017年11月1日 
	 * @param rptQcdzMap
	 * @return
	 * @throws Exception
	 */
	public int updateAll(RptQcdzMap rptQcdzMap) throws Exception{
		Example example = new Example(RptQcdzMap.class);
		example.createCriteria().andLessThan("update_time", new Date());
		return rptQcdzMapMapper.updateByExampleSelective(rptQcdzMap, example);
	}
	/**
	 * 
	 * 描述: 更新单个
	 * @auther gaojinling
	 * @date 2017年11月1日 
	 * @param rptQcdzMap
	 * @return
	 * @throws Exception
	 */
	public int updateByRegorg(RptQcdzMap rptQcdzMap) throws Exception{
		Example example = new Example(RptQcdzMap.class);
		example.createCriteria().andEqualTo("regorg", rptQcdzMap.getRegorg());
		return rptQcdzMapMapper.updateByExampleSelective(rptQcdzMap, example);
	}

	
	
	
	

}