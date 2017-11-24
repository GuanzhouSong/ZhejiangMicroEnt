/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月25日
 * @version 2.0
 */
package com.icinfo.cs.batch.mapper;

import java.util.Map;

import com.icinfo.cs.batch.model.Batch;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_batch 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface BatchMapper extends Mapper<Batch> {
	
	/**
     * 描述:获取批次编号
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月24日
     */
	String selecMaxBatchNo(Map<String, String> qryMap) throws Exception;
}