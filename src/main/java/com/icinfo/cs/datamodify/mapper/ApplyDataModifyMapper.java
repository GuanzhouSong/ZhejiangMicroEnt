/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月22日
 * @version 2.0
 */
package com.icinfo.cs.datamodify.mapper;

import com.icinfo.cs.datamodify.model.ApplyDataModify;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_apply_data_modify 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
public interface ApplyDataModifyMapper extends Mapper<ApplyDataModify> {
    /**
     *@描述：获取数据
     *@author: wangjin
     *@date 2017-11-22 10:34
     *@return
     */
    List<ApplyDataModify> selectByParams(Map<String, Object> searchMap);
}