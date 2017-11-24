/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.service.impl;

import com.icinfo.cs.risk.mapper.CsWarnDeptMapper;
import com.icinfo.cs.risk.model.CsWarnDept;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.ICsWarnDeptService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 描述:    cs_warn_dept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
@Service
public class CsWarnDeptServiceImpl extends MyBatisServiceSupport implements ICsWarnDeptService {
	
	@Autowired
	CsWarnDeptMapper csWarnDeptMapper;
	/**
	 * 指定部门插入关联表
	 * @author zjj
	 * 20161021
	 */
	public void insertDept(CsWarnMark csWarnMark,String type) throws Exception{
		Example example = new Example(CsWarnDept.class);
		example.createCriteria().andEqualTo("warnNo", csWarnMark.getMarkNo());
		csWarnDeptMapper.deleteByExample(example);
		CsWarnDept csWarnDept = new CsWarnDept();
		csWarnDept.setWarnNo(csWarnMark.getMarkNo());
		csWarnDept.setType(type);
		//对内提示
		if(csWarnMark.getMarkAppointWay().equals("0")){
			csWarnDept.setDeptCode(csWarnMark.getMarkSetDeptCode());
			csWarnDeptMapper.insert(csWarnDept);
		}
		//部门共享
		if(csWarnMark.getMarkAppointWay().equals("1")){
			if(!StringUtils.isEmpty(csWarnMark.getMarkAppointDeptCode())){
				String[] codeArr = csWarnMark.getMarkAppointDeptCode().split(",");
				for(String str : codeArr){
					csWarnDept.setDeptCode(str);
					csWarnDeptMapper.insert(csWarnDept);
				}
			}
			//插入本部门编号
			csWarnDept.setDeptCode(csWarnMark.getMarkSetDeptCode());
		    csWarnDeptMapper.insert(csWarnDept);
		}
	    //公共发布
	    if(csWarnMark.getMarkAppointWay().equals("2"))	csWarnDeptMapper.insert(csWarnDept);
	}
}