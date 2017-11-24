/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.mapper.CsPatentiInfoMapper;
import com.icinfo.cs.es.model.CsPatentiInfo;
import com.icinfo.cs.es.service.ICsPatentiInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_patentinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
@Service
public class CsPatentiInfoServiceImpl extends MyBatisServiceSupport implements ICsPatentiInfoService {
	@Autowired
	private CsPatentiInfoMapper csPatentiInfoMapper;
	/**
	 * 根据priPID获取企业专利信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CsPatentiInfo> selectCsPatentiInfoListByPriPID(PageRequest request) {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsPatentiInfo.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID").toString());
		return csPatentiInfoMapper.selectByExample(example);
	}
}