/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.mapper.pubScSpecialLibraryMapper;
import com.icinfo.cs.drcheck.model.pubScSpecialLibrary;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.mainmark.service.IMainMarkService;
import com.icinfo.cs.registinfo.mapper.RegistMarkMapper;
import com.icinfo.cs.registinfo.model.RegistMark;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scspecial_library 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月19日
 */
@Service
public class pubScSpecialLibraryServiceImpl extends MyBatisServiceSupport implements IpubScSpecialLibraryService {
	
	@Autowired
	pubScSpecialLibraryMapper pubScSpecialLibraryMapper;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	MidBaseInfoMapper midBaseInfoMapper;
	
	@Autowired
	RegistMarkMapper registMarkMapper;
	
	@Autowired
	private IMainMarkService mainMarkService;
	
	/**
	 * 描述: 获取专项检查对象主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    public List<pubScSpecialLibrary> doGetScSpecialLibraryInfo(PageRequest request) throws Exception{
    	PageHelper.startPage(request.getPageNum(), request.getLength());
    	Map<String, Object> qryMap = request.getParams();
    	return pubScSpecialLibraryMapper.selectScSpecialLibraryInfo(getParamInfoMap(qryMap));
    }
    
    /**
     * 描述: 获取专项检查对象主体库数据
     * @auther yujingwei
     * @date 2017年4月19日
     * @param request
     * @return List<pubScSpecialLibrary>
     * @throws Exception
     */
    @Override
    public List<pubScSpecialLibrary> doGetScSpecialLibraryList(PageRequest request) throws Exception {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
    	Map<String, Object> qryMap = request.getParams();
    	return pubScSpecialLibraryMapper.selectScSpecialLibraryList(getParamInfoMap(qryMap));
    }
    
    /**
	 * 描述: 保存专项检查对象主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param pubScSpecialLibrary
	 * @return int
	 * @throws Exception
	 */
    @Transactional(rollbackFor = Exception.class)
	public int doSaveScSpecialInfo(pubScSpecialLibrary scSpecialLibrary,SysUserDto sysUser) throws Exception {
    	int in = 0;
		// 来源为1
    	scSpecialLibrary.setScPtype("1");
		// 默认有效
    	scSpecialLibrary.setIsScVlid("1");
		// 判断库里是否已经存
		int specialInfoId = this.doJudgeIsRepeatLicNOForinsert(scSpecialLibrary);
		if(specialInfoId > 0){
			scSpecialLibrary.setId(specialInfoId);
			scSpecialLibrary.setUid(null);
	    	in = pubScSpecialLibraryMapper.updateByPrimaryKeySelective(scSpecialLibrary);
	    }else{
	    	in = pubScSpecialLibraryMapper.insert(scSpecialLibrary);
	    }
	    // 同步标签库
 		synRegistMark(scSpecialLibrary.getPriPID(), sysUser);
		return in;
	}
    
