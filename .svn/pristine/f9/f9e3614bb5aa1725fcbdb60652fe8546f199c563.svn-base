/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubDeptScitemDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_dept_scitem 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
public interface IPubDeptScitemService extends BaseService {
	/**
	 * 
	 * 描述: 查询for树状结构
	 * @auther ljx
	 * @date 2016年11月1日 
	 * @return
	 */
	List<Map<String, Object>> selectToTreeMap(String deptCode);
	
	/**
     * 描述：修改实施部门检查科目
     * @author chenxin
     * @date 2016-11-15
     * @param pubDeptScitemDto
     * @return
     * @throws Exception
     */
    public boolean saveDeptScitem(PubDeptScitemDto pubDeptScitemDto)throws Exception;
}