/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeSliceno;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_code_sliceno 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface ICodeSlicenoService extends BaseService {

    /**
     * 获取所有的片区商圈
     * @return
     */
    List<CodeSliceno> selectAll();

	List<Map<String, Object>> selectToNoLeafTreeMap();
    /**
     * 
     * 描述: 查询for树状结构
     * @auther ljx
     * @date 2016年11月2日 
     * @return
     */
	public List<Map<String,Object>>selectToTreeMap(Map param);
	
	/**
	 * 
	 * 描述: 只能选择片区查询
	 * @auther ljx
	 * @date 2016年11月2日 
	 * @return
	 */
    public List<Map<String,Object>>	selectToTreeNoCheckMap(Map param);
	
	
	/**
	 * 描述: 获取片区商圈维护树形数据
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return List<CodeSliceno>
	 * @throws Exception
	 */
	public List<CodeSliceno> selectListForTree(Map<String, Object> param) throws Exception;
	
	/**
	 * 描述: 获取单条片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return CodeSliceno
	 * @param code
	 * @throws Exception
	 */
	public CodeSliceno selectCodeSlicenoInfo(String code) throws Exception;
	
	/**
	 * 描述: 获取单条片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return CodeSliceno
	 * @param code
	 * @throws Exception
	 */
	public CodeSliceno selectCodeSlicenoInfoBySup(String code) throws Exception;
	
	/**
	 * 描述: 添加或修改片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return boolean
	 * @param codeSliceno
	 * @throws Exception
	 */
	public boolean doAddOrEditInfo(CodeSliceno codeSliceno) throws Exception;
	
	/**
	 * 描述: 删除片区商圈信息
	 * @auther yujingwei
	 * @date 2016年9月21日 
	 * @return int
	 * @param code
	 * @throws Exception
	 */
	public int deleteSliceInfoBycode(String code) throws Exception;

    List<CodeSliceno> getSlicenoBynode(CodeSliceno codeSliceno);

	/**
	 * 查询省级片区
	 * @param nocheck 是否设置父级不可选
	 * @author ZhuDefeng
	 * @date 2017-01-12
	 * @return
	 */
	List<Map<String,Object>> selectProv(String nocheck);
}