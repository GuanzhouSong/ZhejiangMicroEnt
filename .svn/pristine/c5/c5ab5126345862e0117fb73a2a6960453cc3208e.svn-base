/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_opadetail 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
public interface IPubOpaDetailService extends BaseService {
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年10月24日 
	 * @param pubOpanoMaly
	 * @return
	 * @throws Exception
	 */
	public int insertPubOpaDetail(PubOpaDetailDto pubOpaDetail) throws Exception;

	/**
	 * 
	 * 描述: 删除（通过列入NO（对应列入表中的主键uuid））
	 * @auther gaojinling
	 * @date 2016年10月24日 
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
    public int deletePubOpaDetailByBusExcList(String busExcList)throws Exception;

   /**
    * 
    * 描述: 更新
    * @auther gaojinling
    * @date 2016年10月24日 
    * @param pubOpanoMaly
    * @return
    * @throws Exception
    */
    public int updatePubOpaDetail(PubOpaDetailDto pubOpaDetail)throws Exception;

   /**
    * 
    * 描述: 查询单个
    * @auther gaojinling
    * @date 2016年10月24日 
    * @param busExcList
    * @return
    * @throws Exception
    */
    public PubOpaDetail selectPubOpaDetailByBusExcList(String busExcList,String priPID)throws Exception;
    
    /**
     * 
     * 描述: 移出查询
     * @auther gaojinling
     * @date 2016年10月25日 
     * @param queryMap
     * @return
     * @throws Exception
     */
    public List<PubOpaDetailDto>  selectMoveOutSearchList(PageRequest request)throws Exception;
    
    
    /**
	 * 
	 * 描述: 移出新增查询（列入未移出且未申请移出（即不属于移出待审核状态））（同撤销新增查询）
	 * @auther gaojinling
	 * @date 2016年10月25日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<PubOpaDetailDto> selectAddMoveOutSearchList(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述:获取当前登记机关下最大文号
	 * @auther gaojinling
	 * @date 2016年10月28日 
	 * @param regOrg
	 * @return
	 * @throws Exception
	 */
	public Integer selectPenDecNoMove (String regOrg,String isMove) throws Exception;
	
	/**
	 * 
	 * 描述: 移出新增查询(不分页)
	 * @auther gaojinling
	 * @date 2016年10月25日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<PubOpaDetailDto> selectAddMoveOutSearch(
			Map<String, Object> map ) throws Exception;
   /**
    * 更加priPID查询
    * @param priPID
    * @return
    * @throws Exception
    */
	 List<PubOpaDetail> selectByPriPID(String priPID) throws Exception;
	 
	 /**
	  * 
	  * 描述   根据主键和主体身份代码删除
	  * @author 赵祥江
	  * @date 2017年1月22日 下午2:08:15 
	  * @param 
	  * @return int
	  * @throws
	  */
	 public int deletePubOpaDetailByBusExcList(String busExcList,String priPID)throws Exception;
	 
	 /**
	  * 
	  * 描述: 列入待审核条数（警示首页）
	  * @auther gaojinling
	  * @date 2017年3月20日 
	  * @param map
	  * @return
	  * @throws Exception
	  */
	 public Integer selectPubOpaInCount(Map<String, Object> map) throws Exception ;
	 
	 /**
	  * 
	  * 描述: 移出+撤销待审核条数（警示首页）
	  * @auther gaojinling
	  * @date 2017年3月20日 
	  * @param map
	  * @return
	  * @throws Exception
	  */
	 public Integer selectPubOpaOutCount(Map<String, Object> map) throws Exception ;

	/**
	 * 描述：查询所有数据
	 * @return
     */
	List<PubOpaDetail> selectFindAll();
	
	
	 /**
	  * 
	  * 描述   根据主体身份代码和操作类型查询异常信息
	  * @author 赵祥江
	  * @date 2017年7月5日 下午8:24:30 
	  * @param 
	  * @return List<PubOpaDetail>
	  * @throws
	  */
	 public List<PubOpaDetail> selectPubOpaDetailBypriPIDAndIsMove (String priPID,String isMove) throws Exception;
	 
}