/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年07月12日
 * @version 2.0
 */
package com.icinfo.cs.rpt.rptmapper;
import com.icinfo.cs.rpt.rptmodel.RelationNetAll;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_relation_net_all 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年07月12日
 */
public interface RelationNetAllMapper extends Mapper<RelationNetAll> {
    /**
     *@描述： 查询数据
     *@author: wangjin
     *@date 2017-07-12 16:58
     *@return
     */
    List<RelationNetAll> selectByParams(Map<String, Object> searchMap);

    /**
     * 描述：根据内部序号查询 xml 并判断to_id不能为空
     * @param corpid
     * @return
     */
    List<RelationNetAll> selectByCopid(@Param("corpid")String corpid);
    /**
     * 描述：根据内部序号查询
     * @param corpid
     * @return
     */
    List<RelationNetAll> selectByToId(@Param("corpid")String corpid);
}