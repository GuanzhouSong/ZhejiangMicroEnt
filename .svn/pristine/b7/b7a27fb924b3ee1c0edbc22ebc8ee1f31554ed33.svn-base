/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import com.icinfo.cs.im.model.ImInvactdetail;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

/**
 * 描述:    实缴出资详细信息 对应的Service接口.<br>
 *
 * @author zhudefeng
 * @date 2016年08月29日
 */
public interface IImInvactdetailService extends BaseService {

    /**
     *
     * 描述:  保存实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param imInvactdetail 实缴出资详细信息
     * @throws Exception
     */
    void insert(ImInvactdetail imInvactdetail)throws Exception;

    /**
     *
     * 描述:  修改实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param imInvactdetail 实缴出资详细信息
     * @return
     * @throws Exception
     */
    int update(ImInvactdetail imInvactdetail)throws Exception;


    /**
     *
     * 描述:  根据实缴ID删除实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param paidID 实缴出资详细信息ID
     * @throws Exception
     */
    void delByPaidId(String paidID)throws Exception;


    /**
     *
     * 描述:  根据出资人ID删除所有实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param invId 出资人ID
     * @return
     * @throws Exception
     */
    void delByInvId(String invId,boolean isUpdateLicomam)throws Exception;


    /**
     *
     * 描述:  根据实缴出资ID查询实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月30日
     * @param paidID 实缴出资ID
     * @return
     * @throws Exception
     */
    ImInvactdetail findByPaidID(String paidID)throws Exception;


    /**
     *
     * 描述:  根据出资人ID分页查询实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param invId 出资人ID
     * @param request 查询参数
     * @return
     * @throws Exception
     */
    List<ImInvactdetail> findByInvId(PageRequest request,String invId) throws Exception ;
    
    List<ImInvactdetail> findByInvIdNoPageForPub(String invId) throws Exception ;

    /**
     *
     * 描述:  根据出资人ID查询所有实缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月30日
     * @param invId 出资人ID
     * @return
     * @throws Exception
     */
    List<ImInvactdetail> findByInvIdNoPage(String invId) throws Exception ;

}