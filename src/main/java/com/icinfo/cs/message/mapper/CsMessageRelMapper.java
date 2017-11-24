/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月18日
 * @version 2.0
 */
package com.icinfo.cs.message.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.message.dto.CsMessageRelDto;
import com.icinfo.cs.message.model.CsMessageRel;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_message_rel 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
public interface CsMessageRelMapper extends Mapper<CsMessageRel> {
    
    /** 
     * 描述: 获取消息分页列表 
     * @author 张文男
     * @date 2017年5月23日 
     * @param map
     * @return 
     */
    
    public List<CsMessageRelDto> queryMessagPageList(Map<String,Object> map);
    
    /** 
     * 描述: 获取消息分页列表根据企业id
     * @author 张文男
     * @date 2017年5月24日 
     * @param map
     * @return 
     */
    
    public List<CsMessageRelDto> queryMessagPageListByPriPID(Map<String,Object> map);
    
    /** 
     * 描述: 根据企业id获取统计数据 
     * @author 张文男
     * @date 2017年5月25日 
     * @param map
     * @return 
     */
    
    public Long queryMessagCountGroupByPriPID(Map<String,Object> map);
    
    /** 
     * 描述: 根据消息id获取统计数据
     * @author 张文男
     * @date 2017年5月25日 
     * @param map
     * @return 
     */
    
    public CsMessageRelDto queryMessagCountGroupByMsgUid(Map<String,Object> map);
 
}