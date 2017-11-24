/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月06日
 * @version 2.0
 */
package com.icinfo.cs.writ.mapper;

import com.icinfo.cs.writ.dto.WritCountDto;
import com.icinfo.cs.writ.dto.WritDto;
import com.icinfo.cs.writ.model.Writ;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_writ 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月06日
 */
public interface WritMapper extends Mapper<Writ> {
    /**
     * 描述:查询列表  client
     * @author:wangjin
     * @param searchMap
     * @return
     */
    List<WritDto> selectByPripidAndYear(Map<String, Object> searchMap);

    /**
     * 描述：根据查询条件 进行查询 server
     * @param searchMap
     * @return
     */
    List<WritDto> selectByParameters(Map<String, Object> searchMap);

    /**
     * 描述:根据查询条件统计数据
     * @author:wangjin
     * @param
     * @param searchMap
     * @return
     */
    WritCountDto search_countResult(Map<String, Object> searchMap);
}