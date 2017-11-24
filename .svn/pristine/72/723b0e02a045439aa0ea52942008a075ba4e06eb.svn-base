/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import java.util.List;

import com.icinfo.cs.im.model.ImIppldg;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    知识产权出质登记信息 对应的Service接口.<br>
 *
 * @author zhudefeng
 * @date 2016年08月28日
 */
public interface IImIppldgService extends BaseService {

    /**
     * 描述:  保存知识产权出质登记信息
     *
     * @param iImIppldg 知识产权出质登记信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int insert(ImIppldg iImIppldg)throws Exception;


    /**
     * 描述:  修改知识产权出质登记信息
     *
     * @param iImIppldg 知识产权出质登记信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int update(ImIppldg iImIppldg)throws Exception;

    /**
     * 描述:  删除知识产权出质登记信息
     *
     * @param pleID 知识产权出质登记信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int deleteByPleID(String pleID,String priPID)throws Exception;


    /**
     * 描述:  分页查询知识产权出质登记信息
     *
     * @param pageRequest 查询参数
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    List<ImIppldg> quryPage(PageRequest pageRequest,String priPID)throws Exception;
    

    /** 
     * 描述: 根据自然人身份证号获取 个人知识产权出质登记信息
     * @author 张文男
     * @date 2017年3月17日 
     * @param pageRequest
     * @return 
     */
    
    public List<ImIppldg> selectListByCerNO(PageRequest pageRequest);


    /**
     * 描述:  根据知识产权出质登记信息ID查询知识产权出质登记信息
     *
     * @param pleID 股权变更信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    ImIppldg findByPleId(String pleID,String priPID)throws  Exception;


    /**
     * 描述:  根据主体身份ID来公示所有的 知识产权出质登记信息
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
     * @param pageReqeust
     * @param priPID
     * @return
     * @throws Exception
     */
	List<ImIppldg> queryPageForPUb(PageRequest pageReqeust, String priPID) throws Exception;
}