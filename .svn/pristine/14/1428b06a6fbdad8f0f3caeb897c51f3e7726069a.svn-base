/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.SfcBaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcBaseInfoService extends BaseService {
	/**
	 * 
	 * 描述   根据年份和主体代码查询基本信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:27:04 
	 * @param 
	 * @return SfcBaseInfo
	 * @throws
	 */
	public SfcBaseInfo selectSfcBaseInfoByPriPIdAndYear(String priPID, int year) throws Exception ;

	/**
	 * 
	 * 描述: 根据年报id删除公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	int deleteByAnCheID(String anCheID) throws Exception;

	/**
	 * 
	 * 描述: 保存公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param sfcBaseInfo
	 * @return
	 * @throws Exception
	 */
	int insert(SfcBaseInfo sfcBaseInfo) throws Exception;

	/**
	 * 描述：根据PripID查询农专年报ID列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param priPID
	 * @return
	 */
	public List<SfcBaseInfoDto> querySfcAncheIDList(String priPID);

	/**
	 * 描述：根据priPID和year查询农专年报信息
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param priPID
	 * @param year
	 * @return
	 */
	public SfcBaseInfoDto querySfcYrInfoByPriPIDAndYear(String priPID, String year);

	/**
	 * 描述：农专年报信息查看详情列表页
	 * @author baifangfang
	 * @date 2016年10月31日
	 * @param request
	 * @return
	 */
	public List<SfcBaseInfoDto> queryPageResult(PageRequest request);
	/**
	 * 
	 * 描述: 根据年报ID查询敏感词审核情况
	 * @auther chenyl
	 * @date 2016年11月4日 
	 * @param AncheID
	 * @return
	 */
	public String queryAnduitStateInfoByAncheID(String AncheID);
	
	/**
	 * 描述: 根据priPID和year查询敏感词审核情况
	 * @auther chenyl
	 * @date 2016年11月4日 
	 * @param priPID
	 * @param year
	 * @return
	 */
	public String queryAnduitStateInfoByAncheID(String priPID, Integer year);

	/**
	 * 描述：农专社资产状况信息查询
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param request
	 * @return
	 */
	public List<SfcBaseInfoDto> selectSfcBaseinfoAssetList(PageRequest request);

	/**
	 * 描述：农专社资产状况信息统计
	 * @author baifangfang
	 * @date 2017年6月8日
	 * @param request
	 * @return
	 */
	public YrAssetCount querySfcYrAssetCount(PageRequest request);
	 
}