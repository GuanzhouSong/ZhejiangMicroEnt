/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.quartz.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.cs.base.service.ICodeDzLicenseService;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.dtinfo.model.PubDtInfo;
import com.icinfo.cs.dzdtinfo.dto.LicDzDeptDto;
import com.icinfo.cs.dzdtinfo.dto.PubDzDtInfoDto;
import com.icinfo.cs.dzdtinfo.model.LicDzDept;
import com.icinfo.cs.dzdtinfo.model.PubDzDtInfo;
import com.icinfo.cs.dzdtinfo.service.ILicDzDeptService;
import com.icinfo.cs.dzdtinfo.service.IPubDzDtInfoService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.quartz.service.IPubDzDtInfoQuartzJobService;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_pub_opadetail 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@Service
public class PubDzDtInfoQuartzJobServiceImpl extends MyBatisServiceSupport implements IPubDzDtInfoQuartzJobService {
	private static final Logger logger = LoggerFactory.getLogger(PubDzDtInfoQuartzJobServiceImpl.class);

	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ISysDepartService sysDepartService;
	@Autowired
	private ICodeDzLicenseService codeLicenseService;
	@Autowired
	private ILicDzDeptService licDeptService;
	@Autowired
	private IPubDzDtInfoService pubDtInfoService;
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	@Autowired
	ICsQuartzJobService csQuartzJobService; 
 
