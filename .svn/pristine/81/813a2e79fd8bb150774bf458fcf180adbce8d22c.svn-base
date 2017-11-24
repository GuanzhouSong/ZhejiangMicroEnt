/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.SfcLicenceInfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_sfc_licenceinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcLicenceInfoHisService extends BaseService {
	/**
	 * 
	 * 描述   根据年报ID和年报编号查询许可证信息 历史 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:34:44 
	 * @param 
	 * @return List<SfcLicenceInfoHis>
	 * @throws
	 */
  public List<SfcLicenceInfoHis> selectSfcLicenceInfoHisByAnCheIdAndReportNo(String anCheID,String reportNo) throws Exception;

    /**
     * 
     * 描述: 保存许可证历史记录
     * @auther gaojinling
     * @date 2016年10月11日 
     * @param sfcLicenceInfoHis
     * @return
     * @throws Exception
     */
	int insert(SfcLicenceInfoHis sfcLicenceInfoHis) throws Exception;

}