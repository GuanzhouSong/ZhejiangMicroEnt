/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.icinfo.cs.yr.mapper.YrSfcSocialSecurityMapper;
import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.cs.yr.service.IYrSfcSocialSecurityService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_sfc_social_security 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年12月21日
 */
@Service
public class YrSfcSocialSecurityServiceImpl extends MyBatisServiceSupport implements IYrSfcSocialSecurityService {

	@Autowired
	private YrSfcSocialSecurityMapper  yrSfcSocialSecurityMapper;
	/**
	 * 
	 * 描述:根绝年报id查询社保信息
	 * @auther gaojinling
	 * @date 2017年12月21日 
	 * @param anCheID
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@Override
	public YrSfcSocialSecurity selectYrSfcSocialSecurityByAnCheID(String anCheID, String flag) throws Exception {
		YrSfcSocialSecurity yrSfcSocialSecurity = new YrSfcSocialSecurity();
		yrSfcSocialSecurity.setAnCheID(anCheID);
		if("1".equals(flag)){//截取4位
			return doWapMulitply(yrSfcSocialSecurityMapper.selectOne(yrSfcSocialSecurity));
		}else{//直接万元展示（预览页）
			return yrSfcSocialSecurityMapper.selectOne(yrSfcSocialSecurity);
		}
	}
	
	/**
	 * 
	 * 描述: 将万元转化为元(农专社保信息表中金额数据)
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param yrSfcSocialSecurity
	 * @return
	 */
	private YrSfcSocialSecurity doWapMulitply(YrSfcSocialSecurity yrSfcSocialSecurity) {
		if(yrSfcSocialSecurity == null){
			return yrSfcSocialSecurity;
		}
        /**
         * 单位缴费基数-城镇职工基本养老保险
         */
        yrSfcSocialSecurity.setPaymentEndowment(yrSfcSocialSecurity.getPaymentEndowment()==null?null:yrSfcSocialSecurity.getPaymentEndowment().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位缴费基数-失业保险
         */
        yrSfcSocialSecurity.setPaymentUnemployment(yrSfcSocialSecurity.getPaymentUnemployment()==null?null:yrSfcSocialSecurity.getPaymentUnemployment().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位缴费基数-医疗保险
         */
        yrSfcSocialSecurity.setPaymentMedical(yrSfcSocialSecurity.getPaymentMedical()==null?null:yrSfcSocialSecurity.getPaymentMedical().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位缴费基数-工伤保险
         */
        yrSfcSocialSecurity.setPaymentEmpInjury(yrSfcSocialSecurity.getPaymentEmpInjury()==null?null:yrSfcSocialSecurity.getPaymentEmpInjury().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位缴费基数-生育保险
         */
        yrSfcSocialSecurity.setPaymentMaternity(yrSfcSocialSecurity.getPaymentMaternity()==null?null:yrSfcSocialSecurity.getPaymentMaternity().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 本期实际缴费金额-城镇职工基本养老保险
         */
        yrSfcSocialSecurity.setActualPayEndowment(yrSfcSocialSecurity.getActualPayEndowment()==null?null:yrSfcSocialSecurity.getActualPayEndowment().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 本期实际缴费金额-失业保险
         */
        yrSfcSocialSecurity.setActualPayUnemployment(yrSfcSocialSecurity.getActualPayUnemployment()==null?null:yrSfcSocialSecurity.getActualPayUnemployment().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 本期实际缴费金额-医疗保险
         */
        yrSfcSocialSecurity.setActualPayMedical(yrSfcSocialSecurity.getActualPayMedical()==null?null:yrSfcSocialSecurity.getActualPayMedical().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 本期实际缴费金额-工伤保险
         */
        yrSfcSocialSecurity.setActualPayEmpInjury(yrSfcSocialSecurity.getActualPayEmpInjury()==null?null:yrSfcSocialSecurity.getActualPayEmpInjury().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 本期实际缴费金额-生育保险
         */
        yrSfcSocialSecurity.setActualPayMaternity(yrSfcSocialSecurity.getActualPayMaternity()==null?null:yrSfcSocialSecurity.getActualPayMaternity().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位累计欠缴金额-城镇职工基本养老保险
         */
        yrSfcSocialSecurity.setCumuEndowment(yrSfcSocialSecurity.getCumuEndowment()==null?null:yrSfcSocialSecurity.getCumuEndowment().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位累计欠缴金额-失业保险
         */
        yrSfcSocialSecurity.setCumuUnemployment(yrSfcSocialSecurity.getCumuUnemployment()==null?null:yrSfcSocialSecurity.getCumuUnemployment().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位累计欠缴金额-医疗保险
         */
        yrSfcSocialSecurity.setCumuMedical(yrSfcSocialSecurity.getCumuMedical()==null?null:yrSfcSocialSecurity.getCumuMedical().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位累计欠缴金额-工伤保险
         */
        yrSfcSocialSecurity.setCumuEmpInjury(yrSfcSocialSecurity.getCumuEmpInjury()==null?null:yrSfcSocialSecurity.getCumuEmpInjury().setScale(4,BigDecimal.ROUND_HALF_UP));

        /**
         * 单位累计欠缴金额-生育保险
         */
        yrSfcSocialSecurity.setCumuMaternity(yrSfcSocialSecurity.getCumuMaternity()==null?null:yrSfcSocialSecurity.getCumuMaternity().setScale(4,BigDecimal.ROUND_HALF_UP));
        //单位缴费基数总额
        yrSfcSocialSecurity.setPaymentBase(yrSfcSocialSecurity.getPaymentBase()==null?null:yrSfcSocialSecurity.getPaymentBase().setScale(4,BigDecimal.ROUND_HALF_UP));
        //单位累计欠缴金额总额
        yrSfcSocialSecurity.setCumulArrears(yrSfcSocialSecurity.getCumulArrears()==null?null:yrSfcSocialSecurity.getCumulArrears().setScale(4,BigDecimal.ROUND_HALF_UP));
        //本期实际缴费金额总额
        yrSfcSocialSecurity.setActualPayment(yrSfcSocialSecurity.getActualPayment()==null?null:yrSfcSocialSecurity.getActualPayment().setScale(4,BigDecimal.ROUND_HALF_UP));
		
		return yrSfcSocialSecurity;
	}

	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年12月21日 
	 * @param yrSfcSocialSecurity
	 * @return
	 * @throws Exception
	 */
	@Override
	public int saveYrSfcSocialSecurity(YrSfcSocialSecurity yrSfcSocialSecurity)
			throws Exception {
		yrSfcSocialSecurity.setCreateTime(new Date());
		yrSfcSocialSecurity = doWapDivide(yrSfcSocialSecurity);
		return yrSfcSocialSecurityMapper.insert(yrSfcSocialSecurity);
	}
	
	/**
	 * 
	 * 描述: 将元转化为万元(农专社保信息表中金额数据)
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param yrSfcBaseInfo
	 * @return
	 */
	 private YrSfcSocialSecurity doWapDivide(YrSfcSocialSecurity yrSfcSocialSecurity) {
		 if(yrSfcSocialSecurity == null){
				return yrSfcSocialSecurity;
			}
			//资金数额
//			yrSfcBaseinfo.setMemConGro(yrSfcBaseinfo.getMemConGro() == null ? null : yrSfcBaseinfo.getMemConGro().divide(new BigDecimal(10000)));
//		  
//			yrSfcBaseinfo.setRatGro(yrSfcBaseinfo.getRatGro() == null ? null : yrSfcBaseinfo.getRatGro().divide(new BigDecimal(10000)));
//			
//			yrSfcBaseinfo.setVendInc(yrSfcBaseinfo.getVendInc() == null ? null : yrSfcBaseinfo.getVendInc().divide(new BigDecimal(10000)));
//			
//			yrSfcBaseinfo.setPriYeaProfit(yrSfcBaseinfo.getPriYeaProfit() == null ? null : yrSfcBaseinfo.getPriYeaProfit().divide(new BigDecimal(10000)));
//			
//			yrSfcBaseinfo.setPriYeaSub(yrSfcBaseinfo.getPriYeaSub() == null ? null : yrSfcBaseinfo.getPriYeaSub().divide(new BigDecimal(10000)));
//			
//			yrSfcBaseinfo.setPriYeaLoan(yrSfcBaseinfo.getPriYeaLoan() == null ? null : yrSfcBaseinfo.getPriYeaLoan().divide(new BigDecimal(10000)));
			
			return yrSfcSocialSecurity;
	}


	/**
	 * 
	 * 描述:更新（主键socialID）
	 * @auther gaojinling
	 * @date 2017年12月21日 
	 * @param yrSfcSocialSecurity
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateYrSfcSocialSecurityByID(
			YrSfcSocialSecurity yrSfcSocialSecurity) throws Exception {
		Example example = new Example(YrSfcSocialSecurity.class);
		example.createCriteria().andEqualTo("priPID",yrSfcSocialSecurity.getPriPID())
		.andEqualTo("year",yrSfcSocialSecurity.getYear()).andEqualTo("anCheID",yrSfcSocialSecurity.getAnCheID());
		yrSfcSocialSecurity.setCreateTime(new Date());
		yrSfcSocialSecurity = doWapDivide(yrSfcSocialSecurity);
		return yrSfcSocialSecurityMapper.updateByExampleSelective(yrSfcSocialSecurity, example);
	}
	
}