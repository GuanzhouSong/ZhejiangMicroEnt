/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.cs.yr.model.SfcBaseInfoHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_baseinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月28日
 */
public interface IPbBaseinfoHisService extends BaseService {
	 
	/**
	 * 
	 * 描述   根据年报ID分页查询 公示  历史信息 个体户
	 * @author 赵祥江
	 * @date 2016年9月28日 下午8:46:49 
	 * @param 
	 * @return List<PbBaseinfoHis>
	 * @throws
	 */
	public List<PbBaseinfoHis> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述   根据年报ID和年报提交编号查询历史信息
	 * @author 赵祥江
	 * @date 2016年9月28日 下午8:48:42 
	 * @param 
	 * @return PbBaseinfoHis
	 * @throws
	 */
	public PbBaseinfoHis  selectPbBaseinfoHisAnCheIdAndReportNo(String anCheID,String reportNo) throws Exception;
	
	/**
	 * 
	 * 描述    根据年报ID不分页查询 公示 年报基本信息 历史信息
	 * @author 赵祥江
	 * @date 2016年9月29日 下午5:44:00 
	 * @param 
	 * @return List<PbBaseinfoHis>
	 * @throws
	 */
	public List<PbBaseinfoHis> selectPbBaseinfoHisByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 保存公示基本信息历史记录
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pbBaseinfoHis
	 * @return
	 * @throws Exception 
	 */
	public int insert(PbBaseinfoHis pbBaseinfoHis)throws Exception;
	
	
	/**
	 * 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author 赵祥江
	 * @date 2016年12月29日 下午5:38:51 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	public List<PbBaseinfoHis>  selectPbBaseinfoHisListYear(int year, String priPID)throws Exception ;

}