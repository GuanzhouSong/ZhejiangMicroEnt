/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.HttpFluent;
import com.icinfo.cs.common.utils.SM4Utils;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.model.MessageScCheck;
import com.icinfo.cs.message.service.IMessageScCheckService;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.mapper.PubScentMapper;
import com.icinfo.cs.sccheck.service.IPubSccheckWeChatService;
import com.icinfo.cs.system.mapper.SysLogMapper;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 
 * 描述:  联连微信接口
 * @author: 赵祥江
 * @date: 2017年8月9日 上午10:20:59
 */
@Service
public class PubSccheckWeChatServiceImpl extends MyBatisServiceSupport implements IPubSccheckWeChatService {
	private static final Logger logger = LoggerFactory.getLogger(PubSccheckWeChatServiceImpl.class);
	private String key="asdfghjkl";
	@Autowired
	private PubScentMapper pubScentMapper;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private SysLogMapper sysLogMapper;
	@Autowired
	private IMessageScCheckService messageScCheckService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
    @Value("${llDomain}")
	private String   llDomain; 
    @Value("${webDomain}")
    private String   url;
    @Value("${appDomain}")
    private String   interfaceUrl; 
	@Autowired
    private ICsQuartzJobService    csQuartzJobService;
    
	/**
	 * 
	 * 描述   根据联系电话和企业名称和社会信用代码查询抽查检查名单列表
	 * @author  赵祥江
	 * @date 2017年8月9日 上午10:07:43 
	 * @param  
	 * @throws
	 */
	@Override
	public JSONObject getSccheckeEntList(String tel, String keyword,String secretkey,
			int pageNo, int pageSize,String flag) throws Exception {
		JSONObject jsonObject = new JSONObject();
		List<Object> jsonObjList = new ArrayList<Object>();
		//总数
		Integer totalCount=0;
		try {
			//校验口令
			if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			//检查结果中文名称
			Map<String, Object> resMap =getCheckResult();
			Map<String, Object> searchMap = new HashMap<String, Object>();
			pageNo = StringUtil.isBlank(String.valueOf(pageNo)) ? 1:pageNo; // 默认为0
			pageSize = StringUtil.isBlank(String.valueOf(pageSize)) ? 10:pageSize; // 默认为 10条每页
			searchMap.put("numStart", (pageNo - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
			if("1".equals(flag)){
				searchMap.put("uid", keyword);
			}else{
				searchMap.put("keyword", keyword);
				searchMap.put("tel", tel);
			}
			List<PubScentDto> pubScentDtoList=  pubScentMapper.selectSccheckeEntList(searchMap);
			if(pubScentDtoList!=null&&pubScentDtoList.size()>0){
				for(PubScentDto pubScentDto: pubScentDtoList){
					Map<String, Object> objMap = new HashMap<String, Object>();
					// 企业名称
					objMap.put("entName", pubScentDto.getEntName()==null?"":pubScentDto.getEntName());
					// 统一社会信用代码
					objMap.put("uniCode", pubScentDto.getUniCode()==null?pubScentDto.getRegNO():pubScentDto.getUniCode());
					// 抽查检查名单id
					objMap.put("pubscentid",pubScentDto.getUid()==null?"000000":pubScentDto.getUid()); 
					
					//任务编号
					objMap.put("taskCode",pubScentDto.getTaskCode()==null?"":pubScentDto.getTaskCode());
					//任务名称
					objMap.put("taskName",pubScentDto.getTaskName()==null?"":StringEscapeUtils.unescapeHtml4(pubScentDto.getTaskName())); 
					String checkResultStr= pubScentDto.getCheckResult();
					String checkResult="";
					if(StringUtil.isNotBlank(checkResultStr)){
					String []  checkResultArr=	checkResultStr.split(",");
					    if(checkResultArr.length>0){
					    	for(int i=0;i<checkResultArr.length;i++){
					    		if(i==checkResultArr.length-1){
					    			checkResult+=resMap.get(checkResultArr[i]).toString();
					    		}else{
					    			checkResult+=resMap.get(checkResultArr[i]).toString()+"；"+"\r\n";
					    		}
					    	}
					    }
					} 
					if(StringUtil.isNotBlank(pubScentDto.getAuditState())&&"5".equals(pubScentDto.getAuditState())){
						objMap.put("taskState","已公示");
					}else{
						objMap.put("taskState","暂无");
					}
					if("1".equals(flag)){
						//列入名单日期
						objMap.put("randomDate",pubScentDto.getEstDate()==null?"":DateUtil.formatDate(pubScentDto.getEstDate()));
						if(StringUtil.isNotBlank(pubScentDto.getAuditState())&&"5".equals(pubScentDto.getAuditState())){
							//抽检日期
							objMap.put("checkDate",pubScentDto.getCheckDate()==null?"":DateUtil.formatDate(pubScentDto.getCheckDate()));
							//抽查检查实施部门名称
							objMap.put("checkDeptName",pubScentDto.getCheckDeptName()==null?"":pubScentDto.getCheckDeptName());
							//检查结果
							objMap.put("checkResult",checkResult); 
						}else{
							//抽检日期
							objMap.put("checkDate",""); 
							//抽查检查实施部门名称
							objMap.put("checkDeptName","");
							//检查结果
							objMap.put("checkResult",""); 
						}
					}
					jsonObjList.add(objMap);
				}
			} 
			if("0".equals(flag)){
				totalCount=pubScentMapper.selectSccheckeEntCount(searchMap); 
				jsonObject.put("totalCount", totalCount);
			}
			jsonObject.put("resultList", JSONArray.fromObject(jsonObjList)); 
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"),e);
		} 
		return jsonObject;
	}
	
	
	/**
	 * 
	 * 描述   获取抽查结果
	 * @author 赵祥江
	 * @date 2017年8月9日 下午3:23:34 
	 * @param 
	 * @return Map<String,Object>
	 * @throws
	 */
	public Map<String,Object> getCheckResult(){
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("1", "未发现问题");
		//resMap.put("2", "违反工商行政管理相关规定");
		resMap.put("3", "违反食品药品管理相关规定");
		resMap.put("4", "违反质量技术监督相关规定");
		resMap.put("5", "违反其他部门相关规定");
		resMap.put("6", "通过登记的住所（经营场所）无法联系");
		resMap.put("7", "已关闭停业或正在清算");
		resMap.put("8", "不配合检查情节严重");
		resMap.put("9", "注销");
		resMap.put("10", "被吊销");
		resMap.put("11", "被撤销");
		resMap.put("12", "迁出");
		
		resMap.put("B", "未按规定公示应当公示的信息");
		resMap.put("C", "公示信息隐瞒真实情况弄虚作假");
		resMap.put("D", "违反其他工商行政管理规定行为");
		resMap.put("E", "发现问题经责令已改正");
		resMap.put("F", "未发现开展本次抽查涉及的经营活动");
		resMap.put("G", "违反公安部门相关规定");
		return resMap;
	}


	/**
	 * 
	 * 描述   抽查检查消息推送
	 * @author  赵祥江
	 * @date 2017年8月10日 上午10:57:18 
	 * @param  
	 * @throws
	 */
	@Override
	public JSONObject sccheckMsgPush(String tel, String secretkey, String flag)
			throws Exception { 
			JSONObject jsonObject = new JSONObject();
			Map<String, Object> searchMap = new HashMap<String, Object>();
			if("0".equals(flag)){//定时任务
			   // 阻塞任务，防止并发访问数据库
		        SleepUtil.threadSleep (); 
		 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.SCCHECK_MSG_SEND_JOB.getJobName())){
		 			return null;
		 		}
		 		csQuartzJobService.insert(QuartzJobName.SCCHECK_MSG_SEND_JOB.getJobName ());
			}else{ 
				//微信端调用
				//校验口令
				if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
					jsonObject.put("responseCode", "0");
					jsonObject.put("responseMessage", "访问接口口令验证不通过");
					logger.error(jsonObject.getString("responseMessage"));
					return jsonObject;
				}
				if(StringUtil.isBlank(tel)){
					jsonObject.put("responseCode", "0");
					jsonObject.put("responseMessage", "联络员电话不能为空");
					logger.error(jsonObject.getString("responseMessage"));
					return jsonObject;
				}
				searchMap.put("tel",tel); 
			}
				Integer totalCount = pubScentMapper.selectSccheckeMsgCount(searchMap);
	 		    if(totalCount==0&&"1".equals(flag)){
	 		    	jsonObject.put("responseCode", "3");
					jsonObject.put("responseMessage", "联络员电话:"+tel+"，该联络员名下没有找到处于抽查检查范围的企业");
					logger.error(jsonObject.getString("responseMessage"));
					return jsonObject;
	 		    }
		        Long pageSize = 9999L;
		        Long pageCount=totalCount/pageSize;
		        if (totalCount%pageSize>0) {
		            pageCount++;
		        }
		        searchMap.put("isView", "1");
		        searchMap.put("pageSize", pageSize); 
		        List<JSONObject> entDataList=new ArrayList<JSONObject>();
		        for ( int i = 1 ; i <= pageCount ; i++ ) {
		            Long numStart = (i - 1) * pageSize;
		            searchMap.put("numStart", numStart);
		            List<PubScentDto> unReportList = pubScentMapper.selectSccheckeMsgEntList(searchMap);
		            if (null != unReportList && unReportList.size () > 0) { 
		                for ( PubScentDto pubScentDtoDto : unReportList ) { 
		                	try {
		                		entDataList.clear();
		                		//联络员电话
			                	String linatel = pubScentDtoDto.getTaskCode();
			                	//企业条数
			                	Integer entCount=pubScentDtoDto.getTotalNum();
			                	String entName = pubScentDtoDto.getEntName();
			                	//列入日期
			                	String randomDate="2017年8月10";
			                	if(pubScentDtoDto.getEstDate()!=null){
			                		randomDate=DateUtil.formatDate(pubScentDtoDto.getEstDate(), "yyyy年MM月dd日");
			                	}
			                	String  taskName =pubScentDtoDto.getTaskName(); 
			                	if(StringUtil.isNotBlank(taskName)){
			                		taskName=StringEscapeUtils.unescapeHtml4(taskName);
			                		taskName="“"+taskName+"”";
			                	}else{
			                		taskName="“浙江省2016年度企业年报公示信息及登记事项抽查”";
			                	}
			                	String[] entNameArr=pubScentDtoDto.getRegOrgName().split(",");
			                	if(entNameArr.length>0){
			                		for(int c=0;c<entNameArr.length;c++){
			                			MidBaseInfo midBaseInfo=midBaseInfoService.selectInfoByPriPID(entNameArr[c]);
			                			if(midBaseInfo!=null){
			                				 JSONObject jSONObject=new JSONObject();
			                				 //企业名称
			                				 jSONObject.put("entName", StringUtil.isBlank(midBaseInfo.getEntName())?"":midBaseInfo.getEntName());
			                				 //内部序号businessInfo
			                				 jSONObject.put("entId",  StringUtil.isBlank(midBaseInfo.getPriPID())?"":midBaseInfo.getPriPID());
			                				 jSONObject.put("entUnino", StringUtil.isBlank(midBaseInfo.getUniCode())?midBaseInfo.getRegNO():midBaseInfo.getUniCode());
			                				 jSONObject.put("businessInfo", "");
			                				 entDataList.add(jSONObject);
			                			}
			                		} 
			                	}  
			                	
			                	String entList= JSONArray.fromObject(entDataList).toString(); 
			                	if(entCount!=null&&entCount>0){
			                		//如果没有绑定联连则不推送消息
				                	if(checkTel(linatel)){
				                		    String content="您担任联络员的"+entName+"等"+entCount+"家企业在"+randomDate+"已被浙江省工商局抽中为"+taskName+"工作的抽查检查对象。";
								String json = "{\"title\" : \"抽查检查提醒\", "
										+ "\"pusher\" : \"国家企业信用信息公示系统\", "
										+ "\"receiver\" : \""
										+ linatel
										+ "\","
										+ "\"sourceUrl\" : \""
										+ url
										+ "/sccheck/wechat/toMessageSccheckView?tel="
										+ linatel
										+ "&sendDate="
										+ DateUtil.getDate("yyyyMMdd")
										+ "\","
										+ "\"type\" : \"03\","
										+ "\"midType\" : \"03001\"," 
										+ "\"subType\" : \"03001006\","
										+ "\"content\" : \""
										+ content
										+ "\"," 
										+ "\"pushChannels\":\"1,2\","
										+ "\"entList\":"
										+ entList
										+ "" + "}";
				                		   // String json = "{\"title\" : \"企业抽查提醒\", " + "\"pusher\" : \"国家企业信用信息公示系统\", " + "\"receiver\" : \""+linatel+"\"," + "\"sourceUrl\" : \""+url+"/sccheck/wechat/toMessageSccheckView?tel="+tel+"&sendDate="+DateUtil.getDate ("yyyyMMdd")+"\"," + "\"type\" : \"3\"," + "\"subType\" : \"yr_random_check\"," + "\"content\" : \""+content+"\"," + "\"additionInfo\" : {" + "\"toDo\" : \"请积极配合做好相关准备\"," + "\"basicInfo\" : \"抽查提醒\","+ "\"sendTime\" : \""+DateUtil.getDate ("HH:mm")+"\"," +"\"remark\" : \"客服电话 4008884636\"},"+ "\"pushChannels\":\"1,2\"}";
						                    /*fixedThreadPool.execute (new Runnable () { 
								            public void run(){*/
						                    	MessageScCheck messageScCheck=new MessageScCheck();
								            	//调用app接口发送信息 
						                        JSONObject jSONObject=sendPOSTRequestMsg(json,linatel);  
							                    String code=jSONObject.get("code").toString ();
							                    String state="0";
							                     String matchMsg="";
							                     //成功
							                     if("00".equals(code)){
							                    	 state ="1"; 
							                     }else if("01".equals(code)){//部分成功
							                    	 state ="2"; 
							                     }else{//失败
							                    	 state ="0"; 
							                     } 
							                     jsonObject.put("responseCode", state);
							                     if(jSONObject.containsKey("msg")){
							                    	 matchMsg+=jSONObject.get("msg")+",";
							                     }
							                     if(jSONObject.containsKey("description")&&jSONObject.get("description")!=null){
							                    	 matchMsg+=jSONObject.get("description")+",";
							                     }
							                     jsonObject.put("responseMessage",matchMsg); 
							                     //状态
							                     messageScCheck.setState(state);
							                     //主键uid        
							                     messageScCheck.setMsgUid(StringUtil.uuid());
							                     //推送内容
							                     messageScCheck.setContent(json.replaceAll("'",""));
							                     //联络员电话
							                     messageScCheck.setLiaisonManTel(linatel);
							                     //推送类型
							                     messageScCheck.setMsgType(flag);
							                     //时间戳
							                     messageScCheck.setCreateTime(DateUtil.getSysDate());
							                     //匹配信息
							                     messageScCheck.setMatchMsg(matchMsg);
							                     messageScCheckService.insertMessageScCheck(messageScCheck);
							                // }
								       // }); 
				                	}
			                	}
							} catch (Exception e) {
								e.printStackTrace();
								logger.error("联络员手机号码:"+pubScentDtoDto.getTaskCode()+"错误", e);
								continue;
							}
		                }
		            } 
		        } 
		        try {
	        	    SysLog sysLog=new SysLog();
					sysLog.setYear(Integer.parseInt(DateUtil.getYear()) );
					sysLog.setLogMsg(DateUtil.getCurrentFormatDate()+"抽查检查消息推送"+flag=="0"?"定时":"实时"+"任务执行完成");
					sysLog.setLogOperation(LogOperation.MESSAGESCCHECKLOG.getCode()); 
					sysLog.setSetTime(DateUtil.getSysDate());
			        sysLogMapper.insert(sysLog);
				} catch (Exception e) {
					logger.error("抽查检查消息推送"+flag=="0"?"定时":"实时"+"任务保存日志错误", e);
				} 
		        return jsonObject;
	}
	

	/**
	 * 
	 * 描述   校验手机号码是否绑定客户端
	 * @author 赵祥江
	 * @date 2017年7月4日 下午5:24:10 
	 * @param 
	 * @return boolean
	 * @throws
	 */
    private boolean checkTel(String tel){
	        try {
	            SM4Utils sm4Utils = new SM4Utils ();
	            sm4Utils.setSecretKey ("JeF8U9wHFOMfs2Xx");
	            sm4Utils.setHexString (false); 
	            if (StringUtil.isNotBlank(tel)) {
	                String json = "{\"phone\":\"" + tel + "\"}";
	                String returnStr = sendHttpClientPOSTRequest (llDomain + "/doGetUserInfo.do", json, "UTF-8");
                    String retunJson = sm4Utils.decryptData_ECB (returnStr);
	                com.alibaba.fastjson.JSONObject jSONObject = JSON.parseObject (retunJson);
	                String retcode = jSONObject.get("retcode").toString ();
	                //0 表示绑定连连客户端
	                if ("0".equals (retcode)) {
	                    return true;
	                } 
	            }
	        } catch (Exception e) {
	            e.printStackTrace ();
	            logger.error("调用校验绑定联连接口发生错误", e);
	        }
			return false;
	}
    
    
    /**
	  * 
	  * 描述   发送客户端请求
	  * @author 赵祥江
	  * @date 2017年7月25日 下午2:35:22 
	  * @param 
	  * @return String
	  * @throws
	  */
	 private static String sendHttpClientPOSTRequest(String path,String param,String encoding) throws IOException{
	        CloseableHttpClient client = null;
	        CloseableHttpResponse response = null;
	        try {
	            StringEntity entity = new StringEntity (param,encoding);
	            HttpPost httpPost = new HttpPost (path);
	            RequestConfig requestConfig = RequestConfig.custom ().setConnectTimeout (60000).setConnectionRequestTimeout (60000).setSocketTimeout (60000).build ();
	            httpPost.setHeader ("Connection", "Keep-Alive");
	            httpPost.setConfig (requestConfig);
	            httpPost.setEntity (entity);

	            client = HttpClients.createDefault ();
	            response = client.execute (httpPost);

	            int statusCode = response.getStatusLine ().getStatusCode ();
	            /* 若状态码为200 ok */
	            if (statusCode == 200) {
	                InputStream inputStream = response.getEntity ().getContent ();
	                byte[] dateStream = readStream (inputStream);
	                return new String (dateStream);
	            } else {
	            	logger.error("调用校验绑定联连接口发生错误");
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace ();
	            logger.error("调用校验绑定联连接口发生错误", e);
	        } finally {
	            if (null != response) {
	                response.close ();
	            }
	            if (null != client) {
	                client.close ();
	            }
	        }
	        return null;
	    }
	 
	 
	 /**
	  * 
	  * 描述   调用手机App接口推送消息
	  * @author 赵祥江
	  * @date 2017年7月4日 下午5:37:45 
	  * @param 
	  * @return void
	  * @throws
	  */
	 public JSONObject  sendPOSTRequestMsg(String newJson,String tel){
	        try {
	            SM4Utils sm4Utils = new SM4Utils ();
	            sm4Utils.setSecretKey ("JeF8U9wHFOMfs2Xx");
	            sm4Utils.setHexString (false);
	            if (StringUtil.isNotBlank(tel)&&StringUtil.isNotBlank(newJson)) { 
                    String jsonEncodeStr = sm4Utils.encryptData_ECB (newJson);
                    Map<String, String> params = new HashMap<String, String> ();
                    params.put ("message", jsonEncodeStr);
                    params.put ("cust_id", "cs"); 
                    String res=sendPOSTRequest (interfaceUrl + "/api/message/single_push", params, "UTF-8");
                    return    JSONObject.fromObject(res); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace ();
	            logger.error("调用发送消息接口发生错误", e);
	        } 
	        return null;
	    }
	 
	 
	 public static byte[] readStream(InputStream inStream) throws Exception{
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream ();
	        byte[] buffer = new byte[2048];
	        int len = -1;
	        while ((len = inStream.read (buffer)) != -1) {
	            outSteam.write (buffer, 0, len);
	        }
	        outSteam.close ();
	        inStream.close ();
	        return outSteam.toByteArray ();
	    }
	 
	 /**
	    * 
	    * 描述   发送post请求
	    * @author 赵祥江
	    * @date 2017年7月25日 下午2:34:37 
	    * @param 
	    * @return String
	    * @throws
	    */
	   public static String sendPOSTRequest(String path,Map<String, String> params,String encoding){
	        InputStream inputStream = null;
	        HttpURLConnection conn = null;
	        try {
	            // 组装 name=yangpan&age=28
	            StringBuilder data = new StringBuilder ();
	            if (params != null && !params.isEmpty ()) {
	                for ( Map.Entry<String, String> entry : params.entrySet () ) {
	                    data.append (entry.getKey ()).append ("=");
	                    data.append (URLEncoder.encode (entry.getValue (), encoding));
	                    data.append ("&");
	                }
	                data.deleteCharAt (data.length () - 1);
	            }
	            byte[] entity = data.toString ().getBytes ();// 生成实体数据
	            conn = (HttpURLConnection) new URL (path).openConnection ();
	            conn.setConnectTimeout (60000);// 设置超时
	            conn.setRequestMethod ("POST");
	            // 允许对外输出数据
	            conn.setDoOutput (true);
	            // 设定传送的内容类型是可序列化的java对象
	            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
	            conn.setRequestProperty ("Content-Type", "application/x-www-form-urlencoded");
	            conn.setRequestProperty ("Content-Length", String.valueOf (entity.length));
	            // conn.setRequestProperty ("User-Agent", AppContext.getHandSetInfo ());
	            conn.setRequestProperty ("AppKey", "3");
	            conn.setRequestProperty ("Connection", "Keep-Alive");
	            OutputStream outStream = conn.getOutputStream ();
	            outStream.write (entity);
	            if (conn.getResponseCode () == 200) {
	                inputStream = conn.getInputStream ();
	                byte[] dateStream = readStream (inputStream);
	                return new String (dateStream);
	            } else {
	            	 logger.error("调用发送消息接口发生错误");
	            }
	        } catch (Exception e) {
	            e.printStackTrace ();
	            logger.error("调用发送消息接口发生错误", e);
	        } finally {
	            if (conn != null) {
	                conn.disconnect ();
	            }
	        }
	        return null;
	    }


   /**
	 * 
	 * 描述   根据消息id组装详细信息
	 * @author 赵祥江
	 * @date 2017年8月24日 下午3:50:41 
	 * @param 
	 * @return List<PubScentDto>
	 * @throws
	 */
	@Override
	public List<PubScentDto> getMsgInfoByMsgId(String msgId) throws Exception {
		List<PubScentDto> pubScentDtolist=new ArrayList<PubScentDto>();
		try {
			if(StringUtil.isNotBlank(msgId)){
				String res="";
				try {
					 res=HttpFluent.getData(interfaceUrl + "/api/message/get_message_ents/"+msgId); 
				} catch (Exception e) {
					 logger.error("根据消息id调用主体信息接口发生错误", e);
					 return pubScentDtolist;
				}
				JSONObject resJSONObject =JSONObject.fromObject(res);
				if(resJSONObject!=null&&resJSONObject.containsKey("code")){
					String code=resJSONObject.getString("code");
					if("00".equals(code)){
						JSONObject dataJSONObject=JSONObject.fromObject(resJSONObject.get("data"));
						if(!dataJSONObject.isEmpty()){
						    String content=dataJSONObject.getString("content"); 
						    Date  pushTime=DateUtil.stringToDate(dataJSONObject.getString("pushTime"),"yyyy-MM-dd");
							JSONArray entArray =(JSONArray) dataJSONObject.get("entList");
							if(entArray.size()>0){
								for(int i=0;i<entArray.size();i++){
									PubScentDto pubScentDto=new PubScentDto();
									pubScentDto.setEntName(entArray.get(i).toString());
									if(content.indexOf("。")>0){
										content=content.substring(0, content.indexOf("。")+1);
									} 
									pubScentDto.setCheckResult(content);
									pubScentDto.setCheckDate(pushTime);
									pubScentDtolist.add(pubScentDto);
								}
							}
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			logger.error("根据消息id组装详细信息发生错误", e);
		}
		return pubScentDtolist;
	}

/**
 * 
 * 描述   根据联系电话获取抽查检查企业列表信息
 * @author  赵祥江
 * @date 2017年9月6日 下午2:16:23 
 * @param  
 * @throws
 */
@Override
public JSONObject getSccheckEntListByTel(String tel, String secretkey)
		throws Exception {
	JSONObject jSONObject=new JSONObject();
	Map<String, Object> searchMap = new HashMap<String, Object>();
	try {
		if(StringUtil.isBlank(tel)){
			jSONObject.put("responseMessage", "联系电话不能为空");
			jSONObject.put("responseCode", "0");
			logger.error("根据联系电话获取抽查检查企业列表信息发生错误:联系电话不能为空");
			return jSONObject;
		} 
		//校验口令
		if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
			jSONObject.put("responseCode", "0");
			jSONObject.put("responseMessage", "访问接口口令验证不通过");
			logger.error("根据联系电话获取抽查检查企业列表信息发生错误:访问接口口令验证不通过");
			return jSONObject;
		}
		JSONObject jSONObjectT=new JSONObject();
		String entList="";
		String[] entNameArr={};
		jSONObjectT.put("receiver", tel);
		jSONObjectT.put("addition", "");
		searchMap.put("isView", "1");
        searchMap.put("pageSize", 9999);
        searchMap.put("numStart", 0);
        searchMap.put("tel",tel); 
		List<PubScentDto> unReportList = pubScentMapper.selectSccheckeMsgEntList(searchMap);
		if(unReportList!=null&&unReportList.size()>0){
			PubScentDto pubScentDto=unReportList.get(0);
			if(StringUtil.isNotBlank(pubScentDto.getRegOrgName())){
				entNameArr=pubScentDto.getRegOrgName().split(","); 
			}
		}
		entList= JSONArray.fromObject(entNameArr).toString(); 
		jSONObjectT.put("entList",entList); 
		jSONObject.put("responseCode", "1");
		jSONObject.put("dataSourceDto", jSONObjectT);
		jSONObject.put("responseMessage", "查询成功");
	} catch (Exception e) {
		logger.error("根据联系电话获取抽查检查企业列表信息发生错误", e);
		jSONObject.put("responseCode", "-1");
		jSONObject.put("responseMessage", "查询失败"); 
	}
	return jSONObject;
  } 
}