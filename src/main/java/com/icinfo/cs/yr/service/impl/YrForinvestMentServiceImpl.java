/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.framework.tools.utils.StringUtils;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogTables;
import com.icinfo.cs.common.constant.OperationTypes;
import com.icinfo.cs.common.utils.ObjectComparator;
import com.icinfo.cs.system.model.SysLogJson;
import com.icinfo.cs.system.model.SysLogJsonItem;
import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.mapper.YrForinvestMentMapper;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrForinvestMentService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_yr_forinvestment 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class YrForinvestMentServiceImpl extends MyBatisServiceSupport implements IYrForinvestMentService {
	 private static final Logger logger = LoggerFactory.getLogger(YrForinvestMentServiceImpl.class);

	 @Autowired
	 private YrForinvestMentMapper yrForinvestMentMapper;  
	 //对外投资主键uuid
	 private final String CS_YR_FORINVESTMENT_OUTINVID="outinvid";
	 @Autowired
	 private ISysLogService iSysLogService;
	 @Autowired
	 private IYrBaseInfoService yrBaseInfoService;

	/**
	 * 更新
	 * @autor: wangjin
	 * @param yrForinvestMent
	 * @return
	 */
	@Override
	public int update(YrForinvestMent yrForinvestMent) {
		Example example = new Example(YrForinvestMent.class);
		example.createCriteria().andEqualTo(CS_YR_FORINVESTMENT_OUTINVID, yrForinvestMent.getOutinvid()).andEqualTo("priPID",yrForinvestMent.getPriPID());
		//yrForinvestMent.setCreateTime(DateUtils.getSysDate());
		return yrForinvestMentMapper.updateByExampleSelective(yrForinvestMent,example);
	}

	/**
	 * 添加
	 * @autor: wangjin
	 * @param yrForinvestMent
	 * @return
	 */
	@Override
	public int insert(YrForinvestMent yrForinvestMent) {
		yrForinvestMent.setCreateTime(DateUtils.getSysDate());
		return yrForinvestMentMapper.insert(yrForinvestMent);
	}

	@Override
	public List<YrForinvestMent> select_queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrForinvestMent.class);
		Map<String, Object> searchMap=  request.getParams();
		String priPID = searchMap.get(Constants.CS_PRIPID).toString();
		String year = searchMap.get(Constants.CS_YEAR).toString();
		if(StringUtil.isNotEmpty(year)&&StringUtil.isNotEmpty(priPID)){
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);

			String orderStr = (String)searchMap.get("orderStr");
			if(StringUtils.isNotEmpty(orderStr)){ ////判断排序参数是否为空
				example.setOrderByClause(searchMap.get("orderStr").toString());
			}else{
				example.setOrderByClause(" CreateTime desc ");
			}
			return yrForinvestMentMapper.selectByExample(example);
		}
		return null;

	}

	/**
	 * 根据年份和主体身份代码获取 对象集合数据
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 */
	@Override
	public List<YrForinvestMent> selectByYearAndPripidList(Integer year, String priPID) {
		Example example=new Example(YrSubcapital.class);
		if (StringUtil.isNotEmpty(String.valueOf(year)) && StringUtil.isNotEmpty(priPID)) {
			example.createCriteria().andEqualTo(Constants.CS_YEAR, year).andEqualTo(Constants.CS_PRIPID,priPID);
		}
		return yrForinvestMentMapper.selectByExample(example);
	}


	/**
	 * 插入当前年份上一年份的数据集合
	 * @autor:wangjin
	 * @param list
	 * @param anCheID 年报ID
	 * @return
	 */
	@Override
	public void insertyrForinvestMentlList(List<YrForinvestMent> list, String anCheID) {
		YrForinvestMent yrForinvestMent = null;
		int leng = list.size();
		for (int i=0;i<leng;i++){
			yrForinvestMent = new YrForinvestMent();
			yrForinvestMent.setPriPID(list.get(i).getPriPID());
			yrForinvestMent.setEntName(list.get(i).getEntName().replace("'","\\\'")); //转义特殊字符
			yrForinvestMent.setSubConProp(list.get(i).getSubConProp());
			yrForinvestMent.setAcConAm(list.get(i).getAcConAm());
			yrForinvestMent.setUniCode(list.get(i).getUniCode());  //
			yrForinvestMent.setYear(list.get(i).getYear()+1);
			yrForinvestMent.setCreateTime(DateUtils.getSysDate());//系统当前时间
			yrForinvestMent.setConFormCN(list.get(i).getConFormCN());
			yrForinvestMent.setAcConFormCn(list.get(i).getAcConFormCn());
			yrForinvestMent.setAnCheID(anCheID);//当前年报的年报ID
			yrForinvestMent.setSubConAm(list.get(i).getSubConAm());
			yrForinvestMent.setPriPID(list.get(i).getPriPID());
			yrForinvestMent.setAcConForm(list.get(i).getAcConForm());
			yrForinvestMent.setSubConForm(list.get(i).getSubConForm());
			yrForinvestMentMapper.insert(yrForinvestMent);
		}
	}

	/**
	 * 批量删除
	 * @autor:wangjin
	 * @param list_outinvIDs
	 * @param priPID
	 * @return
	 */
	@Override
	public int batch_delete(List<String> list_outinvIDs, String priPID) {
		if(StringUtil.isNotEmpty(priPID)){
			YrForinvestMent yrForinvestMent = null;
			int num =0;
			for(String outinviid: list_outinvIDs ){
				yrForinvestMent = new YrForinvestMent();
				yrForinvestMent.setOutinvid(outinviid);
				yrForinvestMent.setPriPID(priPID);
				yrForinvestMentMapper.delete(yrForinvestMent);
				num++;
			}
			return num;
		}
		return 0;

	}

	/**
	 * 根据 invID和priPID 查询对象
	 * @param outinvid
	 * @param priPID
	 * @return
	 */
	@Override
	public YrForinvestMent selectByInvIdAndPriPID(String outinvid, String priPID) {
		if(StringUtil.isNotEmpty(outinvid)&&StringUtil.isNotEmpty(priPID)){
			YrForinvestMent yrForinvestMent = new YrForinvestMent();
			yrForinvestMent.setOutinvid(outinvid);
			yrForinvestMent.setPriPID(priPID);
			return yrForinvestMentMapper.selectOne(yrForinvestMent);
		}
		return null;
	}



	/**
	 *
	 * 描述  : 获取组装查询sql工具对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午2:23:46
	 * @param :
	 * @return: Criteria
	 * @throws
	 */
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj);
		return example;
	}


	/** 
	 * 描述: 年报预览：对外投资
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<YrForinvestMent> queryPagePreview(PageRequest request)
			throws Exception {
		List<YrForinvestMent> yrForinvestMentList=new ArrayList<YrForinvestMent>();
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(YrForinvestMent.class);
			//验证是否主体代码和年报年度都传了
			if(searchMap.containsKey(Constants.CS_PRIPID)&&searchMap.containsKey(Constants.CS_YEAR)){
				example.createCriteria().andEqualTo(Constants.CS_PRIPID,searchMap.get(Constants.CS_PRIPID).toString())
				.andEqualTo(Constants.CS_YEAR, searchMap.get(Constants.CS_YEAR).toString());
				yrForinvestMentList=yrForinvestMentMapper.selectByExample(example); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取对外投资信息失败!");
            throw new BusinessException("获取对外投资信息失败!");
		}
		return yrForinvestMentList;
	}

	/**
	 * 描述:根据年报年度和企业主体代码查询 对外投资 认缴总额
	 *
	 * @param
	 * @return BigDecimal
	 * @throws
	 * @author 赵祥江
	 * @date 2016年11月15日 下午5:42:39
	 */
	@Override
	public BigDecimal selectInvestSubConAmSumByYearAndPriPid(Map<String, Object> queryMap) {
		BigDecimal subConAmSum = new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP);
		if (StringUtil.isNotEmpty(queryMap.get(Constants.CS_PRIPID).toString()) && StringUtil.isNotEmpty(queryMap.get(Constants.CS_YEAR).toString())) {
			subConAmSum = yrForinvestMentMapper.selectInvestSubConAmSumByYearAndPriPid(queryMap);
			if (subConAmSum == null) {
				subConAmSum = new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP);
			} else {
				subConAmSum = subConAmSum.setScale(4, BigDecimal.ROUND_HALF_UP);
			}
		}
		return subConAmSum;
	}


	/**
	 * 描述 : 根据年报年度和企业主体代码查询 对外投资  实缴总额
	 *
	 * @param :
	 * @throws
	 * @author: 赵祥江
	 * @date : 2016年9月8日 下午6:58:37
	 * @return: BigDecimal
	 */
	@Override
	public BigDecimal selectInvestSumByYearAndPriPid(Map<String, Object> queryMap) {
		BigDecimal actAmountSum = new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP);
		if (StringUtil.isNotEmpty(queryMap.get(Constants.CS_PRIPID).toString()) && StringUtil.isNotEmpty(queryMap.get(Constants.CS_YEAR).toString())) {
			actAmountSum = yrForinvestMentMapper.selectInvestSumByYearAndPriPid(queryMap);
			if (actAmountSum == null) {
				actAmountSum = new BigDecimal(0).setScale(4, BigDecimal.ROUND_HALF_UP);
			} else {
				actAmountSum = actAmountSum.setScale(4, BigDecimal.ROUND_HALF_UP);
			}
		}
		return actAmountSum;
	}


	
}