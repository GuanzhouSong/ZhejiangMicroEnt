/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import com.icinfo.cs.im.model.ImPermit;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:    即时信息-许可信息 对应的Service接口.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
public interface IImPermitService extends BaseService {

    /**
     *
     * 描述:  保存即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    int insert(ImPermit imPermit) throws Exception;

    /**
     *
     * 描述:  保存并公示即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    int insertAndPub(ImPermit imPermit) throws Exception;

    /**
     *
     * 描述:  修改即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    int update(ImPermit imPermit) throws Exception;

    /**
     *
     * 描述:  根据LicId删除即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return 1：删除成功;-1:已经公示不允许删除；0：不存在
     * @throws Exception
     */
    int deleteByLicId(String licId,String priPID) throws Exception;

    /**
     *
     * 描述:  根据LicId查询即时信息-许可信息
     * @auther zhudefeng
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    ImPermit selectByLicId(String licId,String priPID) throws Exception;


    /**
     *
     * 描述:  查询许可信息列表
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param request 查询参数
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     */
    List<ImPermit> queryPage(PageRequest request,String priPID)throws Exception;

    /**
     * 描述:  根据主体身份ID来公示所有的行政许可信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    public int pubAll(String priPID) throws Exception;
    /**
     * 
     * 描述: 查询列表for 公示
     * @auther ljx
     * @date 2016年9月24日 
     * @param request
     * @param priPID
     * @return
     * @throws Exception
     */
	List<ImPermit> queryPageForPub(PageRequest request, String priPID) throws Exception;
}