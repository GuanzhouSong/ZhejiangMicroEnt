/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.SfcBranchInfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_sfc_branchinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcBranchInfoHisService extends BaseService {
	/**
	 * 
	 * 描述   根据年报ID和年报编号查分支机构信息
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:45:59 
	 * @param 
	 * @return List<SfcBranchInfoHis>
	 * @throws
	 */
	 public List<SfcBranchInfoHis> selectSfcBranchInfoHisByAnCheIdAndReportNo(String anCheID,String reportNo) throws Exception;

	 /**
	 * 
	 * 描述: 保存分支机构历史记录
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param sfcLicenceInfoHis
	 * @return
	 * @throws Exception
	 */
	int insert(SfcBranchInfoHis sfcBranchInfoHis) throws Exception;

}