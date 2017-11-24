/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月10日
 * @version 2.0
 */
package com.icinfo.cs.base.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_regunit 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface CodeRegunitMapper extends Mapper<CodeRegunit> {
	/**
	 * 
	 * 描述: 获取登记机关列表list（排序）
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return List<ModApplicationDto>
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
	 * 获取省级的管辖单位
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> selectProv(Map<String, Object> map)throws Exception;


	/**
	 * 获取地区（省、市）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> selectArea(Map<String, Object> map)throws Exception;
	
}
