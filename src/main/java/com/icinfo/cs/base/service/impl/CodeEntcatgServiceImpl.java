/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeEntcatgMapper;
import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_code_entcatg 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Service
public class CodeEntcatgServiceImpl extends MyBatisServiceSupport implements ICodeEntcatgService {

    @Autowired
    CodeEntcatgMapper codeEntcatgMapper;

    @Override
    public List<CodeEntcatg> selectAll() {
        return codeEntcatgMapper.selectAll();
    }
    @Override
    public CodeEntcatg selectByCode(String code){
    	Example example=new Example(CodeEntcatg.class);
        example.createCriteria().andEqualTo("code", code);
        List<CodeEntcatg> list=codeEntcatgMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
        	return list.get(0);
        }else{
        	return null;
        }
    }
    
	@Override
	public List<Map<String, Object>> selectToTreeMap(Map<String, Object> map) {
		 
		return codeEntcatgMapper.selectToTreeMap(map);
	}

	@Override
	public List<Map<String, Object>> selectToTreeMapNoCheck(Map<String, Object> map) {
		 
		return codeEntcatgMapper.selectToTreeMapNoCheck(map);
	}

	@Override
	public List<CodeEntcatg> selectByCation(List<String> codes) {
		Example example=new Example(CodeEntcatg.class);
		example.createCriteria().andIn("code", codes);
		return codeEntcatgMapper.selectByExample(example);
		 
	}

	@Override
	public List<CodeEntcatg> selectByCationNotIn(List<String> codes) {
		// TODO Auto-generated method stub
		Example example=new Example(CodeEntcatg.class);
		example.createCriteria().andNotIn("code", codes);
		return codeEntcatgMapper.selectByExample(example);
	}

	@Override
	public List<Map<String, Object>> selectToTreeMapLimit(Map<String,Object> qryMap) {
		return codeEntcatgMapper.selectToTreeMapLimit(qryMap);
	}
	
	@Override
	public List<Map<String, Object>> selectToTreeMapByType(String type,String content) {
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("supcode", type);
		qryMap.put("content", content);
		return codeEntcatgMapper.selectToTreeMapByType(qryMap);
	}
	
	/**
	 * 
	 * 描述: 根据企业大类型获取树结构
	 * 
	 * @author zhuyong
	 * @date 2017年3月6日
	 * @return
	 */
	public List<Map<String, Object>> selectToTreeMapByIndType(String indType){
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("indType", indType);
		return codeEntcatgMapper.selectToTreeMapByIndType(qryMap);
	}

}