/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月25日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubDeptSctaskDto;
import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_dept_sctask 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface PubDeptSctaskMapper extends Mapper<PubDeptSctask> {
	/**
	 * 描述：根据taskNO查询部门信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectPubDeptSctaskByTaskNO(Map<String,Object> map);
	
	/**
	 * 描述：根据taskNO查询首次打开部门信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectNewPubDeptSctaskByTaskNO(Map<String,Object> map);
	
	/**
	 * 描述：判断是否已填写所有实施结果
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
	public int countPubDeptSctaskByTaskNO(Map<String,Object> map);
	
	/**
	 * 描述：根据任务id查询本次抽查检查--科目类型
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectPubDeptSctypesList(Map<String,Object> map)throws Exception;
    
	
	/**
	 * 描述：根据任务id查询本次抽查检查--科目类型
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectPubDeptSctypesListByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 
	 * 描述: 根据任务单号判断是否所有实施部门已经完成结果审核
	 * @auther chenxin
	 * @date 2016-11-15
	 * @param map
	 * @return boolean
	 */
	public int selectCountDeptSctaskAllFinished(Map<String,Object> map)throws Exception;
}