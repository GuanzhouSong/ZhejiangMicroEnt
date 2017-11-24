/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.SkipNum;
import com.icinfo.cs.drcheck.mapper.PubScinfoHisMapper;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.drcheck.model.PubScinfoBack;
import com.icinfo.cs.drcheck.model.PubScinfoHis;
import com.icinfo.cs.drcheck.service.IPubScinfoBackService;
import com.icinfo.cs.drcheck.service.IPubScinfoHisService;
import com.icinfo.cs.drcheck.service.IPubScinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_pub_scinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubScinfoHisServiceImpl extends MyBatisServiceSupport implements IPubScinfoHisService {
    @Autowired
    private PubScinfoHisMapper pubScinfoHisMapper;
    
    @Autowired
    private IPubScinfoBackService pubScinfoBackService ;
    
    @Autowired
    private IPubScinfoService pubScinfoService;
    
    private static final int PERCENT_MAX = 100;
    /**
	 * 描述：保存历史记录
	 * @author chenxin
	 * @date 2016-11-02
	 * @param pubScinfoHisList
	 * @throws Exception
	 */
    @Override
    public void savePubScinfoHisList(List<PubScinfoHis> pubScinfoHisList)throws Exception {
    	if(pubScinfoHisList != null && pubScinfoHisList.size() > 0){
    		for(PubScinfoHis pubScinfoHis :pubScinfoHisList){
    			pubScinfoHisMapper.insertSelective(pubScinfoHis);
    		}
    	}
    }
    
    /**
	 * 描述:随机抽取企业
	 * @author chenxin
	 * @date 2016-11-04
	 * @param taskNO
	 * @param percent抽取百分比
	 * @param firstNum
	 * @return
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public boolean randomPubscinfo(String taskNO,float percent) throws Exception {
    	if(StringUtils.isEmpty(taskNO) && percent > PERCENT_MAX ){
    		return false;
    	}
    	//1.根据taskNO查询临时表数据
    	List<PubScinfoBack> PubScinfoBackList = pubScinfoBackService.selectPubScinfoBackByTaskNO(taskNO);
    	int count = PubScinfoBackList.size();
    	//2.将备份表back数据排序,先删除后批量插入到历史表cs_pub_scinfo_his
    	this.cleanScinfoHisByTaskNO(taskNO);
    	copyPubScinfoBackList(PubScinfoBackList);
    	//3.随机抽取企业
    	List<PubScinfo> list = randomPubscinfoHis(taskNO,percent,count);
    	//4.先删除后批量插入到抽检（命中）企业表cs_pub_scinfo
    	pubScinfoService.cleanPubScinfoByTaskNO(taskNO);
    	pubScinfoService.insertBatch(list);
    	//5.删除备份表数据
    	pubScinfoBackService.cleanScinfoBackByTaskNO(taskNO);
    	return true;
    }
    
    /**
     * 描述：排序
     * @author chenxin
	 * @date 2016-11-04
     * @param PubScinfoBackList
     * @return
     * @throws Exception
     */
    private void copyPubScinfoBackList(List<PubScinfoBack> PubScinfoBackList)throws Exception{
    	int order = 1;
    	for(PubScinfoBack pubScinfoBack : PubScinfoBackList){
    		PubScinfoHis pubScinfoHis = new PubScinfoHis();
    		pubScinfoHis.setTaskNO(pubScinfoBack.getTaskNO());
    		pubScinfoHis.setPriPID(pubScinfoBack.getPriPID());
    		pubScinfoHis.setInfoOrder(order+"");
    		pubScinfoHis.setCreateTime(new Date());
    		order++;
    		pubScinfoHisMapper.insert(pubScinfoHis);
    	}
    }
    
    /**
     * 描述:随机生成企业（跳号）
     * @author chenxin
	 * @date 2016-11-04
     * @param taskNO
     * @param percent
     * @return
     */
    private List<PubScinfo> randomPubscinfoHis(String taskNO,float percent,int count)throws Exception{
    	List<String> listNum = SkipNum.getAllRandomNumber(count,percent);
        return pubScinfoService.selectPubScinfoByOrderList(taskNO,listNum);
    }
    
    /**
	 * 描述：通过主任务表ID清空历史记录表
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public void cleanScinfoHisByTaskNO(String taskNO) throws Exception {
    	Example example=new Example(PubScinfoHis.class);
        example.createCriteria().andEqualTo("taskNO",taskNO);
        pubScinfoHisMapper.deleteByExample(example);
    }
    
    /**
	 * 描述:获取收个随机数和抽取户数总数
	 * @author chenxin
	 * @date 2016-11-04
	 * @param total
	 * @param percent抽取百分比
	 * @return
	 * @throws Exception
	 */
    @Override
    public String countFirstNumber(int total, float percent) throws Exception {
    	if(percent > PERCENT_MAX ){
    		return PERCENT_MAX+"";
    	}
    	int firstNum= SkipNum.getRandom(total, percent);
    	List<String> list = SkipNum.getAllRandomNumber(total,percent);
    	int length = list.size();
    	return firstNum +","+length;
    }
}