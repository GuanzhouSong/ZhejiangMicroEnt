/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.SfcForm;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_sfc_form 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月05日
 */
public interface ISfcFormService extends BaseService {

    /**
     * 描述: 查询当年度表单填写情况
     * @auther wangjin
     * @date 2016年9月13日
     * @param priPID
     * @param year
     * @return
     * @throws Exception
     */
    SfcForm selectSfcFormByPripidAndYear(String priPID, Integer year) throws Exception;

    /**
     * 描述: 初始化农专当年度表单填写情况
     * @auther wangjin
     * @date 2016年9月13日
     * @param pripid
     * @param year
     * @return
     * @throws Exception
     */
    int insert(String pripid, Integer year);

    /**
     * 更新Form表单状态
     * @autor: wangjin
     * @param sfcForm
     * @return
     */
    int updateForm(SfcForm sfcForm);
}