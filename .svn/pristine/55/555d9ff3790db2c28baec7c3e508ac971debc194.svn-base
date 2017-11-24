/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 *
 * @author framework generator
 * @date 2016年09月26日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.FoodstorageBaseDto;
import com.icinfo.cs.yr.dto.FoodstorageCountDto;
import com.icinfo.cs.yr.model.FoodstorageBase;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_foodstorage_base 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public interface FoodstorageBaseMapper extends Mapper<FoodstorageBase> {
	/**
	 * 描述: 获取食品仓储信息查询列表list数据（工商端）
     * @auther chenxin
     * @date 2016年09月23日 
	 * @param request
	 * @return List<FoodstorageBaseDto>
	 */
	public List<FoodstorageBaseDto> selectFoodstorageBaseDtoList(Map<String, Object> map);
	
	/**
	 * 描述: 获取食品仓储退回列表列表list数据（工商端）
	 * @auther chenxin
	 * @date 2016年09月23日 
	 * @param request
	 * @return List<FoodstorageBaseDto>
	 */
	public List<FoodstorageBaseDto> selectFoodstorageBaseBackDtoList(Map<String, Object> map);
	
	/**
	 * 描述：根据内部序号查询年报修改申请（权限过滤）（工商端）
	 * @author chenxin
	 * @date 2016-09-14
	 * @param map
	 * @return
	 */
	public FoodstorageBase selectFoodstorageBaseById(Map<String, Object> map);
	
	/**
	 * 描述：根据查询申请（权限过滤）（关联主表信息）（工商端）
	 * @author chenxin
	 * @date 2016-09-28
	 * @param map
	 * @return
	 */
	public FoodstorageBaseDto selecFoodstorageBaseDtoById(Map<String, Object> map);
	
	/**
	 * 
	 * 描述   食品仓储统计
	 * @author 赵祥江
	 * @date 2017年5月8日 下午7:14:40 
	 * @param 
	 * @return List<FoodstorageCountDto>
	 * @throws
	 */
	public List<FoodstorageCountDto> foodstorageCount(Map<String, Object> map);
    
	/**
	 * 描述: 判断是否属于食品仓储企业
	 * @auther yujingwei
	 * @date 2016年9月29日 
	 * @param priPID
	 * @return boolean
	 */
	public List<FoodstorageBaseDto> doJudgeIsFoodStorageEnt(String priPID);
}