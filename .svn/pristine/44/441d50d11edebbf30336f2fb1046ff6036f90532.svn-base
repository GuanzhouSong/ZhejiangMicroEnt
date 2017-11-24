/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentAgentBackDto;
import com.icinfo.cs.sccheck.model.PubScentAgentBack;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent_agent_back 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月20日
 */
public interface IPubScentAgentBackService extends BaseService {
	
	/**
	 * 
	 * 描述:  查询当前部门任务下待抽取人员库列表 
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @return
	 */
	public List<PubScentAgentBackDto> selectPubScentAgentBackList(PageRequest request)  throws Exception ;
	
	/**
	 * 
	 * 描述:  查询当前部门任务下待抽取人员库列表 
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @return
	 */
	public List<PubScentAgentBackDto> selectPubScentAgentBackList(String deptTaskUid)  throws Exception ;
	
	/**
	 * 
	 * 描述: 查询当前任务部门下待抽取人员库总数
	 * @auther gaojinling
	 * @date 2017年5月26日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectPubScentAgentBackDtoCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述:抽检人员批量导入待选库
	 * @auther gaojinling
	 * @date 2017年5月21日 
	 * @param deptTaskUid
	 * @param uidList
	 * @return
	 * @throws Exception
	 */
    public boolean addScentAgentBackList(String deptTaskUid, List<String> uidList)throws Exception;
    
    /**
     *  
     * 描述: 根据部门任务编号删除待选库检查人员（即清空当前部门任务下的待选检察人员）
     * @auther gaojinling
     * @date 2017年5月21日 
     * @param deptTaskUid
     * @return
     * @throws Exception
     */
    public int deleteByDeptTaskUid(String deptTaskUid) throws Exception;   
    
    
    /**
     * 
     * 描述:批量删除（根绝任务id和部门人员id）
     * @return 
     * @auther gaojinling
     * @date 2017年5月21日 
     * @return
     * @throws Exception
     */
    public void deleteByDeptTaskUidAndAgentId(String deptTaskUid,String uidList)throws Exception;

    /**
     * 描述:根据任务id查找待抽检执法人员
     * @author chenxin
     * @date 2017-05-22
     * @param deptTaskUid
     * @return
     */
	public List<PubScentAgentBack> selectlistByDeptTaskUid(String deptTaskUid);

	/**
	 * 描述：查询待抽检库执法人员数量
	 * @author chenxin
	 * @date 2017-08-25
	 * @param deptTaskUid
	 * @return
	 */
	public int doSelectCountByDeptTaskUid(String deptTaskUid);
}