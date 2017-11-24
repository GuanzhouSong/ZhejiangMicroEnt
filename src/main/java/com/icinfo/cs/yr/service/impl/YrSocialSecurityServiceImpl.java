/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.YrSocialSecurityMapper;
import com.icinfo.cs.yr.model.YrSocialSecurity;
import com.icinfo.cs.yr.service.IYrSocialSecurityService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述:  cs_yr_social_security 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Service
public class YrSocialSecurityServiceImpl extends MyBatisServiceSupport implements IYrSocialSecurityService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(YrSocialSecurityServiceImpl.class);

    @Autowired
    private YrSocialSecurityMapper yrSocialSecurityMapper;

    /**
     * 根据年份和主体身份代码进行查询
     * @author: wangjin
     * @return
     */
    @Override
    public YrSocialSecurity selectByYearAndPripid(Integer year, String priPID) {
        if(StringUtil.isNotEmpty(priPID)&&year!=null){
            YrSocialSecurity yrSocialSecurity = new YrSocialSecurity();
            yrSocialSecurity.setYear(year);
            yrSocialSecurity.setPriPID(priPID);
            yrSocialSecurity = yrSocialSecurityMapper.selectOne(yrSocialSecurity);
            if(yrSocialSecurity!=null){

                /**
                 * 单位缴费基数-城镇职工基本养老保险
                 */
                yrSocialSecurity.setPaymentEndowment(yrSocialSecurity.getPaymentEndowment()==null?null:yrSocialSecurity.getPaymentEndowment().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位缴费基数-失业保险
                 */
                yrSocialSecurity.setPaymentUnemployment(yrSocialSecurity.getPaymentUnemployment()==null?null:yrSocialSecurity.getPaymentUnemployment().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位缴费基数-医疗保险
                 */
                yrSocialSecurity.setPaymentMedical(yrSocialSecurity.getPaymentMedical()==null?null:yrSocialSecurity.getPaymentMedical().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位缴费基数-工伤保险
                 */
                yrSocialSecurity.setPaymentEmpInjury(yrSocialSecurity.getPaymentEmpInjury()==null?null:yrSocialSecurity.getPaymentEmpInjury().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位缴费基数-生育保险
                 */
                yrSocialSecurity.setPaymentMaternity(yrSocialSecurity.getPaymentMaternity()==null?null:yrSocialSecurity.getPaymentMaternity().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 本期实际缴费金额-城镇职工基本养老保险
                 */
                yrSocialSecurity.setActualPayEndowment(yrSocialSecurity.getActualPayEndowment()==null?null:yrSocialSecurity.getActualPayEndowment().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 本期实际缴费金额-失业保险
                 */
                yrSocialSecurity.setActualPayUnemployment(yrSocialSecurity.getActualPayUnemployment()==null?null:yrSocialSecurity.getActualPayUnemployment().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 本期实际缴费金额-医疗保险
                 */
                yrSocialSecurity.setActualPayMedical(yrSocialSecurity.getActualPayMedical()==null?null:yrSocialSecurity.getActualPayMedical().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 本期实际缴费金额-工伤保险
                 */
                yrSocialSecurity.setActualPayEmpInjury(yrSocialSecurity.getActualPayEmpInjury()==null?null:yrSocialSecurity.getActualPayEmpInjury().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 本期实际缴费金额-生育保险
                 */
                yrSocialSecurity.setActualPayMaternity(yrSocialSecurity.getActualPayMaternity()==null?null:yrSocialSecurity.getActualPayMaternity().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位累计欠缴金额-城镇职工基本养老保险
                 */
                yrSocialSecurity.setCumuEndowment(yrSocialSecurity.getCumuEndowment()==null?null:yrSocialSecurity.getCumuEndowment().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位累计欠缴金额-失业保险
                 */
                yrSocialSecurity.setCumuUnemployment(yrSocialSecurity.getCumuUnemployment()==null?null:yrSocialSecurity.getCumuUnemployment().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位累计欠缴金额-医疗保险
                 */
                yrSocialSecurity.setCumuMedical(yrSocialSecurity.getCumuMedical()==null?null:yrSocialSecurity.getCumuMedical().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位累计欠缴金额-工伤保险
                 */
                yrSocialSecurity.setCumuEmpInjury(yrSocialSecurity.getCumuEmpInjury()==null?null:yrSocialSecurity.getCumuEmpInjury().setScale(4,BigDecimal.ROUND_HALF_UP));

                /**
                 * 单位累计欠缴金额-生育保险
                 */
                yrSocialSecurity.setCumuMaternity(yrSocialSecurity.getCumuMaternity()==null?null:yrSocialSecurity.getCumuMaternity().setScale(4,BigDecimal.ROUND_HALF_UP));
                //单位缴费基数总额
                yrSocialSecurity.setPaymentBase(yrSocialSecurity.getPaymentBase()==null?null:yrSocialSecurity.getPaymentBase().setScale(4,BigDecimal.ROUND_HALF_UP));
                //单位累计欠缴金额总额
                yrSocialSecurity.setCumulArrears(yrSocialSecurity.getCumulArrears()==null?null:yrSocialSecurity.getCumulArrears().setScale(4,BigDecimal.ROUND_HALF_UP));
                //本期实际缴费金额总额
                yrSocialSecurity.setActualPayment(yrSocialSecurity.getActualPayment()==null?null:yrSocialSecurity.getActualPayment().setScale(4,BigDecimal.ROUND_HALF_UP));
            }
            return yrSocialSecurity;
        }
        return null;

    }

    /**
     * 更新数据
     * @autor: wangjin
     * @param yrSocialSecurity
     * @return
     */
    @Override
    public int update(YrSocialSecurity yrSocialSecurity) {
        if(StringUtil.isNotEmpty(yrSocialSecurity.getPriPID())){
            Example example = new Example(YrSocialSecurity.class);
            //yrSocialSecurity.setCreateTime(DateUtil.getSysDate());
            example.createCriteria().andEqualTo("socialID", yrSocialSecurity.getSocialID()).andEqualTo("priPID",yrSocialSecurity.getPriPID());
            return yrSocialSecurityMapper.updateByExampleSelective(yrSocialSecurity,example);
        }
        return 0;

    }

    /**
     * 新增数据
     * @autor: wangjin
     * @param yrSocialSecurity
     * @return
     */
    @Override
    public int insert(YrSocialSecurity yrSocialSecurity) {
        //时间戳
        yrSocialSecurity.setCreateTime(DateUtil.getSysDate());
        return yrSocialSecurityMapper.insert(yrSocialSecurity);
    }


}