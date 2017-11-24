/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.yr.mapper.YrPbBaseInfoMapper;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_yr_pb_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
@Service
public class YrPbBaseInfoServiceImpl extends MyBatisServiceSupport implements IYrPbBaseInfoService {

	@Autowired
	private YrPbBaseInfoMapper yrPbBaseInfoMapper;
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	public List<YrPbBaseInfo> selectYrPbBaseInfoList(String priPID, int year) throws Exception {
		Example example = new Example(YrPbBaseInfo.class);
		example.createCriteria().andEqualTo("priPID",priPID);
		example.createCriteria().andEqualTo("year",year);
		return yrPbBaseInfoMapper.selectByExample(example);
	}
	
	/**
	 * 根据年份和主体身份代码进行查询
	 * @param year
	 * @param pripid
	 * @param flag(是否将万元转化为元)
     * @return
     */
	@Override
	public YrPbBaseInfo selectYrPbBaseInfoByYearAndPripid(String year, String priPID,String flag) throws Exception {
		YrPbBaseInfo yrPbBaseInfo = new YrPbBaseInfo();
		yrPbBaseInfo.setYear(Integer.valueOf(year));
		yrPbBaseInfo.setPriPID(priPID);
		if(flag.equals("1") ){//须将万元转化为元（进入填报页时使用）
			return doWapMulitplyYrPbBaseInfo(yrPbBaseInfoMapper.selectOne(yrPbBaseInfo));
		}else{//直接万元展示
			return yrPbBaseInfoMapper.selectOne(yrPbBaseInfo);
		}
	}

	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbBaseInfo
	 * @return
	 */
	@Override
	public int saveYrPbBaseInfo(YrPbBaseInfo yrPbBaseInfo) throws Exception {
		yrPbBaseInfo.setCreateTime(new Date());
		yrPbBaseInfo = doWapDivideYrPbBaseInfo(yrPbBaseInfo);
		return yrPbBaseInfoMapper.insert(yrPbBaseInfo);
	}
	

	/**
	 * 
	 * 描述: 根据主体代码和年份更新个体基本信息表
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbBaseInfo
	 * @return
	 */
	@Override
	public int updateYrPbBaseInfoByPriPidAndYear(YrPbBaseInfo yrPbBaseInfo) throws Exception {
		Example example = new Example(YrPbBaseInfo.class);
		example.createCriteria().andEqualTo("priPID",yrPbBaseInfo.getPriPID())
		.andEqualTo("year",yrPbBaseInfo.getYear()).andEqualTo("anCheID",yrPbBaseInfo.getAnCheID());
		yrPbBaseInfo.setCreateTime(new Date());
		yrPbBaseInfo = doWapDivideYrPbBaseInfo(yrPbBaseInfo);
		return yrPbBaseInfoMapper.updateByExampleSelective(yrPbBaseInfo, example);
	}
	
