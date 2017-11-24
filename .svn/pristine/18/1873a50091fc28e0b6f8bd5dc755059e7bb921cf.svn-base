/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.ext.mapper.MidInvMapper;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.yr.mapper.YrBaseInfoMapper;
import com.icinfo.cs.yr.mapper.YrSubcapitalMapper;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.cs.yr.service.IYrSubcapitalService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_yr_subcapital 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class YrSubcapitalServiceImpl extends MyBatisServiceSupport implements IYrSubcapitalService {
	private static final Logger logger = LoggerFactory.getLogger(YrSubcapitalServiceImpl.class);

	@Autowired
	private YrSubcapitalMapper yrSubcapitalMapper;
	@Autowired
	private MidInvMapper midInvMapper;
	@Autowired
	private YrBaseInfoMapper yrBaseInfoMapper;
	@Autowired
	private IYrBaseInfoService yrBaseInfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	//主键uuid
	private final String CS_YR_SUBCAPITAL_INVID="invID";


	/**
	 * 添加
	 * @autor: wangjin
	 * @param yrSubcapital
	 * @return
	 */
	@Override
	public int insert(YrSubcapital yrSubcapital) {
		yrSubcapital.setCreateTime(DateUtils.getSysDate());
		return yrSubcapitalMapper.insert(yrSubcapital);
	}

	/**
	 * 更新
	 * @autor: wangjin
	 * @param yrSubcapital
	 * @return
     */
	@Override
	public int update(YrSubcapital yrSubcapital) {
		Example example = new Example(YrSubcapital.class);
		example.createCriteria().andEqualTo(CS_YR_SUBCAPITAL_INVID, yrSubcapital.getInvID()).andEqualTo("priPID",yrSubcapital.getPriPID());

		// 如果实缴出资额等于0  则将出资方式和日期更新为null
		if(yrSubcapital.getLiacconam()!=null){
			BigDecimal a = yrSubcapital.getLiacconam();
			BigDecimal b = BigDecimal.ZERO;
			if(a.compareTo(b)==0){
				Map<String, String> map = new HashMap<String, String>();
				map.put(CS_YR_SUBCAPITAL_INVID,yrSubcapital.getInvID());
				map.put("priPID",yrSubcapital.getPriPID());
				yrSubcapitalMapper.updateByLiacconam(map);
				yrSubcapital.setAcConDate(null);
				yrSubcapital.setAcConForm("");
				yrSubcapital.setAcConFormCn("");
			}
		}
		//yrSubcapital.setCreateTime(DateUtils.getSysDate());
		return yrSubcapitalMapper.updateByExampleSelective(yrSubcapital,example);
	}



	/**
	 * 根据年份和主体身份代码进行查询
	 * @autor: wangjin
	 * @param year
	 * @param pripid
	 * @return
	 */
	@Override
	public YrSubcapital selectByYearAndPripid(Integer year, String pripid) {
		if(StringUtil.isNotEmpty(pripid)&&year!=null){
			YrSubcapital yrSubcapital = new YrSubcapital();
			yrSubcapital.setYear(year);
			yrSubcapital.setPriPID(pripid);
			yrSubcapital=yrSubcapitalMapper.selectOne(yrSubcapital);
			return yrSubcapital;
		}
		return null;
	}

	/**
	 * 列表查询
	 * @autor: wangjin
	 * @param request
	 * @return
     */
	@Override
	public List<YrSubcapital> select_queryPage(PageRequest request) {

		PageHelper.startPage(request.getPageNum(), request.getLength());

		Map<String, Object> searchMap=  request.getParams();
		String priPID = searchMap.get(Constants.CS_PRIPID).toString();
		String year = searchMap.get(Constants.CS_YEAR).toString();

		if(StringUtils.isNotBlank(priPID)&&StringUtils.isNotBlank(year)){
			return yrSubcapitalMapper.doGetYrSubcapitalList(searchMap);
		}else{
			return null;
		}


	/*	Example example = new Example(YrSubcapital.class);
		Example.Criteria criteria=example.createCriteria();

		Map<String, Object> searchMap=  request.getParams();
		String priPID = searchMap.get(Constants.CS_PRIPID).toString();
		String year = searchMap.get(Constants.CS_YEAR).toString();
		String keyValue = searchMap.get("keyValue").toString();
		String orderStr = (String)searchMap.get("orderStr");

		if(StringUtil.isNotEmpty(year)&&StringUtil.isNotEmpty(priPID)){
			criteria.andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);
			//判断搜索关键字是否为空
			if(StringUtils.isNotBlank(keyValue)){
				criteria.andLike("inv","%"+keyValue+"%");
			}
			////判断排序参数是否为空
			if(StringUtils.isNotEmpty(orderStr)){
				example.setOrderByClause(searchMap.get("orderStr").toString());
			}else{
				example.setOrderByClause(" CreateTime desc ");
			}

			//return yrSubcapitalMapper.selectByExample(example);
			return yrSubcapitalMapper.doGetYrSubcapitalList(request);
		}
		return null;*/

	}

	/**
	 * 根据 invID和priPID 查询对象
	 * @param invID
	 * @param priPID
	 * @return
	 */
	@Override
	public YrSubcapital selectByInvIdAndPriPID(String invID,String priPID) {
		if(StringUtil.isNotEmpty(invID)&&StringUtil.isNotEmpty(priPID)){
			YrSubcapital yrSubcapital = new YrSubcapital();
			yrSubcapital.setInvID(invID);
			yrSubcapital.setPriPID(priPID);
			return yrSubcapitalMapper.selectOne(yrSubcapital);
		}
		return null;
	}

	/**
	 * 根据 invID 进行删除
	 * @autor: wangjin
	 * @param invID
	 * @return
	 */

	@Override
	public int delete(String invID) {
		YrSubcapital yrSubcapital = new YrSubcapital();
		yrSubcapital.setInvID(invID);
		return yrSubcapitalMapper.delete(yrSubcapital);
	}

	/**
	 * 批量删除
	 * @autor:wangjin
	 * @param list_invID
	 * @param priPID
	 * @return
	 */
	@Override
	public int batch_delete(List<String> list_invID, String priPID) {
		if(StringUtil.isNotEmpty(priPID)){
			YrSubcapital yrSubcapital = null;
			int num = 0;
			for(String invID:list_invID){
				yrSubcapital = new YrSubcapital();
				yrSubcapital.setInvID(invID);
				yrSubcapital.setPriPID(priPID);
				yrSubcapitalMapper.delete(yrSubcapital);
				num++;
			}
			return num;
		}
		return 0;
	}


	/**
	 * 根据年份和主体身份代码获取 对象集合数据
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 */
	@Override
	public List<YrSubcapital> selectByYearAndPripidList(Integer year, String priPID) {
		Example example=new Example(YrSubcapital.class);
		if (StringUtil.isNotEmpty(String.valueOf(year)) && StringUtil.isNotEmpty(priPID)) {
			example.createCriteria().andEqualTo(Constants.CS_YEAR, year).andEqualTo(Constants.CS_PRIPID,priPID);
			return yrSubcapitalMapper.selectByExample(example);
		}
		return null;
	}
	/**
	 * 插入当前年份上一年份的数据集合
	 * @autor:wangjin
	 * @param list
	 * @param anCheID 年报ID
	 * @return
	 */

	@Override
	public void insertYrSubcapitalList(List<YrSubcapital> list, String anCheID) {

		YrSubcapital yrSubcapital = null;
		int leng = list.size();
		for (int i=0;i<leng;i++){
			yrSubcapital = new YrSubcapital();
			yrSubcapital.setPriPID(list.get(i).getPriPID());
			yrSubcapital.setInv(list.get(i).getInv().replace("'","\\\'"));//转义特殊字符
			yrSubcapital.setInvID(StringUtils.uuid());//主键 生成uuid
			yrSubcapital.setAcConDate(list.get(i).getAcConDate());
			yrSubcapital.setYear(list.get(i).getYear()+1);
			yrSubcapital.setCreateTime(DateUtils.getSysDate());//系统当前时间
			yrSubcapital.setConFormCN(list.get(i).getConFormCN());
			yrSubcapital.setAcConFormCn(list.get(i).getAcConFormCn());
			yrSubcapital.setAnCheID(anCheID);//当前年报的年报ID
			yrSubcapital.setLiacconam(list.get(i).getLiacconam());
			yrSubcapital.setLisubconam(list.get(i).getLisubconam());
			yrSubcapital.setInvRegNO(list.get(i).getInvRegNO());
			yrSubcapital.setAcConForm(list.get(i).getAcConForm());
			yrSubcapital.setSubConForm(list.get(i).getSubConForm());
			yrSubcapital.setSubConDate(list.get(i).getSubConDate());
			yrSubcapitalMapper.insert(yrSubcapital);
		}
	}

	/**
	 * 获取认缴出资 总和
	 * @author:wangjin
	 * @param queryMap
	 * @return
	 */
	@Override
	public BigDecimal rj_sumMoney(Map<String, Object> queryMap) {
		BigDecimal sumMoney =yrSubcapitalMapper.rj_sumMoeny(queryMap);
		return sumMoney!=null?sumMoney:new BigDecimal(0);
	}

	/**
	 * 获取实缴出资 总和
	 * @author:wangjin
	 * @param queryMap
	 * @return
	 */
	@Override
	public BigDecimal sj_sumMoney(Map<String, Object> queryMap) {
		BigDecimal sumMoney =yrSubcapitalMapper.sj_sumMoeny(queryMap);
		return sumMoney!=null?sumMoney:new BigDecimal(0);
	}


	/**
	 *
	 * 描述             : 根据内部序号和年报年度获取出资信息
	 * @author: 赵祥江
	 * @date  : 2016年8月28日 下午1:32:50
	 * @param :
	 * @return: List<YrSubcapital>
	 * @throwsMidInv
	 */
	@Override
	public List<YrSubcapital> queryPagePreview(
			PageRequest request)throws Exception {
		List<YrSubcapital> yrSubcapitalList=new ArrayList<YrSubcapital>();
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(YrSubcapital.class);
			//主体代码
			if(searchMap.containsKey(Constants.CS_PRIPID)&&searchMap.containsKey(Constants.CS_YEAR)){
				example.createCriteria().andEqualTo(Constants.CS_PRIPID, searchMap.get(Constants.CS_PRIPID)).andEqualTo(Constants.CS_YEAR, searchMap.get(Constants.CS_YEAR).toString());
				yrSubcapitalList = yrSubcapitalMapper.selectByExample(example);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取企业出资信息失败!");
            throw new BusinessException("获取企业出资信息失败!");
		}
		return yrSubcapitalList;
	}


	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj);
		return example;
	}

	@Override
	public List<Subcapital> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return yrSubcapitalMapper.queryPageResultByPripid(request.getParams());
	}


}