/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月11日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.ModApplicationDto;
import com.icinfo.cs.yr.model.ModApplication;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mod_application 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
public interface ModApplicationMapper extends Mapper<ModApplication> {
	
	/**
	 * 
	 * 描述: 获取年报修改申请审核列表list
	 * @auther chenxin
	 * @date 2016-09-11
	 * @param map 
	 * @return List<ModApplicationDto>
	 */
	public List<ModApplicationDto> selectModApplicationApplyList(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 获取年报修改申请审核历史接收列表list
	 * @auther chenxin
	 * @date 2016-09-14
	 * @param map 
	 * @return List<ModApplication>
	 */
	public List<ModApplication> selectModApplicationApplyHisList(Map<String, Object> map);
	
	/**
	 * 描述：根据内部序号查询年报修改申请（权限过滤）
	 * @author chenxin
	 * @date 2016-09-14
	 * @param map
	 * @return
	 */
	public ModApplicationDto selectModApplicationApplyById(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 修改年报修改申请
	 * @auther chenxin
	 * @date 2016年9月11日 
	 * @param modApplication
	 * @return ModApplicationDto
	 */
	public int updateModApplication(ModApplication modApplication);
	
	/**
	 * 
	 * 描述: 修改申请待审核
	 * @auther gaojinling
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 */
	public Integer selectModApplicationCount(Map<String, Object> map);
}