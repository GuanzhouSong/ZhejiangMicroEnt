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
import com.icinfo.cs.yr.dto.AlterStockInfoDto;
import com.icinfo.cs.yr.mapper.AlterStockInfoMapper;
import com.icinfo.cs.yr.model.AlterStockInfo;
import com.icinfo.cs.yr.service.IAlterStockInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_alterstockinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class AlterStockInfoServiceImpl extends MyBatisServiceSupport implements IAlterStockInfoService {

	private static final Logger logger = LoggerFactory.getLogger(AlterStockInfoServiceImpl.class);

	@Autowired
	private AlterStockInfoMapper alterStockInfoMapper;
	
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 股权转让信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<AlterStockInfo>
	 * @throws
	 */
	@Override
	public List<AlterStockInfo> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(AlterStockInfo.class);
			//年报ID
			if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
				example.createCriteria()
				.andEqualTo(Constants.CS_ANCHEID, searchMap.get(Constants.CS_ANCHEID).toString());
				return alterStockInfoMapper.selectByExample(example);
			} 
			return new ArrayList<AlterStockInfo>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报股权转让信息失败!");
            throw new BusinessException("根据年报ID查询公示  年报股权转让信息失败!");
		}
	}
	
	/**
	 * 
	 * 描述             : 根据年报ID查询 公示 股权转让信息 不分页
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午3:51:59 
	 * @param :
	 * @return: List<AlterStockInfo>
	 * @throws
	 */
	@Override
	public List<AlterStockInfo> selectAlterStockInfoByAnCheID(String anCheID)
			throws Exception {
		try {
			AlterStockInfo alterStockInfo=new AlterStockInfo();
			alterStockInfo.setAnCheID(anCheID);
			return alterStockInfoMapper.select(alterStockInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报股权转让信息失败!");
            throw new BusinessException("根据年报ID查询公示  年报股权转让信息失败!");
		}
	}
	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}

	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example=this.getExample(AlterStockInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return alterStockInfoMapper.deleteByExample(example);
	}

	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insertByAnCheID(String anCheID) throws Exception {
		return alterStockInfoMapper.insertByAnCheID(anCheID);
	}

	/**
	 * 
	 * 描述: 公示侧查询股权转让信息（需要过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 */
	@Override
	public List<AlterStockInfoDto> queryPageForPub(PageRequest request) {
		Map<String, Object> searchMap=  request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		//年报ID
		if(searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)){
			List<AlterStockInfoDto>  alterStockInfoList= alterStockInfoMapper.selectAlterStockInfoForPub(searchMap);
			if(alterStockInfoList.size()>0){
				return alterStockInfoList;
			} 
		} 
		return new ArrayList<AlterStockInfoDto>();
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param flterStockInfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(AlterStockInfo flterStockInfo) throws Exception {
		return alterStockInfoMapper.insert(flterStockInfo);
	}
	

}