	/**
	 * 描述: 更新专项检查对象主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param pubScSpecialLibrary
	 * @return int
	 * @throws Exception
	 */
    @Transactional(rollbackFor = Exception.class)
	public int doUpdateScSpecialInfo(pubScSpecialLibrary pubScSpecialLibrary,String uid,SysUserDto sysUser) throws Exception{
    	int in = 0;
	    // 来源为1
		pubScSpecialLibrary.setScPtype("1");
		// 判断库里是否已经存
		Example example = new Example(pubScSpecialLibrary.class);
		if(pubScSpecialLibrary != null && StringUtils.isNotEmpty(pubScSpecialLibrary.getLicNO())){
			example.createCriteria()
		    .andEqualTo("licNO", pubScSpecialLibrary.getLicNO())
		    .andEqualTo("priPID", pubScSpecialLibrary.getPriPID())
			.andEqualTo("specialCode", pubScSpecialLibrary.getSpecialCode())
			.andEqualTo("markCode", pubScSpecialLibrary.getMarkCode())
		    .andNotEqualTo("uid", uid);
		}else{
			example.createCriteria()
			.andEqualTo("priPID", pubScSpecialLibrary.getPriPID())
			.andEqualTo("specialCode", pubScSpecialLibrary.getSpecialCode())
			.andEqualTo("markCode", pubScSpecialLibrary.getMarkCode())
			.andIsNull("licNO")
			.andNotEqualTo("uid", uid);
		}
	    List<pubScSpecialLibrary> pubScSpecialLibraries = pubScSpecialLibraryMapper.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(pubScSpecialLibraries)){
	    	for(pubScSpecialLibrary library : pubScSpecialLibraries){
	    		if(StringUtils.isNotEmpty(library.getUid())){
	    			Example delExample = new Example(pubScSpecialLibrary.class);
	    			delExample.createCriteria().andEqualTo("uid", library.getUid());
	    			pubScSpecialLibraryMapper.deleteByExample(delExample);
	    		}
	    	}
	    }
    	// 更新
		Example upExample = new Example(pubScSpecialLibrary.class);
		upExample.createCriteria().andEqualTo("uid", uid);
		in = pubScSpecialLibraryMapper.updateByExample(pubScSpecialLibrary, upExample);
	    // 同步标签库
		synRegistMark(pubScSpecialLibrary.getPriPID(), sysUser);
		return in;
	}
    
    /**
     * 判断是否重复
     * @author yujingwei
	 * @date 2017-05-10
     * @param specialInfo
     * @return int
     */
	private int doJudgeIsRepeatInfoForInsert(pubScSpecialLibrary specialInfo) {
		Example example = new Example(pubScSpecialLibrary.class);
		Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(specialInfo.getRegNO())){
			criteria.andEqualTo("regNO", specialInfo.getRegNO())
			.andEqualTo("specialCode", specialInfo.getSpecialCode())
			.andEqualTo("markCode", specialInfo.getMarkCode())
			.andIsNull("licNO");
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectByExample(example);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				return pubScSpecialLibraryList.get(0).getId();
			}
		}else{
			criteria.andEqualTo("uniCode", specialInfo.getUniCode())
			.andEqualTo("specialCode", specialInfo.getSpecialCode())
			.andEqualTo("markCode", specialInfo.getMarkCode())
			.andIsNull("licNO");
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectByExample(example);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				return pubScSpecialLibraryList.get(0).getId();
			}
		}
		return 0;
	}
	
	/**
	 * 描述：判断是否许可证编号唯一
	 * @author chenxin
	 * @date 2017-05-10
	 * @param specialInfo
	 * @return int
	 */
	private int doJudgeIsRepeatLicNOForinsert(pubScSpecialLibrary specialInfo) {
		if(StringUtils.isNotEmpty(specialInfo.getLicNO())){
			//许可证不为空则以许可证作为唯一主键
			Example example = new Example(pubScSpecialLibrary.class);
			Criteria criteria = example.createCriteria();
			if(StringUtil.isNotEmpty(specialInfo.getRegNO())){
				criteria.andEqualTo("regNO", specialInfo.getRegNO())
				.andEqualTo("licNO", specialInfo.getLicNO())
				.andEqualTo("specialCode", specialInfo.getSpecialCode())
				.andEqualTo("markCode", specialInfo.getMarkCode());
			}else{
				criteria.andEqualTo("uniCode", specialInfo.getUniCode())
				.andEqualTo("licNO", specialInfo.getLicNO())
				.andEqualTo("specialCode", specialInfo.getSpecialCode())
				.andEqualTo("markCode", specialInfo.getMarkCode());
			}
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectByExample(example);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				return pubScSpecialLibraryList.get(0).getId();
			}
		}
		//许可证不为空则以许可证作为唯一主键
		return doJudgeIsRepeatInfoForInsert(specialInfo);
