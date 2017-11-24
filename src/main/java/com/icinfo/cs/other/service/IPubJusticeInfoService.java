/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.other.dto.PubJusticeInfoDto;
import com.icinfo.cs.other.model.PubJusticeInfo;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_justiceinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface IPubJusticeInfoService extends BaseService {
    
	/**
     * 描述：获取司法协助信息录入列表数据
     * @author yujingwei
     * @data 2016-10-17
     * @param request
     * @return List<PubJusticeInfo>
     * @throws Exception
     */
	public List<PubJusticeInfo> queryPage(PageRequest request) throws Exception;
	
	/**
     * 描述：通过priPID，UID查询司法协助信息
     * @author yujingwei
     * @data 2016-10-17
     * @param pripid,uID
     * @return PubJusticeInfo
     * @throws Exception
     */
	public PubJusticeInfo doGetPubJusticeInfo(String pripid, String UID) throws Exception;
    
	/**
     * 描述：通过priPID，UID删除司法协助信息
     * @author yujingwei
     * @data 2016-10-17
     * @param pripid,uID
     * @return PubJusticeInfo
     * @throws Exception
     */
	public boolean deletePubJusticeInfo(String priPID, String uID) throws Exception;
     
	/**
     * 描述：新增或修改司法协助信息
     * @author yujingwei
     * @data 2016-10-17
     * @param pubJusticeInfo
	 * @param sysUser 
     * @return boolean
     * @throws Exception
     */
	public boolean doAddAndEditJusticeInfo(PubJusticeInfoDto pubJusticeInfoDto, SysUser sysUser) throws Exception;
     
	/**
     * 描述：司法协助提交审核
     * @author yujingwei
     * @data 2016-10-17
     * @param pubJusticeInfo
	 * @param sysUser 
     * @return boolean
     * @throws Exception
     */
	public boolean doCommitJusticeInfo(PubJusticeInfo pubJusticeInfo,SysUser sysUser) throws Exception;
    
	/**
     * 描述：获取司法协助信息查询数据
     * @author yujingwei
     * @data 2016-10-17
	 * @param request 
     * @return List<PubJusticeInfoDto>
     * @throws Exception
     */
	public List<PubJusticeInfoDto> queryPageForSearch(PageRequest request) throws Exception;
    
	/**
     * 描述：通过pripid 和 justiceType 查询司法信息
     * @author yujingwei
     * @data 2016-10-17
     * @param pripid
	 * @param justiceType 
     * @return List<PubJusticeInfo>
     * @throws Exception
     */
	public List<PubJusticeInfo> doGetPubJusticeInList(String pripid,String justiceType) throws Exception;
    
	/**
     * 描述：查询司法协助信息（被执行人选择页面）
     * @author yujingwei
     * @data 2016-10-17
     * @param pubJusticeInfo
	 * @param request 
     * @return List<PubJusticeInfo>
     * @throws Exception
     */
	public List<PubJusticeInfo> queryPageForInclude(PageRequest request) throws Exception;
    
	/**
     * 描述：查询司法协助信息（用于公告公示）
     * @author yujingwei
     * @data 2016-10-17
     * @param pubJusticeInfo
	 * @param request 
     * @return List<PubJusticeInfo>
     * @throws Exception
     */
	public List<PubJusticeInfo> doGetJusticeInfoForBulletin(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 查询司法协助信息（用于公告公示）
	 * @param updateDate 
	 * @auther yujingwei
	 * @date 2016年10月26日 
	 * @param justiceType
	 * @return List<PubJusticeInfo>
	 * @throws Exception 
	 */
	public List<PubJusticeInfo> doGetInfoByJusticeType(String updateDate) throws Exception;
	
	/** 
	 * 描述: 获取司法协助信息录入列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<PubJusticeInfo> queryPageForPub(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 司法协助信息录入详情（公示）
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param UID
	 * @return
	 * @throws Exception 
	 */
	public PubJusticeInfo doGetPubJusticeInfoForPub(String UID) throws Exception;
	
	/**
     * 描述：通过priPID查询司法协助信息
     * @author chenyu
     * @data 2016-10-31
     * @param pripid
     * @return PubJusticeInfo
     * @throws Exception
     */
	public List<PubJusticeInfo> selectPubJusticeInfoListByPriPID(PageRequest request) throws Exception;

	/**
     * 描述：通过cerNO查询司法协助信息
     * @author chenyu
     * @data 2016-10-31
     * @param pripid
     * @return PubJusticeInfo
     * @throws Exception
     */
	public List<PubJusticeInfoDto> selectSpPledgeListByCerNO(PageRequest request);
    
	/**
     * 描述：司法协助-股权冻结定时失效
     * @author yujingwei
     * @data 2016-10-17
     * @param 
     * @throws Exception
     */
	public void doSetfrozNoEffect() throws Exception;
	
	/**
	 * 
	 * 描述:Excel 导入
	 * @auther ljx
	 * @date 2016年11月24日 
	 * @param list
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> importByExcel(List<List<Object>> list,HttpSession session) throws Exception;

	MidBaseInfo getBaseInfoByUniIDOrRegNO(String code);
    
	/**
     * 描述：查询某一个企业股权是否是冻结状态
     * 
     * @author yujingwei
     * @data 2016-10-17
     * @param  priPID
     * @throws Exception
     */
	public boolean doJudgeIsExsitIsForzenInfo(String priPID) throws Exception;
	
	
}