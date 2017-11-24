/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.relation.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.relation.service.IRelationService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_code_expert_type 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class RelationServiceImpl  extends MyBatisServiceSupport implements IRelationService {
	@Value("${relation.path.url}")
	private String RELATION_PATH_URL;
	@Autowired
	private  IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 
	 * 描述   TODO
	 * @author  赵祥江
	 * @date 2017年11月9日 下午5:11:36 
	 * @param  entNameStrs 企业名称 多个用逗号隔开
	 * @throws
	 */
	@Override
	public String getIRelationInfo(String entNameStrs) throws Exception {
		String priPIDStr="";
		Map<String, String> params = new HashMap<String, String>();
		if(StringUtil.isNotBlank(entNameStrs)){
			String[] entNameArr=entNameStrs.split(",");
			if(entNameArr.length>0){
				for(int i=0;i<entNameArr.length;i++){
					//校验身份证号码,不是身份证号码则默认企业名称
					if(!"".equals(CardUtil.IDCardValidate(entNameArr[i].toLowerCase()))){ 
						MidBaseInfo midBaseInfo=midBaseInfoService.selectEntByEntName(entNameArr[i]);
						if(midBaseInfo!=null){
							priPIDStr+=midBaseInfo.getPriPID()+",";
						} 
					}else{
						priPIDStr+=entNameArr[i]+",";
					}
				}
			}
			if(priPIDStr.length()>0){
				priPIDStr=priPIDStr.substring(0, priPIDStr.length()-1);
				params.put("start", priPIDStr); 
				priPIDStr=	sendPOSTRequest(RELATION_PATH_URL, params, "UTF-8");
			} 
		}
		
		
		return priPIDStr;
	}
	  
	
	
	public  String sendPOSTRequest(String path,Map<String, String> params,String encoding){
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
            conn.setConnectTimeout (5000);// 设置超时
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
     * 读取流
     * @param inStream
     * @return 字节数组
     * @throws Exception
     */
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
}