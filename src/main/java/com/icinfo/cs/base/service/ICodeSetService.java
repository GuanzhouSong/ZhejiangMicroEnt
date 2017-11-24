/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.cs.base.model.CodeSet;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;


/**
 * 描述:    编码信息 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface ICodeSetService extends BaseService {
    /**
     *
     * 描述:  根据编码类型查询编码集合
     * @auther zhudefeng
     * @param codeType 登陆主体身份ID
     * @date 2016年09月09日
     * @return 编码集合
     * @throws Exception
     */
    List<CodeSet> findCodeByType(String codeType)throws Exception;
}