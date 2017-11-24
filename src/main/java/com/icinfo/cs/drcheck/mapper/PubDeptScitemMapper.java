/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月01日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.model.PubDeptScitem;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_dept_scitem 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
public interface PubDeptScitemMapper extends Mapper<PubDeptScitem> {
	/**
	 * 
	 * 描述: 查询for树状结构
	 * @auther ljx
	 * @date 2016年11月1日 
	 * @return
	 */
	List<Map<String, Object>> selectToTreeMap(String deptCode);

	/**
	 * 描述： 批量插入
	 * @author chenxin
	 * @date 2016-11-04
	 * @param list
	 * @return
	 * @throws Exception
	 */
	int insertBatch(List<PubDeptScitem> list)throws Exception;
}