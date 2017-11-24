/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.govguide.service.impl;

import com.icinfo.cs.common.utils.StringToInUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.govguide.mapper.GovguideMapper;
import com.icinfo.cs.govguide.model.Govguide;
import com.icinfo.cs.govguide.service.IGovguideService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_govguide_set 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Service
public class GovguideServiceImpl extends MyBatisServiceSupport implements IGovguideService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(GovguideServiceImpl.class);

    @Autowired
    private GovguideMapper govguideMapper;
    @Autowired
    private MidBaseInfoMapper midBaseInfoMapper;

    @Override
    public Govguide getGovGuideByUid(String uid) {

        Govguide govguide = new Govguide();
        if(StringUtil.isEmpty(uid))return govguide;
        govguide.setUid(uid);
        Govguide govguide1 = govguideMapper.selectOne(govguide);
        return govguide1;
    }

    @Override
    public List<Govguide> govguide_querypage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        StringToInUtil.strToIn(request.getParams());
        return govguideMapper.govguide_querypage(request.getParams());
    }

    @Override
    public List<MidBaseInfo> midbaseinfoForAdd_querypage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        StringToInUtil.strToIn(request.getParams());
        return midBaseInfoMapper.midbaseinfoForGovuideAdd_querypage(request.getParams());
    }

    @Override
    public List<Govguide> govguidecheck_querypage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        StringToInUtil.strToIn(request.getParams());
        return govguideMapper.govguidecheck_querypage(request.getParams());
    }

    @Override
    public int modiGovSet(Govguide govguide) {
        if(StringUtil.isEmpty(govguide.getUid())){
            govguide.setEfftstatus("2");//有效状态 2在流程中
            govguide.setAuditstate("0");//审核状态 未审核
          return  govguideMapper.insert(govguide);
        }else{
            Example example = new Example(Govguide.class);
            example.createCriteria().andEqualTo("uid",govguide.getUid());
            int res = totalDocNum(govguide);//设置企业文号
            if(res==-1) return res;
            return govguideMapper.updateByExampleSelective(govguide,example);
        }

    }

    /**
     * 审核通过设置行政指导书文号
     * @param govguide
     * @return
     */
    private int totalDocNum(Govguide govguide) {
        if("1".equals(govguide.getAuditstate())){         //审核通过才能设置
            Govguide govguide_pen = govguideMapper.totalDocNum(govguide);
            if(govguide_pen.getPendecno().indexOf("##")>-1)return -1;
            govguide.setPendecno(govguide_pen.getPendecno());
            govguide.setSeqyear(String.valueOf(LocalDate.now().getYear()));
        }
        return 1;
    }

    @Override
    public int delGovSet(String uid) {
        if(StringUtil.isEmpty(uid))
        return 0;
        Govguide govguide = new Govguide();
        govguide.setUid(uid);
        return govguideMapper.delete(govguide);
    }

    /**
     * 按照pripid查询主体户口管理的行政指导状态数
     * @param priPID
     * @return
     */
    @Override
    public int getCountByPripid(String priPID) {
        Govguide govguide = new Govguide();
        govguide.setPripid(priPID);
        govguide.setEfftstatus("1");
        return govguideMapper.selectCount(govguide);
    }
    
    /**
     * 
     * 描述: 责令指导待审核条数
     * @auther gaojinling
     * @date 2017年10月18日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectAduitOrdCount(Map<String, Object> map) throws Exception{
    	return govguideMapper.selectAduitOrdCount(map);
    }
    
    /**
     * 
     * 描述: 行政指导待审核条数
     * @auther gaojinling
     * @date 2017年10月18日 
     * @param map
     * @return
     * @throws Exception
     */
    public int selectAduitGovCount(Map<String, Object> map) throws Exception{
    	return govguideMapper.selectAduitGovCount(map);
    }
}