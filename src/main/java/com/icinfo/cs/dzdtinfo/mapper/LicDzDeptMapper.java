/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月19日
 * @version 2.0
 */
package com.icinfo.cs.dzdtinfo.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.dtinfo.dto.LicDeptDto;
import com.icinfo.cs.dtinfo.model.LicDept;
import com.icinfo.cs.dzdtinfo.dto.LicDzDeptDto;
import com.icinfo.cs.dzdtinfo.model.LicDzDept;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_lic_dz_dept 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface LicDzDeptMapper extends Mapper<LicDzDept> {
	
  /**
   * 	
   * 描述   分页查询审批对照
   * @author 赵祥江
   * @date 2016年10月19日 上午11:32:12 
   * @param 
   * @return List<LicDept>
   * @throws
   */
  List<LicDzDeptDto>	selectLicDeptListJSON(Map<String,Object> queryMap);
}