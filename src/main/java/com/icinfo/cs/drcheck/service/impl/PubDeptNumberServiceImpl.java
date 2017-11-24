/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.mapper.PubDeptNumberMapper;
import com.icinfo.cs.drcheck.model.PubDeptNumber;
import com.icinfo.cs.drcheck.service.IPubDeptNumberService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:  cs_pub_dept_number 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月13日
 */
@Service
public class PubDeptNumberServiceImpl extends MyBatisServiceSupport implements IPubDeptNumberService {

    @Autowired
    private PubDeptNumberMapper pubDeptNumberMapper;

	@Override
	public PubDeptNumber selectByDeptCode(String deptCode) { 
		Example example=new Example(PubDeptNumber.class); 
		example.setOrderByClause("id desc");
		example.createCriteria().andEqualTo("deptCode",deptCode).andEqualTo("year",DateUtils.getYear());  
		PubDeptNumber pubDeptNumber=new PubDeptNumber();
		List<PubDeptNumber> list=pubDeptNumberMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			pubDeptNumber=list.get(0);
		}
		return pubDeptNumber;
	}

	@Override
	public int saveDeptNumber(PubDeptNumber pubDeptNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
}