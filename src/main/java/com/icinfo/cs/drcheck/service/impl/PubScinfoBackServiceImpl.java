/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.dto.PubScinfoBackDto;
import com.icinfo.cs.drcheck.mapper.PubScinfoBackMapper;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.cs.drcheck.model.PubScinfoBack;
import com.icinfo.cs.drcheck.service.IPubScinfoBackService;
import com.icinfo.cs.drcheck.service.IPubScinfoHisService;
import com.icinfo.cs.drcheck.service.IPubScinfoService;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scinfo_back 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubScinfoBackServiceImpl extends MyBatisServiceSupport implements IPubScinfoBackService {

    @Autowired
    private PubScinfoBackMapper pubScinfoBackMapper;
    
    //抽检历史记录表
    @Autowired 
    private IPubScinfoHisService pubScinfoHisService;
    //抽检选中表
    @Autowired
    private IPubScinfoService pubScinfoService;
    //企业主表信息
    @Autowired
    private IMidBaseInfoService midBaseInfoService;
    
    /**
     * 描述：查询企业待选库列表(工商端)
     * @author chenxin
     * @date 2016-11-02
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<PubScinfoBackDto> queryPubScinfoBackDtoPage(PageRequest request) {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScinfoBackMapper.selectPubScinfoBackDtoList(request.getParams());
    }
    
    /**
	 * 描述：批量插入备份表
	 * @author chenxin
	 * @date 2016-11-02
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void savePubScinfoBackBatch(String taskNO,List<PubScinfoBack> pubScinfoBackList) throws Exception{
    	this.cleanScinfoBackByTaskNO(taskNO);
    	if(pubScinfoBackList != null && pubScinfoBackList.size() >= 0){
    		for(PubScinfoBack pubScinfoBack : pubScinfoBackList){
    			pubScinfoBackMapper.insert(pubScinfoBack);
    		}
    	}
    }
    
    /**
	 * 描述：插入备份表
	 * @author chenxin
	 * @date 2016-11-02
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @Override
    public void savePubScinfoBack(PubScinfoBack pubScinfoBack) throws Exception {
    	if(pubScinfoBack != null){
    		pubScinfoBackMapper.insert(pubScinfoBack);
    	}
    }
    
    /**
	 * 描述：根据抽检taskNO查询企业
	 * @author chenxin
	 * @date 2016-11-02
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<PubScinfoBack> selectPubScinfoBackByTaskNO(String taskNO) {
    	if(StringUtils.isNotEmpty(taskNO)){
    		Map<String,Object> params = new HashMap<String,Object>();
    		params.put("taskNO", taskNO);
    		return pubScinfoBackMapper.selectPubScinfoBackByTaskNO(params);
    	}
    	return null;
    }
    
    /**
	 * 描述：统计待抽检库数量
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
    @Override
    public int countPubScinfoBack(String taskNO) {
    	PubScinfoBack pubScinfoBack = new PubScinfoBack();
    	pubScinfoBack.setTaskNO(taskNO);
    	return pubScinfoBackMapper.selectCount(pubScinfoBack);
    }
    
    /**
	 * 描述：查询企业是否存在
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
    @Override
    public int countPubScinfoBackExist(String taskNO, String priPID) {
    	PubScinfoBack pubScinfoBack = new PubScinfoBack();
    	pubScinfoBack.setTaskNO(taskNO);
    	pubScinfoBack.setPriPID(priPID);
    	return pubScinfoBackMapper.selectCount(pubScinfoBack);
    }
    
    /**
	 * 描述：查询已经导入待抽检库的企业主体身份代码
	 * @author chenxin
	 * @date 2016-12-06
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<String> selectPriPIDListByTaskNO(String taskNO) {
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("taskNO", taskNO);
    	return pubScinfoBackMapper.selectPriPIDListByTaskNO(params);
    }
    
    /**
     * 描述：插入待抽检库
     * @author chenxin
     * @date 2016-11-03
     * @param taskNO
     * @param pripIDList
     * @return
     * @throws Exception
     */
    @Override
    public boolean addScinfoBackByTaskNO(String taskNO, List<String> pripIDList) throws Exception {
    	if(StringUtils.isNotEmpty(taskNO) && pripIDList != null && pripIDList.size() > 0){
    		List<String> list = this.selectPriPIDListByTaskNO(taskNO);
    		for(String pripID : pripIDList){
    			//1.根据taskNO和企业主体代码查询时候已在待抽检库
    			PubScinfoBack pubScinfoBack = new PubScinfoBack();
    			pubScinfoBack.setTaskNO(taskNO);
    			pubScinfoBack.setPriPID(pripID);
    			if(list.contains(pripID)){
    				continue;
    			}
    			pubScinfoBack.setCreateTime(new Date());
    			pubScinfoBackMapper.insert(pubScinfoBack);
    			list.add(pripID);
    			//2.查询企业数据
//    			MidBaseInfo midBaeInfo = midBaseInfoService.selectByPripid(pripID);
//    			PubScinfoBack pubScinfoBackInsert = copyMidToPubscInfoBack(midBaeInfo,taskNO);
    			//3.插入待抽检库
    		}
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 描述：插入待抽检库（批量导入）
     * @author chenxin
     * @date 2017-02-2-20
	 * @param taskNO
	 * @param in
	 * @return
	 * @throws Exceptionc
	 */
    @Override
    public boolean batchImportBack(InputStream in, String taskNO) throws Exception {
    	if(in != null && StringUtils.isNotEmpty(taskNO)){
    		List<String> regNOList = excelTranslateRegNO(in);//解析excel注册号或统一代码
    		if(regNOList != null && regNOList.size() > 0){
    			List<String> pirPIDList = midBaseInfoService.selectPriPIDByRegno(regNOList);
    			List<String> list = this.selectPriPIDListByTaskNO(taskNO);
    			//插入待抽检库
    			for(String priPID : pirPIDList){
    				if(list.contains(priPID)){
    					continue;
    				}
    				PubScinfoBack pubScinfoBack = new PubScinfoBack();
    				pubScinfoBack.setTaskNO(taskNO);
    				pubScinfoBack.setPriPID(priPID);
    				pubScinfoBackMapper.insert(pubScinfoBack);
    				list.add(priPID);
    			}
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 描述：解析excel
     * @author chenxin
     * @date 2017-02-21
     * @param in
     * @return
     */
    private List<String> excelTranslateRegNO(InputStream in){
    	try {
			//解析excel
			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			if (rows < 2) {
				return null;
			}
			List<String> regNOList = new ArrayList<String>();
			// 遍历处理每行
			for (int i = 1; i < rows; i++) {
				Row row = sheet.getRow(i);
				if (row == null || row.getCell(0) == null) {
					continue;
				}
				String regNO = ExcelUtil.getCellContent(row.getCell(0));
				if(StringUtils.isNotEmpty(regNO)){
					regNOList.add(regNO);
				}
			}
			return regNOList;
		} catch (Exception e) {
			return null;
		}
    }

	/**
     * 描述：通过主任务表ID清空待抽检库
     * @author chenxin
     * @date 2016-11-03
     * @param taskNO
     * @return
     * @throws Exception
     */
    @Override
    public void cleanScinfoBackByTaskNO(String taskNO) throws Exception {
        if(StringUtils.isNotEmpty(taskNO)){
        	PubScinfoBack pubScinfoBack = new PubScinfoBack();
        	pubScinfoBack.setTaskNO(taskNO);
        	pubScinfoBackMapper.delete(pubScinfoBack);
        }
    }
    
    /**
	 * 描述： 统计待抽检库，各登记机关对应的企业数量
	 * @author chenxin
	 * @date 2016-11-21
	 * @param taskNO
	 * @param minNum
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<PubScinfoBackDto> selectCountInfoBack(String taskNO,int minNum) throws Exception {
    	if(StringUtils.isNotEmpty(taskNO)){
	    	Map<String, Object> params = new HashMap<String,Object>();
	    	params.put("taskNO", taskNO);
	    	if(minNum > 0){
	    		params.put("minNum", minNum);
	    	}
	    	return pubScinfoBackMapper.selectCountInfoBack(params);
    	}
    	return new ArrayList<PubScinfoBackDto>();
    }
    
    /**
	 * 描述:根据登记机关随机抽取企业
	 * @author chenxin
	 * @date 2016-11-21
	 * @param taskNO
	 * @param totalRandomNum
	 * @return
	 */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public boolean randomPubScinfoByRegOrg(String taskNO, int totalRandomNum)throws Exception  {
    	if(StringUtils.isEmpty(taskNO) || totalRandomNum <= 0){
    		return false;
    	}
    	//1.统计待抽检库总数量
    	int total = this.countPubScinfoBack(taskNO);
    	if(total <= 0){
    		return false;
    	}
    	//2.统计待抽检库中登记机关及各个登记机关所对应的企业数量
    	List<PubScinfoBackDto> pubScinfoBackDtoList = selectCountInfoBack(taskNO,0);
    	Map<String,Integer> backMap = getBackMap(pubScinfoBackDtoList);
    	if(backMap == null){
    		return false;
    	}
    	//3.根据待抽取总数分配给各登记机关
    	Map<String,Integer> randomMap = randomRegOrg(backMap,totalRandomNum);
    	if(randomMap == null){
    		return false;
    	}
    	//4.随机抽取企业
    	pubScinfoService.cleanPubScinfoByTaskNO(taskNO);
    	randomPubScinfo(randomMap,backMap,taskNO);
    	//5.清空待抽检库
//    	this.cleanScinfoBackByTaskNO(taskNO);
    	return true;
    }

    /**
     * 描述：转成map
     * @author chenxin
     * @date 2016-11-21 
     * @param pubScinfoBackDtoList
     * @return
     */
    private Map<String, Integer> getBackMap(List<PubScinfoBackDto> pubScinfoBackDtoList) {
    	if(pubScinfoBackDtoList == null || pubScinfoBackDtoList.size() <= 0){
    		return null;
    	}
		Map<String,Integer> backMap = new HashMap<String,Integer>();
		boolean flag = true;
		for(PubScinfoBackDto pubScinfoBackDto : pubScinfoBackDtoList){
			String regOrg = pubScinfoBackDto.getRegOrg();
			int count = pubScinfoBackDto.getEntCount();
//			if(StringUtils.isEmpty(regOrg)){
//				flag = false;
//				break;
//			}
			if(StringUtils.isNotEmpty(regOrg) && count > 0){
				backMap.put(regOrg, count);
			}
		}
		if(!flag){
			return null;
		}
		return backMap;
	}

	/**
     * 描述：随机抽取各个登记机关下的企业
     * @author chenxin
     * @date 2016-11-21
     * @param map
     * @param backMap
     * @param taskNO
     */
    private void randomPubScinfo(Map<String, Integer> map,Map<String,Integer> backMap,String taskNO)throws Exception {
    	Set<String> set = new HashSet<String>();
    	for (String regOrg : map.keySet()) {  
    		int totalRandom = map.get(regOrg);//需要随机的个数
    		int totalEnt = backMap.get(regOrg);//登记机关下所有的企业数量
    		for(int i = 0;i < totalRandom;i++){
    			boolean flag = true;
    			while(flag){
    				int rand = new Random().nextInt(totalEnt)+1;
    				int entNumber = rand - 1;
    				Map<String,Object> params = new HashMap<String,Object>();
    				params.put("regOrg", regOrg);
    				params.put("entNumber", entNumber);
    				params.put("taskNO", taskNO);
    				PubScinfo pubScinfo = pubScinfoService.selectPubScinfoForInsert(params);
    				if(pubScinfo !=null && StringUtils.isNotEmpty(pubScinfo.getPriPID())){
    					String priPID = pubScinfo.getPriPID();
    					if(!set.contains(priPID)){
    						pubScinfo.setCreateTime(new Date());
    						pubScinfoService.insertPubScinfo(pubScinfo);
    						set.add(priPID);
    						flag = false;
    					}
    				}
    			}
    			
    		}
    	}  
	}
    
	/**
     * 描述:根据分配登记机关抽取企业数量
	 * @author chenxin
	 * @date 2016-11-21
     * @param pubScinfoBackDtoList
     * @param total
     * @param totalRnadomNum
     * @return
     */
	private Map<String, Integer> randomRegOrg(Map<String,Integer> backMap,int totalRnadomNum)throws Exception {
		Map<String, Integer> regorgMap = new HashMap<String,Integer>();
		//1.获取最小值，平均分配，直到剩下一个登记机关则分配剩下的全部数量
		boolean flag = true;
		int totalCount = 0;
		while(flag){
			for (String regOrg : backMap.keySet()){ 
				int entCount = backMap.get(regOrg);
				if(regorgMap.get(regOrg) != null){
					int haveCount = regorgMap.get(regOrg);
					if(haveCount < entCount){
						haveCount ++; 
						regorgMap.put(regOrg, haveCount);
						totalCount ++;
					}
				}else{
					regorgMap.put(regOrg, 1);
					totalCount ++;
				}
				if(totalRnadomNum == totalCount){
					flag = false;
					break;
				}
			}
		}
		return regorgMap;
	}
}