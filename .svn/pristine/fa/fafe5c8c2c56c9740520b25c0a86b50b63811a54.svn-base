/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.yr.mapper.YrSfcBaseinfoMapper;
import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.cs.yr.service.IYrSfcBaseinfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_sfc_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
@Service
public class YrSfcBaseinfoServiceImpl extends MyBatisServiceSupport implements IYrSfcBaseinfoService {

	@Autowired
	private YrSfcBaseinfoMapper yrSfcBaseinfoMapper;
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param
	 * @param year
	 * @return
	 */
	@Override
	public List<YrSfcBaseinfo> selectYrSfcBaseInfoList(String priPID, int year)
			throws Exception {
		Example example = new Example(YrSfcBaseinfo.class);
		example.createCriteria().andEqualTo("priPID",priPID);
		example.createCriteria().andEqualTo("year",year);
		return yrSfcBaseinfoMapper.selectByExample(example);
	}

	/**
	 * 根据年份和主体身份代码进行查询
	 * @param year
	 * @param
	 * @param flag(是否将万元转化为元，1转化，0不转化)
     * @return
     */
	@Override
	public YrSfcBaseinfo selectYrSfcBaseInfoByYearAndPripid(String year, String priPID, String flag) throws Exception {
		if(StringUtil.isNotEmpty(year)&&StringUtil.isNotEmpty(priPID)){
			try {
				YrSfcBaseinfo yrSfcBaseinfo = new YrSfcBaseinfo();
				yrSfcBaseinfo.setYear(Integer.valueOf(year));
				yrSfcBaseinfo.setPriPID(priPID);
				if(flag.equals("1")){//须将万元转化为元（进入填报页时使用）
					return doWapMulitplyYrPbBaseInfo(yrSfcBaseinfoMapper.selectOne(yrSfcBaseinfo));
				}else{//直接万元展示（预览页）
					return yrSfcBaseinfoMapper.selectOne(yrSfcBaseinfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
	            throw new BusinessException(e.getMessage()+"查询年报基本信息失败！");
			}
		}
        throw new BusinessException("查询参数不完整！");

	}
	
	/**
	 * 
	 * 描述: 将万元转化为元(农专基本信息表中金额数据)
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param selectOne
	 * @return
	 */
	private YrSfcBaseinfo doWapMulitplyYrPbBaseInfo(YrSfcBaseinfo yrSfcBaseinfo) {
		if(yrSfcBaseinfo == null){
			return yrSfcBaseinfo;
		}
		//资金数额
		yrSfcBaseinfo.setMemConGro(yrSfcBaseinfo.getMemConGro() == null ? null : yrSfcBaseinfo.getMemConGro().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		yrSfcBaseinfo.setRatGro(yrSfcBaseinfo.getRatGro() == null ? null : yrSfcBaseinfo.getRatGro().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		yrSfcBaseinfo.setVendInc(yrSfcBaseinfo.getVendInc() == null ? null : yrSfcBaseinfo.getVendInc().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		yrSfcBaseinfo.setPriYeaProfit(yrSfcBaseinfo.getPriYeaProfit() == null ? null : yrSfcBaseinfo.getPriYeaProfit().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		yrSfcBaseinfo.setPriYeaSub(yrSfcBaseinfo.getPriYeaSub() == null ? null : yrSfcBaseinfo.getPriYeaSub().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		yrSfcBaseinfo.setPriYeaLoan(yrSfcBaseinfo.getPriYeaLoan() == null ? null : yrSfcBaseinfo.getPriYeaLoan().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		//百分数截取为3位小数
		yrSfcBaseinfo.setCreditMem(yrSfcBaseinfo.getCreditMem() == null ? null : yrSfcBaseinfo.getCreditMem().setScale(3, BigDecimal.ROUND_HALF_UP));
		
		return yrSfcBaseinfo;
	}

	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param yrSfcBaseInfo
	 * @return
	 */
	@Override
	public int saveYrSfcBaseInfo(YrSfcBaseinfo yrSfcBaseInfo) throws Exception {
		yrSfcBaseInfo.setCreateTime(new Date());
		yrSfcBaseInfo.setSubDate(new Date());
		yrSfcBaseInfo = doWapDivideYrPbBaseInfo(yrSfcBaseInfo);
		return yrSfcBaseinfoMapper.insert(yrSfcBaseInfo);
	}

	/**
	 * 
	 * 描述: 将元转化为万元(农专基本信息表中金额数据)
	 * @auther gaojinling
	 * @date 2016年9月27日 
	 * @param
	 * @return
	 */
	 private YrSfcBaseinfo doWapDivideYrPbBaseInfo(YrSfcBaseinfo yrSfcBaseinfo) {
		 if(yrSfcBaseinfo == null){
				return yrSfcBaseinfo;
			}
			//资金数额
			yrSfcBaseinfo.setMemConGro(yrSfcBaseinfo.getMemConGro() == null ? null : yrSfcBaseinfo.getMemConGro().divide(new BigDecimal(10000)));
		  
			yrSfcBaseinfo.setRatGro(yrSfcBaseinfo.getRatGro() == null ? null : yrSfcBaseinfo.getRatGro().divide(new BigDecimal(10000)));
			
			yrSfcBaseinfo.setVendInc(yrSfcBaseinfo.getVendInc() == null ? null : yrSfcBaseinfo.getVendInc().divide(new BigDecimal(10000)));
			
			yrSfcBaseinfo.setPriYeaProfit(yrSfcBaseinfo.getPriYeaProfit() == null ? null : yrSfcBaseinfo.getPriYeaProfit().divide(new BigDecimal(10000)));
			
			yrSfcBaseinfo.setPriYeaSub(yrSfcBaseinfo.getPriYeaSub() == null ? null : yrSfcBaseinfo.getPriYeaSub().divide(new BigDecimal(10000)));
			
			yrSfcBaseinfo.setPriYeaLoan(yrSfcBaseinfo.getPriYeaLoan() == null ? null : yrSfcBaseinfo.getPriYeaLoan().divide(new BigDecimal(10000)));
			
			return yrSfcBaseinfo;
	}

	/**
     * 
     * 描述: 更新（通过年份和主体代码更新）
     * @auther gaojinling
     * @date 2016年8月31日 
     * @param yrSfcBaseinfo
     * @return
     */
	@Override
	public int updateYrSfcBaseinfoByPriPidAndYear(YrSfcBaseinfo yrSfcBaseinfo)
			throws Exception {
		Example example = new Example(YrSfcBaseinfo.class);
		example.createCriteria().andEqualTo("priPID",yrSfcBaseinfo.getPriPID())
		.andEqualTo("year",yrSfcBaseinfo.getYear()).andEqualTo("anCheID",yrSfcBaseinfo.getAnCheID());
		yrSfcBaseinfo.setCreateTime(new Date());
		yrSfcBaseinfo.setSubDate(new Date());
		yrSfcBaseinfo = doWapDivideYrPbBaseInfo(yrSfcBaseinfo);
		return yrSfcBaseinfoMapper.updateByExampleSelective(yrSfcBaseinfo, example);
	}
	
	
    /**
     * 
     * 描述: 由yrSfcBaseinfo得到YrSfcSocialSecurity
     * @auther gaojinling
     * @date 2016年12月22日 
     * @return
     * @throws Exception
     */
    public YrSfcSocialSecurity baseinfotransformSocialSecurity(YrSfcBaseinfo yrSfcBaseinfo,YrSfcSocialSecurity yrSfcSocialSecurity) throws Exception{
    	if(yrSfcBaseinfo == null ){
    		return yrSfcSocialSecurity;
    	}
    	if(yrSfcSocialSecurity == null){
    		yrSfcSocialSecurity = new YrSfcSocialSecurity();
    	}
    	yrSfcSocialSecurity.setAnCheID(yrSfcBaseinfo.getAnCheID());
    	yrSfcSocialSecurity.setPriPID(yrSfcBaseinfo.getPriPID());
    	yrSfcSocialSecurity.setYear(yrSfcBaseinfo.getYear());
    	yrSfcSocialSecurity.setUniCode(yrSfcBaseinfo.getUniCode());
    	yrSfcSocialSecurity.setRegNO(yrSfcBaseinfo.getRegNO());
    	yrSfcSocialSecurity.setEntName(yrSfcBaseinfo.getFarSpeArtName());
    	return yrSfcSocialSecurity;
    }

}