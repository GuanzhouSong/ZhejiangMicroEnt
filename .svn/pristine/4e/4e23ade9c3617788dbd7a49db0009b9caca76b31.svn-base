/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.registinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.registinfo.mapper.RegistMarkHisMapper;
import com.icinfo.cs.registinfo.model.RegistMarkHis;
import com.icinfo.cs.registinfo.service.IRegistMarkHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_regist_mark 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class RegistMarkHisServiceImpl extends MyBatisServiceSupport implements IRegistMarkHisService {

    @Autowired
    private RegistMarkHisMapper registMarkHisMapper;

    /**
     * 
     * 描述   根据标签编号查询
     * @author  赵祥江
     * @date 2017年3月23日 下午12:56:07 
     * @param  
     * @throws
     */
    @Override
    public List<RegistMarkHis> queryRegistMarkHisListByIdCode(PageRequest request) throws Exception{
        PageHelper.startPage (request.getPageNum (), request.getLength ());
        return registMarkHisMapper.selectRegistMarkHisListByIdCode (request.getParams ());
    }

    /**
     * 
     * 描述   根据主键查询
     * @author  赵祥江
     * @date 2017年3月23日 下午12:53:22 
     * @param  
     * @throws
     */
    @Override
    public RegistMarkHis selectRegistMarkHisListByIdCode(String markUuid) throws Exception{
        if (com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty (markUuid)) {
            RegistMarkHis registMarkHis = new RegistMarkHis ();
            registMarkHis.setMarkUuid (markUuid);
            return registMarkHisMapper.selectOne (registMarkHis);
        }
        return null;
    }

    /**
     * 
     * 描述   插入
     * @author  赵祥江
     * @date 2017年3月23日 下午7:48:43 
     * @param  
     * @throws
     */
    @Override
    public void insertRegistMark(RegistMarkHis registMarkHis) throws Exception{
        registMarkHis.setCreateTime (DateUtil.getSysDate ());
        registMarkHisMapper.insert (registMarkHis);

    }
    /** 
     * 描述: 根据code删除对应记录
     * @author 张文男
     * @date 2017年4月20日 
     * @param idcode 
     */
    
    public void deleteByIDCode(String idcode){
        registMarkHisMapper.deleteByIDCode (idcode);
    }
}