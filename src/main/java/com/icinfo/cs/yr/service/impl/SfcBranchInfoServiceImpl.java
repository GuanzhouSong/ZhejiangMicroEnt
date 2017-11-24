/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.SfcBranchInfoDto;
import com.icinfo.cs.yr.mapper.SfcBranchInfoMapper;
import com.icinfo.cs.yr.model.SfcBranchInfo;
import com.icinfo.cs.yr.service.ISfcBranchInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_branchinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcBranchInfoServiceImpl extends MyBatisServiceSupport implements ISfcBranchInfoService {
	private static final Logger logger = LoggerFactory.getLogger(SfcBranchInfoServiceImpl.class);
	@Autowired
	private SfcBranchInfoMapper sfcBranchInfoMapper;
	
	/**
	 * 
	 * 描述   根据年报ID查询分支机构信息 
	 * @author  赵祥江
	 * @date 2016年10月8日 下午3:37:27 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SfcBranchInfo> selectSfcBranchInfoByAnCheID(String anCheID)
			throws Exception {
		try {
			SfcBranchInfo sfcBranchInfo=new SfcBranchInfo();
			sfcBranchInfo.setAnCheID(anCheID);
 			return sfcBranchInfoMapper.select(sfcBranchInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询分支机构信息失败!");
            throw new BusinessException("根据年报ID查询分支机构信息失败!");
		}
	}

	@Override
	public List<SfcBranchInfoDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sfcBranchInfoMapper.queryPageResult(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 根据年报id删除公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int deleteByAnCheID(String anCheID) throws Exception{
		Example example = new Example(SfcBranchInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return sfcBranchInfoMapper.deleteByExample(example);
	}
	
	/**
	 * 
	 * 描述: 根据年报id保存公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int insertByAnCheID(String anCheID) throws Exception{
		return sfcBranchInfoMapper.insertByAnCheID(anCheID);
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param sfcBranchInfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(SfcBranchInfo sfcBranchInfo) throws Exception {
		return sfcBranchInfoMapper.insert(sfcBranchInfo);
	}
	
}