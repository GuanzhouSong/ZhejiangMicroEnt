/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.message.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinaoly.oss.SgsOSSClient;
import com.icinfo.cs.base.constant.QuartzJobName;
import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.base.service.impl.CsQuartzJobServiceImpl;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.SM4Utils;
import com.icinfo.cs.common.utils.SleepUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.dto.CsMessageDto;
import com.icinfo.cs.message.mapper.CsMessageMapper;
import com.icinfo.cs.message.model.CsMessage;
import com.icinfo.cs.message.model.CsMessageRel;
import com.icinfo.cs.message.service.ICsMessageRelService;
import com.icinfo.cs.message.service.ICsMessageService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_message 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
@Service
public class CsMessageServiceImpl extends MyBatisServiceSupport implements ICsMessageService {

    @Autowired
    private CsMessageMapper        csMessageMapper;
    @Autowired
    private SgsOSSClient           soc;
    @Autowired
    private ICsMessageRelService   csMessageRelService;
    @Autowired
    private IPubEppasswordService  pubEppasswordService;
    @Autowired
    private IPanoramaSearchService panoramaSearchService;
    @Autowired
    private ICsQuartzJobService    csQuartzJobService;

    // 消息内容默认保存路径
    private final String           MESSAGE_PATH = "message/txt/";

    private List<CsMessage>        pageList     = null;
    private Long                   total        = 0L;
    @Value("${webDomain}")
    private String                 url;
    @Value("${appDomain}")
    private String                 interfaceUrl;
    @Value("${llDomain}")
    private String                 llDomain;

    // private String interfaceUrl = "http://192.168.5.201:8082";

    /** 
     * 描述: inputStream转String
     * @author 张文男
     * @date 2017年5月19日 
     * @param is
     * @return
     * @throws IOException 
     */

