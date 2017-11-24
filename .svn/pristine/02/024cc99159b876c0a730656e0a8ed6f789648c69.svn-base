/**
 * Copyright@ 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 工具文件 <br/>
 * @author 胡义振
 * @date 2013-9-30
 * @version 1.0
 */
package com.icinfo.cs.common.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;

/** 
 * 描述: 证书工具类
 * @author ZhouYan
 * @date 2016年8月28日  
 */
public class CertUtil{

	/** 
	 * 描述: 把证书信息转换为 map 键-值 格式
	 * @auther ZhouYan
	 * @date 2016年8月28日 
	 * @param base64Cert
	 * @return 
	 */
	public static Map<String,String>  getCertSubjectMapContent(String base64Cert) {
		Map<String,String> mapCert = new HashMap<String,String>();
		try
		{
			//去掉证书开始 -----BEGIN CERTIFICATE----- 与 -----END CERTIFICATE-----
			if(base64Cert.indexOf("-----")>-1){
				String arrStr [] = base64Cert.split("-----");
				if(arrStr.length>2){
					base64Cert = arrStr[2];
				}
			}
			
		    CertificateFactory cf = CertificateFactory.getInstance("X.509");
		    InputStream certis = new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(base64Cert));
		    X509Certificate x509Cert = (X509Certificate) cf.generateCertificate(certis);

		    
		    //证书的有效日期
		    mapCert.put("certValidStartTime", DateUtil.dateToString(x509Cert.getNotBefore(),"yyyy-MM-dd HH:mm:ss"));
		    mapCert.put("certValidEndTime", DateUtil.dateToString(x509Cert.getNotAfter(),"yyyy-MM-dd HH:mm:ss")); 
		    
		    Principal subjectDN = x509Cert.getSubjectDN();
		    if(subjectDN!=null){
			    String [] arrSubjectDN = subjectDN.toString().replaceAll(" ","").split(",");
			    if(arrSubjectDN!=null){
				    for(String theme: arrSubjectDN){
				    	if(theme!=null){
						    String [] arrTheme = theme.split("=");
						    if(arrTheme.length>1){
						    	mapCert.put(arrTheme[0], arrTheme[1]);
						    }
						    else{
						    	mapCert.put(arrTheme[0], "");
						    }
				    	}
				    }
			    }
		    }		    
		}
		catch(Exception er){
			mapCert.put("err", er.toString());
		}
		return mapCert;
	}
	
}
