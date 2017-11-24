/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月25日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScinfoDto;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_scinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface PubScinfoMapper extends Mapper<PubScinfo> {
	/**
	 * 
	 * 描述: 获取查抽检查结果录入列表list(工商端)
	 * @auther chenxin
	 * @date 2016-10-26
	 * @param map 
	 * @return List<ModApplicationDto>
	 */
	public List<PubScinfoDto> selectPubScinfoDtoList(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 获取查抽检查结果录入列表list(工商端)有权限
	 * @auther chenxin
	 * @date 2016-10-26
	 * @param map 
	 * @return List<ModApplicationDto>
	 */
	public List<PubScinfoDto> selectPubScinfoDtoListByauth(Map<String, Object> map);
	
	/**
	 * 描述：批量插入记录
	 * @author chenxin
	 * @date 2016-11-02
	 * @param pubScinfoList
	 * @throws Exception
	 */
	public int insertBatch(List<PubScinfo> list)throws Exception;
	
	/**
	 * 描述：获取随机选中的企业
	 * @author chenxin
	 * @date 2016-11-02
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfo> selectPubScinfoByOrderList(Map<String,Object> params);
	
	/**
	 * 描述：根据任务编号查询企业信息(工商端)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public PubScinfoDto selectPubScinfoDtoByTaskNO(Map<String,Object> params);
	
	
	//======================随机========================
	/**
	 * 
	 * 描述: 获取查抽检查结果录入列表list(工商端)
	 * @auther chenxin
	 * @date 2016-10-26
	 * @param map 
	 * @return List<PubScinfo>
	 */
	public List<PubScinfo> selectRandomPubScinfoList(Map<String, Object> map);
	
	
	/**
	 * 描述：查询已经选中列表
	 * @author chenxin
	 * @date 2017-11-08
	 * @param taskNO
	 * @return
	 */
	public List<PubScinfoDto> selectPubScinfoByTaskNO(Map<String,Object> params);
	
	/**
	 * 描述： 根据随机数查询企业
	 * @author chenxin
	 * @date 2016-11-21
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public PubScinfo selectPubScinfoForInsert(Map<String,Object> params)throws Exception;
	
	/**
	 * 描述： 定时更新es索引文件
	 * @author chenxin
	 * @date 2016-11-28
	 * @param creatTime
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfo> selectPubScinfoForUpdateEs(Map<String,Object> params)throws Exception;
	
	/**
	 * 描述：根据任务编号查询管辖单位
	 * @author chenxin
	 * @date 2016-11-28 
	 * @param taskNO
	 * @return
	 */
	public List<String> selectLocalAdmList(Map<String,Object> params);

	/**
	 * 描述：所所交叉查询企业
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoDto> selectPubScinfoForCross(Map<String, Object> params);
	
	/**
	 * 描述：统计各个地区抽检到的企业数量
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoDto> selectRegOrgShortCount(Map<String, Object> params);
	
	/**
	 * 描述：统计各个登记机关抽检到的企业数量
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoDto> selectRegOrgCount(Map<String, Object> params);
}