package com.icinfo.cs.sment.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.sment._enum.ReasonByHisRnum;
import com.icinfo.cs.sment._enum.SmentSourceEnum;
import com.icinfo.cs.sment.constant.SmentConstants;
import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.mapper.BaseinfoDataSyncMapper;
import com.icinfo.cs.sment.model.SmBaseinfoHis;
import com.icinfo.cs.sment.service.IBaseinfoDataSyncService;
import com.icinfo.cs.sment.service.ISmBaseinfoHisService;
import com.icinfo.cs.sment.service.ISmBaseinfoService;
import com.icinfo.cs.sment.util.SmentRuleUtils;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 小微监测数据同步方法 - 实现
 * 
 * @author zhuyong
 */
@Service
public class BaseinfoDataSyncServiceImpl extends MyBatisServiceSupport
	implements IBaseinfoDataSyncService{
	
	@Autowired
	BaseinfoDataSyncMapper baseinfoDataSyncMapper;
	
	@Autowired
	private ISmBaseinfoService smBaseinfoService;
	
	@Autowired
	private ISmBaseinfoHisService smBaseinfoHisService;
	
	/** 搜索结果数据源 */
	private static final String SOURCE_TYPE_SM = "sm_baseinfo";
	
	// 分页数据大小
	private static final int PAGE_SIZE = 100;
	
	/**
	 * 获取前一天增量的数据总量
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer selectSyncCountForBaseinfo(Map<String,Object> qryMap) throws Exception{
		return baseinfoDataSyncMapper.selectSyncCountForBaseinfo(qryMap);	
	}
	
	
	/**
	 * 增量更新小微名录库
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @param syncTotal
	 */
	public void updateByInc(Map<String,Object>qryMap,int syncTotal)  throws Exception{
		Map<String,Object> map = qryMap;
		List<String> priPIDList = null;
		for (int i = 0; i < syncTotal; i = i + PAGE_SIZE) {
			map.put("numStart", i);
			map.put("pageSize", PAGE_SIZE);
			priPIDList = baseinfoDataSyncMapper.selectSmPriPIDInc(map);
			for (String priPID : priPIDList) {
				updateOne(priPID);
			}
		}
	}
	
	/**
	 * 全量匹配更新
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @throws Exception
	 */
	public void updateByBatchComp(Map<String,Object>qryMap) throws Exception{
		// 手动新设生成小微企业 过滤老的小微企业
	}
	
	
	/**
	 * 更新某一家企业
	 * 是小微    ： 列入/保持不动
	 * 不是小微：  不列入/移除
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
	public void updateOne(String priPID) throws Exception{
		if(StringUtils.isBlank(priPID)){
			return ;
		}
		checkIsSment(smBaseinfoService.selectOneForCompare(priPID));
	}
	
	/**
	 * 初始化一家企业是不是小微
	 * 
	 * @author zhuyong
	 * @param smList
	 * @throws Exception
	 */
	private void checkIsSment(List<SmBaseinfoDto> smList) throws Exception {
		if (smList == null || smList.size() == 0 || smList.size() > 2)
			return;
		
		if(smList.size() == 1){
			checkIsSmByOne(smList);
			return ;
		}
		
		if(smList.size() == 2){
			checkIsSmByTwo(smList);
			return ;
		}
	}
	
	/**
	 * 检查单条返回结果是不是小微企业
	 * 
	 * @author zhuyong
	 * @param smList
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	private void checkIsSmByOne(List<SmBaseinfoDto> smList) throws Exception{
		SmBaseinfoDto dto = smList.get(0);
		/** 1 监管基本信息表-无  小微基本信息表-有 ，不用做任何操作 */
		if(SOURCE_TYPE_SM.equals(dto.getSourceType()))
			return ;
		
		/** 2 监管基本信息表-有  小微基本信息表-无 ，列入小微库 */
		if(SmentRuleUtils.checkMidEntIsSm(dto)){
			smBaseinfoService.insertOneFromCsMidBaseinfo(dto.getPriPID(),SmentConstants.IS_SMENT,SmentSourceEnum.XS.toString());
			smBaseinfoHisService.insertSmBaseinfoHis(new SmBaseinfoHis(dto, ReasonByHisRnum.INSERT.toString()));
		}
	}
	
	/**
	 * 检查两条返回结果是不是小微企业
	 * 
	 * @author zhuyong
	 * @param smList
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	private void checkIsSmByTwo(List<SmBaseinfoDto> smList) throws Exception{
		SmBaseinfoDto baseinfoDto = smList.get(0);
		SmBaseinfoDto smDto = smList.get(1);
		
		//如果不是作为新设列入的则不处理
		if(SmentSourceEnum.ZC.toString().equalsIgnoreCase(smDto.getSmentReason())){
			return ;
		}
		
		// 从cs_mid_baseinfo表取出的企业是否是小微
		boolean baseIsSment = SmentRuleUtils.checkMidEntIsSm(baseinfoDto);
		 // 获取小微库里面小微企业状态
		boolean smIsSment = smDto.getIsSment().equals(SmentConstants.IS_SMENT) && SmentRuleUtils.checkSmIsValid(smDto); 
		
		smBaseinfoService.deleteByPriPID(smDto.getPriPID());
		
		if(baseIsSment && smIsSment){ // 更新小微库里小微企业信息
			smBaseinfoService.insertOneFromCsMidBaseinfo(smDto.getPriPID(), SmentConstants.IS_SMENT, SmentSourceEnum.XS.toString());
			return ;
		}
		
		if(baseIsSment && !smIsSment){ // 重新列入
			smBaseinfoService.insertOneFromCsMidBaseinfo(smDto.getPriPID(), SmentConstants.IS_SMENT,SmentSourceEnum.XS.toString());
			smBaseinfoHisService.insertSmBaseinfoHis(new SmBaseinfoHis(smDto,ReasonByHisRnum.INSERT.toString()));
			return ;
		}
		
		if(!baseIsSment && smIsSment){ // 移除小微企业
			smBaseinfoService.insertOneFromCsMidBaseinfo(smDto.getPriPID(), SmentConstants.IS_SMENT_NOT,SmentSourceEnum.XS.toString());
			smBaseinfoHisService.insertSmBaseinfoHis(new SmBaseinfoHis(smDto,ReasonByHisRnum.REMOVE.toString()));
			return ;
		}
		
//		if(!baseIsSment && !smIsSment){//无需修改
//			return ;
//		}
		
	}
	
	
	
	
}
