/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.SfcBaseInfoHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_baseinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcBaseInfoHisService extends BaseService { 
	
	/**
	 * 
	 * 描述   根据年报ID分页查询 公示  历史信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:16:29 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	public List<SfcBaseInfoHis> queryPage(PageRequest request) throws Exception;
	 
	/**
	 * 
	 * 描述    根据年报ID和年报提交编号查询历史信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:17:05 
	 * @param 
	 * @return SfcBaseInfoHis
	 * @throws
	 */
	public SfcBaseInfoHis  selectSfcBaseInfoHisAnCheIdAndReportNo(String anCheID,String reportNo) throws Exception;
	
 
	/**
	 * 
	 * 描述   根据年报ID不分页查询 公示 年报基本信息 历史信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:17:32 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	public List<SfcBaseInfoHis> selectSfcBaseInfoHisByAnCheID(String anCheID) throws Exception;
	
	/**
	 * 
	 * 描述: 保存公示基本信息历史记录
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param pbBaseinfoHis
	 * @return
	 * @throws Exception
	 */
	public int insert(SfcBaseInfoHis sfcBaseInfoHis) throws Exception ;
	
	/**
	 * 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author 赵祥江
	 * @date 2016年12月29日 下午5:38:51 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	public List<SfcBaseInfoHis>  selectSfcBaseinfoHisListYear(int year, String priPID)throws Exception ;
}