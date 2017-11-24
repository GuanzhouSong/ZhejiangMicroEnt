/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptSmBaseinfoDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sm_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public interface IRptSmBaseinfoService extends BaseService {

	/**
	 * 描述: 培育库分页列表
	 * 
	 * @author 张文男
	 * @date 2017年5月3日
	 * @param request
	 * @throws Exception 
	 */
	public PageResponse<RptSmBaseinfoDto> queryPageListForEntarchives(PageRequest request) throws Exception;

	/**
	 * 描述: 获取企业、培育库分页列表
	 * 
	 * @author 张文男
	 * @date 2017年5月4日
	 * @param params
	 * @return
	 */

	public List<RptSmBaseinfoDto> queryEntAndEntarchivesPageList(PageRequest request);

	/**
	 * 描述: 根据企业id获取对象
	 * 
	 * @author 张文男
	 * @date 2017年5月5日
	 * @param priPID
	 * @return
	 */

	public RptSmBaseinfoDto queryBeanByPriPID(String priPID);

	/**
	 * 描述：查询小微企业信息
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @param paramMap
	 * @return
	 */
	public List<RptSmBaseinfoDto> selectListByCondition(String condition);

	/**
	 * 描述：获取需要增量更新的小微企业数量
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @param qryMap
	 * @return
	 */
	public int queryIncreCount(Map<String, Object> qryMap);

	/**
	 * 描述：获取pripid
	 * @author baifangfang
	 * @date 2017年5月8日
	 * @param qryMap
	 * @return
	 */
	public List<RptSmBaseinfoDto> queryIncreData(Map<String, Object> qryMap);
	
	/**
	 * 根据pripid分别从cs_mid_baseinfo和sm_baseinfo中取出数据
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public List<RptSmBaseinfoDto> selectOneForCompare(String priPID) throws Exception;

	/**
	 * 描述：向云服务器导入小微全量数据
	 * @author baifangfang
	 * @date 2017年5月9日
	 */
//	public void doInsertSmEntDataToGsById();

	/**
	 * 描述：小微企业信息查询
	 * @author baifangfang
	 * @date 2017年5月9日
	 * @param request
	 * @return
	 */
	public Page<RptSmBaseinfoDto> doGetSmBaseinfoList(PageRequest request);
	
	/**
	 * 从cs_mid_baseinfo查询出结果插入到sm_baseinfo中去
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
//	public void insertOneFromCsMidBaseinfo(String priPID,String isSment,String smentReason) throws Exception;

	/**
	 * 描述：小微企业年报详情查看页面
	 * @author baifangfang
	 * @date 2017年5月11日
	 * @param request
	 * @return
	 */
	public List<RptSmBaseinfoDto> queryPageResult(PageRequest request);
	
	/**
	 * 删除
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
//	public void deleteByPriPID(String priPID) throws Exception;
	
	
	/**
	 * 
	 * 描述: 小微监测年报信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmBaseinfoDto> selectYrSmNormalCount(PageRequest request) throws Exception ;
	
	/**
	 * 
	 * 描述: 小微监测年报信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmBaseinfoDto> selectYrRptImportCount(PageRequest request) throws Exception ;
	
	
	 /** 
	 * 描述: 根据注册号获取不在培育库的pripid
	 * @author 张文男
	 * @date 2017年6月15日 
	 * @param regNoOrUniCode
	 * @return 
	 */
	
	 public String queryPriPIDByRegNoOrUniCode(String regNoOrUniCode);
	 
	 /** 
	  * 描述: 根据pripid获取类型
	  * @author 张文男
	  * @date 2017年6月20日 
	  * @param priPID
	  * @return 
	  */
	
	 public List<String> selectTypeByPriPID(String priPID);
	 
	/**
	 * 
	 * 描述: 小微企业总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int smbaseinfoCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 小微可视化首页年报相关统计
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public RptSmBaseinfoDto smbaseinfoNbCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 小微年报可视化三次产业统计
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int smbaseThreeTypeCount(Map<String, Object> map) throws Exception;

	public Long countSgsjBySetDeptCode(String sysSetDeptCode);

	/**
	 *@Description 获取首页企业上规升级列表
	 *@author ylr
	 *@date 2017-11-17
	 */
	public List<RptSmBaseinfoDto> selectSgsjBySetDeptCodeList(SysUserDto sysUser,PageRequest request)throws Exception;
	/**
	 *@Description 获取首规升页企业上级列表
	 *@author ylr
	 *@date 2017-11-17
	 */
	public List<RptSmBaseinfoDto> selectZxList(SysUserDto sysUser,PageRequest request)throws Exception;
	/**
	 *@Description 根据部门code获取经营异常企业数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	public List<RptSmBaseinfoDto> selectJyycBySetDeptCodeList(SysUserDto sysUser,PageRequest request)throws Exception;

	/**
	 *@Description 根据部门code获取违法违规企业数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	public List<RptSmBaseinfoDto> selectWfwgBySetDeptCodeList(SysUserDto sysUser,PageRequest request)throws Exception;
	/**
	 *@Description 根据部门code获取营收下降企业数量list
	 *@author ylr
	 *@date 2017-11-17
	 */
	public List<RptSmBaseinfoDto> selectJyxjBySetDeptCodeList(SysUserDto sysUser,PageRequest request)throws Exception;


    /**
     * 获取培育库历史档案
     * @author zjj
     * 20170508
     */
    public List<RptSmBaseinfoDto> queryPage(PageRequest request);
    
	/**
	 * 描述: 获取小微企业库详细信息
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param uID
	 * @return SmBaseInfo
	 * @throws Exception
	 */
	public RptSmBaseinfoDto doGetSmBaseInfo(String uID) throws Exception;
    
	/**
	 * 描述: 获取小微企业库列表数据
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param request
	 * @return List<SmBaseInfo>
	 * @throws Exception
	 */
	public List<RptSmBaseinfoDto> doGetSmallDirInfoList(PageRequest request) throws Exception;
    
	
}