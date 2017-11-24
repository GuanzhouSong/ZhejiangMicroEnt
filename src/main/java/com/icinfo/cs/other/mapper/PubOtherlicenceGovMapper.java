/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年10月31日
 * @version 2.0
 */
package com.icinfo.cs.other.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.other.dto.PubOtherlicenceGovDto;
import com.icinfo.cs.other.model.PubOtherlicenceGov;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_otherlicence_gov 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
public interface PubOtherlicenceGovMapper extends Mapper<PubOtherlicenceGov> {
	
	/** 
	 * 描述: 行政许可归集查询
	 * @auther ZhouYan
	 * @date 2017年10月31日 
	 * @param params
	 * @return 
	 */
	List<PubOtherlicenceGovDto> selectPubOtherlicenceGovList(Map<String, Object> params);
	
	/** 
	 * 描述: 在册企业行政许可数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param params
	 * @return 
	 */
	Integer selectPubOtherlicenceGovRegTotal(Map<String, Object> params);
    
	/** 
	 * 描述: 在册企业行政许可机关数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param params
	 * @return 
	 */
	Integer selectPubOtherlicenceGovRegAnthTotal(Map<String, Object> paramsMap);
    
	/** 
	 * 描述: 行政许可机关数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param params
	 * @return 
	 */
	Integer selectPubOtherlicenceGovAnthTotal(Map<String, Object> paramsMap);
	
	/**
	 * 
	 * 描述  定时任务专用  更新cs_pub_otherlicence_gov表的注册号 企业名称 、PubFlag标识
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:37:21 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int  updatePubotherlicenceGovQuartz(Map<String, Object> params)throws Exception	;
	
	/**
	 * 
	 * 描述  定时任务专用  批量插入  将cs_pub_otherlicence_gov的 SetDeptName = '政务网' 和 PubFlag ='1'的数据插入 cs_pub_otherlicence
	 * @author 赵祥江
	 * @date 2017年11月20日 下午3:42:02 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int  insertBatchPubOtherLicenceQuartz(Map<String, Object> params)throws Exception;
    
	 
	
}