    public static String inputStream2String(InputStream is) throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        int i = -1;
        while ((i = is.read ()) != -1) {
            baos.write (i);
        }
        return baos.toString ();
    }

    /** 
     * 描述: 保存或修改
     * @author 张文男
     * @date 2017年5月25日 
     * @param dto
     * @param request
     * @throws Exception 
     */
    public void saveOrUpdate(CsMessageDto dto,PageRequest request) throws Exception{
        String msgUuid = StringUtil.uuid ();
        String msgContent = StringEscapeUtils.unescapeHtml (dto.getMsgContent ());
        String priPIDs = dto.getPriPIDs ();
        String entNames = dto.getEntNames ();
        String[] priPIDsArr = priPIDs.split (",");
        String[] entNamesArr = entNames.split (",");
        Date nowDate = new Date ();
        InputStream msgContentInputStream = new ByteArrayInputStream (msgContent.getBytes ("UTF-8"));
        // 将内容存储至文件服务器中
        String txtPath = MESSAGE_PATH + msgUuid + ".txt";
        if (null != soc) {
            soc.putStream (txtPath, msgContentInputStream);
        }
        CsMessage csMessage = (CsMessage) BeanUtils.cloneBean (dto);
        csMessage.setMsgUid (msgUuid);
        csMessage.setMsgTxtPath (txtPath);
        csMessage.setCreateTime (nowDate);
        csMessage.setUpdateTime (nowDate);
        csMessageMapper.insert (csMessage);

        if (dto.getCheckAllEnt ()) {
            // 查询全部数据并保存速度可能过慢，所以开启子线程后台保存
            new Thread (new Runnable () {

                @Override
                public void run(){
                    try {
                        Page<PanoramaResultDto> data = panoramaSearchService.doGetYearsComSearchList (request);
                        for ( PanoramaResultDto panoramaResultDto : data ) {
                            String priPID = panoramaResultDto.getPriPID ();
                            String entName = panoramaResultDto.getEntName ();
                            saveCsMessageRel (msgUuid, priPID, entName);
                        }
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }
                }
            }).start ();

        }
        for ( int i = 0 ; i < priPIDsArr.length ; i++ ) {
            String priPID = priPIDsArr[i];
            String entName = entNamesArr[i];
            saveCsMessageRel (msgUuid, priPID, entName);
        }

    }

    private void saveCsMessageRel(String msgUuid,String priPID,String entName){
        PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid (priPID);
        if (null != pubEppassword) {
            CsMessageRel csMessageRel = new CsMessageRel ();
            csMessageRel.setLiaisonManId (pubEppassword.getUid ());
            csMessageRel.setLiaisonManName (pubEppassword.getLianame ());
            csMessageRel.setLiaisonManTel (pubEppassword.getTel ());
            csMessageRel.setMsgUid (msgUuid);
            csMessageRel.setPriPID (priPID);
            csMessageRel.setEntName (entName);
            csMessageRelService.insert (csMessageRel);
        }
    }

    /** 
     * 描述: 根据联络员手机号获取对应消息列表
     * @author 张文男
     * @date 2017年5月22日 
     * @param map
     * @return 
     * @throws InterruptedException 
     */

    public PageResponse<CsMessage> queryMessagePageListByLiaisonManTel(String liaisonManTel,Integer pageNum,Integer pageSize) throws InterruptedException{
        Map<String, Object> map = new HashMap<String, Object> ();
        int start = (pageNum - 1) * pageSize;
        map.put ("numStart", start);
        map.put ("pageSize", pageSize);
        map.put ("liaisonManTel", liaisonManTel);
        final CountDownLatch countDownLatch = new CountDownLatch (2);

        new Thread (new Runnable () {

            @Override
            public void run(){
                try {
                    total = csMessageMapper.queryMessagePageCountByLiaisonManTel (map);
                    countDownLatch.countDown ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (new Runnable () {

            @Override
            public void run(){
                try {
                    pageList = csMessageMapper.queryMessagePageListByLiaisonManTel (map);
                    countDownLatch.countDown ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }

            }
        }).start ();

        countDownLatch.await ();
        PageRequest request = new PageRequest ();
        request.setPageNum (pageNum);
        request.setStart (start);
        return new PageResponse<CsMessage> (pageList,total,request);
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

    /** 
     * 描述: 发送ClientPOST请求
     * @author 张文男
     * @date 2017年6月12日 
     * @param path
     * @param param
     * @param encoding
     * @return
     * @throws IOException 
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
     * 描述: 根据msgUid获取消息详情
     * @author 张文男
     * @date 2017年5月24日 
     * @param msgUid
     * @return 
     * @throws IOException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws NoSuchMethodException 
     * @throws InstantiationException 
     */

    public CsMessageDto queryCsMessageDtoByMsgUid(String msgUid) throws IOException,IllegalAccessException,InvocationTargetException,InstantiationException,NoSuchMethodException{
        CsMessage csMessage = queryCsMessageByMsgUid (msgUid);
        if (null != csMessage) {
            CsMessageDto dto = new CsMessageDto ();
            dto.setMsgTitle (csMessage.getMsgTitle ());
            dto.setSendTime (csMessage.getSendTime ());
            dto.setMsgUid (csMessage.getMsgUid ());
            if (null != soc) {
                InputStream in = soc.getStream (csMessage.getMsgTxtPath ());
                String msgContent = inputStream2String (in);
                dto.setMsgContent (msgContent);
            }
            return dto;
        }
        return null;
    }

    /** 
     * 描述: 根据msgUid获取消息详情
     * @author 张文男
     * @date 2017年5月26日 
     * @param msgUid
     * @return 
     */

    private CsMessage queryCsMessageByMsgUid(String msgUid){
        Example e = new Example (CsMessage.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("msgUid", msgUid);
        List<CsMessage> list = csMessageMapper.selectByExample (e);
        if (null != list && list.size () > 0) {
            CsMessage csMessage = list.get (0);
            return csMessage;
        }
        return null;
    }

    /** 
     * 描述: 根据消息id更新数据
     * @author 张文男
     * @date 2017年5月26日 
     * @param bean 
     * @throws UnsupportedEncodingException 
     */

    public void updateMessageByMsgUid(CsMessage bean) throws UnsupportedEncodingException{

        CsMessage csMessage = queryCsMessageByMsgUid (bean.getMsgUid ());
        String msgPcReadTel = csMessage.getMsgPcReadTel ();
        if (StringUtil.isBlank (msgPcReadTel)) {// 未阅读过则更新阅读人
            String msgPcReadName = bean.getMsgPcReadName ();
            if (StringUtil.isNotBlank (msgPcReadName)) {
                msgPcReadName = URLDecoder.decode (URLDecoder.decode (msgPcReadName, "UTF-8"), "UTF-8");
                bean.setMsgPcReadName (msgPcReadName);
            }
            bean.setMsgPcReadTime (new Date ());
            csMessageMapper.updateMessageByMsgUid (bean);
        }
    }

    /** 
     * 描述: http调用手机端接口
     * @author 张文男
     * @date 2017年6月12日 
     * @param newJson
     * @param tel 
     */

    public void sendPOSTRequest(String newJson,String tel){
        try {
            SM4Utils sm4Utils = new SM4Utils ();
            sm4Utils.setSecretKey ("JeF8U9wHFOMfs2Xx");
            sm4Utils.setHexString (false);

            if (null != tel) {
                String json = "{\"phone\":\"" + tel + "\"}";
                String returnStr = sendHttpClientPOSTRequest (llDomain + "/doGetUserInfo.do", json, "UTF-8");

                String retunJson = sm4Utils.decryptData_ECB (returnStr);

                JSONObject jSONObject = JSON.parseObject (retunJson);
                String retcode = jSONObject.get ("retcode").toString ();
                // 如果是连联用户则进行消息推送
                if ("0".equals (retcode)) {
                    String jsonEncodeStr = sm4Utils.encryptData_ECB (newJson);
                    Map<String, String> params = new HashMap<String, String> ();
                    params.put ("message", jsonEncodeStr);
                    params.put ("cust_id", "cs");
                    sendPOSTRequest (interfaceUrl + "/api/message/single_push", params, "UTF-8");
                }

            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    private void sendPOSTRequest(ExecutorService fixedThreadPool,String newJson,String tel){
        fixedThreadPool.execute (new Runnable () {

            public void run(){
                sendPOSTRequest (newJson, tel);
            }
        });
    }
    
    /** 
     * 描述: 定时发送消息
     * @author 张文男
     * @date 2017年6月8日  
     */

    public void quartzJob() throws Exception{
        // 阻塞任务，防止并发访问数据库
        SleepUtil.threadSleep ();
        if (csQuartzJobService.checkJobIsExecute (QuartzJobName.YR_MSG_SEND_JOB.getJobName ())) { return; }
        csQuartzJobService.insert (QuartzJobName.YR_MSG_SEND_JOB.getJobName ());
        
        String year = DateUtil.getCurrentYear ();
        Integer lastYear = Integer.parseInt (year) - 1;
        
        Long totalCount = pubEppasswordService.queryYearReportCount (lastYear, "0");
        Long pageSize = 9999L;
        Long pageCount=totalCount/pageSize;
        if (totalCount%pageSize>0) {
            pageCount++;
        }
        
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool (3);// 默认最多5条线程
        for ( int i = 1 ; i <= pageCount ; i++ ) {
            Long numStart = (i - 1) * pageSize;
            List<PubEppasswordDto> unReportList = pubEppasswordService.queryYearReportList (lastYear, "0",numStart,pageSize);
            
			String json = "{\"title\" : \"企业工商年报提醒\", "
					+ "\"pusher\" : \"国家企业信用信息公示系统\", "
					+ "\"receiver\" : \"${tel}\","
					+ "\"sourceUrl\" : \"${url}\","
					+ "\"type\" : \"03\","
					+ "\"midType\" : \"03001\","
					+ "\"subType\" : \"03001003\","
					+ "\"content\" : \"${content}\","
					+ "\"additionInfo\" : {"
					+ "\"备注\" : \"ⓘ${lastYear}年度企业年报将于${nowyear}年6月30日截止，逾期将被列入经营异常名录并公示。\","
					/*+ "\"发送日期\" : \""+DateUtil.getCurrentDate()+"\","*/
					+ "\"年报状态\" : \"${reportType}\"  " + "},"
					+ "\"pushChannels\" : \"1,2\"   " + "}";
            if (null != unReportList && unReportList.size () > 0) {
                
                for ( PubEppasswordDto pubEppasswordDto : unReportList ) {
                    String tel = pubEppasswordDto.getTel ();
                    String entName = pubEppasswordDto.getEntname ();
                    Long entCount = pubEppasswordDto.getEntCount ();

                    String newJson = json.replace ("${tel}", tel).replace ("${url}", url + "/reg/message/toMessageUnreportView?year=" + lastYear + "&isreported=0&msgSource=wx&msgReadTel=" + tel + "&sendDate=" + DateUtil.getDate ("yyyyMMdd")).replace ("${content}", "您担任工商联络员的" + entName + "等" + entCount + "家企业未完成" + lastYear + "年度企业年报。").replace ("${lastYear}", lastYear.toString ()).replace ("${nowyear}", year).replace ("${reportType}", "未年报");
                    //sendPOSTRequest (newJson, tel);
                    sendPOSTRequest (fixedThreadPool,newJson, tel);

                }
            }
           
        }
        
   
    }

}