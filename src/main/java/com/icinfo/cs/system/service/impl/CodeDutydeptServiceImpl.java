/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.mapper.CodeDutydeptMapper;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_code_dutydept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Service
public class CodeDutydeptServiceImpl extends MyBatisServiceSupport implements ICodeDutydeptService {

    @Autowired
    private CodeDutydeptMapper codeDutydeptMapper;


    /**
     * 描述：获取职能部门编码数据
     *
     * @param selectedCodes
     * @return
     * @throws Exception
     */
    @Override
    public List<CodeDutydept> doSelectAllDutyCodes(String selectedCodes) throws Exception {
        List<CodeDutydept> codeDutydepts=codeDutydeptMapper.selectAll();
        for (CodeDutydept codeDutydept:codeDutydepts){
            if(StringUtil.isNotBlank(codeDutydept.getDeptCode())){
                if(StringUtil.indexOf(selectedCodes, codeDutydept.getDeptCode())!=-1){
                    codeDutydept.setChecked("true");
                }
            }
            codeDutydept.setpId("0");
        }
        return codeDutydepts;
    }

    /**
     * 
     * 描述   根据部门类型编码查询
     * @author  赵祥江
     * @date 2016年11月21日 下午4:14:10 
     * @param  
     * @throws
     */
	@Override
	public CodeDutydept doSelectCodeDutydeptBydeptCode(String deptCode)
			throws Exception {
		CodeDutydept codeDutydept=new CodeDutydept();
		codeDutydept.setDeptCode(deptCode);
 		return codeDutydeptMapper.selectOne(codeDutydept);
	}
	
	 /**
     * 描述：获取职能部门编码数据
     * @param deptCode
     * @return
     * @throws Exception
     */
	@Override
	public List<CodeDutydept> selectByParams(Map<String,Object> params) throws Exception {
		return codeDutydeptMapper.selectByParams(params);
	}
}