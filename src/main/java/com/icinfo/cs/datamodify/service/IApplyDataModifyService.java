/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.datamodify.service;

import com.icinfo.cs.datamodify.model.ApplyDataModify;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

/**
 * 描述:  cs_apply_data_modify 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
public interface IApplyDataModifyService extends BaseService {

    /**
     *@描述：获取数据
     *@author: wangjin
     *@date 2017-11-22 10:10
     *@return
     */
    List<ApplyDataModify> search_result(PageRequest request) throws Exception;

    /**
     *@描述：保存数据对象
     *@author: wangjin
     *@date 2017-11-23 9:09
     *@return
     */
    int save(ApplyDataModify applyDataModify);

    /**
     *@描述：查看对象信息
     *@author: wangjin
     *@date 2017-11-23 9:15
     *@return
     */
    ApplyDataModify selectByUid(String uid);
}