	/**
	 * 
	 * 描述: 删除（通过年份和主体代码）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public int deleteyYrPbBaseInfoByPriPidAndYear(String priPID,int year) throws Exception{
		Example example = new Example(YrPbBaseInfo.class);
		example.createCriteria().andEqualTo("priPID",priPID).andEqualTo("year",year);
		return yrPbBaseInfoMapper.deleteByExample(example);
	}
	
	/**
	 * 
	 * 描述: 个体户接收  （由主表数据对象封装得到基本信息表数据对象）
	 * @auther gaojinling
	 * @date 2016年9月19日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	public YrPbBaseInfo getYrPbBaseinfoByYrRegCheck(YrRegCheck yrRegCheck) throws Exception {
		YrPbBaseInfo yrPbBaseInfo  = new YrPbBaseInfo();
		yrPbBaseInfo.setPriPID(yrRegCheck.getPriPID() == null ? null : yrRegCheck.getPriPID());
		yrPbBaseInfo.setName(yrRegCheck.getLeRep() == null ? null : yrRegCheck.getLeRep());
		yrPbBaseInfo.setRegNO(yrRegCheck.getRegNO() == null ? null : yrRegCheck.getRegNO());
		yrPbBaseInfo.setOpLoc(yrRegCheck.getDom() == null ? null : yrRegCheck.getDom());
		yrPbBaseInfo.setTraName(yrRegCheck.getEntName() == null ? null : yrRegCheck.getEntName());
		yrPbBaseInfo.setUniCode(yrRegCheck.getUniCode() == null ? null : yrRegCheck.getUniCode());
		yrPbBaseInfo.setYear(yrRegCheck.getYear() == null ? null : yrRegCheck.getYear());
		yrPbBaseInfo.setComPhone(yrRegCheck.getTel() == null ? null : yrRegCheck.getTel());
		return yrPbBaseInfo ;
	}
	
	/**
	 * 
	 * 描述: 个体户接收  （由年报主表数据对象封装得到公示主表数据对象）
	 * @auther gaojinling
	 * @date 2016年9月19日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	public PbBaseinfo getPbBaseinfoByYrRegCheck(YrRegCheck yrRegCheck) throws Exception {
		PbBaseinfo pbBaseinfo = new PbBaseinfo();
		pbBaseinfo.setPriPID(yrRegCheck.getPriPID() == null ? null : yrRegCheck.getPriPID());
		pbBaseinfo.setName(yrRegCheck.getLeRep() == null ? null : yrRegCheck.getLeRep());
		pbBaseinfo.setRegNO(yrRegCheck.getRegNO() == null ? null : yrRegCheck.getRegNO());
		pbBaseinfo.setTraName(yrRegCheck.getEntName() == null ? null : yrRegCheck.getEntName());
		pbBaseinfo.setUniCode(yrRegCheck.getUniCode() == null ? null : yrRegCheck.getUniCode());
		pbBaseinfo.setYear(yrRegCheck.getYear() == null ? null : yrRegCheck.getYear());
		pbBaseinfo.setRegNO(yrRegCheck.getRegNO() == null ? null : yrRegCheck.getRegNO());
		pbBaseinfo.setTel(yrRegCheck.getTel() == null ? null : yrRegCheck.getTel());
		return pbBaseinfo ;
	}
	
	
	/**
	 * 
	 * 描述: 元转化为万元
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param indBaseInfo
	 * @return
	 * @throws Exception
	 */
	public YrPbBaseInfo doWapDivideYrPbBaseInfo(YrPbBaseInfo yrPbBaseInfo) throws Exception {
		if(yrPbBaseInfo == null){
			return yrPbBaseInfo;
		}
		//资金数额
		yrPbBaseInfo.setFundAm(yrPbBaseInfo.getFundAm() == null ? null : yrPbBaseInfo.getFundAm().divide(new BigDecimal(10000)));
		//2015年投入经营资金
		yrPbBaseInfo.setPbFundAm(yrPbBaseInfo.getPbFundAm() == null ? null : yrPbBaseInfo.getPbFundAm().divide(new BigDecimal(10000)));
		//营业额或营业收入
		yrPbBaseInfo.setVendInc(yrPbBaseInfo.getVendInc() == null ? null : yrPbBaseInfo.getVendInc().divide(new BigDecimal(10000)));
		// 纳税总额
		yrPbBaseInfo.setRatGro(yrPbBaseInfo.getRatGro() == null ? null : yrPbBaseInfo.getRatGro().divide(new BigDecimal(10000)));
		return yrPbBaseInfo;
	}

	/**
	 * 
	 * 描述: 万元转化元
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbBaseInfo
	 * @return
	 * @throws Exception
	 */
	public YrPbBaseInfo doWapMulitplyYrPbBaseInfo(YrPbBaseInfo yrPbBaseInfo)throws Exception {
		if(yrPbBaseInfo == null){
			return yrPbBaseInfo;
		}
		//资金数额
		yrPbBaseInfo.setFundAm(yrPbBaseInfo.getFundAm() == null ? null : yrPbBaseInfo.getFundAm().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//2015年投入经营资金
		yrPbBaseInfo.setPbFundAm(yrPbBaseInfo.getPbFundAm() == null ? null : yrPbBaseInfo.getPbFundAm().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//营业额或营业收入
		yrPbBaseInfo.setVendInc(yrPbBaseInfo.getVendInc() == null ? null : yrPbBaseInfo.getVendInc().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		// 纳税总额
		yrPbBaseInfo.setRatGro(yrPbBaseInfo.getRatGro() == null ? null : yrPbBaseInfo.getRatGro().multiply(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		return yrPbBaseInfo;
	}
	
}