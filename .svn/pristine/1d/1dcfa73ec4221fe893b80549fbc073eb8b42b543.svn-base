/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;


import com.icinfo.cs.rpt.rptmodel.RelationNetAll;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_relation_net_all 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月12日
 */
public interface IRelationNetAllService extends BaseService {

    /**
     *@描述：  获取数据
     *@author: wangjin
     *@date 2017-07-12 16:01
     *@return
     */
    public Map<String, Object> select_result(PageRequest request) throws Exception;

    /**
     * 描述：根据内部序号查询
     * @param corpid
     * @return
     */
    public List<RelationNetAll> selectByFromId(String corpid);

    /**
     * 描述：根据内部序号或身份证查询
     * @param corpid
     * @return
     */
    public List<RelationNetAll> selectByToId(String corpid);



}