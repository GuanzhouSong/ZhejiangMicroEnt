/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.AlterStockInfoHisMapper;
import com.icinfo.cs.yr.model.AlterStockInfoHis;
import com.icinfo.cs.yr.service.IAlterStockInfoHisService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_alterstockinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
/** 
 * 描述: TODO<br>
 * @author ZhouYan
 * @date 2016年9月19日  
 */
@Service
public class AlterStockInfoHisServiceImpl extends MyBatisServiceSupport implements IAlterStockInfoHisService {

	private static final Logger logger = LoggerFactory.getLogger(AlterStockInfoHisServiceImpl.class);

	@Autowired
	private AlterStockInfoHisMapper alterStockInfoHisMapper;
	
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 股权转让历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午6:11:06 
	 * @param : anCheID:年报ID
	 * @return: List<AlterStockInfoHis>
	 * @throws
	 */
	@Override
	public List<AlterStockInfoHis> queryPage(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(AlterStockInfoHis.class);
			//年报ID
			if(searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				List<AlterStockInfoHis>  alterStockInfoHisList= alterStockInfoHisMapper.selectByExample(example);
				if(alterStockInfoHisList.size()>0){
					return alterStockInfoHisList;
				} 
			} 
			return new ArrayList<AlterStockInfoHis>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报股权转让历史信息失败!");
            throw new BusinessException("根据年报ID查询公示  年报股权转让历史信息失败!");
		}
	}
	
	
	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}



	/** 
	 * 描述: 保存公示股权转让历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param flterStockInfoHis
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(AlterStockInfoHis flterStockInfoHis) throws Exception {
		return alterStockInfoHisMapper.insert(flterStockInfoHis);
	}



	/**
	 * 
	 * 描述   根据年报ID和年报编码查询历史信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午6:06:53 
	 * @param 
	 * @return List<AlterStockInfoHis>
	 * @throws
	 */
 
	@Override
	public List<AlterStockInfoHis> selectAlterStockInfoHisByAnCheIDAndreportNo(
			String anCheID, String reportNo) throws Exception {
		AlterStockInfoHis  alterStockInfoHis =new AlterStockInfoHis();
		alterStockInfoHis.setAnCheID(anCheID);
		alterStockInfoHis.setReportNo(reportNo); 
		return alterStockInfoHisMapper.select(alterStockInfoHis);
	}
	
}