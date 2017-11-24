/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.DeptPubInfoRptDto;
import com.icinfo.cs.rpt.rptmodel.RptAnnounceMentInfo;
import com.icinfo.cs.rpt.rptservice.IDeptPubInfoRptService;
import com.icinfo.cs.rpt.rptservice.IRptAnnounceMentInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 
 * 描述:  信用信息公示情况
 * @author: 赵祥江
 * @date: 2017年8月15日 下午3:07:44
 */
@Controller
@RequestMapping("/reg/server/echartspubsituationrpt" )
public class EchartsPubSituationRptController extends CSBaseController  {
	 private static final Logger logger =LoggerFactory.getLogger(EchartsPubSituationRptController.class);
	 @Autowired
	 private IDeptPubInfoRptService deptPubInfoRptService; 
	 @Autowired
	 private IRptAnnounceMentInfoService rptAnnounceMentInfoService;
	 
	 /**
	  * 
	  * 描述   获取系统公示主体总数
	  * @author 赵祥江
	  * @date 2017年8月15日 下午3:26:34 
	  * @param 
	  * @return AjaxResult
	  * @throws
	  */
	@RequestMapping(value = "/getPubEntRegStateKTotal")
	@ResponseBody
	public AjaxResult getPubEntRegStateKTotal(PageRequest request) throws Exception {
		try { 
			Map<String,Object> qMap=request.getParams();
			qMap.put("statLevel", "pubtotal");
			qMap.put("monthCode", DateUtil.getDate ("yyyyMMdd")); 
			String[] normalStrArr={"0","0","0","0","0","0","0","0"};
			if(qMap.containsKey("areaCode")&&StringUtil.isNotBlank(qMap.get("areaCode").toString())){
				List<DeptPubInfoRptDto> deptPubInfoRptDtoList=deptPubInfoRptService.selectDeptPubInfoSituationRpt(qMap);
				if(deptPubInfoRptDtoList.size()>0){
					String normalStr=deptPubInfoRptDtoList.get(0).getPublicInfo().toString();
					if(normalStr.length()<8){
						String zero="";
						int a= 8-normalStr.length();
						while(normalStr.length()<8){
							zero+="0";
							if(a==zero.length()){
								break;
							}
						}
						normalStr=zero+normalStr;
					} 
					for(int i=0;i<normalStr.length();i++){ 
						String tStr=normalStr.substring(i, i+1); 
						normalStrArr[i]=tStr; 
					}
				}
			} 
			return AjaxResult.success("获取系统公示主体总数成功", normalStrArr); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取系统公示主体总数失败!", e);
		} 
		return AjaxResult.error("获取系统公示主体总数失败!");
	} 
	
	 
	/**
	 * 
	 * 描述   企业信用信息公示概览
	 * @author 赵祥江
	 * @date 2017年8月15日 下午3:30:45 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getPubEntSituation")
	@ResponseBody
	public AjaxResult getPubEntSituation(PageRequest request) throws Exception {
		try {  
			Integer regstatek=0;
			Integer regstatexx=0;
			Integer regstated=0;
			Integer regstatec=0;
			Integer regstateq=0;
			Integer publicinfo=0;
			Map<String,Object> qMap=request.getParams();
			if(qMap.containsKey("areaCode")&&StringUtil.isNotBlank(qMap.get("areaCode").toString())){
				qMap.put("statLevel", "pubregstate");
				qMap.put("areaCode", qMap.get("areaCode").toString()); 
				qMap.put("monthCode", DateUtil.getDate ("yyyyMMdd")); 
				List<DeptPubInfoRptDto> deptPubInfoRptDtoList=deptPubInfoRptService.selectDeptPubInfoSituationRpt(qMap);
			    if(deptPubInfoRptDtoList.size()>0){
			    	regstatek=deptPubInfoRptDtoList.get(0).getRegstateK();
			    	regstatexx=deptPubInfoRptDtoList.get(0).getRegstateXX();
			    	regstated=deptPubInfoRptDtoList.get(0).getRegstateD();
			    	regstatec=deptPubInfoRptDtoList.get(0).getRegstateC();
			    	regstateq=deptPubInfoRptDtoList.get(0).getRegstateQ();
			    	publicinfo=deptPubInfoRptDtoList.get(0).getPublicInfo(); 
			    }
			    //存续
				qMap.put("cunxu", regstatek);
				//注销
				qMap.put("zhuxiao", regstatexx);
				//吊销
				qMap.put("diaoxiao", regstated);
				//撤销
				qMap.put("chexiao", regstatec);
				//迁出
				qMap.put("qianchu", regstateq); 
				//总数
				qMap.put("total", publicinfo);
				return AjaxResult.success("获取企业信用信息公示概览成功", qMap); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取企业信用信息公示概览失败!", e);
		} 
		return AjaxResult.error("获取企业信用信息公示概览失败!");
	} 
	
	
	/**
	 * 
	 * 描述   企业信用信息公示
	 * @author 赵祥江
	 * @date 2017年8月15日 下午4:05:25 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getPubEntSituationInfo")
	@ResponseBody
	public AjaxResult getPubEntSituationInfo(PageRequest request) throws Exception {
		try { 
			JSONObject jSONObjectyztotal=new JSONObject();
			Map<String,Object> qMap=request.getParams(); 
			if(qMap.containsKey("areaCode")&&StringUtil.isNotBlank(qMap.get("areaCode").toString())){
				qMap.put("statLevel", "pubinfo");
				qMap.put("areaCode", qMap.get("areaCode").toString()); 
				qMap.put("monthCode", DateUtil.getDate ("yyyyMMdd")); 
				List<DeptPubInfoRptDto> deptPubInfoRptDtoList=deptPubInfoRptService.selectDeptPubInfoSituationRpt(qMap);
			    if(deptPubInfoRptDtoList.size()>0){
			    	//行政许可
			    	JSONObject jSONObjectxzxk=new JSONObject();
					jSONObjectxzxk.put("disCount", deptPubInfoRptDtoList.get(0).getLicenceH());
					jSONObjectxzxk.put("count", deptPubInfoRptDtoList.get(0).getLicenceT());
					qMap.put("xingzhengxuke", jSONObjectxzxk);
					
					//异常名录
					JSONObject jSONObjectyc=new JSONObject();
					jSONObjectyc.put("disCount",deptPubInfoRptDtoList.get(0).getOpanomlyH());
					jSONObjectyc.put("count", deptPubInfoRptDtoList.get(0).getOpanomlyT());
					qMap.put("yichang", jSONObjectyc);
					 
					
					//严重违法失信名单
					JSONObject jSONObjectyzwf=new JSONObject();
					jSONObjectyzwf.put("disCount", deptPubInfoRptDtoList.get(0).getIllDisHoneH());
					jSONObjectyzwf.put("count",deptPubInfoRptDtoList.get(0).getIllDisHoneT());
					qMap.put("yanzhongweifa", jSONObjectyzwf); 
					
					
					
					//行政处罚的总数
					jSONObjectyztotal.put("disCount", deptPubInfoRptDtoList.get(0).getPunishH());
					jSONObjectyztotal.put("count", deptPubInfoRptDtoList.get(0).getPunishT()); 
					
					
					//其他部门
					JSONObject jSONObjectother=new JSONObject();
					jSONObjectother.put("disCount", deptPubInfoRptDtoList.get(0).getOtherpunishH());
					jSONObjectother.put("count", deptPubInfoRptDtoList.get(0).getOtherpunishT());
					
					
					//工商部门
					JSONObject jSONObjectgs=new JSONObject();
					jSONObjectgs.put("disCount", deptPubInfoRptDtoList.get(0).getCaseH());
					jSONObjectgs.put("count", deptPubInfoRptDtoList.get(0).getCaseT());
					
					
					jSONObjectyztotal.put("otherDept", jSONObjectother);
					jSONObjectyztotal.put("gongshang", jSONObjectgs);
					qMap.put("xingzhengchufa", jSONObjectyztotal); 
			    }
			} 
			return AjaxResult.success("获取企业信用信息公示成功", qMap); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取企业信用信息公示失败!", e);
		} 
		return AjaxResult.error("获取企业信用信息公示失败!");
	} 
	
	
	/**
	 * 
	 * 描述   企业基本信息公示情况
	 * @author 赵祥江
	 * @date 2017年8月15日 下午4:43:41 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getPubEntSituationBaseInfo")
	@ResponseBody
	public AjaxResult getPubEntSituationBaseInfo(PageRequest request) throws Exception {
		try {  
			Map<String,Object> qMap=request.getParams(); 
			if(qMap.containsKey("areaCode")&&StringUtil.isNotBlank(qMap.get("areaCode").toString())){
				qMap.put("statLevel", "pubentbaseinfo");
				qMap.put("areaCode", qMap.get("areaCode").toString());
				qMap.put("monthCode", DateUtil.getDate ("yyyyMMdd")); 
				List<DeptPubInfoRptDto> deptPubInfoRptDtoList=deptPubInfoRptService.selectDeptPubInfoSituationRpt(qMap);
			    if(deptPubInfoRptDtoList.size()>0){
			    	//股东及出资
					JSONObject jSONObjectgdcz=new JSONObject();
					jSONObjectgdcz.put("disCount", deptPubInfoRptDtoList.get(0).getInvH());
					jSONObjectgdcz.put("count", deptPubInfoRptDtoList.get(0).getInvT());
					qMap.put("gudongjichuzi", jSONObjectgdcz);
					
					//主要人员
					JSONObject jSONObjectgdry=new JSONObject();
					jSONObjectgdry.put("disCount",deptPubInfoRptDtoList.get(0).getMemH());
					jSONObjectgdry.put("count", deptPubInfoRptDtoList.get(0).getMemT());
					qMap.put("zhuyaorenyuan", jSONObjectgdry);
					
					//分支机构
					JSONObject jSONObjectgdfzjg=new JSONObject();
					jSONObjectgdfzjg.put("disCount", deptPubInfoRptDtoList.get(0).getSupH());
					jSONObjectgdfzjg.put("count", deptPubInfoRptDtoList.get(0).getSupT());
					qMap.put("fenzhijigou", jSONObjectgdfzjg); 
					
					//清算信息
					JSONObject jSONObjectgdqs=new JSONObject();
					jSONObjectgdqs.put("disCount",deptPubInfoRptDtoList.get(0).getLiqH());
					jSONObjectgdqs.put("count", deptPubInfoRptDtoList.get(0).getLiqT());
					qMap.put("qingsuanxinxi", jSONObjectgdqs); 
					
					//变更信息
					JSONObject jSONObjectbgxx=new JSONObject();
					jSONObjectbgxx.put("disCount", deptPubInfoRptDtoList.get(0).getAltItemH());
					jSONObjectbgxx.put("count", deptPubInfoRptDtoList.get(0).getAltItemT());
					qMap.put("biangengxinxi", jSONObjectbgxx);  
			    	
			    	//动产抵押登记信息
					JSONObject jSONObjectdcdy=new JSONObject();
					jSONObjectdcdy.put("disCount", deptPubInfoRptDtoList.get(0).getMortH());
					jSONObjectdcdy.put("count", deptPubInfoRptDtoList.get(0).getMortT());
					qMap.put("dongchandiya", jSONObjectdcdy); 
					
					//股权出资登记信息
					JSONObject jSONObjectgqcz=new JSONObject();
					jSONObjectgqcz.put("disCount", deptPubInfoRptDtoList.get(0).getPledgeH());
					jSONObjectgqcz.put("count",deptPubInfoRptDtoList.get(0).getPledgeT());
					qMap.put("guquanchuzi", jSONObjectgqcz); 
					
					//知识产权出资登记信息
					JSONObject jSONObjectzscq=new JSONObject();
					jSONObjectzscq.put("disCount", deptPubInfoRptDtoList.get(0).getIppldgH());
					jSONObjectzscq.put("count", deptPubInfoRptDtoList.get(0).getIppldgT());
					qMap.put("zhishichanquan", jSONObjectzscq); 
					
					//抽查检查结果
					JSONObject jSONObjectccjc=new JSONObject();
					jSONObjectccjc.put("disCount", deptPubInfoRptDtoList.get(0).getSpotcheckH());
					jSONObjectccjc.put("count", deptPubInfoRptDtoList.get(0).getSpotcheckT());
					qMap.put("chouchajiancha", jSONObjectccjc);
					
					//商标注册信息
					JSONObject jSONObjectsbzc=new JSONObject();
					jSONObjectsbzc.put("disCount", deptPubInfoRptDtoList.get(0).getTmH());
					jSONObjectsbzc.put("count", deptPubInfoRptDtoList.get(0).getTmT());
					qMap.put("shangbiaozhuche", jSONObjectsbzc);
					
					//司法协助信息
					JSONObject jSONObjectsfxz=new JSONObject();
					jSONObjectsfxz.put("disCount", deptPubInfoRptDtoList.get(0).getSfH());
					jSONObjectsfxz.put("count", deptPubInfoRptDtoList.get(0).getSfT());
					qMap.put("sifaxiezhu", jSONObjectsfxz);
			    }
			} 
			
			
			 
			return AjaxResult.success("获取企业基本信息公示情况成功", qMap); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取企业基本信息公示情况失败!", e);
		} 
		return AjaxResult.error("获取企业基本信息公示情况失败!");
	} 
	
	/**
	 * 
	 * 描述   获取公告数
	 * @author 赵祥江
	 * @date 2017年8月22日 下午5:03:36 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	private Integer getNum(Map<String,Object> pMap) throws Exception{
		List<RptAnnounceMentInfo> rptAnnounceMentInfoList=  	rptAnnounceMentInfoService.selectRptAnnounceMentInfo(pMap);
		if(rptAnnounceMentInfoList!=null&&rptAnnounceMentInfoList.size()>0){
			return rptAnnounceMentInfoList.get(0).getNum();
		} 
		return 0;
	}
	
	/**
	 * 
	 * 描述   公告信息统计
	 * @author 赵祥江
	 * @date 2017年8月16日 上午9:20:26 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getPubNoticeInfo")
	@ResponseBody
	public AjaxResult getPubNoticeInfo(PageRequest request) throws Exception {
		try {   
			Map<String,Object> qMap=request.getParams(); 
			Map<String,Object> dataMap=new HashMap<String,Object>(); 
			qMap.put("statLevel", "announcementinfo");
			if(qMap.containsKey("areaCode")&&StringUtil.isNotBlank(qMap.get("areaCode").toString())){
				qMap.put("pubtype", "1");
				 //经营异常名录
				JSONObject jSONObjectgdcz=new JSONObject();
				jSONObjectgdcz.put("count",getNum(qMap));
				dataMap.put("yichang", jSONObjectgdcz);
				  
				qMap.put("pubtype", "2");
				//严重违法失信企业名单公告
				JSONObject jSONObjectzyry=new JSONObject();
				jSONObjectzyry.put("count", getNum(qMap));
				dataMap.put("yanzhongweifa", jSONObjectzyry);
				
				//抽查检查
				qMap.put("pubtype", "3");
				JSONObject jSONObjectfzjg=new JSONObject(); 
				jSONObjectfzjg.put("count", getCheckNum(qMap));
				dataMap.put("chouchajiancha", jSONObjectfzjg);
				
				//行政处罚
				qMap.put("pubtype", "4");
				JSONObject jSONObjectqsxx=new JSONObject(); 
				jSONObjectqsxx.put("count",getNum(qMap));
				dataMap.put("xingzhengchufa", jSONObjectqsxx);
				
				//司法协助
				qMap.put("pubtype", "5");
				JSONObject jSONObjectbgxx=new JSONObject(); 
				jSONObjectbgxx.put("count",getNum(qMap));
				dataMap.put("sifaxiezhu", jSONObjectbgxx);
				
				//简易注销
				qMap.put("pubtype", "6");
				JSONObject jSONObjectdcdy=new JSONObject(); 
				jSONObjectdcdy.put("count",getNum(qMap));
				dataMap.put("jianyizhuxiao", jSONObjectdcdy);  
				
				//其他
				qMap.put("pubtype", "7");
				JSONObject jSONObjectgqcz=new JSONObject();
				jSONObjectgqcz.put("count", getNum(qMap));
				dataMap.put("other", jSONObjectgqcz);
				
				//催报
				qMap.put("pubtype", "8");
				JSONObject jSONObjectgqcb=new JSONObject();
				jSONObjectgqcb.put("count", getNum(qMap));
				dataMap.put("cuibao", jSONObjectgqcb);
			}  
			return AjaxResult.success("获取公告信息统计成功", dataMap); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取公告信息统计失败!", e);
		} 
		return AjaxResult.error("获取公告信息统计失败!");
	} 
	
	/**
	 * 
	 * 描述   获取抽查检查公告总数
	 * @author 赵祥江
	 * @date 2017年8月23日 下午4:28:54 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer getCheckNum(Map<String,Object> parmMap) throws Exception{
		Map<String,Object> pMap=new HashMap<String,Object>();
		if(parmMap!=null&&parmMap.containsKey("areaCode")){
			pMap.put("areaCode", parmMap.get("areaCode")); 
		}
		pMap.put("statLevel", "announcementinfobytype");
		pMap.put("pubtype", "6"); 
		Integer total=getNum(pMap); 
		pMap.put("pubtype", "7"); 
		total+=getNum(pMap); 
		pMap.put("pubtype", "17"); 
		total+=getNum(pMap); 
		pMap.put("pubtype", "18"); 
		return total+=getNum(pMap); 
	}
	
	
	/**
	 * 
	 * 描述   信息公告分类统计
	 * @author 赵祥江
	 * @date 2017年8月16日 上午10:00:24 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getPubKindNoticeInfo")
	@ResponseBody
	public AjaxResult getPubKindNoticeInfo(PageRequest request) throws Exception {
		try {  
			
			Map<String,Object> parmMap=request.getParams();
			Map<String,Object> qMap=new HashMap<String,Object>(); 
			String kindFlag=parmMap.get("kindFlag").toString();
			if(parmMap.containsKey("areaCode")&&StringUtil.isNotBlank(parmMap.get("areaCode").toString())){
				parmMap.put("statLevel", "announcementinfobytype");
				//异常公告
				if("1".equals(kindFlag)){ 
					parmMap.put("pubtype", "1"); 
					//列入
					qMap.put("lieru", getNum(parmMap));
					parmMap.put("pubtype", "2"); 
					//移出
					qMap.put("yichu", getNum(parmMap));
					parmMap.put("pubtype", "3"); 
					//期满三年
					qMap.put("qimansannian",getNum(parmMap));
					parmMap.put("statLevel", "announcementinfo"); 
					parmMap.put("pubtype", kindFlag); 
					//总数
					qMap.put("total", getNum(parmMap));
				}else if("2".equals(kindFlag)){//严重违法失信企业名单公告
					parmMap.put("pubtype", "4"); 
					qMap.put("lieru", getNum(parmMap));
					parmMap.put("pubtype", "5"); 
					qMap.put("yichu", getNum(parmMap));
					parmMap.put("statLevel", "announcementinfo"); 
					parmMap.put("pubtype", kindFlag); 
					qMap.put("total", getNum(parmMap));
				}else if("3".equals(kindFlag)){//抽查检查公告 
					parmMap.put("pubtype", "6");
					qMap.put("choucha", getNum(parmMap));
					parmMap.put("pubtype", "7");
					qMap.put("jiancha", getNum(parmMap));
					parmMap.put("pubtype", "17");
					qMap.put("chouchajihua", getNum(parmMap));
					parmMap.put("pubtype", "18");
					qMap.put("choucharenwu", getNum(parmMap)); 
					qMap.put("total",getCheckNum(parmMap));
				}else if("4".equals(kindFlag)){//行政处罚
					parmMap.put("pubtype", "8"); 
					qMap.put("xingzhengchufa", getNum(parmMap)); 
					parmMap.put("statLevel", "announcementinfo"); 
					parmMap.put("pubtype",kindFlag); 
					qMap.put("total", getNum(parmMap));
				}else if("5".equals(kindFlag)){//司法协助
					parmMap.put("pubtype", "9");
					qMap.put("guquandongjie", getNum(parmMap));
					parmMap.put("pubtype", "10");
					qMap.put("gudongbiangeng", getNum(parmMap)); 
					parmMap.put("statLevel", "announcementinfo"); 
					parmMap.put("pubtype",kindFlag); 
					qMap.put("total", getNum(parmMap));
				}else if("6".equals(kindFlag)){//简易注销
					parmMap.put("pubtype", "12");
					qMap.put("jianyizhuxiao", getNum(parmMap)); 
					parmMap.put("statLevel", "announcementinfo"); 
					parmMap.put("pubtype",kindFlag); 
					qMap.put("total", getNum(parmMap));
				}else if("7".equals(kindFlag)){//其他公告
					parmMap.put("pubtype", "13");
					qMap.put("tingzheng", getNum(parmMap)); 
					parmMap.put("pubtype", "14");
					qMap.put("diaoxiao", getNum(parmMap)); 
					parmMap.put("pubtype", "15");
					qMap.put("zhuxiao", getNum(parmMap));
					parmMap.put("statLevel", "announcementinfo");
					parmMap.put("pubtype",kindFlag); 
					qMap.put("total", getNum(parmMap));
				} 
			}
			return AjaxResult.success("获取信息公告分类统计成功", qMap); 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取信息公告分类统计失败!", e);
		} 
		return AjaxResult.error("获取信息公告分类统计失败!");
	} 
	
}