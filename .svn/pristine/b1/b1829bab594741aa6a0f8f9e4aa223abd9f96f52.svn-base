/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import com.icinfo.cs.im.model.ImInvprodetail;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

/**
 * 描述:    认缴出资详细信息 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IImInvprodetailService extends BaseService {


    /**
     *
     * 描述:  保存认缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param imInvprodetail 认缴出资详细信息
     * @return
     * @throws Exception
     */
    void insert(ImInvprodetail imInvprodetail)throws Exception;

    /**
     *
     * 描述:  修改认缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param imInvprodetail 认缴出资详细信息
     * @return
     * @throws Exception
     */
    int update(ImInvprodetail imInvprodetail)throws Exception;


    /**
     *
     * 描述:  根据认缴ID删除认缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param subID 认缴出资详细信息ID
     * @return
     * @throws Exception
     */
    int delBySubId(String subID)throws Exception;


    /**
     *
     * 描述:  根据出资人ID删除所有认缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param invId 出资人ID
     * @param isUpdateLicomam 是否更新L累计出资额
     * @throws Exception
     */
    void delByInvId(String invId,boolean isUpdateLicomam)throws Exception;


    /**
     *
     * 描述:  根据认缴出资ID查询认缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月30日
     * @param subID 认缴出资ID
     * @return
     * @throws Exception
     */
    ImInvprodetail findBySubID(String subID)throws Exception;


    /**
     *
     * 描述:  根据出资人ID查询所有认缴出资详细信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param invId 出资人ID
     * @return
     * @throws Exception
     */
    List<ImInvprodetail> findByInvIdNoPage(String invId) throws Exception ;
    /**
     * 
     * 描述:  根据出资人ID查询所有认缴出资详细信息for公示
     * @auther ljx
     * @date 2016年9月30日 
     * @param invId
     * @return
     * @throws Exception
     */
    List<ImInvprodetail> findByInvIdNoPageForPub(String invId) throws Exception ;




}