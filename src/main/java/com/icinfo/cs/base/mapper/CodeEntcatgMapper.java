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

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_code_entcatg 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface CodeEntcatgMapper extends Mapper<CodeEntcatg> {
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
	 * 描述:查询for树状机构展示只选小类+
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
	public List<Map<String, Object>> selectToTreeMapLimit(Map<String,Object> qryMap);

	/**
	 * 
	 * 描述: 根据企业大类查询企业类型
	 * 
	 * @auther baifangfang
	 * @date 2017年3月23日
	 * @return
	 */
	public List<Map<String, Object>> selectToTreeMapByType(Map<String, Object> qryMap);
	
	
	/**
	 * 
	 * 描述: 根据企业大类型获取树结构
	 * 
	 * @author zhuyong
	 * @date 2017年3月6日
	 * @return
	 */
	public List<Map<String, Object>> selectToTreeMapByIndType(Map<String,Object> qryMap);

}