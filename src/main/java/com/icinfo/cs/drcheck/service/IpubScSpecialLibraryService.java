/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.model.pubScSpecialLibrary;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scspecial_library 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月19日
 */
public interface IpubScSpecialLibraryService extends BaseService {
    
	/**
	 * 描述: 获取专项检查对象主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    public List<pubScSpecialLibrary> doGetScSpecialLibraryInfo(PageRequest request) throws Exception;
    
    
    /**
     * 描述: 获取专项检查对象主体库数据
     * @auther yujingwei
     * @date 2017年4月19日
     * @param request
     * @return List<pubScSpecialLibrary>
     * @throws Exception
     */
    public List<pubScSpecialLibrary> doGetScSpecialLibraryList(PageRequest request) throws Exception;
    
    /**
	 * 描述: 保存专项检查对象主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param pubScSpecialLibrary
     * @param sysUser 
	 * @return int
	 * @throws Exception
	 */
	public int doSaveScSpecialInfo(pubScSpecialLibrary pubScSpecialLibrary, SysUserDto sysUser) throws Exception;
    
	/**
	 * 描述: 更新专项检查对象主体库数据
	 * @param sysUser 
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param pubScSpecialLibrary，uid
	 * @return int
	 * @throws Exception
	 */
	public int doUpdateScSpecialInfo(pubScSpecialLibrary pubScSpecialLibrary,String uid, SysUserDto sysUser) throws Exception;
    
	/**
	 * 描述: 通过uid查询专项检查主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param uid
	 * @return pubScSpecialLibrary
	 * @throws Exception
	 */
	public pubScSpecialLibrary doGetScSpecialInfoByUid(String uid) throws Exception;
    
	/**
	 * 描述: 获取专项库树数据
	 * @param isPermissionCheck 
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectToTreeMap(String isPermissionCheck) throws Exception;
    
	/**
	 * 描述: 导入专项库名单
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return Map<String, String>
	 * @param InputStream,sysUser
	 * @throws Exception
	 */
	public Map<String, Object> doSaveSpLibraryInfoExcelBatch(InputStream in,SysUserDto sysUser) throws Exception;
	
	/**
	 * 描述: 专项库数据保存
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return boolean
	 * @param priPID,SpecialCode,ScpType
	 * @throws Exception
	 */
	public boolean doSaveMarkToSpecialLibrary(String priPID,List<String> SpecialCode,String ScpType) throws Exception;
	
	/**
	 * 描述: 专项库数据保存
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return boolean
	 * @param priPID,SpecialCode,ScpType
	 * @throws Exception
	 */
	public boolean doNewSaveMarkToSpecialLibrary(String priPID,List<RegistMark> registMarks,String ScpType,SysUserDto sysUser) throws Exception;
	
	/**
     * 通过priPID查询抽查专项库信息（来源不为2，且要有效）
     * @param priPID，scpType
     * @return List<pubScSpecialLibrary>
     */
	public List<pubScSpecialLibrary> getSpLibraryInfoByPriPID(String priPID) throws Exception;
    
	/**
	 * 描述: 获取监管标签树（查询条件）
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return boolean
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectToMarkTreeMap() throws Exception;

	/**
	 * 描述: 统计专项检查对象主体库
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    public List<pubScSpecialLibraryDto> selectScSpecialLibraryCount(PageRequest request) throws Exception;

    /**
     * 描述: 查询一家企业涉及的所有检查事项
	 * @auther chenxin
	 * @date 2017年4月19日
     * @param priPID
     * @return
     */
	public List<String> selectCheckCodeList(String priPID);
    
    /**
	 * 描述: 初始化个数统计
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param parmMap
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> doGetScSpecialInitTotal(Map<String, Object> parmMap) throws Exception;
	
	/**
	 * 描述: 初始化个数统计(录入)
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param parmMap
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> doGetScSpecialOptInitTotal(Map<String, Object> parmMap) throws Exception;

	/**
	 * 描述: 查询企业的所有专项库
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param parmMap
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectPubScSpecialLibrary(Map<String,Object> params);

	/**
	 * 描述:统计
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectCountBySpecial(Map<String, Object> params) throws Exception;
	
	
	/**
	 * 描述:查询
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectListBySpecial(Map<String, Object> params) throws Exception;
	
	/**
	 * 描述:查询某家企业
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	public pubScSpecialLibraryDto selectPubScSpeForRandom(Map<String, Object> params) throws Exception;
	
	/**
	 * 描述:查询列表企业
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> selectPubScSpeListForRandom(Map<String, Object> params) throws Exception;
}