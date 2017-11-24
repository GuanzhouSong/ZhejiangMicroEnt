/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dtinfo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.model.CodeLicense;
import com.icinfo.cs.base.service.ICodeLicenseService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.dtinfo.dto.LicDeptDto;
import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.dtinfo.mapper.LicDeptMapper;
import com.icinfo.cs.dtinfo.model.LicDept;
import com.icinfo.cs.dtinfo.model.PubDtInfo;
import com.icinfo.cs.dtinfo.service.ILicDeptService;
import com.icinfo.cs.dtinfo.service.IPubDtInfoService;
import com.icinfo.cs.system.dto.DeptTree;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUserCheckRecord;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysUserCheckRecordService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_lic_dept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Service
public class LicDeptServiceImpl extends MyBatisServiceSupport implements ILicDeptService {

	private static final Logger logger = LoggerFactory.getLogger(LicDeptServiceImpl.class);

	@Autowired
	private LicDeptMapper licDeptMapper;
	@Autowired
	private ICodeLicenseService codeLicenseService;
	@Autowired
	private ISysDepartService sysDepartService;
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;
	@Autowired
	private ISysUserCheckRecordService sysUserCheckRecordService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	@Autowired
	private IPubDtInfoService pubDtInfoService;
	
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2016年10月19日 上午10:59:47 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int insertLicDept(LicDept licDept) throws Exception {
		try {
			if(licDept!=null)
			{
				licDept.setCreateTime(DateUtils.getSysDate());
				return licDeptMapper.insert(licDept);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "保存失败");
            throw new BusinessException("保存失败");
		}
	}

