/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年08月01日
 * @version 2.0
 */
package com.icinfo.cs.deptpubinfo.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.deptpubinfo.dto.DeptPubInfoDto;
import com.icinfo.cs.deptpubinfo.model.DeptPubInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年08月01日
 */
public interface DeptPubInfoMapper extends Mapper<DeptPubInfo> {
	
	/** 
	 * 描述: 获取部门公示信息列表
	 * @auther ZhouYan
	 * @date 2017年8月1日 
	 * @param params
	 * @return 
	 */
	List<DeptPubInfoDto> selectDeptPubInfoList(Map<String, Object> params);
}