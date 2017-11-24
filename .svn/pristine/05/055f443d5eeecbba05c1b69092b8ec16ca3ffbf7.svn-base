/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月06日
 * @version 2.0
 */
package com.icinfo.cs.es.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.CsMidPersonDto;
import com.icinfo.cs.es.model.CsMidPerson;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_person 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月06日
 */
public interface CsMidPersonMapper extends Mapper<CsMidPerson> {
	
	/**
	 * 获取人员信息列表
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsMidPersonDto> selectPersonList(Map<String,Object> map) throws Exception;
	
	/** 
	 * 描述: 获取人员信息列表-总数
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	
	public Long selectPersonListCount(Map<String,Object> map) throws Exception;
	
	/** 
	 * 描述: 获取人员对应企业列表信息
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	
	public List<CsMidPersonDto>  selectPersonEntPageList(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取人员企业列表信息-总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Long  selectPersonEntPageListCount(Map<String,Object> map) throws Exception;
	
}