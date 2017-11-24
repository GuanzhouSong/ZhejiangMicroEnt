/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.mapper.EBrandInfoMapper;
import com.icinfo.cs.es.model.CsBrandInfo;
import com.icinfo.cs.es.service.IEBrandInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    e_brand_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月06日
 */
@Service
public class CsBrandInfoServiceImpl extends MyBatisServiceSupport implements IEBrandInfoService {
	@Autowired
	private EBrandInfoMapper eBrandInfoMapper;

	/**
	 * 描述：通过priPID查询企业商标信息
	 * @author chenyu
	 * @data 2016-10-31
	 * @param request
	 * @return PubJusticeInfo
	 * @throws Exception
	 */
	@Override
	public List<CsBrandInfo> selectCsBrandInfoListByPriPID(PageRequest request) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(CsBrandInfo.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID").toString());
		//example.createCriteria().andEqualTo("priPID", "123123");
		return eBrandInfoMapper.selectByExample(example);
	}
}