/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月18日
 * @version 2.0
 */
package com.icinfo.cs.dtinfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.dtinfo.model.PubDtInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_dtinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface PubDtInfoMapper extends Mapper<PubDtInfo> {
	/**
	 * 
	 * 描述    查询待手动分流的企业（分流失败和退回待推送）
	 * @author 赵祥江
	 * @date 2016年10月17日 下午3:23:30 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectPubdtinfoFailReBackList(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   查询部门未认领的审批事项
	 * @author 赵祥江
	 * @date 2017年4月14日 下午5:00:27 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectTransferPubdtinfoList(Map<String,Object> queryMap)throws Exception;
	
	
	
	
	
	/**
	 * 
	 * 描述   查询已经认领的企业信息
	 * @author 赵祥江
	 * @date 2017年1月5日 下午3:04:40 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectPubdtinfoCancelList(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   涉证推送反馈统计 (暂时不用)
	 * @author 赵祥江
	 * @date 2016年10月20日 下午4:38:00 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectPubDtInfoCount(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   涉证推送反馈统计
	 * @author 赵祥江
	 * @date 2017年5月23日 下午2:34:17 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectPubDtInfoCountRlt(Map<String,Object> queryMap)throws Exception;
	
	
	/**
	 * 
	 * 描述: 涉证企业查询(分页)
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param map
	 * @return
	 */
	List<PubDtInfoDto> selectPubDtinfoListSearch(Map<String,Object> map);
	
	/**
	 * 
	 * 描述:涉证企业查询条数
	 * @auther gaojinling
	 * @date 2017年1月13日 
	 * @param map
	 * @return
	 */
	public Integer  selectPubDtinfoListSearchCount(Map<String,Object> map);
	/**
	 * 
	 * 描述: 涉证企业查询详情（工商登记信息）
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param map
	 * @return
	 */
	PubDtInfoDto selectPubDtInfoByPraMap(Map<String,Object> map);
	
	/**
	 * 
	 * 描述   根据注册号和主体身份代码获取不重复的审批事项编码
	 * @author 赵祥江
	 * @date 2016年12月7日 下午8:14:52 
	 * @param 
	 * @return List<PubDtInfo>
	 * @throws
	 */
	List<PubDtInfo> selectDistinctExaCodeByRegNoAndPriPID(Map<String,Object> map);
	
	/**
	 * 
	 * 描述: 涉证企业查询处统计(1.分流成功 2分流失败 3回退待分流 4终止推送 )
	 * @auther gaojinling
	 * @date 2016年10月23日 
	 * @return
	 */
	public int pubDtinfoSearchCount(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 涉证企业查询处统计：推送企业条数
	 * @auther gaojinling
	 * @date 2016年10月23日 
	 * @return
	 */
	public int pubDtinfoCount(Map<String, Object> map);
	
	
	/**
	 * 
	 * 描述: 涉证企业查询处统计：推送审批 部门条数
	 * @auther gaojinling
	 * @date 2016年10月23日 
	 * @return
	 */
	public int sendDeptCount(Map<String, Object> map);
	
	/**
	 * @return 
	 * 
	 * 描述   认领撤销
	 * @author 赵祥江
	 * @date 2017年1月5日 下午6:44:28 
	 * @param 
	 * @return void
	 * @throws
	 */
	public int updatePubDtInfoCancel(Map<String, Object> map)throws Exception;
	/**
	 * 
	 * 描述   获取手动分流条数
	 * @author 赵祥江
	 * @date 2017年1月15日 下午6:36:05 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectPubdtinfoFailReBackListCount(
			Map<String, Object> queryMap) throws Exception;
	
	/**
	 * 
	 * 描述: 查询本年度本部门已认领或接收的条数
	 * @auther gaojinling
	 * @date 2016年11月17日 
	 * @param checkDep
	 * @return
	 */
	public int claimAndReceiveCount(@Param("checkDep")String checkDep,@Param("userType")String userType,@Param("year")String year);
    
	/**
	 * 描述:获取审批部门个数(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return PubDtInfoDto
	 * @throws Exception
	 */
	public String selectCheckDepTotalForCharts(Map<String, Object> qryMap);
    
	/**
	 * 描述:获取推送个数(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return PubDtInfoDto
	 * @throws Exception
	 */
	public String selectPushTotalForCharts(Map<String, Object> qryMap);
	
	/**
	 * 描述:获取认领个数(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return PubDtInfoDto
	 * @throws Exception
	 */
	public String selectClaimTotalForCharts(Map<String, Object> qryMap);
    
	/**
	 * 描述:市级认领个数
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  qryMap
	 * @return String
	 * @throws Exception
	 */
	public String selectClaimTotalForCity(Map<String, Object> qryMap);
	/**
	 * 描述:县级认领个数
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  qryMap
	 * @return String
	 * @throws Exception
	 */
	public String selectClaimTotalForCounty(Map<String, Object> qryMap);
	/**
	 * 描述:省级认领个数
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  qryMap
	 * @return String
	 * @throws Exception
	 */
	public String selectClaimTotalForPro(Map<String, Object> qryMap);
	
	/**
	 * 描述:获取部门推送top10情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public List<PubDtInfoDto> selectClaimInfoForDuty(Map<String, Object> params);
    
	/**
	 * 描述:已退回个数(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public String selectBackTotalForCharts(Map<String, Object> params);
	/**
	 * 描述:未认领个数(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public String selectNoClaimCountForCharts(Map<String, Object> params);
    
	/**
	 * 描述:获取各地市部门认领情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public List<PubDtInfoDto> selectClaimInfoForArea(Map<String, Object> params);
}