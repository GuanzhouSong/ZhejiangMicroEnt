/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.SfcHonor;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

/**
 * 描述:  cs_sfc_honor 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface ISfcHonorService extends BaseService {

    /**
     * 更新数据
     * @author: wangjin
     * @param sfcHonor
     * @return
     */
    int update(SfcHonor sfcHonor);

    /**
     * 新增数据
     * @author: wangjin
     * @param sfcHonor
     * @return
     */
    int insert(SfcHonor sfcHonor);


    /**
     * 列表查询
     * @author: wangjin
     * @param request
     * @return
     */
    List<SfcHonor> select_queryPage(PageRequest request);

    /**
     * 批量删除
     * @autor: wangjin
     * @param list_uids
     * @return
     */
    int batch_delete(List<String> list_uids,String priPID);

    /**
     * 根据uid 查询当前对象
     * @author: wangjin
     * @param uid
     * @return
     */
    SfcHonor selectByUid(String uid,String priPID);
}