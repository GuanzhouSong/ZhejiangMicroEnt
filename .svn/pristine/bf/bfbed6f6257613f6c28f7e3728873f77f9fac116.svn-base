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

import com.icinfo.cs.base.model.CodeSliceno;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_sliceno 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface CodeSlicenoMapper extends Mapper<CodeSliceno> {
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
	 * 描述: 只能选择片区查询
	 * @auther ljx
	 * @date 2016年11月2日 
	 * @return
	 */
    public List<Map<String,Object>>	selectToTreeNoCheckMap(Map param);
    
	
	public List<CodeSliceno> selectListForTree(Map<String, Object> param);

	List<Map<String,Object>> selectToNoLeafTreeMap();

	/**
	 * 查询省级片区
	 * @author ZhuDefeng
	 * @date 2017-01-12
	 * @return
	 */
	List<Map<String,Object>> selectProv();
	
}