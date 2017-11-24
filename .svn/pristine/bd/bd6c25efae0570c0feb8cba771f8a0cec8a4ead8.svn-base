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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SM4Utils;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.creditprove.service.ICreditProveListService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.mapper.MessageOpanoMalyMapper;
import com.icinfo.cs.message.model.MessageOpanoMaly;
import com.icinfo.cs.message.service.IMessageOpanoMalyService;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_message_opanomaly 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
@Service
public class MessageOpanoMalyServiceImpl extends MyBatisServiceSupport implements IMessageOpanoMalyService {
	private static final Logger logger = LoggerFactory.getLogger(MessageOpanoMalyServiceImpl.class);
	@Autowired
	private MessageOpanoMalyMapper messageOpanoMalyMapper; 
	@Autowired
    private IPubEppasswordService  pubEppasswordService; 
	@Autowired
    private ICsQuartzJobService    csQuartzJobService;
	@Autowired
	private ICreditProveListService creditProveListService;
	
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
	public int insertMessageOpanoMaly(MessageOpanoMaly messageOpanoMaly)
			throws Exception {
		return messageOpanoMalyMapper.insert(messageOpanoMaly);
	}

	/**
	 * 
	 * 描述   列入异常实时推送消息
	 * @author  赵祥江
	 * @date 2017年7月4日 下午5:05:46 
	 * @param  
	 * @throws
	 */
	@Override
	public int  sendJoinOpanoMaly(List<String> priPIDList,SysUserDto sysUser) throws Exception {
		 try {
			if(priPIDList.size()>0){
				for(String priPID:priPIDList){
					PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (priPID.trim());
					if(pubEppassword!=null){
						String tel=pubEppassword.getTel();
						//校验手机号码是否绑定连连客户端
						if(this.checkTel(tel)){
							String content="您担任联络员的"+pubEppassword.getEntname()+"被列入经营异常名录";
							String json = "{\"title\" : \"列入经营异常名录提醒\", "
									+ "\"pusher\" : \"国家企业信用信息公示系统\", "
									+ "\"receiver\" : \""
									+ tel
									+ "\","
									+ "\"sourceUrl\" : \""
									+ url
									+ "/message/opanomalymessage/toMessageOpanoMalyView?msgReadTel="
									+ tel
									+ "&isMove=3&sendDate="
									+ DateUtil.getDate("yyyyMMdd")
									+ "\","
									+ "\"type\" : \"03\","
									+ "\"midType\" : \"03001\"," 
									+ "\"subType\" : \"03001007\","
									+ "\"content\" : \""
									+ content
									+ "\","
									+ "\"additionInfo\" : {"
									/*+ "\"remark\" : \"列入经营异常名录是企业的信用污点,请及时消除异常事由，并向工商部门申请移出经营异常名录。\","*/
									+ "\"记录类别\" : \"信用警示\"  " + "},"
									+ "\"pushChannels\" : \"1,2\"" + "}";
							  //发送消息
							  int i=sendPOSTRequestMsg(json,tel);
							  //失败
							  String state="0";
							  //成功
							  if(i==1){
								  state="1";
							  //部分成功
							  }else if(i==2){
								  state="2";
							  }
							  MessageOpanoMaly messageOpanoMaly=new MessageOpanoMaly();
							  messageOpanoMaly.setMsgType("1");
							  messageOpanoMaly.setIsMove("3");
							  messageOpanoMaly.setContent(json);
							  messageOpanoMaly.setSetTime(DateUtil.getSysDate());
							  messageOpanoMaly.setLiaisonManId(pubEppassword.getUid());
							  messageOpanoMaly.setLiaisonManTel(pubEppassword.getTel());
							  messageOpanoMaly.setLiaisonManName(pubEppassword.getLianame());
							  messageOpanoMaly.setSetUserUid(sysUser.getId());
							  messageOpanoMaly.setSetUserName(sysUser.getRealName());
							  if("2".equals(sysUser.getUserType())){
								  messageOpanoMaly.setSetDeptCode(sysUser.getSysDepart().getOrgCoding());
								  messageOpanoMaly.setSetDeptName(sysUser.getSysDepart().getOrgName());
							  }else{
								  messageOpanoMaly.setSetDeptCode(sysUser.getDepartMent().getDeptDID());
								  messageOpanoMaly.setSetDeptName(sysUser.getDepartMent().getDeptName());
							  }
							  messageOpanoMaly.setCreateTime(messageOpanoMaly.getSetTime());
							  messageOpanoMaly.setState(state);
						      insertMessageOpanoMaly(messageOpanoMaly);
						}
					}
				}
			 }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("列入异常实时推送消息失败", e);
		}
		return 0;
		
	}

