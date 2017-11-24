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

import com.icinfo.cs.message.model.CsMessage;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_message 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
public interface CsMessageMapper extends Mapper<CsMessage> {

    /** 
     * 描述: 根据联络员手机号获取对应消息列表
     * @author 张文男
     * @date 2017年5月22日 
     * @param map
     * @return 
     */
    
    public List<CsMessage> queryMessagePageListByLiaisonManTel(Map<String, Object> map);
    
    /** 
     * 描述: 根据联络员手机号获取对应消息列表-总数
     * @author 张文男
     * @date 2017年5月23日 
     * @param map
     * @return 
     */
    
    public Long queryMessagePageCountByLiaisonManTel(Map<String, Object> map);
    
    /** 
     * 描述: 根据消息id更新数据
     * @author 张文男
     * @date 2017年5月26日 
     * @param bean 
     */
    
    public void updateMessageByMsgUid(CsMessage bean);
}