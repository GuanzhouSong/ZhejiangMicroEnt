/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service.impl;

import java.util.List;

import com.icinfo.cs.specialrec.mapper.SpecialRecItemMapper;
import com.icinfo.cs.specialrec.model.SpecialRecItem;
import com.icinfo.cs.specialrec.service.ISpecialRecItemService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_special_rec_item 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月03日
 */
@Service
public class SpecialRecItemServiceImpl extends MyBatisServiceSupport implements ISpecialRecItemService {
	
	@Autowired
	private SpecialRecItemMapper specialRecItemMapper;
	
	/**
	 * 描述: 通过uid查询检查事项
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @param resultUid
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecItem> selectSpecialRecItemListByUid(String resultUid) 
			throws Exception{
		Example example = new Example(SpecialRecItem.class);
		example.createCriteria()
		.andEqualTo("resultUid", resultUid);
		return specialRecItemMapper.selectByExample(example);
	}
}