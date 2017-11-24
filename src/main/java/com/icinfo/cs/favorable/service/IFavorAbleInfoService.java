/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.favorable.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.favorable.dto.FavorAbleInfoDto;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_favorable_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年03月02日
 */
public interface IFavorAbleInfoService extends BaseService {

	/**
	 * 描述：查询企业良好信息录入列表数据
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @param request
	 * @throws Exception
	 */
	public List<FavorAbleInfoDto> queryPageResult(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述   分页企业良好信息查询
	 * @author 赵祥江
	 * @date 2017年3月3日 下午2:40:33 
	 * @param 
	 * @return List<FavorAbleInfoDto>
	 * @throws
	 */
	public List<FavorAbleInfoDto> queryFavorAblePage(PageRequest request) throws Exception  ;
	
	
	/**
	 * 
	 * 描述   根据UID查询
	 * @author 赵祥江
	 * @date 2017年3月6日 下午1:44:43 
	 * @param 
	 * @return List<FavorAbleInfo>
	 * @throws
	 */
	public FavorAbleInfo selectFavorAbleInfoByUid(String uid) throws Exception  ;
     
	/**
	 * 描述：删除企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param uid
	 * @throws Exception
	 */
	public int doDeleteInfoByUid(String uid) throws Exception;
    
	/**
	 * 描述：保存企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @throws Exception
	 */
	public int doSaveFavorableInfo(FavorAbleInfo favorAbleInfo) throws Exception;
    
	/**
	 * 描述：修改企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @param uid 
	 * @throws Exception
	 */
	public int doUpdateFavorableInfo(FavorAbleInfo favorAbleInfo, String uid) throws Exception;
    
	/**
	 * 描述：企业良好信息审核
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @author boolean
	 */
	public boolean doCommitFavorableInfo(FavorAbleInfo favorAbleInfo) throws Exception; 
	
	/**
	 * 
	 * 描述   根据主体代码查询已经审核通过的企业良好信息
	 * @author 赵祥江
	 * @date 2017年3月9日 上午10:07:37 
	 * @param 
	 * @return List<FavorAbleInfo>
	 * @throws
	 */
	public List<FavorAbleInfo> selectFavorAbleInfoBypriPIDAndEfftStatus(PageRequest request) throws Exception  ;
	
	/**
	 * 
	 * 描述     根据主体代码查询已经审核通过的不良信息
	 * @author 赵祥江
	 * @date 2017年3月9日 下午2:01:09 
	 * @param 
	 * @return List<FavorAbleInfo>
	 * @throws
	 */
	public List<FavorAbleInfo> selectCaseInfoBypriPIDAndEfftStatus(PageRequest request) throws Exception  ;
    
	/**
	 * 描述     Excel批量导入
	 * @author yujingwei
	 * @date 2017-03-13
	 * @param InputStream,sysUser
	 * @return boolean
	 * @throws Exception
	 */
	public Map<String, String> doSaveFavorableInfoExcelBatch(InputStream in,SysUserDto sysUser) throws Exception;
    
	/**
	 * 描述     批量审核
	 * @author yujingwei
	 * @date 2017-03-13
	 * @param favorAbleInfo,uids
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doSaveBatchFavorableInfo(FavorAbleInfo favorAbleInfo,String uids) throws Exception;

	/** 
	 * 描述: 根据身份号获取列表信息
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<FavorAbleInfo> selectListByCerNO(PageRequest request) throws Exception  ;

	/**
	 * 描述：定时任务查询企业良好信息
	 * @author baifangfang
	 * @date 2017年10月16日
	 * @param updateDate
	 * @return
	 */
	public List<FavorAbleInfo> selectFavorAbleInfoForBulletin(String updateDate);
	
	/** 
	 * 描述: 分页查询良好荣誉信息(公示)
	 * @auther ZhouYan
	 * @date 2017年10月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<FavorAbleInfo> queryFavorAbleInfoForPub(PageRequest request) throws Exception;
	
}