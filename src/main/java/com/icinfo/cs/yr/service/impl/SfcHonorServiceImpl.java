/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.SfcHonorMapper;
import com.icinfo.cs.yr.model.SfcHonor;
import com.icinfo.cs.yr.service.ISfcHonorService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_sfc_honor 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Service
public class SfcHonorServiceImpl extends MyBatisServiceSupport implements ISfcHonorService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcHonorServiceImpl.class);


    @Autowired
    private SfcHonorMapper sfcHonorMapper;



    /** 更新数据
     * @author: wangjin
     * @param sfcHonor
     * @return
     */
    @Override
    public int update(SfcHonor sfcHonor) {
        if(StringUtil.isNotEmpty(sfcHonor.getPriPID())){
            sfcHonor.setCreateTime(DateUtils.getSysDate()); //时间戳
            Example example = new Example(SfcHonor.class);
            example.createCriteria().andEqualTo("uid", sfcHonor.getUid());

            return sfcHonorMapper.updateByExample(sfcHonor,example);
        }
        return 0;

    }

    /** 新增数据
     * @author: wangjin
     * @param sfcHonor
     * @return
     */
    @Override
    public int insert(SfcHonor sfcHonor) {
        sfcHonor.setCreateTime(DateUtils.getSysDate());
        return sfcHonorMapper.insert(sfcHonor);
    }

    /**
     * 数据列表 条件查询
     * @param request
     * @return
     */
    @Override
    public List<SfcHonor> select_queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Example example = new Example(SfcHonor.class);
        Map<String, Object> searchMap=  request.getParams();
        String priPID = searchMap.get(Constants.CS_PRIPID).toString();
        String year = searchMap.get(Constants.CS_YEAR).toString();
        if(StringUtil.isNotEmpty(priPID)&&StringUtil.isNotEmpty(year)){
            example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);
            example.setOrderByClause(" CreateTime desc ");
            return sfcHonorMapper.selectByExample(example);
        }
        return null;
    }

    /**
     * 批量删除
     * @author: wangjim
     * @param list_uids
     * @return
     */
    @Override
    public int batch_delete(List<String> list_uids,String priPID) {
        if(StringUtil.isNotEmpty(priPID)){
            SfcHonor sfcHonor = null;
            int num = 0;
            for(String uid:list_uids){
                sfcHonor = new SfcHonor();
                sfcHonor.setUid(uid);
                sfcHonorMapper.delete(sfcHonor);
                num++;
            }
            return num;
        }
        return 0;
    }

    /**
     * 根据uid 查询一个对象
     * @param uid
     * @return
     */
    @Override
    public SfcHonor selectByUid(String uid,String priPID) {
        if(StringUtil.isNotEmpty(priPID)){
            SfcHonor sfcHonor = new SfcHonor();
            sfcHonor.setUid(uid);
            sfcHonor.setPriPID(priPID);
            return sfcHonorMapper.selectOne(sfcHonor);
        }
        return null;
    }


}