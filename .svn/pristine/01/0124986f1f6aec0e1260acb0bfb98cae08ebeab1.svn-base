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

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.drcheck.dto.PubScinfoDto;
import com.icinfo.cs.drcheck.mapper.PubScinfoMapper;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.drcheck.model.PubScinfoHis;
import com.icinfo.cs.drcheck.service.IPubDeptSctaskService;
import com.icinfo.cs.drcheck.service.IPubScdisposeService;
import com.icinfo.cs.drcheck.service.IPubScinfoService;
import com.icinfo.cs.drcheck.service.IPubScitemResultService;
import com.icinfo.cs.drcheck.service.IPubScresultOpinionHisService;
import com.icinfo.cs.drcheck.service.IPubScresultService;
import com.icinfo.cs.drcheck.service.IPubSctaskService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class PubScinfoServiceImpl extends MyBatisServiceSupport implements IPubScinfoService {

    @Autowired
    private PubScinfoMapper pubScinfoMapper;
   //实施部门任务表
    @Autowired
    private IPubDeptSctaskService pubDeptSctaskService;
    //抽查检查结果
    @Autowired
    private IPubScresultService pubScresultService;
    //抽查检查后续处理信息
    @Autowired
    private IPubScdisposeService pubScdisposeService;
    //检查项结果
    @Autowired
    private IPubScitemResultService pubScitemResultService;
    //主任务
    @Autowired
    private IPubSctaskService pubSctaskService ;
    
    @Autowired
    private IPubScresultOpinionHisService pubScresultOpinionHisService;
    
    @Autowired
    private IPanoramaSearchService panoramaSearchService;

	@Autowired
	private ICsQuartzJobService csQuartzJobService;
    
    /**
     * 描述：查抽检查结果录入列表(工商端)
     * @author chenxin
     * @date 2016-10-26
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<PubScinfoDto> queryPubScinfoDtoPage(PageRequest request) {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
    	Map<String, Object> map = request.getParams();
		if(map!=null){
			if(StringUtils.isNotEmpty(map.get("leaderDept").toString()) ){
				String leaderDept = map.get("leaderDept").toString();//组织部门
				if(leaderDept.split(",").length >= 1){
					map.put("leaderDepts",leaderDept.split(","));
					map.remove("leaderDept");
				}
			}
			if(StringUtils.isNotEmpty(map.get("regOrg").toString()) ){
				String regOrg = map.get("regOrg").toString();//登记机关
				if(regOrg.split(",").length >= 1){
					map.put("regOrgs",regOrg.split(","));
					map.remove("regOrg");
				}
			}
			if(StringUtils.isNotEmpty(map.get("localAdm").toString()) ){
				String localAdm = map.get("localAdm").toString();//管辖单位
				if(localAdm.split(",").length >= 1){
					map.put("localAdms",localAdm.split(","));
					map.remove("localAdm");
				}
			}
		}
        return pubScinfoMapper.selectPubScinfoDtoList(request.getParams());
    }
    
    /**
     * 描述：查抽检查结果录入列表(工商端)有权限
     * @author chenxin
     * @date 2016-10-26
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<PubScinfoDto> queryPubScinfoDtoPageByAuth(PageRequest request) {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
    	Map<String, Object> map = request.getParams();
    	if(map!=null){
    		if(StringUtils.isNotEmpty(map.get("leaderDept").toString()) ){
    			String leaderDept = map.get("leaderDept").toString();//组织部门
    			if(leaderDept.split(",").length >= 1){
    				map.put("leaderDepts",leaderDept.split(","));
    				map.remove("leaderDept");
    			}
    		}
    		if(StringUtils.isNotEmpty(map.get("regOrg").toString()) ){
    			String regOrg = map.get("regOrg").toString();//登记机关
    			if(regOrg.split(",").length >= 1){
    				map.put("regOrgs",regOrg.split(","));
    				map.remove("regOrg");
    			}
    		}
    		if(StringUtils.isNotEmpty(map.get("localAdm").toString()) ){
    			String localAdm = map.get("localAdm").toString();//管辖单位
    			if(localAdm.split(",").length >= 1){
    				map.put("localAdms",localAdm.split(","));
    				map.remove("localAdm");
    			}
    		}
    	}
    	return pubScinfoMapper.selectPubScinfoDtoListByauth(request.getParams());
    }

    /**
	 * 描述：根据任务编号查询企业信息列表(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
    @Override
    public PubScinfo selectPubScinfoByTaskNO(String taskNO,String priPID) {
    	PubScinfo pubScinfo = new PubScinfo();
    	pubScinfo.setTaskNO(taskNO);
    	pubScinfo.setPriPID(priPID);
    	return  pubScinfoMapper.selectOne(pubScinfo);
    }
    
    /**
	 * 描述：根据任务编号查询企业信息(工商端)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @Override
    public PubScinfoDto selectPubScinfoDtoByTaskNO(String taskNO,String priPID) {
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("taskNO", taskNO);
    	params.put("priPID", priPID);
    	return pubScinfoMapper.selectPubScinfoDtoByTaskNO(params);
    }
    
    /**
	 * 描述:提交审核抽查检查结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScinfoDto
	 * @return
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public boolean commitPubScinfoDto(PubScinfoDto pubScinfoDto)throws Exception {
    	if(pubScinfoDto == null){
    		return false;
    	}

    	return pubScitemResultService.savePubScitemResultList(pubScinfoDto.getPubScitemResultList(),pubScinfoDto.getSysUserDto()) &&
		    	pubScdisposeService.savePubScdispose(pubScinfoDto.getPubScdispose()) &&
		    	pubScresultService.savePubScresult(pubScinfoDto.getPubScresult(),pubScinfoDto.getSysUserDto())
		    	&& pubDeptSctaskService.updateInspectState(pubScinfoDto.getTaskNO(), pubScinfoDto.getPubScresult().getTaskNO(), pubScinfoDto.getPubDeptSctask().getInspectDate());
    }
    
    /**
	 * 描述:审核抽查检查结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScinfoDto
	 * @return
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public boolean auditPubScinfoDto(PubScinfoDto pubScinfoDto) throws Exception {
    	if(pubScinfoDto == null){
    		return false;
    	}
    	boolean flag =  pubScitemResultService.savePubScitemResultList(pubScinfoDto.getPubScitemResultList(),pubScinfoDto.getSysUserDto()) &&
		    	pubScdisposeService.savePubScdispose(pubScinfoDto.getPubScdispose()) &&
		    	pubScresultService.auditPubScresult(pubScinfoDto.getPubScresult(),pubScinfoDto.getSysUserDto()) 
		    	&& pubDeptSctaskService.updateInspectState(pubScinfoDto.getTaskNO(), pubScinfoDto.getPubScresult().getTaskNO(), pubScinfoDto.getPubDeptSctask().getInspectDate())
		        && pubScresultOpinionHisService.savePubScresultOpinion(pubScinfoDto.getPubScresult(),pubScinfoDto.getTaskNO(),pubScinfoDto.getSysUserDto());
    	if(flag){
    		boolean finishFlag = pubDeptSctaskService.checkDeptSctaskAllFinished(pubScinfoDto.getTaskNO());
    		//更新主任务状态
    		if(finishFlag){
    			return pubSctaskService.setSctaskOver(pubScinfoDto.getTaskNO());
    		}
    	}
    	return flag;
    }
    
    /**
	 * 描述：保存历史记录
	 * @author chenxin
	 * @date 2016-11-02
	 * @param pubScinfoHisList
	 * @throws Exception
	 */
    @Override
    public void savePubScinfoList(List<PubScinfo> pubScinfoList)throws Exception {
    	if(pubScinfoList != null && pubScinfoList.size() > 0){
    		for(PubScinfo pubScinfo :pubScinfoList){
    			pubScinfoMapper.insertSelective(pubScinfo);
    		}
    	}
    }
    
    /**
	 * 描述：批量插入记录
	 * @author chenxin
	 * @date 2016-11-02
	 * @param pubScinfoList
	 * @throws Exception
	 */
    @Override
    public void insertBatch(List<PubScinfo> list) throws Exception {
    	if(list != null && list.size() >= 0){
    		for(PubScinfo PubScinfo : list){
    			pubScinfoMapper.insert(PubScinfo);
    		}
    	}
    }
    
    /**
	 * 描述：插入记录
	 * @author chenxin
	 * @date 2016-11-21
	 * @param pubScinfo
	 * @throws Exception
	 */
    @Override
    public int insertPubScinfo(PubScinfo pubScinfo) throws Exception {
		return pubScinfoMapper.insert(pubScinfo);
    }
    
    /**
	 * 描述：通过主任务表taskNO清楚cs_pub_scinfo表
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public void cleanPubScinfoByTaskNO(String taskNO) throws Exception {
    	Example example=new Example(PubScinfo.class);
        example.createCriteria().andEqualTo("taskNO",taskNO);
        pubScinfoMapper.deleteByExample(example);
    }
    
    /**
	 * 描述：通过主任务表taskNO清楚cs_pub_scinfo表
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public List<PubScinfo> selectPubScinfoByOrderList(String taskNO,List<String> list) {
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("taskNO", taskNO);
    	params.put("list", list);
    	return pubScinfoMapper.selectPubScinfoByOrderList(params);
    }
    
    /**
	 * 描述：查询企业是否存在
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
    @Override
    public int selectPubScinfoByTaskNOAndPriPID(String taskNO, String priPID)throws Exception {
    	Example example = new Example(PubScinfo.class);
    	example.createCriteria().andEqualTo("taskNO",taskNO).andEqualTo("priPID",priPID);
    	return pubScinfoMapper.selectCountByExample(example);
    }
    
    /**
     * 描述：抽检选中列表
     * @author chenxin
     * @date 2016-10-26
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<PubScinfoDto> queryRandomPubScinfoList(PageRequest request) {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScinfoMapper.selectPubScinfoByTaskNO(request.getParams());
    }
    
    /**
	 * 描述：获取随机选中的企业数量
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
    @Override
    public int selectCountByTaskNO(String taskNO) throws Exception {
    	PubScinfo pubScinfo = new PubScinfo();
    	pubScinfo.setTaskNO(taskNO);
    	return pubScinfoMapper.selectCount(pubScinfo);
    }
    
    /**
	 * 描述： 根据随机数查询企业
	 * @author chenxin
	 * @date 2016-11-21
	 * @param PubScinfo
	 * @return
	 * @throws Exception
	 */
    @Override
    public PubScinfo selectPubScinfoForInsert(Map<String, Object> params)throws Exception {
    	return pubScinfoMapper.selectPubScinfoForInsert(params);
    }
    
    /**
   	 * 描述：根据任务UID查询抽取的企业
     * @author chenxin
     * @date 2016-11-23 
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
   @Override
   public List<PubScinfo> selectPubscinfoByTaskNO(String taskNO)throws Exception {
   	Example example=new Example(PubScinfoHis.class);
       example.createCriteria().andEqualTo("taskNO",taskNO);
   	return pubScinfoMapper.selectByExample(example);
   }
   
   /**
	 * 描述： 定时更新es索引文件
	 * @author chenxin
	 * @date 2016-11-28
	 * @param creatTime
	 * @return
	 * @throws Exception
	 */
   @Override
	public List<PubScinfo> selectPubScinfoForUpdateEs(String creatTime)throws Exception {
	   Map<String,Object> params = new HashMap<String,Object>();
   		params.put("creatTime", creatTime);
		return pubScinfoMapper.selectPubScinfoForUpdateEs(params);
	}
   
   /**
	 * 描述： 定时更新es索引文件
	 * @author chenxin
	 * @date 2016-11-28
	 * @return
	 * @throws Exception
	 */
   @Override
	public void updateEsByPubscTask() throws Exception {
	   //阻塞任务，防止并发访问数据库
	   SleepUtil.threadSleep();
	   if(csQuartzJobService.checkJobIsExecute(QuartzJobName.SCINFO_JOB.getJobName())){
		   return ;
	   }
	   csQuartzJobService.insert(QuartzJobName.SCINFO_JOB.getJobName());
		
	   String creatTime = DateUtil.getCurrentDate();
	   List<PubScinfo> pubScinfoList = this.selectPubScinfoForUpdateEs(creatTime);
	   for(PubScinfo pubScinfo : pubScinfoList){
		   String priPID = pubScinfo.getPriPID();
		   Date taskCreatTime = pubScinfo.getCreateTime();
		   if(taskCreatTime != null){
			   Map<String,Object> jsonMap = new HashMap<String,Object>();
			   jsonMap.put("priPID", priPID);
			   jsonMap.put("spotDate", DateUtil.formatDate(taskCreatTime,"yyyy-MM-dd"));
			   panoramaSearchService.updatePanoramaIdx(jsonMap);
		   }
	   }
	}
   
    /**
	 * 描述：根据任务编号查询管辖单位
	 * @author chenxin
	 * @date 2016-11-28 
	 * @param taskNO
	 * @return
	 */
    @Override
	public List<String> selectLocalAdmList(String taskNO) {
    	 Map<String,Object> params = new HashMap<String,Object>();
    	 params.put("taskNO", taskNO);
		return pubScinfoMapper.selectLocalAdmList(params);
	}
    
    /**
	 * 描述：所所交叉
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<PubScinfoDto> selectPubScinfoForCross(Map<String, Object> params)throws Exception {
    	return pubScinfoMapper.selectPubScinfoForCross(params);
    }
    
    /**
	 * 描述：统计各个地区抽检到的企业数量
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<PubScinfoDto> selectRegOrgShortCount(String taskNO) {
    	Map<String,Object> params = new HashMap<String,Object>();
   	 	params.put("taskNO", taskNO);
    	List<PubScinfoDto> pubScinfoDtoList = pubScinfoMapper.selectRegOrgShortCount(params);
    	
    	if(pubScinfoDtoList != null && pubScinfoDtoList.size() == 1){
    		pubScinfoDtoList = pubScinfoMapper.selectRegOrgCount(params);
    	}
    	return pubScinfoDtoList;
    }
}