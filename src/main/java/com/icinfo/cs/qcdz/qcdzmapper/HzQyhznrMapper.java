/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月22日
 * @version 2.0
 */
package com.icinfo.cs.qcdz.qcdzmapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.qcdz.qcdzdto.HzQyhznrDto;
import com.icinfo.cs.qcdz.qcdzmodel.HzQyhznr;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    hz_qyhznr 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月22日
 */
public interface HzQyhznrMapper extends Mapper<HzQyhznr> {
	
	/**
	 * 
	 * 描述: 查询当前年度主体总数及同比增长率
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectZtCount(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 查询当前年度各分类主体总数
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectTypeZtCount(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 当前年每月新设消亡数量
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectXsXwCount(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 查询今日新成立企业 各地市分布
	 * @auther gaojinling
	 * @date 2017年9月22日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectDayXsCount(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 查询今日新成立企业 各地市分布
	 * @auther gaojinling
	 * @date 2017年9月22日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectDayZxCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 查询股东分类(按照股东类型)
	 * @auther gaojinling
	 * @date 2017年10月10日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectinvTypeCount(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * 描述: 查询股东区域分类
	 * @auther gaojinling
	 * @date 2017年10月10日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectAreainvTypeCount(Map<String, Object> map) throws Exception;
	
	public List<HzQyhznrDto> selectIndustryinvTypeCount(Map<String, Object> map) throws Exception;
	
	public Integer selectIndustryinvTypeTotalCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 5分钟内各登记机关新设数量
	 * @auther gaojinling
	 * @date 2017年11月1日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectHzMapList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 5分钟内各登记机关注销数量
	 * @auther gaojinling
	 * @date 2017年11月1日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<HzQyhznrDto> selectBfMapList(Map<String, Object> map) throws Exception;
	
	

}