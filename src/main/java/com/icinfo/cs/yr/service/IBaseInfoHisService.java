/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.BaseInfoHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_baseinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IBaseInfoHisService extends BaseService {

	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 年报基本信息 历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午6:11:06 
	 * @param : anCheID:年报ID
	 * @return: List<BaseInfoHis>
	 * @throws
	 */
	public List<BaseInfoHis> queryPage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 保存公示基本信息历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param baseInfoHis
	 * @return
	 * @throws Exception 
	 */
	public int insert(BaseInfoHis baseInfoHis)throws Exception;
	
	/**
	 * 
	 * 描述             : 根据年报年度和主体代码获取年报基本信息 历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 上午10:42:44 
	 * @param :
	 * @return: List<BaseInfoHis>
	 * @throws
	 */
	public List<BaseInfoHis> slectBaseInfoHisByYearAndpriPID(int year,String priPID) throws Exception;
	
	 /** 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author 赵祥江
	 * @date 2016年12月29日 下午4:46:50 
	 * @param 
	 * @return List<BaseInfoHis>
	 * @throws
	 */
	public List<BaseInfoHis> selectBaseInfoHisListYear(int year,String priPID) throws Exception;
	
	/**
	 * 
	 * 描述   根据年报ID和年报编号获取年报历史信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午5:59:30 
	 * @param 
	 * @return List<BaseInfoHis>
	 * @throws
	 */
	public BaseInfoHis slectBaseInfoHisByanCheIDAndReportNo(String  anCheID,String reportNo) throws Exception;

}