/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.cs.im.dto.ImInvestmentDto;
import com.icinfo.cs.im.model.ImInvestment;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:    股东及出资情况 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IImInvestmentService extends BaseService {

    /**
     *
     * 描述:  分页查询出资情况列表（即时信息）
     * @auther zhudefeng
     * @param request 请求参数
     * @date 2016年8月29日
     * @return 出资情况列表
     * @throws Exception
     */
    List<ImInvestment> findInvestmentWithDetailByPriPID(PageRequest request,boolean isPageSearch)throws Exception;

    /**
     * 通过企业内部序列号来查询股东列表
     * @author ZhuDefeng
     * @date 2017-02-14
     * @param priPID
     * @return
     */
    List<MidInv>  selectInvestmentDtosFromMidInv(String priPID) throws Exception;

    /**
     *
     * 描述:  全查询出资情况列表（即时信息）
     * @auther zhudefeng
     * @param priPID 登陆主体身份ID
     * @date 2016年8月30日
     * @return 出资情况列表
     * @throws Exception
     */
    List<ImInvestmentDto> findInvestmentWithDetailByPriPIDNoPage(String priPID)throws Exception;


    /**
     *
     * 描述:  保存出资人信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param imInvestment 出资人信息
     * @return 投资人ID
     * @throws Exception
     */
    String insert(ImInvestment imInvestment)throws Exception;

    /**
     *
     * 描述:  公示该主体的所有股东的出资信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param priPID 主体身份编号
     * @throws Exception
     */
     Map<String,String> pubInv(String priPID)throws Exception;


    /**
     * 描述:  删除出资人信息（同时删除实缴出资明细、认缴出资明细）
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param invId 出资人ID
     * @return
     * @throws Exception
     */
    void   delByInvId(String invId,String priPID)throws Exception;


    /**
     *
     * 描述:  根据出资人ID查询股东信息
     * @auther zhudefeng
     * @date 2016年8月29日
     * @param invId 出资人ID
     * @return
     * @throws Exception
     */
    ImInvestment findByInvId(String invId,String priPID) throws Exception;
   
    

    /**
    *
    * 描述:  根据出资人ID查询股东信息
    * @authe ljx
    * @date 2016年8月29日
    * @param invId 出资人ID
    * @return
    * @throws Exception
    */
   ImInvestment findByOnlyInvId(String invId) throws Exception;
  

   /**
    * 
    * 描述: TODO
    * @auther 更新方法
    * @date 2016年9月12日 
    * @param imInvestment
    * @return
    * @throws Exception
    */
	int update(ImInvestment imInvestment) throws Exception;
	  /**
    *
    * 描述:  分页查询出资情况列表（即时信息For公示）
    * @auther zhudefeng
    * @param request 请求参数
    * @date 2016年8月29日
    * @return 出资情况列表
    * @throws Exception
    */
    List<ImInvestmentDto> findInvestmentWithDetailByPriPIDForPub(PageRequest request) throws Exception;


    /**
     * 描述:  分页查询出资情况列表（即时信息）for公示
     *
     * @param request 请求参数
     * @return 出资情况列表
     * @throws Exception
     * @auther ljx
     * @date 2016年12月8日
     */
	List<ImInvestment> findInvestmentWithDetatilForPub(PageRequest request) throws Exception;

    /**
     * 生成UUID
     * @author ZhuDefeng
     * @return
     * @throws Exception
     */
    String genInvId()throws Exception;

}