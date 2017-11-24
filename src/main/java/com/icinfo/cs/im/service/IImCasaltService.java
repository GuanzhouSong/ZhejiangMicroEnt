/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service;

import java.util.List;

import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    行政处罚信息变更 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IImCasaltService extends BaseService {

    /**
     * 描述:  保存行政处罚信息
     *
     * @param imCasalt 行政处罚信息
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    int insert(ImCasalt imCasalt)throws Exception;
    /**
     *   
     * 描述: 查询列表信息更加caseNO
     * @auther ljx
     * @date 2016年9月9日 
     * @param request
     * @param caseNO
     * @return
     * @throws Exception
     */
    List<ImCasalt> queryPageByCaseNO(PageRequest request,String caseNO)throws Exception;
    
    /**
     * 
     * 描述: 查询for公示
     * @auther ljx
     * @date 2016年10月28日 
     * @param caseNO
     * @return
     * @throws Exception
     */
    List<ImCasalt> queryForPub(String caseNO)throws Exception;
    
   
    

}