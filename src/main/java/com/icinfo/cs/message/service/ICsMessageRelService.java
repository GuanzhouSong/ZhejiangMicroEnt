/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.message.dto.CsMessageRelDto;
import com.icinfo.cs.message.model.CsMessageRel;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_message_rel 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
public interface ICsMessageRelService extends BaseService {
    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年5月19日 
     * @param bean 
     */
    
    public void insert(CsMessageRel bean);
    
    /** 
     * 描述: 获取消息分页列表 
     * @author 张文男
     * @date 2017年5月23日 
     * @param request
     * @return 
     */

    public PageResponse<CsMessageRelDto> queryMessagPageList(PageRequest request);
    
    /** 
     * 描述: 获取消息分页列表根据企业id
     * @author 张文男
     * @date 2017年5月24日 
     * @param map
     * @return 
     */
    
    public PageResponse<CsMessageRelDto> queryMessagPageListByPriPID(PageRequest request);
    
    /** 
     * 描述:  获取消息分页列表根据消息ID
     * @author 张文男
     * @date 2017年5月24日 
     * @param request
     * @return 
     */
    
    public PageResponse<CsMessageRel> queryMessagPageListByMsgUid(PageRequest request);
    
    /** 
     * 描述: 获取消息列表根据消息ID
     * @author 张文男
     * @date 2017年5月25日 
     * @param msgUid
     * @return 
     */
    
    public List<CsMessageRel> queryMessagListByMsgUid(String msgUid);
    
    /** 
     * 描述: 导出excel
     * @author 张文男
     * @date 2017年5月25日 
     * @param msgUid
     * @param ouputStream
     * @throws IOException 
     */
    
    public void excelExportByMsgUid(String msgUid,OutputStream ouputStream) throws IOException;
    
    /** 
     * 描述: 根据查询条件获取统计信息
     * @author 张文男
     * @date 2017年5月25日 
     * @param map
     * @return
     * @throws InterruptedException 
     */
    
    public CsMessageRelDto queryMessageCount(Map<String,Object> map) throws InterruptedException;
}