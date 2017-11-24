/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月18日
 * @version 2.0
 */
package com.icinfo.cs.base.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_code_license 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface CodeDzLicenseMapper extends Mapper<CodeDzLicense> {
	/**
	 * 描述   根据审批事项编码或名称查询后置审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午3:30:27 
	 * @param 
	 * @return List<CodeLicense>
	 * @throws
	 */
	public List<CodeDzLicense> selectCodeLicenseListByExaCodeOrExaName(Map<String,Object> queryMap);
	
	/**
	 * 
	 * 描述   分页查询后置审批事项
	 * @author 赵祥江
	 * @date 2016年11月18日 下午1:44:26 
	 * @param 
	 * @return List<CodeLicense>
	 * @throws
	 */
	public List<CodeDzLicense> selectCodeLicenseSearchList(Map<String,Object> queryMap);
	
	
    /**
     * 
     * 描述:  根据审批事项编码或名称查询审批事项
     * @auther gaojinling
     * @date 2016年11月22日 
     * @param queryMap
     * @return
     */
	public List<CodeDzLicense> selectLicenseList(Map<String,Object> queryMap);
	
}