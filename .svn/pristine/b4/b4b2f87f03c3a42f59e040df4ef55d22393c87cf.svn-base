/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dtinfo.controller.syn.server;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.base.model.CodeLicense;
import com.icinfo.cs.base.service.ICodeLicenseService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.dtinfo.model.LicDept;
import com.icinfo.cs.dtinfo.model.QzDtinfo;
import com.icinfo.cs.dtinfo.service.ILicDeptService;
import com.icinfo.cs.dtinfo.service.IQzDtinfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.ISysDepartService;

/**
 * 描述:    cs_pub_dtinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({"/qz/pubdtinfo"})
public class QzDtinfoController extends CSBaseController {
	//访问参数验证
	private String  key="3b679f7cf55011e5bb6600188b839ae8";
	
	@Autowired
	private ICodeLicenseService codeLicenseService;
	@Autowired
	private ILicDeptService licDeptService;
	@Autowired
	private ISysDepartService sysDepartService;
	@Autowired
	private IQzDtinfoService qzDtinfoService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	
	
	
	/**
	 * 
	 * 描述   衢州双告知接口
	 * @author 赵祥江
	 * @date 2017年3月29日 下午2:14:40 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/qzpubdtinfo.json")
	@ResponseBody
	public JSONObject qzpubdtinfo(String token,String priPID,String entName,String uniSCID,String regNO,String regOrg,String localAdm,String exaCode) throws Exception {
		JSONObject jsonObj = new JSONObject();
		List<Object> jsonObjList = new ArrayList<Object>(); 
		List<QzDtinfo> qzDtinfoList = new ArrayList<QzDtinfo>();
		StringBuffer sb=new StringBuffer("");
 		try {
			//校验会话的合法性
			if(!key.equals(token)){
				jsonObj.put("errcode", "2");
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				jsonObj.put("msg",URLEncoderEncode("token会话口令验证不通过")); 
				return jsonObj;  
			}
			//校验入参
			this.checkInParm(priPID, entName, regNO, regOrg, localAdm, exaCode, jsonObj);
			if(jsonObj!=null&&jsonObj.containsKey("errcode")&&"2".equals(jsonObj.get("errcode").toString())){
				jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
				return jsonObj; 
			} 
			//截取 
			String[] exaCodeCodeArr=exaCode.trim().split(",");
			List<String> hzApprCodeArrList = new ArrayList<String>();
			//数组转换成LIST
			Collections.addAll(hzApprCodeArrList, exaCodeCodeArr); 
			for(String hzApprCode:hzApprCodeArrList){ 
				  try {
					    //根据审批事项编码获取后置审批信息
						CodeLicense codeLicense=codeLicenseService.selectCodeLicenseByExaCodeAndLicType(hzApprCode, "2");
					    //如果根据审批事项编码没有找到审批事项或审批机关为空 跳出循环不分流
						if(codeLicense==null||"0".equals(codeLicense.getLicDeptType())||StringUtil.isEmpty(codeLicense.getLicZone().trim())){
					    	sb.append("没有找到审批事项编码为【"+hzApprCode+"】的审批事项或审批部门不明确,");
					    	QzDtinfo qzDtinfoTem =new QzDtinfo();
					    	qzDtinfoTem.setUniSCID(uniSCID);
					    	qzDtinfoTem.setRemark(sb.toString());
					    	qzDtinfoTem.setCheckPushType("3");
					    	this.getQzDtinfo(priPID, entName, regNO, regOrg, localAdm, hzApprCode, "3","", qzDtinfoTem);
					    	qzDtinfoService.insertQzDtinfo(qzDtinfoTem);
							continue;
					    }
						//审批事项名称
						String exaName=codeLicense.getExaName();
						//审批部门
						String[] LicDeptArr=codeLicense.getLicDeptType().trim().split(",");
						if(LicDeptArr.length>0){
					    	for(int b=0;b<LicDeptArr.length;b++){
					    		//提示信息
								String msg="";
					    		QzDtinfo qzDtinfo=null;
					    		//审批部门类型   比如A001 A002
				    			String depType=LicDeptArr[b]==null?"":LicDeptArr[b].trim();
				    			//职能部门名称
				    			CodeDutydept codeDutydept =codeDutydeptService.doSelectCodeDutydeptBydeptCode(depType);
				    			String dutyName=codeDutydept==null?"":codeDutydept.getDeptName();
				    			//县
				    			String temOwnership=localAdm.substring(0, 6);
				    			//根据审批事项、行政区划和职能部门编码
				    			List<LicDept> licDeptList=licDeptService.selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(hzApprCode, depType, temOwnership,"1");
				    			if(licDeptList!=null&&licDeptList.size()>0){ 
				    				List<SysDepart> sysDepartList= this.checkDepExist(licDeptList.get(0).getAdCode());
				    				if(sysDepartList.size()>0){
				    					qzDtinfo =new QzDtinfo();
				    					qzDtinfo.setUniSCID(uniSCID);
				    					Map<String, Object> objMap = new HashMap<String, Object>();
					    				//内部序号
				    					objMap.put("priPID", priPID); 
				    					//企业名称
					    				objMap.put("entName",URLEncoderEncode(entName) ); 
					    				//社会信用代码
					    				objMap.put("uniSCID", uniSCID==null?"":uniSCID); 
					    				//注册号
					    				objMap.put("regNO", URLEncoderEncode(regNO) ); 
					    				//登记机关
					    				objMap.put("regOrg", regOrg); 
					    				//管辖单位
					    				objMap.put("localAdm", localAdm); 
					    				//后置审批事项编码
					    				objMap.put("exaCode", hzApprCode); 
					    				//后置审批事项名称
					    				objMap.put("exaName",URLEncoderEncode(exaName) ); 
					    				//审批部门编码
					    				objMap.put("checkDep", licDeptList.get(0).getAdCode());
					    				qzDtinfo.setAdCode(licDeptList.get(0).getAdCode());
					    				//审批部门名称
					    				objMap.put("checkDepName",URLEncoderEncode( sysDepartList.get(0).getOrgName())); 
					    				qzDtinfo.setOrgName(sysDepartList.get(0).getOrgName()); 
					    				this.getQzDtinfo(priPID, entName, regNO, regOrg, localAdm, hzApprCode, "1",exaName, qzDtinfo);
					    				jsonObjList.add(objMap);
					    				qzDtinfoList.add(qzDtinfo); 
				    				}else{
				    					qzDtinfo =new QzDtinfo();
				    					qzDtinfo.setUniSCID(uniSCID);
				    					List<SysDepart>  sysDepartTemList= sysDepartService.doGetSysDepartByAdcode(temOwnership); 
				    					msg="没有找到部门编码为【"+licDeptList.get(0).getAdCode()+"】的审批部门,职能部门名称【"+dutyName+"】,审批事项编码:【"+hzApprCode+"】,请检查部门是否存在;";
				    					if(sysDepartTemList.size()>0){
				    					msg="没有找到"+sysDepartTemList.get(0).getOrgName()+"下属的【"+dutyName+"】,审批部门编码【"+temOwnership+"】,请检查部门是否存在;";
				    					} 
				    					qzDtinfo.setRemark(msg);
				    					sb.append(msg);
				    					this.getQzDtinfo(priPID, entName, regNO, regOrg, localAdm, hzApprCode, "3",exaName, qzDtinfo);
				    					qzDtinfoService.insertQzDtinfo(qzDtinfo);
				    				} 
				    			}else{
				    				qzDtinfo =new QzDtinfo();
				    				qzDtinfo.setUniSCID(uniSCID);
				    				List<SysDepart>  sysDepartTemList= sysDepartService.doGetSysDepartByAdcode(temOwnership);
				    				if(sysDepartTemList.size()>0){
				    					msg="没有找到【"+sysDepartTemList.get(0).getOrgName()+"】下属的【"+dutyName+"】,审批事项编码:【"+hzApprCode+"】请检查审批事项对照维护配置;";
				    				 }else{ 
				    					msg="没有找到部门编码为【"+temOwnership+"】的审批部门,职能部门名称:"+dutyName+"】,审批事项编码【"+hzApprCode+"】,请检查审批事项对照维护配置;";
				    				} 
			    					qzDtinfo.setRemark(msg);
			    					sb.append(msg);
				    				this.getQzDtinfo(priPID, entName, regNO, regOrg, localAdm, hzApprCode, "3",exaName, qzDtinfo);
				    				//插入记录表
				    				qzDtinfoService.insertQzDtinfo(qzDtinfo); 
				    			} 
					    	}
						}
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			} 
			if(qzDtinfoList.size()>0){
				for(QzDtinfo qzDtinfoTem:qzDtinfoList){
			    	qzDtinfoService.insertQzDtinfo(qzDtinfoTem);
			    }
			}
			//成功
			if(jsonObjList!= null && jsonObjList.size()>0){ 
				    String msge="推送成功:本次共推送"+jsonObjList.size()+"条审批数据;";
				    jsonObj.put("errcode", "0"); 
				    jsonObj.put("msg",URLEncoderEncode(msge));
				    jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			        return jsonObj;
     	    }else{ //失败 
				    jsonObj.put("errcode", "1"); 
				    jsonObj.put("msg",URLEncoderEncode(sb.toString()));
				    jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			        return jsonObj;
     	    }
		} catch (Exception e) {//异常
			QzDtinfo qzDtinfo=new QzDtinfo();
			qzDtinfo.setUniSCID(uniSCID);
			e.printStackTrace();
			jsonObj.put("errcode", "1");
			jsonObj.put("msg",URLEncoderEncode("推送失败:"+e.getMessage()));
			jsonObj.put("result",  JSONArray.fromObject(jsonObjList));
			qzDtinfo.setRemark("推送失败:"+e.getMessage());
			this.getQzDtinfo(priPID, entName, regNO, regOrg, localAdm, exaCode, "3",entName, qzDtinfo);
			qzDtinfoService.insertQzDtinfo(qzDtinfo);
			return jsonObj;
		}
	} 
	
	
	
	/**
	 * 
	 * 描述   组装对象
	 * @author 赵祥江
	 * @date 2017年3月29日 下午4:59:53 
	 * @param 
	 * @return QzDtinfo
	 * @throws
	 */
	private QzDtinfo getQzDtinfo(String priPID,String entName,String regNO
			,String regOrg,String localAdm,String exaCode, String checkPushType,String exaName,QzDtinfo qzDtinfo){
		qzDtinfo.setPriPID(priPID);
		qzDtinfo.setEntName(entName);
		qzDtinfo.setRegNO(regNO);
		qzDtinfo.setRegOrg(regOrg);
		qzDtinfo.setLocalAdm(localAdm);
		qzDtinfo.setCheckPushType(checkPushType);
		qzDtinfo.setExaCode(exaCode);
		qzDtinfo.setExaName(exaName);
		//推送日期
		qzDtinfo.setCheckPushDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd"));
		return qzDtinfo;
	}
	
	private JSONObject   checkInParm(String priPID,String entName,String regNO,String regOrg,String localAdm,String exaCode,JSONObject jsonObj)throws Exception {
		try {
			if(StringUtil.isBlank(priPID)) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg",URLEncoderEncode("内部序号不能为空")); 
			}else if(StringUtil.isBlank(entName)) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg", URLEncoderEncode("企业名称不能为空"));
			 
			}else if(StringUtil.isBlank(regNO)) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg",URLEncoderEncode("注册号不能为空"));
				 
			}else if(StringUtil.isBlank(regOrg)) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg",URLEncoderEncode("登记机关不能为空"));
				return jsonObj;
			}else if(StringUtil.isBlank(localAdm)) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg",URLEncoderEncode("管辖单位不能为空"));
				return jsonObj;
			}else if(localAdm.length()<6) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg", URLEncoderEncode("管辖单位编码长度不能小于6"));
				return jsonObj;
			}else if(StringUtil.isBlank(exaCode)) {
				jsonObj.put("errcode", "2");
				jsonObj.put("msg",URLEncoderEncode("后置审批事项编码不能为空"));
				return jsonObj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
 	}
	 
	
	/**
	 * 
	 * 描述   校验部门是否存在
	 * @author 赵祥江
	 * @date 2017年3月29日 下午3:07:44 
	 * @param 
	 * @return List<SysDepart>
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
	 * 描述   将字符串转成GBK编码
	 * @author 赵祥江
	 * @date 2017年3月31日 上午11:11:11 
	 * @param 
	 * @return String
	 * @throws
	 */
	private String  URLEncoderEncode(String cStr ) throws Exception{
		return URLEncoder.encode(cStr, "GBK");
	}
	
	/**
	 * 
	 * 描述   测试
	 * @author 赵祥江
	 * @date 2017年3月31日 下午4:16:08 
	 * @param 
	 * @return void
	 * @throws
	 */
//	public static void main(String[] args) throws Exception { 
//	        Map<String,Object> paramMap = new HashMap<String, Object>();
//	        paramMap.put("token","3b679f7cf55011e5bb6600188b839ae8");
//	        paramMap.put("priPID","3325013000038770");
//	        paramMap.put("entName","丽水市万年石材店");
//	        paramMap.put("regNO","331102660128296");
//	        paramMap.put("regOrg","332501");
//	        paramMap.put("localAdm","33250109");
//	        paramMap.put("exaCode","115");
//	        String paramStr="&"+StringUtil.maptToUrlParam(paramMap,"GBK");
//	        ServiceClient serviceClient = new ServiceClient("qz_pubdtinfo", "admin", "password","59.202.28.96", "59.202.28.96:11211"); 
//	        String result = serviceClient.callRemoteService("qz_pubdtinfo", "method=qzpubdtinfo.json"+paramStr);
//	        System.out.println(result);
//	        serviceClient.close(); 
//	}
	
	
	
	
	
	
}