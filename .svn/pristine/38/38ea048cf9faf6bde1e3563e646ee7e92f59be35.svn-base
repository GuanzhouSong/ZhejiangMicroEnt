/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registinfo.dto.RegistMarkDto;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.registinfo.model.RegistMarkHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_regist_mark 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IRegistMarkHisService extends BaseService {
	
    /**
     * 
     * 描述   根据标签编号查询分页
     * @author 赵祥江
     * @date 2017年3月23日 下午12:49:05 
     * @param 
     * @return List<RegistMarkHis>
     * @throws
     */
    public List<RegistMarkHis> queryRegistMarkHisListByIdCode(PageRequest request) throws Exception;
    
    /**
     * 
     * 描述   根据uid查询
     * @author 赵祥江
     * @date 2017年3月23日 下午12:50:19 
     * @param 
     * @return RegistMarkHis
     * @throws
     */
    public RegistMarkHis selectRegistMarkHisListByIdCode(String markUuid) throws Exception;
    
    /**
     * 
     * 描述   插入
     * @author 赵祥江
     * @date 2017年3月23日 下午7:43:47 
     * @param 
     * @return void
     * @throws
     */
    public void  insertRegistMark(RegistMarkHis registMarkHis) throws Exception;
    
    
    /** 
     * 描述: 根据code删除对应记录
     * @author 张文男
     * @date 2017年4月20日 
     * @param idcode 
     */
    
    public void deleteByIDCode(String idcode);

}