	/**
	 * 
	 * 描述   多证合一定时推送
	 * @author  赵祥江
	 * @date 2017年6月14日 上午11:25:37 
	 * @param  flag推送类型标识 1:根据企业名称推送  2:根据注册号推送3：根据主体身份代码推送 4:全部推送   5：晚上定时推送    priPIDStr 对应推送类型 多个用逗号隔开
	 * @throws
	 */
	@Override
	public String pubDtInfoPush(String flag,String priPIDStr) throws Exception{
		try {
			Map<String,Object> parmMap=new HashMap<String,Object>(); 
			//晚上定时推送 priPIDStr是前端传过来的
			if("5".equals(flag)||"4".equals(flag)){
				if("5".equals(flag)){
					//阻塞任务，防止并发访问数据库
					SleepUtil.threadSleep();
					if(csQuartzJobService.checkJobIsExecute(QuartzJobName.DZDTINFO_JOB.getJobName())){
						return "任务已执行";
					}
					csQuartzJobService.insert(QuartzJobName.DZDTINFO_JOB.getJobName());
					logger.info("多证合一定时任务开始");
				}
				String startDate=getDateBefore(DateUtils.getSysDate(), 15);
				String endDate=DateUtils.getDate();
				parmMap.put("startApprDate", startDate);
				parmMap.put("endApprDate",endDate);
			}else{
				//用逗号打散
				parmMap.put("priPIDStr", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(priPIDStr,","));
			}
			String message=""; 
			//总共推送的条数
			int totalPushCount=0; 
			//当前时间
			//parmMap.put("endApprDate","2015-11-04"); 
			parmMap.put("flag", flag); 
			//七天前的日期
			//parmMap.put("startApprDate", "2009-12-24");
			//获取一周内有审批事项的在册核准数据
			List<MidBaseInfo> midBaseInfoList=midBaseInfoService.selectMidInfoDzByApprDate(parmMap);
			if(midBaseInfoList.size()>0){
				//循环为每一个企业推送消息
				for(MidBaseInfo midBaseInfo:midBaseInfoList){ 
					try { 
						List<PubDzDtInfo> pubDtInfoPushDataList=new ArrayList<PubDzDtInfo>();
	                    //单个企业的审批事项 特殊情况下会有多个
						List<String> hzApprCodeArrList = new ArrayList<String>();
						//新增、变更标识
						boolean isEditFlag=false;
						//注册号
						String regNo=midBaseInfo.getRegNO();
						//主体身份代码
						String priPID=midBaseInfo.getPriPID(); 
						//登记机关编码
						//String regOrg=midBaseInfo.getRegOrg();
						//管辖单位
						String localAdmin=midBaseInfo.getLocalAdm()==null?"000000":midBaseInfo.getLocalAdm().substring(0, 6);
						//企业所属行政区划
						String domDistrict=midBaseInfo.getDomDistrict()==null?"000000":midBaseInfo.getDomDistrict().substring(0, 6);
						//企业所在行政区划
						String yiedistrict=midBaseInfo.getRegOrg()==null?"":midBaseInfo.getRegOrg();
						if(StringUtil.isEmpty(yiedistrict)){
							continue;
						}
						//审批事项编码 多个用逗号隔开
						String hzApprCodeStr=midBaseInfo.getHzApprCode().trim();
						//截取 
						String[] hzApprCodeArr=hzApprCodeStr.split(",");
						//数组转换成LIST
						Collections.addAll(hzApprCodeArrList, hzApprCodeArr); 
						//获取已经推送过的数据
						List<PubDzDtInfo> pubDtInfoList= pubDtInfoService.selectDistinctExaCodeByRegNoAndPriPID(regNo, priPID);
						if(pubDtInfoList.size()>0){
							//如果已经推送过数据则 该标识未true表示变更
							isEditFlag=true; 
							//删除已经推送过的审批事项元素 cs_code_dutydept
							doDeleteRepeatedElement(hzApprCodeArrList,pubDtInfoList);
						}
						if(hzApprCodeArrList.size()>0){
							//1：新设； 2：变更
							String regType=isEditFlag==true?"2":"1";
							for(String hzApprCode:hzApprCodeArrList){ 
								//根据审批事项编码获取后置审批信息
								CodeDzLicense codeLicense=codeLicenseService.selectCodeLicenseByExaCodeAndLicType(hzApprCode, "2");
							    //如果根据审批事项编码没有找到审批事项或审批机关为空 跳出循环不分流
								if(codeLicense==null||"0".equals(codeLicense.getLicDeptType())||StringUtil.isEmpty(codeLicense.getLicZone().trim())){
							    	continue;
							    }
								//存放审批部门编码
								List<String> hzApprCodeList=new ArrayList<String>();
								String exaName=codeLicense.getExaName();
								//审批机关级别 多个用逗号隔开
								String[] licZoneArr=codeLicense.getLicZone().split(",");
								//审批级别最后一个元素的索引 这一步是为了推送最低级别部门审批
								int approvalIndx=licZoneArr.length-1;
							    String[] LicDeptArr=codeLicense.getLicDeptType().trim().split(",");
							    if(LicDeptArr.length>0){
							    	for(int b=0;b<LicDeptArr.length;b++){ 
							    		//审批部门类型   比如A001 A002
						    			String depType=LicDeptArr[b]==null?"":LicDeptArr[b].trim(); 
						    			//县
						    			String temOwnership=yiedistrict.substring(0, 6); 
						    			//截取属地前四位   市
						    			//String temCity=yiedistrict.substring(0, 4)+"00";
						    			//截取属地前2位    省
						    			//String temProvince="330000"; 
						    			//同级
						    			//String temSubordinates=regOrg;
						    			//部门标识 1审批 2属地 3同级 默认审批
						    			String spFlag="3";
						    			PubDzDtInfo pubDtInfo=new PubDzDtInfo(); 
						    			//推送审批部门  审批机关为国家级或省级 审批机关只推送省级
						    			/*if("0".equals(licZoneArr[approvalIndx])||"1".equals(licZoneArr[approvalIndx])){
						    				//校验部门是否存在 如果存在推送状态为自动推送  如果不存在推送状态为推送失败 
						    				this.doSetDtInfoListVal(hzApprCodeList, pubDtInfo, pubDtInfoPushDataList, midBaseInfo, hzApprCode, exaName, regType, temProvince, spFlag,depType);
						    			}else if("2".equals(licZoneArr[approvalIndx])){//市级 
						    				this.doSetDtInfoListVal(hzApprCodeList, pubDtInfo, pubDtInfoPushDataList, midBaseInfo, hzApprCode, exaName, regType, temCity, spFlag,depType);
						    			}else if("3".equals(licZoneArr[approvalIndx])){//县级
*/						    			this.doSetDtInfoListVal(hzApprCodeList, pubDtInfo, pubDtInfoPushDataList, midBaseInfo, hzApprCode, exaName, regType, temOwnership, spFlag,depType);
						    			//}
						    			//获取是否推送标识
						    			//String licDeptType=getlicDeptTypeByHzApprCodeAndDeptCode(hzApprCode,"0");
						    			//推送属地  默认不推送  是否推送属地标识 1 不推送 2 推送
						    			/*if("2".equals(licDeptType)) {//如果配置了推送属地就推送属地
						    				PubDtInfo pubDtInfoSd=new PubDtInfo();
						    				spFlag="2";
						    				this.doSetDtInfoListVal(hzApprCodeList, pubDtInfoSd, pubDtInfoPushDataList, midBaseInfo, hzApprCode, exaName, regType, temOwnership, spFlag,depType);
	 					    			} */
						    			//是否推送同级 1是 0 否
						    			/*String isSameGov=getlicDeptTypeByHzApprCodeAndDeptCode(hzApprCode,"1");
						    			if("1".equals(isSameGov)){
						    				//推送同级部门
	 					    				PubDtInfo pubDtInfoTj=new PubDtInfo();
	 					    				spFlag="3"; 
	 					    				this.doSetDtInfoListVal(hzApprCodeList, pubDtInfoTj, pubDtInfoPushDataList, midBaseInfo, hzApprCode, exaName, regType, temSubordinates, spFlag,depType);
	 						    		} */
							    	}
							    } 
							} 
						}
						if(pubDtInfoPushDataList.size()>0){
							pubDtInfoService.insertBatchPubDtinfo(pubDtInfoPushDataList);
							totalPushCount+=pubDtInfoPushDataList.size(); 
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("企业名称:"+midBaseInfo.getEntName()+",注册号:"+midBaseInfo.getRegNO()+"推送失败", e);
						continue;
					}
				}
				message="多证合一分流定时任务结束:总共推送了【"+totalPushCount+"】条记录";
				logger.info(message);
			}else{
				//message="没有找到核准日期自"+startDate+"至"+endDate+"新增/变更的核准数据多证合一分流定时任务结束";
				logger.info(message);
			}
			return message;
		} catch (Exception e) {
			 e.printStackTrace();
			 logger.error("多证合一定时任务执行失败", e);
			 throw new BusinessException(e.getCause().getMessage(),e);
		}
	}
	
	
	 
	/**
	 * 
	 * 描述   删除已经推送过的审批事项元素
	 * @author 赵祥江
	 * @date 2016年10月24日 下午12:15:44 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void  doDeleteRepeatedElement(List<String> appConPptArrList,List<PubDzDtInfo> pubDtInfoList)throws Exception{
		for(int a=0;a<appConPptArrList.size();a++){
			for(PubDzDtInfo dtInfo:pubDtInfoList){
				 //如果是同一个审批事项已经推送过了 就不用再推送了
				 if(appConPptArrList.get(a).equals(dtInfo.getExaCode())){
					 appConPptArrList.remove(a);
					 a--;
					 break;
				 }
			 }
		} 
	} 
	
	 
	
	/**
	 * 
	 * 描述   根据审批事项编码获取是否推送标识
	 * @author 赵祥江
	 * @date 2017年1月12日 下午2:11:55 
	 * @param 
	 * @return String
	 * @throws
	 */
	public String getlicDeptTypeByHzApprCodeAndDeptCode(String hzApprCode,String isFlag){
		//是否推送属地、同级标识 
		String licDeptType="";
		//有效标识 1 标识有效
		String isValid="1";
		try { 
			PageRequest request=new PageRequest();
			Map<String,Object> queryMap=new HashMap<String,Object>();
			queryMap.put("exaCode", hzApprCode);
			queryMap.put("isValid", isValid);
			request.setLength(1);
			request.setParams(queryMap);
			List<LicDzDeptDto> licDeptDtoList=licDeptService.queryLicDeptListJSON(request);
		    if(licDeptDtoList.size()>0&&StringUtil.isNotEmpty(licDeptDtoList.get(0).getLicDeptType())){
		    	if("0".equals(isFlag)){
		    		licDeptType=licDeptDtoList.get(0).getLicDeptType();
		    	}else{
		    		licDeptType=licDeptDtoList.get(0).getIsSameGov();
		    	} 
		    } 
		} catch (Exception e) {
			e.printStackTrace(); 
			logger.error("", e);
			return licDeptType;
		} 
		return licDeptType;
	}
	
	
	/**
	 * 
	 * 描述   组装多证合一主表数据并把数据加入保存的结果集List：如果是审批部门先检索审批部门对照表 如果检索到则审批部门推送成功否则推送失败，
	 * 同级和属地只有该部门存在才推送否则不推送
	 * @author 赵祥江
	 * @date 2016年10月24日 下午5:41:26 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void doSetDtInfoListVal(List<String> hzApprCodeList,
			PubDzDtInfo pubDtInfo, List<PubDzDtInfo> pubDtInfoPushDataList,
			MidBaseInfo midBaseInfo, String exaCode, String exaName,
			String checkRegType, String deptCode,String spFlag,String depType) throws Exception {  
		//根据职能编码查询职能部门
		CodeDutydept codeDutydept=codeDutydeptService.doSelectCodeDutydeptBydeptCode(depType); 
		//职能部门名称
		String dutyDeptName=codeDutydept==null?"":codeDutydept.getDeptName(); 
		//区县名称
		String areaName="";
		//分流失败原因;
		String msg="";
		//组装多证合一主表数据对象
		this.setPubDtInfoVal(midBaseInfo, pubDtInfo,exaCode,exaName,checkRegType,deptCode,spFlag);
		//审批部门
		if("3".equals(spFlag)){
			//根据审批事项、行政区划和职能部门编码
			List<LicDzDept> licDeptList=licDeptService.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(exaCode, depType, deptCode,"1");
			if(licDeptList!=null&&licDeptList.size()>0){
				//对应审批部门
				String deptCodeTem=licDeptList.get(0).getDeptCode();
				//对应审批部门名称
				String deptNameTem=licDeptList.get(0).getDeptName();
				//实际审批部门编码
				String adCode=licDeptList.get(0).getAdCode();
				//实际审批部门名称
				String orgName=licDeptList.get(0).getOrgName(); 
				//校验部门是否存在
				List<SysDepart> sysDepartListTem=checkDepExist(adCode); 
				if(sysDepartListTem!=null&&sysDepartListTem.size()>0){
					//推送成功
					pubDtInfo.setCheckPushType("1");
					//实际审批部门名称
					pubDtInfo.setCheckDepName(orgName);
				    //实际审批部门编码
					pubDtInfo.setCheckDep(adCode); 
					//对应审批部门编码
					pubDtInfo.setDeptCode(deptCodeTem);
					//对应审批部门名称
					pubDtInfo.setDeptName(deptNameTem);
					String areaCodeT=adCode.substring(0, 6);  
					areaName=getAreaName(areaCodeT); 
					//取实际审批部门的只能部门和编码  如果没有找到取对应审批部门
					//List<DeptDutycodeRef> deptDutycodeRefListTem= deptDutycodeRefService.selectDeptDutycodeRefByAdCode(adCode);
					/*if(deptDutycodeRefListTem!=null&&deptDutycodeRefListTem.size()>0){
						pubDtInfo.setDutyDeptName(deptDutycodeRefListTem.get(0).getDutyDeptName()); 
						pubDtInfo.setDutyDeptCode(deptDutycodeRefListTem.get(0).getDutyDeptCode());
					}else{*/
						pubDtInfo.setDutyDeptName(dutyDeptName); 
						pubDtInfo.setDutyDeptCode(depType);
					//}
				}else{	//没有找到实际审批部门
					areaName=getAreaName(deptCode);
					msg="没有找到部门【编码:"+deptCode+"】与职能部门【编码:"+depType+",职能部门名称:"+dutyDeptName+"】的对应关系,请在部门维护功能检查配置或联系系统管理员";
					if(StringUtil.isNotEmpty(areaName)){
					msg="没有找到"+areaName+"下属的"+dutyDeptName+"与职能部门的对应关系或该部门不存在,备案部门编码【"+deptCode+"】,【职能部门编码:"+depType+",职能部门名称:"+dutyDeptName+"】,请在部门维护功能检查配置或联系系统管理员";
					} 
					pubDtInfo.setReassignRemark(msg);
					pubDtInfo.setCheckPushType("3"); 
				}
			}else{//没有找到审批对照部门
				//根据编码获取区县名称 
				areaName=getAreaName(deptCode);
				msg="没有找到对应的备案部门【编码:"+deptCode+"】,【职能编码:"+depType+",职能部门名称:"+dutyDeptName+"】,请在部门对照维护功能检查配置或联系系统管理员";
				if(StringUtil.isNotEmpty(areaName)){
					msg="没有找到"+areaName+"下属的【"+dutyDeptName+"】,备案部门编码【"+deptCode+"】,【职能部门编码:"+depType+",职能部门名称:"+dutyDeptName+"】,请在部门对照维护功能检查配置或联系系统管理员";
				}
				pubDtInfo.setReassignRemark(msg);
			    pubDtInfo.setCheckPushType("3"); 
			}  
  			if(!hzApprCodeList.contains(pubDtInfo.getCheckDep())){
  				//如果没有分流成功取对应审批部门的只能编码和名称
  				if(!"1".equals(pubDtInfo.getCheckPushType())){
  					pubDtInfo.setDutyDeptCode(depType); 
  	  				pubDtInfo.setDutyDeptName(dutyDeptName); 
  	  				pubDtInfo.setCheckDep(deptCode);
  	  				pubDtInfo.setDeptCode(deptCode);
  				} 
  				pubDtInfo.setAreaName(areaName);
				pubDtInfoPushDataList.add(pubDtInfo);
  				hzApprCodeList.add(pubDtInfo.getCheckDep()); 
  			}
		}else{ //属地和同级
			//根据编码的前九位数和职能部门编码获取部门对应关系数据
			List<DeptDutycodeRef> deptDutycodeRefList=checkDutycodeRefExist(deptCode, depType);
			if(deptDutycodeRefList!=null&&deptDutycodeRefList.size()>0){
				pubDtInfo.setCheckPushType("1"); 
				pubDtInfo.setCheckDepName(deptDutycodeRefList.get(0).getOrgName());
				pubDtInfo.setCheckDep(deptDutycodeRefList.get(0).getAdCode());
				pubDtInfo.setDutyDeptCode(depType);
				pubDtInfo.setDutyDeptName(deptDutycodeRefList.get(0).getDutyDeptName());
				pubDtInfo.setAreaName(getAreaName(pubDtInfo.getCheckDep().substring(0, 6)));
				if(!hzApprCodeList.contains(pubDtInfo.getCheckDep())){ 
					pubDtInfoPushDataList.add(pubDtInfo);
					hzApprCodeList.add(pubDtInfo.getCheckDep()); 
	  			}
			} 
		} 
	}
	
	/**
	 * 
	 * 描述   根据行政区划获取行政区划名称
	 * @author 赵祥江
	 * @date 2017年1月12日 上午11:38:39 
	 * @param 
	 * @return String
	 * @throws
	 */
	private String getAreaName(String codeTem) throws Exception{
		String areaName = "";
		// 省级
		if ("330000".equals(codeTem)) {
			areaName = "省政府";
		} else {
			// 根据编码获取区县名称
			List<SysDepart> sysDepartList = sysDepartService
					.doGetSysDepartByAdcode(codeTem);
			if (sysDepartList != null && sysDepartList.size() > 0) {
				areaName = sysDepartList.get(0).getOrgName();
			}
		}
		return areaName;
	}
	
	/**
	 * 
	 * 描述   根据职能编码和部门编码
	 * @author 赵祥江
	 * @date 2017年1月12日 上午10:37:02 
	 * @param 
	 * @return List<DeptDutycodeRef>
	 * @throws
	 */
	public List<DeptDutycodeRef> checkDutycodeRefExist(String adcode,String depType){
		try {  
			return deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(adcode, depType);
		} catch (Exception e) { 
			e.printStackTrace();
			logger.error("", e);
		}
		return null;
	} 
	
 
	
	/**
	 * 
	 * 描述   获取部门编码+主体身份代码+审批事项代码拼接的字符串
	 * @author 赵祥江
	 * @date 2016年12月29日 下午11:18:43 
	 * @param 
	 * @return String
	 * @throws
	 */
	public String getDeptStr(PubDtInfo pubDtInfo){
		return pubDtInfo.getCheckDep()+pubDtInfo.getPriPID()+pubDtInfo.getExaCode(); 
	}
	
	
	/**
	 * 
	 * 描述   组装多证合一主表对象
	 * @author 赵祥江
	 * @date 2016年10月24日 下午2:48:37 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void setPubDtInfoVal(MidBaseInfo midBaseInfo, PubDzDtInfo pubDtInfo,
			String exaCode, String exaName, String checkRegType,
			String deptCode, String spFlag) {
		//身份主体代码
		pubDtInfo.setPriPID(midBaseInfo.getPriPID());
		//统一信用代码
		pubDtInfo.setUniSCID(midBaseInfo.getUniCode());
		//企业名称
		pubDtInfo.setEntName(midBaseInfo.getEntName());
		//注册号
		pubDtInfo.setRegNO(midBaseInfo.getRegNO());
		//法定代表人
		pubDtInfo.setLeRep(midBaseInfo.getLeRep());
		//法定代表人联系电话
		pubDtInfo.setTel(midBaseInfo.getTel());
		//成立日期
		pubDtInfo.setEstDate(midBaseInfo.getEstDate());
		//注册资本
		pubDtInfo.setRegCap(midBaseInfo.getRegCap());
		//住所
		pubDtInfo.setDom(midBaseInfo.getDom());
		//营业期限自
		pubDtInfo.setOpFrom(midBaseInfo.getOpFrom());
		//营业期限至
		pubDtInfo.setOpTo(midBaseInfo.getOpTo());
		//经营范围
		pubDtInfo.setOpScope(midBaseInfo.getOpScope());
		//核准日期
		pubDtInfo.setApprDate(midBaseInfo.getApprDate());
		//登记机关
		pubDtInfo.setRegOrg(midBaseInfo.getRegOrg());
		//属地监管工商所
		pubDtInfo.setLocalAdm(midBaseInfo.getLocalAdm());
		//住所地行政区划
		pubDtInfo.setDomDistrict(midBaseInfo.getDomDistrict());
		//街道
		pubDtInfo.setStreet(midBaseInfo.getStreet());
		//登记状态
		pubDtInfo.setRegState(midBaseInfo.getRegState());
		//推送机关编码
		pubDtInfo.setCheckDep(deptCode);
		//企业大类
		pubDtInfo.setEntTypeCatg(midBaseInfo.getEntTypeCatg());
		//企业小类
		pubDtInfo.setEntType(midBaseInfo.getEntType());
		//地区
		pubDtInfo.setArea(midBaseInfo.getArea());
		//企业登记事项
		pubDtInfo.setCheckRegType(checkRegType);
		//推送日期
		pubDtInfo.setCheckPushDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd")); 
		//接收标识 
		pubDtInfo.setReceiveState("0");
		//认领标识
		pubDtInfo.setClaimState("0");
		//个转企标识
		pubDtInfo.setIsIndivid(midBaseInfo.getIsIndivid());
		//行业代码
		pubDtInfo.setIndustryCo(midBaseInfo.getIndustryCo());
		//审批事项编码
		pubDtInfo.setExaCode(exaCode);
		//审批事项名称
		pubDtInfo.setExaName(exaName);
		//审批机关类型
		pubDtInfo.setCheckDeptType(spFlag);
		//终止标识
		pubDtInfo.setCheckStopState("0");
		//时间戳
		pubDtInfo.setCreateTime(DateUtils.getSysDate());
	}
	
	
	
	
	
	
	/**
	 * 
	 * 描述   根据部门编码和职能编码校验是否配置有部门与职能的关系表
	 * @author 赵祥江
	 * @date 2016年11月22日 下午5:09:37 
	 * @param 
	 * @return DeptDutycodeRef
	 * @throws
	 */
	private  List<SysDepart> checkDepExist(String adcode)throws Exception {
		try {
			return sysDepartService.doGetSysDepartByAdcode(adcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 	}
	

	/**
	 * 
	 * 描述   获取N天前的日期
	 * @author 赵祥江
	 * @date 2016年10月25日 下午3:11:44 
	 * @param 
	 * @return String
	 * @throws
	 */
   private  String getDateBefore(Date d, int N) {  
       Calendar now = Calendar.getInstance();  
       now.setTime(d);  
       now.set(Calendar.DATE, now.get(Calendar.DATE) -N); 
       return    DateUtils.formatDate(now.getTime(), "yyyy-MM-dd");  
   }



   /**
	 * 
	 * 描述   提取推送失败的分流数据重新分流
	 * @author 赵祥江
	 * @date 2016年12月27日 上午11:15:52 
	 * @param 
	 * @return String
	 * @throws
	 */
	@Override
	public String pubFailPush() throws Exception {
		logger.info("提取推送失败的分流数据重新分流开始");
		int totalfailPushCount=0;
		int totalsusPushCount=0;
		String infoMsg="";
		String errMsg=",发生系统错误的主体身份代码为:";
		PageRequest request=new PageRequest();
		Map<String,Object> qMap=new HashMap<String,Object>();
		qMap.put("checkPushType","3");
		request.setPageNum(0);
		request.setLength(9999999);
		request.setParams(qMap);
		//获取推送失败的企业数据
		List<PubDzDtInfoDto> pubDtInfoDtoList= pubDtInfoService .queryPubdtinfoFailReBackListJSON(request);
		if(pubDtInfoDtoList!=null&&pubDtInfoDtoList.size()>0){ 
			for(PubDzDtInfoDto pubDtInfoDto:pubDtInfoDtoList){
				try {
					//主键ID
					String uId=pubDtInfoDto.getUid()==null||"".equals(pubDtInfoDto.getUid())?"00000":pubDtInfoDto.getUid();
					PubDzDtInfo pubDtInfo=new PubDzDtInfo(); 
					PubDzDtInfo pubDtInfo1=pubDtInfoService.selectPubDtInfoByUID(uId);
					//后置审批事项编码
					String exaCode=pubDtInfo1.getExaCode();
					//职能部门编码
					String dutyDeptCode=pubDtInfo1.getDutyDeptCode()==null||"".equals(pubDtInfo1.getDutyDeptCode())?"00000":pubDtInfo1.getDutyDeptCode();
					//职能部门名称
					String dutyDeptName="";
					//部门编码
					String deptCode=pubDtInfo1.getCheckDep();
					//失败原因
					String msg="";
					//区县名称
					String areaName=""; 
					MidBaseInfo midBaseInfo=this.midBaseInfoService.selectByPripid(pubDtInfo1.getPriPID());
					if(midBaseInfo!=null){
						deptCode=midBaseInfo.getYiedistrict().substring(0, 6);
					}else{
						deptCode=deptCode.substring(0, 6);
					}
					//根据职能部门编码获取职能部门对象
					CodeDutydept codeDutydept=this.codeDutydeptService.doSelectCodeDutydeptBydeptCode(dutyDeptCode);
					//职能部门名称
					dutyDeptName=codeDutydept==null?"":codeDutydept.getDeptName();
					pubDtInfo.setUid(uId); 
					//根据审批事项、行政区划和职能部门编码
					List<LicDzDept> licDeptList=licDeptService.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(exaCode, dutyDeptCode, deptCode,"1");
					if(licDeptList!=null&&licDeptList.size()>0){
						//对应审批部门
						String deptCodeTem=licDeptList.get(0).getDeptCode();
						//对应审批部门名称
						String deptNameTem=licDeptList.get(0).getDeptName();
						//实际审批部门编码
						String adCode=licDeptList.get(0).getAdCode();
						//实际审批部门名称
						String orgName=licDeptList.get(0).getOrgName(); 
						//校验部门是否存在
						List<SysDepart> sysDepartListTem=checkDepExist(adCode);
						if(sysDepartListTem!=null&&sysDepartListTem.size()>0){
							pubDtInfo.setReassignRemark("");
							//推送成功
							pubDtInfo.setCheckPushType("1");
							//实际审批部门名称
							pubDtInfo.setCheckDepName(orgName);
						    //实际审批部门编码
							pubDtInfo.setCheckDep(adCode); 
							//对应审批部门编码
							pubDtInfo.setDeptCode(deptCodeTem);
							//对应审批部门名称
							pubDtInfo.setDeptName(deptNameTem); 
							areaName=this.getAreaName(adCode.substring(0, 6));
							totalsusPushCount++;
						}else{
							areaName=this.getAreaName(deptCode);
							msg="没有找到部门【编码:"+deptCode+"】与职能部门【编码:"+dutyDeptCode+",职能部门名称:"+codeDutydept.getDeptName()+"】的对应关系,请在部门维护功能检查配置或联系系统管理员";
							if(StringUtil.isNotEmpty(areaName)){
							msg="没有找到"+areaName+"下属的"+dutyDeptName+"与职能部门的对应关系或该部门不存在,审批部门编码【"+deptCode+"】,【职能部门编码:"+dutyDeptCode+",职能部门名称:"+dutyDeptName+"】,请在部门维护功能检查配置或联系系统管理员";
							} 
							pubDtInfo.setReassignRemark(msg);
							pubDtInfo.setCheckPushType("3");
							pubDtInfo.setCheckDep(deptCode);
							totalfailPushCount++;
						}
					}else{
						areaName=this.getAreaName(deptCode);
						msg="没有找到对应的审批部门【编码:"+deptCode+"】,【职能编码:"+dutyDeptCode+",职能部门名称:"+dutyDeptName+"】,请在审批对照维护功能检查配置或联系系统管理员";
						if(StringUtil.isNotEmpty(areaName)){
							msg="没有找到"+areaName+"下属的【"+dutyDeptName+"】,审批部门编码【"+deptCode+"】,【职能部门编码:"+dutyDeptCode+",职能部门名称:"+dutyDeptName+"】,请在审批对照维护功能检查配置或联系系统管理员";
						}
						pubDtInfo.setReassignRemark(msg);
					    pubDtInfo.setCheckPushType("3");
					    pubDtInfo.setCheckDep(deptCode);
					    totalfailPushCount++;
					} 
					pubDtInfo.setAreaName(areaName);
					pubDtInfo.setCheckPushDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd"));
					pubDtInfoService.updatePubDtInfoByUID(pubDtInfo); 
				} catch (Exception e) {
					e.printStackTrace();
					errMsg+=pubDtInfoDto.getPriPID()+"错误信息:"+e.getCause().getMessage();
					logger.error(errMsg, e);
					continue;
				} 
			} 
			infoMsg="提取推送失败的分流数据重新分流结束:总共推送了【"+pubDtInfoDtoList.size()+"】条记录,推送成功:"+totalsusPushCount+"条，推送失败："+totalfailPushCount+"条";
			if(errMsg.length()>16){
				infoMsg+=errMsg;
			}
			logger.info(infoMsg);
		} 
		return infoMsg;
 	} 
}