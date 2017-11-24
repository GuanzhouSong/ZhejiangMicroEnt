/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.mapper.CsPubIlldisdetailMapper;
import com.icinfo.cs.es.model.CsPatentiInfo;
import com.icinfo.cs.es.model.CsPubIlldisdetail;
import com.icinfo.cs.es.service.ICsPubIlldisdetailService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_illdisdetail 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月10日
 */
@Service
public class CsPubIlldisdetailServiceImpl extends MyBatisServiceSupport implements ICsPubIlldisdetailService {
	@Autowired
	private CsPubIlldisdetailMapper csPubIlldisdetailMapper;

	@Override
	public List<CsPubIlldisdetail> selectCsPubIlldisDetailListByPriPID(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsPubIlldisdetail.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID").toString());
		return csPubIlldisdetailMapper.selectByExample(example);
	}

	@Override
	public List<CsPubIlldisdetail> selectCsPubIlldisDetailListByCerNO(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsPubIlldisdetail.class);
		example.createCriteria().andEqualTo("cerNO", request.getParams().get("cerNO").toString());
		return csPubIlldisdetailMapper.selectByExample(example);
	}
}