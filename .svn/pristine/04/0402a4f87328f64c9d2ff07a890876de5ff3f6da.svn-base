/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.sccheck.dto.PubScentConditionDto;
import com.icinfo.cs.sccheck.dto.PubScentSpecialDto;
import com.icinfo.cs.sccheck.mapper.PubScentConditionMapper;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.cs.sccheck.model.PubScentCondition;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubScentBackService;
import com.icinfo.cs.sccheck.service.IPubScentConditionService;
import com.icinfo.cs.sccheck.service.IPubScentSpecialService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent_condition 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubScentConditionServiceImpl extends MyBatisServiceSupport implements IPubScentConditionService {
	
	@Autowired
	private PubScentConditionMapper pubScentConditionMapper;
	
	@Autowired
	private IPubScentBackService pubScentBackService;
	
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService;
	
	@Autowired
	private IPubSccheckItemService pubSccheckItemService;
	
	@Autowired
	private IPubScentSpecialService pubScentSpecialService;
	
	@Autowired
	private IpubScSpecialLibraryService pubScSpecialLibraryService;
	
	/**
     * 描述：确认本次检查对象抽取库
     * @author chenxin
     * @date 2017-05-17
     * @param taskUid
     * @param sysUser
     * @return
     * @throws Exception
     */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doConfirmEntBack(String taskUid,SysUserDto sysUser)throws Exception {
		if(StringUtils.isEmpty(taskUid)){
			return false;
		}
		pubScentSpecialService.savePubScentSpecialBatch(taskUid);
		doClassifyEntBack(taskUid, sysUser);
		return true;
	}
	
	/**
	 * 描述：确认本次检查对象抽取库条件
	 * @author chenxin
	 * @date 2017-05-17
	 * @param pubScentConditionDto
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doCommitCondition(PubScentConditionDto pubScentConditionDto)throws Exception {
		if(pubScentConditionDto != null && CollectionUtils.isNotEmpty(pubScentConditionDto.getPubScentConditionList())){
			List<PubScentCondition> pubScentConditionList = pubScentConditionDto.getPubScentConditionList();
			for(PubScentCondition pubScentCondition : pubScentConditionList){
				if(StringUtils.isNotEmpty(pubScentCondition.getUid())){
					Example example = new Example(PubScentBack.class);
					example.createCriteria().andEqualTo("uid", pubScentCondition.getUid());
					pubScentConditionMapper.updateByExampleSelective(pubScentCondition, example);
				}
			}
			if(pubScentConditionDto.getPubScPlanTask() != null){
				//更新主任务表信息
				pubScPlanTaskService.updatePubScPlanTaskByUid(pubScentConditionDto.getPubScPlanTask());
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：统计待抽检库结果
	 * @author chenxin
     * @date 2017-05-17
	 * @param request
	 * @return List<PubScentConditionDto>
	 * @throws Exception
	 */
	@Override
	public List<PubScentConditionDto> queryPubScentConditionDtoPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), 10000);
		return pubScentConditionMapper.selectPubScentConditionDtoList(request.getParams());
	}
	
	/**
	 * 描述：查询待抽取专项库信息
	 * @author chenxin
     * @date 2017-05-17
	 * @param request
	 * @return List<PubScentConditionDto>
	 * @throws Exception
	 */
	@Override
	public List<PubScentCondition> selectPubScentConditionList(String taskUid,String randomType) {
		Example example = new Example(PubScentCondition.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("checkType", randomType);
		return pubScentConditionMapper.selectByExample(example);
	}
	
	/**
	 * 描述：查询待抽取专项库信息
	 * @author chenxin
     * @date 2017-05-17
	 * @param request
	 * @return PubScentCondition
	 * @throws Exception
	 */
	@Override
	public List<PubScentCondition> selectPubScentCondition(String taskUid,String specialCode,String randomType) {
		Example example=new Example(PubScentCondition.class);
		example.createCriteria().andEqualTo("taskUid",taskUid).andEqualTo("specialCode",specialCode).andEqualTo("checkType",randomType);
		return pubScentConditionMapper.selectByExample(example);
	}
	
	/**
	 * 描述：将待抽检企业按照检查事项分类
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doClassifyEntBack(String taskUid,SysUserDto sysUser)throws Exception {
		//1.先清除库里统计记录
		Example example = new Example(PubScentBack.class);
		example.createCriteria().andEqualTo("taskUid", taskUid);
		pubScentConditionMapper.deleteByExample(example);
		//判断是否有待抽检库数据
		int total = pubScentBackService.selectEntTotal(taskUid);
		if(total <= 0){
			return false;
		}
		//===============================按照主体综合库分类============================
		//2.查询本次任务涉及的所有的检查事项
		List<PubSccheckItem> pubSccheckItemList = pubSccheckItemService.selectPubSccheckItemByTaskUid(taskUid);
		//3.查询本次检查任务主体综合库检查事项
		if(CollectionUtils.isNotEmpty(pubSccheckItemList)){
			String allCheckName = getAllCheckNames(pubSccheckItemList);
			
			int num = pubScentBackService.selectEntTotal(taskUid);
			PubScentCondition pubScentCondition = new PubScentCondition();
			pubScentCondition.setTaskUid(taskUid);
			pubScentCondition.setSpecialCode("multiple");
			pubScentCondition.setSpecialName("主体综合库");
			pubScentCondition.setSpecialNum(num);
			pubScentCondition.setCheckCode("multiple");
			pubScentCondition.setCheckName(allCheckName);
			pubScentCondition.setSetTime(new Date());
			pubScentCondition.setSetDeptCode(sysUser.getDeptCode());
			pubScentCondition.setSetTime(new Date());
			pubScentCondition.setSetUserUid(sysUser.getId());
			pubScentCondition.setSetUserName(sysUser.getRealName());
			pubScentCondition.setSetDeptName(sysUser.getDept());
			pubScentCondition.setCheckType("1");
			pubScentConditionMapper.insertSelective(pubScentCondition);
		}
		
		//================================按照专项库分类===========================
		//4.统计本次专项库数量
		List<PubScentSpecialDto> pubScentSpecialDtoList = pubScentSpecialService.selectCheckItemCodeTypes(taskUid);
		//5.保存统计记录
		if(CollectionUtils.isNotEmpty(pubScentSpecialDtoList)){
			String checkName = getCheckNames(pubSccheckItemList);
			for(PubScentSpecialDto pubScentSpecialDto : pubScentSpecialDtoList){
				PubScentCondition pubScentConditionSpe = new PubScentCondition();
				pubScentConditionSpe.setTaskUid(taskUid);
				pubScentConditionSpe.setSpecialCode(pubScentSpecialDto.getSpecialCode());
				pubScentConditionSpe.setSpecialName(pubScentSpecialDto.getSpecialName());
				pubScentConditionSpe.setSpecialNum(pubScentSpecialDto.getSpecialNum());
				pubScentConditionSpe.setCheckCode(pubScentSpecialDto.getCheckCode());
				if("multiple".equals(pubScentSpecialDto.getCheckCode())){
					pubScentConditionSpe.setCheckName(checkName);
				}else{
					pubScentConditionSpe.setCheckName(pubScentSpecialDto.getCheckCode()+"."+pubScentSpecialDto.getCheckName());
				}
				pubScentConditionSpe.setSetTime(new Date());
				pubScentConditionSpe.setSetDeptCode(sysUser.getDeptCode());
				pubScentConditionSpe.setSetTime(new Date());
				pubScentConditionSpe.setSetUserUid(sysUser.getId());
				pubScentConditionSpe.setSetUserName(sysUser.getRealName());
				pubScentConditionSpe.setSetDeptName(sysUser.getDept());
				pubScentConditionSpe.setCheckType("2");
				pubScentConditionMapper.insertSelective(pubScentConditionSpe);
			}
		}
		
		return true;
	}
	
	/**
	 * 描述:生成专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param pubSccheckItemList
	 * @return
	 */
	private String getCheckNames(List<PubSccheckItem> pubSccheckItemList) {
		String checkNames = "";
		for(PubSccheckItem pubSccheckItem : pubSccheckItemList){
			if(judgeCheckCode(pubSccheckItem.getCheckCode())){
				if(StringUtils.isEmpty(checkNames)){
					checkNames = pubSccheckItem.getCheckName();
				}else{
					checkNames += ","+pubSccheckItem.getCheckName();
				}
			}
		}
		return checkNames;
	}
	
	/**
	 * 描述:生成专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param pubSccheckItemList
	 * @return
	 */
	private String getAllCheckNames(List<PubSccheckItem> pubSccheckItemList) {
		String checkNames = "";
		for(PubSccheckItem pubSccheckItem : pubSccheckItemList){
			if(StringUtils.isEmpty(checkNames)){
				checkNames = pubSccheckItem.getCheckName();
			}else{
				checkNames += ","+pubSccheckItem.getCheckName();
			}
		}
		return checkNames;
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
	
	/**
	 * 描述：读取专项库分类数据
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doConfirmBySpecial(String taskUid, SysUserDto sysUser,Map<String,Object> params)throws Exception {
		Example example = new Example(PubScentCondition.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("checkType", "2");
		pubScentConditionMapper.deleteByExample(example);
		//读取专项库数据
		List<PubSccheckItem> pubSccheckItemList = pubSccheckItemService.selectPubSccheckItemByTaskUid(taskUid);
		String checkItemCodes = getSpePubSccheckItemList(pubSccheckItemList);
		if(StringUtils.isNotEmpty(checkItemCodes)){
			params.put("checkItemCodes", checkItemCodes.split(","));
			List<pubScSpecialLibraryDto> pubScSpecialLibraryList = pubScSpecialLibraryService.selectCountBySpecial(params);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				for(pubScSpecialLibraryDto psslDto : pubScSpecialLibraryList){
					PubScentCondition pubScentConditionSpe = new PubScentCondition();
					pubScentConditionSpe.setTaskUid(taskUid);
					pubScentConditionSpe.setSpecialCode(psslDto.getSpecialCode());
					pubScentConditionSpe.setSpecialName(psslDto.getSpecialName());
					pubScentConditionSpe.setSpecialNum(psslDto.getSpecialNum());
					pubScentConditionSpe.setCheckCode(psslDto.getCheckItemCode());
					pubScentConditionSpe.setCheckName(psslDto.getCheckItemCode()+"."+psslDto.getCheckItemName());
					pubScentConditionSpe.setSetTime(new Date());
					pubScentConditionSpe.setSetDeptCode(sysUser.getDeptCode());
					pubScentConditionSpe.setSetTime(new Date());
					pubScentConditionSpe.setSetUserUid(sysUser.getId());
					pubScentConditionSpe.setSetUserName(sysUser.getRealName());
					pubScentConditionSpe.setSetDeptName(sysUser.getDept());
					pubScentConditionSpe.setCheckType("2");
					pubScentConditionMapper.insertSelective(pubScentConditionSpe);
				}
				return true;
			}
		}
		return false;
	}
	

	/**
	 * 描述:封装检查事项编码
	 * @author chenxin
	 * @date 2017-06-01
	 * @param pubSccheckItemList
	 * @return
	 */
	@Override
	public String getSpePubSccheckItemList(List<PubSccheckItem> pubSccheckItemList) {
		String checkItemCodes = ""; 
		for(PubSccheckItem pubSccheckItem : pubSccheckItemList){
			if(!judgeCheckCode(pubSccheckItem.getCheckCode())){
				if(StringUtils.isEmpty(checkItemCodes)){
					checkItemCodes = pubSccheckItem.getCheckCode();
				}else{
					checkItemCodes += ","+pubSccheckItem.getCheckCode();
				}
			}
		}
		return checkItemCodes;
	}
	
	/**
	 * 描述：保存或更新
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean doSaveOrUpdateCondition(String taskUid, SysUserDto sysUser) throws Exception {
		Example example = new Example(PubScentCondition.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("checkType", "1");
		PubScentCondition params = new PubScentCondition();
		params.setTaskUid(taskUid);
		params.setCheckType("1");
		PubScentCondition result = pubScentConditionMapper.selectOne(params);
		int num = pubScentBackService.selectEntTotal(taskUid);
		if(num > 0){
			if(result == null){
				List<PubSccheckItem> pubSccheckItemList = pubSccheckItemService.selectPubSccheckItemByTaskUid(taskUid);
				//3.查询本次检查任务主体综合库检查事项
				if(CollectionUtils.isNotEmpty(pubSccheckItemList)){
					String allCheckName = getAllCheckNames(pubSccheckItemList);
					PubScentCondition pubScentCondition = new PubScentCondition();
					pubScentCondition.setTaskUid(taskUid);
					pubScentCondition.setSpecialCode("multiple");
					pubScentCondition.setSpecialName("主体综合库");
					pubScentCondition.setSpecialNum(num);
					pubScentCondition.setCheckCode("multiple");
					pubScentCondition.setCheckName(allCheckName);
					pubScentCondition.setSetTime(new Date());
					pubScentCondition.setSetDeptCode(sysUser.getDeptCode());
					pubScentCondition.setSetTime(new Date());
					pubScentCondition.setSetUserUid(sysUser.getId());
					pubScentCondition.setSetUserName(sysUser.getRealName());
					pubScentCondition.setSetDeptName(sysUser.getDept());
					pubScentCondition.setCheckType("1");
					pubScentConditionMapper.insertSelective(pubScentCondition);
					return true;
				}
			}else{
				result.setSpecialNum(num);
				result.setRandomNum(0);
				pubScentConditionMapper.updateByPrimaryKeySelective(result);
				return true;
			}
		}else{
			if(result != null){
				Example delexample = new Example(PubScentCondition.class);
				delexample.createCriteria().andEqualTo("uid", result.getUid());
				pubScentConditionMapper.deleteByExample(delexample);
				return true;
			}
		}
		return false;
	}
}