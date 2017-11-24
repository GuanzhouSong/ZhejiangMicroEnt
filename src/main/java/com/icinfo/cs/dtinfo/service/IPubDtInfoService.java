/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dtinfo.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.dtinfo.model.PubDtInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_dtinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface IPubDtInfoService extends BaseService {
	/**
	 * 
	 * 描述   涉证企业分流 查询推送失败和未分流的企业
	 * @author 赵祥江
	 * @date 2016年10月17日 下午3:19:01 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> queryPubdtinfoFailReBackListJSON(PageRequest request)throws Exception;
	
	
	/**
	 * 
	 * 描述   查询部门未认领的审批事项
	 * @author 赵祥江
	 * @date 2017年4月14日 下午5:00:27 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectTransferPubdtinfoList(String checkDep,String exaCode,String areaCode)throws Exception;
	
	
	
	/**
	 * 
	 * 描述   查询撤销列表
	 * @author 赵祥江
	 * @date 2017年1月5日 下午3:06:05 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> queryPubdtinfoCancelListJSON(PageRequest request)throws Exception; 
	
	
	
	/**
	 * 
	 * 描述   根据UID查询
	 * @author 赵祥江
	 * @date 2016年10月18日 上午11:35:34 
	 * @param 
	 * @return PubDtInfo
	 * @throws
	 */
	public PubDtInfo selectPubDtInfoByUID(String  UID)throws Exception;
	
	/**
	 * 
	 * 描述   根据UID修改
	 * @author 赵祥江
	 * @date 2016年10月18日 下午12:14:53 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updatePubDtInfoByUID(PubDtInfo  pubDtInfo)throws Exception;
	
	/**
	 * 
	 * 描述   插入
	 * @author 赵祥江
	 * @date 2016年10月18日 下午12:19:54 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertPubDtInfo(PubDtInfo pubDtInfo) throws Exception;
	
	
	/**
	 * 
	 * 描述: 查询单个涉证企业信息
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param priPID
	 * @param dtid
	 * @return
	 * @throws Exception
	 */
	public PubDtInfo selectOne(String priPID,String uid) throws Exception;
	
	/**
	 * 
	 * 描述: 涉证企业查询（分页）
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubDtInfoDto> queryPage(PageRequest request,SysUserDto sysUser) throws Exception;
	
	/**
	 * 
	 * 描述: 涉证企业查询(条数)
	 * @auther gaojinling
	 * @date 2017年1月13日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectPubdtinfoSearchCount() throws Exception;
	
	/**
	 * 
	 * 描述   涉证推送反馈统计
	 * @author 赵祥江
	 * @date 2016年10月20日 下午4:38:00 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<PubDtInfoDto> selectPubDtInfoCount(PageRequest request)throws Exception;
	
	
	/**
	 * 
	 * 描述   根据注册号和主体身份代码获取不重复的审批事项编码
	 * @author 赵祥江
	 * @date 2016年10月24日 上午11:37:58 
	 * @param 
	 * @return List<PubDtInfo>
	 * @throws
	 */
	public List<PubDtInfo> selectDistinctExaCodeByRegNoAndPriPID(
			String  regNo,String priPid) throws Exception;
	
	
	/**
	 * 
	 * 描述: 涉证企业查询详细信息（工商登记信息）
	 * @auther gaojinling
	 * @date 2016年10月17日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public PubDtInfoDto selectPubDtInfoByPraMap(Map<String, Object> map) throws Exception ;
	
	
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
	 * 
	 * 描述   批量保存
	 * @author 赵祥江
	 * @date 2016年10月24日 下午4:06:35 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertBatchPubDtinfo(List<PubDtInfo> pubDtinfoList)throws Exception; 
	
	/**
	 * 
	 * 描述   去掉参数的左右空格
	 * @author 赵祥江
	 * @date 2016年10月28日 下午4:25:12 
	 * @param 
	 * @return  
	 * @throws
	 */
	public void  paramTrim(Map<String,Object> dataMap) throws Exception;
	
	/**
	 * 
	 * 描述   校验同一部门同一企业同一审批事项是否推送过
	 * @author 赵祥江
	 * @date 2016年11月10日 下午8:06:20 
	 * @param 
	 * @return boolean
	 * @throws
	 */
	public boolean  checkPush(String exaCode,String checkDep,String priPID) throws Exception;
	
	/**
	 * 
	 * 描述: 查询本年度本部门已认领或接收的条数
	 * @auther gaojinling
	 * @date 2016年11月17日 
	 * @param checkDep
	 * @return
	 * @throws Exception
	 */
	public int claimAndReceiveCount(SysUserDto sysUser) throws Exception;
	
	/**
	 * 
	 * 描述   获取手动分流条数
	 * @author 赵祥江
	 * @date 2017年1月15日 下午6:33:29 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectPubdtinfoFailReBackListCount(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   认领撤销修改
	 * @author 赵祥江
	 * @date 2017年1月5日 下午6:45:42 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int  updatePubDtInfoCancel(PubDtInfo pubDtInfo) throws Exception;

	/**
	 * 描述:获取推送，认领，部门个数等基础数据(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public PubDtInfoDto doGetDtCommonDataForCharts(PageRequest request) throws Exception;

	/**
	 * 描述:获取部门推送情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public PubDtInfoDto doGetDeptClaimDataForCharts(PageRequest request) throws Exception;

	/**
	 * 描述:获取部门推送top10情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public List<PubDtInfoDto> doGetClaimInfoForDutyData(PageRequest request) throws Exception;

	/**
	 * 描述:获取部门认领情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public PubDtInfoDto doGetDutyClaimOptForCharts(PageRequest request) throws Exception;

	/**
	 * 描述:获取各地市部门认领情况(可视化)
	 * 
	 * @author yujingwei
	 * @date 2017-11-10
	 * @param  request
	 * @return AjaxResult
	 * @throws Exception
	 */
	public List<PubDtInfoDto> doGetAreaClaimDataForCharts(PageRequest request) throws Exception; 
	
}