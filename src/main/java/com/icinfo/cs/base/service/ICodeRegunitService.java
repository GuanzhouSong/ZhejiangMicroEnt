/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_regunit 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface ICodeRegunitService extends BaseService {

    /**
     * 获取所有的管辖单位
     * @return
     */
    List<CodeRegunit> selectAll();
    
    /**
     * 描述:获取所有的管辖单位(排序)
     * @author chenxin
     * @date 2016-09-12
     * @return List<CodeRegunit>
     */
    public List<CodeRegunit> selectCodeRegunitAll();
    
    /**
	 * 
	 * 描述: 查询for树状机构展示
	 * @auther ljx
	 * @date 2016年10月18日 
	 * @return
	 */
	public List<Map<String,Object>>selectToTreeMap(Map param);
	
	/**
	 * 
	 * 描述: 只选择最后一级
	 * @auther ljx
	 * @date 2016年11月2日 
	 * @return
	 */
	public List<Map<String,Object>> selectToTreeNoCheckMap(Map param);
	
	
	/**
     * 描述:通过管辖单位编码查询内容
     * @author yujingwei
     * @param code
     * @date 2016-09-12
     * @return CodeRegunit
     */
    public CodeRegunit selectCodeRegunitInfo(String code) throws Exception;


	/**
	 * 查询省级的管辖单位
	 * @param nocheck 是否设置父级不可选
	 * @author ZhuDefeng
	 * @date 2017-01-11
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> selectProv(String nocheck,String content)throws Exception;


	/**
	 * 获取地区（省、市）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> selectArea(Map<String, Object> map)throws Exception;

	/**
	 * 描述：根据当前部门编码查询上级部门信息
	 * 
	 * @author chenxin
	 * @date 2017-10-16
	 * @param deptCode
	 * @return
	 * @throws Exception
	 */
	public CodeRegunit selectByPCode(String deptCode)throws Exception;
}