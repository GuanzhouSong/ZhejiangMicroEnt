/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.writ.mapper.DzqzMapper;
import com.icinfo.cs.writ.model.Dzqz;
import com.icinfo.cs.writ.service.IDzqzService;
import com.icinfo.cs.yr.model.Signature;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_dzqz 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
@Service
public class DzqzServiceImpl extends MyBatisServiceSupport implements IDzqzService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(DzqzServiceImpl.class);

    @Autowired
    private DzqzMapper dzqzMapper;

    @Override
    public Dzqz selectbyWritUuid(String writUuid) {
        if(StringUtil.isNotBlank(writUuid)){
            Dzqz dzqz = new Dzqz();
            dzqz.setWritUuid(writUuid);
            return dzqzMapper.selectOne(dzqz);
        }
        return null;
    }

    @Override
    public int modify(Dzqz dzqz) {
        if(StringUtil.isNotBlank(dzqz.getWritUuid())) {
            dzqz.setQzStatus("1"); //修改为签章成功状态
            Example example = new Example(Signature.class);
            example.createCriteria().andEqualTo("writUuid", dzqz.getWritUuid());
            return dzqzMapper.updateByExample(dzqz,example);
        }
        return 0;
    }

    @Override
    public int save(String year, String pripid, String sealImgBase64, String writUuid) {
        int i=0;
        if(StringUtil.checkYearAndPripid(year,pripid)&&StringUtil.isNotBlank(sealImgBase64)&&StringUtil.isNotBlank(writUuid)){
            Dzqz dzqz = new Dzqz();
            dzqz.setYear(Integer.valueOf(year));
            dzqz.setCreateTime(DateUtil.getSysDate());
            dzqz.setPriPID(pripid);
            dzqz.setQzStatus("1");//签章成功
            dzqz.setQzTime(DateUtil.getSysDate());//签章时间
            dzqz.setImageCode(sealImgBase64);
            dzqz.setWritUuid(writUuid);
            try {
               return i = dzqzMapper.insert(dzqz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }


    @Override
    public int modifyStatus(Dzqz dzqz) {
        int i = 0;
        if (dzqz != null && StringUtil.isNotBlank(dzqz.getWritUuid())) {
            dzqz.setQzStatus("0"); //修改为签章失败状态
            Example example = new Example(Signature.class);
            example.createCriteria().andEqualTo("writUuid", dzqz.getWritUuid());
            i = dzqzMapper.updateByExample(dzqz, example);
        }
        return i;
    }
}