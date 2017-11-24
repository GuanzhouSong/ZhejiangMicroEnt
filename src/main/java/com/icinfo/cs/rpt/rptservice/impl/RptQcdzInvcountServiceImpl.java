/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzInvcountDto;
import com.icinfo.cs.rpt.rptmapper.RptQcdzInvcountMapper;
import com.icinfo.cs.rpt.rptmodel.RptQcdzInvcount;
import com.icinfo.cs.rpt.rptmodel.RptQcdzToday;
import com.icinfo.cs.rpt.rptservice.IRptQcdzInvcountService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_qcdz_invcount 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class RptQcdzInvcountServiceImpl extends MyBatisServiceSupport implements IRptQcdzInvcountService {
	
	@Autowired
	private RptQcdzInvcountMapper rptQcdzInvcountMapper;
	
	
	/**
	 * 
	 * 描述: 大屏可视化--图5 投资分布（查询法人股东和自然人股东）
	 * @auther gaojinling
	 * @date 2017年9月27日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzInvcountDto> selectRptQcdzInvcountList(Map<String, Object> map) throws Exception{
		return rptQcdzInvcountMapper.selectRptQcdzInvcountList(map);
	}
	
	public int save(RptQcdzInvcount rptQcdzInvcount) throws Exception{
		return rptQcdzInvcountMapper.insertSelective(rptQcdzInvcount);
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
		Example example = new Example(RptQcdzInvcount.class);
		example.createCriteria().andEqualTo("name", name).andEqualTo("type", type);
		return rptQcdzInvcountMapper.deleteByExample(example);
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
	public int update(RptQcdzInvcount rptQcdzInvcount) throws Exception{
		Example example = new Example(RptQcdzInvcount.class);
		example.createCriteria().andEqualTo("name", rptQcdzInvcount.getName()).andEqualTo("type", rptQcdzInvcount.getType());
		return rptQcdzInvcountMapper.updateByExampleSelective(rptQcdzInvcount, example);
	}
	
	
}