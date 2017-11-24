/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.SkipNum;
import com.icinfo.cs.drcheck.dto.PubScinfoDto;
import com.icinfo.cs.drcheck.dto.PubSctaskAgentDto;
import com.icinfo.cs.drcheck.mapper.PubSctaskAgentMapper;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.drcheck.model.PubScinfoAgent;
import com.icinfo.cs.drcheck.model.PubSctaskAgent;
import com.icinfo.cs.drcheck.model.PubSctaskAgentHis;
import com.icinfo.cs.drcheck.service.IPubScinfoAgentService;
import com.icinfo.cs.drcheck.service.IPubScinfoService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentBackService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentHisService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_sctask_agent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubSctaskAgentServiceImpl extends MyBatisServiceSupport implements IPubSctaskAgentService {

    @Autowired
    private PubSctaskAgentMapper pubSctaskAgentMapper;
    
    @Autowired
    private IPubSctaskAgentHisService pubSctaskAgentHisService;
    
    @Autowired
    private IPubSctaskAgentBackService pubSctaskAgentBackService;
    
    @Autowired
    private IPubScinfoService pubScinfoService;
    
    @Autowired
    private IPubScinfoAgentService pubScinfoAgentService;
    
    /**
	 * 描述：分页查询已抽取执法人员列表
	 * @author chenxin
	 * @date 2016-11-07
	 * @param request
	 * @return
	 */
    @Override
    public List<PubSctaskAgentDto> queryPubSctaskAgentDtoPage(PageRequest request) throws Exception {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
    	return pubSctaskAgentMapper.selectPubSctaskAgentDtoList(request.getParams());
    }
    
    /**
	 * 描述：查询执法人员以逗号分开
	 * @author chenxin
	 * @date 2016-11-07
	 * @param request
	 * @return
	 */
    @Override
    public String selectPubSctaskAgentDtoListToStr(String taskNO)throws Exception {
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("taskNO", taskNO);
    	List<PubSctaskAgentDto> pubSctaskAgentDtoList =  pubSctaskAgentMapper.selectPubSctaskAgentDtoListToStr(params);
    	if(pubSctaskAgentDtoList != null && pubSctaskAgentDtoList.size() >= 0){
    		String agentNames = "";
    		boolean flag = true;
    		for(PubSctaskAgentDto pubSctaskAgentDto : pubSctaskAgentDtoList){
    			if(flag){
    				agentNames += pubSctaskAgentDto.getAgentName();
    				flag = false;
    			}else{
    				agentNames += ","+pubSctaskAgentDto.getAgentName();
    			}
    		}
    		return agentNames;
    	}
    	return "";
    }
    
    /**
	 * 描述：通过主任务表taskNO清除已选中执法人员
     * @author chenxin
     * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public void cleanPubSctaskAgentByTaskNO(String taskNO) {
    	Example example=new Example(PubSctaskAgent.class);
        example.createCriteria().andEqualTo("taskNO",taskNO);
        pubSctaskAgentMapper.deleteByExample(example);
    }
    
    /**
	 * 描述：随机抽取执法人员
	 * @author chenxin
	 * @date 2016-11-07
	 * @param deptTaskNO
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public boolean randomPubSctaskAgentByTaskNO(String deptTaskNO,String taskNO,int total,int number,String scTypeWay, int groupAgentNumber)throws Exception {
		//1.查询备份表数据排序
		List<PubSctaskAgentHis> pubSctaskAgentHisList = pubSctaskAgentHisService.selectOrderPubSctaskAgentBack(deptTaskNO);
		//2.插入his表
		int num = 1;
		for(PubSctaskAgentHis pubSctaskAgentHis : pubSctaskAgentHisList){
			pubSctaskAgentHis.setAgentOrder(num+"");
			pubSctaskAgentHis.setCreateTime(new Date());
			num++;
		}
		pubSctaskAgentHisService.deleteByTaskNO(deptTaskNO);
		pubSctaskAgentHisService.insertBatch(pubSctaskAgentHisList);
		//3.获取随机数
		List<String> list =SkipNum.getRandomNumber(total, number);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskNO", deptTaskNO);
		params.put("list", list);
		List<PubSctaskAgent> pubSctaskAgentLIst = pubSctaskAgentMapper.selectPubSctaskAgentByOrderList(params);
		//4.插入
		this.cleanPubSctaskAgentByTaskNO(deptTaskNO);
		if(pubSctaskAgentLIst != null && pubSctaskAgentLIst.size() >= 0){
			for(PubSctaskAgent pubSctaskAgent : pubSctaskAgentLIst){
				pubSctaskAgentMapper.insert(pubSctaskAgent);
			}
		}
		//5.删除备份表
		//pubSctaskAgentBackService.delSctaskAgentBackByTaskNO(deptTaskNO);
		return assignEntToAgent(taskNO, deptTaskNO,scTypeWay,groupAgentNumber);
    }
    
    /**
	 * 描述：统计抽取执法人员
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public int countPubSctaskAgentByTaskNO(String taskNO) throws Exception {
    	PubSctaskAgent pubSctaskAgent = new PubSctaskAgent();
    	pubSctaskAgent.setTaskNO(taskNO);
    	return pubSctaskAgentMapper.selectCount(pubSctaskAgent);
    }
    
    /**
	 * 描述：将随机抽取的本次任务中的企业均匀分配给执法人员
	 * @author chenxin
	 * @date 2016-11-23
	 * @param taskNO
	 * @param deptTaskNO
	 * @param scTypeWay
	 * @throws Exception
	 */
    @Override
    public boolean assignEntToAgent(String taskNO, String deptTaskNO,String scTypeWay,int groupAgentNumber)throws Exception {
    	if("4".equals(scTypeWay)){
    		//所所交叉
    		return allPubinfoCross(taskNO, deptTaskNO,groupAgentNumber);
    	}else{
    		//其他均匀分配
    		evenDistribute(taskNO, deptTaskNO,groupAgentNumber);
    	}
    	return true;
    }
    
    /**
     * 描述：均匀分配
     * @author chenxin
     * @date 2016-11-28
     * @param taskNO
     * @param deptTaskNO
     */
    private void evenDistribute(String taskNO, String deptTaskNO,int groupAgentNumber)throws Exception{
    	Example example = new Example(PubSctaskAgent.class);
    	example.createCriteria().andEqualTo("taskNO",deptTaskNO);
    	List<PubSctaskAgent> pubSctaskAgentList = pubSctaskAgentMapper.selectByExample(example);//查询实施部门抽取的执法人员
    	List<PubScinfo> pubScinfoList = pubScinfoService.selectPubscinfoByTaskNO(taskNO);//企业信息
    	int num = 0;
    	pubScinfoAgentService.cleanPubScinfoAgent(deptTaskNO, taskNO);
    	for(PubScinfo pubScinfo : pubScinfoList){
    		num = assignInfoToAgentEvent(pubScinfo, num, pubSctaskAgentList, deptTaskNO, groupAgentNumber);
    	}
    }
    
	/**
     * 描述：均匀分配
     * @author chenxin
     * @date 2016-11-28
     * @param taskNO
     * @param deptTaskNO
     */
    private boolean allPubinfoCross(String taskNO, String deptTaskNO,int groupAgentNumber)throws Exception{
    	//1.判断是否可以进行所所交叉。一旦不行则均匀分配
    	Example example = new Example(PubSctaskAgent.class);
		example.createCriteria().andEqualTo("taskNO",deptTaskNO);
		Map<String,Object> agentparams = new HashMap<String,Object>();
		agentparams.put("taskNO", deptTaskNO);
		List<PubSctaskAgentDto> pubSctaskAgentList = pubSctaskAgentMapper.selectPubSctaskAgentDtoList(agentparams);//查询实施部门抽取的执法人员
		//2.先查询有多少个管辖单位
		List<String> localAdmList = pubScinfoService.selectLocalAdmList(taskNO);
		if(localAdmList != null && localAdmList.size() >= 2){
			//3.根据管辖单位查询企业列表
			int num = 0;
			pubScinfoAgentService.cleanPubScinfoAgent(deptTaskNO, taskNO);
			for(String localAdmParam : localAdmList){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("localAdm", localAdmParam);
				params.put("taskNO", taskNO);
				List<PubScinfoDto> pubScinfoList = pubScinfoService.selectPubScinfoForCross(params);
				//1.遍历企业列表，排除掉所属的执法人员----注意：难点  需要连续执法人员分配(相同的管辖单位不得分配)
				for(PubScinfoDto pubScinfo : pubScinfoList){
					num = assignInfoToAgent(pubScinfo,num,pubSctaskAgentList,deptTaskNO,groupAgentNumber);
					if(num == -1){
						return false;
					}
				}
			}
		}
		return true;
    }
    
    /**
     * 描述：指定执法人员
     * @author chenxin
     * @date 2016-11-28
     * @param pubScinfo
     * @param num
     * @param pubSctaskAgentList
     * @return
     */
	private int assignInfoToAgentEvent(PubScinfo pubScinfo, int num,List<PubSctaskAgent> pubSctaskAgentList,String deptTaskNO,int groupAgentNumber)throws Exception {
		int total = pubSctaskAgentList.size();//执法人员总量
		int start = num;
		boolean flag = true;
		//计数器（用于一家企业匹配最小分组人数）
		int count = 0;
		//计数器（用于计算是否已走完整个执法人员）
		int agentEntNum = 0;
		while(flag){
			if(start == total){
				start = 0;
			}
    		String priPID = pubScinfo.getPriPID();
    		PubScinfoAgent pubScinfoAgent = new PubScinfoAgent();
    		pubScinfoAgent.setTaskNO(pubScinfo.getTaskNO());
    		pubScinfoAgent.setDeptTaskNO(deptTaskNO);
    		pubScinfoAgent.setPriPID(priPID);
    		pubScinfoAgent.setAgentUid(pubSctaskAgentList.get(start).getAgentId());
    		pubScinfoAgentService.savePubScinfoAgent(pubScinfoAgent);
    		if(count < groupAgentNumber-1){
    			count++;
    		}else{
    			flag = false;
    		}
    		num = start+1;
    		if(num > total){
    			num = 0;
    		}
			start++;
			agentEntNum++;
			//遍历完一遍执法人员，没有找到相对应的执法人员
			if(agentEntNum > total){
				flag = false;
				num = -1;
			}
		}
		return num;
	}

    /**
     * 描述：指定执法人员
     * @author chenxin
     * @date 2016-11-28
     * @param pubScinfo
     * @param num
     * @param pubSctaskAgentList
     * @return
     */
	private int assignInfoToAgent(PubScinfoDto pubScinfo, int num,List<PubSctaskAgentDto> pubSctaskAgentList,String deptTaskNO,int groupAgentNumber)throws Exception {
		int total = pubSctaskAgentList.size();//执法人员总量
		int start = num;
		if(pubScinfo != null && StringUtils.isNotEmpty(pubScinfo.getLocalAdm())){
			String infoLocalAdm = pubScinfo.getLocalAdm();
			boolean flag = true;
			//计数器（用于一家企业匹配最小分组人数）
			int count = 0;
			//计数器（用于计算是否已走完整个执法人员）
			int agentEntNum = 0;
			while(flag){
				if(start == total){
					start = 0;
				}
				String slicenNO = pubSctaskAgentList.get(start).getSlicenNO();
				if(!slicenNO.equals(infoLocalAdm)){
		    		String priPID = pubScinfo.getPriPID();
		    		PubScinfoAgent pubScinfoAgent = new PubScinfoAgent();
		    		pubScinfoAgent.setTaskNO(pubScinfo.getTaskNO());
		    		pubScinfoAgent.setDeptTaskNO(deptTaskNO);
		    		pubScinfoAgent.setPriPID(priPID);
		    		pubScinfoAgent.setAgentUid(pubSctaskAgentList.get(start).getAgentId());
		    		pubScinfoAgentService.savePubScinfoAgent(pubScinfoAgent);
		    		if(count < groupAgentNumber-1){
		    			count++;
		    		}else{
		    			flag = false;
		    		}
		    		num = start+1;
		    		if(num > total){
		    			num = 0;
		    		}
				}
				start++;
				agentEntNum++;
				//遍历完一遍执法人员，没有找到相对应的执法人员
				if(agentEntNum > total){
					flag = false;
					num = -1;
				}
			}
		}
		return num;
	}
}