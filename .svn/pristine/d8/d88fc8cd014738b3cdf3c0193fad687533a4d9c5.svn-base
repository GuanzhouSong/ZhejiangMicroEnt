/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月21日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_dept_dutycode_ref 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
public interface DeptDutycodeRefMapper extends Mapper<DeptDutycodeRef> {
	
	/**
	 * 
	 * 描述   根据adCod的前九位和职能编码查询
	 * @author 赵祥江
	 * @date 2016年11月25日 下午4:33:45 
	 * @param 
	 * @return DeptDutycodeRef
	 * @throws
	 */
	public List<DeptDutycodeRef> selectDeptDutycodeRefByAdCodeSubDutyDeptCode(Map<String,Object> queryMap);

	/**
	 * 获取当前节点下的最大的AdCode部门信息
	 * @author ZhuDefeng
	 * @date 2016-11-29
	 * @param orgCoding
	 * @return
	 * @throws Exception
	 */
	String getMaxAdCode(String orgCoding)throws Exception;


	/**
	 * 获取当前节点下的最大的OrgCoding部门信息
	 * @author ZhuDefeng
	 * @date 2016-11-29
	 * @param orgCoding
	 * @return
	 * @throws Exception
	 */
	String getMaxOrgCode(String orgCoding)throws Exception;

	/**
	 * 描述：查询部门信息
	 * 
	 * @param params
	 * @return
	 */
	public List<DeptDutycodeRef> selectByName(Map<String, Object> params);
}