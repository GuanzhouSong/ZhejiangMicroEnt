/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeSlicenoMapper;
import com.icinfo.cs.base.model.CodeSliceno;
import com.icinfo.cs.base.service.ICodeSlicenoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_code_sliceno 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Service
public class CodeSlicenoServiceImpl extends MyBatisServiceSupport implements ICodeSlicenoService {
    @Autowired
    CodeSlicenoMapper codeSlicenoMapper;

    @Override
    public List<CodeSliceno> selectAll() {
        return codeSlicenoMapper.selectAll();
    }

	@Override
	public List<Map<String, Object>> selectToNoLeafTreeMap() {
		return codeSlicenoMapper.selectToNoLeafTreeMap();
	}@Override
	public List<CodeSliceno> getSlicenoBynode(CodeSliceno codeSliceno) {
		return codeSlicenoMapper.select(codeSliceno);
	}


	@Override
	public List<Map<String, Object>> selectToTreeMap(Map param) {
		 
		return codeSlicenoMapper.selectToTreeMap(param);
	}
	
	
	/**
	 * 描述: 获取片区商圈维护树形数据
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return List<CodeSliceno>
	 * @throws Exception
	 */
	public List<CodeSliceno> selectListForTree(Map<String, Object> param) throws Exception{
		return codeSlicenoMapper.selectListForTree(param);
	}
	
	/**
	 * 描述: 通过Code获取单条片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return CodeSliceno
	 * @param code
	 * @throws Exception
	 */
	public CodeSliceno selectCodeSlicenoInfo(String code) throws Exception{
		CodeSliceno codeSliceno = new CodeSliceno();
		codeSliceno.setCode(code);
		return codeSlicenoMapper.selectOne(codeSliceno);
	}
	
	/**
	 * 描述: 通过supCode获取单条片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return CodeSliceno
	 * @param code
	 * @throws Exception
	 */
	public CodeSliceno selectCodeSlicenoInfoBySup(String supCode) throws Exception{
		CodeSliceno codeSliceno = new CodeSliceno();
		codeSliceno.setSupCode(supCode);
		return codeSlicenoMapper.selectOne(codeSliceno);
	}
	
	/**
	 * 描述: 添加或修改片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return boolean
	 * @param codeSliceno
	 * @throws Exception
	 */
	public boolean doAddOrEditInfo(CodeSliceno codeSliceno) throws Exception{
		if(codeSliceno.getId() !=null){
			if(codeSlicenoMapper.updateByPrimaryKeySelective(codeSliceno) < 0){
				return false;
			}
		}else{
			if(codeSlicenoMapper.insert(codeSliceno) < 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 描述: 删除片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return int
	 * @param code
	 * @throws Exception
	 */
	public int deleteSliceInfoBycode(String code) throws Exception{
		Example example = new Example(CodeSliceno.class);
		example.createCriteria().andEqualTo("code", code);
		return codeSlicenoMapper.deleteByExample(example);
	}

	@Override
	public List<Map<String, Object>> selectToTreeNoCheckMap(Map param) {
		return codeSlicenoMapper.selectToTreeNoCheckMap(param);
	}

	/**
	 * 查询省级片区
	 *
	 * @return
	 * @author ZhuDefeng
	 * @date 2017-01-12
	 */
	@Override
	public List<Map<String, Object>> selectProv(String nocheck) {
		return codeSlicenoMapper.selectProv();
	}
}