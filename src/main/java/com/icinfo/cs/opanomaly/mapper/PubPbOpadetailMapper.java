/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月27日
 * @version 2.0
 */
package com.icinfo.cs.opanomaly.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_pub_pbopadetail 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
public interface PubPbOpadetailMapper extends Mapper<PubPbOpadetail> {

	/**
	 * 描述：恢复异常申请列表
	 * 
	 * @author baifangfang
	 * @date 2017年7月3日
	 * @param params
	 * @return
	 */
	List<PubPbOpadetailDto> selectPubPbOpadetailDtoList(Map<String, Object> params);

	/**
	 * 描述：查询异常恢复信息
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param params
	 * @return
	 */
	PubPbOpadetailDto selectPubPbOpadetailByBusExcList(Map<String, Object> params);
	
	/**
	 * 
	 * 描述   根据主体身份代码查询移出信息
	 * @author 赵祥江
	 * @date 2017年10月11日 上午11:48:23 
	 * @param 
	 * @return List<PubPbOpadetailDto>
	 * @throws
	 */
	List<PubPbOpadetailDto> selectPubPbOpadetailByPriPID(Map<String, Object> params);
}