package com.icinfo.cs.es.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.es.service.IEntPubOtherlicenceService;
import com.icinfo.cs.other.mapper.PubOtherlicenceMapper;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

@Service("entPubOtherlicenceService")
public class EntPubOtherlicenceServiceImpl implements IEntPubOtherlicenceService {

	@Autowired
	private PubOtherlicenceMapper pubOtherlicenceMapper;
	
	@Override
	public List<PubOtherlicence> queryList(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOtherlicenceMapper.selectAll();
	}

}
