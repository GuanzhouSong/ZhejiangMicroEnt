/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述: cs_code_entcatg 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface ICodeEntcatgService extends BaseService {

	/**
	 * 获取全部的企业类型大类
	 * 
	 * @param request
	 * @return
	 */
	List<CodeEntcatg> selectAll();

	/**
	 * 
	 * 描述: 更多条件查询in
	 * 
	 * @auther ljx
	 * @date 2016年11月8日
	 * @param codes
	 * @return
	 */
	List<CodeEntcatg> selectByCation(List<String> codes);

	List<CodeEntcatg> selectByCationNotIn(List<String> codes);

	/**
	 * 
	 * 描述: 查询to树状结构
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @return
	 */
	public List<Map<String, Object>> selectToTreeMap(Map<String, Object> map);

	/**
	 * 
	 * 描述: 只选小类
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @return
	 */
	public List<Map<String, Object>> selectToTreeMapNoCheck(Map<String, Object> map);

	/**
	 * 
	 * 描述: 查询to树状结构(企业大类除集团)
	 * 
	 * @auther baifangfang
	 * @date 2017年1月6日
	 * @return
	 */
	List<Map<String, Object>> selectToTreeMapLimit(Map<String,Object> qryMap);

	CodeEntcatg selectByCode(String code);

	/**
	 * 
	 * 描述: 根据企业大类查询企业类型树状结构
	 * 
	 * @auther baifangfang
	 * @date 2017年3月6日
	 * @return
	 */
	List<Map<String, Object>> selectToTreeMapByType(String type,String content);
	
	/**
	 * 
	 * 描述: 根据企业大类型获取树结构
	 * 
	 * @author zhuyong
	 * @date 2017年3月6日
	 * @return
	 */
	List<Map<String, Object>> selectToTreeMapByIndType(String indType);

}