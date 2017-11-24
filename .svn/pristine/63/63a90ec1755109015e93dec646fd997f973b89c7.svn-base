/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_otherpunish 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
public interface IPubOtherpunishService extends BaseService {
     
	/**
     * 描述：获取行政处罚录入审核列表数据
     * @author yujingwei
     * @data 2016-10-7
     * @param request
     * @return List<PubOtherpunish>
     * @throws Exception
     */
	public List<PubOtherpunish> queryPage(PageRequest request) throws Exception;
    
	/**
     * 描述：通过pripId，caseNo查找行政处罚信息
     * @author yujingwei
     * @data 2016-10-7
     * @param pripid，caseNO
     * @return PubOtherpunish
     * @throws Exception
     */
	public PubOtherpunish doGetPubOtherPunishInfo(String pripid, String caseNO) throws Exception;
    
	/**
     * 描述：行政处罚审核
     * @author yujingwei
     * @data 2016-10-7
     * @param pubOtherpunish
     * @return boolean
     * @throws Exception
     */
	public boolean doCommitPubOtherpunish(PubOtherpunish pubOtherpunish) throws Exception;
    
	/**
     * 描述：删除行政处罚信息
     * @author yujingwei
     * @data 2016-10-7
     * @param priPID，caseNO
     * @return boolean
     * @throws Exception
     */
	public boolean deleteOtherPunishInfo(String priPID, String caseNO) throws Exception;
    
	/**
     * 描述：保存行政处罚变更信息
     * @author yujingwei
     * @data 2016-10-7
     * @param pubOtherpunish，sysUser
     * @return boolean
     * @throws Exception
     */
	public boolean doSavePunishAlter(PubOtherPunishAlter pubOtherPunishAlter,SysUser sysUser) throws Exception;
    
	/**
     * 描述：保存或修改行政处罚信息
     * @author yujingwei
     * @data 2016-10-7
     * @param pubOtherpunish
	 * @param session 
     * @return boolean
     * @throws Exception
     */
	public boolean doSaveOrEditOtherPunishInfo(PubOtherpunish pubOtherpunish, SysUserDto sysUser) throws Exception;
    
	/**
     * 描述：获取行政处罚信息查询列表数据
     * @author yujingwei
     * @data 2016-10-7
	 * @param request 
     * @return List<PubOtherpunish>
     * @throws Exception
     */
	public List<PubOtherpunishDto> queryPageForPunishSearch(PageRequest request) throws Exception;
    
	/**
     * 描述：获取行政处罚详细信息
     * @author yujingwei
     * @data 2016-10-7
	 * @param request 
     * @return List<PubOtherpunish>
     * @throws Exception
     */
	public PubOtherpunishDto selectOtherPunishDetails(Map<String, Object> qryMap) throws Exception;
	
    /**
    * 
    * 描述: 双告知预警提示行政处罚信息（分页查询）
    * @auther gaojinling
    * @date 2016年10月19日 
    * @param licID
    * @return
    */
	public List<PubOtherpunish> selectOtherpunishListByPriPid(PageRequest request);
	
	/**
     * 描述：获取行政处罚信息(用于公告公示)
     * @author yujingwei
     * @data 2016-10-7
	 * @param request 
     * @return List<PubOtherpunish>
     * @throws Exception
     */
	public List<PubOtherpunish> selectOtherPunishForBulletin(String updateDate) throws Exception;
    
	/**
     * 描述：获取行政处罚信息，通过caseNo查询
     * @author yujingwei
     * @data 2016-10-7
	 * @param caseNO 
     * @return PubOtherpunish
     * @throws Exception
     */
	public PubOtherpunishDto doGetOtherPunishInfo(String caseNO) throws Exception;
	
	/** 
	 * 描述: 获取行政处罚信息列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年11月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<PubOtherpunishDto> queryPageForPub(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 根据caseNO获取行政处罚信息详情（公示）
	 * @auther ZhouYan
	 * @date 2016年11月1日 
	 * @param caseNO
	 * @param priPID
	 * @return
	 * @throws Exception 
	 */
	public PubOtherpunishDto doGetPubOtherpunishByCaseNO(String caseNO, String priPID) throws Exception;
	
	/** 
	 * 描述: 获取行政处罚列表计数个数
	 * @auther yujingwei
	 * @date 2016年12月19日 
	 * @param pramsMap
	 * @return List<String>
	 */
	public List<PubOtherpunishDto> queryTotalForPunishSearch(Map<String, Object> pramsMap) throws Exception;
	
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
	
	/**
	 * 指定条件查询行政处罚(更新索引)
	 * @author zjj
	 */
	public List<Map<String,Object>> selectOtherpunishListForIdx(Map<String,Object> qryMap) throws Exception;
	
	/** 
	 * 描述: 通过主体代码获取行政处罚信息
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @param entName
	 * @param regNO 
	 * @return List<PubOtherpunishDto>
	 * @throws Exception 
	 */
	public List<PubOtherpunishDto> doGetPubOtherPunishList(String regNO, String entName) throws Exception;
	
	/**
	 *根据unicode或者regNO查询
	 * @author  ljx
	 */
	MidBaseInfo getBaseInfoByUniIDOrRegNO(String code);
	
	
	/**
	 * 
	 * 描述   查询工商和其他部门的行政处罚
	 * @author 赵祥江
	 * @date 2017年3月16日 下午4:01:45 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	public List<PubOtherpunishDto> selectPubOtherpunishDtoJSON(PageRequest request) throws Exception;
	
}