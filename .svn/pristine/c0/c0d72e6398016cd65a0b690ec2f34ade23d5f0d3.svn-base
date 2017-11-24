/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_dz_license 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface ICodeDzLicenseService extends BaseService {
	/**
	 * 
	 * 描述   根据后置审批事项编码查询审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:40:30 
	 * @param 
	 * @return CodeLicense
	 * @throws
	 */
	public CodeDzLicense selectCodeLicenseByExaCode(String exaCode) throws Exception;
	
	/**
	 * 
	 * 描述   根据后置审批事项编码前后置类型查询审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:40:25 
	 * @param 
	 * @return CodeLicense
	 * @throws
	 */
	public CodeDzLicense selectCodeLicenseByExaCodeAndLicType(String exaCode,String licType) throws Exception;


	/**
	 * 
	 * 
	 * 描述   根据前后置类型查询审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:41:22 
	 * @param 
	 * @return List<CodeLicense>
	 * @throws
	 */
    public List<CodeDzLicense> selectCodeLicenseListByLicType(String licType) throws Exception;
    
    /**
     * 
     * 描述   根据后置审批事项名称查询
     * @author 赵祥江
     * @date 2016年11月18日 下午5:20:13 
     * @param 
     * @return List<CodeLicense>
     * @throws
     */
    public List<CodeDzLicense> selectCodeLicenseListByExaName(String exaName) throws Exception;
    
    
    
	/**
	 * 
	 * 
	 * 描述   根据后置审批事项编码或审批事项名称模糊查询后置审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:41:22 
	 * @param 
	 * @return List<CodeLicense>
	 * @throws
	 */
    public List<CodeDzLicense> selectCodeLicenseListByExaCodeOrExaName(String licContent) throws Exception;
    
   
    
    /**
     * 
     * 描述   后置审批事项分页查询
     * @author 赵祥江
     * @date 2016年11月18日 上午11:34:45 
     * @param 
     * @return List<CodeLicense>
     * @throws
     */
    public List<CodeDzLicense> selectCodeLicenseSearchList (PageRequest request)throws Exception;
    
    /**
     * 
     * 描述   根据后置审批事项编码删除
     * @author 赵祥江
     * @date 2016年11月18日 下午4:44:45 
     * @param 
     * @return int
     * @throws
     */
    public int deleteCodeLicenseByExaCode(String exaCode)throws Exception;
    
    /**
     * 
     * 描述   根据后置审批事项编码修改
     * @author 赵祥江
     * @date 2016年11月18日 下午4:44:45 
     * @param 
     * @return int
     * @throws
     */
    public int updateCodeLicenseByExaCode(CodeDzLicense codeLicense)throws Exception; 
    
    /**
     * 
     * 描述   保存后置审批事项
     * @author 赵祥江
     * @date 2016年11月18日 下午5:01:23 
     * @param 
     * @return int
     * @throws
     */
    public int insertCodeLicenseByExaCode(CodeDzLicense codeLicense)throws Exception; 
    
	 /**
     * 
     * 描述:  根据审批事项编码或名称查询审批事项
     * @auther gaojinling
     * @date 2016年11月22日 
     * @param queryMap
     * @return
     */
	public List<CodeDzLicense> selectLicenseList(Map<String,Object> queryMap) throws Exception;
}