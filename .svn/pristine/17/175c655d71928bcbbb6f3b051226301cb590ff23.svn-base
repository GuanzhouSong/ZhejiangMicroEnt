/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.service.impl;

import com.icinfo.cs.simpleesc.dto.ErEscObjinfoDto;
import com.icinfo.cs.simpleesc.mapper.ErEscObjinfoMapper;
import com.icinfo.cs.simpleesc.model.ErEscObjinfo;
import com.icinfo.cs.simpleesc.service.IErEscObjinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    er_esc_objinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Service
public class ErEscObjinfoServiceImpl extends MyBatisServiceSupport implements IErEscObjinfoService {

	@Autowired
	ErEscObjinfoMapper erEscObjinfoMapper;
	
	@Override
	public List<ErEscObjinfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return erEscObjinfoMapper.queryPageResultByPriPID(request.getParams());
	}

	@Override
	public int saveErEscObjinfo(ErEscObjinfo erEscObjinfo) {
		return erEscObjinfoMapper.insert(erEscObjinfo);
	}

	@Override
	public int deleteErEscObjinfo(ErEscObjinfoDto erEscObjinfo) {
		return erEscObjinfoMapper.delete(erEscObjinfo);
	}
}