/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年03月29日
 * @version 2.0
 */
package com.icinfo.cs.mainmark.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.mainmark.dto.MainMarkHisDto;
import com.icinfo.cs.mainmark.model.MainMarkHis;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_main_mark_his 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
public interface MainMarkHisMapper extends Mapper<MainMarkHis> {
	/** 
	 * 描述: 分页列表
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param map
	 * @return 
	 */
	
	public List<MainMarkHisDto> queryPageList(Map<String, Object> map);
	
	
	/** 
	 * 描述: 批量新增
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param list 
	 */
	
	public void insertBatch(List<MainMarkHis> list);
	
	/** 
	 * 描述: 新增
	 * @author 张文男
	 * @date 2017年4月6日 
	 * @param bean 
	 */
	
	public void insertOne(MainMarkHis bean);
	
	/** 
	 * 描述: 更新
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param bean 
	 */
	
	public void updateByMarkUuid(MainMarkHis bean);
	
	/** 
	 * 描述: 根据企业id获取最新未审核记录
	 * @author 张文男
	 * @date 2017年3月30日 
	 * @param priPID
	 * @return 
	 */
	
	public String queryLastMarkUuidByPriPID(String priPID);
	
	
	/** 
	 * 描述: 根据企业ID更新最新一条数据
	 * @author 张文男
	 * @date 2017年4月5日 
	 * @param bean 
	 */
	
	public void updateLastByPriPID(MainMarkHis bean);
	
}