/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.mapper.CsAttachmentEstateMapper;
import com.icinfo.cs.es.model.CsAttachmentEstate;
import com.icinfo.cs.es.service.ICsAttachmentEstateService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_attachment_estate 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月09日
 */
@Service
public class CsAttachmentEstateServiceImpl extends MyBatisServiceSupport implements ICsAttachmentEstateService {
	@Autowired
	private CsAttachmentEstateMapper csAttachmentEstateMapper;
	
	@Override
	public List<CsAttachmentEstate> selectCsAttachmentEstateListByPriPID(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsAttachmentEstate.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("priPID", request.getParams().get("priPID").toString());
		return csAttachmentEstateMapper.selectByExample(example);
	}
	
	@Override
	public List<CsAttachmentEstate> selectCsAttachmentEstateListByCerNO(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsAttachmentEstate.class);
		Example.Criteria criteria = example.createCriteria();
		//criteria.andEqualTo("cerNO", "111");
		criteria.andEqualTo("cerNO", request.getParams().get("cerNO").toString());
		return csAttachmentEstateMapper.selectByExample(example);
	}
}