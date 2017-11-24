/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeRegorgMapper;
import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.dtinfo.model.PubDtInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_code_regorg 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Service
public class CodeRegorgServiceImpl extends MyBatisServiceSupport implements ICodeRegorgService {
	
	 @Autowired
	 CodeRegorgMapper codeRegorgMapper;

	 /**
     * 描述:获取所有的登记机关
     * @author chenxin
     * @date 2016-09-12
     * @return List<CodeRegunit>
     */
    @Override
    public List<CodeRegorg> selectCodeRegorgList() {
        return codeRegorgMapper.selectCodeRegorgAll();
    }


    /**
     * 描述:根据登记机关编码查询登记机关信息
     *
     * @param regOrgCode
     * @return 登记机关信息
     * @author ZhuDefeng
     * @date 2016-10-12
     */
    @Override
    public CodeRegorg selectRegOrgByCode(String regOrgCode) {
        CodeRegorg codeRegorg=new CodeRegorg();
        codeRegorg.setCode(regOrgCode);
        return codeRegorgMapper.selectOne(codeRegorg);
    }


	@Override
	public List<Map<String, Object>> selectToTreeMap(Map param) {
		return codeRegorgMapper.selectToTreeMap(param);
	}

    /**
     * 根据code选择下级登记机关
     * @param code
     * @return
     */
    @Override
    public List<CodeRegorg> getRegorgByPcode(String code) {
        if(StringUtil.isEmpty(code)||code.length()<2) return null;
        Example example = new Example(CodeRegorg.class);
        example.createCriteria().andLike("code",code+"%");
        return codeRegorgMapper.selectByExample(example);
    }


	@Override
	public List<Map<String, Object>> selectToTreeNocheckMap(Map param) {
		// TODO Auto-generated method stub
		return codeRegorgMapper.selectToTreeNocheckMap(param);
	}


	/**
	 * 
	 * 描述:  双告知登记机关联络员维护 查询列表
	 * @auther gaojinling
	 * @date 2016年11月15日 
	 * @param request
	 * @return
	 */
	@Override
	public List<CodeRegorg> selectRegOrgCodeListJSON(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return codeRegorgMapper.selectRegOrgCodeListJSON(request.getParams());
	}

    /**
     * 
     * 描述: 根据编码更新登记机关联络员或电话
     * @auther gaojinling
     * @date 2016年11月15日 
     * @param codeRegorg
     * @return
     * @throws Exception
     */
	@Override
	public int update(CodeRegorg codeRegorg) throws Exception {
		if(codeRegorg!=null&&StringUtil.isNotEmpty(codeRegorg.getCode())){
			Example example = new Example(CodeRegorg.class);
			example.createCriteria().andEqualTo("code", codeRegorg.getCode()); 
			return codeRegorgMapper.updateByExampleSelective(codeRegorg, example);
		}
		return 0;
	}

	/**
	 * 查询省级登记机关
	 *
	 * @return
	 * @throws Exception
	 * @author ZhuDefeng
	 * @date 2017-01-13
	 */
	@Override
	public List<Map<String, Object>> selectProv(String nocheck,String content) throws Exception {
		Map<String,Object> qryMap=new HashMap<String,Object>();
		qryMap.put("nocheck",nocheck);
		qryMap.put("content", content);
		return codeRegorgMapper.selectProv(qryMap);
	}


	@Override
	public List<Map<String, Object>> selectToTreeMapHZ(Map param) {
		return codeRegorgMapper.selectToTreeMapHZ(param);
	}


	@Override
	public List<CodeRegorg> selectRegOrgByCodes(String regOrgs) {
		Map<String,Object> qryMap=new HashMap<String,Object>();
		qryMap.put("regOrgs",regOrgs);
		return codeRegorgMapper.selectRegOrgByCodes(qryMap);
	}
}