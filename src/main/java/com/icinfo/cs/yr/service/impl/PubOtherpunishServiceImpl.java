/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.base.mapper.CodeSetMapper;
import com.icinfo.cs.base.model.CodeSet;
import com.icinfo.cs.common.constant.CodeType;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.BeanUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.mapper.PubOtherPunishAlterMapper;
import com.icinfo.cs.yr.mapper.PubOtherpunishHisMapper;
import com.icinfo.cs.yr.mapper.PubOtherpunishMapper;
import com.icinfo.cs.yr.mapper.PubServerHisModMapper;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.cs.yr.model.PubOtherpunishHis;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_otherpunish 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Service
public class PubOtherpunishServiceImpl extends MyBatisServiceSupport implements IPubOtherpunishService {

	@Autowired
	PubOtherpunishMapper pubOtherpunishMapper;

	@Autowired
	PubOtherpunishHisMapper PubOtherpunishHisMapper;

	@Autowired
	PubServerHisModMapper pubServerHisModMapper;

	@Autowired
	PubOtherPunishAlterMapper pubOtherPunishAlterMapper;

	@Autowired
	private MidBaseInfoMapper midBaseInfoMapper;
	@Autowired
    private CodeSetMapper codeMapper;

	/**
	 * 描述：获取行政处罚录入审核列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param request
	 * @return List<PubOtherpunish>
	 * @throws Exception
	 */
	public List<PubOtherpunish> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOtherpunishMapper.selectOtherPunishInfo(request.getParams());
	}

	/**
	 * 描述：获取行政处罚信息查询列表数据
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param request
	 * @return List<PubOtherpunish>
	 * @throws Exception
	 */
	public List<PubOtherpunishDto> queryPageForPunishSearch(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<PubOtherpunishDto> PubOtherpunishDtoList = pubOtherpunishMapper.selectInfoForPunishSearch(handleParamsMap(request.getParams()));
		return PubOtherpunishDtoList;
	}
	
	/** 
	 * 描述: 获取行政处罚列表计数个数
	 * @auther yujingwei
	 * @date 2016年12月19日 
	 * @param request
	 * @return List<String>
	 */
	public List<PubOtherpunishDto> queryTotalForPunishSearch(Map<String, Object> pramsMap) throws Exception{
		return pubOtherpunishMapper.selectPunishSearchTotal(handleParamsMap(pramsMap));
	}

	/**
	 * 描述：通过pripId，caseNo查找行政处罚信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param pripid，caseNO
	 * @return PubOtherpunish
	 * @throws Exception
	 */
	public PubOtherpunish doGetPubOtherPunishInfo(String pripid, String caseNO) throws Exception {
		if (StringUtil.isNotEmpty(pripid) && StringUtil.isNotEmpty(caseNO)) {
			PubOtherpunish pubOtherpunish = new PubOtherpunish();
			pubOtherpunish.setPriPID(pripid);
			pubOtherpunish.setCaseNO(caseNO);
			return pubOtherpunishMapper.selectOne(pubOtherpunish);
		}
		return new PubOtherpunish();
	}

	/**
	 * 描述：获取行政处罚详细信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param request
	 * @return List<PubOtherpunish>
	 * @throws Exception
	 */
	public PubOtherpunishDto selectOtherPunishDetails(Map<String, Object> qryMap) throws Exception {
		return pubOtherpunishMapper.selectOtherPunishDetails(qryMap);
	}

	/**
	 * 描述：删除行政处罚信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param priPID，caseNO
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteOtherPunishInfo(String priPID, String caseNO) throws Exception {
		Example example = new Example(PubOtherpunish.class);
		example.createCriteria().andEqualTo("priPID", priPID).andEqualTo("caseNO", caseNO);
		if (pubOtherpunishMapper.deleteByExample(example) < 0) {
			return false;
		}
		return true;
	}

	/**
	 * 描述：保存或修改行政处罚信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param pubOtherpunish
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doSaveOrEditOtherPunishInfo(PubOtherpunish pubOtherpunish, SysUserDto sysUser) throws Exception {
		try {
			// 每次进行更新或插入操作进行的数据处理，置空审核信息
			pubOtherpunish.setSetDate(new Date());// 录入时间
			pubOtherpunish.setSetName(sysUser.getRealName());// 录入人
			pubOtherpunish.setSetDeptname(sysUser.getDeptCode());// 录入部门
			pubOtherpunish.setAuditState("0");// 设置待审核
			pubOtherpunish.setAuditOpin(null);// 审核意见
			pubOtherpunish.setAuditName(null);// 审核人姓名
			pubOtherpunish.setAuditDate(null);// 审核时间
			pubOtherpunish.setPubFlag("0");// 设置未公示
			if (pubOtherpunish != null && StringUtil.isNotEmpty(pubOtherpunish.getCaseNO())) {
				Example example = new Example(PubOtherpunish.class);
				example.createCriteria().andEqualTo("priPID", pubOtherpunish.getPriPID()).andEqualTo("caseNO",
						pubOtherpunish.getCaseNO());
				if (pubOtherpunishMapper.updateByExample(pubOtherpunish, example) < 0) {
					return false;
				}
			} else {
				String caseNO = StringUtil.getRandomNumber(pubOtherpunish.getPriPID());
				pubOtherpunish.setCaseNO(caseNO);
				if (pubOtherpunishMapper.insert(pubOtherpunish) < 0) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 描述：保存行政处罚变更信息
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param pubOtherpunish，sysUser
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doSavePunishAlter(PubOtherPunishAlter pubOtherPunishAlter, SysUser sysUser) throws Exception {
		String hisNo = null;
		// 保存变更信息
		if (pubOtherPunishAlter != null && pubOtherPunishAlter.getCaseNO() != null) {
			hisNo = StringUtil.getRandomNumber(pubOtherPunishAlter.getCaseNO());
			pubOtherPunishAlter.setHisNO(hisNo);
			pubOtherPunishAlterMapper.insert(pubOtherPunishAlter);
			// 增加修改记录
			PubServerHisMod pubServerHisMod = new PubServerHisMod();
			pubServerHisMod.setPriPID(pubOtherPunishAlter.getPriPID());
			pubServerHisMod.setModUID(pubOtherPunishAlter.getCaseNO());
			pubServerHisMod.setAltName(sysUser.getRealName());
			pubServerHisMod.setAltDate(new Date());
			pubServerHisMod.setHisNO(hisNo);
			pubServerHisMod.setAltTable("cs_pub_otherpunish");
			pubServerHisModMapper.insert(pubServerHisMod);
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 描述：行政处罚审核
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param pubOtherpunish
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doCommitPubOtherpunish(PubOtherpunish pubOtherpunish) throws Exception {
		if (!pubOtherpunish.getCaseNO().equals("")) {
			// 1.更新处罚表数据
			pubOtherpunish.setCreateTime(new Date());
			pubOtherpunish.setAuditDate(new Date());
			if (pubOtherpunish.getAuditState().equals("1")) {
				pubOtherpunish.setPubFlag("1");// 已公示
			} else if (pubOtherpunish.getAuditState().equals("2")) {
				pubOtherpunish.setPubFlag("0");// 未公示
			}
			Example example = new Example(PubOtherpunish.class);
			example.createCriteria().andEqualTo("priPID", pubOtherpunish.getPriPID()).andEqualTo("caseNO",
					pubOtherpunish.getCaseNO());
			pubOtherpunishMapper.updateByExampleSelective(pubOtherpunish, example);
			// 2.添加修改记录
			PubServerHisMod pubServerHisMod = new PubServerHisMod();
			pubServerHisMod = doHandleInfo(pubOtherpunish, pubServerHisMod);
			pubServerHisModMapper.insert(pubServerHisMod);
			// 3.更新处罚历史表数据
			PubOtherpunish newpubOtherpunish = new PubOtherpunish();
			newpubOtherpunish.setCaseNO(pubOtherpunish.getCaseNO());
			newpubOtherpunish.setPriPID(pubOtherpunish.getPriPID());
			PubOtherpunish pubOtherpunishTmp = pubOtherpunishMapper.selectOne(newpubOtherpunish);
			PubOtherpunishHis pubOtherpunishHis = new PubOtherpunishHis();
			if (pubOtherpunishTmp != null) {
				pubOtherpunishTmp.setId(null);
				BeanUtil.getBeanUtilsBean().copyProperties(pubOtherpunishHis, pubOtherpunishTmp);
			}
			pubOtherpunishHis.setCreateTime(new Date());
			pubOtherpunishHis.setHisNO(pubServerHisMod.getHisNO());
			PubOtherpunishHisMapper.insert(pubOtherpunishHis);
		} else {
			return false;
		}
		return true;
	}

	public PubServerHisMod doHandleInfo(PubOtherpunish pubOtherpunish, PubServerHisMod pubServerHisMod)
			throws Exception {
		pubServerHisMod.setHisNO(StringUtil.getRandomNumber(pubOtherpunish.getPriPID()));
		pubServerHisMod.setPriPID(pubOtherpunish.getPriPID());
		pubServerHisMod.setAltDate(pubOtherpunish.getSetDate());
		pubServerHisMod.setAltName(pubOtherpunish.getSetName());
		pubServerHisMod.setAuditState(pubOtherpunish.getAuditState());
		pubServerHisMod.setAuditDate(pubOtherpunish.getAuditDate());
		pubServerHisMod.setAuditName(pubOtherpunish.getAuditName());
		pubServerHisMod.setModUID(pubOtherpunish.getCaseNO());
		pubServerHisMod.setAltTable("cs_pub_otherpunish");
		return pubServerHisMod;
	}

	/**
	 * 描述：获取行政处罚信息(用于公告公示)
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param request
	 * @return List<PubOtherpunish>
	 * @throws Exception
	 */
	public List<PubOtherpunish> selectOtherPunishForBulletin(String updateDate) throws Exception {
		return pubOtherpunishMapper.selectOtherPunishForBulletin(updateDate);
	}

	/**
	 * 描述：获取行政处罚信息，通过caseNo查询
	 * 
	 * @author yujingwei
	 * @data 2016-10-7
	 * @param caseNO
	 * @return PubOtherpunish
	 * @throws Exception
	 */
	public PubOtherpunishDto doGetOtherPunishInfo(String caseNO) throws Exception {
		return pubOtherpunishMapper.doGetOtherPunishInfo(caseNO);
	}

	/**
	 * 
	 * 描述: 双告知预警提示行政处罚信息（分页查询）
	 * 
	 * @auther gaojinling
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 */
	public List<PubOtherpunish> selectOtherpunishListByPriPid(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength(), "setDate");
		Example example = new Example(PubOtherpunish.class);
		example.createCriteria().andEqualTo("priPID", request.getParams().get("priPID")).andEqualTo("pubFlag", "1");
		return pubOtherpunishMapper.selectByExample(example);
	}

	/**
	 * 描述: 获取行政处罚信息列表数据（公示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年11月1日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubOtherpunishDto> queryPageForPub(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOtherpunishMapper.selectPubOtherpunishForPub(request.getParams());
	}

	/**
	 * 描述: 根据caseNO获取行政处罚信息详情（公示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年11月1日
	 * @param caseNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubOtherpunishDto doGetPubOtherpunishByCaseNO(String caseNO, String priPID) throws Exception {
		return pubOtherpunishMapper.selectPubOtherpunishByCaseNO(caseNO, priPID);
	}
    /**
     * 
     * 描述: Excel 导入
     * @auther ljx
     * @date 2016年11月24日 
     * @param list
     * @param session
     * @return
     * @throws Exception
     */
	 
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String,String> importByExcel(List<List<Object>> list, HttpSession session) throws Exception {
		int result = 0;
		Map<String,String> resultMap=new HashMap<String,String>();
		
		PubOtherpunish pubOtherpunish = new PubOtherpunish();
		SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		pubOtherpunish.setSetDate(new Date());// 录入时间
		pubOtherpunish.setSetName(sysUser.getRealName());// 录入人
		pubOtherpunish.setSetDeptname(sysUser.getDeptCode());// 录入部门code
		pubOtherpunish.setAuditState("0");// 设置待审核
		pubOtherpunish.setAuditOpin(null);// 审核意见
		pubOtherpunish.setAuditName(null);// 审核人姓名
		pubOtherpunish.setAuditDate(null);// 审核时间
		pubOtherpunish.setPubFlag("0");// 设置未公示
		Example example=new Example(CodeSet.class);
		example.createCriteria().andEqualTo("type", CodeType.CODE_TYPE_PENTYPE);
		/*List<CodeSet> listCode=codeMapper.selectByExample(example);//查询类型
	 
	    Map<String,String> map=new HashMap<String,String>();
		for(CodeSet set:listCode){
	    	map.put(set.getContent(), set.getCode());
	    }*/
		   //处罚类型为模拟,与前端保持一致
		   Map<String,String> map=new HashMap<String,String>();
		   map.put("警告","1");
		   map.put("罚款","2");
		   map.put("没收违法所得和非法财物", "3");
		   map.put("责令停产停业","4");
		   map.put("暂扣许可证", "5");
		   map.put("暂扣执照(登记证)", "6");
		   map.put("吊销许可证", "7");
		   map.put("吊销执照(登记证)","8");
		   map.put("法律、法规规定的其他行政处罚方式", "9");
		   
		   StringBuffer buffer=new StringBuffer();
		
		for (int i = 0; i < list.size(); i++) {
			List<Object> lo = list.get(i);
			MidBaseInfo bas=new MidBaseInfo();
			 if(StringUtils.isEmpty(String.valueOf(lo.get(0)).trim())){//如果注册号为空则不保存
					continue;
				}
	    	bas.setRegNO(String.valueOf(lo.get(0)));
	    	MidBaseInfo baseIfo =getBaseInfoByUniIDOrRegNO(lo.get(0).toString());//查询其主体信息，活动主体id(pirPID)
	    	if(baseIfo==null||baseIfo.getPriPID().equals("")){
	              buffer.append(lo.get(0).toString()).append(",");//不存在的注册号
	    		continue;//跳出不保存
	    	}else{
	    		String caseNO=StringUtil.getRandomNumber(baseIfo.getPriPID()); 
		    	pubOtherpunish.setCaseNO(caseNO);
	    	}
	    	pubOtherpunish.setLeRep(baseIfo.getLeRep());
	    	pubOtherpunish.setPriPID(baseIfo.getPriPID());
	    	if(lo.size()>0){
	    	pubOtherpunish.setRegNO(String.valueOf(lo.get(0)));
	    	}
	    	if(lo.size()>1){
			pubOtherpunish.setEntName(String.valueOf(lo.get(1)));
			}
			if(lo.size()>2){
			pubOtherpunish.setPenDecNo(String.valueOf(lo.get(2)));
			}
			if(lo.size()>3){
			pubOtherpunish.setIllegActType(String.valueOf(lo.get(3)));
		    }
			if(lo.size()>4){
			String typeArray[]=lo.get(4).toString().split(",");
			StringBuffer  penType=new StringBuffer();
			for(String str:typeArray){//循环数组,取到其处罚类型
				penType.append(map.get(str)).append(",");
			}
			
			pubOtherpunish.setPenType(penType.toString().substring(0,penType.length()-1));
			}
			if(lo.size()>5){
			pubOtherpunish.setPenContent(String.valueOf(lo.get(5)));
			}
			if(lo.size()>6){
			pubOtherpunish.setPenDecIssDate(DateUtil.stringToDate(String.valueOf(lo.get(6)), "yyyy-MM-dd"));
			}
			if(lo.size()>7){
			pubOtherpunish.setJudAuth(String.valueOf(lo.get(7)));
			}
			if(lo.size()>8){
			if(StringUtils.isNotEmpty(String.valueOf(lo.get(8)))){
			BigDecimal pen=new BigDecimal(String.valueOf(lo.get(8))); 
			pubOtherpunish.setPenAm(pen);
			}
			}
			if(lo.size()>9){
			if(StringUtils.isNotEmpty(String.valueOf(lo.get(9)))){ 
			BigDecimal fora=new BigDecimal(String.valueOf(lo.get(9))).setScale(4); 
			pubOtherpunish.setForfAm(fora);
			}
			}
		    result=	pubOtherpunishMapper.insertSelective(pubOtherpunish); 
		}
		 resultMap.put("regNO", buffer.toString());
         resultMap.put("result",String.valueOf(result));
		
		return resultMap;
	}
	
	/**
	 * 指定条件查询行政处罚(更新索引)
	 * 
	 * @author zjj
	 */
	@Override
	public List<Map<String, Object>> selectOtherpunishListForIdx(Map<String, Object> qryMap) throws Exception {
		    Map<String,Object> map = new HashMap<String,Object>();
		    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		    List<PubOtherpunish> pubList = pubOtherpunishMapper.selectOtherpunishListForIdx(qryMap);
		    
		    map.put("isCase", "Y");
		    for(PubOtherpunish pubOtherpunish : pubList){
			    map.put("priPID", pubOtherpunish.getPriPID());
			    list.add(map);
			}
		    
		    return list; 
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 * @author ljx
	 */
	@Override
	public MidBaseInfo getBaseInfoByUniIDOrRegNO(String code){
		 Example example=new Example(MidBaseInfo.class);
		 Criteria criteria=  example.createCriteria();
		 criteria.andEqualTo("regNO",code);
		 Criteria criteria2=  example.createCriteria();
		 criteria2.andEqualTo("uniCode",code);
		 example.or(criteria2);
		List<MidBaseInfo> list =midBaseInfoMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
		return list.get(0);
		}else{
			return null;
		}
	}
	
	/** 
	 * 描述: 通过主体代码获取行政处罚信息
	 * @auther yujingwei
	 * @date 2017年2月13日 
	 * @param priPID
	 * @return List<PubOtherpunishDto>
	 * @throws Exception 
	 */
	public List<PubOtherpunishDto> doGetPubOtherPunishList(String regNO,String entName) throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("regNO", regNO);
		qryMap.put("entName", entName);
		return pubOtherpunishMapper.selectPubOtherpunishForPub(qryMap);
	}

	/**
	 * 
	 * 描述   查询工商和其他部门的行政处罚
	 * @author 赵祥江
	 * @date 2017年3月16日 下午4:01:45 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	@Override
	public List<PubOtherpunishDto> selectPubOtherpunishDtoJSON(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOtherpunishMapper.selectPubOtherpunishDto(request.getParams());
	}
	
	/** 
	 * 描述: 处理参数
	 * @auther ZhouYan
	 * @date 2017年8月18日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	private Map<String, Object> handleParamsMap(Map<String, Object> paramsMap) throws Exception{
		if(paramsMap != null){
			if(paramsMap.containsKey("regState")){
				String regState = (String) paramsMap.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
		}
		return paramsMap;
	}

}