/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import com.icinfo.cs.im.model.ImInvsralt;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

/**
 * 描述:    股权变更 对应的Service接口.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
public interface IImInvsraltService extends BaseService {

    /**
     *
     * 描述:  保存股权变更信息
     * @auther zhudefeng
     * @date 2016年8月31日
     * @param imInvsralt 股权变更信息
     * @return
     * @throws Exception
     */
    int insert(ImInvsralt imInvsralt)throws Exception;

    /**
     *
     * 描述:  删除股权变更信息
     * @auther zhudefeng
     * @date 2016年8月31日
     * @param invAltId 股权变更信息ID
     * @return
     * @throws Exception
     */
    int delByInvAltId(String invAltId,String priPID)throws Exception;


    /**
     *
     * 描述:  修改股权变更信息
     * @auther zhudefeng
     * @date 2016年8月31日
     * @param imInvsralt 股权变更信息
     * @return
     * @throws Exception
     */
    int update(ImInvsralt imInvsralt)throws Exception;


    /**
     * 描述:  分页查询股权变更信息
     *
     * @param pageRequest 查询参数
     * @param priPID 主体ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
     List<ImInvsralt> queryPage(PageRequest pageRequest,String priPID)throws Exception;

    /**
     *
     * 描述:  根据股权变更信息ID查询股权变更信息
     * @auther zhudefeng
     * @date 2016年8月31日
     * @param invAltID 股权变更信息ID
     * @return
     * @throws Exception
     */
    ImInvsralt findByInvAltID(String invAltID,String priPID)throws Exception;


    /**
     * 描述:  根据主体身份ID来公示所有的股权变更信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    public void pubAll(String priPID) throws Exception;
    /**
     * 
     * 描述: 查询to 公示
     * @auther ljx
     * @date 2016年9月24日 
     * @param pageRequest
     * @param priPID
     * @return
     * @throws Exception
     */
	List<ImInvsralt> queryPageForPub(PageRequest pageRequest, String priPID) throws Exception;

	/**
	 * 根据pripid查询股权变更信息列表分页
	 * @param request
	 * @return
	 */
	List<ImInvsralt> queryPage(PageRequest request) throws Exception;


}