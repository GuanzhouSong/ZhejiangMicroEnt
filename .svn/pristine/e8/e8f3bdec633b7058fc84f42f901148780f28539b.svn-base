/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeLicenseMapper;
import com.icinfo.cs.base.model.CodeLicense;
import com.icinfo.cs.base.service.ICodeLicenseService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_license 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Service
public class CodeLicenseServiceImpl extends MyBatisServiceSupport implements ICodeLicenseService {
	private static final Logger logger = LoggerFactory.getLogger(CodeLicenseServiceImpl.class);
	@Autowired
	private CodeLicenseMapper codeLicenseMapper;
	/**
	 * 
	 * 描述   根据后置审批事项编码查询审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:40:30 
	 * @param 
	 * @return CodeLicense
	 * @throws
	 */
	@Override
	public CodeLicense selectCodeLicenseByExaCode(String exaCode)
			throws Exception {
		CodeLicense codeLicense=new CodeLicense();
		codeLicense.setExaCode(exaCode);
		return codeLicenseMapper.selectOne(codeLicense);
	}

	/**
	 * 
	 * 描述   根据后置审批事项编码前后置类型查询审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:40:25 
	 * @param 
	 * @return CodeLicense
	 * @throws
	 */
	@Override
	public CodeLicense selectCodeLicenseByExaCodeAndLicType(String exaCode,
			String licType) throws Exception {
		CodeLicense codeLicense=new CodeLicense();
		codeLicense.setExaCode(exaCode);
		codeLicense.setLicType(licType);
		return codeLicenseMapper.selectOne(codeLicense);
	}

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
	@Override
	public List<CodeLicense> selectCodeLicenseListByLicType(String licType)
			throws Exception {
		CodeLicense codeLicense=new CodeLicense(); 
		codeLicense.setLicType(licType);
		return codeLicenseMapper.select(codeLicense);
	}

	/**
	 * 
	 * 描述   根据后置审批事项编码前后置类型查询审批事项
	 * @author 赵祥江
	 * @date 2016年10月18日 下午1:40:25 
	 * @param 
	 * @return CodeLicense
	 * @throws
	 */
	@Override
	public List<CodeLicense> selectCodeLicenseListByExaCodeOrExaName(
			String licContent) throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>(); 
		queryMap.put("licContent", licContent);
		return codeLicenseMapper.selectCodeLicenseListByExaCodeOrExaName(queryMap);
	}

	/**
	 * 
	 * 描述   分页查询后置审批事项
	 * @author  赵祥江
	 * @date 2016年11月18日 下午1:34:41 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CodeLicense> selectCodeLicenseSearchList(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return codeLicenseMapper.selectCodeLicenseSearchList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "查询后置审批事项失败!");
            throw new BusinessException("查询后置审批事项失败!");
		}
	}

	/**
	 * 
	 * 描述   根据后置审批事项编码删除
	 * @author  赵祥江
	 * @date 2016年11月18日 下午4:46:16 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteCodeLicenseByExaCode(String exaCode) throws Exception {
		try {
			if(StringUtil.isNotEmpty(exaCode)){ 
				CodeLicense codeLicense=new CodeLicense(); 
				codeLicense.setExaCode(exaCode);
				codeLicense.setLicType("2");
			    return codeLicenseMapper.delete(codeLicense);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批是事项编码删除失败!");
            throw new BusinessException("根据审批是事项编码删除失败!");
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   根据后置审批事项编码修改
	 * @author  赵祥江
	 * @date 2016年11月18日 下午4:46:28 
	 * @param  
	 * @throws
	 */
	@Override
	public int updateCodeLicenseByExaCode(CodeLicense codeLicense) throws Exception {
		try {
			if(codeLicense!=null&&StringUtil.isNotEmpty(codeLicense.getExaCode())){
  				Example example = new Example(CodeLicense.class);
				example.createCriteria()
				.andEqualTo("exaCode", codeLicense.getExaCode())
				.andEqualTo("licType", "2"); 
			    return codeLicenseMapper.updateByExampleSelective(codeLicense, example);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批事项编码修改失败!");
            throw new BusinessException("根据审批事项编码修改失败!");
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   保存后置审批事项
	 * @author  赵祥江
	 * @date 2016年11月18日 下午5:02:15 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertCodeLicenseByExaCode(CodeLicense codeLicense)
			throws Exception {
		try {
			if(codeLicense!=null){ 
			    return codeLicenseMapper.insert(codeLicense);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "保存审批事项编码修改失败!");
            throw new BusinessException("保存审批事项编码修改失败!");
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   根据后置审批事项名称查询
	 * @author  赵祥江
	 * @date 2016年11月18日 下午5:21:47 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CodeLicense> selectCodeLicenseListByExaName(String exaName)
			throws Exception { 
		try {
			CodeLicense codeLicense=new CodeLicense(); 
			codeLicense.setLicType("2");
			codeLicense.setExaName(exaName);
			return codeLicenseMapper.select(codeLicense); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据后置审批事项名称查询失败!");
            throw new BusinessException("根据后置审批事项名称查询失败!");
		} 
 	}
	
	 /**
     * 
     * 描述:  根据审批事项编码或名称查询审批事项
     * @auther gaojinling
     * @date 2016年11月22日 
     * @param queryMap
     * @return
     */
	public List<CodeLicense> selectLicenseList(Map<String,Object> queryMap) throws Exception{
		return codeLicenseMapper.selectLicenseList(queryMap);
	}
}