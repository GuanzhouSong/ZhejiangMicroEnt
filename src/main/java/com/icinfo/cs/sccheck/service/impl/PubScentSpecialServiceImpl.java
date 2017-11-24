/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.sccheck.dto.PubScentSpecialDto;
import com.icinfo.cs.sccheck.mapper.PubScentSpecialMapper;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.cs.sccheck.model.PubScentSpecial;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubScentBackService;
import com.icinfo.cs.sccheck.service.IPubScentSpecialService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_pub_scent_special 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月01日
 */
@Service
public class PubScentSpecialServiceImpl extends MyBatisServiceSupport implements IPubScentSpecialService {
	@Autowired
	private IPubScentBackService pubScentBackService;
	@Autowired
	private IpubScSpecialLibraryService pubScSpecialLibraryService;
	@Autowired
	private PubScentSpecialMapper pubScentSpecialMapper;
	@Autowired
	private IPubSccheckItemService pubSccheckItemService;
	/**
	 * 描述:生成专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void savePubScentSpecialBatch(String taskUid) throws Exception {
		delPubScentSpecial(taskUid);//先清除记录
		//1.根据企业查询抽取的所有企业
		List<PubScentSpecial> pubScentSpecialList = pubScentSpecialMapper.seletPubScentSpecialList(taskUid);
		//2.查询本次任务涉及的所有的检查事项
		List<PubSccheckItem> pubSccheckItemList = pubSccheckItemService.selectPubSccheckItemByTaskUid(taskUid);
		//3.查询本次检查任务主体综合库检查事项
		String checkName = getCheckNames(pubSccheckItemList);
		//3.将检查事项按照专项库分类
		String checkItemCodes = getSpePubSccheckItemList(pubSccheckItemList);
		if(CollectionUtils.isNotEmpty(pubScentSpecialList)){
			for(PubScentSpecial pubScentSpecial : pubScentSpecialList){
				//4.查询企业的所有的标签数据，并且插入数据
				if(StringUtils.isNotEmpty(pubScentSpecial.getPriPID())){
					String priPID = pubScentSpecial.getPriPID();
					//5.查询企业对应的专项库信息
					List<pubScSpecialLibraryDto> pubScSpecialLibraryList = null;
					if(StringUtils.isNotEmpty(checkItemCodes)){
						Map<String,Object> params = new HashMap<String,Object>();
						params.put("priPID", priPID);
						params.put("checkItemCodes", checkItemCodes.split(","));
						pubScSpecialLibraryList = pubScSpecialLibraryService.selectPubScSpecialLibrary(params);
					}
					if(CollectionUtils.isNotEmpty(pubScSpecialLibraryList)){
						//6.如果有专项库数据，则去重插入
						Set<String> set = new HashSet<String>();
						for(pubScSpecialLibraryDto pubScSpecialLibrary : pubScSpecialLibraryList){
							if(pubScSpecialLibrary != null && StringUtils.isNotEmpty(pubScSpecialLibrary.getCheckItemCode())){
								String checkItemCode = pubScSpecialLibrary.getCheckItemCode();
								if(!set.contains(checkItemCode)){
									set.add(checkItemCode);
									pubScentSpecial.setId(null);
									pubScentSpecial.setUid(null);
									pubScentSpecial.setCheckCode(pubScSpecialLibrary.getCheckItemCode());
									pubScentSpecial.setCheckName(pubScSpecialLibrary.getCheckItemName());
									pubScentSpecial.setSpecialCode(pubScSpecialLibrary.getSpecialCode());
									pubScentSpecial.setSpecialName(pubScSpecialLibrary.getSpecialName());
									pubScentSpecial.setRelateUserUid(pubScSpecialLibrary.getSetUserUid());
									savePubScentSpecial(pubScentSpecial);
								}
							}
						}
					}else{
						//7.如果没有专项库数据则插入主体综合库
						pubScentSpecial.setCheckCode("multiple");
						pubScentSpecial.setCheckName(checkName);
						pubScentSpecial.setSpecialCode("multiple");
						pubScentSpecial.setSpecialName("主体综合库");
						savePubScentSpecial(pubScentSpecial);
					}
				}
			}
		}
	}
	
	/**
	 * 描述:删除待抽检库专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @throws Exception
	 */
	@Override
	public void delPubScentSpecial(String taskUid) throws Exception {
		Example example=new Example(PubScentBack.class);
        example.createCriteria().andEqualTo("taskUid",taskUid);
        pubScentSpecialMapper.deleteByExample(example);
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
	 * 描述:封装检查事项编码
	 * @author chenxin
	 * @date 2017-06-01
	 * @param pubSccheckItemList
	 * @return
	 */
	private String getSpePubSccheckItemList(List<PubSccheckItem> pubSccheckItemList) {
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
	 * 描述:保存待抽检库专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param pubScentSpecial
	 */
	@Override
	public void savePubScentSpecial(PubScentSpecial pubScentSpecial)throws Exception{
		if(pubScentSpecial != null){
			pubScentSpecialMapper.insertSelective(pubScentSpecial);
		}
	}
	
	/**
	 * 描述:统计所有的检查事项类型及企业数量
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @return
	 */
	@Override
	public List<PubScentSpecialDto> selectCheckItemCodeTypes(String taskUid) {
		if(StringUtils.isNotEmpty(taskUid)){
			return pubScentSpecialMapper.selectCheckItemCodeTypes(taskUid);
		}
		return null;
	}
	
	/**
	 * 描述：查询某个检查事项对应的检查企业
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @param checkCode
	 * @return
	 */
	@Override
	public List<PubScentSpecial> selectScentSpecialList(String taskUid,String checkCode) {
		Example example=new Example(PubScentSpecial.class);
        example.createCriteria().andEqualTo("taskUid",taskUid).andEqualTo("checkCode",checkCode);
		return pubScentSpecialMapper.selectByExample(example);
	}
	
	/**
	 * 描述：获取一条企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param params
	 * @return PubScentSpecial
	 * @throws Exception
	 */
	@Override
	public PubScentSpecial selectPubScentSpeForRandom(Map<String, Object> params) {
		return pubScentSpecialMapper.selectPubScentSpeForRandom(params);
	}
}