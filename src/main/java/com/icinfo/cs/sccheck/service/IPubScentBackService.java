/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.cs.sccheck.dto.DrandomSpecialEntDto;
import com.icinfo.cs.sccheck.dto.PubScentBackDto;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent_back 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubScentBackService extends BaseService {
	
	/**
     * 描述：分页查询待抽检库列表
     * @author chenxin
     * @date 2017-05-17
     * @param request
     * @return List<PubScentBackDto>
     * @throws Exception
     */
	public List<PubScentBackDto> queryPubScentBackDtoPage(PageRequest request);
	
	/**
	 * 描述：通过主任务表taskUid清除本次任务的所有待抽检库
     * @author chenxin
     * @date 2017-05-17
	 * @param taskUid
	 * @throws Exception
	 */
	public boolean doCleanPubScentBack(String taskUid,SysUserDto sysUser)throws Exception;
	
	/**
	 * 描述：随机抽取企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param randomType
	 * @throws Exception
	 */
	public boolean doRandomEntBack(SysUserDto sysUser,String taskUid,String randomType,Map<String,Object> params)throws Exception;
	
	/**
	 * 描述：通过主待抽检库表entBackUidList清除本次任务的所有待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param entBackUidList
	 * @throws Exception
	 */
	public boolean doCleanPubScentBack(List<String> entBackUidList,String taskUid,SysUserDto sysUser)throws Exception;
	
	/**
	 * 描述：批量保存待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param pubScentBackDto
	 * @throws Exception
	 */
	public boolean doAddBatch(PubScentBackDto pubScentBackDto,SysUserDto sysUser)throws Exception;
	
	/**
	 * 描述：导入专项检查对象库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param map
	 * @throws Exception
	 */
	public boolean doAddSpecial(Map<String,Object> params)throws Exception;
	
	/**
	 * 描述：统计专项检查对象库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param map
	 * @throws Exception
	 */
	public int doCountSpecial(Map<String,Object> params)throws Exception;
	
	/**
	 * 描述：excel批量导入待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	public JSONObject doAddExcelBatch(InputStream in,String taskUid,SysUserDto sysUser)throws Exception;
	
	/**
	 * 描述：excel批量导入待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	public JSONObject doAddExcelBatchBack(InputStream in,String taskUid,String deptTaskUid)throws Exception;
	
	/**
	 * 描述：统计本次抽查任务专项库数量
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	public List<PubScentBackDto> countSpecialTypes(String taskUid)throws Exception;

	/**
	 * 描述：统计本次抽查任务专项库去重数量
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @throws Exception
	 */
	public int selectEntTotal(String taskUid)throws Exception;
	
	/**
	 * 判断某个专项库是否已经存在记录.
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param priPID
	 * @param specialCode
	 * @return
	 */
	public boolean checkExist(String taskUid,String priPID,String specialCode);
	
	/**
	 * 批量导入待抽检库：判断企业是否已经存在.
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param priPID
	 * @return
	 */
	public boolean checkExist(String taskUid,String priPID);

	/**
	 * 描述：查询抽取的企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @return
	 */
	public List<PubScentBack> seletPubScentBackList(String taskUid);

	/**
	 * 描述：跨部门导入待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-10-31
	 * @param drandomSpecialEntDtoList
	 * @param taskUid
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	public boolean saveSpecialEnts(List<DrandomSpecialEntDto> drandomSpecialEntDtoList,String taskUid,SysUserDto sysUserDto)throws Exception;
}