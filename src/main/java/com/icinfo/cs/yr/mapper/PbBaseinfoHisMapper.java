/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月28日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.PbBaseinfoHis;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pb_baseinfo_his 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月28日
 */
public interface PbBaseinfoHisMapper extends Mapper<PbBaseinfoHis> {
	/**
	 * 
	 * 描述   根据年度和主体代码获取年报日期和最后年报日期不相等的历史信息
	 * @author 赵祥江
	 * @date 2016年12月29日 下午5:29:51 
	 * @param 
	 * @return List<SfcBaseInfoHis>
	 * @throws
	 */
	public List<PbBaseinfoHis>  selectPbBaseinfoHisListYear(Map<String,Object> qMap);
	
}