	/**
	 * 
	 * 描述   移出异常推送消息
	 * @author  赵祥江
	 * @date 2017年7月4日 下午5:16:12 
	 * @param  
	 * @throws
	 */
	@Override
	public int sendIsMoveOpanoMaly(List<String>  priPIDList, String isMove,SysUserDto sysUser)
			throws Exception {
		try {
			if(priPIDList.size()>0){
				for(String priPID:priPIDList){
					PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (priPID.trim());
					if(pubEppassword!=null){
						String tel=pubEppassword.getTel();
						//校验手机号码是否绑定连连客户端
						if(this.checkTel(tel)){
							  String title="移出经营异常名录提醒";
							  String content="恭喜您担任联络员的"+pubEppassword.getEntname()+"已成功移出经营异常名录";
							  if("2".equals(isMove)){
								  title="更正(撤销)经营异常名录信息提醒";
								  content="恭喜您担任工商联络员的"+pubEppassword.getEntname()+"已更正（撤销）列入经营异常名录信息";
							  }
							String json = "{\"title\" : \""
									+ title
									+ "\", "
									+ "\"pusher\" : \"国家企业信用信息公示系统\", "
									+ "\"receiver\" : \""
									+ tel
									+ "\","
									+ "\"sourceUrl\" : \""
									+ url
									+ "/message/opanomalymessage/toMessageOpanoMalyView?msgReadTel="
									+ tel + "&isMove=" + isMove + "&sendDate="
									+ DateUtil.getDate("yyyyMMdd") + "\","
									+ "\"type\" : \"03\","
									+ "\"midType\" : \"03001\","
									+ "\"subType\" : \"03001008\","
									+ "\"content\" : \"" + content + "\","
									+ "\"additionInfo\" : {"
									/*+ "\"remark\" : \"请持续关注企业信用警示提醒消息。\","*/
									+ "\"记录类别\" : \"信用警示\"  " + "},"
									+ "\"pushChannels\" : \"1,2\"" + "}";
							  //发送消息
							  int i=sendPOSTRequestMsg(json,tel);
							  //失败
							  String state="0";
							  //成功
							  if(i==1){
								  state="1";
							  //部分成功
							  }else if(i==2){
								  state="2";
							  }
							  MessageOpanoMaly messageOpanoMaly=new MessageOpanoMaly();
							  messageOpanoMaly.setMsgType(isMove);
							  messageOpanoMaly.setIsMove(isMove);
							  messageOpanoMaly.setContent(json);
							  messageOpanoMaly.setSetTime(DateUtil.getSysDate());
							  messageOpanoMaly.setLiaisonManId(pubEppassword.getUid());
							  messageOpanoMaly.setLiaisonManTel(pubEppassword.getTel());
							  messageOpanoMaly.setLiaisonManName(pubEppassword.getLianame());
							  messageOpanoMaly.setSetUserUid(sysUser.getId());
							  messageOpanoMaly.setSetUserName(sysUser.getRealName());
							  if("2".equals(sysUser.getUserType())){
								  messageOpanoMaly.setSetDeptCode(sysUser.getSysDepart().getOrgCoding());
								  messageOpanoMaly.setSetDeptName(sysUser.getSysDepart().getOrgName());
							  }else{
								  messageOpanoMaly.setSetDeptCode(sysUser.getDepartMent().getDeptDID());
								  messageOpanoMaly.setSetDeptName(sysUser.getDepartMent().getDeptName());
							  }
							  messageOpanoMaly.setCreateTime(messageOpanoMaly.getSetTime());
							  messageOpanoMaly.setState(state);
						      insertMessageOpanoMaly(messageOpanoMaly);
						}
					}
				}
			 }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("移出异常实时推送消息失败", e);
		}
		return 0;
	}
	
	
	  /**
	   * 
	   * 描述   定时推送消息
	   * @author 赵祥江
	   * @date 2017年7月5日 下午5:43:00 
	   * @param 
	   * @return String
	   * @throws
	   */
	  @Override
	  public String  quartzJob() throws Exception{
	        // 阻塞任务，防止并发访问数据库
	        SleepUtil.threadSleep (); 
			if(csQuartzJobService.checkJobIsExecute(QuartzJobName.OPANOMALY_MSG_SEND_JOB.getJobName())){
				return "任务已执行";
			}
	        csQuartzJobService.insert(QuartzJobName.OPANOMALY_MSG_SEND_JOB.getJobName ());
		    long S= System.currentTimeMillis();
		    System.out.println(S);
	        Long totalCount = pubEppasswordService.queryPubEppasswordPsCount();
	        Long pageSize = 9999L;
	        Long pageCount=totalCount/pageSize;
	        if (totalCount%pageSize>0) {
	            pageCount++;
	        }
	       // ExecutorService fixedThreadPool = Executors.newFixedThreadPool (3);// 默认最多5条线程
	        for ( int i = 1 ; i <= pageCount ; i++ ) {
	            Long numStart = (i - 1) * pageSize;
	            List<PubEppasswordDto> unReportList = pubEppasswordService.queryPubEppasswordPsList(numStart,pageSize);
	            if (null != unReportList && unReportList.size () > 0) { 
	                for ( PubEppasswordDto pubEppasswordDto : unReportList ) { 
	                	try {
		                	String tel = pubEppasswordDto.getTel ();
		                	Long entCount=pubEppasswordDto.getEntCount();
		                	String entName = pubEppasswordDto.getEntname ();
		                	if(entCount!=null&&entCount>0){
		                		//如果没有绑定联连则不推送消息
			                	if(checkTel(tel)){
			                		    String content=""; 
				                    	if(entCount>2){
					                    	content="您担任联络员的"+entName+"等"+entCount+"家企业被列入经营异常名录";
					                    }else{
					                    	content="您担任联络员的"+entName+"被列入经营异常名录";
					                    }
								String json = "{\"title\" : \"列入经营异常名录提醒\", "
										+ "\"pusher\" : \"国家企业信用信息公示系统\", "
										+ "\"receiver\" : \""
										+ tel
										+ "\","
										+ "\"sourceUrl\" : \""
										+ url
										+ "/message/opanomalymessage/toMessageOpanoMalyView?msgReadTel="
										+ tel
										+ "&isMove=3&sendDate="
										+ DateUtil.getDate("yyyyMMdd")
										+ "\","
										+ "\"type\" : \"03\","
										+ "\"midType\" : \"03001\","
										+ "\"subType\" : \"03001007\","
										+ "\"content\" : \""
										+ content
										+ "\","
										+ "\"additionInfo\" : {"
										/*+ "\"remark\" : \"列入经营异常名录是企业的信用污点,请及时消除异常事由，并向工商部门申请移出经营异常名录。\","*/
										+ "\"记录类别\" : \"信用警示\"  "
										+ "}," + "\"pushChannels\" : \"1,2\""
										+ "}";
					                    /*fixedThreadPool.execute (new Runnable () { 
							            public void run(){*/
							            	//调用app接口发送信息
						                    int a=sendPOSTRequestMsg(json,tel); 
						                    //失败
										    String state="0";
										    //成功
											if(a==1){
											state="1";
											//部分成功
											}else if(a==2){
												  state="2";
											}
					                      MessageOpanoMaly messageOpanoMaly=new MessageOpanoMaly();
										  messageOpanoMaly.setMsgType("0");
										  messageOpanoMaly.setIsMove("3");
										  messageOpanoMaly.setContent(json);
										  messageOpanoMaly.setSetTime(DateUtil.getSysDate());
										  messageOpanoMaly.setLiaisonManId(pubEppasswordDto.getUid());
										  messageOpanoMaly.setLiaisonManTel(tel);
										  messageOpanoMaly.setLiaisonManName(pubEppasswordDto.getLianame()); 
										  messageOpanoMaly.setSetUserName("系统自动");
										  messageOpanoMaly.setCreateTime(messageOpanoMaly.getSetTime());
										  messageOpanoMaly.setState(state);
									      try {
											insertMessageOpanoMaly(messageOpanoMaly);
 									    } catch (Exception e) { 
											e.printStackTrace();
											logger.error("", e);
										}
							           // }
							       // }); 
			                	}
		                	}
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("定时推送消息失败", e);
							continue;
						}
	                }
	            } 
	        } 
	        long e= System.currentTimeMillis();
	        
	        System.out.println("共花费了"+(e-S));
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
	            logger.error("调用验证联连接口失败", e);
	        }
			return false;
	    }
	 
	 
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
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace ();
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
	 public int  sendPOSTRequestMsg(String newJson,String tel){
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
                    JSONObject josnObject =(JSONObject) JSONObject.parse(res); 
                    String code =josnObject.get("code").toString();
                    //成功
                    if("00".equals(code)){
                    	return 1;
                    }else if("01".equals(code)){//部分成功
                    	return 2;
                    }
	            }
	        } catch (Exception e) {
	            e.printStackTrace ();
	            logger.error("调用发送微信推送消息接口失败", e);
	        }
	        //失败
	        return 0;
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
	            } else {}
	        } catch (Exception e) {
	            e.printStackTrace ();
	        } finally {
	            if (conn != null) {
	                conn.disconnect ();
	            }
	        }
	        return null;
	    }
}