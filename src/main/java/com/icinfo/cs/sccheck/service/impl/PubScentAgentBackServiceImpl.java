/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentAgentBackDto;
import com.icinfo.cs.sccheck.mapper.PubScentAgentBackMapper;
import com.icinfo.cs.sccheck.model.PubScentAgentBack;
import com.icinfo.cs.sccheck.service.IPubScentAgentBackService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent_agent_back 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月20日
 */
@Service
public class PubScentAgentBackServiceImpl extends MyBatisServiceSupport implements IPubScentAgentBackService {
	@Autowired 
	private PubScentAgentBackMapper pubScentAgentBackMapper;
	
	/**
	 * 
	 * 描述: 查询当前部门任务下待抽取人员库列表 
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @return
	 */
	public List<PubScentAgentBackDto> selectPubScentAgentBackList(PageRequest request)  throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentAgentBackMapper.selectPubScentAgentBackDtoList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 查询当前任务部门下待抽取人员库总数
	 * @auther gaojinling
	 * @date 2017年5月26日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectPubScentAgentBackDtoCount(Map<String, Object> map) throws Exception{
		return pubScentAgentBackMapper.selectPubScentAgentBackDtoCount(map);
	}
	
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
    public boolean addScentAgentBackList(String deptTaskUid, List<String> uidList)throws Exception{
    	if(StringUtils.isNotEmpty(deptTaskUid) && uidList != null && uidList.size() > 0){
    		for(String agentId : uidList){
    			//查询是否存在
    			PubScentAgentBack pubScentAgentBack = new PubScentAgentBack();
    			pubScentAgentBack.setAgentUid(agentId);
    			pubScentAgentBack.setDeptTaskUid(deptTaskUid);
    			if(pubScentAgentBackMapper.selectCount(pubScentAgentBack) > 0){
    				continue;
    			}else{
//    				pubScentAgentBack.set(new Date());
    				pubScentAgentBackMapper.insert(pubScentAgentBack);
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
   /**
    *  
    * 描述: 根据部门任务编号删除待选库检查人员（即清空当前部门任务下的待选检察人员）
    * @auther gaojinling
    * @date 2017年5月21日 
    * @param deptTaskUid
    * @return
    * @throws Exception
    */
   public int deleteByDeptTaskUid(String deptTaskUid) throws Exception{
	   if(StringUtil.isNotBlank(deptTaskUid)){
		   Example example = new Example(PubScentAgentBack.class);
		   example.createCriteria().andEqualTo("deptTaskUid", deptTaskUid);
		   return pubScentAgentBackMapper.deleteByExample(example); 
	   }else{
		   return 0;
	   }

   }
   
   
   /**
    * 
    * 描述:批量删除（根绝任务id和部门人员id）
    * @return 
    * @auther gaojinling
    * @date 2017年5月21日 
    * @return
    * @throws Exception
    */
   public void deleteByDeptTaskUidAndAgentId(String deptTaskUid,String uidList)throws Exception{
	   if(StringUtil.isNotBlank(deptTaskUid)&&StringUtil.isNotBlank(uidList)){
		   pubScentAgentBackMapper.deleteInAgentUIdAndDeptTaskUid(deptTaskUid, uidList);
	   }
   }
    
   /**
    * 描述:根据任务id查找待抽检执法人员
    * @author chenxin
    * @date 2017-05-22
    * @param deptTaskUid
    * @return
    */
    @Override
    public List<PubScentAgentBack> selectlistByDeptTaskUid(String deptTaskUid) {
    	Example example = new Example(PubScentAgentBack.class);
		example.createCriteria().andEqualTo("deptTaskUid", deptTaskUid);
    	return pubScentAgentBackMapper.selectByExample(example);
    }
    
    /**
	 * 
	 * 描述:  查询当前部门任务下待抽取人员库列表 
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @return
	 */
    @Override
    public List<PubScentAgentBackDto> selectPubScentAgentBackList(String deptTaskUid) throws Exception {
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("deptTaskUid", deptTaskUid);
    	return pubScentAgentBackMapper.selectPubScentAgentBackDtoList(params);
    }
    
    /**
	 * 描述：查询待抽检库执法人员数量
	 * @author chenxin
	 * @date 2017-08-25
	 * @param deptTaskUid
	 * @return
	 */
    @Override
    public int doSelectCountByDeptTaskUid(String deptTaskUid) {
    	 Example example = new Example(PubScentAgentBack.class);
		 example.createCriteria().andEqualTo("deptTaskUid", deptTaskUid);
    	return pubScentAgentBackMapper.selectCountByExample(example);
    }
}