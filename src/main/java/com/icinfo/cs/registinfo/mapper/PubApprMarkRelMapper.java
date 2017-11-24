/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年04月26日
 * @version 2.0
 */
package com.icinfo.cs.registinfo.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registinfo.dto.PubApprMarkRelDto;
import com.icinfo.cs.registinfo.model.PubApprMarkRel;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_appr_mark_rel 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年04月26日
 */
public interface PubApprMarkRelMapper extends Mapper<PubApprMarkRel> {

    /** 
     * 描述: 根据企业id删除对应信息
     * @author 张文男
     * @date 2017年4月26日 
     * @param priPID 
     */

    public void deleteInPriPID(String priPID);

    /** 
     * 描述: 根据企业id删除对应信息
     * @author 张文男
     * @date 2017年4月26日 
     * @param priPID 
     */

    public void deleteByMap(Map<String, Object> map);

    /** 
     * 描述: 根据markcodes 删除对应数据
     * @author 张文男
     * @date 2017年4月27日 
     * @param markCode 
     */

    public void deleteByMarkCode(String markCode);

    /** 
     * 描述: 根据企业ID获取所有是专项库的标签code
     * @author 张文男
     * @date 2017年4月27日 
     * @param priPIDs
     * @return 
     */

    public List<String> queryDoublyStoMarkCodeListInPriPID(String priPIDs);

    /**
     * 
     * 描述: 根绝pripid查询企业所属标签(当前有效的标签)（分组化后）
     * @auther gaojinling
     * @date 2017年4月26日 
     * @param map
     * @return
     */
    List<PubApprMarkRelDto> selectPubApprMarkRelDtoByPriPIDGroup(Map<String, Object> map);

    /**
     * 
     * 描述: 获取当前企业所属标签及标签是否为专项库标签
     * @auther gaojinling
     * @date 2017年4月26日 
     * @param map
     * @return
     */
    List<PubApprMarkRelDto> selectPubApprMarkRelDtoByPriPID(Map<String, Object> map);

}