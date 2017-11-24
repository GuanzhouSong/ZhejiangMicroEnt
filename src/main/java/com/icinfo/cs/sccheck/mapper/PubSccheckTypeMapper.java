/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月17日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_sccheck_type 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubSccheckTypeMapper extends Mapper<PubSccheckType> {

	/**
	 * 描述：获取检查事项列表
	 * @author baifangfang
	 * @date 2017年5月18日
	 * @return
	 */
	List<PubSccheckType> qryPubSccheckTypeList();
	/**
	 * 
	 * 描述   分页查询检查事项
	 * @author 赵祥江
	 * @date 2017年5月18日 下午5:23:44 
	 * @param 
	 * @return List<PubSccheckType>
	 * @throws
	 */
	public List<PubSccheckType> selectPubSccheckTypeList(Map<String,Object> queryMap)throws Exception;
	
     /**
      * 
      * 描述: 获取执法清单范围树数据
      * @auther gaojinling
      * @date 2017年5月25日 
      * @return
      */
	 List<Map<String, Object>> selectScPtypeTreeMap(Map<String, Object> params);
}