/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.other.dto.PubOtherlicenceGovDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_otherlicence_gov 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
public interface IPubOtherlicenceGovService extends BaseService {
	
	/** 
	 * 描述: 行政许可归集查询
	 * @auther ZhouYan
	 * @date 2017年10月31日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	List<PubOtherlicenceGovDto> selectPubOtherlicenceGovList(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	Integer selectPubOtherlicenceGovRegTotal(Map<String, Object> paramsMap) throws Exception;
    
	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	PubOtherlicenceGovDto selectOtherLicenceGovCount(Map<String, Object> paramsMap) throws Exception;
	
	/**
	 * 
	 * 描述 定时任务专用   批量插入  将cs_pub_otherlicence_gov的 SetDeptName = '政务网' 和 PubFlag ='1'的数据插入 cs_pub_otherlicence
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:49:11 
	 * @param 
	 * @return int
	 * @throws
	 */
	int  insertBatchPubOtherLicenceQuartz(Map<String, Object> paramsMap) throws Exception;
	
	/**
	 * 
	 * 描述   定时任务专用  更新cs_pub_otherlicence_gov表的注册号 企业名称 、PubFlag标识
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:49:14 
	 * @param 
	 * @return int
	 * @throws
	 */
	int  updatePubotherlicenceGovQuartz(Map<String, Object> paramsMap) throws Exception;
    
	 
}