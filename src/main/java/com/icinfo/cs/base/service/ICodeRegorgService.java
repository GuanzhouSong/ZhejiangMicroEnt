/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_regorg 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
public interface ICodeRegorgService extends BaseService {
	
	/**
     * 描述:获取所有的管辖单位
     * @author chenxin
     * @date 2016-09-12
     * @return List<CodeRegunit>
     */
    public List<CodeRegorg> selectCodeRegorgList();


    /**
     * 描述:根据登记机关编码查询登记机关信息
     * @author ZhuDefeng
     * @date 2016-10-12
     * @return 登记机关信息
     */
    CodeRegorg selectRegOrgByCode(String regOrgCode);
    /**
     * 
     * 描述: for树状结构展示
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
     * 根据登记机关code选择下级登记机关
     * @param substring
     * @return
     */
    List<CodeRegorg> getRegorgByPcode(String substring);
    
    /**
     * 
     * 描述:  双告知登记机关联络员维护 查询列表
     * @auther gaojinling
     * @date 2016年11月15日 
     * @param request
     * @return
     */
    public List<CodeRegorg> selectRegOrgCodeListJSON( PageRequest request) throws Exception;
    
    /**
     * 
     * 描述: 更新登记机关联络员或电话
     * @auther gaojinling
     * @date 2016年11月15日 
     * @param codeRegorg
     * @return
     * @throws Exception
     */
    public int update(CodeRegorg codeRegorg) throws Exception;

    /**
     * 查询省级登记机关
     * @param nocheck 是否设置父级不可选
     * @author ZhuDefeng
     * @date 2017-01-13
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> selectProv(String nocheck,String content) throws Exception;

    /**
     * 
     * 描述: 杭州地区树状结构展示
     * @auther ljx
     * @date 2017年4月26日 
     * @return
     */
	public List<Map<String, Object>> selectToTreeMapHZ(Map param);

	/**
     * 
     * 描述: 根据编号获取登记机关名称
     * @auther baifangfang
     * @date 2017年4月26日 
     * @return
     */
	public List<CodeRegorg> selectRegOrgByCodes(String regOrgs);

}