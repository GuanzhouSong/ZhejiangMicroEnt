/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月22日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import com.icinfo.cs.system.model.EntAssignRecord;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * 描述:    cs_ent_assign 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月22日
 */
public interface EntAssignRecordMapper extends Mapper<EntAssignRecord> {

    /**
     * 描述：删除指定分配信息
     *
     * @param conditionMap
     * @throws Exception
     * @author ZhuDefeng
     */
    void delByPriPIDAndAssignUserId(Map<String,Object> conditionMap) throws Exception;
}