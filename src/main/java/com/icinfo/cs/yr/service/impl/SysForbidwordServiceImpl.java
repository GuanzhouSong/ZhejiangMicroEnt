/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.SysForbidwordMapper;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.service.ISysForbidwordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_sys_forbidword 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
@Service
public class SysForbidwordServiceImpl extends MyBatisServiceSupport implements ISysForbidwordService {
	@Autowired
	SysForbidwordMapper sysForbidwordMapper;

	@Override
	public List<SysForbidword> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sysForbidwordMapper.queryPageResult(request.getParams());
	}

	@Override
	public SysForbidword doGetSysForbidWordById(Integer sysForbidwordId) {
		return sysForbidwordMapper.selectByPrimaryKey(sysForbidwordId);
	}

	@Override
	public int update(SysForbidword sysForbidword) {
		return sysForbidwordMapper.updateByPrimaryKeySelective(sysForbidword);
	}

	@Override
	public int insert(SysForbidword sysForbidword) {
		return sysForbidwordMapper.insert(sysForbidword);
	}

	@Override
	public int deleteById(Integer sysForbidwordId) {
		return sysForbidwordMapper.deleteByPrimaryKey(sysForbidwordId);
	}

	/** 
	 * 描述: 获取缓存列表：敏感词校验用
	 * @auther ZhouYan
	 * @date 2016年9月14日 
	 * @return 
	 */
	@Override
	public List<SysForbidword> doGetListForCache() {
		Example example = new Example(SysForbidword.class); 
		example.createCriteria().andEqualTo("isValid", 1); 
		List<SysForbidword> list = sysForbidwordMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<SysForbidword> findSysForbidBySearchKeyWord(String searchKeyWord) {
		return sysForbidwordMapper.findSysForbidByBanLetter(searchKeyWord);
	}

	/**
	 * 判断是否存在敏感词
	 *
	 * @param content
	 * @return
	 * @author ZhuDefeng
	 * @date 2016-11-18
	 */
	@Override
	public boolean isContainForbidWord(String content) {
		boolean sentiveFlag = false;
		List<SysForbidword> sysForbidwordList = doGetListForCache();
		//过滤掉所有特殊字符
		content = StringUtil.StringFilter(content);
		for (SysForbidword sysForbidword : sysForbidwordList) {
			if (content.indexOf(sysForbidword.getBanLetter()) != -1) {
				sentiveFlag=true;
				break;
			}
		}
		return sentiveFlag;
	}
}