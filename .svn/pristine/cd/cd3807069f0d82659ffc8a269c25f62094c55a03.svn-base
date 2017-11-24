/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SM4Utils;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.creditprove.service.ICreditProveListService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.mapper.MessageImInfoMapper;
import com.icinfo.cs.message.model.MessageImInfo;
import com.icinfo.cs.message.service.IMessageIminfoService;
import com.icinfo.cs.system.mapper.SysLogMapper;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_message_opanomaly 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
@Service
public class MessageIminfoServiceImpl extends MyBatisServiceSupport implements IMessageIminfoService {
	private static final Logger logger = LoggerFactory.getLogger(MessageIminfoServiceImpl.class);
	@Autowired
	private MessageImInfoMapper messageImInfoMapper; 
	@Autowired
    private IPubEppasswordService  pubEppasswordService; 
	@Autowired
    private ICsQuartzJobService    csQuartzJobService;
	@Autowired
	private ICreditProveListService creditProveListService;
	@Autowired
	private SysLogMapper sysLogMapper;
	
    @Value("${llDomain}")
	private String   llDomain; 
    @Value("${webDomain}")
    private String   url;
    @Value("${appDomain}")
    private String   interfaceUrl;
	
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年7月4日 下午4:37:23 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertMessageImInfo(MessageImInfo messageImInfo)
			throws Exception {
		return messageImInfoMapper.insert(messageImInfo);
	}  
	
	 /**
	  * 
	  * 描述   企信联连即时消息推送
	  * @author  赵祥江
	  * @date 2017年7月18日 下午2:59:46 
	  * @param  
	  * @throws
	  */
	  @Override
	  public String  quartzJob() throws Exception{
	        // 阻塞任务，防止并发访问数据库
 	        SleepUtil.threadSleep (); 
 	 		if(csQuartzJobService.checkJobIsExecute(QuartzJobName.IMINFO_MSG_SEND_JOB.getJobName())){
 	 			return "任务已执行";
 	 		}
 	 		csQuartzJobService.insert(QuartzJobName.IMINFO_MSG_SEND_JOB.getJobName ()); 
	        Long totalCount = pubEppasswordService.queryPubEppasswordImInfoCount();
	        Long pageSize = 9999L;
	        Long pageCount=totalCount/pageSize;
	        if (totalCount%pageSize>0) {
	            pageCount++;
	        }
	       // ExecutorService fixedThreadPool = Executors.newFixedThreadPool (3);// 默认最多5条线程
	        for ( int i = 1 ; i <= pageCount ; i++ ) {
	            Long numStart = (i - 1) * pageSize;
	            List<PubEppasswordDto> unReportList = pubEppasswordService.queryPubEppasswordImInfoList(numStart,pageSize);
	            if (null != unReportList && unReportList.size () > 0) { 
	                for ( PubEppasswordDto pubEppasswordDto : unReportList ) { 
	                	try {
 		                    String tel = pubEppasswordDto.getTel();
		                	Long entCount=pubEppasswordDto.getEntCount();
		                	String entName = pubEppasswordDto.getEntname ();
		                	if(entCount!=null&&entCount>0){
		                		//如果没有绑定联连则不推送消息
			                	if(checkTel(tel)){
			                		    String content="您担任工商联络员的"+entName+"（等"+entCount+"家企业）有即时信息（股东及出资信息）未公示或公示不完整情况，为避免此原因被列入经营异常名录，请及时填报并公示！";
								String json = "{\"title\" : \"企业即时信息公示提醒\", "
										+ "\"pusher\" : \"国家企业信用信息公示系统\", "
										+ "\"receiver\" : \""
										+ tel
										+ "\","
										+ "\"sourceUrl\" : \""
										+ url
										+ "/message/messageiminfo/toMessageImInfoView?msgReadTel="
										+ tel
										+ "&sendDate="
										+ DateUtil.getDate("yyyyMMdd")
										+ "\","
										+ "\"type\" : \"03\","
										+ "\"midType\" : \"03001\"," 
										+ "\"subType\" : \"03001005\","
										+ "\"content\" : \""
										+ content
										+ "\","
										+ "\"additionInfo\" : {"
										+ "\"待办内容\" : \"完善企业即时信息（股东及出资信息）报送与公示\""
										+ "},"
										+ "\"pushChannels\" : \"1,2\""
										+ "}";
					                    /*fixedThreadPool.execute (new Runnable () { 
							            public void run(){*/
					                    MessageImInfo messageImInfo=new MessageImInfo();
							            	//调用app接口发送信息 
					                        JSONObject jSONObject=sendPOSTRequestMsg(json,tel);  
						                    String code=jSONObject.get("code").toString ();
						                    String state="0";
						                     String matchMsg="";
						                     //成功
						                     if("00".equals(code)){
						                    	 state ="1";
						                     }
						                     if(jSONObject.containsKey("msg")){
						                    	 matchMsg+=jSONObject.get("msg")+",";
						                     }
						                     if(jSONObject.containsKey("description")&&jSONObject.get("description")!=null){
						                    	 matchMsg+=jSONObject.get("description")+",";
						                     }
							                 messageImInfo.setMsgType("0");
							                 messageImInfo.setContent(json);
							                 messageImInfo.setSetTime(DateUtil.getSysDate());
							                 messageImInfo.setLiaisonManId(pubEppasswordDto.getUid());
							                 messageImInfo.setLiaisonManTel(tel);
							                 messageImInfo.setLiaisonManName(pubEppasswordDto.getLianame());
							                 messageImInfo.setCreateTime(messageImInfo.getSetTime());
							                 messageImInfo.setState(state);
							                 messageImInfo.setMatchMsg(matchMsg);
											 insertMessageImInfo(messageImInfo);
							           // }
							       // }); 
			                	}
		                	}
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("联络员:"+pubEppasswordDto.getLianame()+"，手机号码:"+pubEppasswordDto.getTel()+"错误", e);
							continue;
						}
	                }
	            } 
	        }  
	        SysLog sysLog=new SysLog();
			sysLog.setYear(Integer.parseInt(DateUtil.getYear()) );
			sysLog.setLogMsg(DateUtil.getCurrentFormatDate()+"有限责任公司即时消息推送任务执行完成");
			sysLog.setLogOperation(LogOperation.MESSAGEIMINFOLOG.getCode()); 
			sysLog.setSetTime(DateUtil.getSysDate());
	        sysLogMapper.insert(sysLog);
	        return null;
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
	                JSONObject jSONObject = JSON.parseObject (retunJson);
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
                    return     (JSONObject) JSONObject.parse(res); 
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
}