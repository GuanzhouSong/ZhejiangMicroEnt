/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.mapper.PubOpaDetailMapper;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_pub_opadetail 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@Service
public class PubOpaDetailServiceImpl extends MyBatisServiceSupport implements IPubOpaDetailService {
	private static final Logger logger = LoggerFactory.getLogger(PubOpaDetailServiceImpl.class);

	@Autowired
	private PubOpaDetailMapper pubOpaDetailMapper; 
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	
	
	
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年10月24日 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public int insertPubOpaDetail(PubOpaDetailDto pubOpaDetail) throws Exception{
		try {
			if(pubOpaDetail!=null){
			    //时间戳
				pubOpaDetail.setCreateTime(DateUtils.getSysDate());
				return pubOpaDetailMapper.insert(pubOpaDetail);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "保存撤销或移出信息失败!");
            throw new BusinessException("保存撤销或移出信息失败!");
		} 
		return 0;
	}

	/**
	 * 
	 * 描述: 删除（通过列入NO（对应列入表中的主键uuid））
	 * @auther gaojinling
	 * @date 2016年10月24日 
	 * @param busExcList
	 * @return
	 * @throws Exception
	 */
    public int deletePubOpaDetailByBusExcList(String busExcList)throws Exception{
		try {
			if(StringUtils.isNotEmpty(busExcList)){
				PubOpaDetail pubOpaDetail = new PubOpaDetail();
				pubOpaDetail.setBusExcList(busExcList);
			    return pubOpaDetailMapper.delete(pubOpaDetail);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据主键busExcList删除撤销或移出信息失败!");
            throw new BusinessException("根据主键busExcList删除撤销或移出信息失败!");
		} 
		return 0;
	}

    /**
     * 
     * 描述: 更新
     * @auther gaojinling
     * @date 2016年10月24日 
     * @param
     * @return
     * @throws Exception
     */
     public int updatePubOpaDetail(PubOpaDetailDto pubOpaDetail)throws Exception {
		try {
			if(pubOpaDetail!=null&&StringUtils.isNotEmpty(pubOpaDetail.getBusExcList())){
				//时间戳
				pubOpaDetail.setCreateTime(DateUtils.getSysDate());
				Example example = new Example(PubOpanoMaly.class);
				example.createCriteria().andEqualTo("busExcList", pubOpaDetail.getBusExcList())
				.andEqualTo("priPID", pubOpaDetail.getPriPID());
			    return pubOpaDetailMapper.updateByExampleSelective(pubOpaDetail, example);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据主键busExcList修改移出或撤销信息失败!");
            throw new BusinessException("根据主键busExcList修改移出或撤销信息失败!");
		} 
		return 0;
	}

     /**
      * 
      * 描述: 查询单个移出或撤销
      * @auther gaojinling
      * @date 2016年10月24日 
      * @param busExcList
      * @return
      * @throws Exception
      */
      public PubOpaDetail selectPubOpaDetailByBusExcList(String busExcList,String priPID)throws Exception{
		try {
			if(StringUtils.isNotEmpty(busExcList)){
				PubOpaDetailDto pubOpaDetail = new PubOpaDetailDto();
				pubOpaDetail.setBusExcList(busExcList);
				if(StringUtils.isNotEmpty(priPID)){
					pubOpaDetail.setPriPID(priPID);
				}
				return pubOpaDetailMapper.selectOne(pubOpaDetail);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据主键BusExcList查询移出或撤销对象失败!");
            throw new BusinessException("根据主键BusExcList查询移出或撤销对象失败!");
		} 
		return null;
	}
      @Override
      public List<PubOpaDetail> selectByPriPID(String priPID)throws Exception{ 
    	     Example example=new Example(PubOpaDetail.class);
    		 Criteria criteria=  example.createCriteria();
    		 criteria.andEqualTo("priPID",priPID);
    		 Criteria criteria2=  example.createCriteria();
    		 criteria2.andEqualTo("regNO",priPID);
    		 example.or(criteria2);
    		 example.orderBy("remDate").desc();
    		 return pubOpaDetailMapper.selectByExample(example);
      }
      

	  /**
	   * 
	   * 描述: 移出查询
	   * @auther gaojinling
	   * @date 2016年10月25日 
	   * @param
	   * @return
	   * @throws Exception
	   */
	public List<PubOpaDetailDto> selectMoveOutSearchList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOpaDetailMapper.selectMoveOutSearchList(request.getParams());
	}

	/**
	 * 
	 * 描述: 移出新增查询
	 * @auther gaojinling
	 * @date 2016年10月25日 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<PubOpaDetailDto> selectAddMoveOutSearchList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return pubOpaDetailMapper.selectAddMoveOutSearchList(paramsMap);
	}
	
	/**
	 * 
	 * 描述: 移出新增查询(不分页,更新索引数据)
	 * @auther gaojinling
	 * @date 2016年10月25日 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<PubOpaDetailDto> selectAddMoveOutSearch(
			Map<String, Object> map ) throws Exception {
		map.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return pubOpaDetailMapper.selectAddMoveOutSearchList(map);
	}
	
	/**
	 * 
	 * 描述: 获取当前文号简称下最大文号
	 * @auther gaojinling
	 * @date 2016年10月28日 
	 * @param regOrg
	 * @return
	 * @throws Exception
	 */
	public Integer selectPenDecNoMove(String regOrg,String isMove) throws Exception {
		Map<String, Object> queryMap=  new HashMap<String, Object>();
		queryMap.put("regOrg", regOrg);
		queryMap.put("year",DateUtils.getYear()); //当前年份传入
		queryMap.put("isMove", isMove);
		return pubOpaDetailMapper.selectPenDecNoMove(queryMap);
	}

	/**
	 * 
	 * 描述   根据主键和主体身份代码删除
	 * @author  赵祥江
	 * @date 2017年1月22日 下午2:13:59 
	 * @param  
	 * @throws
	 */
	@Override
	public int deletePubOpaDetailByBusExcList(String busExcList, String priPID)
			throws Exception {
		if(StringUtils.isNotEmpty(busExcList)&&StringUtils.isNotEmpty(priPID)){
			PubOpaDetail pubOpaDetail = new PubOpaDetail();
			pubOpaDetail.setBusExcList(busExcList); 
			pubOpaDetail.setPriPID(priPID); 
			return pubOpaDetailMapper.delete(pubOpaDetail); 
		}
		return 0;
	}
	
	

	/**
	 * 
	 * 描述: 异常列入待审核条数（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer selectPubOpaInCount(Map<String, Object> map)
			throws Exception {
		try {
			return pubOpaDetailMapper.selectPubOpaInCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("异常列入待审核条数查询失败!");
		}
	}

	/**
	 * 
	 * 描述: 移出+撤销待审核条数（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer selectPubOpaOutCount(Map<String, Object> map)
			throws Exception {
		try {
			return pubOpaDetailMapper.selectPubOpaOutCount(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("异常移出及撤销待审核条数查询失败!");
		}
	}

	/**
	 * 查询所有数据
	 * @return
     */
	@Override
	public List<PubOpaDetail> selectFindAll() {
		return	pubOpaDetailMapper.selectAll();
	}
	
	
	/**
	 * 
	 * 描述   根据主体身份代码和操作类型查询异常信息
	 * @author  赵祥江
	 * @date 2017年7月5日 下午8:25:16 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubOpaDetail> selectPubOpaDetailBypriPIDAndIsMove(
			String priPID, String isMove) throws Exception {
		PubOpaDetail pubOpaDetail = new PubOpaDetail();
		pubOpaDetail.setIsMove(isMove); 
		pubOpaDetail.setPriPID(priPID); 
		pubOpaDetail.setAuditState("1");
		return pubOpaDetailMapper.select(pubOpaDetail);
	}


}