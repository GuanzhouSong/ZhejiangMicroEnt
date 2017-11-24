/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月12日
 * @version 2.0
 */
package com.icinfo.cs.base.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_regorg 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
public interface CodeRegorgMapper extends Mapper<CodeRegorg> {
	/**
	 * 
	 * 描述: 获取登记机关列表list
	 * @auther chenxin
	 * @date 2016-09-11
	 * @return List<ModApplicationDto>
	 */
	public List<CodeRegorg> selectCodeRegorgAll();
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
	 * 描述: 查询for树状结构只选择最后一级
	 * @auther ljx
	 * @date 2016年11月2日 
	 * @return
	 */
	public List<Map<String,Object>> selectToTreeNocheckMap(Map param);
	
	/**
	 * 
	 * 描述: 双告知登记机关联络员维护 查询列表
	 * @auther gaojinling
	 * @date 2016年11月15日 
	 * @param map
	 * @return
	 */
	public List<CodeRegorg> selectRegOrgCodeListJSON(Map<String, Object> map) throws Exception;

	/**
	 * 查询省级登记机关
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 * @date 2017-01-13
	 */
    List<Map<String,Object>> selectProv(Map<String, Object> map) throws Exception;
    
    /**
	 * 描述: 杭州地区查询树状结构展示
	 * @auther baifangfang
	 * @date 2017年4月26日 
	 * @return
	 */
	public List<Map<String, Object>> selectToTreeMapHZ(Map param);
	
	/**
	 * 描述: 根据编号查询登记机关编码
	 * @auther baifangfang
	 * @date 2017年4月26日 
	 * @return
	 */
	public List<CodeRegorg> selectRegOrgByCodes(Map<String, Object> qryMap);

}