//		return 0;
	}
	
	
	/**
	 * 描述: 通过uid查询专项检查主体库数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @param uid
	 * @return pubScSpecialLibrary
	 * @throws Exception
	 */
	public pubScSpecialLibrary doGetScSpecialInfoByUid(String uid) throws Exception{
		pubScSpecialLibrary pubScSpecialLibrary = new pubScSpecialLibrary();
		pubScSpecialLibrary.setUid(uid);
		return pubScSpecialLibraryMapper.selectOne(pubScSpecialLibrary);
	}
	
	/**
	 * 描述: 获取专项库树数据
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectToTreeMap(String isCheck) throws Exception{
		return pubScSpecialLibraryMapper.selectScSpecialTreeMap(isCheck);
	}
	
	
	/**
	 * 描述: 专项库数据保存(来源标签)
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return boolean
	 * @param priPID,SpecialCode,ScpType
	 * @throws Exception
	 */
	public boolean doSaveMarkToSpecialLibrary(String priPID,List<String> SpecialCodes,String ScpType) throws Exception{
		if(StringUtil.isEmpty(priPID) || StringUtil.isEmpty(ScpType) || CollectionUtils.isEmpty(SpecialCodes)){
			return false;
		}
		List<pubScSpecialLibrary> spLibraryList = getSpLibraryInfoByPriPIDAndType(priPID,ScpType);
		if(spLibraryList != null && spLibraryList.size() > 0){
			for(pubScSpecialLibrary info : spLibraryList){
				// 失效
				info.setIsScVlid("0");
				pubScSpecialLibraryMapper.updateByPrimaryKeySelective(info);
			}
		}
		for(String specialCode : SpecialCodes){
			List<pubScSpecialLibrary> spLibraryOtherList = getSpLibraryInfoByPriPIDAndCode(priPID,specialCode,null);
			if(spLibraryOtherList !=null && spLibraryOtherList.size() >0){
				pubScSpecialLibrary spInfo = spLibraryOtherList.get(0);
					// 设置有效
					spInfo.setIsScVlid("1");
					pubScSpecialLibraryMapper.updateByPrimaryKeySelective(spInfo);
			}else{
				pubScSpecialLibrary saveInfo = new pubScSpecialLibrary();
				MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(priPID);
				if(baseInfo !=null){
					saveInfo.setEntName(baseInfo.getEntName());
					saveInfo.setUniCode(baseInfo.getUniCode());
					saveInfo.setRegNO(baseInfo.getRegNO());
					saveInfo.setEntType(baseInfo.getEntTypeCatg());
					saveInfo.setPriPID(baseInfo.getPriPID());
					saveInfo.setRegOrg(baseInfo.getRegOrg());
					saveInfo.setRegOrgName(baseInfo.getRegOrgName());
					saveInfo.setLocalAdm(baseInfo.getLocalAdm());
					saveInfo.setLocalAdmName(baseInfo.getLocalAdmName());
					saveInfo.setSliceNO(baseInfo.getSliceNO());
					saveInfo.setSliceNOName(baseInfo.getSliceNOName());
					saveInfo.setRegState(baseInfo.getRegState());
				}
				saveInfo.setScPtype("2");
				saveInfo.setIsScVlid("1");
				saveInfo.setSetTime(new Date());
				saveInfo.setSpecialCode(specialCode);
				saveInfo.setSpecialName(pubScSpecialLibraryMapper.selectSpLibraryByCode(specialCode));
				pubScSpecialLibraryMapper.insert(saveInfo);
			}
		}
		return true;
	}
	
	/**
	 * 描述: 专项库数据保存(来源标签)
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return boolean
	 * @param priPID,SpecialCode,ScpType
	 * @throws Exception
	 */
	public boolean doNewSaveMarkToSpecialLibrary(String priPID,List<RegistMark> registMarks,String ScpType,SysUserDto sysUser) throws Exception{
		if(StringUtil.isEmpty(priPID) || StringUtil.isEmpty(ScpType)){
			return false;
		}
		List<pubScSpecialLibrary> spLibraryList = getSpLibraryInfoByPriPIDAndType(priPID,null);
		if(spLibraryList != null && spLibraryList.size() > 0){
			for(pubScSpecialLibrary info : spLibraryList){
				// 失效
				info.setIsScVlid("0");
				pubScSpecialLibraryMapper.updateByPrimaryKeySelective(info);
			}
		}
		if(registMarks != null && CollectionUtils.isNotEmpty(registMarks)){
			for(RegistMark registMark : registMarks){
				List<pubScSpecialLibrary> spLibraryOtherList = getSpLibraryInfoByPriPIDAndCode(priPID,registMark.getDoublyStoThiCode(),registMark.getIDCode());
				if(spLibraryOtherList !=null && spLibraryOtherList.size() >0){
					for(pubScSpecialLibrary spInfo : spLibraryOtherList){
						// 设置有效
						spInfo.setIsScVlid("1");
						spInfo.setMarkName(registMark.getIDName());
						spInfo.setMarkCode(registMark.getIDCode());
						pubScSpecialLibraryMapper.updateByPrimaryKeySelective(spInfo);
					}
				}else{
					pubScSpecialLibrary saveInfo = new pubScSpecialLibrary();
					MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(priPID);
					if(baseInfo !=null){
						saveInfo.setEntName(baseInfo.getEntName());
						saveInfo.setUniCode(baseInfo.getUniCode());
						saveInfo.setRegNO(baseInfo.getRegNO());
						saveInfo.setEntType(baseInfo.getEntTypeCatg());
						saveInfo.setPriPID(baseInfo.getPriPID());
						saveInfo.setRegOrg(baseInfo.getRegOrg());
						saveInfo.setRegOrgName(baseInfo.getRegOrgName());
						saveInfo.setLocalAdm(baseInfo.getLocalAdm());
						saveInfo.setLocalAdmName(baseInfo.getLocalAdmName());
						saveInfo.setSliceNO(baseInfo.getSliceNO());
						saveInfo.setSliceNOName(baseInfo.getSliceNOName());
						saveInfo.setRegState(baseInfo.getRegState());
					}
					saveInfo.setScPtype("2");
					saveInfo.setIsScVlid("1");
					saveInfo.setSetTime(new Date());
					saveInfo.setSetUserName(sysUser.getRealName());
					saveInfo.setSetUserUid(sysUser.getId());
					saveInfo.setSetDeptcode(sysUser.getDepartMent().getDeptCode());
					saveInfo.setSetDeptName(sysUser.getDepartMent().getDeptName());
					saveInfo.setSpecialCode(registMark.getDoublyStoThiCode());
					saveInfo.setSpecialName(pubScSpecialLibraryMapper.selectSpLibraryByCode(registMark.getDoublyStoThiCode()));
					saveInfo.setMarkName(registMark.getIDName());
					saveInfo.setMarkCode(registMark.getIDCode());
					pubScSpecialLibraryMapper.insert(saveInfo);
				}
			}
		}
		return true;
	}


	/**
	 * 描述: 导入专项库名单
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return Map<String, String>
	 * @param InputStream,sysUser
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> doSaveSpLibraryInfoExcelBatch(InputStream in,SysUserDto sysUser) throws Exception {
		if(in == null || sysUser == null){
			return null;
		}
		StringBuilder strBuff =  new StringBuilder();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = excelTranslateToScLibraryInfo(in,sysUser);
		if(returnMap != null && returnMap.get("spLibraryList") !=null){
			List<pubScSpecialLibrary> spLibrarys = (List<pubScSpecialLibrary>) returnMap.get("spLibraryList");
			if(CollectionUtils.isNotEmpty(spLibrarys)){
				for(pubScSpecialLibrary specialInfo : spLibrarys){
					String taskNO = specialInfo.getRegNO()==null?specialInfo.getUniCode():specialInfo.getRegNO();
					// 获取基本信息
					List<MidBaseInfo> MidBaseInfos = getMidBaseInfoForExcel(specialInfo);
					if(MidBaseInfos !=null && MidBaseInfos.size() !=0){
						MidBaseInfo baseInfo = MidBaseInfos.get(0);
						specialInfo.setEntType(baseInfo.getEntTypeCatg());
						specialInfo.setPriPID(baseInfo.getPriPID());
						specialInfo.setRegOrg(baseInfo.getRegOrg());
						specialInfo.setRegOrgName(baseInfo.getRegOrgName());
						specialInfo.setLocalAdm(baseInfo.getLocalAdm());
						specialInfo.setLocalAdmName(baseInfo.getLocalAdmName());
						specialInfo.setSliceNO(baseInfo.getSliceNO());
						specialInfo.setSliceNOName(baseInfo.getSliceNOName());
						specialInfo.setRegState(baseInfo.getRegState());
						specialInfo.setRegNO(baseInfo.getRegNO());
						specialInfo.setUniCode(baseInfo.getUniCode());
						specialInfo.setEntName(baseInfo.getEntName());
					}else{
						strBuff.append("统一代码/注册号为："+taskNO+"的企业不存在"+'，');
						continue;
					}
					// 来源
					specialInfo.setScPtype("1");
					// 设置有效
					specialInfo.setIsScVlid("1");
					// 是否有许可标志
					if(StringUtil.isNotEmpty(specialInfo.getLicName())){
						specialInfo.setSpecialLicFlag("1");
					}else{
						specialInfo.setSpecialLicFlag("0");
					}
					specialInfo.setSetUserName(sysUser.getRealName());
					specialInfo.setSetTime(new Date());
					specialInfo.setSetDeptName("1".equals(sysUser.getUserType())?sysUser.getDepartMent().getDeptName():sysUser.getSysDepart().getOrgName());
					specialInfo.setSetDeptcode("1".equals(sysUser.getUserType())?sysUser.getDepartMent().getDeptCode():sysUser.getSysDepart().getAdcode());
					specialInfo.setSetUserUid(sysUser.getId());
					//判断是否重复，重复覆盖，否则插入
					int specialInfoId = this.doJudgeIsRepeatLicNO(specialInfo);
					if(specialInfoId > 0){
						specialInfo.setId(specialInfoId);
						pubScSpecialLibraryMapper.updateByPrimaryKeySelective(specialInfo);
					}else{
						pubScSpecialLibraryMapper.insert(specialInfo);
					}
					// 同步标签库
					synRegistMark(specialInfo.getPriPID(), sysUser);
				}
			}
		}
		String errInfo = strBuff.toString();
		String rebackInfo = (String) returnMap.get("errorInfo");
		if(errInfo.length() > 0 && StringUtil.isNotEmpty(errInfo)){
			errInfo = errInfo.substring(0, errInfo.length()-1);
			if(rebackInfo !=null && !rebackInfo.equals("")){
				jsonMap.put("errorInfo", rebackInfo+"，"+errInfo);
			}else{
				jsonMap.put("errorInfo", errInfo);
			}
		}else{
			jsonMap.put("errorInfo",rebackInfo);
		}
		return jsonMap;
	}
	
	/**
	 * 描述：同步标签库
	 * @author chenxin
	 * @date 2017-05-10
	 * @param priPID
	 * @param sysUser
	 * @throws Exception
	 */
	private void synRegistMark(String priPID,SysUserDto sysUser)throws Exception{
		// 绑定标签库
		if(StringUtils.isNotEmpty(priPID) && sysUser != null){
			List<RegistMark>  registMarks = new ArrayList<RegistMark>();
			Example rexample = new Example(pubScSpecialLibrary.class);
			rexample.createCriteria().andEqualTo("priPID", priPID).andEqualTo("isScVlid", "1");
			List<pubScSpecialLibrary> infos = pubScSpecialLibraryMapper.selectByExample(rexample);
			if(infos !=null && infos.size() >0){
				Set<String> set = new HashSet<String>();
				for(pubScSpecialLibrary info : infos){
					if(StringUtils.isNotEmpty(info.getMarkCode())){
						if(set.contains(info.getMarkCode())){
							continue;
						}
						set.add(info.getMarkCode());
						RegistMark registMark = new RegistMark();
						registMark.setIDName(info.getMarkName());
						registMark.setIDCode(info.getMarkCode());
						registMarks.add(registMark);
					}
				}
			}
			mainMarkService.saveOrUpdateForDoublySto(priPID,registMarks,sysUser);
		}
	}

	/**
	 * 描述：解析excel文档
	 * 
	 * @author yujingwei
	 * @date 2017-05-10
	 * @param in
	 * @param sysUser
	 * @return
	 */
	private Map<String, Object> excelTranslateToScLibraryInfo(InputStream in, SysUserDto sysUser) {
		try {
			//解析excel
			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			if (rows < 4) {
				return null;
			}
			StringBuilder strBuff =  new StringBuilder();
			List<pubScSpecialLibrary> ScSpecialLibraryList = new ArrayList<pubScSpecialLibrary>();
			// 遍历处理每行
			for (int i = 3; i < rows; i++) {
				pubScSpecialLibrary pubScSpecialLibrary = new pubScSpecialLibrary();
				Row row = sheet.getRow(i);
				if(row == null){
					continue;
				}
				String specialName = ExcelUtil.getCellContent(row.getCell(0));  //专项库
				if(specialName == null){
					strBuff.append("第"+(i+1)+"行专项库名称不能为空"+"，");
					continue;
				}
				pubScSpecialLibrary.setSpecialName(specialName);
				String specialCode = pubScSpecialLibraryMapper.selectSpLibraryByName(specialName);
				if(StringUtils.isEmpty(specialCode)){
					strBuff.append("第"+(i+1)+"行专项库名称不存在"+"，");
					continue;
				}
				pubScSpecialLibrary.setSpecialCode(specialCode);
				
				String markName = ExcelUtil.getCellContent(row.getCell(1));  //监管标签名称
				if(markName == null){
					strBuff.append("第"+(i+1)+"行对应专项库监管标签名称不能为空"+"，");
					continue;
				}
				pubScSpecialLibrary.setMarkName(markName);
				String markCode = getRegistMarkCodeByName(markName);
				if(StringUtils.isEmpty(markCode)){
					strBuff.append("第"+(i+1)+"行对应专项库监管标签名称不存在"+"，");
					continue;
				}
				pubScSpecialLibrary.setMarkCode(markCode);
				
				String regOrUnicode = com.icinfo.cs.common.utils.ExcelUtil.parseCellValueToString(row.getCell(2));// 注册号或统一代码
				if(regOrUnicode == null){
					strBuff.append("第"+(i+1)+"行统一社会信用代码/注册号不能为空"+"，");
					continue;
				}
				if(regOrUnicode.length() == 18){
					pubScSpecialLibrary.setUniCode(regOrUnicode);
				}else
					pubScSpecialLibrary.setRegNO(regOrUnicode);
				String entName = ExcelUtil.getCellContent(row.getCell(3));// 企业名称不能为空
				pubScSpecialLibrary.setEntName(entName);
				
				String licName = ExcelUtil.getCellContent(row.getCell(4));// 许可证名称
				pubScSpecialLibrary.setLicName(licName);
				
				String licNO = ExcelUtil.getCellContent(row.getCell(5)); // 许可证编号
				pubScSpecialLibrary.setLicNO(licNO);
				
				String licDate = ExcelUtil.getCellContent(row.getCell(6));// 许可批准日期
				pubScSpecialLibrary.setLicApprDate(checkWorkTime(licDate));
				
				String licEndDate = ExcelUtil.getCellContent(row.getCell(7));// 有效期至
				pubScSpecialLibrary.setLicSaveEndDate(checkWorkTime(licEndDate));
				
				String licSendDept = ExcelUtil.getCellContent(row.getCell(8));// 许可证发证机关
				pubScSpecialLibrary.setLicSendDept(licSendDept);
				
				String supervisFlag = ExcelUtil.getCellContent(row.getCell(9));// 是否监管
				if(supervisFlag != null){
					pubScSpecialLibrary.setSuperviseFlag(supervisFlag.equals("是")?"1":"0");
				}
				
				String rightFlag = ExcelUtil.getCellContent(row.getCell(10));// 专业资质资格
				pubScSpecialLibrary.setRightFlag(getRightFlagStr(rightFlag));
				
				String leadFlag = ExcelUtil.getCellContent(row.getCell(11));// 配备专家组长
				pubScSpecialLibrary.setLeadFlag(getLeadFlagStr(leadFlag));
				ScSpecialLibraryList.add(pubScSpecialLibrary);
			}
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("spLibraryList", ScSpecialLibraryList);
		    String errorInfo = strBuff.toString();
		    if(errorInfo.length() > 0 && StringUtil.isNotEmpty(errorInfo)){
		    	returnMap.put("errorInfo",  errorInfo.substring(0, errorInfo.length()-1));
		    }else{
		    	returnMap.put("errorInfo","");
		    }
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
     * 判断是否重复
     * @author yujingwei
	 * @date 2017-05-10
     * @param specialInfo
     * @return int
     */
	private int doJudgeIsRepeatInfo(pubScSpecialLibrary specialInfo) {
		Example example = new Example(pubScSpecialLibrary.class);
		Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(specialInfo.getRegNO())){
			criteria.andEqualTo("regNO", specialInfo.getRegNO())
			.andEqualTo("specialCode", specialInfo.getSpecialCode())
			.andEqualTo("markCode", specialInfo.getMarkCode())
			.andIsNull("licNO");
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectByExample(example);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				return pubScSpecialLibraryList.get(0).getId();
			}
		}else{
			criteria.andEqualTo("uniCode", specialInfo.getUniCode())
			.andEqualTo("specialCode", specialInfo.getSpecialCode())
			.andEqualTo("markCode", specialInfo.getMarkCode())
			.andIsNull("licNO");
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectByExample(example);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				return pubScSpecialLibraryList.get(0).getId();
			}
		}
		return 0;
	}
	
	/**
	 * 描述：判断是否许可证编号唯一
	 * @author chenxin
	 * @date 2017-05-10
	 * @param specialInfo
	 * @return int
	 */
	private int doJudgeIsRepeatLicNO(pubScSpecialLibrary specialInfo) {
		if(StringUtils.isNotEmpty(specialInfo.getLicNO())){
			//许可证不为空则以许可证作为唯一主键
			Example example = new Example(pubScSpecialLibrary.class);
			Criteria criteria = example.createCriteria();
			if(StringUtil.isNotEmpty(specialInfo.getRegNO())){
				criteria.andEqualTo("regNO", specialInfo.getRegNO())
				.andEqualTo("licNO", specialInfo.getLicNO())
				.andEqualTo("specialCode", specialInfo.getSpecialCode())
				.andEqualTo("markCode", specialInfo.getMarkCode());
			}else{
				criteria.andEqualTo("uniCode", specialInfo.getUniCode())
				.andEqualTo("licNO", specialInfo.getLicNO())
				.andEqualTo("specialCode", specialInfo.getSpecialCode())
				.andEqualTo("markCode", specialInfo.getMarkCode());
			}
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectByExample(example);
			if(pubScSpecialLibraryList != null && pubScSpecialLibraryList.size() > 0){
				return pubScSpecialLibraryList.get(0).getId();
			}
		}
		//许可证不为空则以许可证作为唯一主键
		return doJudgeIsRepeatInfo(specialInfo);
	}
	
	/**
     * 通过priPID和来源查询信息
     * @param priPID，scpType
     * @return List<pubScSpecialLibrary>
     */
	private List<pubScSpecialLibrary> getSpLibraryInfoByPriPIDAndType(String priPID, String scpType) {
		Example example = new Example(pubScSpecialLibrary.class);
		if(StringUtils.isNotEmpty(scpType)){
			example.createCriteria()
			.andEqualTo("priPID", priPID)
		    .andEqualTo("scPtype", scpType);
		}else{
			example.createCriteria()
			.andEqualTo("priPID", priPID);
		}
		return pubScSpecialLibraryMapper.selectByExample(example);
	}
	
	
	/**
     * 通过priPID和专项库编码查询信息
     * @param priPID，scpType
     * @return List<pubScSpecialLibrary>
     */
	private List<pubScSpecialLibrary> getSpLibraryInfoByPriPIDAndCode(String priPID, String specialCode,String markCode) {
		Example example = new Example(pubScSpecialLibrary.class);
		example.createCriteria()
		.andEqualTo("priPID", priPID)
	    .andEqualTo("specialCode", specialCode)
	    .andEqualTo("markCode", markCode);
		return pubScSpecialLibraryMapper.selectByExample(example);
	}
	
	/**
     * 通过priPID查询抽查专项库信息（来源不为2，且要有效）
     * @param priPID，scpType
     * @return List<pubScSpecialLibrary>
     */
	public List<pubScSpecialLibrary> getSpLibraryInfoByPriPID(String priPID) throws Exception {
		Example example = new Example(pubScSpecialLibrary.class);
		example.createCriteria()
		.andEqualTo("priPID", priPID).andEqualTo("isScVlid", "1").andNotEqualTo("scPtype", "2");
		return pubScSpecialLibraryMapper.selectByExample(example);
	}
	
	/**
     * 通过监管标签名称查询Code
     * @param markName
     * @return String
     */
    public String getRegistMarkCodeByName(String markName){
    	Example example = new Example(RegistMark.class);
    	example.createCriteria()
    	.andEqualTo("IDName", markName);
    	List<RegistMark> registMarks = registMarkMapper.selectByExample(example);
    	if(registMarks != null && registMarks.size() >0){
    		return registMarks.get(0).getIDCode();
    	}
    	return null;
    }
	
	/**
     * 通过注册号或统一代码获取企业基本信息
     * @param specialInfo
     * @return List<MidBaseInfo>
     */
	private List<MidBaseInfo> getMidBaseInfoForExcel(pubScSpecialLibrary specialInfo) {
		Example example = new Example(MidBaseInfo.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("regNO", specialInfo.getRegNO());
		Criteria criteria2 = example.createCriteria();
		criteria2.andEqualTo("uniCode", specialInfo.getUniCode());
		example.or(criteria2);
		return midBaseInfoMapper.selectByExample(example);
	}
	
	/**
	 * 描述: 获取监管标签树（查询条件）
	 * @auther yujingwei
	 * @date 2017年4月19日
	 * @return boolean
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectToMarkTreeMap() throws Exception{
		return pubScSpecialLibraryMapper.selectMarkTreeMap();
	}
    
	/**
     * 获取配备专家组长（逗号隔开）
     * @param timeStr
     * @return date
     */
	private String getLeadFlagStr(String excelVal) {
		if(StringUtil.isEmpty(excelVal)){
			return "";
		}
		String returnVal = "";
		Map<String, String> qyrMap = new HashMap<String, String>();
		qyrMap.put("无", "N");
		qyrMap.put("保化组长", "1");
		qyrMap.put("药品GSP", "2");
		qyrMap.put("药品GMP", "3");
		qyrMap.put("医疗器械GSP", "4");
		qyrMap.put("医疗器械GMP", "5");
		// 中文逗号转英文
		excelVal = excelVal.replace("，", ",");
		List<String> vals =  Arrays.asList(excelVal.split(","));
		if(vals !=null && vals.size() >0){
			for(String val : vals){
				if(qyrMap.get(val)==null || qyrMap.get(val) == null){
					continue;
				}
				if(StringUtils.isEmpty(returnVal)){
					returnVal = qyrMap.get(val);
				}else{
					returnVal += ',' + qyrMap.get(val);
				}
			}
		}
		if(StringUtils.isEmpty(returnVal)){
			returnVal = "N";
		}
		return returnVal;
	}

	 /**
     * 获取专业资质资格（逗号隔开）
     * @param timeStr
     * @return date
     */
	private String getRightFlagStr(String excelVal) {
		if(StringUtil.isEmpty(excelVal)){
			return "";
		}
		String returnVal = "";
		Map<String, String> qyrMap = new HashMap<String, String>();
		qyrMap.put("无", "N");
		qyrMap.put("保化检查员", "1");
		qyrMap.put("药品检查员", "2");
		qyrMap.put("医疗器械检查员", "3");
		qyrMap.put("特种设备安全监察员", "4");
		// 中文逗号转英文
		excelVal = excelVal.replace("，", ",");
		List<String> vals =  Arrays.asList(excelVal.split(","));
		if(vals !=null && vals.size() >0){
			for(String val : vals){
				if(qyrMap.get(val)==null || qyrMap.get(val) == null){
					continue;
				}
				if(StringUtils.isEmpty(returnVal)){
					returnVal = qyrMap.get(val);
				}else{
					returnVal += ',' + qyrMap.get(val);
				}
			}
		}
		if(StringUtils.isEmpty(returnVal)){
			returnVal = "N";
		}
		return returnVal;
	}
	
	 /**
     * 日期格式转换
     * @param timeStr
     * @return date
     */
    private Date checkWorkTime(String timeStr) {
        if (StringUtil.isBlank(timeStr)) {
            return null;
        }
        try{
        	return DateUtil.stringToDate(timeStr, "yyyy-MM-dd");
        }catch(Exception e){
        	return null;
        }
    }
    
    /**
	 * 描述: 统计专项检查对象主体库
	 * @auther chenxin
	 * @date 2017年4月19日
	 * @param request
	 * @return List<pubScSpecialLibrary>
	 * @throws Exception
	 */
    @Override
    public List<pubScSpecialLibraryDto> selectScSpecialLibraryCount(PageRequest request) throws Exception {
    	Map<String,Object> parmMap=request.getParams();
		if(parmMap != null){
			StringUtil.paramTrim(parmMap);

			if(parmMap.containsKey("startCheckPushDate") && parmMap.containsKey("endCheckPushDate")){
				if(parmMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(parmMap.get("startCheckPushDate").toString())){
					parmMap.put("startCheckPushDate", StringUtil.replace(parmMap.get("startCheckPushDate").toString(), "-", ""));
					parmMap.put("endCheckPushDate", StringUtil.replace(parmMap.get("endCheckPushDate").toString(), "-", ""));
				}else{
					parmMap.put("startCheckPushDate", parmMap.get("rptyear").toString()+parmMap.get("rptbeginmouth").toString());
				}
			}
		    	if(parmMap.get("entType")!=null && !parmMap.get("entType").toString().equals("")){
		    		parmMap.put("entTypes", StringUtil.doSplitStringToSqlFormat(parmMap.get("entType").toString(),","));
		    	}
				PageHelper.startPage(request.getPageNum(), 10000);
				return pubScSpecialLibraryMapper.selectScSpecialLibraryCountByArea(parmMap);
		}
		return new ArrayList<pubScSpecialLibraryDto>();
    }
    
    /**
     * 描述: 查询一家企业涉及的所有检查事项
	 * @auther chenxin
	 * @date 2017年4月19日
     * @param priPID
     * @return
     */
    @Override
    public List<String> selectCheckCodeList(String priPID) {
    	return pubScSpecialLibraryMapper.selectCheckCodeList(priPID);
    }
    
    /**
	 * 描述: 初始化个数统计
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param request
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	public List<pubScSpecialLibraryDto> doGetScSpecialInitTotal(Map<String, Object> qryMap) throws Exception{
		return pubScSpecialLibraryMapper.selectScSpecialInitTotal(getParamInfoMap(qryMap));
	}
	
	/**
	 * 描述: 初始化个数统计(录入)
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param parmMap
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	@Override
	public List<pubScSpecialLibraryDto> doGetScSpecialOptInitTotal(Map<String, Object> parmMap) throws Exception {
		return pubScSpecialLibraryMapper.selectScSpecialOptInitTotal(getParamInfoMap(parmMap));
	}
	
	
	/**
     * 参数处理
     * @param qryMap
     * @return qryMap
     */
	private Map<String, Object> getParamInfoMap(Map<String, Object> qryMap){
    	// 登记状态
    	if(qryMap.get("regState")!=null && !qryMap.get("regState").toString().equals("")){
    		qryMap.put("regStates", qryMap.get("regState").toString().split(","));
    	}
    	// 专项库
    	if(qryMap.get("specialCode")!=null && !qryMap.get("specialCode").toString().equals("")){
    		qryMap.put("specialCodes", qryMap.get("specialCode").toString().split(","));
    	}
    	// 监管标签
    	if(qryMap.get("markCode")!=null && !qryMap.get("markCode").toString().equals("")){
    		qryMap.put("markCodes", qryMap.get("markCode").toString().split(","));
    	}
    	// 专业资质资格
    	if(qryMap.get("rightFlag")!=null && !qryMap.get("rightFlag").toString().equals("")){
    		qryMap.put("rightFlags", qryMap.get("rightFlag").toString().split(","));
    	}
    	// 配备专家组长
    	if(qryMap.get("leadFlag")!=null && !qryMap.get("leadFlag").toString().equals("")){
    		qryMap.put("leadFlags", qryMap.get("leadFlag").toString().split(","));
    	}
    	// 配备专家组长
    	if(qryMap.get("licName")!=null && !qryMap.get("licName").toString().equals("")){
    		qryMap.put("licNames", qryMap.get("licName").toString().split(","));
    	}
    	return qryMap;
	}
	
	/**
	 * 描述: 查询企业的所有专项库
	 * @auther yujingwei
	 * @date 2017年5月31日
	 * @param parmMap
	 * @return List<pubScSpecialLibraryDto> 
	 * @throws Exception
	 */
	@Override
	public List<pubScSpecialLibraryDto> selectPubScSpecialLibrary(Map<String,Object> params) { 
		return pubScSpecialLibraryMapper.selectPubScSpecialLibrary(params);
	}
	
	/**
	 * 描述:统计
	 * @auther chenxin
	 * @date 2017年7月12日
	 * @param params
	 * @throws Exception
	 */
	@Override
	public List<pubScSpecialLibraryDto> selectCountBySpecial(Map<String, Object> params) throws Exception {
		if(params != null){
			params.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return pubScSpecialLibraryMapper.selectCountBySpecial(params);
	}
	
	/**
	 * 描述:查询
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	@Override
	public List<pubScSpecialLibraryDto> selectListBySpecial(Map<String, Object> params) throws Exception {
		if(params != null){
			params.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return pubScSpecialLibraryMapper.selectListBySpecial(params);
	}
	
	/**
	 * 描述:查询某家企业
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	@Override
	public pubScSpecialLibraryDto selectPubScSpeForRandom(Map<String, Object> params) throws Exception {
		if(params != null){
			params.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return pubScSpecialLibraryMapper.selectPubScSpeForRandom(params);
	}
	
	/**
	 * 描述:查询列表企业
	 * @auther chenxin
	 * @date 2017年7月13日
	 * @param params
	 * @throws Exception
	 */
	@Override
	public List<pubScSpecialLibraryDto> selectPubScSpeListForRandom(Map<String, Object> params) throws Exception {
		if(params != null){
			params.put("regState", RegStateEnum.CUNXU.getParam());
		}
		return pubScSpecialLibraryMapper.selectPubScSpeListForRandom(params);
	}
}