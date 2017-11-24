/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.ForinvestMentDto;
import com.icinfo.cs.yr.mapper.ForinvestMentMapper;
import com.icinfo.cs.yr.model.ForinvestMent;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.service.IForinvestMentService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_forinvestment 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class ForinvestMentServiceImpl extends MyBatisServiceSupport implements IForinvestMentService {
	private static final Logger logger = LoggerFactory.getLogger(ForinvestMentServiceImpl.class);

	@Autowired
	private ForinvestMentMapper forinvestMentMapper;

	/**
	 * 
	 * 描述 : 根据年报ID分页查询 公示 对外投资 @author: 赵祥江 @date : 2016年9月9日 下午3:55:12 @param :
	 * anCheID:年报ID @return: List<ForinvestMent> @throws
	 */
	@Override
	public List<ForinvestMent> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap = request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example = this.getExample(Subcapital.class);
			// 年报ID
			if (searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)) {
				example.createCriteria().andEqualTo(Constants.CS_ANCHEID,
						searchMap.get(Constants.CS_ANCHEID).toString());
				return forinvestMentMapper.selectByExample(example);
			}
			return new ArrayList<ForinvestMent>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  对外投资信息失败!");
			throw new BusinessException("根据年报ID查询公示  对外投资失败!");
		}
	}

	/**
	 * 
	 * 描述 : 根据年报ID获取对外投资不分页 @author: 赵祥江 @date : 2016年9月19日 下午2:23:27 @param
	 * : @return: List<ForinvestMent> @throws
	 */
	public List<ForinvestMent> selectForinvestMentByAnCheID(String anCheID) throws Exception {
		try {
			ForinvestMent forinvestMent = new ForinvestMent();
			forinvestMent.setAnCheID(anCheID);
			return forinvestMentMapper.select(forinvestMent);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID获取对外投资不分页 失败!");
			throw new BusinessException("根据年报ID获取对外投资不分页 失败!");
		}
	}

	private Example getExample(Class<?> classObj) {
		Example example = new Example(classObj);
		return example;
	}

	/**
	 * 描述: 根据年报id删除公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = this.getExample(ForinvestMent.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return forinvestMentMapper.deleteByExample(example);
	}

	/**
	 * 描述: 根据年报id保存公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertByAnCheID(String anCheID) throws Exception {
		return forinvestMentMapper.insertByAnCheID(anCheID);
	}

	/**
	 * 
	 * 描述: 公示侧对外投资信息查询（过滤敏感词）
	 * 
	 * @auther chenyl
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 */
	@Override
	public List<ForinvestMentDto> queryPageForPub(PageRequest request) {
		Map<String, Object> searchMap = request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		// 年报ID
		if (searchMap != null && searchMap.containsKey(Constants.CS_ANCHEID)) {
			List<ForinvestMentDto> forinvestMentList = forinvestMentMapper.selectForinvestMentForPub(searchMap);
			if (forinvestMentList.size() > 0) {
				return forinvestMentList;
			}
		}
		return new ArrayList<ForinvestMentDto>();
	}

	@Override
	public List<ForinvestMentDto> queryListResult(String anCheID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("anCheID", anCheID);
		List<ForinvestMentDto> forinvestMentDtoList = forinvestMentMapper.selectForinvestMentForPub(queryMap);
		return forinvestMentDtoList;
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param forinvestMent
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(ForinvestMent forinvestMent) throws Exception {
		return forinvestMentMapper.insert(forinvestMent);
	}
	
}