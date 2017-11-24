/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.cs.sccheck.model.PubScentSpecial;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubScentService extends BaseService {
	
	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScent> selectPubSentByDeptTaskUId(String deptTaskUid) throws Exception;
	
	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> selectPubSentDtoListBytaskUId(String taskUid) throws Exception;
	
	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> selectBytaskUIdAndRegOrg(String regOrg,String taskUid) throws Exception;
	

	/**
	 * 
	 * 描述: 通过查询已抽取的企业进行滚动
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScent> selectPubSentListBytaskUId(String taskUid) throws Exception;
	
	/**
	 * 
	 * 描述: 通过部门任务id分页查询已抽取的企业
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @return
	 */
	public List<PubScentDto> selectPubScentDtoList(PageRequest request)  throws Exception ;
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	public void savePubScent(PubScentBack pubScentBack)  throws Exception ;
	
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	public void savePubScent(PubScent pubScent,PubScentBack pubScentBack)  throws Exception ;
	
	/**
	 * 
	 * 描述: 删除抽检结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	public void delPubScent(String taskUid)  throws Exception ;

	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param string
	 */
	public void updatePubScent(String taskUid, String deptTaskUid, String specialCode);
	
	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param specialCode
	 * @param regOrg
	 * 
	 */
	public void updatePubScent(String taskUid, String deptTaskUid, String specialCode,String regOrg);
	
	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param specialCode
	 * @param checkDeptCode
	 * 
	 */
	public void updatePubScentByCheckDeptCode(String taskUid, String deptTaskUid, String specialCode,String checkDeptCode);
	
	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param relateUserUid
	 * @param specialCodes
	 * @param string
	 */
	public void updatePubScentByRelateUid(String taskUid, String deptTaskUid, String relateUserUid);

	/**
	 * 描述: 查询抽检结果中的某个专项库的登记机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<String> selectRegOrgsInSpecial(String taskUid,String specialCode)throws Exception;
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<String> selectEntTypeCatg(String taskUid)throws Exception;
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的登记机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<PubScentDto> selectRegOrgNumInSpecial(String taskUid,String specialCode)throws Exception;
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的抽查机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<PubScentDto> selectCheckNumInSpecial(String taskUid,String specialCode)throws Exception;
	/**
	 * 描述: 查询抽检结果中的某个专项库的监管用户
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	public List<PubScentDto> selectUidsNotInSpecial(String taskUid,String[] specialCodes)throws Exception;

	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	public void savePubScent(PubScentSpecial pubScentSpecial);
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	public void savePubScent(PubScent pubScent,pubScSpecialLibraryDto pubScSpecialLibraryDto,String taskUid);

	/**
	 * 描述：只用来处理人工分配抽查任务
	 * @param taskUid
	 * @param entName
	 * @return
	 */
	public PubScent selectEntByEntNameTaskUid(String taskUid, String entName);
	
	/**
	 * 描述：只用来处理人工分配抽查任务
	 * @param taskUid
	 * @param priPID
	 * @return
	 */
	public PubScent selectEntByPriPIDTaskUid(String taskUid, String priPID);

	/**
	 * 描述：任务指派列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> queryPageResult(PageRequest request,SysUserDto sysUserDto)throws Exception;
	
	/**
	 * 描述：抽取企业列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScentDto> queryEntPage(PageRequest request)throws Exception;

	/**
	 * 描述：任务指派
	 *
	 * @author chenxin
	 * @date 2017年7月4日 
	 * @param pubScentDto
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	public boolean doAppointEnts(String uids,String appointLocalAdm,SysUserDto sysUserDto)throws Exception;
	
	/**
	 * 描述：任务指派
	 *
	 * @author chenxin
	 * @date 2017年7月4日 
	 * @param pubScentDto
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	public boolean doAppointEnt(String uid,String appointLocalAdm,SysUserDto sysUserDto)throws Exception;
	
	/**
	 * 描述：根据uid查询企业信息
	 *
	 * @author chenxin
	 * @date 2017年7月4日  
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public PubScent selectPubScentByUid(String uid)throws Exception;

	/**
	 * 描述：统计一次任务所有企业所属的状态
	 * @author chenxin
	 * @date 22017-07-22
	 * @param taskUid
	 * @return
	 */
	public PubScentDto selectEntCountByTaskUid(String taskUid);
    
	/**
	 * 描述：通过任务UID查询个数
	 * @author yujingwei
	 * @date 2017-07-22
	 * @param taskUid
	 * @return Integer
	 * @throws Exception 
	 */
	public Integer selectPubScentTotalForBulletin(PageRequest request) throws Exception;
	
	/**
	 * 描述：通过任务UID查询个数
	 * @author yujingwei
	 * @date 2017-07-22
	 * @param taskUid
	 * @return Integer
	 * @throws Exception 
	 */
	public Integer selectPubScentAllTotal(Map<String,Object> params) throws Exception;
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年8月25日
	 * @param deptTaskUid
	 * @return
	 */
	public List<PubScentDto> selectPubScentAllList(String deptTaskUid)throws Exception;
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年8月25日
	 * @param deptTaskUid
	 * @return
	 */
	public List<PubScentDto> selectPubScentPageList(String deptTaskUid)throws Exception;
}