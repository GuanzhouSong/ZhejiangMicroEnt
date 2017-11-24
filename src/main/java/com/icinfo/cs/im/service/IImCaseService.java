/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.im.dto.ImCaseDto;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    行政处罚 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IImCaseService extends BaseService {

    /**
     * 描述:  保存行政处罚信息
     *
     * @param imCase 行政处罚信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int insert(ImCase imCase)throws Exception;


    /**
     * 描述:  修改行政处罚信息
     *
     * @param imCase 行政处罚信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int update(ImCase imCase)throws Exception;

    /**
     * 描述:  删除行政处罚信息
     *
     * @param caseNO 行政处罚信息ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int deleteByCaseNO(String caseNO,String priPID)throws Exception;


    /**
     * 描述:  分页查询行政处罚信息
     *
     * @param pageRequest 查询参数
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    List<ImCase> quryPage(PageRequest pageRequest,String priPID)throws Exception;


    /**
     * 描述:  根据行政处罚信息ID查询行政处罚信息
     *
     * @param caseNO 行政处罚ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    ImCase findByCaseNO(String caseNO,String priPID)throws  Exception;

    /**
     * 描述:  根据主体身份ID来公示所有的行政许可信息
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
    int pubAllImCase(String priPID)throws Exception;

    /**
     * 描述:  根据主体身份ID来公示所有的行政许可信息for公示
     *
     * @param priPID 主体身份ID
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年9月09日
     */
	List<ImCase> quryPageForPub(PageRequest pageRequest, String priPID) throws Exception;
	
	List<ImCaseDto> queryToPub(PageRequest pageRequest,String priPID)throws Exception;
	
	 
}