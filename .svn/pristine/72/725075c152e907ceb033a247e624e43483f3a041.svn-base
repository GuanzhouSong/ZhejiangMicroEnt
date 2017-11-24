/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.SfcFormMapper;
import com.icinfo.cs.yr.model.SfcForm;
import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.cs.yr.service.ISfcFormService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_sfc_form 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月05日
 */
@Service
public class SfcFormServiceImpl extends MyBatisServiceSupport implements ISfcFormService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcFormServiceImpl.class);

    @Autowired
    private SfcFormMapper sfcFormMapper;

    /**
     * 描述: 查询当年度表单填写情况
     * @auther wangjin
     * @param priPID
     * @param year
     * @return
     * @throws Exception
     */
    @Override
    public SfcForm selectSfcFormByPripidAndYear(String priPID, Integer year) throws Exception {
        if(StringUtils.isNotBlank(priPID)&&year!=null){
            SfcForm sfcForm = new SfcForm();
            sfcForm.setPriPID(priPID);
            sfcForm.setYear(year);
            return sfcFormMapper.selectOne(sfcForm);
        }
        return null;

    }

    /**
     * 描述: 初始化农专当年度表单填写情况
     * @auther ZhouYan
     * @date 2016年9月13日
     * @param pripid
     * @param year
     * @return
     * @throws Exception
     */
    @Override
    public int insert(String pripid, Integer year) {
        SfcForm sfcForm = new SfcForm();
        sfcForm.setPriPID(pripid);
        sfcForm.setYear(year);
        sfcForm.setCreateTime(DateUtils.getSysDate());
        sfcForm.setCominfo("0");      //综合信息
        sfcForm.setBalanctsheet("0"); //资产负债
        sfcForm.setIncstatement("0"); //盈余及分配
        sfcForm.setIncomechange("0"); //成员权益变动
        return sfcFormMapper.insert(sfcForm);
    }

    @Override
    public int updateForm(SfcForm sfcForm) {
        //时间戳
        //sfcForm.setCreateTime(DateUtil.getSysDate());
        Example example = new Example(YrForm.class);
        example.createCriteria().andEqualTo(Constants.CS_YEAR, sfcForm.getYear()).andEqualTo(Constants.CS_PRIPID,sfcForm.getPriPID());
        return sfcFormMapper.updateByExampleSelective(sfcForm,example);
    }

}