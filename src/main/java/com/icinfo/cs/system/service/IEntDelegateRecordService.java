/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.model.EntDelegateRecord;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

/**
 * 描述:    cs_delegate_record 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月22日
 */
public interface IEntDelegateRecordService extends BaseService {




    /**
     * 描述：
     * @author ZhuDefeng
     * @param entDelegateRecord
     * @return
     * @throws Exception
     */
    int insertRecord(EntDelegateRecord entDelegateRecord)throws Exception;

    /**
     * 描述：查询企业委托记录信息
     *
     * @param pageRequest
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-10
     */
    public List<EntDelegateRecord> query(PageRequest pageRequest) throws Exception ;



}