	/**
	 * 
	 * 描述   根据审批事项部门和部门编码和有效标识查询
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:02:51 
	 * @param 
	 * @return LicDept
	 * @throws
	 */
	@Override
	public LicDept selectLicDeptByExaCodeAndDeptCode(String exaCode,
			String deptCode,String dutyDeptCode, String isValid) throws Exception {
		try {
			if(StringUtil.isNotEmpty(exaCode)&&StringUtil.isNotEmpty(deptCode)&&StringUtil.isNotEmpty(isValid))
			{
				LicDept licDept=new LicDept();
				licDept.setExaCode(exaCode);
				licDept.setDeptCode(deptCode);
				licDept.setIsValid(isValid);
				licDept.setDutyDeptCode(dutyDeptCode);
				return licDeptMapper.selectOne(licDept);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批事项部门和部门编码和有效标识查询失败");
            throw new BusinessException("根据审批事项部门和部门编码和有效标识查询失败");
		}
	}

	/**
	 * 
	 * 描述   根据审批事项部门和部门编码查询
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:02:51 
	 * @param 
	 * @return LicDept
	 * @throws
	 */
	@Override
	public List<LicDept> selectLicDeptByExaCodeAndDeptCodeAndDutyDeptCode(String exaCode,
			String deptCode,String dutyDeptCode) throws Exception {
		try {
			if(StringUtil.isNotEmpty(exaCode)&&StringUtil.isNotEmpty(deptCode))
			{
				LicDept licDept=new LicDept();
				licDept.setExaCode(exaCode);
				licDept.setDeptCode(deptCode);
				licDept.setDutyDeptCode(dutyDeptCode);
 				return licDeptMapper.select(licDept);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批事项部门和部门编码查询失败");
            throw new BusinessException("根据审批事项部门和部门编码失败");
		}
	}

	/**
	 * 
	 * 描述   根据审批事项编码和部门编码删除
	 * @author  赵祥江
	 * @date 2016年10月19日 上午11:15:21 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteLicDeptByExaCodeAndDeptCode(String exaCode, String deptCode)
			throws Exception {
		try {
 			if(StringUtil.isNotEmpty(exaCode)&&StringUtil.isNotEmpty(deptCode)){
 				LicDept licDept=new LicDept();
				licDept.setExaCode(exaCode);
				licDept.setDeptCode(deptCode); 
				return licDeptMapper.delete(licDept);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批事项编码和部门编码删除失败");
            throw new BusinessException("根据审批事项编码和部门编码删除失败");
		}
	}

	/**
	 * 
	 * 描述   分页查询审批部门对照
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:29:00 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	@Override
	public List<LicDeptDto> queryLicDeptListJSON(PageRequest request)
			throws Exception { 
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> queryMap= request.getParams();
		return licDeptMapper.selectLicDeptListJSON(queryMap);
	}

	@Override
	public List<LicDeptDto> queryLicDeptByAdCode(String adCode)throws Exception{
		Map<String,Object> queryMap= new HashMap<String,Object>();
		queryMap.put("deptCode",adCode);
		return licDeptMapper.selectLicDeptListJSON(queryMap);
	}

	/**
	 * 
	 * 描述   根据审批事项编码修改是否推送的值（licDeptType）
	 * @author 赵祥江
	 * @date 2016年10月19日 下午7:31:05 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int updateLicDeptByExaCode(String exaCode, String licDeptType,String flag) {
		try {
 			if(StringUtil.isNotEmpty(exaCode)&&StringUtil.isNotEmpty(licDeptType)){
 				LicDept licDept=new LicDept();
 				if("0".equals(flag)){
 					licDept.setLicDeptType(licDeptType);
 				}else{
 					licDept.setIsSameGov(licDeptType);
 				} 
				Example example = new Example(LicDept.class);
				example.createCriteria().andEqualTo("exaCode", exaCode); 
 				return licDeptMapper.updateByExampleSelective(licDept, example);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批事项编码和部门编码删除失败");
            throw new BusinessException("根据审批事项编码和部门编码删除失败");
		}
	}

	/**
	 * 
	 * 描述   根据审批事项编码和部门编码修改
	 * @author 赵祥江
	 * @date 2016年11月3日 下午1:50:49 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int updateLicDeptByExaCodeAndDeptCode(LicDept licDept) {
		try {
 			if(licDept!=null&&StringUtil.isNotEmpty(licDept.getExaCode())&&StringUtil.isNotEmpty(licDept.getDeptCode())){
 				licDept.setCreateTime(DateUtils.getSysDate());
				Example example = new Example(LicDept.class);
				example.createCriteria()
				.andEqualTo("exaCode", licDept.getExaCode())
				.andEqualTo("dutyDeptCode", licDept.getDutyDeptCode())
				.andEqualTo("deptCode", licDept.getDeptCode()); 
 				return licDeptMapper.updateByExampleSelective(licDept, example);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据审批事项编码和部门编码修改");
            throw new BusinessException("根据审批事项编码和部门编码修改");
		}
	}

	/**
	 * 
	 * 描述   根据审批部门级别自动生成个县市审批对照数据
	 * @author 赵祥江
	 * @date 2016年11月3日 下午1:41:52 
	 * @param 
	 * @return void
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void executeLicDeptDataByLicZone() throws Exception { 
		try {
			logger.info("生成审批事项对照表数据开始");
			 //存储省级部门的MAP
			 Map<String,Object>  temProvince=new HashMap<String,Object>();
			 //存储市级部门的MAP
			 Map<String,Object>  temCity=new HashMap<String,Object>();
			 //存储县级部门的MAP
			 Map<String,Object>  temOwer=new HashMap<String,Object>();
			 //查询adCode不重复且其长度为13 包含M编码的部门结果集 
			 List<DeptDutycodeRef> deptDutycodeRefList= deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(null, null);
			 for(DeptDutycodeRef deptDutycodeRef:deptDutycodeRefList){
				 if(StringUtil.isEmpty(deptDutycodeRef.getDutyDeptCode())){
					 continue;
				 }
				 String deptCode=deptDutycodeRef.getAdCode().substring(0, 6);
				 //去掉前四位
				 String  temtadCity=deptCode.substring(4,deptCode.length());
 				 //省
				 if("330000".equals(deptCode)){ 
					 temProvince.put(deptCode+"000"+deptDutycodeRef.getDutyDeptCode(), deptDutycodeRef);
				 }else if("00".equals(temtadCity)){//市
					 temCity.put(deptCode+"000"+deptDutycodeRef.getDutyDeptCode(), deptDutycodeRef);
				 }else{//县
					 temOwer.put(deptDutycodeRef.getAdCode()+"_"+deptDutycodeRef.getDutyDeptCode(), deptDutycodeRef);
				 }
			 }
			 
			 List<CodeLicense> codeLicenseList= codeLicenseService.selectCodeLicenseListByLicType("2");
			 int count =0;
			 String exaCodeStr="";
			 for(CodeLicense codeLicense:codeLicenseList){ 
				 try {
					 if("0".equals(codeLicense.getLicDeptType())||StringUtil.isEmpty(codeLicense.getLicDeptType())){
							continue; 
					  }
					 String exaCode=codeLicense.getExaCode();
					 String[] licZoneArr= codeLicense.getLicZone().split(",");
					 String[] licDeptTypeArr= codeLicense.getLicDeptType().split(",");
					 List<DeptDutycodeRef> deptDutycodeRefListTem=null;
					 for(int a=0;a<licZoneArr.length;a++){ 
						//审批部门 国家级或省级
						 if("0".equals(licZoneArr[a])||"1".equals(licZoneArr[a])){
							 for(int b=0;b<licDeptTypeArr.length;b++){ 
								 deptDutycodeRefListTem =deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode("330000000", licDeptTypeArr[b]);
								 if(deptDutycodeRefListTem!=null&&deptDutycodeRefListTem.size()>0){
									 for(DeptDutycodeRef deptDutycodeRefTem:deptDutycodeRefListTem){
										 LicDept licDept=null; 
										//如果已经有了就不再新增
									     List<LicDept> LicDeptList=this.selectLicDeptByExaCodeAndDeptCodeAndDutyDeptCode(exaCode, deptDutycodeRefTem.getAdCode(),licDeptTypeArr[b]); 
										 if(LicDeptList==null||LicDeptList.size()==0){
											 licDept=getLicDept(deptDutycodeRefTem, exaCode);
											 licDept.setAdCode(licDept.getDeptCode());
											 licDept.setOrgName(licDept.getDeptName());
											 licDept.setYiedistrict("330000");
											 licDept.setAreaName("省本级");
											 this.insertLicDept(licDept);
									     }
									 }
								 }
							 }
						 }else if("2".equals(licZoneArr[a])){//市级
							 for(int c=0;c<licDeptTypeArr.length;c++){
								 List<String> cityLevelList=doGetCityLevelCodes();
								 for(String cityLeveCode:cityLevelList){
	 								 deptDutycodeRefListTem =deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(cityLeveCode+"000", licDeptTypeArr[c]);
	 								 if(deptDutycodeRefListTem!=null&&deptDutycodeRefListTem.size()>0){
	 									 for(DeptDutycodeRef deptDutycodeRefTem:deptDutycodeRefListTem){
	 										LicDept licDept=getLicDept(deptDutycodeRefTem, exaCode); 
	 										//如果已经有了就不再新增
	 									     List<LicDept> LicDeptList=this.selectLicDeptByExaCodeAndDeptCodeAndDutyDeptCode(exaCode, deptDutycodeRefTem.getAdCode(),licDeptTypeArr[c]); 
	 										 if(LicDeptList==null||LicDeptList.size()==0){
	 											 licDept.setAdCode(licDept.getDeptCode());
												 licDept.setOrgName(licDept.getDeptName());
												 licDept.setYiedistrict(licDept.getDeptCode().substring(0, 6));
												 List<SysDepart> sysDepartList= this.sysDepartService.doGetSysDepartByAdcode(licDept.getDeptCode().substring(0, 6));
												 licDept.setAreaName(sysDepartList==null||sysDepartList.size()==0?"":sysDepartList.get(0).getOrgName());
	 											 this.insertLicDept(licDept);
	 									     }
	 									 }
	 								 }
								 }
							 }
						 }else if("3".equals(licZoneArr[a])){//县级
							 //循环为每一个县找对应的部门
							 for(int d=0;d<licDeptTypeArr.length;d++){
								 Iterator i=temOwer.entrySet().iterator();
								 while(i.hasNext()){
									 Map.Entry e=(Map.Entry)i.next();
									 String deptKey=e.getKey().toString();
									 if(deptKey.indexOf(licDeptTypeArr[d])>0){
										 DeptDutycodeRef deptDutycodeRefOwer=(DeptDutycodeRef) temOwer.get(deptKey);
										 LicDept licDept=getLicDept(deptDutycodeRefOwer, exaCode); 
										 List<LicDept> LicDeptList=this.selectLicDeptByExaCodeAndDeptCodeAndDutyDeptCode(exaCode, deptDutycodeRefOwer.getAdCode(),licDeptTypeArr[d]);
										 if(LicDeptList==null||LicDeptList.size()==0){ 
											 licDept.setAdCode(licDept.getDeptCode());
											 licDept.setOrgName(licDept.getDeptName());
											 licDept.setYiedistrict(licDept.getDeptCode().substring(0, 6));
											 List<SysDepart> sysDepartList= this.sysDepartService.doGetSysDepartByAdcode(licDept.getDeptCode().substring(0, 6));
											 licDept.setAreaName(sysDepartList==null||sysDepartList.size()==0?"":sysDepartList.get(0).getOrgName());
 											 this.insertLicDept(licDept);
										 }
									 } 
								}
							 } 
						 }
					 }
					 count++;
					 System.out.println(count);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("第"+count+"条失败");
					exaCodeStr+=codeLicense.getExaCode()+",";
					continue;
				}
			 }
			  if(exaCodeStr.length()>0){
				  logger.info("生成数据失败的后置审批事项编码为:"+exaCodeStr);
 			  }
			  logger.info("生成审批事项对照表数据结束"); 
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void  updateLicDeptData() throws Exception{
		List<LicDeptDto> licDeptDtoList=	this.queryLicDeptByAdCode(null);
		for(LicDeptDto licDeptDto: licDeptDtoList){
			LicDept licDept=new LicDept();
			 String sCode=licDeptDto.getDeptCode().substring(0, 6);
			 licDept.setYiedistrict(sCode);
			 licDept.setUid(licDeptDto.getUid());
			 if("330000".equals(sCode)){
				 licDept.setAreaName("省本级");
			 }else{
				 List<SysDepart> sysDepartList=sysDepartService.doGetSysDepartByAdcode(sCode);
				 if(sysDepartList!=null&&sysDepartList.size()>0){
					 licDept.setAreaName(sysDepartList.get(0).getOrgName());
				 } 
			 }
 			 this.updateLicDeptByUid(licDept);
		}
	}
	
	/**
	 * 
	 * 描述   设置审批对照对象的值
	 * @author 赵祥江
	 * @date 2016年11月3日 下午2:46:30 
	 * @param 
	 * @return void
	 * @throws
	 */
	public LicDept getLicDept(DeptDutycodeRef deptDutycodeRefTem,String exaCode){
		 LicDept licDept=new LicDept();
		 licDept.setExaCode(exaCode);
		 licDept.setDeptCode(deptDutycodeRefTem.getAdCode());
		 licDept.setDeptName(deptDutycodeRefTem.getOrgName());
		 licDept.setIsValid("1");
		 licDept.setLicDeptType("1");
		 if(deptDutycodeRefTem.getOrgCoding()!=null&&"1".equals(deptDutycodeRefTem.getOrgCoding())){
			 licDept.setSetName("部门采集");
		 }else{
			 licDept.setSetName("系统自动");
		 }
		 licDept.setSetTime(DateUtils.getSysDate());
		 licDept.setCreateTime(DateUtils.getSysDate());
		 licDept.setDutyDeptCode(deptDutycodeRefTem.getDutyDeptCode());
		 licDept.setDutyDeptName(deptDutycodeRefTem.getDutyDeptName());
		 return licDept;
	}
	
	 
	/**
	 * 
	 * 描述   获取市级编码
	 * @author 赵祥江
	 * @date 2016年11月3日 下午2:48:19 
	 * @param 
	 * @return List<String>
	 * @throws
	 */
	private List<String> doGetCityLevelCodes(){
		List<String> cityLevelList=new ArrayList<String>();
		//杭州市
		cityLevelList.add("330100");
		//宁波
		cityLevelList.add("330200");
		//温州
		cityLevelList.add("330300");
		//嘉兴
		cityLevelList.add("330400");
		//湖州
		cityLevelList.add("330500");
		//绍兴
		cityLevelList.add("330600");
		//金华
		cityLevelList.add("330700");
		//衢州
		cityLevelList.add("330800");
		//舟山
		cityLevelList.add("330900");
		//台州
		cityLevelList.add("331000");
		//丽水
		cityLevelList.add("332500"); 
		return cityLevelList;
	}

	/**
	 * 
	 * 描述   根据部门采集表生成审批对照数据
	 * @author 赵祥江
	 * @date 2016年12月22日 下午7:55:28 
	 * @param 
	 * @return void
	 * @throws
	 */
	@Override
	public void executeLicDeptByUserCheckRecord() throws Exception {
		try {
			List<SysUserCheckRecord> sysUserCheckRecordList=sysUserCheckRecordService.selectAllSysUserCheckRecord();
		    if(sysUserCheckRecordList!=null&&sysUserCheckRecordList.size()>0){
		    	for(SysUserCheckRecord sysUserCheckRecord:sysUserCheckRecordList){
		    		//部门编码
		    		String adCode=sysUserCheckRecord.getAdcode();
		    		if(StringUtil.isEmpty(adCode)){
		    			continue;
		    		}
		    		if(StringUtil.isNotEmpty(sysUserCheckRecord.getLicItems())&&StringUtil.isNotEmpty(sysUserCheckRecord.getDutyCodes())){
		    			//审批事项编码数组
		    			String[] licItemsArr=sysUserCheckRecord.getLicItems().split(",");
			    		//职能编码数组
		    			String[] dutyCodesArr =sysUserCheckRecord.getDutyCodes().split(",");
			    		for(int a=0;a<licItemsArr.length;a++){
 			    			 //后置审批事项编码
			    	         String exaCode=licItemsArr[a];
			    			 for(int b=0;b<dutyCodesArr.length;b++){
			    			 //职能部门编码
			    			 String dutyCode=dutyCodesArr[b];
			    			 DeptDutycodeRef deptDutycodeRef=new DeptDutycodeRef();
							 deptDutycodeRef.setAdCode(adCode);
							 deptDutycodeRef.setDutyDeptCode(dutyCode);
							 deptDutycodeRef.setOrgName(sysUserCheckRecord.getDeptShortName());
							 CodeDutydept codeDutydept=codeDutydeptService.doSelectCodeDutydeptBydeptCode(dutyCode);
							 deptDutycodeRef.setDutyDeptName(codeDutydept==null?"":codeDutydept.getDeptName());
							 deptDutycodeRef.setOrgCoding("1");
			    			 List<LicDept> LicDeptList=this.selectLicDeptByExaCodeAndDeptCodeAndDutyDeptCode(exaCode,adCode ,dutyCode);
							 if(LicDeptList==null||LicDeptList.size()==0){ 
 								 this.insertLicDept(this.getLicDept(deptDutycodeRef, exaCode));
							 }else{ 
								 this.updateLicDeptByExaCodeAndDeptCode(this.getLicDept(deptDutycodeRef, exaCode));
							 }
			    		  }
			    		}
			    		
			    		
		    		}
		    		
		    		
		    	}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年1月10日 下午8:47:22 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int deleteLicDeptByUid(String uid) throws Exception {
		LicDept licDept =new LicDept();
		if(StringUtil.isNotEmpty(uid)){
		   licDept.setUid(uid);
		   return	licDeptMapper.delete(licDept);
		} 
		return 0;
	}
	
	/**
	 * 
	 * 描述   根据审批事项编码、职能部门编码、行政区划删除
	 * @author  赵祥江
	 * @date 2017年1月16日 上午8:35:27 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteByExaCodeAnDutyDeptCodeAndYiedistrict(String exaCode,String dutyDeptCode,String yiedistrict) throws Exception {
		LicDept licDept =new LicDept();
		if(StringUtil.isNotEmpty(exaCode)&&StringUtil.isNotEmpty(dutyDeptCode)&&StringUtil.isNotEmpty(yiedistrict)){
		   licDept.setExaCode(exaCode);
		   licDept.setDutyDeptCode(dutyDeptCode);
		   licDept.setYiedistrict(yiedistrict);
		   return	licDeptMapper.delete(licDept);
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   根据uid查询
	 * @author  赵祥江
	 * @date 2017年1月11日 下午2:53:05 
	 * @param  
	 * @throws
	 */
	@Override
	public List<LicDept> selectLicDeptByUid(String uid) throws Exception {
		LicDept licDept =new LicDept();
		if(StringUtil.isNotEmpty(uid)){
		   licDept.setUid(uid);
		   return licDeptMapper.select(licDept);
		} 
		return null;
	}

	/**
	 * 
	 * 描述   根据uid修改
	 * @author  赵祥江
	 * @date 2017年1月11日 下午2:56:53 
	 * @param  
	 * @throws
	 */
	@Override
	public int updateLicDeptByUid(LicDept licDept) {
		if(licDept!=null&&StringUtil.isNotEmpty(licDept.getUid())){
			licDept.setCreateTime(DateUtils.getSysDate());
			Example example = new Example(LicDept.class);
			example.createCriteria().andEqualTo("uid", licDept.getUid()); 
			return licDeptMapper.updateByExampleSelective(licDept, example);
		}
		return 0;
	}

	/**
	 * 
	 * 描述   根据行政区划、审批事项和职能编码查询
	 * @author  赵祥江
	 * @date 2017年1月11日 下午6:22:03 
	 * @param  
	 * @throws 
	 */
	@Override
	public List<LicDept> selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(
			String exaCode, String dutyDeptCode, String yiedistrict,String isValid)
			throws Exception {
		LicDept licDept =new LicDept();
		licDept.setExaCode(exaCode);
		licDept.setDutyDeptCode(dutyDeptCode);
		licDept.setYiedistrict(yiedistrict); 
		licDept.setIsValid(isValid);
		return licDeptMapper.select(licDept);
	}
	
	
	
	
	
	/**
	 * 
	 * 描述   数据下放 省级下放市县级
	 * @author 赵祥江
	 * @date 2017年4月14日 下午4:28:11 
	 * @param 
	 * @return void
	 * @throws
	 */
	@Override
	public void transferExaCode(String exaCodeStr,String checkDep,String yFlag,String istransferFlag) throws Exception{
		try { 
			System.out.println("执行开始");
			Map<String,Object> qryMapT=new HashMap<>();
			qryMapT.put("330905", "");
			qryMapT.put("330906", "");
			qryMapT.put("330907", "");
			qryMapT.put("330908", "");
			qryMapT.put("330402", "");
			Map<String,Object> qryMap=new HashMap<>();
			CodeLicense codeLicense=codeLicenseService.selectCodeLicenseByExaCodeAndLicType(exaCodeStr, "2");
			String[] licTypeArr=codeLicense.getLicDeptType().split(",");
			List<DeptTree> sysDepartList=sysDepartService.deptTreeCtity(qryMap); 
			if(licTypeArr.length>0){
				for(int i=0;i<licTypeArr.length;i++){
					String licType=licTypeArr[i];
					 for(DeptTree deptTree: sysDepartList){
						 String adCode=deptTree.getAdcode();
						 if(deptTree.getAdcode().length()==6){
							 if(qryMapT.containsKey(adCode)){
								 continue;
							 }
							 System.out.println("--------------------"+adCode+"-----------------------");
							 List<LicDept>  licDeptList= this.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(exaCodeStr, licType, adCode,"1");
							 if(licDeptList.size()>0){
								 for(LicDept licDept:licDeptList){
									 List<DeptDutycodeRef> deptDutycodeRefList=null;
									 if("1".equals(yFlag)){
										//下放市局
									     deptDutycodeRefList= deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(adCode.substring(0, 4)+"00000", licType);
									 }else{
										 deptDutycodeRefList=  deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(adCode+"000", licType);
									     //如果没有找市局
										 if(deptDutycodeRefList.size()==0){
									    	 deptDutycodeRefList=  deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(adCode.substring(0, 4)+"00000", licType);
									     }
									 }
									 if(deptDutycodeRefList.size()>0){
								    	 licDept.setAdCode(deptDutycodeRefList.get(0).getAdCode());
								    	 licDept.setOrgName(deptDutycodeRefList.get(0).getOrgName());
								    	 List<SysDepart> sysDepart= sysDepartService.doGetSysDepartByAdcode(adCode);
								    	 licDept.setAreaName(sysDepart.size()==0?"":sysDepart.get(0).getOrgName());
								    	 this.updateLicDeptByUid(licDept);
								    	 //下放省直属机关和省登记推送数据
								    	 if("1".equals(istransferFlag)){
								    		 List<PubDtInfoDto> pubDtInfoDtoList= pubDtInfoService.selectTransferPubdtinfoList(checkDep, exaCodeStr, "330000,330010");
									    	 if(pubDtInfoDtoList.size()>0){
									    		 for(PubDtInfoDto pubDtInfoDto:pubDtInfoDtoList){
									    			 PubDtInfo pubDtInfo=new PubDtInfo();
									    			 String domDistrict=pubDtInfoDto.getDomDistrict();
									    			 if(com.icinfo.cs.common.utils.StringUtil.isBlank(domDistrict)){
									    				 pubDtInfo.setCheckPushType("3");
									    			 }else{
									    				 domDistrict=domDistrict.substring(0, 6);
									    				 List<LicDept>  licDeptListT= this.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(exaCodeStr, licType, domDistrict,"1");
										    			 if(licDeptListT.size()>0){
										    				 pubDtInfo.setCheckDep(licDeptListT.get(0).getAdCode());
										    				 pubDtInfo.setCheckPushType("1");
										    				 List<SysDepart> sysDepart_t= sysDepartService.doGetSysDepartByAdcode(licDeptListT.get(0).getAdCode());
											    			 pubDtInfo.setCheckDepName(sysDepart_t.size()==0?"":sysDepart_t.get(0).getOrgName());
											    			 sysDepart_t= sysDepartService.doGetSysDepartByAdcode(domDistrict);
											    			 pubDtInfo.setAreaName(sysDepart_t.size()==0?"":sysDepart_t.get(0).getOrgName());
										    			 }else{
										    				 pubDtInfo.setCheckPushType("3");
										    			 }
									    			 }
									    			 pubDtInfo.setUid(pubDtInfoDto.getUid()); 
									    			 pubDtInfo.setCheckPushDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd")); 
									    			 pubDtInfoService.updatePubDtInfoByUID(pubDtInfo);
									    		 }
									    	 }
								    	 }
								    	 
								    	 List<PubDtInfoDto> pubDtInfoDtoList= pubDtInfoService.selectTransferPubdtinfoList(checkDep, exaCodeStr, adCode);
								    	 if(pubDtInfoDtoList.size()>0){
								    		 for(PubDtInfoDto pubDtInfoDto:pubDtInfoDtoList){
								    			 PubDtInfo pubDtInfo=new PubDtInfo();
								    			 pubDtInfo.setUid(pubDtInfoDto.getUid());
								    			 pubDtInfo.setCheckDep(deptDutycodeRefList.get(0).getAdCode());
								    			 List<SysDepart> sysDepart_t= sysDepartService.doGetSysDepartByAdcode(deptDutycodeRefList.get(0).getAdCode());
								    			 pubDtInfo.setCheckDepName(sysDepart_t.size()==0?"":sysDepart_t.get(0).getOrgName());
								    			 sysDepart_t= sysDepartService.doGetSysDepartByAdcode(adCode);
								    			 pubDtInfo.setAreaName(sysDepart_t.size()==0?"":sysDepart_t.get(0).getOrgName());
								    			 pubDtInfo.setCheckPushDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd"));
								    			 pubDtInfo.setCheckPushType("1");
								    			 pubDtInfoService.updatePubDtInfoByUID(pubDtInfo);
								    		 }
								    	 }
								     }
								 }
							 }
						 }
					 }
				}
			}
			System.out.println("执行结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}