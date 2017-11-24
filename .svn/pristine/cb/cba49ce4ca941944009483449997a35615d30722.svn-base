/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeRegunitMapper;
import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_regunit 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Service
public class CodeRegunitServiceImpl extends MyBatisServiceSupport implements ICodeRegunitService {
    @Autowired
    CodeRegunitMapper codeRegunitMapper;

    @Override
    public List<CodeRegunit> selectAll() {
        return codeRegunitMapper.selectAll();
    }
    
    /**
     * 描述:获取所有的管辖单位(排序)
     * @author chenxin
     * @date 2016-09-12
     * @return List<CodeRegunit>
     */
    @Override
    public List<CodeRegunit> selectCodeRegunitAll() {
    	
    	return codeRegunitMapper.selectCodeRegunitAll();
    }

	@Override
	public List<Map<String, Object>> selectToTreeMap(Map param) {
		 
		return codeRegunitMapper.selectToTreeMap(param);
	}

	@Override
	public List<Map<String, Object>> selectToTreeNoCheckMap(Map param) {
		// TODO Auto-generated method stub
		return codeRegunitMapper.selectToTreeNoCheckMap(param);
	}
	/**
     * 描述:通过管辖单位编码查询内容
     * @author yujingwei
     * @param code
     * @date 2016-09-12
     * @return CodeRegunit
     */
    public CodeRegunit selectCodeRegunitInfo(String code) throws Exception{
    	CodeRegunit codeRegunit = new CodeRegunit();
    	codeRegunit.setCode(code);
    	return codeRegunitMapper.selectOne(codeRegunit);
    }

	/**
	 * 查询省级的关系啊单位
	 *
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 * @date 2017-01-11
	 */
	@Override
	public List<Map<String, Object>> selectProv(String nocheck,String content) throws Exception {
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("nocheck",nocheck);
		map.put("content", content);
		return codeRegunitMapper.selectProv(map);
	}

	/**
	 * 获取地区（省、市）
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> selectArea(Map<String, Object> map) throws Exception {
		return codeRegunitMapper.selectArea(map);
	}

	/**
	 * 描述：根据当前部门编码查询上级部门信息
	 * 
	 * @author chenxin
	 * @date 2017-10-16
	 * @param deptCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public CodeRegunit selectByPCode(String deptCode) throws Exception {
		CodeRegunit codeRegunit = selectCodeRegunitInfo(deptCode);
		String pCode = codeRegunit.getSupCode();
		return selectCodeRegunitInfo(pCode);
	}
}