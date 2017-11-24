/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年10月31日
 * @version 2.0
 */
package com.icinfo.cs.webservice.mapper;

import com.icinfo.cs.webservice.model.WsPubEppassword;
import com.icinfo.cs.webservice.model.WsPubOpadetail;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述: 联络员信息表 cs_pub_eppassword 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
public interface WsPubEppasswordMapper extends Mapper<WsPubEppassword> {
    List<WsPubEppassword> selectWsPubEppasswordListByContion(Map<String, Object> params);

    Integer selectWsPubEppasswordCountByContion(Map<String, Object> params);

    Integer selectWsPubEppasswordMaxId(Map<String, Object> params);

    Integer selectWsPubEppasswordMinId(Map<String, Object> params);
}