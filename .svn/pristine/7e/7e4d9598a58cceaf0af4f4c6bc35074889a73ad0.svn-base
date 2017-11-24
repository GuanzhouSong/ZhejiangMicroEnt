/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import com.icinfo.cs.message.dto.CsMessageDto;
import com.icinfo.cs.message.model.CsMessage;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_message 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
public interface ICsMessageService extends BaseService {
    /** 
     * 描述: 保存或修改
     * @author 张文男
     * @date 2017年5月25日 
     * @param dto
     * @param request
     * @throws Exception 
     */
    public void saveOrUpdate(CsMessageDto dto,PageRequest request) throws Exception;
    
    /** 
     * 描述: 根据联络员手机号获取对应消息列表
     * @author 张文男
     * @date 2017年5月22日 
     * @param map
     * @return 
     * @throws InterruptedException 
     */
    
    public PageResponse<CsMessage> queryMessagePageListByLiaisonManTel(String liaisonManTel,Integer pageNum,Integer pageSize) throws InterruptedException;
    
    /** 
     * 描述: 根据msgUid获取消息详情
     * @author 张文男
     * @date 2017年5月24日 
     * @param msgUid
     * @return 
     * @throws IOException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws NoSuchMethodException 
     * @throws InstantiationException 
     */
    
    public CsMessageDto queryCsMessageDtoByMsgUid(String msgUid) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException;
    
    
    /** 
     * 描述: 根据消息id更新数据
     * @author 张文男
     * @date 2017年5月26日 
     * @param bean 
     * @throws UnsupportedEncodingException 
     */
    
    public void updateMessageByMsgUid(CsMessage bean) throws UnsupportedEncodingException;
    
    /** 
     * 描述: 定时发送消息
     * @author 张文男
     * @throws Exception 
     * @date 2017年6月8日  
     */
    
    public void quartzJob() throws Exception;
    
    /** 
     * 描述: http调用手机端接口
     * @author 张文男
     * @date 2017年6月12日 
     * @param newJson
     * @param tel 
     */
    
    public void sendPOSTRequest(String newJson,String tel);
}