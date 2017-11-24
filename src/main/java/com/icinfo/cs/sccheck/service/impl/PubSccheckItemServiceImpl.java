/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.sccheck.mapper.PubSccheckItemMapper;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.service.IDrandomSpecialEntService;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_pub_sccheck_item 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubSccheckItemServiceImpl extends MyBatisServiceSupport implements IPubSccheckItemService {

	@Autowired
	private  PubSccheckItemMapper pubSccheckItemMapper;
	@Autowired
	private  IPubScdeptTaskService pubScdeptTaskService;
	@Autowired
	private  IPubScPlanTaskService pubScPlanTaskService;
	@Autowired
	private  IpubScSpecialLibraryService pubScSpecialLibraryService;
	@Autowired
	private  IDrandomSpecialEntService drandomSpecialEntService;
	/**
	 * 根据任务uid删除
	 */
	@Override
	public int deletePubSccheckItemByTaskUid(String taskUid) throws Exception {
		if(StringUtil.isNotBlank(taskUid)){
			PubSccheckItem pubSccheckItem=new PubSccheckItem();
			pubSccheckItem.setTaskUid(taskUid);
			return pubSccheckItemMapper.delete(pubSccheckItem);
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   根据任务uid查询
	 * @author  赵祥江
	 * @date 2017年5月19日 上午9:07:23 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubSccheckItem> selectPubSccheckItemByTaskUid(String taskUid)
			throws Exception {
		if(StringUtil.isNotBlank(taskUid)){
			PubSccheckItem pubSccheckItem=new PubSccheckItem();
			pubSccheckItem.setTaskUid(taskUid);
			return pubSccheckItemMapper.select(pubSccheckItem);
		} 
		return null;
	}

	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年5月19日 上午9:07:44 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertPubSccheckItem(PubSccheckItem pubSccheckItem)
			throws Exception {
		if(pubSccheckItem!=null){
			return pubSccheckItemMapper.insert(pubSccheckItem);
		}
		return 0;
	}
	
	/**
	 * 
	 * 描述:根据实施部门任务ID查询企业相关的检查事项
	 * @author chenxin
	 * @date 2017年6月1日 上午9:02:36 
	 * @param deptTaskUid
	 * @param priPID
	 * @return List<PubSccheckItem>
	 * @throws
	 */
	@Override
	public List<PubSccheckItem> selectEntRlate(String deptTaskUid, String priPID)throws Exception {
		if(StringUtils.isNotEmpty(deptTaskUid) || StringUtils.isNotEmpty(priPID)){
			//1.根据部门任务查询，主任务信息
			PubScdeptTask pubScdeptTask = pubScdeptTaskService.selectPubScdeptTaskByUid(deptTaskUid);
			if(pubScdeptTask != null && StringUtils.isNotEmpty(pubScdeptTask.getTaskUid())){
				PubScPlanTask pubScPlanTask = pubScPlanTaskService.selectPubScPlanTaskByUid(pubScdeptTask.getTaskUid());
				if(pubScPlanTask != null && !"A058".equals(pubScPlanTask.getDutyDeptCode())
						&& !"A012".equals(pubScPlanTask.getDutyDeptCode())
						&& !"A027".equals(pubScPlanTask.getDutyDeptCode())){
					return selectRlateSpecial(pubScdeptTask, priPID);
				}
				//2.查询本次任务涉及的所有标签
				List<PubSccheckItem> pubSccheckItemList = this.selectPubSccheckItemByTaskUid(pubScdeptTask.getTaskUid());
//				if("1".equals(pubScPlanTask.getRandomType())){//如果按照主体综合库抽取，则显示所有检查事项
//					return pubSccheckItemList;
//				}
				if(CollectionUtils.isNotEmpty(pubSccheckItemList) && pubSccheckItemList.size() > 0){
					//5.定义一企一表标签
					List<PubSccheckItem> returnPubSccheckItemList = new ArrayList<PubSccheckItem>();
					//6.查询当前企业专项库对应的检查事项
					List<String> entCheckCodeList = pubScSpecialLibraryService.selectCheckCodeList(priPID);
					//7.转化成set，便于判断
					Set<String> entCheckCodeSet = getentCheckCodeSet(entCheckCodeList);
					//8.遍历当前任务涉及的所有标签，按照规则分类【主体综合库的标签全部加入,当前企业对应的专项库标签全部加入】
					for(PubSccheckItem pubSccheckItem : pubSccheckItemList){
						if(StringUtils.isNotEmpty(pubSccheckItem.getCheckCode())){
							String checkCode = pubSccheckItem.getCheckCode();
							if(judgeCheckCode(checkCode)){
								returnPubSccheckItemList.add(pubSccheckItem);
							}else{
								if(entCheckCodeSet != null && entCheckCodeSet.contains(checkCode)){
									returnPubSccheckItemList.add(pubSccheckItem);
								}
							}
						}
					}
					return returnPubSccheckItemList;
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * 描述   查询企业相关的检查事项
	 * @author chenxin
	 * @date 2017年6月1日 上午9:02:36 
	 * @param deptTaskUid
	 * @param deptTaskUid
	 * @return List<PubSccheckItem>
	 * @throws
	 */
	@Override
	public List<PubSccheckItem> selectRlateSpecial(PubScdeptTask pubScdeptTask, String priPID)throws Exception {
		if(pubScdeptTask != null && StringUtils.isNotEmpty(priPID)){
			if(StringUtils.isNotEmpty(pubScdeptTask.getTaskUid())){
				//1.查询本次任务涉及的所有标签
				List<PubSccheckItem> pubSccheckItemList = this.selectPubSccheckItemByTaskUid(pubScdeptTask.getTaskUid());
				if(CollectionUtils.isNotEmpty(pubSccheckItemList) && pubSccheckItemList.size() > 0){
					//2.定义一企一表标签
					List<PubSccheckItem> returnPubSccheckItemList = new ArrayList<PubSccheckItem>();
					//3.查询当前企业专项库对应的检查事项
					List<String> entCheckCodeList = drandomSpecialEntService.selectCheckCodeList(priPID);
					//4.转化成set，便于判断
					Set<String> entCheckCodeSet = getentCheckCodeSet(entCheckCodeList);
					//5.遍历当前任务涉及的所有标签，按照规则分类【主体综合库的标签全部加入,当前企业对应的专项库标签全部加入】
					for(PubSccheckItem pubSccheckItem : pubSccheckItemList){
						if(StringUtils.isNotEmpty(pubSccheckItem.getCheckCode())){
							String checkCode = pubSccheckItem.getCheckCode();
							if(entCheckCodeSet != null && entCheckCodeSet.contains(checkCode)){
								returnPubSccheckItemList.add(pubSccheckItem);
							}
						}
					}
					return returnPubSccheckItemList;
				}
			}
		}
		return null;
	}

	/**
	 * 描述：转成set
	 * @author chenxin
	 * @date 2017年6月1日 上午9:02:36 
	 * @param entCheckCodeList
	 * @return
	 */
	private Set<String> getentCheckCodeSet(List<String> entCheckCodeList) {
		if(CollectionUtils.isNotEmpty(entCheckCodeList)){
			Set<String> set = new HashSet<String>();
			for(String entCheckCode : entCheckCodeList){
				if(StringUtils.isNotEmpty(entCheckCode)){
					set.add(entCheckCode);
				}
			}
			return set;
		}
		return null;
	}

	/**
	 * 描述：判断一个检查事项是否是主体综合库
	 * @author chenxin
	 * @date 2017年6月1日 上午9:02:36 
	 * @param checkCode
	 * @return
	 */
	private boolean judgeCheckCode(String checkCode) {
		if("A02,A03,A05,A07,A08,A09,C13,C14".indexOf(checkCode) > -1){
			return true;
		}
		if(checkCode.indexOf("OTHER") > -1){//自定义检查项
			return true;
		}
		return false;
	}
}