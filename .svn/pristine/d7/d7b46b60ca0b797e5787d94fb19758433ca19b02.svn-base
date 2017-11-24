/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.datamodify.service.impl;

import com.icinfo.cs.common.utils.CsStringUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.datamodify.mapper.ApplyDataModifyMapper;
import com.icinfo.cs.datamodify.model.ApplyDataModify;
import com.icinfo.cs.datamodify.service.IApplyDataModifyService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_apply_data_modify 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
@Service
public class ApplyDataModifyServiceImpl extends MyBatisServiceSupport implements IApplyDataModifyService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplyDataModifyServiceImpl.class);

    @Autowired
    private ApplyDataModifyMapper applyDataModifyMapper;

    /**
     *@描述:获取数据
     *@author: wangjin
     *@date 2017-11-22 10:11
     *@return
     */
    @Override
    public List<ApplyDataModify> search_result(PageRequest request) throws Exception {
        Map<String, Object> searchMap = CsStringUtil.getMapParams(request.getParams());
        PageHelper.startPage(request.getPageNum(), request.getLength());
        return applyDataModifyMapper.selectByParams(searchMap);
    }

    @Override
    public int save(ApplyDataModify applyDataModify) {
        try{
            Date sysdate = DateUtils.getSysDate();
          /*  applyDataModify.setApplyDate(sysdate);
            applyDataModify.setFeedbackDate(sysdate);*/
            applyDataModify.setUid(StringUtil.uuid());
            applyDataModify.setCreateTime(sysdate);
            return applyDataModifyMapper.insert(applyDataModify);
        }catch (Exception e ){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ApplyDataModify selectByUid(String uid) {
        if(CsStringUtil.isNotBlank(uid)){
            ApplyDataModify dataModify = new ApplyDataModify();
            dataModify.setUid(uid);
            return applyDataModifyMapper.selectOne(dataModify);
        }
        return null;
    }
}