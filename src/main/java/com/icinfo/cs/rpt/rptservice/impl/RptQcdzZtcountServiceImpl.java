/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzZtcountDto;
import com.icinfo.cs.rpt.rptmapper.RptQcdzZtcountMapper;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtcount;
import com.icinfo.cs.rpt.rptservice.IRptQcdzZtcountService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_qcdz_ztcount 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class RptQcdzZtcountServiceImpl extends MyBatisServiceSupport implements IRptQcdzZtcountService {
	
	@Autowired
	private RptQcdzZtcountMapper rptQcdzZtcountMapper;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int save(RptQcdzZtcount rptQcdzZtcount) throws Exception{
		rptQcdzZtcount.setCreateTime(new Date());
		return rptQcdzZtcountMapper.insertSelective(rptQcdzZtcount);
	}
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public int delete() throws Exception{
		Example example = new Example(RptQcdzZtcount.class);
		example.createCriteria().andLessThan("createTime", new Date());
		return rptQcdzZtcountMapper.deleteByExample(example);
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
	public int update(RptQcdzZtcount rptQcdzZtcount) throws Exception{
		Example example = new Example(RptQcdzZtcount.class);
		example.createCriteria().andLessThan("createTime", new Date());
		rptQcdzZtcount.setCreateTime(new Date());
		return rptQcdzZtcountMapper.updateByExampleSelective(rptQcdzZtcount, example);
	}
	
	
	/**
	 * 
	 * 描述: 大屏可视化 --查询主体数据
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzZtcountDto>  selectRptQcdzZtcount(Map<String, Object> map) throws Exception{
		return rptQcdzZtcountMapper.selectRptQcdzZtcount(map);
	}
	
	
}